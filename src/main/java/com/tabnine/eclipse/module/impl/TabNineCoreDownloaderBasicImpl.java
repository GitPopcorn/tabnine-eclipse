package com.tabnine.eclipse.module.impl;

import java.io.File;
import com.tabnine.eclipse.enums.TabNinePlatformInfo;
import com.tabnine.eclipse.exception.TabNineApplicationException;
import com.tabnine.eclipse.module.TabNineCoreDownloader;
import com.tabnine.eclipse.util.TabNineIOUtils;
import com.tabnine.eclipse.util.TabNineLangUtils;
import com.tabnine.eclipse.util.TabNineLoggingUtils;

/**
 * The basic implementation of {@link TabNineCoreDownloader}
 * @author ZhouYi
 * @version version
 * @date 2019-10-29 11:55:21
 * @description description
 */
public class TabNineCoreDownloaderBasicImpl implements TabNineCoreDownloader {

	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Entry Method (For test only)] ===== ===== ===== ===== //
	
	public static void main(String[] args) {
		TabNineCoreDownloader downloader = new TabNineCoreDownloaderBasicImpl();
		
		String downloadUrlPath = downloader.getDownloadUrlPath(downloader.getLatestTabNineVersion());
		String fileFolderPath = new File(ClassLoader.getSystemResource("").getPath()).getParent() + File.separator + "tabnine-core";
		File coreFile = downloader.downloadTabNineCode(
				downloadUrlPath
				, downloadUrlPath.replace(TABNINE_UPDATE_SITE, fileFolderPath)
		);
		System.out.println(coreFile.getAbsolutePath());
		
	}
	
	// ===== ===== ===== ===== [Static Variables] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Instance Variables] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Instance Method] ===== ===== ===== ===== //
	
	/* (non-Javadoc)
	 * @see com.tabnine.eclipse.module.impl.TabNineCoreDownloader#getLatestTabNineVersion()
	 * @return
	 * @writer ZhouYi
	 * @date 2019-11-07 17:02:37
	 * @description description
	 */
	@Override
	public String getLatestTabNineVersion() {
		// STEP Number Declare the log variables
		String logTitle = "Try to get the latest version of TabNine core"; // Log message title
		String logMessage = null; // Log message text
		
		// STEP Number Try to connect the URL to get version
		String version = null;
		try {
			// SUBSTEP Number Send HTTP-GET request and get response result
			version = TabNineIOUtils.doGet(TABNINE_VERSION_URL_PATH, "UTF-8");
			
		} catch (TabNineApplicationException e) {
			throw e;
			
		} catch (Exception e) {
			logMessage = logTitle + " - Failed: Unknown exception hanppend.";
			TabNineLoggingUtils.error(logMessage, e);
			throw new TabNineApplicationException(logMessage, e);
			
		}
		
		// STEP Number Return the version got
		return version;
		
	}
	
	/* (non-Javadoc)
	 * @see com.tabnine.eclipse.module.impl.TabNineCoreDownloader#getDownloadUrlPath(java.lang.String)
	 * @param version
	 * @return
	 * @writer ZhouYi
	 * @date 2019-11-07 17:02:37
	 * @description description
	 */
	@Override
	public String getDownloadUrlPath(String version) {
		// STEP Number Validate incoming parameters
		if (TabNineLangUtils.isBlank(version)) {
			String logMessage = "Fail to get download URL path, the given version is blank.";
			TabNineLoggingUtils.error(logMessage);
			throw new TabNineApplicationException(logMessage);
			
		}
		
		// STEP Number Get the matched {@link TabNinePlatformInfo} according to current OS
		TabNinePlatformInfo platformInfo = TabNinePlatformInfo.getTabNinePlatformInfoMatchedCurrentOS();
		
		// STEP Number Concatenate the URL path
		StringBuilder pathBuilder = new StringBuilder(TABNINE_UPDATE_SITE).append("/")
				.append(version).append("/")
				.append(platformInfo.toPlatformTypeText()) .append("/")
				.append(TABNINE_CORE_FILE_NAME_REMOTE).append(platformInfo.getSuffixNameOfExecutableFile());
		
		// STEP Number Return result
		return pathBuilder.toString();
		
	}
	
	/* (non-Javadoc)
	 * @see com.tabnine.eclipse.module.impl.TabNineCoreDownloader#downloadTabNineCode(java.lang.String, java.lang.String)
	 * @param downloadUrlPath
	 * @param destFilePath
	 * @return
	 * @writer ZhouYi
	 * @date 2019-11-07 17:02:37
	 * @description description
	 */
	@Override
	public File downloadTabNineCode(String downloadUrlPath, String destFilePath) {
		// STEP Number Declare the log variables
		String logTitle = "Try to download TabNine core file from [" + downloadUrlPath + "] to [" + destFilePath + "]"; // Log message title
		String logMessage = null; // Log message text
		
		// STEP Number Declare returned result
		File destFile = null;
		
		// STEP Number Begin to download file
		try {
			destFile = TabNineIOUtils.downLoadFile(downloadUrlPath, destFilePath, true);
			
		} catch (TabNineApplicationException e) {
			throw e;
			
		} catch (Exception e) {
			logMessage = logTitle + " - Failed: Unknown exception hanppend.";
			TabNineLoggingUtils.error(logMessage, e);
			throw new TabNineApplicationException(logMessage, e);
			
		}
		
		// STEP Number Return the destination file object
		return destFile;
		
	}
	
	// ===== ===== ===== ===== [Instance Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Utility Methods - Utility] ===== ===== ===== ===== //

	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
	
}
