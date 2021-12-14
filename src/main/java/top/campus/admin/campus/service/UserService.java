package top.campus.admin.campus.service;

import top.campus.admin.campus.domain.Do.UserDo;
import top.campus.admin.campus.domain.vo.UserVo;

import java.util.List;

public interface UserService {
    /**
     * 查询用户列表
     * @return
     */
    List<UserVo> queryUser();
}
