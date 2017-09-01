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
import com.zhiyou100.video.utils.secToTime;

@Controller
@RequestMapping("front/video")
public class frontVideoController {
	@Autowired
	frontVideoService fv;
	@Autowired
	frontCourseService fc;
	@Autowired
	frontSpeakerService fs;
	@RequestMapping("/index.action")
	public String index(Integer videoId,Integer subjectId,Model mo){
		mo.addAttribute("videoId", videoId);
		Subject sub = fc.findSubjectNameBySubjectId(subjectId);
		mo.addAttribute("subject", sub);
		return "/front/video/index";
	}
	@RequestMapping("/videoData.action")
	public String videoData(Integer videoId,Model mo){
		mo.addAttribute("videoId", videoId);
		Video vi = fv.findAllVideo(videoId);
		mo.addAttribute("video", vi);
		Speaker sp = fs.findSpeaker(vi.getSpeakerId());
		mo.addAttribute("speaker", sp);
		Course co = fc.findCourse(vi.getCourseId());
		mo.addAttribute("course", co);
		Subject sub = fc.findSubjectNameBySubjectId(co.getSubjectId());
		mo.addAttribute("subjectId", sub.getId());
		List<Video> list = fv.findAllvideo(co.getId());
		for(Video vid :list){
			vid.setVideoLengthStr(secToTime.secToTime(vid.getVideoLength()));
		}
		mo.addAttribute("videoList", list);
		return "/front/video/content";
	}
	@RequestMapping("/state.action")
	public void state(Integer videoId){
		Video vi = fv.findAllVideo(videoId);
		Integer times = vi.getVideoPlayTimes()+1;
		vi.setVideoPlayTimes(times);
		fv.updateVideo(vi);
	}
}
