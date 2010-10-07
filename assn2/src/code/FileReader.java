package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader {

	public static Hashtable<String, Integer> wordList= new Hashtable<String, Integer>();
	public static Hashtable<String, Integer> poswordList= new Hashtable<String, Integer>();
	public static Hashtable<String, Integer> negwordList= new Hashtable<String, Integer>();


	

	public static FileOutputStream fstream2 ;
	public static DataOutputStream in2 ;
	public static BufferedWriter br2;

	public static void main(String args[]){

		try{

			FileInputStream fstream = new FileInputStream(args[1]);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			
			fstream2 = new FileOutputStream("output.txt");
			 in2 = new DataOutputStream(fstream2);
			 br2 = new BufferedWriter(new OutputStreamWriter(in2));
			
			String strLine;
			int cnt =0;
			Pattern pattern  = Pattern.compile(".*<star>(.*)</star><review>(.*)</review>.*");
			Matcher matcher;

			while ((strLine = br.readLine()) != null)   {

				matcher = pattern.matcher(strLine);
				while (matcher.find()) {
					cnt++;
					String star = matcher.group(1).trim();
					String match = matcher.group(2).trim();
					getCount(match,cnt,Integer.parseInt(star));
					//System.out.println (strLine);
					//System.out.println (cnt +" " +star+" "+match);
				}

			}

			printHashTable(wordList);
			br2.newLine();
			br2.newLine();
			br2.newLine();
			br2.newLine();

			printHashTable(poswordList);
			br2.newLine();
			br2.newLine();
			br2.newLine();
			br2.newLine();
			printHashTable(negwordList);

			br2.flush();
			in2.close();
			in.close();

		}catch (Exception e){

			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();

		}

	}


	private static void printHashTable(Hashtable<String, Integer> poswordList2) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("here");
		Hashtable<String, String> wordSortedList= new Hashtable<String, String>();
		Enumeration<String> e = poswordList2.keys();
		while( e. hasMoreElements() ){
			String key = (String)e.nextElement() ;
			Integer value=poswordList2.get(key);

			String mainkey = value+key;
			wordSortedList.put(mainkey, key);


		}
		Vector<String> v = new Vector<String>(wordSortedList.keySet());
		Collections.sort(v);
		Iterator<String> it = wordSortedList.keySet().iterator();

		it = v.iterator();
		while (it.hasNext()) {
			String element =  (String)it.next();
			br2.write (element + " " + (String)wordSortedList.get(element));
			br2.newLine();
		}



	}


	private static void getCount(String match, int cntt, int star) {
		System.out.print(cntt +"                     ");

		String[] bow=match.split(" ");

		for(String bowWord:bow){

			addToWordList(bowWord,wordList);

			if(star<=2){
				addToWordList(bowWord,negwordList);
			}
			else{
				addToWordList(bowWord,poswordList);
			}


		}

	}


	private static void addToWordList(String bowWord, 	Hashtable<String, Integer> wordList2) {
		if(wordList2.containsKey(bowWord)){

			Integer count = wordList2.get(bowWord);
			count++;
			wordList2.remove(bowWord);
			wordList2.put(bowWord, count);


		}
		else{
			wordList2.put(bowWord, 1);
		}

	}



}
