package com.zhiyou100.video.service;



import java.util.List;

import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoVO;
import com.zhiyou100.video.utils.Page;

public interface VideoService {

	Page<Video> findPage(String videoTitle, int speakerId, int courseId, Integer currentPage);

	void addVideo(Video vi);

	Video findAllVideo(int id);

	void editVideo(Video vi);

	void deleteVideo(int id);

	void deleteVideoByIds(List<Integer> li);

	List<VideoVO> analysis();

}
