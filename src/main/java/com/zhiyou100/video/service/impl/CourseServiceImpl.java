package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.CourseMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.CourseVO;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.utils.Page;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseMapper cm;

	@Override
	public Page<Course> findAllCourse(Integer currentPage) {
		Page<Course> page = new Page<>();
		Course co = new Course();
		co.setCurrentPage((currentPage-1)*5);
		page.setPage(currentPage);
		page.setSize(5);
		page.setTotal(cm.findTotalCount());
		page.setRows(cm.findAllCourse(co));
		
		return page;
	}

	

	@Override
	public List<Course> findAllCourse() {
		// TODO Auto-generated method stub
		return cm.selectByExample(null);
	}



	@Override
	public void addCourse(Course co) {
		// TODO Auto-generated method stub
		cm.insertSelective(co);
	}



	@Override
	public Course findCourseById(int id) {
		// TODO Auto-generated method stub
		return cm.selectByPrimaryKey(id);
	}



	@Override
	public void editCourse(Course co) {
		// TODO Auto-generated method stub
		cm.updateByPrimaryKeySelective(co);
	}



	@Override
	public void editCourse(int id) {
		// TODO Auto-generated method stub
		cm.deleteByPrimaryKey(id);
	}
	
	
	
	
	
}
