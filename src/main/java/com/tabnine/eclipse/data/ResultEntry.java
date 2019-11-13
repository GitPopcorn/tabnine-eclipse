package com.tabnine.eclipse.data;

/**
 * Each result entry in response of auto-complete request to TabNine Core
 * @author ZhouYi
 * @date 2019-11-07 16:23:47
 * @description description
 * @note note
 */
public class ResultEntry {

	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Variables] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Entry Method (For test only)] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Test Methods] ===== ===== ===== ===== //

	
	// ===== ===== ===== ===== [Instance Variables] ===== ===== ===== ===== //
	
	/** The new prefix computed by TabNine Core to replace old prefix : String newPrefix */
	private String newPrefix;
	
	/** The old suffix word after cursor : String oldSuffix */
	private String oldSuffix;
	
	/** The new suffix computed by TabNine Core to replace old suffix : String newSuffix */
	private String newSuffix;
	
	/** The kind of completion item specified by LSP(Language Server Protocol) : String kind */
	private String kind;
	
	/** The detail of completion item specified by LSP(Language Server Protocol) : String detail */
	private String detail;
	
	/** The documentation of this completion operation specified by LSP(Language Server Protocol) : String documentation */
	private String documentation;
	
	/** Is current completion proposal deprecated : Boolean deprecated */
	private Boolean deprecated;
	
	// ===== ===== ===== ===== [Instance Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Instance Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Constructors] ===== ===== ===== ===== //

	/**
	 * The empty constructor of {@link ResultEntry}
	 * @author ZhouYi
	 * @date 2019-11-07 16:31:44
	 * @constructorSerial 00
	 * @description description
	 */
	public ResultEntry() {
		super();
	}

	/**
	 * The full constructor of {@link ResultEntry}
	 * @param newPrefix {@link #newPrefix}
	 * @param oldSuffix {@link #oldSuffix}
	 * @param newSuffix {@link #newSuffix}
	 * @param kind {@link #kind}
	 * @param detail {@link #detail}
	 * @param documentation {@link #documentation}
	 * @param deprecated {@link #deprecated}
	 * @author ZhouYi
	 * @date 2019-11-07 16:31:46
	 * @constructorSerial 01
	 * @description description
	 */
	public ResultEntry(String newPrefix, String oldSuffix, String newSuffix, String kind, String detail,
			String documentation, Boolean deprecated) {
		super();
		this.newPrefix = newPrefix;
		this.oldSuffix = oldSuffix;
		this.newSuffix = newSuffix;
		this.kind = kind;
		this.detail = detail;
		this.documentation = documentation;
		this.deprecated = deprecated;
	}
	
	// ===== ===== ===== ===== [Static Factory Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Getters & Setters] ===== ===== ===== ===== //
	
	public String getNewPrefix() {
		return newPrefix;
	}

	public void setNewPrefix(String newPrefix) {
		this.newPrefix = newPrefix;
	}

	public String getOldSuffix() {
		return oldSuffix;
	}

	public void setOldSuffix(String oldSuffix) {
		this.oldSuffix = oldSuffix;
	}

	public String getNewSuffix() {
		return newSuffix;
	}

	public void setNewSuffix(String newSuffix) {
		this.newSuffix = newSuffix;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	public Boolean getDeprecated() {
		return deprecated;
	}

	public void setDeprecated(Boolean deprecated) {
		this.deprecated = deprecated;
	}
	
	// ===== ===== ===== ===== [Standard Method] ===== ===== ===== ===== //
	
	@Override
	public String toString() {
		return "ResultEntry [newPrefix=" + newPrefix + ", oldSuffix=" + oldSuffix + ", newSuffix=" + newSuffix
				+ ", kind=" + kind + ", detail=" + detail + ", documentation=" + documentation + ", deprecated="
				+ deprecated + "]";
	}
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
}
