package com.yxysoft.utils.weixin;

import com.yxysoft.utils.weixin.thread.AccessTokenThread;

public class testtt {

	/**
	 * MethodName: main
	 * @Description: 此处填写方法描述
	 * @param args   
	 * @return void  
	 * @author yangsy
	 * @version:0.1
	 * @date 2016-4-26 上午11:06:00
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new AccessTokenThread()).start();
	}

}
