package com.jenventory.jenventoryapi.file.controller;

import com.jenventory.jenventoryapi.file.enums.FileType;
import com.jenventory.jenventoryapi.file.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/storage")
@RequiredArgsConstructor
public class FileController {

    private final StorageService storageService;

    @GetMapping("/images/{filename:.+}")
    public ResponseEntity<Resource> serveImage(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename, FileType.IMAGE);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(determineContentType(filename)))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @GetMapping("/documents/{filename:.+}")
    public ResponseEntity<Resource> serveDocument(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename, FileType.DOCUMENT);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }


    @GetMapping("/documents/{filename:.+}/download")
    public ResponseEntity<Resource> downloadDocument(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename, FileType.DOCUMENT);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    private String determineContentType(String filename) {
        String lower = filename.toLowerCase();
        if (lower.endsWith(".pdf")) return "application/pdf";
        if (lower.endsWith(".png")) return "image/png";
        return "image/jpeg";
    }
}
