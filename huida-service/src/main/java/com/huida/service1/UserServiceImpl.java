package com.huida.service1;

import com.huida.api.UserService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @description
 * @Author WYP
 * @Date 2021/3/10
 */
@Service
public class UserServiceImpl  implements UserService {
    @Override
    public String dubboTest(String param) {
        return "掉成功了啊啊 啊";
    }
}
