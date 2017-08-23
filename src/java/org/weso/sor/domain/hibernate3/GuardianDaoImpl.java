package org.weso.sor.domain.hibernate3;

import java.util.Date;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.weso.sor.domain.GuardianDao;
import org.weso.sor.model.Guardian;
import org.weso.sor.model.GuardianVolunteerChoices;
import org.weso.sor.utils.StringUtils;

public class GuardianDaoImpl extends HibernateDaoSupport implements GuardianDao {
	
	public Guardian addGuardian(final String userName, final String lastName,
			final String firstName, final String emailAddress,
			final String primaryPhone,
			boolean photoPermisson, 
			String tShirtSize) throws IllegalArgumentException {
		verifyParameters(userName, lastName, firstName, emailAddress,
				primaryPhone);
		Guardian guardian;
		try {
			guardian = new Guardian(userName, lastName, firstName,
					emailAddress, primaryPhone, photoPermisson, tShirtSize);
			final Session session = getHibernateTemplate().getSessionFactory()
					.getCurrentSession();

			session.persist(guardian);
			session.flush();
			if (logger.isInfoEnabled()) {
				logger.info("Added guardian: " + guardian);
			}
		} catch (DataAccessException e) {
			// Critical errors : database unreachable, etc.
			logger.error("Exception - DataAccessException occurs : "
					+ e.getMessage() + " on addGuardian.");
			guardian = null;
		} catch (ConstraintViolationException cve) {
			logger.error("Exception - ConstaintViolationException occurred : "
					+ cve.getMessage() + " on addGuardian.");
			guardian = null;
		}
		return guardian;
	}

	private void verifyParameters(final String userName, final String lastName,
			final String firstName, final String emailAddress,
			String primaryPhone) {
		final StringUtils utils = new StringUtils();
		utils.requiresLength(userName, "User Name");
		utils.requiresLength(lastName, "Last Name");
		utils.requiresLength(firstName, "First Name");
		utils.requiresLength(emailAddress, "E-Mail Address");
		utils.requiresLength(primaryPhone, "Primary Phone Number");
	}

	
	public boolean doesUserExist(String userName) {
		final StringUtils utils = new StringUtils();
		utils.requiresLength(userName, "User Name");

		Session session = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		// create a new criteria
		Criteria crit = session.createCriteria(Guardian.class);
		crit.add(Restrictions.eq("userName", userName));

		Guardian guardian = (Guardian) crit.uniqueResult();
		return (guardian != null);
	}

	public Guardian addGuardian(final Guardian guardian) {
		try {
			final Session session = getHibernateTemplate().getSessionFactory()
					.getCurrentSession();
			guardian.setDateCreated(new Date());
			session.persist(guardian);
			session.flush();
			if (logger.isInfoEnabled()) {
				logger.info("Added guardian: " + guardian);
			}
		} catch (DataAccessException e) {
			// Critical errors : database unreachable, etc.
			logger.error("Exception - DataAccessException occurs : "
					+ e.getMessage() + " on addGuardian.");
		} catch (ConstraintViolationException cve) {
			logger.error("Exception - ConstaintViolationException occurred : "
					+ cve.getMessage() + " on addGuardian.");
		}
		return guardian;
	}
	


	
	public Guardian attachGuardian(String userName) {
		final StringUtils utils = new StringUtils();
		utils.requiresLength(userName, "User Name");

		Session session = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		// create a new criteria
		Criteria crit = session.createCriteria(Guardian.class);
		crit.add(Restrictions.eq("userName", userName));

		Guardian guardian = (Guardian) crit.uniqueResult();
		return guardian;
	}

	public Guardian addGuardian(Guardian guardian,
			Set<GuardianVolunteerChoices> volunteer) {
		Guardian pGuardian = addGuardian(guardian);
		if (volunteer != null && volunteer.size() > 0) {
			final Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			for (GuardianVolunteerChoices guardianVolunteerChoices : volunteer) {
				guardianVolunteerChoices.setGuardian(pGuardian);
				session.persist(guardianVolunteerChoices);
			}
		}
		return pGuardian;
	}

}
