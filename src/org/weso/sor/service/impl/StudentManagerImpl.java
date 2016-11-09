package org.weso.sor.service.impl;

import java.util.List;

import org.weso.sor.domain.StudentDao;
import org.weso.sor.model.Grade;
import org.weso.sor.model.Student;
import org.weso.sor.model.StudentEventChoices;
import org.weso.sor.model.Teacher;
import org.weso.sor.service.StudentManager;

public class StudentManagerImpl implements StudentManager {
	private StudentDao studentDao;
	
	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}


	public Student addStudent(
			Teacher teacher, 
			Grade grade,
			String lastName, 
			String firstName,
			final String phoneNumber,
			final String tShirtSize,
			final int numOfEvents) {
		return studentDao.addStudent(teacher, grade, lastName, firstName, phoneNumber, tShirtSize, numOfEvents);
	}
	
	public Student addStudent(Student student) {
		return studentDao.addStudent(student);
	}

	public Student addStudent(Student curStudent,
			List<StudentEventChoices> eventStatusList) {
		return studentDao.addStudent(curStudent, eventStatusList);
	}

}
