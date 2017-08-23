package org.weso.sor.domain.hibernate3;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.weso.sor.domain.TeacherDao;
import org.weso.sor.model.Grade;
import org.weso.sor.model.Teacher;

/**
 * 
 * @author bforester
 */
public class TeacherDaoImpl extends HibernateDaoSupport implements TeacherDao {

	@SuppressWarnings("unchecked")
	
	public List<Teacher> getTeachers() {
		final HibernateTemplate hibernateTemplate = getHibernateTemplate();
		final SessionFactory sessionFactory = hibernateTemplate
				.getSessionFactory();
		final Session session = sessionFactory.getCurrentSession();

		final Query teacherQuery = session
				.createQuery("from Teacher order by teacherName");
		final List<Teacher> teachers = teacherQuery.list();
		return teachers;
	}

	@SuppressWarnings("unchecked")
	public List<Teacher> getTeachers(final Grade grade) {
		final HibernateTemplate hibernateTemplate = getHibernateTemplate();
		final SessionFactory sessionFactory = hibernateTemplate
				.getSessionFactory();
		final Session session = sessionFactory.getCurrentSession();

		final SQLQuery query = session
				.createSQLQuery("select * from teacher where teacher_id in "
						+ "	(select ttg_teacher_id from teacher_To_Grade where ttg_grade_id = "
						+ "	(select grade_id from grade where grade_numb=:grade)) "
						+ "	order by teacher_name");
		query.addEntity(Teacher.class);
		query.setInteger("grade", grade.getGradeNumb());
		final List<Teacher> teachers = query.list();
		return teachers;
	}
	
	public Teacher find(final String teacherName) {
		final HibernateTemplate hibernateTemplate = getHibernateTemplate();
		final SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		final Session session = sessionFactory.getCurrentSession();
		final Criteria crit = session.createCriteria(Teacher.class);
		crit.add(Restrictions.eq("teacherName", teacherName ));
		
		final Teacher teacher = (Teacher) crit.uniqueResult();
		return teacher;
	}
	
	public Teacher loadTeacher(final Integer teacherId) {
		final HibernateTemplate hibernateTemplate = getHibernateTemplate();
		final SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		final Session session = sessionFactory.getCurrentSession();
		final Criteria crit = session.createCriteria(Teacher.class);
		crit.add(Restrictions.eq("teacherId", teacherId));
		final Teacher teacher = (Teacher) crit.uniqueResult();
		return teacher;
	}

	@SuppressWarnings("unchecked")
	public List<Teacher> getTeachers(Integer gradeId) {
		final HibernateTemplate hibernateTemplate = getHibernateTemplate();
		final SessionFactory sessionFactory = hibernateTemplate
				.getSessionFactory();
		final Session session = sessionFactory.getCurrentSession();

		final SQLQuery query = session
				.createSQLQuery("select * from teacher where teacher_id in "
						+ "	(select ttg_teacher_id from teacher_To_Grade where ttg_grade_id = "
						+ "	(select grade_id from grade where grade_id=:grade)) "
						+ "	order by teacher_name");
		query.addEntity(Teacher.class);
		query.setInteger("grade", gradeId);
		final List<Teacher> teachers = query.list();
		return teachers;
	}

}
