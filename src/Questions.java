import java.util.ArrayList;


public class Questions {

	public ArrayList<String> questionList=new ArrayList<String>();

	public Questions(){
		questionList.add(".*What did (.*) do\\?");
		questionList.add(".*How *much *did *(.*) (rise|fall|gain|gained|fell|rose)\\?");
		questionList.add(".*[Dd]id *(.*) (rise|fall|gain|gained|fell|rose) or (rise|fall|gain|gained|fell|rose)\\?");
	}

}
