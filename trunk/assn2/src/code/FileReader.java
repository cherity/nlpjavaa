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

	public static int FEATcnt =3101;
	public static String outFile="Arff"+FEATcnt+"_reviewer-";


	public static String[] oldposwordss= {"captivating","wise","perfection","Absolutely","compelling","cogent","convince","amazing","payoff","tremendous","revealing","brilliance","genuinely","gracefully","importance","intrinsic","masterly","involved","memorable","simplicity","unfold","unfolds","unmatched","outdoes","rarely","successfully","successful","accomplished","great","imagination","exhibited","imagined","intriguing","masterpiece","masterpieces","pleased","monumental","inspiring","intelligent","masterful","smoothly","different","Abundant","Acclaimed","Accomplishment","Achievement","Acumen","Admire","Adorable","Adored","Affirmative","Affluent","Amaze","Amity","Appreciation","Approve","Artistic","Astonish","Astounding","Astute","surprises","Attractive","good","entertaining","entertained","entertain","special","Authentic","engaging","interesting","Beautiful","Benefit","Blessed","Bliss","Bloom","Bountiful","Bounty","Brave","Bright","Brilliant","Bubbly","Calm","Celebrate","Charitable","Charming","Cheer","Cherish","Clarity","Classy","Clean","Clever","Closeness","Commend","Companionship","Complete","Comradeship","Confident","Conviction","Copious","Core","Coupled","Courageous","Creative","Cultivate","Curious","Cute","Dazzling","Delight","Distinguished","Divine","Earnest","Ecstasy","Effervescent","Efficient","Effortless","Electrifying","Elegance","Embrace","Encompassing","Encourage","Endorse","Energized","Energy","Enjoy","Enjoyed","Enormously","Enthuse","Enthusiastic","Essence","Established","Esteem","Esteemed","Excited","Exciting","Exhilarating","Exquisite","Exultant","Faith","Famous","Feat","Flourish","Fortunate","Fortune","Freedom","Fresh","Funny","authenticity","grit","gritty","improvise","improvisational","libbing","satisfying","surprisingly","unique","uniquely","unnerving","Generous","Genius","Genuine","accurately","accurate","mysterious","suprisingly","best","classic","deserved","deservedly","glib","glibness","honors","profound","realistic","justice","poignant","poignancy","reminiscent","Glad","Glow","Gorgeous","Grace","Graceful","Gratitude","Handsome","Harmony","Healthy","Hearty","Heavenly","Helpful","Holy","Honest","Honored","affirm","Ideal","Imaginative","Increase","Incredible","Independent","Ingenious","Innate","Innovate","Inspire","Instantaneous","Instinct","Intellectual","Intelligence","Intuitive","Inventive","Jovial","Jubilation","Keen","Key","Knowledge","Laugh","Leader","Learn","Legendary","Light","Lively","merit","merits","stunning","magnificently","neat","tender","topped","nice","nicely","noteworthy","Loveliness","Lucidity","Lucrative","Luminous","Maintain","Marvelous","Master","Meaningful","Meditate","Mend","Metamorphosis","Mind-Blowing","Miracle","Mission","Modify","Motivate","Moving","Natural","Nature","Nourish","Nourished","Novel","Nurture","Nutritious","Open","Openhanded","Optimistic","Paradise","Peace","Perfect","Phenomenon","Pleasure","Plenteous","Plentiful","Plenty","Plethora","Poise","Polish","Popular","Positive","Powerful","Prepared","Pretty","Principle","Productive","Project","Prominent","Prosperous","Protect","Proud","Quest","Ready","Recognized","Refinement","Refresh","Rejoice","Rejuvenate","Relax","Reliance","Rely","Remarkable","Renew","Renowned","Replenished","Resolution","Resound","Resources","Respect","Restore","Revered","Revolutionize","Rewarding","Robust","Rousing","Safe","Secure","Sensation","Serenity","Shift","Shine","Silence","Simple","Sincerity","Smart","Smooth","Solution","Sparkling","Spirit","Spirited","Spiritual","Splendid","Spontaneous","Stillness","Stir","Stirring","Strong","Style","Success","Sunny","Support","Surprise","Surprised","Sustain","Synchronized","Team","Thankful","Therapeutic","Thorough","Thrilled","Thrive","Tied","Today","Tranquil","Transform","Triumph","Unity","Unusual","Unwavering","Upbeat","Valued","Vary","Venerated","Venture","Vibrant","Victory","Vigorous","Vision","Visualize","Vital","Vivacious","Voyage","Welcome","Well","Whole","Wholesome","Wonder","Wonderful","Wondrous","Yes"};
	public static String[] oldnegwordss= {"mishandle","pedestrian","clich","average","misses","problem","rant","contrived","sink","painful","silly","stupidity","lamest","sorry","abandoned ","abused ","accused ","addicted ","afraid ","aggravated ","aggressive ","alone ","angry ","anguish ","annoyed ","futile","stereotypes","squirming","unnoticeable","unoriginal","vile","anxious ","apprehensive ","insipid","fail","melodramatic","missing","overkill","spoof","spoofing","weary","embarrassing","forgetable","regretable","vacuous","unnecessary","sardonic","sophomoric","argumentative ","artificial ","ashamed ","assaulted ","risk ","atrocious ","attacked ","avoided ","awful ","awkward ","bad ","badgered ","baffled ","banned ","barren ","belittled ","berated ","betrayed ","bitched ","bitter ","bizzare ","blacklisted ","blackmailed ","blamed ","bleak ","blown ","blur ","bored ","boring ","bossed-around ","bothered ","bothersome ","bounded ","boxed-in ","broken ","bruised ","brushed-off ","bugged ","bullied ","bummed ","burdened ","burdensome ","burned ","burned-out ","caged ","careless ","chaotic ","chased ","cheated ","chicken ","claustrophobic ","clingy ","closed ","clueless ","clumsy ","coaxed ","codependent ","coerced ","cold ","cold-hearted ","combative ","commanded ","competitive ","compulsive ","conceited ","concerned ","condescended ","confined ","conflicted ","confronted ","confused ","conned ","consumed ","contemplative ","contempt ","contentious ","controlled ","convicted ","cornered ","corralled ","cowardly ","crabby ","cramped ","cranky ","crap ","crappy ","crazy ","creeped ","creepy ","critical ","criticized ","cross ","crowded ","cruddy ","repulsive","unrehearsed","crummy ","crushed ","cut-down ","cut-off ","cynical","damaged ","damned ","dangerous ","dazed ","deceived ","defamed ","defeated ","defective ","defenseless ","defensive ","defiant ","deficient ","deflated ","degraded ","dehumanized ","dejected ","delicate ","deluded ","demanding ","demeaned ","demented ","demoralized ","demotivated ","dependent ","depleted ","depraved ","depressed ","deprived ","melodramatics","inconclusive","worst","punishment ","desolate ","despair ","despairing ","desperate ","despicable ","despised ","destroyed ","destructive ","detached ","detest ","detestable ","detested ","devalued ","devastated ","deviant ","devoid ","diagnosed ","dictated ","difficult ","directionless ","dirty ","disabled ","disagreeable ","disappointed ","disappointing ","disapproved ","disbelieved ","discardable ","discarded ","disconnected ","discontent ","discouraged ","discriminated ","disdain ","disdainful ","disempowered ","disenchanted ","disgraced ","disgruntled ","disgust ","disgusted ","disheartened ","dishonest ","dishonorable ","disillusioned ","dislike ","disliked ","dismal ","dismayed ","disorganized ","disoriented ","disowned ","displeased ","disposable ","disregarded ","disrespected ","dissatisfied ","distant ","distracted ","distraught ","distressed ","disturbed ","dizzy ","dominated ","doomed ","double-crossed ","doubted ","doubtful ","down ","downhearted ","downtrodden ","drained ","dramatic ","dread ","dreadful ","dreary ","dropped ","drunk ","dry ","dumb ","dumped ","duped","edgy ","egocentric ","egotistic ","egotistical ","elusive ","emancipated ","emasculated ","embarrassed ","emotional ","emotionless ","bankrupt ","empty ","encumbered ","endangered ","enraged ","enslaved ","entangled ","evaded ","evasive ","evicted ","excessive ","excluded ","exhausted ","exploited ","exposed ","failful","fake ","fearful ","fed ","flawed ","forced ","forgetful ","forgettable ","forgotten ","fragile ","freaked ","frightened ","frigid ","frustrated ","furious","gloomy ","glum ","gothic ","grey ","grief ","grim ","gross ","grossed-out ","grotesque ","grouchy ","grounded ","grumpy ","guilt-tripped ","guilty ","harassed ","hard ","hard-hearted ","harmed ","hassled ","hate ","hateful ","hatred ","haunted ","heartbroken ","heartless ","heavy-hearted ","helpless ","hesitant ","hideous ","hindered ","hopeless ","horrible ","horrified ","horror ","hostile ","hot-tempered ","humiliated ","hung ","hurried ","hysterical","idiotic ","ignorant ","ignored ","ill ","ill-tempered ","imbalanced ","imposed-upon ","impotent ","imprisoned ","impulsive ","dumps ","inactive ","inadequate ","incapable ","incommunicative ","incompetent ","incompatible ","incomplete ","incorrect ","indecisive ","indifferent ","indoctrinated ","inebriated ","ineffective ","inefficient ","inferior ","infuriated ","inhibited ","inhumane ","injured ","injusticed ","insane ","insecure ","insignificant ","insincere ","insufficient ","insulted ","intense ","interrogated ","interrupted ","intimidated ","intoxicated ","invalidated ","invisible ","irrational ","irritable ","irritated ","isolated","jaded","jealous ","jerked ","joyless ","labeled ","laughable ","lazy ","limited ","lonely ","lonesome ","lost ","lousy ","loveless ","low","mad ","manipulated ","masochistic ","messed ","messy ","miffed ","miserable ","misled ","mistaken ","mistreated ","mistrusted ","misunderstood ","mixed-up ","mocked ","molested ","moody","nagged ","needy ","negative ","nervous ","neurotic ","nonconforming ","numb ","nuts ","nutty","objectified ","obligated ","obsessed ","obsessive ","obstructed ","odd ","offended ","opposed ","oppressed ","over-controlled ","over-protected ","overwhelmed","panic ","paranoid ","passive ","pathetic ","pessimistic ","petrified ","phony ","pissed ","plain ","pooped ","poor ","powerless ","pre-judged ","preached","preoccupied ","predjudiced ","pressured ","prosecuted ","provoked ","psychopathic ","psychotic ","punished ","pushed ","puzzled ","quarrelsome ","queer ","questioned ","rage ","raped ","rattled ","regret ","rejected ","resented ","resentful ","responsible ","retarded ","revengeful ","ridiculed ","ridiculous ","robbed ","rotten ","sad ","sadistic ","sarcastic ","scared ","scarred ","screwed ","self-centered ","self-conscious ","self-destructive ","self-hatred ","selfish ","sensitive ","shy ","singled-out ","slow ","smothered ","snapped","spiteful ","stereotyped ","strange ","stressed ","stretched ","stuck ","stupid ","submissive ","suffering ","suffocated ","suicidal ","superficial ","suppressed ","suspicious"};
	public static String[] distWords={"poorly", "terrible", "avoid", "wasted", "seagal", "id", "unfunny", "fan", "embarrassing", "christopher", "unless", "batman", "dogs", "remotely", "clich", "ugly", "gratuitous", "inane", "painful", "youd", "mention", "imagination", "inept", "gun", "managed", "excuse", "depressing", "apparent", "stupidity", "apparently", "sitcom", "lawrence", "hands", "logic", "wayans", "include", "eddie", "101", "watchable", "decided", "therefore", "bore", "werent", "virtually", "bored", "thrillers", "dumber", "fathers", "carrey", "unpleasant", "alien", "nielsen", "blame", "shallow", "please", "lewis", "acted", "mans", "commercial", "cliches", "obnoxious", "havent", "uninteresting", "uninspired", "evidence", "naked", "irritating", "1995", "gotten", "drop", "box", "nasty", "offensive", "further", "started", "tired", "oh", "genuinely", "comparison", "category", "total", "shadow", "sister", "team", "ludicrous", "escape", "pretentious", "roger", "sorry", "admit", "trailers", "disaster", "buy", "basketball", "ad", "shoot", "pathetic", "crude", "farce", "hoping", "added", "beverly", "scream", "credible", "target", "begins", "promise", "leaving", "suspect", "fight", "worthwhile", "teen", "energetic", "promising", "featuring", "walk", "stuck", "mediocre", "budget", "sadly", "spends", "ride", "characterization", "protagonist", "enjoyed", "wait", "happening", "stock", "lesson", "spent", "alan", "davis", "tim", "climax", "price", "uneven", "songs", "numbers", "charming", "appreciate", "wedding", "jane", "significant", "parker", "largely", "business", "mother", "buddy", "biggest", "dream", "moves", "various", "relatively", "disappointed", "issue", "fortunately", "younger", "resolution", "thoroughly", "towards", "latter", "park", "episode", "puts", "center", "surprises", "affair", "wars", "masterpiece", "academy", "joy", "sayles", "amazing", "strongly", "vision", "honest", "structure", "stunning", "battle", "innocence", "epic", "presents", "indeed", "spirit", "footage", "emotionally", "deeply", "greatest", "cold", "grand", "scorsese", "howard", "speaks", "control", "incredible", "historical", "cuts", "kieslowski", "tears", "viewed", "worthy", "toy", "larry", "accomplished", "considered", "universal", "silence", "future", "marvelous", "scope", "la", "wide", "justice", "crafted", "happened", "godfather", "master", "branagh", "match", "superb", "tragic", "pulp", "meaning", "poignant", "schindlers", "process", "presentation", "forget", "represents", "moral", "mesmerizing", "engrossing", "ages", "asks", "sympathetic", "remarkable", "class", "theatrical", "print", "circumstances", "cameron", "beautifully", "subjects", "move", "won", "recommendation", "titanic", "understanding", "became", "detail", "slowly", "answers", "pain", "ago", "examination", "addition", "gay", "jerry", "portrait", "hamlet", "black-and-white", "individuals", "gripping", "animation", "tarantino", "1994", "hate", "andrew", "feelings", "silent", "includes", "seven", "captures", "lovers", "fear", "christmas", "draws", "delight", "displays"};
	public static ArrayList<String> distWordslist=new ArrayList<String>();
	public static ArrayList<String> printedposlist=new ArrayList<String>();
	public static ArrayList<String> printedneglist=new ArrayList<String>();



	public static String[] reviewerFeaturesWords={"show", "though", "subscribe", "acceptable", "particularly", "simply", "solid", "nature", "ultimately", "familiar", "entirely", "believable", "appealing", "rare", "fast", "mostly", "potential", "necessary", "particular", "central", "opportunity", "perspective", "largely", "worthwhile", "apparent", "apparently", "primarily", "universal", "superb", "core", "evident", "therefore", "fortunately", "mesmerizing", "competent", "vastly", "although", "profanity", "despite", "unfortunately", "difficult", "contrived", "unexpected", "critical", "melodramatic", "unfortunate", "distracting", "film", "movie", "story", "--"};

	public static String[] reviewerFeaturesbigramWords={"motion-picture", "waste-money", "dont-waste", "running-time", "message-subject", "reply-message", "rated-pg-13", "fine-kids", "son-jeffrey", "fine-teenagers", "older-teenagers", "theres-nothing", "film-one", "motion-pictures", "running-length", "film-makers", "far-more", "relationship-between", "kind-film", "very-good", "theres-little", "film-making", "screen-presence", "doesnt-take", "film-maker", "film-film", "theres-enough", "find-yourself", "theres-one", "entertainment-value", "taking-place", "even-better", "entire-movie", "rated-probably", "end-credits", "title-character", "films-title", "films-end", "nothing-offend"};


	public static ArrayList<String> reviewerFeaturesWordsList=new ArrayList<String>();
	public static ArrayList<String> reviewerFeaturesbigramWordsList=new ArrayList<String>();

	//3000--public static String[] bigramList={"films-year", "see-film", "motion-picture", "film-excellent", "movie-kind", "waste-money", "average-movie", "dont-waste", "show-dont", "excellent-show", "show-look", "kind-enjoyable", "enjoyable-poor", "poor-show", "look-average", "opinions-expressed", "meant-reflect", "mine-meant", "reflect-employers", "expressed-mine", "running-time", "few-films", "one-worst", "worst-films", "message-subject", "reply-message", "details-reply", "one-top", "money-one", "year-see", "totally-unbearable", "year-totally", "top-few", "rated-pg-13", "mpaa-rating", "subject-line", "much-more", "even-though", "special-effects", "even-more", "little-more", "adult-themes", "unbearable-opinions", "fine-kids", "screening-room", "son-jeffrey", "see-screening", "subject-subscribe", "room-details", "much-better", "fine-teenagers", "one-those", "kids-around", "sex-nudity", "see-moviepage", "moviepage-details", "line-subscribe", "jeffrey-age", "painfully-unbearable", "money-totally", "unbearable-picture", "totally-painfully", "sexual-situations", "turns-out", "older-teenagers", "english-subtitles", "theres-nothing", "review-written", "romantic-comedy", "film-one", "word-subscribe", "letter-word", "subscribe-subject", "send-letter", "acceptable-teenagers", "screen-time", "motion-pictures", "running-length", "love-story", "character-study", "film-makers", "mature-themes", "two-hours", "far-more", "subject-matter", "between-two", "runs-rated", "acceptable-older", "chemistry-between", "one-thing", "action-sequences", "film-more", "first-time", "bad-language", "character-development", "brief-nudity", "themes-running", "supporting-cast", "one-best", "theres-something", "rated-violence", "profanity-adult", "rating-pg-13", "violence-profanity", "star-wars", "film-fine", "picture-opinions", "figure-out", "time-minutes", "acceptable-kids", "language-acceptable", "give-1/2", "academy-award", "nudity-violence", "high-school", "part-film", "science-fiction", "writer-director", "first-half", "1/2-one", "film-made", "box-office", "action-film", "main-characters", "dont-know", "last-years", "more-interesting", "subtitles-rated", "one-many", "great-deal", "best-part", "film-doesnt", "along-way", "doesnt-seem", "theres-much", "rating-profanity", "bad-guys", "unbearable-review", "dont-think", "takes-place", "relationship-between", "youve-seen", "give-film", "very-little", "woody-allen", "long-rated", "big-screen", "many-scenes", "pulp-fiction", "isnt-much", "years-ago", "movie-one", "new-york", "rated-strong", "runs-long", "director-john", "want-see", "see-movie", "many-times", "rated-sex", "something-more", "film-noir", "one-more", "worth-seeing", "half-hour", "ingmar-bergman", "film-festival", "never-quite", "many-ways", "doesnt-make", "long-time", "rated-language", "bit-more", "much-time", "film-never", "soap-opera", "dont-want", "movie-nothing", "film-even", "one-films", "second-half", "film-rated", "nothing-more", "kind-film", "black-white", "very-good", "1997-opinions", "make-sense", "robin-williams", "theres-little", "make-film", "one-few", "profanity-violence", "part-movie", "one-scene", "1/2-see", "never-seen", "sit-through", "found-myself", "film-making", "film-much", "picture-review", "black-comedy", "die-hard", "film-makes", "one-film", "movie-rated", "lot-more", "screen-presence", "profanity-fine", "down-david", "belief-movie", "david-puttnam", "nothing-life", "sexual-content", "people-neutral", "makes-film", "leave-down", "neutral-leave", "leaves-people", "leave-leave", "life-leaves", "made-film", "very-funny", "theres-lot", "very-much", "give-one", "enough-make", "drug-use", "based-novel", "star-trek", "written-directed", "two-leads", "one-point", "action-films", "pg-13-profanity", "anything-more", "film-takes", "drug-usage", "horror-film", "ive-seen", "sense-humor", "doesnt-take", "violence-language", "put-together", "film-maker", "pg-13-violence", "comic-relief", "jurassic-park", "feature-film", "best-thing", "nudity-profanity", "first-place", "film-film", "theres-enough", "plot-device", "quite-good", "violence-running", "seen-before", "movie-isnt", "reason-see", "doesnt-much", "profanity-running", "movie-more", "without-being", "violence-fine", "many-characters", "opening-credits", "tell-story", "doesnt-work", "sight-gags", "bad-movie", "good-film", "once-again", "teenagers-send", "kind-movie", "real-life", "action-scenes", "plot-twists", "age-gave", "those-films", "physical-comedy", "fairy-tale", "show-fine", "find-yourself", "film-director", "theres-one", "seems-more", "one-another", "good-enough", "great-film", "first-film", "mpaa-classification", "turn-out", "much-fun", "true-story", "bad-guy", "entertainment-value", "old-enough", "more-interested", "recommend-give", "fifteen-minutes", "one-expect", "one-character", "fine-older", "recommend-film", "length-mpaa", "hard-believe", "good-movie", "way-through", "mature-teenagers", "comic-book", "rest-movie", "rated-profanity", "leave-theater", "around-son", "sitting-through", "film-isnt", "taking-place", "same-time", "even-better", "rest-film", "correctly-rated", "director-robert", "french-english", "entire-movie", "ensemble-cast", "one-two", "happy-ending", "theres-more", "waste-time", "tries-hard", "fine-line", "romantic-comedies", "throughout-film", "come-out", "violence-acceptable", "profanity-sexual", "many-films", "pretty-good", "never-really", "men-women", "much-film", "make-sure", "film-very", "story-told", "point-out", "supporting-characters", "doesnt-really", "television-series", "themes-profanity", "story-itself", "first-hour", "story-film", "film-works", "story-line", "story-more", "james-bond", "mission-impossible", "family-film", "serial-killer", "entire-film", "unbearable-reviewed", "good-time", "few-minutes", "action-hero", "quentin-tarantino", "reviewed-written", "director-peter", "lion-king", "schindlers-list", "toy-story", "making-film", "telling-story", "rated-probably", "times-before", "gives-film", "give-see", "movie-made", "main-character", "film-itself", "even-those", "more-effective", "recommend-movie", "feel-good", "ten-minutes", "manages-make", "more-one", "hour-half", "movie-never", "film-many", "five-minutes", "whole-lot", "film-seems", "love-affair", "best-film", "kids-under", "film-good", "low-budget", "film-without", "movie-doesnt", "doesnt-know", "visual-effects", "many-people", "recommend-picture", "twenty-minutes", "trying-make", "romance-between", "more-impressive", "home-alone", "best-performance", "perhaps-best", "ages-son", "quite-funny", "1995-opinions", "1996-opinions", "very-well", "out-film", "makes-sense", "good-sense", "twists-turns", "human-beings", "closing-credits", "end-film", "minutes-film", "see-one", "part-story", "bad-film", "thumbs-down", "screenplay-david", "without-much", "both-sides", "nudity-sex", "age-thought", "better-film", "length-rated", "sexuality-acceptable", "film-give", "cant-help", "film-offers", "musical-numbers", "independence-day", "director-michael", "little-bit", "end-credits", "story-one", "director-david", "out-one", "gave-film", "film-little", "rating-violence", "high-energy", "out-loud", "thirty-minutes", "source-material", "well-worth", "same-way", "whats-going", "film-ends", "set-pieces", "give-movie", "more-time", "dont-care", "one-better", "first-part", "fun-watch", "point-view", "recommend-show", "press-screening", "way-film", "slice-life", "rest-cast", "problem-film", "think-film", "ninety-minutes", "point-film", "award-1/2", "few-scenes", "noir-film", "entertaining-film", "film-comes", "movie-itself", "few-times", "little-profanity", "line-between", "one-great", "many-movies", "target-audience", "despite-being", "steven-seagal", "sexuality-language", "films-one", "although-film", "strong-violence", "take-place", "violence-sex", "half-film", "characters-situations", "pretty-much", "language-violence", "although-movie", "easy-see", "silicon-valley", "title-character", "make-movie", "violence-adult", "film-those", "few-good", "last-act", "fine-teenager", "ending-credits", "suspension-disbelief", "fair-amount", "back-forth", "pg-13-sexual", "difference-between", "havent-seen", "seem-more", "two-films", "bond-films", "doesnt-quite", "seeing-film", "pop-culture", "horror-films", "walk-out", "good-one", "one-one", "wonderful-life", "though-film", "turned-out", "credits-roll", "find-film", "date-released", "movie-takes", "good-idea", "more-important", "especially-those", "work-well", "jackie-chan", "strong-language", "older-mature", "story-doesnt", "between-art", "many-viewers", "human-being", "something-mary", "much-less", "film-well", "camera-work", "time-film", "drug-content", "bruce-willis", "time-around", "lot-fun", "first-time-director", "something-between", "written-january", "themes-violence", "beginning-end", "film-probably", "long-enough", "century-theaters", "hong-kong", "language-fine", "piece-work", "few-moments", "out-place", "art-films", "1994-opinions", "film-acceptable", "facial-expressions", "pg-13-brief", "short-cuts", "watching-movie", "recent-films", "film-becomes", "two-characters", "anthony-hopkins", "much-movie", "martin-scorsese", "miramax-films", "one-good", "jean-luc-godard", "many-different", "violence-sexual", "sexual-humor", "movie-makes", "directorial-debut", "time-movie", "good-guys", "fine-ages", "parts-movie", "best-picture", "one-reasons", "picture-give", "live-action", "funny-moments", "clint-eastwood", "amc-century", "minor-characters", "social-commentary", "film-gets", "film-really", "teenagers-recommend", "good-job", "works-best", "one-favorite", "mild-profanity", "thought-movie", "doesnt-mean", "horror-movie", "nudity-language", "such-films", "characters-film", "few-years", "more-serious", "films-made", "art-life", "pg-13-adult", "warner-brothers", "thematic-elements", "dont-see", "forrest-gump", "life-piece", "far-less", "thing-film", "cinema-both", "life-takes", "language-drug", "movie-fine", "cinema-something", "bad-taste", "straight-out", "weve-seen", "last-summer", "film-see", "film-critics", "situations-adult", "make-mistake", "long-way", "few-more", "movie-runs", "violence-film", "films-life", "themes-sexual", "violence-bad", "parts-film", "come-close", "nudity-sexual", "sex-violence", "both-gives", "unlike-painting", "painting-literature", "press-kit", "cinema-art", "cinema-slice", "piece-cake", "emotional-impact", "life-unlike", "film-didnt", "film-still", "literature-cinema", "arent-many", "takes-jean-luc", "film-cant", "more-few", "watching-film", "well-done", "never-seems", "good-bad", "gave-1/2", "one-way", "make-more", "becomes-more", "jim-carrey", "film-set", "gives-life", "first-movie", "movie-filled", "life-cinema", "find-out", "really-good", "central-character", "good-evil", "plot-elements", "sexual-innuendo", "sandra-bullock", "movie-thats", "van-damme", "united-states", "story-never", "few-laughs", "film-best", "little-mermaid", "character-film", "loose-ends", "worth-caring", "starship-troopers", "steven-spielberg", "classification-mpaa", "isnt-nearly", "type-film", "mild-thumbs", "nothing-special", "make-much", "acting-ability", "very-bad", "good-thing", "film-thats", "films-best", "enough-recommend", "last-year", "many-more", "enough-interested", "valley-showing", "film-opens", "much-same", "start-finish", "smart-enough", "doesnt-offer", "problem-movie", "best-known", "better-movie", "certainly-isnt", "sort-movie", "worth-price", "doesnt-matter", "pg-13-language", "little-long", "theaters-send", "dumb-dumber", "those-dont", "content-acceptable", "saving-grace", "movie-bad", "beauty-beast", "film-story", "more-fun", "sex-scenes", "rated-nudity", "isnt-bad", "film-version", "doesnt-even", "reservoir-dogs", "doesnt-help", "period-piece", "rated-brief", "film-seem", "film-seen", "film-such", "way-out", "out-way", "even-worse", "youre-going", "production-values", "film-tries", "art-house", "oliver-stone", "script-doesnt", "each-one", "pleasant-enough", "long-before", "many-things", "itself-seriously", "fine-job", "slow-motion", "film-first", "those-rare", "take-long", "language-film", "year-old", "one-long", "much-sense", "language-sexual", "dont-make", "didnt-know", "situations-running", "much-story", "works-well", "best-films", "films-such", "romeo-juliet", "aspect-ratio", "debut-feature", "those-enjoy", "far-better", "films-title", "pg-13-mature", "blair-witch", "fine-kid", "gave-movie", "kenneth-branagh", "best-work", "films-end", "movie-best", "makes-one", "more-compelling", "more-plot", "found-film", "fifth-element", "starts-out", "makes-feel", "see-show", "movie-good", "showing-amc", "price-admission", "read-book", "perhaps-more", "made-more", "rest-picture", "those-scenes", "tom-hanks", "camera-angles", "rated-mature", "didnt-seem", "everyone-love", "john-hughes", "nothing-offend", "scene-film", "man-woman", "under-fire", "end-movie", "two-stars", "time-director", "little-violence", "isnt-enough", "more-film", "first-feature", "edge-seat", "real-people", "arnold-schwarzenegger", "simple-story", "last-film", "nudity-acceptable", "both-films", "film-goes", "isnt-particularly", "thought-film", "picture-one", "christopher-walken", "none-characters", "strongly-recommend", "age-innocence", "check-out", "language-brief", "one-time", "harrison-ford", "film-seemed", "scenes-between", "themes-fine", "two-people", "long-film", "time-one", "von-trier", "batman-robin", "film-based", "interaction-between", "part-problem", "production-design", "good-news", "big-laughs", "even-less", "little-film", "during-course", "recent-years", "everything-film", "character-interaction", "previous-films", "show-one", "through-film", "paramount-pictures", "tour-force", "something-special", "little-time", "seen-film", "kids-age", "film-although", "car-chase", "one-years", "hard-imagine", "audiences-attention", "small-part", "film-make", "left-theater", "much-ado", "makes-more", "film-moves", "runs-little", "movie-much", "award-nomination", "award-winning", "dont-mind", "supporting-players", "offend-anyone", "few-nice", "more-subtle", "going-through", "theres-reason", "movie-year", "even-film", "stand-out", "movie-works", "strong-enough", "punch-lines", "worth-watching", "sort-film", "rest-story", "film-something", "nice-guy", "movie-without", "lost-world", "takes-itself", "cast-members", "courage-under", "film-wasnt", "good-intentions", "dark-comedy", "rated-nc-17", "film-plays", "isnt-even", "movie-seems", "more-more", "strong-performances", "twenty-years", "lead-character", "fast-paced", "movie-really", "movie-even", "give-thumbs", "screenplay-john", "story-much", "large-part", "written-june", "never-made", "brady-bunch", "steve-martin", "david-mamet", "spend-time", "high-points", "french-subtitles", "life-film", "perfectly-cast", "original-film", "good-looks", "nudity-bad", "isnt-quite", "great-fun", "video-game", "julia-roberts", "notre-dame", "film-going", "more-enough", "best-scenes", "two-movies", "theres-never", "kevin-costner", "del-toro", "going-happen", "cross-between", "sweet-little", "theatrical-aspect", "human-nature", "another-film", "breaking-waves", "far-much", "before-sunrise", "cant-even", "right-down", "kids-movie", "giving-film", "film-certainly", "john-sayles", "film-worth", "interesting-character", "award-one", "movies-one", "story-isnt", "last-seen", "written-october", "violence-nudity", "profanity-brief", "saturday-night", "main-story", "bad-thing", "first-foremost", "two-actors", "think-movie", "toward-end", "come-alive", "half-movie", "nudity-little", "music-video", "violence-gore", "story-thats", "more-complex", "spinal-tap", "dont-understand", "characters-more", "low-key", "murder-mystery", "dont-expect", "those-movies", "liked-movie", "new-film", "several-scenes", "director-stephen", "theres-sense", "kids-movies", "bad-movies", "funny-film", "doesnt-always", "want-know", "nothing-new", "film-stock", "towards-end", "pg-13-rating", "take-away", "hugh-grant", "several-times", "film-feels", "find-themselves", "whole-family", "question-whether", "dont-worry", "film-starts", "aspects-film", "truman-show", "movie-film", "being-one", "kid-old", "language-sex", "sound-effects", "over-top", "film-shot", "best-parts", "bad-news", "aspect-film", "beverly-hills", "one-very", "little-sense", "david-lynch", "best-friends", "richard-iii", "movie-first", "intelligent-script", "story-movie", "look-good", "dont-work", "without-giving", "das-boot", "full-monty", "hollywood-films", "near-end", "film-being", "one-wonders", "more-substantial", "biggest-problem", "quite-bit", "viewers-find", "acting-talent", "lead-role", "movie-tries", "until-last", "good-story", "isnt-exactly", "until-end", "such-one", "comes-close", "scene-movie", "taken-seriously", "primary-colors", "isnt-really", "crude-humor", "love-stories", "excellent-job", "opening-scene", "film-full", "seeing-movie", "brought-screen", "characters-story", "teenagers-see", "takes-time", "movie-give", "particularly-good", "101-dalmatians", "dont-even", "perhaps-even", "story-many", "last-scene", "film-theres", "never-gets", "one-such", "those-two", "dont-need", "family-entertainment", "compelling-story", "graphic-violence", "beneath-surface", "director-mike", "good-acting", "film-though", "give-picture", "nicolas-cage", "nearly-enough", "bond-film", "thats-good", "fine-performances", "actors-actresses", "between-characters", "over-years", "out-more", "world-war", "thats-more", "remains-day", "enough-keep", "watch-film", "wag-dog", "based-true", "four-weddings", "movie-comes", "always-seems", "result-film", "100-minutes", "bad-things", "film-contains", "fall-love", "jerry-maguire", "kids-over", "quite-sure", "teenagers-older", "theres-still", "points-out", "eddie-murphy", "make-feel", "20th-century", "two-main", "martial-arts", "rated-sexual", "theres-doubt", "film-long", "thats-one", "isnt-one", "one-big", "movie-full", "movie-gets", "battle-scenes", "live-die", "funny-one", "over-two", "sense-sensibility", "film-funny", "movie-still", "theres-even", "one-movies", "refreshing-see", "ado-nothing", "didnt-make", "waiting-guffman", "frontal-nudity", "robert-duvall", "thats-exactly", "even-best", "much-longer", "worth-noting", "george-lucas", "stands-out", "violence-sexuality", "way-long", "love-interest", "message-film", "opening-sequence", "movie-little", "during-movie", "matter-much", "nutty-professor", "fun-watching", "tim-burton", "time-kill", "nudity-fine", "come-expect", "one-characters", "fall-flat", "columbia-pictures", "independent-film", "through-eyes", "language-sexuality", "movie-1/2", "robert-niro", "basic-instinct", "runs-feels", "company-men", "scenes-film", "thumbs-1/2", "youll-probably", "more-less", "press-notes", "two-hour", "one-really", "nothing-much", "more-real", "sundance-film", "musical-score", "more-powerful", "good-guy", "best-supporting", "nothing-short", "hunchback-notre", "film-few", "suspend-disbelief", "isnt-funny", "somewhere-between", "supporting-roles", "bathroom-humor", "distributor-miramax", "film-movie", "more-concerned", "little-sex", "characters-dont", "lost-highway", "worse-still", "minute-running", "made-look", "movie-feels", "less-successful", "during-first", "art-film", "sleepless-seattle", "kevin-spacey", "las-vegas", "virtually-nothing", "guilty-pleasure", "time-movies", "attention-detail", "true-lies", "french-film", "family-films", "seen-movie", "fun-film", "plays-part", "center-stage", "free-willy", "mystery-story", "see-again", "comes-alive", "something-little", "movie-features", "made-movie", "far-away", "piece-acting", "scenes-one", "story-seems", "director-james", "those-moments", "movie-two", "scary-movie", "director-richard", "blown-away", "time-spent", "coen-brothers", "doesnt-appear", "boogie-nights", "early-film", "more-enjoyable", "les-miserables", "film-kind", "last-action", "universal-pictures", "film-industry", "film-look", "minutes-long", "half-dozen", "final-scene", "more-successful", "one-doesnt", "film-way", "more-appropriate", "absolutely-nothing", "feature-length", "making-movie", "entirely-different", "running-around", "good-measure", "adam-sandler", "world-cinema", "work-here", "see-something", "ending-film", "someone-elses", "theme-song", "first-two", "few-things", "comes-through", "keep-audience", "psychological-thriller", "naked-gun", "makes-want", "john-malkovich", "such-thing", "best-actor", "director-jonathan", "profanity-nudity", "already-know", "dope-smoking", "over-head", "anyone-age", "never-again", "characters-seem", "role-film", "many-recent", "full-frontal", "never-takes", "plays-role", "way-movie", "film-shows", "movie-movie", "kama-sutra", "film-looks", "dantes-peak", "rated-sexuality", "dont-really", "film-quite", "story-without", "quite-few", "youre-looking", "oscar-nomination", "more-entertaining", "spitfire-grill", "best-movie", "fact-theres", "robert-altman", "john-cusack", "philadelphia-festival", "movie-set", "opposite-sex", "characters-never", "including-one", "movie-director", "solid-performances", "pictures-classics", "dark-side", "better-script", "quite-well", "animated-feature", "little-movie", "nothing-less", "content-language", "make-good", "made-sense", "story-characters", "know-last", "love-hate", "top-form", "played-out", "know-more", "movie-ends", "more-films", "actors-play", "sweet-hereafter", "things-going", "more-anything", "film-better", "best-one", "one-much", "those-elements", "festival-world", "citizen-kane", "animated-film", "didnt-care", "film-bad", "film-end", "film-far", "script-based", "easily-one", "theres-plenty", "movie-make", "ive-never", "make-such", "care-characters", "film-french", "billy-crystal", "denis-leary", "although-many", "acceptable-ages", "time-frame", "part-show", "great-movie", "plot-devices", "whole-movie", "first-act", "private-parts", "starring-role", "nudity-running", "visual-style", "105-minutes", "human-drama", "same-level", "film-actually", "alfred-hitchcock", "look-film", "performance-one", "dont-take", "script-full", "sixth-sense", "nudity-adult", "film-trying", "short-film", "situations-profanity", "another-one", "perhaps-one", "over-again", "little-story", "american-audiences", "over-over", "based-play", "liar-liar", "best-director", "genuine-chemistry", "way-another", "good-parts", "john-woo", "comes-out", "energy-level", "lot-time", "shown-philadelphia", "slightly-more", "theres-way", "although-one", "members-audience", "few-lines", "movies-more", "family-values", "previous-film", "reason-care", "through-movie", "action-violence", "night-live", "sony-pictures", "right-wrong", "blood-gore", "weddings-funeral", "rated-little", "sex-profanity", "movie-people", "audience-members", "real-world", "monty-python", "rush-hour", "best-performances", "well-cast", "see-much", "air-force", "more-once", "never-see", "film-nothing", "fully-developed", "one-hand", "best-lines", "same-kind", "quality-film", "cutting-room", "whose-last", "same-name", "better-one", "doesnt-feel", "feature-debut", "best-way", "movie-theater", "director-steven", "attempts-humor", "slightly-different", "those-characters", "keanu-reeves", "films-conclusion", "film-two", "make-audience", "given-more", "completely-different", "extremely-funny", "silence-lambs", "bit-much", "scene-one", "more-little", "force-one", "movie-although", "goes-long", "film-work", "wide-variety", "another-movie", "find-something", "idea-film", "outer-space", "supporting-role", "slapstick-comedy", "carried-away", "talented-cast", "rated-fine", "youve-never", "movie-worth", "austin-powers", "language-mature", "fathers-day", "differences-between", "set-design", "ice-storm", "answer-question", "new-ground", "once-upon", "dance-numbers", "against-type", "tells-story", "movie-becomes", "one-minute", "lead-characters", "lot-people", "movie-actually", "having-fun", "didnt-see", "strikes-back", "film-characters", "little-much", "film-acting", "care-less", "title-film", "enjoy-film", "action-picture", "care-much", "saw-film", "built-around", "michael-keaton", "runs-out", "film-experience", "waynes-world", "funny-lines", "meg-ryan", "vastly-different", "lead-actors", "strong-sexuality", "quite-same", "comedy-drama", "best-moments", "film-come", "second-time", "wanted-make", "film-done", "film-dont", "profanity-sex", "one-person", "one-major", "thing-certain", "script-director", "film-whose", "film-feel", "big-budget", "one-interesting", "title-role", "one-even", "see-more", "even-one", "hard-eight", "usual-suspects", "part-picture", "themes-brief", "high-level", "best-foreign", "one-reason", "more-difficult", "perfect-example", "worth-look", "movie-going", "thats-way", "becomes-clear", "one-moment", "high-concept", "action-thriller", "love-catastrophes", "minutes-movie", "strong-sexual", "chasing-amy", "makes-much", "written-1996", "last-few", "make-seem", "run-out", "surprise-ending", "things-happen", "pokes-fun", "situations-nudity", "car-chases", "youll-find", "dont-miss", "movie-plays", "few-many", "make-want", "less-effective", "time-105", "century-fox", "story-such", "film-year", "seen-through", "story-tell", "story-really", "juliette-lewis", "denzel-washington", "never-more", "film-lacks", "films-last", "based-book", "director-brian", "bad-enough", "music-john", "mel-gibson", "films-more", "sex-scene", "rated-nothing", "history-lesson", "dysfunctional-family", "still-one", "farewell-concubine", "through-entire", "scenes-movie", "barry-levinson", "screenplay-peter", "wesley-snipes", "rated-mild", "films-opening", "male-female", "martin-lawrence", "out-much", "enough-give", "entire-life", "main-problem", "krzysztof-kieslowski", "interesting-enough", "director-roger", "thirty-years", "incorrectly-rated", "feel-sorry", "moments-film", "chain-reaction", "first-half-hour", "film-great", "youd-expect", "much-anything", "dont-ask", "done-before", "rating-sexual", "sliding-doors", "basic-plot", "muriels-wedding", "gives-one", "bunch-movie", "unlike-many", "never-comes", "pointe-blank", "bring-myself", "disney-animated", "nothing-film", "film-both", "few-people", "city-slickers", "more-two", "hollywood-film", "worked-well", "crude-sexual", "fleshed-out", "isnt-good", "friends-wedding", "doesnt-exactly", "around-send", "stage-play", "love-film", "one-half", "two-years", "story-story", "next-time", "red-line", "memorable-lines", "grand-canyon", "doesnt-come", "theres-question", "take-look", "very-hard", "cant-make", "certainly-doesnt", "during-film", "funny-enough", "sling-blade", "film-1/2", "very-different", "con-air", "really-liked", "easy-understand", "january-1997", "many-good", "english-patient", "conflict-between", "chance-see", "given-much", "coming-of-age-story", "film-same", "movie-many", "year-list", "take-time", "both-actors", "actors-playing", "hes-more", "forth-between", "first-glance", "feature-director", "sexuality-fine", "leslie-nielsen", "come-along", "years-best", "richard-gere", "much-plot", "anything-new", "deep-impact", "film-failed", "19th-century", "message-movie", "recent-memory", "characters-make", "become-more", "look-feel", "never-feels", "here-film", "first-time-writer", "john-travolta", "liked-way", "dont-surprised", "doesnt-want", "three-main", "cant-see", "pelican-brief", "big-game", "characters-little", "empire-strikes", "change-pace", "sort-thing", "val-kilmer", "ace-ventura", "big-night", "story-becomes", "absolute-power", "movies-best", "rise-above", "quirky-characters", "everything-seems", "kenneth-branaghs", "come-back", "cats-dogs", "enough-film", "winona-ryder", "release-date", "gene-hackman", "comes-mind", "people-dont", "good-reason", "michelle-pfeiffer", "real-story", "final-analysis", "profanity-drug", "certain-amount", "demi-moore", "female-characters", "far-best", "those-familiar", "arent-enough", "noir-films", "city-angels", "comic-moments", "dustin-hoffman", "little-things", "type-movie", "youll-see", "indiana-jones", "cutting-edge", "noir-thriller", "smile-face", "big-fan", "actors-film", "american-film", "george-jungle", "thin-red", "around-nine", "john-turturro", "far-long", "thing-movie", "probably-best", "moves-along", "little-better", "much-different", "aspect-movie", "twentieth-century", "animated-features", "one-fine", "director-jon", "humor-movie", "grosse-pointe", "age-1/2", "movies-year", "story-didnt", "three-hours", "cautionary-tale", "jackie-brown", "top-rating", "star-film", "femme-fatale", "movie-starts", "air-bud", "wedding-singer", "those-under", "one-key", "movie-gave", "old-men", "more-screen", "film-filled", "before-film", "comedy-film", "same-thing", "doesnt-give", "show-give", "virtually-impossible", "acting-good", "story-makes", "very-long", "very-few", "gwyneth-paltrow", "seven-years", "makes-movie", "situations-violence", "way-story", "1/2-star", "computer-generated", "many-great", "much-energy", "performance-film", "wings-desire", "forty-five-minutes", "around-corner", "interesting-story", "real-problem", "find-one", "whole-thing", "line-fire", "easily-best", "spike-lee", "first-one", "mild-language", "time-see", "room-floor", "years-later", "pointed-out", "laughably-bad", "hollywood-pictures", "really-isnt", "films-many", "feels-more", "bring-out", "movie-well", "samuel-jackson", "without-resorting", "kevin-smith", "came-out", "darn-cat", "film-nevertheless", "director-paul", "long-line", "out-movie", "dramatic-music", "more-human", "solid-entertainment", "dead-man", "farrelly-brothers", "didnt-work", "youd-think", "young-kids", "shall-dance", "worth-recommending", "sexual-references", "drew-barrymore", "woody-allens", "cant-quite", "strong-performance", "well-enough", "heavenly-creatures", "dark-city", "whose-previous", "power-rangers", "looking-richard", "love-jones", "masterpiece-theater", "miracle-34th", "more-appealing", "original-movie", "nice-job", "sean-penn", "animated-movie", "body-language", "although-few", "film-critic", "seems-little", "jingle-way", "look-one", "last-picture", "witch-project", "rating-nudity", "black-hat", "many-others", "stock-characters", "really-funny", "more-passing", "billy-bob", "screenplay-michael", "politically-incorrect", "first-major", "work-one", "connection-between", "things-dont", "seen-one", "kids-show", "didnt-think", "third-act", "cannes-film", "american-beauty", "many-lines", "talking-heads", "another-example", "younger-kids", "seen-more", "much-attention", "good-looking", "cartoonish-violence", "times-movie", "final-credits", "film-always", "film-left", "kevin-williamson", "movie-find", "story-gets", "something-different", "gratuitous-violence", "written-december", "much-happens", "needs-more", "movie-great", "liked-film", "small-role", "first-minutes", "welcome-dollhouse", "film-over", "probably-pg-13", "oscar-nominations", "two-three", "bad-idea", "joy-luck", "make-laugh", "film-think", "hardly-wait", "very-difficult", "monster-movie", "movie-stars", "disaster-movie", "little-bad", "way-around", "work-film", "show-more", "second-act", "much-going", "extremely-effective", "los-angeles", "larry-flynt", "better-films", "completely-satisfying", "theres-denying", "action-flick", "movie-same", "look-back", "come-surprise", "short-story", "walt-disney", "34th-street", "straight-face", "feels-much", "screenplay-robert", "carry-film", "times-film", "good-gets", "principal-characters", "line-features", "wonder-whether", "made-one", "everyone-film", "major-league", "becomes-apparent", "good-laughs", "little-picture", "written-august", "bad-one", "foreign-language", "make-one", "private-ryan", "theres-very", "point-story", "men-black", "spanish-english", "twelve-monkeys", "given-opportunity", "cant-hardly", "rated-mpaa", "film-manages", "thin-story", "script-makes", "more-traditional", "hoop-dreams", "make-story", "second-film", "isnt-anything", "tries-make", "people-film", "offers-few", "things-considered", "bogs-down", "115-minutes", "groundhog-day", "being-made", "many-critics", "movie-opens", "runs-way", "addams-family", "more-recent", "movie-few", "late-film", "life-story", "seem-much", "110-minutes", "profanity-mature", "one-story", "figured-out", "even-given", "film-certain", "wild-things", "raging-bull", "audience-film", "dances-wolves", "new-wave", "enough-time", "movie-making", "camera-shots", "more-story", "george-clooney", "far-many", "keeps-film", "such-film", "entire-picture", "fine-mature", "kids-son", "lines-dialogue", "secrets-lies", "people-want", "myself-recommend", "under-skin", "director-rob", "saving-private", "hard-find", "considerably-more", "basic-premise", "sean-connery", "surprisingly-effective", "story-even", "makes-wonder", "done-better", "director-barry", "younger-viewers", "one-worth", "even-story", "put-sleep", "makes-good", "cant-think", "one-mans", "those-want", "lee-jones", "jeff-bridges", "punch-line", "hard-make", "makes-think", "probably-more", "rating-one", "early-scenes", "once-warriors", "far-between", "bottom-line", "last-time", "mood-film", "worth-mentioning", "lone-star", "sometimes-funny", "cant-seem", "one-three", "roller-coaster", "romantic-interest", "still-manages", "out-control", "work-even", "interesting-film", "out-welcome", "much-character", "glued-screen", "laugh-track", "character-movie", "more-character", "bogged-down", "really-bad", "show-much", "foreign-film", "certainly-one", "beautifully-photographed", "interesting-watch", "heart-film", "both-good", "performance-here", "much-made", "theatrical-release", "upon-time", "one-things", "appropriate-teenagers", "danny-devito", "brief-language", "grumpy-old", "shanghai-triad", "one-easily", "seemed-more", "especially-one", "completely-predictable", "need-more", "something-out", "belly-laughs", "one-level", "between-good", "hard-see", "lack-thereof", "more-satisfying", "characters-movie", "know-story", "characters-arent", "nc-17-rating", "lethal-weapon", "thats-case", "tension-between", "even-movie", "over-hour", "action-movie", "cemetery-man", "way-make", "bugs-life", "film-series", "gives-movie", "strong-sense", "sharon-stone", "comic-violence", "those-expecting", "one-problems", "charlie-chan", "writing-directing", "screenplay-richard", "luck-club", "human-condition", "failed-attempts", "natural-born", "mars-attacks", "picture-perfect", "one-reasonably", "more-believable", "emotional-depth", "focal-point", "female-nudity", "ends-being", "physical-humor", "picture-fine", "amount-time", "script-written", "chris-odonnell", "movie-going-experience", "subtitles-film", "much-recommend", "great-performance", "much-worse", "suspense-film", "simply-put", "movie-version", "great-director", "many-levels", "shock-value", "new-line", "beavis-butt-head", "shallow-grave", "sex-brief", "give-away", "kevin-kline", "compelling-characters", "character-depth", "out-such", "number-one", "never-clear", "tim-roth", "drink-man", "audience-movie", "two-minutes", "john-williams", "film-thought", "reality-bites", "recent-movie", "fight-sequences", "movie-see", "screwball-comedy", "gives-way", "black-humor", "fellow-americans", "much-screen", "cut-out", "thoroughly-enjoyable", "right-direction", "brand-humor", "performance-makes", "work-out", "body-count", "shadow-conspiracy", "last-half", "costume-drama", "three-times", "one-makes", "best-year", "best-friend", "much-humor", "adult-humor", "feeling-minnesota", "rock-roll", "things-film", "humor-film", "movie-gives", "supporting-actor", "nearly-much", "make-even", "tommy-lee", "opportunity-see", "youre-watching", "director-martin", "doing-something", "probably-find", "everyone-involved", "seen-many", "cinematic-experience", "pierce-brosnan", "one-hope", "old-feeling", "know-whether", "bad-boys", "story-still", "cute-little", "keep-viewers", "good-taste", "know-characters", "atom-egoyan", "character-doesnt", "stay-away", "triumph-over", "blues-brothers", "film-less", "movie-feel", "movie-probably", "take-much", "nothing-remotely", "last-part", "one-see", "show-even", "alan-parker", "different-way", "land-before", "film-especially", "cast-includes", "genre-film", "people-involved", "isnt-movie", "small-talk", "howards-end", "director-alan", "easy-follow", "legends-fall", "fine-performance", "recent-film", "lowell-ganz", "movie-long", "never-even", "spends-much", "scenes-together", "latter-category", "time-travel", "movie-keeps", "clear-present", "american-pie", "morgan-freeman", "story-two", "seen-trailers", "films-even", "film-uses", "thus-far", "few-memorable", "dream-sequences", "long-stretches", "story-takes", "recommend-anyone", "done-much", "really-care", "kiss-death", "ghost-darkness", "films-ending", "uses-word", "hard-time", "script-never", "those-few", "characters-relationships", "character-played", "lines-film", "time-100", "bits-pieces", "leonardo-dicaprio", "warner-bros", "very-very", "those-occasions", "touchstone-pictures", "much-part", "sort-way", "pg-13-little", "didnt-much", "way-characters", "though-story", "lost-souls", "present-danger", "need-know", "before-time", "ordinary-people", "eat-drink", "mike-leigh", "big-city", "important-thing", "movie-easily", "those-arent", "out-character", "really-know", "course-film", "director-kevin", "out-those", "fall-asleep", "wanted-see", "more-importantly", "plays-more", "seems-designed", "didnt-take", "first-scene", "really-need", "kind-role", "classification-rated", "even-little", "june-1997", "more-energy", "animated-films", "theres-always", "within-bellcore", "light-comedy", "throughout-movie", "york-city", "above-represents", "war-films", "ill-anything", "one-seems", "worst-movie", "joel-schumacher", "funny-movie", "well-developed", "good-old-fashioned", "script-more", "king-hill", "johnny-depp", "enjoyable-film", "road-picture", "story-theres", "amusement-park", "hollow-reed", "both-characters", "single-character", "leave-beaver", "central-characters", "one-never", "those-bellcore", "king-kong", "life-isnt", "film-loses", "jerry-bruckheimer", "final-act", "films-first", "plot-points", "right-place", "trying-find", "couldnt-help", "stanley-tucci", "october-films", "put-much", "individual-scenes", "pg-13-sex", "cuss-words", "author-necessarily", "trying-hard", "funny-even", "never-developed", "memorable-moments", "never-fully", "thats-part", "both-movies", "earlier-year", "time-develop", "courtroom-drama", "direction-film", "ron-howard", "little-ones", "elements-film", "next-film", "time-time", "come-life", "rating-mild", "somewhere-along", "special-effect", "rises-above", "rating-adult", "more-depth", "central-theme", "few-far", "new-version", "film-before", "especially-liked", "lawrence-kasdan", "film-begins", "final-half", "serious-film", "brothers-mcmullen", "better-movies", "water-chocolate", "second-feature", "life-one", "richard-lagravenese", "movie-based", "ten-years", "taxi-driver", "organization-within", "last-seduction", "films-success", "robin-hood", "point-movie", "violence-brief", "right-thing", "film-easy", "material-work", "director-christopher", "twist-fate", "difficult-watch", "profanity-show", "find-anything", "fact-film", "movie-needs", "better-more", "particularly-interesting", "kansas-city", "make-think", "real-reason", "something-thats", "movie-cant", "fresh-air", "again-again", "sound-music", "movie-come", "isnt-worth", "carefully-constructed", "even-without", "interesting-see", "makes-picture", "time-place", "spending-time", "more-substance", "know-much", "more-focused", "ivan-reitman", "shows-more", "sylvester-stallone", "really-matter", "lot-going", "film-love", "mike-nichols", "glenn-close", "character-one", "merchant-ivory", "movie-goes", "brief-violence", "kiss-girls", "humor-comes", "straight-man", "male-nudity", "place-film", "love-triangle", "wes-craven", "steven-soderbergh", "sure-whether", "bellcore-organization", "keep-film", "film-school", "film-completely", "those-looking", "red-rock", "very-end", "first-thing", "made-even", "enough-see", "rating-mature", "born-killers", "holiday-season", "real-star", "shes-lovely", "movie-better", "movie-filmed", "story-made", "really-doesnt", "picture-rated", "makes-look", "forty-minutes", "much-way", "human-story", "one-argue", "written-1997", "boyz-hood", "part-one", "out-theater", "san-francisco", "harvey-keitel", "necessarily-those", "kids-probably", "hard-take", "funny-scenes", "directors-cut", "one-greatest", "book-one", "dont-much", "rocky-bullwinkle", "nuanced-performance", "school-seniors", "whoopi-goldberg", "never-know", "makes-seem", "plot-threads", "emotional-response", "bad-performance", "spends-time", "many-plot", "satisfying-film", "come-through", "represents-opinions", "interesting-characters", "tom-shadyac", "quiz-show", "movie-time", "odd-couple", "quite-enough", "explicit-sex", "even-minor", "missed-opportunities", "pleasant-surprise", "sometimes-even", "found-movie", "film-recommend", "lost-space", "fact-one", "film-tried", "beauty-film", "without-even", "eves-bayou", "director-mark", "terminal-velocity", "big-deal", "sympathetic-character", "give-single", "new-zealand", "running-gag", "acceptable-high", "look-forward", "goes-beyond", "nice-moments", "simple-wish", "technical-aspects", "films-second", "find-much", "twelfth-night", "film-couldnt", "whole-wide", "hard-enough", "picture-thats", "high-quality", "opinions-author", "cant-believe", "glenn-gould", "one-exception", "willing-take", "ability-make", "worst-thing", "brad-pitt", "exactly-same", "brady-sequel", "robert-altmans", "bill-murray", "makes-character", "entry-genre", "rated-pervasive", "tammy-faye", "american-history", "adventure-film", "much-films", "virtual-reality", "line-dialogue", "nearly-two", "use-word", "certain-aspects", "never-heard", "movie-think", "going-make", "picture-even", "young-actors", "hope-see", "eyes-ears", "role-one", "inventing-abbotts", "ralph-fiennes", "nearly-scene", "space-jam", "ang-lee", "plot-character", "really-want", "picture-comes", "nothing-wrong", "final-product", "bill-pullman", "deft-touch", "morality-tale", "thats-right", "edward-zwick", "film-directed", "time-trying", "film-succeeds", "robert-redford", "sex-film", "one-hundred-minutes", "especially-considering", "film-played", "much-substance", "big-time", "film-another", "profanity-film", "plot-holes", "good-spirited", "addicted-love", "anything-film", "rare-occasions", "king-george", "without-single", "event-horizon", "very-brady", "know-better", "wait-until", "couldnt-more", "film-leaves", "woody-harrelson", "fierce-creatures", "cinema-paradiso", "around-edges", "rarely-seen", "rated-few", "james-newton", "always-good", "wanted-film", "movie-big", "movie-far", "cinematography-john", "side-story", "talented-director", "couple-scenes", "hav-plenty", "bridget-fonda", "such-bad", "romy-michele", "more-common", "story-little", "two-best", "country-film", "wrong-way", "funny-scene", "still-something", "documentary-style", "probably-enjoy", "script-one", "genuinely-funny", "patch-adams", "audience-feel", "lets-hope", "tom-cruise", "film-history", "feel-more", "think-much", "ive-always", "deep-rising", "reason-film", "edge-seats", "emotional-resonance", "screen-adaptation", "true-romance", "plot-twist", "soap-operas", "more-life", "many-jokes", "trigger-effect", "supporting-actress", "surprise-film", "though-one", "few-characters", "war-film", "mixed-bag", "takes-few", "kids-ten", "arent-nearly", "poorly-written", "slasher-movie", "director-joe", "film-hard", "tin-cup", "director-tom", "broadcast-news", "walked-out", "steven-spielbergs", "little-buddha", "keen-sense", "movie-characters", "dazed-confused", "comic-timing", "typical-hollywood", "makes-easy", "small-screen", "quite-effective", "conspiracy-theory", "full-energy", "movie-quite", "world-film", "worth-effort", "home-movie", "character-arc", "self-deprecating-humor", "good-see", "more-intriguing", "behind-camera", "younger-ones", "time-period", "one-look", "fact-movie", "bad-words", "old-fashioned", "except-one", "oscar-wilde", "work-best", "humor-language", "kissing-fool", "classic-film", "james-woods", "runs-fast", "whole-film", "harold-ramis", "well-made", "one-part", "coming-out", "know-one", "film-real", "story-make", "much-one", "characters-whose", "life-movie", "never-feel", "isnt-very", "dead-bodies", "think-one", "characters-even", "films-film", "john-grisham", "movie-certainly", "tone-poem", "drawn-out", "enough-material", "more-movie", "strongest-recommendation", "star-show", "much-stronger", "wide-world", "music-film", "time-115", "look-away", "having-seen", "films-central", "film-perhaps", "violence-drug", "makes-sure", "one-suspects", "comic-books", "try-hard", "director-joel", "during-films", "film-easily", "lead-actor", "actually-one", "larger-life", "cabin-boy", "under-siege", "well-one", "particularly-funny", "art-form", "looks-great", "real-character", "movie-very", "whatever-reason", "those-willing", "keeps-audience", "umbrellas-cherbourg", "made-seem", "something-new", "plot-point", "song-dance", "time-theres", "quite-mature", "long-kiss", "final-half-hour", "cant-imagine", "written-over", "film-features", "done-well", "major-problem", "summer-movie", "find-many", "rings-true", "feel-something", "mrs-doubtfire", "find-more", "minute-film", "film-festivals", "sister-act", "deconstructing-harry", "exactly-one", "out-even", "individual-moments", "way-many", "film-genre", "going-end", "anyone-seen", "going-see", "looking-forward", "funny-script", "one-little", "middle-ground", "film-audience", "thats-problem", "strong-cast", "sense-being", "piece-entertainment", "two-girls", "gets-little", "one-sense", "simple-twist", "violence-mature", "many-years", "star-power", "pretty-woman", "subtle-humor", "cinema-running", "unqualified-success", "overly-long", "movie-those", "film-gives", "high-society", "enjoy-movie", "kids-ages", "know-exactly", "presented-here", "bye-bye", "teenagers-although", "one-shows", "faint-praise", "out-left", "little-girl", "story-seemed", "arguably-best", "difficult-task", "more-involving", "previous-efforts", "isnt-going", "poke-fun", "never-thought", "dalai-lama", "over-past", "being-film", "enough-good", "give-credit", "trip-theater", "enough-here", "whose-performance", "vietnam-war", "wont-find", "film-sometimes", "looking-film", "one-quite", "music-david", "little-kids", "distributor-new", "little-doubt", "nice-people", "story-between", "godfather-part", "couple-years", "video-store", "stay-awake", "young-people", "giving-1/2", "violent-scenes", "cult-classic", "drama-comedy", "nice-see", "more-obvious", "isnt-especially", "junior-high", "viewing-experience", "cheap-out", "ganz-babaloo", "susan-sarandon", "several-years", "cheap-thrills", "princess-mononoke", "film-debut", "roland-emmerich", "film-basically", "film-several", "screen-one", "big-lebowski", "profanity-sexuality", "written-script", "personal-favorite", "makes-little", "favorite-part", "indie-film", "walk-moon", "half-star", "movies-many", "academy-awards", "make-point", "local-multiplex", "film-become", "believe-one", "attention-span", "make-films", "movie-lot", "film-instead", "movie-now", "125-minutes", "jokes-work", "edward-norton", "cries-out", "done-without", "movie-way", "memorable-film", "more-palatable", "oscar-consideration", "fascinating-character", "films-theme", "real-mccoy", "such-way", "easy-way", "director-writer", "fatal-instinct", "kids-nine", "madness-king", "little-women", "thrown-good", "films-french", "film-people", "urban-legend", "hour-movie", "body-work", "out-sight", "good-example", "fine-day", "action-figures", "dramatic-impact", "such-case", "poor-quality", "adrenaline-pumping", "wrong-movie", "more-conventional", "attempt-make", "sense-place", "searching-bobby", "latest-film", "enough-movie", "lot-better", "san-joses", "one-several", "hold-attention", "tango-lesson", "one-problem", "cinematic-equivalent", "film-enough", "mel-brooks", "fleshing-out", "picture-never", "one-funniest", "nine-son", "know-film", "hanging-out", "color-night", "film-looking", "characters-one", "director-andrew", "young-actress", "extremely-well", "takes-many", "biggest-surprise", "see-picture", "good-films", "social-satire", "rob-roy", "without-having", "director-harold", "one-first", "never-one", "war-violence", "improvement-over", "supposed-funny", "innuendo-fine", "before-movie", "well-film", "give-show", "those-seen", "finished-product", "violence-little", "dont-wrong", "two-women", "movie-dont", "rock-west", "two-more", "character-more", "original-script", "francis-ford", "different-kind", "foreign-films", "plot-characters", "parts-story", "flesh-out", "out-story", "film-last", "story-full", "big-chill", "theme-film", "thematic-material", "story-goes", "make-compelling", "good-old", "getting-know", "mild-violence", "one-man", "make-clear", "down-pat", "kiss-goodnight", "dont-come", "better-job", "having-good", "make-look", "lose-track", "falls-back", "jungle-jungle", "one-make", "director-seems", "scene-scene", "possible-exception", "scenes-show", "chase-scene", "film-anything", "bad-good", "plot-development", "scenes-such", "drop-zone", "preachers-wife", "expect-more", "one-wonder", "better-served"};

	//2000--public static String[] bigramList={"films-year",  "see-film",  "motion-picture",  "film-excellent",  "movie-kind",  "waste-money",  "average-movie",  "dont-waste",  "show-dont",  "excellent-show",  "show-look",  "kind-enjoyable",  "enjoyable-poor",  "poor-show",  "look-average",  "opinions-expressed",  "meant-reflect",  "mine-meant",  "reflect-employers",  "expressed-mine",  "running-time",  "few-films",  "one-worst",  "worst-films",  "message-subject",  "reply-message",  "details-reply",  "one-top",  "money-one",  "year-see",  "totally-unbearable",  "year-totally",  "top-few",  "rated-pg-13",  "mpaa-rating",  "subject-line",  "much-more",  "even-though",  "special-effects",  "even-more",  "little-more",  "adult-themes",  "unbearable-opinions",  "fine-kids",  "screening-room",  "son-jeffrey",  "see-screening",  "subject-subscribe",  "room-details",  "much-better",  "fine-teenagers",  "one-those",  "kids-around",  "sex-nudity",  "see-moviepage",  "moviepage-details",  "line-subscribe",  "jeffrey-age",  "painfully-unbearable",  "money-totally",  "unbearable-picture",  "totally-painfully",  "sexual-situations",  "turns-out",  "older-teenagers",  "english-subtitles",  "theres-nothing",  "review-written",  "romantic-comedy",  "film-one",  "word-subscribe",  "letter-word",  "subscribe-subject",  "send-letter",  "acceptable-teenagers",  "screen-time",  "motion-pictures",  "running-length",  "love-story",  "character-study",  "film-makers",  "mature-themes",  "two-hours",  "far-more",  "subject-matter",  "between-two",  "runs-rated",  "acceptable-older",  "chemistry-between",  "one-thing",  "action-sequences",  "film-more",  "first-time",  "bad-language",  "character-development",  "brief-nudity",  "themes-running",  "supporting-cast",  "one-best",  "theres-something",  "rated-violence",  "profanity-adult",  "rating-pg-13",  "violence-profanity",  "star-wars",  "film-fine",  "picture-opinions",  "figure-out",  "time-minutes",  "acceptable-kids",  "language-acceptable",  "give-1/2",  "academy-award",  "nudity-violence",  "high-school",  "part-film",  "science-fiction",  "writer-director",  "first-half",  "1/2-one",  "film-made",  "box-office",  "action-film",  "main-characters",  "dont-know",  "last-years",  "more-interesting",  "subtitles-rated",  "one-many",  "great-deal",  "best-part",  "film-doesnt",  "along-way",  "doesnt-seem",  "theres-much",  "rating-profanity",  "bad-guys",  "unbearable-review",  "dont-think",  "takes-place",  "relationship-between",  "youve-seen",  "give-film",  "very-little",  "woody-allen",  "long-rated",  "big-screen",  "many-scenes",  "pulp-fiction",  "isnt-much",  "years-ago",  "movie-one",  "new-york",  "rated-strong",  "runs-long",  "director-john",  "want-see",  "see-movie",  "many-times",  "rated-sex",  "something-more",  "film-noir",  "one-more",  "worth-seeing",  "half-hour",  "ingmar-bergman",  "film-festival",  "never-quite",  "many-ways",  "doesnt-make",  "long-time",  "rated-language",  "bit-more",  "much-time",  "film-never",  "soap-opera",  "dont-want",  "movie-nothing",  "film-even",  "one-films",  "second-half",  "film-rated",  "nothing-more",  "kind-film",  "black-white",  "very-good",  "1997-opinions",  "make-sense",  "robin-williams",  "theres-little",  "make-film",  "one-few",  "profanity-violence",  "part-movie",  "one-scene",  "1/2-see",  "never-seen",  "sit-through",  "found-myself",  "film-making",  "film-much",  "picture-review",  "black-comedy",  "die-hard",  "film-makes",  "one-film",  "movie-rated",  "lot-more",  "screen-presence",  "profanity-fine",  "down-david",  "belief-movie",  "david-puttnam",  "nothing-life",  "sexual-content",  "people-neutral",  "makes-film",  "leave-down",  "neutral-leave",  "leaves-people",  "leave-leave",  "life-leaves",  "made-film",  "very-funny",  "theres-lot",  "very-much",  "give-one",  "enough-make",  "drug-use",  "based-novel",  "star-trek",  "written-directed",  "two-leads",  "one-point",  "action-films",  "pg-13-profanity",  "anything-more",  "film-takes",  "drug-usage",  "horror-film",  "ive-seen",  "sense-humor",  "doesnt-take",  "violence-language",  "put-together",  "film-maker",  "pg-13-violence",  "comic-relief",  "jurassic-park",  "feature-film",  "best-thing",  "nudity-profanity",  "first-place",  "film-film",  "theres-enough",  "plot-device",  "quite-good",  "violence-running",  "seen-before",  "movie-isnt",  "reason-see",  "doesnt-much",  "profanity-running",  "movie-more",  "without-being",  "violence-fine",  "many-characters",  "opening-credits",  "tell-story",  "doesnt-work",  "sight-gags",  "bad-movie",  "good-film",  "once-again",  "teenagers-send",  "kind-movie",  "real-life",  "action-scenes",  "plot-twists",  "age-gave",  "those-films",  "physical-comedy",  "fairy-tale",  "show-fine",  "find-yourself",  "film-director",  "theres-one",  "seems-more",  "one-another",  "good-enough",  "great-film",  "first-film",  "mpaa-classification",  "turn-out",  "much-fun",  "true-story",  "bad-guy",  "entertainment-value",  "old-enough",  "more-interested",  "recommend-give",  "fifteen-minutes",  "one-expect",  "one-character",  "fine-older",  "recommend-film",  "length-mpaa",  "hard-believe",  "good-movie",  "way-through",  "mature-teenagers",  "comic-book",  "rest-movie",  "rated-profanity",  "leave-theater",  "around-son",  "sitting-through",  "film-isnt",  "taking-place",  "same-time",  "even-better",  "rest-film",  "correctly-rated",  "director-robert",  "french-english",  "entire-movie",  "ensemble-cast",  "one-two",  "happy-ending",  "theres-more",  "waste-time",  "tries-hard",  "fine-line",  "romantic-comedies",  "throughout-film",  "come-out",  "violence-acceptable",  "profanity-sexual",  "many-films",  "pretty-good",  "never-really",  "men-women",  "much-film",  "make-sure",  "film-very",  "story-told",  "point-out",  "supporting-characters",  "doesnt-really",  "television-series",  "themes-profanity",  "story-itself",  "first-hour",  "story-film",  "film-works",  "story-line",  "story-more",  "james-bond",  "mission-impossible",  "family-film",  "serial-killer",  "entire-film",  "unbearable-reviewed",  "good-time",  "few-minutes",  "action-hero",  "quentin-tarantino",  "reviewed-written",  "director-peter",  "lion-king",  "schindlers-list",  "toy-story",  "making-film",  "telling-story",  "rated-probably",  "times-before",  "gives-film",  "give-see",  "movie-made",  "main-character",  "film-itself",  "even-those",  "more-effective",  "recommend-movie",  "feel-good",  "ten-minutes",  "manages-make",  "more-one",  "hour-half",  "movie-never",  "film-many",  "five-minutes",  "whole-lot",  "film-seems",  "love-affair",  "best-film",  "kids-under",  "film-good",  "low-budget",  "film-without",  "movie-doesnt",  "doesnt-know",  "visual-effects",  "many-people",  "recommend-picture",  "twenty-minutes",  "trying-make",  "romance-between",  "more-impressive",  "home-alone",  "best-performance",  "perhaps-best",  "ages-son",  "quite-funny",  "1995-opinions",  "1996-opinions",  "very-well",  "out-film",  "makes-sense",  "good-sense",  "twists-turns",  "human-beings",  "closing-credits",  "end-film",  "minutes-film",  "see-one",  "part-story",  "bad-film",  "thumbs-down",  "screenplay-david",  "without-much",  "both-sides",  "nudity-sex",  "age-thought",  "better-film",  "length-rated",  "sexuality-acceptable",  "film-give",  "cant-help",  "film-offers",  "musical-numbers",  "independence-day",  "director-michael",  "little-bit",  "end-credits",  "story-one",  "director-david",  "out-one",  "gave-film",  "film-little",  "rating-violence",  "high-energy",  "out-loud",  "thirty-minutes",  "source-material",  "well-worth",  "same-way",  "whats-going",  "film-ends",  "set-pieces",  "give-movie",  "more-time",  "dont-care",  "one-better",  "first-part",  "fun-watch",  "point-view",  "recommend-show",  "press-screening",  "way-film",  "slice-life",  "rest-cast",  "problem-film",  "think-film",  "ninety-minutes",  "point-film",  "award-1/2",  "few-scenes",  "noir-film",  "entertaining-film",  "film-comes",  "movie-itself",  "few-times",  "little-profanity",  "line-between",  "one-great",  "many-movies",  "target-audience",  "despite-being",  "steven-seagal",  "sexuality-language",  "films-one",  "although-film",  "strong-violence",  "take-place",  "violence-sex",  "half-film",  "characters-situations",  "pretty-much",  "language-violence",  "although-movie",  "easy-see",  "silicon-valley",  "title-character",  "make-movie",  "violence-adult",  "film-those",  "few-good",  "last-act",  "fine-teenager",  "ending-credits",  "suspension-disbelief",  "fair-amount",  "back-forth",  "pg-13-sexual",  "difference-between",  "havent-seen",  "seem-more",  "two-films",  "bond-films",  "doesnt-quite",  "seeing-film",  "pop-culture",  "horror-films",  "walk-out",  "good-one",  "one-one",  "wonderful-life",  "though-film",  "turned-out",  "credits-roll",  "find-film",  "date-released",  "movie-takes",  "good-idea",  "more-important",  "especially-those",  "work-well",  "jackie-chan",  "strong-language",  "older-mature",  "story-doesnt",  "between-art",  "many-viewers",  "human-being",  "something-mary",  "much-less",  "film-well",  "camera-work",  "time-film",  "drug-content",  "bruce-willis",  "time-around",  "lot-fun",  "first-time-director",  "something-between",  "written-january",  "themes-violence",  "beginning-end",  "film-probably",  "long-enough",  "century-theaters",  "hong-kong",  "language-fine",  "piece-work",  "few-moments",  "out-place",  "art-films",  "1994-opinions",  "film-acceptable",  "facial-expressions",  "pg-13-brief",  "short-cuts",  "watching-movie",  "recent-films",  "film-becomes",  "two-characters",  "anthony-hopkins",  "much-movie",  "martin-scorsese",  "miramax-films",  "one-good",  "jean-luc-godard",  "many-different",  "violence-sexual",  "sexual-humor",  "movie-makes",  "directorial-debut",  "time-movie",  "good-guys",  "fine-ages",  "parts-movie",  "best-picture",  "one-reasons",  "picture-give",  "live-action",  "funny-moments",  "clint-eastwood",  "amc-century",  "minor-characters",  "social-commentary",  "film-gets",  "film-really",  "teenagers-recommend",  "good-job",  "works-best",  "one-favorite",  "mild-profanity",  "thought-movie",  "doesnt-mean",  "horror-movie",  "nudity-language",  "such-films",  "characters-film",  "few-years",  "more-serious",  "films-made",  "art-life",  "pg-13-adult",  "warner-brothers",  "thematic-elements",  "dont-see",  "forrest-gump",  "life-piece",  "far-less",  "thing-film",  "cinema-both",  "life-takes",  "language-drug",  "movie-fine",  "cinema-something",  "bad-taste",  "straight-out",  "weve-seen",  "last-summer",  "film-see",  "film-critics",  "situations-adult",  "make-mistake",  "long-way",  "few-more",  "movie-runs",  "violence-film",  "films-life",  "themes-sexual",  "violence-bad",  "parts-film",  "come-close",  "nudity-sexual",  "sex-violence",  "both-gives",  "unlike-painting",  "painting-literature",  "press-kit",  "cinema-art",  "cinema-slice",  "piece-cake",  "emotional-impact",  "life-unlike",  "film-didnt",  "film-still",  "literature-cinema",  "arent-many",  "takes-jean-luc",  "film-cant",  "more-few",  "watching-film",  "well-done",  "never-seems",  "good-bad",  "gave-1/2",  "one-way",  "make-more",  "becomes-more",  "jim-carrey",  "film-set",  "gives-life",  "first-movie",  "movie-filled",  "life-cinema",  "find-out",  "really-good",  "central-character",  "good-evil",  "plot-elements",  "sexual-innuendo",  "sandra-bullock",  "movie-thats",  "van-damme",  "united-states",  "story-never",  "few-laughs",  "film-best",  "little-mermaid",  "character-film",  "loose-ends",  "worth-caring",  "starship-troopers",  "steven-spielberg",  "classification-mpaa",  "isnt-nearly",  "type-film",  "mild-thumbs",  "nothing-special",  "make-much",  "acting-ability",  "very-bad",  "good-thing",  "film-thats",  "films-best",  "enough-recommend",  "last-year",  "many-more",  "enough-interested",  "valley-showing",  "film-opens",  "much-same",  "start-finish",  "smart-enough",  "doesnt-offer",  "problem-movie",  "best-known",  "better-movie",  "certainly-isnt",  "sort-movie",  "worth-price",  "doesnt-matter",  "pg-13-language",  "little-long",  "theaters-send",  "dumb-dumber",  "those-dont",  "content-acceptable",  "saving-grace",  "movie-bad",  "beauty-beast",  "film-story",  "more-fun",  "sex-scenes",  "rated-nudity",  "isnt-bad",  "film-version",  "doesnt-even",  "reservoir-dogs",  "doesnt-help",  "period-piece",  "rated-brief",  "film-seem",  "film-seen",  "film-such",  "way-out",  "out-way",  "even-worse",  "youre-going",  "production-values",  "film-tries",  "art-house",  "oliver-stone",  "script-doesnt",  "each-one",  "pleasant-enough",  "long-before",  "many-things",  "itself-seriously",  "fine-job",  "slow-motion",  "film-first",  "those-rare",  "take-long",  "language-film",  "year-old",  "one-long",  "much-sense",  "language-sexual",  "dont-make",  "didnt-know",  "situations-running",  "much-story",  "works-well",  "best-films",  "films-such",  "romeo-juliet",  "aspect-ratio",  "debut-feature",  "those-enjoy",  "far-better",  "films-title",  "pg-13-mature",  "blair-witch",  "fine-kid",  "gave-movie",  "kenneth-branagh",  "best-work",  "films-end",  "movie-best",  "makes-one",  "more-compelling",  "more-plot",  "found-film",  "fifth-element",  "starts-out",  "makes-feel",  "see-show",  "movie-good",  "showing-amc",  "price-admission",  "read-book",  "perhaps-more",  "made-more",  "rest-picture",  "those-scenes",  "tom-hanks",  "camera-angles",  "rated-mature",  "didnt-seem",  "everyone-love",  "john-hughes",  "nothing-offend",  "scene-film",  "man-woman",  "under-fire",  "end-movie",  "two-stars",  "time-director",  "little-violence",  "isnt-enough",  "more-film",  "first-feature",  "edge-seat",  "real-people",  "arnold-schwarzenegger",  "simple-story",  "last-film",  "nudity-acceptable",  "both-films",  "film-goes",  "isnt-particularly",  "thought-film",  "picture-one",  "christopher-walken",  "none-characters",  "strongly-recommend",  "age-innocence",  "check-out",  "language-brief",  "one-time",  "harrison-ford",  "film-seemed",  "scenes-between",  "themes-fine",  "two-people",  "long-film",  "time-one",  "von-trier",  "batman-robin",  "film-based",  "interaction-between",  "part-problem",  "production-design",  "good-news",  "big-laughs",  "even-less",  "little-film",  "during-course",  "recent-years",  "everything-film",  "character-interaction",  "previous-films",  "show-one",  "through-film",  "paramount-pictures",  "tour-force",  "something-special",  "little-time",  "seen-film",  "kids-age",  "film-although",  "car-chase",  "one-years",  "hard-imagine",  "audiences-attention",  "small-part",  "film-make",  "left-theater",  "much-ado",  "makes-more",  "film-moves",  "runs-little",  "movie-much",  "award-nomination",  "award-winning",  "dont-mind",  "supporting-players",  "offend-anyone",  "few-nice",  "more-subtle",  "going-through",  "theres-reason",  "movie-year",  "even-film",  "stand-out",  "movie-works",  "strong-enough",  "punch-lines",  "worth-watching",  "sort-film",  "rest-story",  "film-something",  "nice-guy",  "movie-without",  "lost-world",  "takes-itself",  "cast-members",  "courage-under",  "film-wasnt",  "good-intentions",  "dark-comedy",  "rated-nc-17",  "film-plays",  "isnt-even",  "movie-seems",  "more-more",  "strong-performances",  "twenty-years",  "lead-character",  "fast-paced",  "movie-really",  "movie-even",  "give-thumbs",  "screenplay-john",  "story-much",  "large-part",  "written-june",  "never-made",  "brady-bunch",  "steve-martin",  "david-mamet",  "spend-time",  "high-points",  "french-subtitles",  "life-film",  "perfectly-cast",  "original-film",  "good-looks",  "nudity-bad",  "isnt-quite",  "great-fun",  "video-game",  "julia-roberts",  "notre-dame",  "film-going",  "more-enough",  "best-scenes",  "two-movies",  "theres-never",  "kevin-costner",  "del-toro",  "going-happen",  "cross-between",  "sweet-little",  "theatrical-aspect",  "human-nature",  "another-film",  "breaking-waves",  "far-much",  "before-sunrise",  "cant-even",  "right-down",  "kids-movie",  "giving-film",  "film-certainly",  "john-sayles",  "film-worth",  "interesting-character",  "award-one",  "movies-one",  "story-isnt",  "last-seen",  "written-october",  "violence-nudity",  "profanity-brief",  "saturday-night",  "main-story",  "bad-thing",  "first-foremost",  "two-actors",  "think-movie",  "toward-end",  "come-alive",  "half-movie",  "nudity-little",  "music-video",  "violence-gore",  "story-thats",  "more-complex",  "spinal-tap",  "dont-understand",  "characters-more",  "low-key",  "murder-mystery",  "dont-expect",  "those-movies",  "liked-movie",  "new-film",  "several-scenes",  "director-stephen",  "theres-sense",  "kids-movies",  "bad-movies",  "funny-film",  "doesnt-always",  "want-know",  "nothing-new",  "film-stock",  "towards-end",  "pg-13-rating",  "take-away",  "hugh-grant",  "several-times",  "film-feels",  "find-themselves",  "whole-family",  "question-whether",  "dont-worry",  "film-starts",  "aspects-film",  "truman-show",  "movie-film",  "being-one",  "kid-old",  "language-sex",  "sound-effects",  "over-top",  "film-shot",  "best-parts",  "bad-news",  "aspect-film",  "beverly-hills",  "one-very",  "little-sense",  "david-lynch",  "best-friends",  "richard-iii",  "movie-first",  "intelligent-script",  "story-movie",  "look-good",  "dont-work",  "without-giving",  "das-boot",  "full-monty",  "hollywood-films",  "near-end",  "film-being",  "one-wonders",  "more-substantial",  "biggest-problem",  "quite-bit",  "viewers-find",  "acting-talent",  "lead-role",  "movie-tries",  "until-last",  "good-story",  "isnt-exactly",  "until-end",  "such-one",  "comes-close",  "scene-movie",  "taken-seriously",  "primary-colors",  "isnt-really",  "crude-humor",  "love-stories",  "excellent-job",  "opening-scene",  "film-full",  "seeing-movie",  "brought-screen",  "characters-story",  "teenagers-see",  "takes-time",  "movie-give",  "particularly-good",  "101-dalmatians",  "dont-even",  "perhaps-even",  "story-many",  "last-scene",  "film-theres",  "never-gets",  "one-such",  "those-two",  "dont-need",  "family-entertainment",  "compelling-story",  "graphic-violence",  "beneath-surface",  "director-mike",  "good-acting",  "film-though",  "give-picture",  "nicolas-cage",  "nearly-enough",  "bond-film",  "thats-good",  "fine-performances",  "actors-actresses",  "between-characters",  "over-years",  "out-more",  "world-war",  "thats-more",  "remains-day",  "enough-keep",  "watch-film",  "wag-dog",  "based-true",  "four-weddings",  "movie-comes",  "always-seems",  "result-film",  "100-minutes",  "bad-things",  "film-contains",  "fall-love",  "jerry-maguire",  "kids-over",  "quite-sure",  "teenagers-older",  "theres-still",  "points-out",  "eddie-murphy",  "make-feel",  "20th-century",  "two-main",  "martial-arts",  "rated-sexual",  "theres-doubt",  "film-long",  "thats-one",  "isnt-one",  "one-big",  "movie-full",  "movie-gets",  "battle-scenes",  "live-die",  "funny-one",  "over-two",  "sense-sensibility",  "film-funny",  "movie-still",  "theres-even",  "one-movies",  "refreshing-see",  "ado-nothing",  "didnt-make",  "waiting-guffman",  "frontal-nudity",  "robert-duvall",  "thats-exactly",  "even-best",  "much-longer",  "worth-noting",  "george-lucas",  "stands-out",  "violence-sexuality",  "way-long",  "love-interest",  "message-film",  "opening-sequence",  "movie-little",  "during-movie",  "matter-much",  "nutty-professor",  "fun-watching",  "tim-burton",  "time-kill",  "nudity-fine",  "come-expect",  "one-characters",  "fall-flat",  "columbia-pictures",  "independent-film",  "through-eyes",  "language-sexuality",  "movie-1/2",  "robert-niro",  "basic-instinct",  "runs-feels",  "company-men",  "scenes-film",  "thumbs-1/2",  "youll-probably",  "more-less",  "press-notes",  "two-hour",  "one-really",  "nothing-much",  "more-real",  "sundance-film",  "musical-score",  "more-powerful",  "good-guy",  "best-supporting",  "nothing-short",  "hunchback-notre",  "film-few",  "suspend-disbelief",  "isnt-funny",  "somewhere-between",  "supporting-roles",  "bathroom-humor",  "distributor-miramax",  "film-movie",  "more-concerned",  "little-sex",  "characters-dont",  "lost-highway",  "worse-still",  "minute-running",  "made-look",  "movie-feels",  "less-successful",  "during-first",  "art-film",  "sleepless-seattle",  "kevin-spacey",  "las-vegas",  "virtually-nothing",  "guilty-pleasure",  "time-movies",  "attention-detail",  "true-lies",  "french-film",  "family-films",  "seen-movie",  "fun-film",  "plays-part",  "center-stage",  "free-willy",  "mystery-story",  "see-again",  "comes-alive",  "something-little",  "movie-features",  "made-movie",  "far-away",  "piece-acting",  "scenes-one",  "story-seems",  "director-james",  "those-moments",  "movie-two",  "scary-movie",  "director-richard",  "blown-away",  "time-spent",  "coen-brothers",  "doesnt-appear",  "boogie-nights",  "early-film",  "more-enjoyable",  "les-miserables",  "film-kind",  "last-action",  "universal-pictures",  "film-industry",  "film-look",  "minutes-long",  "half-dozen",  "final-scene",  "more-successful",  "one-doesnt",  "film-way",  "more-appropriate",  "absolutely-nothing",  "feature-length",  "making-movie",  "entirely-different",  "running-around",  "good-measure",  "adam-sandler",  "world-cinema",  "work-here",  "see-something",  "ending-film",  "someone-elses",  "theme-song",  "first-two",  "few-things",  "comes-through",  "keep-audience",  "psychological-thriller",  "naked-gun",  "makes-want",  "john-malkovich",  "such-thing",  "best-actor",  "director-jonathan",  "profanity-nudity",  "already-know",  "dope-smoking",  "over-head",  "anyone-age",  "never-again",  "characters-seem",  "role-film",  "many-recent",  "full-frontal",  "never-takes",  "plays-role",  "way-movie",  "film-shows",  "movie-movie",  "kama-sutra",  "film-looks",  "dantes-peak",  "rated-sexuality",  "dont-really",  "film-quite",  "story-without",  "quite-few",  "youre-looking",  "oscar-nomination",  "more-entertaining",  "spitfire-grill",  "best-movie",  "fact-theres",  "robert-altman",  "john-cusack",  "philadelphia-festival",  "movie-set",  "opposite-sex",  "characters-never",  "including-one",  "movie-director",  "solid-performances",  "pictures-classics",  "dark-side",  "better-script",  "quite-well",  "animated-feature",  "little-movie",  "nothing-less",  "content-language",  "make-good",  "made-sense",  "story-characters",  "know-last",  "love-hate",  "top-form",  "played-out",  "know-more",  "movie-ends",  "more-films",  "actors-play",  "sweet-hereafter",  "things-going",  "more-anything",  "film-better",  "best-one",  "one-much",  "those-elements",  "festival-world",  "citizen-kane",  "animated-film",  "didnt-care",  "film-bad",  "film-end",  "film-far",  "script-based",  "easily-one",  "theres-plenty",  "movie-make",  "ive-never",  "make-such",  "care-characters",  "film-french",  "billy-crystal",  "denis-leary",  "although-many",  "acceptable-ages",  "time-frame",  "part-show",  "great-movie",  "plot-devices",  "whole-movie",  "first-act",  "private-parts",  "starring-role",  "nudity-running",  "visual-style",  "105-minutes",  "human-drama",  "same-level",  "film-actually",  "alfred-hitchcock",  "look-film",  "performance-one",  "dont-take",  "script-full",  "sixth-sense",  "nudity-adult",  "film-trying",  "short-film",  "situations-profanity",  "another-one",  "perhaps-one",  "over-again",  "little-story",  "american-audiences",  "over-over",  "based-play",  "liar-liar",  "best-director",  "genuine-chemistry",  "way-another",  "good-parts",  "john-woo",  "comes-out",  "energy-level",  "lot-time",  "shown-philadelphia",  "slightly-more",  "theres-way",  "although-one",  "members-audience",  "few-lines",  "movies-more",  "family-values",  "previous-film",  "reason-care",  "through-movie",  "action-violence",  "night-live",  "sony-pictures",  "right-wrong",  "blood-gore",  "weddings-funeral",  "rated-little",  "sex-profanity",  "movie-people",  "audience-members",  "real-world",  "monty-python",  "rush-hour",  "best-performances",  "well-cast",  "see-much",  "air-force",  "more-once",  "never-see",  "film-nothing",  "fully-developed",  "one-hand",  "best-lines",  "same-kind",  "quality-film",  "cutting-room",  "whose-last",  "same-name",  "better-one",  "doesnt-feel",  "feature-debut",  "best-way",  "movie-theater",  "director-steven",  "attempts-humor",  "slightly-different",  "those-characters",  "keanu-reeves",  "films-conclusion",  "film-two",  "make-audience",  "given-more",  "completely-different",  "extremely-funny",  "silence-lambs",  "bit-much",  "scene-one",  "more-little",  "force-one",  "movie-although",  "goes-long",  "film-work",  "wide-variety",  "another-movie",  "find-something",  "idea-film",  "outer-space",  "supporting-role",  "slapstick-comedy",  "carried-away",  "talented-cast",  "rated-fine",  "youve-never",  "movie-worth",  "austin-powers",  "language-mature",  "fathers-day",  "differences-between",  "set-design",  "ice-storm",  "answer-question",  "new-ground",  "once-upon",  "dance-numbers",  "against-type",  "tells-story",  "movie-becomes",  "one-minute",  "lead-characters",  "lot-people",  "movie-actually",  "having-fun",  "didnt-see",  "strikes-back",  "film-characters",  "little-much",  "film-acting",  "care-less",  "title-film",  "enjoy-film",  "action-picture",  "care-much",  "saw-film",  "built-around",  "michael-keaton",  "runs-out",  "film-experience",  "waynes-world",  "funny-lines",  "meg-ryan",  "vastly-different",  "lead-actors",  "strong-sexuality",  "quite-same",  "comedy-drama",  "best-moments",  "film-come",  "second-time",  "wanted-make",  "film-done",  "film-dont",  "profanity-sex",  "one-person",  "one-major",  "thing-certain",  "script-director",  "film-whose",  "film-feel",  "big-budget",  "one-interesting",  "title-role",  "one-even",  "see-more",  "even-one",  "hard-eight",  "usual-suspects",  "part-picture",  "themes-brief",  "high-level",  "best-foreign",  "one-reason",  "more-difficult",  "perfect-example",  "worth-look",  "movie-going",  "thats-way",  "becomes-clear",  "one-moment",  "high-concept",  "action-thriller",  "love-catastrophes",  "minutes-movie",  "strong-sexual",  "chasing-amy",  "makes-much",  "written-1996",  "last-few",  "make-seem",  "run-out",  "surprise-ending",  "things-happen",  "pokes-fun",  "situations-nudity",  "car-chases",  "youll-find",  "dont-miss",  "movie-plays",  "few-many",  "make-want",  "less-effective",  "time-105",  "century-fox",  "story-such",  "film-year",  "seen-through",  "story-tell",  "story-really",  "juliette-lewis",  "denzel-washington",  "never-more",  "film-lacks",  "films-last",  "based-book",  "director-brian",  "bad-enough",  "music-john",  "mel-gibson",  "films-more",  "sex-scene",  "rated-nothing",  "history-lesson",  "dysfunctional-family",  "still-one",  "farewell-concubine",  "through-entire",  "scenes-movie",  "barry-levinson",  "screenplay-peter",  "wesley-snipes",  "rated-mild",  "films-opening",  "male-female",  "martin-lawrence",  "out-much",  "enough-give",  "entire-life",  "main-problem",  "krzysztof-kieslowski",  "interesting-enough",  "director-roger",  "thirty-years",  "incorrectly-rated",  "feel-sorry",  "moments-film",  "chain-reaction",  "first-half-hour",  "film-great",  "youd-expect",  "much-anything",  "dont-ask",  "done-before",  "rating-sexual",  "sliding-doors",  "basic-plot",  "muriels-wedding",  "gives-one",  "bunch-movie",  "unlike-many",  "never-comes",  "pointe-blank",  "bring-myself",  "disney-animated",  "nothing-film",  "film-both",  "few-people",  "city-slickers",  "more-two",  "hollywood-film",  "worked-well",  "crude-sexual",  "fleshed-out",  "isnt-good",  "friends-wedding",  "doesnt-exactly",  "around-send",  "stage-play",  "love-film",  "one-half",  "two-years",  "story-story",  "next-time",  "red-line",  "memorable-lines",  "grand-canyon",  "doesnt-come",  "theres-question",  "take-look",  "very-hard",  "cant-make",  "certainly-doesnt",  "during-film",  "funny-enough",  "sling-blade",  "film-1/2",  "very-different",  "con-air",  "really-liked",  "easy-understand",  "january-1997",  "many-good",  "english-patient",  "conflict-between",  "chance-see",  "given-much",  "coming-of-age-story",  "film-same",  "movie-many",  "year-list",  "take-time",  "both-actors",  "actors-playing",  "hes-more",  "forth-between",  "first-glance",  "feature-director",  "sexuality-fine",  "leslie-nielsen",  "come-along",  "years-best",  "richard-gere",  "much-plot",  "anything-new",  "deep-impact",  "film-failed",  "19th-century",  "message-movie",  "recent-memory",  "characters-make",  "become-more",  "look-feel",  "never-feels",  "here-film",  "first-time-writer",  "john-travolta",  "liked-way",  "dont-surprised",  "doesnt-want",  "three-main",  "cant-see",  "pelican-brief",  "big-game",  "characters-little",  "empire-strikes",  "change-pace",  "sort-thing",  "val-kilmer",  "ace-ventura",  "big-night",  "story-becomes",  "absolute-power",  "movies-best",  "rise-above",  "quirky-characters",  "everything-seems",  "kenneth-branaghs",  "come-back",  "cats-dogs",  "enough-film",  "winona-ryder",  "release-date",  "gene-hackman",  "comes-mind",  "people-dont",  "good-reason",  "michelle-pfeiffer",  "real-story",  "final-analysis",  "profanity-drug",  "certain-amount",  "demi-moore",  "female-characters",  "far-best",  "those-familiar",  "arent-enough",  "noir-films",  "city-angels",  "comic-moments",  "dustin-hoffman",  "little-things",  "type-movie",  "youll-see",  "indiana-jones",  "cutting-edge",  "noir-thriller",  "smile-face",  "big-fan",  "actors-film",  "american-film",  "george-jungle",  "thin-red",  "around-nine",  "john-turturro",  "far-long",  "thing-movie",  "probably-best",  "moves-along",  "little-better",  "much-different",  "aspect-movie",  "twentieth-century",  "animated-features",  "one-fine",  "director-jon",  "humor-movie",  "grosse-pointe",  "age-1/2",  "movies-year",  "story-didnt",  "three-hours",  "cautionary-tale",  "jackie-brown",  "top-rating",  "star-film",  "femme-fatale",  "movie-starts",  "air-bud",  "wedding-singer",  "those-under",  "one-key",  "movie-gave",  "old-men",  "more-screen",  "film-filled",  "before-film",  "comedy-film",  "same-thing",  "doesnt-give",  "show-give",  "virtually-impossible",  "acting-good",  "story-makes",  "very-long",  "very-few",  "gwyneth-paltrow",  "seven-years",  "makes-movie",  "situations-violence",  "way-story",  "1/2-star",  "computer-generated",  "many-great",  "much-energy",  "performance-film",  "wings-desire",  "forty-five-minutes",  "around-corner",  "interesting-story",  "real-problem",  "find-one",  "whole-thing",  "line-fire",  "easily-best",  "spike-lee",  "first-one",  "mild-language",  "time-see",  "room-floor",  "years-later",  "pointed-out",  "laughably-bad",  "hollywood-pictures",  "really-isnt",  "films-many",  "feels-more",  "bring-out",  "movie-well",  "samuel-jackson",  "without-resorting",  "kevin-smith",  "came-out",  "darn-cat",  "film-nevertheless",  "director-paul",  "long-line",  "out-movie",  "dramatic-music",  "more-human",  "solid-entertainment",  "dead-man",  "farrelly-brothers",  "didnt-work",  "youd-think",  "young-kids",  "shall-dance",  "worth-recommending",  "sexual-references",  "drew-barrymore",  "woody-allens",  "cant-quite",  "strong-performance",  "well-enough",  "heavenly-creatures",  "dark-city",  "whose-previous",  "power-rangers",  "looking-richard",  "love-jones",  "masterpiece-theater",  "miracle-34th",  "more-appealing",  "original-movie",  "nice-job",  "sean-penn",  "animated-movie",  "body-language",  "although-few",  "film-critic",  "seems-little",  "jingle-way",  "look-one",  "last-picture",  "witch-project",  "rating-nudity",  "black-hat",  "many-others",  "stock-characters",  "really-funny",  "more-passing",  "billy-bob",  "screenplay-michael",  "politically-incorrect",  "first-major",  "work-one",  "connection-between",  "things-dont",  "seen-one",  "kids-show",  "didnt-think",  "third-act",  "cannes-film",  "american-beauty",  "many-lines",  "talking-heads",  "another-example",  "younger-kids",  "seen-more",  "much-attention",  "good-looking",  "cartoonish-violence",  "times-movie",  "final-credits",  "film-always",  "film-left",  "kevin-williamson",  "movie-find",  "story-gets",  "something-different",  "gratuitous-violence",  "written-december",  "much-happens",  "needs-more",  "movie-great",  "liked-film",  "small-role",  "first-minutes",  "welcome-dollhouse",  "film-over",  "probably-pg-13",  "oscar-nominations",  "two-three",  "bad-idea",  "joy-luck",  "make-laugh",  "film-think",  "hardly-wait",  "very-difficult",  "monster-movie",  "movie-stars",  "disaster-movie",  "little-bad",  "way-around",  "work-film",  "show-more",  "second-act",  "much-going",  "extremely-effective",  "los-angeles",  "larry-flynt",  "better-films",  "completely-satisfying",  "theres-denying",  "action-flick",  "movie-same",  "look-back",  "come-surprise",  "short-story",  "walt-disney",  "34th-street",  "straight-face",  "feels-much",  "screenplay-robert",  "carry-film",  "times-film",  "good-gets",  "principal-characters",  "line-features",  "wonder-whether",  "made-one",  "everyone-film",  "major-league",  "becomes-apparent",  "good-laughs",  "little-picture",  "written-august",  "bad-one",  "foreign-language"  };
	//1270--public static String[] bigramList={"films-year" ,  "see-film" ,  "motion-picture" ,  "film-excellent" ,  "movie-kind" ,  "waste-money" ,  "average-movie" ,  "dont-waste" ,  "show-dont" ,  "excellent-show" ,  "show-look" ,  "kind-enjoyable" ,  "enjoyable-poor" ,  "poor-show" ,  "look-average" ,  "opinions-expressed" ,  "meant-reflect" ,  "mine-meant" ,  "reflect-employers" ,  "expressed-mine" ,  "running-time" ,  "few-films" ,  "one-worst" ,  "worst-films" ,  "message-subject" ,  "reply-message" ,  "details-reply" ,  "one-top" ,  "money-one" ,  "year-see" ,  "totally-unbearable" ,  "year-totally" ,  "top-few" ,  "rated-pg-13" ,  "mpaa-rating" ,  "subject-line" ,  "much-more" ,  "even-though" ,  "special-effects" ,  "even-more" ,  "little-more" ,  "adult-themes" ,  "unbearable-opinions" ,  "fine-kids" ,  "screening-room" ,  "son-jeffrey" ,  "see-screening" ,  "subject-subscribe" ,  "room-details" ,  "much-better" ,  "fine-teenagers" ,  "one-those" ,  "kids-around" ,  "sex-nudity" ,  "see-moviepage" ,  "moviepage-details" ,  "line-subscribe" ,  "jeffrey-age" ,  "painfully-unbearable" ,  "money-totally" ,  "unbearable-picture" ,  "totally-painfully" ,  "sexual-situations" ,  "turns-out" ,  "older-teenagers" ,  "english-subtitles" ,  "theres-nothing" ,  "review-written" ,  "romantic-comedy" ,  "film-one" ,  "word-subscribe" ,  "letter-word" ,  "subscribe-subject" ,  "send-letter" ,  "acceptable-teenagers" ,  "screen-time" ,  "motion-pictures" ,  "running-length" ,  "love-story" ,  "character-study" ,  "film-makers" ,  "mature-themes" ,  "two-hours" ,  "far-more" ,  "subject-matter" ,  "between-two" ,  "runs-rated" ,  "acceptable-older" ,  "chemistry-between" ,  "one-thing" ,  "action-sequences" ,  "film-more" ,  "first-time" ,  "bad-language" ,  "character-development" ,  "brief-nudity" ,  "themes-running" ,  "supporting-cast" ,  "one-best" ,  "theres-something" ,  "rated-violence" ,  "profanity-adult" ,  "rating-pg-13" ,  "violence-profanity" ,  "star-wars" ,  "film-fine" ,  "picture-opinions" ,  "figure-out" ,  "time-minutes" ,  "acceptable-kids" ,  "language-acceptable" ,  "give-1/2" ,  "academy-award" ,  "nudity-violence" ,  "high-school" ,  "part-film" ,  "science-fiction" ,  "writer-director" ,  "first-half" ,  "1/2-one" ,  "film-made" ,  "box-office" ,  "action-film" ,  "main-characters" ,  "dont-know" ,  "last-years" ,  "more-interesting" ,  "subtitles-rated" ,  "one-many" ,  "great-deal" ,  "best-part" ,  "film-doesnt" ,  "along-way" ,  "doesnt-seem" ,  "theres-much" ,  "rating-profanity" ,  "bad-guys" ,  "unbearable-review" ,  "dont-think" ,  "takes-place" ,  "relationship-between" ,  "youve-seen" ,  "give-film" ,  "very-little" ,  "woody-allen" ,  "long-rated" ,  "big-screen" ,  "many-scenes" ,  "pulp-fiction" ,  "isnt-much" ,  "years-ago" ,  "movie-one" ,  "new-york" ,  "rated-strong" ,  "runs-long" ,  "director-john" ,  "want-see" ,  "see-movie" ,  "many-times" ,  "rated-sex" ,  "something-more" ,  "film-noir" ,  "one-more" ,  "worth-seeing" ,  "half-hour" ,  "ingmar-bergman" ,  "film-festival" ,  "never-quite" ,  "many-ways" ,  "doesnt-make" ,  "long-time" ,  "rated-language" ,  "bit-more" ,  "much-time" ,  "film-never" ,  "soap-opera" ,  "dont-want" ,  "movie-nothing" ,  "film-even" ,  "one-films" ,  "second-half" ,  "film-rated" ,  "nothing-more" ,  "kind-film" ,  "black-white" ,  "very-good" ,  "1997-opinions" ,  "make-sense" ,  "robin-williams" ,  "theres-little" ,  "make-film" ,  "one-few" ,  "profanity-violence" ,  "part-movie" ,  "one-scene" ,  "1/2-see" ,  "never-seen" ,  "sit-through" ,  "found-myself" ,  "film-making" ,  "film-much" ,  "picture-review" ,  "black-comedy" ,  "die-hard" ,  "film-makes" ,  "one-film" ,  "movie-rated" ,  "lot-more" ,  "screen-presence" ,  "profanity-fine" ,  "down-david" ,  "belief-movie" ,  "david-puttnam" ,  "nothing-life" ,  "sexual-content" ,  "people-neutral" ,  "makes-film" ,  "leave-down" ,  "neutral-leave" ,  "leaves-people" ,  "leave-leave" ,  "life-leaves" ,  "made-film" ,  "very-funny" ,  "theres-lot" ,  "very-much" ,  "give-one" ,  "enough-make" ,  "drug-use" ,  "based-novel" ,  "star-trek" ,  "written-directed" ,  "two-leads" ,  "one-point" ,  "action-films" ,  "pg-13-profanity" ,  "anything-more" ,  "film-takes" ,  "drug-usage" ,  "horror-film" ,  "ive-seen" ,  "sense-humor" ,  "doesnt-take" ,  "violence-language" ,  "put-together" ,  "film-maker" ,  "pg-13-violence" ,  "comic-relief" ,  "jurassic-park" ,  "feature-film" ,  "best-thing" ,  "nudity-profanity" ,  "first-place" ,  "film-film" ,  "theres-enough" ,  "plot-device" ,  "quite-good" ,  "violence-running" ,  "seen-before" ,  "movie-isnt" ,  "reason-see" ,  "doesnt-much" ,  "profanity-running" ,  "movie-more" ,  "without-being" ,  "violence-fine" ,  "many-characters" ,  "opening-credits" ,  "tell-story" ,  "doesnt-work" ,  "sight-gags" ,  "bad-movie" ,  "good-film" ,  "once-again" ,  "teenagers-send" ,  "kind-movie" ,  "real-life" ,  "action-scenes" ,  "plot-twists" ,  "age-gave" ,  "those-films" ,  "physical-comedy" ,  "fairy-tale" ,  "show-fine" ,  "find-yourself" ,  "film-director" ,  "theres-one" ,  "seems-more" ,  "one-another" ,  "good-enough" ,  "great-film" ,  "first-film" ,  "mpaa-classification" ,  "turn-out" ,  "much-fun" ,  "true-story" ,  "bad-guy" ,  "entertainment-value" ,  "old-enough" ,  "more-interested" ,  "recommend-give" ,  "fifteen-minutes" ,  "one-expect" ,  "one-character" ,  "fine-older" ,  "recommend-film" ,  "length-mpaa" ,  "hard-believe" ,  "good-movie" ,  "way-through" ,  "mature-teenagers" ,  "comic-book" ,  "rest-movie" ,  "rated-profanity" ,  "leave-theater" ,  "around-son" ,  "sitting-through" ,  "film-isnt" ,  "taking-place" ,  "same-time" ,  "even-better" ,  "rest-film" ,  "correctly-rated" ,  "director-robert" ,  "french-english" ,  "entire-movie" ,  "ensemble-cast" ,  "one-two" ,  "happy-ending" ,  "theres-more" ,  "waste-time" ,  "tries-hard" ,  "fine-line" ,  "romantic-comedies" ,  "throughout-film" ,  "come-out" ,  "violence-acceptable" ,  "profanity-sexual" ,  "many-films" ,  "pretty-good" ,  "never-really" ,  "men-women" ,  "much-film" ,  "make-sure" ,  "film-very" ,  "story-told" ,  "point-out" ,  "supporting-characters" ,  "doesnt-really" ,  "television-series" ,  "themes-profanity" ,  "story-itself" ,  "first-hour" ,  "story-film" ,  "film-works" ,  "story-line" ,  "story-more" ,  "james-bond" ,  "mission-impossible" ,  "family-film" ,  "serial-killer" ,  "entire-film" ,  "unbearable-reviewed" ,  "good-time" ,  "few-minutes" ,  "action-hero" ,  "quentin-tarantino" ,  "reviewed-written" ,  "director-peter" ,  "lion-king" ,  "schindlers-list" ,  "toy-story" ,  "making-film" ,  "telling-story" ,  "rated-probably" ,  "times-before" ,  "gives-film" ,  "give-see" ,  "movie-made" ,  "main-character" ,  "film-itself" ,  "even-those" ,  "more-effective" ,  "recommend-movie" ,  "feel-good" ,  "ten-minutes" ,  "manages-make" ,  "more-one" ,  "hour-half" ,  "movie-never" ,  "film-many" ,  "five-minutes" ,  "whole-lot" ,  "film-seems" ,  "love-affair" ,  "best-film" ,  "kids-under" ,  "film-good" ,  "low-budget" ,  "film-without" ,  "movie-doesnt" ,  "doesnt-know" ,  "visual-effects" ,  "many-people" ,  "recommend-picture" ,  "twenty-minutes" ,  "trying-make" ,  "romance-between" ,  "more-impressive" ,  "home-alone" ,  "best-performance" ,  "perhaps-best" ,  "ages-son" ,  "quite-funny" ,  "1995-opinions" ,  "1996-opinions" ,  "very-well" ,  "out-film" ,  "makes-sense" ,  "good-sense" ,  "twists-turns" ,  "human-beings" ,  "closing-credits" ,  "end-film" ,  "minutes-film" ,  "see-one" ,  "part-story" ,  "bad-film" ,  "thumbs-down" ,  "screenplay-david" ,  "without-much" ,  "both-sides" ,  "nudity-sex" ,  "age-thought" ,  "better-film" ,  "length-rated" ,  "sexuality-acceptable" ,  "film-give" ,  "cant-help" ,  "film-offers" ,  "musical-numbers" ,  "independence-day" ,  "director-michael" ,  "little-bit" ,  "end-credits" ,  "story-one" ,  "director-david" ,  "out-one" ,  "gave-film" ,  "film-little" ,  "rating-violence" ,  "high-energy" ,  "out-loud" ,  "thirty-minutes" ,  "source-material" ,  "well-worth" ,  "same-way" ,  "whats-going" ,  "film-ends" ,  "set-pieces" ,  "give-movie" ,  "more-time" ,  "dont-care" ,  "one-better" ,  "first-part" ,  "fun-watch" ,  "point-view" ,  "recommend-show" ,  "press-screening" ,  "way-film" ,  "slice-life" ,  "rest-cast" ,  "problem-film" ,  "think-film" ,  "ninety-minutes" ,  "point-film" ,  "award-1/2" ,  "few-scenes" ,  "noir-film" ,  "entertaining-film" ,  "film-comes" ,  "movie-itself" ,  "few-times" ,  "little-profanity" ,  "line-between" ,  "one-great" ,  "many-movies" ,  "target-audience" ,  "despite-being" ,  "steven-seagal" ,  "sexuality-language" ,  "films-one" ,  "although-film" ,  "strong-violence" ,  "take-place" ,  "violence-sex" ,  "half-film" ,  "characters-situations" ,  "pretty-much" ,  "language-violence" ,  "although-movie" ,  "easy-see" ,  "silicon-valley" ,  "title-character" ,  "make-movie" ,  "violence-adult" ,  "film-those" ,  "few-good" ,  "last-act" ,  "fine-teenager" ,  "ending-credits" ,  "suspension-disbelief" ,  "fair-amount" ,  "back-forth" ,  "pg-13-sexual" ,  "difference-between" ,  "havent-seen" ,  "seem-more" ,  "two-films" ,  "bond-films" ,  "doesnt-quite" ,  "seeing-film" ,  "pop-culture" ,  "horror-films" ,  "walk-out" ,  "good-one" ,  "one-one" ,  "wonderful-life" ,  "though-film" ,  "turned-out" ,  "credits-roll" ,  "find-film" ,  "date-released" ,  "movie-takes" ,  "good-idea" ,  "more-important" ,  "especially-those" ,  "work-well" ,  "jackie-chan" ,  "strong-language" ,  "older-mature" ,  "story-doesnt" ,  "between-art" ,  "many-viewers" ,  "human-being" ,  "something-mary" ,  "much-less" ,  "film-well" ,  "camera-work" ,  "time-film" ,  "drug-content" ,  "bruce-willis" ,  "time-around" ,  "lot-fun" ,  "first-time-director" ,  "something-between" ,  "written-january" ,  "themes-violence" ,  "beginning-end" ,  "film-probably" ,  "long-enough" ,  "century-theaters" ,  "hong-kong" ,  "language-fine" ,  "piece-work" ,  "few-moments" ,  "out-place" ,  "art-films" ,  "1994-opinions" ,  "film-acceptable" ,  "facial-expressions" ,  "pg-13-brief" ,  "short-cuts" ,  "watching-movie" ,  "recent-films" ,  "film-becomes" ,  "two-characters" ,  "anthony-hopkins" ,  "much-movie" ,  "martin-scorsese" ,  "miramax-films" ,  "one-good" ,  "jean-luc-godard" ,  "many-different" ,  "violence-sexual" ,  "sexual-humor" ,  "movie-makes" ,  "directorial-debut" ,  "time-movie" ,  "good-guys" ,  "fine-ages" ,  "parts-movie" ,  "best-picture" ,  "one-reasons" ,  "picture-give" ,  "live-action" ,  "funny-moments" ,  "clint-eastwood" ,  "amc-century" ,  "minor-characters" ,  "social-commentary" ,  "film-gets" ,  "film-really" ,  "teenagers-recommend" ,  "good-job" ,  "works-best" ,  "one-favorite" ,  "mild-profanity" ,  "thought-movie" ,  "doesnt-mean" ,  "horror-movie" ,  "nudity-language" ,  "such-films" ,  "characters-film" ,  "few-years" ,  "more-serious" ,  "films-made" ,  "art-life" ,  "pg-13-adult" ,  "warner-brothers" ,  "thematic-elements" ,  "dont-see" ,  "forrest-gump" ,  "life-piece" ,  "far-less" ,  "thing-film" ,  "cinema-both" ,  "life-takes" ,  "language-drug" ,  "movie-fine" ,  "cinema-something" ,  "bad-taste" ,  "straight-out" ,  "weve-seen" ,  "last-summer" ,  "film-see" ,  "film-critics" ,  "situations-adult" ,  "make-mistake" ,  "long-way" ,  "few-more" ,  "movie-runs" ,  "violence-film" ,  "films-life" ,  "themes-sexual" ,  "violence-bad" ,  "parts-film" ,  "come-close" ,  "nudity-sexual" ,  "sex-violence" ,  "both-gives" ,  "unlike-painting" ,  "painting-literature" ,  "press-kit" ,  "cinema-art" ,  "cinema-slice" ,  "piece-cake" ,  "emotional-impact" ,  "life-unlike" ,  "film-didnt" ,  "film-still" ,  "literature-cinema" ,  "arent-many" ,  "takes-jean-luc" ,  "film-cant" ,  "more-few" ,  "watching-film" ,  "well-done" ,  "never-seems" ,  "good-bad" ,  "gave-1/2" ,  "one-way" ,  "make-more" ,  "becomes-more" ,  "jim-carrey" ,  "film-set" ,  "gives-life" ,  "first-movie" ,  "movie-filled" ,  "life-cinema" ,  "find-out" ,  "really-good" ,  "central-character" ,  "good-evil" ,  "plot-elements" ,  "sexual-innuendo" ,  "sandra-bullock" ,  "movie-thats" ,  "van-damme" ,  "united-states" ,  "story-never" ,  "few-laughs" ,  "film-best" ,  "little-mermaid" ,  "character-film" ,  "loose-ends" ,  "worth-caring" ,  "starship-troopers" ,  "steven-spielberg" ,  "classification-mpaa" ,  "isnt-nearly" ,  "type-film" ,  "mild-thumbs" ,  "nothing-special" ,  "make-much" ,  "acting-ability" ,  "very-bad" ,  "good-thing" ,  "film-thats" ,  "films-best" ,  "enough-recommend" ,  "last-year" ,  "many-more" ,  "enough-interested" ,  "valley-showing" ,  "film-opens" ,  "much-same" ,  "start-finish" ,  "smart-enough" ,  "doesnt-offer" ,  "problem-movie" ,  "best-known" ,  "better-movie" ,  "certainly-isnt" ,  "sort-movie" ,  "worth-price" ,  "doesnt-matter" ,  "pg-13-language" ,  "little-long" ,  "theaters-send" ,  "dumb-dumber" ,  "those-dont" ,  "content-acceptable" ,  "saving-grace" ,  "movie-bad" ,  "beauty-beast" ,  "film-story" ,  "more-fun" ,  "sex-scenes" ,  "rated-nudity" ,  "isnt-bad" ,  "film-version" ,  "doesnt-even" ,  "reservoir-dogs" ,  "doesnt-help" ,  "period-piece" ,  "rated-brief" ,  "film-seem" ,  "film-seen" ,  "film-such" ,  "way-out" ,  "out-way" ,  "even-worse" ,  "youre-going" ,  "production-values" ,  "film-tries" ,  "art-house" ,  "oliver-stone" ,  "script-doesnt" ,  "each-one" ,  "pleasant-enough" ,  "long-before" ,  "many-things" ,  "itself-seriously" ,  "fine-job" ,  "slow-motion" ,  "film-first" ,  "those-rare" ,  "take-long" ,  "language-film" ,  "year-old" ,  "one-long" ,  "much-sense" ,  "language-sexual" ,  "dont-make" ,  "didnt-know" ,  "situations-running" ,  "much-story" ,  "works-well" ,  "best-films" ,  "films-such" ,  "romeo-juliet" ,  "aspect-ratio" ,  "debut-feature" ,  "those-enjoy" ,  "far-better" ,  "films-title" ,  "pg-13-mature" ,  "blair-witch" ,  "fine-kid" ,  "gave-movie" ,  "kenneth-branagh" ,  "best-work" ,  "films-end" ,  "movie-best" ,  "makes-one" ,  "more-compelling" ,  "more-plot" ,  "found-film" ,  "fifth-element" ,  "starts-out" ,  "makes-feel" ,  "see-show" ,  "movie-good" ,  "showing-amc" ,  "price-admission" ,  "read-book" ,  "perhaps-more" ,  "made-more" ,  "rest-picture" ,  "those-scenes" ,  "tom-hanks" ,  "camera-angles" ,  "rated-mature" ,  "didnt-seem" ,  "everyone-love" ,  "john-hughes" ,  "nothing-offend" ,  "scene-film" ,  "man-woman" ,  "under-fire" ,  "end-movie" ,  "two-stars" ,  "time-director" ,  "little-violence" ,  "isnt-enough" ,  "more-film" ,  "first-feature" ,  "edge-seat" ,  "real-people" ,  "arnold-schwarzenegger" ,  "simple-story" ,  "last-film" ,  "nudity-acceptable" ,  "both-films" ,  "film-goes" ,  "isnt-particularly" ,  "thought-film" ,  "picture-one" ,  "christopher-walken" ,  "none-characters" ,  "strongly-recommend" ,  "age-innocence" ,  "check-out" ,  "language-brief" ,  "one-time" ,  "harrison-ford" ,  "film-seemed" ,  "scenes-between" ,  "themes-fine" ,  "two-people" ,  "long-film" ,  "time-one" ,  "von-trier" ,  "batman-robin" ,  "film-based" ,  "interaction-between" ,  "part-problem" ,  "production-design" ,  "good-news" ,  "big-laughs" ,  "even-less" ,  "little-film" ,  "during-course" ,  "recent-years" ,  "everything-film" ,  "character-interaction" ,  "previous-films" ,  "show-one" ,  "through-film" ,  "paramount-pictures" ,  "tour-force" ,  "something-special" ,  "little-time" ,  "seen-film" ,  "kids-age" ,  "film-although" ,  "car-chase" ,  "one-years" ,  "hard-imagine" ,  "audiences-attention" ,  "small-part" ,  "film-make" ,  "left-theater" ,  "much-ado" ,  "makes-more" ,  "film-moves" ,  "runs-little" ,  "movie-much" ,  "award-nomination" ,  "award-winning" ,  "dont-mind" ,  "supporting-players" ,  "offend-anyone" ,  "few-nice" ,  "more-subtle" ,  "going-through" ,  "theres-reason" ,  "movie-year" ,  "even-film" ,  "stand-out" ,  "movie-works" ,  "strong-enough" ,  "punch-lines" ,  "worth-watching" ,  "sort-film" ,  "rest-story" ,  "film-something" ,  "nice-guy" ,  "movie-without" ,  "lost-world" ,  "takes-itself" ,  "cast-members" ,  "courage-under" ,  "film-wasnt" ,  "good-intentions" ,  "dark-comedy" ,  "rated-nc-17" ,  "film-plays" ,  "isnt-even" ,  "movie-seems" ,  "more-more" ,  "strong-performances" ,  "twenty-years" ,  "lead-character" ,  "fast-paced" ,  "movie-really" ,  "movie-even" ,  "give-thumbs" ,  "screenplay-john" ,  "story-much" ,  "large-part" ,  "written-june" ,  "never-made" ,  "brady-bunch" ,  "steve-martin" ,  "david-mamet" ,  "spend-time" ,  "high-points" ,  "french-subtitles" ,  "life-film" ,  "perfectly-cast" ,  "original-film" ,  "good-looks" ,  "nudity-bad" ,  "isnt-quite" ,  "great-fun" ,  "video-game" ,  "julia-roberts" ,  "notre-dame" ,  "film-going" ,  "more-enough" ,  "best-scenes" ,  "two-movies" ,  "theres-never" ,  "kevin-costner" ,  "del-toro" ,  "going-happen" ,  "cross-between" ,  "sweet-little" ,  "theatrical-aspect" ,  "human-nature" ,  "another-film" ,  "breaking-waves" ,  "far-much" ,  "before-sunrise" ,  "cant-even" ,  "right-down" ,  "kids-movie" ,  "giving-film" ,  "film-certainly" ,  "john-sayles" ,  "film-worth" ,  "interesting-character" ,  "award-one" ,  "movies-one" ,  "story-isnt" ,  "last-seen" ,  "written-october" ,  "violence-nudity" ,  "profanity-brief" ,  "saturday-night" ,  "main-story" ,  "bad-thing" ,  "first-foremost" ,  "two-actors" ,  "think-movie" ,  "toward-end" ,  "come-alive" ,  "half-movie" ,  "nudity-little" ,  "music-video" ,  "violence-gore" ,  "story-thats" ,  "more-complex" ,  "spinal-tap" ,  "dont-understand" ,  "characters-more" ,  "low-key" ,  "murder-mystery" ,  "dont-expect" ,  "those-movies" ,  "liked-movie" ,  "new-film" ,  "several-scenes" ,  "director-stephen" ,  "theres-sense" ,  "kids-movies" ,  "bad-movies" ,  "funny-film" ,  "doesnt-always" ,  "want-know" ,  "nothing-new" ,  "film-stock" ,  "towards-end" ,  "pg-13-rating" ,  "take-away" ,  "hugh-grant" ,  "several-times" ,  "film-feels" ,  "find-themselves" ,  "whole-family" ,  "question-whether" ,  "dont-worry" ,  "film-starts" ,  "aspects-film" ,  "truman-show" ,  "movie-film" ,  "being-one" ,  "kid-old" ,  "language-sex" ,  "sound-effects" ,  "over-top" ,  "film-shot" ,  "best-parts" ,  "bad-news" ,  "aspect-film" ,  "beverly-hills" ,  "one-very" ,  "little-sense" ,  "david-lynch" ,  "best-friends" ,  "richard-iii" ,  "movie-first" ,  "intelligent-script" ,  "story-movie" ,  "look-good" ,  "dont-work" ,  "without-giving" ,  "das-boot" ,  "full-monty" ,  "hollywood-films" ,  "near-end" ,  "film-being" ,  "one-wonders" ,  "more-substantial" ,  "biggest-problem" ,  "quite-bit" ,  "viewers-find" ,  "acting-talent" ,  "lead-role" ,  "movie-tries" ,  "until-last" ,  "good-story" ,  "isnt-exactly" ,  "until-end" ,  "such-one" ,  "comes-close" ,  "scene-movie" ,  "taken-seriously" ,  "primary-colors" ,  "isnt-really" ,  "crude-humor" ,  "love-stories" ,  "excellent-job" ,  "opening-scene" ,  "film-full" ,  "seeing-movie" ,  "brought-screen" ,  "characters-story" ,  "teenagers-see" ,  "takes-time" ,  "movie-give" ,  "particularly-good" ,  "101-dalmatians" ,  "dont-even" ,  "perhaps-even" ,  "story-many" ,  "last-scene" ,  "film-theres" ,  "never-gets" ,  "one-such" ,  "those-two" ,  "dont-need" ,  "family-entertainment" ,  "compelling-story" ,  "graphic-violence" ,  "beneath-surface" ,  "director-mike" ,  "good-acting" ,  "film-though" ,  "give-picture" ,  "nicolas-cage" ,  "nearly-enough" ,  "bond-film" ,  "thats-good" ,  "fine-performances" ,  "actors-actresses" ,  "between-characters" ,  "over-years" ,  "out-more" ,  "world-war" ,  "thats-more" ,  "remains-day" ,  "enough-keep" ,  "watch-film" ,  "wag-dog" ,  "based-true" ,  "four-weddings" ,  "movie-comes" ,  "always-seems" ,  "result-film" ,  "100-minutes" ,  "bad-things" ,  "film-contains" ,  "fall-love" ,  "jerry-maguire" ,  "kids-over" ,  "quite-sure" ,  "teenagers-older" ,  "theres-still" ,  "points-out" ,  "eddie-murphy" ,  "make-feel" ,  "20th-century" ,  "two-main" ,  "martial-arts" ,  "rated-sexual" ,  "theres-doubt" ,  "film-long" ,  "thats-one" ,  "isnt-one" ,  "one-big" ,  "movie-full" ,  "movie-gets" ,  "battle-scenes" ,  "live-die" ,  "funny-one" ,  "over-two" ,  "sense-sensibility" ,  "film-funny" ,  "movie-still" ,  "theres-even" ,  "one-movies" ,  "refreshing-see" ,  "ado-nothing" ,  "didnt-make" ,  "waiting-guffman" ,  "frontal-nudity" ,  "robert-duvall" ,  "thats-exactly" ,  "even-best" ,  "much-longer" ,  "worth-noting" ,  "george-lucas" ,  "stands-out" ,  "violence-sexuality" ,  "way-long" ,  "love-interest" ,  "message-film" ,  "opening-sequence" ,  "movie-little" ,  "during-movie" ,  "matter-much" ,  "nutty-professor" ,  "fun-watching" ,  "tim-burton" ,  "time-kill" ,  "nudity-fine" ,  "come-expect" ,  "one-characters" ,  "fall-flat" ,  "columbia-pictures" ,  "independent-film" ,  "through-eyes" ,  "language-sexuality" ,  "movie-1/2" ,  "robert-niro" ,  "basic-instinct" ,  "runs-feels" ,  "company-men" ,  "scenes-film" ,  "thumbs-1/2" ,  "youll-probably" ,  "more-less" ,  "press-notes" ,  "two-hour" ,  "one-really" ,  "nothing-much" ,  "more-real" ,  "sundance-film" ,  "musical-score" ,  "more-powerful" ,  "good-guy" ,  "best-supporting" ,  "nothing-short" ,  "hunchback-notre" ,  "film-few" ,  "suspend-disbelief" ,  "isnt-funny" ,  "somewhere-between" ,  "supporting-roles" ,  "bathroom-humor" ,  "distributor-miramax" ,  "film-movie" ,  "more-concerned" ,  "little-sex" ,  "characters-dont" ,  "lost-highway" ,  "worse-still" ,  "minute-running" ,  "made-look" ,  "movie-feels" ,  "less-successful" ,  "during-first" ,  "art-film" ,  "sleepless-seattle" ,  "kevin-spacey" ,  "las-vegas" ,  "virtually-nothing" ,  "guilty-pleasure" ,  "time-movies" ,  "attention-detail" ,  "true-lies" ,  "french-film" ,  "family-films" ,  "seen-movie" ,  "fun-film" ,  "plays-part" ,  "center-stage" ,  "free-willy" ,  "mystery-story" ,  "see-again" ,  "comes-alive" ,  "something-little" ,  "movie-features" ,  "made-movie" ,  "far-away" ,  "piece-acting" ,  "scenes-one" ,  "story-seems" ,  "director-james" ,  "those-moments" ,  "movie-two" ,  "scary-movie" ,  "director-richard" ,  "blown-away" ,  "time-spent" ,  "coen-brothers" ,  "doesnt-appear" ,  "boogie-nights" ,  "early-film" ,  "more-enjoyable" ,  "les-miserables" ,  "film-kind" ,  "last-action" ,  "universal-pictures" ,  "film-industry" ,  "film-look" ,  "minutes-long" };

	public static String[] bigramList={"films-year" , "see-film" , "motion-picture" , "film-excellent" , "movie-kind" , "waste-money" , "average-movie" , "dont-waste" , "show-dont" , "excellent-show" , "show-look" , "kind-enjoyable" , "enjoyable-poor" , "poor-show" , "look-average" , "opinions-expressed" , "meant-reflect" , "mine-meant" , "reflect-employers" , "expressed-mine" , "running-time" , "few-films" , "one-worst" , "worst-films" , "message-subject" , "reply-message" , "details-reply" , "one-top" , "money-one" , "year-see" , "totally-unbearable" , "year-totally" , "top-few" , "rated-pg-13" , "mpaa-rating" , "subject-line" , "much-more" , "even-though" , "special-effects" , "even-more" , "little-more" , "adult-themes" , "unbearable-opinions" , "fine-kids" , "screening-room" , "son-jeffrey" , "see-screening" , "subject-subscribe" , "room-details" , "much-better" , "fine-teenagers" , "one-those" , "kids-around" , "sex-nudity" , "see-moviepage" , "moviepage-details" , "line-subscribe" , "jeffrey-age" , "painfully-unbearable" , "money-totally" , "unbearable-picture" , "totally-painfully" , "sexual-situations" , "turns-out" , "older-teenagers" , "english-subtitles" , "theres-nothing" , "review-written" , "romantic-comedy" , "film-one" , "word-subscribe" , "letter-word" , "subscribe-subject" , "send-letter" , "acceptable-teenagers" , "screen-time" , "motion-pictures" , "running-length" , "love-story" , "character-study" , "film-makers" , "mature-themes" , "two-hours" , "far-more" , "subject-matter" , "between-two" , "runs-rated" , "acceptable-older" , "chemistry-between" , "one-thing" , "action-sequences" , "film-more" , "first-time" , "bad-language" , "character-development" , "brief-nudity" , "themes-running" , "supporting-cast" , "one-best" , "theres-something" , "rated-violence" , "profanity-adult" , "rating-pg-13" , "violence-profanity" , "star-wars" , "film-fine" , "picture-opinions" , "figure-out" , "time-minutes" , "acceptable-kids" , "language-acceptable" , "give-1/2" , "academy-award" , "nudity-violence" , "high-school" , "part-film" , "science-fiction" , "writer-director" , "first-half" , "1/2-one" , "film-made" , "box-office" , "action-film" , "main-characters" , "dont-know" , "last-years" , "more-interesting" , "subtitles-rated" , "one-many" , "great-deal" , "best-part" , "film-doesnt" , "along-way" , "doesnt-seem" , "theres-much" , "rating-profanity" , "bad-guys" , "unbearable-review" , "dont-think" , "takes-place" , "relationship-between" , "youve-seen" , "give-film" , "very-little" , "woody-allen" , "long-rated" , "big-screen" , "many-scenes" , "pulp-fiction" , "isnt-much" , "years-ago" , "movie-one" , "new-york" , "rated-strong" , "runs-long" , "director-john" , "want-see" , "see-movie" , "many-times" , "rated-sex" , "something-more" , "film-noir" , "one-more" , "worth-seeing" , "half-hour" , "ingmar-bergman" , "film-festival" , "never-quite" , "many-ways" , "doesnt-make" , "long-time" , "rated-language" , "bit-more" , "much-time" , "film-never" , "soap-opera" , "dont-want" , "movie-nothing" , "film-even" , "one-films" , "second-half" , "film-rated" , "nothing-more" , "kind-film" , "black-white" , "very-good" , "1997-opinions" , "make-sense" , "robin-williams" , "theres-little" , "make-film" , "one-few" , "profanity-violence" , "part-movie" , "one-scene" , "1/2-see" , "never-seen" , "sit-through" , "found-myself" , "film-making" , "film-much" , "picture-review" , "black-comedy" , "die-hard" , "film-makes" , "one-film" , "movie-rated" , "lot-more" , "screen-presence" , "profanity-fine" , "down-david" , "belief-movie" , "david-puttnam" , "nothing-life" , "sexual-content" , "people-neutral" , "makes-film" , "leave-down" , "neutral-leave" , "leaves-people" , "leave-leave" , "life-leaves" , "made-film" , "very-funny" , "theres-lot" , "very-much" , "give-one" , "enough-make" , "drug-use" , "based-novel" , "star-trek" , "written-directed" , "two-leads" , "one-point" , "action-films" , "pg-13-profanity" , "anything-more" , "film-takes" , "drug-usage" , "horror-film" , "ive-seen" , "sense-humor" , "doesnt-take" , "violence-language" , "put-together" , "film-maker" , "pg-13-violence" , "comic-relief" , "jurassic-park" , "feature-film" , "best-thing" , "nudity-profanity" , "first-place" , "film-film" , "theres-enough" , "plot-device" , "quite-good" , "violence-running" , "seen-before" , "movie-isnt" , "reason-see" , "doesnt-much" , "profanity-running" , "movie-more" , "without-being" , "violence-fine" , "many-characters" , "opening-credits" , "tell-story" , "doesnt-work" , "sight-gags" , "bad-movie" , "good-film" , "once-again" , "teenagers-send" , "kind-movie" , "real-life" , "action-scenes" , "plot-twists" , "age-gave" , "those-films" , "physical-comedy" , "fairy-tale" , "show-fine" , "find-yourself" , "film-director" , "theres-one" , "seems-more" , "one-another" , "good-enough" , "great-film" , "first-film" , "mpaa-classification" , "turn-out" , "much-fun" , "true-story" , "bad-guy" , "entertainment-value" , "old-enough" , "more-interested" , "recommend-give" , "fifteen-minutes" , "one-expect" , "one-character" , "fine-older" , "recommend-film" , "length-mpaa" , "hard-believe" , "good-movie" , "way-through" , "mature-teenagers" , "comic-book" , "rest-movie" , "rated-profanity" , "leave-theater" , "around-son" , "sitting-through" , "film-isnt" , "taking-place" , "same-time" , "even-better" , "rest-film" , "correctly-rated" , "director-robert" , "french-english" , "entire-movie" , "ensemble-cast" , "one-two" , "happy-ending" , "theres-more" , "waste-time" , "tries-hard" , "fine-line" , "romantic-comedies" , "throughout-film" , "come-out" , "violence-acceptable" , "profanity-sexual" , "many-films" , "pretty-good" , "never-really" , "men-women" , "much-film" , "make-sure" , "film-very" , "story-told" , "point-out" , "supporting-characters" , "doesnt-really" , "television-series" , "themes-profanity" , "story-itself" , "first-hour" , "story-film" , "film-works" , "story-line" , "story-more" , "james-bond" , "mission-impossible" , "family-film" , "serial-killer" , "entire-film" , "unbearable-reviewed" , "good-time" , "few-minutes" , "action-hero" , "quentin-tarantino" , "reviewed-written" , "director-peter" , "lion-king" , "schindlers-list" , "toy-story" , "making-film" , "telling-story" , "rated-probably" , "times-before" , "gives-film" , "give-see" , "movie-made" , "main-character" , "film-itself" , "even-those" , "more-effective" , "recommend-movie" , "feel-good" , "ten-minutes" , "manages-make" , "more-one" , "hour-half" , "movie-never" , "film-many" , "five-minutes" , "whole-lot" , "film-seems" , "love-affair" , "best-film" , "kids-under" , "film-good" , "low-budget" , "film-without" , "movie-doesnt" , "doesnt-know" , "visual-effects" , "many-people" , "recommend-picture" , "twenty-minutes" , "trying-make" , "romance-between" , "more-impressive" , "home-alone" , "best-performance" , "perhaps-best" , "ages-son" , "quite-funny" , "1995-opinions" , "1996-opinions" , "very-well" , "out-film" , "makes-sense" , "good-sense" , "twists-turns" , "human-beings" , "closing-credits" , "end-film" , "minutes-film" , "see-one" , "part-story" , "bad-film" , "thumbs-down" , "screenplay-david" , "without-much" , "both-sides" , "nudity-sex" , "age-thought" , "better-film" , "length-rated" , "sexuality-acceptable" , "film-give" , "cant-help" , "film-offers" , "musical-numbers" , "independence-day" , "director-michael" , "little-bit" , "end-credits" , "story-one" , "director-david" , "out-one" , "gave-film" , "film-little" , "rating-violence" , "high-energy" , "out-loud" , "thirty-minutes" , "source-material" , "well-worth" , "same-way" , "whats-going" , "film-ends" , "set-pieces" , "give-movie" , "more-time" , "dont-care" , "one-better" , "first-part" , "fun-watch" , "point-view" , "recommend-show" , "press-screening" , "way-film" , "slice-life" , "rest-cast" , "problem-film" , "think-film" , "ninety-minutes" , "point-film" , "award-1/2" , "few-scenes" , "noir-film" , "entertaining-film" , "film-comes" , "movie-itself" , "few-times" , "little-profanity" , "line-between" , "one-great" , "many-movies" , "target-audience" , "despite-being" , "steven-seagal" , "sexuality-language" , "films-one" , "although-film" , "strong-violence" , "take-place" , "violence-sex" , "half-film" , "characters-situations" , "pretty-much" , "language-violence" , "although-movie" , "easy-see" , "silicon-valley" , "title-character" , "make-movie" , "violence-adult" , "film-those" , "few-good" , "last-act" , "fine-teenager" , "ending-credits" , "suspension-disbelief" , "fair-amount" , "back-forth" , "pg-13-sexual" , "difference-between" , "havent-seen" , "seem-more" , "two-films" , "bond-films" , "doesnt-quite" , "seeing-film" , "pop-culture" , "horror-films" , "walk-out" , "good-one" , "one-one" , "wonderful-life" , "though-film" , "turned-out" , "credits-roll" , "find-film" , "date-released" , "movie-takes" , "good-idea" , "more-important" , "especially-those" , "work-well" , "jackie-chan" , "strong-language" , "older-mature" , "story-doesnt" , "between-art" , "many-viewers" , "human-being" , "something-mary" , "much-less" , "film-well" , "camera-work" , "time-film" , "drug-content" , "bruce-willis" , "time-around" , "lot-fun" , "first-time-director" , "something-between" , "written-january" , "themes-violence" , "beginning-end" , "film-probably" , "long-enough" , "century-theaters" , "hong-kong" , "language-fine" , "piece-work" , "few-moments" , "out-place" , "art-films" , "1994-opinions" , "film-acceptable" , "facial-expressions" , "pg-13-brief" , "short-cuts" , "watching-movie" , "recent-films" , "film-becomes" , "two-characters" , "anthony-hopkins" , "much-movie" , "martin-scorsese" , "miramax-films" , "one-good" , "jean-luc-godard" , "many-different" , "violence-sexual" , "sexual-humor" , "movie-makes" , "directorial-debut" , "time-movie" , "good-guys" , "fine-ages" , "parts-movie" , "best-picture" , "one-reasons" , "picture-give" , "live-action" , "funny-moments" , "clint-eastwood" , "amc-century" , "minor-characters" , "social-commentary" , "film-gets" , "film-really" , "teenagers-recommend" , "good-job" , "works-best" , "one-favorite" , "mild-profanity" , "thought-movie" , "doesnt-mean" , "horror-movie" , "nudity-language" , "such-films" , "characters-film" , "few-years" , "more-serious" , "films-made" , "art-life" , "pg-13-adult" , "warner-brothers" , "thematic-elements" , "dont-see" , "forrest-gump" , "life-piece" , "far-less" , "thing-film" , "cinema-both" , "life-takes" , "language-drug" , "movie-fine" , "cinema-something" , "bad-taste" , "straight-out" , "weve-seen" , "last-summer" , "film-see" , "film-critics" , "situations-adult" , "make-mistake" , "long-way" , "few-more" , "movie-runs" , "violence-film" , "films-life" , "themes-sexual" , "violence-bad" , "parts-film" , "come-close" , "nudity-sexual" , "sex-violence" , "both-gives" , "unlike-painting" , "painting-literature" , "press-kit" , "cinema-art" , "cinema-slice" , "piece-cake" , "emotional-impact" , "life-unlike" , "film-didnt" , "film-still" , "literature-cinema" , "arent-many" , "takes-jean-luc" , "film-cant" , "more-few" , "watching-film" , "well-done" , "never-seems" , "good-bad" , "gave-1/2" , "one-way" , "make-more" , "becomes-more" , "jim-carrey" , "film-set" , "gives-life" , "first-movie" , "movie-filled" , "life-cinema" , "find-out" , "really-good" , "central-character" , "good-evil" , "plot-elements" , "sexual-innuendo" , "sandra-bullock" , "movie-thats" , "van-damme" , "united-states" , "story-never" , "few-laughs" , "film-best" , "little-mermaid" , "character-film" , "loose-ends" , "worth-caring" , "starship-troopers" , "steven-spielberg" , "classification-mpaa" , "isnt-nearly" , "type-film" , "mild-thumbs" , "nothing-special" , "make-much" , "acting-ability" , "very-bad" , "good-thing" , "film-thats" , "films-best" , "enough-recommend" , "last-year" , "many-more" , "enough-interested" , "valley-showing" , "film-opens" , "much-same" , "start-finish" , "smart-enough" , "doesnt-offer" , "problem-movie" , "best-known" , "better-movie" , "certainly-isnt" , "sort-movie" , "worth-price" , "doesnt-matter" , "pg-13-language" , "little-long" , "theaters-send" , "dumb-dumber" , "those-dont" , "content-acceptable" , "saving-grace" , "movie-bad" , "beauty-beast" , "film-story" , "more-fun" , "sex-scenes" , "rated-nudity" , "isnt-bad" , "film-version" , "doesnt-even" , "reservoir-dogs" , "doesnt-help" , "period-piece" , "rated-brief" , "film-seem" , "film-seen" , "film-such" , "way-out" , "out-way" , "even-worse" , "youre-going" , "production-values" , "film-tries" , "art-house" , "oliver-stone" , "script-doesnt" , "each-one" , "pleasant-enough" , "long-before" , "many-things" , "itself-seriously" , "fine-job" , "slow-motion" , "film-first" , "those-rare" , "take-long" , "language-film" , "year-old" , "one-long" , "much-sense" , "language-sexual" , "dont-make" , "didnt-know" , "situations-running" , "much-story" , "works-well" , "best-films" , "films-such" , "romeo-juliet" , "aspect-ratio" , "debut-feature" , "those-enjoy" , "far-better" , "films-title" , "pg-13-mature" , "blair-witch" , "fine-kid" , "gave-movie" , "kenneth-branagh" , "best-work" , "films-end" , "movie-best" , "makes-one" , "more-compelling" , "more-plot" , "found-film" , "fifth-element"};

	public static FileOutputStream fstream2 ;
	public static DataOutputStream in2 ;
	public static BufferedWriter br2;

	public static boolean trainFlag =false;
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


			for(String s :reviewerFeaturesWords){
				//System.out.println(s);

				reviewerFeaturesWordsList.add(s);

			}


			for(String s :distWords){
				//System.out.println(s);

				distWordslist.add(s);

			}



			for(String s :reviewerFeaturesbigramWords){
				//System.out.println(s);

				reviewerFeaturesbigramWordsList.add(s);

			}

			outFile+=args[0]+"-"+args[1]+".arff";
			FileInputStream fstream = new FileInputStream(args[1]);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));


			fstream2 = new FileOutputStream("alllistuni_4"+args[0]+".txt");
			in2 = new DataOutputStream(fstream2);
			br2 = new BufferedWriter(new OutputStreamWriter(in2));


			fstream3 = new FileOutputStream(outFile);
			in3 = new DataOutputStream(fstream3);
			br3 = new BufferedWriter(new OutputStreamWriter(in3));




			fstream4 = new FileOutputStream("all_quotes_list_desc_4"+args[0]+".txt");
			in4 = new DataOutputStream(fstream4);
			br4 = new BufferedWriter(new OutputStreamWriter(in4));


			CountGenerator cg = new CountGenerator();

			String strLine;
			int cnt =0,negCnt=0,posCnt=0;
			Pattern pattern ;

			if(args[0].equalsIgnoreCase("train")){
				pattern= Pattern.compile("<id>(.*)</id><reviewer>(.*)</reviewer><star>(.*)</star><review>(.*)</review>.*");
				trainFlag=true;
			}
			else{
				pattern= Pattern.compile("<id>(.*)</id><review>(.*)</review>.*");
				trainFlag=false;
			}


			Matcher matcher;

			while ((strLine = br.readLine()) != null)   {

				matcher = pattern.matcher(strLine);
				while (matcher.find()) {
					cnt++;


					String id ;
					String reviewer ;
					String star  ;
					String match ;
					int starr =-1;

					if(trainFlag){
						id = matcher.group(1).trim();
						reviewer = matcher.group(2).trim();
						star = matcher.group(3).trim();
						match = matcher.group(4).trim();
						starr=Integer.parseInt(star);
						if(starr<=2){
							negCnt++;
						}
						else{
							posCnt++;
						}
					}
					else{
						id = matcher.group(1).trim();
						reviewer = "?";
						star ="?";
						match = matcher.group(2).trim();
					}

					cg.getCount(match,cnt,starr,reviewer, id,trainFlag);

				}

			}


			br2.write("-----------------pos------------------");
			br2.newLine();
			br4.write("-----------------pos------------------");
			br4.newLine();
			//printHashTable(cg.wordList);
			//printHashTable2(cg.poswordList);
			br2.newLine();
			br2.newLine();
			br2.newLine();
			br2.newLine();
			br2.write("-----------------neg------------------");
			br2.newLine();
			br4.write("-----------------neg------------------");
			br4.newLine();
			//printHashTable(cg.poswordList);
			//printHashTable2(cg.negwordList);

			br2.newLine();
			br2.newLine();
			br2.newLine();
			br2.newLine();






			br2.write("-----------------star 1------------------");
			br2.newLine();
			br4.write("-----------------star 1------------------");
			br4.newLine();
			//printHashTable(cg.wordList);
			//printHashTable2(cg.star1wordList);
			br2.newLine();
			br2.newLine();
			br2.newLine();
			br2.newLine();
			br2.write("-----------------star 2------------------");
			br2.newLine();
			br4.write("-----------------star 2------------------");
			br4.newLine();
			//printHashTable(cg.poswordList);
			//printHashTable2(cg.star2wordList);
			br2.newLine();
			br2.newLine();
			br2.newLine();
			br2.newLine();
			br2.write("-----------------star 3------------------");
			br2.newLine();
			br4.write("-----------------star 3------------------");
			br4.newLine();
			//printHashTable(cg.negwordList);
			//printHashTable2(cg.star3wordList);

			br2.newLine();
			br2.newLine();
			br2.newLine();
			br2.newLine();

			br2.write("-----------------star 4------------------");
			br2.newLine();
			br4.write("-----------------star 4------------------");
			br4.newLine();
			//printHashTable2(cg.star4wordList);
			br2.newLine();
			br2.newLine();
			br2.newLine();
			br2.newLine();






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

			if(trainFlag){
				POSFileReader pos = new POSFileReader();
				pos.getCount("parsedCorpus.txt");
			}

			//XXXXXXXXXXXXXXXXX
			//printDocList2(cg);
			printDocListForReviewer(cg,args[0]);


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


			//compareList(cg.posWords,oldposwordss);

			//compareList(cg.negWords,oldnegwordss);

			//printBigram();

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







	private static void printDocListForReviewer(CountGenerator cg, String casee ) throws IOException {
		// TODO Auto-generated method stub

		br3.write("@RELATION reviewer"+casee+"ing");
		br3.newLine();
		br3.newLine();
		br3.newLine();




		for(int i=0;i<reviewerFeaturesWords.length;i++){

			br3.write("@ATTRIBUTE "+reviewerFeaturesWords[i]+" NUMERIC");
			br3.newLine();


		}

		for(int i=0;i<reviewerFeaturesbigramWords.length;i++){

			br3.write("@ATTRIBUTE "+reviewerFeaturesbigramWords[i]+" NUMERIC");
			br3.newLine();


		}





		br3.write("@ATTRIBUTE doclength NUMERIC");
		br3.newLine();


		br3.write("@ATTRIBUTE diffposs NUMERIC");
		br3.newLine();





		br3.write("@ATTRIBUTE NNCount NUMERIC");
		br3.newLine();



		br3.write("@ATTRIBUTE NNPairCount NUMERIC");
		br3.newLine();


		br3.write("@ATTRIBUTE classFinal {A,B,C,D}");
		br3.newLine();

		br3.newLine();
		br3.newLine();
		br3.write("@DATA");
		br3.newLine();
		br3.flush();


		for(Document d : cg.docList){


			for(int i=0;i<reviewerFeaturesWords.length;i++){

				if(d.termFrequency.containsKey(reviewerFeaturesWords[i])){

					double tf=((d.termFrequency.get(reviewerFeaturesWords[i]))/(d.countWords));

					ArrayList<Integer> listt=cg.docFrequency.get(reviewerFeaturesWords[i]);

					double df=Math.log(cg.docCount/listt.size());
					double tfidf=tf*df;

					br3.write(tf+",");
				}
				else{
					br3.write("0,");
				}


			}


			for(int i=0;i<reviewerFeaturesbigramWords.length;i++){

				if(d.bigramtermFrequency.containsKey(reviewerFeaturesbigramWords[i])){

					double tf=((d.bigramtermFrequency.get(reviewerFeaturesbigramWords[i]))/(d.bicountWords));



					br3.write(tf+",");
				}
				else{
					br3.write("0,");
				}


			}







			br3.write(d.countWords+",");



			if(((d.posWords/d.countWords)-(d.negWords/d.countWords))>0){
				br3.write((d.posWords/d.countWords)-(d.negWords/d.countWords)+",");

			}
			else{
				br3.write(0+",");

			}










			br3.write(d.NNcount/d.countWords+",");

			br3.write(d.NNpaircount/d.countWords+",");



			if(casee.equalsIgnoreCase("train")){
				br3.write(d.reviewer);
			}
			else{
				br3.write("?");
			}
			br3.newLine();
			br3.flush();

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

		//sortbigram(cg);



		int cSize=FEATcnt;
		if(poswordlistkeys.length<cSize-1){
			cSize=poswordlistkeys.length+1;
		}
		for(int i=(poswordlistkeys.length-1);i>(poswordlistkeys.length-cSize);i--){

			br3.write("@ATTRIBUTE "+poswordlistkeys[i]+" NUMERIC");
			br3.newLine();
			printedposlist.add(poswordlistkeys[i]);

		}


		int cSizeNeg=FEATcnt;
		if(negwordlistkeys.length<cSizeNeg-1){
			cSizeNeg=negwordlistkeys.length+1;
		}
		for(int i=(negwordlistkeys.length-1);i>(negwordlistkeys.length-cSizeNeg);i--){

			br3.write("@ATTRIBUTE "+negwordlistkeys[i]+" NUMERIC");
			br3.newLine();

			printedneglist.add(negwordlistkeys[i]);
		}



		/*
		int cSizebigram=1001;
		if(bigramwordlistkeys.length<cSizebigram-1){
			cSizebigram=bigramwordlistkeys.length+1;
		}
		for(int i=(bigramwordlistkeys.length-1);i>(bigramwordlistkeys.length-cSizebigram);i--){
			if((!cg.negWords.contains(bigramwordlistkeys[i])) && (!cg.posWords.contains(bigramwordlistkeys[i]))){
				br3.write("@ATTRIBUTE "+bigramwordlistkeys[i]+" NUMERIC");
				br3.newLine();
			}

		}
		 */


		for(int i=0;i<distWords.length;i++){
			if((!printedneglist.contains(distWords[i])) && (!printedposlist.contains(distWords[i]))){
				br3.write("@ATTRIBUTE "+distWords[i]+" NUMERIC");
				br3.newLine();
			}

		}

		for(int i=0;i<bigramList.length;i++){
			if((!printedneglist.contains(bigramList[i])) && (!printedposlist.contains(bigramList[i]))){
				br3.write("@ATTRIBUTE "+bigramList[i]+" NUMERIC");
				br3.newLine();
			}

		}


		//int cSizet=FEATcnt;
		int cSizet=11;
		if(wordlistkeys.length<cSizet){
			cSizet=wordlistkeys.length+1;
		}
		for(int i=(wordlistkeys.length-1);i>(wordlistkeys.length-cSizet);i--){
			if((!printedneglist.contains(wordlistkeys[i])) && (!printedposlist.contains(wordlistkeys[i]))  && (!distWordslist.contains(wordlistkeys[i]))){
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

		br3.write("@ATTRIBUTE diffposs NUMERIC");
		br3.newLine();
		br3.write("@ATTRIBUTE diffneg NUMERIC");
		br3.newLine();



		br3.write("@ATTRIBUTE notWord NUMERIC");
		br3.newLine();


		br3.write("@ATTRIBUTE commaWord NUMERIC");
		br3.newLine();



		br3.write("@ATTRIBUTE extremeWord NUMERIC");
		br3.newLine();


		br3.write("@ATTRIBUTE NNCount NUMERIC");
		br3.newLine();



		br3.write("@ATTRIBUTE NNPairCount NUMERIC");
		br3.newLine();

		//br3.write("@ATTRIBUTE classFinal {0,1}");
		//br3.write("@ATTRIBUTE classFinal {1,2,3,4}");
		br3.write("@ATTRIBUTE classFinal {A,B,C,D}");
		br3.newLine();

		br3.newLine();
		br3.newLine();
		br3.write("@DATA");
		br3.newLine();
		br3.flush();


		for(Document d : cg.docList){




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


			/*

			for(int i=(bigramwordlistkeys.length-1);i>(bigramwordlistkeys.length-cSizebigram);i--){

				if((!cg.negWords.contains(bigramwordlistkeys[i])) && (!cg.posWords.contains(bigramwordlistkeys[i]))){


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


			 */



			for(int i=0;i<distWords.length;i++){
				if((!printedneglist.contains(distWords[i])) && (!printedposlist.contains(distWords[i]))){
					if(d.termFrequency.containsKey(distWords[i])){

						double tf=((d.termFrequency.get(distWords[i]))/(d.countWords));

						ArrayList<Integer> listt=cg.docFrequency.get(distWords[i]);

						double df=Math.log(cg.docCount/listt.size());
						double tfidf=tf*df;

						br3.write(tf+",");
					}
					else{
						br3.write("0,");
					}
				}

			}


			for(int i=0;i<bigramList.length;i++){
				if((!printedneglist.contains(bigramList[i])) && (!printedposlist.contains(bigramList[i]))){
					if(d.bigramtermFrequency.containsKey(bigramList[i])){

						double tf=((d.bigramtermFrequency.get(bigramList[i]))/(d.bicountWords));

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
				if((!printedneglist.contains(wordlistkeys[i])) && (!printedposlist.contains(wordlistkeys[i])) && (!distWordslist.contains(wordlistkeys[i]))){
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







			if(cg.docFrequency.containsKey("notWords")){

				double tf=d.notWords/d.countWords;

				ArrayList<Integer> listt=cg.docFrequency.get("notWords");

				double df=Math.log(cg.docCount/listt.size());
				double tfidf=tf*df;

				br3.write(tfidf+",");
			}
			else{
				br3.write("0,");
			}

			if(cg.docFrequency.containsKey("commaWords")){

				double tf=d.commaWords/d.countWords;

				ArrayList<Integer> listt=cg.docFrequency.get("commaWords");

				double df=Math.log(cg.docCount/listt.size());
				double tfidf=tf*df;

				br3.write(tfidf+",");
			}
			else{
				br3.write("0,");
			}


			if(cg.docFrequency.containsKey("extremeWords")){

				double tf=d.extremeWords/d.countWords;

				ArrayList<Integer> listt=cg.docFrequency.get("extremeWords");

				double df=Math.log(cg.docCount/listt.size());
				double tfidf=tf*df;

				br3.write(tfidf+",");
			}
			else{
				br3.write("0,");
			}


			//br3.write(d.notWords/d.countWords+",");

			//br3.write(d.commaWords/d.countWords+",");

			//br3.write(d.extremeWords/d.countWords+",");



			br3.write(d.NNcount/d.countWords+",");

			br3.write(d.NNpaircount/d.countWords+",");



			String sstar=""+d.star;

			//br3.write(sstar);
			br3.write(d.reviewer);

			/*
			if(d.star>=3){
				br3.write("1");
			}
			else{
				br3.write("0");
			}

			 */
			br3.newLine();
			br3.flush();

		}


	}





	private static void printDocList_50_multi(CountGenerator cg ) throws IOException {

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
			if((!cg.negWords.contains(bigramwordlistkeys[i])) && (!cg.posWords.contains(bigramwordlistkeys[i]))){
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

				if((!cg.negWords.contains(bigramwordlistkeys[i])) && (!cg.posWords.contains(bigramwordlistkeys[i]))){


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




	private static void printDocList_reviewer(CountGenerator cg) throws IOException {

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




	private static void printHashTable2(Hashtable<String, Integer> poswordList2) throws IOException {

		String []wordkeys = new String[poswordList2.size()];
		Enumeration en=poswordList2.keys();
		int kk=0;
		while( en. hasMoreElements() ){
			wordkeys[kk] = (String)en.nextElement() ;
			kk++;
		}

		Integer []wordvals = new Integer[poswordList2.size()];
		Enumeration env=poswordList2.keys();
		int kkk=0;
		while( env. hasMoreElements() ){
			String keyss = (String)env.nextElement() ;
			wordvals[kkk]=poswordList2.get(keyss);
			kkk++;
		}


		//bubblesortFinal(wordkeys,wordvals);


		int n = wordvals.length;
		for (int pass=1; pass < n; pass++) {  // count how many times
			// This next loop becomes shorter and shorter
			for (int i=0; i < n-pass; i++) {
				if (wordvals[i] > wordvals[i+1]) {
					// exchange elements
					int temp = wordvals[i];  wordvals[i] = wordvals[i+1];  wordvals[i+1] = temp;
					String tempp = wordkeys[i];  wordkeys[i] = wordkeys[i+1];  wordkeys[i+1] = tempp;
				}
			}
		}




		for(int i=(wordkeys.length-1);i>=0;i--){

			br2.write(wordkeys[i]+" "+wordvals[i]);
			br2.newLine();
			br4.write("\""+wordkeys[i]+"\"");
			br4.newLine();

		}


	}



	private static void bubblesortFinal(String[] wordkeys, Integer[] wordvals) {
		// TODO Auto-generated method stub

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
