package com.jenventory.jenventoryapi.file.service.impl;

import com.jenventory.jenventoryapi.common.exception.ResourceNotFoundException;
import com.jenventory.jenventoryapi.common.exception.StorageException;
import com.jenventory.jenventoryapi.file.enums.FileType;
import com.jenventory.jenventoryapi.file.service.StorageService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@Slf4j
public class FileSystemStorageServiceImpl implements StorageService {

    private final Path storageLocation = Path.of("storage");
    private final Path imageLocation = storageLocation.resolve(Path.of("images"));
    private final Path documentLocation = storageLocation.resolve(Path.of("documents"));
    private final List<String> allowedExtensions = List.of("jpg", "jpeg", "png", "pdf");

    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(imageLocation);
            Files.createDirectories(documentLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage directory.", e);
        }
    }

    @Override
    public String save(MultipartFile file, FileType type) {
        validateFile(file);

        String originalFileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String fileExtension = StringUtils.getFilenameExtension(originalFileName);
        String storedFilename = UUID.randomUUID() + "." + fileExtension;

        Path directory = resolveDirectory(type);
        Path destination = directory.resolve(storedFilename).normalize().toAbsolutePath();

        if (!destination.startsWith(directory.toAbsolutePath())) {
            throw new StorageException("Cannot store file outside its directory");
        }

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
            log.info("Stored file: {} as {}", originalFileName, storedFilename);
            return storedFilename;
        } catch (IOException e) {
            throw new StorageException("Failed to store file.", e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try (Stream<Path> paths = Files.walk(storageLocation, 1)) {
            return paths.filter(path -> !path.equals(storageLocation))
                    .map(storageLocation::relativize);
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files.", e);
        }
    }

    @Override
    public Path load(String filename) {
        return storageLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename, FileType type) {
        try {
            Path directory = resolveDirectory(type);
            Path filePath = directory.resolve(filename).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                throw new ResourceNotFoundException("File not found: " + filename);
            }

        } catch (MalformedURLException ex) {
            throw new ResourceNotFoundException("File not found: " + filename, ex);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(storageLocation.toFile());
    }

    @Override
    public void delete(String filename) {
        try {
            Path filePath = storageLocation.resolve(filename).normalize();
            Files.deleteIfExists(filePath);
            log.info("Deleted file: {}", filename);
        } catch (IOException ex) {
            throw new StorageException("Could not delete file: " + filename, ex);
        }
    }

    private void validateFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new StorageException("Failed to store empty file.");
        }

        String originalFilename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        String extension = StringUtils.getFilenameExtension(originalFilename);

        if (!allowedExtensions.contains(extension)) {
            throw new StorageException("File type not allowed. Allowed types: " + String.join(", ", allowedExtensions));
        }

        if (file.getSize() > 5 * 1024 * 1024) { // TODO: make this configurable
            throw new StorageException("File size exceeds the maximum allowed size of 5MB.");
        }

        validateContentType(file, extension);
    }

    private void validateContentType(MultipartFile file, String extension) {
        String contentType = file.getContentType();

        if (contentType == null) {
            throw new StorageException("File content type is missing.");
        }

        boolean valid = switch (extension) {
            case "jpg", "jpeg" -> contentType.equals("image/jpeg");
            case "png" -> contentType.equals("image/png");
            case "pdf" -> contentType.equals("application/pdf");
            default -> true;
        };

        if (!valid) {
            throw new StorageException("File content type does not match the file extension.");
        }
    }

    private Path resolveDirectory(FileType type) {
        return switch (type) {
            case IMAGE -> imageLocation;
            case DOCUMENT -> documentLocation;
        };
    }

}
