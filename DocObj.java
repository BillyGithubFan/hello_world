package com.main.app;

public class DocObj {

	private int doc_id ;
	private String storagepath ;
	private String displaypath ;
	private String attachedkeywords ;  // delimited by '|'
	private String title ;
	private int icon_id ;	
	
	public DocObj() {
		
	}
	
	public int getdoc_id() {
		return doc_id;
	}
	public void setdoc_id(int id) {
		doc_id = id;
	}
	public String getstoragepath() {
		return storagepath;
	}
	public void setstoragepath(String path) {
		storagepath = path;
	}
	public String getdisplaypath() {
		return displaypath;
	}
	public void setdisplaypath(String path) {
		displaypath = path;
	}	
	public String getattachedkeywords() {
		return attachedkeywords;
	}
	public void setattachedkeywords(String words) {
		attachedkeywords = words;
	}		
	public String gettitle() {
		return title;
	}
	public void settitle(String words) {
		title = words;
	}		
	public int geticon_id() {
		return icon_id;
	}
	public void seticon_id(int id) {
		icon_id = id;
	}
	
}
