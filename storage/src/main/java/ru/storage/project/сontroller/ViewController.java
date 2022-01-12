package ru.storage.project.сontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/hello")
    String hello() {
        return "start.html";
    }
}
