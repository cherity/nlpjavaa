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

	public static int FEATcnt =3001;
	public static String outFile="outputArff"+FEATcnt+"_10_newbinary_w_bigram.arff";


	public static String[] oldposwordss= {"captivating","wise","perfection","Absolutely","compelling","cogent","convince","amazing","payoff","tremendous","revealing","brilliance","genuinely","gracefully","importance","intrinsic","masterly","involved","memorable","simplicity","unfold","unfolds","unmatched","outdoes","rarely","successfully","successful","accomplished","great","imagination","exhibited","imagined","intriguing","masterpiece","masterpieces","pleased","monumental","inspiring","intelligent","masterful","smoothly","different","Abundant","Acclaimed","Accomplishment","Achievement","Acumen","Admire","Adorable","Adored","Affirmative","Affluent","Amaze","Amity","Appreciation","Approve","Artistic","Astonish","Astounding","Astute","surprises","Attractive","good","entertaining","entertained","entertain","special","Authentic","engaging","interesting","Beautiful","Benefit","Blessed","Bliss","Bloom","Bountiful","Bounty","Brave","Bright","Brilliant","Bubbly","Calm","Celebrate","Charitable","Charming","Cheer","Cherish","Clarity","Classy","Clean","Clever","Closeness","Commend","Companionship","Complete","Comradeship","Confident","Conviction","Copious","Core","Coupled","Courageous","Creative","Cultivate","Curious","Cute","Dazzling","Delight","Distinguished","Divine","Earnest","Ecstasy","Effervescent","Efficient","Effortless","Electrifying","Elegance","Embrace","Encompassing","Encourage","Endorse","Energized","Energy","Enjoy","Enjoyed","Enormously","Enthuse","Enthusiastic","Essence","Established","Esteem","Esteemed","Excited","Exciting","Exhilarating","Exquisite","Exultant","Faith","Famous","Feat","Flourish","Fortunate","Fortune","Freedom","Fresh","Funny","authenticity","grit","gritty","improvise","improvisational","libbing","satisfying","surprisingly","unique","uniquely","unnerving","Generous","Genius","Genuine","accurately","accurate","mysterious","suprisingly","best","classic","deserved","deservedly","glib","glibness","honors","profound","realistic","justice","poignant","poignancy","reminiscent","Glad","Glow","Gorgeous","Grace","Graceful","Gratitude","Handsome","Harmony","Healthy","Hearty","Heavenly","Helpful","Holy","Honest","Honored","affirm","Ideal","Imaginative","Increase","Incredible","Independent","Ingenious","Innate","Innovate","Inspire","Instantaneous","Instinct","Intellectual","Intelligence","Intuitive","Inventive","Jovial","Jubilation","Keen","Key","Knowledge","Laugh","Leader","Learn","Legendary","Light","Lively","merit","merits","stunning","magnificently","neat","tender","topped","nice","nicely","noteworthy","Loveliness","Lucidity","Lucrative","Luminous","Maintain","Marvelous","Master","Meaningful","Meditate","Mend","Metamorphosis","Mind-Blowing","Miracle","Mission","Modify","Motivate","Moving","Natural","Nature","Nourish","Nourished","Novel","Nurture","Nutritious","Open","Openhanded","Optimistic","Paradise","Peace","Perfect","Phenomenon","Pleasure","Plenteous","Plentiful","Plenty","Plethora","Poise","Polish","Popular","Positive","Powerful","Prepared","Pretty","Principle","Productive","Project","Prominent","Prosperous","Protect","Proud","Quest","Ready","Recognized","Refinement","Refresh","Rejoice","Rejuvenate","Relax","Reliance","Rely","Remarkable","Renew","Renowned","Replenished","Resolution","Resound","Resources","Respect","Restore","Revered","Revolutionize","Rewarding","Robust","Rousing","Safe","Secure","Sensation","Serenity","Shift","Shine","Silence","Simple","Sincerity","Smart","Smooth","Solution","Sparkling","Spirit","Spirited","Spiritual","Splendid","Spontaneous","Stillness","Stir","Stirring","Strong","Style","Success","Sunny","Support","Surprise","Surprised","Sustain","Synchronized","Team","Thankful","Therapeutic","Thorough","Thrilled","Thrive","Tied","Today","Tranquil","Transform","Triumph","Unity","Unusual","Unwavering","Upbeat","Valued","Vary","Venerated","Venture","Vibrant","Victory","Vigorous","Vision","Visualize","Vital","Vivacious","Voyage","Welcome","Well","Whole","Wholesome","Wonder","Wonderful","Wondrous","Yes"};
	public static String[] oldnegwordss= {"mishandle","pedestrian","clich","average","misses","problem","rant","contrived","sink","painful","silly","stupidity","lamest","sorry","abandoned ","abused ","accused ","addicted ","afraid ","aggravated ","aggressive ","alone ","angry ","anguish ","annoyed ","futile","stereotypes","squirming","unnoticeable","unoriginal","vile","anxious ","apprehensive ","insipid","fail","melodramatic","missing","overkill","spoof","spoofing","weary","embarrassing","forgetable","regretable","vacuous","unnecessary","sardonic","sophomoric","argumentative ","artificial ","ashamed ","assaulted ","risk ","atrocious ","attacked ","avoided ","awful ","awkward ","bad ","badgered ","baffled ","banned ","barren ","belittled ","berated ","betrayed ","bitched ","bitter ","bizzare ","blacklisted ","blackmailed ","blamed ","bleak ","blown ","blur ","bored ","boring ","bossed-around ","bothered ","bothersome ","bounded ","boxed-in ","broken ","bruised ","brushed-off ","bugged ","bullied ","bummed ","burdened ","burdensome ","burned ","burned-out ","caged ","careless ","chaotic ","chased ","cheated ","chicken ","claustrophobic ","clingy ","closed ","clueless ","clumsy ","coaxed ","codependent ","coerced ","cold ","cold-hearted ","combative ","commanded ","competitive ","compulsive ","conceited ","concerned ","condescended ","confined ","conflicted ","confronted ","confused ","conned ","consumed ","contemplative ","contempt ","contentious ","controlled ","convicted ","cornered ","corralled ","cowardly ","crabby ","cramped ","cranky ","crap ","crappy ","crazy ","creeped ","creepy ","critical ","criticized ","cross ","crowded ","cruddy ","repulsive","unrehearsed","crummy ","crushed ","cut-down ","cut-off ","cynical","damaged ","damned ","dangerous ","dazed ","deceived ","defamed ","defeated ","defective ","defenseless ","defensive ","defiant ","deficient ","deflated ","degraded ","dehumanized ","dejected ","delicate ","deluded ","demanding ","demeaned ","demented ","demoralized ","demotivated ","dependent ","depleted ","depraved ","depressed ","deprived ","melodramatics","inconclusive","worst","punishment ","desolate ","despair ","despairing ","desperate ","despicable ","despised ","destroyed ","destructive ","detached ","detest ","detestable ","detested ","devalued ","devastated ","deviant ","devoid ","diagnosed ","dictated ","difficult ","directionless ","dirty ","disabled ","disagreeable ","disappointed ","disappointing ","disapproved ","disbelieved ","discardable ","discarded ","disconnected ","discontent ","discouraged ","discriminated ","disdain ","disdainful ","disempowered ","disenchanted ","disgraced ","disgruntled ","disgust ","disgusted ","disheartened ","dishonest ","dishonorable ","disillusioned ","dislike ","disliked ","dismal ","dismayed ","disorganized ","disoriented ","disowned ","displeased ","disposable ","disregarded ","disrespected ","dissatisfied ","distant ","distracted ","distraught ","distressed ","disturbed ","dizzy ","dominated ","doomed ","double-crossed ","doubted ","doubtful ","down ","downhearted ","downtrodden ","drained ","dramatic ","dread ","dreadful ","dreary ","dropped ","drunk ","dry ","dumb ","dumped ","duped","edgy ","egocentric ","egotistic ","egotistical ","elusive ","emancipated ","emasculated ","embarrassed ","emotional ","emotionless ","bankrupt ","empty ","encumbered ","endangered ","enraged ","enslaved ","entangled ","evaded ","evasive ","evicted ","excessive ","excluded ","exhausted ","exploited ","exposed ","failful","fake ","fearful ","fed ","flawed ","forced ","forgetful ","forgettable ","forgotten ","fragile ","freaked ","frightened ","frigid ","frustrated ","furious","gloomy ","glum ","gothic ","grey ","grief ","grim ","gross ","grossed-out ","grotesque ","grouchy ","grounded ","grumpy ","guilt-tripped ","guilty ","harassed ","hard ","hard-hearted ","harmed ","hassled ","hate ","hateful ","hatred ","haunted ","heartbroken ","heartless ","heavy-hearted ","helpless ","hesitant ","hideous ","hindered ","hopeless ","horrible ","horrified ","horror ","hostile ","hot-tempered ","humiliated ","hung ","hurried ","hysterical","idiotic ","ignorant ","ignored ","ill ","ill-tempered ","imbalanced ","imposed-upon ","impotent ","imprisoned ","impulsive ","dumps ","inactive ","inadequate ","incapable ","incommunicative ","incompetent ","incompatible ","incomplete ","incorrect ","indecisive ","indifferent ","indoctrinated ","inebriated ","ineffective ","inefficient ","inferior ","infuriated ","inhibited ","inhumane ","injured ","injusticed ","insane ","insecure ","insignificant ","insincere ","insufficient ","insulted ","intense ","interrogated ","interrupted ","intimidated ","intoxicated ","invalidated ","invisible ","irrational ","irritable ","irritated ","isolated","jaded","jealous ","jerked ","joyless ","labeled ","laughable ","lazy ","limited ","lonely ","lonesome ","lost ","lousy ","loveless ","low","mad ","manipulated ","masochistic ","messed ","messy ","miffed ","miserable ","misled ","mistaken ","mistreated ","mistrusted ","misunderstood ","mixed-up ","mocked ","molested ","moody","nagged ","needy ","negative ","nervous ","neurotic ","nonconforming ","numb ","nuts ","nutty","objectified ","obligated ","obsessed ","obsessive ","obstructed ","odd ","offended ","opposed ","oppressed ","over-controlled ","over-protected ","overwhelmed","panic ","paranoid ","passive ","pathetic ","pessimistic ","petrified ","phony ","pissed ","plain ","pooped ","poor ","powerless ","pre-judged ","preached","preoccupied ","predjudiced ","pressured ","prosecuted ","provoked ","psychopathic ","psychotic ","punished ","pushed ","puzzled ","quarrelsome ","queer ","questioned ","rage ","raped ","rattled ","regret ","rejected ","resented ","resentful ","responsible ","retarded ","revengeful ","ridiculed ","ridiculous ","robbed ","rotten ","sad ","sadistic ","sarcastic ","scared ","scarred ","screwed ","self-centered ","self-conscious ","self-destructive ","self-hatred ","selfish ","sensitive ","shy ","singled-out ","slow ","smothered ","snapped","spiteful ","stereotyped ","strange ","stressed ","stretched ","stuck ","stupid ","submissive ","suffering ","suffocated ","suicidal ","superficial ","suppressed ","suspicious"};


	public static FileOutputStream fstream2 ;
	public static DataOutputStream in2 ;
	public static BufferedWriter br2;

	public static FileOutputStream fstream3 ;
	public static DataOutputStream in3 ;
	public static BufferedWriter br3;



	public static FileOutputStream fstream4 ;
	public static DataOutputStream in4 ;
	public static BufferedWriter br4;



	public static Integer[] wordlistvals;
	public static String[] wordlistkeys;




	public static Integer[] poswordlistvals;
	public static String[] poswordlistkeys;



	public static Integer[] negwordlistvals;
	public static String[] negwordlistkeys;



	public static Integer[] bigramwordlistvals;
	public static String[] bigramwordlistkeys;

	public static void main(String args[]){

		try{


			//LexicalizedParser lp = new LexicalizedParser("englishPCFG.ser.gz"); 
			//TokenizerFactory tf = PTBTokenizer.factory(false, new WordTokenFactory());
			//TreePrint tp = new TreePrint("penn,typedDependenciesCollapsed");

			FileInputStream fstream = new FileInputStream(args[1]);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));


			fstream2 = new FileOutputStream("output55.txt");
			in2 = new DataOutputStream(fstream2);
			br2 = new BufferedWriter(new OutputStreamWriter(in2));


			fstream3 = new FileOutputStream(outFile);
			in3 = new DataOutputStream(fstream3);
			br3 = new BufferedWriter(new OutputStreamWriter(in3));




			fstream4 = new FileOutputStream("outputbigram66.txt");
			in4 = new DataOutputStream(fstream4);
			br4 = new BufferedWriter(new OutputStreamWriter(in4));



			CountGenerator cg = new CountGenerator();

			String strLine;
			int cnt =0,negCnt=0,posCnt=0;
			Pattern pattern  = Pattern.compile(".*<reviewer>(.*)</reviewer><star>(.*)</star><review>(.*)</review>.*");
			Matcher matcher;

			while ((strLine = br.readLine()) != null)   {

				matcher = pattern.matcher(strLine);
				while (matcher.find()) {
					cnt++;
					String reviewer = matcher.group(1).trim();
					String star = matcher.group(2).trim();
					int starr=Integer.parseInt(star);
					if(starr<=2){
						negCnt++;
					}
					else{
						posCnt++;
					}
					String match = matcher.group(3).trim();
					cg.getCount(match,cnt,starr,reviewer);

					//System.out.println (strLine);
					//System.out.println (cnt +" " +star+" "+match);
					/*
					String ss[]=match.split("\\.");
					for(String match2 :ss){
						System.out.println(match2);
					//List tokens = tf.getTokenizer(new StringReader(match)).tokenize(); 
					//lp.parse(tokens); // parse the tokens
					//Tree t = lp.getBestParse(); // get the best parse tree
					//System.out.println("\nPROCESSED:\n\n"); tp.printTree(t);

					}*/


				}
				//if(cnt==1){
				//break;
				//}

			}

			printHashTable(cg.wordList);
			br2.newLine();
			br2.newLine();
			br2.newLine();
			br2.newLine();

			printHashTable(cg.poswordList);
			br2.newLine();
			br2.newLine();
			br2.newLine();
			br2.newLine();

			printHashTable(cg.negwordList);


			System.out.println("Total Docs- "+cnt);
			cg.docCount=cnt;
			System.out.println(" doc cnt- "+cg.wordCnt);
			System.out.println("Avg doc length- "+cg.wordCnt/cnt);
			logln();


			System.out.println("Total neg Docs- "+negCnt);
			System.out.println(" neg doc cnt- "+cg.wordFromNeg);
			System.out.println("Avg neg doc length- "+cg.wordFromNeg/negCnt);
			logln();


			System.out.println("Total pos Docs- "+posCnt);
			System.out.println(" neg doc cnt- "+cg.wordFromPos);
			System.out.println("Avg pos doc length- "+cg.wordFromPos/posCnt);
			logln();



			System.out.println("Total cntposwordList Docs- "+cg.cntposwordList.size());

			System.out.println("Total cntnegwordList Docs- "+cg.cntnegwordList.size());

			printDocList2(cg);



			/*
			for(Document d : cg.docList){
				br2.newLine();
				br2.newLine();
				br2.write(d.star+" --- pos");
				br2.newLine();
				printHashTable(d.postermFrequency);
				br2.newLine();
				br2.newLine();
				br2.write(d.star+" --- neg");
				br2.newLine();
				printHashTable(d.negtermFrequency);
				br2.newLine();
				br2.newLine();
				br2.write(d.star+" --- all");
				br2.newLine();
				printHashTable(d.termFrequency);
				br2.newLine();
				br2.newLine();
			}
			 */


			compareList(cg.posWords,oldposwordss);

			compareList(cg.negWords,oldnegwordss);

			printBigram();

			br2.flush();
			in2.close();
			br3.flush();
			in3.close();
			br4.flush();
			in4.close();
			in.close();

		}catch (Exception e){

			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();

		}

	}




	private static void printBigram() throws IOException {

		br2.write("------------------------------------bigram list---------------------------------------------------------------");
		br2.newLine();
		/*
		Enumeration en=CountGenerator.bigramwordList.keys();
		int kk=0;
		while( en. hasMoreElements() ){
			String s=(String)en.nextElement();
			System.out.println(s );
			int cnt =CountGenerator.bigramwordList.get(s);
			br2.write("\""+s+"\"  "+cnt);
			br2.newLine();
		}*/

		for(int i=(bigramwordlistkeys.length-1);i>=0;i--){

			br2.write(bigramwordlistkeys[i]+" "+bigramwordlistvals[i]);
			br2.newLine();

			br4.write("\""+bigramwordlistkeys[i]+"\"");
			br4.newLine();

		}

	}




	private static void compareList(ArrayList<String> posWords,			String[] oldposwords) throws IOException {
		br2.write("-----------------------list---------------------------------------------------------------");
		br2.newLine();
		for(String s : oldposwords){

			if(!posWords.contains(s.toLowerCase().trim())){
				br2.write("\""+s+"\"");
				br2.newLine();
			}

		}

	}








	private static void printDocList2(CountGenerator cg ) throws IOException {
		// TODO Auto-generated method stub

		br3.write("@RELATION moviestraining");
		br3.newLine();
		br3.newLine();
		br3.newLine();

		int ccnt=0;





		wordlistkeys = new String[cg.wordList.size()];
		Enumeration en=cg.wordList.keys();
		int kk=0;
		while( en. hasMoreElements() ){
			wordlistkeys[kk] = (String)en.nextElement() ;
			kk++;
		}

		wordlistvals = new Integer[cg.wordList.size()];
		Enumeration env=cg.wordList.keys();
		int kkk=0;
		while( env. hasMoreElements() ){
			String keyss = (String)env.nextElement() ;
			wordlistvals[kkk]=cg.wordList.get(keyss);
			kkk++;
		}


		bubbleSort1();



		sortpos(cg);

		sortneg(cg);

		sortbigram(cg);


		//printArray();

		/*
		for(String key :cg.posWords){

			br3.write("@ATTRIBUTE "+key+" NUMERIC");
			br3.newLine();

		}



		for(String key :cg.negWords){

			br3.write("@ATTRIBUTE "+key+" NUMERIC");
			br3.newLine();

		}
		 */

		int cSize=FEATcnt;
		if(poswordlistkeys.length<cSize-1){
			cSize=poswordlistkeys.length+1;
		}
		for(int i=(poswordlistkeys.length-1);i>(poswordlistkeys.length-cSize);i--){

			br3.write("@ATTRIBUTE "+poswordlistkeys[i]+" NUMERIC");
			br3.newLine();


		}


		int cSizeNeg=FEATcnt;
		if(negwordlistkeys.length<cSizeNeg-1){
			cSizeNeg=negwordlistkeys.length+1;
		}
		for(int i=(negwordlistkeys.length-1);i>(negwordlistkeys.length-cSizeNeg);i--){

			br3.write("@ATTRIBUTE "+negwordlistkeys[i]+" NUMERIC");
			br3.newLine();


		}




		int cSizebigram=1001;
		if(bigramwordlistkeys.length<cSizebigram-1){
			cSizebigram=bigramwordlistkeys.length+1;
		}
		for(int i=(bigramwordlistkeys.length-1);i>(bigramwordlistkeys.length-cSizebigram);i--){
			if((!cg.negWords.contains(wordlistkeys[i])) && (!cg.posWords.contains(wordlistkeys[i]))){
				br3.write("@ATTRIBUTE "+bigramwordlistkeys[i]+" NUMERIC");
				br3.newLine();
			}

		}




		//int cSizet=FEATcnt;
		int cSizet=11;
		if(wordlistkeys.length<cSizet){
			cSizet=wordlistkeys.length+1;
		}
		for(int i=(wordlistkeys.length-1);i>(wordlistkeys.length-cSizet);i--){
			if((!cg.negWords.contains(wordlistkeys[i])) && (!cg.posWords.contains(wordlistkeys[i]))){
				br3.write("@ATTRIBUTE "+wordlistkeys[i]+" NUMERIC");
				br3.newLine();
			}

		}


		br3.write("@ATTRIBUTE doclength NUMERIC");
		br3.newLine();

		br3.write("@ATTRIBUTE posword NUMERIC");
		br3.newLine();

		br3.write("@ATTRIBUTE negword NUMERIC");
		br3.newLine();

		/*br3.write("@ATTRIBUTE diff NUMERIC");
		br3.newLine();
		br3.write("@ATTRIBUTE diffneg NUMERIC");
		br3.newLine();
		 */


		br3.write("@ATTRIBUTE notWord NUMERIC");
		br3.newLine();


		br3.write("@ATTRIBUTE commaWord NUMERIC");
		br3.newLine();

		br3.write("@ATTRIBUTE classFinal {0,1}");
		//br3.write("@ATTRIBUTE classFinal {1,2,3,4}");
		//br3.write("@ATTRIBUTE classFinal {A,B,C,D}");
		br3.newLine();

		br3.newLine();
		br3.newLine();
		br3.write("@DATA");
		br3.newLine();
		br3.flush();


		for(Document d : cg.docList){


			//System.out.println("finished");


			/*
			for(String key :cg.posWords){


				if(d.postermFrequency.containsKey(key)){
					br3.write(d.postermFrequency.get(key)/d.countWords+",");
				}
				else{
					br3.write("0,");
				}

			}



			for(String key :cg.negWords){



				if(d.negtermFrequency.containsKey(key)){
					br3.write(d.negtermFrequency.get(key)/d.countWords+",");
				}
				else{
					br3.write("0,");
				}


			}

			 */

			for(int i=(poswordlistkeys.length-1);i>(poswordlistkeys.length-cSize);i--){

				if(d.postermFrequency.containsKey(poswordlistkeys[i])){

					double tf=d.postermFrequency.get(poswordlistkeys[i])/d.countWords;

					ArrayList<Integer> listt=cg.docFrequency.get(poswordlistkeys[i]);

					double df=Math.log(cg.docCount/listt.size());
					double tfidf=tf*df;

					br3.write(tfidf+",");
				}
				else{
					br3.write("0,");
				}

			}



			for(int i=(negwordlistkeys.length-1);i>(negwordlistkeys.length-cSizeNeg);i--){
				if(d.negtermFrequency.containsKey(negwordlistkeys[i])){

					double tf=d.negtermFrequency.get(negwordlistkeys[i])/d.countWords;

					ArrayList<Integer> listt=cg.docFrequency.get(negwordlistkeys[i]);

					double df=Math.log(cg.docCount/listt.size());
					double tfidf=tf*df;

					br3.write(tfidf+",");
				}
				else{
					br3.write("0,");
				}


			}




			for(int i=(bigramwordlistkeys.length-1);i>(bigramwordlistkeys.length-cSizebigram);i--){

				if((!cg.negWords.contains(wordlistkeys[i])) && (!cg.posWords.contains(wordlistkeys[i]))){


					if(d.bigramtermFrequency.containsKey(bigramwordlistkeys[i])){

						double tf=((d.bigramtermFrequency.get(bigramwordlistkeys[i]))/(d.bicountWords));

						//ArrayList<Integer> listt=cg.docFrequency.get(negwordlistkeys[i]);

						//double df=Math.log(cg.docCount/listt.size());
						//double tfidf=tf*df;

						br3.write(tf+",");
					}
					else{
						br3.write("0,");
					}

				}
			}










			for(int i=(wordlistkeys.length-1);i>(wordlistkeys.length-cSizet);i--){
				if((!cg.negWords.contains(wordlistkeys[i])) && (!cg.posWords.contains(wordlistkeys[i]))){
					if(d.termFrequency.containsKey(wordlistkeys[i])){

						double tf=d.termFrequency.get(wordlistkeys[i])/d.countWords;

						ArrayList<Integer> listt=cg.docFrequency.get(wordlistkeys[i]);

						double df=Math.log(cg.docCount/listt.size());
						double tfidf=tf*df;

						br3.write(tfidf+",");
					}
					else{
						br3.write("0,");
					}
				}
			}

			br3.write(d.countWords+",");

			//br3.write(d.countWords+",");
			br3.write((d.posWords)/d.countWords+",");
			br3.write((d.negWords)/d.countWords+",");
			/*
			if(((d.posWords/d.countWords)-(d.negWords/d.countWords))>0){
				br3.write((d.posWords/d.countWords)-(d.negWords/d.countWords)+",");
				br3.write(0+",");
			}
			else{
				br3.write(0+",");
				br3.write((d.negWords/d.countWords)-(d.posWords/d.countWords)+",");
			}
			 */


			br3.write(d.notWords/d.countWords+",");

			br3.write(d.commaWords/d.countWords+",");


			String sstar=""+d.star;

			//br3.write(sstar);
			//br3.write(d.reviewer);


			if(d.star>=3){
				br3.write("1");
			}
			else{
				br3.write("0");
			}


			br3.newLine();
			br3.flush();

		}


	}







	private static void sortbigram(CountGenerator cg) {


		bigramwordlistkeys = new String[cg.bigramwordList.size()];
		Enumeration en=cg.bigramwordList.keys();
		int kk=0;
		while( en. hasMoreElements() ){
			bigramwordlistkeys[kk] = (String)en.nextElement() ;
			kk++;
		}

		bigramwordlistvals = new Integer[cg.bigramwordList.size()];
		Enumeration env=cg.bigramwordList.keys();
		int kkk=0;
		while( env. hasMoreElements() ){
			String keyss = (String)env.nextElement() ;
			bigramwordlistvals[kkk]=cg.bigramwordList.get(keyss);
			kkk++;
		}


		bubbleSortbigram();
	}




	private static void bubbleSortbigram() {
		int n = bigramwordlistvals.length;
		for (int pass=1; pass < n; pass++) {  // count how many times
			// This next loop becomes shorter and shorter
			for (int i=0; i < n-pass; i++) {
				if (bigramwordlistvals[i] > bigramwordlistvals[i+1]) {
					// exchange elements
					int temp = bigramwordlistvals[i];  bigramwordlistvals[i] = bigramwordlistvals[i+1];  bigramwordlistvals[i+1] = temp;
					String tempp = bigramwordlistkeys[i];  bigramwordlistkeys[i] = bigramwordlistkeys[i+1];  bigramwordlistkeys[i+1] = tempp;
				}
			}
		}
	}




	private static void printDocList(CountGenerator cg ) throws IOException {

		br3.write("@RELATION moviestraining");
		br3.newLine();
		br3.newLine();
		br3.newLine();

		/*
		Enumeration<String> e = docFrequency.keys();
		while( e. hasMoreElements() ){
			ccnt++;

			if(ccnt==1000)
				break;

			String key = (String)e.nextElement() ;

			br3.write("@ATTRIBUTE "+key+" NUMERIC");
			br3.newLine();


		}
		 */

		Enumeration<String> ee;


		br3.write("@ATTRIBUTE doclength NUMERIC");
		br3.newLine();

		br3.write("@ATTRIBUTE posword NUMERIC");
		br3.newLine();

		br3.write("@ATTRIBUTE negword NUMERIC");
		br3.newLine();

		br3.write("@ATTRIBUTE diff NUMERIC");
		br3.newLine();
		br3.write("@ATTRIBUTE diffneg NUMERIC");
		br3.newLine();

		br3.write("@ATTRIBUTE classFinal {A,B,C,D}");
		br3.newLine();

		br3.newLine();
		br3.newLine();
		br3.write("@DATA");
		br3.newLine();
		br3.flush();


		for(Document d : cg.docList){
			/*
			ee= docFrequency.keys();
			ccnt=0;

			while( ee. hasMoreElements() ){
				String key = (String)ee.nextElement() ;

				ccnt++;

				if(ccnt==1000)
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
			br3.write((d.posWords)/d.countWords+",");
			br3.write((d.negWords)/d.countWords+",");

			if(((d.posWords/d.countWords)-(d.negWords/d.countWords))>0){
				br3.write((d.posWords/d.countWords)-(d.negWords/d.countWords)+",");
				br3.write(0+",");
			}
			else{
				br3.write(0+",");
				br3.write((d.negWords/d.countWords)-(d.posWords/d.countWords)+",");
			}


			String sstar=""+d.star;
			br3.write(sstar);

			br3.newLine();
			br3.flush();

		}


	}








	private static void printDocList_reviewer(CountGenerator cg ) throws IOException {
		// TODO Auto-generated method stub

		br3.write("@RELATION moviestraining");
		br3.newLine();
		br3.newLine();
		br3.newLine();

		int ccnt=0;





		wordlistkeys = new String[cg.wordList.size()];
		Enumeration en=cg.wordList.keys();
		int kk=0;
		while( en. hasMoreElements() ){
			wordlistkeys[kk] = (String)en.nextElement() ;
			kk++;
		}

		wordlistvals = new Integer[cg.wordList.size()];
		Enumeration env=cg.wordList.keys();
		int kkk=0;
		while( env. hasMoreElements() ){
			String keyss = (String)env.nextElement() ;
			wordlistvals[kkk]=cg.wordList.get(keyss);
			kkk++;
		}


		bubbleSort1();



		sortpos(cg);

		sortneg(cg);

		//printArray();

		/*
		for(String key :cg.posWords){

			br3.write("@ATTRIBUTE "+key+" NUMERIC");
			br3.newLine();

		}



		for(String key :cg.negWords){

			br3.write("@ATTRIBUTE "+key+" NUMERIC");
			br3.newLine();

		}
		 */

		int cSize=FEATcnt;
		if(poswordlistkeys.length<cSize-1){
			cSize=poswordlistkeys.length+1;
		}
		for(int i=(poswordlistkeys.length-1);i>(poswordlistkeys.length-cSize);i--){

			br3.write("@ATTRIBUTE "+poswordlistkeys[i]+" NUMERIC");
			br3.newLine();


		}


		int cSizeNeg=FEATcnt;
		if(negwordlistkeys.length<cSizeNeg-1){
			cSizeNeg=negwordlistkeys.length+1;
		}
		for(int i=(negwordlistkeys.length-1);i>(negwordlistkeys.length-cSizeNeg);i--){

			br3.write("@ATTRIBUTE "+negwordlistkeys[i]+" NUMERIC");
			br3.newLine();


		}


		//int cSizet=FEATcnt;
		int cSizet=11;
		if(wordlistkeys.length<cSizet){
			cSizet=wordlistkeys.length+1;
		}
		for(int i=(wordlistkeys.length-1);i>(wordlistkeys.length-cSizet);i--){
			if((!cg.negWords.contains(wordlistkeys[i])) && (!cg.posWords.contains(wordlistkeys[i]))){
				br3.write("@ATTRIBUTE "+wordlistkeys[i]+" NUMERIC");
				br3.newLine();
			}

		}


		br3.write("@ATTRIBUTE doclength NUMERIC");
		br3.newLine();

		br3.write("@ATTRIBUTE posword NUMERIC");
		br3.newLine();

		br3.write("@ATTRIBUTE negword NUMERIC");
		br3.newLine();

		/*br3.write("@ATTRIBUTE diff NUMERIC");
		br3.newLine();
		br3.write("@ATTRIBUTE diffneg NUMERIC");
		br3.newLine();
		 */


		br3.write("@ATTRIBUTE notWord NUMERIC");
		br3.newLine();


		br3.write("@ATTRIBUTE commaWord NUMERIC");
		br3.newLine();

		br3.write("@ATTRIBUTE classFinal {0,1}");
		//br3.write("@ATTRIBUTE classFinal {1,2,3,4}");
		//br3.write("@ATTRIBUTE classFinal {A,B,C,D}");
		br3.newLine();

		br3.newLine();
		br3.newLine();
		br3.write("@DATA");
		br3.newLine();
		br3.flush();


		for(Document d : cg.docList){
			/*
			ee= docFrequency.keys();
			ccnt=0;

			while( ee. hasMoreElements() ){
				String key = (String)ee.nextElement() ;

				ccnt++;

				if(ccnt==1000)
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


			/*
			for(String key :cg.posWords){


				if(d.postermFrequency.containsKey(key)){
					br3.write(d.postermFrequency.get(key)/d.countWords+",");
				}
				else{
					br3.write("0,");
				}

			}



			for(String key :cg.negWords){



				if(d.negtermFrequency.containsKey(key)){
					br3.write(d.negtermFrequency.get(key)/d.countWords+",");
				}
				else{
					br3.write("0,");
				}


			}

			 */

			for(int i=(poswordlistkeys.length-1);i>(poswordlistkeys.length-cSize);i--){

				if(d.postermFrequency.containsKey(poswordlistkeys[i])){

					double tf=d.postermFrequency.get(poswordlistkeys[i])/d.countWords;

					ArrayList<Integer> listt=cg.docFrequency.get(poswordlistkeys[i]);

					double df=Math.log(cg.docCount/listt.size());
					double tfidf=tf*df;

					br3.write(tfidf+",");
				}
				else{
					br3.write("0,");
				}

			}



			for(int i=(negwordlistkeys.length-1);i>(negwordlistkeys.length-cSizeNeg);i--){
				if(d.negtermFrequency.containsKey(negwordlistkeys[i])){

					double tf=d.negtermFrequency.get(negwordlistkeys[i])/d.countWords;

					ArrayList<Integer> listt=cg.docFrequency.get(negwordlistkeys[i]);

					double df=Math.log(cg.docCount/listt.size());
					double tfidf=tf*df;

					br3.write(tfidf+",");
				}
				else{
					br3.write("0,");
				}


			}









			for(int i=(wordlistkeys.length-1);i>(wordlistkeys.length-cSizet);i--){
				if((!cg.negWords.contains(wordlistkeys[i])) && (!cg.posWords.contains(wordlistkeys[i]))){
					if(d.termFrequency.containsKey(wordlistkeys[i])){

						double tf=d.termFrequency.get(wordlistkeys[i])/d.countWords;

						ArrayList<Integer> listt=cg.docFrequency.get(wordlistkeys[i]);

						double df=Math.log(cg.docCount/listt.size());
						double tfidf=tf*df;

						br3.write(tfidf+",");
					}
					else{
						br3.write("0,");
					}
				}
			}

			br3.write(d.countWords+",");

			//br3.write(d.countWords+",");
			br3.write((d.posWords)/d.countWords+",");
			br3.write((d.negWords)/d.countWords+",");
			/*
			if(((d.posWords/d.countWords)-(d.negWords/d.countWords))>0){
				br3.write((d.posWords/d.countWords)-(d.negWords/d.countWords)+",");
				br3.write(0+",");
			}
			else{
				br3.write(0+",");
				br3.write((d.negWords/d.countWords)-(d.posWords/d.countWords)+",");
			}
			 */


			br3.write(d.notWords/d.countWords+",");

			br3.write(d.commaWords/d.countWords+",");


			String sstar=""+d.star;

			//br3.write(sstar);
			//br3.write(d.reviewer);


			if(d.star>=3){
				br3.write("1");
			}
			else{
				br3.write("0");
			}


			br3.newLine();
			br3.flush();

		}


	}




	private static void sortneg(CountGenerator cg) {



		negwordlistkeys = new String[cg.cntnegwordList.size()];
		Enumeration en=cg.cntnegwordList.keys();
		int kk=0;
		while( en. hasMoreElements() ){
			negwordlistkeys[kk] = (String)en.nextElement() ;
			kk++;
		}

		negwordlistvals = new Integer[cg.cntnegwordList.size()];
		Enumeration env=cg.cntnegwordList.keys();
		int kkk=0;
		while( env. hasMoreElements() ){
			String keyss = (String)env.nextElement() ;
			negwordlistvals[kkk]=cg.cntnegwordList.get(keyss);
			kkk++;
		}


		bubbleSortneg();

	}




	private static void sortpos(CountGenerator cg) {


		poswordlistkeys = new String[cg.cntposwordList.size()];
		Enumeration en=cg.cntposwordList.keys();
		int kk=0;
		while( en. hasMoreElements() ){
			poswordlistkeys[kk] = (String)en.nextElement() ;
			kk++;
		}

		poswordlistvals = new Integer[cg.cntposwordList.size()];
		Enumeration env=cg.cntposwordList.keys();
		int kkk=0;
		while( env. hasMoreElements() ){
			String keyss = (String)env.nextElement() ;
			poswordlistvals[kkk]=cg.cntposwordList.get(keyss);
			kkk++;
		}


		bubbleSortpos();

	}




	private static void printArray() {
		for(int i=0;i<20;i++){
			System.out.println(wordlistvals[i] +" "+wordlistkeys[i]);
		}



		for(int i=(wordlistvals.length-1);i>(wordlistvals.length-21);i--){
			System.out.println(wordlistvals[i] +" "+wordlistkeys[i]);
		}

	}





	public static void bubbleSort1() {
		int n = wordlistvals.length;
		for (int pass=1; pass < n; pass++) {  // count how many times
			// This next loop becomes shorter and shorter
			for (int i=0; i < n-pass; i++) {
				if (wordlistvals[i] > wordlistvals[i+1]) {
					// exchange elements
					int temp = wordlistvals[i];  wordlistvals[i] = wordlistvals[i+1];  wordlistvals[i+1] = temp;
					String tempp = wordlistkeys[i];  wordlistkeys[i] = wordlistkeys[i+1];  wordlistkeys[i+1] = tempp;
				}
			}
		}
	}




	public static void bubbleSortneg() {
		int n = negwordlistvals.length;
		for (int pass=1; pass < n; pass++) {  // count how many times
			// This next loop becomes shorter and shorter
			for (int i=0; i < n-pass; i++) {
				if (negwordlistvals[i] > negwordlistvals[i+1]) {
					// exchange elements
					int temp = negwordlistvals[i];  negwordlistvals[i] = negwordlistvals[i+1];  negwordlistvals[i+1] = temp;
					String tempp = negwordlistkeys[i];  negwordlistkeys[i] = negwordlistkeys[i+1];  negwordlistkeys[i+1] = tempp;
				}
			}
		}
	}





	public static void bubbleSortpos() {
		int n = poswordlistvals.length;
		for (int pass=1; pass < n; pass++) {  // count how many times
			// This next loop becomes shorter and shorter
			for (int i=0; i < n-pass; i++) {
				if (poswordlistvals[i] > poswordlistvals[i+1]) {
					// exchange elements
					int temp = poswordlistvals[i];  poswordlistvals[i] = poswordlistvals[i+1];  poswordlistvals[i+1] = temp;
					String tempp = poswordlistkeys[i];  poswordlistkeys[i] = poswordlistkeys[i+1];  poswordlistkeys[i+1] = tempp;
				}
			}
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
