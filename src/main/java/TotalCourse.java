
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TotalCourse extends PDFReader implements Runnable{
		
		private String list;
		private String []lines;
		
		public TotalCourse (String list){
			this.list  = list;
			
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			 int totalCourse = 0;
			 lines = list.split("\\r?\\n");
			 Pattern pattern = Pattern.compile("(\\w{1,3}\\d{4})"); 
			
			 
			 for(String line : lines) {
				 
				 String word = line;
				 Matcher matcher = pattern.matcher(word);
				 while(matcher.find()) {
					 totalCourse++;
				 }
			 }
			 System.out.println(Thread.currentThread().getName() + "\n\nTotal Course: " + totalCourse+ "\n");
             
			
		}
		
		
}
