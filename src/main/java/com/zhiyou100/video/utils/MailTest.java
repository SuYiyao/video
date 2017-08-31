package com.zhiyou100.video.utils;

import org.junit.Test;

/**  
* @ClassName: MailTest  
* @Description: TODO
* @author lyb  
* @date 2017年8月28日  下午2:31:54
*  
*/
public class MailTest {

	@Test
	public void test01() throws Exception{
		/*
		 * 
		 * <a href=\"http://www.baidu.com\">百度</a>
		 */
		MailUtil.send("1448570200@qq.com", "45321", "您中了500万请点击领取..<a href=\"http://www.baidu.com\">百度</a>");
		/*
		 * 0. MD5(邮箱+密码+当前时间)就是激活码  24小时有效
		 * 1.id(uuid)  邮箱地址   状态(0未激活,1表示激活)   激活码     失效时间
		 * 2.http://localhost:8080/Test/Mail/active.action?id=id&activeCode=激活码 
		 */
		
		
		
	}
	
}
