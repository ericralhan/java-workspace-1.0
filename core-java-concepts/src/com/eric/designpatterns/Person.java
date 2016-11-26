package com.eric.designpatterns;

public class Person
{
	private String firstName; // required
	private String lastName; // required
	private int age; // optional
	private String phone; // optional
	private String address; // optional

	public Person(String firstName, String lastName, int age, String phone, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public static class PersonBuilder
	{
		private String firstName; // required
		private String lastName; // required
		private int age; // optional
		private String phone; // optional
		private String address; // optional
		
		public PersonBuilder() {
			super();
		}
		public PersonBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		public PersonBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		public PersonBuilder age(int age) {
			this.age = age;
			return this;
		}
		public PersonBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}
		public PersonBuilder address(String address) {
			this.address = address;
			return this;
		}
		
		public Person build()
		{
			return new Person(firstName, lastName, age, phone, address);
		}
	}
	
	public static void main(String []args) 
	{
		Person person = new Person.PersonBuilder().firstName("Vikas").lastName("Dewan").build();
		System.out.println(person.getLastName());
	}
}
