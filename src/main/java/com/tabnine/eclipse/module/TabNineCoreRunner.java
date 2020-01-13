package com.tabnine.eclipse.module;

import com.tabnine.eclipse.data.TabNineCore;

public interface TabNineCoreRunner {
	
	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	

	// ===== ===== ===== ===== [Basic API Methods] ===== ===== ===== ===== //
	
	/**
	 * Start TabNine process
	 * @author ZhouYi
	 * @date 2019-11-01 14:11:46
	 * @description description
	 * @note note
	 */
	public void start();

	/**
	 * Send message to current TabNine process
	 * @param message The message to send
	 * @param responseLinesExpectation The expectation for line count of response text
	 *     <li>0: No response expected, this method will not handle the response</li>
	 *     <li>1: The process will respond with 1 line text, this method will receive only one line text</li>
	 *     <li>2: The process will respond with 2 line text, this method will receive two line text and then return</li>
	 *     <li>...</li>
	 * @return result The result text responded by process
	 * @author ZhouYi
	 * @date 2019-11-01 14:28:29
	 * @description description
	 * @note note
	 */
	public String send(String message, int responseLinesExpectation);

	/**
	 * Destroy current TabNine process
	 * @param forcibly Is the destroy operation forcible
	 * @author ZhouYi
	 * @date 2019-11-01 15:46:55
	 * @description description
	 * @note note
	 */
	public void destroy(boolean forcibly);

	/**
	 * Get the TabNine Core used by this runner
	 * @return tabNineCore The {@link TabNineCore} used by this runner
	 * @author ZhouYi
	 * @date 2019-11-07 17:13:10
	 * @description description
	 * @note note
	 */
	public TabNineCore getTabNineCore();
	
}