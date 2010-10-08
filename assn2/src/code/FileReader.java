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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader {

	public static Hashtable<String, Integer> wordList= new Hashtable<String, Integer>();

	public static Hashtable<String, ArrayList<Integer>> docFrequency= new Hashtable<String, ArrayList<Integer>>();

	public static Hashtable<String, Integer> poswordList= new Hashtable<String, Integer>();
	public static Hashtable<String, Integer> negwordList= new Hashtable<String, Integer>();
	public static ArrayList<Document> docList= new ArrayList<Document>();

	public static double wordCnt=0, wordFromPos=0,wordFromNeg=0;


	public static FileOutputStream fstream2 ;
	public static DataOutputStream in2 ;
	public static BufferedWriter br2;

	public static FileOutputStream fstream3 ;
	public static DataOutputStream in3 ;
	public static BufferedWriter br3;


	public static void main(String args[]){

		try{

			FileInputStream fstream = new FileInputStream(args[1]);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));


			fstream2 = new FileOutputStream("output.txt");
			in2 = new DataOutputStream(fstream2);
			br2 = new BufferedWriter(new OutputStreamWriter(in2));





			fstream3 = new FileOutputStream("outputFile.arff");
			in3 = new DataOutputStream(fstream3);
			br3 = new BufferedWriter(new OutputStreamWriter(in3));


			String strLine;
			int cnt =0,negCnt=0,posCnt=0;
			Pattern pattern  = Pattern.compile(".*<star>(.*)</star><review>(.*)</review>.*");
			Matcher matcher;

			while ((strLine = br.readLine()) != null)   {

				matcher = pattern.matcher(strLine);
				while (matcher.find()) {
					cnt++;
					String star = matcher.group(1).trim();
					int starr=Integer.parseInt(star);
					if(starr<=2){
						negCnt++;
					}
					else{
						posCnt++;
					}
					String match = matcher.group(2).trim();
					getCount(match,cnt,starr);
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


			System.out.println("Total Docs- "+cnt);
			System.out.println("Avg doc length- "+wordCnt/cnt);
			logln();


			System.out.println("Total neg Docs- "+negCnt);
			System.out.println("Avg neg doc length- "+wordFromNeg/negCnt);
			logln();


			System.out.println("Total pos Docs- "+posCnt);
			System.out.println("Avg pos doc length- "+wordFromPos/posCnt);
			logln();

			printDocList();



			br2.flush();
			in2.close();
			br3.flush();
			in3.close();
			in.close();

		}catch (Exception e){

			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();

		}

	}




	private static void printDocList() {
		// TODO Auto-generated method stub

		for(Document d : docList){
			logln(d.countWords);
		}


	}




	private static void printHashTable(Hashtable<String, Integer> poswordList2) throws IOException {

		//System.out.println("here");
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

		String[] bow=match.split(" ");

		Document d= new Document();
		d.countWords=bow.length;

		docList.add(d);

		for(String bowWord:bow){

			addToWordList(bowWord,wordList);
			addToDocFreqTracker(bowWord,cntt);
			wordCnt++;
			addTerm(bowWord,d);

			if(star<=2){
				addToWordList(bowWord,negwordList);
				wordFromNeg++;
			}
			else{
				addToWordList(bowWord,poswordList);
				wordFromPos++;
			}


		}

	}



	private static void addToDocFreqTracker(String bowWord, int cntt) {
		if(docFrequency.containsKey(bowWord)){

			ArrayList<Integer> list = docFrequency.get(bowWord);
			if(list.contains(cntt)){

			}
			else{
				list.add(cntt);
			}

			docFrequency.remove(bowWord);
			docFrequency.put(bowWord, list);


		}
		else{
			ArrayList<Integer> list = new 	ArrayList<Integer> ();
			list.add(cntt);
			docFrequency.put(bowWord, list);

		}

	}


	private static void addTerm(String bowWord, Document d) {

		if(d.termFrequency.containsKey(bowWord)){

			Integer count = d.termFrequency.get(bowWord);
			count++;
			d.termFrequency.remove(bowWord);
			d.termFrequency.put(bowWord, count);


		}
		else{
			d.termFrequency.put(bowWord, 1);
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





	private static void logln(String string) {
		System.out.println(string);
	}

	private static void logln(int cnt) {
		System.out.println(cnt);
	}

	private static void logln(double cnt) {
		System.out.println(cnt);
	}

	private static void logln() {
		System.out.println();
	}



	private static void log(String string) {
		System.out.print(string);
	}

	private static void log(int cnt) {
		System.out.print(cnt);
	}

	private static void log(double cnt) {
		System.out.print(cnt);
	}

	private static void log() {
		System.out.print("");
	}


}
