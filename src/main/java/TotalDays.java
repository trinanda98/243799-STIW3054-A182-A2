
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TotalDays extends PDFReader implements Runnable{
	private String list;
	private String []lines;
	
	public TotalDays(String list) {
		this.list = list;
	}
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		lines = list.split("\\r?\\n");
		Pattern pattern = Pattern.compile("(\\d{1,2}/\\d{1,2}/\\d{4})");
		String dates = "";
		 for(String line : lines) {
			 
			 String word = line;
			 Matcher matcher = pattern.matcher(word);
			 while(matcher.find()) {
				 dates +="\n" + matcher.group().trim();
				 
			 }
		 }
		
		 String [] date = dates.split("\n");
	     date = Arrays.stream(date).distinct().toArray(String[]::new);
	     int length =  date.length-1;
		 System.out.println(Thread.currentThread().getName() + "\n\nTotal Exam Days: " + length+ "\n");
		
	}

}
