package xyz.lennon.laotao_server.controller;

import org.springframework.web.bind.annotation.RestController;
import xyz.lennon.laotao_server.result.RespResult;
import xyz.lennon.laotao_server.result.RespUtil;

@RestController
public class ContentController {

    public RespResult homePage() {
        return RespUtil.makeOKRsp();
    }

    public RespResult Square() {
        return RespUtil.makeOKRsp();
    }
}

