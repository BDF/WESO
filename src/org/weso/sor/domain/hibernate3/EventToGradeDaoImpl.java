package org.weso.sor.domain.hibernate3;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.weso.sor.domain.EventToGradeDao;
import org.weso.sor.model.EventToGrade;
import org.weso.sor.model.Events;
import org.weso.sor.model.Grade;

public class EventToGradeDaoImpl extends HibernateDaoSupport implements
		EventToGradeDao {

	public EventToGrade addEventToGrade(Events event, Grade grade) {
		EventToGrade etg;
		try {
			final HibernateTemplate hibernateTemplate = getHibernateTemplate();
			final SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
			final Session session = sessionFactory.getCurrentSession();
			etg = new EventToGrade(grade, event);
			session.persist(etg);
		} catch (DataAccessException e) {
			// Critical errors : database unreachable, etc.
			logger.error("Exception - DataAccessException occurs : "
					+ e.getMessage() + " on addGuardian.");
			etg = null;
		} catch (ConstraintViolationException cve) {
			logger.error("Exception - ConstaintViolationException occurred : "
					+ cve.getMessage() + " on addGuardian.");
			etg = null;
		}
		return etg;
	}

	public EventToGrade addEventToGrade(String eventName, int gradeNumber) {
		EventToGrade etg;
		try {
			final HibernateTemplate hibernateTemplate = getHibernateTemplate();
			final SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
			final Session session = sessionFactory.getCurrentSession();
			final Criteria eventCrit = session.createCriteria(Events.class);
			eventCrit.add(Restrictions.eq("eventName", eventName));
			final Events event = (Events) eventCrit.uniqueResult();
			
			final Criteria gradeCrit = session.createCriteria(Grade.class);
			gradeCrit.add(Restrictions.eq("gradeNumb", gradeNumber));
			final Grade grade = (Grade) gradeCrit.uniqueResult();

			etg = addEventToGrade(event, grade);
		} catch (DataAccessException e) {
			// Critical errors : database unreachable, etc.
			logger.error("Exception - DataAccessException occurs : "
					+ e.getMessage() + " on addGuardian.");
			etg = null;
		} catch (ConstraintViolationException cve) {
			logger.error("Exception - ConstaintViolationException occurred : "
					+ cve.getMessage() + " on addEventToGrade.");
			etg = null;
		}
		return etg;
	}

	@SuppressWarnings("unchecked")
	public List<Events> listEventsByGrade(Integer gradeId) {
		List<Events> events;
		try {
			final HibernateTemplate hibernateTemplate = getHibernateTemplate();
			final SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
			final Session session = sessionFactory.getCurrentSession();
			final Criteria eventCrit = session.createCriteria(EventToGrade.class);
			eventCrit.add(Restrictions.eq("grade.gradeId", gradeId));
			events = eventCrit.list();
		} catch (DataAccessException e) {
			// Critical errors : database unreachable, etc.
			logger.error("Exception - DataAccessException occurs : "
					+ e.getMessage() + " on addGuardian.");
			events = null;
		} catch (ConstraintViolationException cve) {
			logger.error("Exception - ConstaintViolationException occurred : "
					+ cve.getMessage() + " on addEventToGrade.");
			events = null;
		}
		return events;
	}
	
	

}
