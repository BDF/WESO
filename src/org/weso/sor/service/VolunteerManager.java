package org.weso.sor.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.weso.sor.model.VolunteerActivities;

@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public interface VolunteerManager {
	List<VolunteerActivities> loadVolunteerChoices();
	
	Map<String, VolunteerActivities> loadNameToVolunteerActivities();
}
