package org.weso.sor.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.weso.sor.model.Grade;
import org.weso.sor.model.Student;
import org.weso.sor.model.StudentEventChoices;
import org.weso.sor.model.Teacher;

@Transactional(propagation=Propagation.REQUIRED)
public interface StudentManager {

//	Student addStudent(final String lastName, final String firstName,
//			final Guardian guardian, final Integer gradeId);
	Student addStudent(
			Teacher teacher, 
			Grade grade,
			String lastName, 
			String firstName,
			final String phoneNumber,
			final String tShirtSize,
			final int numOfEvents);
	
	Student addStudent(Student student);

	Student addStudent(Student curStudent,
			List<StudentEventChoices> eventStatusList);
}
