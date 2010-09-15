import java.util.ArrayList;


public class Questions {

	public ArrayList<String> questionList=new ArrayList<String>();

	public Questions(){
		questionList.add(".*What did .*?([A-Z].*) do\\?");
		questionList.add(".*How *much *did .*?([A-Z].*) (fall|fell|loose|lost)\\?");
		questionList.add(".*How *much *did .*?([A-Z].*) (rise|gain|gained|rose)\\?");
		questionList.add(".*[Dd]id .*?([A-Z].*) (rise|fall|gain|gained|fell|rose|loose|lost) or (rise|fall|gain|gained|fell|rose|loose|lost)\\?");
	}

}
