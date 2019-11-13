package com.tabnine.eclipse.data;

/**
 * The command message send to TabNine Core that contains version and request arguments
 * @author ZhouYi
 * @date 2019-11-07 16:52:01
 * @description description
 * @note note
 */
public class TabNineApplicationCommand {

	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Variables] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Entry Method (For test only)] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Test Methods] ===== ===== ===== ===== //

	
	// ===== ===== ===== ===== [Instance Variables] ===== ===== ===== ===== //
	
	/** The version of TabNine Core contained in this command message : String version */
	private String version;
	
	/** The application request contained in this command message : TabNineApplicationRequest request */
	private TabNineApplicationRequest request;

	// ===== ===== ===== ===== [Instance Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Instance Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Constructors] ===== ===== ===== ===== //
	
	/**
	 * The empty constructor of {@link TabNineApplicationCommand}
	 * @author ZhouYi
	 * @date 2019-11-07 16:55:01
	 * @constructorSerial 00
	 * @description description
	 */
	public TabNineApplicationCommand() {
		super();
	}

	/**
	 * The full constructor of {@link TabNineApplicationCommand}
	 * @param version {@link #version}
	 * @param request {@link #request}
	 * @author ZhouYi
	 * @date 2019-11-07 16:55:02
	 * @constructorSerial 01
	 * @description description
	 */
	public TabNineApplicationCommand(String version, TabNineApplicationRequest request) {
		super();
		this.version = version;
		this.request = request;
	}
	
	// ===== ===== ===== ===== [Static Factory Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Getters & Setters] ===== ===== ===== ===== //
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public TabNineApplicationRequest getRequest() {
		return request;
	}

	public void setRequest(TabNineApplicationRequest request) {
		this.request = request;
	}
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
}
