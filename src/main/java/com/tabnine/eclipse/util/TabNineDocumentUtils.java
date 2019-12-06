package com.tabnine.eclipse.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import com.tabnine.eclipse.data.AutocompleteArgs;
import com.tabnine.eclipse.data.AutocompleteResponse;
import com.tabnine.eclipse.data.IContextRange;
import com.tabnine.eclipse.data.IContextRangeComputer;
import com.tabnine.eclipse.data.ResultEntry;

/**
 * The DocumentUtils used in this project (The "TabNine" prefix is just for distinguishing)
 * @author ZhouYi
 * @date 2019-11-15 10:58:47
 * @description description
 * @note note
 */
public class TabNineDocumentUtils {
	
	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //

	/** Get the before/after text from current line : int FROM_LINES
	 * @note In this mode, the proposals from TabNine will be a little bit more confined
	 * @note note
	 */
	public static final int FROM_LINES = 0;
	
	/** Get the before/after text from the whole document : int FROM_DOCS
	 * @note In this mode, the proposals from TabNine will be much more as well as the cost grows 
	 * @note note 
	 */
	public static final int FROM_DOCS = 1;
	
	/** Get the before/after text from the custom range computer : int FROM_RANGE_COMPUTER */
	public static final int FROM_RANGE_COMPUTER = 2;
	
	/** An empty proposal list to return when no proposal got : List<ICompletionProposal> EMPTY_PROPOSAL_LIST */
	public static final List<ICompletionProposal> EMPTY_PROPOSAL_LIST = new ArrayList<ICompletionProposal>();
	
	// ===== ===== ===== ===== [Static Variables] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Entry Method (For test only)] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Test Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Utility Methods - Utility] ===== ===== ===== ===== //
	
	/**
	 * Extract the arguments information for TabNine auto-complete from {@link ContentAssistInvocationContext}
	 * @param context The {@link ContentAssistInvocationContext} object which this method is working on
	 * @param extractionRange The range we extract before/after text from context, includes: 
	 *     <li>{@link #FROM_LINES}: Get the before/after text from current line</li>
	 *     <li>{@link #FROM_DOCS}: Get the before/after text from the whole documents(not recommend)</li>
	 *     <li>{@link #FROM_RANGE_COMPUTER}: Get the before/after text by a custom range computer(need to provide a computer object)</li>
	 * @param rangeComputer A {@link IContextRangeComputer} object to compute the before/after range from context
	 * @return autocompleteArgs The arguments extracted 
	 * @author ZhouYi
	 * @date 2019-12-01 17:42:05
	 * @description description
	 * @note note
	 */
	public static AutocompleteArgs extractAutocompleteArgs(ContentAssistInvocationContext context, int extractionRange, IContextRangeComputer rangeComputer) {
		// STEP Number Declare the log variables
		String logTitle = "Try to extract arguments information for TabNine auto-complete request from context"; // Log message title
		String logMessage = null; // Log message text
		
		// STEP Number Validate incoming parameters
		if (context == null) {
			return null;
			
		}
		
		// STEP Number Get relative variables from context
		int invocationOffset = context.getInvocationOffset(); // The position of current cursor in the whole text
		IDocument document = context.getDocument(); // The document object
		
		// STEP Number Declare argument variables
		AutocompleteArgs autocompleteArgs = null;
		
		// STEP Number Fill argument object by different ways according to the method settings
		try {
			// BRANCH Number If get before/after text from the whole text
			if (extractionRange == FROM_DOCS) {
				autocompleteArgs = new AutocompleteArgs();
				autocompleteArgs.setBefore(document.get(0, invocationOffset));
				autocompleteArgs.setAfter(document.get(invocationOffset, document.getLength() - invocationOffset));
				autocompleteArgs.setRegionIncludesBeginning(true);
				autocompleteArgs.setRegionIncludesEnd(true);
				
			// BRANCH Number If get before/after text from current line
			} else if (extractionRange == FROM_LINES) {
				IRegion lineInformation = document.getLineInformationOfOffset(invocationOffset);
				int lineHeadOffset = lineInformation.getOffset(); // The position of current line head in the whole text
				int lineLength = lineInformation.getLength(); // The length of current line
				int totalLineNumber = document.getNumberOfLines(); // The total line count of this document
				int currentLineNumber = document.getLineOfOffset(lineHeadOffset) + 1; // The number of current line (index of line plus one)
				autocompleteArgs = new AutocompleteArgs();
				autocompleteArgs.setBefore(document.get(lineHeadOffset, invocationOffset - lineHeadOffset));
				autocompleteArgs.setAfter(document.get(invocationOffset, lineLength - (invocationOffset - lineHeadOffset)));
				autocompleteArgs.setRegionIncludesBeginning((currentLineNumber == 1));
				autocompleteArgs.setRegionIncludesEnd((currentLineNumber == totalLineNumber));
				
			} else if (extractionRange == FROM_RANGE_COMPUTER) {
				if (rangeComputer != null) {
					IContextRange range = rangeComputer.computeRange(context);
					autocompleteArgs = new AutocompleteArgs();
					autocompleteArgs.setBefore(document.get(range.getHeadOffset(), invocationOffset));
					autocompleteArgs.setAfter(document.get(invocationOffset, range.getTailOffset()));
					autocompleteArgs.setRegionIncludesBeginning(range.isRangeIncludesBeginingOfFile());
					autocompleteArgs.setRegionIncludesEnd(range.isRangeIncludesEndingOfFile());
					
				}
				
			}
			
		} catch (BadLocationException e) {
			logMessage = logTitle + " - Failed: Unknown bad location exception hanppend.";
			System.err.println(logMessage);
			e.printStackTrace();
			return null;
			
		}
		
		// STEP Number Return the object created
		return autocompleteArgs;
		
	}
	
	/**
	 * Generate {@ICompletionProposal} list using the response information from TabNine auto-complete application
	 * @param context The {@link ContentAssistInvocationContext} object which this method is working on
	 * @param response The response from TabNine auto-complete application
	 * @param extractionRange The range we got before/after text from context, includes: 
	 *     <li>{@link #FROM_LINES}: Get the before/after text from current line</li>
	 *     <li>{@link #FROM_DOCS}: Get the before/after text from the whole documents(not recommend)</li>
	 *     <li>{@link #FROM_RANGE_COMPUTER}: Get the before/after text by a custom range computer(need to provide a computer object)</li>
	 * @return proposalList The proposal list generated
	 * @author ZhouYi
	 * @date 2019-12-01 18:08:45
	 * @description description
	 * @note note
	 */
	public static List<ICompletionProposal> generateCompletionProposal(ContentAssistInvocationContext context, AutocompleteResponse response, int extractionRange) {
		// STEP Number Validate incoming parameters
		if ((context == null) || (response == null) || TabNineLangUtils.isEmpty(response.getResults())) {
			return EMPTY_PROPOSAL_LIST;
			
		}
		
		// STEP Number Get common information from context and response
		int invocationOffset = context.getInvocationOffset();
		String oldPrefix = response.getOldPrefix();
		String userMessage = TabNineTextUtils.join(response.getUserMessage(), null);
		List<ResultEntry> results = response.getResults();
		
		// STEP Number Calculate additional information
		int oldPrefixLength = TabNineTextUtils.safelyGetLength(oldPrefix);
		boolean isUserMessageNotBlank = TabNineTextUtils.isNotBlank(userMessage);
		
		// STEP Number Handle the auto-complete result entities circularly
		List<ICompletionProposal> proposalList = new ArrayList<ICompletionProposal>(results.size());
		for (ResultEntry resultEntry : results) {
			// SUBSTEP Number Read properties
			String newPrefix = resultEntry.getNewPrefix();
			String newSuffix = resultEntry.getNewSuffix();
			Boolean deprecated = resultEntry.getDeprecated();
			String detail = resultEntry.getDetail();
			String kind = resultEntry.getKind();
			String documentation = resultEntry.getDocumentation();
			
			// SUBSTEP Number Make up text
			// TODO Number The text we build here contains line separator, 
			//   but no line breaks shows in additional proposal information, 
			//   this problem should be fixed later
			String newText = newPrefix.concat(newSuffix);
			StringBuilder infoBuilder = new StringBuilder("TabNine");
			if (TabNineLangUtils.equalsWithNull(deprecated, true)) {
				infoBuilder.append(TabNineTextUtils.LINE_SEPARATOR).append("Deprecated.");
				
			}
			if (TabNineTextUtils.isNotBlank(detail)) {
				infoBuilder.append(TabNineTextUtils.LINE_SEPARATOR).append(detail);
				
			}
			if (isUserMessageNotBlank) {
				infoBuilder.append(TabNineTextUtils.LINE_SEPARATOR).append(userMessage);
				
			}
			if (TabNineTextUtils.isNotBlank(kind)) {
				infoBuilder.append(TabNineTextUtils.LINE_SEPARATOR).append(kind);
				
			}
			if (TabNineTextUtils.isNotBlank(documentation)) {
				infoBuilder.append(TabNineTextUtils.LINE_SEPARATOR).append(documentation);
				
			}
			String additionalProposalInfo = infoBuilder.toString();
			
			// SUBSTEP Number Generate proposal object and add it to list
			proposalList.add(new CompletionProposal(
				newText
				, invocationOffset - oldPrefixLength
				, oldPrefixLength
				, TabNineTextUtils.safelyGetLength(newPrefix)
				, null
				, newText
				, null
				, additionalProposalInfo
			));
			
		}
		
		// STEP Number Return the proposal list we got
		return proposalList;
		
	}
	
	
	// ===== ===== ===== ===== [Constructors] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Factory Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Getters & Setters] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
}
