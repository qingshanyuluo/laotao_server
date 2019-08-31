package xyz.lennon.laotao_server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonInfo {

    @RequestMapping("/hello")
    public String hello() {
        return "helddasdaslo";
    }
}
