package com.tabnine.eclipse.enums;

import com.tabnine.eclipse.util.TabNineLangUtils;

/**
 * The version information for TabNine Core
 * @author ZhouYi
 * @date 2019-10-29 15:42:11
 * @description description
 * @note note
 */
public enum TabNinePlatformInfo {

	// ===== ===== ===== ===== [Enum Items] ===== ===== ===== ===== //
	
	I686_APPLE_DARWIN(InfoConstants.CPU_I686, InfoConstants.DEVICE_APPLE, InfoConstants.OS_DARWIN)
	
	, I686_UNKNOWN_LINUX_GNU(InfoConstants.CPU_I686, InfoConstants.DEVICE_UNKNOWN, InfoConstants.OS_LINUX_GNU)
    
    , I686_PC_WINDOWS_GNU(InfoConstants.CPU_I686, InfoConstants.DEVICE_PC, InfoConstants.OS_WINDOWS_GNU)
    
    , X86_64_APPLE_DARWIN(InfoConstants.CPU_X86_64, InfoConstants.DEVICE_APPLE, InfoConstants.OS_DARWIN)
    
    , X86_64_UNKNOWN_LINUX_GNU(InfoConstants.CPU_X86_64, InfoConstants.DEVICE_UNKNOWN, InfoConstants.OS_LINUX_GNU)
    
    , X86_64_PC_WINDOWS_GNU(InfoConstants.CPU_X86_64, InfoConstants.DEVICE_PC, InfoConstants.OS_WINDOWS_GNU);
	
	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //

	
	// ===== ===== ===== ===== [Static Variables] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Entry Method (For test only)] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Test Methods] ===== ===== ===== ===== //

	
	// ===== ===== ===== ===== [Instance Variables] ===== ===== ===== ===== //
	
	/** The CPU architecture type that TabNine Core matched : {String} cpuArchitectureType */
	private String cpuArchitectureType;
	
	/** The Hardware device type that TabNine Core matched : {String} deviceType */
	private String deviceType;
	
	/** Then Operation system type that TabNine Core matched : {String} osType */
	private String osType;
	
	// ===== ===== ===== ===== [Instance Methods] ===== ===== ===== ===== //
	
	/**
	 * Dose target information match this object (Full comparison)
	 * @param version Target version text to compare with {@link #version}
	 * @param cpuArchitectureType Target cpuArchitectureType text to compare with {@link #cpuArchitectureType}
	 * @param deviceType Target deviceType text to compare with {@link #deviceType}
	 * @param osType Target osType text to compare with {@link #osType}
	 * @return matched The judgment result
	 * @author ZhouYi
	 * @since version
	 * @date 2019-10-29 15:35:56
	 * @description description
	 */
	public boolean isMatched(String version, String cpuArchitectureType, String deviceType, String osType) {
		return TabNineLangUtils.equalsWithNull(cpuArchitectureType, this.cpuArchitectureType)
				&& TabNineLangUtils.equalsWithNull(deviceType, this.deviceType)
				&& TabNineLangUtils.equalsWithNull(osType, this.osType);
		
	}
	
	/**
	 * Get the suffix name of executable file(mainly refer to TabNine core file) in this platform
	 * @return suffix The suffix name matched this platform, contains "."
	 * @author ZhouYi
	 * @date 2019-11-01 上午 11:41:29
	 * @description description
	 * @note note
	 */
	public String getSuffixNameOfExecutableFile() {
		switch (this.osType) {
			case InfoConstants.OS_DARWIN:
				return "";

			case InfoConstants.OS_LINUX_GNU:
				return "";

			case InfoConstants.OS_WINDOWS_GNU:
				return ".exe";

			default:
				return "";

		}
		
	}
	
	/**
	 * Transfer this platform information object to text.
	 * @return
	 * @author ZhouYi
	 * @since version
	 * @date 2019-11-01 10:41:48
	 * @description description
	 */
	public String toPlatformTypeText() {
		if ((this.cpuArchitectureType == null) || (this.deviceType == null) || (this.osType == null)) {
			throw new NullPointerException("The platformInfo is not complete and could not be transferred to text");
		}
		
		return this.cpuArchitectureType.toLowerCase() + "-"
				+ this.deviceType.toLowerCase() + "-"
				+ this.osType.toLowerCase();
		
	}
	
	// ===== ===== ===== ===== [Instance Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Utility Methods - Utility] ===== ===== ===== ===== //
	
	/**
	 * Get the matched {@link TabNinePlatformInfo} according to current OS
	 * @return version Match result
	 * @author ZhouYi
	 * @date 2019-10-29 16:06:16
	 * @description description
	 * @note note
	 */
	public static TabNinePlatformInfo getTabNinePlatformInfoMatchedCurrentOS() {
		// STEP Number Get information of current environment
		String osName = System.getProperty("os.name");
		String osArch = System.getProperty("os.arch");
		
		// STEP Number Check if the architecture was X86_64 type
		boolean is64 = ((osArch != null) && osArch.contains("64"));
		
		// STEP Number Judge the OS type and return matched version
		osName = (osName == null) ? "" : osName.toUpperCase();
		if (osName.contains("APPLE") || osName.contains("MAC")) {
			return is64 ? TabNinePlatformInfo.X86_64_APPLE_DARWIN : TabNinePlatformInfo.I686_APPLE_DARWIN;
			
		} else if (osName.contains("WINDOWS")) {
			return is64 ? TabNinePlatformInfo.X86_64_PC_WINDOWS_GNU : TabNinePlatformInfo.I686_PC_WINDOWS_GNU;
			
		} else {
			return is64 ? TabNinePlatformInfo.X86_64_UNKNOWN_LINUX_GNU : TabNinePlatformInfo.I686_UNKNOWN_LINUX_GNU;
			
		}
		
	}
	
	// ===== ===== ===== ===== [Constructors] ===== ===== ===== ===== //


	/**
	 * Empty constructor for {@link TabNinePlatformInfo}
	 * @constructorSerial 00
	 * @description description
	 */
	private TabNinePlatformInfo() {
		
	}
	
	/**
	 * Complete constructor of {@link TabNinePlatformInfo}
	 * @param version {@link #version}
	 * @param cpuArchitectureType {@link #cpuArchitectureType}
	 * @param deviceType {@link #deviceType}
	 * @param osType {@link #osType}
	 * @constructorSerial 02
	 * @description description
	 */
	private TabNinePlatformInfo(String cpuArchitectureType, String deviceType, String osType) {
		this.cpuArchitectureType = cpuArchitectureType;
		this.deviceType = deviceType;
		this.osType = osType;
		
	}
	
	// ===== ===== ===== ===== [Static Factory Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Getters & Setters] ===== ===== ===== ===== //
	
	/**
	 * Get the {@link #cpuArchitectureType} of this object
	 * @return {@link #cpuArchitectureType}
	 * @author ZhouYi
	 * @date 2019-10-29 16:12:14
	 * @description description
	 * @note note
	 */
	public String getCpuArchitectureType() {
		return this.cpuArchitectureType;
		
	}
	
	/**
	 * Get the {@link #deviceType} of this object
	 * @return {@link #deviceType}
	 * @author ZhouYi
	 * @date 2019-10-29 16:12:15
	 * @description description
	 * @note note
	 */
	public String getDeviceType() {
		return this.deviceType;
		
	}
	
	/**
	 * Get the {@link #osType} of this object
	 * @return {@link #osType}
	 * @author ZhouYi
	 * @date 2019-10-29 16:12:19
	 * @description description
	 * @note note
	 */
	public String getOsType() {
		return this.osType;
		
	}
	
	// ===== ===== ===== ===== [Static Inner Class] ===== ===== ===== ===== //
	
	/**
	 * The constants used in {@link TabNinePlatformInfo}
	 * @author ZhouYi
	 * @version version
	 * @date 2019-10-29 15:40:03
	 * @description description
	 */
	public static class InfoConstants {
		
		// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
		
		/** The CPU architecture type - I686 : {String} CPU_I686 */
		public static final String CPU_I686 = "i686";
		
		/** The CPU architecture type - X86_64 : {String} CPU_X86_64 */
		public static final String CPU_X86_64 = "x86_64";
		
		/** The Hardware Device type - Apple : {String} DEVICE_APPLE */
		public static final String DEVICE_APPLE = "apple";
		
		/** The Hardware Device type - Unknown : {String} DEVICE_UNKNOWN */
		public static final String DEVICE_UNKNOWN = "unknown";
		
		/** The Hardware Device type - PC : {String} DEVICE_PC */
		public static final String DEVICE_PC = "pc";
		
		/** The Operation System type - Darwin : {String} OS_DARWIN */
		public static final String OS_DARWIN = "darwin";
		
		/** The Operation System type - Linux GNU : {String} OS_LINUX_GNU */
		public static final String OS_LINUX_GNU = "linux-gnu";
		
		/** The Operation System type - Windows GNU : {String} OS_WINDOWS_GNU */
		public static final String OS_WINDOWS_GNU = "windows-gnu";
		
	}
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
	
}
