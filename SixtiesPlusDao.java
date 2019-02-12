package com.mysql;

import com.main.app.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class SixtiesPlusDao {

	public SixtiesPlusDao() {
		
	}
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	final private String host = "localhost:3306";
	final private String user = "mysqluser";
	final private String passwd = "crap2man";
	final private String database = "sixtiesplus";

	public void connectToDB() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/"
					+ database + "?" + "user=" + user + "&password=" + passwd);
			System.out.println("Connected fine");
		} catch (Exception e) {
			throw e;
		}
	}


	public ArrayList<DocObj> readdocregister() throws Exception {
		
		ArrayList<DocObj> DocObjs = new ArrayList<DocObj>(10);
		
		try {
			int docCounts = 0;
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from " + database + ".docregister");
			while (resultSet.next()) {
				
				DocObj oneDocObj = new DocObj();
				oneDocObj.setdoc_id(resultSet.getInt("doc_id"));
				oneDocObj.setstoragepath(resultSet.getString("storagepath")); 
				oneDocObj.setdisplaypath(resultSet.getString("displaypath"));
				oneDocObj.setattachedkeywords(resultSet.getString("attachedkeywords"));
				oneDocObj.settitle(resultSet.getString("title"));
				oneDocObj.seticon_id(resultSet.getInt("icon_id"));	
				
				DocObjs.add(oneDocObj);
				
				docCounts++;

			}
		} catch (Exception e) {
			System.out.println("some unknown doc read error");
			throw e;
		}
		
		return DocObjs;
	}

	public ArrayList<KeywordObj> readkeywordregister() throws Exception {
		
		ArrayList<KeywordObj> KeywordObjs = new ArrayList<KeywordObj>(50);
		
		try {
			int keywordCounts = 0;
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from " + database + ".keywordregister");
			while (resultSet.next()) {
				
				KeywordObj oneKeywordObj = new KeywordObj();
				oneKeywordObj.setkeyword_id(resultSet.getInt("keyword_id"));
				oneKeywordObj.setkeywordtype(resultSet.getString("keywordtype")); 
				oneKeywordObj.setkeyword(resultSet.getString("keyword"));
					
				KeywordObjs.add(oneKeywordObj);
				
				keywordCounts++;

			}
		} catch (Exception e) {
			System.out.println("some unknown keyword read error");
			throw e;
		}
		
		return KeywordObjs;
	}

	
	
}
