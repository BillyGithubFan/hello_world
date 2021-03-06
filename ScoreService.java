package com.tutor;
import javax.ws.rs.*;

import com.jcs.test.*;

@Path("/ScoreService")
public class ScoreService {

	public BookVObjManager BKMGR ;
	public BookVObj vObj;
	
	public ScoreService() {
		BKMGR = BookVObjManager.getInstance();		
	}
	
	
	@GET 
	@Path("/score/wins")
	@Produces("text/plain")
	public int getWins() {return Score.WINS;}
	     
	@GET 
	@Path("/score/losses")
	@Produces("text/plain")
	public int getLosses() {return Score.LOSSES;}
	     
	@GET 
	@Path("/score/ties")
	@Produces("text/plain")
	public int getTies() {return Score.TIES;}
	
	@POST 
	@Path("/score/pwins")
	@Produces("text/plain")
	public int increaseWins() { 
		Score.WINS++; 
		vObj = BKMGR.getBookVObj(Score.WINS);
		System.out.println("Inserted one JCS item " + Score.WINS + " fine");		
		return Score.WINS; 
		}
	     
	@POST 
	@Path("/score/pties")
	@Produces("text/plain")      
	public int increaseTies() { return Score.WINS++;}
	     
	@POST 
	@Path("/score/plosses")
	@Produces("text/plain")         
	public int increaseLosses() {return Score.LOSSES++;}
	
	@GET
	@Path("/score")
	@Produces("application/json")
	public String getScore() {
	   String pattern = 
	      "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
	   return String.format(pattern,  Score.WINS, Score.LOSSES, Score.TIES );   
	}
	 
	@PUT
	@Path("/score/update")
	@Produces("application/json")
	public String update(@QueryParam("wins") int wins, 
	                        @QueryParam("losses") int losses, 
	                        @QueryParam("ties")   int ties) {
	   Score.WINS   = wins;
	   Score.TIES   = ties;
	   Score.LOSSES = losses;
	   String pattern = 
	      "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
	   return String.format(pattern,  Score.WINS, Score.LOSSES, Score.TIES );   
	}
	
	
}
