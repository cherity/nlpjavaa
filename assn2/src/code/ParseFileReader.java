package code;


import java.util.Iterator;
import edu.stanford.nlp.ling.TaggedWord;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.process.*;
import edu.stanford.nlp.objectbank.TokenizerFactory;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import java.io.IOException;
import java.io.PrintWriter;


public class ParseFileReader {

	//public static PrintWriter pw = new PrintWriter("printWriterOutput.txt");
	public static FileOutputStream fstream2 ;
	public static DataOutputStream in2 ;
	public static BufferedWriter br2;


	LexicalizedParser lp ; 
	TokenizerFactory tf ;
	TreePrint tp  ;


	public ParseFileReader(){
		lp = new LexicalizedParser("/home/cs4705/stanford-parser-2010-08-20/englishPCFG.ser.gz"); 
		tf = PTBTokenizer.factory(false, new WordTokenFactory());
		tp = new TreePrint("wordsAndTags");

	}
	/*
	 * public static void main(String args[]){

		try{


			ParseFileReader();
			FileInputStream fstream = new FileInputStream(args[1]);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			PrintWriter pw = new PrintWriter("parsedCorpus.txt");

			fstream2 = new FileOutputStream("output55.txt");
			in2 = new DataOutputStream(fstream2);
			br2 = new BufferedWriter(new OutputStreamWriter(in2));


			String strLine;
			int cnt =0,negCnt=0,posCnt=0;
			Pattern pattern  = Pattern.compile(".*<reviewer>(.*)</reviewer><star>(.*)</star><review>(.*)</review>.*");
			Matcher matcher;

			while ((strLine = br.readLine()) != null)   {

				matcher = pattern.matcher(strLine);
				while (matcher.find()) {
					cnt++;
					String reviewer = matcher.group(1).trim();
					String star = matcher.group(2).trim();
					int starr=Integer.parseInt(star);
					if(starr<=2){
						negCnt++;
					}
					else{
						posCnt++;
					}
					String match = matcher.group(3).trim();

					//System.out.println (strLine);
					//System.out.println (cnt +" " +star+" "+match);
					pw.println(cnt+" <<");


					String ss[]=match.split("\\.");
					for(String match2 :ss){
						//System.out.println(match2);
						if(match2.length()>0)		{				
							try{
								List tokens = tf.getTokenizer(new StringReader(match2)).tokenize(); 
								lp.parse(tokens); // parse the tokens
								Tree t = lp.getBestParse(); // get the best parse tree
								//						System.out.println(t.toString());
								List taggedWords = t.taggedYield();


								for (Iterator i = taggedWords.iterator( ); i.hasNext( ); ) {

									// String s = (String)i.next( );

									//System.out.println(s);
									TaggedWord s = (TaggedWord) i.next( );

									System.out.print (s.toString()+ " ");
								}

								//tp.printTree(t,pw);

								System.out.println("-----------------------");
								tp.printTree(t);

							}catch (Exception e){

								System.err.println("Error: " + e.getMessage());
								e.printStackTrace();

							}


						}				
					}


					pw.println(">> END");
				}
				if(cnt==1){
					break;
				}

			}


			pw.flush();
			pw.close();
		}catch (Exception e){

			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();

		}


	}


	 */
	public String parseTheLine(String strLine){
		String parse="";

		try{



			tf = PTBTokenizer.factory(false, new WordTokenFactory());
			tp = new TreePrint("wordsAndTags");


			int cnt =0,negCnt=0,posCnt=0;


			if(strLine.length()>0)		{				
				try{
					List tokens = tf.getTokenizer(new StringReader(strLine)).tokenize(); 
					lp.parse(tokens); // parse the tokens
					Tree t = lp.getBestParse(); // get the best parse tree
					//						System.out.println(t.toString());
					List taggedWords = t.taggedYield();


					for (Iterator i = taggedWords.iterator( ); i.hasNext( ); ) {

						// String s = (String)i.next( );

						//System.out.println(s);
						TaggedWord s = (TaggedWord) i.next( );
						parse+=s.toString()+ " ";

					}




				}catch (Exception e){

					System.err.println("Error: " + e.getMessage());
					e.printStackTrace();

				}



			}
			//System.out.println (parse);
			return parse;

		}catch (Exception e){

			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
			return parse;
		}

	}








}