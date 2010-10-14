package code;

import java.util.Hashtable;

public class Document {

	public double countWords; 
	public double posWords; 
	public double negWords; 
	public double commaWords;
	public double notWords; 
	public int star; 
	public  Hashtable<String, Integer> termFrequency;

	public  Hashtable<String, Integer> postermFrequency;

	public  Hashtable<String, Integer> negtermFrequency;

	public Document(){
		star=1;
		countWords=0;
		posWords=0;
		negWords=0;
		commaWords=0;
		notWords=0;
		termFrequency= new Hashtable<String, Integer>();
		postermFrequency= new Hashtable<String, Integer>();

		negtermFrequency= new Hashtable<String, Integer>();

	}


}
