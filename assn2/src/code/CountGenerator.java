package code;

import java.util.ArrayList;
import java.util.Hashtable;

public class CountGenerator {

	public static Hashtable<String, Integer> wordList= new Hashtable<String, Integer>();

	public static Hashtable<String, ArrayList<Integer>> docFrequency= new Hashtable<String, ArrayList<Integer>>();

	public static Hashtable<String, Integer> poswordList= new Hashtable<String, Integer>();
	public static Hashtable<String, Integer> negwordList= new Hashtable<String, Integer>();
	public static ArrayList<Document> docList= new ArrayList<Document>();


	public static String[] stopwords= {"a","able","about","across","after","all","almost","also","am","among","an","and","any","are","as","at","be","because","been","but","by","can","cannot","could","dear","did","do","does","either","else","ever","every","for","from","get","got","had","has","have","he","her","hers","him","his","how","however","i","if","in","into","is","it","its","just","least","let","like","likely","may","me","might","most","must","my","neither","no","nor","not","of","off","often","on","only","or","other","our","own","rather","said","say","says","she","should","since","so","some","than","that","the","their","them","then","there","these","they","this","tis","to","too","twas","us","wants","was","we","were","what","when","where","which","while","who","whom","why","will","with","would","yet","you","your"};
	public static String[] poswords= {"captivating","wise","perfection","Absolutely","compelling","cogent","convince","amazing","payoff","tremendous","revealing","brilliance","genuinely","gracefully","importance","intrinsic","masterly","involved","memorable","simplicity","unfold","unfolds","unmatched","outdoes","rarely","successfully","successful","accomplished","great","imagination","exhibited","imagined","intriguing","masterpiece","masterpieces","pleased","monumental","inspiring","intelligent","masterful","smoothly","different","Abundant","Acclaimed","Accomplishment","Achievement","Acumen","Admire","Adorable","Adored","Affirmative","Affluent","Amaze","Amity","Appreciation","Approve","Artistic","Astonish","Astounding","Astute","surprises","Attractive","good","entertaining","entertained","entertain","special","Authentic","engaging","interesting","Beautiful","Benefit","Blessed","Bliss","Bloom","Bountiful","Bounty","Brave","Bright","Brilliant","Bubbly","Calm","Celebrate","Charitable","Charming","Cheer","Cherish","Clarity","Classy","Clean","Clever","Closeness","Commend","Companionship","Complete","Comradeship","Confident","Conviction","Copious","Core","Coupled","Courageous","Creative","Cultivate","Curious","Cute","Dazzling","Delight","Distinguished","Divine","Earnest","Ecstasy","Effervescent","Efficient","Effortless","Electrifying","Elegance","Embrace","Encompassing","Encourage","Endorse","Energized","Energy","Enjoy","Enjoyed","Enormously","Enthuse","Enthusiastic","Essence","Established","Esteem","Esteemed","Excited","Exciting","Exhilarating","Exquisite","Exultant","Faith","Famous","Feat","Flourish","Fortunate","Fortune","Freedom","Fresh","Funny","authenticity","grit","gritty","improvise","improvisational","libbing","satisfying","surprisingly","unique","uniquely","unnerving","Generous","Genius","Genuine","accurately","accurate","mysterious","suprisingly","best","classic","deserved","deservedly","glib","glibness","honors","profound","realistic","justice","poignant","poignancy","reminiscent","Glad","Glow","Gorgeous","Grace","Graceful","Gratitude","Handsome","Harmony","Healthy","Hearty","Heavenly","Helpful","Holy","Honest","Honored","affirm","Ideal","Imaginative","Increase","Incredible","Independent","Ingenious","Innate","Innovate","Inspire","Instantaneous","Instinct","Intellectual","Intelligence","Intuitive","Inventive","Jovial","Jubilation","Keen","Key","Knowledge","Laugh","Leader","Learn","Legendary","Light","Lively","merit","merits","stunning","magnificently","neat","tender","topped","nice","nicely","noteworthy","Loveliness","Lucidity","Lucrative","Luminous","Maintain","Marvelous","Master","Meaningful","Meditate","Mend","Metamorphosis","Mind-Blowing","Miracle","Mission","Modify","Motivate","Moving","Natural","Nature","Nourish","Nourished","Novel","Nurture","Nutritious","Open","Openhanded","Optimistic","Paradise","Peace","Perfect","Phenomenon","Pleasure","Plenteous","Plentiful","Plenty","Plethora","Poise","Polish","Popular","Positive","Powerful","Prepared","Pretty","Principle","Productive","Project","Prominent","Prosperous","Protect","Proud","Quest","Ready","Recognized","Refinement","Refresh","Rejoice","Rejuvenate","Relax","Reliance","Rely","Remarkable","Renew","Renowned","Replenished","Resolution","Resound","Resources","Respect","Restore","Revered","Revolutionize","Rewarding","Robust","Rousing","Safe","Secure","Sensation","Serenity","Shift","Shine","Silence","Simple","Sincerity","Smart","Smooth","Solution","Sparkling","Spirit","Spirited","Spiritual","Splendid","Spontaneous","Stillness","Stir","Stirring","Strong","Style","Success","Sunny","Support","Surprise","Surprised","Sustain","Synchronized","Team","Thankful","Therapeutic","Thorough","Thrilled","Thrive","Tied","Today","Tranquil","Transform","Triumph","Unity","Unusual","Unwavering","Upbeat","Valued","Vary","Venerated","Venture","Vibrant","Victory","Vigorous","Vision","Visualize","Vital","Vivacious","Voyage","Welcome","Well","Whole","Wholesome","Wonder","Wonderful","Wondrous","Yes"};
	public static String[] negwords= {"mishandle","pedestrian","clich","average","misses","problem","rant","contrived","sink","painful","silly","stupidity","lamest","sorry","abandoned ","abused ","accused ","addicted ","afraid ","aggravated ","aggressive ","alone ","angry ","anguish ","annoyed ","futile","stereotypes","squirming","unnoticeable","unoriginal","vile","anxious ","apprehensive ","insipid","fail","melodramatic","missing","overkill","spoof","spoofing","weary","embarrassing","forgetable","regretable","vacuous","unnecessary","sardonic","sophomoric","argumentative ","artificial ","ashamed ","assaulted ","risk ","atrocious ","attacked ","avoided ","awful ","awkward ","bad ","badgered ","baffled ","banned ","barren ","belittled ","berated ","betrayed ","bitched ","bitter ","bizzare ","blacklisted ","blackmailed ","blamed ","bleak ","blown ","blur ","bored ","boring ","bossed-around ","bothered ","bothersome ","bounded ","boxed-in ","broken ","bruised ","brushed-off ","bugged ","bullied ","bummed ","burdened ","burdensome ","burned ","burned-out ","caged ","careless ","chaotic ","chased ","cheated ","chicken ","claustrophobic ","clingy ","closed ","clueless ","clumsy ","coaxed ","codependent ","coerced ","cold ","cold-hearted ","combative ","commanded ","competitive ","compulsive ","conceited ","concerned ","condescended ","confined ","conflicted ","confronted ","confused ","conned ","consumed ","contemplative ","contempt ","contentious ","controlled ","convicted ","cornered ","corralled ","cowardly ","crabby ","cramped ","cranky ","crap ","crappy ","crazy ","creeped ","creepy ","critical ","criticized ","cross ","crowded ","cruddy ","repulsive","unrehearsed","crummy ","crushed ","cut-down ","cut-off ","cynical","damaged ","damned ","dangerous ","dazed ","deceived ","defamed ","defeated ","defective ","defenseless ","defensive ","defiant ","deficient ","deflated ","degraded ","dehumanized ","dejected ","delicate ","deluded ","demanding ","demeaned ","demented ","demoralized ","demotivated ","dependent ","depleted ","depraved ","depressed ","deprived ","melodramatics","inconclusive","worst","punishment ","desolate ","despair ","despairing ","desperate ","despicable ","despised ","destroyed ","destructive ","detached ","detest ","detestable ","detested ","devalued ","devastated ","deviant ","devoid ","diagnosed ","dictated ","difficult ","directionless ","dirty ","disabled ","disagreeable ","disappointed ","disappointing ","disapproved ","disbelieved ","discardable ","discarded ","disconnected ","discontent ","discouraged ","discriminated ","disdain ","disdainful ","disempowered ","disenchanted ","disgraced ","disgruntled ","disgust ","disgusted ","disheartened ","dishonest ","dishonorable ","disillusioned ","dislike ","disliked ","dismal ","dismayed ","disorganized ","disoriented ","disowned ","displeased ","disposable ","disregarded ","disrespected ","dissatisfied ","distant ","distracted ","distraught ","distressed ","disturbed ","dizzy ","dominated ","doomed ","double-crossed ","doubted ","doubtful ","down ","downhearted ","downtrodden ","drained ","dramatic ","dread ","dreadful ","dreary ","dropped ","drunk ","dry ","dumb ","dumped ","duped","edgy ","egocentric ","egotistic ","egotistical ","elusive ","emancipated ","emasculated ","embarrassed ","emotional ","emotionless ","bankrupt ","empty ","encumbered ","endangered ","enraged ","enslaved ","entangled ","evaded ","evasive ","evicted ","excessive ","excluded ","exhausted ","exploited ","exposed ","failful","fake ","fearful ","fed ","flawed ","forced ","forgetful ","forgettable ","forgotten ","fragile ","freaked ","frightened ","frigid ","frustrated ","furious","gloomy ","glum ","gothic ","grey ","grief ","grim ","gross ","grossed-out ","grotesque ","grouchy ","grounded ","grumpy ","guilt-tripped ","guilty ","harassed ","hard ","hard-hearted ","harmed ","hassled ","hate ","hateful ","hatred ","haunted ","heartbroken ","heartless ","heavy-hearted ","helpless ","hesitant ","hideous ","hindered ","hopeless ","horrible ","horrified ","horror ","hostile ","hot-tempered ","humiliated ","hung ","hurried ","hysterical","idiotic ","ignorant ","ignored ","ill ","ill-tempered ","imbalanced ","imposed-upon ","impotent ","imprisoned ","impulsive ","dumps ","inactive ","inadequate ","incapable ","incommunicative ","incompetent ","incompatible ","incomplete ","incorrect ","indecisive ","indifferent ","indoctrinated ","inebriated ","ineffective ","inefficient ","inferior ","infuriated ","inhibited ","inhumane ","injured ","injusticed ","insane ","insecure ","insignificant ","insincere ","insufficient ","insulted ","intense ","interrogated ","interrupted ","intimidated ","intoxicated ","invalidated ","invisible ","irrational ","irritable ","irritated ","isolated","jaded","jealous ","jerked ","joyless ","labeled ","laughable ","lazy ","limited ","lonely ","lonesome ","lost ","lousy ","loveless ","low","mad ","manipulated ","masochistic ","messed ","messy ","miffed ","miserable ","misled ","mistaken ","mistreated ","mistrusted ","misunderstood ","mixed-up ","mocked ","molested ","moody","nagged ","needy ","negative ","nervous ","neurotic ","nonconforming ","numb ","nuts ","nutty","objectified ","obligated ","obsessed ","obsessive ","obstructed ","odd ","offended ","opposed ","oppressed ","over-controlled ","over-protected ","overwhelmed","panic ","paranoid ","passive ","pathetic ","pessimistic ","petrified ","phony ","pissed ","plain ","pooped ","poor ","powerless ","pre-judged ","preached","preoccupied ","predjudiced ","pressured ","prosecuted ","provoked ","psychopathic ","psychotic ","punished ","pushed ","puzzled ","quarrelsome ","queer ","questioned ","rage ","raped ","rattled ","regret ","rejected ","resented ","resentful ","responsible ","retarded ","revengeful ","ridiculed ","ridiculous ","robbed ","rotten ","sad ","sadistic ","sarcastic ","scared ","scarred ","screwed ","self-centered ","self-conscious ","self-destructive ","self-hatred ","selfish ","sensitive ","shy ","singled-out ","slow ","smothered ","snapped","spiteful ","stereotyped ","strange ","stressed ","stretched ","stuck ","stupid ","submissive ","suffering ","suffocated ","suicidal ","superficial ","suppressed ","suspicious"};

	public static ArrayList<String> stopWords=new ArrayList<String>();
	public static ArrayList<String> posWords=new ArrayList<String>();
	public static ArrayList<String> negWords=new ArrayList<String>();
	public static double wordCnt=0, wordFromPos=0,wordFromNeg=0,docCount=0;


	public CountGenerator(){
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
	}





	public static void getCount(String match, int cntt, int star) {

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

			if(bowWord.equals("not")||bowWord.equals("no"))
			{
				d.notWords++;
			}
			if(posWords.contains(bowWord.trim().toLowerCase())){
				d.posWords++;
				addTermPos(bowWord,d);
			}
			else 				if(negWords.contains(bowWord.trim().toLowerCase())){
				d.negWords++;
				addTermNeg(bowWord,d);
			}


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





	private static void addTermNeg(String bowWord, Document d) {
		// TODO Auto-generated method stub
		if(d.negtermFrequency.containsKey(bowWord)){

			Integer count = d.negtermFrequency.get(bowWord);
			count++;
			d.negtermFrequency.remove(bowWord);
			d.negtermFrequency.put(bowWord, count);


		}
		else{
			d.negtermFrequency.put(bowWord, 1);
		}
	}




	private static void addTermPos(String bowWord, Document d) {
		// TODO Auto-generated method stub
		if(d.postermFrequency.containsKey(bowWord)){

			Integer count = d.postermFrequency.get(bowWord);
			count++;
			d.postermFrequency.remove(bowWord);
			d.postermFrequency.put(bowWord, count);


		}
		else{
			d.postermFrequency.put(bowWord, 1);
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








}
