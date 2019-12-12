package testHIbernate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SuperHeroRepository2Test {


	private SessionFactory sessionFactory;

	private Session session;

	@BeforeEach

	public void before() {

		sessionFactory = createSessionFactory();

		session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

	}

	@Test

	public void returnsHerosWithMatchingType() {

		SuperPowerType powerType = createSuperPowerType();

		session.save(powerType);

		SuperPower superpower = createSuperPower(powerType);

		session.save(superpower);

		SuperHero hero = createSuperHero(superpower);

		session.save(hero);

		SuperHeroRepository heroRepository = new SuperHeroRepository(session);

		List heroes = heroRepository.loadBy(superpower);

		assertNotNull(heroes);

		assertEquals(1, heroes.size());

	}

	private SessionFactory createSessionFactory() {

		Configuration configuration = new Configuration();

		configuration.addAnnotatedClass(SuperHero.class)

				.addAnnotatedClass(SuperPower.class)

				.addAnnotatedClass(SuperPowerType.class);

		configuration.setProperty("hibernate.dialect",

				"org.hibernate.dialect.H2Dialect");

		configuration.setProperty("hibernate.connection.driver_class",

				"org.h2.Driver");

		configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem:test");

		configuration.setProperty("hibernate.hbm2ddl.auto", "create");

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		return sessionFactory;

	}

	private SuperHero createSuperHero(SuperPower superpower) {

		SuperHero hero = new SuperHero();

		hero.name = "Name";

		hero.power = superpower;

		hero.weakness = "None";

		hero.secretIdentity = "Mr. Jones";

		return hero;

	}

	private SuperPower createSuperPower(SuperPowerType powerType) {

		SuperPower superpower = new SuperPower();

		superpower.name = "SuperPower";

		superpower.description = "Description";

		superpower.type = powerType;

		return superpower;

	}

	private SuperPowerType createSuperPowerType() {

		SuperPowerType powerType = new SuperPowerType();

		powerType.name = "TheType";

		powerType.description = "12345678901234567890aDescription";

		return powerType;

	}

}
