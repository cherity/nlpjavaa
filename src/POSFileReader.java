import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class POSFileReader {

	public static ArrayList<String> freetextfile=new ArrayList<String>();

	public static void main(String args[]){
		readFile(args[0]);

	}



	private static void readFile(String fileName) {
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
				parseEachLine(strLine);
				//		if(cnt==2)
				//		break;
			}

			in.close();



			//System.out.println();
			//System.out.println("Verbs "+Verbs.size());
			//printTable(Verbs);
			//System.out.println();
			//System.out.println("Nouns "+Nouns.size());
			//printTable(Nouns);


		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

	}



	private static void parseEachLine(String strLine) {
		// TODO Auto-generated method stub

		System.out.println(strLine);
		strLine=strLine.replaceAll("\\\\/", "yessss");
		String[] words =strLine.split("(/.*? |/.*?$)");
		String line2="";
		int cnt2=0;
		/*		
		for(String word: words){
			System.out.println(word);
			cnt2++;
			if(cnt2==3)
				break;
			word = word.replaceAll("\\s", "");
			if(cnt2==1||word.startsWith("'")||word.startsWith(",")||word.startsWith(".")){
				line2= line2+word;
			}
			else{
				line2=line2+" "+word;

			}
			System.out.print(line2);
		}*/

		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX   $SIGN ()inner side

		for(String word: words){
			//System.out.println(word);
			cnt2++;
			//if(cnt2==3)
			//break;
			word = word.replaceAll("\\s", "");
			word = word.replaceAll("yessss", "/");
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
		System.out.print(line2);

		System.out.println();
		String line="";
		int cnt =0;
		for(String word: words){
			//System.out.println(word);
			cnt++;
			word=	word.replace("] ","");
			word = word.replaceAll("yessss", "/");
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
		System.out.println(line);
		freetextfile.add(line);
		System.out.println();

	}

}
