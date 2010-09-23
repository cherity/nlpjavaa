import java.util.ArrayList;


public class Questions {

	public ArrayList<String> questionList=new ArrayList<String>();

	public String  negVerbs="(fall|fell|falling|loose|lost|losing|collapse|collapsed|collapsing|carshing|crash|crashed|dip|dipped|dipping|declining|sinking|dropping|decline|declined|down|sink|sinked|drop|dropped|low|lower)";
	public String  posVerbs="(rise|risen|rising|climb|climbed|climbing|gain|gained|gaining|advanced|advancing|high|higher|advance|rose|grow|grown|growing|raised|raising|raise|hike|hiking|hiked|up)";
	public String  allVerbs="(rise|risen|rising|climb|climbed|climbing|gain|gained|gaining|advanced|advancing|high|higher|advance|rose|grow|grown|growing|raised|raising|raise|hike|hiking|hiked|up|fall|fell|falling|loose|lost|low|lower|losing|collapse|collapsed|collapsing|carshing|crash|drop|dropped|crashed|dip|dipped|decline|declined|dipping|declining|sinking|droppping|down|sink|sinked)";
	public String  extraEle="(went |have |had |has )?";
	
	public Questions(){

		questionList.add(".*[Ww]hat did (the )?.*?([A-Z].*) do\\?");


		questionList.add(".*[Hh]ow much did .*?([A-Z].*)\\s?.* "+negVerbs+"\\?");
		questionList.add(".*[Hh]ow much did .*?([A-Z].*)\\s?.* "+posVerbs+"\\?");


		questionList.add(".*[Dd]id (the )?.*?([A-Z].*) .*?"+allVerbs+" or "+allVerbs+"\\?");

		
		questionList.add(".*([Ww]hat|How much) did .*?([A-Z].*) close(d|) at\\?");


		questionList.add(".*([Ww]hat|How much) did (the )?.*?([A-Z].*) open(ed|) at\\?");
		questionList.add(".*([Ww]hat|How much) did (the )?.*?([A-Z].*) s(ell|old) at\\?");


		questionList.add(".*[Ww](hat|hich).*?(index|indexes).*"+negVerbs+"\\?");
		questionList.add(".*[Ww](hat|hich).*?(index|indexes).*"+posVerbs+"\\?");


		//questionList.add(".*[Ww]hat was\\s?(the)?\\s?(.*)\\?");
		questionList.add(".*[Ww]hat was\\s?(the)?\\s?([Dd]iscount [Rr]ate)\\?");

		questionList.add(".*[Ww]hat did\\s?(the)?\\s?(.*) do against\\s?(the)?\\s?(.*)\\?");
		questionList.add(".*Did\\s?(the)?\\s?(.*?) "+extraEle+allVerbs+" or "+extraEle+allVerbs+" against\\s?(the)?\\s?(.*?)\\?");

		questionList.add(".*[Ww](hat|hich)\\s?(company)?\\s?(stock|stocks)\\s?.*"+negVerbs+"\\?");
		questionList.add(".*[Ww](hat|hich)\\s?(company)?\\s?(stock|stocks)\\s?.*"+posVerbs+"\\?");
		questionList.add(".*\\?");



	}

}
