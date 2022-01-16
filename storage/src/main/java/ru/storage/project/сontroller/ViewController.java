package ru.storage.project.сontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/start")
public class ViewController {

    @GetMapping
    String hello() {
        return "start";
    }
}
