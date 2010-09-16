import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Answer {



	public static boolean getAnswer(Matcher matcherr, int casei) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int cntLine=0;
		int cnt=0;
		try{

			String nounCase = matcherr.group(1);


			FileInputStream fstream = new FileInputStream("inputfile.txt");
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


					pattern = Pattern.compile("("+nounCase+" .*?)(,\\s|\\.($|\\s))",Pattern.DOTALL);
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
					pattern = Pattern.compile(""+nounCase+" [^,\\.]*?(fall|fell|loose|lost) ([0-9\\s.,/]*).*?(,\\s|\\.($|\\s))",Pattern.DOTALL);



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
					pattern = Pattern.compile(""+nounCase+" [^,\\.]*?(rise|gain|gained|rose) ([0-9\\s.,/]*).*?(,\\s|\\.($|\\s))",Pattern.DOTALL);
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
					pattern = Pattern.compile(""+nounCase+" [^,\\.]*?("+question.allVerbs+") .*(,\\s|\\.($|\\s))",Pattern.DOTALL);
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
