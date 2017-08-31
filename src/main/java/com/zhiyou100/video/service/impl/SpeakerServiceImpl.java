package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.zhiyou100.video.mapper.SpeakerMapper;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.SpeakerVO;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.utils.Page;

@Service
public class SpeakerServiceImpl implements SpeakerService {

	@Autowired
	SpeakerMapper sm;

	@Override
	public Page loadPage(SpeakerVO sv) {
		Page<Speaker> page = new Page<>();
		page.setPage(sv.getCurrentPage());
		page.setTotal(sm.findAllSpeakerCount(sv));
		page.setSize(5);
		int a = (sv.getCurrentPage()-1)*5;
		sv.setCurrentPage(a);
		page.setRows(sm.findAllSpeaker(sv));
		return page;
		
	}

	@Override
	public void addSpeaker(Speaker speaker) {
		sm.insertSelective(speaker);
		
	}

	@Override
	public List<Speaker> findAllSpeaker() {
		// TODO Auto-generated method stub
		return sm.selectByExample(null);
	}

	@Override
	public Speaker findSpeakerById(int id) {
		// TODO Auto-generated method stub
		return sm.selectByPrimaryKey(id);
	}

	@Override
	public void editSpeaker(Speaker sp) {
		// TODO Auto-generated method stub
		sm.updateByPrimaryKeySelective(sp);
	}

	@Override
	public void deleteSpeaker(int id) {
		// TODO Auto-generated method stub
		sm.deleteByPrimaryKey(id);
	}
}
