package org.weso.sor.domain;

import org.weso.sor.model.Events;
import org.weso.sor.model.Student;
import org.weso.sor.model.StudentEventChoices;

public interface StudentEventChoicesDao {

	public StudentEventChoices addStudentEventChoice(Student student, Events event, int rank);

	StudentEventChoices addStudentEventChoice2(Student student, Events event,
			int ranking);
}
