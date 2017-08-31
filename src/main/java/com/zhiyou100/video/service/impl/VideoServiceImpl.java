package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.VideoMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoExample;
import com.zhiyou100.video.model.VideoVO;
import com.zhiyou100.video.service.VideoService;
import com.zhiyou100.video.utils.Page;
@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	VideoMapper vm;

	@Override
	public Page<Video> findPage(String videoTitle, int speakerId, int courseId, Integer currentPage) {
		Page<Video> page = new Page<>();
		Video vi = new Video();
		Course co = new Course();
		Speaker sp = new Speaker();
		vi.setVideoTitle(videoTitle);
		sp.setId(speakerId);
		co.setId(courseId);
		vi.setCo(co);
		vi.setSp(sp);
		vi.setCurrentPage((currentPage-1)*5);
		page.setPage(currentPage);
		page.setSize(5);
		page.setTotal(vm.findAllVideoCount(vi));
		page.setRows(vm.findAllVideo(vi));
		
		
		return page;
	}

	@Override
	public void addVideo(Video vi) {
		vm.insertSelective(vi);
		
	}

	@Override
	public Video findAllVideo(int id) {
		// TODO Auto-generated method stub
		return vm.selectByPrimaryKey(id);
	}

	@Override
	public void editVideo(Video vi) {
		// TODO Auto-generated method stub
		vm.updateByPrimaryKeySelective(vi);
	}

	@Override
	public void deleteVideo(int id) {
		// TODO Auto-generated method stub
		vm.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteVideoByIds(List<Integer> li) {
		// TODO Auto-generated method stub
		VideoExample example = new VideoExample();
		example.createCriteria().andIdIn(li);
		vm.deleteByExample(example);
	}

	@Override
	public List<VideoVO> analysis() {
		List<VideoVO> li = vm.analysis();
		
			return li;
		
		
	}
}
