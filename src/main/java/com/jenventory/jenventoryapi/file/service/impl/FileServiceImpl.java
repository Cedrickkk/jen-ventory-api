package com.jenventory.jenventoryapi.file.service.impl;

import com.jenventory.jenventoryapi.common.exception.ResourceNotFoundException;
import com.jenventory.jenventoryapi.file.entity.File;
import com.jenventory.jenventoryapi.file.enums.FileType;
import com.jenventory.jenventoryapi.file.repository.FileRepository;
import com.jenventory.jenventoryapi.file.service.FileService;
import com.jenventory.jenventoryapi.file.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    private final StorageService storageService;

    @Override
    @Transactional
    public File create(MultipartFile file, FileType type) {
        String storedFilename = storageService.save(file, type);
        
        String originalFilename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        File _file = File.builder()
                .originalFilename(originalFilename)
                .storedFilename(storedFilename)
                .contentType(file.getContentType())
                .fileSize(file.getSize())
                .fileType(type)
                .build();

        return fileRepository.save(_file);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        File file = getMetadata(id);
        storageService.delete(file.getStoredFilename());
        fileRepository.delete(file);
    }

    @Override
    @Transactional(readOnly = true)
    public File getMetadata(UUID id) {
        return fileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("File not found: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public Resource load(UUID id) {
        File entity = fileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("File not found: " + id));

        return storageService.loadAsResource(entity.getStoredFilename(), entity.getFileType());
    }
}
