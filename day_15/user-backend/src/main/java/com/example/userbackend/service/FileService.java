package com.example.userbackend.service;

import com.example.userbackend.exception.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    private Path rootPath = Paths.get("uploads");

    public FileService() {
        createFolder(rootPath.toString());
    }

    // /Users/buihien/Documents/techmaster-training/class/java-12a/day_15/uploads/1
    private void createFolder(String path) {
        File file = new File(path);
        if(!file.exists()) {
            file.mkdirs();
        }
    }

    public String uploadFile(int id, MultipartFile file) {
        // Tạo folder với userId
        Path userPath = rootPath.resolve(String.valueOf(id));
        createFolder(userPath.toString());

        // Validate file
        validateFile(file);

        // Upload vào trong folder
        String fileId = String.valueOf(Instant.now().getEpochSecond());
        Path filePath = userPath.resolve(String.valueOf(fileId));

        File targetFile = filePath.toFile();
        try (OutputStream os = new FileOutputStream(targetFile)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Lỗi trong quá trình upload file");
        }

        return "/api/v1/users/" + id + "/files/" + fileId;
    }

    private void validateFile( MultipartFile file) {
        // Kiểm tra tên file
        String fileName = file.getOriginalFilename();
        if(fileName == null || fileName.isEmpty()) {
            throw new BadRequestException("file không không được để trống");
        }

        // image.png -> png
        // avatar.jpg -> jpg
        // Kiểm tra đuôi file (jpg, png, jpeg)
        String fileExtension = getFileExtensiton(fileName);
        if(!checkFileExtension(fileExtension)) {
            throw new BadRequestException("file không đúng định dạng");
        }

        // Kiểm tra dung lượng file (<= 2MB)
        double fileSize =  (double) (file.getSize() / 1_048_576);
        if( fileSize > 2) {
            throw new BadRequestException("file không được vượt quá 2MB");
        }
    }

    private String getFileExtensiton(String fileName) {
        int lastIndexOf = fileName.lastIndexOf(".");
        return fileName.substring(lastIndexOf + 1);
    }

    private boolean checkFileExtension(String fileExtension) {
        List<String> extensions = new ArrayList<>(List.of("png", "jpg", "jpeg"));
        return extensions.contains(fileExtension);
    }
}
