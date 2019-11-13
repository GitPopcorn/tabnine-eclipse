package com.tabnine.eclipse.data;

/**
 * The arguments of identifier-regex-getting request that send to TabNine Core
 * @author ZhouYi
 * @date 2019-11-07 16:41:25
 * @description description
 * @note note
 */
public class GetIdentifierRegexArgs implements TabNineApplicationRequestArguments {

	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Variables] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Entry Method (For test only)] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Test Methods] ===== ===== ===== ===== //

	
	// ===== ===== ===== ===== [Instance Variables] ===== ===== ===== ===== //

	/** The filename of file which is appointed to get identifier-regex from TabNine Core : String filename */
	private String filename;

	// ===== ===== ===== ===== [Instance Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Instance Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Constructors] ===== ===== ===== ===== //
	
	/**
	 * The empty constructor of {@link GetIdentifierRegexArgs}
	 * @author ZhouYi
	 * @date 2019-11-07 16:43:07
	 * @constructorSerial 00
	 * @description description
	 */
	public GetIdentifierRegexArgs() {
		super();
	}

	/**
	 * The full constructor of {@link GetIdentifierRegexArgs}
	 * @param filename {@link #filename}
	 * @author ZhouYi
	 * @date 2019-11-07 16:43:08
	 * @constructorSerial 01
	 * @description description
	 */
	public GetIdentifierRegexArgs(String filename) {
		super();
		this.filename = filename;
	}
	
	// ===== ===== ===== ===== [Static Factory Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Getters & Setters] ===== ===== ===== ===== //
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	// ===== ===== ===== ===== [Standard Method] ===== ===== ===== ===== //
	
	@Override
	public String toString() {
		return "GetIdentifierRegexArgs [filename=" + filename + "]";
	}
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
}
