import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Answer {

	public String suffix="(to |at |)";

	public  boolean getAnswer(Matcher matcherr, int casei) {
		// TODO Auto-generated method stub

		boolean flag=false;
		int cntLine=0;
		int cnt=0;
		try{

			String nounCase;
			if(casei==4 ||casei==5||casei==6||casei==9){
				nounCase= matcherr.group(2);
			}
			else{
				nounCase= matcherr.group(1);
			}

			/*FileInputStream fstream = new FileInputStream("inputfile.txt");


			//FileInputStream fstream = new FileInputStream("posfile.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));*/
			String strLine;
			String strLinePos;
			Pattern pattern;
			Matcher matcher;
			String caseQ;
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


					//pattern = Pattern.compile("(\\b"+nounCase+"\\b .*?"+question.allVerbs+")(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					//pattern = Pattern.compile("(\\b"+nounCase+"\\b .*"+question.allVerbs+".*?)(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					pattern = Pattern.compile("\\b"+nounCase+"\\b .*?\\b"+question.allVerbs+"\\b.*?(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);

					matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						String match = matcher.group(1).trim();
						String out="";
						if(question.negVerbs.matches(".*"+match+".*")){
							out="It Fell";

						}
						else if(question.posVerbs.matches(".*"+match+".*")){
							out="It Rose";
						}else{
							out=match.toUpperCase();
						}

						System.out.println("A "+cnt+": "+out+".");
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
					}

					//System.out.println(strLine);




					break;


				case 1:


					boolean flag3=false;
					caseQ = matcherr.group(2);
					//Pattern pattern = Pattern.compile("("+nounCase+"[^,\\.]*? (fall|fell|loose|lost) .*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
					pattern = Pattern.compile("\\b"+nounCase+"\\b [^,\\.]*?\\b"+question.negVerbs+"\\b ([0-9][0-9\\s\\.,/%]*).*?(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);



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
						pattern = Pattern.compile("\\b"+nounCase+"\\b [^,\\.]*? ([0-9][0-9\\s\\.,/%]*) \\b"+question.negVerbs+"\\b.*?(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);


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

					caseQ = matcherr.group(2);
					//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
					//pattern = Pattern.compile("\\b"+nounCase+"\\b [^,\\.]*?"+question.posVerbs+" ([0-9][0-9\\s\\.,/%]*).*?(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					pattern = Pattern.compile("\\b"+nounCase+"\\b [^,\\.]*?\\b"+question.posVerbs+"\\b ([0-9][0-9\\s\\.,/%]*).*?(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);


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
						pattern = Pattern.compile("\\b"+nounCase+"\\b [^,\\.]*? ([0-9][0-9\\s\\.,/%]*) \\b"+question.posVerbs+"\\b.*?(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);


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

					caseQ = matcherr.group(2);
					pattern = Pattern.compile("\\b"+nounCase+"\\b [^,\\.]*?\\b"+question.allVerbs+"\\b .*(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						String match = matcher.group(1).trim();
						String pos="";
						String neg="";
						String x=caseQ;
						String y=matcherr.group(3);

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
							wrflag=false;
						}



						if(question.negVerbs.matches(".*"+match+".*")){
							if(wrflag)
								System.out.println("A "+cnt+": "+neg.toUpperCase()+".");
							else
								System.out.println("A "+cnt+": "+match+".");
						}
						else if(question.posVerbs.matches(".*"+match+".*")){
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

					//System.out.println(strLine);



					break;




				case 4:


					//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
					//System.out.println(""+nounCase+" [^,\\.]*?(to|at) ([0-9\\s.,/]*).*?(,\\s|\\.($|\\s))");
					pattern = Pattern.compile("\\b"+nounCase+"\\b.*?(closed|close) (to|at) ([0-9][0-9\\s\\.,/%]*).*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
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

					//System.out.println(strLine);






					if(!flag){
						pattern = Pattern.compile("\\b"+nounCase+"\\b.*?(to|at) ([0-9][0-9\\s\\.,/%]*).*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
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
					pattern = Pattern.compile("\\b"+nounCase+"\\b.*?(open|opened|start|started) (to|at) ([0-9][0-9\\s\\.,/%]*).*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
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

					//System.out.println(strLine);




					break;






				case 6:


					//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
					//System.out.println(""+nounCase+" [^,\\.]*?(to|at) ([0-9\\s.,/]*).*?(,\\s|\\.($|\\s))");
					pattern = Pattern.compile("\\b"+nounCase+"\\b.*?(sell|sold|bought) (to|at) ([0-9][0-9\\s\\.,/%]*).*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
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

					//System.out.println(strLine);




					break;

				case 7:

					pattern = Pattern.compile(".*(\\[.*?[iI]ndex.*?\\]).*?\\b"+question.negVerbs+"\\b.*?",Pattern.DOTALL);
					matcher = pattern.matcher(strLinePos);

					while (matcher.find()) {
						cnt++;
						String matchFirst = matcher.group(1).trim();
						//String matchFirst1 = matcher.group(2).trim();

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
						//System.out.println(matchFirst1);
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
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


					break;








				case 9:

					boolean flagdr=false;
					//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
					//System.out.println(""+nounCase+" [^,\\.]*?(to|at) ([0-9\\s.,/]*).*?(,\\s|\\.($|\\s))");






					//pattern = Pattern.compile("([0-9][0-9\\s\\.,/%]*) [^,\\.]*?\\b"+nounCase+"\\b.*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					pattern = Pattern.compile("([0-9][0-9\\s\\.,/%]*) in (the)? \\b"+nounCase+"\\b.*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);


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




					pattern = Pattern.compile("\\b"+nounCase+"\\b [^,\\.]*?was ([0-9][0-9\\s\\.,/%]*)",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
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

					//System.out.println(strLine);




					pattern = Pattern.compile("\\b"+nounCase+"\\b [^,\\.]*?(to|at) ([0-9][0-9\\s\\.,/%]*).*?(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
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

					//System.out.println(strLine);



					break;












				case 10:

					String c1= matcherr.group(2);
					String c2= matcherr.group(4);
					//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
					//System.out.println(""+nounCase+" [^,\\.]*?(to|at) ([0-9\\s.,/]*).*?(,\\s|\\.($|\\s))");
					pattern = Pattern.compile("\\b"+c1+"\\b.*? \\b"+question.allVerbs+"\\b .*?against .*?\\b"+c2+"\\b.*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						String match = matcher.group(1).trim();


						System.out.println("A "+cnt+": "+match.toUpperCase()+".");

						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
					}

					//System.out.println(strLine);




					break;




				case 11:


					boolean wrflag2=true;
					String c3= matcherr.group(2);
					String c4= matcherr.group(6);
					//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
					//System.out.println(""+nounCase+" [^,\\.]*?(to|at) ([0-9\\s.,/]*).*?(,\\s|\\.($|\\s))");
					pattern = Pattern.compile("\\b"+c3+"\\b.*? \\b"+question.allVerbs+"\\b .*?against .*?\\b"+c4+"\\b.*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						String match = matcher.group(1).trim();

						String pos="";
						String neg="";
						String x=matcherr.group(3);
						String y=matcherr.group(4);

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

					//System.out.println(strLine);




					break;






				case 12:

					//pattern = Pattern.compile(".*(\\[[A-Z].*?\\]).*"+question.negVerbs+".*?",Pattern.DOTALL);
					//pattern = Pattern.compile(".*([A-Z].*)[^,\\.]*"+question.negVerbs+".*?",Pattern.DOTALL);


					pattern = Pattern.compile(".*(\\[.*?\\]).*?\\b"+question.negVerbs+"\\b.*?",Pattern.DOTALL);


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






				case 13:

					//pattern = Pattern.compile(".*(\\[[A-Z].*?\\]).*"+question.negVerbs+".*?",Pattern.DOTALL);
					//pattern = Pattern.compile(".*([A-Z].*)[^,\\.]*"+question.negVerbs+".*?",Pattern.DOTALL);


					pattern = Pattern.compile("([A-Z].*).*?\\b"+question.posVerbs+"\\b.*?",Pattern.DOTALL);


					matcher = pattern.matcher(strLine);

					while (matcher.find()) {

						String matchFirst = matcher.group(1).trim();

						//String match = modifyString(matchFirst);
						String match = matchFirst;
						if(match.matches(".*[iI]ndex.*")){
							continue;	
						}

						cnt++;
						/*
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
						 */

						System.out.println("A "+cnt+": "+match+".");
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
					}

					//System.out.println("-------------------");
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

	private String modifyString(String strLine) {
		// TODO Auto-generated method stub


		strLine=strLine.replaceAll("\\\\/", "yesssrandomsss");

		String[] words =strLine.split("(/.*? |/.*?$)");

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
