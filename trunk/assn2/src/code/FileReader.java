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
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class FileReader {

	public static int FEATcnt =5001;

	public static String outFile6="FinArff"+"-binary-newterms-";
	public static String outFile="FinArff"+"_reviewer-fff-";
	public static String outFile2="FinArff"+"_binary-fff-";
	public static String outFile3="FinArff"+"_binary-extra-reviewer-f-";
	public static String outFile4="FinArff"+"_multi-fff-";
	public static String outFile5="FinArff"+"_multi-extra-reviewer-f-D-";



	public static ArrayList<String> distWordslist=new ArrayList<String>();
	public static ArrayList<String> printedposlist=new ArrayList<String>();
	public static ArrayList<String> printedneglist=new ArrayList<String>();
	public static ArrayList<String> printedneutlist=new ArrayList<String>();


	public static ArrayList<String> featlist=new ArrayList<String>();
	public static ArrayList<String> featbilist=new ArrayList<String>();

	public static String[] reviewerFeaturesWords={"show", "though", "subscribe", "acceptable", "particularly", "simply", "solid", "nature", "ultimately", "familiar", "entirely", "believable", "appealing", "rare", "fast", "mostly", "potential", "necessary", "particular", "central", "opportunity", "perspective", "largely", "worthwhile", "apparent", "apparently", "primarily", "universal", "superb", "core", "evident", "therefore", "fortunately", "mesmerizing", "competent", "vastly", "although", "profanity", "despite", "unfortunately", "difficult", "contrived", "unexpected", "critical", "melodramatic", "unfortunate", "distracting", "film", "movie", "story", "--"};
	public static String[] reviewerFeaturesbigramWords={"motion-picture", "waste-money", "dont-waste", "running-time", "message-subject", "reply-message", "rated-pg-13", "fine-kids", "son-jeffrey", "fine-teenagers", "older-teenagers", "theres-nothing", "film-one", "motion-pictures", "running-length", "film-makers", "far-more", "relationship-between", "kind-film", "very-good", "theres-little", "film-making", "screen-presence", "doesnt-take", "film-maker", "film-film", "theres-enough", "find-yourself", "theres-one", "entertainment-value", "taking-place", "even-better", "entire-movie", "rated-probably", "end-credits", "title-character", "films-title", "films-end", "nothing-offend"};




	public static String[] mulFeaturesWords={"intrinsic", "masterly", "annoyingly","show", "though", "subscribe", "particularly", "simply", "nature", "ultimately", "familiar", "entirely", "believable", "appealing", "fast", "mostly", "potential", "necessary", "particular", "central", "opportunity", "largely", "worthwhile", "apparent", "apparently", "primarily", "universal", "superb", "core", "evident", "therefore", "competent", "vastly", "profanity", "despite", "difficult", "contrived", "unexpected", "critical", "melodramatic", "unfortunate", "distracting", "movie", "enhanced", "recommend", "delightful", "easy", "clich", "guilty", "ridiculous", "stale", "still", "uninteresting", "gripping", "many", "both", "anything", "quite", "interesting", "acceptable", "solid", "nevertheless", "award", "predictable", "surprising", "perfectly", "hilarious", "perspective", "strength", "fortunately", "poignant", "incredible", "outstanding", "recommendation", "resolved", "delicious", "simplicity", "down", "bland", "tedious", "lame", "pointless", "mindless", "lackluster", "bore", "juvenile", "laughable","moving", "simple", "strong", "great", "nice", "mesmerizing", "memorable", "polite", "unique", "best", "confidence", "compelling", "true", "worst", "problem", "enough", "idea", "remotely", "sitcom", "uninspired", "life","fine", "effective", "perfect", "wonderful", "power", "understand", "fascinating", "important", "intelligent", "powerful", "rich", "rare", "subtle", "minor", "emotions", "brilliant", "wonderfully", "masterpiece", "suppose", "upbeat", "masterful", "keen", "tolerable", "brag",  "bad", "unfortunately", "supposed", "worse", "complex", "tragedy", "dull", "dumb", "awful", "force", "boring", "uneven", "annoying", "mess", "lifeless", "badly", "embarrassing", "inane", "inept", "abomination", "unfunny", "watchable", "academy", "strongly", "film", "story"};
	public static String[] mulFeaturesbigramWords={"waste-money", "dont-waste", "running-time", "message-subject", "reply-message", "rated-pg-13", "fine-kids", "son-jeffrey", "fine-teenagers", "older-teenagers", "theres-nothing", "film-one", "motion-pictures", "running-length", "film-makers", "far-more", "relationship-between", "kind-film", "very-good", "theres-little", "film-making", "screen-presence", "doesnt-take", "film-maker", "film-film", "theres-enough", "find-yourself", "theres-one", "entertainment-value", "taking-place", "even-better", "entire-movie", "rated-probably", "end-credits", "title-character", "films-title", "films-end", "nothing-offend","character-study", "runs-long", "1/2-see", "director-robert", "ensemble-cast", "waste-time", "movie-made", "find-film", "thing-film", "few-laughs", "little-long", "edge-seat", "breaking-waves", "david-lynch", "best-actor", "surprise-ending", "myself-recommend", "give-single","motion-picture", "mature-themes", "one-best", "best-performance", "thumbs-down", "best-picture", "best-films"};

	public static String[] binFeaturesWords={"show", "though", "subscribe", "particularly", "simply", "nature", "ultimately", "familiar", "entirely", "believable", "appealing", "fast", "mostly", "potential", "necessary", "particular", "central", "opportunity", "largely", "worthwhile", "apparent", "apparently", "primarily", "universal", "superb", "core", "evident", "therefore", "competent", "vastly", "profanity", "despite", "difficult", "contrived", "unexpected", "critical", "melodramatic", "unfortunate", "distracting", "movie","great", "nice", "polite", "unique", "best", "confidence", "compelling", "true", "worst", "enough", "idea", "understand", "rich", "minor", "upbeat", "tolerable", "brag", "force", "uneven", "mess", "inept", "abomination", "strongly","important", "enhanced", "recommend", "delightful", "easy", "clich", "guilty", "ridiculous", "badly", "inane", "stale", "still", "suppose", "emotions", "unfunny", "remotely", "sitcom", "watchable", "uninteresting", "uninspired", "academy", "gripping", "many", "life", "both", "anything", "fine", "quite", "interesting", "strong", "effective", "acceptable", "simple", "perfect", "wonderful", "solid", "nevertheless", "power", "fascinating", "memorable", "award", "predictable", "moving", "intelligent", "powerful", "surprising", "rare", "subtle", "perfectly", "hilarious", "brilliant", "wonderfully", "perspective", "strength", "masterpiece", "fortunately", "poignant", "incredible", "mesmerizing", "outstanding", "recommendation", "masterful", "resolved", "keen", "delicious", "simplicity",  "bad", "down", "problem", "unfortunately", "supposed", "worse", "complex", "tragedy", "dull", "dumb", "awful", "boring", "bland", "tedious", "annoying", "lame", "lifeless", "pointless", "mindless", "lackluster", "embarrassing", "bore", "juvenile", "laughable", "film", "story"};
	public static String[] binFeaturesbigramWords={	"mature-themes","best-picture","best-films","best-performance","motion-picture", "character-study", "one-best", "runs-long", "1/2-see", "director-robert", "ensemble-cast", "waste-time", "movie-made", "thumbs-down", "find-film", "thing-film", "few-laughs", "little-long", "edge-seat", "breaking-waves", "david-lynch", "best-actor", "surprise-ending", "myself-recommend", "give-single"};



	public static boolean trainFlag =false;

	public static FileOutputStream fstream2 ;
	public static DataOutputStream in2 ;
	public static BufferedWriter br2;

	public static FileOutputStream fstream3 ;
	public static DataOutputStream in3 ;
	public static BufferedWriter br3;


	public static FileOutputStream fstream4 ;
	public static DataOutputStream in4 ;
	public static BufferedWriter br4;


	public static FileOutputStream fstream_bin ;
	public static DataOutputStream in_bin ;
	public static BufferedWriter br_bin;


	public static FileOutputStream fstream_bin_r ;
	public static DataOutputStream in_bin_r ;
	public static BufferedWriter br_bin_r;


	public static FileOutputStream fstream_mul ;
	public static DataOutputStream in_mul ;
	public static BufferedWriter br_mul;


	public static FileOutputStream fstream_mul_r ;
	public static DataOutputStream in_mul_r ;
	public static BufferedWriter br_mul_r;


	public static Integer[] wordlistvals;
	public static String[] wordlistkeys;


	public static Integer[] wordvalsss;
	public static String[] wordkeysss;



	public static Double[] wwordvalsss;
	public static String[] wwordkeysss;

	public static Integer[] poswordlistvals;
	public static String[] poswordlistkeys;


	public static Integer[] negwordlistvals;
	public static String[] negwordlistkeys;


	public static Integer[] bigramwordlistvals;
	public static String[] bigramwordlistkeys;


	public static void main(String args[]){

		try{


			outFile+=args[0]+"-"+args[1]+".arff";
			outFile2+=args[0]+"-"+args[1]+".arff";
			outFile3+=args[0]+"-"+args[1]+".arff";
			outFile4+=args[0]+"-"+args[1]+".arff";
			outFile5+=args[0]+"-"+args[1]+".arff";
			outFile6+=args[0]+"-"+args[1]+".arff";


			FileInputStream fstream = new FileInputStream(args[1]);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));


			fstream2 = new FileOutputStream("alllistuni_4"+args[0]+"223.txt");
			in2 = new DataOutputStream(fstream2);
			br2 = new BufferedWriter(new OutputStreamWriter(in2));


			fstream3 = new FileOutputStream(outFile);
			in3 = new DataOutputStream(fstream3);
			br3 = new BufferedWriter(new OutputStreamWriter(in3));


			fstream4 = new FileOutputStream("all_quotes_list_desc_4"+args[0]+"223.txt");
			in4 = new DataOutputStream(fstream4);
			br4 = new BufferedWriter(new OutputStreamWriter(in4));




			fstream_bin = new FileOutputStream(outFile2);
			in_bin = new DataOutputStream(fstream_bin);
			br_bin = new BufferedWriter(new OutputStreamWriter(in_bin));



			fstream_bin_r = new FileOutputStream(outFile3);
			in_bin_r = new DataOutputStream(fstream_bin_r);
			br_bin_r = new BufferedWriter(new OutputStreamWriter(in_bin_r));




			fstream_mul = new FileOutputStream(outFile4);
			in_mul = new DataOutputStream(fstream_mul);
			br_mul = new BufferedWriter(new OutputStreamWriter(in_mul));




			fstream_mul_r = new FileOutputStream(outFile5);
			in_mul_r = new DataOutputStream(fstream_mul_r);
			br_mul_r = new BufferedWriter(new OutputStreamWriter(in_mul_r));


			CountGenerator cg = new CountGenerator();

			String strLine;
			int cnt =0,negCnt=0,posCnt=0;
			Pattern pattern ;

			if(args[0].equalsIgnoreCase("train")){
				pattern= Pattern.compile("<id>(.*)</id><reviewer>(.*)</reviewer><star>(.*)</star><review>(.*)</review>.*");
				trainFlag=true;
			}
			else{
				pattern= Pattern.compile("<id>(.*)</id><review>(.*)</review>.*");
				trainFlag=false;
			}


			Matcher matcher;

			while ((strLine = br.readLine()) != null)   {

				matcher = pattern.matcher(strLine);
				while (matcher.find()) {
					cnt++;


					String id ;
					String reviewer ;
					String star  ;
					String match ;
					int starr =-1;

					if(trainFlag){
						id = matcher.group(1).trim();
						reviewer = matcher.group(2).trim();
						star = matcher.group(3).trim();
						match = matcher.group(4).trim();
						starr=Integer.parseInt(star);
						if(starr<=2){
							negCnt++;
						}
						else{
							posCnt++;
						}
					}
					else{
						id = matcher.group(1).trim();
						reviewer = "?";
						star ="?";
						match = matcher.group(2).trim();
					}

					cg.getCount(match,cnt,starr,reviewer, id,trainFlag);

				}

			}




			System.out.println("Total Docs- "+cnt);
			cg.docCount=cnt;


			if(trainFlag){
				POSFileReader pos = new POSFileReader();
				pos.getCount("parsedCorpus.txt");
			}

			//XXXXXXXXXXXXXXXXX
			 printDocListForReviewer(cg,args[0]);


			printDocListForClassification(cg,args[0],br_bin,"binary",binFeaturesWords, binFeaturesbigramWords);
			//printDocListForClassification(cg,args[0],br_bin_r,"binaryr",binFeaturesWords, binFeaturesbigramWords);

			printDocListForClassification(cg,args[0],br_mul,"multi",mulFeaturesWords, mulFeaturesbigramWords);
			//printDocListForClassification(cg,args[0],br_mul_r,"multi_and_extrareviewer",mulFeaturesWords, mulFeaturesbigramWords);



			br2.flush();
			in2.close();
			br3.flush();
			in3.close();
			br4.flush();
			in4.close();


			br_bin.flush();
			in_bin.close();


			br_bin_r.flush();
			in_bin_r.close();


			br_mul.flush();
			in_mul.close();


			br_mul_r.flush();
			in_mul_r.close();


			in.close();

		}catch (Exception e){

			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();

		}

	}



	private static void printDocListForClassification(CountGenerator cg,String casee, BufferedWriter br_bin2, String classicationCase, String[] featuresWordss, String featuresbigramWordss[]) {
		// TODO Auto-generated method stub

		try {

			br_bin2.write("@RELATION "+classicationCase+casee+"ing");

			br_bin2.newLine();
			br_bin2.newLine();
			br_bin2.newLine();


			for(int i=0;i<featuresWordss.length;i++){

				br_bin2.write("@ATTRIBUTE "+featuresWordss[i]+" NUMERIC");
				br_bin2.newLine();


			}

			for(int i=0;i<featuresbigramWordss.length;i++){

				br_bin2.write("@ATTRIBUTE "+featuresbigramWordss[i]+" NUMERIC");
				br_bin2.newLine();


			}





			if(classicationCase.equalsIgnoreCase("binary") || classicationCase.equalsIgnoreCase("binaryr")){


				br_bin2.write("@ATTRIBUTE posword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE negword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffposs NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffneg NUMERIC");
				br_bin2.newLine();



				//br_bin2.write("@ATTRIBUTE reviewerWord {A,B,C,D}");
				//br_bin2.newLine();

				br_bin2.write("@ATTRIBUTE adjWord NUMERIC");
				br_bin2.newLine();



				br_bin2.write("@ATTRIBUTE adverbWord NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE verbWord NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE detWord NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE classFinal {0,1}");
				br_bin2.newLine();
			}
			else{


				br_bin2.write("@ATTRIBUTE doclength NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE posword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE negword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffposs NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffneg NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE extremeWord NUMERIC");
				br_bin2.newLine();


				//	br_bin2.write("@ATTRIBUTE nnWord NUMERIC");
				//br_bin2.newLine();



				//br_bin2.write("@ATTRIBUTE nnpairWord NUMERIC");
				//br_bin2.newLine();


				//br_bin2.write("@ATTRIBUTE reviewerWord {A,B,C,D}");
				//br_bin2.newLine();

				br_bin2.write("@ATTRIBUTE adjWord NUMERIC");
				br_bin2.newLine();



				br_bin2.write("@ATTRIBUTE adverbWord NUMERIC");
				br_bin2.newLine();




				br_bin2.write("@ATTRIBUTE verbWord NUMERIC");
				br_bin2.newLine();

				br_bin2.write("@ATTRIBUTE detWord NUMERIC");
				br_bin2.newLine();

				br_bin2.write("@ATTRIBUTE classFinal {1,2,3,4}");
				br_bin2.newLine();
			}

			br_bin2.newLine();
			br_bin2.newLine();
			br_bin2.write("@DATA");
			br_bin2.newLine();
			br_bin2.flush();


			for(Document d : cg.docList){


				for(int i=0;i<featuresWordss.length;i++){

					if(d.termFrequency.containsKey(featuresWordss[i])){

						double tf=((d.termFrequency.get(featuresWordss[i]))/(d.countWords));

						ArrayList<Integer> listt=cg.docFrequency.get(featuresWordss[i]);

						double df=Math.log(cg.docCount/listt.size());
						double tfidf=tf*df;

						br_bin2.write(tfidf+",");
					}
					else{
						br_bin2.write("0,");
					}


				}


				for(int i=0;i<featuresbigramWordss.length;i++){

					if(d.bigramtermFrequency.containsKey(featuresbigramWordss[i])){

						double tf=((d.bigramtermFrequency.get(featuresbigramWordss[i]))/(d.bicountWords));



						br_bin2.write(tf+",");
					}
					else{
						br_bin2.write("0,");
					}


				}







				if(classicationCase.equalsIgnoreCase("binary") || classicationCase.equalsIgnoreCase("binaryr")){



					br_bin2.write((d.posWords)/d.countWords+",");
					br_bin2.write((d.negWords)/d.countWords+",");

					if(((d.posWords/d.countWords)-(d.negWords/d.countWords))>0){
						br_bin2.write((d.posWords/d.countWords)-(d.negWords/d.countWords)+",");
						br_bin2.write(0+",");
					}
					else{
						br_bin2.write(0+",");
						br_bin2.write((d.negWords/d.countWords)-(d.posWords/d.countWords)+",");
					}

					//br_bin2.write(d.reviewer+",");
				}
				else{

					br_bin2.write(d.countWords+",");

					br_bin2.write((d.posWords)/d.countWords+",");
					br_bin2.write((d.negWords)/d.countWords+",");

					if(((d.posWords/d.countWords)-(d.negWords/d.countWords))>0){
						br_bin2.write((d.posWords/d.countWords)-(d.negWords/d.countWords)+",");
						br_bin2.write(0+",");
					}
					else{
						br_bin2.write(0+",");
						br_bin2.write((d.negWords/d.countWords)-(d.posWords/d.countWords)+",");
					}


					if(cg.docFrequency.containsKey("extremeWords")){

						double tf=d.extremeWords/d.countWords;

						ArrayList<Integer> listt=cg.docFrequency.get("extremeWords");

						double df=Math.log(cg.docCount/listt.size());
						double tfidf=tf*df;

						br_bin2.write(tfidf+",");
					}
					else{
						br_bin2.write("0,");
					}


					//br_bin2.write(d.reviewer+",");

				}
				//br_bin2.write(d.NNcount/d.countWords+",");

				//br_bin2.write(d.NNpaircount/d.countWords+",");



				br_bin2.write(d.JJcount/d.countWords+",");

				br_bin2.write(d.RBcount/d.countWords+",");
				br_bin2.write(d.VBcount/d.countWords+",");
				br_bin2.write(d.DTcount/d.countWords+",");


				if(casee.equalsIgnoreCase("train")){
					if(classicationCase.equalsIgnoreCase("binary") || classicationCase.equalsIgnoreCase("binaryr")){
						if(d.star>=3){
							br_bin2.write("1");
						}
						else{
							br_bin2.write("0");
						}
					}
					else{
						String sstar =""+d.star;
						br_bin2.write(sstar);
					}
				}
				else{
					br_bin2.write("?");
				}
				br_bin2.newLine();
				br_bin2.flush();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	private static void printDocListForReviewer(CountGenerator cg, String casee ) throws IOException {
		// TODO Auto-generated method stub

		br3.write("@RELATION reviewer"+casee+"ing");
		br3.newLine();
		br3.newLine();
		br3.newLine();


		for(int i=0;i<reviewerFeaturesWords.length;i++){

			br3.write("@ATTRIBUTE "+reviewerFeaturesWords[i]+" NUMERIC");
			br3.newLine();


		}

		for(int i=0;i<reviewerFeaturesbigramWords.length;i++){

			br3.write("@ATTRIBUTE "+reviewerFeaturesbigramWords[i]+" NUMERIC");
			br3.newLine();


		}


		br3.write("@ATTRIBUTE doclength NUMERIC");
		br3.newLine();


		br3.write("@ATTRIBUTE diffposs NUMERIC");
		br3.newLine();


		//br3.write("@ATTRIBUTE NNCount NUMERIC");
		//br3.newLine();


		//br3.write("@ATTRIBUTE NNPairCount NUMERIC");
		//br3.newLine();


		br3.write("@ATTRIBUTE classFinal {A,B,C,D}");
		br3.newLine();

		br3.newLine();
		br3.newLine();
		br3.write("@DATA");
		br3.newLine();
		br3.flush();


		for(Document d : cg.docList){

			for(int i=0;i<reviewerFeaturesWords.length;i++){

				if(d.termFrequency.containsKey(reviewerFeaturesWords[i])){

					double tf=((d.termFrequency.get(reviewerFeaturesWords[i]))/(d.countWords));

					ArrayList<Integer> listt=cg.docFrequency.get(reviewerFeaturesWords[i]);

					double df=Math.log(cg.docCount/listt.size());
					double tfidf=tf*df;

					br3.write(tfidf+",");
				}
				else{
					br3.write("0,");
				}


			}

			for(int i=0;i<reviewerFeaturesbigramWords.length;i++){

				if(d.bigramtermFrequency.containsKey(reviewerFeaturesbigramWords[i])){

					double tf=((d.bigramtermFrequency.get(reviewerFeaturesbigramWords[i]))/(d.bicountWords));

					br3.write(tf+",");
				}
				else{
					br3.write("0,");
				}


			}


			br3.write(d.countWords+",");


			if(((d.posWords/d.countWords)-(d.negWords/d.countWords))>0){
				br3.write((d.posWords/d.countWords)-(d.negWords/d.countWords)+",");

			}
			else{
				br3.write(0+",");

			}


			//br3.write(d.NNcount/d.countWords+",");
			//br3.write(d.NNpaircount/d.countWords+",");


			if(casee.equalsIgnoreCase("train")){
				br3.write(d.reviewer);
			}
			else{
				br3.write("?");
			}
			br3.newLine();
			br3.flush();

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



}
