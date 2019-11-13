package com.tabnine.eclipse.data;

/**
 * The arguments of prefetch request that send to TabNine Core
 * @author ZhouYi
 * @date 2019-11-07 16:32:38
 * @description description
 * @note note
 */
public class PrefetchArgs implements TabNineApplicationRequestArguments {

	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Variables] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Entry Method (For test only)] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Test Methods] ===== ===== ===== ===== //

	
	// ===== ===== ===== ===== [Instance Variables] ===== ===== ===== ===== //
	
	/** The filename of file which is appointed to be prefetched by TabNine Core : String filename */
	private String filename;
	
	// ===== ===== ===== ===== [Instance Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Instance Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Constructors] ===== ===== ===== ===== //

	/**
	 * The empty constructor of {@link PrefetchArgs}
	 * @author ZhouYi
	 * @date 2019-11-07 16:36:32
	 * @constructorSerial 00
	 * @description description
	 */
	public PrefetchArgs() {
		super();
	}

	/**
	 * The full constructor of {@link PrefetchArgs}
	 * @param filename {@link #filename}
	 * @author ZhouYi
	 * @date 2019-11-07 16:36:36
	 * @constructorSerial 01
	 * @description description
	 */
	public PrefetchArgs(String filename) {
		super();
		this.filename = filename;
	}
	
	// ===== ===== ===== ===== [Static Factory Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Getters & Setters] ===== ===== ===== ===== //

	public String getFileName() {
		return filename;
	}

	public void setFileName(String filename) {
		this.filename = filename;
	}
	
	// ===== ===== ===== ===== [Standard Method] ===== ===== ===== ===== //
	
	@Override
	public String toString() {
		return "PrefetchArgs [filename=" + filename + "]";
	}
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
}
