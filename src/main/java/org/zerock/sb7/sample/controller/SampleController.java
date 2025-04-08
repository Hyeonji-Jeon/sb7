package org.zerock.sb7.sample.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {

    @GetMapping("ex1")
    public void ex1(){
        log.info("ex1");
    }

    @GetMapping("ex2")
    public void ex2(){
        log.info("ex2");
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("ex3")
    public void ex3(){
        log.info("ex3");
    }

}