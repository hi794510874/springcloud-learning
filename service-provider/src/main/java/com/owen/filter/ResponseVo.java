package com.owen.filter;

import com.owen.utils.JacksonUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 服务返回通用对象
 * 
 * Created by huang_b on 2017/7/19.
 *
 */
@JsonInclude(Include.NON_NULL)
public class ResponseVo<T> {
	private Integer errcode;
	private String errmsg;
	private T data;

	public ResponseVo() {
		this.errcode = 0;
		this.errmsg = "";
		this.data = null;
	}

	public ResponseVo(T data) {
		this.errcode = 0;
		this.errmsg = "";
		this.data = data;
	}
 
	
	public ResponseVo(Integer errcode, String errrmsg) {
		this.errcode = errcode;
		this.errmsg = errrmsg;
		this.data = null;
	}

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String toJson() {
		return JacksonUtils.toJson(this);
	}

}
