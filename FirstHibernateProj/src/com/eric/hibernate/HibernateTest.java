package com.eric.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eric.javabrains.dto.Address;
import com.eric.javabrains.dto.AdvancedUserDetails;
import com.eric.javabrains.dto.UserDetails;
import com.eric.javabrains.dto.UserDetailsCollection;
import com.eric.javabrains.dto.UserDetailsProxy;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		UserDetails user2 = new UserDetails();

		AdvancedUserDetails advUser = new AdvancedUserDetails();

		user.setUserName("First User2");
		user2.setUserName("Second User2");

		Address addr = new Address();
		addr.setStreet("Home Address Street");
		addr.setCity("Home Address City");

		user.setHomeAddress(addr);

		Address addr2 = new Address();
		addr2.setStreet("Office Address Street");
		addr2.setCity("Office Address City");

		user.setOfficeAddress(addr2);

		advUser.setUserId(1);
		advUser.setUserName("First Adv User2");
		advUser.setAddress("First Adv User2 Address");
		advUser.setJoinedDate(new Date());
		advUser.setDescription("First Adv User2 Description");

		UserDetailsCollection userCol1 = new UserDetailsCollection();

		userCol1.setUserName("User2 name of Collection Object");

		Address addrCol1 = new Address();
		addrCol1.setStreet("Street 1 of Collection Object");
		addrCol1.setCity("City 1 of Collection Object");
		addrCol1.setState("State 1 of Collection Object");
		addrCol1.setPincode("3072");

		Address addrCol2 = new Address();
		addrCol2.setStreet("Street 2 of Collection Object");
		addrCol2.setCity("City 2 of Collection Object");
		addrCol2.setState("State 2 of Collection Object");
		addrCol2.setPincode("3125");

		userCol1.getListOfAddresses().add(addrCol1);
		userCol1.getListOfAddresses().add(addrCol2);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.save(user);
		session.save(user2);

		session.save(advUser);

		session.save(userCol1);

		session.getTransaction().commit();
		session.close();

		user = null;

		session = sessionFactory.openSession();
		session.beginTransaction();

		user = (UserDetails) session.get(UserDetails.class, 2);

		System.out.println("User2 Name retrieved is " + user.getUserName());

		UserDetailsProxy userProx = new UserDetailsProxy();

		userProx.setUserName("User2 name of Proxy Object");

		Address addrProx1 = new Address();
		addrProx1.setStreet("Street 1 of Proxy Object");
		addrProx1.setCity("City 1 of Proxy Object");
		addrProx1.setState("State 1 of Proxy Object");
		addrProx1.setPincode("3072");

		userProx.getListOfAddresses().add(addrProx1);

		session.save(userProx);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();

		userProx = null;
		userProx = (UserDetailsProxy) session.get(UserDetailsProxy.class, 1);
		session.close();
		System.out.println("size of list of addresses is " + userProx.getListOfAddresses().size());

	}

}
