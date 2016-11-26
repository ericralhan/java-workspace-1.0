/**
 * 
 */
package com.eric.core.concept.override;

import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 * Super Class which will have a overridden method. The sub class will override
 * this method
 * 
 * @author Eric
 *
 */
public class SuperClass {

	/**
	 * Overridden method
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public Number sum(Integer a, Integer b) throws FileNotFoundException, SQLException{
		return a + b;
	}

	/**
	 * Rule 3: private, static and final methods can not be overridden for below
	 * reasons.
	 * 
	 * Private Methods - have no visibility in the subclass.
	 * 
	 * Subclasses cannot override private method
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private Number sumPrivate(Integer a, Integer b) {
		return a + b;
	}

	/**
	 * Rule 3: private, static and final methods can not be overridden for below
	 * reasons.
	 * 
	 * Static Methods - are per class methods. Subclasses are not allowed to
	 * change their implementation.
	 * 
	 * Subclasses cannot override static method
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static Number sumStatic(Integer a, Integer b) {
		return a + b;
	}

	/**
	 * Rule 3: private, static and final methods can not be overridden for below
	 * reasons.
	 * 
	 * Final Methods - These methods are final and cannot be changed in
	 * subclasses.
	 * 
	 * Subclasses cannot override final method
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public final Number sumFinal(Integer a, Integer b) {
		return a + b;
	}


	/**
	 * Overridden method which throws exception
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws FileNotFoundException
	 */
	public Integer sumException(Integer a, Integer b) throws FileNotFoundException {
		return a + b;
	}

	/**
	 * Overridden method which is Protected
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	protected Integer sumProtected(Integer a, Integer b) {
		return a + b;
	}

	
}
