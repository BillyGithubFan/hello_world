package com.main.app;

public class KeywordObj {

	private int keyword_id ;
	private String keywordtype ;
	private String keyword ;
	
	public KeywordObj() {
		
	}
	
	public int getkeyword_id() {
		return keyword_id;
	}
	public void setkeyword_id(int id) {
		keyword_id = id;
	}
	public String getkeywordtype() {
		return keywordtype;
	}
	public void setkeywordtype(String type) {
		keywordtype = type;
	}
	public String getkeyword() {
		return keyword;
	}
	public void setkeyword(String word) {
		keyword = word;
	}		
}
