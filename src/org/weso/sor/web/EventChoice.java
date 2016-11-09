package org.weso.sor.web;

import org.weso.sor.model.Events;

public class EventChoice {
	private Events events;
	private Integer ranking;
	private String methodName;
	
	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public EventChoice(Events inEvent) {
		events = inEvent;
	}
	
	public EventChoice(Events inEvent, String inMethodName) {
		events = inEvent;
		methodName = inMethodName;	
	}

	public String getEventName() {
		return events.getEventName();
	}
	
	public void setEventName(final String eventName) {
		events.setEventName(eventName);
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
}
