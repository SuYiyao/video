package com.zhiyou100.video.web.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.SubjectService;
import com.zhiyou100.video.utils.Page;

@Controller
@RequestMapping("/admin/course")
public class CourseController {

	@Autowired
	CourseService cs;
	@Autowired
	SubjectService ss;
	
	
	@RequestMapping("/courseList.action")
	public ModelAndView courseList(@RequestParam(value="page",required=true,defaultValue="1") Integer currentPage){
		ModelAndView mv = new ModelAndView();
		Page<Course> page = cs.findAllCourse(currentPage);
		mv.addObject("page", page);
		mv.setViewName("/admin/course/courseList");
		return mv;
	}
	@RequestMapping(value="/addCourse.action",method=RequestMethod.GET)
	public ModelAndView addCourse(){
		ModelAndView mv = new ModelAndView();
		List<Subject> li = ss.findAllSubject();
		mv.addObject("list", li);
		mv.setViewName("/admin/course/addCourse");
		return mv;
	}
	@RequestMapping(value="/addCourse.action",method=RequestMethod.POST)
	public String addCourse(Course co){
		cs.addCourse(co);
		return"redirect:/admin/course/courseList.action";
	}
	@RequestMapping(value="/editCourse.action",method=RequestMethod.GET)
	public ModelAndView editCourse(int id){
		ModelAndView mv = new ModelAndView();
		Course co = cs.findCourseById(id);
		List<Subject> li = ss.findAllSubject();
		mv.addObject("list", li);
		mv.addObject("course", co);
		mv.setViewName("/admin/course/updateCourse");
		return mv;
	}
	@RequestMapping(value="/editCourse.action",method=RequestMethod.POST)
	public String editCourse(Course co){
		cs.editCourse(co);
		return"redirect:/admin/course/courseList.action";
	}
	@RequestMapping("/deleteCourse.action")
	@ResponseBody
	public String deleteCourse(int id){
		cs.editCourse(id);
		return"success";
	}
	
}
