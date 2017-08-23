package org.weso.sor.service.impl;

import java.util.List;
import java.util.Map;

import org.weso.sor.domain.VolunteerActivitiesDao;
import org.weso.sor.model.VolunteerActivities;
import org.weso.sor.service.VolunteerManager;

public class VolunteerManagerImpl implements VolunteerManager {
	private VolunteerActivitiesDao vaDao;
	
	public void setVolunteerActivitiesDao(VolunteerActivitiesDao inVaDao) {
		vaDao = inVaDao;
	}

	public VolunteerActivitiesDao getVolunteerActivitiesDao() {
		return vaDao;
	}

	public List<VolunteerActivities> loadVolunteerChoices() {
		final List<VolunteerActivities> vas = vaDao.loadVolunteerActivities();
		return vas; 
	}

	public Map<String, VolunteerActivities> loadNameToVolunteerActivities() {
		final Map<String, VolunteerActivities> nameToVa = vaDao.loadNameToVolunteerActivities();
		return nameToVa;
	}

}
