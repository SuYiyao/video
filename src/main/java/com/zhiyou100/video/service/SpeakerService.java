package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.SpeakerVO;
import com.zhiyou100.video.utils.Page;

public interface SpeakerService {

	Page loadPage(SpeakerVO sv);

	void addSpeaker(Speaker speaker);

	List<Speaker> findAllSpeaker();

	Speaker findSpeakerById(int id);

	void editSpeaker(Speaker sp);

	void deleteSpeaker(int id);

}
