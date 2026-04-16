package com.jenventory.jenventoryapi.file.service;

import com.jenventory.jenventoryapi.file.entity.File;
import com.jenventory.jenventoryapi.file.enums.FileType;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface FileService {
    File create(MultipartFile file, FileType type);

    void delete(UUID id);

    File getMetadata(UUID id);

    Resource load(UUID fileId);
}
