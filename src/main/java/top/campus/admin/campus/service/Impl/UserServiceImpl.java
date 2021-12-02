package top.campus.admin.campus.service.Impl;

import org.springframework.stereotype.Service;
import top.campus.admin.campus.domain.Do.UserDo;
import top.campus.admin.campus.domain.vo.UserVo;
import top.campus.admin.campus.mapper.UserMapper;
import top.campus.admin.campus.service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserVo> queryUser() {
        // 定义list存放sql查到的结果
        List<UserDo> queryUserList = userMapper.queryUser();
        // 定义list决定返回给前端的东西
        List<UserVo> list = new ArrayList<>();
        for (UserDo userDo : queryUserList) {
            UserVo userVo = UserVo.builder()
                    .userId(userDo.getPk_id())
                    .avatar(userDo.getAvatar())
                    .name(userDo.getName())
                    .age(userDo.getAge())
                    .department(userDo.getDepartment())
                    .grade(userDo.getGrade())
                    .dormitory(userDo.getDormitory())
                    .phone(userDo.getPhone())
                    .createTime(userDo.getCreate_time())
                    .build();
            list.add(userVo);
        }
        return list;
    }
}
