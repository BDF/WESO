package org.weso.sor.domain.hibernate3;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.weso.sor.domain.StudentEventChoicesDao;
import org.weso.sor.model.Events;
import org.weso.sor.model.Student;
import org.weso.sor.model.StudentEventChoices;

public class StudentEventChoicesDaoImpl extends HibernateDaoSupport implements
		StudentEventChoicesDao {

	
	public StudentEventChoices addStudentEventChoice(Student student, Events event, int ranking) {
		StudentEventChoices sec;
		try {
			final HibernateTemplate hibernateTemplate = getHibernateTemplate();
			final SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
			final Session session = sessionFactory.getCurrentSession();
			final Criteria studentCrit = session.createCriteria(Student.class);
			studentCrit.add(Restrictions.eq("studentId", student.getStudentId()));
			final Student liveStudent = (Student) studentCrit.uniqueResult();
			
			final Criteria eventCrit = session.createCriteria(Events.class);
			eventCrit.add(Restrictions.eq("eventsId", event.getEventsId()));
			
			final Events liveEvent = (Events) eventCrit.uniqueResult();
			sec = new StudentEventChoices(liveEvent, liveStudent, ranking);
			session.persist(sec);
			
			if (logger.isInfoEnabled()) {
				logger.info("Added studentToGuardian: " + sec);
			}
		} catch (DataAccessException e) {
			// Critical errors : database unreachable, etc.
			logger.error("Exception - DataAccessException occurs : "
					+ e.getMessage() + " on addGuardian.");
			sec = null;
		} catch (ConstraintViolationException cve) {
			logger.error("Exception - ConstaintViolationException occurred : "
					+ cve.getMessage() + " on addGuardian.");
			sec = null;
		}
		return sec;
	}
	
	
	public StudentEventChoices addStudentEventChoice2(Student student, Events event, int ranking) {
		StudentEventChoices sec;
		try {
			final HibernateTemplate hibernateTemplate = getHibernateTemplate();
			final SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
			final Session session = sessionFactory.getCurrentSession();
			sec = new StudentEventChoices(event, student, ranking);
			session.persist(sec);
			
			if (logger.isInfoEnabled()) {
				logger.info("Added studentToGuardian: " + sec);
			}
		} catch (DataAccessException e) {
			// Critical errors : database unreachable, etc.
			logger.error("Exception - DataAccessException occurs : "
					+ e.getMessage() + " on addGuardian.");
			sec = null;
		} catch (ConstraintViolationException cve) {
			logger.error("Exception - ConstaintViolationException occurred : "
					+ cve.getMessage() + " on addGuardian.");
			sec = null;
		}
		return sec;
	}

}
