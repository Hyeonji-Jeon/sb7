package org.zerock.sb7.util;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
@RequiredArgsConstructor
public class FileUploadUtil {

    @Value("${org.zerock.upload}")
    private String uploadDir;


    @PostConstruct
    public void ready() throws Exception {

        log.info("---------post construct---------");
        log.info("uploadDir: " + uploadDir);

        File uploadDirFile = new File(uploadDir);

        log.info("uploadDirFile: " + uploadDirFile.getAbsolutePath());

        if(!uploadDirFile.exists()){
            uploadDirFile.mkdirs();
        }
    }

    public List<String> uploadFiles(List<MultipartFile> files) throws Exception {

        List<String> uploadedFileNames = new ArrayList<>();

        return uploadedFileNames;

    }

}
