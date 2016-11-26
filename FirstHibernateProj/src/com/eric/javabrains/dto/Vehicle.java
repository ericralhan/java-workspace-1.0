package com.eric.javabrains.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {

	@Id
	@GeneratedValue
	@Column(name = "VEHICLE_ID")
	private int vehicleId;
	@Column(name = "VEHICLE_NAME")
	private String vehicleName;
	// @ManyToOne
	// @JoinColumn(name="USER_ID")
	// private User2 user;
	@ManyToMany(mappedBy="vehicle")
	private Collection<User> userList = new ArrayList();

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Collection<User> getUserList() {
		return userList;
	}

	public void setUserList(Collection<User> userList) {
		this.userList = userList;
	}


}
