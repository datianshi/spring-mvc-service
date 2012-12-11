package com.sample.domain;

import java.util.List;

public class MyBean {
	private String name;
	private EmbededBean eb;
	private List<ListBean> lbs;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EmbededBean getEb() {
		return eb;
	}
	public void setEb(EmbededBean eb) {
		this.eb = eb;
	}
	public List<ListBean> getLbs() {
		return lbs;
	}
	public void setLbs(List<ListBean> lbs) {
		this.lbs = lbs;
	}
	
	
}
