package com.STIW3054.Assignment2new;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import java.io.File;
import java.io.IOException;


public class PDFReader {


	
	  public static void main(String[] args) throws IOException {
		  	Thread mainThread = Thread.currentThread();

	        try (PDDocument document = PDDocument.load(new File("/Users/trina/Desktop/draft.pdf"))) {

	            document.getClass();

	            if (!document.isEncrypted()) {
				
	                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
	                stripper.setSortByPosition(true);
	                PDFTextStripper textStripper = new PDFTextStripper();
	                String pdfFileInText = textStripper.getText(document);

	                
	                TotalCourse tCourse= new TotalCourse(pdfFileInText);
	                TotalDays tDay= new TotalDays(pdfFileInText);
	                SOCCourse sCourse = new SOCCourse(pdfFileInText);
	                TotalSOCCourse tSOCCourse = new TotalSOCCourse(pdfFileInText);
	                DisplayRT dRt = new DisplayRT(pdfFileInText);
	                
	                Thread totalCourse = new Thread(tCourse);
	                totalCourse.setName("Thread 1");
	                Thread totalDays = new Thread(tDay);
	                totalDays.setName("Thread 2");
	                Thread socCourse = new Thread(sCourse);
	                socCourse.setName("Thread 3");
	                Thread totalSOCCourse = new Thread(tSOCCourse);
	                totalSOCCourse.setName("Thread 4");
	                Thread displayRealTime = new Thread(dRt);
	                displayRealTime.setName("Thread 5");
	                
	                
	                
	                totalCourse.start();
	                try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                totalDays.start();
	                try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	               
	                totalSOCCourse.start();
	                try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                
	                socCourse.start();
	                try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                try {
	                    totalSOCCourse.join(2000);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                displayRealTime.start();
	                try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                
	                
	               
	                
	                
	                
	               
	            }
	         
				

	        }

	    }
	}

