package com.jcs.test;

public class TestJCS {
	
	public static void main(String[] args) throws Exception {
		int id = 1;
		
		BookVObjManager BKMGR = BookVObjManager.getInstance();
		
		BookVObj vObj1 = BKMGR.getBookVObj(id);
		System.out.println("Inserted one JCS item fine");
		
		id = 2;
		BookVObj vObj2 = BKMGR.getBookVObj(id);
		System.out.println("Inserted second JCS item fine");	
		
		System.out.println("BKMGR instance works fine for two items");
	}
}
