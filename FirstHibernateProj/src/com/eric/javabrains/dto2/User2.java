package com.eric.javabrains.dto2;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_1")
public class User2 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;

	// @OneToMany(mappedBy="user")
	// @JoinTable(name = "USER_VEHICLE", joinColumns = @JoinColumn(name =
	// "USER_ID"), inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
	//@ManyToMany
	@OneToMany(cascade=CascadeType.PERSIST)
	private Collection<Vehicle2> vehicle = new ArrayList<Vehicle2>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Collection<Vehicle2> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<Vehicle2> vehicle) {
		this.vehicle = vehicle;
	}

}
