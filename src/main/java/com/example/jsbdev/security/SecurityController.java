package com.example.jsbdev.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/open")
    public String open() {
        return "OPEN";
    }

    @GetMapping("/closed")
    public String close() {
        return "CLOSED";
    }

//    @GetMapping("/special")
//    public String special() {
//        return "SPECIAL";
//    }
//
//    @GetMapping("/basic")
//    public String basic() {
//        return "BASIC";
//    }

    @PreAuthorize("hasRole('superuser')")
    @GetMapping("/special")
    public String special() {
        return "SPECIAL";
    }

    @PreAuthorize("hasRole('superuser') or hasRole('basicuser')")
    @GetMapping("/basic")
    public String basic() {
        return "BASIC";
    }

}
