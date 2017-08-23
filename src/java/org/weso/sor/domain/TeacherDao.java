package org.weso.sor.domain;

import java.util.List;

import org.weso.sor.model.Grade;
import org.weso.sor.model.Teacher;


public interface TeacherDao {

	List<Teacher> getTeachers();
	
	List<Teacher> getTeachers(Grade grade);
	
	List<Teacher> getTeachers(Integer gradeId);

	Teacher find(String teacherName);

	Teacher loadTeacher(Integer teacherId);
	
}
