package com.practice.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		obj.printHello();
		
		ByeWorld byeWorld = (ByeWorld) context.getBean("byeBean");
		byeWorld.getHelloWorld().printHello();
	}
}