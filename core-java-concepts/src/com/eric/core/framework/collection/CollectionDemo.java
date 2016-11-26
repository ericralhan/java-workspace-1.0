/**
 * 
 */
package com.eric.core.framework.collection;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Eric
 *
 */
public class CollectionDemo {

	/**
	 * Synchronized Collections 
	 */
	public void synchronizedCollections() {

		Map myMap = new ConcurrentHashMap<>();
		Queue myList = new ConcurrentLinkedQueue<>();
  
	}

}
