package com.tabnine.eclipse.data;

import java.io.File;

import com.tabnine.eclipse.enums.TabNinePlatformInfo;

/**
 * The TabNine core used in application 
 * @author ZhouYi
 * @date 2019-11-01 12:02:17
 * @description description
 * @note note
 */
public class TabNineCore {

	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Variables] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Entry Method (For test only)] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Test Methods] ===== ===== ===== ===== //

	
	// ===== ===== ===== ===== [Instance Variables] ===== ===== ===== ===== //
	
	/** The binary file of this core : File coreFile */
	private File coreFile;
	
	/** The version of this core : String version */
	private String version;
	
	/** The platform information matchted this core : TabNinePlatformInfo tabNinePlatformInfo */
	private TabNinePlatformInfo tabNinePlatformInfo;
	
	/** If this core is running : boolean isRunning */
	private boolean isRunning;
	
	/** The thread this core runned in : Thread thread */
	private Thread thread;
	
	// ===== ===== ===== ===== [Instance Methods] ===== ===== ===== ===== //

	@Override
	public String toString() {
		return "TabNineCore [coreFile=" + coreFile + ", version=" + version + ", tabNinePlatformInfo="
				+ tabNinePlatformInfo + ", isRunning=" + isRunning + ", thread=" + thread + "]";
		
	}
	
	// ===== ===== ===== ===== [Instance Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Constructors] ===== ===== ===== ===== //

	/**
	 * The empty constructor of {@link TabNineCore}
	 * @author ZhouYi
	 * @date 2019-11-01 12:08:18
	 * @constructorSerial 00
	 * @description description
	 */
	public TabNineCore() {
		super();
		
	}
	
	/**
	 * The full constructor of {@link TabNineCore}
	 * @param coreFile {@link #coreFile}
	 * @param version {@link #version}
	 * @param tabNinePlatformInfo {@link #tabNinePlatformInfo}
	 * @param isRunning {@link #isRunning()}
	 * @param thread {@link #thread}
	 * @author ZhouYi
	 * @date 2019-11-01 12:08:20
	 * @constructorSerial 01
	 * @description description
	 */
	public TabNineCore(File coreFile, String version, TabNinePlatformInfo tabNinePlatformInfo, boolean isRunning,
			Thread thread) {
		super();
		this.coreFile = coreFile;
		this.version = version;
		this.tabNinePlatformInfo = tabNinePlatformInfo;
		this.isRunning = isRunning;
		this.thread = thread;
		
	}
	
	// ===== ===== ===== ===== [Static Factory Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Getters & Setters] ===== ===== ===== ===== //

	public File getCoreFile() {
		return coreFile;
	}

	public void setCoreFile(File coreFile) {
		this.coreFile = coreFile;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public TabNinePlatformInfo getTabNinePlatformInfo() {
		return tabNinePlatformInfo;
	}

	public void setTabNinePlatformInfo(TabNinePlatformInfo tabNinePlatformInfo) {
		this.tabNinePlatformInfo = tabNinePlatformInfo;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
}
