package org.weso.sor.domain;

import java.util.List;

import org.weso.sor.model.Grade;
import org.weso.sor.model.Student;
import org.weso.sor.model.StudentEventChoices;
import org.weso.sor.model.Teacher;

/**
 * 
 * @author bforester
 */
public interface StudentDao {

	Student addStudent(
			final Teacher teacher, 
			final Grade grade,
			final String lastName, 
			final String firstName,
			final String phoneNumber,
			final String tShirtSize,
			final int numOfEvents);

	Student addStudent(Student student);
	
	Student findStudent(String lastName, String firstName);

	Student addStudent(Student curStudent,
			List<StudentEventChoices> eventStatusList);

}
