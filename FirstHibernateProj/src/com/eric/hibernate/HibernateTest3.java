package com.eric.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eric.javabrains.dto2.User2;
import com.eric.javabrains.dto2.Vehicle2;
import com.eric.javabrains.dto2.FourWheeler;
import com.eric.javabrains.dto2.TwoWheeler;

public class HibernateTest3 {

	public static void main(String[] args) {

		Vehicle2 vehicle = new Vehicle2();
		vehicle.setVehicleName("Car");

		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike steering handle");

		FourWheeler car = new FourWheeler();
		car.setVehicleName("BMW");
		car.setSteeringWheel("Car steering wheel");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);

		session.getTransaction().commit();
		session.close();

	}

}
