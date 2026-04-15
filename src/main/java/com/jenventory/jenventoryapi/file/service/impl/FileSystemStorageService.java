package com.jenventory.jenventoryapi.file.service.impl;

import com.jenventory.jenventoryapi.common.exception.StorageException;
import com.jenventory.jenventoryapi.file.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@Slf4j
public class FileSystemStorageService implements StorageService {

    private final Path storageLocation = Path.of("storage");
    private final List<String> allowedExtensions = List.of("jpg", "jpeg", "png", "pdf");

    @Override
    public String store(MultipartFile file) {
        validateFile(file);

        String originalFileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String fileExtension = StringUtils.getFilenameExtension(originalFileName);
        String storedFileName = UUID.randomUUID() + "." + fileExtension;

        Path destinationPath = storageLocation
                .resolve(Objects.requireNonNull(storedFileName))
                .normalize()
                .toAbsolutePath();

        if (!destinationPath.getParent().equals(storageLocation.toAbsolutePath())) {
            throw new StorageException("Cannot store file outside of the current directory.");
        }

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, destinationPath, StandardCopyOption.REPLACE_EXISTING);

            log.info("Stored file: {} as {}", originalFileName, storedFileName);

            return storedFileName;

        } catch (IOException e) {
            throw new StorageException("Failed to store file.", e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try (Stream<Path> paths = Files.walk(storageLocation, 1)) {
            return paths.filter(path -> !path.equals(storageLocation))
                    .map(Path::getFileName);
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files.", e);
        }
    }

    @Override
    public Path load(String filename) {
        return Path.of("storage").resolve(filename);
    }

    @Override
    public void deleteAll() {

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


}
