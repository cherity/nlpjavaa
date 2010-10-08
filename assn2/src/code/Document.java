package code;

import java.util.Hashtable;

public class Document {

	public double countWords; 
	public int star; 
	public  Hashtable<String, Integer> termFrequency;

	public Document(){
		star=1;
		countWords=0;
		termFrequency= new Hashtable<String, Integer>();

	}


}
