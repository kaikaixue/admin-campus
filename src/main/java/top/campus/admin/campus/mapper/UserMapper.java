package top.campus.admin.campus.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.campus.admin.campus.domain.Do.UserDo;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDo> queryUser();
}
