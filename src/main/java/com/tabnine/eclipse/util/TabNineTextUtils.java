package com.tabnine.eclipse.util;

import java.util.List;

/**
 * The TextUtils(Includes string manipulation, encode/decode, etc.) used in this project (The "TabNine" prefix is just for distinguishing)
 * @author ZhouYi
 * @date 2019-11-08 10:37:54
 * @description description
 * @note note
 */
public class TabNineTextUtils {

	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	/** The line separator in current JVM : String LINE_SEPARATOR */
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	/** The {@code <br>} element of HTML : String HTML_BREAK_ELEMENT */
	public static final String HTML_BREAK_ELEMENT = "<br>";
	
	/** A constant refer to empty text : String EMPTY_TEXT */
	public static final String EMPTY_TEXT = "";
	
	// ===== ===== ===== ===== [Static Variables] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Entry Method (For test only)] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Test Methods] ===== ===== ===== ===== //

	
	// ===== ===== ===== ===== [Instance Variables] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Instance Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Instance Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Utility Methods - Utility] ===== ===== ===== ===== //
	
	/**
	 * To judge if the char sequence is blank
	 * @param charSequence The charSequence
	 * @return isBlank Judgment result
	 * @author ZhouYi
	 * @date 2019-12-01 17:31:23
	 * @description description
	 * @note note
	 */
	public static boolean isBlank(CharSequence charSequence) {
		return (charSequence == null) ? true : charSequence.toString().trim().equals(EMPTY_TEXT);
		
	}
	
	/**
	 * To judge if the char sequence is not blank
	 * @param charSequence The charSequence
	 * @return isNotBlank Judgment result
	 * @author ZhouYi
	 * @date 2019-12-01 17:31:25
	 * @description description
	 * @note note
	 */
	public static boolean isNotBlank(CharSequence charSequence) {
		return !isBlank(charSequence);
		
	}

	/**
	 * Get the length of char sequence object safely (no error thrown)
	 * @param charSequence The char sequence object
	 * @return length The length got
	 * @author ZhouYi
	 * @date 2019-12-01 18:20:04
	 * @description description
	 * @note note
	 */
	public static int safelyGetLength(CharSequence charSequence) {
		return (charSequence == null) ? 0 : charSequence.length();
		
	}
	
	/**
	 * Join the multirow text list as a single string
	 * @param textList The text list, each item is a single line
	 * @param separator The separator word added between lines, default to be {@link #LINE_SEPARATOR}
	 * @return result The text result
	 * @author ZhouYi
	 * @date 2019-12-01 17:03:42
	 * @description description
	 * @note note
	 */
	public static String join(List<? extends CharSequence> textList, String separator) {
		// STEP Number Validate incoming parameters
		if (textList == null) {
			return null;
			
		} else  if (textList.isEmpty()) {
			return "";
			
		}
		if (separator == null) {
			separator = LINE_SEPARATOR;
			
		}
		
		// STEP Number Declare string builder
		StringBuilder builder = new StringBuilder(textList.get(0));
		
		// STEP Number Concatenate text circularly
		for (int i = 1, length = textList.size(); i < length; i++) {
			builder.append(separator).append(textList.get(i));
			
		}
		
		// STEP Number Return the result
		return builder.toString();
		
	}
	
	// ===== ===== ===== ===== [Constructors] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Factory Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Getters & Setters] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
}
