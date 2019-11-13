package com.tabnine.eclipse.data;

/**
 * The arguments of auto-complete request that send to TabNine Core
 * @author ZhouYi
 * @date 2019-11-07 16:12:06
 * @description description
 * @note note
 */
public class AutocompleteArgs implements TabNineApplicationRequestArguments {

	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //

	
	// ===== ===== ===== ===== [Static Variables] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Entry Method (For test only)] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Test Methods] ===== ===== ===== ===== //

	
	// ===== ===== ===== ===== [Instance Variables] ===== ===== ===== ===== //
	
	/** The context text before cursor : String before */
	private String before;
	
	/** The context text after cursor : String after */
	private String after;
	
	/** The file name which current context was in : String filename */
	private String filename;
	
	/** If current context includes a BOF(beginning of file) : Boolean regionIncludesBeginning */
	private Boolean regionIncludesBeginning;
	
	/** If current context includes a EOF(ending of file) : Boolean regionIncludesEnd */
	private Boolean regionIncludesEnd;
	
	/** The max num for count of results respond by TabNineCore : Integer maxNumResults */
	private Integer maxNumResults;
	
	// ===== ===== ===== ===== [Instance Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Instance Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Constructors] ===== ===== ===== ===== //

	/**
	 * The empty constructor of {@link AutocompleteArgs}
	 * @author ZhouYi
	 * @date 2019-11-07 16:28:03
	 * @constructorSerial 00
	 * @description description
	 */
	public AutocompleteArgs() {
		super();
	}

	/**
	 * The full constructor of {@link AutocompleteArgs}
	 * @param before {@link #before}
	 * @param after {@link #after}
	 * @param filename {@link #filename}
	 * @param regionIncludesBeginning {@link #regionIncludesBeginning}
	 * @param regionIncludesEnd {@link #regionIncludesEnd}
	 * @param maxNumResults {@link #maxNumResults}
	 * @author ZhouYi
	 * @date 2019-11-07 16:28:31
	 * @constructorSerial 01
	 * @description description
	 */
	public AutocompleteArgs(String before, String after, String filename, Boolean regionIncludesBeginning,
			Boolean regionIncludesEnd, Integer maxNumResults) {
		super();
		this.before = before;
		this.after = after;
		this.filename = filename;
		this.regionIncludesBeginning = regionIncludesBeginning;
		this.regionIncludesEnd = regionIncludesEnd;
		this.maxNumResults = maxNumResults;
	}
	
	// ===== ===== ===== ===== [Static Factory Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Getters & Setters] ===== ===== ===== ===== //
	
	public String getBefore() {
		return before;
	}

	public void setBefore(String before) {
		this.before = before;
	}

	public String getAfter() {
		return after;
	}

	public void setAfter(String after) {
		this.after = after;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Boolean getRegionIncludesBeginning() {
		return regionIncludesBeginning;
	}

	public void setRegionIncludesBeginning(Boolean regionIncludesBeginning) {
		this.regionIncludesBeginning = regionIncludesBeginning;
	}

	public Boolean getRegionIncludesEnd() {
		return regionIncludesEnd;
	}

	public void setRegionIncludesEnd(Boolean regionIncludesEnd) {
		this.regionIncludesEnd = regionIncludesEnd;
	}

	public Integer getMaxNumResults() {
		return maxNumResults;
	}

	public void setMaxNumResults(Integer maxNumResults) {
		this.maxNumResults = maxNumResults;
	}
	
	// ===== ===== ===== ===== [Standard Method] ===== ===== ===== ===== //

	@Override
	public String toString() {
		return "AutocompleteArgs [before=" + before + ", after=" + after + ", filename=" + filename
				+ ", regionIncludesBeginning=" + regionIncludesBeginning + ", regionIncludesEnd=" + regionIncludesEnd
				+ ", maxNumResults=" + maxNumResults + "]";
	}
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
}
