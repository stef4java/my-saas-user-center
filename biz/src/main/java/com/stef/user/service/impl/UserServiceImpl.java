package com.stef.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stef.user.dto.UserInfo;
import com.stef.user.entity.User;
import com.stef.user.entity.UserRole;
import com.stef.user.mapper.UserMapper;
import com.stef.user.mapper.UserRoleMapper;
import com.stef.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author stef
 * @since 2021-05-06
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public UserInfo info(Long id) {
        UserInfo info = new UserInfo();
        User user = this.baseMapper.selectById(id);
        Assert.notNull(user, "not find.");
        info.setUser(user);
        info.setRoles(userRoleMapper.selectList(new QueryWrapper<UserRole>()
                .lambda()
                .eq(UserRole::getUserId, user.getId())));
        return info;
    }
}
