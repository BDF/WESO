package org.weso.sor.domain;

import java.util.Set;

import org.weso.sor.model.Guardian;
import org.weso.sor.model.GuardianVolunteerChoices;

public interface GuardianDao {
	
	Guardian addGuardian(String userName, String lastName, String firstName,
			String emailAddress,
			String primaryPhone,
			boolean photoPermisson, 
			String tShirtSize);

	boolean doesUserExist(String userName);

	Guardian addGuardian(Guardian guardian);

	Guardian attachGuardian(String userName);

	Guardian addGuardian(Guardian guardian,
			Set<GuardianVolunteerChoices> volunteer);
}
