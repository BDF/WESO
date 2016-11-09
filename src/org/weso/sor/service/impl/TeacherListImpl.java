package org.weso.sor.service.impl;

import java.util.List;

import org.weso.sor.domain.TeacherDao;
import org.weso.sor.model.Teacher;
import org.weso.sor.service.TeachersList;

public class TeacherListImpl implements TeachersList {
	private TeacherDao teacherDao;
	
	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	public List<Teacher> getTeachers(Integer gradeId) {
		final List<Teacher> teachers = teacherDao.getTeachers(gradeId);
		return teachers;
	}
	
	public Teacher loadTeacher(Integer teacherId) {
		final Teacher teacher = teacherDao.loadTeacher(teacherId);
		return teacher;
	}

}
