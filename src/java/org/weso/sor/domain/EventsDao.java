package org.weso.sor.domain;

import java.util.List;

import org.weso.sor.model.Events;

public interface EventsDao {

	public List<Events> findEvents(int grade);

	public Events findEventByName(String eventName);
}
