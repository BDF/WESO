package org.weso.sor.web;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.weso.sor.model.Guardian;
import org.weso.sor.model.GuardianVolunteerChoices;
import org.weso.sor.model.Student;
import org.weso.sor.model.StudentEventChoices;

public class WesoState implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7044410858256504906L;
	private Guardian guardianOne;
	private Guardian guardianTwo;
	private Student curStudent;
	private Map<String, Student> addedStudents = new HashMap<String, Student>();
	private Map<String, List<StudentEventChoices>> studentChoices = new HashMap<String, List<StudentEventChoices>>();

	private Class<?> nextPage;
	private Set<GuardianVolunteerChoices> _volunteerOne;
	private Set<GuardianVolunteerChoices> _volunteerTwo;
	private boolean addingStudent = false;

	public boolean isAddingStudent() {
		return addingStudent;
	}

	public void setAddingStudent(boolean addingStudent) {
		this.addingStudent = addingStudent;
	}

	public Class<?> getNextPage() {
		return nextPage;
	}

	public void setNextPage(Class<?> nextPage) {
		this.nextPage = nextPage;
	}

	public Student getCurrentStudent() {
		return curStudent;
	}

	public void setCurrentStudent(Student newStudent) {
		this.curStudent = newStudent;
	}

	public Guardian getGuardianOne() {
		return guardianOne;
	}

	public void setGuardianOne(Guardian guardianOne) {
		this.guardianOne = guardianOne;
	}

	public void finishCurrentStudent() {
		if (curStudent != null) {
			if (addedStudents == null) {
				addedStudents = new HashMap<String, Student>();
			}
			final String key = buildKey(curStudent);
			addedStudents.put(key, curStudent);
			curStudent = null;
		}
	}

	private String buildKey(Student inStudent) {
		return inStudent.getFirstName() + " " + inStudent.getLastName();
	}

	public void setGuardianTwo(Guardian inG) {
		guardianTwo = inG;
	}

	public Guardian getGuardianTwo() {
		return guardianTwo;
	}

	public void setVolunteerOne(Set<GuardianVolunteerChoices> oneVols) {
		_volunteerOne = oneVols;
	}

	public void setVolunteerTwo(Set<GuardianVolunteerChoices> twoVols) {
		_volunteerTwo = twoVols;
	}

	public Set<GuardianVolunteerChoices> getVolunteerOne() {
		return _volunteerOne;
	}

	public Set<GuardianVolunteerChoices> getVolunteerTwo() {
		return _volunteerTwo;
	}

	public List<StudentEventChoices> getStudentEventChoices(
			final Student inStudent) {
		final String key = buildKey(inStudent);
		final List<StudentEventChoices> sec = studentChoices.get(key);
		return sec;
	}
	
	public void addStudentEventChoices(final Student inStudent,
			final List<StudentEventChoices> sec) {
		final String key = buildKey(inStudent);
		studentChoices.put(key, sec);
	}
	
	public Collection<Student> getStudents() {
		return addedStudents.values();
	}

	public Student  getStudent(String name) {
		return addedStudents.get(name);
	}
}
