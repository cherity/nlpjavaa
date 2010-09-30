
/**
 * Ashish S Tomar
 * ast2124
 * NLP Assignment # 1
 * Stock market QA System
 * POSFileReader.java
 */



import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class POSFileReader {

	// These Arraylists are used to store the POS Line and free text lines in a String format.
	// So we dont have to read from file again and again and can be done in a faster way from these ArrayLists.
	public static ArrayList<String> freetextfile=new ArrayList<String>();
	public static ArrayList<String> freeposfile=new ArrayList<String>();


	/*
	 * This function is called by the main class to read the POS file and generate Arraylists containing POS lines and free text lines.
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


			}

			in.close();


		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

	}

	/*
	 * This function is called by readFile() as a helper function to parse each line and save them in arrayLists.
	 */

	private static void parseEachLine(String strLine) {

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









}
