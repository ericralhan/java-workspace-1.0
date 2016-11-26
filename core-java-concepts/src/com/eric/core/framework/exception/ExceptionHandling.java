/**
 * 
 */
package com.eric.core.framework.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class demonstrates the exception framework and handling
 * 
 * @author Eric
 */
public class ExceptionHandling {

	/**
	 * To open whole hierarchy of the Exception and RuntimeException class,
	 * press Ctrl+T when your cursor is on the class name
	 * 
	 * @param args
	 * @throws ClassCastException
	 * @throws NoClassDefFoundError
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public void exceptionHierarchy(int args) throws IOException, FileNotFoundException, ClassCastException,
			NoClassDefFoundError, RuntimeException, Exception {

	}

	/**
	 * FileNotFoundException is a Compile Time Exception, hence we need to
	 * declare it in throws. Compile Time Exceptions are also called Checked
	 * Exceptions
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public void compileTimeExceptionDemo(int args) throws FileNotFoundException {

		boolean boolVar = false;
		if (boolVar)
			throw new FileNotFoundException();
	}

	/**
	 * ClassCastException is a Runtime Exception, hence no need to declare in
	 * throws. Runtime Exceptions are also called Unchecked Exceptions
	 * 
	 * @param args
	 */
	public void runTimeExceptionDemo(int args) {

		boolean boolVar = false;
		if (boolVar)
			throw new ClassCastException();
	}

}
