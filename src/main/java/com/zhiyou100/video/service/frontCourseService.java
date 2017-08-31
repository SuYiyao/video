package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;

public interface frontCourseService {

	List<Course> findcoursesBySubjectId(Integer subjectId);

	Subject findSubjectNameBySubjectId(Integer subjectId);

	Course findCourse(Integer courseId);

}
