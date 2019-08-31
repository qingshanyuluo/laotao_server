package xyz.lennon.laotao_server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import xyz.lennon.laotao_server.dao.CommentDao;
import xyz.lennon.laotao_server.dao.ShopDao;
import xyz.lennon.laotao_server.entity.Comment;
import xyz.lennon.laotao_server.entity.Shop;
import xyz.lennon.laotao_server.result.RespResult;
import xyz.lennon.laotao_server.result.RespUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-15 14:04
 */
@RestController
public class UploadController {

    @Autowired
    ShopDao shopDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @PostMapping("/uploadShop/{userId}")
    public RespResult<Boolean> upload(HttpServletRequest request,
                                      @Param("name")String name, @Param("cost")Integer cost,
                                      @Param("location")String location, @Param("commit")String commit,
                                      @Param("type")String type, @PathVariable("userId")Long userId) {
        Shop shop = new Shop(name, location, cost, 4, type, 0, Math.toIntExact(userId), commit);
        shop = shopDao.save(shop);
        long shopId = shop.getId();
        LOGGER.info("shopId = "+ shopId);//        File shopPath = new File(ResourceUtils.getURL("classpath:static").getPath()+"/"+shopId+"/");
        File shopPath = new File("/home/l/laotao/img/"+shopId);
        shopPath.mkdirs();
        UploadUtil.multiUpload(request, shopPath.getAbsolutePath()+"/");
//        UploadUtil.multiUpload(request,"/home/l");
        return RespUtil.makeOKRsp(true);
    }
}

class UploadUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    public static boolean multiUpload(HttpServletRequest request, String filePath) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                return false;
            }
            String fileName = i + ".jpg";
            File dest = new File(filePath + fileName);
//            File dest = new File("/home/l/" + fileName);
            try {
                file.transferTo(dest);
                LOGGER.info("第" + (i + 1) + "个文件上传成功");
            } catch (IOException e) {
                LOGGER.error(e.toString(), e);
                return false;
            }
        }
        return true;
    }
}


//    @PostMapping("/upload")
//    @ResponseBody
//    public String upload(@RequestParam("file") MultipartFile file) {
//        if (file.isEmpty()) {
//            return "上传失败，请选择文件";
//        }
//
//        String fileName = file.getOriginalFilename();
//
//
//        String filePath = "D:\\ufs";
//        File dest = new File(filePath + fileName);
//        try {
//            file.transferTo(dest);
//            LOGGER.info("上传成功");
//            return "上传成功";
//        } catch (IOException e) {
//            LOGGER.error(e.toString(), e);
//        }
//        return "上传失败！";
//    }