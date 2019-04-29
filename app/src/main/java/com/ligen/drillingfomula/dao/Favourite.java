package com.ligen.drillingfomula.dao;

public class Favourite {

	private String titleName;
	private String className;
	private String layoutId;
	
	public Favourite(String titleName, String className, String layoutId) {
		super();
		this.titleName = titleName;
		this.className = className;
		this.layoutId = layoutId;
	}

	public String getTitleName() {
		return titleName;
	}

	public String getClassName() {
		return className;
	}

	public String getLayoutId() {
		return layoutId;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setLayoutId(String layoutId) {
		this.layoutId = layoutId;
	}
	
	
}
