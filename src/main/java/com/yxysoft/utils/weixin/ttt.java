package com.yxysoft.utils.weixin;

import java.io.File;
import java.io.IOException;

public class ttt {

	/**
	 * MethodName: main
	 * @Description: 此处填写方法描述
	 * @param args   
	 * @return void  
	 * @author yangsy
	 * @version:0.1
	 * @date 2016-10-10 下午7:42:44
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        File file = new File("http://source.tanyangnet.com/user/avatar/1473392454764.png");
        if (!file.exists() || !file.isFile()) {  
            try {
				throw new IOException("文件不存在");
			} catch (IOException e) {
				e.printStackTrace();
			}  
        } 
	}

}
