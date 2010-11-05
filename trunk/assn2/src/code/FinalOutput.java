package code;

/*
 * Ashish Tomar
 * NLP HW 2
 * 
 * Converts the ARFF file output to text file as required for the assignment. 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class FinalOutput {

	public static Hashtable<Integer, String> classifiedValues;

	public static FileOutputStream fstreamOut ;
	public static DataOutputStream inOut ;
	public static BufferedWriter brOut;

	public static FileInputStream fstream;
	public static DataInputStream in ;
	public static BufferedReader br ;

	public static FileInputStream fstream2;
	public static DataInputStream in2 ;
	public static BufferedReader br2 ;

	/*
	 * Converts the ARFF file output to text file as required for the assignment. 
	 */
	public static void main(String args[]){

		try{


			classifiedValues=new Hashtable<Integer, String> ();
			fstream = new FileInputStream(args[0]);
			in = new DataInputStream(fstream);
			br = new BufferedReader(new InputStreamReader(in));


			fstream2 = new FileInputStream(args[1]);
			in2 = new DataInputStream(fstream2);
			br2 = new BufferedReader(new InputStreamReader(in2));


			fstreamOut = new FileOutputStream(args[3]);
			inOut = new DataOutputStream(fstreamOut);
			brOut = new BufferedWriter(new OutputStreamWriter(inOut));

			setTheClassifiedValues(br2);


			readAndWrite(args[2],br,brOut);


			brOut.flush();
			inOut.close();

			in2.close();
			in.close();
		}catch (Exception e){

			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();

		}

	}

	/*
	 * Reads the ARFF file output and write sit to text file as required for the assignment. 
	 */
	private static void readAndWrite(String classifierCase, BufferedReader brr, BufferedWriter brOut2) throws IOException {
		// TODO Auto-generated method stub

		String strLine="";
		int cnt=0;
		boolean flag = false;
		Pattern pattern ;
		Matcher matcher;
		pattern= Pattern.compile("<id>(.*)</id><review>(.*)</review>.*");

		String opTag="";

		if(classifierCase.equalsIgnoreCase("multi")){

			opTag="star";

		}
		else if(classifierCase.equalsIgnoreCase("binary")){

			opTag = "PN";
		}
		else if(classifierCase.equalsIgnoreCase("reviewer")){

			opTag="reviewer";
		}


		while ((strLine = brr.readLine()) != null)   {
			if(!strLine.equalsIgnoreCase("")){


				matcher = pattern.matcher(strLine);
				while (matcher.find()) {
					cnt++;


					String id ;
					String match ;
					id = matcher.group(1).trim();
					match = matcher.group(2).trim();


					brOut2.write("<id>");
					brOut2.write(id);
					brOut2.write("</id>");


					brOut2.write("<"+opTag+">");

					String s = classifiedValues.get(cnt);

					if(classifierCase.equalsIgnoreCase("binary")){

						if(s.equalsIgnoreCase("1")){
							brOut2.write("P");
						}
						else if(s.equalsIgnoreCase("0")){
							brOut2.write("N");
						}

					}
					else{
						brOut2.write(s);
					}

					brOut2.write("</"+opTag+">");

					brOut2.write("<review>");
					brOut2.write(match);
					brOut2.write("</review>");


					brOut2.newLine();
					brOut2.flush();

				}

			}
		}

		//System.out.println(cnt);

	}

	/*
	 * Enters the classified results values into the data structure.
	 */
	private static void setTheClassifiedValues(BufferedReader brr) throws IOException {

		String strLine="";
		int cnt=0;
		boolean flag = false;

		while ((strLine = brr.readLine()) != null)   {

			if(flag && !(strLine.equalsIgnoreCase(""))   && !(strLine.equalsIgnoreCase("@data"))){
				cnt++;
				//System.out.println(strLine);
				String extracted = extractValue(strLine);
				classifiedValues.put(cnt, extracted);
				//System.out.println(extracted);
			}


			if(strLine.equalsIgnoreCase("@data")){
				flag = true;

			}



		}


		//System.out.println(cnt);
	}

	/*
	 * Extracts classified results values.
	 */
	private static String extractValue(String strLine) {

		String stringclassifiedVal="";
		char arr[] = strLine.toCharArray();
		char classifiedVal = arr[arr.length-1];
		stringclassifiedVal = Character.toString(classifiedVal);
		return stringclassifiedVal;

	}



}
