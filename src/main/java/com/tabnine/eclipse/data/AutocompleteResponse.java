package com.tabnine.eclipse.data;

import java.util.List;

/**
 * The response for auto-complete request returned by TabNine Core
 * @author ZhouYi
 * @date 2019-11-07 16:20:10
 * @description description
 * @note note
 */
public class AutocompleteResponse implements TabNineApplicationResponse {

	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Variables] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Entry Method (For test only)] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Test Methods] ===== ===== ===== ===== //

	
	// ===== ===== ===== ===== [Instance Variables] ===== ===== ===== ===== //
	
	/** The old prefix before current cursor : String oldPrefix
	 * @note This old prefix is included in the old "before" text of {@link AutocompleteArgs} and may be shorter than it 
	 */
	private String oldPrefix;
	
	/** The results of completion proposal computed by TabNine Core : List<ResultEntry> results */
	private List<ResultEntry> results;
	
	/** The user message that should be displayed to user, lined text : List<String> userMessage */
	private List<String> userMessage;
	
	// ===== ===== ===== ===== [Instance Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Instance Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Constructors] ===== ===== ===== ===== //

	/**
	 * The empty constructor of {@link AutocompleteResponse}
	 * @author ZhouYi
	 * @date 2019-11-07 16:31:01
	 * @constructorSerial 00
	 * @description description
	 */
	public AutocompleteResponse() {
		super();
	}
	
	/**
	 * The full constructor of {@link AutocompleteResponse}
	 * @param oldPrefix {@link #oldPrefix}
	 * @param results {@link #results}
	 * @param userMessage {@link #userMessage}
	 * @author ZhouYi
	 * @date 2019-11-07 16:30:59
	 * @constructorSerial 01
	 * @description description
	 */
	public AutocompleteResponse(String oldPrefix, List<ResultEntry> results, List<String> userMessage) {
		super();
		this.oldPrefix = oldPrefix;
		this.results = results;
		this.userMessage = userMessage;
	}
	
	// ===== ===== ===== ===== [Static Factory Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Getters & Setters] ===== ===== ===== ===== //

	public String getOldPrefix() {
		return oldPrefix;
	}

	public void setOldPrefix(String oldPrefix) {
		this.oldPrefix = oldPrefix;
	}

	public List<ResultEntry> getResults() {
		return results;
	}

	public void setResults(List<ResultEntry> results) {
		this.results = results;
	}

	public List<String> getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(List<String> userMessage) {
		this.userMessage = userMessage;
	}
	
	// ===== ===== ===== ===== [Standard Method] ===== ===== ===== ===== //
	
	@Override
	public String toString() {
		return "AutocompleteResponse [oldPrefix=" + oldPrefix + ", results=" + results + ", userMessage=" + userMessage
				+ "]";
	}
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
}
