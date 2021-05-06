package com.stef.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	private Date createTime;
	private Date updateTime;
	/**
	 * 删除标识
	 */
	// private Integer delFlag;

}
