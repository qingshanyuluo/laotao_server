package xyz.lennon.laotao_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.lennon.laotao_server.result.RespResult;
import xyz.lennon.laotao_server.result.RespUtil;
import xyz.lennon.laotao_server.services.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    RespResult<Boolean> login(@RequestParam String username, @RequestParam String password) {
        return RespUtil.makeOKRsp(userService.ismatching(username, password));
    }

    @PostMapping("/register")
    RespResult<Boolean> register(@RequestParam String username, @RequestParam String password, @RequestParam String displayName) {
        return RespUtil.makeOKRsp(userService.insert(username, password, displayName));
    }

}
