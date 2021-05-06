package com.stef.user.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stef.common.RespBean;
import com.stef.user.dto.UserInfo;
import com.stef.user.entity.User;
import com.stef.user.feign.UserClient;
import com.stef.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.stef.common.RespBean.ok;


/**
 * 用户信息表
 *
 * @author stef
 * @date 2021-05-06
 */
@RestController
@RequestMapping("/user")
@Api(value = "/user", tags = "用户信息表管理")
public class UserController implements UserClient {

    @Autowired
    private  UserService userService;

    /**
     * 通过id获取用户详情
     * @param id id
     * @return RespBean
     */
    @ApiOperation(value = "通过id获取用户详情", notes = "通过id获取用户详情")
    @GetMapping("/info/{id}" )
    @Override
    public RespBean<UserInfo> info(@PathVariable  Long id) {
        UserInfo info = userService.info(id);
        return RespBean.ok(info);
    }

    /**
     * 分页查询
     * @param page 分页对象
     * @param user 用户信息表
     * @return RespBean
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public RespBean getUserControllerPage(Page page, User user) {
        return ok(userService.page(page, Wrappers.query(user)));
    }


    /**
     * 通过id查询用户信息表
     * @param id id
     * @return RespBean
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    public RespBean getById(@PathVariable("id" ) Long id) {
        return ok(userService.getById(id));
    }

    /**
     * 新增用户信息表
     * @param user 用户信息表
     * @return RespBean
     */
    @ApiOperation(value = "新增用户信息表", notes = "新增用户信息表")
    @PostMapping
    public RespBean save(@RequestBody User  user) {
        return ok(userService.save(user));
    }

    /**
     * 修改用户信息表
     * @param user 用户信息表
     * @return RespBean
     */
    @ApiOperation(value = "修改用户信息表", notes = "修改用户信息表")
    @PutMapping
    public RespBean updateById(@RequestBody User  user) {
        return ok(userService.updateById(user));
    }

    /**
     * 通过id删除用户信息表
     * @param id id
     * @return RespBean
     */
    @ApiOperation(value = "通过id删除用户信息表", notes = "通过id删除用户信息表")
    @DeleteMapping("/{id}" )
    public RespBean removeById(@PathVariable Long id) {
        return ok(userService.removeById(id));
    }


}
