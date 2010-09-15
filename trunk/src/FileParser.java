import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileParser {

	public static Hashtable Verbs = new Hashtable();
	public static Hashtable Nouns = new Hashtable();

	public static void main(String args[]){
		int cnt =0;

		if(args.length==3)
		{


			try
			{


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



				System.out.println();
				System.out.println("Verbs "+Verbs.size());
				//printTable(Verbs);
				System.out.println();
				System.out.println("Nouns "+Nouns.size());
				//printTable(Nouns);


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
			System.out.println("Third parameter -- Input Text file");
		}
	}




	private static void printTable(Hashtable ht) {


		Enumeration e = ht.keys();
		while( e. hasMoreElements() ){
			System.out.println( e.nextElement() );
		}

	}


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
			Pattern pattern = Pattern.compile(q.questionList.get(i));
			Matcher matcher = pattern.matcher(str);

			while (matcher.find()) {

				System.out.println();
				System.out.println(str);
				//System.out.println(match);
				boolean ans= getAnswer(matcher,i);
				if(ans==false){
					System.out.println("No Information Available.");
				}

			}

		}


	}




	private static boolean getAnswer(Matcher matcherr, int casei) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int cntLine=0;
		int cnt=0;
		try{

			String nounCase = matcherr.group(1);


			FileInputStream fstream = new FileInputStream("inputfile.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null)
			{
				cntLine++;
				if(casei==0){


					Pattern pattern = Pattern.compile("("+nounCase+" .*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
					Matcher matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						String match = matcher.group(1).trim();

						System.out.println("A "+cnt+": "+match+".");
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
					}

					//System.out.println(strLine);

				}





				if(casei==1){


					String caseQ = matcherr.group(2);
					//Pattern pattern = Pattern.compile("("+nounCase+"[^,\\.]*? (fall|fell|loose|lost) .*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
					Pattern pattern = Pattern.compile(""+nounCase+" [^,\\.]*?(fall|fell|loose|lost) ([0-9\\s.,/]*).*?(,\\s|\\.($|\\s))",Pattern.DOTALL);



					Matcher matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						String match = matcher.group(2).trim();
						char[] trimarr= match.toCharArray();
						if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
							System.out.print("A "+cnt+": ");
							for(int l=0;l<trimarr.length-1;l++){
								System.out.print(trimarr[l]);
							}
							System.out.println(".");
						}
						else{
							System.out.println("A "+cnt+": "+match+".");
						}
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
					}

					//System.out.println(strLine);

				}







				if(casei==2){


					String caseQ = matcherr.group(2);
					//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
					Pattern pattern = Pattern.compile(""+nounCase+" [^,\\.]*?(rise|gain|gained|rose) ([0-9\\s.,/]*).*?(,\\s|\\.($|\\s))",Pattern.DOTALL);
					Matcher matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						String match = matcher.group(2).trim();

						char[] trimarr= match.toCharArray();
						if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
							System.out.print("A "+cnt+": ");
							for(int l=0;l<trimarr.length-1;l++){
								System.out.print(trimarr[l]);
							}
							System.out.println(".");
						}
						else{
							System.out.println("A "+cnt+": "+match+".");
						}
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
					}

					//System.out.println(strLine);

				}





			}

			in.close();

			return flag;



		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
			return false;
		}


	}






}
