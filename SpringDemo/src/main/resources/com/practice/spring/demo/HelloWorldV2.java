package com.practice.spring.demo;
/**
 * Spring bean
 *
 */
public class HelloWorldV2 implements HW
{
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public void printHello() 
	{
		System.out.println("Hello ! Eric I am version 2" + name);
	}
}