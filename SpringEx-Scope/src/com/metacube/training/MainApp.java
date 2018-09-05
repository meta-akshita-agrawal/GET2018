package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		TextEditor textEditorS = (TextEditor) context.getBean("textEditorSingleton");
		textEditorS.getWord();
		textEditorS.setWord("newValue");
		textEditorS.getWord();
		
		TextEditor textEditorP = (TextEditor) context.getBean("textEditorSingleton");
		textEditorP.getWord();
		textEditorP.setWord("newValue");
		textEditorP.getWord();
		
	}
}
