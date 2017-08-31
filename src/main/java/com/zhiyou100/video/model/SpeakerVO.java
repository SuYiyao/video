package com.zhiyou100.video.model;

public class SpeakerVO {

	private Admin admin;
	private String nameKey;
	private String positionKey;
	private int currentPage;
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getNameKey() {
		return nameKey;
	}
	public void setNameKey(String nameKey) {
		this.nameKey = nameKey;
	}
	public String getPositionKey() {
		return positionKey;
	}
	public void setPositionKey(String positionKey) {
		this.positionKey = positionKey;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public String toString() {
		return "SpeakerVO [admin=" + admin + ", nameKey=" + nameKey + ", positionKey=" + positionKey + ", currentPage="
				+ currentPage + "]";
	}
	
	
}
