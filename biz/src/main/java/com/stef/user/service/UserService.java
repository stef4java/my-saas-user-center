package com.stef.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stef.user.dto.UserInfo;
import com.stef.user.entity.User;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author stef
 * @since 2021-05-06
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户Id获取用户详情
     * @param id
     * @return
     */
    UserInfo info(Long id);

}
