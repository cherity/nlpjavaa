/**
 * Ashish S Tomar
 * ast2124
 * NLP Assignment # 1
 * Stock market QA System
 * Questions.java
 */


import java.util.ArrayList;


public class Questions {

	public ArrayList<String> questionList=new ArrayList<String>();

	// Verb Patterns -- Got from Wordnet
	public String  negVerbs="(fall|falls|fell|falling|loose|lost|losing|collapse|collapsed|collapsing|crashing|crash|crashed|dip|dips|crashes|collapses|sinks|declines|drops|plunges|dipped|dipping|declining|sinking|dropping|lessen|decline|declined|down|sink|sinked|sank|drop|dropped|low|lower|fallen|below|plunge|plunged|plunging|plummet|plummets|plummeting|plummeted|droping|lose|recede|receding|recedes|wane|waned|waning|wanes|plump|plumped|plumping|plumps|plunk|plunks|plunked|plunking|descend|descends|descended|descending|dive|dove|lowered)";
	public String  posVerbs="(rise|risen|rises|rising|climb|climbs|climbed|climbing|gain|gains|gained|gaining|advanced|advancing|high|higher|advance|advances|rose|grow|grown|grows|growing|raised|raising|raise|raises|hike|hikes|hiking|hiked|up|elevate|elevates|elevated|elevating|jumps|jumped|jumping|jump|ascend|ascends|ascended|ascending|increase|increases|increased|increasing|mount|mounts|mounted|mounting|wax|waxes|waxed|waxing)";
	public String  allVerbs="(rise|risen|rises|rising|climb|climbs|climbed|climbing|gain|gains|gained|gaining|advanced|advancing|high|higher|advance|advances|rose|grow|grown|grows|growing|raised|raising|raise|raises|hike|hikes|hiking|hiked|up|elevate|elevates|elevated|elevating|jumps|jumped|jumping|jump|ascend|ascends|ascended|ascending|increase|increases|increased|increasing|mount|mounts|mounted|mounting|wax|waxes|waxed|waxing|fall|falls|fell|fallen|falling|loose|lost|low|lower|losing|collapse|collapsed|collapsing|crashing|crash|drop|dropped|crashed|dip|dipped|decline|declined|dipping|declining|sinking|dropping|down|sink|sinked|below|plunge|plunged|plunging|plummet|sank|plummets|plummeting|plummeted|dips|crashes|collapses|sinks|declines|drops|plunges|droping|lessen|lose|recede|receding|recedes|wane|waned|waning|wanes|plump|plumped|plumping|plumps|plunk|plunks|plunked|plunking|descend|descends|descended|descending|dive|dove|lowered)";
	public String  extraEle="(went |have |had |has |was |go |gone |is |move |moved |lift |come )?";
	public String  allEVerbs="(rise|risen|rises|rising|climb|climbs|climbed|climbing|gain|gains|gained|gaining|advanced|advancing|high|higher|advance|advances|rose|grow|grown|grows|growing|raised|raising|raise|raises|hike|hikes|hiking|hiked|up|elevate|elevates|elevated|elevating|jumps|jumped|jumping|jump|ascend|ascends|ascended|ascending|increase|increases|increased|increasing|mount|mounts|mounted|mounting|wax|waxes|waxed|waxing|fall|falls|fell|fallen|falling|loose|lost|low|lower|losing|collapse|collapsed|collapsing|crashing|crash|drop|dropped|crashed|dip|dipped|decline|declined|dipping|declining|sinking|dropping|down|sink|sinked|below|plunge|plunged|plunging|plummet|sank|plummets|plummeting|plummeted|dips|crashes|collapses|sinks|declines|drops|plunges|droping|lessen|lose|recede|receding|recedes|wane|waned|waning|wanes|plump|plumped|plumping|plumps|plunk|plunks|plunked|plunking|descend|descends|descended|descending|dive|dove|lowered";

	public String  allExtraEle=allEVerbs+"|closed|close|end|ended|finish|finished|shut|terminate|terminated|stop|stopped|cease|ceased|opened|open|commence|commenced|begin|began|start|started|initiate|initiated|sell|sold|deal|dealt|trade|transact|traded|transacted|bought)";

	/*
	 * All the patterns for Questions
	 * This is a constructor and is called when the class is Instantiated.
	 * It is used to parse the Questions file for matching the Questions with these patterns. 
	 */

	public Questions(){

		questionList.add(".*[Ww]hat did (the )?.*?([A-Z0-9].*) do\\?");


		questionList.add(".*[Hh]ow much did (the )?.*?([A-Z0-9].*?) "+extraEle+negVerbs+"\\s?.*?\\?");
		questionList.add(".*[Hh]ow much did (the )?.*?([A-Z0-9].*?) "+extraEle+posVerbs+"\\s?.*?\\?");


		questionList.add(".*[Dd]id (the )?.*?([A-Z0-9].*?) "+extraEle+allVerbs+" or "+extraEle+allVerbs+"\\?");


		questionList.add(".*([Ww]hat|How much) did (the )?.*?([A-Z0-9].*?) "+extraEle+"(closed|close|end|ended|finish|finished|shut|terminate|terminated|stop|stopped|cease|ceased) at\\?");


		questionList.add(".*([Ww]hat|How much) did (the )?.*?([A-Z0-9].*?) "+extraEle+"(opened|open|commence|commenced|begin|began|start|started|initiate|initiated) at\\?");
		questionList.add(".*([Ww]hat|How much) did (the )?.*?([A-Z0-9].*?) "+extraEle+"(sell|sold|deal|dealt|trade|transact|traded|transacted|bought) at\\?");


		questionList.add(".*[Ww](hat|hich) (index|indexes).*"+negVerbs+"\\?");
		questionList.add(".*[Ww](hat|hich) (index|indexes).*"+posVerbs+"\\?");
		//questionList.add(".*[Ww](hat|hich).*?(index|indexes).*"+posVerbs+"\\?");


		//questionList.add(".*[Ww]hat was\\s?(the)?\\s?(.*)\\?");
		questionList.add(".*[Ww]hat was\\s?(the)?\\s?([Dd]iscount [Rr]ate)\\?");

		questionList.add(".*[Ww]hat did\\s?(the)?\\s?(.*?) do (against|compared to|in comparison to|opposed to|in oppposing to|counter to|contrary to|in contrary to|in counter to|opposing|versus|vs|as opposed to|as compared to|as counter to|as contrary to)\\s?(the)?\\s?(.*?)\\?");
		questionList.add(".*Did\\s?(the)?\\s?(.*?) "+extraEle+allVerbs+" or "+extraEle+allVerbs+" (against|compared to|in comparison to|opposed to|as opposed to|as compared to|as counter to|as contrary to|in oppposing to|counter to|contrary to|in contrary to|in counter to|opposing|versus|vs)\\s?(the)?\\s?(.*?)\\?");

		questionList.add(".*[Ww](hat|hich)\\s?(company)?\\s?(stock|stocks)\\s?.*"+negVerbs+"\\?");
		questionList.add(".*[Ww](hat|hich)\\s?(company)?\\s?(stock|stocks)\\s?.*"+posVerbs+"\\?");

		questionList.add(".*");



	}

}
