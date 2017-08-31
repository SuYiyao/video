package com.zhiyou100.video.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.frontCourseService;
import com.zhiyou100.video.service.frontVideoService;

@Controller
@RequestMapping("/front/course")
public class frontCourseController {

	@Autowired
	frontCourseService fc;
	@Autowired
	frontVideoService fv;
	@RequestMapping("/index.do")
	public String index(Integer subjectId,Model mo){
		mo.addAttribute("subjectId", subjectId);
		Subject sub = fc.findSubjectNameBySubjectId(subjectId);
		mo.addAttribute("subject", sub);
		List<Course> li = fc.findcoursesBySubjectId(subjectId);
		mo.addAttribute("courses", li);
		for(Course cou : li){
			List<Video> list = fv.findVideos(cou.getId());
			cou.setVideoList(list);
		}
		return "/front/course/index";
	}
}
