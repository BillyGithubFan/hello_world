package com.main.app;

import java.util.ArrayList;

import com.jcs.test.*;
import com.mysql.*;

public class LoadSortStore {
     
	  public static void main(String[] args) throws Exception {
		  
		DocObj oneDocObj = new DocObj();
		
	       // Load the control info of docs from database
		SixtiesPlusDao maindb = new SixtiesPlusDao();
		maindb.connectToDB();
				
		
	       // It is a total table read. The data will be used to populate caches.
		ArrayList<DocObj> DocObjs = maindb.readdocregister();
		    			      

	       // Sort out one cache with doc_id, keyword, weight
		for (int i=0; i<DocObjs.size(); i++) 
		{
			oneDocObj = DocObjs.get(i);
			int doc_id = oneDocObj.getdoc_id();
			String[] storagekeywords = oneDocObj.getstoragepath().split("\\\\");
			String[] displaykeywords = oneDocObj.getdisplaypath().split("\\\\");
			String[] contentkeywords = oneDocObj.getattachedkeywords().split("\\|");
			
			
		}

	      

	       // Sort out another cache with  keyword, {doc_id, weight}  ( 2=Category, 1=Content )

	      

	      

	       // Sort out third cache with doc_id, storagepath, searchpath, doc

	      

	      

	       // Other design

	       // At start of App, send version info from App to Server via http,

	       // if require update, send back the searchpaths, else send back 'no change'

	       // the searchpaths returned is either incremental or full

	       // according to server instructions, version will be sent back as well

	       // update the local db with version and searchpaths using nosql

	      

	       // If a particular doc has been selected, this doc_id will be used to search

	       // the local db to see if the doc has been downloaded before. If no local copy, 

	       // send request to website to load this doc.
		
	  }

}
