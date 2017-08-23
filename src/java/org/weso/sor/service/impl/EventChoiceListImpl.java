package org.weso.sor.service.impl;

import java.util.List;

import org.weso.sor.domain.EventsDao;
import org.weso.sor.model.Events;
import org.weso.sor.service.EventChoiceList;

public class EventChoiceListImpl implements EventChoiceList {
	private EventsDao eventsDao;

	public EventsDao getEventsDao() {
		return eventsDao;
	}

	public void setEventsDao(EventsDao eventToGradeDao) {
		this.eventsDao = eventToGradeDao;
	}

	public List<Events> loadEventsByGrade(int grade) {
		final List<Events> events = eventsDao.findEvents(grade);
		return events;
	}
	
	public Events findEventByName(String eventName) {
		final Events event = eventsDao.findEventByName(eventName);
		return event;
	}
}
