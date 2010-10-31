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

	public static int FEATcnt =5001;

	public static String outFile6="FinArff"+"-binary-newterms-";
	public static String outFile="FinArff"+"_reviewer-";
	public static String outFile2="FinArff"+"_binary-f-";
	public static String outFile3="FinArff"+"_binary-extra-reviewer-f-";
	public static String outFile4="FinArff"+"_multi-f-";
	public static String outFile5="FinArff"+"_multi-extra-reviewer-f-D-";


	public static String[] oldposwordss= {"captivating","wise","perfection","Absolutely","compelling","cogent","convince","amazing","payoff","tremendous","revealing","brilliance","genuinely","gracefully","importance","intrinsic","masterly","involved","memorable","simplicity","unfold","unfolds","unmatched","outdoes","rarely","successfully","successful","accomplished","great","imagination","exhibited","imagined","intriguing","masterpiece","masterpieces","pleased","monumental","inspiring","intelligent","masterful","smoothly","different","Abundant","Acclaimed","Accomplishment","Achievement","Acumen","Admire","Adorable","Adored","Affirmative","Affluent","Amaze","Amity","Appreciation","Approve","Artistic","Astonish","Astounding","Astute","surprises","Attractive","good","entertaining","entertained","entertain","special","Authentic","engaging","interesting","Beautiful","Benefit","Blessed","Bliss","Bloom","Bountiful","Bounty","Brave","Bright","Brilliant","Bubbly","Calm","Celebrate","Charitable","Charming","Cheer","Cherish","Clarity","Classy","Clean","Clever","Closeness","Commend","Companionship","Complete","Comradeship","Confident","Conviction","Copious","Core","Coupled","Courageous","Creative","Cultivate","Curious","Cute","Dazzling","Delight","Distinguished","Divine","Earnest","Ecstasy","Effervescent","Efficient","Effortless","Electrifying","Elegance","Embrace","Encompassing","Encourage","Endorse","Energized","Energy","Enjoy","Enjoyed","Enormously","Enthuse","Enthusiastic","Essence","Established","Esteem","Esteemed","Excited","Exciting","Exhilarating","Exquisite","Exultant","Faith","Famous","Feat","Flourish","Fortunate","Fortune","Freedom","Fresh","Funny","authenticity","grit","gritty","improvise","improvisational","libbing","satisfying","surprisingly","unique","uniquely","unnerving","Generous","Genius","Genuine","accurately","accurate","mysterious","suprisingly","best","classic","deserved","deservedly","glib","glibness","honors","profound","realistic","justice","poignant","poignancy","reminiscent","Glad","Glow","Gorgeous","Grace","Graceful","Gratitude","Handsome","Harmony","Healthy","Hearty","Heavenly","Helpful","Holy","Honest","Honored","affirm","Ideal","Imaginative","Increase","Incredible","Independent","Ingenious","Innate","Innovate","Inspire","Instantaneous","Instinct","Intellectual","Intelligence","Intuitive","Inventive","Jovial","Jubilation","Keen","Key","Knowledge","Laugh","Leader","Learn","Legendary","Light","Lively","merit","merits","stunning","magnificently","neat","tender","topped","nice","nicely","noteworthy","Loveliness","Lucidity","Lucrative","Luminous","Maintain","Marvelous","Master","Meaningful","Meditate","Mend","Metamorphosis","Mind-Blowing","Miracle","Mission","Modify","Motivate","Moving","Natural","Nature","Nourish","Nourished","Novel","Nurture","Nutritious","Open","Openhanded","Optimistic","Paradise","Peace","Perfect","Phenomenon","Pleasure","Plenteous","Plentiful","Plenty","Plethora","Poise","Polish","Popular","Positive","Powerful","Prepared","Pretty","Principle","Productive","Project","Prominent","Prosperous","Protect","Proud","Quest","Ready","Recognized","Refinement","Refresh","Rejoice","Rejuvenate","Relax","Reliance","Rely","Remarkable","Renew","Renowned","Replenished","Resolution","Resound","Resources","Respect","Restore","Revered","Revolutionize","Rewarding","Robust","Rousing","Safe","Secure","Sensation","Serenity","Shift","Shine","Silence","Simple","Sincerity","Smart","Smooth","Solution","Sparkling","Spirit","Spirited","Spiritual","Splendid","Spontaneous","Stillness","Stir","Stirring","Strong","Style","Success","Sunny","Support","Surprise","Surprised","Sustain","Synchronized","Team","Thankful","Therapeutic","Thorough","Thrilled","Thrive","Tied","Today","Tranquil","Transform","Triumph","Unity","Unusual","Unwavering","Upbeat","Valued","Vary","Venerated","Venture","Vibrant","Victory","Vigorous","Vision","Visualize","Vital","Vivacious","Voyage","Welcome","Well","Whole","Wholesome","Wonder","Wonderful","Wondrous","Yes"};
	public static String[] oldnegwordss= {"mishandle","pedestrian","clich","average","misses","problem","rant","contrived","sink","painful","silly","stupidity","lamest","sorry","abandoned ","abused ","accused ","addicted ","afraid ","aggravated ","aggressive ","alone ","angry ","anguish ","annoyed ","futile","stereotypes","squirming","unnoticeable","unoriginal","vile","anxious ","apprehensive ","insipid","fail","melodramatic","missing","overkill","spoof","spoofing","weary","embarrassing","forgetable","regretable","vacuous","unnecessary","sardonic","sophomoric","argumentative ","artificial ","ashamed ","assaulted ","risk ","atrocious ","attacked ","avoided ","awful ","awkward ","bad ","badgered ","baffled ","banned ","barren ","belittled ","berated ","betrayed ","bitched ","bitter ","bizzare ","blacklisted ","blackmailed ","blamed ","bleak ","blown ","blur ","bored ","boring ","bossed-around ","bothered ","bothersome ","bounded ","boxed-in ","broken ","bruised ","brushed-off ","bugged ","bullied ","bummed ","burdened ","burdensome ","burned ","burned-out ","caged ","careless ","chaotic ","chased ","cheated ","chicken ","claustrophobic ","clingy ","closed ","clueless ","clumsy ","coaxed ","codependent ","coerced ","cold ","cold-hearted ","combative ","commanded ","competitive ","compulsive ","conceited ","concerned ","condescended ","confined ","conflicted ","confronted ","confused ","conned ","consumed ","contemplative ","contempt ","contentious ","controlled ","convicted ","cornered ","corralled ","cowardly ","crabby ","cramped ","cranky ","crap ","crappy ","crazy ","creeped ","creepy ","critical ","criticized ","cross ","crowded ","cruddy ","repulsive","unrehearsed","crummy ","crushed ","cut-down ","cut-off ","cynical","damaged ","damned ","dangerous ","dazed ","deceived ","defamed ","defeated ","defective ","defenseless ","defensive ","defiant ","deficient ","deflated ","degraded ","dehumanized ","dejected ","delicate ","deluded ","demanding ","demeaned ","demented ","demoralized ","demotivated ","dependent ","depleted ","depraved ","depressed ","deprived ","melodramatics","inconclusive","worst","punishment ","desolate ","despair ","despairing ","desperate ","despicable ","despised ","destroyed ","destructive ","detached ","detest ","detestable ","detested ","devalued ","devastated ","deviant ","devoid ","diagnosed ","dictated ","difficult ","directionless ","dirty ","disabled ","disagreeable ","disappointed ","disappointing ","disapproved ","disbelieved ","discardable ","discarded ","disconnected ","discontent ","discouraged ","discriminated ","disdain ","disdainful ","disempowered ","disenchanted ","disgraced ","disgruntled ","disgust ","disgusted ","disheartened ","dishonest ","dishonorable ","disillusioned ","dislike ","disliked ","dismal ","dismayed ","disorganized ","disoriented ","disowned ","displeased ","disposable ","disregarded ","disrespected ","dissatisfied ","distant ","distracted ","distraught ","distressed ","disturbed ","dizzy ","dominated ","doomed ","double-crossed ","doubted ","doubtful ","down ","downhearted ","downtrodden ","drained ","dramatic ","dread ","dreadful ","dreary ","dropped ","drunk ","dry ","dumb ","dumped ","duped","edgy ","egocentric ","egotistic ","egotistical ","elusive ","emancipated ","emasculated ","embarrassed ","emotional ","emotionless ","bankrupt ","empty ","encumbered ","endangered ","enraged ","enslaved ","entangled ","evaded ","evasive ","evicted ","excessive ","excluded ","exhausted ","exploited ","exposed ","failful","fake ","fearful ","fed ","flawed ","forced ","forgetful ","forgettable ","forgotten ","fragile ","freaked ","frightened ","frigid ","frustrated ","furious","gloomy ","glum ","gothic ","grey ","grief ","grim ","gross ","grossed-out ","grotesque ","grouchy ","grounded ","grumpy ","guilt-tripped ","guilty ","harassed ","hard ","hard-hearted ","harmed ","hassled ","hate ","hateful ","hatred ","haunted ","heartbroken ","heartless ","heavy-hearted ","helpless ","hesitant ","hideous ","hindered ","hopeless ","horrible ","horrified ","horror ","hostile ","hot-tempered ","humiliated ","hung ","hurried ","hysterical","idiotic ","ignorant ","ignored ","ill ","ill-tempered ","imbalanced ","imposed-upon ","impotent ","imprisoned ","impulsive ","dumps ","inactive ","inadequate ","incapable ","incommunicative ","incompetent ","incompatible ","incomplete ","incorrect ","indecisive ","indifferent ","indoctrinated ","inebriated ","ineffective ","inefficient ","inferior ","infuriated ","inhibited ","inhumane ","injured ","injusticed ","insane ","insecure ","insignificant ","insincere ","insufficient ","insulted ","intense ","interrogated ","interrupted ","intimidated ","intoxicated ","invalidated ","invisible ","irrational ","irritable ","irritated ","isolated","jaded","jealous ","jerked ","joyless ","labeled ","laughable ","lazy ","limited ","lonely ","lonesome ","lost ","lousy ","loveless ","low","mad ","manipulated ","masochistic ","messed ","messy ","miffed ","miserable ","misled ","mistaken ","mistreated ","mistrusted ","misunderstood ","mixed-up ","mocked ","molested ","moody","nagged ","needy ","negative ","nervous ","neurotic ","nonconforming ","numb ","nuts ","nutty","objectified ","obligated ","obsessed ","obsessive ","obstructed ","odd ","offended ","opposed ","oppressed ","over-controlled ","over-protected ","overwhelmed","panic ","paranoid ","passive ","pathetic ","pessimistic ","petrified ","phony ","pissed ","plain ","pooped ","poor ","powerless ","pre-judged ","preached","preoccupied ","predjudiced ","pressured ","prosecuted ","provoked ","psychopathic ","psychotic ","punished ","pushed ","puzzled ","quarrelsome ","queer ","questioned ","rage ","raped ","rattled ","regret ","rejected ","resented ","resentful ","responsible ","retarded ","revengeful ","ridiculed ","ridiculous ","robbed ","rotten ","sad ","sadistic ","sarcastic ","scared ","scarred ","screwed ","self-centered ","self-conscious ","self-destructive ","self-hatred ","selfish ","sensitive ","shy ","singled-out ","slow ","smothered ","snapped","spiteful ","stereotyped ","strange ","stressed ","stretched ","stuck ","stupid ","submissive ","suffering ","suffocated ","suicidal ","superficial ","suppressed ","suspicious"};
	public static String[] distWords={"poorly", "terrible", "avoid", "wasted", "seagal", "id", "unfunny", "fan", "embarrassing", "christopher", "unless", "batman", "dogs", "remotely", "clich", "ugly", "gratuitous", "inane", "painful", "youd", "mention", "imagination", "inept", "gun", "managed", "excuse", "depressing", "apparent", "stupidity", "apparently", "sitcom", "lawrence", "hands", "logic", "wayans", "include", "eddie", "101", "watchable", "decided", "therefore", "bore", "werent", "virtually", "bored", "thrillers", "dumber", "fathers", "carrey", "unpleasant", "alien", "nielsen", "blame", "shallow", "please", "lewis", "acted", "mans", "commercial", "cliches", "obnoxious", "havent", "uninteresting", "uninspired", "evidence", "naked", "irritating", "1995", "gotten", "drop", "box", "nasty", "offensive", "further", "started", "tired", "oh", "genuinely", "comparison", "category", "total", "shadow", "sister", "team", "ludicrous", "escape", "pretentious", "roger", "sorry", "admit", "trailers", "disaster", "buy", "basketball", "ad", "shoot", "pathetic", "crude", "farce", "hoping", "added", "beverly", "scream", "credible", "target", "begins", "promise", "leaving", "suspect", "fight", "worthwhile", "teen", "energetic", "promising", "featuring", "walk", "stuck", "mediocre", "budget", "sadly", "spends", "ride", "characterization", "protagonist", "enjoyed", "wait", "happening", "stock", "lesson", "spent", "alan", "davis", "tim", "climax", "price", "uneven", "songs", "numbers", "charming", "appreciate", "wedding", "jane", "significant", "parker", "largely", "business", "mother", "buddy", "biggest", "dream", "moves", "various", "relatively", "disappointed", "issue", "fortunately", "younger", "resolution", "thoroughly", "towards", "latter", "park", "episode", "puts", "center", "surprises", "affair", "wars", "masterpiece", "academy", "joy", "sayles", "amazing", "strongly", "vision", "honest", "structure", "stunning", "battle", "innocence", "epic", "presents", "indeed", "spirit", "footage", "emotionally", "deeply", "greatest", "cold", "grand", "scorsese", "howard", "speaks", "control", "incredible", "historical", "cuts", "kieslowski", "tears", "viewed", "worthy", "toy", "larry", "accomplished", "considered", "universal", "silence", "future", "marvelous", "scope", "la", "wide", "justice", "crafted", "happened", "godfather", "master", "branagh", "match", "superb", "tragic", "pulp", "meaning", "poignant", "schindlers", "process", "presentation", "forget", "represents", "moral", "mesmerizing", "engrossing", "ages", "asks", "sympathetic", "remarkable", "class", "theatrical", "print", "circumstances", "cameron", "beautifully", "subjects", "move", "won", "recommendation", "titanic", "understanding", "became", "detail", "slowly", "answers", "pain", "ago", "examination", "addition", "gay", "jerry", "portrait", "hamlet", "black-and-white", "individuals", "gripping", "animation", "tarantino", "1994", "hate", "andrew", "feelings", "silent", "includes", "seven", "captures", "lovers", "fear", "christmas", "draws", "delight", "displays"};
	public static ArrayList<String> distWordslist=new ArrayList<String>();
	public static ArrayList<String> printedposlist=new ArrayList<String>();
	public static ArrayList<String> printedneglist=new ArrayList<String>();
	public static ArrayList<String> printedneutlist=new ArrayList<String>();

	public static ArrayList<String> featlist=new ArrayList<String>();
	public static ArrayList<String> featbilist=new ArrayList<String>();
	public static String[] featWords={"wishmaster", "mchales", "kombat", "deedles", "skulls", "jerky", "fishin", "mccoy", "madagascar", "anne-marie", "kumble", "gumby", "phat", "harland", "hideaway", "knicks", "zegers", "seagals", "33-1/3", "garguilo", "rocketman", "newby", "faculty", "franciss", "pimp", "cochran", "clunk", "forsaken", "prophecy", "quixote", "kurtzman", "bushwhacked", "conway", "mangler", "tripe", "djinn", "metcalf", "outfield", "cowgirls", "pest", "_ever_", "roxbury", "compounds", "deuce", "adrenalin", "ds", "late-summer", "ling", "666", "horseshit", "duchau", "babbit", "boyum", "immortals", "salvageable", "stupor", "tutu", "sliver", "clea", "ineptness", "pootie", "conception", "sagemiller", "cody", "sadler", "unforgivable", "mordillat", "divoff", "abomination", "2032", "cannonball", "longo", "oceans", "tornados", "pimps", "fireplace", "pyun", "mind-numbingly", "carpool", "spotted", "update", "wrongfully", "fiore", "leight", "squinting", "bratt", "capa", "ropelewski", "wise-guy", "highlander", "ninjas", "crypt", "kattan", "dailies", "sloppily", "dunston", "taplitz", "switchblade", "bachelor", "artaud", "leonetti", "barsi", "condolences", "rayburn", "delacroix", "swampland", "vivaldi", "globetrotters", "wal-mart", "starsky", "soisson", "dim-witted", "kooky", "luzhins", "64", "geiger", "whispered", "marg", "cristofer", "prevel", "twenty-year-old", "forney", "konner", "hubie", "self-characterization", "erb", "_as_", "poorly-constructed", "rhymes", "headache-inducing", "branaugh", "rago", "fleas", "cruickshank", "ad-lib", "erotique", "rasa", "artauds", "pittance", "sawaki", "wormy", "gebrselassie", "filing", "oreo", "hennings", "_by_", "va", "lenkov", "grits", "arty-farty", "gin", "i-2", "uninhabitable", "romano", "charmless", "perseveres", "linc", "overdue", "snively", "barfing", "beano", "retch", "atlanta", "walz", "cartoonlike", "11/23/94", "gazoo", "iago", "aoyama", "industrialist", "bowman", "kulls", "tattoo", "zanitsch", "lovebirds", "barrel", "damnedest", "scatological", "astounded", "astrids", "dauphin", "houseguests", "sedative", "anesthetize", "drools", "bota", "melkonian", "cavazos", "deriving", "mchale", "maloney", "flint", "legalized", "bramon", "undertake", "misdirected", "dignan", "beebe", "hughess", "plentys", "roderigo", "henpecked", "conqueror", "scotia", "shaven", "cking", "prozac", "unquestioned", "repulse", "grabianski", "placards", "lamely", "marshal", "sapping", "unkind", "incompitent", "softly", "betcha", "haddonfield", "black-faced", "fouse", "screwy", "giant-sized", "mvp", "moths", "restaging", "pandas", "bamboozled", "oxygen-deprived", "rico", "stock-in-trade", "feldberg", "risa", "shrimp", "pitifully", "techie", "coolio", "frederik", "cassio", "boomers", "yawner", "terraforming", "magoos", "yogurt", "puke", "b-list", "seer", "tobolowsky", "disgrace", "leaned", "imagination-impaired", "arline", "horace", "grieco", "corwin", "makkena", "metallic", "hoax", "creepshow", "flashlight", "eisners", "frowns", "stupefyingly", "escapees", "hunks", "steckler", "schygulla", "diversionary", "gung", "winants", "ho-sun", "totals", "motionless", "amick", "xerox", "locket", "salli", "shou", "algrant", "honchos", "baddies", "deadening", "neorealist", "staterooms", "family-oriented", "adjani", "lundgren", "klebanoff", "mummies", "paluds", "clokey", "mazin", "herrington", "magnate", "unredeemably", "tampering", "vicky", "caviar", "ennervated", "theodora", "fingered", "corbin", "gonin", "guns-and-drugs", "chimp", "dissension", "cubs", "polsky", "mallory", "novalee", "setup-setup-gag", "action-slapstick", "reneau", "chuckled", "barb", "dim-wittedness", "ingest", "defunct", "edifices", "slured", "m&ms", "fish-eye", "ex-major", "hush", "amateurishly", "phoning", "alcala", "zolotin", "potentially-amusing", "malfunctioning", "snowden", "reminsent", "kaminskis", "robin/billy", "crabbe", "mumble", "loveless", "evies", "forgetable", "tribulation", "brownie", "planet-sized", "all-too-easy", "fourth-rate", "vigil", "pathic", "tims", "lundy", "windup", "smithee", "palud", "unexciting", "dolph", "lombardos", "do-gooders", "lowdown", "impudent", "mirror-imaged", "survivable", "spew", "two-day", "adrenalins", "spicer", "livingston", "souza", "plissken", "dizdar", "geezer", "thinkin", "titillates", "mendelson", "domingo", "panza", "sagged", "redeming", "nuggets", "nutter", "desdemona", "excrutiatingly", "tamasy", "ferrell", "silverman", "asinine", "scarier", "poorly-conceived", "dumass", "starry-eyed", "dumbed-down", "alumni", "insomniacs", "hodgepodge", "godmother", "fax", "fork", "henstridge", "nauseous", "lisbon", "iscove", "hogans", "dumbo", "hos", "clouzots", "dreck", "zondag", "prehistoric", "scrap", "sherilyn", "kotto", "enforcer", "nielsens", "stupefying", "unrepentant", "foisted", "doubly", "schlesingers", "herve", "mussolini", "normally-reliable", "simonds", "brag", "yuck", "belinda", "yuks", "miz", "much-publicized", "osborne", "imbeciles", "sadist", "atkins", "kriel", "puck", "hip-hop", "yolande", "holzman", "torches", "workaholic", "jeter", "effects-driven", "notepad", "inanity", "periscope", "hacked", "escaped", "regurgitating", "tobacks", "dross", "grossness", "ricardo", "cheap-looking", "detested", "cosmatos", "scheinman", "winant", "grodin", "smokey", "burnstein", "borden", "sheet", "parrot", "mnemonic", "suture", "laborious", "zaz", "droning", "aip", "never-ending", "dorian", "unlawful", "cahn", "duos", "manoel", "heidi", "monotony", "mcgehee", "psychopaths", "tattoos", "debont", "cch", "unenlightening", "pennant", "cecile", "anything-", "over-worked", "speech-impaired", "luke-warm", "detten", "one-star", "younguns", "bourne", "burns/art", "jarret", "hinch", "insects/the", "bakalian", "veracruz", "splices", "obliges", "quickness", "middlebrow", "bargirls", "pics", "barty", "wastes=20", "port-a-potty", "at-bat", "whos=20", "small-to-big", "rite-of-passage", "nine-year-old", "grayson", "moslem", "schizoid", "dirt-packed", "lansfield", "estonian", "re-cycling", "slam-dunked", "oyanka", "suppresed", "show-and-tell", "lexically-challenged", "super-producer", "forthcoming", "beyond=20", "haru", "leno", "original--and", "valedictorian", "cliche-filled", "hauntings", "self-destructed", "migrating", "superwealthy", "halprin", "danza", "mytho-poetic", "glimcher", "20-", "gobbledy-gook", "characterizing", "allaying", "seagel", "caro/jean-pierre", "shot--a", "amorality", "shaefer", "flubbed", "have--but", "negotiating", "250", "bunsen", "mildewed", "never-to-be", "smelled", "barbells", "gumbys", "in-a-gadda-da-vida", "religious-type", "jasmin", "actor/writer", "swear-grunt-blast", "mucho", "hirsute", "epidemics", "watchabel", "cross-eyed", "skreed", "stinkeroo", "stooge-inclined", "maleficent", "blackface", "anka", "bierkos", "yellowstone", "290", "valenzuela", "zapped", "hashing", "fergus", "spiers", "sidebars", "philanthropist", "ineptly-executed", "vagrants", "stalwart", "fantasy-adventure", "slang-spewing", "pickets", "prevel--dull", "mid-thought", "thump", "movie=20", "tallying", "dawdles", "over-stay", "tap-dance", "salonen", "derrickson", "pimping", "alarmingly", "propellants", "bay-style", "balibar", "creepy-crawlies", "stepchild", "elviss", "eternities", "zweibels", "carface", "oooh", "shotguns", "fish-", "ramage", "dribbled", "preposterous--yes", "chinlund", "#3", "scalped", "wylys", "cripple", "chastened", "defensible", "blechman", "simmply", "turmoils", "frizzell", "appearance--even", "first-grade", "lohmeyer", "ever-more-saccharine", "handwritten", "sex-craved", "mid-film", "sunglasses-at-night-wearin", "_good_", "vigorously", "trashier", "cameo-rama", "tangerine", "water-fuel", "dmx", "aberration", "sequenced", "belladonna", "amazing--an", "ville", "bumbles", "teammates", "dow", "cyber-space", "3/4", "tigerland", "arses", "meshed", "+1", "thandie", "babbits", "bridgit", "correlative", "villains=20", "tremolet", "prank", "flaherty", "broadcaster", "[better", "reductionist", "shuffle-beats", "kelsey", "janitor", "somnabulistic", "chatillon", "lisping", "wretchedly", "dub", "flopped", "techno-rock", "full-to-bursting", "taveras", "2/", "pseudo-skinheads", "food-fighting", "pseudo-instructional", "oppressingly", "duster", "petting", "tavera", "leachmans", "huskies", "camera-angles", "medowlark", "thickly-drawled", "prawn", "subconsciouses--influenced", "sleepwalked", "konvitz", "danger--michael", "manfredini", "slovenly", "84", "unbecoming", "logans", "methamphetamines", "one-hundred-plus", "cowgirl", "stultified", "pulpit", "karnowski", "tse-tungs", "pedantry-as-art", "lebovitz", "element--comedy", "non-romances", "empowering", "botticelli", "fertility", "ultra-sinister", "nudged", "slots", "jaundiced", "blunden", "coiffure", "separated-at-birth", "_cliched_", "fathered", "dwindled", "uneven-but-enjoyable", "hubby", "pain-killing", "commom", "acting--but", "unentertaining", "laughs-to-jokes", "foster/carol", "reacquainted", "seventysomething", "barely-adequate", "koslows", "grandma", "onorati", "partying", "declie", "hurriedly", "messner", "money-shot", "classifieds", "kroopf", "hroizon", "advertiser", "temps", "saloons", "investments", "volleyball", "huglin", "strutting", "galileo", "self-promoting", "under-estimate", "brainsmasher", "rambos", "malcontents", "fingernails-on-the-blackboard", "dyke", "willocks", "rhinestone", "savers", "stun", "bloodline", "this--what", "architecturally", "ones--theyre", "poorly-coordinated", "whatnot", "44-", "wonderfully-conceived", "mvoies", "guess--the", "slovakia", "talisa", "turgidly", "labelling", "hive-shaking", "byrum", "manga--hyperrealistic", "lubbock", "trenchcoats", "emptier", "furthered", "tearing-it-down", "crude-but-humorous", "ex-doctor", "misha", "enjoyable-yet-anemic", "hambling", "rockefeller", "lawsuits", "decriminalization", "displays=20", "stand-by", "weepie", "too-subtle", "serenaded", "craigs", "gils", "abolutely", "swiss-cheese", "spirit-crushing", "ear-shattering", "skulldom", "humor--you", "napier", "once-beloved", "nauseatingly", "jasons", "cest", "custody/city", "punchless", "payback]", "clairvoyants", "mailed-in", "mcdonnough", "wallet", "re-gain", "113-minute", "end/totally", "sued", "penthouse", "town--that", "_thinking_", "offed", "me--perhaps", "letterboxed", "re-enter", "adrenaline/testosterone", "foam", "exert", "black-candle-lightin", "street-corner-leaflet", "tranquilizers", "nearly-inconsequential", "simple--a", "nauseum", "shark-skin", "tourettes", "genie-in-a-boombox", "schmoeller", "fey", "cinny", "tiresias-like", "criterion", "audra", "conspire", "something=20", "expendience", "farren", "namby-pamby", "head-tripping", "fiores", "shallowest", "perpetrates", "brennan", "z/missing", "punished", "anatomical", "disobeyed", "girl-to-girl", "corman", "raif", "bierko", "celestially-destined", "explosion-based", "sprinklers", "_be_", "tickle-tickle", "15-foot", "grammers", "heart-beat", "wimple", "bernhards", "chill/", "conehead", "dd", "wrays", "action--well", "heavy-metal-listenin", "flogging", "3-com", "chainet", "infortunately", "noisome", "inappropriately-placed", "jump-starts", "circling", "triplet", "fong", "haiti", "leatrice", "posts", "bernsen", "nauseated", "spoofed", "spurting", "mitas", "illogic", "k-", "perpetrator", "56-years", "ja", "water-logged", "semiclad", "racketeers", "liverlips", "dustbin", "athleticism", "ll", "contemptible", "queers", "555", "atmosphere-saturated", "walkie-talkie", "fannys", "bad-team-made-good", "confiding", "fowl", "realtionships", "unstability", "partially-animatronic", "foxx", "dullards", "talkshow", "mid-1960s", "demonstrable", "demonstrably", "smothered", "herley", "conveyor", "lascivious", "sh", "slithering", "barondes", "clubhouse", "c3p0", "taggart", "1997-france", "looker", "schintzius", "ua", "uh", "underhanded", "einstein-type", "glaudini", "dewy-eyed", "pseudo-nervous", "half-vulcan", "awkward-sounding", "_last_", "bowed", "inelegant", "nieve", "heel", "i-dont-get-it", "entities", "_expecting_", "fully-abled", "bateer", "tisch", "ingratiates", "wellville", "titan", "timecode", "tingle", "ff", "stepmom", "mandela", "gravesend", "airheads", "burdened", "carrol", "geronimo", "greedy", "bulletproof", "wh", "sonia", "rubies", "bullwinkle", "corrina", "twentyfourseven", "stabile", "glam", "macbeth", "snatchers", "pickford", "goldmine", "wortmann", "bleeding", "adultery", "farmers", "barneys", "unsatisfactory", "stevo", "mon", "son-in-law", "inkwell", "pok", "stiles", "sonke", "slc", "ravenous", "tectonic", "nadja", "simpatico", "sawa", "curdled", "barenaked", "grumpier", "timecop", "smillas", "zorro", "izzy", "carlitos", "digimon", "mouthpieces", "piles", "vertical", "pansori", "gast", "hoegs", "dolittle", "frankies", "kikujiro", "illtown", "breillat", "bruckheimers", "silverstones", "treacly", "arteta", "portentous", "varsity", "junger", "westman", "enthusiasts", "cleese", "winterbourne", "controllers", "palmetto", "angrier", "yakin", "leder", "devolves", "herek", "bradys", "decadence", "berlanti", "01", "dredd", "biggs", "bicentennial", "mcneice", "decorated", "hoggett", "guasparis", "shaimans", "kuhn", "dishwater", "remedies", "tropical", "virgils", "whistler", "quadrant", "qui", "casanova", "parades", "do-right", "teds", "locked", "camilla", "blaring", "pearson", "golino", "coupling", "clints", "rosemarys", "gayton", "structurally", "poseurs", "bink", "dispassionately", "graceland", "pyromaniacs", "snowman", "nightwatch", "spin-off", "bordello", "irritated", "bloods", "pressfields", "ravich", "juvenal", "ricki", "icky", "cross-cutting", "inter-racial", "smacking", "isaacs", "beneaths", "whiley", "idols", "sprung", "receiver", "golly", "desperado", "magnolias", "stabiles", "menagerie", "jolies", "frost", "coyle", "rosina", "sled", "monogram", "chaotically", "psychlos", "camara", "loughery", "flop", "sweeney", "ehren", "limps", "oomph", "hostages", "leering", "adele", "pills", "harling", "responded", "sphere", "gunfights", "flatness", "trey", "simms", "heckerling", "smilla", "ariel", "providence", "mikey", "plates", "stella", "ample", "plotline", "bagger", "ala", "anatomy", "exhale", "flex", "baigelman", "aprile", "dmytryk", "scarwid", "guzzles", "outpost", "quadrants", "eskimo", "leprosy", "earthquakes", "numb", "gradys", "darby", "balkan", "duffel", "maud", "calculate", "novalynes", "two-legged", "muresan", "seventy-nine", "mullan", "proportional", "discount", "oland", "gerdes", "ai", "flo", "cronenbergs", "ro", "gab", "zimmerman", "fumbled", "life-style", "pakulas", "georgina", "resnicks", "drews", "smithsonian", "hiv", "equinox", "susceptible", "khaila", "justiniano", "fastest", "frye", "krugers", "spheres", "rochon", "stiers", "disposition", "kemper", "isaiahs", "rickety", "internment", "sober-minded", "life-and-death", "garret", "lix", "preternaturally", "simple-minded", "rafters", "mox", "recess", "shriek", "deena", "existenz", "cholodenko", "gatins", "nhl", "murakami", "lovecraft", "beachums", "meany", "lamas", "delpys", "constipated", "jennys", "paring", "mallon", "scenery-", "bolton", "tags", "inexcusably", "elapsed", "mazar", "crept", "octopussy", "ryu", "honeymooners", "non-conformist", "tulips", "hayek", "wilmas", "semi-plausible", "potently", "explosiveness", "shmaltz", "pucks", "illuminata", "clamoring", "bornedal", "compatible", "monumentally", "promoter", "impacts", "regimes", "slogging", "overly-long", "suschitzky", "henris", "man-eating", "contradicted", "antitrust", "thai", "fairbanks", "airheaded", "nineteen", "brava", "zlotoff", "inhabited", "high-minded", "mariachi", "orgazmo", "stump", "dragnet", "toothpaste", "fudge", "targeting", "baby-sitters", "annabel", "braddock", "dozing", "polanskis", "spawns", "disguising", "antiseptic", "clarice", "eran", "ratner", "blessings", "nail-biter", "opportunists", "ralphie", "triviality", "institution", "apache", "bernadine", "goldbacher", "gilead", "heckerlings", "gizella", "toothy", "silky", "splotchy", "flighty", "unfulfilling", "puree", "potentially-interesting", "kitanos", "gerardo", "expanding", "viva", "macleane", "palestinian", "verne", "awash", "grenier", "manning", "priestley", "thespians", "palestinians", "warchus", "janni", "slicker", "ralphies", "soothing", "leguizamos", "corrigan", "bandaras", "balletbo-coll", "revisits", "8-year-olds", "repressions", "charbanic", "oater", "burg", "psychoanalysis", "nudge", "effeminate", "screamed", "krippendorfs", "plunder", "orfeu", "receptive", "garrets", "senorita", "snarky", "antagonistic", "sandlers", "$250", "run-of-the", "1930", "predisposed", "doro", "sputters", "sternberg", "orkin", "silvestris", "fetish", "gabriela", "niccolo", "baffled", "lidia", "too-long", "drescher", "hammett", "rudys", "poledouris", "korine", "fizz", "chunhyang", "flockhart", "credentials", "bemusement", "belting", "mcworter", "sabian", "pallbearer", "bio", "annabels", "131", "jabbering", "nazareth", "cho", "funding", "self-indulgence", "wards", "wittliff", "pokemon", "seedy", "waterworld", "freakish", "kalvert", "otoole", "postcards", "superficiality", "b-films", "speculative", "profits", "whove", "hasidic", "inhumanity", "islands", "woodstock", "homo", "rocco", "permeates", "assassins", "kyra", "tax", "stole", "annoyance", "shoot-out", "republicans", "cures", "meadows", "undermined", "virginia", "injection", "cyberspace", "arbitrarily", "puzzler", "directionless", "monger", "frankel", "indecision", "above-average", "sexism", "masked", "hackmans", "ragged", "engagingly", "levi", "babbling", "dorff", "smileys", "lowlife", "telegraphs", "marshals", "mumfords", "liev", "elfont", "troy", "cedars", "tramp", "fielding", "pseudo-intellectual", "fulfill", "bacons", "symptomatic", "stockwell", "tulsa", "11-year-old", "randle", "oconnell", "croghan", "mindlessly", "spinotti", "dominic", "dublin", "harlequin", "johnsons", "schreiber", "morass", "sena", "salma", "disappearance", "climbers", "gillespie", "jackpot", "supposes", "diverted", "regurgitate", "blandly", "unenthusiastic", "slice-of-life", "micheles", "co-director", "pescis", "coitum", "zellwegers", "everetts", "shelleys", "anesthetized", "haid", "drooling", "sanitarium", "stoically", "non-documentary", "rockers", "picturing", "marijuana", "poverty-stricken", "draft", "action-suspense", "hippo", "mcglone", "flub", "tagline", "15-year-olds", "devane", "cub", "phenom", "slinky", "chevalier", "movie--its", "indigent", "hails", "dev", "zucker/abrahams/zucker", "thousand-yard", "pre-marital", "firecracker", "trysts", "din", "hairy", "cluelesss", "proficiency", "dov", "governess", "alleviate", "brawls", "manifestations", "scoff", "waterfalls", "bendrix", "hiruta", "montaigu", "maul", "swill", "mavi", "wei-wei", "dyan", "exceed", "metroland", "censor", "pursues", "lightheartedness", "libbies", "overly-expository", "carnahan", "ruizs", "carradine", "reuben", "paulinas", "greenway", "writer/star", "cahill", "personifications", "wortmanns", "liling", "signaled", "skateboarder", "subjugation", "hothead", "twiddle", "fag", "dotted", "pours", "stevos", "sincerest", "rand", "savannah", "covertly", "shone", "bedspread", "windons", "trifle", "spacious", "rard", "gs", "day-glo", "southwestern", "na", "quintanos", "liljeberg", "bookish", "qs", "evolutionary", "broken-down", "annoyances", "fantasyland", "gee", "ladle", "racetrack", "cavemen", "ogden", "leacock", "stitched", "wither", "rigidly", "petulia", "gpa", "tickled", "underwent", "departments", "hyper-kinetic", "clergy", "appointment", "marceau", "647", "osmond", "quang", "strides", "vinnie", "investigate", "adetuyis", "collodi", "televangelist", "passingly", "hughs", "nyah", "drastically", "tahiti", "crediting", "kellogg", "pillsburys", "falter", "hop", "hrs", "dodger", "whirl", "concise", "bandis", "dudleys", "tripled", "applauds", "ravichs", "cassidy", "stupid--thats", "nosedive", "mixtures", "inordinately", "deads", "dialogue-free", "pond", "disdains", "poop", "valeh", "excite", "pout", "yamaguchi", "topper", "mumbo-jumbo", "steadicam", "greedys", "intakes", "ruppert", "goodie", "marek", "babas", "margo", "traction", "jlo", "marky", "cloning", "self-deluding", "steph", "bogota", "hartmans", "t-rex", "marta", "sketching", "kat", "unmercifully", "hemingway-like", "meeker", "trivializes", "hero-on-a-quest", "back-to-back", "silvestri", "grimaldi", "carlei", "sandor", "spiner", "adult-oriented", "brokedown", "somethin", "kirgiz", "garrad", "cabaret-like", "smudged", "rounds", "cecils", "matey", "mich", "cereal", "eliminating", "miho", "shuts", "miko", "minh", "well-handled", "lucys", "eyeballs", "unwisely", "mag", "wrangling", "awww", "starling", "romanctic", "abating", "boozed", "motofumi", "jillian", "moe", "joons", "stupendously", "carney", "mix-ups", "skimps", "hairstyles", "blackmail", "totalitarianism", "lolita-style", "suschitzkys", "schweiger", "mst3ks", "trying--and", "withstand", "torino", "neurotics", "humdrum", "somniferous", "betters", "crain", "fienness", "profligate", "lazily", "vacations", "sting", "detector", "ritt", "nur", "animatronics", "kristen", "dead-in-the-water", "persian", "caspers", "arab-americans", "intuitive", "fairlane", "cheng", "18-year-olds", "intermeshed", "gothar", "carpet", "chews", "epidemic", "singlehandedly", "semi-serious", "roars", "listener", "wily", "lamer", "stillborn", "shorthand", "indemnity", "quits", "grapes", "mewtwo", "continuous", "wobbling", "destroying", "montreal", "muren", "pom", "antiquarian", "belgrade", "lakeside", "utility", "bahns", "hrebejks", "leiser", "mystery/thriller", "incredibility", "hobo", "earths", "arlington", "sussex", "wei-tung", "holt", "industrialists", "whitley", "strikeout", "drifted", "gambles", "mullers", "better--or", "tough-as-nails", "medak", "nourished", "undoing", "blue-green", "brogues", "difficult-to-swallow", "klute", "yabba", "roden", "rodeo", "regis", "yada", "yael", "odin", "jacquasse", "warners", "railroad", "gyorgy", "sonias", "widely-panned", "mope", "jennifers", "over-stuffed", "gaghan", "workout", "jelling", "chile", "batteer", "kanievska", "pitting", "willow", "lampwick", "yglesias", "a-lans", "tretiak", "grasso", "upgrading", "alienating", "einstein", "run-from-the-killer", "striped", "oklahoma", "sappiness", "obradors", "suitability", "chelsea", "tee", "ingemar", "goddess", "hairless", "smells", "rook", "mumblers", "taylors", "zelniker", "buffy", "hundredth", "delli", "pardner", "tingler", "flush", "ice-fishing", "larch", "waterston", "disarm", "unbelievability", "every-60-seconds", "unimpressively", "uli", "cold-blooded", "gloucester", "stahls", "jungers", "burnished", "hobby", "gumption", "befall", "hippopotamus", "crappy", "infested", "curio", "im-ho-tep", "berkoff", "slayer", "noonan", "twelfth", "streisand", "preachers", "troche", "eyre", "pollock", "beaumarchais", "traveller", "valour", "cronos", "muriels", "brassed", "sandlot", "tigger", "lucinda", "anders", "xiu", "screamers", "deconstructing", "emmet", "multiplicity", "unconventionally", "kahuna", "clockers", "pecker", "tito", "butt-head", "dorado", "horrocks", "barbra", "okoge", "stupids", "felicias", "daytrippers", "shakur", "watermelon", "bayou", "nixon", "posse", "augustin", "sinclair", "albino", "serenade", "cosi", "suicides", "grandpa", "kriss", "erins", "arnaud", "nelly", "fingerprints", "cherot", "posed", "dex", "lilians", "zhou", "au", "dunye", "scully", "alchemy", "lys", "devitos", "edouard", "gaslight", "suo", "hilditch", "impatient", "grease", "donal", "thumbelina", "beattys", "hackford", "barrett", "noelle", "stakeout", "takehiro", "warmerdam", "stopkewich", "barbieri", "harrer", "shyamalans", "sargasso", "absent-minded", "freundlich", "deceiver", "farinelli", "brockovich", "ramblin", "laugh-aloud", "nunns", "copland", "matchmaker", "monica", "armageddon", "titus", "squeeze", "fitzgerald", "essayed", "muppets", "unbreakable", "mildred", "pillow", "harp", "streisands", "shante", "lodoli", "yi", "bearing", "giles", "nutcracker", "gossamer", "pussycat", "hatta", "scheming", "mayfield", "channes", "preston", "mourner", "viv", "bulimia", "zsa", "jody", "terrys", "ermo", "evan", "cunning", "noonans", "teller", "seducer", "aronofskys", "adolfo", "insurrection", "rosenbloom", "glistening", "hades", "abbys", "unzipped", "quills", "feebles", "ever-present", "moonraker", "lurie", "johnston", "cid", "serrault", "down-to-earth", "discord", "dee", "willendorf", "truce", "diversity", "rade", "stonewall", "lu", "ly", "tomeis", "overhyped", "impromptu", "rickmans", "pooh", "calei", "sofia", "newsroom", "kermit", "emilio", "molinaro", "remy", "stephan", "liu", "behaviour", "instrumental", "mai", "blasko", "margarets", "cobb", "juliannes", "peculiarly", "unstrung", "cons", "heartwood", "unhurried", "travellers", "luisa", "syd", "1979s", "teno", "veber", "negroponte", "torres", "hues", "forcefully", "missionaries", "yul", "fantasia/2000", "outweigh", "prefontaines", "razor-sharp", "ceremonie", "pounding", "conjunction", "aphrodite", "nakajima", "commando", "marble", "cynic", "tupac", "stodgy", "cadillac", "javert", "estelle", "leeson", "elicited", "sheri", "pumbaa", "swann", "roseanna", "papaya", "rubys", "hamlisch", "compensates", "morpheus", "stanleys", "clayton", "makhmalbaf", "flemings", "dominating", "sofie", "ratchets", "malick", "almod", "quilt", "caron", "anchors", "var", "claiborne", "rainmaker", "outbursts", "satisfies", "ritchie", "guinevere", "mulder", "gramercy", "unhook", "dzhordzadze", "hare", "eliminates", "rants", "mayersberg", "oliviers", "$1", "deleon", "78", "belvaux", "soavi", "dunnes", "ely", "wrap-up", "disillusionment", "mst3k", "lucian", "aw", "h20", "lv", "cheered", "definitively", "cleric", "starkwell", "alfie", "falardeau", "fever", "procedure", "engross", "ida", "gridlockd", "grumbling", "elisabetta", "sweeter", "suvaris", "norville", "luchini", "plumbing", "khleifi", "sorcerers", "dashes", "usher", "itami", "lapsing", "werb", "lex", "zauberman", "exports", "weebo", "ascend", "mcglynn", "slansky", "mckay", "urbania", "sizzles", "boughedir", "cuesta", "shuisheng", "rushs", "navigate", "atkinsons", "buoyant", "banker", "peg", "overplays", "feynman", "murph", "natascha", "jenkins", "was=85", "brynner", "repulses", "mechanisms", "salwen", "self-confidence", "rowe", "turtletaub", "delta", "beaumont", "georgia", "stubbs", "merivels", "bana", "vickie", "worshipful", "mcavoy", "mathematical", "wai", "keitels", "greenwald", "wellman", "farces", "lait", "conchita", "laurent", "regularly", "elevating", "stallion", "formation", "gunner", "disorganized", "peckers", "akerman", "lurks", "goodspeed", "murata", "gallimards", "unforgettably", "outerbridge", "kourkov", "leos", "fernanda", "malvolio", "wayland", "unglamorous", "fabrice", "almost-", "yous", "chopper", "terrance", "superrich", "juha", "anglade", "near-subliminal", "sadie", "darabonts", "coles", "gestapo", "judds", "bodybuilders", "logue", "sophies", "authoritative", "portends", "nagiko", "corbiau", "passione", "attwood", "rounding", "dereks", "flower", "apprentice", "tumbleweeds", "damore", "awaited", "gromit", "soavis", "tiggers", "min-yong", "leons", "doubtfires", "crooklyn", "pruning", "westworld", "well-done", "overcrowded", "berger", "doubled", "takeoffs", "ngor", "borman", "salvo", "nelligan", "bemberg", "infuriated", "out-and-out", "kornbluth", "siam", "faulkner", "inhuman", "denkers", "kauf", "kayo", "frustrates", "sketchily-developed", "sorrento", "kuzco", "mantello", "marias", "costuming", "ethans", "persists", "interchanges", "gullette", "arleen", "well-cast", "documentary-style", "lotus", "celestial", "palumbo", "mandarin", "schub", "retreat", "nastier", "unholy", "merivel", "stefano", "discipline", "danni", "europa", "alterations", "kika", "mormon", "bearded", "feore", "atypically", "superspy", "sudina", "seydor", "dinsmore", "estevez", "soldat", "hamming", "threadbare", "sweeps", "crichtons", "lantern", "tibetans", "shandling", "meander", "tenzin", "stockard", "coin", "voodoo", "discrimination", "ullmann", "underappreciated", "well-suited", "teri", "bach", "mackinnon", "yimou", "oily", "real-time", "baumbach", "stuffy", "holofcener", "requiem", "afflicted", "helgeland", "channing", "clearer", "tangled", "fresher", "myles", "necrophilia", "fatalistic", "naturalness", "pulsates", "motorcycle", "shellys", "hamptons", "ninas", "u-571", "serbedzija", "downside", "catherines", "norwegian", "vonnegut", "fantasia", "daisy", "clements", "saras", "deceased", "cunningham", "seldoms", "conjures", "obriens", "mcquarries", "coy", "karols", "det", "haing", "dna", "mckays", "dario", "marx", "out-of-towners", "barbaric", "steinfeld", "laid-back", "thorny", "galatea", "colleague", "stuck-up", "vicki-ann", "hirst", "attention-grabbing", "splashes", "advisors", "burnetts", "chimpanzees", "ag", "5/3/97", "bg", "vecchio", "ls", "mi", "michels", "foyt", "ballads", "trepidation", "gaz", "clucking", "fetus", "headless", "classify", "guerra", "00am", "gabor", "ulla", "condensing", "malachy", "watsons", "chadhas", "chon", "australians", "prelude", "yoshi", "steinbecks", "witchers", "pops", "chagrin", "interacts", "koreeda", "nudging", "stowes", "redo", "marcy", "interlude", "broomfield", "buddhism", "calogero", "buddhist", "geometry", "mornings", "arabic", "grenville", "bluish", "obscuring", "asteroid", "hometown", "agutters", "gregorys", "favreaus", "duran", "guitarist", "blanchett", "kia", "orlando", "chart", "bachs", "berendts", "hurdle", "mattola", "jonas", "stephanopoulos", "mates", "peking", "neils", "d-fens", "dedee", "administered", "sibertin-blanc", "brosnans", "5/11/96", "mcg", "skinny-dip", "legitimacy", "aggressiveness", "harts", "1900s", "stafford", "poelvoorde", "adder", "eruption", "rattigan", "second-time", "out-of-control", "embalming", "tarrantino", "cotlers", "prentice", "riyo", "hilmar", "ringwald", "breckman", "guides", "agitated", "meara", "lithe", "coco", "trusting", "oph", "households", "ruths", "steenburgen", "backseat", "deficit", "rationalizations", "danner", "reality-based", "hannahs", "pakula", "edge-of-the-", "seller", "chimps", "relaxation", "puppy-dog", "reinforcement", "recollection", "triplets", "deterred", "hock", "laney", "markowitz", "hassan", "enlightens", "favreau", "buellers", "waterhouse", "francie", "bloodlust", "amplified", "follower", "creed", "egan", "odea", "parked", "acheson", "egon", "x-ray", "rug", "cranston", "caution", "chicanery", "sexiest", "paragraphs", "kimmy", "culled", "weisberg", "louises", "stu", "lessac", "ganga", "mollys", "merchant/ivory", "stamped", "tao", "kinka", "zamachowski", "grungy", "counter-point", "lightening", "luthan", "giveaway", "excellently", "dubroux", "cardoso", "swanbeck", "bhaji", "quota", "bask", "bewildered", "predominantly", "vhs", "industrys", "cecilia", "ronnow-klarlund", "congenial", "newsies", "scholars", "nixons", "evitas", "starlights", "wei", "hums", "deafness", "shimizu", "brisville", "grandmotherly", "mercilessly", "dionisi", "bulimic", "algonquin", "garth", "dizzyingly", "norbu", "snootles", "triangular", "heflin", "mulvehill", "dismisses", "xxx", "tian", "puzzles", "philosophies", "salwens", "emmets", "sonoko", "starlight", "ofallon", "lava", "wilshaw", "strangulation", "castrato", "chants", "stalin", "erupts", "criticizes", "omelet", "boasting", "regains", "exported", "hoffa", "bens", "donny", "timidity", "thermal", "conversely", "deric", "latcho", "cleanly", "weaken", "8-1/2", "hungering", "girlish", "bennys", "non-gory", "joao", "rigorous", "samantha", "taymor", "5/7/97", "well-presented", "vann", "buckley", "implants", "none-too-subtle", "superimposed", "masayuki", "porters", "forevers", "dwyer", "lauries", "sigel", "twenty-somethings", "covert", "end-credit", "varieties", "long-standing", "capolicchio", "rather=20", "callow", "entwined", "eighteenth", "locks", "perversion", "crusty", "chunky", "story-lines", "churn", "monti", "lathan", "imogen", "differ", "devilishly", "newton-john", "karol", "vend", "denver", "osullivan", "monogamy", "bronwen", "dale", "conspiratorial", "zeena", "cameroon", "antonymic", "nudges", "geese", "lino", "frail", "downfalls", "splendide", "francies", "housekeeper", "franc", "bonzei", "wibberley", "rhetoric", "father/daughter", "buses", "tanya", "minbos", "sadsack", "stiefel", "antoinette", "uncomplicated", "juzo", "silvia", "andronicus", "scoundrel", "sexpot", "in-joke", "uncontrolled", "bromell", "plotlines", "exec", "hwangs", "werdin", "vida", "10-year", "nana", "boni", "mcbeal", "mischa", "smartly-written", "elated", "mcdiarmid", "keach", "warmer", "vyacheslav", "afterglow", "rotunno", "tarek", "wight", "overlaying", "ouisa", "gown", "aristarain", "catwoman", "insisted", "halfaouine", "chirping", "heating", "waterss", "matsuji", "homeward", "hobbes", "flynt", "slingshot", "ladybird", "lelouch", "aparajito", "vukovar", "samourai", "dinovis", "decalogue", "dieyi", "hamster", "labute", "ulee", "intermission", "crissy", "roan", "locusts", "leni", "fincher", "microcosmos", "gattaca", "inish", "chad", "devastatingly", "conformist", "badii", "equaled", "nil", "kore-eda", "odessa", "scarlett", "wertmuller", "cocteau", "kurosawa", "motta", "hurlyburly", "neff", "paradiso", "lasseter", "kenton", "vilanch", "trotta", "gracie", "sayless", "apur", "lieberman", "yoshii", "dadetown", "freeze-frames", "darlington", "sansar", "chaser", "devor", "ilona", "midges", "almasy", "cocteaus", "midwinters", "ulees", "minghellas", "ake", "leuchter", "zeta-jones", "riefenstahl", "dreyer", "riff-raff", "stantons", "malli", "sandgren", "muller", "birthing", "fr", "rhett", "rarer", "waco", "breeds", "isa", "cement", "delons", "=96", "halloweens", "hortense", "ondaatjes", "egos", "chili", "kwang-su", "70mm", "finer", "winstanley", "lawick", "margarethe", "near-masterpiece", "hamill", "pather", "kanes", "hyperbole", "discreetly", "chekhovs", "mitterrand", "lamerica", "regent", "starkness", "goeth", "pistols", "winterbottoms", "melvilles", "peels", "dragojevic", "pancakes", "murnau", "salen", "panchali", "felicie", "anastasias", "shum", "pornographer", "1959", "ferran", "mimmo", "horrigan", "ferrans", "hinds", "brewster", "springtime", "unsentimental", "promesse", "fatigue", "sim", "mcgrath", "bosnia", "zwigoff", "ronin", "lefty", "forman", "crouching", "osment", "stephane", "hossein", "brasco", "nuridsany", "bould", "recount", "lillith", "breathed", "dax", "bannion", "dorries", "attanasio", "defelitta", "dreamlife", "potts", "tomas", "janvier", "apus", "cupboard", "morrow", "allegiance", "chronicled", "bleakest", "devastated", "imperial", "renton", "jean-michel", "vilified", "wachowski", "slave", "travail", "gaenor", "ritz", "islamic", "lally", "kwai", "bjelogrlic", "sobieski", "caros", "pacifist", "hillary", "movie-lover", "re-defines", "pulp-noir", "josts", "re-interpreted", "lukes", "back-brain", "truffaut", "mclaren", "beckett", "richest", "uwe", "curls", "vep", "waterford", "mehta", "roosters", "hardys", "petrycki", "magnolia", "kirks", "transporting", "niccol", "lanh", "hollandais", "cocks", "birmingham", "plaintive", "reginald", "invade", "jacek", "middle-age", "miette", "elsie", "kaleidoscope", "bombay", "completing", "better-known", "salvatore", "dessie", "vaders", "regans", "sverak", "flynts", "broulard", "brownlow", "swooning", "patons", "rentons", "downs", "palahniuks", "srdjan", "grody", "defy", "motss", "gori", "echoed", "oddjob", "maborosi", "bohringer", "kazuo", "jalsaghar", "perennou", "sera", "calopresti", "preisner", "trintignant", "rock-solid", "charred", "korben", "story-wise", "geris", "juxian", "tenacious", "marina", "1972", "ramonas", "narrators", "nigger", "rique", "erick", "widely-held", "maite", "clancys", "newland", "amon", "gurland", "35mm", "tarzans", "triumphs", "ouedraogo", "aftermath", "frat", "hates", "assayas", "henkin", "musker", "strachey", "delon", "linney", "ashman", "saison", "widespread", "farnsworth", "doren", "assisted", "fonteyne", "strauss", "pussy", "remastered", "eckhart", "sebergs", "defendants", "decisive", "klapisch", "germinal", "re-creation", "sully", "blasband", "mines", "magically", "captivated", "stereo", "dardenne", "preferee", "exhilerating", "downplay", "ullas", "archers", "wallow", "chu", "navas", "caucasus", "238", "ballhaus", "teary-eyed", "sort-of-love", "bessons", "reticence", "awestruck", "porphyria", "reputations", "jaaferi", "undermining", "mala", "stag", "hortenses", "althea", "fleur", "internees", "aeberhard", "muffled", "annalees", "ems", "indirectly", "15-year-old", "mammy", "corleones", "co-producers", "seema", "tomek", "winifred", "ga-ga", "perfectly-pitched", "gulden", "saccharinely", "purity", "transcendentalist", "fhs", "mj", "accountability", "c3po", "mireau", "carveys", "fan-boy", "doomsday", "amidou", "koenkamps", "austerity", "keshavarz", "thrashing", "festive", "unfit", "fraternities", "fliks", "eggshells", "frenhofer", "grazyna", "enveloping", "ignatz", "miramaxs", "decipherable", "gattacas", "shrek", "ciao", "steiners", "bellies", "110-minute", "gorman", "monahans", "storaro", "77-minute", "emilie", "lebeshev", "karuna", "mcgaw", "with--hopefully", "vitos", "misskelly", "edge-of-the-seat", "accessibility", "ambiguities", "rathnam", "scarletts", "gaear", "harwood", "pettiness", "manojilovic", "coaxes", "wildes", "masao", "plights", "idziak", "forging", "decae", "lahti", "gertrud", "finely-honed", "bannerjee", "warlike", "quinet", "thacker", "non-animated", "machinas", "kyo", "tightly-paced", "blackadder", "sihung", "immorality", "mazurskys", "agincourt", "slingshots", "non-disney", "enright", "pisier", "single-camera", "much-maligned", "ramius", "krizan", "mime", "martines", "sevens", "jonze", "fuentes", "mise", "separating", "good=20", "nakedness", "szapolowska", "smoothies", "see--dont", "bierman", "telegram", "testemonial", "rationale", "belles", "maxence", "face-off", "atheists", "grange", "sharons", "weeping", "entangled", "divisiveness", "ruses", "davidians", "moment-to-moment", "vastness", "totality", "inflammation", "pups", "identity--we", "boujenah", "ozu", "ethnicities", "bankss", "accompanist", "resilient", "lampy", "sinofskys", "mallis", "side-splittingly", "swintons", "mattel", "intake", "away=20", "twisty", "caste", "puccini", "celebrants", "worrall", "manipulation-free", "panoramic", "dissects", "obtained", "schmid", "aarons", "romantics", "mid-seventies", "beekeeping", "hoyt", "rohrbach", "so=20", "jeni", "gainful", "slawomir", "horizons", "feature--its", "1958s", "mori", "nepal", "guenter", "husband-and-wife", "insanities", "brights", "self-deception", "sen", "jumper", "pitt/morgan", "mottas", "compose", "underexposed", "grasps", "dostoevskys", "1964s", "bankole", "sinofsky", "radford", "falconetti", "frederique", "yeager", "illiterates", "villaggio", "badalamenti", "fountainhead", "hamlets", "fadge", "synch", "empires", "professore", "arm-pit", "interweave", "govworks", "nurtured", "screw-ups", "handcuffs", "abelard", "guile", "freeways", "terk", "gershon", "frydman", "chirpy", "inextricably", "machiko", "tristesse", "ephemeral", "jaaved", "kerrigans", "unflagging", "ryszard", "bodrov", "heart-stopping", "santosh", "traviss", "bbqs", "restrict", "shelle", "gourmet", "advocates", "cimino", "feudal", "monahan", "interweaving", "kirby", "late-model", "crisper", "oostrums", "honeycombs", "perier", "toland", "indisputable", "spasse", "cowrote", "too-predictable", "andromeda", "prissy", "yasujiro", "carolines", "fridrikssons", "endre", "hinkley", "bedi", "seething", "waringo", "renzi", "conceals", "olund", "startup", "techines", "renoirs", "materialist", "embroidered", "alyssas", "annes", "anathema", "boating", "basch", "mendez", "basia", "craves", "emulated", "granges", "colgan", "hexter", "emotionally-rich", "kentucky", "legionnaire", "gratifyingly", "reexamine", "jost", "crowley", "bohbot", "cortese", "ishiguro", "trainspottings", "groundbreaker", "christains", "brean", "hells", "court-martial", "disquiet", "nikola", "stoppage", "mollo", "decorating", "stalens", "dark-haired", "fugit", "lahtis", "left-wing", "acuteness", "briers", "campfires", "elton", "secondo", "innards", "farquaads", "oscar-nominated", "bardot", "jingo", "barrison", "ignon", "weak-minded", "damien", "lesser-known", "remarking", "hostess", "quieter", "action/suspense", "chamberlain", "dorens", "loveable", "starry", "nuttgens", "appetizer", "julies", "behalf", "sandstorm", "waring", "millie", "lothars", "hungarians", "candid", "rejecting", "sailors", "refined", "seales", "niclas", "newmans", "cascio", "caterer", "alessandra", "makiko", "precaution", "cheapen", "deeply-realized", "uncomplimentary", "auberjonois", "kharbanda", "cinepix", "tightly-structured", "francophone", "gerrard", "width", "intersected", "tightly-plotted", "necessitates", "seminarian", "gravedigger", "prickly", "rouen", "hasidics", "boaz", "guerrilla", "spassing", "wrestling-match", "freeze-framing", "surrealists", "selleck", "adroit", "in-valids", "henreid", "disillusionments", "streitfeld", "downplayed", "freds", "devi", "minimizing", "fallwell", "resoluteness", "wide-screen", "burbank", "freno", "greenwood", "psyches", "insinuated", "taros", "conceited", "verso", "kulbushan", "panafi", "strife", "executions", "quindlen", "6/96", "troublemaker", "newsreels", "marlowes", "and-white", "blethyns", "constitution", "fatigues", "echols", "isaach", "loic", "heightening", "regina", "matarazzo", "floyds", "neruda", "bradford", "yumikos", "chutkowski", "lows", "capably", "wooded", "narrower", "boyishly", "tahereh", "hampshire", "sabbath", "eamon", "chickens", "savageness", "restorers", "icelands", "2-1/2", "layout", "giller", "emilfork", "expansion", "expansive", "scardino", "johansson", "1431", "zhivago", "budd", "ueberroth", "rock-and-roll", "deedee", "reveled", "unsolvable", "churchill", "sitch", "vont", "godards", "feder", "bakkers", "drilled", "bateau", "mohamad", "apparently-simple", "amini", "knieper", "chariots", "tenseness", "sommer", "arranges", "dorothys", "innies", "11/4/94", "faux", "bonjour", "esumi", "olympiad", "unerring", "croner", "toothache", "hironobu", "atonement", "orange-hued", "karens", "elodie", "junket", "biswas", "grotto", "andante", "press-only", "traditionalist", "interconnections", "barancik", "undetermined", "academically", "ailing", "vittet", "civics", "mcdaniel", "see--or", "kincaid", "canonization", "billboards", "beefed", "harnesses", "nanni", "empathizes", "delerue", "pummeling", "spoken-word", "berlioz", "engulfs", "rectified", "hettinger", "kelli", "christof", "pbss", "rottens", "gonzalez", "tiananmen", "themed", "curiousity", "skerry", "libby", "mechas", "boone", "guitarists", "balcony", "satine", "eclipsing", "furlongs", "kern", "underscores", "maggies", "_period_", "taskmaster", "acknowledges", "unbounded", "fast-attraction", "thivisol", "zaza", "himalaya", "nosferatu", "magda", "much-reviled", "susans", "nesbitt", "specialized", "bouchez", "concocted", "contamination", "borrower", "adjuster", "mitterrands", "knuckle", "rosebud", "wampa", "antonis", "relationship-based", "trousdale", "immemorial", "nakabori", "facades", "popaul", "danes", "camelia", "irans", "rennahan", "[peter]", "abuser", "layered", "ahn", "comstock", "apparently-", "drawer", "woodwards", "_can_", "salens", "sclerosis", "mister", "amistads", "24-hour-a-day", "pher", "re-interpreting", "/la", "reckoned", "wierzbicki", "112", "139", "observant", "deviance", "porch", "transfixes", "annick", "hana", "20s", "mobsters", "bravely", "schamus", "two-plus", "misinterpret", "uncut", "mockumentaries", "cecchi", "purist", "creepily", "michell", "humane", "demonaco", "intimidated", "waffles", "thorntons", "id4", "backdraft", "dexterity", "gainsbourg", "beetle", "speculation", "cite", "nebulous"};
	public static String[] reviewerFeaturesWords={"show", "though", "subscribe", "acceptable", "particularly", "simply", "solid", "nature", "ultimately", "familiar", "entirely", "believable", "appealing", "rare", "fast", "mostly", "potential", "necessary", "particular", "central", "opportunity", "perspective", "largely", "worthwhile", "apparent", "apparently", "primarily", "universal", "superb", "core", "evident", "therefore", "fortunately", "mesmerizing", "competent", "vastly", "although", "profanity", "despite", "unfortunately", "difficult", "contrived", "unexpected", "critical", "melodramatic", "unfortunate", "distracting", "film", "movie", "story", "--"};
	public static String[] reviewerFeaturesbigramWords={"motion-picture", "waste-money", "dont-waste", "running-time", "message-subject", "reply-message", "rated-pg-13", "fine-kids", "son-jeffrey", "fine-teenagers", "older-teenagers", "theres-nothing", "film-one", "motion-pictures", "running-length", "film-makers", "far-more", "relationship-between", "kind-film", "very-good", "theres-little", "film-making", "screen-presence", "doesnt-take", "film-maker", "film-film", "theres-enough", "find-yourself", "theres-one", "entertainment-value", "taking-place", "even-better", "entire-movie", "rated-probably", "end-credits", "title-character", "films-title", "films-end", "nothing-offend"};


	public static String[] mulFeaturesWords={"fine", "effective", "perfect", "wonderful", "power", "understand", "fascinating", "important", "intelligent", "powerful", "rich", "rare", "subtle", "minor", "emotions", "brilliant", "wonderfully", "masterpiece", "suppose", "upbeat", "masterful", "keen", "tolerable", "brag", "although", "bad", "unfortunately", "supposed", "worse", "complex", "tragedy", "dull", "dumb", "awful", "force", "boring", "uneven", "annoying", "mess", "lifeless", "badly", "embarrassing", "inane", "inept", "abomination", "unfunny", "watchable", "academy", "strongly", "film", "story"};
	public static String[] mulFeaturesbigramWords={"motion-picture", "mature-themes", "one-best", "best-performance", "thumbs-down", "best-picture", "best-films"};

	public static String[] binFeaturesWords={"fine", "quite", "interesting", "strong", "effective", "acceptable", "simple", "perfect", "wonderful", "solid", "nevertheless", "power", "fascinating", "memorable", "award", "predictable", "moving", "intelligent", "powerful", "surprising", "rare", "subtle", "perfectly", "hilarious", "brilliant", "wonderfully", "perspective", "strength", "masterpiece", "fortunately", "poignant", "incredible", "mesmerizing", "outstanding", "recommendation", "masterful", "resolved", "keen", "delicious", "simplicity", "although", "bad", "down", "problem", "unfortunately", "supposed", "worse", "complex", "tragedy", "dull", "dumb", "awful", "boring", "bland", "tedious", "annoying", "lame", "lifeless", "pointless", "mindless", "lackluster", "embarrassing", "bore", "juvenile", "laughable", "film", "story"};
	public static String[] binFeaturesbigramWords={"motion-picture", "character-study", "one-best", "runs-long", "1/2-see", "director-robert", "ensemble-cast", "waste-time", "movie-made", "thumbs-down", "find-film", "thing-film", "few-laughs", "little-long", "edge-seat", "breaking-waves", "david-lynch", "best-actor", "surprise-ending", "myself-recommend", "give-single"};


	//public static String[] allFeaturesWords={"film", "one", "movie", "more", "story", "films", "much", "--", "even", "up", "time", "show", "out", "see", "director", "characters", "little", "good", "picture", "many", "those", "make", "never", "dont", "few", "character", "way", "script", "best", "two", "doesnt", "such", "look", "something", "theres", "scenes", "enough", "first", "isnt", "movies", "makes", "audience", "performance", "life", "being", "kind", "rated", "although", "part", "well", "comedy", "bad", "better", "people", "made", "very", "love", "between", "scene", "work", "without", "plot", "year", "still", "through", "seems", "long", "both", "violence", "great", "acting", "funny", "think", "give", "nothing", "action", "really", "minutes", "thats", "actors", "cast", "humor", "here", "screen", "real", "fine", "over", "sense", "know", "music", "kids", "though", "another", "quite", "big", "role", "going", "seen", "subject", "hard", "end", "excellent", "screenplay", "anything", "moments", "before", "probably", "around", "less", "last", "feel", "lot", "find", "same", "far", "things", "right", "line", "take", "go", "money", "come", "enjoyable", "sex", "comes", "seem", "point", "interesting", "times", "making", "thing", "message", "motion", "new", "john", "always", "poor", "takes", "man", "gives", "cant", "world", "teenagers", "running", "perhaps", "want", "down", "totally", "ending", "meant", "language", "fun", "fact", "years", "actually", "average", "cinematography", "gets", "plays", "bit", "waste", "hes", "didnt", "themes", "performances", "worth", "profanity", "worst", "watching", "place", "given", "back", "nudity", "certainly", "problem", "top", "especially", "viewers", "original", "family", "unbearable", "opinions", "found", "im", "becomes", "written", "done", "play", "easy", "mine", "different", "romantic", "sure", "strong", "someone", "star", "pg-13", "reflect", "tale", "full", "material", "expressed", "set", "pictures", "anyone", "sexual", "old", "together", "details", "employers", "drama", "actor", "each", "away", "shows", "during", "matter", "watch", "subscribe", "runs", "dialogue", "reason", "rating", "david", "high", "special", "thought", "three", "again", "everything", "lines", "instead", "style", "effective", "looks", "half", "hollywood", "trying", "recommend", "now", "result", "production", "human", "age", "level", "american", "keep", "version", "works", "case", "true", "acceptable", "need", "comic", "certain", "series", "parts", "itself", "men", "sometimes", "turns", "whose", "energy", "become", "several", "everyone", "obvious", "sort", "playing", "based", "once", "small", "goes", "feels", "mpaa", "along", "ones", "romance", "simple", "believe", "idea", "youre", "whole", "sequences", "thriller", "played", "whether", "effects", "use", "leave", "care", "laughs", "seeing", "left", "moment", "completely", "michael", "particularly", "piece", "put", "looking", "seemed", "recent", "short", "experience", "second", "images", "theater", "serious", "turn", "elements", "having", "heart", "perfect", "despite", "used", "entertaining", "directed", "exactly", "emotional", "compelling", "reply", "course", "easily", "feature", "room", "simply", "expect", "job", "unfortunately", "young", "tell", "black", "situations", "tone", "impressive", "others", "robert", "difficult", "title", "narrative", "relationship", "pretty", "adult", "possible", "word", "manages", "rest", "stories", "wonderful", "book", "war", "brief", "quality", "camera", "solid", "theyre", "mind", "nice", "lost", "including", "dark", "example", "directors", "getting", "nevertheless", "james", "art", "hour", "arent", "direction", "himself", "novel", "genre", "final", "rarely", "under", "producers", "nearly", "lack", "son", "entertainment", "supporting", "day", "main", "next", "sequence", "1/2", "keeps", "older", "hand", "screening", "none", "approach", "taking", "attention", "giving", "dramatic", "shot", "act", "english", "power", "number", "until", "visual", "single", "audiences", "clear", "cinema", "review", "tension", "question", "guy", "documentary", "close", "problems", "viewer", "couple", "women", "premise", "home", "entire", "mystery", "understand", "lead", "interest", "ends", "eyes", "theme", "attempt", "feeling", "wrong", "tries", "horror", "fascinating", "roles", "important", "classic", "except", "pg", "showing", "stars", "doing", "credits", "liked", "writer", "frequently", "white", "gave", "appears", "supposed", "appeal", "nature", "taken", "opening", "live", "memorable", "side", "plenty", "laugh", "genuine", "jeffrey", "uses", "length", "occasionally", "features", "mature", "beauty", "effort", "history", "cinematic", "already", "richard", "subtitles", "game", "wasnt", "offers", "face", "success", "sound", "woman", "words", "children", "ultimately", "silly", "interested", "youll", "saw", "released", "dialog", "french", "award", "told", "extremely", "shots", "light", "sets", "familiar", "hope", "predictable", "de", "conclusion", "jokes", "maybe", "past", "dead", "shown", "surprise", "sweet", "name", "hours", "against", "actress", "early", "couldnt", "chance", "try", "view", "ways", "enjoy", "leads", "finally", "entirely", "start", "death", "city", "leaves", "video", "happens", "filmed", "bond", "shes", "depth", "presence", "moving", "beautiful", "person", "natural", "usually", "slow", "youve", "musical", "felt", "tv", "intelligent", "reality", "major", "mr", "attempts", "remember", "noir", "somewhat", "unique", "surprisingly", "political", "clearly", "guess", "television", "fairly", "manner", "happy", "summer", "peter", "figure", "mood", "ridiculous", "impossible", "favorite", "believable", "editing", "guys", "wanted", "disney", "appear", "telling", "chemistry", "powerful", "situation", "drug", "talk", "painfully", "10", "mark", "george", "head", "filled", "hero", "worse", "kevin", "fiction", "provides", "days", "whats", "themselves", "background", "house", "tells", "rich", "fans", "low", "straight", "presented", "called", "complete", "change", "typical", "similar", "surprising", "starring", "using", "appealing", "successful", "generally", "night", "satisfying", "read", "heavy", "adults", "above", "points", "wonder", "rare", "body", "intriguing", "effect", "twists", "study", "storyline", "ive", "large", "type", "involving", "focus", "credit", "stuff", "charm", "upon", "starts", "sounds", "modern", "atmosphere", "happen", "truly", "run", "edge", "fast", "provide", "mostly", "villain", "basic", "subtle", "potential", "talent", "satire", "beginning", "lots", "minor", "perfectly", "ability", "overall", "impact", "beyond", "bring", "personality", "wont", "means", "clever", "thinking", "necessary", "involved", "myself", "school", "particular", "content", "oscar", "yes", "saying", "coming", "seriously", "sexuality", "unlike", "distributor", "trouble", "comedies", "cute", "release", "development", "four", "mild", "issues", "usual", "girls", "central", "deep", "williams", "die", "complex", "tom", "mean", "wish", "truth", "lets", "behind", "fresh", "setting", "hilarious", "aspects", "flat", "cut", "allen", "pace", "help", "add", "expected", "voice", "emotions", "intelligence", "fall", "score", "talking", "reasons", "animated", "previous", "alone", "martin", "form", "parody", "fair", "sad", "choice", "highly", "lives", "physical", "key", "later", "tragedy", "questions", "delivers", "kid", "latest", "events", "merely", "throughout", "personal", "ideas", "ill", "violent", "king", "adventure", "present", "female", "critics", "forced", "worked", "developed", "send", "minute", "pacing", "moviepage", "stage", "offer", "create", "casting", "country", "remains", "dull", "relationships", "slightly", "gone", "smile", "writers", "list", "letter", "aspect", "color", "turned", "amusing", "parents", "steven", "quickly", "realistic", "cheap", "individual", "miss", "writing", "boy", "brings", "melodrama", "strange", "pleasant", "longer", "air", "male", "created", "gags", "considering", "deal", "dog", "needs", "debut", "period", "colors", "culture", "numerous", "known", "late", "storys", "working", "lee", "yourself", "reaction", "brilliant", "wouldnt", "career", "limited", "paul", "popular", "joke", "call", "writer/director", "smart", "robin", "red", "wonderfully", "opportunity", "lies", "boys", "convincing", "rock", "somehow", "element", "social", "brothers", "knows", "effectively", "twist", "third", "sequel", "society", "suspense", "went", "makers", "dance", "opera", "share", "absolutely", "screenwriter", "hit", "portrayal", "pure", "group", "fashion", "friends", "today", "blood", "formula", "century", "touching", "girl", "date", "lacks", "jim", "carefully", "ten", "came", "car", "over-the-top", "adaptation", "willing", "jones", "woody", "evil", "science", "thin", "perspective", "fantasy", "pieces", "blue", "deserves", "imagine", "dumb", "father", "jack", "bizarre", "remake", "flaws", "realize", "filmmaker", "concept", "eye", "wild", "learn", "space", "awful", "adds", "comedic", "needed", "bunch", "intense", "force", "delightful", "kept", "middle", "stupid", "bill", "laughter", "songs", "viewing", "waiting", "cinematographer", "equally", "within", "proves", "emotion", "creating", "touch", "producer", "brought", "value", "mainly", "likable", "ground", "stay", "sight", "appropriate", "strength", "loved", "murder", "falls", "boring", "project", "aside", "begin", "taste", "spend", "otherwise", "common", "crime", "living", "amount", "exception", "concerned", "child", "theaters", "welcome", "general", "killer", "substance", "song", "america", "wife", "doubt", "basically", "hold", "eventually", "hardly", "okay", "purpose", "follow", "talented", "costumes", "hear", "fails", "whatever", "five", "surface", "bland", "magic", "allows", "office", "significant", "charming", "fire", "contains", "scott", "fully", "results", "thumbs", "note", "unusual", "members", "filmmakers", "loud", "wit", "intended", "took", "mistake", "heard", "uneven", "consider", "image", "engaging", "battle", "quirky", "god", "warm", "numbers", "turning", "business", "somewhere", "intensity", "12", "water", "chase", "moves", "weak", "gore", "news", "frank", "cartoon", "missing", "albeit", "answer", "joe", "performers", "considered", "sit", "traditional", "kiss", "masterpiece", "stand", "open", "fight", "begins", "amazing", "includes", "van", "capable", "tedious", "directing", "appreciate", "energetic", "soon", "issue", "range", "indeed", "obviously", "laughing", "thanks", "hate", "virtually", "chris", "future", "ago", "cold", "biggest", "towards", "academy", "designed", "stephen", "christopher", "worthy", "pleasure", "sympathetic", "episode", "press", "moral", "imaginative", "featuring", "move", "visually", "suspect", "various", "honest", "disappointed", "match", "reading", "road", "budget", "ask", "box", "era", "slapstick", "stone", "fan", "creates", "develop", "grace", "happened", "largely", "presents", "forget", "class", "count", "promise", "joy", "speed", "passion", "ages", "accomplished", "visuals", "fear", "id", "sitting", "caught", "acted", "psychological", "contrived", "sharp", "company", "include", "scary", "steve", "ready", "wide", "cuts", "enjoyed", "teen", "relatively", "latter", "hands", "disappointing", "park", "dream", "spirit", "price", "unexpected", "inspired", "puts", "contrast", "havent", "walk", "chan", "odd", "alan", "humorous", "mother", "wait", "credible", "charles", "protagonist", "failed", "surprises", "leaving", "slowly", "younger", "shock", "mike", "climax", "bright", "affair", "technical", "conventional", "trite", "theatrical", "wars", "shallow", "lovers", "missed", "routine", "worthwhile", "structure", "seven", "historical", "spent", "annoying", "added", "opens", "festival", "process", "gay", "flick", "alive", "avoid", "near", "epic", "presentation", "dogs", "absurd", "inside", "tried", "1996", "studio", "tough", "thoroughly", "stunning", "imagination", "belief", "jane", "order", "1997", "mention", "deliver", "public", "howard", "apparent", "product", "parker", "cause", "further", "apparently", "sympathy", "tragic", "accent", "following", "creative", "frightening", "scream", "drawn", "fit", "resolution", "tim", "looked", "viewed", "comparison", "william", "knew", "suppose", "detail", "british", "grand", "awkward", "photography", "disaster", "target", "smith", "lesson", "artistic", "players", "variety", "emotionally", "mess", "statement", "buddy", "characterization", "christmas", "surprised", "mediocre", "center", "protagonists", "western", "changes", "11", "la", "impression", "genuinely", "pull", "device", "ordinary", "source", "crowd", "unless", "greatest", "first-time", "allow", "happening", "critical", "meaning", "mary", "animation", "offering", "ride", "roger", "inevitable", "standard", "conflict", "soul", "undoubtedly", "interaction", "1995", "likes", "decent", "lame", "lacking", "efforts", "wedding", "necessarily", "vision", "unnecessary", "asks", "jerry", "tired", "intellectual", "primarily", "represents", "became", "thrillers", "beautifully", "control", "stuck", "crude", "lifeless", "treat", "innocence", "manage", "consistently", "addition", "actions", "pulp", "regardless", "bergman", "becoming", "references", "punch", "andrew", "understanding", "hair", "touches", "universal", "heads", "graphic", "batman", "pair", "stop", "justice", "realized", "manipulative", "magical", "1994", "loves", "pointless", "moore", "youd", "shame", "religious", "pain", "choices", "knowing", "food", "pop", "dozen", "thomas", "originality", "stock", "evidence", "decided", "melodramatic", "soap", "difference", "reminded", "terrible", "subplot", "won", "broad", "speak", "event", "recognize", "colorful", "category", "marvelous", "fare", "circumstances", "displays", "degree", "mix", "shakespeare", "subplots", "finds", "break", "disturbing", "superb", "disneys", "billy", "subtlety", "huge", "ryan", "friend", "positive", "deeply", "ugly", "succeeds", "poorly", "lovely", "walking", "delight", "loose", "jackie", "cliches", "beneath", "core", "insightful", "leading", "dancing", "state", "wasted", "primary", "monster", "street", "famous", "confused", "sadly", "save", "names", "lively", "free", "sam", "opinion", "evident", "appearance", "anyway", "disappointment", "therefore", "hell", "edward", "harry", "carry", "engrossing", "current", "reasonably", "crafted", "actresses", "quiet", "speaks", "building", "occasional", "books", "hasnt", "faces", "farce", "filmmaking", "winning", "mans", "provided", "team", "started", "twenty", "capture", "animals", "one-liners", "acts", "earth", "actual", "screenwriters", "remarkably", "subjects", "places", "humanity", "lawrence", "serves", "cop", "striking", "footage", "villains", "besides", "values", "exciting", "escape", "tremendous", "gorgeous", "oh", "frustrating", "individuals", "equal", "return", "bruce", "earlier", "animal", "thinks", "terms", "refreshing", "expectations", "keeping", "fault", "mouth", "witty", "forward", "green", "disbelief", "innocent", "pretentious", "captures", "roll", "admit", "messages", "nc-17", "singing", "feelings", "essentially", "ed", "drive", "master", "generate", "brian", "trek", "aware", "constant", "delivered", "politics", "stands", "handled", "confusing", "overly", "expecting", "naked", "cover", "brain", "tarantino", "heroes", "track", "bored", "danger", "write", "low-key", "reminiscent", "front", "flaw", "old-fashioned", "dr", "club", "speech", "commercial", "involves", "logic", "kill", "portrait", "normal", "gotten", "frame", "lose", "seat", "figures", "davis", "straightforward", "creepy", "loses", "check", "suffers", "episodes", "decision", "clich", "combination", "badly", "weve", "mission", "notice", "anthony", "constantly", "thrown", "secret", "respect", "identity", "managed", "attitude", "cry", "gag", "mixed", "gun", "realism", "pay", "raw", "setup", "spends", "tears", "handle", "americans", "soundtrack", "carrey", "wondering", "funniest", "york", "trailers", "film-making", "system", "quick", "barely", "spectacular", "accept", "town", "careful", "draw", "relief", "black-and-white", "cool", "sports", "jackson", "italian", "paced", "stick", "unlikely", "storytelling", "promising", "due", "tales", "scripted", "speaking", "finding", "allowed", "fortunately", "plus", "industry", "nicely", "bits", "murphy", "please", "expressions", "prove", "danny", "ice", "mainstream", "whos", "failure", "toward", "editor", "response", "ingmar", "bloody", "party", "argue", "explain", "behavior", "admittedly", "finale", "poignant", "serve", "outside", "tony", "answers", "artist", "dreams", "importance", "growing", "computer", "silent", "personalities", "attractive", "laughed", "search", "false", "holes", "print", "safe", "bob", "occasions", "provocative", "definitely", "talents", "goofy", "guilty", "incredible", "produced", "hopkins", "serial", "jonathan", "describe", "thematic", "closing", "obligatory", "shoot", "scorsese", "six", "shouldnt", "barry", "intentions", "providing", "rate", "hits", "desire", "lady", "henry", "examination", "flesh", "ambitious", "sides", "chosen", "lewis", "challenging", "arnold", "types", "incredibly", "herself", "vehicle", "commentary", "anywhere", "fill", "russell", "win", "opportunities", "catch", "generation", "foreign", "named", "depressing", "queen", "notes", "innovative", "frequent", "insight", "allowing", "demands", "flawed", "silence", "todays", "strike", "season", "shadow", "journey", "matters", "contemporary", "nasty", "fits", "dry", "oliver", "offbeat", "meet", "mere", "games", "display", "local", "trip", "pathetic", "skills", "adequate", "wrote", "studios", "erotic", "fate", "praise", "sleep", "chinese", "toy", "recently", "correctly", "grow", "entry", "intimate", "rules", "context", "design", "hitchcock", "painful", "buy", "step", "terrific", "hot", "alien", "brooks", "independent", "mrs", "1950s", "ray", "rob", "exercise", "mesmerizing", "cutting", "watchable", "immediately", "daniel", "scope", "explicit", "letting", "land", "scripts", "shocking", "superior", "washington", "scenery", "terribly", "eat", "double", "whereas", "japanese", "began", "extreme", "racial", "remarkable", "enjoyment", "explosions", "decade", "photographed", "spielberg", "rush", "adapted", "memory", "normally", "friendship", "changed", "15", "remind", "affection", "sea", "build", "explains", "constructed", "whenever", "jennifer", "nick", "bleak", "identify", "absolute", "homage", "reach", "comfortable", "aliens", "possibly", "narration", "low-budget", "skin", "teenager", "don", "ford", "wear", "fifteen", "utterly", "easier", "massive", "naturally", "brown", "deeper", "gratuitous", "race", "critic", "paris", "worry", "inner", "sign", "fish", "usage", "connection", "winner", "grant", "hughes", "julia", "experiences", "drop", "calls", "neutral", "werent", "upbeat", "jungle", "branagh", "record", "forgettable", "drugs", "superficial", "joan", "charlie", "conversations", "spark", "blend", "execution", "caring", "mixture", "willis", "hint", "crazy", "gripping", "holds", "forgotten", "roberts", "greater", "empty", "west", "ignore", "eddie", "remotely", "characterizations", "required", "challenge", "maker", "gritty", "ensemble", "cynical", "happiness", "costume", "former", "putting", "focused", "pass", "draws", "basketball", "portrayed", "irony", "joel", "outstanding", "handsome", "examples", "potentially", "unfortunate", "nine", "giant", "thirty", "hill", "interpretation", "bringing", "painting", "daring", "fairy", "strictly", "member", "direct", "personally", "recall", "noteworthy", "triumph", "camp", "ii", "island", "chilling", "uninteresting", "shooting", "grim", "dirty", "baseball", "marketing", "harris", "climactic", "unpleasant", "sheer", "half-hour", "offered", "haunting", "max", "mildly", "gary", "asked", "million", "extra", "saving", "higher", "successfully", "trust", "irritating", "schwarzenegger", "blues", "notably", "occurs", "real-life", "angels", "breaking", "nomination", "favor", "proceedings", "plain", "forever", "resulting", "golden", "jon", "strikes", "balance", "larry", "heaven", "treatment", "excitement", "exist", "requires", "miramax", "approaches", "sayles", "tricks", "trial", "veteran", "performer", "total", "=20", "recommendation", "flying", "beat", "charisma", "market", "similarly", "formulaic", "forth", "pat", "listen", "somber", "moon", "developing", "strongly", "choose", "adventures", "hanks", "baby", "hurt", "ironic", "relies", "received", "quentin", "offensive", "jurassic", "reminds", "complicated", "shine", "pick", "outlandish", "20", "crew", "sorry", "term", "showed", "one-dimensional", "strangely", "conversation", "gory", "thick", "scare", "helped", "anne", "bodies", "metaphor", "described", "seagal", "faith", "credibility", "directorial", "eric", "puttnam", "solely", "remain", "flair", "classics", "position", "medium", "godfather", "momentum", "gross", "suggest", "similarities", "throw", "documentaries", "changing", "tense", "unable", "follows", "appeared", "develops", "attempting", "sci-fi", "controversial", "douglas", "urban", "collection", "stretch", "snow", "fly", "morality", "ron", "test", "von", "aimed", "apart", "police", "generic", "private", "tradition", "stronger", "opposite", "college", "adam", "brother", "filming", "edited", "andy", "70s", "hoping", "arguably", "cross", "claim", "born", "understated", "loss", "sean", "afraid", "outrageous", "weight", "surreal", "artificial", "deserve", "dennis", "valley", "cult", "stereotypes", "brilliance", "blame", "lynch", "treated", "mamet", "endearing", "90s", "excuse", "craft", "portion", "risk", "mentioned", "eastwood", "impressed", "planet", "occur", "clean", "lush", "served", "matthew", "scared", "cage", "field", "brand", "ghost", "clothes", "compared", "glory", "hidden", "stays", "strongest", "professor", "courage", "kenneth", "smoking", "dangerous", "mindless", "amy", "timing", "fifth", "hamlet", "thus", "funnier", "cameron", "flavor", "supposedly", "inventive", "reveal", "uninspired", "available", "convey", "breath", "spanish", "lighting", "incidents", "adding", "13", "exploration", "ms", "bigger", "ian", "lackluster", "unconventional", "satirical", "mundane", "proper", "guns", "comments", "teens", "spots", "unbelievable", "cameo", "learned", "twisted", "bullock", "facial", "confusion", "paper", "courtroom", "literally", "spot", "drags", "evocative", "accents", "considerably", "jean", "productions", "faithful", "miller", "warner", "noted", "groups", "hundred", "passing", "builds", "struggle", "taylor", "eerie", "forces", "states", "payoff", "lion", "derivative", "broken", "expression", "generated", "contrivances", "chases", "visceral", "offend", "ring", "makeup", "nostalgia", "nostalgic", "plausible", "heavily", "skill", "spin", "cat", "seemingly", "90", "menace", "floor", "wise", "task", "conventions", "abuse", "sensitive", "diverting", "belongs", "standards", "avoids", "preposterous", "embarrassing", "conspiracy", "exposition", "obsession", "warning", "angle", "obscure", "dinner", "lighthearted", "antics", "close-ups", "suddenly", "october", "cliched", "princess", "pleasing", "profound", "redemption", "territory", "vampire", "arc", "ben", "atmospheric", "biting", "ad", "fox", "students", "hearts", "table", "poetry", "throws", "leigh", "falling", "christian", "trapped", "levels", "needless", "attempted", "consistent", "author", "patrick", "nightmare", "camerawork", "crisp", "august", "concerns", "novels", "professional", "player", "gentle", "troubled", "halloween", "sandra", "creatures", "slice", "flashbacks", "detective", "church", "beast", "gift", "judge", "resolved", "advice", "bottom", "briefly", "youth", "wilson", "cultural", "confidence", "playful", "worlds", "eight", "initial", "legend", "blow", "masterful", "heartfelt", "fast-paced", "nowhere", "altman", "instances", "memories", "jeff", "sun", "uncomfortable", "basis", "dramatically", "tour", "originally", "caricature", "below", "restrained", "area", "devoid", "campy", "weakness", "weird", "chief", "hearing", "relate", "band", "exceptional", "religion", "repetitive", "onto", "staging", "gibson", "narrator", "pervasive", "piano", "reasonable", "30", "familiarity", "hat", "negative", "typically", "ludicrous", "notion", "ended", "vincent", "killers", "honesty", "sporadically", "hoffman", "views", "concern", "doug", "knowledge", "classification", "terry", "rise", "cartoonish", "notable", "voices", "hunt", "substantial", "pulls", "monty", "hopes", "sitcom", "reduced", "fighting", "soldiers", "legitimate", "jr", "on-screen", "iii", "seconds", "singer", "treats", "text", "live-action", "magnificent", "philosophy", "spoken", "prefer", "hollow", "exists", "technique", "spending", "advance", "extent", "cusack", "host", "suffice", "properly", "hugh", "revealing", "waters", "inane", "rough", "wanting", "criminal", "twice", "delivering", "absence", "faults", "so-called", "months", "argument", "pleasures", "proved", "previously", "held", "presenting", "intent", "cares", "costner", "enjoying", "anger", "psycho", "suggests", "woods", "associated", "obnoxious", "crucial", "dazzling", "minds", "dealing", "overcome", "method", "fascination", "flow", "le", "comment", "deals", "week", "pathos", "finish", "top-notch", "one-hundred", "slick", "motivation", "convoluted", "built", "talks", "feel-good", "jump", "curious", "extended", "tunes", "lights", "landscape", "crystal", "stale", "succeed", "instinct", "stupidity", "wears", "larger", "marks", "spiritual", "victim", "spectacle", "angles", "nights", "watched", "mannerisms", "cliche", "brilliantly", "convinced", "followed", "newcomer", "precisely", "measure", "manipulation", "delights", "gray", "technology", "niro", "glenn", "door", "tendency", "drag", "hadnt", "dynamic", "rain", "staged", "reviewed", "philip", "hood", "stunts", "revelation", "steals", "slight", "fatal", "executed", "clint", "joseph", "suitably", "endure", "risks", "league", "film-makers", "45", "delicate", "window", "explore", "gangster", "undeniable", "wind", "instantly", "capturing", "tend", "philosophical", "south", "desperate", "horrible", "combined", "startling", "gold", "granted", "possesses", "decades", "scale", "reviews", "unconvincing", "kong", "saturday", "twister", "awards", "demonstrates", "advantage", "independence", "flicks", "funeral", "admission", "pedestrian", "good-spirited", "continues", "liar", "learning", "luck", "path", "segment", "50", "russian", "gifted", "irish", "service", "kings", "included", "film-maker", "wayans", "woo", "consists", "movie-goers", "distracting", "palpable", "julie", "trick", "distance", "losing", "involve", "secondary", "heroine", "muddled", "accurate", "bound", "wrapped", "powers", "tones", "exceptionally", "literature", "attraction", "hated", "bear", "suspects", "supernatural", "fellow", "mad", "transformation", "teenage", "sandler", "failing", "push", "titanic", "sorts", "denis", "wood", "bridges", "twelve", "maximum", "sensibility", "bursts", "dramas", "carried", "simon", "rendition", "theory", "strengths", "versions", "walken", "1993", "theyve", "logical", "keen", "slasher", "stuart", "frankly", "rocky", "myers", "claude", "genius", "sister", "bore", "feast", "enthusiasm", "schindlers", "secrets", "breaks", "donald", "essence", "rhythm", "wall", "plots", "satisfy", "ken", "beings", "daughter", "differences", "miracle", "convincingly", "vulnerable", "jobs", "bears", "depiction", "grows", "elizabeth", "deft", "president", "blank", "precious", "rising", "creation", "kick", "101", "international", "blockbuster", "60s", "eating", "vivid", "carter", "ripe", "godard", "motivations", "dozens", "tight", "status", "resonance", "stylish", "proof", "keaton", "busy", "feet", "philadelphia", "sustain", "shift", "qualities", "interviews", "portions", "fights", "dad", "equivalent", "mask", "quest", "lucas", "womans", "holding", "mel", "delicious", "choreographed", "covers", "banal", "poetic", "limits", "fundamental", "program", "observations", "complexity", "well-crafted", "subtly", "inspire", "artists", "husband", "boxing", "earn", "reputation", "andre", "facts", "rose", "chose", "darkness", "reactions", "rule", "duvall", "featured", "limitations", "movement", "sticks", "diversion", "national", "lessons", "adrenaline", "hip", "vaguely", "lie", "unfunny", "afterwards", "surrounding", "brady", "dubious", "smiles", "riveting", "revenge", "americas", "appreciated", "charismatic", "sincerity", "contact", "assume", "kieslowski", "innuendo", "jordan", "explored", "ultimate", "ears", "potent", "nonsense", "placed", "fable", "storm", "environment", "inherent", "competent", "demand", "thoughtful", "helps", "indian", "seriousness", "madness", "link", "gordon", "ship", "excessive", "bathroom", "brutal", "pacino", "settings", "folks", "closer", "dan", "corner", "chuckles", "met", "accomplish", "coming-of-age", "kissing", "miscast", "ingredients", "plodding", "dean", "glass", "big-budget", "childrens", "shorter", "suffering", "allens", "100", "bonding", "hanging", "childhood", "thrills", "react", "machine", "specific", "angry", "decidedly", "emma", "wooden", "harrison", "notwithstanding", "technically", "bite", "dressed", "inept", "ahead", "stones", "curiosity", "likeable", "thought-provoking", "fake", "stanley", "suitable", "paid", "skip", "humans", "soft", "explanation", "earnest", "benefit", "cup", "listening", "etc", "well-acted", "southern", "anderson", "drink", "lucky", "victims", "terror", "shakespeares", "marriage", "projects", "deliciously", "tiny", "marshall", "devoted", "shines", "freedom", "bother", "experienced", "determined", "007", "touched", "anna", "sensuality", "crash", "hollywoods", "uniformly", "absent", "simplistic", "committed", "boasts", "ideal", "shades", "holocaust", "cruel", "effectiveness", "sell", "wings", "peoples", "tiresome", "size", "ninety", "aim", "apt", "susan", "nervous", "mars", "suit", "attack", "desperately", "stewart", "bitter", "spy", "reserved", "train", "hatred", "voice-over", "jarring", "purely", "misses", "stretches", "creativity", "teeth", "suffer", "digital", "politically", "holiday", "caper", "chuckle", "sincere", "venture", "media", "agree", "shadows", "admire", "support", "unforgettable", "forrest", "romeo", "ruth", "connect", "tender", "authentic", "point-of-view", "sudden", "driver", "information", "weakest", "sally", "sees", "australian", "directly", "cameos", "exaggerated", "travolta", "bed", "replies", "plan", "jay", "surely", "flashback", "guest", "minimal", "charms", "wonders", "souls", "burton", "mental", "glad", "bobby", "ivory", "goal", "meaningless", "beloved", "gestures", "verbal", "criticism", "token", "pedantic", "splendid", "rape", "arts", "captivating", "wisdom", "voiceover", "weeks", "harder", "lightweight", "flashes", "snipes", "jimmy", "understands", "sympathize", "murray", "bone", "consequences", "moved", "removed", "clips", "sentimental", "penn", "cake", "cats", "bar", "believes", "standout", "deadly", "staring", "cruise", "epilogue", "wins", "appearing", "prepared", "village", "inviting", "warmth", "inappropriate", "misery", "cheesy", "department", "beverly", "tango", "subtext", "jude", "glow", "awake", "neil", "maintain", "uplifting", "spice", "description", "directs", "cable", "causes", "alex", "hall", "mysterious", "eccentric", "influence", "recognizable", "lesser", "mighty", "sleeping", "suspension", "moreover", "random", "reeves", "scenario", "streets", "horse", "military", "astonishing", "lone", "understood", "court", "comparisons", "predecessor", "page", "segments", "95", "dysfunctional", "widely", "fred", "sparks", "calling", "thoughts", "taut", "searching", "sly", "pairing", "sinister", "polished", "pulling", "newton", "beach", "toys", "non-stop", "asset", "principal", "tune", "occasion", "heavy-handed", "blade", "starting", "turner", "screens", "citizen", "dose", "spoof", "sport", "cowboy", "ambiguity", "fictional", "manic", "community", "steal", "techniques", "location", "lived", "captured", "predictably", "china", "delightfully", "store", "meanwhile", "recycled", "highlights", "recognized", "lees", "indie", "co-stars", "improvement", "hotel", "marvelously", "casual", "families", "considerable", "al", "hey", "affecting", "plight", "coen", "cops", "kinds", "united", "demeanor", "lifted", "showcase", "signs", "regarding", "jacques", "downright", "burns", "burst", "pointed", "boredom", "relying", "poignancy", "firmly", "produce", "gump", "choppy", "dreamy", "lengthy", "encounter", "wildly", "albert", "whimsical", "waves", "80s", "rent", "johnson", "midnight", "model", "revealed", "root", "ignored", "ball", "would-be", "smiling", "thankfully", "depending", "lasting", "proud", "explaining", "loaded", "vietnam", "amidst", "cars", "con", "partially", "fat", "empire", "kit", "les", "undeniably", "pleased", "guessed", "buried", "frustration", "sweeping", "laura", "winter", "seeming", "vegas", "gere", "reference", "vastly", "confident", "plotting", "jason", "michel", "freeman", "excess", "needlessly", "lover", "priest", "backdrop", "questionable", "summers", "insights", "smoke", "realm", "absurdity", "ridicule", "january", "inspiration", "alexander", "finished", "johnny", "angel", "chocolate", "selling", "recognition", "connery", "rolling", "paradise", "delivery", "emphasis", "midst", "bull", "sick", "mayhem", "lovable", "witch", "firm", "asking", "fonda", "perfection", "ourselves", "battles", "modest", "romances", "dogma", "san", "reveals", "fills", "guilt", "juliet", "1990s", "dying", "witness", "wry", "fathers", "drinking", "trilogy", "horrific", "mountain", "killing", "june", "distraction", "transition", "greg", "convince", "kate", "inability", "theyll", "walter", "stark", "blown", "stilted", "heat", "wayne", "superlative", "breathtaking", "murky", "stops", "anymore", "robbins", "lips", "gilbert", "prime", "disjointed", "sundance", "spacey", "government", "variation", "unknown", "seats", "favorites", "bag", "bet", "silliness", "wearing", "stomach", "persona", "fool", "gas", "forms", "fewer", "responsibility", "finest", "clue", "jazz", "require", "celebration", "trailer", "scores", "existence", "doors", "coppola", "punches", "devices", "austin", "loving", "throwing", "reaches", "everywhere", "spite", "performed", "blind", "parent", "francis", "catherine", "suited", "shoulders", "hang", "accessible", "bullets", "agent", "50s", "restoration", "relevant", "sentimentality", "represent", "requisite", "silicon", "alternative", "frantic", "passionate", "claims", "guarantee", "killed", "gregory", "moody", "forceful", "function", "peace", "set-up", "possibilities", "saint", "devastating", "plane", "sink", "fashioned", "domestic", "peak", "conflicts", "solution", "fond", "insults", "wave", "deserving", "net", "literary", "object", "campaign", "freshness", "devil", "rewarding", "covered", "carries", "thrilling", "grown", "sequels", "smiths", "nominated", "spell", "demonstrate", "kane", "morris", "credited", "ambiguous", "exploring", "underlying", "prison", "carol", "meaningful", "stallone", "whatsoever", "romp", "harold", "vignettes", "significantly", "hype", "condition", "merit", "doctor", "brains", "juvenile", "comical", "bold", "sexy", "sugar", "superfluous", "endless", "sarah", "glossy", "chooses", "marc", "vs", "gem", "remembered", "consideration", "absorbing", "tame", "depicted", "roy", "charge", "jean-luc", "driving", "stealing", "unfold", "unpredictable", "myth", "todd", "crying", "opened", "reached", "trees", "dick", "bittersweet", "releases", "macho", "sixth", "concert", "challenges", "raise", "appropriately", "exploitation", "contain", "ratio", "excesses", "moderately", "distribution", "avoiding", "possibility", "native", "possess", "lazy", "factor", "compassion", "suspenseful", "sophisticated", "carpenter", "screaming", "patience", "phone", "incident", "hopelessly", "extraordinary", "pale", "pays", "interview", "shakespearean", "replaced", "saved", "grainy", "dumber", "85", "justify", "paramount", "lacked", "meat", "law", "network", "wright", "account", "diverse", "sat", "flawless", "imitation", "resemblance", "fallen", "rousing", "racism", "outcome", "wrenching", "alas", "quarter", "correct", "stern", "rely", "hopeless", "explores", "howards", "morning", "formulas", "unwatchable", "hong", "engage", "roth", "senses", "string", "kilmer", "helen", "fitting", "metal", "lisa", "evening", "vicious", "amazingly", "highlight", "increasingly", "fail", "fame", "lighter", "shut", "passes", "hills", "clerks", "flash", "odonnell", "swallow", "mass", "german", "unsettling", "models", "paltrow", "jan", "glorious", "endings", "lit", "guaranteed", "lately", "crow", "multiple", "tie", "movements", "implausible", "wes", "introduces", "shifts", "gene", "survive", "bride", "krzysztof", "explained", "deny", "twin", "preachy", "wacky", "characteristic", "blair", "attacks", "dreary", "mysteries", "entertained", "connected", "frankenstein", "caused", "000", "competition", "williamson", "utter", "harmless", "circle", "ominous", "continue", "dalmatians", "hole", "jeremy", "layers", "essential", "appreciation", "poverty", "decide", "soderbergh", "elaborate", "glimpse", "framed", "ponder", "mixing", "expensive", "stranger", "malkovich", "behold", "well-developed", "establishing", "inconsequential", "amounts", "perceptive", "resume", "amc", "pink", "del", "struggling", "40", "comfort", "inspiring", "porn", "entries", "foremost", "expressive", "guessing", "abilities", "truman", "mode", "mistakes", "sky", "achieved", "unfamiliar", "adorable", "ties", "enhanced", "mamets", "teacher", "drawing", "nicholas", "difficulties", "everyday", "garden", "ghosts", "conviction", "shamelessly", "radio", "catholic", "insulting", "gould", "hopefully", "willingness", "grotesque", "reel", "chair", "exclusively", "neatly", "harsh", "spirited", "initially", "bites", "participants", "levinson", "darker", "format", "audacious", "patient", "amusement", "outing", "clash", "godzilla", "goldberg", "paints", "sunday", "nicolas", "bugs", "reservoir", "majority", "sing", "sheen", "compare", "meeting", "standing", "chances", "believed", "wake", "understandable", "mirror", "switches", "alike", "damage", "pet", "visions", "established", "improbable", "1970s", "frontal", "signature", "newman", "triangle", "invisible", "introduced", "edges", "vocal", "staying", "titles", "deaths", "josh", "accepting", "heroic", "trap", "spirits", "controlled", "enigma", "coffee", "lends", "irrelevant", "radical", "tricky", "generous", "spike", "ably", "ernest", "juliette", "eugene", "physically", "relative", "adolescent", "fugitive", "moores", "section", "self-deprecating", "stages", "mothers", "nicholson", "accompanied", "succeeded", "miserable", "produces", "excessively", "base", "hitting", "troopers", "pushes", "responsible", "embarrassed", "periodically", "emphasize", "lesbian", "satisfied", "complications", "depends", "distinct", "gadgets", "mermaid", "michelle", "symbolism", "welles", "closely", "kubrick", "motives", "discover", "repeatedly", "dress", "forty", "hed", "starship", "noise", "oddly", "cost", "travel", "uniquely", "1960s", "modern-day", "tear", "grade", "pitch", "isolated", "traffic", "laughable", "judy", "trio", "dancers", "intentionally", "imagery", "exhilarating", "1992", "forgive", "walsh", "aint", "sensitivity", "lifes", "executive", "chabrol", "frances", "branaghs", "leslie", "chasing", "according", "phenomenon", "discussion", "steel", "discovery", "adams", "chaos", "incorrectly", "richly", "stiff", "rick", "movie-goer", "paying", "forest", "claire", "ross", "rendered", "struggles", "inevitably", "acclaimed", "overlook", "introduction", "darkly", "arrival", "vast", "feeble", "legs", "fancy", "foolish", "causing", "pride", "driven", "boat", "episodic", "explosion", "expects", "seattle", "corny", "sexually", "wilde", "outset", "reiner", "shake", "rings", "immediate", "bloated", "populated", "saves", "packed", "hunchback", "phil", "arguments", "liberal", "legends", "pitt", "travelogue", "25", "35", "mixes", "captain", "belong", "homosexual", "overacting", "kim", "caricatures", "mom", "degrees", "instance", "adaptations", "per", "dilemma", "reynolds", "sum", "erratic", "fortunate", "grave", "gruesome", "jewish", "advertising", "inferior", "snappy", "unfolds", "thank", "repeated", "mechanical", "teach", "ironically", "integrity", "discuss", "restraint", "insult", "dances", "proven", "lower", "argues", "redford", "nude", "gothic", "egoyan", "gimmick", "cards", "handles", "rhythms", "crowe", "elses", "harvey", "flight", "karen", "casino", "dropped", "deserved", "difficulty", "brad", "focuses", "lonely", "snippets", "installment", "overboard", "grisham", "shared", "inherently", "perception", "iron", "figgis", "earned", "jessica", "biography", "precise", "ah", "sweetness", "walt", "borders", "thereby", "corporate", "caliber", "ran", "recommending", "rushed", "tap", "ted", "grays", "menacing", "leary", "relaxed", "buildings", "talky", "disgusting", "jury", "electric", "trier", "aims", "ralph", "celebrity", "warriors", "devils", "gloss", "maudlin", "claustrophobic", "maria", "functions", "dollars", "internal", "describes", "deadpan", "jesus", "arresting", "cared", "focusing", "weapon", "exceedingly", "monsters", "angst", "predictability", "simplicity", "appearances", "nominations", "trainspotting", "rights", "heres", "nielsen", "resembles", "fraser", "breathe", "unhappy", "refuses", "dignity", "sub-plot", "decisions", "suits", "specifically", "nuanced", "destined", "damme", "breezy", "card", "report", "popularity", "uninvolving", "poem", "fiennes", "tolerance", "corruption", "youngsters", "insects", "closure", "womens", "copy", "shy", "tin", "quote", "1980s", "grasp", "related", "thrill", "enhance", "improved", "doses", "boast", "parodies", "walked", "believability", "good-natured", "grew", "honestly", "returns", "threatening", "drew", "maggie", "attitudes", "musicals", "rohmer", "abrupt", "boyle", "march", "recalls", "chain", "chans", "speeches", "liking", "cases", "bothered", "affected", "sloppy", "bean", "uncertain", "hokey", "elliott", "suspend", "roses", "junior", "detached", "revolution", "boot", "football", "positively", "willy", "buck", "transformed", "nuances", "variations", "super", "greatly", "designer", "vibrant", "matt", "ear", "wishing", "determine", "dorothy", "dated", "meal", "lingering", "zone", "milk", "generates", "finger", "quinn", "broadway", "lifestyle", "flatulence", "truths", "houses", "noting", "lawyer", "analysis", "asleep", "grief", "combines", "carreys", "switch", "enigmatic", "dame", "methods", "depp", "revelations", "bonds", "dope", "spinal", "lloyd", "sluggish", "trademark", "intimacy", "kingdom", "blowing", "gradually", "caine", "pinocchio", "tragedies", "torture", "pfeiffer", "computer-generated", "sensibilities", "farrelly", "hook", "cynicism", "loosely", "paint", "smaller", "detailed", "composed", "confrontations", "lemmon", "influenced", "displayed", "fourth", "overwrought", "coincidence", "leonard", "sumptuous", "interactions", "tedium", "lavish", "alfred", "hercules", "tucker", "samuel", "pierce", "emerge", "mouse", "celluloid", "sub-plots", "significance", "ridiculously", "varies", "unnecessarily", "coherent", "fell", "cleverly", "murders", "rises", "mentioning", "das", "relentlessly", "foot", "oz", "judgment", "ethan", "painted", "defined", "handling", "overblown", "smooth", "maguire", "twilight", "achieve", "outline", "vacation", "rap", "craven", "fluff", "tea", "coupled", "frightened", "regular", "tucci", "titled", "richardson", "minimalist", "make-up", "laughably", "meandering", "darn", "progresses", "arthur", "confess", "movie-going", "distant", "illustrate", "foundation", "grin", "diaz", "contrivance", "universe", "grandeur", "hunter", "disco", "cardboard", "commercials", "elliot", "grounded", "sounding", "wallace", "arms", "crisis", "remarks", "candy", "faster", "intricate", "manhattan", "package", "adept", "repetitious", "tarzan", "pulled", "purposes", "victor", "2000", "turturro", "aiming", "define", "embrace", "composer", "silver", "shanghai", "bare", "portraying", "stylistic", "overlong", "stunt", "campion", "generations", "tongue", "leap", "roots", "hence", "horrors", "maverick", "pushing", "unexpectedly", "limp", "bomb", "believing", "entertain", "unrated", "tongue-in-cheek", "achievement", "santa", "enchanted", "shares", "singularly", "schumacher", "closest", "aforementioned", "exploitive", "ann", "carl", "bus", "blatant", "33", "em", "lecture", "chen", "dinosaurs", "highway", "reaching", "perform", "strings", "light-hearted", "sonny", "1940s", "martial", "mock", "determination", "violin", "phrase", "flynt", "daniels", "greed", "threads", "adequately", "dragon", "sleepless", "intellectually", "rambling", "strangers", "conditions", "upset", "infinitely", "dare", "board", "affect", "cannes", "waynes", "barrymore", "friendly", "neat", "sentence", "turkey", "merchant", "belle", "belly", "borrows", "loser", "bones", "candidate", "walls", "sunrise", "admired", "alongside", "cameras", "bottle", "incapable", "agenda", "randy", "crimes", "tends", "co-writer", "maintains", "johns", "brooding", "bellcore", "inclusion", "wrestling", "self-absorbed", "contest", "observation", "handful", "subdued", "norman", "relegated", "demonstrated", "muted", "impress", "wells", "ryder", "stream", "well-written", "stereotype", "handsomely", "thousand", "cartoons", "underwater", "illustrates", "sidekick", "sutherland", "echoes", "nobody", "round", "garbage", "reflects", "stevens", "defense", "riding", "principals", "gerard", "nancy", "intrigue", "dynamics", "selena", "infectious", "damon", "ace", "ado", "resorting", "zero", "plastic", "simultaneously", "pity", "visible", "ego", "countless", "el", "suffered", "hackneyed", "wesley", "serving", "presidents", "unfair", "flourishes", "rapidly", "weddings", "submarine", "anastasia", "banter", "bucks", "richness", "classical", "amateurish", "mediocrity", "conveys", "investigation", "brosnan", "north", "charged", "greek", "polish", "legal", "empathize", "valuable", "morgan", "sketch", "radiant", "raises", "reminding", "laurence", "countryside", "blast", "dimension", "giggles", "enormous", "ethics", "macabre", "aids", "jumping", "whale", "swear", "enduring", "campbell", "accuracy", "destiny", "devito", "compliment", "attract", "lifetime", "sleazy", "topic", "mystical", "desert", "bruckheimer", "picking", "airplane", "rear", "legendary", "seeking", "currently", "edgy", "importantly", "dizzying", "glance", "readily", "underdeveloped", "babe", "faint", "everyones", "stayed", "rolls", "shortcomings", "fantastic", "popcorn", "evoke", "co-star", "combine", "cheated", "montage", "engaged", "tarantinos", "indication", "provoke", "express", "reliable", "pierre", "aaron", "moviegoers", "breasts", "invigorating", "wenders", "naive", "bulk", "acceptance", "sublime", "kelly", "suicide", "spielbergs", "cautionary", "aladdin", "immensely", "expense", "hints", "suggesting", "dislike", "viewpoint", "disappoint", "chew", "virgin", "languid", "criminals", "pleasantly", "monkeys", "experimental", "unclear", "nod", "preferred", "pie", "nuclear", "endeavor", "referred", "altmans", "baldwin", "vampires", "vulnerability", "minimum", "multiplex", "dreamworks", "species", "troubling", "applaud", "tightly", "brave", "benigni", "covering", "attracted", "nifty", "moreau", "directions", "dicaprio", "openly", "authenticity", "square", "michele", "louis", "garner", "nonetheless", "prisoner", "onscreen", "fortune", "fascinated", "intellect", "argued", "wondered", "primal", "married", "visit", "marty", "reed", "circus", "sufficient", "creature", "bonnie", "sit-com", "redeeming", "kurt", "rational", "crossing", "rookie", "neighborhood", "static", "barbara", "malcolm", "student", "chord", "olivier", "lake", "nicole", "repressed", "isolation", "westerns", "sheridan", "clumsy", "matches", "weaknesses", "disease", "volcano", "the=20", "scientific", "sake", "boogie", "glimpses", "click", "genres", "burn", "farm", "gloomy", "twins", "scares", "uncertainty", "femme", "incomplete", "river", "alienation", "enchanting", "kitano", "postman", "nutty", "noble", "dramatics", "glaring", "grating", "worried", "bacon", "deniro", "embarrassment", "guard", "mile", "meg", "mtv", "literal", "concentration", "resolve", "lyrical", "rendering", "1930s", "temptation", "tape", "pretend", "mistaken", "perceived", "despair", "exact", "notre", "complained", "simpler", "trivial", "horribly", "intrusive", "daylight", "observe", "horses", "diane", "toro", "dana", "breakdown", "judd", "tree", "grosse", "rapport", "fundamentally", "compelled", "evokes", "richards", "trend", "raised", "distinction", "possessed", "distinctive", "dies", "cronenberg", "april", "failings", "paintings", "split", "survival", "gabriel", "doubtfire", "smell", "respond", "curtis", "akin", "peppered", "seamlessly", "symbolic", "uncle", "rapid", "guffman", "stare", "rays", "remaining", "girlfriend", "steps", "screenwriting", "producing", "dinosaur", "weather", "abound", "columbia", "matilda", "yarn", "20th", "longing", "varying", "drifts", "snake", "concepts", "shaking", "answered", "greatness", "complains", "characterized", "intention", "loneliness", "engages", "superbly", "interrupted", "phony", "establish", "transitions", "highlighted", "characteristics", "shall", "refers", "carrying", "optimistic", "sharon", "assault", "slip", "leaden", "solo", "thematically", "locations", "periods", "ivan", "label", "figured", "cell", "folk", "controversy", "prologue", "respected", "icy", "alice", "led", "mob", "fifty", "box-office", "cook", "pen", "spring", "sadness", "frozen", "jews", "performing", "satisfaction", "bridge", "thornton", "wag", "deliberate", "surrender", "gain", "wow", "notch", "civilization", "dreyfuss", "oppressive", "warren", "exceptions", "bates", "manipulated", "introducing", "dash", "tribute", "dazzle", "keitel", "glen", "flubber", "underwritten", "shifting", "bogus", "doomed", "died", "pivotal", "merits", "hackman", "dollar", "betty", "bravado", "nose", "flashy", "blink", "half-dozen", "routines", "offerings", "address", "tommy", "bodily", "greenaway", "interior", "prince", "halfway", "meanders", "ripley", "distinguished", "realizing", "choreography", "versus", "wealth", "showgirls", "knife", "illness", "instant", "inclined", "raging", "stirring", "conscience", "sketchy", "philippe", "showdown", "norton", "dubbed", "forgot", "evita", "weaves", "lane", "demanding", "roman", "promises", "complaint", "climate", "receive", "sisters", "lest", "monologue", "france", "honey", "downey", "choosing", "drivel", "jean-pierre", "struck", "collective", "london", "sent", "troubles", "highest", "shed", "luis", "sappy", "newspaper", "matthau", "mimic", "sketches", "moronic", "clueless", "b&w", "raymond", "depression", "awe", "exhausted", "bye", "a=20", "sections", "dig", "29", "activity", "headed", "screwball", "quaid", "amateur", "perspectives", "analyze", "unsympathetic", "england", "petersen", "warn", "operation", "channel", "sparse", "psychology", "criticized", "redundant", "los", "jaws", "seduction", "desperation", "neighbors", "monkey", "personae", "encounters", "balls", "threat", "examines", "filling", "behind-the-scenes", "intelligently", "worn", "involvement", "1996s", "web", "exotic", "enemy", "denzel", "dawn", "billing", "disastrous", "trait", "approached", "predict", "taught", "perverse", "odyssey", "trevor", "retread", "apply", "lying", "mouths", "grab", "canvas", "collins", "morose", "invested", "kama", "1991", "remained", "mafia", "wally", "stylized", "missteps", "slow-motion", "linger", "practically", "vital", "glued", "error", "objects", "culkin", "affable", "parallels", "seamless", "dantes", "agnes", "sophomoric", "fantasies", "staple", "meets", "incomprehensible", "romy", "destruction", "streep", "cries", "casablanca", "station", "activities", "awfully", "blonde", "rudy", "confrontation", "surrounded", "clark", "european", "wasting", "courtney", "kathy", "profane", "exit", "bowl", "marked", "misplaced", "brando", "developments", "introspective", "conveying", "restaurant", "nelson", "martha", "unqualified", "healthy", "tolerable", "graham", "loudly", "risky", "sony", "balanced", "intrigued", "successes", "rival", "reminder", "trains", "irene", "emmerich", "mail", "18", "57", "laced", "shoes", "structured", "sights", "jb", "broderick", "client", "envelope", "exhibits", "jam", "youthful", "burden", "jabs", "connecting", "terminal", "sin", "delve", "medical", "well-paced", "couples", "detract", "gang", "shower", "tied", "mute", "alluring", "divided", "targets", "gems", "prominent", "damned", "framing", "emphasizes", "betrayal", "well-known", "theirs", "financial", "incoherent", "depicting", "impressions", "dismiss", "clothing", "unsatisfying", "partial", "gods", "spectacularly", "approaching", "illusion", "differently", "rooting", "contrasts", "aptly", "assuming", "examine", "homosexuality", "smoothly", "fields", "sporadic", "quiz", "habit", "chaotic", "racist", "attains", "confuse", "delicately", "wraps", "almodovar", "timeless", "mountains", "continuing", "flirting", "chills", "concluding", "trimmed", "aging", "lions", "reunion", "anchor", "accurately", "wishes", "cheer", "roland", "riot", "readers", "texture", "faced", "pains", "roof", "psyche", "palma", "kitchen", "enjoys", "rolled", "linklater", "incarnation", "proving", "vain", "accepted", "concentrate", "nichols", "beaten", "franco", "honor", "thompson", "measures", "prize", "previews", "cloying", "explosive", "sorvino", "marlon", "copycat", "lola", "tastes", "escapist", "chicken", "comedian", "emerges", "unintentional", "depicts", "ephron", "daily", "complement", "fuzzy", "kieslowskis", "relentless", "bud", "reward", "cox", "progressively", "labor", "fools", "exposure", "00", "16", "28", "31", "stab", "42", "clouds", "sending", "sung", "denying", "fog", "melancholy", "contained", "preaching", "plausibility", "grumpy", "translate", "excited", "vertigo", "b-film", "dazed", "las", "realization", "foster", "seductive", "code", "vanessa", "tall", "establishes", "passable", "sgt", "clarity", "val", "flanders", "tide", "bridget", "gaudy", "consequence", "desired", "parallel", "offended", "buying", "grill", "zwick", "teaches", "dahl", "whites", "spare", "responses", "hereafter", "sentiment", "and/or", "sirens", "companion", "describing", "trials", "debate", "dimensional", "indiana", "december", "colored", "benny", "guts", "scent", "eventual", "hand-held", "conceit", "threatens", "outer", "weekend", "ambition", "introduce", "experiment", "demanded", "cemetery", "jealousy", "giddy", "comics", "relating", "bible", "haunted", "hats", "consciousness", "blockbusters", "limit", "inject", "subjected", "statements", "official", "sarandon", "steam", "mario", "awareness", "portrays", "hide", "aura", "raunchy", "complain", "python", "displaying", "urgency", "vacuous", "kasdan", "craig", "disgust", "conservative", "casts", "birds", "population", "talked", "chill", "hitchcocks", "shadowy", "magazine", "bernstein", "problematic", "portray", "unforced", "self-indulgent", "roller", "forgiven", "rangers", "full-length", "harrys", "relations", "cleverness", "rooms", "african", "nerves", "breakfast", "saccharine", "jean-claude", "griffith", "lynchs", "shining", "follow-up", "brainless", "ricci", "payne", "comprehend", "boss", "flintstones", "clooney", "saga", "aficionados", "authority", "fragmented", "throwaway", "stellar", "buff", "buzz", "koepp", "rosewood", "pokes", "assumes", "leader", "glover", "wives", "museum", "vitality", "shocks", "dustin", "exposed", "idiotic", "en", "tempted", "pope", "twentieth", "othello", "explode", "overwhelm", "civil", "prospect", "learns", "par", "virtual", "pacinos", "droll", "sliding", "fright", "picked", "separate", "rod", "buffs", "1994s", "1995s", "warned", "demented", "wrap", "cassavetes", "combining", "siege", "kansas", "dopey", "commandments", "masterfully", "groove", "rivals", "election", "cohesive", "testament", "punishment", "catching", "conveyed", "intentional", "afterthought", "trash", "spawn", "ladies", "overkill", "passage", "creations", "savage", "worship", "blacks", "spitfire", "outtakes", "dracula", "acid", "yellow", "leighs", "heading", "beliefs", "chorus", "noticeable", "parade", "grishams", "interact", "muriels", "australia", "underused", "big-screen", "georges", "detriment", "frighten", "namely", "105", "ranks", "hans", "matrix", "40s", ">from", "rage", "unappealing", "testimony", "sweetly", "accomplishes", "accident", "phantom", "smarter", "curiously", "yours", "concentrates", "lauren", "exterior", "miserables", "letters", "capacity", "pocahontas", "wounds", "columbus", "holy", "defies", "nightmares", "declares", "ellen", "sensual", "melvin", "runner", "earnestness", "bent", "ruby", "gender", "chapter", "formed", "three-dimensional", "practice", "lethal", "lens", "brutality", "oscars", "hokum", "unrealistic", "frames", "videos", "dresses", "crumb", "concubine", "rescue", "keanu", "vice", "wide-eyed", "robinson", "icon", "tortured", "tendencies", "transpires", "resist", "outrage", "castle", "farewell", "placement", "distorted", "varied", "economic", "feat", "undemanding", "marginal", "kramer", "lightning", "zany", "devotion", "outsiders", "assured", "sole", "unimaginative", "savvy", "puzzle", "quirks", "catharsis", "sutra", "palatable", "zellweger", "kline", "phillip", "werewolf", "nazis", "foul", "refuse", "banderas", "valid", "semblance", "goodman", "pool", "confines", "luc", "butterfly", "friday", "jake", "resembling", "puns", "dreadfully", "pam", "pot", "borrowers", "meanings", "sling", "discovered", "catastrophes", "cure", "cuss", "videotape", "represented", "symbols", "dismal", "empathy", "leaps", "precision", "barbs", "rotten", "polite", "deficiencies", "overwhelming", "floating", "half-hearted", "satisfactory", "unsure", "writes", "desires", "unintentionally", "distinguish", "pullman", "attended", "definitive", "ongoing", "overdone", "shiloh", "alaska", "junk", "tremendously", "overlooked", "broadcast", "cuteness", "hundreds", "operas", "walker", "thief", "marketed", "helena", "perfunctory", "dirt", "losers", "ounce", "teams", "attached", "striving", "sex-related", "spinning", "reduce", "stiller", "nora", "boris", "conclusions", "depardieu", "composition", "hazy", "heavenly", "insanity", "off-beat", "arty", "profanities", "doctors", "mummy", "depalma", "sleepy", "richer", "bearable", "eraser", "crass", "didactic", "autobiographical", "sylvester", "polanski", "indicates", "strains", "birth", "zhang", "chamber", "wizard", "angie", "stumbles", "trigger", "resulted", "steady", "b-movie", "realistically", "repetition", "laid", "oddball", "relish", "improve", "stunningly", "expertly", "apartment", "unreal", "holly", "tombstone", "pause", "beatty", "neeson", "everybody", "messy", "beavis", "downer", "crush", "lovingly", "gwyneth", "provoking", "franchise", "props", "shaft", "pretends", "treasure", "plans", "select", "cliffhanger", "radically", "skillfully", "depressed", "clues", "shrill", "jo", "jingle", "subsequent", "crucible", "representative", "garofalo", "minnesota", "cornucopia", "uncompromising", "stopped", "ticket", "forty-five", "slow-moving", "overtones", "nyc", "lambs", "wine", "vengeance", "swedish", "virtues", "taxi", "regard", "row", "winona", "scottish", "cooper", "thread", "scored", "surviving", "restored", "kaufman", "ruined", "alvin", "gaps", "revolutionary", "patton", "loach", "join", "morals", "applies", "tammy", "complaining", "electronic", "nazi", "translation", "dickens", "article", "garcia", "topics", "arquette", "expert", "terminally", "partner", "chillingly", "contempt", "flowing", "coping", "thousands", "canyon", "1998", "1999", "racing", "mickey", "glasses", "magoo", "ethnic", "kirk", "pelican", "irreverent", "nuts", "stake", "block", "obsessed", "childs", "sounded", "dwell", "marie", "harrelson", "atom", "destroy", "discussions", "texas", "wished", "crawl", "partly", "centerpiece", "anticipation", "hopper", "facile", "pages", "chips", "unabashedly", "affairs", "die-hard", "stripped", "perpetually", "futile", "strip", "blends", "neurotic", "timid", "by-the-numbers", "abysmal", "orders", "arrive", "hogan", "addiction", "panther", "amused", "levy", "chuck", "butler", "month", "pointing", "roughly", "franks", "vein", "eves", "fargo", "sparkles", "existential", "heavens", "demons", "singers", "bursting", "fears", "button", "complexities", "baggage", "hicks", "turbulence", "shape", "hideous", "faye", "workers", "kissed", "repeat", "davies", "immediacy", "wanders", "fanciful", "scorseses", "affleck", "aptitude", "concludes", "smug", "pesci", "vulgar", "embarrassingly", "actively", "span", "ang", "artsy", "quirkiness", "vague", "recipe", "mann", "48", "stir", "marginally", "showy", "amistad", "et", "se", "vu", "wade", "wang", "completed", "enthusiastic", "kinetic", "publicity", "laconic", "denise", "vanya", "sinking", "lay", "crowd-pleaser", "irons", "creator", "coat", "oil", "pig", "sardonic", "tail", "tank", "milieu", "mold", "imposing", "meticulously", "madonna", "guide", "propaganda", "alter", "wore", "notions", "relates", "chunks", "ladybird", "farley", "scotts", "gates", "heterosexual", "splash", "substitute", "exchange", "touchstone", "lobby", "herman", "universally", "hippie", "bernard", "slickers", "elegant", "venice", "disguise", "retrospect", "tactics", "innocuous", "austen", "avoided", "barren", "gimmicky", "parties", "foreboding", "growth", "flowers", "helpful", "pointe", "strained", "collaboration", "apocalypse", "stretched", "anybody", "singleton", "excruciatingly", "lopez", "manipulate", "nina", "goods", "intensely", "oldman", "distract", "incest", "confesses", "unwilling", "19th", "walks", "deceptively", "fierce", "linear", "battlefield", "exploits", "pyrotechnics", "swing", "antz", "orson", "off-the-wall", "garnered", "burning", "intact", "horrifying", "comparing", "rejected", "frighteningly", "diminish", "washingtons", "linda", "discussing", "rappaport", "household", "reviewing", "weary", "smartly", "mason", "profoundly", "practical", "ease", "capra", "seniors", "billed", "sticking", "chess", "anaconda", "coincidences", "fisher", "refer", "rocks", "kingpin", "leonardo", "strays", "hurts", "circles", "face/off", "stated", "streak", "inhabitants", "reflection", "reflective", "weaver", "shelton", "cocky", "quietly", "misguided", "lays", "coens", "organization", "predecessors", "arrived", "arrives", "indicate", "lean", "targeted", "cohen", "deftly", "judith", "angela", "opts", "matched", "wicked", "tomorrow", "updated", "beaver", "middle-aged", "admirable", "drives", "ill-advised", "handheld", "lord", "fried", "sooner", "paranoia", "impeccable", "shawn", "sterling", "pack", "exhibiting", "miles", "emily", "scientists", "counts", "charlotte", "rashomon", "boundaries", "wolves", "zemeckis", "suggestion", "inspires", "baffling", "carnage", "principles", "shout", "persons", "waking", "happily", "ha", "defining", "contrasting", "commanding", "solutions", "ham", "chef", "deliberately", "mexican", "nikita", "drowning", "telegraphed", "standpoint", "sparkling", "beside", "mentally", "cope", "humorless", "shoots", "wilderness", "travis", "constraints", "nerve", "saddled", "wolf", "aspirations", "millers", "underneath", "tidy", "fleshed", "staccato", "atypical", "implications", "ww11", "radiates", "survivors", "animators", "goodfellas", "immortal", "attained", "russia", "profit", "exploding", "trekkies", "spade", "trade", "traps", "peaceful", "effortlessly", "deja", "demi", "desk", "one-note", "monologues", "broke", "ferrara", "interchangeable", "enter", "screams", "examining", "dominique", "blake", "penetrating", "paragraph", "first-rate", "geoffrey", "solondz", "$100", "earns", "triumphant", "distractions", "phones", "fragile", "hypnotic", "planned", "beating", "figuring", "ventures", "unremarkable", "macdowell", "ramis", "balloon", "danish", "stillman", "harm", "slater", "mastery", "unimportant", "tomei", "stagy", "boxer", "inexplicably", "manny", "mean-spirited", "splendor", "knack", "army", "identification", "objective", "theatrics", "cruelty", "wastes", "obviousness", "responds", "rene", "artistry", "lowest", "bulworth", "overt", "earl", "alternately", "enterprise", "murphys", "rita", "ventura", "allegory", "heston", "hoop", "placid", "ballroom", "interludes", "gravity", "bass", "voight", "hugo", "warrant", "dedication", "ancient", "employed", "high-concept", "tapestry", "zeffirelli", "lend", "erin", "patch", "biblical", "operate", "lift", "peaks", "lily", "irving", "squad", "carpenters", "unfocused", "suburban", "exquisite", "bogs", "elevate", "exuberance", "pitched", "affirming", "shocked", "quotes", "farcical", "areas", "braveheart", "anders", "nails", "focal", "shop", "strokes", "lucy", "luke", "infuriating", "designated", "amoral", "clown", "accused", "resort", "shell", "storylines", "gangsters", "throwback", "perez", "bertolucci", "adapting", "rocket", "arrow", "petty", "cash", "consequently", "edition", "34th", "additional", "closet", "pile", "crafts", "cousin", "exhausting", "cathartic", "cundieff", "scientist", "honors", "80", "brutally", "eve", "dread", "attain", "musketeers", "occurred", "prejudice", "flies", "gut", "hal", "observing", "lapses", "hurricane", "drift", "annoyed", "kudrow", "advanced", "advances", "silverstone", "fury", "luhrmann", "basquiat", "sadistic", "cole", "narrow", "nolte", "patterns", "jerk", "discussed", "strikingly", "mona", "elsewhere", "victory", "oneal", "counting", "muppet", "finney", "atrocious", "examined", "starred", "tunnel", "referring", "1993s", "stereotyped", "ganz", "inoffensive", "ronald", "warped", "frequency", "insane", "factory", "countrys", "definition", "francisco", "gusto", "wolfgang", "torn", "hooked", "detractors", "brightly", "dave", "hilariously", "cerebral", "july", "glue", "dollhouse", "verve", "demy", "exhibited", "golf", "swimming", "immature", "priceless", "marquee", "nell", "festivals", "economy", "dragging", "indians", "forgets", "construction", "burtons", "downhill", "scandal", "crowds", "fingers", "combat", "pretending", "close-up", "flashing", "paxton", "threw", "insipid", "favors", "ballet", "drab", "heroism", "blessed", "cabin", "exploitative", "overused", "emotive", "height", "locals", "dust", "110", "crosses", "elicit", "males", "machinations", "masters", "mentality", "canonical", "stamp", "tyler", "heck", "perpetual", "buscemi", "mulan", "frankie", "retorts", "mississippi", "laurie", "lowell", "jeanne", "crave", "oconnor", "likewise", "re-release", "tormented", "michaels", "blandness", "robot", "quibble", "picasso", "pleasantville", "sensational", "broadly", "thewlis", "heche", "chaplin", "childish", "schlock", "unprintable", "childlike", "hinted", "spontaneous", "high-energy", "corrupt", "passions", "fatale", "breadth", "tearjerker", "downfall", "woodys", "incorrect", "bounds", "fernando", "recurring", "outfit", "ranging", "deconstructing", "kaplan", "imaginable", "mocking", "liam", "decides", "gesture", "steeped", "velvet", "ineffective", "poetical", "palookaville", "ingredient", "owes", "labute", "authors", "ransom", "veterans", "teaching", "abruptly", "stitches", "audacity", "graces", "prefontaine", "clock", "schrader", "fireworks", "panache", "perry", "enthralling", "buddies", "iran", "sons", "array", "duchovny", "outright", "kundun", "explanations", "disclosure", "communication", "alain", "dares", "melanie", "jefferson", "26", "52", "60", "inventiveness", "framework", "medicine", "shore", "gooding", "emphasizing", "schmaltz", "di", "ma", "st", "fords", "gus", "ward", "subversive", "casually", "whoopi", "spectrum", "pose", "brandon", "donner", "thereof", "defines", "warfare", "darkened", "frothy", "multiplicity", "sinbad", "vapid", "disturbed", "flock", "remote", "supported", "quips", "unfolding", "literate", "hunting", "tear-jerker", "spurts", "gallo", "greedy", "greens", "warhol", "listed", "martins", "shyamalan", "angeles", "rodriguez", "julianne", "sir", "liberties", "awkwardness", "til", "tvs", "demme", "tacky", "enlightening", "cuba", "lasts", "virtue", "uncover", "dense", "preparation", "drunk", "garry", "textbook", "tighter", "brash", "costners", "contrary", "loyalty", "bards", "derek", "dylan", "besson", "cities", "joey", "brett", "joys", "lectures", "publics", "toilet", "eastwoods", "toss", "monotonous", "coaster", "airheads", "lolita", "eminently", "wasteland", "glib", "middle-class", "denouement", "reluctant", "rebellious", "tease", "overcomes", "assets", "perceptions", "races", "opposed", "uncontrollable", "tickets", "dragonheart", "obtuse", "guffaws", "camelot", "off-screen", "doom", "aged", "glamorous", "raimi", "thirteen", "assembled", "eleven", "faraway", "shortly", "thumb", "meyers", "locale", "vistas", "duty", "made-for-tv", "115", "vince", "hack", "automobiles", "landmark", "gifts", "confidential", "spunk", "laudable", "warns", "gallery", "unsuccessful", "reviewers", "beethoven", "two-dimensional", "scrooge", "persuasion", "floats", "somebody", "session", "superhero", "hiding", "lester", "6th", "demolition", "shtick", "rural", "mannered", "awry", "armstrong", "lists", "dangers", "goldfinger", "russo", "grandiose", "parking", "maturity", "ireland", "sleepers", "sacrifice", "stood", "fades", "disappear", "disappointingly", "umbrellas", "roos", "crichton", "heels", "curse", "knock", "daughters", "plague", "eclipse", "relic", "elephant", "acknowledge", "two-thirds", "border", "transforms", "groundhog", "manners", "bounce", "annie", "knight", "studies", "societal", "working-class", "awesome", "consummate", "jerome", "lagravenese", "sources", "leon", "demographics", "bird", "outdoor", "caroline", "altogether", "rosie", "punctuated", "eroticism", "wider", "pearl", "nobodys", "small-town", "heros", "lemmons", "route", "suggested", "shoot-outs", "pumping", "sara", "buddha", "fishburne", "arena", "gillian", "crashes", "schedule", "respectable", "addams", "insecure", "seek", "easiest", "superman", "freddy", "capital", "lightly", "programs", "penny", "geared", "connects", "reliance", "self-parody", "amalgamation", "squirming", "savor", "explicitly", "owner", "ads", "cradle", "ali", "dominates", "everett", "calm", "momentary", "mirth", "geronimo", "closes", "speechless", "decalogue", "implausibilities", "command", "dud", "soldier", "32", "dates", "to=20", "sums", "ex", "lo", "freddie", "velocity", "lyrics", "shred", "bullwinkle", "poke", "dubbing", "noticed", "failures", "efficient", "percent", "lucid", "sells", "bedroom", "retain", "lap", "clay", "equate", "deneuve", "mick", "mira", "slate", "newell", "eclectic", "villainous", "ashley", "ned", "manufactured", "disconcerting", "pilot", "muster", "one-joke", "pad", "horizon", "jedi", "rea", "sentiments", "baker", "hearty", "instincts", "run-of-the-mill", "balto", "no-nonsense", "unpredictability", "tess", "ups", "grass", "achieves", "acquired", "centered", "competently", "witherspoon", "muse", "swings", "wholesome", "sporting", "complaints", "gear", "frustrated", "bread", "upper", "borrowed", "stallones", "throat", "repression", "morbid", "diary", "toes", "fuller", "spooky", "buffalo", "damn", "lofty", "checking", "vomit", "miranda", "regret", "crimson", "sinks", "insider", "minghella", "experiencing", "perplexing", "antonio", "shirts", "bullet", "flamboyant", "executives", "vintage", "neon", "theron", "rowlands", "eliminated", "triad", "paycheck", "apted", "hudson", "ponderous", "inspirational", "bogged", "anniversary", "raising", "ostensibly", "rachel", "1967", "1987", "everyman", "dancer", "applause", "spoil", "escapes", "poster", "unaffected", "departure", "dragged", "peculiar", "environmental", "someones", "loyal", "counterparts", "technological", "alec", "abbotts", "102", "seasons", "kingsley", "halt", "hank", "crocodile", "ants", "butt-head", "crafting", "pauses", "on-target", "horseman", "communist", "recognizing", "subtitled", "unnatural", "mandel", "hypocritical", "reds", "parkers", "wisely", "time-to-time", "screenplay/director", "bilko", "tibet", "ponette", "facets", "weaker", "separation", "crack", "sabrina", "jesse", "evans", "cheat", "popping", "ingenious", "quintessential", "wyatt", "decoration", "reese", "barcelona", "facing", "abandon", "hawke", "hoot", "guillermo", "depend", "prisoners", "sibling", "stowe", "shadowlands", "robs", "shouting", "interpersonal", "harlin", "mcmullen", "coach", "reitman", "timothy", "hung", "pushed", "mulholland", "guidance", "unoriginal", "noonan", "heist", "bickering", "bennett", "russ", "crown", "runaway", "vary", "pulse", "endured", "overwhelmed", "resistance", "imperfect", "chicago", "randall", "roberto", "dangerfield", "breakthrough", "oral", "warrior", "puppy", "unbearably", "relatives", "kathleen", "readings", "hoped", "pressure", "oleanna", "pursuit", "boyz", "ocean", "suave", "accidentally", "owen", "politicians", "bros", "stoned", "styles", "prone", "refusal", "prose", "goldman", "lethargic", "swingers", "bulletproof", "europe", "oeuvre", "hoffmans", "prefers", "sparring", "lust", "tacked", "soaring", "unanswered", "spader", "hopeful", "flame", "commitment", "africa", "stanton", "headlines", "travesty", "prominently", "posey", "plummer", "traits", "doc", "verisimilitude", "37", "overacted", "ignoring", "superstar", "hudsucker", "definite", "un", "contender", "academic", "hav", "gattaca", "dealt", "mens", "cliffs", "lounge", "murderer", "inconsistent", "useless", "ghastly", "grunge", "camerons", "confined", "leo", "lip", "optimism", "mimi", "mgm", "mud", "construct", "isabelle", "indictment", "solve", "punk", "eternity", "lange", "pit", "mastered", "obstacles", "designs", "gut-wrenching", "interplay", "porter", "out-of-place", "moderate", "hollands", "absorbed", "grabs", "cube", "browns", "banks", "jill", "schmaltzy", "wed", "winterbottom", "arbitrary", "picturesque", "story-telling", "fincher", "forbidden", "jacks", "retains", "scathing", "jose", "destination", "disparate", "applied", "outings", "art-house", "isaac", "helicopter", "charmer", "overpowering", "tops", "resolutions", "aykroyd", "bayou", "spalding", "deciding", "anyones", "sings", "schnabel", "establishment", "afterall", "careers", "palminteri", "prevalent", "bronx", "cursory", "deborah", "madeleine", "eye-catching", "mattered", "carroll", "loner", "in-your-face", "paucity", "unspectacular", "afternoon", "helping", "addressed", "addresses", "sixty", "survived", "1977", "1980", "1989", "metaphorical", "challenged", "liberally", "interminable", "separates", "proceeds", "bryan", "nixon", "helmed", "reporter", "incisive", "applauding", "criticize", "bordering", "sherman", "dedicated", "delighted", "gotta", "thurman", "terrain", "questioning", "transcends", "meticulous", "bliss", "emoting", "verhoeven", "off-putting", "mirrors", "attributed", "agents", "croupier", "unbelievably", "drawn-out", "cringe", "madcap", "ruins", "proverbial", "ashamed", "nickolas", "squarely", "natasha", "increasing", "palette", "rank", "rave", "downbeat", "filler", "weave", "alicia", "resourceful", "sword", "obscurity", "industrial", "schools", "astronauts", "tackles", "awkwardly", "hemingway", "carvey", "rapture", "portrayals", "ubiquitous", "conscious", "filthy", "infinity", "cream", "amanda", "fictionalized", "overflowing", "presidential", "kinnear", "broader", "odds", "arrogant", "matinee", "gambling", "counted", "playfulness", "coherence", "ignores", "civilized", "populate", "gilliams", "bath", "inventing", "bitterness", "rooted", "unlikable", "pratfalls", "kennedy", "calculated", "backgrounds", "alison", "iranian", "sophistication", "envy", "stereotypical", "appalling", "generously", "pollack", "drinks", "volume", "molly", "midler", "disagree", "eras", "erik", "well-made", "day-lewis", "theories", "twelfth", "opus", "shockingly", "homes", "indicative", "lowbrow", "announces", "woven", "metro", "gaping", "opting", "affects", "illogical", "suburbia", "useful", "miami", "motto", "winners", "plotted", "thompsons", "jacksons", "cruises", "dominate", "sane", "load", "andrews", "california", "watson", "backbone", "records", "switchback", "addicted", "rushmore", "self", "skits", "striptease", "orange", "shaky", "wander", "prepare", "rip-off", "windows", "nonstop", "caustic", "unnerving", "sharply", "uttering", "passed", "arguing", "davids", "clone", "strident", "attacking", "motions", "kruger", "dalai", "_not_", "dead-on", "felix", "progress", "padding", "boiling", "shirt", "wounded", "lassie", "rarity", "blending", "bay", "breathing", "killings", "exorcist", "liberty", "plethora", "rampant", "dreadful", "renaissance", "38", "43", "51", "contribute", "picks", "shirley", "sentences", "sunk", "fertile", "schwartz", "fore", "mm", "miracles", "proposition", "flirt", "bouncing", "hannibal", "representation", "mercury", "serenity", "worries", "brenda", "deception", "poet", "broadbent", "import", "therein", "exploit", "connerys", "unusually", "eszterhas", "glowing", "farther", "hunters", "kubricks", "map", "grateful", "mod", "newest", "offspring", "remove", "disposal", "heartbreaking", "pump", "overrated", "scattered", "rogers", "pretensions", "astounding", "rip", "meditation", "informs", "accounts", "dazzles", "spotlight", "tag", "turbulent", "crowd-pleasing", "babaloo", "julian", "invest", "extraneous", "1997s", "adrian", "buttons", "dolls", "wet", "fischer", "groundbreaking", "gays", "bargain", "incarnations", "till", "sprinkled", "screenings", "fires", "clinton", "senator", "reportedly", "whimsy", "lurid", "f-word", "centers", "extensive", "macaulay", "joes", "jolt", "colossal", "leaders", "remembering", "reflected", "thunderball", "littered", "advocate", "goals", "cooking", "tons", "stimulating", "heroin", "dougs", "rivette", "brisk", "exuberant", "levant", "credulity", "butch", "redgrave", "zealand", "katherine", "simpson", "unsuccessfully", "marianne", "ohara", "rodney", "landis", "verge", "dern", "principle", "scratch", "wandering", "gossip", "gosh", "endurance", "entering", "tuned", "bitingly", "voiceovers", "spaghetti", "disappoints", "wallop", "embraced", "surrounds", "grip", "pregnant", "citizens", "stargate", "tossed", "deemed", "13th", "director/writer", "pensive", "premises", "idiots", "rewarded", "gonna", "toast", "fodder", "bombs", "justin", "proclivity", "two-hour", "anticipated", "nods", "socially", "bette", "blurred", "noon", "spencer", "priscilla", "clashes", "planning", "enraptured", "weapons", "wanda", "summary", "heights", "auteur", "microcosmos", "expose", "khan", "matching", "duds", "underground", "sydney", "madame", "amuse", "crossed", "employs", "oranges", "liable", "karaoke", "drunken", "zbigniew", "apes", "devlin", "phenomenal", "dragons", "margaret", "errol", "icons", "supply", "interpretations", "releasing", "aimlessly", "scratching", "urge", "benign", "tiring", "operatic", "strategy", "well-rounded", "chest", "hard-boiled", "carlo", "towns", "impending", "kidnapping", "longest", "counterpoint", "soporific", "acerbic", "stares", "penchant", "kafka", "stoic", "robocop", "benoit", "salvation", "individually", "refreshingly", "moralizing", "morally", "sugary", "muriel", "panic", "empowerment", "owners", "spawned", "shattered", "rhyme", "maurice", "conceived", "shootouts", "vaudeville", "mikhalkov", "instrument", "clockwork", "mitchell", "prevent", "resonant", "shadyac", "planes", "potter", "connections", "thankless", "janeane", "akira", "genial", "ratings", "revel", "depths", "goldeneye", "blur", "saturated", "drifting", "threesome", "francois", "generating", "sebastian", "predicament", "hopelessness", "marisa", "frighteners", "streisand", "bont", "workings", "returning", "nuance", "mount", "astute", "photo", "teachers", "casper", "lock", "banquet", "lurking", "translated", "gilliam", "slightest", "gigantic", "enormously", "dissolves", "hypocrisy", "void", "gently", "dehumanizing", "winds", "dafoe", "multi-layered", "cherbourg", "discomfort", "shue", "hilary", "freely", "narratives", "lure", "insubstantial", "poking", "despicable", "ducks", "scheme", "liotta", "conundrum", "slam", "alcoholism", "lynn", "ethical", "fondness", "capras", "brazil", "collaborator", "severe", "kicked", "b/w", "variable", "anguish", "categories", "baz", "textured", "malice", "bon", "irresistible", "recapture", "gather", "convictions", "classroom", "preachers", "dim", "mall", "21", "olivia", "r-rated", "eds", "goodnight", "research", "b-", "diabolical", "memorial", "ok", "gap", "mythology", "toback", "printed", "apollo", "jeopardy", "abundance", "conversion", "sensible", "editors", "tourist", "vance", "winger", "similarity", "enthralled", "camouflage", "pertinent", "suzanne", "pattern", "fuss", "sensation", "pauline", "tidbits", "grease", "alcohol", "concentrating", "nelly", "nightmarish", "retelling", "attribute", "praying", "ode", "lazenby", "monica", "rebellion", "sleek", "kills", "abstract", "foreground", "reserve", "fearless", "all-in-all", "moll", "cruz", "fingerprints", "heartwarming", "devilish", "diabolique", "irwin", "via", "passages", "sexes", "yearning", "forcing", "guarding", "lingers", "weaving", "edits", "basil", "heather", "scrutiny", "frisky", "cheese", "floundering", "bawdy", "nigel", "fixed", "burnt", "integral", "sarcasm", "data", "attenborough", "necessity", "eager", "juan", "wealthy", "kiarostami", "squeeze", "trace", "cannon", "outfits", "dating", "commented", "assumption", "jackies", "tentative", "theyd", "navy", "tibetan", "subpar", "christine", "distinctly", "chewing", "jamon", "gimmicks", "slogans", "lampoon", "dundee", "juice", "direct-to-video", "comedians", "neal", "waller", "license", "equality", "tasteless", "overtly", "friendships", "considers", "stand-up", "handed", "transcend", "filtered", "dissatisfying", "hard-hitting", "cherot", "oscar-winning", "transform", "worrying", "idiocy", "volumes", "madison", "specialty", "darkest", "sarcastic", "non-existent", "celebrate", "convenient", "karl", "gratingly", "mutual", "arnaud", "extravaganza", "bleeding", "hitler", "consumption", "befuddled", "x-files", "secondly", "and=20", "invests", "paulie", "rental", "keys", "natalie", "mercifully", "donovan", "beginnings", "multitude", "existed", "hannah", "dude", "training", "feminist", "remainder", "stable", "so-so", "truck", "powder", "blessing", "hardships", "resemble", "settle", "phillips", "swirl", "rapid-fire", "camaraderie", "willie", "vicariously", "artistically", "nonexistent", "haley", "continuity", "screw", "barrage", "celebrated", "sleaze", "succeeding", "vanishes", "labutes", "magnitude", "containing", "camps", "reno", "gettysburg", "screwed", "italy", "sucked", "believably", "untouchables", "jackal", "documentarians", "collapse", "graduate", "rebel", "parenthood", "uncommon", "ripped", "packs", "psychotic", "rice", "roads", "contributes", "hunts", "immense", "robby", "jacobs", "cultures", "andie", "rhames", "compensate", "strain", "enemies", "tiger", "brendan", "schwarzeneggers", "oblivious", "playboy", "nation", "bought", "regarded", "angus", "lebowski", "probing", "rosy", "serviceable", "best-known", "fish-out-of-water", "bars", "replacements", "cinemas", "charlton", "steamy", "reflecting", "pants", "committee", "lama", "underscore", "lars", "tenderness", "savoring", "peripheral", "invasion", "jekyll", "ambiance", "well-executed", "promised", "thespian", "illustrated", "robbery", "landscapes", "cravens", "alcoholic", "gorilla", "serene", "crushed", "eighty", "fanny", "henri", "rhapsody", "vehicles", "moods", "threatened", "wound", "clause", "franz", "jersey", "whales", "supercop", "assignment", "paradiso", "education", "uneasy", "habits", "colin", "idiot", "admirably", "smillas", "fooled", "turmoil", "pedro", "flimsy", "idle", "sermon", "fashioning", "meyer", "snowy", "masquerading", "marilyn", "minutia", "bergmans", "gladiator", "introspection", "conrad", "carrington", "derived", "fade", "kurosawas", "co-wrote", "second-rate", "momentarily", "wherever", "sits", "subtleties", "steiger", "cloth", "ineffectual", "undercurrent", "ridley", "marital", "pans", "penned", "singular", "musings", "zorro", "marvel", "binoche", "normalcy", "recycling", "slim", "symphony", "seasoned", "moonlight", "soulful", "sold", "sour", "orchestra", "cary", "sunset", "encourages", "technicolor", "sanity", "cue", "computers", "crashing", "auteuil", "05", "14", "profession", "stan", "49", "55", "66", "97", "maxs", "mccoy", "rubies", "pretentiousness", "fix", "therapy", "wholly", "iq", "adultery", "li", "pi", "synthetic", "exotica", "frivolous", "theremin", "mourner", "interiors", "citys", "cousins", "babys", "spared", "excised", "february", "jet", "corpse", "doubts", "self-", "compromised", "finely", "dutch", "overbearing", "liv", "lou", "x-men", "slack", "muscles", "abortion", "symbol", "emotionless", "aided", "innumerable", "copious", "futility", "pan", "pbs", "villainy", "unwillingness", "commodity", "permit", "stakeout", "lugubrious", "titillate", "continually", "snapper", "hardest", "rec", "undermines", "outdated", "archer", "shorts", "shorty", "commended", "files", "opposites", "suspending", "tip", "donofrio", "sidney", "slips", "movie-making", "divorce", "cues", "platonic", "coyote", "cheerful", "footing", "warmly", "archival", "menken", "obtain", "flynn", "kitsch", "donna", "access", "zucker", "bubble", "approximately", "penetrate", "malevolent", "infamous", "mini-series", "niche", "playwright", "atmospherics", "sickening", "observed", "observer", "witnessed", "diamond", "character-driven", "hard-to-swallow", "identical", "evolves", "oblivion", "hillbillies", "barney", "rumble", "descent", "holden", "high-tech", "heightened", "viewings", "tracy", "underdog", "goers", "valerie", "photographs", "matchmaker", "squeamish", "fitzgerald", "monsieur", "christina", "climbing", "jamie", "begun", "corners", "carlitos", "posing", "drawings", "juicy", "sarajevo", "mononoke", "fleshing", "distasteful", "praised", "diet", "unflinching", "raucous", "leopard", "dire", "petulant", "proudly", "generational", "languages", "jumps", "wartime", "mawkish", "cinequest", "amiable", "mesmerized", "tastefully", "all-time", "nominee", "sheriff", "1961", "1984", "revisionist", "dora", "dour", "dove", "lengths", "canadian", "faintest", "berry", "screened", "kicking", "highlighting", "african-american", "ballad", "stevenson", "mysticism", "graphics", "encourage", "reflections", "guests", "sweat", "proyas", "swept", "purple", "duck", "duel", "nonsensical", "liners", "hamilton", "splendidly", "maclaine", "digest", "125", "verite", "187", "haas", "hyperactive", "egoyans", "staples", "posturing", "modicum", "attorney", "30s", "tepid", "understatement", "stabs", "stacy", "inexplicable", "ormond", "whiff", "adversaries", "perkins", "respective", "cruella", "obsessive", "unwanted", "marco", "injects", "motivated", "supper", "trappings", "jean-louis", "masks", "comically", "reads", "hardy", "putative", "infectiously", "delves", "east", "counterpart", "adolescence", "good-looking", "cheek", "gallows", "items", "eden", "high-spirited", "miserably", "futuristic", "edtv", "autumn", "fishin", "action-packed", "joses", "fidelity", "nightclub", "weiss", "dolores", "zaillian", "pitfalls", "faded", "surgery", "peters", "receiving", "avant-garde", "roan", "visionary", "statue", "destructive", "mismatched", "arrest", "pales", "dressing", "invention", "prevents", "falters", "campions", "sorely", "phase", "vanity", "adopt", "lang", "browning", "reinforces", "glimmer", "gentler", "olds", "revels", "youngster", "studied", "harrowing", "ranges", "audio", "fiorentino", "leni", "pascal", "hearted", "isabel", "titus", "shawshank", "convention", "agonizing", "inert", "commonplace", "tearful", "minnie", "measured", "snatchers", "jaglom", "extremes", "haynes", "stature", "titillation", "joyous", "ours", "rides", "freak", "abandoned", "stolen", "misunderstood", "cleese", "leisurely", "sharing", "letdown", "selfish", "mankind", "full-frontal", "cliff", "whispers", "escapism", "pinkett", "reckless", "poets", "melville", "sales", "frears", "spirituality", "associate", "proxy", "dimensions", "proportions", "seth", "exudes", "pillow", "inadequate", "boyish", "keith", "materials", "insignificant", "platt", "lightness", "pastel", "polar", "proceed", "cynthia", "rudolph", "noises", "espionage", "actioner", "thirteenth", "sometime", "ugliness", "adversity", "well-intentioned", "winking", "county", "awakening", "ships", "exploiting", "budding", "puppets", "conveniently", "seams", "disregard", "spoiler", "ape", "ark", "incompetent", "poses", "bug", "flag", "austens", "tactic", "connelly", "batting", "macy", "degradation", "duo", "03", "super-hero", "27", "41", "54", "56", "75", "maze", "criticisms", "character-based", "du", "epoque", "hc", "inspector", "landing", "foxs", "gel", "suggestions", "goo", "trickery", "revolves", "placing", "disposable", "kicks", "employing", "timely", "studying", "hartley", "eduardo", "nominees", "ira", "post", "corpses", "donnie", "painter", "drill", "sufficiently", "dillon", "kay", "identities", "headache", "oversaturated", "preceded", "presumably", "clip", "commits", "bullocks", "mia", "health", "monumental", "nat", "nba", "noisy", "mallrats", "mohicans", "elevated", "sepia", "sophie", "trauma", "wink", "widows", "participation", "aloof", "elaine", "aloud", "drops", "tribulations", "psychic", "engrossed", "ref", "writer-director", "stagnant", "restless", "fluid", "accomplishments", "guido", "delpy", "shameless", "sprawling", "slimy", "nefarious", "violently", "lumet", "misleading", "judging", "ashes", "hit-and-miss", "ramifications", "1992s", "troche", "true-to-life", "designers", "tornadoes", "scoring", "veers", "gasp", "gate", "accomplishment", "armageddon", "spanking", "detachment", "masses", "intangible", "stretching", "giggle", "yep", "bleakness", "breakneck", "fired", "flesh-and-blood", "dissolve", "purposely", "rupert", "imitating", "hawthorne", "slows", "jaded", "christ", "leder", "veneer", "elected", "joon", "joss", "voyeuristic", "sprung", "overacts", "jacquot", "availability", "rafael", "glengarry", "beats", "settled", "stillmans", "charmed", "tool", "clumsily", "permanent", "engagement", "becker", "kidman", "distracted", "gypsies", "hungry", "trail", "jakob", "enliven", "jordans", "newsreel", "unquestionably", "englishman", "females", "versa", "crooks", "interestingly", "gong", "boyfriend", "janet", "pondering", "antonia", "self-aware", "reverence", "opposing", "masturbation", "colonel", "reducing", "reader", "mounting", "shootout", "outbreak", "entrance", "capitalism", "levity", "gruff", "traditions", "balderdash", "equipment", "favorably", "abby", "joness", "spins", "foibles", "trips", "graceful", "frenetic", "1600", "tootsie", "flames", "thanksgiving", "violins", "fabric", "spouting", "patricia", "survivor", "1940", "prevailing", "1954", "1976", "1988", "beethovens", "peacemaker", "insecurity", "holland", "toughness", "skillful", "rejects", "shattering", "sanitized", "unbreakable", "boisterous", "unforgiven", "aspiring", "jodie", "pompous", "ever-present", "ineptitude", "disdain", "bravery", "magnificently", "bloodshed", "raoul", "cocaine", "victoria", "birdcage", "rendezvous", "respectful", "commit", "gasping", "locales", "hanson", "critically", "g-rated", "build-up", "gardner", "limey", "linked", "temptress", "majesty", "giles", "claustrophobia", "crowded", "payback", "reid", "adapt", "reservations", "concentrated", "chazz", "rewrite", "durham", "jerky", "earp", "destroyed", "aesthetic", "axel", "operates", "stance", "rusty", "bening", "roach", "incessantly", "sellers", "cogent", "summed", "exercises", "holm", "enters", "gunfire", "jewison", "improvised", "jacqueline", "hurry", "rightfully", "queens", "someday", "endearment", "kurosawa", "a-list", "depressingly", "decency", "photographic", "brooklyn", "elfman", "stooges", "bang", "bank", "bard", "quantity", "returned", "wardrobe", "howitt", "yeah", "elisabeth", "envision", "articulate", "stating", "allusions", "oblique", "paper-thin", "strict", "peebles", "backed", "tougher", "lara", "robots", "fairytale", "recognizes", "sneer", "mockery", "legacy", "one-", "miguel", "marcia", "russells", "whitaker", "cowboys", "gleefully", "feature-length", "contributions", "akiva", "elvis", "slower", "preview", "vera", "refrain", "peach", "muppets", "conflicted", "margot", "riddled", "organized", "iain", "syrupy", "moron", "morse", "primo", "candidates", "robotic", "borg", "vile", "indoor", "comparable", "isaiah", "eyre", "graphically", "horns", "sant", "stoltz", "inish", "scattershot", "leuchter", "ridiculousness", "transpired", "diatribe", "confession", "clocks", "essayed", "berlin", "viable", "yves", "adventurous", "midway", "ethereal", "catalyst", "proft", "skies", "seal", "exhibit", "paranoid", "imbues", "burt", "interests", "entirety", "cadence", "stores", "mckellen", "kisses", "preferable", "skilled", "terrence", "replace", "victorian", "assumed", "cloud", "opponents", "grimness", "breast", "griffin", "cutesy", "slap", "slew", "hardened", "kenny", "backstage", "humble", "slipping", "handicapped", "pryce", "shiny", "flags", "butcher", "exchanges", "dante", "sore", "preston", "unimpressive", "walters", "concoction", "dalton", "flip", "mitch", "loathing", "puppies", "athlete", "sober", "dor", "louise", "17", "39", "92", "leguizamo", "provokes", "delicacy", "undeveloped", "mileage", "maiden", "yu", "ideals", "sub-text", "plods", "swim", "hiver", "chad", "stinker", "huh", "chow", "faceless", "ilm", "unhurried", "rabbit", "promote", "luther", "diluted", "denied", "eye-opening", "realizes", "wrapping", "webb", "backward", "treating", "maddening", "signed", "lab", "caraboo", "equals", "leg", "spread", "disgusted", "lesbians", "sends", "undercover", "employ", "cigarette", "repulsive", "flora", "flows", "pleaser", "sophomore", "girlfriends", "coal", "anachronistic", "newspapers", "pun", "drown", "greene", "rat", "aspires", "re-", "gandhi", "martian", "unsuspecting", "shores", "overcoming", "addressing", "valour", "coverage", "metaphysical", "nastiness", "sub", "trusted", "much-needed", "sparkle", "resorts", "grape", "overact", "forcefully", "emptiness", "chapters", "ingenuity", "dullness", "wickedly", "voice-overs", "depps", "metaphors", "tapping", "cheering", "snakes", "claiming", "poorer", "entered", "padded", "quarters", "uttered", "dearth", "verdict", "apocalyptic", "detailing", "ninety-minute", "celine", "contribution", "matter-of-fact", "kinder", "bunny", "spewing", "whereby", "psychologically", "observes", "inserts", "insufferable", "uninspiring", "rosenthal", "noyce", "beart", "temperament", "aniston", "patriotism", "veritable", "gina", "vivian", "biographical", "rebecca", "demonstrating", "frankenheimer", "metropolitan", "tapes", "requiring", "phrases", "nair", "appetite", "pinnacle", "buildup", "nary", "cronos", "grinding", "needful", "matured", "thrust", "tasty", "nihilistic", "succinct", "unexplored", "romanticized", "spouse", "lasseter", "reacts", "ballard", "japan", "neck", "grinning", "aggressive", "nerd", "chronicle", "kidmans", "troupe", "birthday", "supplies", "dish", "guinevere", "tosses", "lipstick", "ismail", "resurrection", "recommended", "teddy", "contenders", "furlong", "winslet", "fleming", "heart-warming", "cummings", "formula-driven", "1957", "harriet", "madly", "fully-realized", "commonly", "grinds", "kristin", "evolution", "ample", "morton", "spoon", "homosexuals", "mimics", "rehash", "oxygen", "imitate", "terminator", "sweep", "relevance", "disorder", "claimed", "attributes", "giuseppe", "solidly", "lineup", "bowling", "traveling", "byrne", "globe", "118", "furious", "consisting", "rewards", "imagined", "stumbling", "officers", "anticlimactic", "patrice", "science-fiction", "kaufmans", "traveller", "thinner", "blows", "halle", "assure", "repugnant", "bumbling", "comedy-drama", "terse", "catches", "safely", "psychedelic", "prints", "facade", "crises", "beaumarchais", "inappropriately", "stems", "filters", "unapologetic", "unstable", "classes", "union", "tossing", "locked", "blunt", "bille", "terrifying", "day-to-day", "obliged", "intends", "contributed", "meaty", "sexist", "palace", "conspicuous", "agony", "maxim", "transparent", "comprised", "sigourney", "fishes", "dreyer", "uncredited", "cates", "regal", "modestly", "nathan", "homophobic", "indicated", "philosopher", "wretched", "portman", "terence", "grown-ups", "chick", "populating", "alexandre", "facet", "rossellini", "voiced", "craftsmanship", "incredulous", "satirizing", "distributors", "self-conscious", "well-", "products", "invited", "selection", "wendy", "guitar", "cecil", "communicate", "spouses", "relax", "avengers", "feared", "destroys", "laugher", "hyams", "gunplay", "hostile", "overload", "ruthless", "politician", "behave", "differing", "exceeds", "beer", "elicits", "cleaver", "belt", "ruin", "visualizations", "gained", "coeur", "sleuth", "blackboard", "bronson", "judged", "consistency", "parks", "specialist", "mostow", "midwinters", "impressively", "concerning", "leto", "bias", "uniform", "amongst", "absorb", "sympathies", "tangents", "jarmusch", "ritchie", "tv-movie", "correctness", "karma", "clunky", "registers", "sherlock", "accompanying", "indicating", "bereft", "re-released", "laundry", "rhodes", "age-old", "enamored", "preparing", "repeats", "crawling", "hooks", "basinger", "sonnenfeld", "bourgeois", "otto", "conan", "bobs", "subconscious", "functional", "commenting", "weighty", "osment", "strung", "sand", "thierry", "ferris", "bearing", "low-brow", "rigid", "english-language", "duigan", "_is_", "spellbinding", "idealized", "wagner", "igor", "merchandising", "daddy", "pollock", "sub-par", "thieves", "skips", "countries", "conclude", "altered", "perversions", "imbued", "bust", "butt", "vote", "mildred", "gathering", "brasco", "emerged", "confronted", "singles", "animatronic", "boldly", "raining", "lighten", "wannabe", "radioland", "repartee", "leaping", "sheep", "swinging", "tackle", "mcgregor", "mills", "millennium", "tenuous", "apology", "well-constructed", "fairies", "superficially", "cop-out", "plotline", "reasoning", "emerging", "transfer", "quotient", "stylistically", "zane", "irreverence", "patches", "goodbye", "remade", "bubbling", "pete", "teases", "abbie", "hoskins", "emilio", "bandit", "aid", "unzipped", "mired", "dominated", "managing", "blatantly", "arm", "ass", "bow", "longtime", "prowess", "unsatisfied", "fled", "laurent", "far-fetched", "grueling", "mcconaughey", "unreliable", "anxiety", "skewering", "34", "53", "mcquarrie", "70", "advises", "believer", "ulrich", "suck", "segal", "foil", "weirdness", "cd", "fu", "ju", "zing", "goldsman", "lu", "eye-popping", "viscerally", "inexperienced", "character-building", "solved", "goldsmith", "earthy", "comeuppance", "pacific", "understandably", "shrug", "sofia", "bothers", "approval", "mesh", "wheres", "repertoire", "appeals", "restroom", "sullivan", "attend", "neill", "sitcoms", "precedes", "energized", "numbing", "prom", "prop", "reject", "fighter", "milo", "drawback", "benevolent", "slang", "jarmuschs", "alley", "apostle", "flood", "hampered", "pather", "aidan", "mcdonalds", "burger", "assistant", "cobb", "followup", "sandlot", "colm", "admitted", "pic", "pod", "pre", "kelley", "soccer", "toddler", "clinic", "treads", "courageous", "melodramas", "accorded", "unabashed", "unrelated", "drivers", "aggravating", "kinky", "thunder", "yorker", "sinise", "nerds", "fashions", "autopilot", "ignorance", "bands", "debatable", "uncomfortably", "regularly", "wong", "shallowness", "benicio", "commands", "autobiography", "worldly", "discernible", "impressionable", "wim", "beautician", "high-profile", "prawer", "voyeurism", "patric", "depravity", "tracking", "farmer", "telephone", "afloat", "chopped", "injustice", "commitments", "roommates", "pixar", "regime", "lurie", "yakin", "mulcahy", "jacob", "darabont", "nicks", "geek", "loquacious", "guards", "nauseam", "factors", "gears", "enhances", "alternate", "hideaway", "wonderland", "bombastic", "tigger", "emphasized", "neighbor", "theatrically", "sociopath", "jafar", "commercially", "platoon", "grind", "grips", "tights", "theoretically", "beard", "settles", "kindergarten", "deservedly", "herzfeld", "pathetically", "harassment", "toll", "toms", "toni", "sociological", "underage", "despise", "propensity", "exits", "factual", "egypt", "trim", "ennio", "kaminski", "fountain", "spans", "lovitz", "compromise", "inimitable", "relishes", "monument", "debt", "duplicate", "duncan", "salesman", "distressingly", "occupies", "ghetto", "johnston", "mccarthy", "yearn", "hoblit", "chabert", "needing", "marquis", "embraces", "anatomy", "patriotic", "majestic", "accuse", "plagued", "outrageousness", "bowfinger", "loopy", "doyles", "machines", "abel", "blanc", "copies", "youngest", "triers", "stumble", "inaccurate", "sultry", "linklaters", "pornographic", "gonzo", "smash", "masterminds", "afford", "dastardly", "extraordinarily", "advise", "abused", "gerry", "luxury", "poison", "italians", "aboard", "cromwell", "1964", "1970", "1985", "judicious", "frederic", "bonus", "acres", "tolerant", "devised", "karaszewski", "co-written", "juror", "denominator", "lousy", "attracts", "lieutenant", "amply", "hitchcockian", "surroundings", "gypsy", "abroad", "notting", "ill-conceived", "feebles", "beatles", "blanks", "dual", "shopping", "dusk", "back-story", "upcoming", "remakes", "glacial", "135", "surfaces", "entrapment", "tenth", "smallest", "timecop", "truce", "hart", "indelible", "scenarios", "regretfully", "unfulfilled", "affliction", "sneaking", "artifice", "skeleton", "unattractive", "softley", "freeway", "dripping", "giggling", "halls", "wreck", "thinly", "utilized", "palmetto", "helm", "bonham", "disturb", "mugging", "prinze", "screenplays", "ramsey", "carrie", "catastrophe", "accountant", "big-name", "captivate", "harbor", "entendres", "sleeve", "blurry", "replacement", "benjamin", "tornado", "senior", "jacket", "8mm", "charlies", "implication", "jittery", "absurdist", "pressures", "jerzy", "eats", "eternal", "whore", "self-awareness", "kull", "defeat", "ceremony", "historically", "hostage", "whisperer", "gross-out", "tables", "labeled", "cathy", "admiration", "needle", "jewel", "dangling", "jhabvala", "athletes", "clashing", "athletic", "interspersed", "assorted", "stared", "allure", "wilsons", "egos", "possessing", "yawn", "deakins", "awhile", "devolves", "andersons", "outbursts", "welsh", "incongruous", "savored", "invites", "oozes", "paymer", "increase", "ellis", "chloe", "upfront", "harmed", "stray", "excruciating", "mindset", "mangold", "coast", "reacting", "renee", "vanish", "renny", "chore", "clancy", "incorporating", "errors", "genocide", "powerfully", "stigmata", "overseas", "brassed", "fishing", "fosters", "seagals", "wearying", "workmanlike", "rosemary", "condor", "audrey", "negotiator", "utters", "degenerates", "realities", "plants", "amazed", "marvins", "holidays", "expletives", "paths", "monks", "philosophizing", "hytner", "uproarious", "glances", "slides", "panchali", "reluctance", "clinical", "soderberghs", "pupil", "continued", "african-americans", "blah", "culmination", "satisfies", "penelope", "lili", "solondzs", "abrasive", "manager", "action/adventure", "virtuoso", "threaten", "revolting", "effortless", "likability", "vibe", "motel", "ving", "motif", "confront", "customers", "legion", "millions", "ridicules", "worn-out", "swinton", "tackling", "karloff", "brow", "hospital", "summarized", "intervals", "epics", "russians", "sterns", "prostitute", "puppet", "improvisational", "churning", "refused", "joining", "conduct", "pornography", "homeless", "goldblum", "apathy", "shade", "profile", "shane", "shark", "satirize", "sands", "shaped", "emmanuelle", "pretense", "scarcely", "exploited", "gerald", "goodwill", "unapologetically", "plate", "award-winning", "responsive", "daytime", "thirty-two", "rugrats", "reduces", "lifestyles", "armed", "heroines", "unreasonable", "luckily", "schneider", "versatile", "faithfulness", "3000", "quills", "moonraker", "disappears", "allison", "duets", "alarming", "edginess", "sunny", "occurring", "joined", "peril", "ready-made", "flipper", "patently", "vader", "clubs", "terrorists", "spoiled", "fruit", "breathless", "spit", "infused", "mary-louise", "caan", "transcendent", "ala", "cafe", "apu", "in-between", "lasted", "moretti", "tantalizing", "pounds", "originals", "autopsy", "investment", "flew", "cid", "assumptions", "soars", "weightless", "attendant", "#1", "#2", "darth", "23", "24", "shoddy", "toronto", "maps", "mst3k", "grants", "88", "janusz", "98", "99", "nurse", "reindeer", "acclaim", "stud", "mcdermott", "censors", "reverential", "charitably", "fbi", "afforded", "fed", "plea", "jeffreys", "dunst", "iv", "schtick", "juxtaposition", "ratchets", "tornatore", "federal", "awe-inspiring", "satyajit", "chin", "sofie", "disguised", "warrants", "hug", "bernadette", "beguiling", "consisted", "performs", "brimming", "disasters", "octopussy", "sphere", "jew", "theresa", "overplotted", "wisecracking", "pray", "moneys", "liz", "persistent", "modine", "mar", "slave", "trashy", "skeletons", "floyd", "blunder", "almod", "soulless", "whit", "1920s", "elevates", "winterbottoms", "nagging", "controlling", "residents", "governments", "drained", "tart", "ground-breaking", "bernardo", "gadget", "passably", "dumped", "gangs", "speeds", "psychopath", "aphrodite", "snl", "severely", "dazzled", "dealer", "taboo", "outshines", "ton", "sparked", "irvin", "tech", "rainmaker", "uma", "bangs", "borrowing", "lampooning", "woos", "asian", "drums", "fiona", "dismissed", "franklin", "lugosi", "disconnected", "magnified", "upheaval", "multi-dimensional", "doubtless", "dexter", "policy", "miscalculation", "threats", "innovation", "rooftop", "region", "melvilles", "preference", "topless", "nicky", "excerpts", "antagonist", "contributing", "cheating", "whisper", "alternatives", "generals", "kindly", "massimo", "brent", "excursion", "premiere", "cheers", "uncovered", "baffled", "celebrities", "dissonant", "methodical", "42nd", "checked", "ladder", "incendiary", "deleted", "venue", "venus", "antoine", "heyday", "half-baked", "midpoint", "railing", "riff-raff", "glee", "elusive", "alabama", "compositions", "dutton", "diminished", "nail", "protracted", "stepping", "doyle", "paperback", "deaf", "defy", "invariably", "lemon", "asides", "agreed", "suspicious", "punching", "expand", "bernies", "sweetest", "outsider", "flemings", "brody", "kassovitz", "electrifying", "barton", "ordinarily", "cutthroat", "serrault", "nest", "grey", "grit", "genie", "dime", "traditionally", "grossed", "debbie", "grossly", "lucinda", "jared", "niros", "willard", "slavery", "fluffy", "craziness", "clayton", "lynne", "bruno", "inserted", "boyfriends", "noticing", "fortress", "lending", "levin", "speakers", "transport", "whoever", "inexcusable", "1960", "1963", "1979", "noticeably", "1990", "atrocities", "tolerate", "swagger", "mandarin", "florence", "wilder", "clients", "elderly", "abraham", "rohmers", "reported", "mortal", "spoke", "rails", "procedure", "mifune", "credentials", "envisioned", "kathryn", "incorporates", "distress", "eschews", "imbue", "wellville", "incidental", "berlinger", "mcdowell", "pessimistic", "siblings", "irrespective", "self-consciously", "skinny", "vittorio", "melissa", "gowns", "ally", "parisian", "light-years", "vacuum", "arrogance", "aisles", "108", "bouts", "foxfire", "unsurprisingly", "quotable", "impulses", "triple", "gloom", "wheel", "proportion", "unsentimental", "hawk", "hawn", "cages", "carlos", "infatuated", "skeptical", "curtain", "faculty", "candles", "unrequited", "ernie", "cuban", "1st", "dizzy", "galaxy", "setups", "patriot", "anchors", "boxes", "damaging", "fitfully", "arrested", "toned", "obscene", "tabloid", "naming", "unexplained", "dissatisfaction", "blissfully", "hammy", "anti-hero", "tests", "injured", "additionally", "lingo", "photograph", "caleb", "chinas", "trivia", "williamss", "franken", "untamed", "absurdly", "reviewer", "qualify", "raves", "origins", "revival", "stylishly", "internet", "long-time", "commander", "selenas", "bills", "assassination", "maude", "pablo", "silvers", "fought", "machina", "skewers", "gallagher", "beatrice", "imply", "binds", "schroeder", "kung", "meals", "rife", "naturalistic", "promisingly", "reeds", "spitting", "unaware", "time-honored", "reeks", "anticipating", "liven", "wistful", "muses", "strand", "omnipresent", "spontaneity", "carefree", "anonymous", "jeunet", "cluttered", "irritated", "glorified", "tangent", "finishes", "husbands", "stopping", "whining", "hard-pressed", "over-wrought", "roar", "sterile", "mumford", "rogue", "melancholic", "schlesinger", "pruning", "davidovich", "redeemed", "bait", "bald", "bale", "bart", "hocus", "tilly", "strut", "yell", "soothing", "bishop", "precocious", "flounders", "airport", "unemployment", "duality", "chops", "stride", "lark", "peeling", "lawn", "laws", "self-righteous", "apologies", "begs", "bell", "apologize", "scripting", "primitive", "ronin", "omen", "someplace", "relied", "renders", "prosaic", "courting", "revelatory", "8-year-old", "precursor", "circuit", "resonate", "decline", "nighttime", "backbeat", "sacred", "underlines", "swashbuckling", "underrated", "tended", "angelo", "montana", "stroke", "revive", "insomnia", "restricted", "purists", "meryl", "homer", "claus", "earnestly", "exquisitely", "herek", "evaluate", "darryl", "waitress", "krueger", "remorse", "demmes", "mahler", "progression", "surpasses", "batmans", "marion", "consternation", "titillating", "bohringer", "tomatoes", "slingshot", "firestorm", "papaya", "mulder", "saul", "skewered", "runnings", "sucks", "pocus", "mistakenly", "multiplexes", "impromptu", "officially", "turnaround", "adulthood", "mommas", "tangible", "rounded", "unravel", "detracts", "searches", "ambivalent", "dominating", "stomachs", "costs", "inordinate", "goulds", "louisiana", "trajectory", "narrated", "bury", "hostages", "arnolds", "devastation", "kirsten", "tripplehorn", "marred", "wachowski", "insulted", "sickeningly", "hodges", "zooms", "sharper", "seberg", "tapped", "lull", "freeze", "opted", "site", "artfully", "poker", "penns", "zeffirellis", "sheds", "ulees", "shelf", "daisy", "underwear", "monarchy", "finchers", "disservice", "gloria", "cornball", "armor", "spades", "_that_", "feed", "mctiernan", "motifs", "traces", "minus", "concluded", "pandering", "sketched", "rubber", "replete", "pamela", "kolya", "twohy", "university", "privileged", "identifying", "richardsons", "irma", "masterpieces", "harmony", "pressed", "overplayed", "accidents", "drive-in", "captions", "shrink", "dream-like", "dissimilar", "listened", "transferred", "cape", "bbc", "zeal", "rivalry", "laments", "complemented", "successor", "ceases", "jerusalem", "differentiate", "contrasted", "closed", "distances", "champagne", "re-create", "hired", "overriding", "02", "06", "22", "exposes", "46", "advised", "mara", "96", "math", "cannibalism", "catchy", "pearce", "musker", "offense", "excepting", "keener", "entertains", "surf", "dunne", "ho", "fry", "lt", "ignite", "fulfillment", "apropos", "foray", "stardom", "gil", "serials", "crudup", "fever", "wash", "materialism", "peterson", "versatility", "loathe", "smokes", "satires", "deceptive", "temporarily", "negro", "angrier", "sydow", "jab", "jfk", "lelouch", "unseen", "germany", "tickle", "claiborne", "signal", "journalistic", "expressing", "skarsgard", "hauntingly", "controllers", "lam", "protest", "fuel", "jessie", "lib", "graves", "preceding", "respectively", "shrunk", "overweight", "mist", "fiery", "gibsons", "spelling", "sommers", "periodic", "courtship", "jail", "depraved", "berkeley", "herrings", "quilt", "grabbing", "cardinal", "epithets", "tourists", "launched", "overwhelms", "emanating", "coda", "leather", "elevator", "soliloquies", "iceberg", "preferring", "groupies", "momentous", "langs", "feisty", "officer", "unmoved", "frustrations", "sundays", "existing", "whodunnit", "cram", "awarding", "rut", "angelas", "seymour", "fueled", "baumbach", "dishes", "astonishingly", "birnbaum", "brackett", "sid", "archie", "sue", "samourai", "improbably", "impactful", "division", "hammer", "pulsates", "tax", "aplomb", "stabbed", "barbet", "demon", "monotone", "responded", "foolishness", "undergone", "boston", "lunacy", "lasse", "whirlwind", "latch", "dalloway", "latin", "var", "outlook", "adrift", "crouching", "seminal", "dispassionate", "roller-coaster", "zaniness", "summation", "cricket", "diatribes", "misunderstanding", "freshman", "representing", "miscasting", "comeback", "eastern", "xiu", "kiddie", "senseless", "vividly", "seventeen", "charges", "mush", "horner", "gregg", "renewed", "telegraphs", "humiliation", "comatose", "excel", "zip", "layer", "fabulous", "incidentally", "frustratingly", "suspected", "breed", "uncovers", "recorded", "humorously", "jour", "hobbes", "fatuous", "dorff", "hating", "lamerica", "pizza", "smilla", "grier", "saintly", "november", "chronological", "distressing", "confusingly", "canine", "lefty", "drains", "beans", "insect", "strawberry", "rightly", "cookies", "redeem", "melodramatics", "privacy", "ill-fated", "thankful", "oriented", "off-color", "transported", "vacant", "topical", "judds", "column", "thelma", "trey", "downs", "troy", "mckellens", "priests", "stuffed", "reminders", "maintaining", "torment", "wavers", "deer", "|------------------------------|", "peckinpahs", "anti-climactic", "reporters", "deus", "delving", "ginger", "firing", "janes", "exclusive", "captivated", "attanasio", "creatively", "passenger", "bigotry", "outdoors", "apple", "clements", "volatile", "skewed", "bogart", "squall", "intolerance", "veracity", "thesis", "surrealistic", "responding", "golds", "playfully", "abounds", "disquieting", "gentlemen", "loony", "collision", "turbo", "tribe", "clarence", "expresses", "in=20", "dudley", "adopted", "holmes", "spine", "resident", "quibbles", "tripe", "spits", "welcomed", "sermons", "organ", "solomon", "malicks", "unorthodox", "gulf", "uptight", "narcissistic", "morons", "aparajito", "visitors", "brush", "damaged", "crowes", "siegel", "gwen", "exhilaration", "garish", "admiring", "wailing", "sleep-inducing", "eaten", "waits", "berenger", "1946", "1947", "1949", "1958", "conform", "1971", "dreamlike", "self-absorption", "mumbles", "dots", "puzzling", "passive", "threadbare", "prices", "excels", "zeta-jones", "determines", "booth", "grinch", "unmistakable", "washed", "rains", "spout", "explodes", "gramercy", "playground", "writings", "non-", "forehead", "ditzy", "norm", "chinatown", "bio-pic", "liberation", "platform", "disneyland", "fleeting", "smirking", "donaldson", "discrimination", "sedate", "sweeney", "sacrificing", "insists", "smirk", "rambo", "voyage", "duke", "dunn", "largest", "gracefully", "detours", "genuineness", "grisly", "quartet", "underway", "recreation", "characterize", "cumming", "vigilante", "130", "poorly-paced", "devine", "amys", "father/son", "tokyo", "affinity", "haze", "meander", "immigrants", "anti-war", "confronting", "whitney", "aborted", "moniker", "mysteriously", "schemes", "blasts", "joint", "neglected", "indecipherable", "launch", "finneys", "gun-toting", "heal", "heap", "seventh", "samantha", "buster", "hugos", "unresolved", "upstaged", "rumor", "tonight", "royale", "jenny", "links", "bachelor", "pepper", "undergoing", "hallmark", "orphans", "frankel", "desirable", "alices", "inducing", "marin", "messenger", "elijah", "fundamentalist", "chang", "bogosian", "shaquille", "wring", "in-jokes", "sandwich", "barrels", "organs", "ebert", "disarming", "techine", "glamour", "expository", "stuffy", "brigitte", "practices", "sillier", "engender", "insiders", "accompanies", "hardys", "niccol", "riefenstahl", "cringing", "hates", "unfairly", "billys", "humming", "homely", "channing", "caron", "succession", "strangelove", "filter", "edit", "aplenty", "crescendo", "nicest", "defeated", "comprises", "toxic", "ringing", "streamlined", "josie", "laughless", "sensory", "underline", "trimming", "weitz", "camille", "hows", "suicidal", "iconoclastic", "ryans", "dwight", "articles", "crews", "terrorist", "kyle", "oedekerk", "winters", "well-suited", "carville", "dining", "yard", "oneself", "counter", "critique", "stole", "pistols", "greenberg", "haskell", "bitch", "concession", "roeg", "vukovar", "refusing", "larger-than-life", "shoot-out", "obrien", "exaggeration", "depict", "admits", "anita", "evils", "clearer", "put-downs", "elmer", "illustrating", "marlene", "slacker", "liaisons", "lehmann", "idiosyncratic", "property", "laying", "eschewing", "interviewed", "lukewarm", "ordeal", "panda", "rushing", "choir", "overlapping", "elfont", "mcdonald", "afterlife", "tinge", "darius", "lags", "diaries", "benton", "lecter", "tangled", "boundless", "screamers", "miners", "bend", "proposal", "anthem", "answering", "forman", "toe-to-toe", "sneak", "cycle", "cyclo", "stylist", "fingernails", "characterizes", "franciss", "receives", "anecdotes", "insistence", "lena", "bradys", "bacons", "heckerling", "notorious", "advertisement", "fangs", "rests", "oops", "adjectives", "monet", "titan", "sobering", "instruments", "patients", "auditions", "mercy", "fathom", "parenting", "paula", "pauly", "houseguest", "havana", "alligator", "near-perfect", "anton", "symbolically", "announced", "perplexed", "blew", "honed", "opponent", "wishmaster", "intersection", "valentine", "aronofsky", "forgetting", "dependent", "iconic", "option", "replacing", "fickle", "superiority", "praising", "democracy", "waterworld", "familys", "sensuous", "beforehand", "hairdos", "rudolphs", "tearing", "testosterone", "one-sided", "sams", "obstacle", "tragically", "prosecutor", "impostors", "judicial", "unhook", "royal", "shakes", "eloquent", "milestone", "butter", "cigarettes", "censorship", "monstrous", "edwards", "borrow", "fries", "journal", "first-class", "pronounced", "newcomers", "elitist", "skins", "sunshine", "stellan", "atkinson", "clapping", "announcement", "reversal", "u-turn", "decadence", "timecode", "daffy", "blackout", "tibetans", "arise", "warnings", "exposing", "micheles", "banality", "shaw", "high-", "blazing", "highs", "cinematographic", "nineteenth", "arkin", "exhale", "lithgow", "virtuosity", "reinforce", "lawyers", "illegal", "vietnamese", "schwimmer", "imax", "lumets", "seldom", "irrational", "inch", "dropping", "switching", "wheels", "marvin", "pastoral", "finesse", "tainted", "bitchy", "martians", "addict", "idealist", "gingerbread", "takeoff", "perky", "snap", "immigration", "aurora", "louder", "heartbreak", "peek", "collaborated", "broadest", "consciously", "miriam", "glossed", "danes", "sock", "viewpoints", "soda", "cracks", "oliviers", "conformity", "fist", "labyrinthine", "self-esteem", "predicable", "goldwyn", "turtletaub", "filmgoers", "caps", "woefully", "item", "porno", "communicating", "emmet", "itll", "malick", "beresford", "draco", "questioned", "surrogate", "resolutely", "frenzy", "cap", "hairdo", "pill", "coy", "familial", "vanishing", "austere", "des", "ambitions", "differs", "doa", "clyde", "soft-spoken", "scott-thomas", "04", "07", "08", "19", "goofiness", "36", "outback", "59", "pound", "zlotoff", "91", "93", "urgent", "riotous", "unconventionally", "elm", "alternates", "trueba", "descends", "thereafter", "favreau", "laden", "charitable", "real-world", "observers", "keenan", "truest", "double-entendre", "dredd", "bo", "ff", "alert", "stinks", "brancato", "plug", "circa", "sheila", "custody", "fiddle", "scholars", "cracked", "francesca", "forte", "mythical", "digress", "unconvincingly", "crackle", "fidgeting", "incessant", "miniseries", "orientation", "interfere", "sermonizing", "users", "picard", "keeper", "cher", "virgil", "chic", "fran", "frey", "collector", "dinovis", "operative", "horrocks", "plentiful", "shelly", "debra", "contestants", "hartman", "martinez", "vignette", "denial", "flashdance", "easygoing", "backs", "mcelhone", "banned", "security", "professors", "real-time", "request", "divine", "shuns", "truncated", "sensationalism", "kafkaesque", "chairs", "benefits", "prey", "intrinsic", "chelsom", "wiseguy", "mill", "good-hearted", "caution", "crisper", "uniforms", "dangerously", "stepmom", "jade", "leering", "hawthornes", "scene-stealing", "whew", "nut", "handicap", "bosnia", "occurrence", "misfires", "opt", "naturalness", "excellently", "mastroianni", "armand", "wigs", "guesses", "sabotage", "caption", "wing", "cows", "pal", "strangeness", "wits", "opaque", "accompany", "drone", "masked", "projectionist", "glitzy", "aficionado", "kellys", "tara", "10-year-old", "tate", "railroad", "poland", "qui", "psychos", "goodness", "chabrols", "crudeness", "dorado", "camcorder", "mole", "notoriously", "shoestring", "sim", "squalor", "luminous", "hearst", "annoyingly", "stu", "bosses", "creaky", "nerdy", "filth", "skyscrapers", "barbra", "luminaries", "grain", "teri", "scintilla", "nastiest", "proclaims", "deficiency", "tandem", "pouring", "corleone", "warmed", "non-linear", "state-of-the-art", "belushi", "greeted", "self-destructive", "dreaded", "garofolo", "anti-semitism", "strives", "wei", "distributed", "break-in", "sensationalistic", "lesters", "eyebrows", "gaze", "alternatively", "roxanne", "desperado", "thou", "contract", "bratt", "daylights", "ribald", "burwell", "tics", "colleagues", "spoilers", "tire", "relieved", "tito", "derby", "misstep", "chopper", "sneering", "outfield", "manipulating", "unambitious", "soundtracks", "gilmore", "zoe", "intellectuals", "gavin", "extension", "bumps", "bumpy", "cinematically", "gels", "origin", "puberty", "looney", "professionals", "twisting", "marshals", "polley", "intrusion", "advertised", "ho-hum", "hutton", "spoiling", "postcard", "horrid", "strangest", "manifesto", "maniacal", "classified", "overexposed", "tally", "diana", "manipulates", "insert", "bikini", "bassett", "geese", "overdose", "wachowskis", "capricious", "meaney", "barnes", "draining", "phoenix", "raimis", "transforming", "contemplate", "slickness", "houston", "fulfilling", "coppolas", "render", "rodman", "judes", "bresson", "spain", "canned", "coaches", "unspoken", "rivers", "elliotts", "homicidal", "expanding", "nava", "advertisements", "contemporaries", "tumbleweeds", "deck", "revered", "awash", "of=20", "salesmen", "deux", "nicholsons", "norwegian", "eccleston", "billboard", "barrys", "exemplary", "spotty", "careless", "republican", "ninas", "evoked", "ninja", "happiest", "spiced", "emergency", "okoge", "lunatic", "stubborn", "evolve", "hybrid", "adopts", "spider", "sustained", "samples", "advent", "digs", "daytrippers", "amiel", "stupids", "tingle", "predicaments", "ritchies", "bathing", "gentleman", "one-half", "kalifornia", "misfortune", "cutting-edge", "uninviting", "friedkin", "reagan", "gomez", "falsely", "fluidity", "kinski", "computerized", "topsy-turvy", "overhead", "aggressively", "enchantment", "respite", "erase", "diner", "sunlight", "customer", "christians", "agnieszka", "contents", "conflicting", "urbania", "avenue", "winslow", "compares", "aimless", "enjoyability", "incorporate", "muddle", "naivete", "synchronized", "networks", "impotent", "quixote", "centuries", "1941", "1951", "1956", "1965", "1968", "subtheme", "1972", "jeannie", "1983", "1986", "estevez", "physics", "gridlockd", "predator", "swamp", "grimly", "secretary", "tristar", "kahuna", "retreads", "tested", "wildes", "shudder", "winsome", "bankable", "happenings", "waldo", "inward", "rainy", "inanimate", "heroics", "contests", "yells", "noah", "rented", "association", "simplest", "leconte", "piercing", "rudys", "williamsons", "big-time", "giants", "blamed", "yelling", "delicatessen", "clockers", "slowness", "squabbles", "sincerely", "lifts", "out-of-towners", "/96", "mercedes", "dreyers", "alda", "sci-fier", "kika", "winston", "competitive", "geriatric", "amen", "114", "amid", "epiphany", "rants", "piesiewicz", "hale", "denizens", "viola", "warms", "numbered", "gadgetry", "carmen", "darrell", "rugged", "eerily", "cross-dressing", "schulman", "chuckling", "half-", "waited", "irritatingly", "obese", "simple-minded", "antagonists", "rickman", "raja", "joins", "annoyance", "cheerleader", "creators", "tools", "backers", "retribution", "saints", "furiously", "limbo", "integrated", "heathers", "travoltas", "microscope", "limps", "concrete", "chambers", "oomph", "gandolfini", "lined", "vanished", "insensitive", "homages", "fraction", "biopic", "moviegoer", "balancing", "keitels", "jolie", "devout", "pecker", "flexible", "atop", "alyssa", "reginald", "locker", "mentions", "estate", "worldwide", "indifference", "sucker", "petersens", "assisted", "disappointments", "venturing", "extend", "self-centered", "achieving", "charlize", "cautious", "bordello", "barriers", "woodstock", "friedberg", "diversions", "mcgrath", "flatness", "prostitution", "jenkins", "olive", "retaining", "regurgitated", "crane", "whove", "indignation", "recollections", "soft-core", "hallmarks", "riff", "rips", "defend", "frolicking", "complementary", "sexism", "grimacing", "barrier", "user", "haunt", "laziness", "plot-driven", "cowgirls", "mandatory", "trading", "ragged", "hamptons", "stewarts", "josef", "havoc", "joshs", "renting", "dunaway", "infrequent", "atomic", "strathairn", "tear-jerking", "homo", "helgeland", "occult", "birch", "inanities", "agreeable", "fenton", "elite", "hershey", "maturation", "surround", "demonic", "cover-up", "reign", "pseudo-documentary", "investing", "pairs", "deranged", "mangler", "rosenbergs", "stripper", "slumming", "supporters", "huppert", "jaw-dropping", "simpsons", "devilishly", "outlines", "descriptions", "duvalls", "heartless", "comforting", "joyce", "mandela", "neuroses", "kazaam", "individuality", "imprint", "israeli", "musketeer", "sordid", "almereyda", "generalizations", "coats", "kudos", "scarlet", "unpretentious", "snack", "streitfeld", "strick", "kidding", "substantive", "lana", "studi", "pregnancy", "engineering", "beau", "sizable", "feathers", "rude", "ruiz", "zwigoff", "cheaper", "cheapie", "germinal", "joyful", "hyde", "downside", "hallstrom", "cat-and-mouse", "robbers", "judges", "stefan", "crows", "limiting", "snow-covered", "christianity", "flower", "right-wing", "roodt", "justified", "sickness", "marcel", "nerve-wracking", "yesterday", "desolate", "bind", "debating", "addicts", "anticipate", "declan", "sliced", "retro", "beasts", "stroll", "hubris", "unrest", "emperors", "haphazard", "stability", "bluster", "rosenberg", "malkovichs", "clara", "elwes", "orgy", "automatically", "watermelon", "nuridsany", "liev", "copyright", "self-imposed", "warranted", "platitudes", "celestial", "fares", "implausibility", "reiners", "karenina", "stella", "gravesend", "irresponsible", "plunge", "cohorts", "stunned", "haircut", "boom", "self-congratulatory", "interpreted", "korean", "elmore", "skeet", "liaison", "jealous", "raiders", "salt", "sans", "crypt", "confection", "identified", "succinctly", "gloriously", "sacrilegious", "consumer", "crichtons", "auspicious", "unmitigated", "buddys", "removing", "shakur", "logo", "marathon", "slickly", "schreiber", "lore", "well-choreographed", "howling", "triumphs", "ritual", "improbabilities", "arlene", "re-creation", "cling", "poems", "uncanny", "bodyguard", "interracial", "freaks", "implied", "ozus", "servants", "dutifully", "florida", "griffiths", "competence", "positions", "ersatz", "considerations", "pogue", "providence", "intertwined", "jean-paul", "witches", "mind-boggling", "recover", "cleeses", "forgiving", "digitally", "suite", "representations", "arriving", "plant", "sins", "speculative", "speeding", "boyles", "molasses", "felicias", "penis", "dashing", "havilland", "sweeps", "snapshot", "religions", "pasted", "frosh", "frost", "compass", "frown", "pals", "mimicking", "decipher", "cigar", "experiments", "skit", "pg-rated", "samurai", "duffel", "aftermath", "under-developed", "self-importance", "hamming", "panning", "encouraging", "spelled", "ignorant", "shrewd", "whodunit", "mchales", "slot", "henchman", "chatter", "superspy", "motive", "definetly", "detour", "non-chronological", "quincy", "jumanji", "peer", "sizzle", "atlantic", "penalty", "foolishly", "yuppie", "campaigns", "vinterberg", "nunez", "natives", "affords", "francoise", "catholicism", "greenwald", "infidelity", "ave", "intrigues", "bog", "boo", "drain", "tightening", "taplitz", "flat-out", "belies", "trepidation", "unpromising", "pigs", "fleet", "flop", "cow", "inconvenient", "estranged", "darcy", "holofcener", "regurgitation", "humankind", "buddhist", "entertainments", "$7", "eyeballs", "swirling", "duh", "09", "cynically", "44", "interlude", "stew", "marx", "89", "mays", "egg", "gorris", "revolted", "savannah", "nauseating", "claudia", "clicks", "keenen", "edelman", "foe", "induced", "supercilious", "sf", "annual", "personified", "eccentricity", "eliminate", "shandling", "ghostly", "nossiter", "vladimir", "andrzej", "han", "wary", "accepts", "materialize", "luxurious", "jarringly", "placements", "educated", "marketplace", "afflicted", "rehearsals", "premium", "commendable", "dunston", "footsteps", "babes", "ink", "soggy", "pops", "jurors", "swordfish", "notices", "bitterly", "grasping", "conqueror", "imitations", "jaunty", "permeates", "endearingly", "swords", "drips", "enlightenment", "convinces", "germans", "cranks", "burgeoning", "pistol", "tamahori", "protect", "utilizing", "chains", "treatise", "microwave", "attending", "clan", "mournful", "spunky", "crammed", "abusive", "grudging", "ambient", "paulina", "toying", "anchored", "allan", "hensleigh", "recording", "hurried", "branches", "float", "mackinnon", "existenz", "jada", "leisure", "antidote", "gains", "antiseptic", "saddest", "starkly", "chronology", "pills", "uncomplicated", "mazursky", "requiem", "shyer", "pranks", "coin", "complements", "upper-class", "coke", "underplays", "lance", "cosi", "upscale", "coup", "stepped", "oscar-nominated", "pep", "greenes", "groans", "pro", "teasing", "coldly", "preteen", "tang", "serge", "ripping", "mind-numbing", "piotr", "serra", "fatalistic", "mawkishness", "minority", "embracing", "piper", "avnet", "rid", "approve", "undermined", "contradictory", "permits", "mohr", "crop", "mots", "dead-end", "angelic", "youths", "sandwiched", "best-selling", "synch", "adjective", "properties", "fluke", "delia", "oneil", "sobocinski", "flute", "kitanos", "thatll", "tia", "milked", "unmemorable", "flighty", "crawls", "lulls", "injection", "forster", "toothy", "nineteen", "undergoes", "entertainers", "serbedzija", "bombed", "refrigerator", "chased", "silhouette", "curt", "julien", "latex", "grandpa", "effeminate", "jinx", "vep", "doubles", "adrien", "endangered", "missiles", "shoulder", "snails", "unevenness", "differ", "abyss", "magnifies", "cancer", "catherines", "crooked", "souza", "creeps", "sandlers", "soften", "shield", "sided", "apathetic", "bubbly", "coincidentally", "accolades", "blandly", "necrophilia", "claudius", "invite", "rip-offs", "bully", "spells", "prayer", "fletcher", "spoils", "forthright", "converse", "converts", "sautet", "dammes", "non-professional", "survey", "klapisch", "fascists", "dispel", "treading", "germ", "eileen", "loads", "conspicuously", "effete", "bowels", "probes", "passengers", "indescribable", "favored", "miraculously", "greenaways", "synopsis", "forming", "vogue", "improves", "inflicted", "subjective", "grime", "hipness", "passionately", "clandestine", "underdogs", "infatuation", "hoppers", "aghast", "gordons", "carrere", "coburn", "remembrance", "ambivalence", "dictator", "tamer", "even-handed", "arizona", "upstage", "put-down", "hooker", "fridriksson", "riveted", "burke", "companionship", "oxymoron", "unrealized", "chopping", "snapshots", "brill", "protests", "executions", "postlethwaite", "clothed", "dale", "busey", "derive", "self-doubt", "smartest", "snorting", "slurs", "motorcycle", "yards", "packaged", "boats", "immersed", "falcon", "moreso", "hunger", "platter", "ramblings", "amber", "simms", "slice-of-life", "gratuitously", "glut", "tramp", "too-obvious", "dieyi", "trumpets", "insist", "landau", "snicker", "bombshell", "olympics", "bowman", "diminishes", "contagious", "perennou", "sidekicks", "abrams", "disappearance", "bouquet", "_about_", "garage", "painstakingly", "composers", "nondescript", "underscored", "conjures", "resolute", "surpassing", "fascist", "oldest", "full-fledged", "intricacies", "obligated", "u-571", "fantasia", "moribund", "idyllic", "fierstein", "collect", "schumachers", "frantically", "quinlan", "hossein", "viciously", "hancock", "chutzpah", "mckenna", "oppressed", "neve", "electrical", "enriching", "consigned", "fetish", "democratic", "accentuate", "sissy", "damning", "wades", "fumbles", "fact-based", "calculating", "blinded", "acknowledgement", "pigeons", "agendas", "companys", "abrahams", "jarre", "blades", "taxes", "breakdowns", "favorable", "sputters", "outward", "benefited", "schepisi", "spill", "markets", "debonair", "tierney", "vonnegut", "simulate", "babies", "sutherlands", "laid-back", "disadvantage", "nino", "trifle", "devious", "similarly-themed", "touchingly", "facilitate", "renoir", "blossom", "active", "islands", "lords", "self-indulgence", "purity", "collapses", "nominal", "blissful", "orion", "leven", "burdened", "survives", "selected", "airline", "prejudices", "fluids", "1952", "1969", "1973", "dole", "multi-faceted", "morrow", "stillers", "sized", "renowned", "rockwell", "separated", "18th", "bombast", "willingly", "booty", "blistering", "show-stopping", "antonias", "glitz", "reactionary", "t-shirts", "blakes", "condensed", "augustin", "chicks", "poledouris", "aida", "ullmann", "forewarned", "hijinks", "acute", "untouched", "dilemmas", "pinchot", "politely", "erins", "swell", "dives", "recovery", "spree", "syndrome", "flatly", "discriminating", "underappreciated", "sublimely", "documentarian", "cupboard", "nathaniel", "locane", "geographic", "idziak", "francie", "voodoo", "planted", "mcqueen", "indemnity", "milchan", "flavoring", "infuse", "ensues", "springtime", "ranch", "alonzo", "104", "106", "arabia", "120", "inundated", "albino", "stacey", "influential", "icing", "instinctively", "parental", "trump", "injuries", "mcalpine", "scout", "bowen", "saucers", "klan", "300", "uncut", "edge-of-the-seat", "farrellys", "sinclair", "spilled", "precedence", "wallpaper", "promesse", "albania", "ehren", "skirts", "pancake", "communism", "undead", "grandmother", "slaves", "degenerate", "zimmer", "confrontational", "rant", "immaturity", "rats", "fatigue", "sacrificed", "sacrifices", "chilly", "frankensteins", "assortment", "virus", "celebrates", "bailey", "basics", "arab", "pedigree", "cryptic", "inhabit", "irvings", "corrente", "temperature", "determining", "hilarity", "freezes", "telegraph", "widescreen", "basket", "pitching", "backdrops", "wahlberg", "carrol", "adage", "proficient", "bijou", "thirds", "portent", "gyllenhaal", "chalk", "linney", "polanskis", "severed", "spaceys", "stamina", "out-of-control", "intend", "beijing", "culled", "roxbury", "canon", "patrons", "temper", "temple", "riches", "hire", "theodore", "convenience", "mortality", "recreations", "aerial", "avid", "graveyard", "hard-", "perennial", "cockney", "unconcerned", "tackled", "jerks", "stalin", "harden", "condescending", "yield", "separating", "dinners", "elapsed", "gosnell", "paces", "taciturn", "immeasurably", "unsophisticated", "sting", "rudnick", "crank", "defending", "cracking", "commercialism", "madman", "incongruity", "adele", "billie", "harling", "operator", "echo", "eclipses", "achievements", "elena", "chews", "paean", "carla", "discovering", "towne", "ripostes", "jacobi", "higgins", "fresher", "plowright", "permeate", "external", "painters", "northwest", "jugular", "shellys", "ratner", "leonards", "creep", "2001", "homophobia", "hockey", "suicides", "caveat", "accentuated", "overdrive", "sverak", "must-see", "september", "adventuresome", "galore", "plimpton", "nastassja", "mitchum", "hayek", "immerse", "robertson", "blethyn", "robins", "norris", "worthless", "heinous", "far-reaching", "madsen", "walkabout", "pieced", "techines", "dictionary", "yimou", "photographer", "gratification", "barroom", "righteous", "anime", "curry", "mehta", "ghoulish", "silvio", "bach", "bags", "perversity", "sledgehammer", "gunfights", "knots", "above-average", "bats", "mozart", "lorenzo", "tilda", "inertia", "muscular", "widespread", "maureen", "mystique", "adjani", "labels", "mcnaughton", "stupor", "worker", "siskel", "jean-marie", "cocktail", "huey", "witnessing", "mueller-stahl", "hush", "materializes", "trampled", "black-and-", "remastered", "oily", "participant", "injury", "snaps", "unneeded", "courtesy", "minded", "townspeople", "inexperience", "imaginary", "appreciating", "quieter", "mantra", "extras", "resentment", "appreciative", "strife", "poetically", "overdo", "lamp", "manual", "sustaining", "suspicion", "labored", "entrancing", "beds", "bees", "qualifies", "scariest", "kamen", "sunglasses", "collapsing", "masayuki", "beth", "shelves", "recycles", "fumbling", "berardinelli", "grown-up", "epitaph", "undertones", "cynics", "preacher", "labyrinth", "transformations", "silliest", "belabored", "novelty", "hotels", "tuccis", "magically", "engine", "smacks", "epps", "hewitt", "genitalia", "relive", "vomiting", "rejection", "uninhibited", "amazes", "underlined", "levi", "humanize", "sorkin", "northern", "underutilized", "narrators", "ingrid", "layered", "classy", "chunk", "slices", "sample", "strobe", "undesirable", "global", "sergei", "sergio", "altering", "myles", "insidious", "robust", "powerhouse", "bankrupt", "library", "novice", "dublin", "mass-market", "introductory", "hapless", "subliminal", "india", "craving", "singletons", "announcer", "endear", "paradigm", "newells", "paraphrase", "bandits", "valentina", "hiring", "complimentary", "injustices", "spoofing", "vaughn", "fragility", "morph", "dicillo", "plates", "junkie", "ricky", "double-crosses", "foreigners", "pushy", "anti-social", "fates", "boaz", "stephane", "boil", "component", "funky", "volcanoes", "receptive", "skyscraper", "eyed", "viva", "oven", "gamble", "standup", "capers", "thivisol", "ridiculed", "healing", "connie", "flaming", "identifies", "owns", "kriss", "riffs", "garland", "consumed", "skydiving", "rifle", "foul-mouthed", "spreads", "shaken", "creeping", "spinotti", "informative", "lantern", "kazan", "output", "loop", "cunningham", "cronenbergs", "detect", "decisive", "enable", "lows", "sudsy", "corky", "stereo", "climb", "rockets", "hamster", "clive", "umbrella", "retrospective", "salad", "maggies", "assante", "paired", "outrageously", "critters", "disappearing", "perlman", "feeds", "solemn", "derives", "bagger", "blasted", "ariel", "justification", "overgrown", "loachs", "storms", "detestable", "luhrmanns", "regularity", "faux", "brassy", "intimidating", "uniqueness", "advantages", "cider", "is=20", "ambiguities", "plotless", "ringer", "swayze", "graced", "deceased", "fitful", "alienate", "nations", "mikey", "misadventures", "tawdry", "trotting", "self-help", "spacek", "governor", "dealers", "heavy-handedness", "reassuring", "whedon", "unheard", "saras", "grounds", "sarde", "cabaret", "milne", "milos", "systems", "accompaniment", "nobility", "joshua", "stockard", "arnie", "masterson", "replaces", "arnon", "mid-life", "attentive", "duels", "miner", "mines", "satan", "tracks", "lyle", "huston", "pulse-pounding", "broomfield", "shaven", "post-production", "percy", "ledoyen", "convertible", "hampton", "perks", "plot-wise", "memorably", "grimaces", "peck", "prophetic", "persian", "atlantis", "pest", "flare", "soar", "fizzles", "abbas", "fence", "exchanged", "cartoon-like", "serenade", "finn", "disinterested", "classify", "interrupting", "inflated", "pastiche", "marshalls", "destroying", "self-serving", "tenzin", "recalled", "bashing", "nearest", "winkler", "song-and-dance", "remaking", "bat", "pervades", "cyberspace", "multi-", "sayings", "_and_", "elliptical", "businessman", "sympathetically", "lambert", "brewster", "prestige", "courts", "posse", "morrison", "sheets", "cgi", "cho", "distanced", "pike", "cnn", "half-way", "seventy-five", "visibly", "sciorra", "stone-faced", "35mm", "det", "dex", "selmas", "assembly", "seedy", "puzzles", "cinematographers", "daryl", "seeks", "appetites", "dvd", "granny", "watches", "puppy-dog", "58", "conversely", "mate", "assassins", "acidic", "arrangement", "disappeared", "temporal", "well-told", "fractured", "structural", "diesel", "upsetting", "gainsbourg", "zhou", "undercuts", "geraldine", "b-films", "empathetic", "pearls", "virginia", "malaise", "henkin", "generosity", "giancarlo", "installments", "campus", "fold", "au", "engenders", "poured", "dunye", "spilling", "strategic", "repetitiveness", "wh", "legless", "ya", "gen", "bohemian", "lenses", "babbling", "perfected", "self-discovery", "continuously", "hasidic", "giveaway", "fling", "misnomer", "arrangements", "metamorphosis", "earths", "hbo", "sanders", "disguises", "all-around", "hum", "melt", "brosnans", "frat", "conversing", "collected", "hackmans", "furniture", "dawns", "story-teller", "murdered", "satiric", "operating", "ilk", "pole", "porkys", "typecast", "whoops", "execute", "pore", "boiled", "goldie", "illusions", "rounders", "jeb", "dilutes", "underwhelming", "decay", "gaslight", "braugher", "hackford", "underpinnings", "attest", "grungy", "divide", "realist", "hollywood-type", "cuddly", "bewildered", "towering", "bakers", "gielgud", "weir", "smashing", "talkfest", "percentage", "perils", "lys", "astonishment", "henris", "redeems", "rhetoric", "housekeeper", "putrid", "skulls", "crisply", "merchant/ivory", "heightens", "greasy", "lincoln", "corridors", "cooked", "pent-up", "insurance", "guarantees", "nun", "dodge", "whiz", "handbook", "in-joke", "hilditch", "ashman", "efficiency", "launches", "brotherly", "continuation", "mourning", "racists", "cody", "on-", "equates", "pimps", "delayed", "mussolini", "indulge", "hallucinogenic", "life-affirming", "corn", "ozu", "buttocks", "coxs", "participating", "crushing", "farnsworth", "sargasso", "pin", "hustler", "orgazmo", "startlingly", "marcello", "sonia", "listens", "risible", "bizarrely", "takehiro", "drove", "disorienting", "heaped", "pre-release", "elegance", "condescension", "taps", "diabolically", "psyches", "deedles", "quo", "scraping", "unions", "dogme", "mcginley", "stopkewich", "jeni", "murrays", "pickup", "shaiman", "rex", "villagers", "lapse", "satisfactorily", "washing", "constrained", "matthews", "probability", "poorly-developed", "rug", "rum", "ganga", "almodovars", "milius", "crux", "lukas", "sag", "rituals", "patterson", "pointlessly", "appellation", "sideshow", "fulfill", "sob", "singularity", "suo", "hugely", "attractiveness", "overly-long", "straying", "low-tech", "bambi", "silhouetted", "flights", "injecting", "one-liner", "skimming", "weathered", "psychopathic", "gorgeously", "dominic", "laser", "monotony", "misfire", "tent", "hellish", "ever-changing", "vacillates", "colick", "norbert", "bombay", "rubbish", "radiantly", "finch", "goldmine", "woes", "grate", "physique", "callous", "faithfully", "trained", "housing", "pseudo-intellectual", "vie", "pithy", "jive", "whiskey", "institution", "prestigious", "wrong-headed", "pretenses", "violet", "pitts", "piccoli", "purchase", "fairness", "wax", "hormones", "mariachi", "gals", "mcclane", "armies", "pickford", "tuckers", "denver", "embellished", "preach", "edgar", "supreme", "indecision", "fringe", "syrup", "noses", "absent-minded", "daniele", "thud", "brawl", "donal", "prolific", "mugs", "five-minute", "stalingrad", "candle", "monroe", "candor", "newer", "reprising", "newly", "jabba", "oscar-caliber", "bulbs", "ribbon", "panahi", "cheats", "cigars", "diamonds", "gaunt", "afterglow", "zoo", "signing", "grieving", "roaring", "hitlers", "8-1/2", "nicer", "oppression", "mutant", "imitative", "resolving", "novak", "tight-fitting", "churns", "antagonism", "laugh-out-loud", "explorations", "gena", "vainly", "profundity", "fellini", "chriss", "stabile", "baton", "toshiro", "suvari", "pollak", "pandas", "seltzer", "non-offensive", "loveable", "genesis", "plunges", "damons", "aphorisms", "aiello", "cheech", "betrayed", "witnesses", "grins", "beware", "warmerdam", "squeaky", "devotes", "supervisor", "trends", "litany", "symptomatic", "betrays", "bluntly", "shalhoub", "gillespie", "register", "scatological", "freundlich", "gutsy", "arctic", "gist", "barbieri", "myriad", "partners", "dreamed", "kombat", "non-fiction", "brighter", "becky", "dabo", "dads", "phedon", "conspire", "eccentrics", "demonstration", "daze", "co-writers", "convicts", "johnsons", "strategically", "nodding", "packages", "amaze", "inhabits", "darnell", "glam", "revolve", "hoodlum", "fulfilled", "sideways", "mathist", "troops", "douglass", "late-night", "take-off", "spate", "collage", "agreement", "dardenne", "theft", "gradual", "inconsistencies", "valleys", "pleasurable", "renfro", "permanently", "suckered", "nathalie", "babbit", "staggering", "zucker-abrahams-zucker", "phoebe", "gibberish", "barrel", "shortened", "barrow", "companies", "justifiably", "obscured", "pre-teen", "rotting", "well-directed", "specializes", "detroit", "pescis", "grahams", "radiate", "underscores", "phyllis", "gown", "emulate", "pokemon", "angst-filled", "lenny", "ronnie", "resolves", "funding", "lovemaking", "nailed", "mortals", "panned", "hackers", "smolders", "hackett", "subtler", "prerequisite", "funhouse", "flowery", "gung-ho", "sessions", "derision", "hattie", "substitutes", "patronizing", "oasis", "ninety-five", "decapitations", "waving", "jewelry", "dial", "three-quarters", "deceiver", "valiant", "championship", "supplied", "dino", "sneers", "slapdash", "aristocrat", "originated", "laugh-aloud", "reconstruction", "bells", "alejandro", "majestys", "muresan", "acknowledges", "jules", "tchaikovsky", "fiancee", "mister", "bewitching", "marijuana", "built-in", "wrangling", "prequel", "magazines", "budgeted", "re-write", "interacting", "ardant", "smack", "co-director", "exemplified", "friedman", "dim-witted", "blanchett", "preferee", "emperor", "kasi", "attacked", "recommends", "hard-edged", "cheung", "zombies", "birkin", "foreshadowing", "ostensible", "heighten", "1933", "1943", "1953", "1962", "waterboy", "icelandic", "1981", "heartily", "likelihood", "planner", "mumbled", "dorm", "viggo", "fraternity", "harriss", "forging", "hunted", "admitting", "sallys", "ticking", "tediously", "topped", "berri", "boost", "boots", "fondas", "ruben", "headless", "antonioni", "fondly", "evaluation", "gretchen", "honorable", "devitos", "distaste", "inches", "towers", "little-known", "unfilmable", "noel", "director-writer", "flippant", "incentive", "internally", "showtime", "gathers", "inadvertently", "midsummer", "eliminating", "rounds", "orchestrated", "promoting", "wortmann", "gianni", "recreate", "erics", "snoozer", "unflappable", "transferring", "photos", "indomitable", "acquainted", "jasper", "locash", "duet", "cloning", "muddy", "dump", "undertaking", "magnolia", "tranquil", "escher", "feminine", "roosters", "quaint", "equinox", "mizrahi", "1/3", "103", "116", "119", "121", "wrath", "150", "dungeons", "tinted", "keatons", "corporation", "200", "trunk", "confessional", "fanatics", "sleepwalking", "zhangs", "pakula", "warts", "swiss", "stupidest", "secretive", "bombing", "forgiveness", "willem", "extends", "one-man", "quoting", "dentist", "mistaking", "molina", "stahl", "rifkin", "complicity", "twenty-five", "chronicling", "manni", "salvaged", "blond", "romantics", "fleder", "ideology", "impatient", "compassionate", "sender", "johnnys", "kiefer", "jelly", "lilly", "seemingly-endless", "rewrites", "temporary", "reciting", "liman", "panoramic", "efficiently", "no-name", "blurring", "ulee", "boxers", "hypothetical", "jokey", "vista", "ricardo", "gladly", "chimps", "shatter", "rates", "ironical", "entitled", "jumped", "separately", "crissy", "bender", "promoted", "lessor", "demeaning", "beattys", "jolly", "operations", "levinsons", "botched", "conspiracies", "hinges", "colorfully", "better-known", "potato", "reassurance", "rationale", "federico", "remi", "wexler", "distinguishes", "kris", "12-year-old", "ruining", "jonas", "sleeps", "stakes", "fleiss", "barrett", "corrina", "slawomir", "hiss", "action-oriented", "bluth", "zamachowski", "saison", "none-too-subtle", "texan", "cataclysmic", "self-effacing", "meadows", "maury", "bimbo", "intonations", "xavier", "edouard", "weepy", "caruso", "unassuming", "accidental", "snarling", "summarize", "chiller", "irritate", "sadomasochistic", "despondent", "amendment", "adolescents", "eclipsed", "merchandise", "blocks", "dislikable", "homers", "robes", "unmoving", "crystals", "casey", "miniscule", "cecilia", "workaholic", "showcased", "showcases", "campiness", "cultured", "zweibel", "undone", "bicycle", "bedtime", "pitiful", "merchant-ivory", "ecstasy", "thrived", "boulevard", "civility", "cleavage", "kettle", "ostentatious", "creek", "b-movies", "skyline", "unwatchably", "action-comedy", "nutshell", "anarchy", "finishing", "borderline", "drowns", "elias", "dry-eyed", "sufferings", "eggs", "starry", "eighteenth", "hayes", "bravura", "mocks", "taller", "buckets", "truthful", "surgeon", "inaccessible", "noelle", "restore", "locusts", "chapman", "shameful", "change-of-pace", "pudgy", "rolf", "disarmingly", "one-line", "floors", "21st", "ancestors", "republicans", "harlem", "indulgent", "impotence", "roys", "pitfall", "outlined", "curly", "salvage", "enlighten", "forges", "twentyfourseven", "paynes", "shyamalans", "balk", "kasdans", "influences", "corrigan", "callie", "palme", "overshadowed", "barrymores", "ever-growing", "undisputed", "ferocity", "ranting", "architecture", "thumbelina", "riotously", "hums", "timed", "sensationalized", "reworking", "goings-on", "unacceptable", "interviewer", "participate", "erstwhile", "konner", "star-crossed", "regulars", "dicaprios", "benson", "objectivity", "quantities", "gustav", "offset", "ghostbusters", "supplement", "cotton", "laps", "manuel", "lava", "trintignant", "maligned", "confessions", "fawlty", "otherworldly", "employee", "rudd", "waterss", "salvatore", "ruse", "wallowing", "harrer", "unbalanced", "certainty", "electricity", "ascertain", "pratt", "cedars", "omar", "evidently", "small-time", "kindness", "digested", "joaquin", "macbeth", "freudian", "hello", "throbbing", "melodious", "dwyer", "mahlers", "lampoons", "[the", "tires", "seated", "societys", "resurrect", "croghan", "frakes", "awarded", "lent", "voyeurs", "sniggering", "mommy", "jagged", "marcus", "elton", "urinating", "proceeding", "tangential", "lytton", "turturros", "patty", "cells", "clouzot", "legally", "demise", "esposito", "dietrich", "flawlessly", "hector", "intolerant", "midwestern", "kates", "marlowe", "zombie", "epithet", "matarazzo", "runway", "disturbingly", "sweating", "preisner", "jimmys", "widow", "equipped", "burrows", "probable", "scoundrel", "astray", "iago", "susannah", "antony", "goodmans", "expanded", "briskly", "tableaux", "offhand", "kidnapers", "judgmental", "statues", "asinine", "legrand", "unwittingly", "infected", "pussy", "reception", "pogues", "improvements", "conti", "multicolored", "self-respect", "clerk", "drescher", "vito", "pallbearer", "champion", "yiddish", "under-appreciated", "emotionally-", "egotistical", "cold-hearted", "sade", "peers", "dominant", "settling", "brockovich", "idol", "contradictions", "elementary", "gilroy", "farinelli", "interrupt", "wandered", "attenboroughs", "affectionate", "caffeine", "evoking", "vonneguts", "scam", "angelina", "instructor", "summarizes", "kirshner", "noltes", "riders", "illeana", "murderous", "re-creating", "escaping", "mortensen", "styled", "godards", "reilly", "gillies", "secular", "ephrons", "promptly", "essay", "wrights", "freaky", "pastorelli", "henderson", "cyrano", "prelude", "costa", "seas", "korine", "expansive", "salma", "prowl", "therapist", "fussy", "abbreviated", "ramblin", "ceiling", "mcgovern", "wills", "propels", "specifics", "chocolat", "wrongfully", "converted", "mythic", "bush", "exchanging", "recalling", "funerals", "profits", "witcher", "impeccably", "sandy", "zingers", "twinkling", "collectors", "memphis", "weightier", "radiating", "documentary-like", "madonnas", "co-scripter", "mckellan", "copland", "father-son", "_really_", "potency", "leveled", "stations", "symmetry", "upside", "ex-wife", "expectation", "reservation", "unhealthy", "drowned", "publisher", "world-weary", "luca", "admonishes", "liberals", "graffiti", "lillard", "grapple", "lump", "behaviors", "revulsion", "sigh", "ills", "arbogast", "sharks", "grafted", "sparingly", "dallas", "banking", "traveled", "masculine", "dartagnan", "vulgarity", "dwelling", "spaces", "non-disney", "pads", "hammered", "martys", "story-line", "dynamite", "arouse", "osmond", "graeme", "trusting", "polly", "cohens", "intermission", "offscreen", "violated", "memoir", "taming", "knocked", "oldmans", "capsule", "pulsating", "repercussions", "sassy", "scully", "hailed", "rarest", "depictions", "idealism", "baldwins", "hustle", "tarzans", "hiccups", "alchemy", "sliver", "well-realized", "transfixed", "romanticism", "pumped", "pairings", "insecurities", "ideological", "disheartening", "mother-daughter", "faulted", "coneheads", "debacle", "gregoire", "succumbs", "miramaxs", "posters", "pets", "document", "remark", "iris", "kernel", "teased", "hindi", "file", "sameness", "soup", "interruption", "indifferent", "petit", "submitted", "alienated", "nunns", "infuses", "andrea", "andrei", "spains", "orlando", "cain", "listener", "kooky", "depressive", "suggestive", "axe", "reverentially", "surge", "observant", "reworked", "categorize", "threshold", "brodie", "sucking", "unflattering", "monotonic", "draft", "aquarium", "clouseau", "posed", "sheedy", "wrongs", "lilians", "ninjas", "misty", "vicarious", "sheens", "sadler", "cuckoos", "annette", "ulmer", "cia", "cassidy", "theology", "co-", "com", "spheeris", "punishing", "crafty", "get-go", "special-effects", "soaps", "soapy", "trucks", "cannibal", "two-minute", "den", "der", "#3", "stiles", "puzzler", "underplayed", "dot", "louisa", "benignis", "throw-away", "overloaded", "moriarty", "mano", "47", "stem", "83", "dumas", "townsfolk", "provoked", "offends", "structures", "consecutive", "avary", "regained", "uneventful", "fad", "happier", "attach", "strong-willed", "ploy", "il", "plum", "ne", "ny", "pa", "pc", "switchblade", "madagascar", "demographic", "wu", "yi", "forge", "equaled", "unifying", "francesco", "piety", "avnets", "swan", "gym", "directionless", "shrew", "warp", "apparition", "wall-to-wall", "keyes", "trenches", "trance", "anachronisms", "feeding", "meek", "chip", "kattan", "mirren", "memo", "menu", "secretly", "software", "czech", "guiding", "frog", "poll", "musicians", "iqs", "switched", "avery", "unsatisfactory", "post-apocalyptic", "sabotaged", "jar", "unlikeable", "nutcracker", "channes", "permutations", "cross-country", "dried", "lahti", "orleans", "charging", "ham-fisted", "tie-in", "transvestite", "hawaii", "tried-and-true", "inflections", "badge", "badii", "ineptly", "selma", "slapping", "stuffing", "weed", "motherhood", "lucys", "condense", "lad", "transportation", "hollywood-style", "talkative", "lon", "tagged", "mayfield", "deepa", "bartender", "slams", "slaps", "hand-wringing", "youngs", "brooke", "milder", "mon", "imaginations", "henrys", "sarossy", "monger", "mui", "unrelentingly", "flops", "writhing", "fetishistic", "plugs", "jams", "heinrich", "newmans", "clicking", "smolder", "neo", "enraged", "plunk", "inhumanity", "cookie", "nia", "nil", "varda", "wagging", "matthaus", "kimberly", "tweaks", "proclaiming", "compensation", "overstuffed", "high-flying", "seething", "conventionally", "touristy", "airborne", "illustrious", "mammoth", "coax", "terrys", "launching", "protective", "trivializing", "mumble", "pretentiously", "pups", "celebrating", "coma", "interchange", "adhere", "ephemeral", "wimp", "wipe", "emmett", "remarked", "hysterical", "witt", "pinch", "unappetizing", "grazer", "pok", "provocatively", "sonke", "world-class", "titans", "artificially", "binder", "deceptions", "commissioned", "kevins", "life-changing", "bakker", "s&m", "keyser", "ill-suited", "accented", "sweepstakes", "serum", "hexter", "snapped", "finley", "crap", "spacecraft", "likeableness", "avalanche", "fictitious", "burstyn", "scorpion", "rub", "socio-political", "counterbalance", "impediment", "hurlyburly", "ski", "slc", "bales", "grodin", "counteract", "practicing", "ex-girlfriend", "banished", "delon", "aroused", "rushes", "abundantly", "tad", "tai", "under-stated", "nothin", "tee", "restaurants", "clarify", "distribute", "tcheky", "sorbo", "dilbert", "formans", "threes", "tod", "toe", "seducer", "tug", "slide", "picnic", "kore-eda", "mulroney", "slime", "charts", "farina", "sociology", "grail", "vondie", "cherubic", "nowadays", "peasant", "dailies", "cull", "invent", "leftover", "visited", "antithesis", "canada", "springs", "crudely", "janssen", "latino", "services", "vcr", "weavers", "dicillos", "viv", "fulfills", "investigating", "damian", "lyonne", "paltrows", "dolby", "engagingly", "simulated", "damien", "cunning", "energize", "kinship", "regards", "raving", "abandoning", "gellar", "wee", "crutch", "contented", "fanfare", "preserved", "norms", "herrmann", "non-threatening", "interpret", "fielding", "campbells", "gumby", "it=20", "conundrums", "dismay", "schwartzman", "gasts", "henstridge", "concealed", "snickers", "stockwell", "thom", "collar", "anarchist", "brass", "sputtering", "luppi", "hardison", "valeries", "attaining", "grandparents", "ravenous", "halfhearted", "candid", "tick", "afield", "thrive", "middle-brow", "leash", "interruptions", "skepticism", "dignified", "tina", "skimmed", "phillippe", "rascal", "admonition", "divides", "cocteau", "tete-a-tete", "rodent", "tectonic", "lavished", "particulars", "in-depth", "edith", "randomly", "unscathed", "marketable", "compromising", "zsa", "oedipal", "picassos", "_real_", "whines", "tranquility", "unrelenting", "loomis", "telegraphing", "alessandro", "teller", "batch", "veins", "superstars", "checks", "lusty", "ullman", "jock", "jody", "gawky", "misfit", "nearly-perfect", "bounces", "long-suffering", "artaud", "unchecked", "grossing", "ironies", "championing", "mistress", "bug-eyed", "smiled", "doren", "off-kilter", "channeling", "self-mocking", "throats", "yonkers", "grimm", "coldness", "walkers", "slowing", "morass", "devon", "mermaids", "vanilla", "trendy", "blunted", "escalates", "beals", "strategies", "fast-talking", "constitution", "sewell", "tirades", "barenaked", "toby", "mansion", "mottola", "phenomenally", "intimately", "moorhouse", "displeasure", "hardware", "geeky", "hawkins", "geena", "brick", "dreamer", "spoofs", "financing", "crossover", "climbers", "wertmuller", "contention", "verhoevens", "silas", "effects-driven", "occurrences", "bloodbath", "leftovers", "cleaning", "sedgwick", "vilmos", "artful", "spectre", "unworthy", "eagle", "doofus", "descend", "vying", "pigeon", "hartleys", "immerses", "judi", "tran", "fellows", "undercut", "mathieu", "ought", "intentioned", "consist", "karens", "oclock", "auster", "navarro", "adolfo", "montages", "fragments", "singh", "flaunts", "easy-going", "analyzed", "sullen", "shelleys", "ciphers", "salary", "europeans", "kelleys", "aronofskys", "hinting", "deschanel", "paquin", "extract", "tulsa", "dent", "devi", "simpatico", "dispute", "stirred", "ferocious", "tasks", "wild-eyed", "tattooed", "fistful", "visiting", "indoors", "blasband", "goya", "postcards", "endorsement", "leprechaun", "mouses", "planets", "blaxploitation", "maternal", "ninth", "three-dimensionality", "interwoven", "spottiswoode", "interference", "alfonso", "overabundance", "trent", "enthusiastically", "treasured", "distancing", "godreche", "insurrection", "theological", "acquaintances", "surfeit", "sloppily", "skewer", "neff", "unearthed", "currents", "davidtz", "trotta", "potters", "transparently", "bohem", "lowdown", "secure", "capitalist", "privilege", "reporting", "olympia", "olympic", "barneys", "t-shirt", "restrictions", "purest", "scant", "spiers", "unlucky", "capitalize", "[note", "grumpier", "pageant", "scars", "voted", "transcendental", "bella", "supposes", "blindly", "boils", "acknowledged", "rivettes", "assert", "barancik", "visits", "buoyed", "undiscriminating", "massacre", "modeled", "needles", "coitum", "subconsciously", "symphonic", "helplessly", "flustered", "jumbo", "diverted", "orchestral", "vices", "paychecks", "jumpy", "jackpot", "subway", "constructing", "ouedraogo", "dingy", "surfing", "premiered", "priorities", "mesmerize", "nightly", "shadings", "wagon", "selfless", "laborious", "adas", "mesmerizes", "loren", "resilient", "permitted", "ever-increasing", "incandescent", "assistance", "doubling", "katz", "startled", "naively", "kalvert", "co-workers", "hard-nosed", "entertainer", "jumble", "whimper", "hestons", "1900", "eschewed", "untapped", "1939", "bleed", "1974", "wondrous", "inkwell", "detracted", "doll", "friction", "anesthetized", "grownups", "more=20", "sensitively", "blaine", "carolyn", "inform", "exceed", "swarm", "classmates", "goran", "first-", "proust", "hamstrung", "danced", "respects", "perfectionist", "spills", "crickets", "schindler", "rubin", "everetts", "squirm", "reunions", "self-assured", "hitman", "lindsay", "mountainous", "$500", "meantime", "straining", "americana", "shuttle", "awaiting", "demarco", "enthrall", "trots", "hades", "juxtaposed", "hankss", "spiner", "ditto", "imminently", "eloquently", "gripes", "anti-drug", "monstrosity", "anne-marie", "drum", "chides", "nova", "journalism", "meetings", "abandons", "swicord", "vagaries", "fictions", "shifted", "hand-to-hand", "tautly", "marvellous", "einstein", "linking", "belfast", "williss", "street-wise", "thugs", "verges", "solving", "excite", "rally", "scheming", "headline", "washed-out", "appreciates", "bystanders", "comprise", "cadre", "dwells", "holliday", "locate", "sneakers", "ingenue", "psychopaths", "fumble", "vantage", "strachey", "illiterate", "eighteen", "oklahoma", "alum", "peasants", "kite", "homilies", "apteds", "sketchily", "sketching", "re-created", "randa", "attractions", "scandinavian", "112", "113", "117", "127", "tricked", "amis", "bravely", "vinny", "knock-off", "breathes", "detected", "cinque", "purposefully", "harp", "rosetta", "andr", "wards", "swift", "aspire", "improving", "rehearsal", "accusations", "swims", "tying", "pocket", "gallimard", "bowie", "showmanship", "astronaut", "staginess", "noirish", "nunn", "englands", "flurry", "phifer", "flourish", "synonymous", "30-second", "mandy", "dyan", "inextricably", "out-guess", "risque", "guided", "pursuing", "400", "awakenings", "bloom", "finely-tuned", "grabbed", "voyeur", "womanizing", "gotham", "screeching", "harland", "persuasive", "rake", "tonys", "riccis", "joanna", "son-in-law", "digits", "knee", "sendup", "seventy", "yorks", "carpet", "tour-de-force", "safety", "whiny", "blunts", "arch", "parlor", "preserve", "brickman", "by-the-book", "arlo", "uncaring", "handy", "hangs", "lindo", "outraged", "suchet", "jenna", "abbies", "downeys", "parameters", "doings", "sadomasochism", "robards", "unsavory", "melodies", "shenanigans", "kilmers", "devote", "obliviousness", "minimally", "alvins", "stairs", "stevo", "marry", "ciaran", "arbitrarily", "excrement", "swallowed", "reek", "overdrawn", "camus", "repo", "that--but", "jensen", "disintegration", "toaster", "obsessions", "open-ended", "natured", "interlaced", "natures", "chemical", "auto", "hilt", "wyatts", "signifying", "underbelly", "clockwatchers", "gossamer", "eleanor", "acknowledging", "kidnappers", "tailor-made", "carnival", "blush", "balzac", "robbed", "johanna", "coolidge", "inhabiting", "advancing", "continuous", "stalls", "bergerac", "noonans", "maura", "awol", "weakly", "footnote", "speaker", "ripper", "hierarchy", "stirs", "morricone", "aramis", "mellow", "rhys", "urdu", "bregman", "taylors", "defect", "single-handedly", "side-splittingly", "chens", "hatta", "moderation", "unattainable", "roald", "spectacles", "cumbersome", "palate", "reels", "inaccuracies", "well-received", "whispered", "producer/director", "dolphins", "utah", "reconciliation", "slogan", "odessa", "shelley", "imparts", "rocco", "double-entendres", "sought", "melody", "obtrusive", "scarlett", "affirmative", "underlies", "heady", "andys", "droves", "weisz", "honeymoon", "reinforcing", "alternating", "thrives", "11-year-old", "unhinged", "standouts", "rodeo", "rimbaud", "choking", "domain", "esther", "distilled", "cleaned", "flashed", "finzi-continis", "conceive", "decorations", "terrorism", "straight-ahead", "carlyle", "kyra", "goddess", "shoot-em-up", "dumping", "innocently", "scotland", "highlander", "elise", "impassioned", "kumble", "evenhanded", "northam", "humanitarian", "prospects", "embittered", "submerged", "inspirations", "transports", "kleptomaniac", "workplace", "sealed", "rome", "suspecting", "facility", "pigeonhole", "cures", "clean-cut", "selective", "amusingly", "inevitability", "cried", "strewn", "floppy", "ellie", "bulimia", "travails", "sevigny", "sebergs", "opposition", "cussing", "jackie-o", "kaige", "ogre", "confidently", "baye", "packing", "programming", "richter", "nunezs", "cuter", "harlequin", "mindlessly", "relaxing", "rattle", "unearth", "pseudonym", "materialized", "ominously", "forgivable", "timon", "misunderstand", "defendants", "chock", "materialistic", "caribbean", "pangs", "plucky", "macdonald", "lowlifes", "adore", "supportive", "sturdy", "earthquake", "wildlife", "harper", "and-white", "epstein", "ladd", "wonka", "mumfords", "diggers", "neo-noir", "keystone", "strips", "lodging", "hamburger", "inventions", "paolo", "fearing", "narrate", "negatives", "qualified", "randle", "annas", "berg", "peckinpah", "annes", "audible", "self-righteousness", "black-humored", "all-out", "lowlife", "softened", "utmost", "well-adjusted", "endangerment", "fonteyne", "preaches", "wests", "revell", "gwens", "formal", "photogenic", "oconnell", "gifford", "stinging", "condom", "omri", "mini-dramas", "kindred", "storyteller", "antecedents", "gregarious", "musically", "wizards", "briefest", "dishonest", "ranged", "wordy", "retired", "digging", "leanings", "rerun", "flexing", "lucrative", "leia", "biographies", "miraculous", "injected", "beards", "professionalism", "shabby", "entourage", "semi-autobiographical", "darned", "rosenbloom", "smileys", "passe", "ermo", "poorly-written", "eighth", "bike", "historian", "toning", "balcony", "unsteady", "dysfunction", "nonprofessional", "strauss", "curdled", "heritage", "patti", "mikado", "colorado", "cello", "confuses", "clutter", "unknowns", "exclaims", "sanchez", "gilles", "karyo", "lhermitte", "_does_", "anytime", "illuminated", "illuminates", "alberto", "cartlidge", "gleeson", "enlivens", "sacha", "imagining", "clipped", "scrambling", "yoda", "baroque", "mankiewicz", "clavel", "excluding", "rayfiel", "self-important", "schraders", "henrietta", "limb", "lime", "margin", "hayley", "embeth", "evan", "veiled", "darren", "frankness", "battling", "bracket", "companions", "valentino", "kringle", "khondji", "farsi", "principally", "hoops", "rouan", "zellwegers", "ewan", "steroids", "rouge", "weekly", "rouse", "virtuous", "prediction", "doubtful", "jocelyn", "prior", "productive", "anwar", "philandering", "marine", "rangoon", "jean-yves", "transpiring", "congo", "vocals", "off-balance", "nadja", "kenton", "upbringing", "morriss", "freed", "profitable", "redneck", "ahern", "bout", "procreation", "well-defined", "twain", "standby", "motta", "gambon", "metaphorically", "submission", "reassure", "formless", "pained", "dispatched", "sags", "cesar", "rainbow", "sale", "gazing", "sang", "slipped", "saps", "rapaport", "drastically", "militant", "sawa", "succumbing", "hyped", "two-plus", "solace", "budgets", "tediousness", "overnight", "anarchic", "eckhart", "astronomical", "set-ups", "ridden", "brandy", "hallucinatory", "annaud", "components", "instructed", "lope", "haller", "outweighs", "unfinished", "ad-libbing", "simulation", "corey", "reckoned", "metroland", "creepiness", "punctuate", "unhappiness", "assertion", "peanuts", "pedophilia", "probe", "fritz", "historic", "implies", "salem", "well-meaning", "magnetism", "rigorously", "imports", "papers", "stanwyck", "rambles", "blasting", "leonetti", "skims", "downward", "knives", "bundle", "intriguingly", "hides", "adversary", "sena", "policeman", "imposed", "bothering", "shante", "prospective", "leders", "projectile", "environments", "luster", "burr", "sammy", "streisands", "swears", "sweaty", "confounding", "devastatingly", "shave", "wordless", "unenthusiastic", "goatee", "downpour", "assurance", "wince", "owens", "invented", "ripleys", "wittliff", "affability", "africans", "townsend", "regurgitate", "arline", "blossoms", "resourcefulness", "co-screenwriter", "ravishing", "blinds", "independently", "unfolded", "published", "shun", "rossio", "juliets", "tantamount", "writer/directors", "pussycat", "better-", "unwieldy", "folles", "lurk", "kidnapped", "nemesis", "cinderella", "copying", "legros", "mikes", "eloquence", "cachet", "warm-hearted", "alters", "nanny", "kimble", "lodoli", "devotees", "sheet", "cut-out", "beatings", "luminescent", "daviss", "smacked", "nymans", "potboiler", "naomi", "otoole", "tykwers", "glistening", "noiret", "bananas", "sully", "well-worn", "homogenized", "fading", "vilanch", "dogmas", "feud", "dogmen", "scarce", "farmers", "analogy", "prancing", "macmillan", "immortality", "copeland", "distinguishable", "over-used", "dariusz", "managers", "daringly", "lyon", "muscle", "inconsistency", "contortions", "richmond", "innuendoes", "zahn", "unimpressed", "underworld", "superficiality", "bourgeoisie", "demonaco", "meteor", "summertime", "dramatization", "actuality", "brazen", "peel", "monopoly", "haines", "corrosive", "eyebrow", "steadfastly", "animatronics", "assures", "courtesan", "savoy", "soil", "presses", "lisbon", "prurient", "storybook", "pasolini", "assayas", "conformist", "contemplating", "outwardly", "sominex", "seale", "shrift", "schism", "freakish", "owned", "abbys", "conquest", "shrimp", "jointly", "foley", "traverse", "experts", "recluse", "aip", "encountered", "hindrance", "reform", "disingenuous", "cahn", "weeping", "precede", "badham", "feather-light", "ate", "kerry", "cane", "aux", "sokolow", "touted", "mind-set", "surrealism", "tightly-paced", "phat", "resilience", "hazard", "pigeonholed", "hammering", "takeshi", "degenerating", "businessmen", "zest", "solemnity", "cindy", "abundant", "crippling", "cad", "koepps", "dukes", "moonstruck", "eskimos", "che", "vocabulary", "col", "frolic", "pipe", "klines", "frollo", "comedy/drama", "musics", "skinhead", "trails", "unadulterated", "yoakam", "nephew", "pantoliano", "roundtree", "britain", "impunity", "evenings", "dee", "cereal", "assemble", "seeds", "$2", "dulls", "darts", "low-level", "ambush", "three-plus", "cipher", "gutted", "auteurs", "grange", "darlington", "stills", "dumbed", "preminger", "mama", "heartstrings", "77", "87", "94", "infertility", "plagiarism", "pours", "meredith", "schifrin", "guignol", "hand-drawn", "deadlines", "shops", "listless", "yanking", "off-key", "lament", "nobleman", "underwood", "promotional", "lamest", "corley", "turners", "virginie", "claudio", "jigsaw", "settlement", "earning", "co", "cy", "keenly", "tinseltown", "fh", "fork", "_are_", "bulging", "ku", "fur", "cormac", "ly", "na", "nr", "unsaid", "muslim", "bunuel", "sergeant", "stand-alone", "temptations", "pytka", "sven", "katrin", "vampirism", "ve", "gal", "schoolers", "gee", "housewife", "smells", "blinking", "divert", "butchered", "rizzo", "showpiece", "spiteful", "forum", "sorcery", "pronounce", "remiss", "diarrhea", "venomous", "laszlo", "stephan", "shrek", "hay", "horrified", "manchevski", "freeze-frames", "druggies", "olmstead", "hmm", "disagreement", "hop", "subculture", "izzy", "energetically", "meir", "chop", "cited", "big-hearted", "approved", "tattoos", "polonius", "smoked", "id4", "spectres", "zegers", "toothless", "torres", "piggy", "branded", "pomp", "pond", "pooh", "flatter", "shelby", "itd", "posh", "secondo", "retained", "mozelle", "boiler", "aarons", "wise-cracking", "suppressed", "rigueur", "praiseworthy", "lapsed", "jaw", "lushness", "eavesdrop", "queer", "imbuing", "doubly", "stillborn", "side-splitting", "applauded", "ordered", "instability", "coiffure", "tongues", "enhancing", "porcelain", "grunts", "travellers", "compromises", "dusty", "shields", "lizard", "metric", "dissatisfied", "corral", "pyrotechnic", "circular", "culminates", "illicit", "prep", "pres", "mouthing", "30-minute", "lin", "liu", "abusing", "mice", "dryburghs", "hawaiian", "pros", "one-time", "leachman", "lug", "optimist", "mina", "culprit", "mint", "condemned", "fiend", "karmitz", "stifling", "sansar", "slant", "mac", "healed", "mai", "singlehandedly", "compulsively", "herskovitz", "cross-cut", "obtained", "mol", "pleasingly", "patriarch", "mum", "yglesias", "too-often", "befall", "villages", "grittiness", "impartial", "decadent", "uncharismatic", "piled", "piles", "turteltaub", "options", "non-action", "subservient", "rocketman", "ruthlessness", "jaye", "talkies", "hysterically", "scenic", "bureaucratic", "nsa", "nickname", "missile", "solos", "mansfield", "heartwood", "minutiae", "bedelia", "hacked", "isabella", "sufficed", "lamer", "impulsive", "protection", "puck", "whiteness", "swordplay", "preparations", "clooneys", "ooh", "cramped", "asserts", "bahns", "cons", "putz", "owe", "paternal", "parodying", "lanes", "mychael", "pseudo-science", "counters", "wire", "cozy", "sherry", "pioneering", "abril", "committing", "unbroken", "plugged", "tuning", "sheryl", "hardship", "pow", "family-friendly", "chaney", "romanian", "pub", "loud-mouthed", "greece", "communicates", "searing", "hearings", "short-changed", "renditions", "lowther", "breathtakingly", "luisa", "resorted", "zdenek", "ensconced", "winnie", "crippled", "yojimbo", "rae", "co-producer", "jens", "t&a", "gamut", "ren", "discusses", "idealistic", "signals", "outpouring", "moms", "negroponte", "monk", "brambilla", "inflict", "institute", "chappy", "nakajima", "moss", "cristofer", "comprehensible", "dished", "pythons", "non-fans", "stampede", "likeability", "re-tread", "impoverished", "simmering", "libertine", "compendium", "explicitness", "buffy", "pique", "brannon", "syd", "premingers", "tab", "tak", "tan", "jewels", "veber", "frankies", "airhead", "trusty", "divorced", "retire", "1979s", "declaring", "tit", "silhouettes", "@sover", "guise", "bertoluccis", "barbed", "requirements", "octogenarian", "listing", "ryders", "exceeded", "sarafian", "seuss", "churned", "absorbs", "convent", "messiah", "heated", "convert", "misfits", "demys", "teno", "harness", "bedazzled", "dental", "dreamworld", "ackland", "33-1/3", "alton", "dench", "burned", "banky", "chaser", "herein", "julias", "sub-genre", "cups", "vienna", "curb", "womb", "oddest", "refined", "bruckheimers", "worm", "remarking", "energies", "lungs", "commando", "shouts", "cagney", "debuted", "julius", "homoerotic", "investigative", "orthodox", "grizzly", "dolly", "clement", "hamper", "envious", "crazed", "posterior", "gail", "mischievous", "sweetheart", "densham", "rapscallion", "misunderstandings", "gast", "computer-animated", "nuggets", "jean-jacques", "correcting", "lawton", "theo", "lerner", "braga", "prefontaines", "pre-production", "mexico", "bravo", "askew", "audition", "writ", "adjusting", "kitten", "newby", "reconcile", "leaud", "immune", "fatherly", "malevolence", "astaire", "tips", "thusly", "deran", "bessie", "stapleton", "barks", "lumbering", "titanics", "viscera", "dehumanized", "yul", "tightly-plotted", "mcdormand", "cultish", "humiliating", "oddity", "dorfman", "silverstones", "lured", "zen", "fiercely", "tubes", "yearnings", "signify", "roseanna", "fiance", "fast-pace", "oozing", "dorian", "underpinning", "bracketed", "unintelligible", "sad-eyed", "shaping", "cliche-ridden", "clintons", "shapiro", "treacly", "applicable", "anemic", "onslaught", "pleading", "bathe", "crackling", "constitutes", "proliferation", "instructional", "informed", "jumbled", "heterosexuals", "recordings", "contingent", "adopting", "niece", "mustache", "luciano", "troisi", "sonnenfelds", "heinlein", "shrouded", "subjecting", "conference", "approximating", "uneducated", "insufferably", "inscrutability", "grimy", "spartan", "cheeks", "gripe", "dead-pan", "damper", "barkin", "trash-talking", "cheery", "verbatim", "sommersby", "historians", "devor", "rollicking", "re-hash", "gorefest", "start-to-finish", "farrow", "choreographing", "swishy", "deteriorating", "voila", "rivaling", "duplicitous", "giamatti", "breillat", "heart-breaking", "baffles", "fleshed-out", "gazoo", "cheerleaders", "too-", "moulin", "evolved", "tong", "peeves", "crossdressing", "buchanan", "geeks", "spartacus", "trademarks", "tomcats", "whistle", "burly", "viciousness", "arteta", "tart-tongued", "javert", "stepfather", "brighton", "venom", "hirokazu", "mentor", "bankruptcy", "bristling", "ilona", "unfashionable", "closeness", "wholesomeness", "appallingly", "divergent", "revenue", "imitators", "ribisi", "slums", "resignation", "orwellian", "crenna", "flabby", "nipples", "visage", "honored", "alumni", "machiavellian", "artetas", "yarns", "onset", "commandment", "aussie", "deutch", "lydia", "untracked", "snipped", "snippet", "beefy", "gospel", "deprogramming", "hopping", "dovetails", "trot", "confronts", "complexion", "educational", "vincents", "high-strung", "ennui", "proponent", "glum", "bowler", "vivacious", "parodied", "cannom", "wearisome", "instruction", "teaming", "yates", "leaning", "progressed", "instructive", "leeson", "opulent", "sustains", "dostoevsky", "denmark", "teary-eyed", "valeria", "letterman", "turgid", "javier", "pictured", "sweater", "edelmans", "happy-go-lucky", "divisions", "drooling", "relished", "babble", "debi", "deed", "publicly", "garrison", "portentous", "dermot", "verse", "are=20", "insides", "lookout", "adroitly", "homo-erotic", "inclination", "reverse", "whipped", "estelle", "translating", "communists", "twenties", "dukakis", "discord", "armrest", "makhmalbaf", "specialized", "castles", "turf", "goof", "parting", "unleashed", "isham", "well-conceived", "occupied", "brock", "followers", "emmanuel", "16-year-old", "cosmic", "analytical", "sure-handed", "whiskers", "brook", "little-seen", "speck", "karina", "high-budget", "brows", "he-man", "masturbating", "nonchalance", "videotapes", "stanleys", "surpass", "emergence", "leoni", "disclaimer", "simmons", "watershed", "gabrielle", "acquits", "druggie", "sapiens", "helicopters", "ness", "tupac", "praises", "herring", "groping", "confine", "helene", "toned-down", "langella", "confirm", "feuding", "old-time", "marxist", "facades", "treacherous", "campuses", "dirk", "disk", "$50", "supports", "$70", "diva", "joachim", "black-", "sites", "stonewall", "teary", "brashness", "lindenlaub", "composing", "chaykin", "amini", "islam", "enticing", "on-going", "enthusiasts", "compensates", "wheeler", "baseketball", "trysts", "propel", "mechanics", "helfgott", "remembers", "purged", "atkins", "ferrell", "molinaro", "go-getter", "cherry", "fluent", "recruiting", "harrers", "cheryl", "rawness", "governess", "delany", "shudder-inducing", "unprecedented", "protesters", "uncontrollably", "digimon", "radha", "reuben", "self-loathing", "egyptian", "encouragement", "egregious", "glorifying", "parliament", "brunt", "mohsen", "shortage", "sullivans", "infomercial", "scripter", "well-trodden", "damages", "dissection", "abuses", "same-sex", "purist", "goose", "overhyped", "renown", "afterworld", "costly", "chevalier", "apolitical", "objectionable", "zeitgeist", "no-holds-barred", "chords", "$200", "16th", "assassin", "revolving", "thora", "thorn", "merlet", "tomeis", "rigidly", "wannabes", "rumors", "poisoners", "co-directors", "newsroom", "gremlins", "patricks", "backdraft", "elicited", "buffoon", "quit", "1937", "salles", "twirling", "1944", "1945", "1950", "1978", "17th", "1982", "edlund", "dons", "bonts", "electronics", "kristy", "michell", "minuscule", "burglar", "outdo", "bless", "one-on-one", "boobs", "swank", "swann", "disapproval", "commission", "vigor", "silvestri", "characteristically", "libby", "tie-ins", "sacrilege", "interminably", "researched", "skiing", "machismo", "yoshii", "put-upon", "long-haired", "lethargy", "louie", "bygone", "garlic", "conducted", "unmistakably", "juliannes", "director/co-writer", "newfound", "diminishing", "uncovering", "discontent", "rubys", "cobbled", "bennetts", "schneiders", "cutaways", "trois", "contentment", "shortest", "wales", "normally-reliable", "kees", "inhumane", "cecchi", "restrictive", "austrian", "intensive", "promiscuous", "horners", "peirce", "stupefyingly", "austerity", "harshness", "evolving", "uninvolved", "mccarthys", "tempting", "undoing", "attendance", "drip", "travelers", "aide", "corporations", "concise", "berkley", "nope", "loathed", "intricately", "horrendous", "hebrew", "journalist", "execrable", "megalomaniac", "bores", "elimination", "albatross", "fultons", "liberating", "silences", "patinkin", "borne", "promotion", "hollowness", "urbane", "rudimentary", "waned", "sobbing", "hangdog", "perceptiveness", "wangs", "flaunting", "clearest", "zipper", "toilets", "saigon", "down-to-earth", "spray", "recovers", "fieschi", "mid-70s", "llosa", "borgnine", "skimpy", "prozac", "untold", "mumbo-jumbo", "/97", "reviled", "documented", "winterbourne", "better-than-average", "agency", "carvers", "ballhaus", "huang", "duly", "missionaries", "dune", "bathtub", "mercutio", "elfmans", "garners", "reconstructed", "instrumental", "eschew", "suitor", "fascinates", "alonso", "manifestations", "dreyfus", "thorough", "protestors", "captains", "impenetrable", "culkins", "dixon", "alleys", "margarets", "132", "stimulated", "snooze", "intestines", "hail", "glove", "brokedown", "skinheads", "malik", "belinda", "twisty", "pillsbury", "nationality", "clearing", "ermey", "20s", "pursue", "knocks", "anns", "cecils", "scorn", "indelibly", "liberated", "undergo", "portuguese", "withstand", "betray", "thorntons", "kitschy", "resources", "misogynistic", "rapes", "exacting", "inordinately", "3-d", "pansori", "powell", "brightness", "throttle", "gleaned", "blares", "360", "madden", "skeletal", "kennedys", "staid", "avowed", "carnal", "vastness", "stall", "patriarchal", "yolande", "manns", "garguilo", "corrupted", "approximate", "calendar", "valentines", "pursuits", "barretos", "blasko", "panthers", "rade", "apur", "resounding", "motivational", "flutes", "camouflaged", "rang", "rapp", "yellows", "magnetic", "carole", "joanne", "carols", "re-interpretation", "deprived", "500", "paradoxically", "intersections", "warners", "smoky", "disorders", "economical", "schoolyard", "storaro", "hinder", "terri", "heed", "flirtation", "limbs", "springer", "sargent", "somethings", "larenz", "grittier", "bastard", "dim-wittedness", "herlihy", "zooming", "sailing", "troublesome", "illtown", "bustle", "mischief", "raspy", "vortex", "upstages", "mastermind", "carlyles", "unger", "objection", "steadfast", "liner", "scholar", "archetypal", "compel", "thwarted", "herrington", "enunciation", "pirates", "verona", "calei", "fuming", "woodard", "lessen", "incongruities", "nearby", "booster", "slayer", "jamess", "person-on-the-street", "immersing", "baines", "bancroft", "cold-blooded", "assimilation", "spastic", "stream-of-consciousness", "hurley", "carrot", "radford", "overlaid", "glorify", "unit", "interferes", "evidenced", "swoon", "gleason", "conscienceless", "hoblits", "champ", "barbarian", "remy", "ravel", "docudrama", "kikujiro", "laurel", "counselor", "baffle", "aunt", "blurbs", "zsigmond", "lonergan", "flotsam", "unfettered", "sillas", "comfortably", "stiffly", "munch", "sonnys", "alter-ego", "moscow", "laurentiis", "matte", "grandchildren", "attachment", "scandals", "jonze", "appealed", "hostility", "robber", "hip-hop", "wonderment", "harms", "over-", "hit-and-run", "witless", "debunking", "groaners", "practiced", "awed", "itchy", "pirate", "prissy", "danson", "kaiges", "maniac", "razor-sharp", "shading", "lisas", "socialism", "tours", "elder", "fruition", "fantasia/2000", "stink", "stint", "carver", "fantasizing", "vitale", "allocated", "dolittle", "philosophers", "accompanist", "soaked", "prudent", "paddy", "bentley", "stupendous", "tides", "autumnal", "wagnerian", "bodrov", "towel", "tower", "sing-along", "headings", "loveless", "situational", "tenacity", "three-hour", "mutilated", "cantonese", "vertical", "eunice", "gee-whiz", "ormonds", "combatants", "cetera", "reeve", "flavors", "stanford", "forays", "caste", "hendrix", "saffron", "hard-working", "impulse", "caesar", "weigh", "crackles", "forbes", "hester", "enlivened", "whitakers", "mushy", "maxine", "morricones", "summon", "toyed", "disliked", "medea", "solemnly", "automated", "olmos", "sprecher", "twenty-eight", "roddy", "regis", "scorecard", "allendes", "adherence", "exhaust", "cleaner", "depalmas", "out-takes", "over-dramatized", "bordered", "talker", "zhaos", "confirmed", "bookstore", "talkie", "a-plenty", "greenland", "hubert", "lynskey", "cosmatos", "cottrell", "yang", "shanley", "facto", "bonanza", "notoriety", "stony", "comprehensive", "chemicals", "well-respected", "excepted", "downtrodden", "declared", "tallys", "virginity", "scarier", "edmond", "rosi", "hobby", "rebels", "overview", "clumsiness", "stricken", "lombard", "wrinkles", "lewiss", "evaluated", "overflows", "moralistic", "humanistic", "reruns", "melted", "deletion", "curve", "underlining", "entity", "page-turner", "shepherd", "succumb", "caller", "barf", "boggles", "verbose", "warm-up", "crusade", "that=20", "unduly", "goriest", "knicks", "charlottes", "illustration", "blokes", "gracious", "strands", "self-sacrifice", "humanizing", "signifiers", "yeoh", "leavened", "retarded", "remar", "hues", "florid", "hugs", "conjure", "pressing", "hulk", "unified", "smothered", "hunk", "figuratively", "plugging", "talking-head", "intruding", "deceit", "whitmores", "hoegs", "cocteaus", "mekhi", "hairdressers", "midges", "cadillac", "predicted", "imbeciles", "one-idea", "hurting", "axiom", "experimentation", "lace", "deepens", "gay-themed", "augusts", "sixteen", "roaming", "moranis", "deepest", "borden", "penultimate", "coroner", "moira", "trevors", "sunsets", "condemn", "face-to-face", "fingered", "beef", "harshly", "melting", "discouraging", "prototypical", "over-the-edge", "catskills", "bert", "discards", "cinepix", "tightly-scripted", "annoy", "reassured", "not=20", "wryly", "camping", "olin", "campfire", "pastime", "addictive", "nortons", "palmas", "discourses", "one-by-one", "palmer", "harron", "proposed", "tuneful", "proposes", "fuels", "torturous", "berling", "steele", "steely", "pounding", "shepard", "pegged", "mahoney", "spraying", "crook", "falks", "re-telling", "westerners", "ten-year-old", "acknowledgment", "hells", "depended", "vail", "narratively", "infrequently", "recycle", "marble", "stocks", "sumptuously", "helpless", "minghellas", "leaf", "loggia", "medieval", "famke", "liveliness", "hamlisch", "justifies", "coastline", "inanely", "under-10", "outcasts", "leno", "conjunction", "stodgy", "amnesia", "sixties", "outweigh", "momma", "kapur", "associates", "deconstruction", "leadership", "nevada", "cliche-riddled", "defects", "westman", "sanford", "almasy", "pasta", "hogans", "squabbling", "wellspring", "mining", "pumps", "switzerland", "byrnes", "outdoes", "bing", "ridgemont", "homicide", "resonates", "ceremonies", "typewriter", "frederick", "downsizing", "projected", "bamboozled", "junger", "fantastically", "defuse", "chereau", "nameless", "firstly", "sissel", "shedding", "holms", "unbounded", "morpheus", "wide-angle", "ceremonie", "blemishes", "cookie-cutter", "franzoni", "shaded", "re-made", "co-writer/director", "robbing", "technologically", "moose", "re-make", "employment", "snide", "5/6/97", "phish", "mathilda", "overstated", "stranded", "jerrys", "urine", "hectic", "mandoki", "romantically", "takashi", "connick", "enlightened", "claws", "niceness", "unbridled", "believers", "punctuates", "equation", "rumpled", "lick", "implying", "katie", "cents", "meter", "inconvenience", "elegantly", "limo", "universality", "communications", "gargantuan", "lite", "blended", "self-evident", "roths", "byproduct", "clifton", "eighty-five", "proficiency", "hoods", "zillions", "prostitutes", "popularized", "pupils", "fast-forward", "wahlbergs", "mores", "well-placed", "susannas", "effervescent", "outlaw", "outlet", "oddballs", "tenseness", "wiest", "overworked", "blood-and-gore", "mocked", "smugness", "lyricist", "preteens", "risking", "criticizing", "morphing", "heinleins", "ursula", "waterfalls", "traumas", "wifes", "mendelsohn", "snickering", "nadia", "die-hards", "illuminating", "pumbaa", "sayless", "bolt", "forrests", "half-developed", "touchy", "weighed", "boyd", "rowdy", "motor", "purples", "openness", "foursquare", "sorrow", "unwelcome", "marker", "collecting", "accusers", "faust", "pitcher", "slicing", "calligraphy", "horny", "amelio", "johansson", "struts", "present-day", "colliding", "winding", "collette", "sami", "primally", "unobtrusive", "oconnors", "pervert", "earthly", "consumes", "cruellas", "shootings", "male/female", "overcast", "possessions", "hepburn", "hosts", "blessedly", "removes", "branch", "jovial", "varsity", "cowardly", "giorgio", "yuen", "belgian", "distinguishing", "loch", "feats", "foleys", "indoctrination", "cynic", "yuks", "boldness", "mobsters", "profusely", "myths", "mathison", "taiwan", "weeper", "novices", "echelon", "emphatic", "gamely", "detest", "tamara", "accusation", "kristofferson", "translates", "condemnation", "programmed", "programmer", "tweak", "hound", "silberling", "yields", "hubbard", "feces", "decently", "tennis", "beautys", "recreated", "recreates", "anal-retentive", "thumbing", "bernie", "penguin", "eigeman", "shrinks", "complimented", "stationary", "microphone", "emotes", "defying", "stunted", "ignominious", "carters", "poignantly", "sheridans", "begging", "profundities", "corollary", "engulfs", "narrates", "induce", "scales", "prohibition-era", "eddies", "ill-defined", "histrionics", "curtains", "couch", "vows", "harmful", "announcing", "knockout", "telescope", "routinely", "arias", "preoccupied", "castor", "punctuation", "dawsons", "kirstie", "paramounts", "poorly-realized", "sants", "ledger", "oprah", "mckellar", "singled", "cedric", "sharons", "sham", "loosely-connected", "fighters", "hammers", "unstrung", "shit", "eyelids", "preferably", "shoe", "unthinkable", "hedaya", "gracie", "communities", "dominick", "wading", "uninitiated", "vinnie", "sica", "taymors", "phantoms", "envisions", "behaviour", "lutz", "speculation", "dahls", "scowling", "romane", "romans", "slippery", "peculiarly", "cloak", "hipster", "grader", "simons", "non-english", "satellite", "on-court", "suffocating", "victories", "action/thriller", "splitting", "excellence", "streaming", "stuarts", "sadder", "trustworthy", "multi-million", "willendorf", "annies", "piecing", "televised", "5-year-old", "sheri", "fourteen", "nonplused", "papa", "sticky", "milks", "milking", "fuentes", "kelso", "peeping", "persistence", "free-spirited", "unrecognizable", "mouthpieces", "restrain", "lottery", "artemisia", "schell", "backwards", "misinterpret", "fenn", "adulation", "foreigner", "alcoholics", "reputations", "coarse", "fetching", "humphrey", "censor", "well-handled", "analyzing", "irrationality", "gambler", "slit", "positives", "fullers", "resumes", "lieberman", "effusive", "entrusted", "intro", "slaughter", "cleansing", "implicitly", "unpolished", "shermans", "defiant", "anthropology", "foreplay", "truckload", "star-making", "overexposure", "cloned", "shotgun", "behaving", "traded", "backwater", "crusader", "bureaucracy", "stifle", "collections", "half-realized", "highly-", "marceau", "snag", "aback", "saura", "wavering", "shies", "hoosiers", "professionally", "legitimately", "scissorhands", "under-written", "kermit", "pecs", "lobotomy", "nasal", "snob", "boothe", "compete", "non-judgmental", "with=20", "gershon", "afterward", "gloves", "diversity", "soak", "dandy", "two-character", "hyper-kinetic", "sofa", "davidson", "schiff", "selick", "physicality", "gaining", "exclamation", "cleaned-up", "kicker", "fink", "notables", "sadist", "mccabe", "shakespearian", "contemplation", "breeze", "jean-marc", "scumbag", "chameleon", "brain-dead", "klein", "mccann", "propriety", "spew", "weighs", "incorrectness", "grifters", "flashlights", "servant", "jurgen", "intersect", "ake", "chronicles", "anh", "matter-of-factly", "cliffnotes", "stagnation", "beetle", "emmas", "skull", "surrealist", "surreality", "macready", "ban", "mockumentaries", "misdeeds", "bee", "beg", "tempered", "peanut", "reports", "starving", "inauspicious", "sylvia", "cloris", "lennon", "alarm", "indisputable", "dadetown", "encouraged", "posit", "yourselves", "rickmans", "granddaughter", "over-familiar", "cab", "cal", "foner", "starry-eyed", "cds", "scribe", "ceo", "flit", "carriere", "chi", "engross", "interrelated", "redhead", "remedy", "elders", "conventionality", "pimp", "ozzie", "seresin", "pine", "brimmed", "segregation", "album", "was=85", "grimace", "rampage", "harrelsons", "intrusions", "banged", "knowingly", "off-stage", "regurgitating", "wilders", "employees", "large-scale", "musing", "soavi", "elevating", "impish", "hustlers", "responsibilities", "dumass", "hires", "feynman", "merivels", "mcglynn", "organic", "$1", "exports", "$4", "preisners", "korea", "puzzled", "maam", "mousehunt", "mace", "mack", "dom", "dou", "extraordinaire", "goodhew", "quicker", "gunfight", "01", "management", "doubtlessly", "winant", "permission", "65", "jean-baptiste", "henri-georges", "71", "72", "78", "mari", "mart", "86", "margarethe", "dumbo", "ebb", "sit-coms", "snapping", "butthead", "shuisheng", "malles", "advisor", "twisty-turny", "cloudy", "punctured", "translations", "lipnicki", "ely", "casinos", "goodies", "avant", "journalists", "malloy", "miscalculations", "balaban", "scrupulously", "luchini", "cent", "novelists", "incompetence", "twangy", "duncans", "cumulative", "over-plotted", "foam", "fascistic", "nominate", "fax", "fay", "unnoticed", "hypnotically", "fei", "negotiations", "spiders", "ondaatjes", "dreck", "feirstein", "aw", "translucent", "boasted", "giovanni", "h20", "candlelit", "foo", "doldrums", "fr", "plow", "murdoch", "007s", "suzy", "lv", "alexs", "ol", "om", "nashville", "beckwith", "kotto", "ra", "masala", "scooby-doo", "b-grade", "unreality", "alfie", "crawford", "insular", "customs", "masochistic", "rodgers", "sanctimonious", "twenty-six", "air-conditioned", "waco", "starkwell", "wags", "adjoining", "banker", "solves", "daves", "knowledgeable", "heaping", "flickering", "subversion", "voting", "structurally", "impossibly", "mccormick", "ex-con", "manchurian", "eagerly", "centurys", "armitage", "quadrant", "definitions", "hos", "plows", "accordingly", "malone", "pearson", "silverman", "beetles", "hue", "thinness", "premier", "frasier", "mena", "indignity", "collaborations", "compliments", "out-of-left-field", "mathematical", "hottest", "whacked-out", "dribble", "ibn", "smokey", "layering", "ida", "touring", "valera", "kadeem", "goldfish", "presidency", "invigorated", "sandrine", "overmuch", "mouthful", "saucer", "poorly-conceived", "isa", "unquestioning", "termed", "burchenal", "chayanne", "ivy", "demonstrations", "best-developed", "rhinos", "cite", "syds", "often-absurd", "churchs", "ninety-seven", "fishermen", "jed", "sync", "enrico", "sparky", "lapaglia", "mild-mannered", "four-", "grates", "fours", "denies", "sharp-edged", "pendleton", "ultra", "mikhalkovs", "usher", "milano", "altruistic", "hissable", "decks", "virgils", "technicians", "decor", "interrogation", "talked-about", "diving", "trickier", "dissect", "shuki", "lucia", "atkinsons", "kin", "mourners", "come-on", "kkk", "heartbreakers", "inflate", "chronic", "seriess", "marrying", "weep", "protege", "substances", "alligators", "self-contained", "kourkov", "invaded", "invitingly", "merciless", "werb", "outshine", "wholesale", "head-shaking", "commies", "lem", "lex", "kwang-su", "lajos", "derring-do", "lawick", "milcho", "contradiction", "forrester", "deeds", "arcane", "gullibility", "monetary", "lavender", "disorganized", "perish", "parfitt", "guarded", "mckay", "goodspeed", "learys", "mat", "warden", "forefront", "crispin", "retreating", "helenas", "post-war", "miz", "valium", "earmarks", "violence/gore", "zealander", "flattened", "gut-wrenchingly", "goldmans", "phenomena", "makings", "omission", "preposterousness", "slansky", "apartments", "cundey", "mettle", "anthology", "gails", "anti-communist", "dishwater", "rounding", "mastrantonio", "pizzazz", "trumps", "nap", "homespun", "nygard", "johnstone", "plump", "henson", "weighing", "bitten", "bradley", "unpopular", "anxious", "irelands", "zondag", "abnormal", "whip", "puccinis", "nyu", "farces", "griswold", "personification", "spanning", "golino", "intangibles", "tuxedo", "baltimore", "brevity", "lamps", "right-hand", "misfired", "bonfire", "preferences", "amateurs", "cohn", "wick", "orr", "drunkenness", "puri", "residence", "bandwagon", "closeups", "starman", "examinations", "corr", "ballerina", "scriptwriter", "cote", "acting-wise", "motorbikes", "paw", "captive", "gunmen", "thought-", "offices", "pee", "peg", "hamill", "crashs", "crumbs", "rabier", "pinks", "poe", "godawful", "droning", "ophelia", "opulence", "drool", "pvt", "baird", "pruitt", "dross", "bitter-sweet", "tact", "baitz", "klump", "whistler", "ruggedly", "underplaying", "gunner", "whalley-kilmer", "interrupts", "pratfall", "unlawful", "alpha", "clints", "casanova", "warm-n-fuzzy", "mccrea", "christensen", "nauseous", "imitates", "pretext", "manufacture", "jeep", "parcels", "cosette", "brialy", "perfume", "hensons", "embodies", "latent", "pomposity", "regain", "scolding", "skating", "reg", "backwoods", "thermometer", "self-confidence", "rig", "rio", "sympathizing", "rko", "baked", "documentarys", "high-pitched", "fixation", "embedded", "stop-motion", "reproduce", "two-headed", "chapel", "provocation", "swordfights", "melodic", "hayworth", "kinda", "watered-down", "meditative", "ackerman", "sap", "adjustment", "hodgepodge", "columbo", "venetian", "skipped", "furrow", "mccurley", "conservatives", "almost-", "skg", "non-violent", "seths", "tsarong", "gregor", "schoolgirl", "netherlands", "itching", "lloyds", "largo", "delta", "creaks", "heartthrob", "mcteer", "frontier", "monochromatic", "dilute", "winstanley", "ripples", "climaxes", "anglade", "three-", "minions", "soren", "showings", "diffuse", "barber", "bobbing", "sparsely", "fantastical", "tautness", "brides", "wallaces", "fabrice", "well-done", "70mm", "goldenthal", "tolkin", "maintained", "teds", "altar", "attwood", "gumshoe", "auschwitz", "udo", "obscenities", "grady", "tens", "1988s", "pruned", "dividends", "wrings", "embellish", "messing", "une", "furnishings", "sepia-toned", "desensitized", "awaited", "pygmalion", "finer", "poseidon", "catastrophic", "radiance", "jiff", "whacked", "engineer", "minister", "boorman", "navigates", "1991s", "befits", "lunch", "anxieties", "double-", "wows", "gasoline", "doubled", "regent", "traumatic", "bullying", "fistfights", "stemmed", "slaughtered", "swearing", "bardem", "ravich", "discreetly", "garde", "rochefort", "absentee", "cacophony", "unnamed", "expressionistic", "wai", "anti-semitic", "gaga", "plaudits", "never-ending", "woe", "high-speed", "snipers", "disrupted", "fishburnes", "graceland", "wwf", "incarnate", "psychiatrist", "rosenblooms", "outerbridge", "barest", "twisters", "inquisitive", "reggie", "monkeybone", "thor", "indecent", "reprehensible", "functionally", "obliquely", "commune", "bolstered", "all-star", "hansons", "decisively", "environmentalism", "eeriness", "domineering", "whiley", "haters", "rosemarys", "take-charge", "caddyshack", "twohys", "greet", "lawns", "tint", "pausing", "gregs", "tangle", "baran", "meager", "vodka", "ericson", "kitty", "cronkite", "dipego", "randolph", "disrespect", "antihero", "clouzots", "auroras", "greta", "veronica", "baron", "arthurs", "slowest", "vierny", "rusnak", "periscope", "takeoffs", "outlandishly", "harrisons", "gymnastics", "costuming", "zaz", "unravels", "debilitating", "misinterpreted", "unkempt", "legions", "grossness", "retort", "lurks", "franklins", "uglier", "rosanna", "heeded", "peppers", "rehashes", "trucker", "province", "layed", "qualification", "25-year-old", "jamaica", "fists", "swipes", "cackling", "gender-bending", "christie", "degeneres", "compounded", "baseballs", "smelled", "frustrates", "colony", "piercingly", "jodi", "briefcase", "humbert", "dragan", "breen", "bowens", "dislikeable", "lelouchs", "lecherous", "fiorentinos", "irksome", "soapbox", "gromit", "dereks", "oscar-winner", "adoption", "intolerable", "investigators", "scrambled", "fluorescent", "luciana", "doris", "damore", "thirtysomething", "child-like", "improvising", "scofield", "maclachlan", "malvolio", "approximation", "walkens", "credibly", "maneuvers", "lectured", "dampen", "goofball", "whoop-it-up", "shrieking", "monogram", "dispensing", "nominally", "charley", "cholodenkos", "upwards", "skipping", "authoritative", "dutiful", "impostor", "trench", "re-cycled", "springboard", "duigans", "kornbluth", "beale", "harkens", "conversational", "veloz", "memorabilia", "thandie", "underdone", "co-starring", "pseudo-realism", "karate", "felicie", "madigan", "deniros", "juans", "sarcastically", "essays", "top-", "apprentice", "weasels", "russos", "tori", "toth", "overdoes", "nelligan", "increased", "increases", "artless", "invoke", "gish", "capra-esque", "well-scripted", "min-yong", "prescribed", "dough", "dueling", "massachusetts", "off-handedly", "horrigan", "wynn", "shekhar", "blanket", "delineation", "alarms", "tissues", "occupying", "nicolella", "sleepwalks", "congressman", "elects", "nurturing", "hairdresser", "busby", "longevity", "adjustments", "persecuted", "damsel", "dane", "loosen", "devising", "dart", "flocking", "conglomeration", "transfers", "hum-drum", "stalking", "specter", "congratulations", "disbelieve", "damnation", "vitamins", "biderman", "tidbit", "uncles", "roache", "yared", "leones", "strolling", "inequities", "madeline", "robbersons", "beneficial", "pre-fabricated", "submit", "brotherhood", "accolade", "judas", "disenfranchised", "yulin", "motherly", "astin", "tray", "fully-formed", "billion", "juha", "unrestrained", "journeys", "arranged", "sidewalk", "jung", "darabonts", "logue", "schizophrenic", "amble", "palumbo", "tract", "jakes", "embarking", "vincenzo", "leuchters", "unveiled", "spano", "bushwhacked", "trumpet", "accord", "goeth", "cheerleading", "cabinet", "groan", "mcnally", "zimmers", "fateful", "rivera", "machinery", "groin", "malones", "torches", "dunbar", "khouri", "naif", "mascara", "berlanti", "plot-by-numbers", "starkness", "wilkinson", "belvaux", "morgue", "yimous", "smitten", "repeating", "updating", "schamus", "complacent", "susanna", "engulfed", "cathedral", "dwarfs", "best-ever", "allegorical", "lizzie", "re-working", "veron", "melvins", "reverie", "sneaks", "sneaky", "chain-smoking", "blofeld", "perverted", "cornell", "barrie", "careens", "palpably", "tube", "delectable", "tamahoris", "slyly", "ethans", "goer", "suspicions", "gogh", "10-year-olds", "agrees", "misogynist", "1000", "turd", "amorality", "disneylands", "junkies", "conjured", "mccullah", "mouthpiece", "presumed", "self-defense", "captivates", "10-15", "pubescent", "mickeys", "statistics", "single-minded", "swamped", "celtic", "fulcrum", "unprepared", "dexterity", "posits", "tread", "choked", "kissinger", "intermingled", "ferrans", "tobacco", "retreat", "controls", "videotaped", "jingles", "interlocking", "grandstanding", "manageable", "starters", "detested", "chalimon", "tobacks", "subverting", "unobtrusively", "leons", "womanhood", "leeway", "purportedly", "childbirth", "influencing", "two-", "ferraras", "spaceship", "prompt", "taunt", "berkowitz", "armyan", "drugged", "pabulum", "ensue", "gemma", "garnering", "jackman", "debauchery", "self-referential", "intonation", "elisabetta", "esoteric", "grad", "tidied", "convertino", "klapischs", "interchangeably", "falardeau", "stairway", "glare", "long-running", "ludwig", "fallout", "burgess", "helens", "insignificance", "forties", "squeezed", "adored", "resists", "dips", "runtime", "lapsing", "levins", "_but_", "salt-of-the-earth", "stand-in", "tinged", "hypocrisies", "excelled", "imamura", "extinction", "indiscriminately", "caviezel", "rabbi", "admirers", "composite", "lindley", "belts", "amiss", "fulvio", "mckenzies", "mormon", "golly", "vengeful", "eraserhead", "godmother", "abortions", "shouted", "julio", "ngor", "annabella", "segals", "persists", "flakes", "eliminates", "jejune", "desserts", "unthinking", "delhomme", "dimly", "mechanism", "magnolias", "officials", "abba", "mother/daughter", "physician", "sethes", "glittering", "prolonged", "haircuts", "sizzles", "manufacturing", "bends", "prettier", "scooter", "penetration", "misuse", "disillusionment", "recruits", "appliances", "co-directed", "self-made", "freeing", "openings", "14th", "chopin", "beholder", "scraggly", "castros", "aces", "ramble", "pornographer", "confining", "exemplifies", "sparseness", "misgivings", "voyager", "atypically", "verbinski", "wallflower", "smattering", "razieh", "renderings", "geres", "menagerie", "yeller", "goofs", "defended", "drawbacks", "earps", "bloomers", "dissecting", "poised", "smoothed", "mathew", "bolts", "carbon", "self-actualization", "crowd-", "modeling", "kahn", "prosky", "televisions", "elizabeths", "pixars", "pierce-roberts", "kauf", "heart-felt", "supremely", "prehistoric", "kayo", "axioms", "flattery", "serpentine", "tv-movies", "macys", "costa-gavras", "ninety-plus", "suspended", "birthing", "respectability", "rappeneau", "cheap-looking", "dock", "1920", "1934", "distill", "1955", "1959", "bicentennial", "victoire", "hard-core", "marking", "desmond", "liars", "militia", "sizes", "insure", "dictum", "deleon", "protesting", "lotus", "ribbons", "insomniacs", "semi-documentary", "wolverine", "teutonic", "enigmas", "trimark", "koteas", "best-loved", "sheedys", "alleyways", "cubicles", "ineffectively", "ardent", "prochnow", "neophyte", "dichotomize", "dunnes", "quintet", "lauded", "comic-book", "booze", "pathology", "splashy", "trivialized", "beset", "schub", "waffles", "testud", "sheffield", "send-up", "epiphanies", "discipline", "onstage", "adeptly", "remedies", "complicate", "zipping", "drifter", "psychlos", "postal", "escaped", "spook", "sponsored", "litter", "deschanels", "poirier", "tunnels", "swarming", "majors", "estimate", "walon", "jetsons", "ditch", "beths", "foghorn", "star-studded", "racked", "garfield", "dzhordzadze", "betsy", "burdens", "enabling", "salome", "fireman", "ruddy", "mcneely", "admirer", "dosage", "rudin", "prieto", "tickles", "daunting", "airs", "shaimans", "airy", "whack", "jazzy", "softens", "prettiest", "beggar", "meurisse", "wrought", "gough", "figment", "jacobis", "georgia", "darkman", "insanely", "bernsteins", "blitz", "ventured", "zielinski", "life-", "artificiality", "prophecy", "cringe-inducing", "reaper", "5/11/97", "colorless", "bossa", "muttering", "intercut", "herbert", "light-weight", "benedict", "tweaking", "gladiators", "year-end", "printable", "sizzling", "bartkowiak", "long-winded", "blaring", "botch", "hummable", "pathological", "topping", "dickson", "rufus", "much-publicized", "fences", "dinsmore", "relation", "piqued", "mid-80s", "hypocrites", "shagged", "dung", "debney", "nebulous", "duos", "quaids", "trippin", "guggenheim", "emma-kate", "cowards", "pursuers", "tomlin", "touchy-feely", "overplays", "alls", "lesley", "organizations", "dryden", "eberts", "tempo", "through-line", "pauper", "katzenberg", "fatalism", "consumerism", "freedoms", "completeness", "untalented", "girard", "1700s", "kits", "carlito", "lazebnik", "spiral", "recreating", "shatner", "pleasence", "mcneice", "verify", "joely", "distinctions", "appropriateness", "goldenthals", "107", "ensure", "122", "123", "137", "140", "manifestation", "yakins", "iscove", "discrepancies", "diffuses", "debont", "amok", "wheat", "pascale", "pascals", "cement", "joffe", "goyas", "hamm", "hams", "tommys", "hana", "devise", "inhibitions", "hairs", "stacks", "anti-religious", "guinness", "malli", "truer", "hare", "anal", "unleash", "exasperated", "self-promotion", "setter", "strapped", "raunchier", "mechanisms", "improvise", "roguish", "award-winner", "slated", "mnemonic", "slow-paced", "instructions", "wavered", "wrapper", "decaying", "enforcer", "bosnian", "hitter", "reflexive", "nonplussed", "begley", "prisons", "preordained", "humanitys", "lorraine", "cruising", "one-hour", "s-l-o-w", "re-writes", "stack", "intimidated", "prescient", "staff", "webbers", "klux", "disembodied", "impossibles", "mania", "do-right", "sierra", "manly", "unparalleled", "manor", "chronologically", "undue", "apex", "diseases", "2nd", "meaneys", "parades", "boughedir", "tykes", "ascend", "guidos", "paradis", "claires", "waiter", "adoration", "johann", "almost-documentary", "cuesta", "delons", "boyce", "rack", "definitively", "coupling", "nielsens", "locally", "salwen", "decorated", "rhett", "scrap", "locking", "rarer", "stumped", "departed", "rash", "flipping", "sweeter", "raul", "subtitler", "decorator", "primos", "narrow-minded", "biggs", "retitled", "self-deprecation", "miyazaki", "testify", "handicaps", "underhanded", "coyotes", "knob", "nit-picking", "testing", "tooth", "recognizably", "awaits", "cops-and-robbers", "beaumont", "whine", "herz", "arau", "comedy/romance", "joyless", "arcs", "formation", "respecting", "marries", "rumored", "koch", "caked", "cakes", "aria", "infuriate", "suvaris", "plot-heavy", "vickie", "4th", "tryst", "arne", "sleepwalk", "leeches", "on-stage", "bullies", "constricted", "glacially", "play-by-play", "hanna", "joker", "stubbs", "plumbing", "jousting", "payoffs", "duration", "antique", "conchita", "macmurray", "sizemore", "alexis", "asia", "munching", "747", "linus", "faiths", "drones", "osborne", "slow-witted", "attuned", "steak", "steer", "discovers", "debuts", "promotes", "stein", "cloaked", "ramsay", "ill-developed", "weber", "heretical", "schaeffer", "retirement", "pinter", "jolts", "detention", "rescued", "low-rent", "perpetrated", "untimely", "nebbish", "shunned", "toros", "diagnosed", "scheinman", "contend", "vituperative", "braschi", "portend", "diagnosis", "interviewees", "wellman", "modernized", "pandolfini", "wizardry", "musician", "pronouncements", "dime-store", "deneuves", "unity", "djimon", "thirst", "bikes", "boozing", "itami", "reappear", "book-to-screen", "poseurs", "hangout", "canny", "intern", "irresistable", "revived", "nickelodeon", "escoffier", "mcavoy", "off-guard", "orgasm", "barreto", "symptoms", "prosecution", "intricacy", "petulance", "enforcement", "wreaking", "dealings", "rears", "knees", "unrepentant", "matty", "second-tier", "deluge", "near-masterpiece", "peckers", "laboriously", "bruised", "in-laws", "jewisons", "weebo", "caresses", "regions", "wincott", "online", "viability", "svelte", "gestapo", "tensions", "stallion", "gallimards", "arrighi", "buoyant", "mouthed", "tightrope", "olins", "writer/director/producer", "texts", "disintegrate", "octane", "terrors", "eliciting", "fervent", "consenting", "well-focused", "carved", "bubbles", "feasible", "countenance", "burglars", "burglary", "beauties", "stamps", "novalyne", "obscenity", "mcferran", "parrot", "recut", "khyentse", "backlit", "rushs", "kuhn", "procedures", "emaciated", "jetee", "jeter", "catholics", "cornerstone", "pyromaniacs", "chekhovs", "presentations", "meringue", "carefully-constructed", "caton-jones", "interviewing", "cheri", "dichotomy", "purports", "cheadle", "superrich", "rite", "redux", "akerman", "civilizations", "razor", "abbott", "=96", "concocts", "heavyweight", "intrude", "critically-acclaimed", "pulverize", "barring", "bacall", "yakuza", "jorge", "pittsburgh", "foisted", "fast-moving", "nightwatch", "successive", "didier", "monitor", "mechanically", "murph", "typified", "co-creator", "dispassionately", "grasshopper", "freshly", "infinite", "polansky", "liver", "purchasing", "murata", "garance", "baigleman", "brynner", "structuring", "spurting", "mcenery", "medem", "booming", "tailored", "auto-pilot", "rachael", "camilla", "naughty", "falcons", "plunkett", "heath", "masterwork", "sharpened", "podeswa", "seductively", "thomson", "harbors", "broadcasting", "glamor", "automaton", "mckenzie", "gayton", "kruegers", "manic-depressive", "far-out", "perversely", "annihilation", "despairing", "thrilled", "multi-dimensionality", "androgynous", "heartland", "crooklyn", "torrential", "rehab", "sprinkling", "strippers", "simplified", "prudish", "metcalf", "unglamorous", "scriptwriters", "frenzied", "boulder", "chili", "heartbeat", "colleary", "pubic", "talkin", "lovelier", "djinn", "clarissa", "coattails", "eliot", "worshipful", "post-modern", "barefoot", "wayland", "yank", "eliza", "watergate", "his=20", "gleeful", "victimized", "compulsion", "manoel", "unsympathetically", "stardust", "genteel", "hutchinson", "hatcher", "stool", "stoop", "prized", "extolling", "snubbed", "mohammadkhani", "stumbled", "invaluable", "wallows", "glassy-eyed", "megan", "disoriented", "multimillion", "sequined", "westworld", "heches", "imperfections", "modes", "objectively", "pseudo-", "moslem", "moffat", "prevented", "roma", "hyperbole", "abstinence", "rona", "rope", "halcyon", "dazzlingly", "harley", "impersonation", "rowe", "consulted", "lascivious", "miniature", "professes", "soared", "wrinkled", "adler", "finance", "venerable", "cribs", "beneaths", "swanson", "shannon", "internalized", "ellin", "slapped", "rewritten", "luscious", "forged", "immoral", "pianist", "baer", "reincarnated", "cleared", "distorts", "indeterminate", "chekhov", "catalogue", "bana", "smacking", "shepards", "straw", "schlesingers", "bumped", "broached", "swindle", "blunders", "marleen", "sexuality/nudity", "figgiss", "studded", "categorized", "frosted", "delusion", "brightest", "ohio", "pastels", "inmates", "bemberg", "hodge", "malleable", "conniving", "assessment", "bisexual", "time-", "gizmo", "out-and-out", "hull", "absurdities", "terrance", "impediments", "hurl", "transcendence", "outage", "initiated", "mogul", "resurrected", "restlessness", "well-staged", "delusions", "ornate", "dragojevic", "passione", "elsa", "envisioning", "sluggishness", "plains", "hotbed", "rockefeller", "valjean", "banging", "well-deserved", "excused", "plastered", "spliced", "personalize", "scheduled", "prattle", "initiation", "emil", "woeful", "taurand", "artwork", "heidi", "inhuman", "suburbs", "cotten", "sketchily-developed", "comforts", "nagiko", "lait", "fernandez", "lalo", "subtitling", "cochran", "soavis", "reinforced", "bandage", "stuhr", "maggenti", "unwavering", "audiard", "disagreed", "melts", "ushers", "watery", "innate", "fertility", "sexton", "maneuvering", "watered", "mcgehee", "bela", "nelsons", "pallet", "juvenal", "zentropa", "bess", "employer", "marbles", "giraudeau", "unforgettably", "dreamers", "gunslingers", "corbiau", "grounding", "reassures", "rung", "flouts", "extra-terrestrial", "edmund", "gaines", "bloods", "cheaply", "algerian", "competing", "kanes", "unstoppable", "assignments", "prank", "concur", "rantings", "polemic", "personable", "bodybuilders", "gwenn", "well-cast", "prays", "rumbling", "awakened", "steers", "fernanda", "busting", "defeats", "vilsmaier", "benchmark", "condon", "reluctantly", "dismayed", "unmatched", "assertions", "gaffes", "konrad", "pared", "molds", "astronomer", "transitional", "whiz-bang", "twaddle", "cherished", "upsurge", "scintillating", "photographing", "sorrento", "idrissa", "imaginatively", "zwicks", "parse", "maltese", "elaborately", "animalistic", "receiver", "isaacs", "lear", "nobles", "portends", "murnau", "denkers", "cohesiveness", "degenerated", "previously-mentioned", "clarks", "enables", "pancakes", "nationwide", "sacrosanct", "stupefying", "leos", "ruminations", "generalization", "autistic", "discrete", "babettes", "jagger", "fridrik", "scarred", "rymer", "chiseled", "tumble", "womanizer", "sputter", "amazon", "preserving", "doubtfires", "go-go", "down-to-the-wire", "fooling", "tiggers", "nadeau", "battered", "bink", "reigned", "snowman", "salesmanship", "dianne", "mitchells", "jupiters", "mitterrand", "four-legged", "cavalry", "showcasing", "aloofness", "maclean", "achingly", "stabiles", "near-future", "aching", "twenty-minute", "armpits", "jean-francois", "hermans", "inter-racial", "espn", "hounsou", "dreamworkss", "karey", "albanian", "gibraltar", "discernable", "merge", "uneasiness", "karls", "befitting", "heiress", "blemished", "furtive", "unfathomable", "pauls", "strove", "clinically", "breakup", "sell-out", "papamichael", "distracts", "escapade", "sniff", "cammell", "pamphlet", "wheeling", "infuriated", "elliots", "slowed", "pavel", "unsolicited", "unmasking", "pedophile", "shoot-em-ups", "schlocky", "continual", "petrie", "swamps", "pressfields", "rippling", "clays", "ageless", "beauman", "omalley", "cross-cutting", "revue", "spin-off", "lied", "outweighed", "lieu", "messes", "arduous", "edgier", "nastier", "kamens", "sadie", "holzman", "abstractions", "lila", "bearded", "authorities", "continuum", "loathsome", "lima", "lina", "yost", "pouting", "implant", "yous", "cavorting", "inanity", "annauds", "expatriate", "blender", "caines", "riddler", "documentary-style", "coles", "unease", "odious", "berger", "murdering", "biological", "daydream", "steadman", "oliveira", "clears", "deputy", "spectators", "near-subliminal", "borman", "angies", "ponceludon", "polemics", "antons", "herve", "insincere", "purge", "faulkner", "overcrowded", "sophies", "capshaw", "fumes", "jovovich", "webber", "marias", "prima", "cribbed", "rosina", "abiding", "low-profile", "dulled", "maries", "camilles", "actor/director", "outstrip", "mayersberg", "ricki", "subsequently", "reigns", "one-quarter", "warhols", "flavored", "sandgren", "ossie", "biceps", "befuddling", "soft-focus", "marius", "gargoyles", "afterschool", "bimbos", "jolies", "hedonistic", "interchanges", "demille", "bode", "condoms", "partnership", "impersonations", "stench", "savagely", "bona", "streeps", "oswald", "pencil", "outs", "alterations", "life-threatening", "anastasias", "enriquez", "pursued", "rowan", "atherton", "overtaken", "icky", "unspeakable", "oval", "invoking", "unconscious", "redemptive", "chinese-american", "hushed", "endeavors", "eligible", "conducts", "wheelchair", "fauna", "marketing-friendly", "degraded", "kuras", "krabbe", "sermonize", "cervi", "peels", "pitches", "revolt", "cock-eyed", "saddened", "pre-credits", "amelia", "abandonment", "four-letter", "salacious", "promotions", "suture", "sage", "horta", "kriel", "gullette", "breathlessly", "instructs", "pleads", "formerly", "shocker", "copes", "prominence", "homeland", "who-cares", "livelier", "ferran", "hyper", "wreaks", "unholy", "application", "eavesdropping", "creepily", "sucka", "unglued", "orangutan", "intelligible", "rationality", "twentysomething", "inarticulate", "sherilyn", "brag", "too-pat", "bras", "yuck", "sickly", "boomerang", "descendent", "bret", "hyped-up", "midge", "confessing", "chaotically", "stoner", "scar", "stalwart", "lori", "feckless", "belgium", "piling", "bobbys", "expectedly", "loners", "giacomo", "cockroach", "echoing", "navel-gazing", "arleen", "apparitions", "tamasy", "prompting", "tenants", "courses", "marner", "judgement", "reside", "wrap-up", "tweed", "idols", "heavier", "heavies", "greenhut", "garofalos", "vanities", "alcott", "pledge", "sudina", "mariner", "corresponding", "seydor", "uncountable", "stantons", "salen", "upsets", "dissolute", "soldat", "yo-yo", "overstay", "panders", "wednesday", "kurtzman", "espouse", "conditioned", "pollacks", "indistinguishable", "salvo", "guileless", "penning", "ignites", "australias", "mannerism", "conroy", "traffics", "accustomed", "serras", "projecting", "merivel", "complimenting", "doggie", "gimmickry", "mcmahon", "flirts", "mythos", "implicit", "burnstein", "mayday", "shady", "fervor", "universals", "camara", "peppering", "cough", "descending", "lumber", "secrecy", "_thats_", "broughton", "juergen", "embry", "short-circuit", "lubezki", "reversed", "cyril", "replicate", "belabors", "adoring", "unapproachable", "smarts", "swooping", "one-night", "passionless", "zonca", "vessel", "thirty-five", "guasparis", "falk", "europa", "inventor", "ahmed", "triteness", "snuff", "originating", "conceptual", "preconceptions", "riley", "navigate", "overhearing", "derogatory", "janine", "arliss", "crescendos", "schiffer", "mid-air", "tantrums", "curdling", "potente", "discerning", "presley", "cowan", "overshadows", "perseverance", "mantello", "catatonic", "shum", "basement", "kuzco", "suffused", "lung", "siam", "limitless", "mutants", "alcatraz", "sorcerers", "glitter", "grumbling", "mobster", "plainly", "muhammad", "malady", "ilsa", "muller", "deduction", "indications", "action-adventure", "roster", "jefferies", "schmidt", "consolation", "norville", "tolstoy", "blinding", "anti-septic", "forsaken", "frogs", "shear", "prophetically", "conrads", "conway", "dumbness", "over-reliance", "spaced", "philadelphias", "lucian", "disgustingly", "twosome", "felicity", "millennial", "scrutinized", "fizzle", "sleeper", "gunshots", "kaplans", "ruehls", "unemployed", "palm", "coyle", "natascha", "ritualized", "ducts", "scrape", "armin", "attested", "pampered", "info", "maneuver", "wired", "unruly", "inconsistently", "portraits", "constructs", "well-being", "bogarts", "zauberman", "mis-matched", "dudes", "contemptuous", "hortense", "foggy", "mercies", "tykwer", "seasoning", "violates", "scorpions", "tenure", "well-spent", "pristine", "fend", "capped", "dampens", "shreds", "dumbed-down", "khleifi", "fest", "josies", "mimmo", "recast", "mainland", "dickensian", "pageants", "kopelson", "wiser", "sled", "aversion", "mcmillan", "mis-guided", "klass", "fullest", "redeemable", "revisited", "zachary", "true-crime", "sancho", "slob", "iota", "humane", "iowa", "tracey", "tropical", "backside", "simonds", "cauldron", "gibbons", "aroma", "lyne", "lustful", "encountering", "illuminate", "halves", "banana", "beckinsale", "painstaking", "unrivaled", "stefano", "clones", "romero", "foils", "rubbed", "stiffs", "dwarfed", "sauce", "pooch", "saucy", "zaks", "architect", "obligation", "obliterated", "romanticize", "assaults", "loughery", "montgomery", "caligari", "_the", "ponderously", "cheered", "neesons", "dugan", "jeremiah", "bureaucrats", "closeup", "printing", "pretension", "irresponsibility", "quinns", "cleric", "unchanged", "billowing", "commonality", "nihilism", "pryor", "volleyball", "belonged", "joffes", "inescapable", "nonchalant", "stomach-churning", "gatherings", "screws", "signifies", "waxing", "breeds", "flipped", "finely-realized", "co-worker", "fide", "herrmanns", "fellinis", "teaser", "hinds", "danni", "drive-by", "processed", "unafraid", "representatives", "postulates", "halloweens", "fina", "balances", "freaking", "danza", "incomparable", "epigrams", "disallows", "seans", "commotion", "critic-proof", "encyclopedia", "tammys", "contemplative", "one-third", "clunk", "notepad", "isle", "repulsed", "folds", "repulses", "ada", "blueprint", "publishing", "bradbury", "frivolity", "endowed", "aki", "backstabbing", "feore", "ana", "binoches", "incompleteness", "ari", "confides", "rubell", "ava", "swells", "tasteful", "kingdoms", "capt", "withdrawn", "caro", "ever-so-slightly", "playwrights", "hoggett", "mirkin", "spanned", "marched", "dismissive", "intercourse", "slamming", "kirkpatrick", "surly", "lunatics", "tremors", "blaustein", "functioning", "biz", "comparative", "presume", "waterfront", "economically", "skinny-dipping", "aftertaste", "bellegarde", "bum", "manhood", "sexiness", "zeus", "clearly-defined", "collegiate", "flab", "oversized", "yuppies", "dashes", "blank-faced", "flex", "discount", "attorneys", "travail", "twinkle", "winningham", "pics", "kovacs", "laurens", "flash-forwards", "newsies", "cornered", "seller", "mottolas", "horsing", "video-game", "pins", "lameness", "dempsey", "hesitate", "explosiveness", "flux", "villainess", "unavoidable", "plummet", "pits", "darby", "hispanic", "microsoft", "assuredly", "dared", "interacted", "feigns", "blouses", "daria", "dario", "stewardess", "tissue", "devastated", "dax", "zuckers", "flirtatious", "voters", "hillbilly", "potts", "exhaustion", "dey", "buddhism", "marching", "#4", "dip", "$6", "splatters", "korda", "koontz", "exhaustive", "grande", "dna", "gutter", "model-turned-actress", "zaillians", "unwitting", "hirst", "enlisted", "dub", "dug", "recollection", "recite", "malt", "durning", "gatins", "confinement", "emerson", "3d", "well-played", "beavers", "subside", "fakery", "69", "73", "mare", "hilmar", "81", "84", "rulers", "x-ers", "plaintive", "whence", "maud", "spotting", "thuthob", "ad-libs", "maya", "eel", "fairbanks", "salwens", "smithsonian", "ringwald", "hairstyle", "zimmerman", "shook", "stressed", "transcending", "leaked", "guitarist", "prentice", "fests", "shove", "mallon", "internment", "humanly", "eva", "rubins", "widens", "compounds", "almeida", "novelist", "gnawing", "stage-to-screen", "deterred", "condemning", "half-naked", "mind-numbingly", "thought-out", "forcefulness", "dionisi", "hitch", "serling", "delineated", "craigs", "oregon", "readiness", "strangulation", "materially", "fig", "ladro", "ag", "ai", "quack", "ax", "bg", "armitages", "puffing", "ce", "ck", "flo", "dc", "ds", "triple-crosses", "dispense", "fop", "fetus", "rocketeer", "deserts", "ge", "blisteringly", "fort", "wincer", "winces", "hemingways", "hillary", "unpleasantness", "riegert", "disguising", "ll", "ls", "corman", "dimwitted", "zips", "unsafe", "mi", "mo", "back-brain", "foyt", "devincentis", "pu", "seinfeld", "re", "ro", "grousing", "lauries", "linchpin", "sh", "si", "film-going", "ts", "drews", "gabor", "uh", "mindlessness", "compatible", "spinottis", "expressionism", "gab", "needy", "expressionist", "enveloped", "donkey", "gaz", "lovecraft", "rosettas", "lappin", "smelly", "suschitzky", "hassan", "lifting", "gig", "metaphysics", "git", "captives", "allegiance", "frenais", "bustling", "duchau", "placido", "demonize", "iridescent", "gatlif", "clowns", "pretended", "revolved", "fitted", "shan-yu", "relegate", "cockiness", "flips", "wail", "swap", "cisco", "sway", "cornel", "austins", "manifested", "valdes", "pimples", "flits", "ronnow-klarlund", "wand", "wane", "hustling", "sematary", "00am", "insinuating", "duped", "pacifism", "pacifist", "manifestly", "two-pronged", "watt", "holdens", "unavailable", "acheson", "fereshteh", "congenial", "nausea", "chao", "chat", "hid", "hiv", "tequila", "oceans", "shaving", "invisibility", "prague", "nudging", "boasting", "gregorys", "hut", "chon", "pnub", "ben-hur", "faking", "detrimental", "culprits", "literalist", "humiliated", "bolton", "gaggle", "eviscerations", "seize", "twenty-two", "fray", "28-year-old", "mets", "giddiness", "zylberstein", "straight-forward", "recites", "mothersbaugh", "rat-a-tat", "sprawl", "fairuza", "goldfine", "slo-mo", "valery", "ike", "stridently", "non-musical", "sxsw", "winslets", "spheres", "ropelewski", "occupants", "ethic", "exodus", "impersonal", "rattigan", "luthan", "recovered", "avert", "fiber", "scacchi", "frye", "brandos", "lame-brained", "shuffle", "degrade", "dichotomized", "lowensohn", "fisherman", "duran", "hydrogen", "jai", "alibi", "triple-digit", "spares", "carrillo", "gilligans", "hazing", "fidget", "trudging", "brolin", "overtime", "fiftieth", "enrich", "maibaum", "nightclubs", "publicist", "gutersons", "appease", "torsos", "bachs", "astonished", "shilliday", "astonishes", "mackinnons", "blather", "birmingham", "intelligently-written", "vitales", "high-octane", "necessities", "disparaging", "bunyan", "condemns", "chubby", "kiarostamis", "banner", "horn-rims", "fixate", "surfer", "talkers", "slogging", "colombians", "resisted", "mazzello", "mock-documentary", "germane", "rationalization", "excites", "underprivileged", "hyperspace", "reitmans", "lucie", "orderly", "neils", "kia", "kip", "poodle", "gerrys", "freemans", "nixons", "dizzyingly", "all=20", "contacts", "fireplace", "lurching", "donors", "5/7/97", "dedee", "unashamedly", "morsels", "cameroon", "clayburgh", "entendre", "unspecified", "unfailing", "sword-and-sorcery", "weis", "irrelevance", "welt", "crucifix", "weirdo", "potently", "sensationalize", "sebastians", "lag", "wombat", "good-humored", "energizes", "hungarian", "pre-", "rationalizations", "len", "whores", "backstory", "criticizes", "vancouver", "clad", "clap", "entertainingly", "lis", "lix", "semen", "granddaughters", "prim", "semi-", "clea", "fund", "toe-tapping", "funk", "upstaging", "triviality", "sainthood", "decreased", "completing", "dobbs", "substituting", "completion", "amateurishness", "seiler", "shrugs", "obsessive/compulsive", "integration", "all-but-forgotten", "defenseless", "miki", "pickings", "_supposed_", "deena", "wibberley", "mire", "caricatured", "re-creations", "1900s", "mae", "cybill", "mao", "healer", "mcg", "targeting", "floorboards", "stripped-down", "tangentially", "chomping", "monogamy", "menage", "helgenberger", "hyper-real", "generator", "vegetables", "mid", "selves", "earth-shaking", "porous", "repulsion", "cmdr", "ejogo", "verlaine", "coworkers", "dress-up", "downtown", "abomination", "mop", "mox", "widely-spaced", "cleveland", "dependence", "omelet", "menaul", "greats", "trotted", "mus", "inexpensive", "healthier", "engendered", "patterned", "doughboy", "moralize", "garofolos", "flown", "hoarse", "santas", "sickened", "sociopathic", "johnstons", "lally", "plumb", "middle-age", "upside-down", "regains", "disability", "cajole", "unconventionality", "nhl", "solar", "classically", "jaya", "jays", "skywalker", "non", "mailed", "scissors", "whet", "varma", "bad-boy", "iceland", "lamas", "impelled", "puddle", "quietude", "follower", "paroxysms", "_what_", "excalibur", "starlet", "southerners", "quietness", "sinead", "colorization", "daughter-in-law", "connellys", "re-interpreted", "travelling", "rivalries", "nicely-developed", "one-tenth", "puff", "unearths", "self-aggrandizing", "whys", "ois", "severance", "coco", "spawns", "three-minute", "coolly", "out-of-shape", "ole", "book-type", "bio-pics", "moguls", "turkeys", "lothario", "oph", "ops", "immortals", "latter-day", "duckling", "coos", "yorgos", "pantomime", "louises", "pantomine", "cort", "boyhood", "latcho", "wile", "confirms", "cardoso", "wilt", "laney", "fraternal", "impatience", "rebelling", "emmets", "orphanage", "anchoring", "fraisse", "mendel", "mendes", "self-consciousness", "fortuitous", "pip", "lawman", "ear-to-ear", "leaven", "calypso", "freshest", "non-euclidean", "discordant", "housesitter", "buries", "sonja", "grandmotherly", "non-believers", "pup", "marginalized", "spider-like", "gaetano", "divoff", "sprint", "first-timers", "redemption-hungry", "whistles", "aubrac", "tags", "interweaves", "snootles", "misogyny", "bulworths", "homemade", "slept", "chants", "rehearsing", "klutz", "ozus@sover", "serbs", "illegally", "honeymooners", "invade", "greeks", "miette", "inebriated", "x-ray", "crowd-pleasers", "rubbery", "treaty", "imitated", "gruesomely", "noelles", "mafioso", "dull-witted", "thermal", "petrycki", "baby-sitters", "syndicated", "awfulness", "hardens", "checkmate", "embodied", "wiseman", "co-produced", "suitors", "trade-offs", "ancestor", "rep", "ticklish", "kimmy", "jess", "jest", "regans", "dessert", "ric", "budweiser", "fujimoto", "like-minded", "augment", "rot", "defensive", "crib", "burkes", "salvageable", "blessings", "dangereuses", "castmates", "stabbings", "vacationing", "narrowly", "letdowns", "ennobling", "herbie", "martini", "peeing", "jungles", "ryu", "approximates", "ofallon", "plateau", "redfords", "gay/lesbian", "predicated", "koltai", "sal", "sar", "victors", "fatally", "kinka", "bumping", "lukes", "scurries", "fargos", "kaleidoscope", "tanaka", "protocol", "arched", "trashes", "sil", "somebodys", "downfalls", "swigging", "dillane", "delay", "darting", "level-headed", "credence", "sop", "columns", "lifelong", "centuries-old", "sinatra", "wordplay", "pyun", "fester", "scandalous", "bricks", "massage", "riffing", "curling", "overwritten", "bostonian", "epilog", "baxter", "georgi", "cusacks", "tao", "scramble", "modified", "repressions", "ill-timed", "invalid", "clarice", "rigorous", "stringing", "almost-poetic", "trusts", "multiply", "tex", "kvirikadze", "enviable", "enemas", "dapper", "multifaceted", "11-year-olds", "malapropisms", "seduced", "toyomichi", "appetizers", "rydell", "_like_", "saddles", "lathan", "shivers", "homeward", "page-turning", "avalon", "re-think", "anabella", "quota", "howlingly", "melrose", "[warning", "gump-like", "bhaji", "covert", "handkerchief", "sandras", "rochester", "1983s", "nyman", "tacks", "beaulieu", "hyperbolic", "heckerlings", "rubbing", "patons", "perrin", "hamburgers", "over-long", "peeled", "claptrap", "egomaniacal", "dissected", "homogenous", "lucilles", "high-minded", "uwe", "schlondorff", "capitulate", "alliances", "airheaded", "capulets", "father/daughter", "captors", "lecontes", "musters", "navigated", "abetted", "baby-faced", "eye-rolling", "heresy", "slavishly", "solidarity", "macphersons", "sistance", "warmer", "frills", "ascribed", "somers", "1998s", "vhs", "1600s", "vic", "sewer", "cattle", "expired", "perpetuate", "pedestals", "klausner", "counseling", "devolve", "formulating", "polluting", "dolan", "archived", "jabbas", "trumpeted", "investigates", "rozemas", "goldbacher", "catcalls", "rupaul", "witticisms", "antitrust", "expletive", "whimsically", "crusty", "break-neck", "intercutting", "edgefield", "nervously", "abacus", "investigator", "derailed", "colesberry", "wagners", "wah", "chunky", "discard", "dismisses", "norbu", "chatty", "teen-age", "fiore", "garth", "deterrence", "kirks", "startle", "brisville", "punish", "filmgoer", "titular", "geller", "gall", "posterity", "airwaves", "thunderheart", "pintilie", "norma", "aimee", "gape", "flamberg", "scotch", "garw", "kelsch", "ruefully", "weirdest", "walkouts", "norse", "kelsey", "morphin", "palestinian", "thai", "off-season", "self-aggrandizement", "unmasked", "schoonmaker", "vibrancy", "dogfights", "impassive", "scotty", "missionary", "nosed", "gumps", "jalsaghar", "daniela", "appetizing", "termites", "multi-character", "patron", "muck", "brava", "all-male", "brawn", "misdirection", "solitary", "out-of-the-way", "persecution", "rescuing", "predisposed", "sluggishly", "adorably", "granger", "uplifted", "incognito", "xxx", "tian", "mischa", "valued", "lookin", "screamed", "superimposed", "margins", "starved", "guardian", "donny", "speedboat", "squares", "mutt", "expressiveness", "4-10", "shlock", "starlight", "negate", "juices", "clunkers", "noggin", "unfulfilling", "bared", "inclinations", "split-screen", "pseudo-profound", "delaurentiis", "gonzalo", "deric", "ambulance", "yue", "plunder", "hwangs", "paradoxical", "thunderstorm", "derns", "bulky", "eagerness", "kinskis", "duchovnys", "18-year-old", "alcotts", "regrets", "missions", "snowstorm", "all-too-common", "retold", "thunderstorms", "angelenos", "detracting", "rubber-faced", "maximilian", "firth", "ordering", "mutilation", "roseanne", "pixie", "contracts", "amelios", "dryer", "aristarain", "bases", "time-lapse", "an=20", "taczanowski", "jacek", "jacey", "playboys", "seized", "rotund", "dryly", "cadiff", "montel", "rather=20", "attributable", "whiner", "oddjob", "drummer", "warchus", "billingsley", "rappers", "warmest", "unsung", "vyacheslav", "andronicus", "handsomer", "girlish", "discern", "prosthetics", "propulsive", "force-fed", "salivating", "treacle", "sorting", "collectively", "tails", "pootie", "bigelow", "torpedoes", "clinging", "elated", "oedipus", "sniping", "simpleton", "sagging", "tacked-on", "assemblage", "hesitation", "joao", "institutions", "danforth", "lazar", "rustling", "baring", "broulard", "plantations", "etienne", "extravagant", "viveca", "sigel", "canister", "trunchbull", "do-gooder", "buenos", "fatigued", "jackals", "tovoli", "joni", "accomodate", "silvestris", "misspent", "communal", "analyses", "embodiment", "aires", "uncontrolled", "authentically", "electra", "deuce", "lawsuit", "doras", "dangerfields", "hateful", "mtv-style", "pander", "mid-point", "tapeheads", "seventies", "fatuousness", "deeply-felt", "constitute", "animator", "for=20", "offender", "low-angle", "goings", "cunningly", "ninety-", "foregone", "palance", "niccolo", "niccols", "yangs", "spying", "littlest", "bilongo", "sensually", "mano-a-mano", "italys", "recounts", "scruffy", "lawnmower", "vegetarianism", "semidocumentary", "ffynnon", "deven", "copenhagen", "genetic", "heating", "journals", "pg-rating", "milton", "screw-up", "aisle", "mindscape", "palestinians", "wwfs", "lapoirie", "story-wise", "engines", "lizards", "hipper", "dramedy", "devoe", "exorcising", "locks", "jagloms", "flaherty", "post-world", "cityscapes", "tornados", "cobbled-together", "doubted", "animate", "kerrigan", "undeserving", "antonymic", "taxing", "herzfelds", "isaak", "repressive", "top-rate", "felicia", "high-level", "exaggerations", "warming", "revelry", "hickam", "gutch", "mis-used", "lightened", "improvisations", "tamed", "offensively", "weiland", "first-person", "disabuse", "scrutinize", "puerile", "publish", "vigilantism", "sinbads", "sarone", "orfani", "stiefel", "wenderss", "empathizing", "pfarrer", "potatoes", "suspiciously", "scratched", "gino", "horton", "world-weariness", "stimulation", "interplanetary", "caravan", "senorita", "double-dealing", "storywise", "bowies", "advocating", "lovett", "swimsuit", "phoniness", "modernize", "illustriously", "myrick", "snarky", "snarls", "burma", "professions", "17-year-old", "vivien", "entices", "rustic", "update", "isabels", "color-blind", "quantum", "insisted", "swooning", "brink", "splotchy", "technologies", "diced", "tennessee", "gideon", "cloyingly", "bayer", "overlap", "sleazeball", "tanya", "buses", "limply", "britisher", "drugged-out", "damp", "doves", "rathbone", "unnecessarily-long", "white-", "dans", "high-voltage", "mirandas", "contenting", "looses", "takers", "slugs", "well-endowed", "confidant", "but=20", "wreckage", "smartly-written", "slump", "unconscionable", "self-inflicted", "mounds", "cornwall", "_ever_", "scrapes", "magnificence", "overly-", "mildreds", "agrado", "demonstrative", "silky", "batteries", "pro-choice", "sayeed", "balletbo-coll", "subscribes", "snowscapes", "sternberg", "seldoms", "calopresti", "bromell", "notches", "lucifer", "gizella", "teetering", "parallelism", "snatch", "leonor", "mounts", "geppetto", "logan", "zorans"};
	//3000--public static String[] bigramList={"films-year", "see-film", "motion-picture", "film-excellent", "movie-kind", "waste-money", "average-movie", "dont-waste", "show-dont", "excellent-show", "show-look", "kind-enjoyable", "enjoyable-poor", "poor-show", "look-average", "opinions-expressed", "meant-reflect", "mine-meant", "reflect-employers", "expressed-mine", "running-time", "few-films", "one-worst", "worst-films", "message-subject", "reply-message", "details-reply", "one-top", "money-one", "year-see", "totally-unbearable", "year-totally", "top-few", "rated-pg-13", "mpaa-rating", "subject-line", "much-more", "even-though", "special-effects", "even-more", "little-more", "adult-themes", "unbearable-opinions", "fine-kids", "screening-room", "son-jeffrey", "see-screening", "subject-subscribe", "room-details", "much-better", "fine-teenagers", "one-those", "kids-around", "sex-nudity", "see-moviepage", "moviepage-details", "line-subscribe", "jeffrey-age", "painfully-unbearable", "money-totally", "unbearable-picture", "totally-painfully", "sexual-situations", "turns-out", "older-teenagers", "english-subtitles", "theres-nothing", "review-written", "romantic-comedy", "film-one", "word-subscribe", "letter-word", "subscribe-subject", "send-letter", "acceptable-teenagers", "screen-time", "motion-pictures", "running-length", "love-story", "character-study", "film-makers", "mature-themes", "two-hours", "far-more", "subject-matter", "between-two", "runs-rated", "acceptable-older", "chemistry-between", "one-thing", "action-sequences", "film-more", "first-time", "bad-language", "character-development", "brief-nudity", "themes-running", "supporting-cast", "one-best", "theres-something", "rated-violence", "profanity-adult", "rating-pg-13", "violence-profanity", "star-wars", "film-fine", "picture-opinions", "figure-out", "time-minutes", "acceptable-kids", "language-acceptable", "give-1/2", "academy-award", "nudity-violence", "high-school", "part-film", "science-fiction", "writer-director", "first-half", "1/2-one", "film-made", "box-office", "action-film", "main-characters", "dont-know", "last-years", "more-interesting", "subtitles-rated", "one-many", "great-deal", "best-part", "film-doesnt", "along-way", "doesnt-seem", "theres-much", "rating-profanity", "bad-guys", "unbearable-review", "dont-think", "takes-place", "relationship-between", "youve-seen", "give-film", "very-little", "woody-allen", "long-rated", "big-screen", "many-scenes", "pulp-fiction", "isnt-much", "years-ago", "movie-one", "new-york", "rated-strong", "runs-long", "director-john", "want-see", "see-movie", "many-times", "rated-sex", "something-more", "film-noir", "one-more", "worth-seeing", "half-hour", "ingmar-bergman", "film-festival", "never-quite", "many-ways", "doesnt-make", "long-time", "rated-language", "bit-more", "much-time", "film-never", "soap-opera", "dont-want", "movie-nothing", "film-even", "one-films", "second-half", "film-rated", "nothing-more", "kind-film", "black-white", "very-good", "1997-opinions", "make-sense", "robin-williams", "theres-little", "make-film", "one-few", "profanity-violence", "part-movie", "one-scene", "1/2-see", "never-seen", "sit-through", "found-myself", "film-making", "film-much", "picture-review", "black-comedy", "die-hard", "film-makes", "one-film", "movie-rated", "lot-more", "screen-presence", "profanity-fine", "down-david", "belief-movie", "david-puttnam", "nothing-life", "sexual-content", "people-neutral", "makes-film", "leave-down", "neutral-leave", "leaves-people", "leave-leave", "life-leaves", "made-film", "very-funny", "theres-lot", "very-much", "give-one", "enough-make", "drug-use", "based-novel", "star-trek", "written-directed", "two-leads", "one-point", "action-films", "pg-13-profanity", "anything-more", "film-takes", "drug-usage", "horror-film", "ive-seen", "sense-humor", "doesnt-take", "violence-language", "put-together", "film-maker", "pg-13-violence", "comic-relief", "jurassic-park", "feature-film", "best-thing", "nudity-profanity", "first-place", "film-film", "theres-enough", "plot-device", "quite-good", "violence-running", "seen-before", "movie-isnt", "reason-see", "doesnt-much", "profanity-running", "movie-more", "without-being", "violence-fine", "many-characters", "opening-credits", "tell-story", "doesnt-work", "sight-gags", "bad-movie", "good-film", "once-again", "teenagers-send", "kind-movie", "real-life", "action-scenes", "plot-twists", "age-gave", "those-films", "physical-comedy", "fairy-tale", "show-fine", "find-yourself", "film-director", "theres-one", "seems-more", "one-another", "good-enough", "great-film", "first-film", "mpaa-classification", "turn-out", "much-fun", "true-story", "bad-guy", "entertainment-value", "old-enough", "more-interested", "recommend-give", "fifteen-minutes", "one-expect", "one-character", "fine-older", "recommend-film", "length-mpaa", "hard-believe", "good-movie", "way-through", "mature-teenagers", "comic-book", "rest-movie", "rated-profanity", "leave-theater", "around-son", "sitting-through", "film-isnt", "taking-place", "same-time", "even-better", "rest-film", "correctly-rated", "director-robert", "french-english", "entire-movie", "ensemble-cast", "one-two", "happy-ending", "theres-more", "waste-time", "tries-hard", "fine-line", "romantic-comedies", "throughout-film", "come-out", "violence-acceptable", "profanity-sexual", "many-films", "pretty-good", "never-really", "men-women", "much-film", "make-sure", "film-very", "story-told", "point-out", "supporting-characters", "doesnt-really", "television-series", "themes-profanity", "story-itself", "first-hour", "story-film", "film-works", "story-line", "story-more", "james-bond", "mission-impossible", "family-film", "serial-killer", "entire-film", "unbearable-reviewed", "good-time", "few-minutes", "action-hero", "quentin-tarantino", "reviewed-written", "director-peter", "lion-king", "schindlers-list", "toy-story", "making-film", "telling-story", "rated-probably", "times-before", "gives-film", "give-see", "movie-made", "main-character", "film-itself", "even-those", "more-effective", "recommend-movie", "feel-good", "ten-minutes", "manages-make", "more-one", "hour-half", "movie-never", "film-many", "five-minutes", "whole-lot", "film-seems", "love-affair", "best-film", "kids-under", "film-good", "low-budget", "film-without", "movie-doesnt", "doesnt-know", "visual-effects", "many-people", "recommend-picture", "twenty-minutes", "trying-make", "romance-between", "more-impressive", "home-alone", "best-performance", "perhaps-best", "ages-son", "quite-funny", "1995-opinions", "1996-opinions", "very-well", "out-film", "makes-sense", "good-sense", "twists-turns", "human-beings", "closing-credits", "end-film", "minutes-film", "see-one", "part-story", "bad-film", "thumbs-down", "screenplay-david", "without-much", "both-sides", "nudity-sex", "age-thought", "better-film", "length-rated", "sexuality-acceptable", "film-give", "cant-help", "film-offers", "musical-numbers", "independence-day", "director-michael", "little-bit", "end-credits", "story-one", "director-david", "out-one", "gave-film", "film-little", "rating-violence", "high-energy", "out-loud", "thirty-minutes", "source-material", "well-worth", "same-way", "whats-going", "film-ends", "set-pieces", "give-movie", "more-time", "dont-care", "one-better", "first-part", "fun-watch", "point-view", "recommend-show", "press-screening", "way-film", "slice-life", "rest-cast", "problem-film", "think-film", "ninety-minutes", "point-film", "award-1/2", "few-scenes", "noir-film", "entertaining-film", "film-comes", "movie-itself", "few-times", "little-profanity", "line-between", "one-great", "many-movies", "target-audience", "despite-being", "steven-seagal", "sexuality-language", "films-one", "although-film", "strong-violence", "take-place", "violence-sex", "half-film", "characters-situations", "pretty-much", "language-violence", "although-movie", "easy-see", "silicon-valley", "title-character", "make-movie", "violence-adult", "film-those", "few-good", "last-act", "fine-teenager", "ending-credits", "suspension-disbelief", "fair-amount", "back-forth", "pg-13-sexual", "difference-between", "havent-seen", "seem-more", "two-films", "bond-films", "doesnt-quite", "seeing-film", "pop-culture", "horror-films", "walk-out", "good-one", "one-one", "wonderful-life", "though-film", "turned-out", "credits-roll", "find-film", "date-released", "movie-takes", "good-idea", "more-important", "especially-those", "work-well", "jackie-chan", "strong-language", "older-mature", "story-doesnt", "between-art", "many-viewers", "human-being", "something-mary", "much-less", "film-well", "camera-work", "time-film", "drug-content", "bruce-willis", "time-around", "lot-fun", "first-time-director", "something-between", "written-january", "themes-violence", "beginning-end", "film-probably", "long-enough", "century-theaters", "hong-kong", "language-fine", "piece-work", "few-moments", "out-place", "art-films", "1994-opinions", "film-acceptable", "facial-expressions", "pg-13-brief", "short-cuts", "watching-movie", "recent-films", "film-becomes", "two-characters", "anthony-hopkins", "much-movie", "martin-scorsese", "miramax-films", "one-good", "jean-luc-godard", "many-different", "violence-sexual", "sexual-humor", "movie-makes", "directorial-debut", "time-movie", "good-guys", "fine-ages", "parts-movie", "best-picture", "one-reasons", "picture-give", "live-action", "funny-moments", "clint-eastwood", "amc-century", "minor-characters", "social-commentary", "film-gets", "film-really", "teenagers-recommend", "good-job", "works-best", "one-favorite", "mild-profanity", "thought-movie", "doesnt-mean", "horror-movie", "nudity-language", "such-films", "characters-film", "few-years", "more-serious", "films-made", "art-life", "pg-13-adult", "warner-brothers", "thematic-elements", "dont-see", "forrest-gump", "life-piece", "far-less", "thing-film", "cinema-both", "life-takes", "language-drug", "movie-fine", "cinema-something", "bad-taste", "straight-out", "weve-seen", "last-summer", "film-see", "film-critics", "situations-adult", "make-mistake", "long-way", "few-more", "movie-runs", "violence-film", "films-life", "themes-sexual", "violence-bad", "parts-film", "come-close", "nudity-sexual", "sex-violence", "both-gives", "unlike-painting", "painting-literature", "press-kit", "cinema-art", "cinema-slice", "piece-cake", "emotional-impact", "life-unlike", "film-didnt", "film-still", "literature-cinema", "arent-many", "takes-jean-luc", "film-cant", "more-few", "watching-film", "well-done", "never-seems", "good-bad", "gave-1/2", "one-way", "make-more", "becomes-more", "jim-carrey", "film-set", "gives-life", "first-movie", "movie-filled", "life-cinema", "find-out", "really-good", "central-character", "good-evil", "plot-elements", "sexual-innuendo", "sandra-bullock", "movie-thats", "van-damme", "united-states", "story-never", "few-laughs", "film-best", "little-mermaid", "character-film", "loose-ends", "worth-caring", "starship-troopers", "steven-spielberg", "classification-mpaa", "isnt-nearly", "type-film", "mild-thumbs", "nothing-special", "make-much", "acting-ability", "very-bad", "good-thing", "film-thats", "films-best", "enough-recommend", "last-year", "many-more", "enough-interested", "valley-showing", "film-opens", "much-same", "start-finish", "smart-enough", "doesnt-offer", "problem-movie", "best-known", "better-movie", "certainly-isnt", "sort-movie", "worth-price", "doesnt-matter", "pg-13-language", "little-long", "theaters-send", "dumb-dumber", "those-dont", "content-acceptable", "saving-grace", "movie-bad", "beauty-beast", "film-story", "more-fun", "sex-scenes", "rated-nudity", "isnt-bad", "film-version", "doesnt-even", "reservoir-dogs", "doesnt-help", "period-piece", "rated-brief", "film-seem", "film-seen", "film-such", "way-out", "out-way", "even-worse", "youre-going", "production-values", "film-tries", "art-house", "oliver-stone", "script-doesnt", "each-one", "pleasant-enough", "long-before", "many-things", "itself-seriously", "fine-job", "slow-motion", "film-first", "those-rare", "take-long", "language-film", "year-old", "one-long", "much-sense", "language-sexual", "dont-make", "didnt-know", "situations-running", "much-story", "works-well", "best-films", "films-such", "romeo-juliet", "aspect-ratio", "debut-feature", "those-enjoy", "far-better", "films-title", "pg-13-mature", "blair-witch", "fine-kid", "gave-movie", "kenneth-branagh", "best-work", "films-end", "movie-best", "makes-one", "more-compelling", "more-plot", "found-film", "fifth-element", "starts-out", "makes-feel", "see-show", "movie-good", "showing-amc", "price-admission", "read-book", "perhaps-more", "made-more", "rest-picture", "those-scenes", "tom-hanks", "camera-angles", "rated-mature", "didnt-seem", "everyone-love", "john-hughes", "nothing-offend", "scene-film", "man-woman", "under-fire", "end-movie", "two-stars", "time-director", "little-violence", "isnt-enough", "more-film", "first-feature", "edge-seat", "real-people", "arnold-schwarzenegger", "simple-story", "last-film", "nudity-acceptable", "both-films", "film-goes", "isnt-particularly", "thought-film", "picture-one", "christopher-walken", "none-characters", "strongly-recommend", "age-innocence", "check-out", "language-brief", "one-time", "harrison-ford", "film-seemed", "scenes-between", "themes-fine", "two-people", "long-film", "time-one", "von-trier", "batman-robin", "film-based", "interaction-between", "part-problem", "production-design", "good-news", "big-laughs", "even-less", "little-film", "during-course", "recent-years", "everything-film", "character-interaction", "previous-films", "show-one", "through-film", "paramount-pictures", "tour-force", "something-special", "little-time", "seen-film", "kids-age", "film-although", "car-chase", "one-years", "hard-imagine", "audiences-attention", "small-part", "film-make", "left-theater", "much-ado", "makes-more", "film-moves", "runs-little", "movie-much", "award-nomination", "award-winning", "dont-mind", "supporting-players", "offend-anyone", "few-nice", "more-subtle", "going-through", "theres-reason", "movie-year", "even-film", "stand-out", "movie-works", "strong-enough", "punch-lines", "worth-watching", "sort-film", "rest-story", "film-something", "nice-guy", "movie-without", "lost-world", "takes-itself", "cast-members", "courage-under", "film-wasnt", "good-intentions", "dark-comedy", "rated-nc-17", "film-plays", "isnt-even", "movie-seems", "more-more", "strong-performances", "twenty-years", "lead-character", "fast-paced", "movie-really", "movie-even", "give-thumbs", "screenplay-john", "story-much", "large-part", "written-june", "never-made", "brady-bunch", "steve-martin", "david-mamet", "spend-time", "high-points", "french-subtitles", "life-film", "perfectly-cast", "original-film", "good-looks", "nudity-bad", "isnt-quite", "great-fun", "video-game", "julia-roberts", "notre-dame", "film-going", "more-enough", "best-scenes", "two-movies", "theres-never", "kevin-costner", "del-toro", "going-happen", "cross-between", "sweet-little", "theatrical-aspect", "human-nature", "another-film", "breaking-waves", "far-much", "before-sunrise", "cant-even", "right-down", "kids-movie", "giving-film", "film-certainly", "john-sayles", "film-worth", "interesting-character", "award-one", "movies-one", "story-isnt", "last-seen", "written-october", "violence-nudity", "profanity-brief", "saturday-night", "main-story", "bad-thing", "first-foremost", "two-actors", "think-movie", "toward-end", "come-alive", "half-movie", "nudity-little", "music-video", "violence-gore", "story-thats", "more-complex", "spinal-tap", "dont-understand", "characters-more", "low-key", "murder-mystery", "dont-expect", "those-movies", "liked-movie", "new-film", "several-scenes", "director-stephen", "theres-sense", "kids-movies", "bad-movies", "funny-film", "doesnt-always", "want-know", "nothing-new", "film-stock", "towards-end", "pg-13-rating", "take-away", "hugh-grant", "several-times", "film-feels", "find-themselves", "whole-family", "question-whether", "dont-worry", "film-starts", "aspects-film", "truman-show", "movie-film", "being-one", "kid-old", "language-sex", "sound-effects", "over-top", "film-shot", "best-parts", "bad-news", "aspect-film", "beverly-hills", "one-very", "little-sense", "david-lynch", "best-friends", "richard-iii", "movie-first", "intelligent-script", "story-movie", "look-good", "dont-work", "without-giving", "das-boot", "full-monty", "hollywood-films", "near-end", "film-being", "one-wonders", "more-substantial", "biggest-problem", "quite-bit", "viewers-find", "acting-talent", "lead-role", "movie-tries", "until-last", "good-story", "isnt-exactly", "until-end", "such-one", "comes-close", "scene-movie", "taken-seriously", "primary-colors", "isnt-really", "crude-humor", "love-stories", "excellent-job", "opening-scene", "film-full", "seeing-movie", "brought-screen", "characters-story", "teenagers-see", "takes-time", "movie-give", "particularly-good", "101-dalmatians", "dont-even", "perhaps-even", "story-many", "last-scene", "film-theres", "never-gets", "one-such", "those-two", "dont-need", "family-entertainment", "compelling-story", "graphic-violence", "beneath-surface", "director-mike", "good-acting", "film-though", "give-picture", "nicolas-cage", "nearly-enough", "bond-film", "thats-good", "fine-performances", "actors-actresses", "between-characters", "over-years", "out-more", "world-war", "thats-more", "remains-day", "enough-keep", "watch-film", "wag-dog", "based-true", "four-weddings", "movie-comes", "always-seems", "result-film", "100-minutes", "bad-things", "film-contains", "fall-love", "jerry-maguire", "kids-over", "quite-sure", "teenagers-older", "theres-still", "points-out", "eddie-murphy", "make-feel", "20th-century", "two-main", "martial-arts", "rated-sexual", "theres-doubt", "film-long", "thats-one", "isnt-one", "one-big", "movie-full", "movie-gets", "battle-scenes", "live-die", "funny-one", "over-two", "sense-sensibility", "film-funny", "movie-still", "theres-even", "one-movies", "refreshing-see", "ado-nothing", "didnt-make", "waiting-guffman", "frontal-nudity", "robert-duvall", "thats-exactly", "even-best", "much-longer", "worth-noting", "george-lucas", "stands-out", "violence-sexuality", "way-long", "love-interest", "message-film", "opening-sequence", "movie-little", "during-movie", "matter-much", "nutty-professor", "fun-watching", "tim-burton", "time-kill", "nudity-fine", "come-expect", "one-characters", "fall-flat", "columbia-pictures", "independent-film", "through-eyes", "language-sexuality", "movie-1/2", "robert-niro", "basic-instinct", "runs-feels", "company-men", "scenes-film", "thumbs-1/2", "youll-probably", "more-less", "press-notes", "two-hour", "one-really", "nothing-much", "more-real", "sundance-film", "musical-score", "more-powerful", "good-guy", "best-supporting", "nothing-short", "hunchback-notre", "film-few", "suspend-disbelief", "isnt-funny", "somewhere-between", "supporting-roles", "bathroom-humor", "distributor-miramax", "film-movie", "more-concerned", "little-sex", "characters-dont", "lost-highway", "worse-still", "minute-running", "made-look", "movie-feels", "less-successful", "during-first", "art-film", "sleepless-seattle", "kevin-spacey", "las-vegas", "virtually-nothing", "guilty-pleasure", "time-movies", "attention-detail", "true-lies", "french-film", "family-films", "seen-movie", "fun-film", "plays-part", "center-stage", "free-willy", "mystery-story", "see-again", "comes-alive", "something-little", "movie-features", "made-movie", "far-away", "piece-acting", "scenes-one", "story-seems", "director-james", "those-moments", "movie-two", "scary-movie", "director-richard", "blown-away", "time-spent", "coen-brothers", "doesnt-appear", "boogie-nights", "early-film", "more-enjoyable", "les-miserables", "film-kind", "last-action", "universal-pictures", "film-industry", "film-look", "minutes-long", "half-dozen", "final-scene", "more-successful", "one-doesnt", "film-way", "more-appropriate", "absolutely-nothing", "feature-length", "making-movie", "entirely-different", "running-around", "good-measure", "adam-sandler", "world-cinema", "work-here", "see-something", "ending-film", "someone-elses", "theme-song", "first-two", "few-things", "comes-through", "keep-audience", "psychological-thriller", "naked-gun", "makes-want", "john-malkovich", "such-thing", "best-actor", "director-jonathan", "profanity-nudity", "already-know", "dope-smoking", "over-head", "anyone-age", "never-again", "characters-seem", "role-film", "many-recent", "full-frontal", "never-takes", "plays-role", "way-movie", "film-shows", "movie-movie", "kama-sutra", "film-looks", "dantes-peak", "rated-sexuality", "dont-really", "film-quite", "story-without", "quite-few", "youre-looking", "oscar-nomination", "more-entertaining", "spitfire-grill", "best-movie", "fact-theres", "robert-altman", "john-cusack", "philadelphia-festival", "movie-set", "opposite-sex", "characters-never", "including-one", "movie-director", "solid-performances", "pictures-classics", "dark-side", "better-script", "quite-well", "animated-feature", "little-movie", "nothing-less", "content-language", "make-good", "made-sense", "story-characters", "know-last", "love-hate", "top-form", "played-out", "know-more", "movie-ends", "more-films", "actors-play", "sweet-hereafter", "things-going", "more-anything", "film-better", "best-one", "one-much", "those-elements", "festival-world", "citizen-kane", "animated-film", "didnt-care", "film-bad", "film-end", "film-far", "script-based", "easily-one", "theres-plenty", "movie-make", "ive-never", "make-such", "care-characters", "film-french", "billy-crystal", "denis-leary", "although-many", "acceptable-ages", "time-frame", "part-show", "great-movie", "plot-devices", "whole-movie", "first-act", "private-parts", "starring-role", "nudity-running", "visual-style", "105-minutes", "human-drama", "same-level", "film-actually", "alfred-hitchcock", "look-film", "performance-one", "dont-take", "script-full", "sixth-sense", "nudity-adult", "film-trying", "short-film", "situations-profanity", "another-one", "perhaps-one", "over-again", "little-story", "american-audiences", "over-over", "based-play", "liar-liar", "best-director", "genuine-chemistry", "way-another", "good-parts", "john-woo", "comes-out", "energy-level", "lot-time", "shown-philadelphia", "slightly-more", "theres-way", "although-one", "members-audience", "few-lines", "movies-more", "family-values", "previous-film", "reason-care", "through-movie", "action-violence", "night-live", "sony-pictures", "right-wrong", "blood-gore", "weddings-funeral", "rated-little", "sex-profanity", "movie-people", "audience-members", "real-world", "monty-python", "rush-hour", "best-performances", "well-cast", "see-much", "air-force", "more-once", "never-see", "film-nothing", "fully-developed", "one-hand", "best-lines", "same-kind", "quality-film", "cutting-room", "whose-last", "same-name", "better-one", "doesnt-feel", "feature-debut", "best-way", "movie-theater", "director-steven", "attempts-humor", "slightly-different", "those-characters", "keanu-reeves", "films-conclusion", "film-two", "make-audience", "given-more", "completely-different", "extremely-funny", "silence-lambs", "bit-much", "scene-one", "more-little", "force-one", "movie-although", "goes-long", "film-work", "wide-variety", "another-movie", "find-something", "idea-film", "outer-space", "supporting-role", "slapstick-comedy", "carried-away", "talented-cast", "rated-fine", "youve-never", "movie-worth", "austin-powers", "language-mature", "fathers-day", "differences-between", "set-design", "ice-storm", "answer-question", "new-ground", "once-upon", "dance-numbers", "against-type", "tells-story", "movie-becomes", "one-minute", "lead-characters", "lot-people", "movie-actually", "having-fun", "didnt-see", "strikes-back", "film-characters", "little-much", "film-acting", "care-less", "title-film", "enjoy-film", "action-picture", "care-much", "saw-film", "built-around", "michael-keaton", "runs-out", "film-experience", "waynes-world", "funny-lines", "meg-ryan", "vastly-different", "lead-actors", "strong-sexuality", "quite-same", "comedy-drama", "best-moments", "film-come", "second-time", "wanted-make", "film-done", "film-dont", "profanity-sex", "one-person", "one-major", "thing-certain", "script-director", "film-whose", "film-feel", "big-budget", "one-interesting", "title-role", "one-even", "see-more", "even-one", "hard-eight", "usual-suspects", "part-picture", "themes-brief", "high-level", "best-foreign", "one-reason", "more-difficult", "perfect-example", "worth-look", "movie-going", "thats-way", "becomes-clear", "one-moment", "high-concept", "action-thriller", "love-catastrophes", "minutes-movie", "strong-sexual", "chasing-amy", "makes-much", "written-1996", "last-few", "make-seem", "run-out", "surprise-ending", "things-happen", "pokes-fun", "situations-nudity", "car-chases", "youll-find", "dont-miss", "movie-plays", "few-many", "make-want", "less-effective", "time-105", "century-fox", "story-such", "film-year", "seen-through", "story-tell", "story-really", "juliette-lewis", "denzel-washington", "never-more", "film-lacks", "films-last", "based-book", "director-brian", "bad-enough", "music-john", "mel-gibson", "films-more", "sex-scene", "rated-nothing", "history-lesson", "dysfunctional-family", "still-one", "farewell-concubine", "through-entire", "scenes-movie", "barry-levinson", "screenplay-peter", "wesley-snipes", "rated-mild", "films-opening", "male-female", "martin-lawrence", "out-much", "enough-give", "entire-life", "main-problem", "krzysztof-kieslowski", "interesting-enough", "director-roger", "thirty-years", "incorrectly-rated", "feel-sorry", "moments-film", "chain-reaction", "first-half-hour", "film-great", "youd-expect", "much-anything", "dont-ask", "done-before", "rating-sexual", "sliding-doors", "basic-plot", "muriels-wedding", "gives-one", "bunch-movie", "unlike-many", "never-comes", "pointe-blank", "bring-myself", "disney-animated", "nothing-film", "film-both", "few-people", "city-slickers", "more-two", "hollywood-film", "worked-well", "crude-sexual", "fleshed-out", "isnt-good", "friends-wedding", "doesnt-exactly", "around-send", "stage-play", "love-film", "one-half", "two-years", "story-story", "next-time", "red-line", "memorable-lines", "grand-canyon", "doesnt-come", "theres-question", "take-look", "very-hard", "cant-make", "certainly-doesnt", "during-film", "funny-enough", "sling-blade", "film-1/2", "very-different", "con-air", "really-liked", "easy-understand", "january-1997", "many-good", "english-patient", "conflict-between", "chance-see", "given-much", "coming-of-age-story", "film-same", "movie-many", "year-list", "take-time", "both-actors", "actors-playing", "hes-more", "forth-between", "first-glance", "feature-director", "sexuality-fine", "leslie-nielsen", "come-along", "years-best", "richard-gere", "much-plot", "anything-new", "deep-impact", "film-failed", "19th-century", "message-movie", "recent-memory", "characters-make", "become-more", "look-feel", "never-feels", "here-film", "first-time-writer", "john-travolta", "liked-way", "dont-surprised", "doesnt-want", "three-main", "cant-see", "pelican-brief", "big-game", "characters-little", "empire-strikes", "change-pace", "sort-thing", "val-kilmer", "ace-ventura", "big-night", "story-becomes", "absolute-power", "movies-best", "rise-above", "quirky-characters", "everything-seems", "kenneth-branaghs", "come-back", "cats-dogs", "enough-film", "winona-ryder", "release-date", "gene-hackman", "comes-mind", "people-dont", "good-reason", "michelle-pfeiffer", "real-story", "final-analysis", "profanity-drug", "certain-amount", "demi-moore", "female-characters", "far-best", "those-familiar", "arent-enough", "noir-films", "city-angels", "comic-moments", "dustin-hoffman", "little-things", "type-movie", "youll-see", "indiana-jones", "cutting-edge", "noir-thriller", "smile-face", "big-fan", "actors-film", "american-film", "george-jungle", "thin-red", "around-nine", "john-turturro", "far-long", "thing-movie", "probably-best", "moves-along", "little-better", "much-different", "aspect-movie", "twentieth-century", "animated-features", "one-fine", "director-jon", "humor-movie", "grosse-pointe", "age-1/2", "movies-year", "story-didnt", "three-hours", "cautionary-tale", "jackie-brown", "top-rating", "star-film", "femme-fatale", "movie-starts", "air-bud", "wedding-singer", "those-under", "one-key", "movie-gave", "old-men", "more-screen", "film-filled", "before-film", "comedy-film", "same-thing", "doesnt-give", "show-give", "virtually-impossible", "acting-good", "story-makes", "very-long", "very-few", "gwyneth-paltrow", "seven-years", "makes-movie", "situations-violence", "way-story", "1/2-star", "computer-generated", "many-great", "much-energy", "performance-film", "wings-desire", "forty-five-minutes", "around-corner", "interesting-story", "real-problem", "find-one", "whole-thing", "line-fire", "easily-best", "spike-lee", "first-one", "mild-language", "time-see", "room-floor", "years-later", "pointed-out", "laughably-bad", "hollywood-pictures", "really-isnt", "films-many", "feels-more", "bring-out", "movie-well", "samuel-jackson", "without-resorting", "kevin-smith", "came-out", "darn-cat", "film-nevertheless", "director-paul", "long-line", "out-movie", "dramatic-music", "more-human", "solid-entertainment", "dead-man", "farrelly-brothers", "didnt-work", "youd-think", "young-kids", "shall-dance", "worth-recommending", "sexual-references", "drew-barrymore", "woody-allens", "cant-quite", "strong-performance", "well-enough", "heavenly-creatures", "dark-city", "whose-previous", "power-rangers", "looking-richard", "love-jones", "masterpiece-theater", "miracle-34th", "more-appealing", "original-movie", "nice-job", "sean-penn", "animated-movie", "body-language", "although-few", "film-critic", "seems-little", "jingle-way", "look-one", "last-picture", "witch-project", "rating-nudity", "black-hat", "many-others", "stock-characters", "really-funny", "more-passing", "billy-bob", "screenplay-michael", "politically-incorrect", "first-major", "work-one", "connection-between", "things-dont", "seen-one", "kids-show", "didnt-think", "third-act", "cannes-film", "american-beauty", "many-lines", "talking-heads", "another-example", "younger-kids", "seen-more", "much-attention", "good-looking", "cartoonish-violence", "times-movie", "final-credits", "film-always", "film-left", "kevin-williamson", "movie-find", "story-gets", "something-different", "gratuitous-violence", "written-december", "much-happens", "needs-more", "movie-great", "liked-film", "small-role", "first-minutes", "welcome-dollhouse", "film-over", "probably-pg-13", "oscar-nominations", "two-three", "bad-idea", "joy-luck", "make-laugh", "film-think", "hardly-wait", "very-difficult", "monster-movie", "movie-stars", "disaster-movie", "little-bad", "way-around", "work-film", "show-more", "second-act", "much-going", "extremely-effective", "los-angeles", "larry-flynt", "better-films", "completely-satisfying", "theres-denying", "action-flick", "movie-same", "look-back", "come-surprise", "short-story", "walt-disney", "34th-street", "straight-face", "feels-much", "screenplay-robert", "carry-film", "times-film", "good-gets", "principal-characters", "line-features", "wonder-whether", "made-one", "everyone-film", "major-league", "becomes-apparent", "good-laughs", "little-picture", "written-august", "bad-one", "foreign-language", "make-one", "private-ryan", "theres-very", "point-story", "men-black", "spanish-english", "twelve-monkeys", "given-opportunity", "cant-hardly", "rated-mpaa", "film-manages", "thin-story", "script-makes", "more-traditional", "hoop-dreams", "make-story", "second-film", "isnt-anything", "tries-make", "people-film", "offers-few", "things-considered", "bogs-down", "115-minutes", "groundhog-day", "being-made", "many-critics", "movie-opens", "runs-way", "addams-family", "more-recent", "movie-few", "late-film", "life-story", "seem-much", "110-minutes", "profanity-mature", "one-story", "figured-out", "even-given", "film-certain", "wild-things", "raging-bull", "audience-film", "dances-wolves", "new-wave", "enough-time", "movie-making", "camera-shots", "more-story", "george-clooney", "far-many", "keeps-film", "such-film", "entire-picture", "fine-mature", "kids-son", "lines-dialogue", "secrets-lies", "people-want", "myself-recommend", "under-skin", "director-rob", "saving-private", "hard-find", "considerably-more", "basic-premise", "sean-connery", "surprisingly-effective", "story-even", "makes-wonder", "done-better", "director-barry", "younger-viewers", "one-worth", "even-story", "put-sleep", "makes-good", "cant-think", "one-mans", "those-want", "lee-jones", "jeff-bridges", "punch-line", "hard-make", "makes-think", "probably-more", "rating-one", "early-scenes", "once-warriors", "far-between", "bottom-line", "last-time", "mood-film", "worth-mentioning", "lone-star", "sometimes-funny", "cant-seem", "one-three", "roller-coaster", "romantic-interest", "still-manages", "out-control", "work-even", "interesting-film", "out-welcome", "much-character", "glued-screen", "laugh-track", "character-movie", "more-character", "bogged-down", "really-bad", "show-much", "foreign-film", "certainly-one", "beautifully-photographed", "interesting-watch", "heart-film", "both-good", "performance-here", "much-made", "theatrical-release", "upon-time", "one-things", "appropriate-teenagers", "danny-devito", "brief-language", "grumpy-old", "shanghai-triad", "one-easily", "seemed-more", "especially-one", "completely-predictable", "need-more", "something-out", "belly-laughs", "one-level", "between-good", "hard-see", "lack-thereof", "more-satisfying", "characters-movie", "know-story", "characters-arent", "nc-17-rating", "lethal-weapon", "thats-case", "tension-between", "even-movie", "over-hour", "action-movie", "cemetery-man", "way-make", "bugs-life", "film-series", "gives-movie", "strong-sense", "sharon-stone", "comic-violence", "those-expecting", "one-problems", "charlie-chan", "writing-directing", "screenplay-richard", "luck-club", "human-condition", "failed-attempts", "natural-born", "mars-attacks", "picture-perfect", "one-reasonably", "more-believable", "emotional-depth", "focal-point", "female-nudity", "ends-being", "physical-humor", "picture-fine", "amount-time", "script-written", "chris-odonnell", "movie-going-experience", "subtitles-film", "much-recommend", "great-performance", "much-worse", "suspense-film", "simply-put", "movie-version", "great-director", "many-levels", "shock-value", "new-line", "beavis-butt-head", "shallow-grave", "sex-brief", "give-away", "kevin-kline", "compelling-characters", "character-depth", "out-such", "number-one", "never-clear", "tim-roth", "drink-man", "audience-movie", "two-minutes", "john-williams", "film-thought", "reality-bites", "recent-movie", "fight-sequences", "movie-see", "screwball-comedy", "gives-way", "black-humor", "fellow-americans", "much-screen", "cut-out", "thoroughly-enjoyable", "right-direction", "brand-humor", "performance-makes", "work-out", "body-count", "shadow-conspiracy", "last-half", "costume-drama", "three-times", "one-makes", "best-year", "best-friend", "much-humor", "adult-humor", "feeling-minnesota", "rock-roll", "things-film", "humor-film", "movie-gives", "supporting-actor", "nearly-much", "make-even", "tommy-lee", "opportunity-see", "youre-watching", "director-martin", "doing-something", "probably-find", "everyone-involved", "seen-many", "cinematic-experience", "pierce-brosnan", "one-hope", "old-feeling", "know-whether", "bad-boys", "story-still", "cute-little", "keep-viewers", "good-taste", "know-characters", "atom-egoyan", "character-doesnt", "stay-away", "triumph-over", "blues-brothers", "film-less", "movie-feel", "movie-probably", "take-much", "nothing-remotely", "last-part", "one-see", "show-even", "alan-parker", "different-way", "land-before", "film-especially", "cast-includes", "genre-film", "people-involved", "isnt-movie", "small-talk", "howards-end", "director-alan", "easy-follow", "legends-fall", "fine-performance", "recent-film", "lowell-ganz", "movie-long", "never-even", "spends-much", "scenes-together", "latter-category", "time-travel", "movie-keeps", "clear-present", "american-pie", "morgan-freeman", "story-two", "seen-trailers", "films-even", "film-uses", "thus-far", "few-memorable", "dream-sequences", "long-stretches", "story-takes", "recommend-anyone", "done-much", "really-care", "kiss-death", "ghost-darkness", "films-ending", "uses-word", "hard-time", "script-never", "those-few", "characters-relationships", "character-played", "lines-film", "time-100", "bits-pieces", "leonardo-dicaprio", "warner-bros", "very-very", "those-occasions", "touchstone-pictures", "much-part", "sort-way", "pg-13-little", "didnt-much", "way-characters", "though-story", "lost-souls", "present-danger", "need-know", "before-time", "ordinary-people", "eat-drink", "mike-leigh", "big-city", "important-thing", "movie-easily", "those-arent", "out-character", "really-know", "course-film", "director-kevin", "out-those", "fall-asleep", "wanted-see", "more-importantly", "plays-more", "seems-designed", "didnt-take", "first-scene", "really-need", "kind-role", "classification-rated", "even-little", "june-1997", "more-energy", "animated-films", "theres-always", "within-bellcore", "light-comedy", "throughout-movie", "york-city", "above-represents", "war-films", "ill-anything", "one-seems", "worst-movie", "joel-schumacher", "funny-movie", "well-developed", "good-old-fashioned", "script-more", "king-hill", "johnny-depp", "enjoyable-film", "road-picture", "story-theres", "amusement-park", "hollow-reed", "both-characters", "single-character", "leave-beaver", "central-characters", "one-never", "those-bellcore", "king-kong", "life-isnt", "film-loses", "jerry-bruckheimer", "final-act", "films-first", "plot-points", "right-place", "trying-find", "couldnt-help", "stanley-tucci", "october-films", "put-much", "individual-scenes", "pg-13-sex", "cuss-words", "author-necessarily", "trying-hard", "funny-even", "never-developed", "memorable-moments", "never-fully", "thats-part", "both-movies", "earlier-year", "time-develop", "courtroom-drama", "direction-film", "ron-howard", "little-ones", "elements-film", "next-film", "time-time", "come-life", "rating-mild", "somewhere-along", "special-effect", "rises-above", "rating-adult", "more-depth", "central-theme", "few-far", "new-version", "film-before", "especially-liked", "lawrence-kasdan", "film-begins", "final-half", "serious-film", "brothers-mcmullen", "better-movies", "water-chocolate", "second-feature", "life-one", "richard-lagravenese", "movie-based", "ten-years", "taxi-driver", "organization-within", "last-seduction", "films-success", "robin-hood", "point-movie", "violence-brief", "right-thing", "film-easy", "material-work", "director-christopher", "twist-fate", "difficult-watch", "profanity-show", "find-anything", "fact-film", "movie-needs", "better-more", "particularly-interesting", "kansas-city", "make-think", "real-reason", "something-thats", "movie-cant", "fresh-air", "again-again", "sound-music", "movie-come", "isnt-worth", "carefully-constructed", "even-without", "interesting-see", "makes-picture", "time-place", "spending-time", "more-substance", "know-much", "more-focused", "ivan-reitman", "shows-more", "sylvester-stallone", "really-matter", "lot-going", "film-love", "mike-nichols", "glenn-close", "character-one", "merchant-ivory", "movie-goes", "brief-violence", "kiss-girls", "humor-comes", "straight-man", "male-nudity", "place-film", "love-triangle", "wes-craven", "steven-soderbergh", "sure-whether", "bellcore-organization", "keep-film", "film-school", "film-completely", "those-looking", "red-rock", "very-end", "first-thing", "made-even", "enough-see", "rating-mature", "born-killers", "holiday-season", "real-star", "shes-lovely", "movie-better", "movie-filmed", "story-made", "really-doesnt", "picture-rated", "makes-look", "forty-minutes", "much-way", "human-story", "one-argue", "written-1997", "boyz-hood", "part-one", "out-theater", "san-francisco", "harvey-keitel", "necessarily-those", "kids-probably", "hard-take", "funny-scenes", "directors-cut", "one-greatest", "book-one", "dont-much", "rocky-bullwinkle", "nuanced-performance", "school-seniors", "whoopi-goldberg", "never-know", "makes-seem", "plot-threads", "emotional-response", "bad-performance", "spends-time", "many-plot", "satisfying-film", "come-through", "represents-opinions", "interesting-characters", "tom-shadyac", "quiz-show", "movie-time", "odd-couple", "quite-enough", "explicit-sex", "even-minor", "missed-opportunities", "pleasant-surprise", "sometimes-even", "found-movie", "film-recommend", "lost-space", "fact-one", "film-tried", "beauty-film", "without-even", "eves-bayou", "director-mark", "terminal-velocity", "big-deal", "sympathetic-character", "give-single", "new-zealand", "running-gag", "acceptable-high", "look-forward", "goes-beyond", "nice-moments", "simple-wish", "technical-aspects", "films-second", "find-much", "twelfth-night", "film-couldnt", "whole-wide", "hard-enough", "picture-thats", "high-quality", "opinions-author", "cant-believe", "glenn-gould", "one-exception", "willing-take", "ability-make", "worst-thing", "brad-pitt", "exactly-same", "brady-sequel", "robert-altmans", "bill-murray", "makes-character", "entry-genre", "rated-pervasive", "tammy-faye", "american-history", "adventure-film", "much-films", "virtual-reality", "line-dialogue", "nearly-two", "use-word", "certain-aspects", "never-heard", "movie-think", "going-make", "picture-even", "young-actors", "hope-see", "eyes-ears", "role-one", "inventing-abbotts", "ralph-fiennes", "nearly-scene", "space-jam", "ang-lee", "plot-character", "really-want", "picture-comes", "nothing-wrong", "final-product", "bill-pullman", "deft-touch", "morality-tale", "thats-right", "edward-zwick", "film-directed", "time-trying", "film-succeeds", "robert-redford", "sex-film", "one-hundred-minutes", "especially-considering", "film-played", "much-substance", "big-time", "film-another", "profanity-film", "plot-holes", "good-spirited", "addicted-love", "anything-film", "rare-occasions", "king-george", "without-single", "event-horizon", "very-brady", "know-better", "wait-until", "couldnt-more", "film-leaves", "woody-harrelson", "fierce-creatures", "cinema-paradiso", "around-edges", "rarely-seen", "rated-few", "james-newton", "always-good", "wanted-film", "movie-big", "movie-far", "cinematography-john", "side-story", "talented-director", "couple-scenes", "hav-plenty", "bridget-fonda", "such-bad", "romy-michele", "more-common", "story-little", "two-best", "country-film", "wrong-way", "funny-scene", "still-something", "documentary-style", "probably-enjoy", "script-one", "genuinely-funny", "patch-adams", "audience-feel", "lets-hope", "tom-cruise", "film-history", "feel-more", "think-much", "ive-always", "deep-rising", "reason-film", "edge-seats", "emotional-resonance", "screen-adaptation", "true-romance", "plot-twist", "soap-operas", "more-life", "many-jokes", "trigger-effect", "supporting-actress", "surprise-film", "though-one", "few-characters", "war-film", "mixed-bag", "takes-few", "kids-ten", "arent-nearly", "poorly-written", "slasher-movie", "director-joe", "film-hard", "tin-cup", "director-tom", "broadcast-news", "walked-out", "steven-spielbergs", "little-buddha", "keen-sense", "movie-characters", "dazed-confused", "comic-timing", "typical-hollywood", "makes-easy", "small-screen", "quite-effective", "conspiracy-theory", "full-energy", "movie-quite", "world-film", "worth-effort", "home-movie", "character-arc", "self-deprecating-humor", "good-see", "more-intriguing", "behind-camera", "younger-ones", "time-period", "one-look", "fact-movie", "bad-words", "old-fashioned", "except-one", "oscar-wilde", "work-best", "humor-language", "kissing-fool", "classic-film", "james-woods", "runs-fast", "whole-film", "harold-ramis", "well-made", "one-part", "coming-out", "know-one", "film-real", "story-make", "much-one", "characters-whose", "life-movie", "never-feel", "isnt-very", "dead-bodies", "think-one", "characters-even", "films-film", "john-grisham", "movie-certainly", "tone-poem", "drawn-out", "enough-material", "more-movie", "strongest-recommendation", "star-show", "much-stronger", "wide-world", "music-film", "time-115", "look-away", "having-seen", "films-central", "film-perhaps", "violence-drug", "makes-sure", "one-suspects", "comic-books", "try-hard", "director-joel", "during-films", "film-easily", "lead-actor", "actually-one", "larger-life", "cabin-boy", "under-siege", "well-one", "particularly-funny", "art-form", "looks-great", "real-character", "movie-very", "whatever-reason", "those-willing", "keeps-audience", "umbrellas-cherbourg", "made-seem", "something-new", "plot-point", "song-dance", "time-theres", "quite-mature", "long-kiss", "final-half-hour", "cant-imagine", "written-over", "film-features", "done-well", "major-problem", "summer-movie", "find-many", "rings-true", "feel-something", "mrs-doubtfire", "find-more", "minute-film", "film-festivals", "sister-act", "deconstructing-harry", "exactly-one", "out-even", "individual-moments", "way-many", "film-genre", "going-end", "anyone-seen", "going-see", "looking-forward", "funny-script", "one-little", "middle-ground", "film-audience", "thats-problem", "strong-cast", "sense-being", "piece-entertainment", "two-girls", "gets-little", "one-sense", "simple-twist", "violence-mature", "many-years", "star-power", "pretty-woman", "subtle-humor", "cinema-running", "unqualified-success", "overly-long", "movie-those", "film-gives", "high-society", "enjoy-movie", "kids-ages", "know-exactly", "presented-here", "bye-bye", "teenagers-although", "one-shows", "faint-praise", "out-left", "little-girl", "story-seemed", "arguably-best", "difficult-task", "more-involving", "previous-efforts", "isnt-going", "poke-fun", "never-thought", "dalai-lama", "over-past", "being-film", "enough-good", "give-credit", "trip-theater", "enough-here", "whose-performance", "vietnam-war", "wont-find", "film-sometimes", "looking-film", "one-quite", "music-david", "little-kids", "distributor-new", "little-doubt", "nice-people", "story-between", "godfather-part", "couple-years", "video-store", "stay-awake", "young-people", "giving-1/2", "violent-scenes", "cult-classic", "drama-comedy", "nice-see", "more-obvious", "isnt-especially", "junior-high", "viewing-experience", "cheap-out", "ganz-babaloo", "susan-sarandon", "several-years", "cheap-thrills", "princess-mononoke", "film-debut", "roland-emmerich", "film-basically", "film-several", "screen-one", "big-lebowski", "profanity-sexuality", "written-script", "personal-favorite", "makes-little", "favorite-part", "indie-film", "walk-moon", "half-star", "movies-many", "academy-awards", "make-point", "local-multiplex", "film-become", "believe-one", "attention-span", "make-films", "movie-lot", "film-instead", "movie-now", "125-minutes", "jokes-work", "edward-norton", "cries-out", "done-without", "movie-way", "memorable-film", "more-palatable", "oscar-consideration", "fascinating-character", "films-theme", "real-mccoy", "such-way", "easy-way", "director-writer", "fatal-instinct", "kids-nine", "madness-king", "little-women", "thrown-good", "films-french", "film-people", "urban-legend", "hour-movie", "body-work", "out-sight", "good-example", "fine-day", "action-figures", "dramatic-impact", "such-case", "poor-quality", "adrenaline-pumping", "wrong-movie", "more-conventional", "attempt-make", "sense-place", "searching-bobby", "latest-film", "enough-movie", "lot-better", "san-joses", "one-several", "hold-attention", "tango-lesson", "one-problem", "cinematic-equivalent", "film-enough", "mel-brooks", "fleshing-out", "picture-never", "one-funniest", "nine-son", "know-film", "hanging-out", "color-night", "film-looking", "characters-one", "director-andrew", "young-actress", "extremely-well", "takes-many", "biggest-surprise", "see-picture", "good-films", "social-satire", "rob-roy", "without-having", "director-harold", "one-first", "never-one", "war-violence", "improvement-over", "supposed-funny", "innuendo-fine", "before-movie", "well-film", "give-show", "those-seen", "finished-product", "violence-little", "dont-wrong", "two-women", "movie-dont", "rock-west", "two-more", "character-more", "original-script", "francis-ford", "different-kind", "foreign-films", "plot-characters", "parts-story", "flesh-out", "out-story", "film-last", "story-full", "big-chill", "theme-film", "thematic-material", "story-goes", "make-compelling", "good-old", "getting-know", "mild-violence", "one-man", "make-clear", "down-pat", "kiss-goodnight", "dont-come", "better-job", "having-good", "make-look", "lose-track", "falls-back", "jungle-jungle", "one-make", "director-seems", "scene-scene", "possible-exception", "scenes-show", "chase-scene", "film-anything", "bad-good", "plot-development", "scenes-such", "drop-zone", "preachers-wife", "expect-more", "one-wonder", "better-served"};

	//2000--public static String[] bigramList={"films-year",  "see-film",  "motion-picture",  "film-excellent",  "movie-kind",  "waste-money",  "average-movie",  "dont-waste",  "show-dont",  "excellent-show",  "show-look",  "kind-enjoyable",  "enjoyable-poor",  "poor-show",  "look-average",  "opinions-expressed",  "meant-reflect",  "mine-meant",  "reflect-employers",  "expressed-mine",  "running-time",  "few-films",  "one-worst",  "worst-films",  "message-subject",  "reply-message",  "details-reply",  "one-top",  "money-one",  "year-see",  "totally-unbearable",  "year-totally",  "top-few",  "rated-pg-13",  "mpaa-rating",  "subject-line",  "much-more",  "even-though",  "special-effects",  "even-more",  "little-more",  "adult-themes",  "unbearable-opinions",  "fine-kids",  "screening-room",  "son-jeffrey",  "see-screening",  "subject-subscribe",  "room-details",  "much-better",  "fine-teenagers",  "one-those",  "kids-around",  "sex-nudity",  "see-moviepage",  "moviepage-details",  "line-subscribe",  "jeffrey-age",  "painfully-unbearable",  "money-totally",  "unbearable-picture",  "totally-painfully",  "sexual-situations",  "turns-out",  "older-teenagers",  "english-subtitles",  "theres-nothing",  "review-written",  "romantic-comedy",  "film-one",  "word-subscribe",  "letter-word",  "subscribe-subject",  "send-letter",  "acceptable-teenagers",  "screen-time",  "motion-pictures",  "running-length",  "love-story",  "character-study",  "film-makers",  "mature-themes",  "two-hours",  "far-more",  "subject-matter",  "between-two",  "runs-rated",  "acceptable-older",  "chemistry-between",  "one-thing",  "action-sequences",  "film-more",  "first-time",  "bad-language",  "character-development",  "brief-nudity",  "themes-running",  "supporting-cast",  "one-best",  "theres-something",  "rated-violence",  "profanity-adult",  "rating-pg-13",  "violence-profanity",  "star-wars",  "film-fine",  "picture-opinions",  "figure-out",  "time-minutes",  "acceptable-kids",  "language-acceptable",  "give-1/2",  "academy-award",  "nudity-violence",  "high-school",  "part-film",  "science-fiction",  "writer-director",  "first-half",  "1/2-one",  "film-made",  "box-office",  "action-film",  "main-characters",  "dont-know",  "last-years",  "more-interesting",  "subtitles-rated",  "one-many",  "great-deal",  "best-part",  "film-doesnt",  "along-way",  "doesnt-seem",  "theres-much",  "rating-profanity",  "bad-guys",  "unbearable-review",  "dont-think",  "takes-place",  "relationship-between",  "youve-seen",  "give-film",  "very-little",  "woody-allen",  "long-rated",  "big-screen",  "many-scenes",  "pulp-fiction",  "isnt-much",  "years-ago",  "movie-one",  "new-york",  "rated-strong",  "runs-long",  "director-john",  "want-see",  "see-movie",  "many-times",  "rated-sex",  "something-more",  "film-noir",  "one-more",  "worth-seeing",  "half-hour",  "ingmar-bergman",  "film-festival",  "never-quite",  "many-ways",  "doesnt-make",  "long-time",  "rated-language",  "bit-more",  "much-time",  "film-never",  "soap-opera",  "dont-want",  "movie-nothing",  "film-even",  "one-films",  "second-half",  "film-rated",  "nothing-more",  "kind-film",  "black-white",  "very-good",  "1997-opinions",  "make-sense",  "robin-williams",  "theres-little",  "make-film",  "one-few",  "profanity-violence",  "part-movie",  "one-scene",  "1/2-see",  "never-seen",  "sit-through",  "found-myself",  "film-making",  "film-much",  "picture-review",  "black-comedy",  "die-hard",  "film-makes",  "one-film",  "movie-rated",  "lot-more",  "screen-presence",  "profanity-fine",  "down-david",  "belief-movie",  "david-puttnam",  "nothing-life",  "sexual-content",  "people-neutral",  "makes-film",  "leave-down",  "neutral-leave",  "leaves-people",  "leave-leave",  "life-leaves",  "made-film",  "very-funny",  "theres-lot",  "very-much",  "give-one",  "enough-make",  "drug-use",  "based-novel",  "star-trek",  "written-directed",  "two-leads",  "one-point",  "action-films",  "pg-13-profanity",  "anything-more",  "film-takes",  "drug-usage",  "horror-film",  "ive-seen",  "sense-humor",  "doesnt-take",  "violence-language",  "put-together",  "film-maker",  "pg-13-violence",  "comic-relief",  "jurassic-park",  "feature-film",  "best-thing",  "nudity-profanity",  "first-place",  "film-film",  "theres-enough",  "plot-device",  "quite-good",  "violence-running",  "seen-before",  "movie-isnt",  "reason-see",  "doesnt-much",  "profanity-running",  "movie-more",  "without-being",  "violence-fine",  "many-characters",  "opening-credits",  "tell-story",  "doesnt-work",  "sight-gags",  "bad-movie",  "good-film",  "once-again",  "teenagers-send",  "kind-movie",  "real-life",  "action-scenes",  "plot-twists",  "age-gave",  "those-films",  "physical-comedy",  "fairy-tale",  "show-fine",  "find-yourself",  "film-director",  "theres-one",  "seems-more",  "one-another",  "good-enough",  "great-film",  "first-film",  "mpaa-classification",  "turn-out",  "much-fun",  "true-story",  "bad-guy",  "entertainment-value",  "old-enough",  "more-interested",  "recommend-give",  "fifteen-minutes",  "one-expect",  "one-character",  "fine-older",  "recommend-film",  "length-mpaa",  "hard-believe",  "good-movie",  "way-through",  "mature-teenagers",  "comic-book",  "rest-movie",  "rated-profanity",  "leave-theater",  "around-son",  "sitting-through",  "film-isnt",  "taking-place",  "same-time",  "even-better",  "rest-film",  "correctly-rated",  "director-robert",  "french-english",  "entire-movie",  "ensemble-cast",  "one-two",  "happy-ending",  "theres-more",  "waste-time",  "tries-hard",  "fine-line",  "romantic-comedies",  "throughout-film",  "come-out",  "violence-acceptable",  "profanity-sexual",  "many-films",  "pretty-good",  "never-really",  "men-women",  "much-film",  "make-sure",  "film-very",  "story-told",  "point-out",  "supporting-characters",  "doesnt-really",  "television-series",  "themes-profanity",  "story-itself",  "first-hour",  "story-film",  "film-works",  "story-line",  "story-more",  "james-bond",  "mission-impossible",  "family-film",  "serial-killer",  "entire-film",  "unbearable-reviewed",  "good-time",  "few-minutes",  "action-hero",  "quentin-tarantino",  "reviewed-written",  "director-peter",  "lion-king",  "schindlers-list",  "toy-story",  "making-film",  "telling-story",  "rated-probably",  "times-before",  "gives-film",  "give-see",  "movie-made",  "main-character",  "film-itself",  "even-those",  "more-effective",  "recommend-movie",  "feel-good",  "ten-minutes",  "manages-make",  "more-one",  "hour-half",  "movie-never",  "film-many",  "five-minutes",  "whole-lot",  "film-seems",  "love-affair",  "best-film",  "kids-under",  "film-good",  "low-budget",  "film-without",  "movie-doesnt",  "doesnt-know",  "visual-effects",  "many-people",  "recommend-picture",  "twenty-minutes",  "trying-make",  "romance-between",  "more-impressive",  "home-alone",  "best-performance",  "perhaps-best",  "ages-son",  "quite-funny",  "1995-opinions",  "1996-opinions",  "very-well",  "out-film",  "makes-sense",  "good-sense",  "twists-turns",  "human-beings",  "closing-credits",  "end-film",  "minutes-film",  "see-one",  "part-story",  "bad-film",  "thumbs-down",  "screenplay-david",  "without-much",  "both-sides",  "nudity-sex",  "age-thought",  "better-film",  "length-rated",  "sexuality-acceptable",  "film-give",  "cant-help",  "film-offers",  "musical-numbers",  "independence-day",  "director-michael",  "little-bit",  "end-credits",  "story-one",  "director-david",  "out-one",  "gave-film",  "film-little",  "rating-violence",  "high-energy",  "out-loud",  "thirty-minutes",  "source-material",  "well-worth",  "same-way",  "whats-going",  "film-ends",  "set-pieces",  "give-movie",  "more-time",  "dont-care",  "one-better",  "first-part",  "fun-watch",  "point-view",  "recommend-show",  "press-screening",  "way-film",  "slice-life",  "rest-cast",  "problem-film",  "think-film",  "ninety-minutes",  "point-film",  "award-1/2",  "few-scenes",  "noir-film",  "entertaining-film",  "film-comes",  "movie-itself",  "few-times",  "little-profanity",  "line-between",  "one-great",  "many-movies",  "target-audience",  "despite-being",  "steven-seagal",  "sexuality-language",  "films-one",  "although-film",  "strong-violence",  "take-place",  "violence-sex",  "half-film",  "characters-situations",  "pretty-much",  "language-violence",  "although-movie",  "easy-see",  "silicon-valley",  "title-character",  "make-movie",  "violence-adult",  "film-those",  "few-good",  "last-act",  "fine-teenager",  "ending-credits",  "suspension-disbelief",  "fair-amount",  "back-forth",  "pg-13-sexual",  "difference-between",  "havent-seen",  "seem-more",  "two-films",  "bond-films",  "doesnt-quite",  "seeing-film",  "pop-culture",  "horror-films",  "walk-out",  "good-one",  "one-one",  "wonderful-life",  "though-film",  "turned-out",  "credits-roll",  "find-film",  "date-released",  "movie-takes",  "good-idea",  "more-important",  "especially-those",  "work-well",  "jackie-chan",  "strong-language",  "older-mature",  "story-doesnt",  "between-art",  "many-viewers",  "human-being",  "something-mary",  "much-less",  "film-well",  "camera-work",  "time-film",  "drug-content",  "bruce-willis",  "time-around",  "lot-fun",  "first-time-director",  "something-between",  "written-january",  "themes-violence",  "beginning-end",  "film-probably",  "long-enough",  "century-theaters",  "hong-kong",  "language-fine",  "piece-work",  "few-moments",  "out-place",  "art-films",  "1994-opinions",  "film-acceptable",  "facial-expressions",  "pg-13-brief",  "short-cuts",  "watching-movie",  "recent-films",  "film-becomes",  "two-characters",  "anthony-hopkins",  "much-movie",  "martin-scorsese",  "miramax-films",  "one-good",  "jean-luc-godard",  "many-different",  "violence-sexual",  "sexual-humor",  "movie-makes",  "directorial-debut",  "time-movie",  "good-guys",  "fine-ages",  "parts-movie",  "best-picture",  "one-reasons",  "picture-give",  "live-action",  "funny-moments",  "clint-eastwood",  "amc-century",  "minor-characters",  "social-commentary",  "film-gets",  "film-really",  "teenagers-recommend",  "good-job",  "works-best",  "one-favorite",  "mild-profanity",  "thought-movie",  "doesnt-mean",  "horror-movie",  "nudity-language",  "such-films",  "characters-film",  "few-years",  "more-serious",  "films-made",  "art-life",  "pg-13-adult",  "warner-brothers",  "thematic-elements",  "dont-see",  "forrest-gump",  "life-piece",  "far-less",  "thing-film",  "cinema-both",  "life-takes",  "language-drug",  "movie-fine",  "cinema-something",  "bad-taste",  "straight-out",  "weve-seen",  "last-summer",  "film-see",  "film-critics",  "situations-adult",  "make-mistake",  "long-way",  "few-more",  "movie-runs",  "violence-film",  "films-life",  "themes-sexual",  "violence-bad",  "parts-film",  "come-close",  "nudity-sexual",  "sex-violence",  "both-gives",  "unlike-painting",  "painting-literature",  "press-kit",  "cinema-art",  "cinema-slice",  "piece-cake",  "emotional-impact",  "life-unlike",  "film-didnt",  "film-still",  "literature-cinema",  "arent-many",  "takes-jean-luc",  "film-cant",  "more-few",  "watching-film",  "well-done",  "never-seems",  "good-bad",  "gave-1/2",  "one-way",  "make-more",  "becomes-more",  "jim-carrey",  "film-set",  "gives-life",  "first-movie",  "movie-filled",  "life-cinema",  "find-out",  "really-good",  "central-character",  "good-evil",  "plot-elements",  "sexual-innuendo",  "sandra-bullock",  "movie-thats",  "van-damme",  "united-states",  "story-never",  "few-laughs",  "film-best",  "little-mermaid",  "character-film",  "loose-ends",  "worth-caring",  "starship-troopers",  "steven-spielberg",  "classification-mpaa",  "isnt-nearly",  "type-film",  "mild-thumbs",  "nothing-special",  "make-much",  "acting-ability",  "very-bad",  "good-thing",  "film-thats",  "films-best",  "enough-recommend",  "last-year",  "many-more",  "enough-interested",  "valley-showing",  "film-opens",  "much-same",  "start-finish",  "smart-enough",  "doesnt-offer",  "problem-movie",  "best-known",  "better-movie",  "certainly-isnt",  "sort-movie",  "worth-price",  "doesnt-matter",  "pg-13-language",  "little-long",  "theaters-send",  "dumb-dumber",  "those-dont",  "content-acceptable",  "saving-grace",  "movie-bad",  "beauty-beast",  "film-story",  "more-fun",  "sex-scenes",  "rated-nudity",  "isnt-bad",  "film-version",  "doesnt-even",  "reservoir-dogs",  "doesnt-help",  "period-piece",  "rated-brief",  "film-seem",  "film-seen",  "film-such",  "way-out",  "out-way",  "even-worse",  "youre-going",  "production-values",  "film-tries",  "art-house",  "oliver-stone",  "script-doesnt",  "each-one",  "pleasant-enough",  "long-before",  "many-things",  "itself-seriously",  "fine-job",  "slow-motion",  "film-first",  "those-rare",  "take-long",  "language-film",  "year-old",  "one-long",  "much-sense",  "language-sexual",  "dont-make",  "didnt-know",  "situations-running",  "much-story",  "works-well",  "best-films",  "films-such",  "romeo-juliet",  "aspect-ratio",  "debut-feature",  "those-enjoy",  "far-better",  "films-title",  "pg-13-mature",  "blair-witch",  "fine-kid",  "gave-movie",  "kenneth-branagh",  "best-work",  "films-end",  "movie-best",  "makes-one",  "more-compelling",  "more-plot",  "found-film",  "fifth-element",  "starts-out",  "makes-feel",  "see-show",  "movie-good",  "showing-amc",  "price-admission",  "read-book",  "perhaps-more",  "made-more",  "rest-picture",  "those-scenes",  "tom-hanks",  "camera-angles",  "rated-mature",  "didnt-seem",  "everyone-love",  "john-hughes",  "nothing-offend",  "scene-film",  "man-woman",  "under-fire",  "end-movie",  "two-stars",  "time-director",  "little-violence",  "isnt-enough",  "more-film",  "first-feature",  "edge-seat",  "real-people",  "arnold-schwarzenegger",  "simple-story",  "last-film",  "nudity-acceptable",  "both-films",  "film-goes",  "isnt-particularly",  "thought-film",  "picture-one",  "christopher-walken",  "none-characters",  "strongly-recommend",  "age-innocence",  "check-out",  "language-brief",  "one-time",  "harrison-ford",  "film-seemed",  "scenes-between",  "themes-fine",  "two-people",  "long-film",  "time-one",  "von-trier",  "batman-robin",  "film-based",  "interaction-between",  "part-problem",  "production-design",  "good-news",  "big-laughs",  "even-less",  "little-film",  "during-course",  "recent-years",  "everything-film",  "character-interaction",  "previous-films",  "show-one",  "through-film",  "paramount-pictures",  "tour-force",  "something-special",  "little-time",  "seen-film",  "kids-age",  "film-although",  "car-chase",  "one-years",  "hard-imagine",  "audiences-attention",  "small-part",  "film-make",  "left-theater",  "much-ado",  "makes-more",  "film-moves",  "runs-little",  "movie-much",  "award-nomination",  "award-winning",  "dont-mind",  "supporting-players",  "offend-anyone",  "few-nice",  "more-subtle",  "going-through",  "theres-reason",  "movie-year",  "even-film",  "stand-out",  "movie-works",  "strong-enough",  "punch-lines",  "worth-watching",  "sort-film",  "rest-story",  "film-something",  "nice-guy",  "movie-without",  "lost-world",  "takes-itself",  "cast-members",  "courage-under",  "film-wasnt",  "good-intentions",  "dark-comedy",  "rated-nc-17",  "film-plays",  "isnt-even",  "movie-seems",  "more-more",  "strong-performances",  "twenty-years",  "lead-character",  "fast-paced",  "movie-really",  "movie-even",  "give-thumbs",  "screenplay-john",  "story-much",  "large-part",  "written-june",  "never-made",  "brady-bunch",  "steve-martin",  "david-mamet",  "spend-time",  "high-points",  "french-subtitles",  "life-film",  "perfectly-cast",  "original-film",  "good-looks",  "nudity-bad",  "isnt-quite",  "great-fun",  "video-game",  "julia-roberts",  "notre-dame",  "film-going",  "more-enough",  "best-scenes",  "two-movies",  "theres-never",  "kevin-costner",  "del-toro",  "going-happen",  "cross-between",  "sweet-little",  "theatrical-aspect",  "human-nature",  "another-film",  "breaking-waves",  "far-much",  "before-sunrise",  "cant-even",  "right-down",  "kids-movie",  "giving-film",  "film-certainly",  "john-sayles",  "film-worth",  "interesting-character",  "award-one",  "movies-one",  "story-isnt",  "last-seen",  "written-october",  "violence-nudity",  "profanity-brief",  "saturday-night",  "main-story",  "bad-thing",  "first-foremost",  "two-actors",  "think-movie",  "toward-end",  "come-alive",  "half-movie",  "nudity-little",  "music-video",  "violence-gore",  "story-thats",  "more-complex",  "spinal-tap",  "dont-understand",  "characters-more",  "low-key",  "murder-mystery",  "dont-expect",  "those-movies",  "liked-movie",  "new-film",  "several-scenes",  "director-stephen",  "theres-sense",  "kids-movies",  "bad-movies",  "funny-film",  "doesnt-always",  "want-know",  "nothing-new",  "film-stock",  "towards-end",  "pg-13-rating",  "take-away",  "hugh-grant",  "several-times",  "film-feels",  "find-themselves",  "whole-family",  "question-whether",  "dont-worry",  "film-starts",  "aspects-film",  "truman-show",  "movie-film",  "being-one",  "kid-old",  "language-sex",  "sound-effects",  "over-top",  "film-shot",  "best-parts",  "bad-news",  "aspect-film",  "beverly-hills",  "one-very",  "little-sense",  "david-lynch",  "best-friends",  "richard-iii",  "movie-first",  "intelligent-script",  "story-movie",  "look-good",  "dont-work",  "without-giving",  "das-boot",  "full-monty",  "hollywood-films",  "near-end",  "film-being",  "one-wonders",  "more-substantial",  "biggest-problem",  "quite-bit",  "viewers-find",  "acting-talent",  "lead-role",  "movie-tries",  "until-last",  "good-story",  "isnt-exactly",  "until-end",  "such-one",  "comes-close",  "scene-movie",  "taken-seriously",  "primary-colors",  "isnt-really",  "crude-humor",  "love-stories",  "excellent-job",  "opening-scene",  "film-full",  "seeing-movie",  "brought-screen",  "characters-story",  "teenagers-see",  "takes-time",  "movie-give",  "particularly-good",  "101-dalmatians",  "dont-even",  "perhaps-even",  "story-many",  "last-scene",  "film-theres",  "never-gets",  "one-such",  "those-two",  "dont-need",  "family-entertainment",  "compelling-story",  "graphic-violence",  "beneath-surface",  "director-mike",  "good-acting",  "film-though",  "give-picture",  "nicolas-cage",  "nearly-enough",  "bond-film",  "thats-good",  "fine-performances",  "actors-actresses",  "between-characters",  "over-years",  "out-more",  "world-war",  "thats-more",  "remains-day",  "enough-keep",  "watch-film",  "wag-dog",  "based-true",  "four-weddings",  "movie-comes",  "always-seems",  "result-film",  "100-minutes",  "bad-things",  "film-contains",  "fall-love",  "jerry-maguire",  "kids-over",  "quite-sure",  "teenagers-older",  "theres-still",  "points-out",  "eddie-murphy",  "make-feel",  "20th-century",  "two-main",  "martial-arts",  "rated-sexual",  "theres-doubt",  "film-long",  "thats-one",  "isnt-one",  "one-big",  "movie-full",  "movie-gets",  "battle-scenes",  "live-die",  "funny-one",  "over-two",  "sense-sensibility",  "film-funny",  "movie-still",  "theres-even",  "one-movies",  "refreshing-see",  "ado-nothing",  "didnt-make",  "waiting-guffman",  "frontal-nudity",  "robert-duvall",  "thats-exactly",  "even-best",  "much-longer",  "worth-noting",  "george-lucas",  "stands-out",  "violence-sexuality",  "way-long",  "love-interest",  "message-film",  "opening-sequence",  "movie-little",  "during-movie",  "matter-much",  "nutty-professor",  "fun-watching",  "tim-burton",  "time-kill",  "nudity-fine",  "come-expect",  "one-characters",  "fall-flat",  "columbia-pictures",  "independent-film",  "through-eyes",  "language-sexuality",  "movie-1/2",  "robert-niro",  "basic-instinct",  "runs-feels",  "company-men",  "scenes-film",  "thumbs-1/2",  "youll-probably",  "more-less",  "press-notes",  "two-hour",  "one-really",  "nothing-much",  "more-real",  "sundance-film",  "musical-score",  "more-powerful",  "good-guy",  "best-supporting",  "nothing-short",  "hunchback-notre",  "film-few",  "suspend-disbelief",  "isnt-funny",  "somewhere-between",  "supporting-roles",  "bathroom-humor",  "distributor-miramax",  "film-movie",  "more-concerned",  "little-sex",  "characters-dont",  "lost-highway",  "worse-still",  "minute-running",  "made-look",  "movie-feels",  "less-successful",  "during-first",  "art-film",  "sleepless-seattle",  "kevin-spacey",  "las-vegas",  "virtually-nothing",  "guilty-pleasure",  "time-movies",  "attention-detail",  "true-lies",  "french-film",  "family-films",  "seen-movie",  "fun-film",  "plays-part",  "center-stage",  "free-willy",  "mystery-story",  "see-again",  "comes-alive",  "something-little",  "movie-features",  "made-movie",  "far-away",  "piece-acting",  "scenes-one",  "story-seems",  "director-james",  "those-moments",  "movie-two",  "scary-movie",  "director-richard",  "blown-away",  "time-spent",  "coen-brothers",  "doesnt-appear",  "boogie-nights",  "early-film",  "more-enjoyable",  "les-miserables",  "film-kind",  "last-action",  "universal-pictures",  "film-industry",  "film-look",  "minutes-long",  "half-dozen",  "final-scene",  "more-successful",  "one-doesnt",  "film-way",  "more-appropriate",  "absolutely-nothing",  "feature-length",  "making-movie",  "entirely-different",  "running-around",  "good-measure",  "adam-sandler",  "world-cinema",  "work-here",  "see-something",  "ending-film",  "someone-elses",  "theme-song",  "first-two",  "few-things",  "comes-through",  "keep-audience",  "psychological-thriller",  "naked-gun",  "makes-want",  "john-malkovich",  "such-thing",  "best-actor",  "director-jonathan",  "profanity-nudity",  "already-know",  "dope-smoking",  "over-head",  "anyone-age",  "never-again",  "characters-seem",  "role-film",  "many-recent",  "full-frontal",  "never-takes",  "plays-role",  "way-movie",  "film-shows",  "movie-movie",  "kama-sutra",  "film-looks",  "dantes-peak",  "rated-sexuality",  "dont-really",  "film-quite",  "story-without",  "quite-few",  "youre-looking",  "oscar-nomination",  "more-entertaining",  "spitfire-grill",  "best-movie",  "fact-theres",  "robert-altman",  "john-cusack",  "philadelphia-festival",  "movie-set",  "opposite-sex",  "characters-never",  "including-one",  "movie-director",  "solid-performances",  "pictures-classics",  "dark-side",  "better-script",  "quite-well",  "animated-feature",  "little-movie",  "nothing-less",  "content-language",  "make-good",  "made-sense",  "story-characters",  "know-last",  "love-hate",  "top-form",  "played-out",  "know-more",  "movie-ends",  "more-films",  "actors-play",  "sweet-hereafter",  "things-going",  "more-anything",  "film-better",  "best-one",  "one-much",  "those-elements",  "festival-world",  "citizen-kane",  "animated-film",  "didnt-care",  "film-bad",  "film-end",  "film-far",  "script-based",  "easily-one",  "theres-plenty",  "movie-make",  "ive-never",  "make-such",  "care-characters",  "film-french",  "billy-crystal",  "denis-leary",  "although-many",  "acceptable-ages",  "time-frame",  "part-show",  "great-movie",  "plot-devices",  "whole-movie",  "first-act",  "private-parts",  "starring-role",  "nudity-running",  "visual-style",  "105-minutes",  "human-drama",  "same-level",  "film-actually",  "alfred-hitchcock",  "look-film",  "performance-one",  "dont-take",  "script-full",  "sixth-sense",  "nudity-adult",  "film-trying",  "short-film",  "situations-profanity",  "another-one",  "perhaps-one",  "over-again",  "little-story",  "american-audiences",  "over-over",  "based-play",  "liar-liar",  "best-director",  "genuine-chemistry",  "way-another",  "good-parts",  "john-woo",  "comes-out",  "energy-level",  "lot-time",  "shown-philadelphia",  "slightly-more",  "theres-way",  "although-one",  "members-audience",  "few-lines",  "movies-more",  "family-values",  "previous-film",  "reason-care",  "through-movie",  "action-violence",  "night-live",  "sony-pictures",  "right-wrong",  "blood-gore",  "weddings-funeral",  "rated-little",  "sex-profanity",  "movie-people",  "audience-members",  "real-world",  "monty-python",  "rush-hour",  "best-performances",  "well-cast",  "see-much",  "air-force",  "more-once",  "never-see",  "film-nothing",  "fully-developed",  "one-hand",  "best-lines",  "same-kind",  "quality-film",  "cutting-room",  "whose-last",  "same-name",  "better-one",  "doesnt-feel",  "feature-debut",  "best-way",  "movie-theater",  "director-steven",  "attempts-humor",  "slightly-different",  "those-characters",  "keanu-reeves",  "films-conclusion",  "film-two",  "make-audience",  "given-more",  "completely-different",  "extremely-funny",  "silence-lambs",  "bit-much",  "scene-one",  "more-little",  "force-one",  "movie-although",  "goes-long",  "film-work",  "wide-variety",  "another-movie",  "find-something",  "idea-film",  "outer-space",  "supporting-role",  "slapstick-comedy",  "carried-away",  "talented-cast",  "rated-fine",  "youve-never",  "movie-worth",  "austin-powers",  "language-mature",  "fathers-day",  "differences-between",  "set-design",  "ice-storm",  "answer-question",  "new-ground",  "once-upon",  "dance-numbers",  "against-type",  "tells-story",  "movie-becomes",  "one-minute",  "lead-characters",  "lot-people",  "movie-actually",  "having-fun",  "didnt-see",  "strikes-back",  "film-characters",  "little-much",  "film-acting",  "care-less",  "title-film",  "enjoy-film",  "action-picture",  "care-much",  "saw-film",  "built-around",  "michael-keaton",  "runs-out",  "film-experience",  "waynes-world",  "funny-lines",  "meg-ryan",  "vastly-different",  "lead-actors",  "strong-sexuality",  "quite-same",  "comedy-drama",  "best-moments",  "film-come",  "second-time",  "wanted-make",  "film-done",  "film-dont",  "profanity-sex",  "one-person",  "one-major",  "thing-certain",  "script-director",  "film-whose",  "film-feel",  "big-budget",  "one-interesting",  "title-role",  "one-even",  "see-more",  "even-one",  "hard-eight",  "usual-suspects",  "part-picture",  "themes-brief",  "high-level",  "best-foreign",  "one-reason",  "more-difficult",  "perfect-example",  "worth-look",  "movie-going",  "thats-way",  "becomes-clear",  "one-moment",  "high-concept",  "action-thriller",  "love-catastrophes",  "minutes-movie",  "strong-sexual",  "chasing-amy",  "makes-much",  "written-1996",  "last-few",  "make-seem",  "run-out",  "surprise-ending",  "things-happen",  "pokes-fun",  "situations-nudity",  "car-chases",  "youll-find",  "dont-miss",  "movie-plays",  "few-many",  "make-want",  "less-effective",  "time-105",  "century-fox",  "story-such",  "film-year",  "seen-through",  "story-tell",  "story-really",  "juliette-lewis",  "denzel-washington",  "never-more",  "film-lacks",  "films-last",  "based-book",  "director-brian",  "bad-enough",  "music-john",  "mel-gibson",  "films-more",  "sex-scene",  "rated-nothing",  "history-lesson",  "dysfunctional-family",  "still-one",  "farewell-concubine",  "through-entire",  "scenes-movie",  "barry-levinson",  "screenplay-peter",  "wesley-snipes",  "rated-mild",  "films-opening",  "male-female",  "martin-lawrence",  "out-much",  "enough-give",  "entire-life",  "main-problem",  "krzysztof-kieslowski",  "interesting-enough",  "director-roger",  "thirty-years",  "incorrectly-rated",  "feel-sorry",  "moments-film",  "chain-reaction",  "first-half-hour",  "film-great",  "youd-expect",  "much-anything",  "dont-ask",  "done-before",  "rating-sexual",  "sliding-doors",  "basic-plot",  "muriels-wedding",  "gives-one",  "bunch-movie",  "unlike-many",  "never-comes",  "pointe-blank",  "bring-myself",  "disney-animated",  "nothing-film",  "film-both",  "few-people",  "city-slickers",  "more-two",  "hollywood-film",  "worked-well",  "crude-sexual",  "fleshed-out",  "isnt-good",  "friends-wedding",  "doesnt-exactly",  "around-send",  "stage-play",  "love-film",  "one-half",  "two-years",  "story-story",  "next-time",  "red-line",  "memorable-lines",  "grand-canyon",  "doesnt-come",  "theres-question",  "take-look",  "very-hard",  "cant-make",  "certainly-doesnt",  "during-film",  "funny-enough",  "sling-blade",  "film-1/2",  "very-different",  "con-air",  "really-liked",  "easy-understand",  "january-1997",  "many-good",  "english-patient",  "conflict-between",  "chance-see",  "given-much",  "coming-of-age-story",  "film-same",  "movie-many",  "year-list",  "take-time",  "both-actors",  "actors-playing",  "hes-more",  "forth-between",  "first-glance",  "feature-director",  "sexuality-fine",  "leslie-nielsen",  "come-along",  "years-best",  "richard-gere",  "much-plot",  "anything-new",  "deep-impact",  "film-failed",  "19th-century",  "message-movie",  "recent-memory",  "characters-make",  "become-more",  "look-feel",  "never-feels",  "here-film",  "first-time-writer",  "john-travolta",  "liked-way",  "dont-surprised",  "doesnt-want",  "three-main",  "cant-see",  "pelican-brief",  "big-game",  "characters-little",  "empire-strikes",  "change-pace",  "sort-thing",  "val-kilmer",  "ace-ventura",  "big-night",  "story-becomes",  "absolute-power",  "movies-best",  "rise-above",  "quirky-characters",  "everything-seems",  "kenneth-branaghs",  "come-back",  "cats-dogs",  "enough-film",  "winona-ryder",  "release-date",  "gene-hackman",  "comes-mind",  "people-dont",  "good-reason",  "michelle-pfeiffer",  "real-story",  "final-analysis",  "profanity-drug",  "certain-amount",  "demi-moore",  "female-characters",  "far-best",  "those-familiar",  "arent-enough",  "noir-films",  "city-angels",  "comic-moments",  "dustin-hoffman",  "little-things",  "type-movie",  "youll-see",  "indiana-jones",  "cutting-edge",  "noir-thriller",  "smile-face",  "big-fan",  "actors-film",  "american-film",  "george-jungle",  "thin-red",  "around-nine",  "john-turturro",  "far-long",  "thing-movie",  "probably-best",  "moves-along",  "little-better",  "much-different",  "aspect-movie",  "twentieth-century",  "animated-features",  "one-fine",  "director-jon",  "humor-movie",  "grosse-pointe",  "age-1/2",  "movies-year",  "story-didnt",  "three-hours",  "cautionary-tale",  "jackie-brown",  "top-rating",  "star-film",  "femme-fatale",  "movie-starts",  "air-bud",  "wedding-singer",  "those-under",  "one-key",  "movie-gave",  "old-men",  "more-screen",  "film-filled",  "before-film",  "comedy-film",  "same-thing",  "doesnt-give",  "show-give",  "virtually-impossible",  "acting-good",  "story-makes",  "very-long",  "very-few",  "gwyneth-paltrow",  "seven-years",  "makes-movie",  "situations-violence",  "way-story",  "1/2-star",  "computer-generated",  "many-great",  "much-energy",  "performance-film",  "wings-desire",  "forty-five-minutes",  "around-corner",  "interesting-story",  "real-problem",  "find-one",  "whole-thing",  "line-fire",  "easily-best",  "spike-lee",  "first-one",  "mild-language",  "time-see",  "room-floor",  "years-later",  "pointed-out",  "laughably-bad",  "hollywood-pictures",  "really-isnt",  "films-many",  "feels-more",  "bring-out",  "movie-well",  "samuel-jackson",  "without-resorting",  "kevin-smith",  "came-out",  "darn-cat",  "film-nevertheless",  "director-paul",  "long-line",  "out-movie",  "dramatic-music",  "more-human",  "solid-entertainment",  "dead-man",  "farrelly-brothers",  "didnt-work",  "youd-think",  "young-kids",  "shall-dance",  "worth-recommending",  "sexual-references",  "drew-barrymore",  "woody-allens",  "cant-quite",  "strong-performance",  "well-enough",  "heavenly-creatures",  "dark-city",  "whose-previous",  "power-rangers",  "looking-richard",  "love-jones",  "masterpiece-theater",  "miracle-34th",  "more-appealing",  "original-movie",  "nice-job",  "sean-penn",  "animated-movie",  "body-language",  "although-few",  "film-critic",  "seems-little",  "jingle-way",  "look-one",  "last-picture",  "witch-project",  "rating-nudity",  "black-hat",  "many-others",  "stock-characters",  "really-funny",  "more-passing",  "billy-bob",  "screenplay-michael",  "politically-incorrect",  "first-major",  "work-one",  "connection-between",  "things-dont",  "seen-one",  "kids-show",  "didnt-think",  "third-act",  "cannes-film",  "american-beauty",  "many-lines",  "talking-heads",  "another-example",  "younger-kids",  "seen-more",  "much-attention",  "good-looking",  "cartoonish-violence",  "times-movie",  "final-credits",  "film-always",  "film-left",  "kevin-williamson",  "movie-find",  "story-gets",  "something-different",  "gratuitous-violence",  "written-december",  "much-happens",  "needs-more",  "movie-great",  "liked-film",  "small-role",  "first-minutes",  "welcome-dollhouse",  "film-over",  "probably-pg-13",  "oscar-nominations",  "two-three",  "bad-idea",  "joy-luck",  "make-laugh",  "film-think",  "hardly-wait",  "very-difficult",  "monster-movie",  "movie-stars",  "disaster-movie",  "little-bad",  "way-around",  "work-film",  "show-more",  "second-act",  "much-going",  "extremely-effective",  "los-angeles",  "larry-flynt",  "better-films",  "completely-satisfying",  "theres-denying",  "action-flick",  "movie-same",  "look-back",  "come-surprise",  "short-story",  "walt-disney",  "34th-street",  "straight-face",  "feels-much",  "screenplay-robert",  "carry-film",  "times-film",  "good-gets",  "principal-characters",  "line-features",  "wonder-whether",  "made-one",  "everyone-film",  "major-league",  "becomes-apparent",  "good-laughs",  "little-picture",  "written-august",  "bad-one",  "foreign-language"  };
	//1270--public static String[] bigramList={"films-year" ,  "see-film" ,  "motion-picture" ,  "film-excellent" ,  "movie-kind" ,  "waste-money" ,  "average-movie" ,  "dont-waste" ,  "show-dont" ,  "excellent-show" ,  "show-look" ,  "kind-enjoyable" ,  "enjoyable-poor" ,  "poor-show" ,  "look-average" ,  "opinions-expressed" ,  "meant-reflect" ,  "mine-meant" ,  "reflect-employers" ,  "expressed-mine" ,  "running-time" ,  "few-films" ,  "one-worst" ,  "worst-films" ,  "message-subject" ,  "reply-message" ,  "details-reply" ,  "one-top" ,  "money-one" ,  "year-see" ,  "totally-unbearable" ,  "year-totally" ,  "top-few" ,  "rated-pg-13" ,  "mpaa-rating" ,  "subject-line" ,  "much-more" ,  "even-though" ,  "special-effects" ,  "even-more" ,  "little-more" ,  "adult-themes" ,  "unbearable-opinions" ,  "fine-kids" ,  "screening-room" ,  "son-jeffrey" ,  "see-screening" ,  "subject-subscribe" ,  "room-details" ,  "much-better" ,  "fine-teenagers" ,  "one-those" ,  "kids-around" ,  "sex-nudity" ,  "see-moviepage" ,  "moviepage-details" ,  "line-subscribe" ,  "jeffrey-age" ,  "painfully-unbearable" ,  "money-totally" ,  "unbearable-picture" ,  "totally-painfully" ,  "sexual-situations" ,  "turns-out" ,  "older-teenagers" ,  "english-subtitles" ,  "theres-nothing" ,  "review-written" ,  "romantic-comedy" ,  "film-one" ,  "word-subscribe" ,  "letter-word" ,  "subscribe-subject" ,  "send-letter" ,  "acceptable-teenagers" ,  "screen-time" ,  "motion-pictures" ,  "running-length" ,  "love-story" ,  "character-study" ,  "film-makers" ,  "mature-themes" ,  "two-hours" ,  "far-more" ,  "subject-matter" ,  "between-two" ,  "runs-rated" ,  "acceptable-older" ,  "chemistry-between" ,  "one-thing" ,  "action-sequences" ,  "film-more" ,  "first-time" ,  "bad-language" ,  "character-development" ,  "brief-nudity" ,  "themes-running" ,  "supporting-cast" ,  "one-best" ,  "theres-something" ,  "rated-violence" ,  "profanity-adult" ,  "rating-pg-13" ,  "violence-profanity" ,  "star-wars" ,  "film-fine" ,  "picture-opinions" ,  "figure-out" ,  "time-minutes" ,  "acceptable-kids" ,  "language-acceptable" ,  "give-1/2" ,  "academy-award" ,  "nudity-violence" ,  "high-school" ,  "part-film" ,  "science-fiction" ,  "writer-director" ,  "first-half" ,  "1/2-one" ,  "film-made" ,  "box-office" ,  "action-film" ,  "main-characters" ,  "dont-know" ,  "last-years" ,  "more-interesting" ,  "subtitles-rated" ,  "one-many" ,  "great-deal" ,  "best-part" ,  "film-doesnt" ,  "along-way" ,  "doesnt-seem" ,  "theres-much" ,  "rating-profanity" ,  "bad-guys" ,  "unbearable-review" ,  "dont-think" ,  "takes-place" ,  "relationship-between" ,  "youve-seen" ,  "give-film" ,  "very-little" ,  "woody-allen" ,  "long-rated" ,  "big-screen" ,  "many-scenes" ,  "pulp-fiction" ,  "isnt-much" ,  "years-ago" ,  "movie-one" ,  "new-york" ,  "rated-strong" ,  "runs-long" ,  "director-john" ,  "want-see" ,  "see-movie" ,  "many-times" ,  "rated-sex" ,  "something-more" ,  "film-noir" ,  "one-more" ,  "worth-seeing" ,  "half-hour" ,  "ingmar-bergman" ,  "film-festival" ,  "never-quite" ,  "many-ways" ,  "doesnt-make" ,  "long-time" ,  "rated-language" ,  "bit-more" ,  "much-time" ,  "film-never" ,  "soap-opera" ,  "dont-want" ,  "movie-nothing" ,  "film-even" ,  "one-films" ,  "second-half" ,  "film-rated" ,  "nothing-more" ,  "kind-film" ,  "black-white" ,  "very-good" ,  "1997-opinions" ,  "make-sense" ,  "robin-williams" ,  "theres-little" ,  "make-film" ,  "one-few" ,  "profanity-violence" ,  "part-movie" ,  "one-scene" ,  "1/2-see" ,  "never-seen" ,  "sit-through" ,  "found-myself" ,  "film-making" ,  "film-much" ,  "picture-review" ,  "black-comedy" ,  "die-hard" ,  "film-makes" ,  "one-film" ,  "movie-rated" ,  "lot-more" ,  "screen-presence" ,  "profanity-fine" ,  "down-david" ,  "belief-movie" ,  "david-puttnam" ,  "nothing-life" ,  "sexual-content" ,  "people-neutral" ,  "makes-film" ,  "leave-down" ,  "neutral-leave" ,  "leaves-people" ,  "leave-leave" ,  "life-leaves" ,  "made-film" ,  "very-funny" ,  "theres-lot" ,  "very-much" ,  "give-one" ,  "enough-make" ,  "drug-use" ,  "based-novel" ,  "star-trek" ,  "written-directed" ,  "two-leads" ,  "one-point" ,  "action-films" ,  "pg-13-profanity" ,  "anything-more" ,  "film-takes" ,  "drug-usage" ,  "horror-film" ,  "ive-seen" ,  "sense-humor" ,  "doesnt-take" ,  "violence-language" ,  "put-together" ,  "film-maker" ,  "pg-13-violence" ,  "comic-relief" ,  "jurassic-park" ,  "feature-film" ,  "best-thing" ,  "nudity-profanity" ,  "first-place" ,  "film-film" ,  "theres-enough" ,  "plot-device" ,  "quite-good" ,  "violence-running" ,  "seen-before" ,  "movie-isnt" ,  "reason-see" ,  "doesnt-much" ,  "profanity-running" ,  "movie-more" ,  "without-being" ,  "violence-fine" ,  "many-characters" ,  "opening-credits" ,  "tell-story" ,  "doesnt-work" ,  "sight-gags" ,  "bad-movie" ,  "good-film" ,  "once-again" ,  "teenagers-send" ,  "kind-movie" ,  "real-life" ,  "action-scenes" ,  "plot-twists" ,  "age-gave" ,  "those-films" ,  "physical-comedy" ,  "fairy-tale" ,  "show-fine" ,  "find-yourself" ,  "film-director" ,  "theres-one" ,  "seems-more" ,  "one-another" ,  "good-enough" ,  "great-film" ,  "first-film" ,  "mpaa-classification" ,  "turn-out" ,  "much-fun" ,  "true-story" ,  "bad-guy" ,  "entertainment-value" ,  "old-enough" ,  "more-interested" ,  "recommend-give" ,  "fifteen-minutes" ,  "one-expect" ,  "one-character" ,  "fine-older" ,  "recommend-film" ,  "length-mpaa" ,  "hard-believe" ,  "good-movie" ,  "way-through" ,  "mature-teenagers" ,  "comic-book" ,  "rest-movie" ,  "rated-profanity" ,  "leave-theater" ,  "around-son" ,  "sitting-through" ,  "film-isnt" ,  "taking-place" ,  "same-time" ,  "even-better" ,  "rest-film" ,  "correctly-rated" ,  "director-robert" ,  "french-english" ,  "entire-movie" ,  "ensemble-cast" ,  "one-two" ,  "happy-ending" ,  "theres-more" ,  "waste-time" ,  "tries-hard" ,  "fine-line" ,  "romantic-comedies" ,  "throughout-film" ,  "come-out" ,  "violence-acceptable" ,  "profanity-sexual" ,  "many-films" ,  "pretty-good" ,  "never-really" ,  "men-women" ,  "much-film" ,  "make-sure" ,  "film-very" ,  "story-told" ,  "point-out" ,  "supporting-characters" ,  "doesnt-really" ,  "television-series" ,  "themes-profanity" ,  "story-itself" ,  "first-hour" ,  "story-film" ,  "film-works" ,  "story-line" ,  "story-more" ,  "james-bond" ,  "mission-impossible" ,  "family-film" ,  "serial-killer" ,  "entire-film" ,  "unbearable-reviewed" ,  "good-time" ,  "few-minutes" ,  "action-hero" ,  "quentin-tarantino" ,  "reviewed-written" ,  "director-peter" ,  "lion-king" ,  "schindlers-list" ,  "toy-story" ,  "making-film" ,  "telling-story" ,  "rated-probably" ,  "times-before" ,  "gives-film" ,  "give-see" ,  "movie-made" ,  "main-character" ,  "film-itself" ,  "even-those" ,  "more-effective" ,  "recommend-movie" ,  "feel-good" ,  "ten-minutes" ,  "manages-make" ,  "more-one" ,  "hour-half" ,  "movie-never" ,  "film-many" ,  "five-minutes" ,  "whole-lot" ,  "film-seems" ,  "love-affair" ,  "best-film" ,  "kids-under" ,  "film-good" ,  "low-budget" ,  "film-without" ,  "movie-doesnt" ,  "doesnt-know" ,  "visual-effects" ,  "many-people" ,  "recommend-picture" ,  "twenty-minutes" ,  "trying-make" ,  "romance-between" ,  "more-impressive" ,  "home-alone" ,  "best-performance" ,  "perhaps-best" ,  "ages-son" ,  "quite-funny" ,  "1995-opinions" ,  "1996-opinions" ,  "very-well" ,  "out-film" ,  "makes-sense" ,  "good-sense" ,  "twists-turns" ,  "human-beings" ,  "closing-credits" ,  "end-film" ,  "minutes-film" ,  "see-one" ,  "part-story" ,  "bad-film" ,  "thumbs-down" ,  "screenplay-david" ,  "without-much" ,  "both-sides" ,  "nudity-sex" ,  "age-thought" ,  "better-film" ,  "length-rated" ,  "sexuality-acceptable" ,  "film-give" ,  "cant-help" ,  "film-offers" ,  "musical-numbers" ,  "independence-day" ,  "director-michael" ,  "little-bit" ,  "end-credits" ,  "story-one" ,  "director-david" ,  "out-one" ,  "gave-film" ,  "film-little" ,  "rating-violence" ,  "high-energy" ,  "out-loud" ,  "thirty-minutes" ,  "source-material" ,  "well-worth" ,  "same-way" ,  "whats-going" ,  "film-ends" ,  "set-pieces" ,  "give-movie" ,  "more-time" ,  "dont-care" ,  "one-better" ,  "first-part" ,  "fun-watch" ,  "point-view" ,  "recommend-show" ,  "press-screening" ,  "way-film" ,  "slice-life" ,  "rest-cast" ,  "problem-film" ,  "think-film" ,  "ninety-minutes" ,  "point-film" ,  "award-1/2" ,  "few-scenes" ,  "noir-film" ,  "entertaining-film" ,  "film-comes" ,  "movie-itself" ,  "few-times" ,  "little-profanity" ,  "line-between" ,  "one-great" ,  "many-movies" ,  "target-audience" ,  "despite-being" ,  "steven-seagal" ,  "sexuality-language" ,  "films-one" ,  "although-film" ,  "strong-violence" ,  "take-place" ,  "violence-sex" ,  "half-film" ,  "characters-situations" ,  "pretty-much" ,  "language-violence" ,  "although-movie" ,  "easy-see" ,  "silicon-valley" ,  "title-character" ,  "make-movie" ,  "violence-adult" ,  "film-those" ,  "few-good" ,  "last-act" ,  "fine-teenager" ,  "ending-credits" ,  "suspension-disbelief" ,  "fair-amount" ,  "back-forth" ,  "pg-13-sexual" ,  "difference-between" ,  "havent-seen" ,  "seem-more" ,  "two-films" ,  "bond-films" ,  "doesnt-quite" ,  "seeing-film" ,  "pop-culture" ,  "horror-films" ,  "walk-out" ,  "good-one" ,  "one-one" ,  "wonderful-life" ,  "though-film" ,  "turned-out" ,  "credits-roll" ,  "find-film" ,  "date-released" ,  "movie-takes" ,  "good-idea" ,  "more-important" ,  "especially-those" ,  "work-well" ,  "jackie-chan" ,  "strong-language" ,  "older-mature" ,  "story-doesnt" ,  "between-art" ,  "many-viewers" ,  "human-being" ,  "something-mary" ,  "much-less" ,  "film-well" ,  "camera-work" ,  "time-film" ,  "drug-content" ,  "bruce-willis" ,  "time-around" ,  "lot-fun" ,  "first-time-director" ,  "something-between" ,  "written-january" ,  "themes-violence" ,  "beginning-end" ,  "film-probably" ,  "long-enough" ,  "century-theaters" ,  "hong-kong" ,  "language-fine" ,  "piece-work" ,  "few-moments" ,  "out-place" ,  "art-films" ,  "1994-opinions" ,  "film-acceptable" ,  "facial-expressions" ,  "pg-13-brief" ,  "short-cuts" ,  "watching-movie" ,  "recent-films" ,  "film-becomes" ,  "two-characters" ,  "anthony-hopkins" ,  "much-movie" ,  "martin-scorsese" ,  "miramax-films" ,  "one-good" ,  "jean-luc-godard" ,  "many-different" ,  "violence-sexual" ,  "sexual-humor" ,  "movie-makes" ,  "directorial-debut" ,  "time-movie" ,  "good-guys" ,  "fine-ages" ,  "parts-movie" ,  "best-picture" ,  "one-reasons" ,  "picture-give" ,  "live-action" ,  "funny-moments" ,  "clint-eastwood" ,  "amc-century" ,  "minor-characters" ,  "social-commentary" ,  "film-gets" ,  "film-really" ,  "teenagers-recommend" ,  "good-job" ,  "works-best" ,  "one-favorite" ,  "mild-profanity" ,  "thought-movie" ,  "doesnt-mean" ,  "horror-movie" ,  "nudity-language" ,  "such-films" ,  "characters-film" ,  "few-years" ,  "more-serious" ,  "films-made" ,  "art-life" ,  "pg-13-adult" ,  "warner-brothers" ,  "thematic-elements" ,  "dont-see" ,  "forrest-gump" ,  "life-piece" ,  "far-less" ,  "thing-film" ,  "cinema-both" ,  "life-takes" ,  "language-drug" ,  "movie-fine" ,  "cinema-something" ,  "bad-taste" ,  "straight-out" ,  "weve-seen" ,  "last-summer" ,  "film-see" ,  "film-critics" ,  "situations-adult" ,  "make-mistake" ,  "long-way" ,  "few-more" ,  "movie-runs" ,  "violence-film" ,  "films-life" ,  "themes-sexual" ,  "violence-bad" ,  "parts-film" ,  "come-close" ,  "nudity-sexual" ,  "sex-violence" ,  "both-gives" ,  "unlike-painting" ,  "painting-literature" ,  "press-kit" ,  "cinema-art" ,  "cinema-slice" ,  "piece-cake" ,  "emotional-impact" ,  "life-unlike" ,  "film-didnt" ,  "film-still" ,  "literature-cinema" ,  "arent-many" ,  "takes-jean-luc" ,  "film-cant" ,  "more-few" ,  "watching-film" ,  "well-done" ,  "never-seems" ,  "good-bad" ,  "gave-1/2" ,  "one-way" ,  "make-more" ,  "becomes-more" ,  "jim-carrey" ,  "film-set" ,  "gives-life" ,  "first-movie" ,  "movie-filled" ,  "life-cinema" ,  "find-out" ,  "really-good" ,  "central-character" ,  "good-evil" ,  "plot-elements" ,  "sexual-innuendo" ,  "sandra-bullock" ,  "movie-thats" ,  "van-damme" ,  "united-states" ,  "story-never" ,  "few-laughs" ,  "film-best" ,  "little-mermaid" ,  "character-film" ,  "loose-ends" ,  "worth-caring" ,  "starship-troopers" ,  "steven-spielberg" ,  "classification-mpaa" ,  "isnt-nearly" ,  "type-film" ,  "mild-thumbs" ,  "nothing-special" ,  "make-much" ,  "acting-ability" ,  "very-bad" ,  "good-thing" ,  "film-thats" ,  "films-best" ,  "enough-recommend" ,  "last-year" ,  "many-more" ,  "enough-interested" ,  "valley-showing" ,  "film-opens" ,  "much-same" ,  "start-finish" ,  "smart-enough" ,  "doesnt-offer" ,  "problem-movie" ,  "best-known" ,  "better-movie" ,  "certainly-isnt" ,  "sort-movie" ,  "worth-price" ,  "doesnt-matter" ,  "pg-13-language" ,  "little-long" ,  "theaters-send" ,  "dumb-dumber" ,  "those-dont" ,  "content-acceptable" ,  "saving-grace" ,  "movie-bad" ,  "beauty-beast" ,  "film-story" ,  "more-fun" ,  "sex-scenes" ,  "rated-nudity" ,  "isnt-bad" ,  "film-version" ,  "doesnt-even" ,  "reservoir-dogs" ,  "doesnt-help" ,  "period-piece" ,  "rated-brief" ,  "film-seem" ,  "film-seen" ,  "film-such" ,  "way-out" ,  "out-way" ,  "even-worse" ,  "youre-going" ,  "production-values" ,  "film-tries" ,  "art-house" ,  "oliver-stone" ,  "script-doesnt" ,  "each-one" ,  "pleasant-enough" ,  "long-before" ,  "many-things" ,  "itself-seriously" ,  "fine-job" ,  "slow-motion" ,  "film-first" ,  "those-rare" ,  "take-long" ,  "language-film" ,  "year-old" ,  "one-long" ,  "much-sense" ,  "language-sexual" ,  "dont-make" ,  "didnt-know" ,  "situations-running" ,  "much-story" ,  "works-well" ,  "best-films" ,  "films-such" ,  "romeo-juliet" ,  "aspect-ratio" ,  "debut-feature" ,  "those-enjoy" ,  "far-better" ,  "films-title" ,  "pg-13-mature" ,  "blair-witch" ,  "fine-kid" ,  "gave-movie" ,  "kenneth-branagh" ,  "best-work" ,  "films-end" ,  "movie-best" ,  "makes-one" ,  "more-compelling" ,  "more-plot" ,  "found-film" ,  "fifth-element" ,  "starts-out" ,  "makes-feel" ,  "see-show" ,  "movie-good" ,  "showing-amc" ,  "price-admission" ,  "read-book" ,  "perhaps-more" ,  "made-more" ,  "rest-picture" ,  "those-scenes" ,  "tom-hanks" ,  "camera-angles" ,  "rated-mature" ,  "didnt-seem" ,  "everyone-love" ,  "john-hughes" ,  "nothing-offend" ,  "scene-film" ,  "man-woman" ,  "under-fire" ,  "end-movie" ,  "two-stars" ,  "time-director" ,  "little-violence" ,  "isnt-enough" ,  "more-film" ,  "first-feature" ,  "edge-seat" ,  "real-people" ,  "arnold-schwarzenegger" ,  "simple-story" ,  "last-film" ,  "nudity-acceptable" ,  "both-films" ,  "film-goes" ,  "isnt-particularly" ,  "thought-film" ,  "picture-one" ,  "christopher-walken" ,  "none-characters" ,  "strongly-recommend" ,  "age-innocence" ,  "check-out" ,  "language-brief" ,  "one-time" ,  "harrison-ford" ,  "film-seemed" ,  "scenes-between" ,  "themes-fine" ,  "two-people" ,  "long-film" ,  "time-one" ,  "von-trier" ,  "batman-robin" ,  "film-based" ,  "interaction-between" ,  "part-problem" ,  "production-design" ,  "good-news" ,  "big-laughs" ,  "even-less" ,  "little-film" ,  "during-course" ,  "recent-years" ,  "everything-film" ,  "character-interaction" ,  "previous-films" ,  "show-one" ,  "through-film" ,  "paramount-pictures" ,  "tour-force" ,  "something-special" ,  "little-time" ,  "seen-film" ,  "kids-age" ,  "film-although" ,  "car-chase" ,  "one-years" ,  "hard-imagine" ,  "audiences-attention" ,  "small-part" ,  "film-make" ,  "left-theater" ,  "much-ado" ,  "makes-more" ,  "film-moves" ,  "runs-little" ,  "movie-much" ,  "award-nomination" ,  "award-winning" ,  "dont-mind" ,  "supporting-players" ,  "offend-anyone" ,  "few-nice" ,  "more-subtle" ,  "going-through" ,  "theres-reason" ,  "movie-year" ,  "even-film" ,  "stand-out" ,  "movie-works" ,  "strong-enough" ,  "punch-lines" ,  "worth-watching" ,  "sort-film" ,  "rest-story" ,  "film-something" ,  "nice-guy" ,  "movie-without" ,  "lost-world" ,  "takes-itself" ,  "cast-members" ,  "courage-under" ,  "film-wasnt" ,  "good-intentions" ,  "dark-comedy" ,  "rated-nc-17" ,  "film-plays" ,  "isnt-even" ,  "movie-seems" ,  "more-more" ,  "strong-performances" ,  "twenty-years" ,  "lead-character" ,  "fast-paced" ,  "movie-really" ,  "movie-even" ,  "give-thumbs" ,  "screenplay-john" ,  "story-much" ,  "large-part" ,  "written-june" ,  "never-made" ,  "brady-bunch" ,  "steve-martin" ,  "david-mamet" ,  "spend-time" ,  "high-points" ,  "french-subtitles" ,  "life-film" ,  "perfectly-cast" ,  "original-film" ,  "good-looks" ,  "nudity-bad" ,  "isnt-quite" ,  "great-fun" ,  "video-game" ,  "julia-roberts" ,  "notre-dame" ,  "film-going" ,  "more-enough" ,  "best-scenes" ,  "two-movies" ,  "theres-never" ,  "kevin-costner" ,  "del-toro" ,  "going-happen" ,  "cross-between" ,  "sweet-little" ,  "theatrical-aspect" ,  "human-nature" ,  "another-film" ,  "breaking-waves" ,  "far-much" ,  "before-sunrise" ,  "cant-even" ,  "right-down" ,  "kids-movie" ,  "giving-film" ,  "film-certainly" ,  "john-sayles" ,  "film-worth" ,  "interesting-character" ,  "award-one" ,  "movies-one" ,  "story-isnt" ,  "last-seen" ,  "written-october" ,  "violence-nudity" ,  "profanity-brief" ,  "saturday-night" ,  "main-story" ,  "bad-thing" ,  "first-foremost" ,  "two-actors" ,  "think-movie" ,  "toward-end" ,  "come-alive" ,  "half-movie" ,  "nudity-little" ,  "music-video" ,  "violence-gore" ,  "story-thats" ,  "more-complex" ,  "spinal-tap" ,  "dont-understand" ,  "characters-more" ,  "low-key" ,  "murder-mystery" ,  "dont-expect" ,  "those-movies" ,  "liked-movie" ,  "new-film" ,  "several-scenes" ,  "director-stephen" ,  "theres-sense" ,  "kids-movies" ,  "bad-movies" ,  "funny-film" ,  "doesnt-always" ,  "want-know" ,  "nothing-new" ,  "film-stock" ,  "towards-end" ,  "pg-13-rating" ,  "take-away" ,  "hugh-grant" ,  "several-times" ,  "film-feels" ,  "find-themselves" ,  "whole-family" ,  "question-whether" ,  "dont-worry" ,  "film-starts" ,  "aspects-film" ,  "truman-show" ,  "movie-film" ,  "being-one" ,  "kid-old" ,  "language-sex" ,  "sound-effects" ,  "over-top" ,  "film-shot" ,  "best-parts" ,  "bad-news" ,  "aspect-film" ,  "beverly-hills" ,  "one-very" ,  "little-sense" ,  "david-lynch" ,  "best-friends" ,  "richard-iii" ,  "movie-first" ,  "intelligent-script" ,  "story-movie" ,  "look-good" ,  "dont-work" ,  "without-giving" ,  "das-boot" ,  "full-monty" ,  "hollywood-films" ,  "near-end" ,  "film-being" ,  "one-wonders" ,  "more-substantial" ,  "biggest-problem" ,  "quite-bit" ,  "viewers-find" ,  "acting-talent" ,  "lead-role" ,  "movie-tries" ,  "until-last" ,  "good-story" ,  "isnt-exactly" ,  "until-end" ,  "such-one" ,  "comes-close" ,  "scene-movie" ,  "taken-seriously" ,  "primary-colors" ,  "isnt-really" ,  "crude-humor" ,  "love-stories" ,  "excellent-job" ,  "opening-scene" ,  "film-full" ,  "seeing-movie" ,  "brought-screen" ,  "characters-story" ,  "teenagers-see" ,  "takes-time" ,  "movie-give" ,  "particularly-good" ,  "101-dalmatians" ,  "dont-even" ,  "perhaps-even" ,  "story-many" ,  "last-scene" ,  "film-theres" ,  "never-gets" ,  "one-such" ,  "those-two" ,  "dont-need" ,  "family-entertainment" ,  "compelling-story" ,  "graphic-violence" ,  "beneath-surface" ,  "director-mike" ,  "good-acting" ,  "film-though" ,  "give-picture" ,  "nicolas-cage" ,  "nearly-enough" ,  "bond-film" ,  "thats-good" ,  "fine-performances" ,  "actors-actresses" ,  "between-characters" ,  "over-years" ,  "out-more" ,  "world-war" ,  "thats-more" ,  "remains-day" ,  "enough-keep" ,  "watch-film" ,  "wag-dog" ,  "based-true" ,  "four-weddings" ,  "movie-comes" ,  "always-seems" ,  "result-film" ,  "100-minutes" ,  "bad-things" ,  "film-contains" ,  "fall-love" ,  "jerry-maguire" ,  "kids-over" ,  "quite-sure" ,  "teenagers-older" ,  "theres-still" ,  "points-out" ,  "eddie-murphy" ,  "make-feel" ,  "20th-century" ,  "two-main" ,  "martial-arts" ,  "rated-sexual" ,  "theres-doubt" ,  "film-long" ,  "thats-one" ,  "isnt-one" ,  "one-big" ,  "movie-full" ,  "movie-gets" ,  "battle-scenes" ,  "live-die" ,  "funny-one" ,  "over-two" ,  "sense-sensibility" ,  "film-funny" ,  "movie-still" ,  "theres-even" ,  "one-movies" ,  "refreshing-see" ,  "ado-nothing" ,  "didnt-make" ,  "waiting-guffman" ,  "frontal-nudity" ,  "robert-duvall" ,  "thats-exactly" ,  "even-best" ,  "much-longer" ,  "worth-noting" ,  "george-lucas" ,  "stands-out" ,  "violence-sexuality" ,  "way-long" ,  "love-interest" ,  "message-film" ,  "opening-sequence" ,  "movie-little" ,  "during-movie" ,  "matter-much" ,  "nutty-professor" ,  "fun-watching" ,  "tim-burton" ,  "time-kill" ,  "nudity-fine" ,  "come-expect" ,  "one-characters" ,  "fall-flat" ,  "columbia-pictures" ,  "independent-film" ,  "through-eyes" ,  "language-sexuality" ,  "movie-1/2" ,  "robert-niro" ,  "basic-instinct" ,  "runs-feels" ,  "company-men" ,  "scenes-film" ,  "thumbs-1/2" ,  "youll-probably" ,  "more-less" ,  "press-notes" ,  "two-hour" ,  "one-really" ,  "nothing-much" ,  "more-real" ,  "sundance-film" ,  "musical-score" ,  "more-powerful" ,  "good-guy" ,  "best-supporting" ,  "nothing-short" ,  "hunchback-notre" ,  "film-few" ,  "suspend-disbelief" ,  "isnt-funny" ,  "somewhere-between" ,  "supporting-roles" ,  "bathroom-humor" ,  "distributor-miramax" ,  "film-movie" ,  "more-concerned" ,  "little-sex" ,  "characters-dont" ,  "lost-highway" ,  "worse-still" ,  "minute-running" ,  "made-look" ,  "movie-feels" ,  "less-successful" ,  "during-first" ,  "art-film" ,  "sleepless-seattle" ,  "kevin-spacey" ,  "las-vegas" ,  "virtually-nothing" ,  "guilty-pleasure" ,  "time-movies" ,  "attention-detail" ,  "true-lies" ,  "french-film" ,  "family-films" ,  "seen-movie" ,  "fun-film" ,  "plays-part" ,  "center-stage" ,  "free-willy" ,  "mystery-story" ,  "see-again" ,  "comes-alive" ,  "something-little" ,  "movie-features" ,  "made-movie" ,  "far-away" ,  "piece-acting" ,  "scenes-one" ,  "story-seems" ,  "director-james" ,  "those-moments" ,  "movie-two" ,  "scary-movie" ,  "director-richard" ,  "blown-away" ,  "time-spent" ,  "coen-brothers" ,  "doesnt-appear" ,  "boogie-nights" ,  "early-film" ,  "more-enjoyable" ,  "les-miserables" ,  "film-kind" ,  "last-action" ,  "universal-pictures" ,  "film-industry" ,  "film-look" ,  "minutes-long" };
	//800--
	public static String[] bigramList={"films-year" , "see-film" , "motion-picture" , "film-excellent" , "movie-kind" , "waste-money" , "average-movie" , "dont-waste" , "show-dont" , "excellent-show" , "show-look" , "kind-enjoyable" , "enjoyable-poor" , "poor-show" , "look-average" , "opinions-expressed" , "meant-reflect" , "mine-meant" , "reflect-employers" , "expressed-mine" , "running-time" , "few-films" , "one-worst" , "worst-films" , "message-subject" , "reply-message" , "details-reply" , "one-top" , "money-one" , "year-see" , "totally-unbearable" , "year-totally" , "top-few" , "rated-pg-13" , "mpaa-rating" , "subject-line" , "much-more" , "even-though" , "special-effects" , "even-more" , "little-more" , "adult-themes" , "unbearable-opinions" , "fine-kids" , "screening-room" , "son-jeffrey" , "see-screening" , "subject-subscribe" , "room-details" , "much-better" , "fine-teenagers" , "one-those" , "kids-around" , "sex-nudity" , "see-moviepage" , "moviepage-details" , "line-subscribe" , "jeffrey-age" , "painfully-unbearable" , "money-totally" , "unbearable-picture" , "totally-painfully" , "sexual-situations" , "turns-out" , "older-teenagers" , "english-subtitles" , "theres-nothing" , "review-written" , "romantic-comedy" , "film-one" , "word-subscribe" , "letter-word" , "subscribe-subject" , "send-letter" , "acceptable-teenagers" , "screen-time" , "motion-pictures" , "running-length" , "love-story" , "character-study" , "film-makers" , "mature-themes" , "two-hours" , "far-more" , "subject-matter" , "between-two" , "runs-rated" , "acceptable-older" , "chemistry-between" , "one-thing" , "action-sequences" , "film-more" , "first-time" , "bad-language" , "character-development" , "brief-nudity" , "themes-running" , "supporting-cast" , "one-best" , "theres-something" , "rated-violence" , "profanity-adult" , "rating-pg-13" , "violence-profanity" , "star-wars" , "film-fine" , "picture-opinions" , "figure-out" , "time-minutes" , "acceptable-kids" , "language-acceptable" , "give-1/2" , "academy-award" , "nudity-violence" , "high-school" , "part-film" , "science-fiction" , "writer-director" , "first-half" , "1/2-one" , "film-made" , "box-office" , "action-film" , "main-characters" , "dont-know" , "last-years" , "more-interesting" , "subtitles-rated" , "one-many" , "great-deal" , "best-part" , "film-doesnt" , "along-way" , "doesnt-seem" , "theres-much" , "rating-profanity" , "bad-guys" , "unbearable-review" , "dont-think" , "takes-place" , "relationship-between" , "youve-seen" , "give-film" , "very-little" , "woody-allen" , "long-rated" , "big-screen" , "many-scenes" , "pulp-fiction" , "isnt-much" , "years-ago" , "movie-one" , "new-york" , "rated-strong" , "runs-long" , "director-john" , "want-see" , "see-movie" , "many-times" , "rated-sex" , "something-more" , "film-noir" , "one-more" , "worth-seeing" , "half-hour" , "ingmar-bergman" , "film-festival" , "never-quite" , "many-ways" , "doesnt-make" , "long-time" , "rated-language" , "bit-more" , "much-time" , "film-never" , "soap-opera" , "dont-want" , "movie-nothing" , "film-even" , "one-films" , "second-half" , "film-rated" , "nothing-more" , "kind-film" , "black-white" , "very-good" , "1997-opinions" , "make-sense" , "robin-williams" , "theres-little" , "make-film" , "one-few" , "profanity-violence" , "part-movie" , "one-scene" , "1/2-see" , "never-seen" , "sit-through" , "found-myself" , "film-making" , "film-much" , "picture-review" , "black-comedy" , "die-hard" , "film-makes" , "one-film" , "movie-rated" , "lot-more" , "screen-presence" , "profanity-fine" , "down-david" , "belief-movie" , "david-puttnam" , "nothing-life" , "sexual-content" , "people-neutral" , "makes-film" , "leave-down" , "neutral-leave" , "leaves-people" , "leave-leave" , "life-leaves" , "made-film" , "very-funny" , "theres-lot" , "very-much" , "give-one" , "enough-make" , "drug-use" , "based-novel" , "star-trek" , "written-directed" , "two-leads" , "one-point" , "action-films" , "pg-13-profanity" , "anything-more" , "film-takes" , "drug-usage" , "horror-film" , "ive-seen" , "sense-humor" , "doesnt-take" , "violence-language" , "put-together" , "film-maker" , "pg-13-violence" , "comic-relief" , "jurassic-park" , "feature-film" , "best-thing" , "nudity-profanity" , "first-place" , "film-film" , "theres-enough" , "plot-device" , "quite-good" , "violence-running" , "seen-before" , "movie-isnt" , "reason-see" , "doesnt-much" , "profanity-running" , "movie-more" , "without-being" , "violence-fine" , "many-characters" , "opening-credits" , "tell-story" , "doesnt-work" , "sight-gags" , "bad-movie" , "good-film" , "once-again" , "teenagers-send" , "kind-movie" , "real-life" , "action-scenes" , "plot-twists" , "age-gave" , "those-films" , "physical-comedy" , "fairy-tale" , "show-fine" , "find-yourself" , "film-director" , "theres-one" , "seems-more" , "one-another" , "good-enough" , "great-film" , "first-film" , "mpaa-classification" , "turn-out" , "much-fun" , "true-story" , "bad-guy" , "entertainment-value" , "old-enough" , "more-interested" , "recommend-give" , "fifteen-minutes" , "one-expect" , "one-character" , "fine-older" , "recommend-film" , "length-mpaa" , "hard-believe" , "good-movie" , "way-through" , "mature-teenagers" , "comic-book" , "rest-movie" , "rated-profanity" , "leave-theater" , "around-son" , "sitting-through" , "film-isnt" , "taking-place" , "same-time" , "even-better" , "rest-film" , "correctly-rated" , "director-robert" , "french-english" , "entire-movie" , "ensemble-cast" , "one-two" , "happy-ending" , "theres-more" , "waste-time" , "tries-hard" , "fine-line" , "romantic-comedies" , "throughout-film" , "come-out" , "violence-acceptable" , "profanity-sexual" , "many-films" , "pretty-good" , "never-really" , "men-women" , "much-film" , "make-sure" , "film-very" , "story-told" , "point-out" , "supporting-characters" , "doesnt-really" , "television-series" , "themes-profanity" , "story-itself" , "first-hour" , "story-film" , "film-works" , "story-line" , "story-more" , "james-bond" , "mission-impossible" , "family-film" , "serial-killer" , "entire-film" , "unbearable-reviewed" , "good-time" , "few-minutes" , "action-hero" , "quentin-tarantino" , "reviewed-written" , "director-peter" , "lion-king" , "schindlers-list" , "toy-story" , "making-film" , "telling-story" , "rated-probably" , "times-before" , "gives-film" , "give-see" , "movie-made" , "main-character" , "film-itself" , "even-those" , "more-effective" , "recommend-movie" , "feel-good" , "ten-minutes" , "manages-make" , "more-one" , "hour-half" , "movie-never" , "film-many" , "five-minutes" , "whole-lot" , "film-seems" , "love-affair" , "best-film" , "kids-under" , "film-good" , "low-budget" , "film-without" , "movie-doesnt" , "doesnt-know" , "visual-effects" , "many-people" , "recommend-picture" , "twenty-minutes" , "trying-make" , "romance-between" , "more-impressive" , "home-alone" , "best-performance" , "perhaps-best" , "ages-son" , "quite-funny" , "1995-opinions" , "1996-opinions" , "very-well" , "out-film" , "makes-sense" , "good-sense" , "twists-turns" , "human-beings" , "closing-credits" , "end-film" , "minutes-film" , "see-one" , "part-story" , "bad-film" , "thumbs-down" , "screenplay-david" , "without-much" , "both-sides" , "nudity-sex" , "age-thought" , "better-film" , "length-rated" , "sexuality-acceptable" , "film-give" , "cant-help" , "film-offers" , "musical-numbers" , "independence-day" , "director-michael" , "little-bit" , "end-credits" , "story-one" , "director-david" , "out-one" , "gave-film" , "film-little" , "rating-violence" , "high-energy" , "out-loud" , "thirty-minutes" , "source-material" , "well-worth" , "same-way" , "whats-going" , "film-ends" , "set-pieces" , "give-movie" , "more-time" , "dont-care" , "one-better" , "first-part" , "fun-watch" , "point-view" , "recommend-show" , "press-screening" , "way-film" , "slice-life" , "rest-cast" , "problem-film" , "think-film" , "ninety-minutes" , "point-film" , "award-1/2" , "few-scenes" , "noir-film" , "entertaining-film" , "film-comes" , "movie-itself" , "few-times" , "little-profanity" , "line-between" , "one-great" , "many-movies" , "target-audience" , "despite-being" , "steven-seagal" , "sexuality-language" , "films-one" , "although-film" , "strong-violence" , "take-place" , "violence-sex" , "half-film" , "characters-situations" , "pretty-much" , "language-violence" , "although-movie" , "easy-see" , "silicon-valley" , "title-character" , "make-movie" , "violence-adult" , "film-those" , "few-good" , "last-act" , "fine-teenager" , "ending-credits" , "suspension-disbelief" , "fair-amount" , "back-forth" , "pg-13-sexual" , "difference-between" , "havent-seen" , "seem-more" , "two-films" , "bond-films" , "doesnt-quite" , "seeing-film" , "pop-culture" , "horror-films" , "walk-out" , "good-one" , "one-one" , "wonderful-life" , "though-film" , "turned-out" , "credits-roll" , "find-film" , "date-released" , "movie-takes" , "good-idea" , "more-important" , "especially-those" , "work-well" , "jackie-chan" , "strong-language" , "older-mature" , "story-doesnt" , "between-art" , "many-viewers" , "human-being" , "something-mary" , "much-less" , "film-well" , "camera-work" , "time-film" , "drug-content" , "bruce-willis" , "time-around" , "lot-fun" , "first-time-director" , "something-between" , "written-january" , "themes-violence" , "beginning-end" , "film-probably" , "long-enough" , "century-theaters" , "hong-kong" , "language-fine" , "piece-work" , "few-moments" , "out-place" , "art-films" , "1994-opinions" , "film-acceptable" , "facial-expressions" , "pg-13-brief" , "short-cuts" , "watching-movie" , "recent-films" , "film-becomes" , "two-characters" , "anthony-hopkins" , "much-movie" , "martin-scorsese" , "miramax-films" , "one-good" , "jean-luc-godard" , "many-different" , "violence-sexual" , "sexual-humor" , "movie-makes" , "directorial-debut" , "time-movie" , "good-guys" , "fine-ages" , "parts-movie" , "best-picture" , "one-reasons" , "picture-give" , "live-action" , "funny-moments" , "clint-eastwood" , "amc-century" , "minor-characters" , "social-commentary" , "film-gets" , "film-really" , "teenagers-recommend" , "good-job" , "works-best" , "one-favorite" , "mild-profanity" , "thought-movie" , "doesnt-mean" , "horror-movie" , "nudity-language" , "such-films" , "characters-film" , "few-years" , "more-serious" , "films-made" , "art-life" , "pg-13-adult" , "warner-brothers" , "thematic-elements" , "dont-see" , "forrest-gump" , "life-piece" , "far-less" , "thing-film" , "cinema-both" , "life-takes" , "language-drug" , "movie-fine" , "cinema-something" , "bad-taste" , "straight-out" , "weve-seen" , "last-summer" , "film-see" , "film-critics" , "situations-adult" , "make-mistake" , "long-way" , "few-more" , "movie-runs" , "violence-film" , "films-life" , "themes-sexual" , "violence-bad" , "parts-film" , "come-close" , "nudity-sexual" , "sex-violence" , "both-gives" , "unlike-painting" , "painting-literature" , "press-kit" , "cinema-art" , "cinema-slice" , "piece-cake" , "emotional-impact" , "life-unlike" , "film-didnt" , "film-still" , "literature-cinema" , "arent-many" , "takes-jean-luc" , "film-cant" , "more-few" , "watching-film" , "well-done" , "never-seems" , "good-bad" , "gave-1/2" , "one-way" , "make-more" , "becomes-more" , "jim-carrey" , "film-set" , "gives-life" , "first-movie" , "movie-filled" , "life-cinema" , "find-out" , "really-good" , "central-character" , "good-evil" , "plot-elements" , "sexual-innuendo" , "sandra-bullock" , "movie-thats" , "van-damme" , "united-states" , "story-never" , "few-laughs" , "film-best" , "little-mermaid" , "character-film" , "loose-ends" , "worth-caring" , "starship-troopers" , "steven-spielberg" , "classification-mpaa" , "isnt-nearly" , "type-film" , "mild-thumbs" , "nothing-special" , "make-much" , "acting-ability" , "very-bad" , "good-thing" , "film-thats" , "films-best" , "enough-recommend" , "last-year" , "many-more" , "enough-interested" , "valley-showing" , "film-opens" , "much-same" , "start-finish" , "smart-enough" , "doesnt-offer" , "problem-movie" , "best-known" , "better-movie" , "certainly-isnt" , "sort-movie" , "worth-price" , "doesnt-matter" , "pg-13-language" , "little-long" , "theaters-send" , "dumb-dumber" , "those-dont" , "content-acceptable" , "saving-grace" , "movie-bad" , "beauty-beast" , "film-story" , "more-fun" , "sex-scenes" , "rated-nudity" , "isnt-bad" , "film-version" , "doesnt-even" , "reservoir-dogs" , "doesnt-help" , "period-piece" , "rated-brief" , "film-seem" , "film-seen" , "film-such" , "way-out" , "out-way" , "even-worse" , "youre-going" , "production-values" , "film-tries" , "art-house" , "oliver-stone" , "script-doesnt" , "each-one" , "pleasant-enough" , "long-before" , "many-things" , "itself-seriously" , "fine-job" , "slow-motion" , "film-first" , "those-rare" , "take-long" , "language-film" , "year-old" , "one-long" , "much-sense" , "language-sexual" , "dont-make" , "didnt-know" , "situations-running" , "much-story" , "works-well" , "best-films" , "films-such" , "romeo-juliet" , "aspect-ratio" , "debut-feature" , "those-enjoy" , "far-better" , "films-title" , "pg-13-mature" , "blair-witch" , "fine-kid" , "gave-movie" , "kenneth-branagh" , "best-work" , "films-end" , "movie-best" , "makes-one" , "more-compelling" , "more-plot" , "found-film" , "fifth-element"};


	public static boolean trainFlag =false;

	public static FileOutputStream fstream2 ;
	public static DataOutputStream in2 ;
	public static BufferedWriter br2;

	public static FileOutputStream fstream3 ;
	public static DataOutputStream in3 ;
	public static BufferedWriter br3;


	public static FileOutputStream fstream4 ;
	public static DataOutputStream in4 ;
	public static BufferedWriter br4;


	public static FileOutputStream fstream_bin ;
	public static DataOutputStream in_bin ;
	public static BufferedWriter br_bin;


	public static FileOutputStream fstream_bin_r ;
	public static DataOutputStream in_bin_r ;
	public static BufferedWriter br_bin_r;


	public static FileOutputStream fstream_mul ;
	public static DataOutputStream in_mul ;
	public static BufferedWriter br_mul;


	public static FileOutputStream fstream_mul_r ;
	public static DataOutputStream in_mul_r ;
	public static BufferedWriter br_mul_r;


	public static Integer[] wordlistvals;
	public static String[] wordlistkeys;


	public static Integer[] wordvalsss;
	public static String[] wordkeysss;



	public static Double[] wwordvalsss;
	public static String[] wwordkeysss;

	public static Integer[] poswordlistvals;
	public static String[] poswordlistkeys;


	public static Integer[] negwordlistvals;
	public static String[] negwordlistkeys;


	public static Integer[] bigramwordlistvals;
	public static String[] bigramwordlistkeys;


	public static void main(String args[]){

		try{





			for(String s :distWords){
				//System.out.println(s);

				distWordslist.add(s);

			}



			outFile+=args[0]+"-"+args[1]+".arff";
			outFile2+=args[0]+"-"+args[1]+".arff";
			outFile3+=args[0]+"-"+args[1]+".arff";
			outFile4+=args[0]+"-"+args[1]+".arff";
			outFile5+=args[0]+"-"+args[1]+".arff";
			outFile6+=args[0]+"-"+args[1]+".arff";


			FileInputStream fstream = new FileInputStream(args[1]);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));


			fstream2 = new FileOutputStream("alllistuni_4"+args[0]+"223.txt");
			in2 = new DataOutputStream(fstream2);
			br2 = new BufferedWriter(new OutputStreamWriter(in2));


			fstream3 = new FileOutputStream(outFile6);
			in3 = new DataOutputStream(fstream3);
			br3 = new BufferedWriter(new OutputStreamWriter(in3));


			fstream4 = new FileOutputStream("all_quotes_list_desc_4"+args[0]+"223.txt");
			in4 = new DataOutputStream(fstream4);
			br4 = new BufferedWriter(new OutputStreamWriter(in4));




			fstream_bin = new FileOutputStream(outFile2);
			in_bin = new DataOutputStream(fstream_bin);
			br_bin = new BufferedWriter(new OutputStreamWriter(in_bin));



			fstream_bin_r = new FileOutputStream(outFile3);
			in_bin_r = new DataOutputStream(fstream_bin_r);
			br_bin_r = new BufferedWriter(new OutputStreamWriter(in_bin_r));




			fstream_mul = new FileOutputStream(outFile4);
			in_mul = new DataOutputStream(fstream_mul);
			br_mul = new BufferedWriter(new OutputStreamWriter(in_mul));




			fstream_mul_r = new FileOutputStream(outFile5);
			in_mul_r = new DataOutputStream(fstream_mul_r);
			br_mul_r = new BufferedWriter(new OutputStreamWriter(in_mul_r));


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
			printHashTable23(cg.wordList);
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
			//printHashTable234(cg.star1wordList);
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
			//printHashTable234(cg.star2wordList);
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
			//printHashTable234(cg.star3wordList);
			br2.newLine();
			br2.newLine();
			br2.newLine();
			br2.newLine();

			br2.write("-----------------star 4------------------");
			br2.newLine();
			br4.write("-----------------star 4------------------");
			br4.newLine();
			//printHashTable2(cg.star4wordList);
			//printHashTable234(cg.star4wordList);
			br2.newLine();
			br2.newLine();
			br2.newLine();
			br2.newLine();


			System.out.println("Total Docs- "+cnt);
			cg.docCount=cnt;
			System.out.println(" doc cnt- "+cg.wordCnt);
			System.out.println("Avg doc length- "+cg.wordCnt/cnt);
			logln();


			//System.out.println("Total neg Docs- "+negCnt);
			//System.out.println(" neg doc cnt- "+cg.wordFromNeg);
			//System.out.println("Avg neg doc length- "+cg.wordFromNeg/negCnt);
			//logln();


			//System.out.println("Total pos Docs- "+posCnt);
			//System.out.println(" neg doc cnt- "+cg.wordFromPos);
			//System.out.println("Avg pos doc length- "+cg.wordFromPos/posCnt);
			//logln();



			System.out.println("Total cntposwordList - "+cg.cntposwordList.size());

			System.out.println("Total cntnegwordList - "+cg.cntnegwordList.size());

			if(trainFlag){
				//POSFileReader pos = new POSFileReader();
				//pos.getCount("parsedCorpus.txt");
			}

			//XXXXXXXXXXXXXXXXX
			//printDocList2(cg, "D");
			printDocList_newterms_all(cg);
			// right printDocListForReviewer(cg,args[0]);


			//printDocListForClassification(cg,args[0],br_bin,"binary",binFeaturesWords, binFeaturesbigramWords);
			//printDocListForClassification(cg,args[0],br_bin_r,"binaryr",binFeaturesWords, binFeaturesbigramWords);

			//printDocListForClassification(cg,args[0],br_mul,"multi",mulFeaturesWords, mulFeaturesbigramWords);
			//printDocListForClassification(cg,args[0],br_mul_r,"multi_and_extrareviewer",mulFeaturesWords, mulFeaturesbigramWords);


			//printDocListForClassificationtesting3("D",cg,args[0],br_mul_r,"multi_and_extrareviewer",mulFeaturesWords, mulFeaturesbigramWords);
			//right printDocListForClassificationtesting(cg,args[0],br_bin_r,"binaryr",binFeaturesWords, binFeaturesbigramWords);

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


			br_bin.flush();
			in_bin.close();


			br_bin_r.flush();
			in_bin_r.close();


			br_mul.flush();
			in_mul.close();


			br_mul_r.flush();
			in_mul_r.close();


			in.close();

		}catch (Exception e){

			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();

		}

	}








	private static void printDocListForClassificationtesting3(String reviewernew,CountGenerator cg,String casee, BufferedWriter br_bin2, String classicationCase, String[] featuresWordss, String featuresbigramWordss[]) {
		// TODO Auto-generated method stub

		try {






			br_bin2.write("@RELATION "+classicationCase+casee+"ing");

			br_bin2.newLine();
			br_bin2.newLine();
			br_bin2.newLine();


			for(int i=0;i<featuresWordss.length;i++){

				br_bin2.write("@ATTRIBUTE "+featuresWordss[i]+" NUMERIC");
				br_bin2.newLine();


			}

			for(int i=0;i<featuresbigramWordss.length;i++){

				br_bin2.write("@ATTRIBUTE "+featuresbigramWordss[i]+" NUMERIC");
				br_bin2.newLine();


			}





			if(classicationCase.equalsIgnoreCase("binary") || classicationCase.equalsIgnoreCase("binaryr")){


				br_bin2.write("@ATTRIBUTE posword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE negword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffposs NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffneg NUMERIC");
				br_bin2.newLine();





				br_bin2.write("@ATTRIBUTE classFinal {0,1}");
				br_bin2.newLine();
			}
			else{


				br_bin2.write("@ATTRIBUTE doclength NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE posword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE negword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffposs NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffneg NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE extremeWord NUMERIC");
				br_bin2.newLine();

				br_bin2.write("@ATTRIBUTE classFinal {1,2,3,4}");
				br_bin2.newLine();
			}

			br_bin2.newLine();
			br_bin2.newLine();
			br_bin2.write("@DATA");
			br_bin2.newLine();
			br_bin2.flush();


			for(Document d : cg.docList){

				if(d.reviewer.equalsIgnoreCase(reviewernew)){

					for(int i=0;i<featuresWordss.length;i++){

						if(d.termFrequency.containsKey(featuresWordss[i])){

							double tf=((d.termFrequency.get(featuresWordss[i]))/(d.countWords));

							ArrayList<Integer> listt=cg.docFrequency.get(featuresWordss[i]);

							double df=Math.log(cg.docCount/listt.size());
							double tfidf=tf*df;

							br_bin2.write(tfidf+",");
						}
						else{
							br_bin2.write("0,");
						}


					}


					for(int i=0;i<featuresbigramWordss.length;i++){

						if(d.bigramtermFrequency.containsKey(featuresbigramWordss[i])){

							double tf=((d.bigramtermFrequency.get(featuresbigramWordss[i]))/(d.bicountWords));



							br_bin2.write(tf+",");
						}
						else{
							br_bin2.write("0,");
						}


					}






					if(classicationCase.equalsIgnoreCase("binary") || classicationCase.equalsIgnoreCase("binaryr")){



						br_bin2.write((d.posWords)/d.countWords+",");
						br_bin2.write((d.negWords)/d.countWords+",");

						if(((d.posWords/d.countWords)-(d.negWords/d.countWords))>0){
							br_bin2.write((d.posWords/d.countWords)-(d.negWords/d.countWords)+",");
							br_bin2.write(0+",");
						}
						else{
							br_bin2.write(0+",");
							br_bin2.write((d.negWords/d.countWords)-(d.posWords/d.countWords)+",");
						}


					}
					else{

						br_bin2.write(d.countWords+",");

						br_bin2.write((d.posWords)/d.countWords+",");
						br_bin2.write((d.negWords)/d.countWords+",");

						if(((d.posWords/d.countWords)-(d.negWords/d.countWords))>0){
							br_bin2.write((d.posWords/d.countWords)-(d.negWords/d.countWords)+",");
							br_bin2.write(0+",");
						}
						else{
							br_bin2.write(0+",");
							br_bin2.write((d.negWords/d.countWords)-(d.posWords/d.countWords)+",");
						}


						if(cg.docFrequency.containsKey("extremeWords")){

							double tf=d.extremeWords/d.countWords;

							ArrayList<Integer> listt=cg.docFrequency.get("extremeWords");

							double df=Math.log(cg.docCount/listt.size());
							double tfidf=tf*df;

							br_bin2.write(tfidf+",");
						}
						else{
							br_bin2.write("0,");
						}

					}
					//br_bin2.write(d.NNcount/d.countWords+",");

					//br_bin2.write(d.NNpaircount/d.countWords+",");


					if(casee.equalsIgnoreCase("train")){
						if(classicationCase.equalsIgnoreCase("binary") || classicationCase.equalsIgnoreCase("binaryr")){
							if(d.star>=3){
								br_bin2.write("1");
							}
							else{
								br_bin2.write("0");
							}
						}
						else{
							String sstar =""+d.star;
							br_bin2.write(sstar);
						}
					}
					else{
						br_bin2.write("?");
					}
					br_bin2.newLine();
					br_bin2.flush();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}






	private static void printDocListForClassificationtesting2(CountGenerator cg,String casee, BufferedWriter br_bin2, String classicationCase, String[] featuresWordss, String featuresbigramWordss[]) {
		// TODO Auto-generated method stub

		try {




			for(String s :featuresWordss){
				//System.out.println(s);

				featlist.add(s);

			}





			for(String s :featuresbigramWordss){
				//System.out.println(s);

				featbilist.add(s);

			}



			br_bin2.write("@RELATION "+classicationCase+casee+"ing");

			br_bin2.newLine();
			br_bin2.newLine();
			br_bin2.newLine();


			for(int i=0;i<featuresWordss.length;i++){

				br_bin2.write("@ATTRIBUTE "+featuresWordss[i]+" NUMERIC");
				br_bin2.newLine();


			}

			for(int i=0;i<featuresbigramWordss.length;i++){

				br_bin2.write("@ATTRIBUTE "+featuresbigramWordss[i]+" NUMERIC");
				br_bin2.newLine();


			}



			for(int i=0;i<featWords.length;i++){

				if((!featlist.contains(featWords[i]))  &&  (!featbilist.contains(featWords[i]))){
					br_bin2.write("@ATTRIBUTE "+featWords[i]+" NUMERIC");
					br_bin2.newLine();
				}

			}

			if(classicationCase.equalsIgnoreCase("binary") || classicationCase.equalsIgnoreCase("binaryr")){


				br_bin2.write("@ATTRIBUTE posword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE negword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffposs NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffneg NUMERIC");
				br_bin2.newLine();





				br_bin2.write("@ATTRIBUTE classFinal {0,1}");
				br_bin2.newLine();
			}
			else{


				br_bin2.write("@ATTRIBUTE doclength NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE posword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE negword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffposs NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffneg NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE extremeWord NUMERIC");
				br_bin2.newLine();

				br_bin2.write("@ATTRIBUTE classFinal {1,2,3,4}");
				br_bin2.newLine();
			}

			br_bin2.newLine();
			br_bin2.newLine();
			br_bin2.write("@DATA");
			br_bin2.newLine();
			br_bin2.flush();


			for(Document d : cg.docList){


				for(int i=0;i<featuresWordss.length;i++){

					if(d.termFrequency.containsKey(featuresWordss[i])){

						double tf=((d.termFrequency.get(featuresWordss[i]))/(d.countWords));

						ArrayList<Integer> listt=cg.docFrequency.get(featuresWordss[i]);

						double df=Math.log(cg.docCount/listt.size());
						double tfidf=tf*df;

						br_bin2.write(tfidf+",");
					}
					else{
						br_bin2.write("0,");
					}


				}


				for(int i=0;i<featuresbigramWordss.length;i++){

					if(d.bigramtermFrequency.containsKey(featuresbigramWordss[i])){

						double tf=((d.bigramtermFrequency.get(featuresbigramWordss[i]))/(d.bicountWords));



						br_bin2.write(tf+",");
					}
					else{
						br_bin2.write("0,");
					}


				}




				for(int i=0;i<featWords.length;i++){

					if((!featlist.contains(featWords[i]))  &&  (!featbilist.contains(featWords[i]))){



						if(d.termFrequency.containsKey(featWords[i])){

							double tf=((d.termFrequency.get(featWords[i]))/(d.countWords));

							ArrayList<Integer> listt=cg.docFrequency.get(featWords[i]);

							double df=Math.log(cg.docCount/listt.size());
							double tfidf=tf*df;

							br_bin2.write(tfidf+",");
						}
						else{
							br_bin2.write("0,");
						}



					}

				}

				if(classicationCase.equalsIgnoreCase("binary") || classicationCase.equalsIgnoreCase("binaryr")){



					br_bin2.write((d.posWords)/d.countWords+",");
					br_bin2.write((d.negWords)/d.countWords+",");

					if(((d.posWords/d.countWords)-(d.negWords/d.countWords))>0){
						br_bin2.write((d.posWords/d.countWords)-(d.negWords/d.countWords)+",");
						br_bin2.write(0+",");
					}
					else{
						br_bin2.write(0+",");
						br_bin2.write((d.negWords/d.countWords)-(d.posWords/d.countWords)+",");
					}


				}
				else{

					br_bin2.write(d.countWords+",");

					br_bin2.write((d.posWords)/d.countWords+",");
					br_bin2.write((d.negWords)/d.countWords+",");

					if(((d.posWords/d.countWords)-(d.negWords/d.countWords))>0){
						br_bin2.write((d.posWords/d.countWords)-(d.negWords/d.countWords)+",");
						br_bin2.write(0+",");
					}
					else{
						br_bin2.write(0+",");
						br_bin2.write((d.negWords/d.countWords)-(d.posWords/d.countWords)+",");
					}


					if(cg.docFrequency.containsKey("extremeWords")){

						double tf=d.extremeWords/d.countWords;

						ArrayList<Integer> listt=cg.docFrequency.get("extremeWords");

						double df=Math.log(cg.docCount/listt.size());
						double tfidf=tf*df;

						br_bin2.write(tfidf+",");
					}
					else{
						br_bin2.write("0,");
					}

				}
				//br_bin2.write(d.NNcount/d.countWords+",");

				//br_bin2.write(d.NNpaircount/d.countWords+",");


				if(casee.equalsIgnoreCase("train")){
					if(classicationCase.equalsIgnoreCase("binary") || classicationCase.equalsIgnoreCase("binaryr")){
						if(d.star>=3){
							br_bin2.write("1");
						}
						else{
							br_bin2.write("0");
						}
					}
					else{
						String sstar =""+d.star;
						br_bin2.write(sstar);
					}
				}
				else{
					br_bin2.write("?");
				}
				br_bin2.newLine();
				br_bin2.flush();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	private static void printDocListForClassificationtesting(CountGenerator cg,String casee, BufferedWriter br_bin2, String classicationCase, String[] featuresWordss, String featuresbigramWordss[]) {
		// TODO Auto-generated method stub
		try {

			br_bin2.write("@RELATION "+classicationCase+casee+"ing");

			br_bin2.newLine();
			br_bin2.newLine();
			br_bin2.newLine();






			for(int i=(wordkeysss.length-1);i>=(wordkeysss.length-8001);i--){

				br_bin2.write("@ATTRIBUTE "+wordkeysss[i]+" NUMERIC");
				br_bin2.newLine();


			}




			for(int i=0;i<featuresbigramWordss.length;i++){

				br_bin2.write("@ATTRIBUTE "+featuresbigramWordss[i]+" NUMERIC");
				br_bin2.newLine();


			}


			if(classicationCase.equalsIgnoreCase("binary") || classicationCase.equalsIgnoreCase("binaryr")){


				br_bin2.write("@ATTRIBUTE posword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE negword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffposs NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffneg NUMERIC");
				br_bin2.newLine();





				br_bin2.write("@ATTRIBUTE classFinal {0,1}");
				br_bin2.newLine();
			}
			else{


				br_bin2.write("@ATTRIBUTE doclength NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE posword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE negword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffposs NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffneg NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE extremeWord NUMERIC");
				br_bin2.newLine();

				br_bin2.write("@ATTRIBUTE classFinal {1,2,3,4}");
				br_bin2.newLine();
			}

			br_bin2.newLine();
			br_bin2.newLine();
			br_bin2.write("@DATA");
			br_bin2.newLine();
			br_bin2.flush();


			for(Document d : cg.docList){




				for(int i=(wordkeysss.length-1);i>=(wordkeysss.length-8001);i--){



					if(d.termFrequency.containsKey(wordkeysss[i])){

						double tf=((d.termFrequency.get(wordkeysss[i]))/(d.countWords));

						ArrayList<Integer> listt=cg.docFrequency.get(wordkeysss[i]);

						double df=Math.log(cg.docCount/listt.size());
						double tfidf=tf*df;

						br_bin2.write(tfidf+",");
					}
					else{
						br_bin2.write("0,");
					}


				}





				for(int i=0;i<featuresbigramWordss.length;i++){

					if(d.bigramtermFrequency.containsKey(featuresbigramWordss[i])){

						double tf=((d.bigramtermFrequency.get(featuresbigramWordss[i]))/(d.bicountWords));



						br_bin2.write(tf+",");
					}
					else{
						br_bin2.write("0,");
					}


				}




				if(classicationCase.equalsIgnoreCase("binary") || classicationCase.equalsIgnoreCase("binaryr")){



					br_bin2.write((d.posWords)/d.countWords+",");
					br_bin2.write((d.negWords)/d.countWords+",");

					if(((d.posWords/d.countWords)-(d.negWords/d.countWords))>0){
						br_bin2.write((d.posWords/d.countWords)-(d.negWords/d.countWords)+",");
						br_bin2.write(0+",");
					}
					else{
						br_bin2.write(0+",");
						br_bin2.write((d.negWords/d.countWords)-(d.posWords/d.countWords)+",");
					}


				}
				else{

					br_bin2.write(d.countWords+",");

					br_bin2.write((d.posWords)/d.countWords+",");
					br_bin2.write((d.negWords)/d.countWords+",");

					if(((d.posWords/d.countWords)-(d.negWords/d.countWords))>0){
						br_bin2.write((d.posWords/d.countWords)-(d.negWords/d.countWords)+",");
						br_bin2.write(0+",");
					}
					else{
						br_bin2.write(0+",");
						br_bin2.write((d.negWords/d.countWords)-(d.posWords/d.countWords)+",");
					}


					if(cg.docFrequency.containsKey("extremeWords")){

						double tf=d.extremeWords/d.countWords;

						ArrayList<Integer> listt=cg.docFrequency.get("extremeWords");

						double df=Math.log(cg.docCount/listt.size());
						double tfidf=tf*df;

						br_bin2.write(tfidf+",");
					}
					else{
						br_bin2.write("0,");
					}

				}
				//br_bin2.write(d.NNcount/d.countWords+",");

				//br_bin2.write(d.NNpaircount/d.countWords+",");


				if(casee.equalsIgnoreCase("train")){
					if(classicationCase.equalsIgnoreCase("binary") || classicationCase.equalsIgnoreCase("binaryr")){
						if(d.star>=3){
							br_bin2.write("1");
						}
						else{
							br_bin2.write("0");
						}
					}
					else{
						String sstar =""+d.star;
						br_bin2.write(sstar);
					}
				}
				else{
					br_bin2.write("?");
				}
				br_bin2.newLine();
				br_bin2.flush();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	private static void printDocListForClassification(CountGenerator cg,String casee, BufferedWriter br_bin2, String classicationCase, String[] featuresWordss, String featuresbigramWordss[]) {
		// TODO Auto-generated method stub

		try {

			br_bin2.write("@RELATION "+classicationCase+casee+"ing");

			br_bin2.newLine();
			br_bin2.newLine();
			br_bin2.newLine();


			for(int i=0;i<featuresWordss.length;i++){

				br_bin2.write("@ATTRIBUTE "+featuresWordss[i]+" NUMERIC");
				br_bin2.newLine();


			}

			for(int i=0;i<featuresbigramWordss.length;i++){

				br_bin2.write("@ATTRIBUTE "+featuresbigramWordss[i]+" NUMERIC");
				br_bin2.newLine();


			}





			if(classicationCase.equalsIgnoreCase("binary") || classicationCase.equalsIgnoreCase("binaryr")){


				br_bin2.write("@ATTRIBUTE posword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE negword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffposs NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffneg NUMERIC");
				br_bin2.newLine();



				br_bin2.write("@ATTRIBUTE reviewerWord {A,B,C,D}");
				br_bin2.newLine();

				//br_bin2.write("@ATTRIBUTE adjWord NUMERIC");
				//br_bin2.newLine();



				//br_bin2.write("@ATTRIBUTE adverbWord NUMERIC");
				//br_bin2.newLine();

				br_bin2.write("@ATTRIBUTE classFinal {0,1}");
				br_bin2.newLine();
			}
			else{


				br_bin2.write("@ATTRIBUTE doclength NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE posword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE negword NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffposs NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE diffneg NUMERIC");
				br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE extremeWord NUMERIC");
				br_bin2.newLine();


				//	br_bin2.write("@ATTRIBUTE nnWord NUMERIC");
				//br_bin2.newLine();



				//br_bin2.write("@ATTRIBUTE nnpairWord NUMERIC");
				//br_bin2.newLine();


				br_bin2.write("@ATTRIBUTE reviewerWord {A,B,C,D}");
				br_bin2.newLine();

				//br_bin2.write("@ATTRIBUTE adjWord NUMERIC");
				//br_bin2.newLine();



				//br_bin2.write("@ATTRIBUTE adverbWord NUMERIC");
				//br_bin2.newLine();

				br_bin2.write("@ATTRIBUTE classFinal {1,2,3,4}");
				br_bin2.newLine();
			}

			br_bin2.newLine();
			br_bin2.newLine();
			br_bin2.write("@DATA");
			br_bin2.newLine();
			br_bin2.flush();


			for(Document d : cg.docList){


				for(int i=0;i<featuresWordss.length;i++){

					if(d.termFrequency.containsKey(featuresWordss[i])){

						double tf=((d.termFrequency.get(featuresWordss[i]))/(d.countWords));

						ArrayList<Integer> listt=cg.docFrequency.get(featuresWordss[i]);

						double df=Math.log(cg.docCount/listt.size());
						double tfidf=tf*df;

						br_bin2.write(tfidf+",");
					}
					else{
						br_bin2.write("0,");
					}


				}


				for(int i=0;i<featuresbigramWordss.length;i++){

					if(d.bigramtermFrequency.containsKey(featuresbigramWordss[i])){

						double tf=((d.bigramtermFrequency.get(featuresbigramWordss[i]))/(d.bicountWords));



						br_bin2.write(tf+",");
					}
					else{
						br_bin2.write("0,");
					}


				}



				if(classicationCase.equalsIgnoreCase("binary") || classicationCase.equalsIgnoreCase("binaryr")){



					br_bin2.write((d.posWords)/d.countWords+",");
					br_bin2.write((d.negWords)/d.countWords+",");

					if(((d.posWords/d.countWords)-(d.negWords/d.countWords))>0){
						br_bin2.write((d.posWords/d.countWords)-(d.negWords/d.countWords)+",");
						br_bin2.write(0+",");
					}
					else{
						br_bin2.write(0+",");
						br_bin2.write((d.negWords/d.countWords)-(d.posWords/d.countWords)+",");
					}


				}
				else{

					br_bin2.write(d.countWords+",");

					br_bin2.write((d.posWords)/d.countWords+",");
					br_bin2.write((d.negWords)/d.countWords+",");

					if(((d.posWords/d.countWords)-(d.negWords/d.countWords))>0){
						br_bin2.write((d.posWords/d.countWords)-(d.negWords/d.countWords)+",");
						br_bin2.write(0+",");
					}
					else{
						br_bin2.write(0+",");
						br_bin2.write((d.negWords/d.countWords)-(d.posWords/d.countWords)+",");
					}


					if(cg.docFrequency.containsKey("extremeWords")){

						double tf=d.extremeWords/d.countWords;

						ArrayList<Integer> listt=cg.docFrequency.get("extremeWords");

						double df=Math.log(cg.docCount/listt.size());
						double tfidf=tf*df;

						br_bin2.write(tfidf+",");
					}
					else{
						br_bin2.write("0,");
					}

				}
				//br_bin2.write(d.NNcount/d.countWords+",");

				//br_bin2.write(d.NNpaircount/d.countWords+",");

				br_bin2.write(d.reviewer+",");

				//br_bin2.write(d.JJcount/d.countWords+",");

				//br_bin2.write(d.RBcount/d.countWords+",");


				if(casee.equalsIgnoreCase("train")){
					if(classicationCase.equalsIgnoreCase("binary") || classicationCase.equalsIgnoreCase("binaryr")){
						if(d.star>=3){
							br_bin2.write("1");
						}
						else{
							br_bin2.write("0");
						}
					}
					else{
						String sstar =""+d.star;
						br_bin2.write(sstar);
					}
				}
				else{
					br_bin2.write("?");
				}
				br_bin2.newLine();
				br_bin2.flush();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
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


		//br3.write("@ATTRIBUTE NNCount NUMERIC");
		//br3.newLine();


		//br3.write("@ATTRIBUTE NNPairCount NUMERIC");
		//br3.newLine();


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

					br3.write(tfidf+",");
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


			//br3.write(d.NNcount/d.countWords+",");
			//br3.write(d.NNpaircount/d.countWords+",");


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







	private static void printDocList_newterms_all(CountGenerator cg ) throws IOException {
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
		for(String s :cg.posWords){

			br3.write("@ATTRIBUTE "+s+" NUMERIC");
			br3.newLine();
			printedposlist.add(s);

		}


		int cSizeNeg=FEATcnt;
		if(negwordlistkeys.length<cSizeNeg-1){
			cSizeNeg=negwordlistkeys.length+1;
		}
		for(String s: cg.negWords){

			br3.write("@ATTRIBUTE "+s+" NUMERIC");
			br3.newLine();

			printedneglist.add(s);
		}



		for(String s : cg.neutWords){
			if((!printedneglist.contains(s)) && (!printedposlist.contains(s))){
				br3.write("@ATTRIBUTE "+s+" NUMERIC");
				br3.newLine();

				printedneutlist.add(s);
			}
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
			if((!printedneglist.contains(distWords[i])) && (!printedposlist.contains(distWords[i]))  && (!printedneutlist.contains(distWords[i]))){
				br3.write("@ATTRIBUTE "+distWords[i]+" NUMERIC");
				br3.newLine();
			}

		}

		for(int i=0;i<bigramList.length;i++){
			if((!printedneglist.contains(bigramList[i])) && (!printedposlist.contains(bigramList[i])) && (!printedneutlist.contains(bigramList[i]))){
				br3.write("@ATTRIBUTE "+bigramList[i]+" NUMERIC");
				br3.newLine();
			}

		}


		//int cSizet=FEATcnt;
		int cSizet=201;
		if(wordlistkeys.length<cSizet){
			cSizet=wordlistkeys.length+1;
		}
		for(int i=(wordlistkeys.length-1);i>(wordlistkeys.length-cSizet);i--){
			if((!printedneglist.contains(wordlistkeys[i])) && (!printedposlist.contains(wordlistkeys[i]))  && (!distWordslist.contains(wordlistkeys[i])) && (!printedneutlist.contains(wordlistkeys[i]))){
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

		
		br3.write("@ATTRIBUTE neutword NUMERIC");
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


		//br3.write("@ATTRIBUTE NNCount NUMERIC");
		//br3.newLine();



		//br3.write("@ATTRIBUTE NNPairCount NUMERIC");
		//br3.newLine();

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


			for(String s : cg.posWords){

				if(d.postermFrequency.containsKey(s)){

					double tf=d.postermFrequency.get(s)/d.countWords;

					ArrayList<Integer> listt=cg.docFrequency.get(s);

					double df=Math.log(cg.docCount/listt.size());
					double tfidf=tf*df;

					br3.write(tfidf+",");
				}
				else{
					br3.write("0,");
				}

			}



			for(String s : cg.negWords){
				if(d.negtermFrequency.containsKey(s)){

					double tf=d.negtermFrequency.get(s)/d.countWords;

					ArrayList<Integer> listt=cg.docFrequency.get(s);

					double df=Math.log(cg.docCount/listt.size());
					double tfidf=tf*df;

					br3.write(tfidf+",");
				}
				else{
					br3.write("0,");
				}


			}





			for(String s : cg.neutWords){
				if((!printedneglist.contains(s)) && (!printedposlist.contains(s))){

					if(d.neuttermFrequency.containsKey(s)){

						double tf=d.neuttermFrequency.get(s)/d.countWords;

						ArrayList<Integer> listt=cg.docFrequency.get(s);

						double df=Math.log(cg.docCount/listt.size());
						double tfidf=tf*df;

						br3.write(tfidf+",");
					}
					else{
						br3.write("0,");
					}
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
				if((!printedneglist.contains(distWords[i])) && (!printedposlist.contains(distWords[i])) && (!printedneutlist.contains(distWords[i]))){
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
				if((!printedneglist.contains(bigramList[i])) && (!printedposlist.contains(bigramList[i])) && (!printedneutlist.contains(bigramList[i]))){
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
				if((!printedneglist.contains(wordlistkeys[i])) && (!printedposlist.contains(wordlistkeys[i]))  && (!printedneutlist.contains(wordlistkeys[i])) && (!distWordslist.contains(wordlistkeys[i]))){
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

			
			br3.write((d.neutWords)/d.countWords+",");
			
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

				br3.write(tf+",");
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



			//br3.write(d.NNcount/d.countWords+",");

			//br3.write(d.NNpaircount/d.countWords+",");



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









	private static void printDocList_newterms(CountGenerator cg ) throws IOException {
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



		for(String s : cg.neutWords){
			if((!printedneglist.contains(s)) && (!printedposlist.contains(s))){
				br3.write("@ATTRIBUTE "+s+" NUMERIC");
				br3.newLine();

				printedneutlist.add(s);
			}
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
			if((!printedneglist.contains(distWords[i])) && (!printedposlist.contains(distWords[i]))  && (!printedneutlist.contains(distWords[i]))){
				br3.write("@ATTRIBUTE "+distWords[i]+" NUMERIC");
				br3.newLine();
			}

		}

		for(int i=0;i<bigramList.length;i++){
			if((!printedneglist.contains(bigramList[i])) && (!printedposlist.contains(bigramList[i])) && (!printedneutlist.contains(distWords[i]))){
				br3.write("@ATTRIBUTE "+bigramList[i]+" NUMERIC");
				br3.newLine();
			}

		}


		//int cSizet=FEATcnt;
		int cSizet=201;
		if(wordlistkeys.length<cSizet){
			cSizet=wordlistkeys.length+1;
		}
		for(int i=(wordlistkeys.length-1);i>(wordlistkeys.length-cSizet);i--){
			if((!printedneglist.contains(wordlistkeys[i])) && (!printedposlist.contains(wordlistkeys[i]))  && (!distWordslist.contains(wordlistkeys[i])) && (!printedneutlist.contains(distWords[i]))){
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


		//br3.write("@ATTRIBUTE NNCount NUMERIC");
		//br3.newLine();



		//br3.write("@ATTRIBUTE NNPairCount NUMERIC");
		//br3.newLine();

		//br3.write("@ATTRIBUTE classFinal {0,1}");
		br3.write("@ATTRIBUTE classFinal {1,2,3,4}");
		//br3.write("@ATTRIBUTE classFinal {A,B,C,D}");
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





			for(String s : cg.neutWords){
				if((!printedneglist.contains(s)) && (!printedposlist.contains(s))){

					if(d.neuttermFrequency.containsKey(s)){

						double tf=d.neuttermFrequency.get(s)/d.countWords;

						ArrayList<Integer> listt=cg.docFrequency.get(s);

						double df=Math.log(cg.docCount/listt.size());
						double tfidf=tf*df;

						br3.write(tfidf+",");
					}
					else{
						br3.write("0,");
					}
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
				if((!printedneglist.contains(distWords[i])) && (!printedposlist.contains(distWords[i])) && (!printedneutlist.contains(distWords[i]))){
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
				if((!printedneglist.contains(bigramList[i])) && (!printedposlist.contains(bigramList[i])) && (!printedneutlist.contains(distWords[i]))){
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
				if((!printedneglist.contains(wordlistkeys[i])) && (!printedposlist.contains(wordlistkeys[i]))  && (!printedneutlist.contains(distWords[i])) && (!distWordslist.contains(wordlistkeys[i]))){
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



			//br3.write(d.NNcount/d.countWords+",");

			//br3.write(d.NNpaircount/d.countWords+",");



			String sstar=""+d.star;

			br3.write(sstar);
			//br3.write(d.reviewer);

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







	private static void printDocList2(CountGenerator cg, String reviewernew ) throws IOException {
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
		int cSizet=201;
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
		br3.write("@ATTRIBUTE classFinal {1,2,3,4}");
		//br3.write("@ATTRIBUTE classFinal {A,B,C,D}");
		br3.newLine();

		br3.newLine();
		br3.newLine();
		br3.write("@DATA");
		br3.newLine();
		br3.flush();


		for(Document d : cg.docList){


			if(d.reviewer.equalsIgnoreCase(reviewernew)){


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

				br3.write(sstar);
				//br3.write(d.reviewer);

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


	}


	private static void printHashTable23(Hashtable<String, Integer> poswordList2) throws IOException {

		wordkeysss = new String[poswordList2.size()];
		Enumeration en=poswordList2.keys();
		int kk=0;
		while( en. hasMoreElements() ){
			wordkeysss[kk] = (String)en.nextElement() ;
			kk++;
		}

		wordvalsss = new Integer[poswordList2.size()];
		Enumeration env=poswordList2.keys();
		int kkk=0;
		while( env. hasMoreElements() ){
			String keyss = (String)env.nextElement() ;
			wordvalsss[kkk]=poswordList2.get(keyss);
			kkk++;
		}


		//bubblesortFinal(wordkeys,wordvals);


		int n = wordvalsss.length;
		for (int pass=1; pass < n; pass++) {  // count how many times
			// This next loop becomes shorter and shorter
			for (int i=0; i < n-pass; i++) {
				if (wordvalsss[i] > wordvalsss[i+1]) {
					// exchange elements
					int temp = wordvalsss[i];  wordvalsss[i] = wordvalsss[i+1];  wordvalsss[i+1] = temp;
					String tempp = wordkeysss[i];  wordkeysss[i] = wordkeysss[i+1];  wordkeysss[i+1] = tempp;
				}
			}
		}





	}














	private static void printHashTable234(Hashtable<String, Integer> poswordList2) throws IOException {

		wwordkeysss = new String[poswordList2.size()];
		Enumeration en=poswordList2.keys();
		int kk=0;
		while( en. hasMoreElements() ){
			wwordkeysss[kk] = (String)en.nextElement() ;
			kk++;
		}

		wwordvalsss = new Double[poswordList2.size()];
		Enumeration env=poswordList2.keys();
		int kkk=0;
		while( env. hasMoreElements() ){
			String keyss = (String)env.nextElement() ;
			Integer val=poswordList2.get(keyss);
			double tf =val/CountGenerator.cntstar1wordList;
			//double tf=d.termFrequency.get(wordlistkeys[i])/d.countWords;

			ArrayList<Integer> listt=CountGenerator.stardocFrequency.get(keyss);

			double df=Math.log(4/listt.size());
			double tfidf=tf*df;

			wwordvalsss[kkk]=tfidf;
			kkk++;
		}


		//bubblesortFinal(wordkeys,wordvals);


		int n = wwordvalsss.length;
		for (int pass=1; pass < n; pass++) {  // count how many times
			// This next loop becomes shorter and shorter
			for (int i=0; i < n-pass; i++) {
				if (wwordvalsss[i] > wwordvalsss[i+1]) {
					// exchange elements
					double temp = wwordvalsss[i];  wwordvalsss[i] = wwordvalsss[i+1]; wwordvalsss[i+1] = temp;
					String tempp = wwordkeysss[i];  wwordkeysss[i] = wwordkeysss[i+1];  wwordkeysss[i+1] = tempp;
				}
			}
		}


		for(int i = wwordkeysss.length-1;i>=0;i--){

			br2.write(wwordkeysss[i]+" "+wwordvalsss[i]);
			br2.newLine(); 

			br4.write("\""+wwordkeysss[i]+"\"");
			br4.newLine();
			br4.flush();
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
