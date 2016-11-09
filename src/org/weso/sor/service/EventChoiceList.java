package org.weso.sor.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.weso.sor.model.Events;

@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public interface EventChoiceList {
	List<Events> loadEventsByGrade(int grade);
	Events findEventByName(String eventName);
}
