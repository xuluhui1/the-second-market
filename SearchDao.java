package com.second_hand.dao;

import java.util.List;

import com.second_hand.model.Bbs;
import com.second_hand.model.Suggestion;

public abstract class SearchDao {
	public abstract List<Bbs>SearchBbsString(String keyword);
	public abstract List<Suggestion>SearchSuggestionString(String keyword);
}
