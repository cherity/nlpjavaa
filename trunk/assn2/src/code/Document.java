package code;
/*
 * Ashish Tomar
 * NLP HW 2
 * this is a class for storing the features for each review
 */
import java.util.Hashtable;

public class Document {

	public double countWords; 
	public double bicountWords; 
	public double posWords; 
	public double negWords; 
	public double neutWords;
	public double commaWords;
	public double extremeWords;
	public double notWords; 
	public int star; 
	public double NNcount; 
	public double JJcount; 
	public double RBcount; 
	public double VBcount; 
	public double DTcount; 
	public double NNpaircount; 
	public String reviewer; 
	public String id; 
	public  Hashtable<String, Integer> termFrequency;
	public  Hashtable<String, Integer> bigramtermFrequency;
	public  Hashtable<String, Integer> postermFrequency;
	public  Hashtable<String, Integer> negtermFrequency;

	public  Hashtable<String, Integer> neuttermFrequency;


	public Document(){

		star=1;
		countWords=0;
		bicountWords=0;
		posWords=0;
		negWords=0;
		neutWords=0;
		commaWords=0;
		notWords=0;
		reviewer="A";
		termFrequency= new Hashtable<String, Integer>();
		bigramtermFrequency= new Hashtable<String, Integer>();
		postermFrequency= new Hashtable<String, Integer>();
		negtermFrequency= new Hashtable<String, Integer>();
		neuttermFrequency= new Hashtable<String, Integer>();
		id="";
		NNpaircount=0;
		NNcount=0;
		JJcount=0;
		RBcount=0;
		VBcount=0;
		DTcount=0;
		extremeWords=0;

	}


}
