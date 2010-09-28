import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class POSFileReader {

	public static ArrayList<String> freetextfile=new ArrayList<String>();
	public static ArrayList<String> freeposfile=new ArrayList<String>();

	//public static String[] ast;
	/*
	 public static void main(String args[]){
		//readFile(args[0]);
		readFileAgain(args[0]);
	}
	 */


	public static void readFile(String fileName) {
		int cnt=0;
		try{


			FileInputStream fstream = new FileInputStream(fileName);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null)
			{
				cnt++;
				//System.out.println(strLine);
				freeposfile.add(strLine);
				parseEachLine(strLine);

				//		if(cnt==2)
				//		break;
			}

			in.close();


		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

	}



	private static void parseEachLine(String strLine) {
		// TODO Auto-generated method stub

		//System.out.println(strLine);
		strLine=strLine.replaceAll("\\\\/", "yesssrandomsss");
		String[] words =strLine.split("(/.*? |/.*?$)");
		String line2="";
		int cnt2=0;


		for(String word: words){
			//System.out.println(word);
			cnt2++;
			//if(cnt2==3)
			//break;
			word = word.replaceAll("\\s", "");
			word = word.replaceAll("yesssrandomsss", "/");
			if(cnt2==1||word.startsWith("'")||word.startsWith(",")||word.startsWith(".")||word.startsWith("%")||word.startsWith("n't")||word.startsWith("'t")){
				line2= line2+word;
			}
			else{
				line2=line2+" "+word;


			}

		}

		line2=line2.replaceAll("\\( ", "\\(");
		line2=line2.replaceAll(" \\)", "\\)");
		line2=line2.replaceAll("\\$ ", "\\$");
		//System.out.print(line2);

		//System.out.println();
		String line="";
		int cnt =0;
		for(String word: words){
			//System.out.println(word);
			cnt++;
			word=	word.replace("] ","");
			word = word.replaceAll("yesssrandomsss", "/");
			word=word.replace("[ ","");
			word = word.replaceAll("\\s", "");
			if(cnt==1||word.startsWith("'")||word.startsWith(",")||word.startsWith(".")||word.startsWith("%")||word.startsWith("n't")||word.startsWith("'t")){
				line= line+word;
			}
			else{
				line=line+" "+word;


			}
			//System.out.println(word);
		}
		line=line.replaceAll("\\( ", "\\(");
		line=line.replaceAll(" \\)", "\\)");
		line=line.replaceAll("\\$ ", "\\$");
		//System.out.println(line);
		freetextfile.add(line);
		//System.out.println();

	}




	public static void readFileAgain(String fileName) {
		int cnt=0;
		try{


			FileInputStream fstream = new FileInputStream(fileName);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null)
			{
				cnt++;
				//System.out.println(cnt);
				//System.out.println(strLine);
				parseEachLinePhrase(strLine);
				//if(cnt==2)
				//break;
			}

			in.close();



		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

	}



	private static void parseEachLinePhrase(String strLine) {
		// TODO Auto-generated method stub

		Questions question = new Questions();
		Pattern pattern = Pattern.compile("(\\[.*?\\])",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
		Pattern pattern2 = Pattern.compile(".*(\\[.*?[iI]ndex.*?\\]).*"+question.posVerbs+".*?",Pattern.DOTALL);
		Pattern pattern3 = Pattern.compile(".*(\\[.*?[iI]ndex.*?\\]).*?"+question.negVerbs+".*?",Pattern.DOTALL);

		Matcher matcher = pattern.matcher(strLine);
		Matcher matcher2 = pattern2.matcher(strLine);
		Matcher matcher3 = pattern3.matcher(strLine);


		//System.out.println("");
		//System.out.println("match1");
		/*while (matcher.find()) {

			String match = matcher.group(1).trim();
			//System.out.println(match);
			//System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");

		}*/



		while (matcher2.find()) {
			System.out.println("");



			System.out.println("pos match");
			String match = matcher2.group(1).trim();
			String matchFull = matcher2.group().trim();
			System.out.println(match);
			System.out.println(matchFull);
			//System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
			System.out.println("------------");
		}



		while (matcher3.find()) {
			System.out.println("");



			System.out.println("neg match");
			String match = matcher3.group(1).trim();
			System.out.println(match);
			//System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
			System.out.println("------------");
		}


	}





}
