package org.weso.sor.domain.hibernate3;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.weso.sor.domain.StudentDao;
import org.weso.sor.model.Grade;
import org.weso.sor.model.Student;
import org.weso.sor.model.StudentEventChoices;
import org.weso.sor.model.Teacher;
import org.weso.sor.utils.StringUtils;

public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {
	
	public Student addStudent(
			final Teacher teacher, 
			final Grade grade, 
			final String lastName,
			final String firstName,
			final String phoneNumber,
			final String tShirtSize,
			final int numOfEvents) {
		Student student;
		try {
			student = new Student(teacher, grade, lastName, firstName, phoneNumber, tShirtSize, numOfEvents);
			final Session session = getHibernateTemplate().getSessionFactory()
					.getCurrentSession();

			session.persist(student);
			if (logger.isInfoEnabled()) {
				logger.info("Added student: " + student);
			}
		} catch (DataAccessException e) {
			// Critical errors : database unreachable, etc.
			logger.error("Exception - DataAccessException occurs : "
					+ e.getMessage() + " on addGuardian.");
			student = null;
		} catch (ConstraintViolationException cve) {
			logger.error("Exception - ConstaintViolationException occurred : "
					+ cve.getMessage() + " on addGuardian.");
			student = null;
		}
		return student;
	}

	
	public Student findStudent(String lastName, String firstName) {
		final StringUtils utils = new StringUtils();
		utils.requiresLength(lastName, "Last Name");
		utils.requiresLength(firstName, "First Name");
		final Session session = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		Criteria crit = session.createCriteria(Student.class);
		crit.add(Restrictions.eq("lastName", lastName));
		crit.add(Restrictions.eq("firstName", firstName));

		final Student student = (Student) crit.uniqueResult();
		return student;
	}


	public Student addStudent(Student student) {
		try {
			final StringUtils utils = new StringUtils();
			utils.requiresLength("Last Name", student.getLastName());
			utils.requiresLength("First Name", student.getFirstName());
			utils.requiresLength("Phone Number", student.getPhoneNumber());
			utils.requiresLength("T-Shirt Size", student.getTshirtSize());
			if (student.getGrade() == null) {
				throw new IllegalArgumentException("Grade is a required field");
			}
			if (student.getTeacher() == null) {
				throw new IllegalArgumentException("Teacher is a required field");
			}
			
			final Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.persist(student);
			if (logger.isInfoEnabled()) {
				logger.info("Added student: " + student);
			}
		} catch (DataAccessException e) {
			// Critical errors : database unreachable, etc.
			logger.error("Exception - DataAccessException occurs : "
					+ e.getMessage() + " on addGuardian.");
		} catch (ConstraintViolationException cve) {
			logger.error("Exception - ConstaintViolationException occurred : "
					+ cve.getMessage() + " on addGuardian.");
		}
		return student;
	}


	public Student addStudent(Student student,
			List<StudentEventChoices> eventStatusList) {
		try {
			final StringUtils utils = new StringUtils();
			utils.requiresLength("Last Name", student.getLastName());
			utils.requiresLength("First Name", student.getFirstName());
			utils.requiresLength("Phone Number", student.getPhoneNumber());
			utils.requiresLength("T-Shirt Size", student.getTshirtSize());
			if (student.getGrade() == null) {
				throw new IllegalArgumentException("Grade is a required field");
			}
			if (student.getTeacher() == null) {
				throw new IllegalArgumentException("Teacher is a required field");
			}
			
			final Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.persist(student);
			for (StudentEventChoices studentEventChoice : eventStatusList) {
				studentEventChoice.setStudent(student);
				session.persist(studentEventChoice);
			}
			
			if (logger.isInfoEnabled()) {
				logger.info("Added student: " + student);
			}
		} catch (DataAccessException e) {
			// Critical errors : database unreachable, etc.
			logger.error("Exception - DataAccessException occurs : "
					+ e.getMessage() + " on addGuardian.");
		} catch (ConstraintViolationException cve) {
			logger.error("Exception - ConstaintViolationException occurred : "
					+ cve.getMessage() + " on addGuardian.");
		}
		return student;
	}

//	public Student addStudent(
//			final String lastName,
//			final String firstName,
//			final Guardian guardian,
//			final Integer gradeId) {
//	}
}
