/**
 * ApplicationContext.java
 */
package team.uninter.mordorq;

import java.util.*;
/**
 * Provides a simple naming service for the whole application: 
 * objects can be registered and looked up according to their names registered
 * in the <code>ApplicationContext</code>.
 * 
 * @author Imre Szekeres
 * @version "%I%, %G%"
 */
public class ApplicationContext {

	private static final Map< String,Object > OBJECT_STORE = new java.util.HashMap<String, Object>();
	
	/**
	 * Looks up the context for an object registered in a given name and returns
	 * with the result.
	 * 
	 * @param name to which the object was binded to.
	 * @return the object corresponding to the name parameter or null, if there was no such object.
	 * */
	public static final Object lookup(String name){
		return OBJECT_STORE.get(name);
	}
	
	/**
	 * Binds the given object to the given name through which this object can be looked up
	 * later on.
	 * 
	 * @param name which binds the given object.
	 * @param object which will correspond to the given name.
	 * @return the previous value associated with the name.
	 * */
	public static final Object bind(String name, Object object){
		return OBJECT_STORE.put(name, object);
	}
}
