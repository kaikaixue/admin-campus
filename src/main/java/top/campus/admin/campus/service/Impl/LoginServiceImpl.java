package top.campus.admin.campus.service.Impl;

import org.springframework.stereotype.Service;
import top.campus.admin.campus.domain.dto.LoginDTO;
import top.campus.admin.campus.result.RestResult;
import top.campus.admin.campus.result.RestResultBuilder;
import top.campus.admin.campus.result.ResultCode;
import top.campus.admin.campus.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public RestResult login(LoginDTO loginDTO) {
        if (loginDTO.getAccount().equals("admin") && loginDTO.getPassword().equals("123456")) {
            return new RestResultBuilder<>().success();
        }
        return new RestResultBuilder<>().failure(ResultCode.FAIL);
    }
}
