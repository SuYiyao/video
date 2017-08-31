package com.zhiyou100.video.model;

public class VideoVO {

	private Integer avgTimes;
	
	private String courseName;

	
	
	

	public Integer getAvgTimes() {
		return avgTimes;
	}

	public void setAvgTimes(Integer avgTimes) {
		this.avgTimes = avgTimes;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "VideoVO [avgTimes=" + avgTimes + ", courseName=" + courseName + "]";
	}

	
	
	
	
	
	
	
}
