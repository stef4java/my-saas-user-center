package com.stef.user.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author stef
 */
@Data
public class RespBean implements Serializable {

	/**
	 * 0为成功,非0则失败
	 */
	private int code;
	private String message;
	private Object data;

	public static RespBean ok(Object data) {
		return ok(0, "操作成功", data);
	}

	public static RespBean ok(int code, String msg, Object data) {
		RespBean r = new RespBean();
		r.setCode(code);
		r.setMessage(msg);
		r.setData(data);
		return r;
	}

	public static RespBean error(String msg) {
		return error(1, msg, null);
	}

	public static RespBean error(int code, String msg, Object data) {
		RespBean r = new RespBean();
		r.setCode(code);
		r.setMessage(msg);
		r.setData(data);
		return r;
	}

}
