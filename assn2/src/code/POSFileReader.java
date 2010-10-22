package code;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class POSFileReader {

	public void getCount(String fileName) {
		// TODO Auto-generated method stub
		try{


			FileInputStream fstream = new FileInputStream(fileName);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String strLine;

			
			Document d = new Document();
			while ((strLine = br.readLine()) != null)   {
				if(!strLine.equalsIgnoreCase("")){
					//System.out.println(strLine);
					
					if(strLine.contains(" <<")){
						d = getDocument(strLine);
					}else if(strLine.contains(">> END")){
						//store the values
					}
					else{
						parseLineforNN(strLine, d);
						parseLineforNNpair(strLine, d);
					}
				}
			}

		}catch (Exception e){

			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();

		}
	}

	private Document getDocument(String strLine) {
		Document dd= new Document();
		Pattern pattern  = Pattern.compile("(.*) <<");
		Matcher matcher;
		matcher = pattern.matcher(strLine);
		while (matcher.find()) {
			
			String id = matcher.group(1).trim();
			
			for(Document ddd:CountGenerator.docList){
				if(ddd.id.equalsIgnoreCase(id)){
					dd=ddd;
				}
			}
			
		}
		return dd;
	}

	private void parseLineforNN(String strLine, Document d) {
		
		Pattern pattern  = Pattern.compile("/NN");
		Matcher matcher;
		matcher = pattern.matcher(strLine);
		int cnt=0;
		while (matcher.find()) {
			
			cnt++;
		
			
		}
		d.NNcount+=cnt;
		
		//System.out.println(d.id+"  "+d.NNcount+"  "+cnt);
		
	}
	
	
	
	
	private void parseLineforNNpair(String strLine, Document d) {
		
		Pattern pattern  = Pattern.compile("/NN :/: [A-Za-z-]*/(JJ|NN)");
		Matcher matcher;
		matcher = pattern.matcher(strLine);
		int cnt=0;
		while (matcher.find()) {
			
			cnt++;
		
			
		}
		d.NNpaircount+=cnt;
		
		//System.out.println(d.id+"  "+d.NNpaircount+"  "+cnt);
		
	}
	

}
