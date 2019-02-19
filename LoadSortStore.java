package com.main.app;

import java.util.*;


import com.jcs.test.*;
import com.mysql.*;

public class LoadSortStore {
     
	  // public static void main(String[] args) throws Exception {
		  
		//public ArrayList<HaspMap<String,ArrayList<Integer>>> LoadKeywords () {
	
		public static HashMap<String, ArrayList<Integer> > [ ] LoadKeywords () throws Exception {	
  
		HashMap<String, ArrayList<Integer>>[] keywordMaps = new HashMap[2] ;
			 
		DocObj oneDocObj = new DocObj();
		
	       // Load the control info of docs from database
		SixtiesPlusDao maindb = new SixtiesPlusDao();
		maindb.connectToDB();
				
		
        // It is a total table read. The data will be used to populate caches.

        ArrayList<DocObj> DocObjs = maindb.readdocregister();

       

        HashMap<String, ArrayList<Integer> > categoryDoc_idHash = new HashMap<>();

        HashMap<String, ArrayList<Integer> > contentDoc_idHash = new HashMap<>();        

 

        // Sort out one cache with doc_id, keyword, weight

        for (int i=0; i<DocObjs.size(); i++) {

               oneDocObj = DocObjs.get(i);

               int doc_id = oneDocObj.getdoc_id();

               Integer current_doc_id = Integer.valueOf(doc_id);

               String[] storagekeywords = oneDocObj.getstoragepath().split("\\\\");

               String[] categorykeywords = oneDocObj.getdisplaypath().split("\\\\");

               String[] contentkeywords = oneDocObj.getattachedkeywords().split("\\|");

              

               if (categorykeywords != null) {

                     for (int j=0; j<categorykeywords.length; j++ ) {

                            if (categoryDoc_idHash.get(categorykeywords[j]) != null) {

                                   ArrayList<Integer> newArrList = categoryDoc_idHash.get(categorykeywords[j]);

                                   newArrList.add(current_doc_id);

                                   categoryDoc_idHash.put(categorykeywords[j], newArrList);

                            } else {

                            	if (!categorykeywords[j].equals("")) {
                            		
                                   ArrayList<Integer> newArrList = new ArrayList<Integer>(1);

                                   newArrList.add(current_doc_id);

                                   categoryDoc_idHash.put(categorykeywords[j], newArrList);
                            	}
                            }

                     }

               }


               if (contentkeywords != null) {

                     for (int j=0; j<contentkeywords.length; j++ ) {

                            if (contentDoc_idHash.get(contentkeywords[j]) != null) {

                                   ArrayList<Integer> newArrList = contentDoc_idHash.get(contentkeywords[j]);

                                   newArrList.add(current_doc_id);

                                   contentDoc_idHash.put(contentkeywords[j], newArrList);

                            } else {

                            	if (!contentkeywords[j].equals("")) {
                            		
                                   ArrayList<Integer> newArrList = new ArrayList<Integer>(1);

                                   newArrList.add(current_doc_id);

                                   contentDoc_idHash.put(contentkeywords[j], newArrList);
                            	}
                            }

                     }

               }

                            

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

        keywordMaps[0] = categoryDoc_idHash;
        keywordMaps[1] = contentDoc_idHash;
        
        System.out.println("keywordMaps loaded fine, in LoadSortStore class.");
        
        return  keywordMaps;
        
	  }

		public static void main(String[] args) throws Exception {
			HashMap<String, ArrayList<Integer>>[] keywordMaps = null;
			keywordMaps = LoadKeywords(); 
			System.out.print(keywordMaps);
			return ;
		}
		
}
