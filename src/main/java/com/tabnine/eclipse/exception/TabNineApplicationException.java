package com.tabnine.eclipse.exception;

/**
 * The common exception type for all TabNine application errors
 * @author ZhouYi
 * @version version
 * @date 2019-10-29 13:44:11
 * @description description
 */
public class TabNineApplicationException extends RuntimeException {

	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	/** Serial version UID : {long} serialVersionUID */
	private static final long serialVersionUID = -768890006868820330L;

	
	// ===== ===== ===== ===== [Static Variables] ===== ===== ===== ===== //
	
	
	
	// ===== ===== ===== ===== [Entry Method (For test only)] ===== ===== ===== ===== //
	
	
	
	// ===== ===== ===== ===== [Test Methods] ===== ===== ===== ===== //
	
	/** The unique id of each error instance : {String} errorId */
	private String errorId;

	/** The code contains information about error type, range or other tags : {String} errorCode */
	private String errorCode;
	
	/** The type number of error : {int} errorType */
	private int errorType;
	
	/** The detail data contains in error : {Object} errorData */
	private Object errorData;
	
	// ===== ===== ===== ===== [Instance Variables] ===== ===== ===== ===== //
	
	
	
	// ===== ===== ===== ===== [Instance Methods] ===== ===== ===== ===== //
	
	
	
	// ===== ===== ===== ===== [Utility Methods - Instance Utility] ===== ===== ===== ===== //
	
	
	
	// ===== ===== ===== ===== [Utility Methods - Static Utility] ===== ===== ===== ===== //
	
	
	
	// ===== ===== ===== ===== [Constructors] ===== ===== ===== ===== //
	

	public TabNineApplicationException() {
		super();
	}
	
	public TabNineApplicationException(String message) {
		super(message);
	}
	
	public TabNineApplicationException(Throwable cause) {
		super(cause);
	}
	
	public TabNineApplicationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public TabNineApplicationException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public TabNineApplicationException(String message, Throwable cause, String errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}
	
	// ===== ===== ===== ===== [Static Factory Methods] ===== ===== ===== ===== //
	
	
	
	// ===== ===== ===== ===== [Getters & Setters] ===== ===== ===== ===== //
	

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public int getErrorType() {
		return errorType;
	}

	public void setErrorType(int errorType) {
		this.errorType = errorType;
	}

	public Object getErrorData() {
		return errorData;
	}

	public void setErrorData(Object errorData) {
		this.errorData = errorData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
}
