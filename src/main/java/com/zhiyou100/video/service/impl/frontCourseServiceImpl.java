package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.CourseMapper;
import com.zhiyou100.video.mapper.SubjectMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.CourseExample;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.service.frontCourseService;
@Service
public class frontCourseServiceImpl implements frontCourseService {

	@Autowired
	CourseMapper cm;
	@Autowired
	SubjectMapper sm;

	@Override
	public List<Course> findcoursesBySubjectId(Integer subjectId) {
		// TODO Auto-generated method stub
		CourseExample ce = new CourseExample();
		ce.createCriteria().andSubjectIdEqualTo(subjectId);
		return cm.selectByExample(ce);
	}

	@Override
	public Subject findSubjectNameBySubjectId(Integer subjectId) {
		// TODO Auto-generated method stub
		return sm.selectByPrimaryKey(subjectId);
	}

	@Override
	public Course findCourse(Integer courseId) {
		// TODO Auto-generated method stub
		return cm.selectByPrimaryKey(courseId);
	}
}
