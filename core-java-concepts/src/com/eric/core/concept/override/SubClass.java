/**
 * 
 */
package com.eric.core.concept.override;

import java.io.FileNotFoundException;
import java.sql.SQLTransientException;

/**
 * Sub Class will override the methods from SuperClass. It will demonstrate the
 * concepts of overriding.
 * 
 * @author Eric
 *
 */
public class SubClass extends SuperClass {

	/*
	 * This is Overriding method.
	 * 
	 * Rule 1: The method argument list in overridden and overriding methods
	 * must be exactly same.
	 * 
	 * Rule 2: The return type of overriding method can be child class of return
	 * type declared in overridden method. For eg. Below class's return type is
	 * Integer whereas the superclass return type is Number (superclass of
	 * Integer)
	 * 
	 * Rule 3: private, static and final methods can not be overridden for below
	 * reasons.
	 * 
	 * Private Methods - have no visibility in the subclass.
	 * 
	 * Static Methods - are per class methods. Subclasses are not allowed to
	 * change their implementation.
	 * 
	 * Final Methods - These methods are final and cannot be changed in
	 * subclasses.
	 * 
	 * Rule 4: If the overridding method doesn't throw any or few checked
	 * exceptions, it is fine.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.eric.core.concept.override.SuperClass#sum(java.lang.Integer,
	 * java.lang.Integer)
	 */
	public Integer sum(Integer a, Integer b) throws SQLTransientException {
		// Integer extends Number; so it's valid
		return a + b;
	}

	/*
	 * Rule 4: the overriding method in child class can throw
	 * FileNotFoundException; but it is not allowed to throw IOException or
	 * Exception
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eric.core.concept.override.SuperClass#sumException(java.lang.Integer,
	 * java.lang.Integer)
	 */
	/*public Integer sumException(Integer a, Integer b) throws IOException {
		// Not valid; Compile time error
		return a + b;
	}*/

	
	/*
	 * Rule 4: the overriding method in child class can throw
	 * FileNotFoundException; but it is not allowed to throw IOException or
	 * Exception
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eric.core.concept.override.SuperClass#sumException(java.lang.Integer,
	 * java.lang.Integer)
	 */
	public Integer sumException(Integer a, Integer b) throws FileNotFoundException {
		return a + b;
	}
	

	/*
	 * Rule 5: Overriding method can not reduce the access scope of overridden
	 * method.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eric.core.concept.override.SuperClass#sumPublic(java.lang.Integer,
	 * java.lang.Integer)
	 */
	public Integer sumProtected(Integer a, Integer b) {
		return a + b;
	}

}
