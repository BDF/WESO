package org.weso.sor.domain;

import org.weso.sor.model.Guardian;
import org.weso.sor.model.Student;
import org.weso.sor.model.StudentToGuardian;

public interface StudentToGuardianDao {

	
	StudentToGuardian addStudentToGuardian(Guardian g, Student s);
}
