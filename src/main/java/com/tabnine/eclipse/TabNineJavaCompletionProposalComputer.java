package com.tabnine.eclipse;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposalComputer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;

import com.tabnine.eclipse.application.TabNineApplication;
import com.tabnine.eclipse.application.impl.TabNineApplicationBasicImpl;
import com.tabnine.eclipse.data.AutocompleteArgs;
import com.tabnine.eclipse.data.AutocompleteResponse;
import com.tabnine.eclipse.data.TabNineCompletionProposal;

public class TabNineJavaCompletionProposalComputer implements IJavaCompletionProposalComputer {

	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	/** The option for text range of computation : int COMPUTE_RANGE_OPTION */
	public static final int OPTION_COMPUTE_RANGE = AutocompleteArgs.FROM_LINES;
	
	/** The option for max results count getting from TabNine : int MAX_NUM_RESULTS */
	public static final int OPTION_MAX_NUM_RESULTS = 20;
	
	// ===== ===== ===== ===== [Static Variables] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Entry Method (For test only)] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Test Methods] ===== ===== ===== ===== //

	
	// ===== ===== ===== ===== [Instance Variables] ===== ===== ===== ===== //
	
	/** The application interface of TabNine : TabNineApplication tabNineApplication */
	private TabNineApplication tabNineApplication = new TabNineApplicationBasicImpl();
	
	// ===== ===== ===== ===== [Instance Methods] ===== ===== ===== ===== //
	
	@Override
	public List<ICompletionProposal> computeCompletionProposals(ContentAssistInvocationContext context,
			IProgressMonitor monitor) {
		// STEP Number Get the request from incoming context object
		AutocompleteArgs autocompleteArgs = AutocompleteArgs.fromContext(context, OPTION_COMPUTE_RANGE);
		
		// STEP Number Complete other settings
		autocompleteArgs.setMaxNumResults(OPTION_MAX_NUM_RESULTS);
		
		// STEP Number Send request
		AutocompleteResponse response = tabNineApplication.autocomplete(autocompleteArgs);
		
		// STEP Number Generate proposals using the context and response, then return it
		return TabNineCompletionProposal.fromAutocompleteResponse(response);
		
	}

	@Override
	public List<IContextInformation> computeContextInformation(ContentAssistInvocationContext context,
			IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sessionEnded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionStarted() {
		// TODO Auto-generated method stub
		
	}
	
	// ===== ===== ===== ===== [Basic API Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Instance Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Constructors] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Factory Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Getters & Setters] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
}
