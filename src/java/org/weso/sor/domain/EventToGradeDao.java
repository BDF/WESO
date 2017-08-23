package org.weso.sor.domain;

import java.util.List;

import org.weso.sor.model.EventToGrade;
import org.weso.sor.model.Events;
import org.weso.sor.model.Grade;

public interface EventToGradeDao {
	EventToGrade addEventToGrade(Events event, Grade grade);
	EventToGrade addEventToGrade(String eventName, int grade);
	List<Events> listEventsByGrade(Integer gradeId);
}
