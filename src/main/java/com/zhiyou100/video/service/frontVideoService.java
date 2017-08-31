package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Video;

public interface frontVideoService {

	List<Video> findVideos(Integer id);

	Video findAllVideo(Integer videoId);

	List<Video> findAllvideo(Integer id);

	void updateVideo(Video vi);

	


	

}
