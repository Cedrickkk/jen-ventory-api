package com.jenventory.jenventoryapi.file.service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    String store(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String filename);

    void deleteAll();
}
