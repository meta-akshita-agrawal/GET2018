package com.metacube.training;

public class TextEditor {
	
	private SpellChecker spellChecker;
	private String word;
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}
	
	public void check() {
		System.out.println(spellChecker.checkSpelling() + " of " + getWord());
	}
}
