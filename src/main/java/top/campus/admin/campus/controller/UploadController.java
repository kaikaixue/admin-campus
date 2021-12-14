package top.campus.admin.campus.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.campus.admin.campus.result.RestResult;
import top.campus.admin.campus.result.RestResultBuilder;
import top.campus.admin.campus.service.UploadService;

import javax.annotation.Resource;

@RestController
public class UploadController {
    @Resource
    UploadService uploadService;

    @PostMapping("/upload")
    public RestResult upload() {
        return new RestResultBuilder<>().success(uploadService.uploadPic());
    }
}
