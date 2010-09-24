import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Answer {

	public String suffix="(to |at |)";

	public  boolean getAnswer(Matcher matcherr, int casei) {

		boolean flag=false;
		int cntLine=0, cnt=0;

		try{

			String nounCase;

			if(casei==4 ||casei==9||casei==3||casei==0||casei==1||casei==2){
				nounCase= matcherr.group(2);
			}
			else if(casei==5||casei==6){
				nounCase= matcherr.group(3);
			}
			else if(casei==14){
				nounCase="";
			}
			else{
				nounCase= matcherr.group(1);
			}

			/*FileInputStream fstream = new FileInputStream("inputfile.txt");
			//FileInputStream fstream = new FileInputStream("posfile.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));*/

			String strLine, strLinePos, caseQ;
			Pattern pattern;
			Matcher matcher;

			Questions question= new Questions();
			POSFileReader posff= new POSFileReader();
			//while ((strLine = br.readLine()) != null)

			for(int ttt=0;ttt<posff.freetextfile.size();ttt++)
			{

				strLinePos=posff.freeposfile.get(ttt);
				strLine=posff.freetextfile.get(ttt);


				cntLine++;
				switch(casei){
				case 0:

					boolean flagcase0=false;
					//pattern = Pattern.compile("(\\b"+nounCase+"\\b .*?"+question.allVerbs+")(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					//pattern = Pattern.compile("(\\b"+nounCase+"\\b .*"+question.allVerbs+".*?)(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					pattern = Pattern.compile("\\b("+nounCase+"\\b,? .*?\\b"+question.allVerbs+"\\b.*?)(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);

					matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						//String match = matcher.group(1).trim();
						String match = matcher.group(1).trim();
						String out="";
						/*if(question.negVerbs.matches(".*"+match+".*")){
							out="It Fell";

						}
						else if(question.posVerbs.matches(".*"+match+".*")){
							out="It Rose";
						}else{
							out=match.toUpperCase();
						}*/

						System.out.println("A "+cnt+": "+match+".");
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
						flagcase0=true;
					}

					//System.out.println(strLine);
					if(!flagcase0){
						nounCase=getDiffNoun(nounCase);

						//System.out.println("\\b"+nounCase+"\\b .*?\\b"+question.allVerbs+"\\b.*?(,\\s|\\.($|\\s))");

						pattern = Pattern.compile("\\b("+nounCase+"\\b,? .*?\\b"+question.allVerbs+"\\b.*?)(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);

						matcher = pattern.matcher(strLine);


						while (matcher.find()) {
							cnt++;
							String match = matcher.group(1).trim();
							String out="";
							/*if(question.negVerbs.matches(".*"+match+".*")){
								out="It Fell";

							}
							else if(question.posVerbs.matches(".*"+match+".*")){
								out="It Rose";
							}else{
								out=match.toUpperCase();
							}
							 */
							System.out.println("A "+cnt+": "+match+".");
							System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
							flag=true;
							flagcase0=true;
						}


					}



					break;


				case 1:


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
							System.out.print("A "+cnt+": ");
							for(int l=0;l<trimarr.length-1;l++){
								System.out.print(trimarr[l]);
							}
							System.out.println(".");
						}
						else{
							System.out.println("A "+cnt+": "+match+".");
						}
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
						flag3=true;
					}

					//System.out.println(strLine);


					if(!flag3){
						pattern = Pattern.compile("\\b"+nounCase+"\\b,? [^,\\.]*? ([0-9][0-9\\s\\.,/%]*) \\b"+question.negVerbs+"\\b.*?(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);


						matcher = pattern.matcher(strLine);


						while (matcher.find()) {
							cnt++;
							String match = matcher.group(1).trim();

							char[] trimarr= match.toCharArray();
							if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
								System.out.print("A "+cnt+": ");
								for(int l=0;l<trimarr.length-1;l++){
									System.out.print(trimarr[l]);
								}
								System.out.println(".");
							}
							else{
								System.out.println("A "+cnt+": "+match+".");
							}
							System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
							flag=true;
						}
					}




					break;

				case 2:



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
							System.out.print("A "+cnt+": ");
							for(int l=0;l<trimarr.length-1;l++){
								System.out.print(trimarr[l]);
							}
							System.out.println(".");
						}
						else{
							System.out.println("A "+cnt+": "+match+".");
						}
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
						flag2=true;
					}

					if(!flag2){
						pattern = Pattern.compile("\\b"+nounCase+"\\b,? [^,\\.]*? ([0-9][0-9\\s\\.,/%]*) \\b"+question.posVerbs+"\\b.*?(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);


						matcher = pattern.matcher(strLine);


						while (matcher.find()) {
							cnt++;
							String match = matcher.group(1).trim();

							char[] trimarr= match.toCharArray();
							if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
								System.out.print("A "+cnt+": ");
								for(int l=0;l<trimarr.length-1;l++){
									System.out.print(trimarr[l]);
								}
								System.out.println(".");
							}
							else{
								System.out.println("A "+cnt+": "+match+".");
							}
							System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
							flag=true;
						}
					}

					//System.out.println(strLine);



					break;






				case 3:



					boolean wrflag=true;
					//int cntt =matcherr.groupCount();
					//for(int tt=0;tt<= matcherr.groupCount();tt++){
					//	System.out.print(tt+matcherr.group(tt)+"            ");
					//}

					caseQ = matcherr.group(4);
					//System.out.println(nounCase+caseQ+" "+matcherr.group(6));

					pattern = Pattern.compile("\\b"+nounCase+"\\b,? [^\\.]*?\\b"+question.allVerbs+"\\b.*(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					//	pattern = Pattern.compile(".*\\b"+nounCase+"\\b.* \\b"+question.allVerbs+"\\b .*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					//pattern = Pattern.compile(".*\\b"+nounCase+"\\b.*(fell).*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					//System.out.println(".*\\b"+nounCase+"\\b.*fell.*");
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
							if(wrflag)
								System.out.println("A "+cnt+": "+neg.toUpperCase()+".");
							else
								System.out.println("A "+cnt+": "+match+".");
						}
						else if(question.posVerbs.matches(".*\\b"+match+"\\b.*")){
							if(wrflag)
								System.out.println("A "+cnt+": "+pos.toUpperCase()+".");
							else
								System.out.println("A "+cnt+": "+match+".");
						}
						else{
							System.out.println("A "+cnt+": "+match+".");
						}



						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
					}




					break;




				case 4:


					boolean flagclose=false;
					//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
					//System.out.println(""+nounCase+" [^,\\.]*?(to|at) ([0-9\\s.,/]*).*?(,\\s|\\.($|\\s))");
					pattern = Pattern.compile("\\b"+nounCase+"\\b,?.*?(closed|close) (to|at) ([0-9][0-9\\s\\.,/%]*).*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						String match = matcher.group(3).trim();

						char[] trimarr= match.toCharArray();
						if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
							System.out.print("A "+cnt+": ");
							for(int l=0;l<trimarr.length-1;l++){
								System.out.print(trimarr[l]);
							}
							System.out.println(".");
						}
						else{
							System.out.println("A "+cnt+": "+match+".");
						}
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
						flagclose=true;
					}



					if(!flagclose){

						pattern = Pattern.compile("\\b"+nounCase+"\\b,?.*?(to|at) ([0-9][0-9\\s\\.,/%]*).*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
						matcher = pattern.matcher(strLine);


						while (matcher.find()) {
							cnt++;
							String match = matcher.group(2).trim();

							char[] trimarr= match.toCharArray();
							if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
								System.out.print("A "+cnt+": ");
								for(int l=0;l<trimarr.length-1;l++){
									System.out.print(trimarr[l]);
								}
								System.out.println(".");
							}
							else{
								System.out.println("A "+cnt+": "+match+".");
							}
							System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
							flag=true;
						}
					}


					break;





				case 5:


					//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
					//System.out.println(""+nounCase+" [^,\\.]*?(to|at) ([0-9\\s.,/]*).*?(,\\s|\\.($|\\s))");
					pattern = Pattern.compile("\\b"+nounCase+"\\b,?.*?(open|opened|start|started) (to|at) ([0-9][0-9\\s\\.,/%]*).*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						String match = matcher.group(3).trim();

						char[] trimarr= match.toCharArray();
						if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
							System.out.print("A "+cnt+": ");
							for(int l=0;l<trimarr.length-1;l++){
								System.out.print(trimarr[l]);
							}
							System.out.println(".");
						}
						else{
							System.out.println("A "+cnt+": "+match+".");
						}
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
					}



					break;






				case 6:


					//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
					//System.out.println(""+nounCase+" [^,\\.]*?(to|at) ([0-9\\s.,/]*).*?(,\\s|\\.($|\\s))");
					pattern = Pattern.compile("\\b"+nounCase+"\\b,?.*?(sell|sold|bought) (to|at) ([0-9][0-9\\s\\.,/%]*).*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						String match = matcher.group(3).trim();

						char[] trimarr= match.toCharArray();
						if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
							System.out.print("A "+cnt+": ");
							for(int l=0;l<trimarr.length-1;l++){
								System.out.print(trimarr[l]);
							}
							System.out.println(".");
						}
						else{
							System.out.println("A "+cnt+": "+match+".");
						}
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
					}



					break;



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
								System.out.print("A "+cnt+": ");
								for(int l=0;l<trimarr.length-1;l++){
									System.out.print(trimarr[l]);
								}
								System.out.println(".");
							}
							else{
								System.out.println("A "+cnt+": "+match+".");
							}
							//System.out.println(matchFirst1);
							System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
							flag=true;
						}

					}
					break;




					/*
				case 7:
					/*

					//pattern = Pattern.compile(".*?([A-Z].*? [iI]ndex) .*?"+question.negVerbs+".*?",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					pattern = Pattern.compile(".*?([A-Z].*? [iI]ndex) .*?"+question.negVerbs+".*?",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						String match = matcher.group(1).trim();

						char[] trimarr= match.toCharArray();
						if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
							System.out.print("A "+cnt+": ");
							for(int l=0;l<trimarr.length-1;l++){
								System.out.print(trimarr[l]);
							}
							System.out.println(".");
						}
						else{
							System.out.println("A "+cnt+": "+match+".");
						}
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
					}

					//System.out.println(strLine);



					boolean flag2=false;
					pattern = Pattern.compile("[,\\.] [a-z0-9]*\\s?([A-Z].*? [iI]ndex) .*?"+question.negVerbs+".*?",Pattern.DOTALL);
					//pattern = Pattern.compile(".*[,\\.]\\s[a-z0-9]* ([A-Z].* [iI]ndex) .*?"+question.posVerbs+".*?",Pattern.DOTALL);
					matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						String match = matcher.group(1).trim();

						char[] trimarr= match.toCharArray();
						if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
							System.out.print("A "+cnt+": ");
							for(int l=0;l<trimarr.length-1;l++){
								System.out.print(trimarr[l]);
							}
							System.out.println(".");
						}
						else{
							System.out.println("A "+cnt+": "+match+".");
						}
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
						flag2=true;
					}

					//System.out.println(strLine);
					if(!flag2){
						pattern = Pattern.compile("^([A-Z].*? [iI]ndex) .*?"+question.negVerbs+".*?",Pattern.DOTALL);
						//pattern = Pattern.compile(".*[,\\.]\\s[a-z0-9]* ([A-Z].* [iI]ndex) .*?"+question.posVerbs+".*?",Pattern.DOTALL);
						matcher = pattern.matcher(strLine);


						while (matcher.find()) {
							cnt++;
							String match = matcher.group(1).trim();

							char[] trimarr= match.toCharArray();
							if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
								System.out.print("A "+cnt+": ");
								for(int l=0;l<trimarr.length-1;l++){
									System.out.print(trimarr[l]);
								}
								System.out.println(".");
							}
							else{
								System.out.println("A "+cnt+": "+match+".");
							}
							System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
							flag=true;
							flag2=true;
						}
					}





					break;

					 */
					/*
				case 8:

					boolean flag3=false;
					//latest--pattern = Pattern.compile("[,\\.] [A-Za-z0-9]*\\s?([A-Z].*? [iI]ndex) .*?"+question.posVerbs+".*?",Pattern.DOTALL);
					//pattern = Pattern.compile(".*[,\\.]\\s[a-z0-9]* ([A-Z].* [iI]ndex) .*?"+question.posVerbs+".*?",Pattern.DOTALL);

					pattern = Pattern.compile("(\\[.* [iI]ndex .*\\])"+question.posVerbs+".*?",Pattern.DOTALL);
					matcher = pattern.matcher(strLine);

					//System.out.println(strLine);
					while (matcher.find()) {
						cnt++;
						String match = matcher.group(1).trim();

						char[] trimarr= match.toCharArray();
						if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
							System.out.print("A "+cnt+": ");
							for(int l=0;l<trimarr.length-1;l++){
								System.out.print(trimarr[l]);
							}
							System.out.println(".");
						}
						else{
							System.out.println("A "+cnt+": "+match+".");
						}
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
						flag3=true;
					}

					//System.out.println(strLine);
					{
						pattern = Pattern.compile("^([A-Z].*? [iI]ndex) .*?"+question.posVerbs+".*?",Pattern.DOTALL);
						//pattern = Pattern.compile(".*[,\\.]\\s[a-z0-9]* ([A-Z].* [iI]ndex) .*?"+question.posVerbs+".*?",Pattern.DOTALL);
						matcher = pattern.matcher(strLine);


						while (matcher.find()) {
							cnt++;
							String match = matcher.group(1).trim();

							char[] trimarr= match.toCharArray();
							if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
								System.out.print("A "+cnt+": ");
								for(int l=0;l<trimarr.length-1;l++){
									System.out.print(trimarr[l]);
								}
								System.out.println(".");
							}
							else{
								System.out.println("A "+cnt+": "+match+".");
							}
							System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
							flag=true;

						}
					}



					break;

					 */


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
								System.out.print("A "+cnt+": ");
								for(int l=0;l<trimarr.length-1;l++){
									System.out.print(trimarr[l]);
								}
								System.out.println(".");
							}
							else{
								System.out.println("A "+cnt+": "+match+".");
							}
							System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
							flag=true;
						}
					}

					break;








				case 9:

					boolean flagdr=false;
					//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
					//System.out.println(""+nounCase+" [^,\\.]*?(to|at) ([0-9\\s.,/]*).*?(,\\s|\\.($|\\s))");

					//pattern = Pattern.compile("([0-9][0-9\\s\\.,/%]*) [^,\\.]*?\\b"+nounCase+"\\b.*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					pattern = Pattern.compile("([0-9][0-9\\s\\.,/%]*) in (the )?\\b"+nounCase+"\\b.*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);

					matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						String match = matcher.group(1).trim();

						char[] trimarr= match.toCharArray();
						if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
							System.out.print("A "+cnt+": ");
							for(int l=0;l<trimarr.length-1;l++){
								System.out.print(trimarr[l]);
							}
							System.out.println(".");
						}
						else{
							System.out.println("A "+cnt+": "+match+".");
						}


						//System.out.println("A "+cnt+": "+match+".");
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
						flagdr=true;
					}




					pattern = Pattern.compile("\\b"+nounCase+"\\b,? [^,\\.]*?(was |is )([0-9][0-9\\s\\.,/%]*)",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						String match = matcher.group(2).trim();

						char[] trimarr= match.toCharArray();
						if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
							System.out.print("A "+cnt+": ");
							for(int l=0;l<trimarr.length-1;l++){
								System.out.print(trimarr[l]);
							}
							System.out.println(".");
						}
						else{
							System.out.println("A "+cnt+": "+match+".");
						}

						//System.out.println("A "+cnt+": "+match+".");
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
						flagdr=true;
					}



					pattern = Pattern.compile("\\b"+nounCase+"\\b,? [^,\\.]*?(to |at )([0-9][0-9\\s\\.,/%]*).*?",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						String match = matcher.group(2).trim();

						char[] trimarr= match.toCharArray();
						if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','){
							System.out.print("A "+cnt+": ");
							for(int l=0;l<trimarr.length-1;l++){
								System.out.print(trimarr[l]);
							}
							System.out.println(".");
						}
						else{
							System.out.println("A "+cnt+": "+match+".");
						}
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
					}


					break;





				case 10:

					String c1= matcherr.group(2);
					String c2= matcherr.group(4);
					//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
					//System.out.println(""+nounCase+" [^,\\.]*?(to|at) ([0-9\\s.,/]*).*?(,\\s|\\.($|\\s))");
					pattern = Pattern.compile("\\b"+c1+"\\b,?.*? \\b"+question.allVerbs+"\\b .*?(against|compared to|in comparison to|opposed to|in oppposing to|counter to|contrary to|in contrary to|in counter to|opposing|versus|vs) .*?\\b"+c2+"\\b.*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);
					//System.out.println("\\b"+c1+"\\b.*? \\b"+question.allVerbs+"\\b .*?against .*?\\b"+c2+"\\b.*");

					while (matcher.find()) {
						cnt++;
						String match = matcher.group(1).trim();


						System.out.println("A "+cnt+": "+match.toUpperCase()+".");

						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
					}






					pattern = Pattern.compile("\\b"+c2+"\\b,?.*? \\b"+question.allVerbs+"\\b .*?(against|compared to|in comparison to|opposed to|in oppposing to|counter to|contrary to|in contrary to|in counter to|opposing|versus|vs) .*?\\b"+c1+"\\b.*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);
					//System.out.println("\\b"+c1+"\\b.*? \\b"+question.allVerbs+"\\b .*?against .*?\\b"+c2+"\\b.*");

					while (matcher.find()) {
						cnt++;
						String match = matcher.group(1).trim();

						if(question.negVerbs.matches(".*"+match+".*")){
							System.out.println("A "+cnt+": "+"RISE"+".");
						}
						else if(question.posVerbs.matches(".*"+match+".*")){
							System.out.println("A "+cnt+": "+"FALL"+".");
						}

						//System.out.println("A "+cnt+": "+match.toUpperCase()+".");

						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
					}








					break;




				case 11:


					boolean wrflag2=true;
					String c3= matcherr.group(2);
					String c4= matcherr.group(8);

					pattern = Pattern.compile("\\b"+c3+"\\b,?.*? \\b"+question.allVerbs+"\\b .*?(against|compared to|in comparison to|opposed to|in oppposing to|counter to|contrary to|in contrary to|in counter to|opposing|versus|vs) .*?\\b"+c4+"\\b.*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);
					//System.out.println("\\b"+c3+"\\b.*? \\b"+question.allVerbs+"\\b .*?against .*?\\b"+c4+"\\b.*");

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
							if(wrflag2)
								System.out.println("A "+cnt+": "+neg.toUpperCase()+".");
							else
								System.out.println("A "+cnt+": "+match.toUpperCase()+".");
						}
						else if(question.posVerbs.matches(".*"+match+".*")){
							if(wrflag2)
								System.out.println("A "+cnt+": "+pos.toUpperCase()+".");
							else
								System.out.println("A "+cnt+": "+match.toUpperCase()+".");
						}
						else{
							System.out.println("A "+cnt+": "+match.toUpperCase()+".");
						}



						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
					}









					wrflag2=true;

					pattern = Pattern.compile("\\b"+c4+"\\b,?.*? \\b"+question.allVerbs+"\\b .*?(against|compared to|in comparison to|opposed to|in oppposing to|counter to|contrary to|in contrary to|in counter to|opposing|versus|vs) .*?\\b"+c3+"\\b.*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);
					//System.out.println("\\b"+c3+"\\b.*? \\b"+question.allVerbs+"\\b .*?against .*?\\b"+c4+"\\b.*");

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
							if(wrflag2)
								System.out.println("A "+cnt+": "+pos.toUpperCase()+".");
							else
								System.out.println("A "+cnt+": "+match.toUpperCase()+".");
						}
						else if(question.posVerbs.matches(".*"+match+".*")){
							if(wrflag2)
								System.out.println("A "+cnt+": "+neg.toUpperCase()+".");
							else
								System.out.println("A "+cnt+": "+match.toUpperCase()+".");
						}
						else{
							System.out.println("A "+cnt+": "+match.toUpperCase()+".");
						}



						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
					}









					break;




					/*

				case 12:

					//pattern = Pattern.compile(".*(\\[[A-Z].*?\\]).*"+question.negVerbs+".*?",Pattern.DOTALL);
					//pattern = Pattern.compile(".*([A-Z].*)[^,\\.]*"+question.negVerbs+".*?",Pattern.DOTALL);


					pattern = Pattern.compile(".*\\[(.*?)\\].*?\\b"+question.negVerbs+"\\b.*?",Pattern.DOTALL);


					matcher = pattern.matcher(strLinePos);

					while (matcher.find()) {
						cnt++;
						String matchFirst = matcher.group(1).trim();

						String match = modifyString(matchFirst);

						char[] trimarr= match.toCharArray();
						if(trimarr[trimarr.length-1]=='.' || trimarr[trimarr.length-1]==','|| trimarr[trimarr.length-1]==' '){
							System.out.print("A "+cnt+": ");
							for(int l=0;l<trimarr.length-1;l++){
								System.out.print(trimarr[l]);
							}
							System.out.println(".");
						}
						else{
							System.out.println("A "+cnt+": "+match+".");
						}
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
					}

					//System.out.println("-------------------");
					break;


					 */



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
							//System.out.println(match);
							for(String a :ast){
								//System.out.println(a);
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
								//System.out.println(verb);
								//Matcher m2 = Pattern.compile("("+match+".*?"+verb+").*").matcher(strLine);

								/*IMPPPPPPP
								Matcher m2 = Pattern.compile("("+match+".*?"+verb+").*").matcher(strLine);

								while(m2.find()){
									String gg =m2.group(1);
									String ggarr[] =gg.split(" ");
									if(ggarr.length<=10){
										cnt++;

										System.out.println("A "+cnt+": "+match+".");
										System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
									}
								}

								 */

								//Matcher m2 = Pattern.compile("("+match+".*?"+verb+").*[0-9]+").matcher(strLine);
								//							 "(\\b"+match+"\\b,? .*?\\b"+verb+"\\b).*[0-9]+"
								Matcher m2 = Pattern.compile("(\\b"+match+"\\b,? .*?\\b"+verb+").*[0-9]+").matcher(strLine);

								while(m2.find()){
									//System.out.println("--------" +m2.group());
									String distStr =m2.group(1);
									String dist[] =distStr.split(" ");
									if(dist.length<=10){
										cnt++;

										System.out.println("A "+cnt+": "+match+".");
										System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
									}
								}


							}
						}




						flag=true;
					}


					break;




					/*

					pattern = Pattern.compile(".*?(.*).*\\b"+question.posVerbs+"\\b.*?",Pattern.DOTALL);


					matcher = pattern.matcher(strLine);

					while (matcher.find()) {

						String matchFirst = matcher.group(1).trim();

						//String match = modifyString(matchFirst);
						String match = matchFirst;
						if(match.matches(".*[iI]ndex.*")){
							continue;	
						}

						cnt++;


						System.out.println("A "+cnt+": "+match+".");
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
					}

					//System.out.println("-------------------");
					break;
					 */






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
							//System.out.println(match);
							for(String a :ast){
								//System.out.println(a);
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
									//System.out.println("--------" +m2.group());
									String distStr =m2.group(1);
									String dist[] =distStr.split(" ");
									if(dist.length<=10){
										cnt++;

										System.out.println("A "+cnt+": "+match+".");
										System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
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

	private String getDiffNoun(String nounCase) {
		// TODO Auto-generated method stub

		String strnoun[] =nounCase.split(" ");
		String newnoun="";
		int i=0;
		for(String str:strnoun){
			i++;
			if(i==strnoun.length){
				newnoun+=str;
			}else{
				newnoun+=str+"\\s?.*?\\s?";
			}

		}

		return newnoun;
	}

	private String modifyString(String strLine) {
		// TODO Auto-generated method stub

		strLine=strLine.replaceAll("\\\\/", "yesssrandomsss");

		//System.out.println(strLine);
		strLine=strLine.replaceAll(".*?DT", "");

		//System.out.println(strLine);
		String[] words =strLine.split("(/.*? |/.*?$)");
		//String[] words =strLine.split("(/NN.*? |/NN.*?$)");

		String line="";
		int cnt =0;
		for(String word: words){
			//System.out.println(word);
			cnt++;
			word=	word.replace("]","");
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

		return line;
	}



}
