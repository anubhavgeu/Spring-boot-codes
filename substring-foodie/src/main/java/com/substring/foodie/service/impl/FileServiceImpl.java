package com.substring.foodie.service.impl;

import com.substring.foodie.dto.FileData;
import com.substring.foodie.exception.InvalidFilePathException;
import com.substring.foodie.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements FileService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public FileData uploadFile(MultipartFile file, String path) throws IOException {
        if (path.isBlank()) {
            throw new InvalidFilePathException("Invalid upload path");
        }
        Path folderPath = Paths.get(path.substring(0,path.lastIndexOf("/")+1));
        logger.info(folderPath.toString());
        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }
        String contentType = file.getContentType();

        String fileName = path.substring(path.lastIndexOf("/")+1);
        Path filePath = Paths.get(path);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return new FileData(fileName, path);
    }
}
