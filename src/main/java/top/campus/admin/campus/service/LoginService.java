package top.campus.admin.campus.service;

import top.campus.admin.campus.domain.dto.LoginDTO;
import top.campus.admin.campus.result.RestResult;

public interface LoginService {
    RestResult login(LoginDTO loginDTO);
}
