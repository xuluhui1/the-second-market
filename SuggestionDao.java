package com.second_hand.dao;

import java.util.List;

import com.second_hand.model.Suggestion;

public abstract class SuggestionDao {
	public abstract int insertSuggestion(Suggestion suggestion);//增
	public abstract int removeSuggestionById(int id);//删
	public abstract int updateSUggestion(Suggestion suggestion);//改
	public abstract List<Suggestion> selectSuggestion();//查
	public abstract int insertASuggestion(Suggestion suggestion);
	public abstract int updateStatus(int suggestionid);
}
