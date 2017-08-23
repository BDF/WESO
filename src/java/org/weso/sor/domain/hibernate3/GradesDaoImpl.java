package org.weso.sor.domain.hibernate3;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.weso.sor.domain.GradesDao;
import org.weso.sor.model.Grade;

/**
 * 
 * @author bforester
 */
public class GradesDaoImpl extends HibernateDaoSupport implements GradesDao {
	
	@SuppressWarnings("unchecked")
	public List<Grade> loadGrades() {
		final HibernateTemplate hibernateTemplate = getHibernateTemplate();
		final SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		final Session session = sessionFactory.getCurrentSession();
		final Query gradeQuery = session.createQuery("from Grade order by gradeNumb");
		final List<Grade> grades = gradeQuery.list();
		return grades;
	}

	public Grade loadGrade(final Integer gradeNumber) {
		final HibernateTemplate hibernateTemplate = getHibernateTemplate();
		final SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(Grade.class);
		criteria.add(Restrictions.eq("gradeNumb", gradeNumber));
		final Grade grade = (Grade) criteria.uniqueResult();
		return grade;
	}

	public Grade loadGradeById(final Integer gradeId) {
		final HibernateTemplate hibernateTemplate = getHibernateTemplate();
		final SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(Grade.class);
		criteria.add(Restrictions.eq("gradeId", gradeId));
		final Grade grade = (Grade) criteria.uniqueResult();
		return grade;
	}
}
