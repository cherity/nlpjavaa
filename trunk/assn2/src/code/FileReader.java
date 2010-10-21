package code;

import java.io.BufferedReader;

import edu.stanford.nlp.trees.*; 
import edu.stanford.nlp.process.*;
import edu.stanford.nlp.objectbank.TokenizerFactory;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class FileReader {

	public static int FEATcnt =2001;
	public static String outFile="outputArff"+FEATcnt+"each_tfidf_WITHout_PORTER.arff";
	

	public static FileOutputStream fstream2 ;
	public static DataOutputStream in2 ;
	public static BufferedWriter br2;

	public static FileOutputStream fstream3 ;
	public static DataOutputStream in3 ;
	public static BufferedWriter br3;

	public static Integer[] wordlistvals;
	public static String[] wordlistkeys;




	public static Integer[] poswordlistvals;
	public static String[] poswordlistkeys;



	public static Integer[] negwordlistvals;
	public static String[] negwordlistkeys;


	public static void main(String args[]){

		try{


			//LexicalizedParser lp = new LexicalizedParser("englishPCFG.ser.gz"); 
			//TokenizerFactory tf = PTBTokenizer.factory(false, new WordTokenFactory());
			//TreePrint tp = new TreePrint("penn,typedDependenciesCollapsed");

			FileInputStream fstream = new FileInputStream(args[1]);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));


			fstream2 = new FileOutputStream("output2.txt");
			in2 = new DataOutputStream(fstream2);
			br2 = new BufferedWriter(new OutputStreamWriter(in2));


			fstream3 = new FileOutputStream(outFile);
			in3 = new DataOutputStream(fstream3);
			br3 = new BufferedWriter(new OutputStreamWriter(in3));

			CountGenerator cg = new CountGenerator();

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
					cg.getCount(match,cnt,starr);

					//System.out.println (strLine);
					//System.out.println (cnt +" " +star+" "+match);
					/*
					String ss[]=match.split("\\.");
					for(String match2 :ss){
						System.out.println(match2);
					//List tokens = tf.getTokenizer(new StringReader(match)).tokenize(); 
					//lp.parse(tokens); // parse the tokens
					//Tree t = lp.getBestParse(); // get the best parse tree
					//System.out.println("\nPROCESSED:\n\n"); tp.printTree(t);

					}*/


				}
				//if(cnt==1){
				//break;
				//}

			}

			printHashTable(cg.wordList);
			br2.newLine();
			br2.newLine();
			br2.newLine();
			br2.newLine();

			printHashTable(cg.poswordList);
			br2.newLine();
			br2.newLine();
			br2.newLine();
			br2.newLine();

			printHashTable(cg.negwordList);


			System.out.println("Total Docs- "+cnt);
			cg.docCount=cnt;
			System.out.println(" doc cnt- "+cg.wordCnt);
			System.out.println("Avg doc length- "+cg.wordCnt/cnt);
			logln();


			System.out.println("Total neg Docs- "+negCnt);
			System.out.println(" neg doc cnt- "+cg.wordFromNeg);
			System.out.println("Avg neg doc length- "+cg.wordFromNeg/negCnt);
			logln();


			System.out.println("Total pos Docs- "+posCnt);
			System.out.println(" neg doc cnt- "+cg.wordFromPos);
			System.out.println("Avg pos doc length- "+cg.wordFromPos/posCnt);
			logln();



			System.out.println("Total cntposwordList Docs- "+cg.cntposwordList.size());

			System.out.println("Total cntnegwordList Docs- "+cg.cntnegwordList.size());

			printDocList2(cg);



			/*
			for(Document d : cg.docList){
				br2.newLine();
				br2.newLine();
				br2.write(d.star+" --- pos");
				br2.newLine();
				printHashTable(d.postermFrequency);
				br2.newLine();
				br2.newLine();
				br2.write(d.star+" --- neg");
				br2.newLine();
				printHashTable(d.negtermFrequency);
				br2.newLine();
				br2.newLine();
				br2.write(d.star+" --- all");
				br2.newLine();
				printHashTable(d.termFrequency);
				br2.newLine();
				br2.newLine();
			}
			 */
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




	private static void printDocList(CountGenerator cg ) throws IOException {

		br3.write("@RELATION moviestraining");
		br3.newLine();
		br3.newLine();
		br3.newLine();

		/*
		Enumeration<String> e = docFrequency.keys();
		while( e. hasMoreElements() ){
			ccnt++;

			if(ccnt==1000)
				break;

			String key = (String)e.nextElement() ;

			br3.write("@ATTRIBUTE "+key+" NUMERIC");
			br3.newLine();


		}
		 */

		Enumeration<String> ee;


		br3.write("@ATTRIBUTE doclength NUMERIC");
		br3.newLine();

		br3.write("@ATTRIBUTE posword NUMERIC");
		br3.newLine();

		br3.write("@ATTRIBUTE negword NUMERIC");
		br3.newLine();

		br3.write("@ATTRIBUTE diff NUMERIC");
		br3.newLine();
		br3.write("@ATTRIBUTE diffneg NUMERIC");
		br3.newLine();

		br3.write("@ATTRIBUTE classFinal {1,2,3,4}");
		br3.newLine();

		br3.newLine();
		br3.newLine();
		br3.write("@DATA");
		br3.newLine();
		br3.flush();


		for(Document d : cg.docList){
			/*
			ee= docFrequency.keys();
			ccnt=0;

			while( ee. hasMoreElements() ){
				String key = (String)ee.nextElement() ;

				ccnt++;

				if(ccnt==1000)
					break;

				if(d.termFrequency.containsKey(key)){

					int termCount=d.termFrequency.get(key);
					double tf=termCount/d.countWords;

					ArrayList<Integer> listt=docFrequency.get(key);

					double df=Math.log(docCount/listt.size());
					double tfidf=tf*df;

					br3.write(tfidf+",");
				}
				else{
					br3.write(0+",");
				}




			}

			 */

			//System.out.println("finished");
			br3.write(d.countWords+",");
			br3.write((d.posWords)/d.countWords+",");
			br3.write((d.negWords)/d.countWords+",");

			if(((d.posWords/d.countWords)-(d.negWords/d.countWords))>0){
				br3.write((d.posWords/d.countWords)-(d.negWords/d.countWords)+",");
				br3.write(0+",");
			}
			else{
				br3.write(0+",");
				br3.write((d.negWords/d.countWords)-(d.posWords/d.countWords)+",");
			}


			String sstar=""+d.star;
			br3.write(sstar);

			br3.newLine();
			br3.flush();

		}


	}








	private static void printDocList2(CountGenerator cg ) throws IOException {
		// TODO Auto-generated method stub

		br3.write("@RELATION moviestraining");
		br3.newLine();
		br3.newLine();
		br3.newLine();

		int ccnt=0;





		wordlistkeys = new String[cg.wordList.size()];
		Enumeration en=cg.wordList.keys();
		int kk=0;
		while( en. hasMoreElements() ){
			wordlistkeys[kk] = (String)en.nextElement() ;
			kk++;
		}

		wordlistvals = new Integer[cg.wordList.size()];
		Enumeration env=cg.wordList.keys();
		int kkk=0;
		while( env. hasMoreElements() ){
			String keyss = (String)env.nextElement() ;
			wordlistvals[kkk]=cg.wordList.get(keyss);
			kkk++;
		}


		bubbleSort1();



		sortpos(cg);

		sortneg(cg);

		//printArray();

		/*
		for(String key :cg.posWords){

			br3.write("@ATTRIBUTE "+key+" NUMERIC");
			br3.newLine();

		}



		for(String key :cg.negWords){

			br3.write("@ATTRIBUTE "+key+" NUMERIC");
			br3.newLine();

		}
		 */

		int cSize=FEATcnt;
		if(poswordlistkeys.length<cSize-1){
			cSize=poswordlistkeys.length+1;
		}
		for(int i=(poswordlistkeys.length-1);i>(poswordlistkeys.length-cSize);i--){

			br3.write("@ATTRIBUTE "+poswordlistkeys[i]+" NUMERIC");
			br3.newLine();


		}


		int cSizeNeg=FEATcnt;
		if(negwordlistkeys.length<cSizeNeg-1){
			cSizeNeg=negwordlistkeys.length+1;
		}
		for(int i=(negwordlistkeys.length-1);i>(negwordlistkeys.length-cSizeNeg);i--){

			br3.write("@ATTRIBUTE "+negwordlistkeys[i]+" NUMERIC");
			br3.newLine();


		}


		int cSizet=FEATcnt;
		if(wordlistkeys.length<cSizet){
			cSizet=wordlistkeys.length+1;
		}
		for(int i=(wordlistkeys.length-1);i>(wordlistkeys.length-cSizet);i--){
			if((!cg.negWords.contains(wordlistkeys[i])) && (!cg.posWords.contains(wordlistkeys[i]))){
				br3.write("@ATTRIBUTE "+wordlistkeys[i]+" NUMERIC");
				br3.newLine();
			}

		}


		br3.write("@ATTRIBUTE doclength NUMERIC");
		br3.newLine();

		br3.write("@ATTRIBUTE posword NUMERIC");
		br3.newLine();

		br3.write("@ATTRIBUTE negword NUMERIC");
		br3.newLine();

		/*br3.write("@ATTRIBUTE diff NUMERIC");
		br3.newLine();
		br3.write("@ATTRIBUTE diffneg NUMERIC");
		br3.newLine();
		 */


		br3.write("@ATTRIBUTE notWord NUMERIC");
		br3.newLine();


		br3.write("@ATTRIBUTE commaWord NUMERIC");
		br3.newLine();

		br3.write("@ATTRIBUTE classFinal {0,1}");
		br3.newLine();

		br3.newLine();
		br3.newLine();
		br3.write("@DATA");
		br3.newLine();
		br3.flush();


		for(Document d : cg.docList){
			/*
			ee= docFrequency.keys();
			ccnt=0;

			while( ee. hasMoreElements() ){
				String key = (String)ee.nextElement() ;

				ccnt++;

				if(ccnt==1000)
					break;

				if(d.termFrequency.containsKey(key)){

					int termCount=d.termFrequency.get(key);
					double tf=termCount/d.countWords;

					ArrayList<Integer> listt=docFrequency.get(key);

					double df=Math.log(docCount/listt.size());

					double tfidf=tf*df;

					br3.write(tfidf+",");
				}
				else{
					br3.write(0+",");
				}




			}

			 */

			//System.out.println("finished");


			/*
			for(String key :cg.posWords){


				if(d.postermFrequency.containsKey(key)){
					br3.write(d.postermFrequency.get(key)/d.countWords+",");
				}
				else{
					br3.write("0,");
				}

			}



			for(String key :cg.negWords){



				if(d.negtermFrequency.containsKey(key)){
					br3.write(d.negtermFrequency.get(key)/d.countWords+",");
				}
				else{
					br3.write("0,");
				}


			}

			 */

			for(int i=(poswordlistkeys.length-1);i>(poswordlistkeys.length-cSize);i--){

				if(d.postermFrequency.containsKey(poswordlistkeys[i])){

					double tf=d.postermFrequency.get(poswordlistkeys[i])/d.countWords;

					ArrayList<Integer> listt=cg.docFrequency.get(poswordlistkeys[i]);

					double df=Math.log(cg.docCount/listt.size());
					double tfidf=tf*df;

					br3.write(tfidf+",");
				}
				else{
					br3.write("0,");
				}

			}



			for(int i=(negwordlistkeys.length-1);i>(negwordlistkeys.length-cSizeNeg);i--){
				if(d.negtermFrequency.containsKey(negwordlistkeys[i])){

					double tf=d.negtermFrequency.get(negwordlistkeys[i])/d.countWords;

					ArrayList<Integer> listt=cg.docFrequency.get(negwordlistkeys[i]);

					double df=Math.log(cg.docCount/listt.size());
					double tfidf=tf*df;

					br3.write(tfidf+",");
				}
				else{
					br3.write("0,");
				}


			}









			for(int i=(wordlistkeys.length-1);i>(wordlistkeys.length-cSizet);i--){
				if((!cg.negWords.contains(wordlistkeys[i])) && (!cg.posWords.contains(wordlistkeys[i]))){
					if(d.termFrequency.containsKey(wordlistkeys[i])){

						double tf=d.termFrequency.get(wordlistkeys[i])/d.countWords;

						ArrayList<Integer> listt=cg.docFrequency.get(wordlistkeys[i]);

						double df=Math.log(cg.docCount/listt.size());
						double tfidf=tf*df;

						br3.write(tfidf+",");
					}
					else{
						br3.write("0,");
					}
				}
			}

			br3.write(d.countWords+",");

			//br3.write(d.countWords+",");
			br3.write((d.posWords)/d.countWords+",");
			br3.write((d.negWords)/d.countWords+",");
			/*
			if(((d.posWords/d.countWords)-(d.negWords/d.countWords))>0){
				br3.write((d.posWords/d.countWords)-(d.negWords/d.countWords)+",");
				br3.write(0+",");
			}
			else{
				br3.write(0+",");
				br3.write((d.negWords/d.countWords)-(d.posWords/d.countWords)+",");
			}
			 */


			br3.write(d.notWords/d.countWords+",");

			br3.write(d.commaWords/d.countWords+",");


			String sstar=""+d.star;
			if(d.star>=3){
				br3.write("1");
			}
			else{
				br3.write("0");
			}
			//br3.write(sstar);

			br3.newLine();
			br3.flush();

		}


	}




	private static void sortneg(CountGenerator cg) {
		// TODO Auto-generated method stub



		negwordlistkeys = new String[cg.cntnegwordList.size()];
		Enumeration en=cg.cntnegwordList.keys();
		int kk=0;
		while( en. hasMoreElements() ){
			negwordlistkeys[kk] = (String)en.nextElement() ;
			kk++;
		}

		negwordlistvals = new Integer[cg.cntnegwordList.size()];
		Enumeration env=cg.cntnegwordList.keys();
		int kkk=0;
		while( env. hasMoreElements() ){
			String keyss = (String)env.nextElement() ;
			negwordlistvals[kkk]=cg.cntnegwordList.get(keyss);
			kkk++;
		}


		bubbleSortneg();

	}




	private static void sortpos(CountGenerator cg) {
		// TODO Auto-generated method stub


		poswordlistkeys = new String[cg.cntposwordList.size()];
		Enumeration en=cg.cntposwordList.keys();
		int kk=0;
		while( en. hasMoreElements() ){
			poswordlistkeys[kk] = (String)en.nextElement() ;
			kk++;
		}

		poswordlistvals = new Integer[cg.cntposwordList.size()];
		Enumeration env=cg.cntposwordList.keys();
		int kkk=0;
		while( env. hasMoreElements() ){
			String keyss = (String)env.nextElement() ;
			poswordlistvals[kkk]=cg.cntposwordList.get(keyss);
			kkk++;
		}


		bubbleSortpos();

	}




	private static void printArray() {
		for(int i=0;i<20;i++){
			System.out.println(wordlistvals[i] +" "+wordlistkeys[i]);
		}



		for(int i=(wordlistvals.length-1);i>(wordlistvals.length-21);i--){
			System.out.println(wordlistvals[i] +" "+wordlistkeys[i]);
		}

	}





	public static void bubbleSort1() {
		int n = wordlistvals.length;
		for (int pass=1; pass < n; pass++) {  // count how many times
			// This next loop becomes shorter and shorter
			for (int i=0; i < n-pass; i++) {
				if (wordlistvals[i] > wordlistvals[i+1]) {
					// exchange elements
					int temp = wordlistvals[i];  wordlistvals[i] = wordlistvals[i+1];  wordlistvals[i+1] = temp;
					String tempp = wordlistkeys[i];  wordlistkeys[i] = wordlistkeys[i+1];  wordlistkeys[i+1] = tempp;
				}
			}
		}
	}




	public static void bubbleSortneg() {
		int n = negwordlistvals.length;
		for (int pass=1; pass < n; pass++) {  // count how many times
			// This next loop becomes shorter and shorter
			for (int i=0; i < n-pass; i++) {
				if (negwordlistvals[i] > negwordlistvals[i+1]) {
					// exchange elements
					int temp = negwordlistvals[i];  negwordlistvals[i] = negwordlistvals[i+1];  negwordlistvals[i+1] = temp;
					String tempp = negwordlistkeys[i];  negwordlistkeys[i] = negwordlistkeys[i+1];  negwordlistkeys[i+1] = tempp;
				}
			}
		}
	}





	public static void bubbleSortpos() {
		int n = poswordlistvals.length;
		for (int pass=1; pass < n; pass++) {  // count how many times
			// This next loop becomes shorter and shorter
			for (int i=0; i < n-pass; i++) {
				if (poswordlistvals[i] > poswordlistvals[i+1]) {
					// exchange elements
					int temp = poswordlistvals[i];  poswordlistvals[i] = poswordlistvals[i+1];  poswordlistvals[i+1] = temp;
					String tempp = poswordlistkeys[i];  poswordlistkeys[i] = poswordlistkeys[i+1];  poswordlistkeys[i+1] = tempp;
				}
			}
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
