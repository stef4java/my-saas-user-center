package com.stef.user.feign.fallback;

import com.stef.common.RespBean;
import com.stef.user.dto.UserInfo;
import com.stef.user.feign.UserClient;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public RespBean<UserInfo> info(Long id) {
        return null;
    }
}
