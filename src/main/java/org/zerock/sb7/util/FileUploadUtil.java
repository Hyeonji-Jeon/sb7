package org.zerock.sb7.util;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Log4j2
@RequiredArgsConstructor
public class FileUploadUtil {

    @Value("${org.zerock.upload}")
    private String uploadDir;

    private final ResourceLoader resourceLoader;

    @PostConstruct
    public void ready() throws Exception {

        log.info("---------post construct---------");
        log.info("uploadDir: " + uploadDir);

        Resource resource = resourceLoader.getResource(uploadDir);
        File uploadDirFile = resource.getFile();

        log.info("uploadDirFile: " + uploadDirFile.getAbsolutePath());

        if(!uploadDirFile.exists()){
            uploadDirFile.mkdirs();
        }

    }

}
