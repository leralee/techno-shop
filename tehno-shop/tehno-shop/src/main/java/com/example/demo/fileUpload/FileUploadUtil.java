package com.example.demo.fileUpload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadUtil.class);

    public static void saveFile(String uploadDir, String fileName,
                                MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        try (InputStream inputStream = multipartFile.getInputStream()){
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new IOException("Не удалось сохранить файл: " + fileName, ex);
        }
    }

    public static void cleanDir(String dirPath) throws IOException {
        Path uploadPath = Paths.get(dirPath);

        try {
            Files.list(uploadPath).forEach(file -> {
                if (!Files.isDirectory(file)) {
                    try {
                        System.out.println(file);
                        Files.delete(file);
                    } catch (IOException ex) {
                        System.out.println("Не удалось удалить файл: " + file);
                    }

                }
            });
            Files.delete(uploadPath);
        } catch (IOException ex) {
            System.out.println("Не удалось найти директорию: " + dirPath);
        }
    }

//    public static void main(String[] args) throws IOException {
//        cleanDir("product-photos/28");
////        cleanDir("product-photos/28/extras");
//    }
}
