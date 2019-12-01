package com.tabnine.eclipse.data;

/**
 * A data object refer to a text range in a document
 * @author ZhouYi
 * @date 2019-12-01 17:57:37
 * @description description
 * @note note
 */
public interface IContextRange {
	
	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Basic API Methods] ===== ===== ===== ===== //
	
	/**
	 * Get the beginning position offset of this range
	 * @return headOffset
	 * @author ZhouYi
	 * @date 2019-12-01 17:57:56
	 * @description description
	 * @note note
	 */
	public int getHeadOffset();
	
	/**
	 * Get the ending position offset of this range
	 * @return headOffset
	 * @author ZhouYi
	 * @date 2019-12-01 17:58:31
	 * @description description
	 * @note note
	 */
	public int getTailOffset();
	
	/**
	 * Is this range includes the beginning of file
	 * @return isRangeIncludesBeginingOfFile
	 * @author ZhouYi
	 * @date 2019-12-01 17:59:07
	 * @description description
	 * @note note
	 */
	public boolean isRangeIncludesBeginingOfFile();
	
	/**
	 * Is this range includes the ending of file
	 * @return isRangeIncludesEndingOfFile
	 * @author ZhouYi
	 * @date 2019-12-01 17:59:10
	 * @description description
	 * @note note
	 */
	public boolean isRangeIncludesEndingOfFile();
	
}
