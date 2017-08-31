package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.CourseVO;
import com.zhiyou100.video.utils.Page;

public interface CourseService {

	

	List<Course> findAllCourse();

	Page<Course> findAllCourse(Integer currentPage);

	void addCourse(Course co);

	Course findCourseById(int id);

	void editCourse(Course co);

	void editCourse(int id);

	

	

}
