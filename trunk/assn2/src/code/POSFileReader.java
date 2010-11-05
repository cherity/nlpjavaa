package code;
/*
 * Ashish Tomar
 * NLP HW 2
 * The file to calculate POS features for the reviews
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class POSFileReader {


	/*
	 * This function reads a POS tagged file and calculates the counts for POS Tags.
	 */
	public void getCount(String fileName) {
		// TODO Auto-generated method stub
		try{


			FileInputStream fstream = new FileInputStream(fileName);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String strLine;


			Document d = new Document();
			while ((strLine = br.readLine()) != null)   {
				if(!strLine.equalsIgnoreCase("")){
					//System.out.println(strLine);

					if(strLine.contains(" <<")){
						d = getDocument(strLine);
					}else if(strLine.contains(">> END")){
						//store the values
					}
					else{
						parseLineforNN(strLine, d);
						parseLineforJJ(strLine, d);
						parseLineforRB(strLine, d);
						parseLineforVB(strLine, d);
						parseLineforDT(strLine, d);
						parseLineforNNpair(strLine, d);
					}
				}
			}

		}catch (Exception e){

			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();

		}
	}

	/*
	 * This function calculates the count of Adverbs.
	 */
	public void parseLineforRB(String strLine, Document d) {
		// TODO Auto-generated method stub
		Pattern pattern  = Pattern.compile("/RB");
		Matcher matcher;
		matcher = pattern.matcher(strLine);
		double cnt=0;
		while (matcher.find()) {

			cnt++;

		}
		d.RBcount+=cnt;

	}

	/*
	 * This function calculates the count of Determiners.
	 */
	public void parseLineforDT(String strLine, Document d) {
		// TODO Auto-generated method stub
		Pattern pattern  = Pattern.compile("/DT");
		Matcher matcher;
		matcher = pattern.matcher(strLine);
		double cnt=0;
		while (matcher.find()) {

			cnt++;

		}
		d.DTcount+=cnt;

	}

	/*
	 * This function calculates the count of Verbs.
	 */
	public void parseLineforVB(String strLine, Document d) {
		// TODO Auto-generated method stub
		Pattern pattern  = Pattern.compile("/VB");
		Matcher matcher;
		matcher = pattern.matcher(strLine);
		double cnt=0;
		while (matcher.find()) {

			cnt++;

		}
		d.VBcount+=cnt;

	}

	/*
	 * This function calculates the count of Adjectives.
	 */

	public void parseLineforJJ(String strLine, Document d) {
		// TODO Auto-generated method stub
		Pattern pattern  = Pattern.compile("/JJ");
		Matcher matcher;
		matcher = pattern.matcher(strLine);
		double cnt=0;
		while (matcher.find()) {

			cnt++;

		}
		d.JJcount+=cnt;

	}

	/*
	 * This function retrieves the record for a given review id.
	 */
	public Document getDocument(String strLine) {
		Document dd= new Document();
		Pattern pattern  = Pattern.compile("(.*) <<");
		Matcher matcher;
		matcher = pattern.matcher(strLine);
		while (matcher.find()) {

			String id = matcher.group(1).trim();

			for(Document ddd:CountGenerator.docList){
				if(ddd.id.equalsIgnoreCase(id)){
					dd=ddd;
				}
			}

		}
		return dd;
	}


	/*
	 * This function calculates the count of Nouns.
	 */
	public void parseLineforNN(String strLine, Document d) {

		Pattern pattern  = Pattern.compile("/NN");
		Matcher matcher;
		matcher = pattern.matcher(strLine);
		double cnt=0;
		while (matcher.find()) {

			cnt++;


		}
		d.NNcount+=cnt;

		//System.out.println(d.id+"  "+d.NNcount+"  "+cnt);

	}



	/*
	 * This function calculates the count of NN : JJ pair or NN: NN pair
	 */
	public void parseLineforNNpair(String strLine, Document d) {

		Pattern pattern  = Pattern.compile("/NN :/: [A-Za-z-]*/(JJ|NN)");
		Matcher matcher;
		matcher = pattern.matcher(strLine);
		double cnt=0;
		while (matcher.find()) {

			cnt++;


		}
		d.NNpaircount+=cnt;

		//System.out.println(d.id+"  "+d.NNpaircount+"  "+cnt);

	}


}
