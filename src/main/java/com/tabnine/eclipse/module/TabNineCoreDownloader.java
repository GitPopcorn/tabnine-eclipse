package com.tabnine.eclipse.module;

import java.io.File;

public interface TabNineCoreDownloader {
	
	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	/** The URL path of TabNine official update site : String TABNINE_UPDATE_SITE */
	public static final String TABNINE_UPDATE_SITE = "https://update.tabnine.com";
	
	/** The URL path to get the latest version of TabNine Core : {String} TABNINE_VERSION_URL_PATH */
	public static final String TABNINE_VERSION_URL_PATH = TABNINE_UPDATE_SITE + "/version";
	
	/** The name of TabNine core file in remote storage : String TABNINE_CORE_FILE_NAME_REMOTE */
	public static final String TABNINE_CORE_FILE_NAME_REMOTE = "TabNine";

	// ===== ===== ===== ===== [Basic API Methods] ===== ===== ===== ===== //
	
	/**
	 * Get the latest version from official site of TabNine
	 * @see https://github.com/zxqfl/TabNine/blob/master/dl_binaries.sh
	 * @return version The version got
	 * @author ZhouYi
	 * @since version
	 * @date 2019-10-29 14:25:14
	 * @description description
	 */
	public String getLatestTabNineVersion();

	/**
	 * Get the URL path to download TabNine Core file of specified version 
	 * @param version The version of TabNine Core
	 * @return path The path text
	 * @author ZhouYi
	 * @date 2019-10-29 下午 16:30:45
	 * @description description
	 * @note note
	 */
	public String getDownloadUrlPath(String version);

	/**
	 * Download the TabNine Core file from specified remote URL, and save it to the targeted local path
	 * @param downloadUrlPath The remote URL path to download file
	 * @param destFilePath The file path in local storage to safe downloaded file
	 * @return destFile The downloaded file
	 * @author ZhouYi
	 * @date 2019-10-29 下午 17:03:33
	 * @description description
	 * @note note
	 */
	public File downloadTabNineCode(String downloadUrlPath, String destFilePath);

}