package com.footballobzor.demo.controllers;

import com.footballobzor.demo.api.dto.FileDto;
import com.footballobzor.demo.persistance.entity.FileEntity;
import com.footballobzor.demo.service.impl.AmazonClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/storage/")
@RequiredArgsConstructor
public class UploadFilesController {

    private final AmazonClient amazonClient;

    @PostMapping("/uploadFile")
    public FileDto uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonClient.uploadNewFile(file);
    }
}
