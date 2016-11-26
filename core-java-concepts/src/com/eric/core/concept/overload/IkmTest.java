package com.eric.core.concept.overload;

public class IkmTest {

	private static int count;
	static{
		System.out.println("In block 1");
		count = 10;
	}

	private int[] data;
	
	{
		System.out.println("in block 2");
		data = new int[count];
		for (int i=0; i<count;i++) {
			data[i] = i;
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("count = " + count);
		
		System.out.println("before 1st call to new");
		
		IkmTest test1 = new IkmTest();
		
		System.out.println("before 2nd call to nw");
		
		IkmTest test2 = new IkmTest();
	}

}
