package xyz.lennon.laotao_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.lennon.laotao_server.result.RespResult;
import xyz.lennon.laotao_server.result.RespUtil;
import xyz.lennon.laotao_server.services.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    RespResult<Map<String, Object>> login(@RequestParam String email, @RequestParam String password) {
        Map<String, Object> res = new HashMap<>();
        boolean ismatch = userService.ismatching(email, password);
        if (ismatch) {
            res.put("isMatch", true);
            res.put("userId", userService.getUserId(email));
        } else {
            res.put("isMatch", false);
        }
        return RespUtil.makeOKRsp(res);
    }

    @PostMapping("/register")
    RespResult<Map<String, Object>> register(@RequestParam String email, @RequestParam String password, @RequestParam String displayName) {
        Map<String, Object> res = new HashMap<>();
        boolean isSuccess = userService.insert(email, password, displayName);
        if (isSuccess) {
            res.put("isSuccess", true);
            res.put("userId", userService.getUserId(email));
        } else {
            res.put("isSuccess", false);
        }
        return RespUtil.makeOKRsp(res);
    }

}
