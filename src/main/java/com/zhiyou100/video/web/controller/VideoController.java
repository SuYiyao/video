package com.zhiyou100.video.web.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;

import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.service.VideoService;
import com.zhiyou100.video.utils.Page;

@Controller
@RequestMapping("/video")
public class VideoController {

	@Autowired
	VideoService vs;
	
	@Autowired
	SpeakerService ss;
	@Autowired
	CourseService cs;
	@RequestMapping("/videoList.action")
	public ModelAndView videoList(@RequestParam(value="page",required=true,defaultValue="1") Integer currentPage,
			@RequestParam(defaultValue="") String videoTitle,
			@RequestParam(value="speakerId",required=true,defaultValue="0") int speakerId,
			@RequestParam(value="courseId",required=true,defaultValue="0") int courseId){
		
		ModelAndView mv = new ModelAndView();
		List<Speaker> speakerList = ss.findAllSpeaker();
		List<Course> courseList = cs.findAllCourse();
		Page<Video> page = vs.findPage(videoTitle,speakerId,courseId,currentPage);
		mv.addObject("speakerList", speakerList);
		mv.addObject("courseList", courseList);
		mv.addObject("videoTitle", videoTitle);
		mv.addObject("speakerId", speakerId);
		mv.addObject("courseId", courseId);
		
		mv.addObject("page", page);
		mv.setViewName("/admin/video/videoList");
		return mv;
	}
	@RequestMapping(value="/addVideo.action",method=RequestMethod.GET)
	public ModelAndView addVideo(){
		ModelAndView mv = new ModelAndView();
		List<Speaker> speakerList = ss.findAllSpeaker();
		List<Course> courseList = cs.findAllCourse();
		mv.addObject("speakerList", speakerList);
		mv.addObject("courseList", courseList);
		mv.setViewName("/admin/video/addVideo");
		return mv;
	}
	@RequestMapping(value="/addVideo.action",method=RequestMethod.POST)
	public String addVideo(Video vi){
		vs.addVideo(vi);
		return "redirect:/video/videoList.action";
	}
	@RequestMapping(value="/editVideo.action",method=RequestMethod.GET)
	public ModelAndView editVideo(int id){
		ModelAndView mv = new ModelAndView();
		List<Speaker> speakerList = ss.findAllSpeaker();
		List<Course> courseList = cs.findAllCourse();
		Video vi = vs.findAllVideo(id);
		mv.addObject("speakerList", speakerList);
		mv.addObject("courseList", courseList);
		mv.addObject("video", vi);
		
		mv.setViewName("/admin/video/updateVideo");
		return mv;
	}
	@RequestMapping(value="/editVideo.action",method=RequestMethod.POST)
	public String editVideo(Video vi){
		vs.editVideo(vi);
		return "redirect:/video/videoList.action";
	}
	@RequestMapping("/deleteVideo.action")
	@ResponseBody
	public String deleteVideo(int id){
		vs.deleteVideo(id);
		return "success";
	}
	@RequestMapping("/deleteAllVideo.action")
	public String deleteAllVideo(Integer [] choose){
		List<Integer> li = Arrays.asList(choose);
		vs.deleteVideoByIds(li);
		return "redirect:/video/videoList.action";
	}
	
}
