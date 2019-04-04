import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SOCCourse extends PDFReader implements Runnable {
	private String list;
	private String []lines;
	
	public SOCCourse(String list) {
		this.list = list;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		lines = list.split("\\r?\\n");
		Pattern pattern = Pattern.compile("(ST[IQ][MSANDJKW]\\d{4}.* )");
		String socCourse = "";
		 for(String line : lines) {
			 String word = line;
			 Matcher matcher = pattern.matcher(word);
			 while(matcher.find()) {
				 socCourse +="\n" + matcher.group().trim();
			 }
			 
				 
			 
				 
			 }
		 	System.out.println(Thread.currentThread().getName() + "\n\nList Of SOC Courses: ");
		 	System.out.println(socCourse+ "\n");
		 }
	}


