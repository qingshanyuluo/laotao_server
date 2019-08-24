package xyz.lennon.laotao_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.lennon.laotao_server.entity.Response;
import xyz.lennon.laotao_server.services.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    Response login(@RequestParam String username, @RequestParam String password) {
        Map<String, String> res = new HashMap<>();
        res.put("login", userService.ismatching(username, password) + "");
        return new Response(true,res);
    }

    @PostMapping("/register")
    Response register(@RequestParam String username, @RequestParam String password, @RequestParam String displayName) {
        Map<String, String> res = new HashMap<>();
        res.put("register", userService.insert(username, password, displayName)+"");
        return new Response(true,res);
    }

}
