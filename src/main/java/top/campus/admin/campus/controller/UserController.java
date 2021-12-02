package top.campus.admin.campus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.campus.admin.campus.domain.vo.UserVo;
import top.campus.admin.campus.result.R;
import top.campus.admin.campus.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/user")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/queryUser")
    public R queryUser() {
        List<UserVo> userList = userService.queryUser();
        return R.ok().data("item", userList);
    }
}
