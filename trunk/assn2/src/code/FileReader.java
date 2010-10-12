package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader {

	public static Hashtable<String, Integer> wordList= new Hashtable<String, Integer>();

	public static Hashtable<String, ArrayList<Integer>> docFrequency= new Hashtable<String, ArrayList<Integer>>();

	public static Hashtable<String, Integer> poswordList= new Hashtable<String, Integer>();
	public static Hashtable<String, Integer> negwordList= new Hashtable<String, Integer>();
	public static ArrayList<Document> docList= new ArrayList<Document>();
	public static String[] stopwords= {"a","able","about","across","after","all","almost","also","am","among","an","and","any","are","as","at","be","because","been","but","by","can","cannot","could","dear","did","do","does","either","else","ever","every","for","from","get","got","had","has","have","he","her","hers","him","his","how","however","i","if","in","into","is","it","its","just","least","let","like","likely","may","me","might","most","must","my","neither","no","nor","not","of","off","often","on","only","or","other","our","own","rather","said","say","says","she","should","since","so","some","than","that","the","their","them","then","there","these","they","this","tis","to","too","twas","us","wants","was","we","were","what","when","where","which","while","who","whom","why","will","with","would","yet","you","your"};

	public static String[] poswords= {"Absolutely","Abundant","Accept","Acclaimed","Accomplishment","Achievement","Action","Active","Activist","Acumen","Adjust","Admire","Adopt","Adorable","Adored","Adventure","Affirmative","Affluent","Agree","Airy","Alive","Alliance","Alter","Amaze","Amity","Animated","Answer","Appreciation","Approve","Aptitude","Artistic","Assertive","Astonish","Astounding","Astute","Attractive","Authentic","Basic","Beaming","Beautiful","Believe","Benefactor","Benefit","Bighearted","Blessed","Bliss","Bloom","Bountiful","Bounty","Brave","Bright","Brilliant","Bubbly","Bunch","Burgeon","Calm","Celebrate","Certain","Change","Character","Charitable","Charming","Cheer","Cherish","Clarity","Classy","Clean","Clever","Closeness","Commend","Companionship","Complete","Comradeship","Confident","Connect","Connected","Constant","Content","Conviction","Copious","Core","Coupled","Courageous","Creative","Cuddle","Cultivate","Cure","Curious","Cute","Dazzling","Delight","Direct","Discover","Distinguished","Divine","Donate","Each Day","Eager","Earnest","Easy","Ecstasy","Effervescent","Efficient","Effortless","Electrifying","Elegance","Embrace","Encompassing","Encourage","Endorse","Energized","Energy","Enjoy","Enormously","Enthuse","Enthusiastic","Entirely","Essence","Established","Esteem","Esteemed","Everyday","Excited","Exciting","Exhilarating","Expand","Explore","Express","Exquisite","Exultant","Faith","Familiar","Family","Famous","Feat","Fit","Flourish","For the Highest Good","Fortunate","Fortune","Freedom","Fresh","Friendship","Full","Funny","Gather","Generous","Genius","Genuine","Give","Glad","Glow","Gorgeous","Grace","Graceful","Gratitude","Green","Grin","Group","Grow","Handsome","Happy","Harmony","Healed","Healing","Healthful","Healthy","Heart","Hearty","Heavenly","Helpful","Here","Here","Hold","Holy","Honest","Honored","Hug","I affirm","I allow","I am willing","I am.","I Can","I choose","I create","I follow","I know","I know without a doubt","I make","I realize","I take action","I trust","Idea","Ideal","Imaginative","In Every Way","In this moment","Increase","Incredible","Independent","Ingenious","Innate","Innovate","Inspire","Instantaneous","Instinct","Intellectual","Intelligence","Intuitive","Inventive","Joined","Jovial","Joy","Jubilation","Keen","Key","Kind","Kiss","Knowledge","Laugh","Leader","Learn","Legendary","Let Go","Light","Lively","Love","Loveliness","Lucidity","Lucrative","Luminous","Maintain","Marvelous","Master","Meaningful","Meditate","Mend","Metamorphosis","Mind-Blowing","Miracle","Mission","Modify","Motivate","Moving","Natural","Nature","Nourish","Nourished","Novel","Now","Nurture","Nutritious","One","Open","Openhanded","Optimistic","Paradise","Party","Peace","Perfect","Phenomenon","Pleasure","Plenteous","Plentiful","Plenty","Plethora","Poise","Polish","Popular","Positive","Powerful","Prepared","Pretty","Principle","Productive","Project","Prominent","Prosperous","Protect","Proud","Purpose","Quest","Quick","Quiet","Ready","Recognized","Refinement","Refresh","Rejoice","Rejuvenate","Relax","Reliance","Rely","Remarkable","Renew","Renowned","Replenished","Resolution","Resound","Resources","Respect","Restore","Revered","Revolutionize","Rewarding","Rich","Right Now","Robust","Rousing","Safe","Secure","See","Sensation","Serenity","Shift","Shine","Shown","Silence","Simple","Sincerity","Smart","Smile","Smooth","Solution","Soul","Sparkling","Spirit","Spirited","Spiritual","Splendid","Spontaneous","Stillness","Stir","Stirring","Strong","Style","Success","Sunny","Support","Sure","Surprise","Sustain","Synchronized","Team","Thankful","Therapeutic","Thorough","Thrilled","Thrive","Tied","Today","Today","Together","Tranquil","Transform","Triumph","Trust","Truth","Unity","Unusual","Unwavering","Upbeat","Valued","Vary","Venerated","Venture","Vibrant","Victory","Vigorous","Vision","Visualize","Vital","Vivacious","Voyage","Wealthy","Welcome","Well","Whole","Wholesome","Willing","With Everyone","Wonder","Wonderful","Wondrous","Yes"};
	public static String[] negwords= {"abandoned ","abused ","accused ","addicted ","afraid ","aggravated ","aggressive ","alone ","angry ","anguish ","annoyed ","anxious ","apprehensive ","argumentative ","artificial ","ashamed ","assaulted ","at a loss ","at risk ","atrocious ","attacked ","avoided ","awful ","awkward ","bad ","badgered ","baffled ","banned ","barren ","beat ","beaten down ","belittled ","berated ","betrayed ","bitched at ","bitter ","bizzare ","blacklisted ","blackmailed ","blamed ","bleak ","blown away ","blur ","bored ","boring ","bossed-around ","bothered ","bothersome ","bounded ","boxed-in ","broken ","bruised ","brushed-off ","bugged ","bullied ","bummed ","bummed out ","burdened ","burdensome ","burned ","burned-out ","caged in ","careless ","chaotic ","chased ","cheated ","cheated on ","chicken ","claustrophobic ","clingy ","closed ","clueless ","clumsy ","coaxed ","codependent ","coerced ","cold ","cold-hearted ","combative ","commanded ","compared ","competitive ","compulsive ","conceited ","concerned ","condescended to ","confined ","conflicted ","confronted ","confused ","conned ","consumed ","contemplative ","contempt ","contentious ","controlled ","convicted ","cornered ","corralled ","cowardly ","crabby ","cramped ","cranky ","crap ","crappy ","crazy ","creeped out ","creepy ","critical ","criticized ","cross ","crowded ","cruddy ","crummy ","crushed ","cut-down ","cut-off ","cynical","damaged ","damned ","dangerous ","dark ","dazed ","dead ","deceived ","deep ","defamed ","defeated ","defective ","defenseless ","defensive ","defiant ","deficient ","deflated ","degraded ","dehumanized ","dejected ","delicate ","deluded ","demanding ","demeaned ","demented ","demoralized ","demotivated ","dependent ","depleted ","depraved ","depressed ","deprived ","deserted ","deserving of pain/punishment ","desolate ","despair ","despairing ","desperate ","despicable ","despised ","destroyed ","destructive ","detached ","detest ","detestable ","detested ","devalued ","devastated ","deviant ","devoid ","diagnosed ","dictated to ","different ","difficult ","directionless ","dirty ","disabled ","disagreeable ","disappointed ","disappointing ","disapproved of ","disbelieved ","discardable ","discarded ","disconnected ","discontent ","discouraged ","discriminated ","disdain ","disdainful ","disempowered ","disenchanted ","disgraced ","disgruntled ","disgust ","disgusted ","disheartened ","dishonest ","dishonorable ","disillusioned ","dislike ","disliked ","dismal ","dismayed ","disorganized ","disoriented ","disowned ","displeased ","disposable ","disregarded ","disrespected ","dissatisfied ","distant ","distracted ","distraught ","distressed ","disturbed ","dizzy ","dominated ","doomed ","double-crossed ","doubted ","doubtful ","down ","down and out ","down in the dumps ","downhearted ","downtrodden ","drained ","dramatic ","dread ","dreadful ","dreary ","dropped ","drunk ","dry ","dumb ","dumped ","dumped on ","duped","edgy ","egocentric ","egotistic ","egotistical ","elusive ","emancipated ","emasculated ","embarrassed ","emotional ","emotionless ","emotionally bankrupt ","empty ","encumbered ","endangered ","enraged ","enslaved ","entangled ","evaded ","evasive ","evicted ","excessive ","excluded ","exhausted ","exploited ","exposed ","failful","fake ","false ","fear ","fearful ","fed up ","flawed ","forced ","forgetful ","forgettable ","forgotten ","fragile ","freaked out ","frightened ","frigid ","frustrated ","furious","gloomy ","glum ","gothic ","grey ","grief ","grim ","gross ","grossed-out ","grotesque ","grouchy ","grounded ","grumpy ","guilt-tripped ","guilty ","harassed ","hard ","hard-hearted ","harmed ","hassled ","hate ","hateful ","hatred ","haunted ","heartbroken ","heartless ","heavy-hearted ","helpless ","hesitant ","hideous ","hindered ","hopeless ","horrible ","horrified ","horror ","hostile ","hot-tempered ","humiliated ","hung up ","hung over ","hurried ","hurt ","hysterical","idiotic ","ignorant ","ignored ","ill ","ill-tempered ","imbalanced ","imposed-upon ","impotent ","imprisoned ","impulsive ","in the dumps ","in the way ","inactive ","inadequate ","incapable ","incommunicative ","incompetent ","incompatible ","incomplete ","incorrect ","indecisive ","indifferent ","indoctrinated ","inebriated ","ineffective ","inefficient ","inferior ","infuriated ","inhibited ","inhumane ","injured ","injusticed ","insane ","insecure ","insignificant ","insincere ","insufficient ","insulted ","intense ","interrogated ","interrupted ","intimidated ","intoxicated ","invalidated ","invisible ","irrational ","irritable ","irritated ","isolated","jaded","jealous ","jerked around ","joyless ","judged","kept apart","kept away ","kept in","kept out","kept quiet","labeled ","laughable ","laughed at ","lazy ","leaned on ","lectured to ","left out ","let down ","lied about ","lied to ","limited ","little ","lonely ","lonesome ","longing ","lost ","lousy ","loveless ","low","mad ","made fun of ","man handled ","manipulated ","masochistic ","messed with ","messed up ","messy ","miffed ","miserable ","misled ","mistaken ","mistreated ","mistrusted ","misunderstood ","mixed-up ","mocked ","molested ","moody","nagged ","needy ","negative ","nervous ","neurotic ","nonconforming ","numb ","nuts ","nutty","objectified ","obligated ","obsessed ","obsessive ","obstructed ","odd ","offended ","on display ","opposed ","oppressed ","out of place ","out of touch ","over-controlled ","over-protected ","overwhelmed","pain ","panic ","paranoid ","passive ","pathetic ","pessimistic ","petrified ","phony ","picked on ","pissed ","pissed off ","plain ","played with ","pooped ","poor ","powerless ","pre-judged ","preached to ","preoccupied ","predjudiced ","pressured ","prosecuted ","provoked ","psychopathic ","psychotic ","pulled apart ","pulled back ","punished ","pushed ","pushed away ","put down ","puzzled ","quarrelsome ","queer ","questioned ","quiet ","rage ","raped ","rattled ","regret ","rejected ","resented ","resentful ","responsible ","retarded ","revengeful ","ridiculed ","ridiculous ","robbed ","rotten ","sad ","sadistic ","sarcastic ","scared ","scarred ","screwed ","screwed over ","screwed up ","self-centered ","self-conscious ","self-destructive ","self-hatred ","selfish ","sensitive ","shouted at ","shy ","singled-out ","slow ","small ","smothered ","snapped at ","spiteful ","stereotyped ","strange ","stressed ","stretched ","stuck ","stupid ","submissive ","suffering ","suffocated ","suicidal ","superficial ","suppressed ","suspicious"};

	public static ArrayList<String> stopWords=new ArrayList<String>();
	public static ArrayList<String> posWords=new ArrayList<String>();
	public static ArrayList<String> negWords=new ArrayList<String>();

	public static double wordCnt=0, wordFromPos=0,wordFromNeg=0,docCount=0;


	public static FileOutputStream fstream2 ;
	public static DataOutputStream in2 ;
	public static BufferedWriter br2;

	public static FileOutputStream fstream3 ;
	public static DataOutputStream in3 ;
	public static BufferedWriter br3;


	public static void main(String args[]){

		try{

			for(String s :stopwords){
				//System.out.println(s);

				stopWords.add(s);

			}


			for(String s :poswords){
				//System.out.println(s);

				posWords.add(s.toLowerCase().trim());

			}


			for(String s :negwords){
				//System.out.println(s);

				negWords.add(s.toLowerCase().trim());

			}

			FileInputStream fstream = new FileInputStream(args[1]);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));


			fstream2 = new FileOutputStream("output.txt");
			in2 = new DataOutputStream(fstream2);
			br2 = new BufferedWriter(new OutputStreamWriter(in2));





			fstream3 = new FileOutputStream("outputFile10.arff");
			in3 = new DataOutputStream(fstream3);
			br3 = new BufferedWriter(new OutputStreamWriter(in3));


			String strLine;
			int cnt =0,negCnt=0,posCnt=0;
			Pattern pattern  = Pattern.compile(".*<star>(.*)</star><review>(.*)</review>.*");
			Matcher matcher;

			while ((strLine = br.readLine()) != null)   {

				matcher = pattern.matcher(strLine);
				while (matcher.find()) {
					cnt++;
					String star = matcher.group(1).trim();
					int starr=Integer.parseInt(star);
					if(starr<=2){
						negCnt++;
					}
					else{
						posCnt++;
					}
					String match = matcher.group(2).trim();
					getCount(match,cnt,starr);
					//System.out.println (strLine);
					//System.out.println (cnt +" " +star+" "+match);
				}

			}

			printHashTable(wordList);
			br2.newLine();
			br2.newLine();
			br2.newLine();
			br2.newLine();

			printHashTable(poswordList);
			br2.newLine();
			br2.newLine();
			br2.newLine();
			br2.newLine();

			printHashTable(negwordList);


			System.out.println("Total Docs- "+cnt);
			docCount=cnt;
			System.out.println("Avg doc length- "+wordCnt/cnt);
			logln();


			System.out.println("Total neg Docs- "+negCnt);
			System.out.println("Avg neg doc length- "+wordFromNeg/negCnt);
			logln();


			System.out.println("Total pos Docs- "+posCnt);
			System.out.println("Avg pos doc length- "+wordFromPos/posCnt);
			logln();

			printDocList();



			br2.flush();
			in2.close();
			br3.flush();
			in3.close();
			in.close();

		}catch (Exception e){

			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();

		}

	}




	private static void printDocList() throws IOException {
		// TODO Auto-generated method stub

		br3.write("@RELATION moviestraining");
		br3.newLine();
		br3.newLine();
		br3.newLine();

		int ccnt=0;
		/*
		Enumeration<String> e = docFrequency.keys();
		while( e. hasMoreElements() ){
			ccnt++;

			if(ccnt==15000)
				break;

			String key = (String)e.nextElement() ;

			br3.write("@ATTRIBUTE "+key+" NUMERIC");
			br3.newLine();


		}

		br3.write("@ATTRIBUTE doclength NUMERIC");
		br3.newLine();
		br3.write("@ATTRIBUTE classFinal {1,2,3,4}");
		br3.newLine();
		br3.write("@ATTRIBUTE testFinal {1,2,3,4}");
		br3.newLine();

		br3.newLine();
		br3.newLine();
		br3.write("@DATA");
		br3.newLine();
		br3.flush();


		Enumeration<String> ee;
		 */





		br3.write("@ATTRIBUTE doclength NUMERIC");
		br3.newLine();

		br3.write("@ATTRIBUTE posword NUMERIC");
		br3.newLine();

		br3.write("@ATTRIBUTE negword NUMERIC");
		br3.newLine();
		br3.write("@ATTRIBUTE classFinal {1,2,3,4}");
		br3.newLine();

		br3.newLine();
		br3.newLine();
		br3.write("@DATA");
		br3.newLine();
		br3.flush();


		for(Document d : docList){
			/*
			ee= docFrequency.keys();
			ccnt=0;

			while( ee. hasMoreElements() ){
				String key = (String)ee.nextElement() ;

				ccnt++;

				if(ccnt==15000)
					break;

				if(d.termFrequency.containsKey(key)){

					int termCount=d.termFrequency.get(key);
					double tf=termCount/d.countWords;

					ArrayList<Integer> listt=docFrequency.get(key);

					double df=Math.log(docCount/listt.size());
					double tfidf=tf*df;

					br3.write(tfidf+",");
				}
				else{
					br3.write(0+",");
				}




			}
			 */


			//System.out.println("finished");
			br3.write(d.countWords+",");
			br3.write(d.posWords/d.countWords+",");
			br3.write(d.negWords/d.countWords+",");
			String sstar=""+d.star;
			br3.write(sstar);

			br3.newLine();
			br3.flush();

		}


	}




	private static void printHashTable(Hashtable<String, Integer> poswordList2) throws IOException {

		//System.out.println("here");
		Hashtable<String, String> wordSortedList= new Hashtable<String, String>();
		Enumeration<String> e = poswordList2.keys();
		while( e. hasMoreElements() ){
			String key = (String)e.nextElement() ;
			Integer value=poswordList2.get(key);

			String mainkey = value+key;
			wordSortedList.put(mainkey, key);


		}
		Vector<String> v = new Vector<String>(wordSortedList.keySet());
		Collections.sort(v);
		Iterator<String> it = wordSortedList.keySet().iterator();

		it = v.iterator();
		while (it.hasNext()) {
			String element =  (String)it.next();
			br2.write (element + " " + (String)wordSortedList.get(element));
			br2.newLine();
		}



	}


	private static void getCount(String match, int cntt, int star) {

		String[] bow=match.split(" ");

		Document d= new Document();
		d.countWords=bow.length;
		d.star=star;

		docList.add(d);

		for(String bowWord:bow){
			bowWord=bowWord.replaceAll("'", "");
			bowWord=bowWord.replaceAll("", "");
			bowWord=bowWord.replaceAll("%", "");
			//",",box,","empty"
			if(bowWord.equals("")||bowWord.equals("\"")||bowWord.equals(",")||bowWord.length()<=2||stopWords.contains(bowWord))
			{
				continue;
			}

			if(posWords.contains(bowWord.trim().toLowerCase())){
				d.posWords++;
			}
			else 				if(negWords.contains(bowWord.trim().toLowerCase())){
				d.negWords++;
			}

			//if(bowWord.contains("nobody")){
			//	logln(bowWord +"  "+cntt);
			//}

			addToWordList(bowWord,wordList);
			addToDocFreqTracker(bowWord,cntt);
			wordCnt++;
			addTerm(bowWord,d);

			if(star<=2){
				addToWordList(bowWord,negwordList);
				wordFromNeg++;
			}
			else{
				addToWordList(bowWord,poswordList);
				wordFromPos++;
			}


		}

	}



	private static void addToDocFreqTracker(String bowWord, int cntt) {
		if(docFrequency.containsKey(bowWord)){

			ArrayList<Integer> list = docFrequency.get(bowWord);
			if(list.contains(cntt)){

			}
			else{
				list.add(cntt);
			}

			docFrequency.remove(bowWord);
			docFrequency.put(bowWord, list);


		}
		else{
			ArrayList<Integer> list = new 	ArrayList<Integer> ();
			list.add(cntt);
			docFrequency.put(bowWord, list);

		}

	}


	private static void addTerm(String bowWord, Document d) {

		if(d.termFrequency.containsKey(bowWord)){

			Integer count = d.termFrequency.get(bowWord);
			count++;
			d.termFrequency.remove(bowWord);
			d.termFrequency.put(bowWord, count);


		}
		else{
			d.termFrequency.put(bowWord, 1);
		}

	}


	private static void addToWordList(String bowWord, 	Hashtable<String, Integer> wordList2) {

		if(wordList2.containsKey(bowWord)){

			Integer count = wordList2.get(bowWord);
			count++;
			wordList2.remove(bowWord);
			wordList2.put(bowWord, count);


		}
		else{
			wordList2.put(bowWord, 1);
		}

	}





	private static void logln(String string) {
		System.out.println(string);
	}

	private static void logln(int cnt) {
		System.out.println(cnt);
	}

	private static void logln(double cnt) {
		System.out.println(cnt);
	}

	private static void logln() {
		System.out.println();
	}



	private static void log(String string) {
		System.out.print(string);
	}

	private static void log(int cnt) {
		System.out.print(cnt);
	}

	private static void log(double cnt) {
		System.out.print(cnt);
	}

	private static void log() {
		System.out.print("");
	}


}
