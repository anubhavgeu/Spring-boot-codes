package com.substring.foodie.substring_foodie.service.impl;

import com.substring.foodie.substring_foodie.dto.FileData;
import com.substring.foodie.substring_foodie.exception.InvalidFilePathException;
import com.substring.foodie.substring_foodie.service.FileService;
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
public class FileUploadServiceImpl implements FileService {
    private Logger logger = LoggerFactory.getLogger(FileUploadServiceImpl.class);
    @Override
    public FileData uploadFile(MultipartFile file, String path) throws IOException {
        if (path.isBlank()) {
            throw new InvalidFilePathException("Invalid upload path!!!");
        }

        Path folderPath = Paths.get(path.substring(0,path.lastIndexOf('/')+1));
        logger.info(folderPath.toString());
        // if folder not exists, then it will create folder on that path
        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }

        Path filePath = Paths.get(path);
        Files.copy(file.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);
        String fileName = path.substring(path.lastIndexOf("/")+1);
        FileData fileData = new FileData(fileName, path);
        return fileData;
    }
}
