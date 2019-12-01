package com.tabnine.eclipse.module;

import com.tabnine.eclipse.data.TabNineCore;

public interface TabNineCoreManager {
	
	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	/** The name of TabNine core file in local storage : String TABNINE_CORE_FILE_NAME_LOCAL */
	public static final String TABNINE_CORE_FILE_NAME_LOCAL = "TabNine";
	
	/** The most amount this manager will keep for the TabNine core : int LOCAL_TABNINE_CORE_FILE_LIMIT */
	public static final int LOCAL_TABNINE_CORE_FILE_LIMIT = 10;

	// ===== ===== ===== ===== [Basic API Methods] ===== ===== ===== ===== //
	
	/**
	 * Load the {@link #tabNineCore} of this manager
	 * @return tabNineCore {@link #tabNineCore}
	 * @author ZhouYi
	 * @since version
	 * @date 2019-11-01 10:22:57
	 * @description description
	 */
	public TabNineCore loadTabNineCore();

}