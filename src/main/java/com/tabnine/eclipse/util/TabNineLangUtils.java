package com.tabnine.eclipse.util;

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
	
	
	// ===== ===== ===== ===== [Static Utility Methods - Utility] ===== ===== ===== ===== //
	
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
	
	// ===== ===== ===== ===== [Constructors] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Factory Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Getters & Setters] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
}
