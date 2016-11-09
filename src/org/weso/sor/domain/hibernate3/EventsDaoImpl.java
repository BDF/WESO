package org.weso.sor.domain.hibernate3;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.weso.sor.domain.EventsDao;
import org.weso.sor.model.Events;

public class EventsDaoImpl extends HibernateDaoSupport implements EventsDao {
	
	@SuppressWarnings("unchecked")
	public List<Events> findEvents(int grade) {
		final Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		final Query query = session.createQuery("select etg.events from EventToGrade etg where etg.grade.gradeNumb = :grade");
		query.setInteger("grade", grade);
		final List<Events> events = query.list();		
		if (logger.isInfoEnabled()) {
			logger.info("Looked up events: " + events);
		}
		return events;
	}

	public Events findEventByName(String eventName) {
		final HibernateTemplate hibernateTemplate = getHibernateTemplate();
		final SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(Events.class);
		criteria.add(Restrictions.eq("eventName", eventName));
		final Events event = (Events) criteria.uniqueResult();
		return event;
	}

}
