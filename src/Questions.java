import java.util.ArrayList;


public class Questions {

	public ArrayList<String> questionList=new ArrayList<String>();

	public String  negVerbs="(fall|fell|loose|lost|collapse|collapsed|crash|crashed|dip(ped|)|decline|declined|down|sink)";
	public String  posVerbs="(rise(n|)|gain|gained|rose|grow|raised|raise|hike(d|)|up)";

	public Questions(){

		questionList.add(".*[Ww]hat did .*?([A-Z].*) do\\?");


		questionList.add(".*[Hh]ow much did .*?([A-Z].*)\\s?.* "+negVerbs+"\\?");

		questionList.add(".*[Hh]ow much did .*?([A-Z].*)\\s?.* "+posVerbs+"\\?");


		questionList.add(".*[Dd]id .*?([A-Z].*) .*?(rise(n|)|fall|gain|gained|fell|rose|loose|lost|grow|raised|raise|hike(d|)|up|collapse|collapsed|crash|crashed|dip(ped|)|decline|declined|down|sink) or .*?(rise(n|)|fall|gain|gained|fell|rose|loose|lost|grow|raised|raise|hike(d|)|up|collapse|collapsed|crash|crashed|dip(ped|)|decline|declined|down|sink)\\?");

		questionList.add(".*[Ww]hat did .*?([A-Z].*) close at\\?");


		questionList.add(".*[Ww](hat|hich).*?(index|indexes).*"+negVerbs+"\\?");
		questionList.add(".*[Ww](hat|hich).*?(index|indexes).*"+posVerbs+"\\?");

		questionList.add(".*[Ww]hat was\\s?(the)?\\s?(.*)\\?");

		questionList.add(".*[Ww]hat did\\s?(the)?\\s?(.*) do against\\s?(the)?\\s?(.*)\\?");

		questionList.add(".*[Ww](hat|hich)\\s?(company)?\\s?(stock|stocks)\\s?.*"+negVerbs+"\\?");
		questionList.add(".*[Ww](hat|hich)\\s?(company)?\\s?(stock|stocks)\\s?.*"+posVerbs+"\\?");


	}

}
