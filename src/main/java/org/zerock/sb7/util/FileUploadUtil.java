package org.zerock.sb7.util;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Log4j2
public class FileUploadUtil {

    @Value("${org.zerock.upload}")
    private String uploadDir;

    @PostConstruct
    public void ready(){

        log.info("---------post construct---------");
        log.info("uploadDir: " + uploadDir);

        File uploadDirFile = new File(uploadDir);

        log.info("uploadDirFile: " + uploadDirFile.getAbsolutePath());

        if(!uploadDirFile.exists()){
            uploadDirFile.mkdirs();
        }

    }

}
