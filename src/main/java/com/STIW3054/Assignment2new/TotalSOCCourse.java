package com.STIW3054.Assignment2new;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TotalSOCCourse extends PDFReader implements Runnable{
	private String list;
	private String []lines;
	
	public TotalSOCCourse(String list) {
		this.list = list;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		lines = list.split("\\r?\\n");
		Pattern pattern = Pattern.compile("(ST[IQ][MSANDJKW]\\d{4}.* )");
		int socCourse = 0;
		 for(String line : lines) {
			 String word = line;
			 Matcher matcher = pattern.matcher(word);
			 while(matcher.find()) {
				 socCourse++;
			 }
		  }
		 
		 System.out.println(Thread.currentThread().getName() + "\n\nTotal SOC Courses: " + socCourse+ "\n");
		 
		 }
	}


