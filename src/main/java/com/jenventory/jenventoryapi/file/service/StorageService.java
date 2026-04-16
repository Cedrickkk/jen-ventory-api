package com.jenventory.jenventoryapi.file.service;

import com.jenventory.jenventoryapi.file.enums.FileType;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    String save(MultipartFile file, FileType type);

    Stream<Path> loadAll();

    Path load(String filename);

    void deleteAll();

    void delete(String filename);

    Resource loadAsResource(String filename, FileType type);
}
