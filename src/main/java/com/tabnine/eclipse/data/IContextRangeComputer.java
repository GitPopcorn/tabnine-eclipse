package com.tabnine.eclipse.data;

import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;

/**
 * A range computer to get specific text range from context by some rules
 * @author ZhouYi
 * @date 2019-12-01 17:57:00
 * @description description
 * @note note
 */
public interface IContextRangeComputer {
	
	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Basic API Methods] ===== ===== ===== ===== //
	
	/**
	 * Compute the text range from {@link ContentAssistInvocationContext} with its invocation offset
	 * @param context
	 * @return
	 * @author ZhouYi
	 * @date 2019-12-20 10:58:57
	 * @description description
	 * @note note
	 */
	public IContextRange computeRange(ContentAssistInvocationContext context);
	
	/**
	 * Compute the text range from {@link IDocument} with the invocation offset
	 * @param invocationOffset
	 * @param document
	 * @param viewer
	 * @return
	 * @author ZhouYi
	 * @date 2019-12-20 10:58:58
	 * @description description
	 * @note note
	 */
	public IContextRange computeRange(int invocationOffset, IDocument document, ITextViewer viewer);
	
}
