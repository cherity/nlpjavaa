package code;

import java.util.Hashtable;

public class Document {

	public double countWords; 
	public double bicountWords; 
	public double posWords; 
	public double negWords; 
	public double commaWords;
	public double extremeWords;
	public double notWords; 
	public int star; 
	public double NNcount; 
	public double NNpaircount; 
	public String reviewer; 
	public String id; 
	public  Hashtable<String, Integer> termFrequency;
	public  Hashtable<String, Integer> bigramtermFrequency;
	public  Hashtable<String, Integer> postermFrequency;
	public  Hashtable<String, Integer> negtermFrequency;


	public Document(){

		star=1;
		countWords=0;
		bicountWords=0;
		posWords=0;
		negWords=0;
		commaWords=0;
		notWords=0;
		reviewer="A";
		termFrequency= new Hashtable<String, Integer>();
		bigramtermFrequency= new Hashtable<String, Integer>();
		postermFrequency= new Hashtable<String, Integer>();
		negtermFrequency= new Hashtable<String, Integer>();
		id="";
		NNpaircount=0;
		NNcount=0;
		extremeWords=0;

	}


}
