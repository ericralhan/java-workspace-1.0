/**
 * 
 */
package com.eric.core.concept.overload;

/**
 * Class to demonstrate overloaded method rules
 * 
 * @author Eric
 */
public class OverloadedMethods {

	/**
	 * Overloaded method
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public Integer sum(Integer a, Integer b) {
		return a + b;
	}

	/**
	 * Overloading method - Valid.
	 * 
	 * Rule 1: Method signature should change. Method signature is made of
	 * number of arguments, type of arguments and order of arguments.
	 * 
	 * <b>Return Type and Exception List are not part of method signature.</b>
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public Integer sum(Float a, Integer b) {
		// Valid
		return null;
	}

	/**
	 * Overloading method - Invalid.
	 * 
	 * Rule 2: Just changing the return type is not enough
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	/*public Float sum(Integer a, Integer b) {
		// Not valid; Compile time error
		return null;
	}*/

	/**
	 * Overloading method - Invalid.
	 * 
	 * Rule 3: Just throwing one or different exceptions is not enough
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	/*public Integer sum(Integer a, Integer b) throws Exception {
		// Not valid; Compile time error
		return null;
	}*/

}
