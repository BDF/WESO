package org.weso.sor.domain.hibernate3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.weso.sor.domain.VolunteerActivitiesDao;
import org.weso.sor.model.VolunteerActivities;

public class VolunteerActivitiesDaoImpl extends HibernateDaoSupport implements
		VolunteerActivitiesDao  {

	@SuppressWarnings("unchecked")
	public List<VolunteerActivities> loadVolunteerActivities() {
		final HibernateTemplate hibernateTemplate = getHibernateTemplate();
		final SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		final Session session = sessionFactory.getCurrentSession();
		final Query query = session.createQuery("from VolunteerActivities");
		final List<VolunteerActivities> vAs = (List<VolunteerActivities>) query.list();
		return vAs;
	}

	public Map<String, VolunteerActivities> loadNameToVolunteerActivities() {
		final List<VolunteerActivities> vas = loadVolunteerActivities();
		final Map<String, VolunteerActivities> nameToVa = new HashMap<String, VolunteerActivities>(vas.size() + 5);
		
		for (VolunteerActivities volunteerActivities : vas) {
			nameToVa.put(volunteerActivities.getName(), volunteerActivities);
		}
		
		return nameToVa;
	}

}
