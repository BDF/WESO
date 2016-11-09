package org.weso.sor.domain.hibernate3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.weso.sor.domain.StudentToGuardianDao;
import org.weso.sor.model.Guardian;
import org.weso.sor.model.Student;
import org.weso.sor.model.StudentToGuardian;


public class StudentToGuardianDaoImpl extends HibernateDaoSupport implements StudentToGuardianDao {
	
	public StudentToGuardian addStudentToGuardian(Guardian guardian, Student student) {
		StudentToGuardian studentToGuardian;
		try {
			studentToGuardian = new StudentToGuardian(guardian, student);
			final HibernateTemplate hibernateTemplate = getHibernateTemplate();
			final SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
			final Session session = sessionFactory.getCurrentSession();
			session.persist(studentToGuardian);

			if (logger.isInfoEnabled()) {
				logger.info("Added studentToGuardian: " + studentToGuardian);
			}
		} catch (DataAccessException e) {
			// Critical errors : database unreachable, etc.
			logger.error("Exception - DataAccessException occurs : "
					+ e.getMessage() + " on addGuardian.");
			studentToGuardian = null;
		} catch (ConstraintViolationException cve) {
			logger.error("Exception - ConstaintViolationException occurred : "
					+ cve.getMessage() + " on addGuardian.");
			studentToGuardian = null;
		}
		return studentToGuardian;
	}

}
