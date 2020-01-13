package com.tabnine.eclipse.application.impl;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tabnine.eclipse.application.TabNineApplication;
import com.tabnine.eclipse.data.AutocompleteArgs;
import com.tabnine.eclipse.data.AutocompleteResponse;
import com.tabnine.eclipse.data.GetIdentifierRegexArgs;
import com.tabnine.eclipse.data.PrefetchArgs;
import com.tabnine.eclipse.data.TabNineApplicationCommand;
import com.tabnine.eclipse.data.TabNineApplicationRequest;
import com.tabnine.eclipse.data.TabNineApplicationRequestArguments;
import com.tabnine.eclipse.module.TabNineCoreRunner;
import com.tabnine.eclipse.module.impl.TabNineCoreRunnerBasicImpl;
import com.tabnine.eclipse.util.TabNineLangUtils;
import com.tabnine.eclipse.util.TabNineTextUtils;

/**
 * A basic implementation of {@link TabNineApplication}
 * @author ZhouYi
 * @version version
 * @date 2019-10-21 15:44:25
 * @description description
 */
public class TabNineApplicationBasicImpl implements TabNineApplication {

	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Variables] ===== ===== ===== ===== //

	
	// ===== ===== ===== ===== [Entry Method (For test only)] ===== ===== ===== ===== //
	
	public static void main(String[] args) {
		TabNineApplication application = new TabNineApplicationBasicImpl();
		AutocompleteArgs request = new AutocompleteArgs("Hello H", "", null, true, true, null);
		application.autocomplete(request);
		
	}
	
	// ===== ===== ===== ===== [Test Methods] ===== ===== ===== ===== //

	
	// ===== ===== ===== ===== [Instance Variables] ===== ===== ===== ===== //
	
	/** The runner to interact with TabNine Core : TabNineCoreRunner tabNineCoreRunner */
	private TabNineCoreRunner tabNineCoreRunner = new TabNineCoreRunnerBasicImpl();
	
	/** The version of current TabNine application : String tabNineVersion */
	private String tabNineVersion = null;
	
	/** The gson object used to render/parse JSON text : Gson gson */
	private Gson gson = new GsonBuilder()
			.disableHtmlEscaping()
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.create();
	
	// ===== ===== ===== ===== [Instance Methods] ===== ===== ===== ===== //
	
	/* (non-Javadoc)
	 * @see com.tabnine.eclipse.application.TabNineApplication#autocomplete(com.tabnine.eclipse.data.AutocompleteArgs)
	 * @param args
	 * @return
	 * @writer ZhouYi
	 * @date 2019-10-21 15:45:58
	 * @description description
	 */
	public AutocompleteResponse autocomplete(AutocompleteArgs args) {
		// STEP Number Render JSON text by args, then send it
		String response = this.tabNineCoreRunner.send(this.renderJson(args) + TabNineTextUtils.LINE_SEPARATOR, 1);
		
		// STEP Number Parse the response text and return
		return this.parseAutocompleteResponse(response);
		
	}

	/* (non-Javadoc)
	 * @see com.tabnine.eclipse.application.TabNineApplication#prefetch(com.tabnine.eclipse.data.PrefetchArgs)
	 * @param args
	 * @writer ZhouYi
	 * @date 2019-10-21 15:46:00
	 * @description description
	 */
	public void prefetch(PrefetchArgs args) {
		// STEP Number Render JSON text by args, then send it
		this.tabNineCoreRunner.send(this.renderJson(args) + TabNineTextUtils.LINE_SEPARATOR, 0);
		
	}

	/* (non-Javadoc)
	 * @see com.tabnine.eclipse.application.TabNineApplication#getIdentifierRegex(com.tabnine.eclipse.data.GetIdentifierRegexArgs)
	 * @param args
	 * @return
	 * @writer ZhouYi
	 * @date 2019-10-21 15:46:01
	 * @description description
	 */
	public String getIdentifierRegex(GetIdentifierRegexArgs args) {
		// STEP Number Render JSON text by args, then send it, return the result got
		return this.tabNineCoreRunner.send(this.renderJson(args) + TabNineTextUtils.LINE_SEPARATOR, 1);
		
	}
	
	// ===== ===== ===== ===== [Instance Utility Methods - Utility] ===== ===== ===== ===== //
	
	/**
	 * Get the version of current TabNine application
	 * @return tabNineVersion The version string of this TabNine application
	 * @author ZhouYi
	 * @date 2019-11-07 17:19:11
	 * @description description
	 * @note note
	 */
	protected String getTabNineVersion() {
		// STEP Number If the version data is null, load it
		if (TabNineLangUtils.isBlank(this.tabNineVersion)) {
			this.tabNineVersion = this.tabNineCoreRunner.getTabNineCore().getVersion();
			
		}
		
		// STEP Number Return the version
		return this.tabNineVersion;
		
	}
	
	/**
	 * Render JSON text that will be send to TabNine according to the incoming parameters
	 * @param request The request parameters send to TabNine
	 * @return json The text rendered
	 * @author ZhouYi
	 * @date 2019-11-07 17:38:34
	 * @description description
	 * @note note
	 */
	protected String renderJson(TabNineApplicationRequestArguments arguments) {
		// STEP Number Get version
		String version = this.getTabNineVersion();
		
		// STEP Number Wrap request object and command message object
		TabNineApplicationRequest request = new TabNineApplicationRequest();
		TabNineApplicationCommand command = new TabNineApplicationCommand(version, request);
		
		// STEP Number Judge arguments type, set different variables
		if (arguments instanceof AutocompleteArgs) {
			request.setAutocompleteArgs((AutocompleteArgs) arguments);
			
		} else if (arguments instanceof PrefetchArgs) {
			request.setPrefetchArgs((PrefetchArgs) arguments);
			
		} else if (arguments instanceof GetIdentifierRegexArgs) {
			request.setGetIdentifierRegexArgs((GetIdentifierRegexArgs) arguments);
			
		}
		
		// STEP Number Render JSON text and return
		return this.gson.toJson(command);
		
	}
	
	/**
	 * Parse JSON text conform to the structure of {@link AutocompleteResponse}, and then return parsing result 
	 * @param json The json text to be parsed
	 * @return response The {@link AutocompleteResponse} parsed
	 * @author ZhouYi
	 * @date 2019-11-07 17:40:28
	 * @description description
	 * @note note
	 */
	protected AutocompleteResponse parseAutocompleteResponse(String json) {
		// STEP Number Validate incoming parameters
		if (TabNineLangUtils.isBlank(json)) {
			return null;
			
		}
		
		return this.gson.fromJson(json, AutocompleteResponse.class);
		
	}
	
	// ===== ===== ===== ===== [Static Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Constructors] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Factory Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Getters & Setters] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
}
