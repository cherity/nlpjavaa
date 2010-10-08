package code;

import java.util.Hashtable;

public class Document {

	public double countWords; 
	public  Hashtable<String, Integer> termFrequency;
	
	public Document(){
		countWords=0;
		termFrequency= new Hashtable<String, Integer>();
		
	}
	
	
}
