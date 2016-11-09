package org.weso.sor.web.pages;

import java.util.List;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.weso.sor.model.Grade;
import org.weso.sor.model.Student;
import org.weso.sor.service.GradeList;
import org.weso.sor.utils.StringUtils;
import org.weso.sor.web.ChildTShirtSizeSelectModel;
import org.weso.sor.web.GradesSelectModel;
import org.weso.sor.web.WesoState;

public class StudentPage {
	private GradesSelectModel gradesSelectModel;
	private ChildTShirtSizeSelectModel childSizeMode = new ChildTShirtSizeSelectModel();
	
	@Persist
	private String lastName;
	private String firstName;

	@Persist
	private String lineNumber;

	private Integer selectedGrade;
	private String errorMessages;

	@Inject
	@Service("gradeList")
	private GradeList gradeList;
	
	@ApplicationState
	private WesoState wesoState;
	private Integer selectTShirt;
	private Student currStudent;
	
	public WesoState getWesoState() {
		return wesoState;
	}

	public void setWesoState(WesoState wesoState) {
		this.wesoState = wesoState;
	}

	public String getErrorMessage() {
		return errorMessages;
	}

	public void setErrorMessage(String errorMessages) {
		this.errorMessages = errorMessages;
	}

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	public void onPrepareForRender() {
		fillGradesModel();
	}
	
//	public WesoState getWesoState() {
//		return wesoState;
//	}
//	
//	public void setWesoState(WesoState inWesoState) {
//		wesoState = inWesoState;
//	}
	
	public SelectModel getGrades() {
		return gradesSelectModel;
	}

	public SelectModel getTShirtSizes() {
		return childSizeMode;
	}
	
	@Validate("required") 
	public void setTShirt(Integer tShirtSize) {
		selectTShirt = tShirtSize;
	}
	
	public Integer getTShirt() {
		return selectTShirt;
	}

	@Validate("required")
	public void setGrade(Integer inGrade) {
		selectedGrade = inGrade;
	}
	
	public Integer getGrade(){
		return selectedGrade;
	}

	public String getLastName() {
		return lastName;
	}

	@Validate("required")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	@Validate("required")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	protected void fillGradesModel() {
		List<Grade> grades = gradeList.getGrades();
		gradesSelectModel = new GradesSelectModel(grades);
	}
	
	private Student buildStudent(final Student student) {
		StringUtils utils = new StringUtils();
		final Grade  grade = gradeList.loadGradeById(selectedGrade);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setGrade(grade);
		student.setTshirtSize(childSizeMode.findValue(selectTShirt));
		final String phoneNumber = utils.buildPhone(null, null, this.lineNumber);
		student.setPhoneNumber(phoneNumber);
		return student;
	}

	public String onSuccess() {
		String resultPage = "StudentPage";
		try {
			final Student student;
			if (currStudent == null) {
				student = new Student();
				buildStudent(student);
			} else {
				student = currStudent;
				buildStudent(student);
			}
			wesoState.setCurrentStudent(student);
			resultPage = "EventChoicePage";
		} catch (Exception e) {
			e.printStackTrace();
			resultPage = "StudentPage";
		}

		return resultPage;
	}
	
	/**
	 * New Session...dump old state.
	 */
	void onActivate() {
		if (wesoState != null && wesoState.isAddingStudent() == false) {
			wesoState = new WesoState();
		} 
	}
	
	void onActivate(final String name) {
		if (name != null && name.equals("add")) {
			
		} else if (wesoState != null && wesoState.getStudent(name) != null )  {
			final Student student = wesoState.getStudent(name);
			firstName = student.getFirstName();
			lastName = student.getLastName();
			lineNumber = student.getPhoneNumber();
			selectedGrade = student.getGrade().getGradeId();
			if (student.getTshirtSize() != null) {
				selectTShirt = childSizeMode.findKey(student.getTshirtSize());
			}
		} else {
			wesoState = new WesoState();
		}
	}
}
