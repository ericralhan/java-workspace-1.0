package com.eric.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eric.javabrains.dto.User;
import com.eric.javabrains.dto.Vehicle;

public class HibernateTest2 {

	public static void main(String[] args) {

		User user = new User();
		user.setUserName("Car User2");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");

		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		/*vehicle.getUserList().add(user);
		vehicle2.getUserList().add(user);*/

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		/*session.save(user);
		session.save(vehicle);
		session.save(vehicle2);*/

		session.persist(user);
		session.getTransaction().commit();
		session.close();

	}

}
