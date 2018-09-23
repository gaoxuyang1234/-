package com.yxysoft.utils.weixin;

import java.util.Random;

public class tt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			int max = 20;
			int min = 0;
			Random random = new Random();
			System.out.println((int)random.nextInt(max)%(max-min+1) + min);
		}
	}

}
