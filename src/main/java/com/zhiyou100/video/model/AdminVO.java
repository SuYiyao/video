package com.zhiyou100.video.model;

public class AdminVO {

	private String loginName;
	private String loginPwd;
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	@Override
	public String toString() {
		return "AdminVO [loginName=" + loginName + ", loginPwd=" + loginPwd + "]";
	}
	
	
}