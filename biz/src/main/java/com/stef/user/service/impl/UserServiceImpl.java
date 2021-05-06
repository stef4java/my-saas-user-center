package com.stef.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stef.user.entity.User;
import com.stef.user.mapper.UserMapper;
import com.stef.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author stef
 * @since 2021-05-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
