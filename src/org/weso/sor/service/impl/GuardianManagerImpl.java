package org.weso.sor.service.impl;

import java.util.Set;

import org.weso.sor.domain.GuardianDao;
import org.weso.sor.model.Guardian;
import org.weso.sor.model.GuardianVolunteerChoices;
import org.weso.sor.service.GuardianManager;

public class GuardianManagerImpl implements GuardianManager {
	private GuardianDao _guardianDao;
	
	public GuardianDao getGuardianDao() {
		return _guardianDao;
	}

	public void setGuardianDao(GuardianDao dao) {
		_guardianDao = dao;
	}
	
	
	public Guardian addGuardian(Guardian guardian) {
		final Guardian newGuardian = _guardianDao.addGuardian(guardian);
		return newGuardian;
	}
	
	
	public boolean doesUserExist(final String userName) {
		final boolean doesUserExist = _guardianDao.doesUserExist(userName);
		return doesUserExist;
	}

	
	public Guardian attachGuardian(String userName) {
		final Guardian guardian = _guardianDao.attachGuardian(userName);
		return guardian;
	}

	public Guardian addGuardian(Guardian guardian,
			Set<GuardianVolunteerChoices> volunteer) {
		final Guardian newGuardian = _guardianDao.addGuardian(guardian, volunteer);
		return newGuardian;
	}

}
