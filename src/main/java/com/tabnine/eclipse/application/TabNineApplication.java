package com.tabnine.eclipse.application;

import com.tabnine.eclipse.data.AutocompleteArgs;
import com.tabnine.eclipse.data.AutocompleteResponse;
import com.tabnine.eclipse.data.GetIdentifierRegexArgs;
import com.tabnine.eclipse.data.PrefetchArgs;

/**
 * The Standard API of TabNine
 * @see https://github.com/zxqfl/TabNine/blob/master/HowToWriteAClient.md
 * @author ZhouYi
 * @version version
 * @date 2019-10-21 15:33:14
 * @description description
 */
public interface TabNineApplication {
	
	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	// ===== ===== ===== ===== [Basic API Methods] ===== ===== ===== ===== //
	
	/**
	 * To get the results of auto-complement computation with target arguments
	 * @param args The argument data using for this API
	 * @return response The response gived by TabNine core
	 * @author ZhouYi
	 * @since version
	 * @date 2019-10-21 15:34:31
	 * @description description
	 */
	public AutocompleteResponse autocomplete(AutocompleteArgs args);
	
	/**
	 * Add some texts or files to the index of TabNine core
	 * @param args The argument data using for this API
	 * @author ZhouYi
	 * @since version
	 * @date 2019-10-21 15:34:33
	 * @description You can use this API call to make TabNine add a file to its index even if the user hasn't requested completions in the file yet.
	 */
	public void prefetch(PrefetchArgs args);
	
	/**
	 * Get the regular expression mark that TabNine using to parse identifiers in target file
	 * @param args The argument data using for this API
	 * @return regex The related regex string
	 * @author ZhouYi
	 * @since version
	 * @date 2019-10-21 15:34:35
	 * @description This gives the regex used by TabNine to parse identifiers for the provided file.
	 */
	public String getIdentifierRegex(GetIdentifierRegexArgs args);
	
}
