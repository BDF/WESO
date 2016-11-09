package org.weso.sor.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.util.AbstractSelectModel;
import org.weso.sor.model.Events;

public class EventSelectModel extends AbstractSelectModel {
	private List<OptionModel> eventsModel;
	
	public EventSelectModel(List<Events> events) {
		eventsModel = new ArrayList<OptionModel>(events.size());
		for (Events currEvent : events) {
			eventsModel.add(new GradeOptionModel(currEvent.getEventsId(), currEvent.getEventName()));
		}
	}
	
	public List<OptionGroupModel> getOptionGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OptionModel> getOptions() {
		// TODO Auto-generated method stub
		return null;
	}

}
