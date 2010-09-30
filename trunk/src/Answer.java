/**
 * Ashish S Tomar
 * ast2124
 * NLP Assignment # 1
 * Stock market QA System
 * Answer.java
 */


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Answer {

	public String suffix="(to |at |)";



	/*
	 * This is the function that is called form the main function to get the Answers for the Questions.
	 * Based on the Question type a switch case statement is used and then the appropriate pattern is searched in the POS lines and free text line  to  retrieve the answer.
	 */
	public  boolean getAnswer(Matcher matcherr, int casei) {

		boolean flag=false;
		int cntLine=0, cnt=0;

		try{

			String nounCase, strLine, strLinePos, caseQ;
			Pattern pattern;
			Matcher matcher;

			Questions question= new Questions();
			POSFileReader posff= new POSFileReader();
			//while ((strLine = br.readLine()) != null)

			for(int ttt=0;ttt<posff.freetextfile.size();ttt++)
			{

				strLinePos=posff.freeposfile.get(ttt);
				strLine=posff.freetextfile.get(ttt);

				if(casei==9||casei==3||casei==0||casei==1||casei==2){
					nounCase= matcherr.group(2);
				}
				else if(casei==5||casei==6||casei==4 ){
					nounCase= matcherr.group(3);
				}
				else if(casei==14){
					nounCase="";
				}
				else{
					nounCase= matcherr.group(1);
				}
				cntLine++;

				switch(casei){

				//".*[Ww]hat did (the )?.*?([A-Z].*) do\\?"
				case 0:

					String nouncases[]=getPermutationsParaphrases(nounCase);
					boolean flagrep=false;

					for(int kk=0;kk<nouncases.length;kk++){

						boolean flagtodo=getRightMatch(strLinePos,nouncases[kk],kk);
						//if(!flagrep){
						if(!flagrep && flagtodo){
							nounCase=nouncases[kk];

							boolean flagcase0=false;
							//pattern = Pattern.compile("(\\b"+nounCase+"\\b .*?"+question.allVerbs+")(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
							//pattern = Pattern.compile("(\\b"+nounCase+"\\b .*"+question.allVerbs+".*?)(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
							pattern = Pattern.compile("(\\b"+nounCase+"\\b,? .*?\\b"+question.allVerbs+"\\b.*?)(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);

							matcher = pattern.matcher(strLine);


							while (matcher.find()) {
								cnt++;
								//String match = matcher.group(1).trim();
								String match = matcher.group(1).trim();


								//FileParser.brout.write("A "+cnt+": "+match+".");
								//FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");


								FileParser.brout.write("A "+cnt+": "+match+".");
								FileParser.brout.newLine();
								FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
								FileParser.brout.newLine();

								flag=true;
								flagcase0=true;
								flagrep=true;
							}

						}
					}


					break;

					//".*[Hh]ow much did (the )?.*?([A-Z].*?) "+extraEle+negVerbs+"\\s?.*?\\?"
				case 1:

					nouncases=getPermutationsParaphrases(nounCase);
					flagrep=false;

					for(int kk=0;kk<nouncases.length;kk++){

						boolean flagtodo=getRightMatch(strLinePos,nouncases[kk],kk);
						//if(!flagrep){
						if(!flagrep && flagtodo){


							nounCase=nouncases[kk];

							boolean flag3=false;
							caseQ = matcherr.group(4);
							//Pattern pattern = Pattern.compile("("+nounCase+"[^,\\.]*? (fall|fell|loose|lost) .*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
							pattern = Pattern.compile("\\b"+nounCase+"\\b,? [^,\\.]*?\\b"+question.negVerbs+"\\b ([0-9][0-9\\s\\.,/%]*).*?(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);



							matcher = pattern.matcher(strLine);


							while (matcher.find()) {
								cnt++;
								String match = matcher.group(2).trim();
								char[] trimarr= match.toCharArray();
								if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
									//FileParser.brout.write("A "+cnt+": ");
									FileParser.brout.write("A "+cnt+": ");
									for(int l=0;l<trimarr.length-1;l++){
										//FileParser.brout.write(trimarr[l]);
										FileParser.brout.write(trimarr[l]);
									}
									//FileParser.brout.write(".");
									FileParser.brout.write(".");
									FileParser.brout.newLine();
								}
								else{
									//FileParser.brout.write("A "+cnt+": "+match+".");
									FileParser.brout.write("A "+cnt+": "+match+".");
									FileParser.brout.newLine();
								}
								//FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");

								FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
								FileParser.brout.newLine();

								flag=true;
								flag3=true;
								flagrep=true;
							}



							if(!flag3){
								pattern = Pattern.compile("\\b"+nounCase+"\\b,? [^,\\.]*? ([0-9][0-9\\s\\.,/%]*) \\b"+question.negVerbs+"\\b.*?(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);


								matcher = pattern.matcher(strLine);


								while (matcher.find()) {
									cnt++;
									String match = matcher.group(1).trim();

									char[] trimarr= match.toCharArray();
									if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
										//FileParser.brout.write("A "+cnt+": ");
										FileParser.brout.write("A "+cnt+": ");
										for(int l=0;l<trimarr.length-1;l++){
											//FileParser.brout.write(trimarr[l]);
											FileParser.brout.write(trimarr[l]);
										}
										//FileParser.brout.write(".");

										FileParser.brout.write(".");
										FileParser.brout.newLine();
									}
									else{
										//FileParser.brout.write("A "+cnt+": "+match+".");
										FileParser.brout.write("A "+cnt+": "+match+".");
										FileParser.brout.newLine();
									}
									//FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
									FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
									FileParser.brout.newLine();
									flag=true;
									flagrep=true;
								}
							}

						}
					}


					break;

					//".*[Hh]ow much did (the )?.*?([A-Z].*?) "+extraEle+posVerbs+"\\s?.*?\\?"
				case 2:

					nouncases=getPermutationsParaphrases(nounCase);
					flagrep=false;

					for(int kk=0;kk<nouncases.length;kk++){

						boolean flagtodo=getRightMatch(strLinePos,nouncases[kk],kk);
						//if(!flagrep){
						if(!flagrep && flagtodo){


							nounCase=nouncases[kk];

							boolean flag2=false;

							caseQ = matcherr.group(4);
							//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
							//pattern = Pattern.compile("\\b"+nounCase+"\\b [^,\\.]*?"+question.posVerbs+" ([0-9][0-9\\s\\.,/%]*).*?(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
							pattern = Pattern.compile("\\b"+nounCase+"\\b,? [^,\\.]*?\\b"+question.posVerbs+"\\b ([0-9][0-9\\s\\.,/%]*).*?(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);


							matcher = pattern.matcher(strLine);


							while (matcher.find()) {
								cnt++;
								String match = matcher.group(2).trim();

								char[] trimarr= match.toCharArray();
								if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
									FileParser.brout.write("A "+cnt+": ");
									for(int l=0;l<trimarr.length-1;l++){
										FileParser.brout.write(trimarr[l]);
									}
									FileParser.brout.write(".");
									FileParser.brout.newLine();
								}
								else{
									FileParser.brout.write("A "+cnt+": "+match+".");
									FileParser.brout.newLine();
								}
								FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
								FileParser.brout.newLine();
								flag=true;
								flag2=true;
								flagrep=true;
							}

							if(!flag2){
								pattern = Pattern.compile("\\b"+nounCase+"\\b,? [^,\\.]*? ([0-9][0-9\\s\\.,/%]*) \\b"+question.posVerbs+"\\b.*?(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);


								matcher = pattern.matcher(strLine);


								while (matcher.find()) {
									cnt++;
									String match = matcher.group(1).trim();

									char[] trimarr= match.toCharArray();
									if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
										FileParser.brout.write("A "+cnt+": ");
										for(int l=0;l<trimarr.length-1;l++){
											FileParser.brout.write(trimarr[l]);
										}
										FileParser.brout.write(".");
										FileParser.brout.newLine();
									}
									else{
										FileParser.brout.write("A "+cnt+": "+match+".");
										FileParser.brout.newLine();
									}
									FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
									FileParser.brout.newLine();
									flag=true;
									flagrep=true;
								}
							}



						}
					}

					break;





					//".*[Dd]id (the )?.*?([A-Z].*?) "+extraEle+allVerbs+" or "+extraEle+allVerbs+"\\?"
				case 3:

					nouncases=getPermutationsParaphrases(nounCase);
					flagrep=false;

					for(int kk=0;kk<nouncases.length;kk++){

						boolean flagtodo=getRightMatch(strLinePos,nouncases[kk],kk);
						//if(!flagrep){
						if(!flagrep && flagtodo){


							nounCase=nouncases[kk];

							boolean wrflag=true;


							caseQ = matcherr.group(4);

							pattern = Pattern.compile("\\b"+nounCase+"\\b,? [^\\.]*?\\b"+question.allVerbs+"\\b.*(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
							//	pattern = Pattern.compile(".*\\b"+nounCase+"\\b.* \\b"+question.allVerbs+"\\b .*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
							//pattern = Pattern.compile(".*\\b"+nounCase+"\\b.*(fell).*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);

							matcher = pattern.matcher(strLine);


							while (matcher.find()) {
								cnt++;
								String match = matcher.group(1).trim();
								String pos="";
								String neg="";
								String x=caseQ;
								String y=matcherr.group(6);

								if(question.negVerbs.matches(".*\\b"+x+"\\b.*")){
									neg=x;
									pos=y;

								}
								else if(question.posVerbs.matches(".*\\b"+x+"\\b.*")){
									neg=y;
									pos=x;
								}
								else if(question.posVerbs.matches(".*\\b"+y+"\\b.*")){
									neg=x;
									pos=y;
								}
								else if(question.negVerbs.matches(".*\\b"+y+"\\b.*")){
									neg=y;
									pos=x;
								}
								else{
									wrflag=false;
								}



								if(question.negVerbs.matches(".*\\b"+match+"\\b.*")){
									if(wrflag){
										FileParser.brout.write("A "+cnt+": "+neg.toUpperCase()+".");
										FileParser.brout.newLine();
									}
									else{
										FileParser.brout.write("A "+cnt+": "+match+".");
										FileParser.brout.newLine();
									}
								}
								else if(question.posVerbs.matches(".*\\b"+match+"\\b.*")){
									if(wrflag){
										FileParser.brout.write("A "+cnt+": "+pos.toUpperCase()+".");
										FileParser.brout.newLine();
									}
									else{
										FileParser.brout.write("A "+cnt+": "+match+".");
										FileParser.brout.newLine();
									}
								}
								else{
									FileParser.brout.write("A "+cnt+": "+match+".");
									FileParser.brout.newLine();
								}



								FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
								FileParser.brout.newLine();
								flag=true;
								flagrep=true;
							}


						}
					}

					break;



					//".*([Ww]hat|How much) did (the )?.*?([A-Z].*?) "+extraEle+"(closed|close|end|ended|finish|finished|shut|terminate|terminated|stop|stopped|cease|ceased) at\\?"
				case 4:


					nouncases=getPermutationsParaphrases(nounCase);
					flagrep=false;

					for(int kk=0;kk<nouncases.length;kk++){


						boolean flagtodo=getRightMatch(strLinePos,nouncases[kk],kk);
						//if(!flagrep){
						if(!flagrep && flagtodo){
							//if(!flagrep){

							nounCase=nouncases[kk];

							boolean flagclose=false;
							//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);

							pattern = Pattern.compile("\\b"+nounCase+"\\b,?.*?(closed|close|end|ended|finish|finished|shut|terminate|terminated|stop|stopped|cease|ceased) (to|at) ([0-9][0-9\\s\\.,/%]*).*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
							matcher = pattern.matcher(strLine);


							while (matcher.find()) {
								cnt++;
								String match = matcher.group(3).trim();

								char[] trimarr= match.toCharArray();
								if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
									FileParser.brout.write("A "+cnt+": ");
									for(int l=0;l<trimarr.length-1;l++){
										FileParser.brout.write(trimarr[l]);
									}
									FileParser.brout.write(".");
									FileParser.brout.newLine();
								}
								else{
									FileParser.brout.write("A "+cnt+": "+match+".");
									FileParser.brout.newLine();
								}
								FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
								FileParser.brout.newLine();
								flag=true;
								flagclose=true;
								flagrep=true;
							}



							if(!flagclose){

								pattern = Pattern.compile("\\b"+nounCase+"\\b,?.*?(to|at) ([0-9][0-9\\s\\.,/%]*).*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
								matcher = pattern.matcher(strLine);


								while (matcher.find()) {
									cnt++;
									String match = matcher.group(2).trim();

									char[] trimarr= match.toCharArray();
									if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
										FileParser.brout.write("A "+cnt+": ");
										for(int l=0;l<trimarr.length-1;l++){
											FileParser.brout.write(trimarr[l]);
										}
										FileParser.brout.write(".");
										FileParser.brout.newLine();
									}
									else{
										FileParser.brout.write("A "+cnt+": "+match+".");
										FileParser.brout.newLine();
									}
									FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
									FileParser.brout.newLine();
									flag=true;
									flagclose=true;
									flagrep=true;
								}
							}

						}
					}
					break;




					//".*([Ww]hat|How much) did (the )?.*?([A-Z].*?) "+extraEle+"(opened|open|commence|commenced|begin|began|start|started|initiate|initiated) at\\?"
				case 5:

					nouncases=getPermutationsParaphrases(nounCase);
					flagrep=false;

					for(int kk=0;kk<nouncases.length;kk++){
						boolean flagtodo=getRightMatch(strLinePos,nouncases[kk],kk);
						//if(!flagrep){
						if(!flagrep && flagtodo){
							nounCase=nouncases[kk];
							//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);

							pattern = Pattern.compile("\\b"+nounCase+"\\b,? .*?\\b(open|opened|start|started|begin|began|beginning|opening|starting|initiated|initiating|initiate|commence|commencing|commenced)\\s?.*?\\s?(to|at) ([0-9][0-9\\s\\.,/%]*).*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);

							matcher = pattern.matcher(strLine);


							while (matcher.find()) {
								cnt++;
								String match = matcher.group(3).trim();

								char[] trimarr= match.toCharArray();
								if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
									FileParser.brout.write("A "+cnt+": ");
									for(int l=0;l<trimarr.length-1;l++){
										FileParser.brout.write(trimarr[l]);
									}
									FileParser.brout.write(".");
									FileParser.brout.newLine();
								}
								else{
									FileParser.brout.write("A "+cnt+": "+match+".");
									FileParser.brout.newLine();
								}

								FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
								FileParser.brout.newLine();
								flag=true;
								flagrep=true;
							}

						}
					}

					break;



					//".*([Ww]hat|How much) did (the )?.*?([A-Z].*?) "+extraEle+"(sell|sold|deal|dealt|trade|transact|traded|transacted|bought) at\\?"
				case 6:

					nouncases=getPermutationsParaphrases(nounCase);
					flagrep=false;

					for(int kk=0;kk<nouncases.length;kk++){
						boolean flagtodo=getRightMatch(strLinePos,nouncases[kk],kk);
						//if(!flagrep){
						if(!flagrep && flagtodo){
							nounCase=nouncases[kk];
							//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);

							pattern = Pattern.compile("\\b"+nounCase+"\\b,? .*?\\b(sell|sold|bought|selling|buying|buy|deal|dealt|dealing|trade|traded|transact|transacted|transacting)\\s?.*?\\s?(to|at) ([0-9][0-9\\s\\.,/%]*).*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);


							matcher = pattern.matcher(strLine);


							while (matcher.find()) {
								cnt++;
								String match = matcher.group(3).trim();

								char[] trimarr= match.toCharArray();
								if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
									FileParser.brout.write("A "+cnt+": ");
									for(int l=0;l<trimarr.length-1;l++){
										FileParser.brout.write(trimarr[l]);
									}
									FileParser.brout.write(".");
									FileParser.brout.newLine();
								}
								else{
									FileParser.brout.write("A "+cnt+": "+match+".");
									FileParser.brout.newLine();
								}
								FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
								FileParser.brout.newLine();
								flag=true;
								flagrep=true;
							}

						}
					}

					break;



					//".*[Ww](hat|hich) (index|indexes).*"+negVerbs+"\\?"

				case 7:

					pattern = Pattern.compile(".*(\\[.*?[iI]ndex.*?\\]).*?\\b"+question.negVerbs+"\\b.*?",Pattern.DOTALL);
					matcher = pattern.matcher(strLinePos);

					while (matcher.find()) {

						String matchFirst = matcher.group(1).trim();
						//String matchFirst1 = matcher.group(2).trim();

						String match = modifyString(matchFirst);
						match=match.trim();

						if(!match.equalsIgnoreCase("index") && !match.equalsIgnoreCase("index.") && !match.equalsIgnoreCase("index .")){
							cnt++;
							char[] trimarr= match.toCharArray();
							if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','|| trimarr[trimarr.length-1]==' '){
								FileParser.brout.write("A "+cnt+": ");
								for(int l=0;l<trimarr.length-1;l++){
									FileParser.brout.write(trimarr[l]);
								}
								FileParser.brout.write(".");
								FileParser.brout.newLine();
							}
							else{
								FileParser.brout.write("A "+cnt+": "+match+".");
								FileParser.brout.newLine();
							}

							FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
							FileParser.brout.newLine();
							flag=true;
						}

					}
					break;



					//".*[Ww](hat|hich) (index|indexes).*"+posVerbs+"\\?"

				case 8:

					//pattern = Pattern.compile(".*(\\[.*?[iI]ndex.*?\\]).*?"+question.posVerbs+".*?",Pattern.DOTALL);
					pattern = Pattern.compile(".*(\\[.*?[iI]ndex.*?\\]).*?\\b"+question.posVerbs+"\\b.*?",Pattern.DOTALL);
					matcher = pattern.matcher(strLinePos);

					while (matcher.find()) {

						String matchFirst = matcher.group(1).trim();

						String match = modifyString(matchFirst);
						match=match.trim();

						if(!match.equalsIgnoreCase("index") && !match.equalsIgnoreCase("index.") && !match.equalsIgnoreCase("index .")){
							cnt++;
							char[] trimarr= match.toCharArray();
							if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','|| trimarr[trimarr.length-1]==' '){
								FileParser.brout.write("A "+cnt+": ");
								for(int l=0;l<trimarr.length-1;l++){
									FileParser.brout.write(trimarr[l]);
								}
								FileParser.brout.write(".");
								FileParser.brout.newLine();
							}
							else{
								FileParser.brout.write("A "+cnt+": "+match+".");
								FileParser.brout.newLine();
							}
							FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
							FileParser.brout.newLine();
							flag=true;
						}
					}

					break;






					//".*[Ww]hat was\\s?(the)?\\s?([Dd]iscount [Rr]ate)\\?"

				case 9:

					boolean flagdr=false;
					//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);

					//pattern = Pattern.compile("([0-9][0-9\\s\\.,/%]*) [^,\\.]*?\\b"+nounCase+"\\b.*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					pattern = Pattern.compile("([0-9][0-9\\s\\.,/%]*) in (the )?\\b"+nounCase+"\\b.*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);

					matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						String match = matcher.group(1).trim();

						char[] trimarr= match.toCharArray();
						if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
							FileParser.brout.write("A "+cnt+": ");
							for(int l=0;l<trimarr.length-1;l++){
								FileParser.brout.write(trimarr[l]);
							}
							FileParser.brout.write(".");
							FileParser.brout.newLine();
						}
						else{
							FileParser.brout.write("A "+cnt+": "+match+".");
							FileParser.brout.newLine();
						}


						FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						FileParser.brout.newLine();
						flag=true;
						flagdr=true;
					}




					pattern = Pattern.compile("\\b"+nounCase+"\\b,? [^\\.]*?(was |is )([0-9][0-9\\s\\.,/%]*)",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						String match = matcher.group(2).trim();

						char[] trimarr= match.toCharArray();
						if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
							FileParser.brout.write("A "+cnt+": ");
							for(int l=0;l<trimarr.length-1;l++){
								FileParser.brout.write(trimarr[l]);
							}
							FileParser.brout.write(".");
							FileParser.brout.newLine();
						}
						else{
							FileParser.brout.write("A "+cnt+": "+match+".");
							FileParser.brout.newLine();
						}

						FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						FileParser.brout.newLine();
						flag=true;
						flagdr=true;
					}



					pattern = Pattern.compile("\\b"+nounCase+"\\b,? [^\\.]*?(to |at )([0-9][0-9\\s\\.,/%]*).*?",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						String match = matcher.group(2).trim();

						char[] trimarr= match.toCharArray();
						if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
							FileParser.brout.write("A "+cnt+": ");
							for(int l=0;l<trimarr.length-1;l++){
								FileParser.brout.write(trimarr[l]);
							}
							FileParser.brout.write(".");
							FileParser.brout.newLine();
						}
						else{
							FileParser.brout.write("A "+cnt+": "+match+".");
							FileParser.brout.newLine();
						}
						FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						FileParser.brout.newLine();
						flag=true;
						flagdr=true;
					}


					break;




					//".*[Ww]hat did\\s?(the)?\\s?(.*?) do (against|compared to|in comparison to|opposed to|in oppposing to|counter to|contrary to|in contrary to|in counter to|opposing|versus|vs|as opposed to|as compared to|as counter to|as contrary to)\\s?(the)?\\s?(.*?)\\?"
				case 10:

					String c1= matcherr.group(2);
					String c2= matcherr.group(5);
					//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);

					pattern = Pattern.compile("\\b"+c1+"\\b,?.*? \\b"+question.allVerbs+"\\b .*?(against|compared to|in comparison to|opposed to|in oppposing to|counter to|contrary to|in contrary to|in counter to|opposing|versus|vs|as opposed to|as compared to|as counter to|as contrary to) .*?\\b"+c2+"\\b.*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);

					while (matcher.find()) {
						cnt++;
						String match = matcher.group(1).trim();


						FileParser.brout.write("A "+cnt+": "+match.toUpperCase()+".");
						FileParser.brout.newLine();

						FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						FileParser.brout.newLine();
						flag=true;
					}






					pattern = Pattern.compile("\\b"+c2+"\\b,?.*? \\b"+question.allVerbs+"\\b .*?(against|compared to|in comparison to|opposed to|in oppposing to|counter to|contrary to|in contrary to|in counter to|opposing|versus|vs|as opposed to|as compared to|as counter to|as contrary to) .*?\\b"+c1+"\\b.*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);

					while (matcher.find()) {
						cnt++;
						String match = matcher.group(1).trim();

						if(question.negVerbs.matches(".*"+match+".*")){
							FileParser.brout.write("A "+cnt+": "+"RISE"+".");
							FileParser.brout.newLine();
						}
						else if(question.posVerbs.matches(".*"+match+".*")){
							FileParser.brout.write("A "+cnt+": "+"FALL"+".");
							FileParser.brout.newLine();
						}


						FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						FileParser.brout.newLine();
						flag=true;
					}








					break;


					//".*Did\\s?(the)?\\s?(.*?) "+extraEle+allVerbs+" or "+extraEle+allVerbs+" (against|compared to|in comparison to|opposed to|as opposed to|as compared to|as counter to|as contrary to|in oppposing to|counter to|contrary to|in contrary to|in counter to|opposing|versus|vs)\\s?(the)?\\s?(.*?)\\?"

				case 11:


					boolean wrflag2=true;
					String c3= matcherr.group(2);
					String c4= matcherr.group(9);

					pattern = Pattern.compile("\\b"+c3+"\\b,?.*? \\b"+question.allVerbs+"\\b .*?(against|compared to|in comparison to|opposed to|in oppposing to|counter to|contrary to|in contrary to|in counter to|opposing|versus|vs|as opposed to|as compared to|as counter to|as contrary to) .*?\\b"+c4+"\\b.*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);

					while (matcher.find()) {
						cnt++;
						String match = matcher.group(1).trim();

						String pos="";
						String neg="";
						String x=matcherr.group(4);
						String y=matcherr.group(6);

						if(question.negVerbs.matches(".*"+x+".*")){
							neg=x;
							pos=y;

						}
						else if(question.posVerbs.matches(".*"+x+".*")){
							neg=y;
							pos=x;
						}
						else if(question.posVerbs.matches(".*"+y+".*")){
							neg=x;
							pos=y;
						}
						else if(question.negVerbs.matches(".*"+y+".*")){
							neg=y;
							pos=x;
						}
						else{
							wrflag2=false;
						}



						if(question.negVerbs.matches(".*"+match+".*")){
							if(wrflag2){
								FileParser.brout.write("A "+cnt+": "+neg.toUpperCase()+".");
								FileParser.brout.newLine();
							}
							else{
								FileParser.brout.write("A "+cnt+": "+match.toUpperCase()+".");
								FileParser.brout.newLine();
							}
						}
						else if(question.posVerbs.matches(".*"+match+".*")){
							if(wrflag2){
								FileParser.brout.write("A "+cnt+": "+pos.toUpperCase()+".");
								FileParser.brout.newLine();
							}
							else{
								FileParser.brout.write("A "+cnt+": "+match.toUpperCase()+".");
								FileParser.brout.newLine();
							}
						}
						else{
							FileParser.brout.write("A "+cnt+": "+match.toUpperCase()+".");
							FileParser.brout.newLine();
						}



						FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						FileParser.brout.newLine();
						flag=true;
					}









					wrflag2=true;

					pattern = Pattern.compile("\\b"+c4+"\\b,?.*? \\b"+question.allVerbs+"\\b .*?(against|compared to|in comparison to|opposed to|in oppposing to|counter to|contrary to|in contrary to|in counter to|opposing|versus|vs|as opposed to|as compared to|as counter to|as contrary to) .*?\\b"+c3+"\\b.*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);

					while (matcher.find()) {
						cnt++;
						String match = matcher.group(1).trim();

						String pos="";
						String neg="";
						String x=matcherr.group(4);
						String y=matcherr.group(6);

						if(question.negVerbs.matches(".*"+x+".*")){
							neg=x;
							pos=y;

						}
						else if(question.posVerbs.matches(".*"+x+".*")){
							neg=y;
							pos=x;
						}
						else if(question.posVerbs.matches(".*"+y+".*")){
							neg=x;
							pos=y;
						}
						else if(question.negVerbs.matches(".*"+y+".*")){
							neg=y;
							pos=x;
						}
						else{
							wrflag2=false;
						}



						if(question.negVerbs.matches(".*"+match+".*")){
							if(wrflag2){
								FileParser.brout.write("A "+cnt+": "+pos.toUpperCase()+".");
								FileParser.brout.newLine();	
							}
							else{
								FileParser.brout.write("A "+cnt+": "+match.toUpperCase()+".");
								FileParser.brout.newLine();	
							}
						}
						else if(question.posVerbs.matches(".*"+match+".*")){
							if(wrflag2){
								FileParser.brout.write("A "+cnt+": "+neg.toUpperCase()+".");
								FileParser.brout.newLine();	
							}
							else{
								FileParser.brout.write("A "+cnt+": "+match.toUpperCase()+".");
								FileParser.brout.newLine();
							}
						}
						else{
							FileParser.brout.write("A "+cnt+": "+match.toUpperCase()+".");
							FileParser.brout.newLine();
						}



						FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						FileParser.brout.newLine();
						flag=true;
					}









					break;






					//".*[Ww](hat|hich)\\s?(company)?\\s?(stock|stocks)\\s?.*"+posVerbs+"\\?"

				case 13:

					//pattern = Pattern.compile(".*(\\[[A-Z].*?\\]).*"+question.negVerbs+".*?",Pattern.DOTALL);
					//pattern = Pattern.compile(".*([A-Z].*)[^,\\.]*"+question.negVerbs+".*?",Pattern.DOTALL);

					boolean flag1 =true;
					//pattern = Pattern.compile(".*?([\\[\\sA-Z\\]].*?)\\b"+question.posVerbs+"");
					String verb;
					pattern = Pattern.compile(".*?([\\[\\sA-Z\\]].*?)\\b"+question.posVerbs+"");
					matcher = pattern.matcher(strLinePos);

					while (matcher.find()) {

						String matchFirst = matcher.group(1).trim();
						verb=matcher.group(2).trim();
						flag1=true;
						//String match = modifyString(matchFirst);
						String match = matchFirst;
						if(match.matches(".*[iI]ndex.*")){
							continue;	
						}

						Matcher m = Pattern.compile("\\[(.*?)\\]").matcher(match);
						while (m.find()) {
							String name = m.group(1);
							if (!name.contains("NNP")) {
								continue;
							}
							match=name;

							String[] ast= match.split(" ");

							for(String a :ast){

								if(!a.equals("")){
									if (!a.contains("NNP")&&!a.contains("NNPS")&&!a.contains("DT")){
										flag1=false;
									}
								}
							}


							if(flag1){

								//match =match.replaceAll(" ","");
								match=match.replaceAll(".*?DT", "");
								match =match.replaceAll("/NNPS","");
								match =match.replaceAll("/NNP","");

								match =match.trim();

								//Matcher m2 = Pattern.compile("("+match+".*?"+verb+").*").matcher(strLine);


								//Matcher m2 = Pattern.compile("("+match+".*?"+verb+").*[0-9]+").matcher(strLine);
								//							 "(\\b"+match+"\\b,? .*?\\b"+verb+"\\b).*[0-9]+"
								Matcher m2 = Pattern.compile("(\\b"+match+"\\b,? .*?\\b"+verb+").*[0-9]+").matcher(strLine);

								while(m2.find()){

									String distStr =m2.group(1);
									String dist[] =distStr.split(" ");
									if(dist.length<=10){
										cnt++;

										FileParser.brout.write("A "+cnt+": "+match+".");
										FileParser.brout.newLine();
										FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
										FileParser.brout.newLine();
									}
								}


							}
						}




						flag=true;
					}


					break;


					//".*[Ww](hat|hich)\\s?(company)?\\s?(stock|stocks)\\s?.*"+negVerbs+"\\?"
				case 12:


					boolean flag5 =true;
					//pattern = Pattern.compile(".*?([\\[\\sA-Z\\]].*?)\\b"+question.posVerbs+"");
					String verb2;
					pattern = Pattern.compile(".*?([\\[\\sA-Z\\]].*?)\\b"+question.negVerbs+"");
					matcher = pattern.matcher(strLinePos);

					while (matcher.find()) {

						String matchFirst = matcher.group(1).trim();
						verb2=matcher.group(2).trim();
						flag5=true;
						//String match = modifyString(matchFirst);
						String match = matchFirst;
						if(match.matches(".*[iI]ndex.*")){
							continue;	
						}

						Matcher m = Pattern.compile("\\[(.*?)\\]").matcher(match);
						while (m.find()) {
							String name = m.group(1);
							if (!name.contains("NNP")) {
								continue;
							}

							match=name;

							String[] ast= match.split(" ");

							for(String a :ast){

								if(!a.equals("")){
									if (!a.contains("NNP")&&!a.contains("NNPS")&&!a.contains("DT")){
										flag5=false;
									}
								}
							}


							if(flag5){

								//match =match.replaceAll(" ","");
								match=match.replaceAll(".*?DT", "");
								match =match.replaceAll("/NNPS","");
								match =match.replaceAll("/NNP","");


								match =match.trim();






								//Matcher m2 = Pattern.compile("("+match+".*?"+verb2+").*[0-9]+").matcher(strLine);
								//							 "(\\b"+match+"\\b,? .*?\\b"+verb2+"\\b).*[0-9]+"
								Matcher m2 = Pattern.compile("(\\b"+match+"\\b,? .*?\\b"+verb2+").*[0-9]+").matcher(strLine);

								while(m2.find()){

									String distStr =m2.group(1);
									String dist[] =distStr.split(" ");
									if(dist.length<=10){
										cnt++;

										FileParser.brout.write("A "+cnt+": "+match+".");
										FileParser.brout.newLine();
										FileParser.brout.write("Source "+cnt+": "+strLine+" (line "+cntLine+")");
										FileParser.brout.newLine();
									}
								}

							}
						}

						flag=true;
					}


					break;




				default: 
					flag=false;
					break;



				}
			}

			//in.close();

			return flag;



		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
			return false;
		}


	}

	/*
	 * This function is used when the paraphrases for the Nouns is used for finding the answer.
	 * Because the paraphrases some times can be loose this function makes sure that the the regex is tight enough to pick meaningful matches.
	 * It makes sure that a particular paraphrase case is the only term in that phrase in a given line.
	 * 
	 */

	private boolean getRightMatch(String strLinePos, String nounSet,int indexx) {

		boolean flag=false;
		String dt="(the/DT |The/DT |a/DT |A/DT )?.*?";
		String posNounTag="(/NNP|/NNPS|/NN)";
		String posTag="(/POS)";
		nounSet=nounSet.replaceAll("'s", " 's");
		nounSet=nounSet.replaceAll("'t", " 't");
		//FileParser.brout.write(nounSet);
		nounSet=nounSet.replaceAll("\\.\\*\\?", " ");
		String[] noun=nounSet.split(" ");
		String pat=dt;


		if(indexx==0){
			for(int kk=0;kk<noun.length;kk++){
				if(kk==noun.length-1){
					if(noun[kk].equals("'s") || noun[kk].equals("'t")){
						pat+=noun[kk]+posTag+".*?";
					}
					else{
						pat+=noun[kk]+posNounTag+".*?";
					}
				}
				else{
					if(noun[kk].equals("'s")|| noun[kk].equals("'t")){
						pat+=noun[kk]+posTag+" ";
					}
					else{
						pat+=noun[kk]+posNounTag+" ";
					}
				}

			}
		}
		else{
			for(int kk=0;kk<noun.length;kk++){
				if(kk==noun.length-1){
					if(noun[kk].equals("'s")|| noun[kk].equals("'t")){
						pat+=noun[kk]+posTag;
					}
					else{
						pat+=noun[kk]+posNounTag;
					}
				}
				else{
					if(noun[kk].equals("'s")|| noun[kk].equals("'t")){
						pat+=noun[kk]+posTag+".*?";
					}
					else{
						pat+=noun[kk]+posNounTag+".*?";
					}
				}

			}
		}
		String realpat= "\\[ "+pat+" \\]";

		//FileParser.brout.write(realpat);

		Pattern pattern = Pattern.compile(realpat,Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
		//FileParser.brout.write("(\\b"+nounCase+"\\b,? .*?\\b"+question.allVerbs+"\\b.*?)(,\\s|\\.($|\\s))");
		Matcher 	matcher = pattern.matcher(strLinePos);

		while(matcher.find()){
			//FileParser.brout.write(realpat+" ------------------ "+matcher.group());

			flag=true;
		}
		return flag;
	}


	/*
	 * This function is used to get all the paraphrases of the Noun from the Question
	 */

	private String[] getPermutationsParaphrases(String nounCase) {
		try{
			String nounArray[]=nounCase.split(" ");
			//FileParser.brout.write(nounArray.length);

			if(nounArray.length==2){
				ArrayList<String> a= new ArrayList<String>();
				a.add(nounArray[0]+" "+nounArray[1]);

				a.add(nounArray[0]+".*?"+nounArray[1]);
				a.add(nounArray[0]);

				String[] hidden = a.toArray(new String[a.size()]);

				return hidden;
			}
			else if(nounArray.length==3){

				ArrayList<String> a= new ArrayList<String>();

				a.add(nounArray[0]+" "+nounArray[1]+" "+nounArray[2]);
				a.add(nounArray[0]+".*?"+nounArray[1]+".*?"+nounArray[2]);
				a.add(nounArray[0]+".*?"+nounArray[1]);
				a.add(nounArray[0]+".*?"+nounArray[2]);
				a.add(nounArray[1]+".*?"+nounArray[2]);
				//a.add(nounArray[0]);
				//a.add(nounArray[1]);

				String[] hidden = a.toArray(new String[a.size()]);

				return hidden;
			}
			/*else if(nounArray.length==4){
				return nounArray;
			}*/
			else if (nounArray.length==1){

				String[] hidden = new String[1];
				hidden[0]=nounCase;
				return hidden;

			}
			else {

				String[] hidden = new String[4];
				hidden[0]=nounCase;


				hidden[1]="";
				for(int i=1;i<nounArray.length;i++){
					if(i==nounArray.length-1){
						hidden[1]=hidden[1]+nounArray[i];
					}
					else{
						hidden[1]=hidden[1]+nounArray[i]+" ";
					}
				}


				hidden[2]="";
				for(int i=0;i<nounArray.length;i++){
					if(i==nounArray.length-1){
						//hidden[1]=hidden[1]+nounArray[i];
					}
					else if(i==nounArray.length-2){
						hidden[2]=hidden[2]+nounArray[i];
					}
					else{
						hidden[2]=hidden[2]+nounArray[i]+" ";
					}
				}

				hidden[3]="";
				for(int i=1;i<nounArray.length;i++){
					if(i==nounArray.length-1){
						//hidden[1]=hidden[1]+nounArray[i];
					}
					else if(i==nounArray.length-2){
						hidden[3]=hidden[3]+nounArray[i];
					}
					else{
						hidden[3]=hidden[3]+nounArray[i]+" ";
					}
				}


				return hidden;


			}

		}catch(Exception ex){

			String[] hidden = new String[1];
			hidden[0]="";
			return hidden;
		}
	}

	/*
	 * this functions is used to strip the POS Tags matched for the Index related Questions 
	 * 		".*[Ww](hat|hich) (index|indexes).*"+negVerbs+"\\?"
		".*[Ww](hat|hich) (index|indexes).*"+posVerbs+"\\?"
	 */

	private String modifyString(String strLine) {

		strLine=strLine.replaceAll("\\\\/", "yesssrandomsss");

		//FileParser.brout.write(strLine);
		strLine=strLine.replaceAll(".*?DT", "");

		//FileParser.brout.write(strLine);
		String[] words =strLine.split("(/.*? |/.*?$)");
		//String[] words =strLine.split("(/NN.*? |/NN.*?$)");

		String line="";
		int cnt =0;
		for(String word: words){
			//FileParser.brout.write(word);
			cnt++;
			word=	word.replace("]","");
			word = word.replaceAll("yesssrandomsss", "/");
			word=word.replace("[ ","");
			word = word.replaceAll("\\s", "");
			if(cnt==1||word.startsWith("'")||word.startsWith(",")||word.startsWith(".")||word.startsWith("%")||word.startsWith("n't")||word.startsWith("'t")||word.startsWith("'s")){
				line= line+word;
			}
			else{
				line=line+" "+word;


			}
			//FileParser.brout.write(word);
		}
		line=line.replaceAll("\\( ", "\\(");
		line=line.replaceAll(" \\)", "\\)");
		line=line.replaceAll("\\$ ", "\\$");

		return line;
	}



}
