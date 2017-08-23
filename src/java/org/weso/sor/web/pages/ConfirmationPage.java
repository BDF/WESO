package org.weso.sor.web.pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.weso.sor.model.Guardian;
import org.weso.sor.model.GuardianVolunteerChoices;
import org.weso.sor.model.Student;
import org.weso.sor.model.StudentEventChoices;
import org.weso.sor.service.GuardianManager;
import org.weso.sor.service.StudentManager;
import org.weso.sor.web.StudentDisplay;
import org.weso.sor.web.WesoState;

public class ConfirmationPage {
	@SuppressWarnings("unused")
	@Property
	private String _errorMessage;
	
	@Inject
	@Service("studentManager")
	private StudentManager studentManager;
	
	@Inject
	@Service("guardianManager")
	private GuardianManager guardianManager;
	
	@ApplicationState
	private WesoState wesoState;
	
	@SuppressWarnings("unused")
	@Property
	private StudentDisplay _student;
	
	public boolean isGuardianTwo() {
		return wesoState.getGuardianTwo() != null;
	}
	
	public List<StudentDisplay> getStudents() {
		final Collection<Student>  students = wesoState.getStudents();
		final List<StudentDisplay> sDisp = new ArrayList<StudentDisplay>(students.size());

		for (Student student : students) {
			List<StudentEventChoices> eventChoices = wesoState.getStudentEventChoices(student);
			sDisp.add(new StudentDisplay(student, eventChoices));
		}
		return sDisp; 
	}
	
	public String onSuccess() {
		final Guardian gOne = wesoState.getGuardianOne();
		final Guardian gTwo = wesoState.getGuardianTwo();

		Set<GuardianVolunteerChoices>  gOneVols = wesoState.getVolunteerOne();
		guardianManager.addGuardian(gOne, gOneVols);
		
		if (gTwo != null) {
			Set<GuardianVolunteerChoices>  gTwoVols = wesoState.getVolunteerTwo();
			guardianManager.addGuardian(gTwo, gTwoVols);
		}
		
		final Collection<Student> students = wesoState.getStudents();
		for (Student student : students) {
			List<StudentEventChoices> sec = wesoState.getStudentEventChoices(student);
			studentManager.addStudent(student, sec);
		}

		return "StudentPage";
	}
}
