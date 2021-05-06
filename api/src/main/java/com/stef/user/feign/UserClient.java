package com.stef.user.feign;


import com.stef.common.RespBean;
import com.stef.user.dto.UserInfo;
import com.stef.user.feign.fallback.UserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "my-saas-user-center", fallback = UserClientFallback.class)
public interface UserClient {

    /**
     * 通过用户id查询用户信息
     * @param id 用户Id
     * @return RespBean
     */
    @RequestMapping(value = "/user/info/{id}",method= RequestMethod.GET)
    RespBean<UserInfo> info(@PathVariable("id") Long id);


}
