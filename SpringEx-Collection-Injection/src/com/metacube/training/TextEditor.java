package com.metacube.training;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TextEditor {
	
	private SpellChecker spellChecker;
	private String word;
	private List<String> wordsList;
	private Set<String> wordsSet;
	private Map<String, SpellChecker> spellCheckingMap;
	

	
	public SpellChecker getSpellChecker() {
		return spellChecker;
	}



	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}



	public String getWord() {
		return word;
	}



	public void setWord(String word) {
		this.word = word;
	}



	public List<String> getWordsList() {
		System.out.println("List Elements :"  + wordsList);
		return wordsList;
	}



	public void setWordsList(List<String> wordsList) {
		this.wordsList = wordsList;
	}



	public Set<String> getWordsSet() {
		System.out.println("Set Elements :"  + wordsSet);
		return wordsSet;
	}



	public void setWordsSet(Set<String> wordsSet) {
		this.wordsSet = wordsSet;
	}



	public Map<String, SpellChecker> getSpellCheckingMap() {
		System.out.println("Map Elements :"  + spellCheckingMap);
		return spellCheckingMap;
	}



	public void setSpellCheckingMap(Map<String, SpellChecker> spellCheckingMap) {
		this.spellCheckingMap = spellCheckingMap;
	}



	public void check() {
		System.out.println(spellChecker.checkSpelling() + " of " + getWord());
	}
}
