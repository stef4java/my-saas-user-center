package com.stef.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>
 * 用户和角色关联表
 * </p>
 *
 * @author stef
 * @since 2021-05-06
 */
@Data
@TableName("sys_user_role")
public class UserRole {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;


}
