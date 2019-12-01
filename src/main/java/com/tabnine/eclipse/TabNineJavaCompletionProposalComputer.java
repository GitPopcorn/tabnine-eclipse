package com.tabnine.eclipse;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposalComputer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import com.tabnine.eclipse.application.TabNineApplication;
import com.tabnine.eclipse.application.impl.TabNineApplicationBasicImpl;
import com.tabnine.eclipse.data.AutocompleteArgs;
import com.tabnine.eclipse.data.AutocompleteResponse;
import com.tabnine.eclipse.util.TabNineDocumentUtils;

public class TabNineJavaCompletionProposalComputer implements IJavaCompletionProposalComputer {

	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	/** The option for text range of computation : int COMPUTE_RANGE_OPTION */
	public static final int OPTION_COMPUTE_RANGE = TabNineDocumentUtils.FROM_LINES;
	
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
		AutocompleteArgs autocompleteArgs = TabNineDocumentUtils.extractAutocompleteArgs(context, OPTION_COMPUTE_RANGE, null);
		
		// STEP Number Check the result has got
		if (autocompleteArgs == null) {
			System.out.println("The autocomplete argument object is null."); // STUB Number Text
			return null;
			
		}
		
		// TEST Number Text
		System.out.println("TET-01");
		System.out.println(context.getViewer().getSelectionProvider().getSelection().getClass().getCanonicalName());
		
		// TEST Number Text
		System.out.println("TET-02");
		System.out.println(getPathOfCurrentlyEditingFile());
		
		// TEST Number Text
		System.out.println("TEST-03");
		System.out.println(autocompleteArgs);
		
		// STEP Number Complete other settings
		autocompleteArgs.setFilename(getPathOfCurrentlyEditingFile());
		autocompleteArgs.setMaxNumResults(OPTION_MAX_NUM_RESULTS);
		
		// STEP Number Send request
		AutocompleteResponse response = tabNineApplication.autocomplete(autocompleteArgs);
		
		// TEST Number Text
		System.out.println("TEST-04");
		System.out.println(response);
		
		// STEP Number Generate proposals using the context and response, then return it
		return TabNineDocumentUtils.generateCompletionProposal(context, response, OPTION_COMPUTE_RANGE);
		
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
	
	/**
	 * Get the path of file which is currently edited
	 * @return path The path text got
	 * @author ZhouYi
	 * @date 2019-11-30 19:32:11
	 * @description description
	 * @note note
	 */
	public static String getPathOfCurrentlyEditingFile() {
		// STEP Number Get active editor and check
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (activeEditor == null) {
			return null;
			
		}
		
		// STEP Number Try to get the editor input
		IEditorInput editorInput = activeEditor.getEditorInput();
		
		// TEST Number Text
		System.out.println("TEST-07");
		System.out.println(editorInput.getClass().getCanonicalName());
		
		// STEP Number Get file and check
		IFile file = editorInput.getAdapter(IFile.class);
		if (file == null) {
			return null;
			
		}
		
		// STEP Number Get the file path and return
		return file.getRawLocation().toOSString();
		
	}
	
	// ===== ===== ===== ===== [Constructors] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Factory Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Getters & Setters] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
}
