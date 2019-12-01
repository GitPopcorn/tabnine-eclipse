package com.tabnine.eclipse.data;

import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;

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
	
	public IContextRange computeRange(ContentAssistInvocationContext context);
	
}
