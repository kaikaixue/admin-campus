package top.campus.admin.campus.controller;

import org.springframework.web.bind.annotation.*;
import top.campus.admin.campus.domain.dto.LoginDTO;
import top.campus.admin.campus.result.RestResult;
import top.campus.admin.campus.service.LoginService;

import javax.annotation.Resource;

@RestController
public class LoginController {
    @Resource
    LoginService loginService;

    @PostMapping("/login")
    public RestResult login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }
}
