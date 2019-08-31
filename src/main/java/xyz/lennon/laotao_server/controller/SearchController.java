package xyz.lennon.laotao_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lennon.laotao_server.dao.ShopDao;
import xyz.lennon.laotao_server.result.RespResult;
import xyz.lennon.laotao_server.result.RespUtil;

@RestController
public class SearchController {

    @Autowired
    ShopDao shopDao;
    @GetMapping("/search")
    public RespResult search(@Param("kw")String kw) {
        return RespUtil.makeOKRsp(
                shopDao.findAllByNameLike("%"+kw+"%")
        );
    }
}
