import java.util.ArrayList;


public class Questions {

	public ArrayList<String> questionList=new ArrayList<String>();

	public Questions(){
		questionList.add(".*[Ww]hat did .*?([A-Z].*) do\\?");
		questionList.add(".*[Hh]ow much *did .*?([A-Z].*).* (fall|fell|loose|lost|collapse|collapsed|crash|crashed|dip|decline|declined|down|sink)\\?");

		questionList.add(".*[Hh]ow much *did .*?([A-Z].*).* (rise|gain|gained|rose|grow|raised|raise|hike|up)\\?");
		questionList.add(".*[Dd]id .*?([A-Z].*).*? (rise|fall|gain|gained|fell|rose|loose|lost|grow|raised|raise|hike|up|collapse|collapsed|crash|crashed|dip|decline|declined|down|sink) or .*?(rise|fall|gain|gained|fell|rose|loose|lost|grow|raised|raise|hike|up|collapse|collapsed|crash|crashed|dip|decline|declined|down|sink)\\?");
	}

}
