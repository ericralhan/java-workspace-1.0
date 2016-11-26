package com.eric.javabrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		// Triangle triangle = (Triangle) context.getBean("triangle");

		// AdvancedTriangle triangle = (AdvancedTriangle)
		// context.getBean("advTriangle");

		// TriangleUsingList triangle = (TriangleUsingList)
		// context.getBean("triangleUsingList");

		// AdvancedTriangleAutoWired triangle =
		// (AdvancedTriangleAutoWired)context.getBean("advTriangleAutoWired");

		AdvancedTriangle triangle = (AdvancedTriangle) context.getBean("childTriangle");

		triangle.draw();

	}

}
