package com.tabnine.eclipse.data;

import com.google.gson.annotations.SerializedName;

/**
 * The request send to TabNine Core
 * @author ZhouYi
 * @date 2019-11-07 16:49:05
 * @description description
 * @note note
 */
public class TabNineApplicationRequest {
	
	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Variables] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Entry Method (For test only)] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Test Methods] ===== ===== ===== ===== //

	
	// ===== ===== ===== ===== [Instance Variables] ===== ===== ===== ===== //
	
	/** The {@link AutocompleteArgs} contained in this request : AutocompleteArgs autocompleteArgs */
	@SerializedName("Autocomplete")
	private AutocompleteArgs autocompleteArgs;
	
	/** The {@link PrefetchArgs} contained in this request : PrefetchArgs prefetchArgs */
	@SerializedName("Prefetch")
	private PrefetchArgs prefetchArgs;
	
	/** The {@link GetIdentifierRegexArgs} contained in this request : GetIdentifierRegexArgs getIdentifierRegexArgs */
	@SerializedName("GetIdentifierRegex")
	private GetIdentifierRegexArgs getIdentifierRegexArgs;
	
	// ===== ===== ===== ===== [Instance Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Instance Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Constructors] ===== ===== ===== ===== //
	
	/**
	 * The empty constructor of {@link TabNineApplicationRequest}
	 * @author ZhouYi
	 * @date 2019-11-08 13:51:45
	 * @constructorSerial 00
	 * @description description
	 */
	public TabNineApplicationRequest() {
		super();
	}
	
	/**
	 * The full constructor of {@link TabNineApplicationRequest}
	 * @param autocompleteArgs {@link #autocompleteArgs}
	 * @param prefetchArgs {@link #prefetchArgs}
	 * @param getIdentifierRegexArgs {@link #getIdentifierRegexArgs}
	 * @author ZhouYi
	 * @date 2019-11-08 13:51:47
	 * @constructorSerial 01
	 * @description description
	 */
	public TabNineApplicationRequest(AutocompleteArgs autocompleteArgs, PrefetchArgs prefetchArgs,
			GetIdentifierRegexArgs getIdentifierRegexArgs) {
		super();
		this.autocompleteArgs = autocompleteArgs;
		this.prefetchArgs = prefetchArgs;
		this.getIdentifierRegexArgs = getIdentifierRegexArgs;
	}

	// ===== ===== ===== ===== [Static Factory Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Getters & Setters] ===== ===== ===== ===== //
	
	public AutocompleteArgs getAutocompleteArgs() {
		return autocompleteArgs;
	}

	public void setAutocompleteArgs(AutocompleteArgs autocompleteArgs) {
		this.autocompleteArgs = autocompleteArgs;
	}

	public PrefetchArgs getPrefetchArgs() {
		return prefetchArgs;
	}

	public void setPrefetchArgs(PrefetchArgs prefetchArgs) {
		this.prefetchArgs = prefetchArgs;
	}

	public GetIdentifierRegexArgs getGetIdentifierRegexArgs() {
		return getIdentifierRegexArgs;
	}

	public void setGetIdentifierRegexArgs(GetIdentifierRegexArgs getIdentifierRegexArgs) {
		this.getIdentifierRegexArgs = getIdentifierRegexArgs;
	}
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
}
