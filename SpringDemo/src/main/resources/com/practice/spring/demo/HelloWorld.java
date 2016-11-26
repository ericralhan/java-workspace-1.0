package com.practice.spring.demo;
/**
 * Spring bean
 *
 */
public class HelloWorld implements HW
{
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public void printHello() 
	{
		System.out.println("Hello ! " + name);
	}
}