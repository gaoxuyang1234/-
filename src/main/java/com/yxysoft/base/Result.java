package com.yxysoft.base;

import lombok.Data;

/**
 * 把今天最好的表现当作明天最新的起点．．～
 * いま 最高の表現 として 明日最新の始発．．～
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 *
 * @author : xiaomo
 * github: https://github.com/xiaomoinfo
 * email: xiaomo@xiaomo.info
 * <p>
 * Date: 2016/10/31 15:25
 * Description: 返回结果
 * Copyright(©) 2015 by xiaomo.
 */
@Data
public class Result<T> {

	private int resultCode = 200;//错误码

	private String message = "SUCCESS";//错误信息

	private T data;//数据

    /**
     * 只返回错误码
     *
     * @param resultCode resultCode
     */
    public Result(int resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * 只有返回数据的(验证成功)
     *
     * @param data data
     */
    public Result(T data) {
        this.data = data;
    }

    /**
     * 只有错误码和错误信息的
     *
     * @param resultCode resultCode
     * @param message    message
     */
    public Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }


    /**
     * 全部参数
     *
     * @param resultCode resultCode
     * @param message    message
     * @param data       data
     */
    public Result(int resultCode, String message, T data) {
        this.resultCode = resultCode;
        this.message = message;
        this.data = data;
    }

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Result() {
		super();
	}
    
    
    
    
}
