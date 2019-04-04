package com.STIW3054.Assignment2new;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DisplayRT extends PDFReader implements Runnable {
	private String list;
	private String []lines;
	
	public DisplayRT(String list) {
		this.list = list;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		lines = list.split("\\r?\\n");
		Pattern pattern = Pattern.compile("(\\STIW3054 )");
		 for(String line : lines) {
			 String word = line;
			 Matcher m = pattern.matcher(word);
			 while(m.find()) {
				 String realtimeInfo = word;
				 System.out.print(Thread.currentThread().getName() + "\n\nReal Time Programming Info: ");
				 System.out.println(realtimeInfo + "\n");
			 }
		  }
		 
		 
		 
		 }
	}


