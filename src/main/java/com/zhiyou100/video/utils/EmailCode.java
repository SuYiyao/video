package com.zhiyou100.video.utils;

import java.util.Random;

public class EmailCode {

	private static final Integer LENGTH_NUM = 5;

	public static Integer getRandomCode(){
		Integer minNum = (int) Math.pow(10, (LENGTH_NUM-1));
		Integer maxNum = (int) Math.pow(10, LENGTH_NUM) - 1;
		Random ran  = new Random();
		return ran.nextInt((maxNum - minNum + 1 ) + minNum) ;
	}
}
