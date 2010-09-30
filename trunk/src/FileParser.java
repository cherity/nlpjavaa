/**
 * Ashish S Tomar
 * ast2124
 * NLP Assignment # 1
 * Stock market QA System
 */



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileParser {

	public static Hashtable<String,String> Verbs = new Hashtable<String,String>();
	public static Hashtable<String,String> Nouns = new Hashtable<String,String>();
	public static int cnttt=0;
	public static 	FileOutputStream fstreamOut;
	public static DataOutputStream out ;
	public static BufferedWriter brout;


	public static void main(String args[]){
		int cnt =0;

		if(args.length==2)
		{

			try
			{





				fstreamOut = new FileOutputStream("outputAnswer.txt");
				out = new DataOutputStream(fstreamOut);
				brout = new BufferedWriter(new OutputStreamWriter(out));


				POSFileReader.readFile(args[0]);



				//POSFileReader.freetextfile.add("The Rupee edged down in opposing to the dollar");
				//POSFileReader.freeposfile.add("The Rupee edged down in comparison to the dollar");


				//POSFileReader.freetextfile.add("Discount rate went to 26%");
				//POSFileReader.freeposfile.add("Nitt have been opened at 5235");

				//POSFileReader.freetextfile.add("There was rise in Discount rate, which went to 12.36%");
				//POSFileReader.freeposfile.add("Nitt have been opened at 5235");



				//POSFileReader.freetextfile.add("At the end discount rate was 243,12");
				//POSFileReader.freeposfile.add("Nitt have been opened at 52,35");

				//POSFileReader.freetextfile.add("Nitt have been open at 5235");
				//POSFileReader.freeposfile.add("[ Nitt/NNP ] have been opened at 5235");



				//POSFileReader.freetextfile.add("Nitt Industries have opened low today at 5234235");
				//POSFileReader.freeposfile.add("[ Nitt/NNP Industries/NNPS ] have bought low today at 5234235");


				//POSFileReader.freetextfile.add("Nitt Heavy Industries have opening low today at 22");
				//POSFileReader.freeposfile.add("[ Nitt/NNP Heavy/NNP Industries/NNPS ] have selling low today at 22");




				//POSFileReader.freetextfile.add("Nitt have been sold at 5235");
				//POSFileReader.freeposfile.add("[ Nitt/NNP ] have been opened at 5235");



				//POSFileReader.freetextfile.add("Nitt Industries have sold low today at 5234235");
				//POSFileReader.freeposfile.add("[ Nitt/NNP Industries/NNPS ] have bought low today at 5234235");


				//POSFileReader.freetextfile.add("Nitt Heavy Industries have sold low today at 22");
				//POSFileReader.freeposfile.add("[ Nitt/NNP Heavy/NNP Industries/NNPS ] have  selling low today at 22");

				//POSFileReader.freeposfile.add("discount rate down at 200.00. By the end discount rate was 300.00.");



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

				brout.flush();
				
				out.close();

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


	private static void parseQuestion(String str) {


		try{
			Questions q = new Questions();

			boolean flag = false;

			for(int i=0;i<q.questionList.size();i++){
				Pattern pattern = Pattern.compile(q.questionList.get(i),Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(str);

				int k=0;

				if(i==q.questionList.size()-1){
					cnttt++;

					//System.out.println("Q "+cnttt+": "+str);
					//System.out.println("A: No Information Available.");
					//System.out.println();




					brout.write("Q "+cnttt+": "+str);
					brout.newLine();
					brout.write("A: No Information Available.");
					brout.newLine();
					brout.newLine();


					return;
				}

				while (matcher.find()) {
					cnttt++;
					k++;

					//System.out.println("Q "+cnttt+": "+str);
					brout.write("Q "+cnttt+": "+str);
					brout.newLine();

					Answer answer = new Answer();
					boolean ans= answer.getAnswer(matcher,i);
					if(ans==false){
						//System.out.println("A: No Information Available.");
						brout.write("A: No Information Available.");
						brout.newLine();
					}
					//System.out.println();
					brout.newLine();
					flag=true;
				}

				if(flag){
					break;
				}


			}

		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}


	}



}
