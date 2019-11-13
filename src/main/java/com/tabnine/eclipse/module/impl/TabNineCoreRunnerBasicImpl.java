package com.tabnine.eclipse.module.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.tabnine.eclipse.data.TabNineCore;
import com.tabnine.eclipse.enums.TabNinePlatformInfo;
import com.tabnine.eclipse.exception.TabNineApplicationException;
import com.tabnine.eclipse.module.TabNineCoreManager;
import com.tabnine.eclipse.module.TabNineCoreRunner;
import com.tabnine.eclipse.util.TabNineIOUtils;
import com.tabnine.eclipse.util.TabNineTextUtils;

/**
 * The basic implementation of {@link TabNineCoreRunner}
 * @author ZhouYi
 * @date 2019-11-01 13:56:04
 * @description description
 * @note note
 */
public class TabNineCoreRunnerBasicImpl implements TabNineCoreRunner {

	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Variables] ===== ===== ===== ===== //
	
	/** If the TabNine process is running : boolean isRunning
	 * @note In this implementation of {@link TabNineCoreRunner}, we run only one process in the application
	 *   So these variables are set to be static
	 */
	protected static boolean isRunning = false;
	
	/** The TabNine core running in current process : TabNineCore currentCore */
	protected static TabNineCore currentCore = null;
	
	/** The system process we keep communication with TabNine : Process process */
	protected static Process process = null;
	
	/** The buffered reader which has wrapped the process input stream in : BufferedReader processReader */
	protected static BufferedReader processReader = null;
	
	/** The writer which has wrapped the process output stream in : Writer processWriter */
	protected static Writer processWriter = null;
	
	/** The timestamp when starting current progress : Long startingTimestamp */
	protected static Long startingTimestamp = null;
	
	/** The platform this runner is running in : TabNinePlatformInfo currentPlatform */
	protected static TabNinePlatformInfo currentPlatform = null;
	
	// ===== ===== ===== ===== [Entry Method (For test only)] ===== ===== ===== ===== //
	
	public static void main(String[] args) {
		TabNineCoreRunner runner = new TabNineCoreRunnerBasicImpl();
		String message = null;
		runner.start();
		
		message = "{\"version\": \"2.1.17\", \"request\": {\"Autocomplete\": {\"before\": \"Hello H\", \"after\": \"\", \"region_includes_beginning\": true, \"region_includes_end\": true, \"filename\": null}}}";
		System.out.println();
		System.out.println(message);
		System.out.println(runner.send(message + TabNineTextUtils.LINE_SEPARATOR, 1));
		
		try {
			Thread.sleep(1000 * 10);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		
		message = "{\"version\": \"2.1.17\", \"request\": {\"Autocomplete\": {\"before\": \"\\\\tempty\", \"after\": \"\", \"region_includes_beginning\": false, \"region_includes_end\": false, \"filename\": \"E:\\\\vscode-workspace-temp\\\\temp-files\\\\javascript\\\\web-module\\\\ModifyZhihuEquationSvg2Png.js\", \"max_num_results\": 10}}}";
		System.out.println();
		System.out.println(message);
		System.out.println(runner.send(message + TabNineTextUtils.LINE_SEPARATOR, 1));
		
		try {
			Thread.sleep(1000 * 10);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		
		message = "{\"version\": \"2.1.17\", \"request\": {\"Autocomplete\": {\"before\": \"query\", \"after\": \"\", \"region_includes_beginning\": false, \"region_includes_end\": false, \"filename\": \"E:\\\\vscode-workspace-temp\\\\temp-files\\\\javascript\\\\web-module\\\\BatchParseShortLinks.js\", \"max_num_results\": 10}}}";
		System.out.println();
		System.out.println(message);
		System.out.println(runner.send(message + TabNineTextUtils.LINE_SEPARATOR, 1));

		try {
			Thread.sleep(1000 * 10);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		
		message = "{\"version\": \"2.1.17\", \"request\": {\"Autocomplete\": {\"before\": \"query\", \"after\": \"\", \"region_includes_beginning\": false, \"region_includes_end\": false, \"filename\": \"E:\\\\vscode-workspace-temp\\\\temp-files\\\\javascript\\\\web-module\\\\BatchParseShortLinks.js\", \"max_num_results\": 10}}}";
		System.out.println();
		System.out.println(message);
		System.out.println(runner.send(message + TabNineTextUtils.LINE_SEPARATOR, 1));
		
		try {
			Thread.sleep(1000 * 10);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		
		message = "{\"version\": \"2.1.17\", \"request\": {\"Autocomplete\": {\"before\": \"query\", \"after\": \"\", \"region_includes_beginning\": false, \"region_includes_end\": false, \"filename\": \"E:\\\\vscode-workspace-temp\\\\temp-files\\\\javascript\\\\web-module\\\\BatchParseShortLinks.js\", \"max_num_results\": 10}}}";
		System.out.println();
		System.out.println(message);
		System.out.println(runner.send(message + TabNineTextUtils.LINE_SEPARATOR, 1));
		
	}
	
	// ===== ===== ===== ===== [Test Methods] ===== ===== ===== ===== //

	
	// ===== ===== ===== ===== [Instance Variables] ===== ===== ===== ===== //
	
	/** The manager to load and keep TabNine core : TabNineCoreManagerBasicImpl tabNineCoreManager */
	private TabNineCoreManager tabNineCoreManager = new TabNineCoreManagerBasicImpl();
	
	// ===== ===== ===== ===== [Instance Methods] ===== ===== ===== ===== //
	
	/* (non-Javadoc)
	 * @see com.tabnine.eclipse.module.impl.TabNineCoreRunner#start()
	 * @writer ZhouYi
	 * @date 2019-11-07 16:57:24
	 * @description description
	 */
	@Override
	public void start() {
		// STEP Number Declare the log variables
		String logTitle = "Try to start TabNine process"; // Log message title
		String logMessage = null; // Log message text
		
		// STEP Number Check the running status
		if (isRunning) {
			System.out.println(logTitle + " - Returned: The process is already started");
			return;
			
		}
		
		// STEP Number Load TabNine core and check
		TabNineCore core = this.tabNineCoreManager.loadTabNineCore();
		if (core.isRunning() && (process != null)) {
			logMessage = logTitle + " - Failed: The TabNine core is occupied";
			System.err.println(logMessage);
			throw new TabNineApplicationException(logMessage);
			
		}
		
		// STEP Number Try to run process according to system interface
		try {
			// SUBSTEP Number Initialize process
			process = Runtime.getRuntime().exec(generateProcessStartingCommand(core, null));
			processReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			processWriter = new OutputStreamWriter(process.getOutputStream());
			
			// SUBSTEP Number Set marks
			currentCore = core;
			startingTimestamp = System.currentTimeMillis();
			currentCore.setThread(Thread.currentThread());
			currentCore.setRunning(true);
			isRunning = true;
			
			// SUBSTEP Number Print log
			System.out.println(logTitle + " - Succeeded");
			
		} catch (IOException e) {
			logMessage = logTitle + " - Failed: Unknown IOException happened while start TabNine process";
			System.err.println(logMessage);
			throw new TabNineApplicationException(logMessage, e);
			
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.tabnine.eclipse.module.impl.TabNineCoreRunner#send(java.lang.String, int)
	 * @param message
	 * @param responseLinesExpectation
	 * @return
	 * @writer ZhouYi
	 * @date 2019-11-07 16:57:24
	 * @description description
	 */
	@Override
	public String send(String message, int responseLinesExpectation) {
		// STEP Number Declare the log variables
		String logTitle = "Try to send message to TabNine process"; // Log message title
		String logMessage = null; // Log message text
		
		// STEP Number Check the process running status
		if (!isRunning) {
			start();
			
		}
		
		// STEP Number Send message to process
		try {
			// SUBSTEP Number Write message to the process writer
			processWriter.write(message);
			processWriter.flush();
			
			// SUBSTEP Number Read the response from the process reader
			// NOTE Number The TabNine core is a in-console-interactive program just like SQLPLUS/FTP/VIM
			//   So the input stream will not close before you close the process
			//   If you circularly read response from its input, it will block forever
			//   Now flow the rule in TabNine official document we just try to get a one-line response after each request
			/*
			while ((line = processReader.readLine()) != null) {
				System.out.println(line);
				System.out.println(i++);
				resultBuilder.append(line);
				
			}
			 */
			
			// SUBSTEP Number Check if there was response expected
			if (responseLinesExpectation <= 0) {
				return null;
				
			}
			
			// SUBSTEP Number Create the result variable
			StringBuilder resultBuilder = new StringBuilder();
			
			// SUBSTEP Number Circularly read the response lines from the process reader
			while (responseLinesExpectation > 0) {
				resultBuilder.append(processReader.readLine());
				responseLinesExpectation --;
				
			}
			
			// SUBSTEP Number Return the result read
			return resultBuilder.toString();
			
		} catch (IOException e) {
			logMessage = logTitle + " - Failed: Unknown IOException happened while send message to TabNine process";
			System.err.println(logMessage);
			throw new TabNineApplicationException(logMessage, e);
			
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.tabnine.eclipse.module.impl.TabNineCoreRunner#destroy(boolean)
	 * @param forcibly
	 * @writer ZhouYi
	 * @date 2019-11-07 16:57:24
	 * @description description
	 */
	@Override
	public void destroy(boolean forcibly) {
		// STEP Number Declare the log variables
		String logTitle = "Try to destroy TabNine process"; // Log message title
		
		// STEP Number Check the running status
		if (!isRunning) {
			System.out.println(logTitle + " - Returned: The process is not running now");
			return;
			
		}
		
		// STEP Number destroy process
		TabNineIOUtils.safelyClose(processReader);
		TabNineIOUtils.safelyClose(processWriter);
		if (forcibly) {
			process.destroyForcibly();
			
		} else {
			process.destroy();
			
		}
		
		// STEP Number Modify marks
		startingTimestamp = null;
		currentCore.setThread(null);
		currentCore.setRunning(false);
		currentCore = null;
		isRunning = false;
		
		// STEP Number Print log
		System.out.println(logTitle + " - Succeeded");
		
	}
	
	/* (non-Javadoc)
	 * @see com.tabnine.eclipse.module.TabNineCoreRunner#getCore()
	 * @return
	 * @writer ZhouYi
	 * @date 2019-11-07 17:13:51
	 * @description description
	 */
	public TabNineCore getTabNineCore() {
		// STEP Number Invoking relative method and return result
		return this.tabNineCoreManager.loadTabNineCore();
		
	}
	
	// ===== ===== ===== ===== [Instance Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Utility Methods - Utility] ===== ===== ===== ===== //
	
	/**
	 * Get the {@link TabNinePlatformInfo} currently cached in this type
	 * @return platformInfo
	 * @author ZhouYi
	 * @date 2019-11-01 15:32:29
	 * @description description
	 * @note note
	 */
	protected static TabNinePlatformInfo getCurrentPlatform() {
		// STEP Number Check the static cache
		if (currentPlatform == null) {
			currentPlatform = TabNinePlatformInfo.getTabNinePlatformInfoMatchedCurrentOS();
			
		}
		
		// STEP Number Return the static cache
		return currentPlatform;
		
	}
	
	/**
	 * Generate the process starting command text that suits specified platform
	 * @param tabNineCore The core file using to generate command
	 * @param platformInfo The platform information using to generate command
	 * @return commandText Generated command text
	 * @author ZhouYi
	 * @date 2019-11-01 15:33:06
	 * @description description
	 * @note note
	 */
	protected static String generateProcessStartingCommand(TabNineCore tabNineCore, TabNinePlatformInfo platformInfo) {
		// STEP Number Declare the log variables
		String logTitle = "Try to generate TabNine process starting command text that suits specified platform"; // Log message title
		String logMessage = null; // Log message text
		
		// STEP Number Validate incoming paramaters
		if (platformInfo == null) {
			platformInfo = getCurrentPlatform();
			
		}
		
		// STEP Number Get the file path of TabNine core
		String corePath = tabNineCore.getCoreFile().getAbsolutePath();
		
		// STEP Number Generate text according to the Operation System type of platform
		switch (platformInfo.getOsType()) {
			case TabNinePlatformInfo.InfoConstants.OS_DARWIN:
				return corePath;
				
			case TabNinePlatformInfo.InfoConstants.OS_LINUX_GNU:
				return corePath;
				
			case TabNinePlatformInfo.InfoConstants.OS_WINDOWS_GNU:
				return "CMD /K " + corePath;
				
			default:
				logMessage = logTitle + " - Failed : Unknown OS type [" + platformInfo.getOsType() + "]";
				System.err.println(logMessage);
				throw new TabNineApplicationException(logMessage);
				
		}
		
	}
	
	// ===== ===== ===== ===== [Constructors] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Factory Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Getters & Setters] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
}
