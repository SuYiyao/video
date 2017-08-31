package com.zhiyou100.video.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.frontCourseService;
import com.zhiyou100.video.service.frontSpeakerService;
import com.zhiyou100.video.service.frontVideoService;

@Controller
@RequestMapping("front/video")
public class frontVideoController {

	@Autowired
	frontVideoService fv;
	@Autowired
	frontCourseService fc;
	@Autowired
	frontSpeakerService fs;
	@RequestMapping("/index.do")
	public String index(Integer videoId,Integer subjectId,Model mo){
		mo.addAttribute("videoId", videoId);
		Subject sub = fc.findSubjectNameBySubjectId(subjectId);
		mo.addAttribute("subject", sub);
		return "/front/video/index";
	}
	@RequestMapping("/videoData.do")
	public String videoData(Integer videoId,Model mo){
		mo.addAttribute("videoId", videoId);
		Video vi = fv.findAllVideo(videoId);
		mo.addAttribute("video", vi);
		Speaker sp = fs.findSpeaker(vi.getSpeakerId());
		mo.addAttribute("speaker", sp);
		Course co = fc.findCourse(vi.getCourseId());
		mo.addAttribute("course", co);
		List<Video> list = fv.findAllvideo(co.getId());
		mo.addAttribute("videoList", list);
		return "/front/video/content";
	}
	@RequestMapping("/state.do")
	public void state(Integer videoId){
		Video vi = fv.findAllVideo(videoId);
		Integer times = vi.getVideoPlayTimes()+1;
		vi.setVideoPlayTimes(times);
		fv.updateVideo(vi);
	}
}
