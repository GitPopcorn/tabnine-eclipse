package com.tabnine.eclipse.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/**
 * The LangUtils used in this project (The "TabNine" prefix is just for distinguishing)
 * @author ZhouYi
 * @version version
 * @date 2019年10月29日 15:27:42
 * @description description
 */
public class TabNineLangUtils {

	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	/** String constant - An empty string : Object EMPTY_STRING */
	public static final Object EMPTY_STRING = "";
	
	// ===== ===== ===== ===== [Static Variables] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Entry Method (For test only)] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Test Methods] ===== ===== ===== ===== //

	
	// ===== ===== ===== ===== [Instance Variables] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Instance Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Instance Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Utility Methods - Lang Utility] ===== ===== ===== ===== //
	
	/**
	 * Make a equality judgment with two nullable targets
	 * @param <T> The type of constrat object
	 * @param a Target a to be compared
	 * @param b Target b to be compared
	 * @return equals Are the two targets equal to each other, if both of them are null, return true
	 * @author ZhouYi
	 * @since version
	 * @date 2019年10月29日 15:30:02
	 * @description description
	 */
	public static <T> boolean equalsWithNull(T a, T b) {
		if (a == null) {
			return (b == null);
			
		} else {
			return a.equals(b);
			
		}
		
	}
	
	/**
	 * Get target object or default value if is null
	 * @param <T> The type of target object
	 * @param target The target object
	 * @param defaultValue The default value for target object
	 * @return result The result get by method
	 * @author ZhouYi
	 * @date 2019-11-08 13:26:39
	 * @description description
	 * @note note
	 */
	public static <T> T getTargetOrDefault(T target, T defaultValue) {
		return (target == null) ? defaultValue : target;
		
	}
	
	// ===== ===== ===== ===== [Static Utility Methods - String Utility] ===== ===== ===== ===== //
	
	/**
	 * Check if the {@link CharSequence} object is blank
	 * @param cs Target {@link CharSequence} object to check
	 * @return isBlank Judgment result: 
	 *     <li>null		: true</li>
	 *     <li>""		: true</li>
	 *     <li>" "		: true</li>
	 *     <li>"a"		: false</li>
	 *     <li>"a "		: false</li>
	 * @author ZhouYi
	 * @date 2019-10-29 下午 17:45:12
	 * @description description
	 * @note note
	 */
	public static boolean isBlank(CharSequence cs) {
		if (cs == null) {
			return true;
			
		} else {
			return cs.toString().trim().equals(EMPTY_STRING);
			
		}
		
	}
	
	// ===== ===== ===== ===== [Static Utility Methods - Container Utility] ===== ===== ===== ===== //
	
	/**
	 * To judge if the colletion object is null or empty
	 * @param collection The {@link Collection} object
	 * @return isEmpty Judgment result
	 * @author ZhouYi
	 * @date 2019-12-04 14:55:41
	 * @description description
	 * @note note
	 */
	public static boolean isEmpty(Collection<?> collection) {
		return (collection == null) || collection.isEmpty();
		
	}
	
	/**
	 * Cast the collection to array
	 * @param <T> The item type of collection
	 * @param collection The collection object
	 * @param type The class object of item type
	 * @return array The new array we got
	 * @author ZhouYi
	 * @date 2019-12-20 11:23:56
	 * @description description
	 * @note note
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] toArray(Collection<T> collection, Class<T> type) {
		// STEP Number Validate incoming parameters
		if ((collection == null) || (type == null)) {
			return null;
			
		}
		
		// STEP Number Create a new array with the type and initial size
		T[] array = (T[]) Array.newInstance(type, collection.size());
		
		// STEP Number If the collection is not empty, transfer the item inner
		if (!collection.isEmpty()) {
			int i = 0;
			Iterator<T> iterator = collection.iterator();
			while (iterator.hasNext()) {
				array[i] = iterator.next();
				i ++;
				
			}
			
		}
		
		// STEP Number Return the array result
		return array;
		
	} 
	
	// ===== ===== ===== ===== [Constructors] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Factory Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Getters & Setters] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
}
