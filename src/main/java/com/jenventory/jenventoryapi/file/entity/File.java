package com.jenventory.jenventoryapi.file.entity;

import com.jenventory.jenventoryapi.file.enums.FileType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "original_filename", nullable = false)
    private String originalFilename;

    @Column(name = "stored_filename", nullable = false, unique = true)
    private String storedFilename;

    private String contentType;

    private Long fileSize;

    @Enumerated(EnumType.STRING)
    @Column(name = "file_type")
    private FileType fileType;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}