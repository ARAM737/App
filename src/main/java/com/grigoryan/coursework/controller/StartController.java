package com.grigoryan.coursework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    @GetMapping(value = "/")
    public String start() {
        return "index";
    }

    @GetMapping(value = "/intarfaces")
    public String intarfaces() {
        return "intarface";
    }

    @GetMapping(value = "/writingCodes")
    public String writingCodes() {
        return "writingcode";
    }

    @GetMapping(value = "/checkResults")
    public String checkResults() {
        return "checkresult";
    }
}
