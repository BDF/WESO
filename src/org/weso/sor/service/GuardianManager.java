package org.weso.sor.service;

import java.util.Set;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.weso.sor.model.Guardian;
import org.weso.sor.model.GuardianVolunteerChoices;


@Transactional(propagation=Propagation.REQUIRED)
public interface GuardianManager {
	
	Guardian addGuardian(final Guardian guardian, Set<GuardianVolunteerChoices> oneVols);

	boolean doesUserExist(String userName);

	Guardian attachGuardian(String userName);
}
