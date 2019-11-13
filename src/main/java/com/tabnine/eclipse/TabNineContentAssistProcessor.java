package com.tabnine.eclipse;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

import com.tabnine.eclipse.application.TabNineApplication;
import com.tabnine.eclipse.application.impl.TabNineApplicationBasicImpl;

/**
 * The content assist processor for Generic Editor with TabNine 
 * @author ZhouYi
 * @version version
 * @date 2019-10-21 14:56:58
 * @description description
 */
public class TabNineContentAssistProcessor implements IContentAssistProcessor {
	
	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	/** A empty proposal array represent no completions : {ICompletionProposal[]} EMPTY_PROPOSALS */
	public static final ICompletionProposal[] EMPTY_PROPOSALS = {};

	// ===== ===== ===== ===== [Member Variables] ===== ===== ===== ===== //
	
	@SuppressWarnings("unused")
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
		// STEP Number Extract text information from editor
//		TabNineRequest tabNineRequest = TabNineApplicationUtils.generateAutocompleteRequest(viewer, offset);
		
		// STEP Number Send complement request to TabNine core and get response
//		AutocompleteResponse response = tabNineApplication.autocomplete(tabNineRequest);
		
		// STEP Number Extract completion proposals from response
//		ICompletionProposal[] proposals = TabNineApplicationUtils.wrapCompletionProposals(response);
		
		// STEP Number Validate the extraction
//		if (proposals == null) {
//			proposals = EMPTY_PROPOSALS;
//			
//		}
		
		// STEP Number Return proposals
//		return proposals;
		
		try {
			// STEP Number Get text information
			IDocument doc = viewer.getDocument();
			int lineIndex = doc.getLineOfOffset(offset);
			int lineOffset = doc.getLineOffset(lineIndex);
			int oldTextLength = offset - lineOffset;
			String oldText = doc.get(lineOffset, oldTextLength);
			System.out.println(oldText);
			
			// STEP Number Compute proposal
			String newText = oldText + "Apple";
			
			// STEP Number Wrap proposal and then return
			ICompletionProposal[] proposals = {new CompletionProposal(newText, lineOffset, oldTextLength, newText.length())};
			return proposals;
			
		} catch (Exception e) {
			// STEP Number When catch exceptions, return then empty array as instead
			e.printStackTrace();
			return EMPTY_PROPOSALS;
			
		}
		
	}

	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	public char[] getCompletionProposalAutoActivationCharacters() {
		// TODO Auto-generated method stub
		return null;
	}

	public char[] getContextInformationAutoActivationCharacters() {
		// TODO Auto-generated method stub
		return null;
	}

	public IContextInformationValidator getContextInformationValidator() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
