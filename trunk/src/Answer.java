import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Answer {



	public  boolean getAnswer(Matcher matcherr, int casei) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int cntLine=0;
		int cnt=0;
		try{

			String nounCase;
			if(casei==4 ||casei==5||casei==6){
				nounCase= matcherr.group(2);
			}
			else{
				nounCase= matcherr.group(1);
			}

			FileInputStream fstream = new FileInputStream("inputfile.txt");


			//FileInputStream fstream = new FileInputStream("posfile.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			Pattern pattern;
			Matcher matcher;
			String caseQ;
			Questions question= new Questions();

			while ((strLine = br.readLine()) != null)
			{
				cntLine++;
				switch(casei){
				case 0:


					pattern = Pattern.compile("(\\b"+nounCase+"\\b .*?)(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(strLine);


					while (matcher.find()) {
						cnt++;
						String match = matcher.group(1).trim();

						System.out.println("A "+cnt+": "+match+".");
						System.out.println("Source "+cnt+": "+strLine+" (line "+cntLine+")");
						flag=true;
					}

					//System.out.println(strLine);




					break;


				case 1:


					caseQ = matcherr.group(2);
					//Pattern pattern = Pattern.compile("("+nounCase+"[^,\\.]*? (fall|fell|loose|lost) .*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
					pattern = Pattern.compile("\\b"+nounCase+"\\b [^,\\.]*?"+question.negVerbs+" ([0-9\\s.,/]*).*?(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);



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

				case 2:





					caseQ = matcherr.group(2);
					//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
					pattern = Pattern.compile("\\b"+nounCase+"\\b [^,\\.]*?"+question.posVerbs+" ([0-9\\s.,/]*).*?(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
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






				case 3:



					boolean wrflag=true;
					//int cntt =matcherr.groupCount();
					//for(int tt=0;tt<= matcherr.groupCount();tt++){
					//	System.out.print(tt+matcherr.group(tt)+"            ");
					//}

					caseQ = matcherr.group(2);
					pattern = Pattern.compile("\\b"+nounCase+"\\b [^,\\.]*?"+question.allVerbs+" .*(,\\s|\\.($|\\s))",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
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
					pattern = Pattern.compile("\\b"+nounCase+"\\b.*?(closed|close) (to|at) ([0-9\\s.,/]*).*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
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
						pattern = Pattern.compile("\\b"+nounCase+"\\b.*?(to|at) ([0-9\\s.,/]*).*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
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
					pattern = Pattern.compile("\\b"+nounCase+"\\b.*?(open|opened|start|started) (to|at) ([0-9\\s.,/]*).*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
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
					pattern = Pattern.compile("\\b"+nounCase+"\\b.*?(sell|sold|bought) (to|at) ([0-9\\s.,/]*).*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
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
					 */
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
							flag2=true;
						}
					}



					break;





				case 10:

					String c1= matcherr.group(2);
					String c2= matcherr.group(3);
					//Pattern pattern = Pattern.compile("("+nounCase+"[^\\.]*? (rise|gain|gained|rose).*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
					//System.out.println(""+nounCase+" [^,\\.]*?(to|at) ([0-9\\s.,/]*).*?(,\\s|\\.($|\\s))");
					pattern = Pattern.compile("\\b"+c1+"\\b.*? ("+question.allVerbs+") .*?against .*?\\b"+c2+"\\b.*",Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
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




					break;

				default: break;



				}
			}

			in.close();

			return flag;



		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
			return false;
		}


	}



}
