import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileParser {

	public static Hashtable<String,String> Verbs = new Hashtable<String,String>();
	public static Hashtable<String,String> Nouns = new Hashtable<String,String>();
	public static int cnttt=0;


	public static void main(String args[]){
		int cnt =0;

		if(args.length==2)
		{

			try
			{

				//POSFileReader posfi=new POSFileReader();
				POSFileReader.readFile(args[0]);

				//POSFileReader.freetextfile.add("discount rate was 235");
				//POSFileReader.freeposfile.add("Nitt opened at 235");


				//POSFileReader.freetextfile.add("discount rate, finished at 78235");
				//POSFileReader.freeposfile.add("Nitt, sold at 5235");


				//POSFileReader.freeposfile.add("discount rate down at 200.00. By the end discount rate was 300.00.");
				
				
				/*if(POSFileReader.freetextfile.size()==POSFileReader.freeposfile.size()){
					System.out.println("Size Equal");
				}
				else{
					System.out.println("Not Equal");
				}*/

				FileInputStream fstream2 = new FileInputStream(args[1]);
				DataInputStream in2 = new DataInputStream(fstream2);
				BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
				String strLine2;
				while ((strLine2 = br2.readLine()) != null)
				{
					//cnt++;
					//System.out.println(strLine2);
					parseQuestion(strLine2);
					//if(cnt==4)
					//	break;
				}

				in2.close();


				FileInputStream fstream = new FileInputStream(args[0]);
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String strLine;
				while ((strLine = br.readLine()) != null)
				{
					cnt++;
					//System.out.println(strLine);
					parseLine(strLine);
					//if(cnt==4)
					//	break;
				}

				in.close();


			}
			catch (Exception e)
			{
				System.err.println("Error: " + e.getMessage());
				e.printStackTrace();
			}


		}
		else
		{
			System.out.println("Usage--");
			System.out.println("First parameter -- Input POS file");
			System.out.println("Second parameter -- Question file");

		}
	}



	/*
	private static void printTable(Hashtable<String,String> ht) {


		Enumeration<String> e = ht.keys();
		while( e. hasMoreElements() ){
			System.out.println( e.nextElement() );
		}

	}

	 */
	private static void parseLine(String strLine) {
		try {

			String st[] =strLine.split(" ");
			for(int i=0;i<st.length;i++){

				getVerbs(st[i]);

				getNouns(st[i]);

			}
		} catch (Exception e) {
		}

	}


	private static void getVerbs(String str) {
		Pattern pattern = Pattern.compile("(.*)/VB");
		Matcher matcher = pattern.matcher(str);

		// Find all matches
		while (matcher.find()) {
			// Get the matching string
			String match = matcher.group(1);
			if(!Verbs.containsKey(match))
				Verbs.put(match, "1");
			//System.out.println(match);
		}
	}



	private static void getNouns(String str) {
		Pattern pattern = Pattern.compile("(.*)/NN");
		Matcher matcher = pattern.matcher(str);

		// Find all matches
		while (matcher.find()) {
			// Get the matching string
			String match = matcher.group(1);
			if(!Nouns.containsKey(match))
				Nouns.put(match, "1");
			//System.out.println(match);
		}
	}




	private static void parseQuestion(String str) {
		// TODO Auto-generated method stub
		Questions q= new Questions();


		for(int i=0;i<q.questionList.size();i++){
			Pattern pattern = Pattern.compile(q.questionList.get(i),Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(str);

			while (matcher.find()) {
				cnttt++;
				System.out.println();
				System.out.println(cnttt+". "+str);
				//System.out.println(match);
				Answer answer = new Answer();
				boolean ans= answer.getAnswer(matcher,i);
				if(ans==false){
					System.out.println("No Information Available.");
				}

			}

		}


	}







}
