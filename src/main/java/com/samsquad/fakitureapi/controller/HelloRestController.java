package com.samsquad.fakitureapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloRestController {
    @GetMapping("user")
    public String helloUser() {
        return "Hello User";
    }
    @GetMapping("andy")
    public String helloAdmin() {
        return "Hello Andy";
    }
    @GetMapping("monica")
    public String helloMonica() {
        return "Hello Monica";
    }
}
