package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.VideoMapper;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoExample;
import com.zhiyou100.video.service.frontVideoService;
@Service
public class frontVideoServiceImpl implements frontVideoService {

	@Autowired
	VideoMapper vm;

	@Override
	public List<Video> findVideos(Integer id) {
		VideoExample ve = new VideoExample();
		ve.createCriteria().andCourseIdEqualTo(id);
		return vm.selectByExample(ve);
	}

	@Override
	public Video findAllVideo(Integer videoId) {
		// TODO Auto-generated method stub
		return vm.selectByPrimaryKey(videoId);
	}

	@Override
	public List<Video> findAllvideo(Integer id) {
		// TODO Auto-generated method stub
		return vm.findVideos(id);
	}

	@Override
	public void updateVideo(Video vi) {
		// TODO Auto-generated method stub
		vm.updateByPrimaryKeySelective(vi);
	}

	
	
}
