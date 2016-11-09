package org.weso.sor.domain;

import java.util.List;
import java.util.Map;

import org.weso.sor.model.VolunteerActivities;

public interface VolunteerActivitiesDao {

	List<VolunteerActivities>  loadVolunteerActivities();

	Map<String, VolunteerActivities> loadNameToVolunteerActivities();
	
}
