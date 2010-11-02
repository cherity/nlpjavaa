package code;


import java.util.Iterator;
import edu.stanford.nlp.ling.TaggedWord;
import java.util.List;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.StringReader;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.process.*;
import edu.stanford.nlp.objectbank.TokenizerFactory;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;



public class ParseFileReader {

	//public static PrintWriter pw = new PrintWriter("printWriterOutput.txt");
	public static FileOutputStream fstream2 ;
	public static DataOutputStream in2 ;
	public static BufferedWriter br2;


	LexicalizedParser lp ; 
	TokenizerFactory tf ;
	TreePrint tp  ;


	public ParseFileReader(){

		//lp = new LexicalizedParser("/home/cs4705/stanford-parser-2010-08-20/englishPCFG.ser.gz"); 
		tf = PTBTokenizer.factory(false, new WordTokenFactory());
		tp = new TreePrint("wordsAndTags");

	}

	public String parseTheLine(String strLine){
		String parse="";

		try{


			lp = new LexicalizedParser("/home/cs4705/stanford-parser-2010-08-20/englishPCFG.ser.gz"); 

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