package code;

import java.util.Hashtable;

public class Document {

	public double countWords; 
	public double posWords; 
	public double negWords; 
	public int star; 
	public  Hashtable<String, Integer> termFrequency;

	public Document(){
		star=1;
		countWords=0;
		posWords=0;
		negWords=0;
		termFrequency= new Hashtable<String, Integer>();

	}


}
