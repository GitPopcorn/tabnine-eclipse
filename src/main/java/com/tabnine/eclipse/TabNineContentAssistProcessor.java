package com.tabnine.eclipse;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

import com.tabnine.eclipse.application.TabNineApplication;
import com.tabnine.eclipse.application.impl.TabNineApplicationBasicImpl;
import com.tabnine.eclipse.data.AutocompleteArgs;
import com.tabnine.eclipse.data.AutocompleteResponse;
import com.tabnine.eclipse.util.TabNineDocumentUtils;
import com.tabnine.eclipse.util.TabNineLangUtils;

/**
 * The content assist processor for Generic Editor with TabNine 
 * @author ZhouYi
 * @version version
 * @date 2019-10-21 14:56:58
 * @description description
 */
public class TabNineContentAssistProcessor implements IContentAssistProcessor {
	
	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	/** The option for text range of computation : int COMPUTE_RANGE_OPTION */
	public static final int OPTION_COMPUTE_RANGE = TabNineDocumentUtils.FROM_DOC;
	
	/** The option for max results count getting from TabNine : int MAX_NUM_RESULTS */
	public static final int OPTION_MAX_NUM_RESULTS = 20;

	// ===== ===== ===== ===== [Member Variables] ===== ===== ===== ===== //
	
	/** The application interface of TabNine : TabNineApplication tabNineApplication */
	private TabNineApplication tabNineApplication = new TabNineApplicationBasicImpl();
	
	// ===== ===== ===== ===== [Methods of Implementation] ===== ===== ===== ===== //
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeCompletionProposals(org.eclipse.jface.text.ITextViewer, int)
	 * @param arg0
	 * @param arg1
	 * @return
	 * @writer ZhouYi
	 * @date 2019-10-21 14:59:20
	 * @description description
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		// STEP Number Validate incoming parameters
		if (viewer == null) {
			return TabNineLangUtils.toArray(TabNineDocumentUtils.EMPTY_PROPOSAL_LIST, ICompletionProposal.class);
		}
		
		// STEP Number Get the request from incoming context object
		IDocument document = viewer.getDocument();
		AutocompleteArgs autocompleteArgs = TabNineDocumentUtils.extractAutocompleteArgs(offset, document, viewer, OPTION_COMPUTE_RANGE, null);
		
		// STEP Number Check the result has got
		if (autocompleteArgs == null) {
			System.out.println("The autocomplete argument object is null."); // STUB Number Text
			return null;
			
		}
		
		// STEP Number Complete other settings
		autocompleteArgs.setFilename(TabNineDocumentUtils.getPathOfCurrentlyEditingFile());
		autocompleteArgs.setMaxNumResults(OPTION_MAX_NUM_RESULTS);
		
		// STEP Number Send request
		AutocompleteResponse response = tabNineApplication.autocomplete(autocompleteArgs);
		
		// STEP Number Generate proposals using the context and response, then return it
		return TabNineLangUtils.toArray(
				TabNineDocumentUtils.generateCompletionProposal(offset, document, viewer, response, OPTION_COMPUTE_RANGE)
				, ICompletionProposal.class
		);
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeContextInformation(org.eclipse.jface.text.ITextViewer, int)
	 * @param viewer
	 * @param offset
	 * @return
	 * @writer ZhouYi
	 * @date 2019-12-20 11:27:23
	 * @description description
	 */
	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getCompletionProposalAutoActivationCharacters()
	 * @return
	 * @writer ZhouYi
	 * @date 2019-12-20 11:27:25
	 * @description description
	 */
	public char[] getCompletionProposalAutoActivationCharacters() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationAutoActivationCharacters()
	 * @return
	 * @writer ZhouYi
	 * @date 2019-12-20 11:27:27
	 * @description description
	 */
	public char[] getContextInformationAutoActivationCharacters() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationValidator()
	 * @return
	 * @writer ZhouYi
	 * @date 2019-12-20 11:27:30
	 * @description description
	 */
	public IContextInformationValidator getContextInformationValidator() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getErrorMessage()
	 * @return
	 * @writer ZhouYi
	 * @date 2019-12-20 11:27:37
	 * @description description
	 */
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
