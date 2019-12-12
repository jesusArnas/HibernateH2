package testHIbernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class SuperHeroRepository {

	private Session session;
	
	public SuperHeroRepository(Session session) {
		this.session = session;
	}

	public List loadBy(SuperPower superpower) {
		Criteria criteria = session.createCriteria(SuperHero.class);
		return criteria.list();
	}

}
