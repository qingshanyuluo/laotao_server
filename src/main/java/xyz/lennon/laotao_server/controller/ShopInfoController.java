package xyz.lennon.laotao_server.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import xyz.lennon.laotao_server.dao.CommentDao;
import xyz.lennon.laotao_server.dao.ShopDao;
import xyz.lennon.laotao_server.entity.Comment;
import xyz.lennon.laotao_server.entity.Shop;
import xyz.lennon.laotao_server.result.RespResult;
import xyz.lennon.laotao_server.result.RespUtil;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ShopInfoController {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private ShopDao shopDao;

    @GetMapping("/homeShop")
    public RespResult<List<Shop>> homeShop() {
        return RespUtil.makeOKRsp(shopDao.findAll());
    }

    @GetMapping("/shop/{shopID}/info")
    public RespResult<Optional<Shop>> getShopInfo(@PathVariable(value = "shopID") Long shopId) {
        return RespUtil.makeOKRsp(shopDao.findById(shopId));
    }

    @GetMapping("/shop/{shopId}/comments")
    public RespResult<Page<Comment>> getAllCommentsByShopId(@PathVariable(value = "shopId") Long shopId,
                                                            Pageable pageable) {
        return RespUtil.makeOKRsp(commentDao.findByShopId(shopId, pageable));
    }

    @PostMapping("/shop/{shopId}/comments")
    public RespResult<Comment> createComment(@PathVariable (value = "shopId") Long shopId,
                                             @Valid @RequestBody Comment comment) {
        Comment res = shopDao.findById(shopId).map(shop -> {
           comment.setShop(shop);
           return commentDao.save(comment);
        }).orElseThrow(RuntimeException::new);
        return RespUtil.makeOKRsp(res);
    }
}
