package com.second_hand.demo;

public class KeyWordTurnRedTools {
	public String KeyWordTurnRedTools(String message,String keyword) {
		String result=new String(); 
		result=message.replaceAll(keyword, "<font color=\"red\">"+keyword+"</font>");
		return result;
	}
}
