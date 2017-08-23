package org.weso.sor.web;

import java.util.List;

import org.weso.sor.model.Student;
import org.weso.sor.model.StudentEventChoices;

public class StudentDisplay {
	private Student student;
	private String first;
	private String second;
	private String third;
	private String fourth;
	private String fifth;
	private StringBuilder okChoices = new StringBuilder();
	private StringBuilder alternates = new StringBuilder();

	public StudentDisplay(final Student inStudent,
			final List<StudentEventChoices> sec) {
		student = inStudent;

		for (StudentEventChoices studentEventChoice : sec) {
			int rank = studentEventChoice.getRanking();
			
			String eventName = studentEventChoice.getEvents().getEventName();
			switch (rank) {
			case 0:
				first = eventName;
				break;
			case 1:
				second = eventName;
				break;
			case 2:
				third = eventName;
				break;
			case 3:
				fourth = eventName;
				break;
			case 4:
				fifth = eventName;
				break;
			case 5:
				if (okChoices.length() == 0) {
					okChoices.append(eventName);
				} else {
					okChoices.append(", ").append(eventName);
				}
				break;
			}
			if (studentEventChoice.getAlternate() != null && 
				studentEventChoice.getAlternate().booleanValue()) {
				if (alternates.length() == 0) {
					alternates.append(eventName);
				} else {
					alternates.append(", ").append(eventName);
				}
			}
		}
	}

	public String getStudentName() {
		return student.getFirstName() + " " + student.getLastName();
	}

	public String getFirst() {
		return first;
	}

	public String getSecond() {
		return second;
	}

	public String getThird() {
		return third;
	}

	public String getFourth() {
		return fourth;
	}

	public String getFifth() {
		return fifth;
	}

	public String getOkChoices() {
		return okChoices.toString();
	}

	public String getAlternate() {
		return alternates.toString();
	}

}
