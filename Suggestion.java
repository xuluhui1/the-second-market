package com.second_hand.model;

public class Suggestion {
	private int id;
	private String suggestionid;
	private String talktime;
	private String senderid;
	private int sid;
	private String receiverid;
	private String suggestioncontent;
	private String suggestionstatus;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getSuggestionid() {
		return suggestionid;
	}
	
	public void setSuggestionid(String suggestionid) {
		this.suggestionid=suggestionid;
	}
	
	public String getTalktime() {
		return talktime;
	}
	
	public void setTalktime(String talktime) {
		this.talktime=talktime;
	}
	
	public String getSenderid() {
		return senderid;
	}
	
	public void setSenderid(String senderid) {
		this.senderid=senderid;
	}
	
	public int getSid() {
		return sid;
	}
	
	public void setSid(int sid) {
		this.sid=sid;
	}
	
	public String getReceiverid() {
		return receiverid;
	}
	
	public void setReceiverid(String receiverid) {
		this.receiverid=receiverid;
	}
	
	public String getSuggestioncontent() {
		return suggestioncontent;
	}
	
	public void setSuggestioncontent(String suggestioncontent) {
		this.suggestioncontent=suggestioncontent;
	}
	public String getSuggestionstatus() {
		return suggestionstatus;
	}
	
	public void setSuggestionstatus(int suggestionstatus) {
		if(suggestionstatus==0) {
			this.suggestionstatus="回复";
		}else {
			this.suggestionstatus="";
		}
	}
}
