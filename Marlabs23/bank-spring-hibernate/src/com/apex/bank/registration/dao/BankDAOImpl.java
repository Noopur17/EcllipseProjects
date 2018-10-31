package com.apex.bank.registration.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.apex.bank.registration.vo.BankVO;

@Repository
public class BankDAOImpl implements BankDAO {

	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure("resources/hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Integer addBankInfo(BankVO bvo) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(bvo);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + bvo.toString());
		
		return bvo.getId();

	}

	


}
