package top.campus.admin.campus.service.Impl;

import org.springframework.stereotype.Service;
import top.campus.admin.campus.domain.dto.UploadDTO;
import top.campus.admin.campus.service.UploadService;
import top.campus.admin.campus.util.CallbackServer;
import top.campus.admin.campus.util.OperationOSS;
import top.campus.admin.campus.util.OssConfig;

@Service
public class UploadServiceImpl implements UploadService {
    CallbackServer callbackServer = new CallbackServer();

    @Override
    public Integer uploadPic() {
//        callbackServer.doGet()
        return 0;
    }
}
