package code;

/*
 * Ashish Tomar
 * NLP HW 2
 * This class calculates all the values for the features.
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;

public class CountGenerator {


	public static Hashtable<String, Integer> wordList= new Hashtable<String, Integer>();

	public static Hashtable<String, Integer> bigramwordList= new Hashtable<String, Integer>();
	public static Hashtable<String, ArrayList<Integer>> docFrequency= new Hashtable<String, ArrayList<Integer>>();
	public static ParseFileReader parsReader= new ParseFileReader();
	public static Hashtable<String, ArrayList<Integer>> stardocFrequency= new Hashtable<String, ArrayList<Integer>>();

	public static Hashtable<String, Integer> cntposwordList= new Hashtable<String, Integer>();
	public static Hashtable<String, Integer> cntnegwordList= new Hashtable<String, Integer>();
	public static Hashtable<String, Integer> cntneutwordList= new Hashtable<String, Integer>();

	public static Hashtable<String, Integer> poswordList= new Hashtable<String, Integer>();
	public static Hashtable<String, Integer> negwordList= new Hashtable<String, Integer>();

	public static Hashtable<String, Integer> star1wordList= new Hashtable<String, Integer>();
	public static Hashtable<String, Integer> star2wordList= new Hashtable<String, Integer>();
	public static Hashtable<String, Integer> star3wordList= new Hashtable<String, Integer>();
	public static Hashtable<String, Integer> star4wordList= new Hashtable<String, Integer>();

	public static ArrayList<Document> docList= new ArrayList<Document>();


	//public static String[] stopwords= {"a","able","about","across","after","all","almost","also","am","among","an","and","any","are","as","at","be","because","been","but","by","can","cannot","could","dear","did","do","does","either","else","ever","every","for","from","get","got","had","has","have","he","her","hers","him","his","how","however","i","if","in","into","is","it","its","just","least","let","like","likely","may","me","might","most","must","my","neither","nor","of","off","often","on","only","or","other","our","own","rather","said","say","says","she","should","since","so","some","than","that","the","their","them","then","there","these","they","this","tis","to","too","twas","us","wants","was","we","were","what","when","where","which","while","who","whom","why","will","with","would","yet","you","your"};
	//public static String[] poswords= {"pleadingly", "plead", "covetingly", "pleading", "implore", "infatuated", "laughter","covet", "covetously", "lust", "brag", "impassive", "stringently", "fawn", "gloat", "demand", "imploring", "coveting", "imploringly", "demands", "payoff", "genuinely", "intrinsic", "masterly", "involved", "unfold", "unfolds", "unmatched", "outdoes", "accomplished", "exhibited", "imagined", "smoothly", "different", "Abundant", "Acclaimed", "Accomplishment", "Achievement", "Acumen", "Admire", "Adorable", "Adored", "Affirmative", "Affluent", "Amaze", "Amity", "Appreciation", "Approve", "Artistic", "Astonish", "Astounding", "Astute", "surprises", "Attractive", "entertained", "Authentic", "Beautiful", "Benefit", "Blessed", "Bliss", "Bloom", "Bountiful", "Bounty", "Brave", "Bright", "Brilliant", "Bubbly", "Calm", "Celebrate", "Charitable", "Charming", "Cheer", "Cherish", "Clarity", "Classy", "Clean", "Clever", "Commend", "Companionship", "Complete", "Comradeship", "Confident", "Conviction", "Copious", "Core", "Coupled", "Courageous", "Creative", "Cultivate", "Curious", "Cute", "Dazzling", "Delight", "Distinguished", "Divine", "Earnest", "Ecstasy", "Effervescent", "Efficient", "Effortless", "Electrifying", "Elegance", "Embrace", "Encompassing", "Encourage", "Endorse", "Energized", "Energy", "Enjoy", "Enjoyed", "Enormously", "Enthuse", "Enthusiastic", "Essence", "Established", "Esteem", "Esteemed", "Excited", "Exciting", "Exhilarating", "Exquisite", "Exultant", "Faith", "Famous", "Feat", "Flourish", "Fortunate", "Fortune", "Freedom", "Fresh", "Funny", "authenticity", "gritty", "improvisational", "libbing", "uniquely",  "Generous", "Genius", "Genuine", "mysterious", "suprisingly",  "glibness", "honors", "poignancy", "Glad", "Glow", "Gorgeous", "Grace", "Graceful", "Gratitude", "Handsome", "Harmony", "Healthy", "Hearty", "Heavenly", "Helpful", "Holy", "Honest", "Honored", "Ideal", "Imaginative", "Increase", "Incredible", "Independent", "Ingenious", "Innate", "Innovate", "Inspire", "Instantaneous", "Instinct", "Intellectual", "Intelligence", "Intuitive", "Inventive", "Jovial", "Jubilation", "Keen",  "Knowledge", "Laugh", "Leader", "Learn", "Legendary", "Light", "Lively", "merits", "topped", "Loveliness", "Lucidity", "Lucrative", "Luminous", "Maintain", "Marvelous", "Master", "Meaningful", "Meditate", "Mend", "Metamorphosis", "Mind-Blowing", "Miracle", "Mission", "Modify", "Motivate", "Moving", "Natural",  "Nourish", "Nourished", "Novel", "Nurture", "Nutritious", "Open", "Openhanded", "Optimistic", "Paradise", "Peace", "Perfect", "Phenomenon", "Pleasure", "Plenteous", "Plentiful", "Plenty", "Plethora", "Poise", "Polish", "Popular", "Positive", "Powerful", "Prepared", "Pretty", "Principle", "Productive", "Project", "Prominent", "Prosperous", "Protect", "Proud", "Quest", "Ready", "Recognized", "Refinement", "Refresh", "Rejoice", "Rejuvenate", "Relax", "Reliance", "Rely", "Remarkable", "Renew", "Renowned", "Replenished", "Resolution", "Resound", "Resources", "Respect", "Restore", "Revered", "Revolutionize", "Rewarding", "Robust", "Rousing", "Safe", "Secure", "Sensation", "Serenity", "Shift", "Shine", "Silence", "Simple", "Sincerity", "Smart", "Smooth", "Solution", "Sparkling", "Spirit", "Spirited", "Spiritual", "Splendid", "Spontaneous", "Stillness",  "Stirring", "Strong", "Style", "Success", "Sunny", "Support", "Surprise", "Surprised", "Sustain", "Synchronized", "Team", "Thankful", "Therapeutic", "Thorough", "Thrilled", "Thrive", "Tied", "Today", "Tranquil", "Transform", "Triumph", "Unity", "Unusual", "Unwavering", "Upbeat", "Valued", "Vary", "Venerated", "Venture", "Vibrant", "Victory", "Vigorous", "Vision", "Visualize", "Vital", "Vivacious", "Voyage", "Welcome", "Well", "Whole", "Wholesome", "Wonder", "Wonderful", "Wondrous", "Yes","excitedness", "preemptive", "plainly", "great", "stars", "respectable", "complimentary", "inoffensive", "exclusive", "reform", "majesty", "exalted", "responsive", "commonsensible", "lustrous", "best-performing", "unfazed", "beacon", "avid", "penetrating", "well-regarded", "recognition", "importantly", "keenly", "independent", "adherent", "untrained", "glimmer", "glad", "trustworthiness", "ebullience", "gush", "obviate", "nimble", "effusively", "rightly", "hospitable", "ebulliently", "sophisticated", "triumphal", "glimmering", "self-sufficiency", "meticulously", "cohesive", "quench", "kind", "prudently", "talent", "optimal", "gutsy", "originality", "accolades", "smarter", "daringly", "enthralled", "nice", "innovation", "insist", "heartily", "assure", "qualify", "flawless", "inclinations", "persevere", "pithy", "jaunty", "champ", "eminent", "charming", "hearten", "visionary", "overjoyed", "exalting", "prodigious", "fame", "deserve", "featly", "competent", "pledge", "adventurous", "preference", "joyfully", "tolerant", "refresh", "profit", "unquestionably", "sustainable", "demystify", "guidance", "innocuous", "well-run", "eloquent", "decency", "aver", "liberate", "illuminating", "liking", "intelligible", "stand", "booming", "unquestionable", "friendliness", "coherent", "reverence", "sweeten", "resilient", "mollify", "legitimate", "harmless", "chivalrous", "truthful", "sanguine", "grit", "practicable", "accurately", "adhesion", "defend", "commodious", "grin", "tempt", "worth-while", "well-established", "venerate", "promise", "low-risk", "temperance", "productive", "irrefutably", "sweetness", "remunerate", "amusing", "mesmerizing", "mannerly", "candor", "adaptability", "natural", "preponderance", "unconditional", "sociable", "alleviate", "irrefutable", "vigilance", "selective", "vivid", "reinforce", "flame", "renovate", "convincing", "genial", "divinely", "amenity", "astonishing", "viable", "legitimately", "expressive", "justification", "benefits", "warm", "felicity", "expertly", "warmly", "promptly", "memorable", "assent", "incisively", "lavish", "emancipate", "fair", "basic", "heroize", "supporter", "conducive", "congratulatory", "imaginative", "eloquently", "nicely", "memorialize", "yes", "scrupulously", "gems", "yep", "striking", "powerfully", "calming", "adeptly", "ethical", "heavenly", "grateful", "entranced", "epic", "ecstasies", "enchanted", "lenient", "exceed", "thoughtful", "sincere", "cohesion", "shrewd", "energetic", "indomitably", "care", "prefer", "notably", "diligence", "wisely", "acquit", "improvise", "rapture", "advantages", "influential", "stupendous", "luxuriate", "hardy", "achievable", "righten", "resounding", "rousing", "agility", "durability", "vintage", "miraculousness", "ripe", "blithe", "record-setting", "indomitable", "notable", "contentment", "surge", "pro-American", "wholeheartedly", "vibrant", "star", "famed", "agreeably", "staunchly", "perceptive", "clear", "flair", "content", "clean", "admiration", "ally", "forgivingly", "vigorously", "pleasantly", "benign", "stunning", "maturity", "reliability", "opportunity", "regally", "famously", "exceeding", "enthrall", "agreeable", "unbroken", "seasoned", "minister", "graciously", "patriot", "useful", "strides", "enchantingly", "want", "euphoric", "inclination", "terrifying", "destinies", "euphoria", "magnetic", "honeymoon", "triumph", "inspirational", "continuity", "prestigious", "thoughtfulness", "irreproachable", "open", "benevolence", "masterpiece", "upscale", "raptureous", "especially", "unforgettable", "charitable", "vastness", "restore", "cheerful", "prolific", "yearningly", "sensitive", "aptitude", "sparing", "candid", "security", "rapturously", "immaculate", "exult", "grand", "lover", "gratification", "well-connected", "intercede", "enrapture", "important", "recover", "passion", "tender", "supurb", "powerful", "above-average", "advantageous", "clearly", "humorously", "placid", "delighted", "magnificent", "sincerely", "dazzling", "redeeming", "dedicated", "classic", "treasure", "enviably", "celebration", "graciousness", "superb", "scenic", "magnify", "groundbreaking", "decisiveness", "improving", "terrifically", "cooperatively", "shelter", "unlimited", "enviable", "contribution", "self-satisfaction", "democratic", "exhilaratingly", "luxuriant", "likable", "lavishly", "calm", "precisely", "importance", "painstaking", "spur", "revelation", "flourish", "vouchsafe", "enthusiast", "humane", "law-abiding", "distinct", "valiantly", "diligent", "decent", "spirited", "enthusiasm", "positively", "integrity", "ascendant", "achievement", "worship", "approve", "enhanced", "unparalleled", "solid", "competitiveness", "dreamland", "assuage", "rejoice", "virtuously", "first-rate", "perfectly", "exhaustive", "satisfactorily", "high-quality", "spectacular", "repent", "levity", "exhilaration", "poise", "proud", "distinguish", "praising", "marvellous", "eligible", "abound", "less-expensive", "arousing", "breakthrough", "scruples", "rightfully", "admiringly", "dream", "justly", "entice", "grail", "yearn", "favor", "unbosom", "exhilarating", "time-honored", "superior", "easily", "heros", "rosy", "patriotic", "interests", "fabulously", "swiftness", "manageable", "immaculately", "surmise", "affection", "adulate", "indulgence", "effusive", "gratitude", "intelligence", "perspicuous", "concur", "highlight", "salivate", "brisk", "sweeping", "condone", "colossal", "understandable", "noticeable", "cost-saving", "animated", "relevant", "ability", "unscathed", "refinement", "magnanimously", "heroine", "harmonious", "nourish", "faith", "respect", "curious", "placate", "compromise", "unpretentious", "compassionate", "first-class", "staunchness", "serenity", "jubilantly", "healthy", "deserving", "profuse", "diligently", "playful", "clearer", "brilliance", "chivalry", "trumpet", "profess", "receptive", "venerably", "solidarity", "improve", "allow", "exuberant", "glorious", "bargain", "incontrovertible", "awestruck", "elite", "legitimacy", "careful", "pride", "venerable", "adroitly", "above", "ameliorate", "precaution", "astounded", "seamless", "moderate", "asset", "blissfully", "fortitude", "captivation", "ultra", "wishes", "popular", "non-violent", "hope", "rich", "tenacious", "onward", "covenant", "consistent", "achievements", "celebratory", "feasibly", "pleased", "indelibly", "phenomenally", "earnestly", "perseverance", "loyal", "assiduous", "vouch", "captivating", "tingle", "eminence", "awesomeness", "feasible", "vanquish", "unity", "indelible", "catchy", "phenomenal", "intriguingly", "competency", "properly", "evenly", "aspirations", "herald", "grace", "able", "live", "arresting", "motivated", "enthusiastically", "luxuriously", "befriend", "stylish", "refuge", "stunningly", "hug", "monumentally", "avidly", "resplendent", "beatify", "insistence", "cherished", "lawfully", "competence", "even", "goodness", "awesomely", "spiritual", "satisfaction", "complement", "fastest-growing", "resourceful", "lifelong", "glamorous", "forgive", "easier", "temptingly", "dance", "deft", "essential", "effusion", "usable", "universal", "reminiscent", "abidance", "neutralize", "tremendously", "holy", "spellbinding", "faithful", "excellently", "ennoble", "upward", "incontestable", "enjoyably", "benefit", "evident", "rectification", "premium", "fanfare", "fervent", "efficient", "infallibly", "suave", "lovely", "fidelity", "faithfulness", "values", "cornerstone", "urge", "polite", "handsome", "adaptive", "sustained", "godlike", "competitive", "enjoyable", "gorgeous", "understatedly", "sunny", "intricate", "infallible", "studiously", "tantalizing", "quaint", "discriminating", "acknowledgement", "settle", "dexterously", "workable", "abide", "compassion", "worth", "gainfully", "fashionably", "self-sufficient", "profusely", "kemp", "masterful", "virtuous", "incisiveness", "readily", "myriad", "renaissance", "survivor", "beautify", "fashionable", "congratulations", "undisputably", "luminous", "daring", "loyalty", "success", "reason", "potential", "well-publicized", "temperate", "conquer", "spellbind", "sensitively", "amply", "verifiable", "lawful", "irresistibly", "endurable", "undisputable", "easiest", "salable", "sound", "fitting", "exuberance", "affirm", "prowess", "precise", "cure-all", "neat", "ample", "positiveness", "irresistible", "flourishing", "humanity", "hot", "historic", "tolerantly", "gratifyingly", "affluence", "gifted", "invaluable", "fascinatingly", "wishing", "honestly", "exonerate", "cordial", "delightfully", "acknowledge", "felicitate", "signify", "dear", "conclusive", "flawlessly", "truthfully", "deal", "impressions", "guiltless", "invincibility", "envision", "ardent", "shrewdness", "stately", "expansive", "astute", "stunned", "appreciatively", "press", "mature", "alluring", "astound", "alluringly", "galore", "industrious", "admirably", "prepared", "subtle", "ingratiating", "driven", "inclined", "hopeful", "appreciable", "incorruptible", "prudent", "idealize", "admirable", "cleanse", "steadfastness", "effortlessly", "tact", "beauty", "willingness", "accordantly", "understate", "viability", "gusto", "impeccably", "foresight", "optimistic", "hero", "diversified", "celebrity", "simplicity", "gorgeously", "befit", "satisfactory", "respectfully", "impeccable", "better-than-expected", "hilariousness", "dawn", "deference", "efficacious", "meritorious", "sumptuousness", "original", "joyously", "aristocratic", "crusader", "navigable", "personages", "handy", "appropriate", "inviolable", "everlasting", "fathom", "meticulous", "ecstatically", "proactive", "adoringly", "renown", "bullish", "serene", "spellbound", "stride", "propitiously", "like", "comely", "brook", "harmonize", "allay", "thrifty", "intriguing", "compliment", "prominence", "adventure", "boldness", "dependable", "assertive", "keen", "gratefully", "generosity", "love", "electrify", "authentic", "pertinent", "undoubtedly", "effectual", "invulnerable", "ingenuity", "liberally", "beneficiary", "slender", "miraculous", "upgrade", "exciting", "chaste", "peacefully", "frolic", "comforting", "remedy", "entreatingly", "impress", "ideal", "heroically", "strong", "resurgent", "enticing", "stable", "striving", "indubitably", "vitality", "gain", "ready", "fortuitous", "wisdom", "rejoicingly", "graceful", "persuasively", "salute", "openly", "indubitable", "dazzle", "talented", "impartiality", "advisable", "accessible", "afloat", "eagerness", "conveniently", "exalt", "sufficiently", "pleasingly", "idealist", "easygoing", "definitive", "affirmative", "mastery", "understand", "idealism", "dare", "thinkable", "masters", "bliss", "simplified", "purposeful", "objectively", "modest", "humankind", "help", "outdo", "adventuresome", "tantalizingly", "poised", "harmony", "beauteous", "appreciativeness", "practical", "realistically", "superbly", "incredibly", "commitment", "praiseworthy", "distinguished", "deflationary", "amity", "judicious", "faithfully", "proficient", "invaluablely", "sensational", "modern", "glowingly", "discretion", "ingratiate", "stainless", "sensationally", "advantage", "incredible", "paradise", "congratulate", "befitting", "spectacularly", "truth", "respectful", "hallowed", "devotee", "suitable", "devoted", "luster", "beautiful", "boost", "fervently", "confer", "enchant", "legendary", "extol", "trust", "affability", "glorify", "liberation", "awe", "elan", "jubilation", "purification", "exquisitely", "courageous", "endorse", "privileged", "destiny", "undaunted", "acclamation", "offset", "recommend", "gloriously", "soundness", "fascination", "afford", "flatter", "posterity", "painless", "foolproof", "priceless", "indescribably", "honor", "destine", "insistent", "sturdy", "premier", "kid", "diplomatic", "healthful", "agilely", "willful", "thrive", "survival", "plausible", "recommendation", "freedom", "commonsense", "indescribable", "illumine", "darling", "virtue", "fascinating", "succeed", "integral", "grandeur", "ardently", "simplify", "painstakingly", "rightful", "maturely", "mightily", "boom", "fantasy", "surging", "supreme", "sense", "fertile", "ebullient", "personality", "terrified", "stirring", "ingenuously", "renowned", "wonderful", "unconcerned", "electrification", "romantic", "merciful", "realistic", "marvelousness", "master", "indispensable", "uphold", "unabashed", "desirable", "triumphantly", "enraptured", "accolade", "affirmation", "passionate", "pleasing", "epitome", "quasi-ally", "excitedly", "courteous", "innocent", "securely", "luxury", "politeness", "valuable", "discriminatingly", "idolized", "spacious", "assurances", "learned", "determination", "richly", "crisp", "protector", "persistent", "comfort", "ultimate", "sentimentally", "intimate", "fortune", "outwit", "well-informed", "repair", "heart", "pious", "smile", "modesty", "bold", "insightful", "fantastic", "extraordinarily", "fervor", "reconcile", "courageously", "fondness", "well-received", "elated", "trump", "rationality", "fortunately", "smooth", "better", "reward", "kindliness", "prodigy", "illuminati", "ingenuous", "unanimous", "illuminate", "apt", "amazingly", "appeal", "endure", "truly", "angel", "unique", "outstandingly", "honest", "ingeniously", "fortuitously", "catalyst", "tolerably", "humorous", "merriment", "blessing", "gracefully", "favorite", "necessary", "hopefully", "hopefulness", "exultation", "honorable", "guarantee", "sleek", "handily", "tolerable", "friendly", "assertions", "thorough", "literate", "convenient", "obey", "heartwarming", "reassure", "kingmaker", "elegance", "traditional", "broad", "enhancement", "ecstatic", "full-fledged", "real", "beautifully", "rapturous", "skilled", "trusting", "sumptuous", "preferably", "motivation", "abundance", "inclusive", "flattering", "well-positioned", "attractive", "uniformly", "empowerment", "heal", "elegant", "prominent", "substantive", "shield", "preferable", "torridly", "go-ahead", "pacifist",  "breathtakingly", "terrify", "toleration", "profound", "greatness", "outgoing", "dashing", "earnest", "approval", "plush", "lush", "astounding", "autonomous", "comprehensive", "ardor", "lionhearted", "lifeblood", "patiently", "amour", "obedience", "engaging", "gentle", "friends", "allowable", "defender", "brilliantly", "swift", "sublime", "impressiveness", "gaiety", "mindful", "sparkle", "triumphant", "fragrant", "togetherness", "prospect", "consensus", "sworn", "thriving", "resolve", "rehabilitation", "slim", "obliged", "best", "acceptable", "fine", "comfortably", "almighty", "thrill", "functional", "constancy", "reverently", "pinnacle", "comeback", "impervious", "overachiever", "charity", "marvel", "coherence", "improved", "merry", "dodge", "gallant", "uncommon", "comfortable", "valiant", "sensibly", "humor", "economical", "regal", "precedent", "leverage", "righteousness", "fulfillment", "excellency", "riches", "reputable", "rewardingly", "champion", "cogent", "commendably", "fervid", "safeguard", "painlessly", "simple", "rave", "sensible", "exquisite", "rapprochement", "educable", "marvelous", "excellence", "overture", "commendable", "confident", "enjoy", "adroit", "understated", "top", "gleeful", "amiabily", "reverent", "permissible", "plentiful", "arouse", "fresh", "flatteringly", "picturesque", "compromises", "gaily", "uttermost", "amazed", "benevolent", "adorable", "victory", "sustainability", "forgiveness", "maximize", "amusingly", "seductive", "timely", "individuality", "bloom", "resolved", "reasonably", "pretty", "advanced", "solicitous", "indisputable", "confidence", "self-determination", "exultingly", "sexy", "peaceful", "lyrical", "ambitious", "protect", "thrills", "wish", "outstrip", "homage", "willing", "wise", "reasonable", "dignity", "fearlessly", "amiable", "credible", "gladly", "stupendously", "responsibly", "obediently", "unbound", "significance", "opulent", "awesome", "improvement", "admit", "captivate", "lighten", "warmhearted", "insight", "attraction",  "positive", "wry", "hilarity", "enrich", "skillfully", "magical", "intuitive", "compelling", "remarkably", "earnestness", "boundless", "excusable", "sanctity", "impel", "efficiency", "twinkly", "trustingly", "moving", "thrillingly", "rights", "surpass", "independence", "favorable", "dexterity", "upheld", "goodly", "uplift", "optimism", "enchanting", "thrift", "remarkable", "assurance", "soothe", "shimmeringly", "posh", "appreciative", "enable", "peaceable", "gleefully", "giddy", "bull", "destined", "romanticize", "world-famous", "suggest", "fervidly", "auspicious", "rapt", "humourous", "civilize", "craving", "adaptable", "happy", "preeminent", "perspicuously", "humanists", "speedy", "attest", "treat", "qualified", "genuine", "justify", "enduring", "vastly", "thankfully", "upfront", "joyful", "wow", "conciliate", "romantically", "halcyon", "delicate", "masterpieces", "lively", "appreciate", "playfully", "woo", "realist", "piety", "hilariously", "enlighten", "dreamy", "heady", "abilities", "interest", "wink", "dreams", "asylum", "vigilant", "god-given", "definitively", "appealing", "advocate", "adulation", "embellish", "thankful", "vigorous", "festive", "active", "gratify", "amazing", "reasoned", "sure", "buoyant", "assiduously", "cozy", "glisten", "truthfulness", "vibrantly", "rescue", "entertain", "merit", "sparingly", "admittedly", "raptureously", "astutely", "exemplar", "equality", "luckiness", "prestige", "substantially", "deserved", "will", "wonderous", "whimsical", "consummate", "delightful", "jolly", "intimacy", "spotless", "unassailable", "streamlined", "sanction", "instrumental", "revive", "vindicate", "satisfy", "happily", "tranquility", "titillating", "fluent", "significant", "progress", "veritable", "insightfully", "revival", "impartial", "devout", "justice", "voluntarily", "mild", "yearning", "victorious", "stabilize", "wonder", "portable", "breakthroughs", "bless", "cooperative", "foremost", "merrily", "voluntary", "uniform", "wondrous", "fruitful", "impressive", "daydream", "wonderfully", "ovation", "meaningful", "manly", "hale", "decisive", "heaven", "fond", "attune", "civility", "pamper", "soft-spoken", "embolden", "agreeability", "richness", "cherish", "desire", "devote", "reaffirmation", "masterfully", "passionately", "endear", "pacifists", "subscribe", "easiness", "appreciation", "rally", "support", "stood", "perfect", "right", "indefatigable", "friendship", "brighten", "lucidly", "bolster", "non-violence", "impregnable", "protective", "enlightenment", "accordance", "pleasure", "embrace", "amuse", "excited", "successfully", "harmoniously", "brave", "affably", "rational", "feisty", "blossom", "tenderly", "precautions", "gainful", "stylishly", "lovably", "redeem", "oasis", "providence", "invincible", "poeticize", "explicit", "accomplishments", "compensate", "affable", "truculently", "relish", "hardier", "joy", "easy", "blissful", "blameless", "sentimentality", "lovable", "luck", "funny", "laudably", "carefree", "refined", "discerning", "hail", "persuade", "versatile", "patient", "patience", "inviolate", "profitable", "mighty", "ingratiatingly", "enterprising", "spirit", "preach", "ease", "breathtaking", "value", "welcome", "appease", "torrid", "amazement", "neatly", "laudable", "privilege", "capability", "trepidation", "indestructible", "pro-peace", "mercy", "solicitously", "lower-priced", "excite", "rectify", "advice", "solace", "novel", "excellent", "excitingly", "hilarious", "robust", "low-cost", "worthwhile", "angelic", "loveliness", "knowledgeable", "regard", "pro-Cuba", "luckiest", "adequate", "tickle", "favour", "luckily", "agile", "splendor", "reassurance", "deservedly", "fascinate", "gallantly", "accord", "outsmart", "profoundly", "encouragingly", "stability", "humour", "courageousness", "well-intentioned", "polished", "eager", "luxurious", "dexterous", "tempting", "divine", "console", "ultimately", "enthusiastic", "moral", "devotion", "lean", "helpful", "credence", "re-conquest", "conceivable", "renovation", "adherence", "bonus", "adulatory", "dignify", "upside", "savvy", "better-known", "fondly", "honesty", "glistening", "breathlessness", "fantastically", "trustworthy", "suit", "zest", "dextrous", "upliftingly", "squarely", "statuesque", "eloquence", "cooperation", "heartfelt", "friend", "logical", "infallibility", "wide", "repay", "impression", "drive", "saintly", "mirth", "steadfastly", "gem", "substantial", "charmingly", "resolute", "okay", "apostle", "elate", "purity", "plausibility", "miraculously", "sanctify", "brotherly", "pre-eminent", "correct", "reliably", "pure", "amenable", "recommended", "enliven", "jubilate", "defense", "calmness", "affinity", "elegantly", "vivacious", "beneficially", "imperturbable", "delicious", "prosperity", "sanity", "protection", "extraordinary", "freedoms", "reliable", "wide-ranging", "attentive", "co-operation", "finely", "empower", "usefulness", "thank", "acclaim", "distinctive", "understanding", "creative", "agreement", "definitely", "merriness", "invigorating", "commend", "valor", "reunite", "steadiness", "amnesty", "courtesy", "convincingly", "tenaciously", "brainy", "truculent", "awed", "outshine", "super", "shimmer", "brains", "nifty", "closeness", "principled", "beloved", "rightness", "restraint", "semblance", "tenderness", "leading", "delectable", "reparation", "flexible", "interested", "prudence", "enhance", "elevated", "adorer", "accurate", "unequivocal", "offbeat", "reconciliation", "revolution", "promising", "necessarily", "laud", "adored", "peerless", "innocence", "amusement", "guardian", "charismatic", "applaud", "forgave", "idolize", "unselfish", "agreeableness", "gracious", "colorful", "idyllic", "validity", "splendid", "recompense", "reaffirm", "illustrious", "liberty", "dynamic", "golden", "farsighted", "desirous", "goodwill", "miracle", "vast", "admission", "sanctuary", "impetus", "progressive", "luckier", "courtly", "unencumbered", "reclaim", "rapport", "pro", "utilitarian", "courage", "smilingly", "clout", "tantalize", "matchless", "aspiration", "vital", "preaching", "envisions", "delicacy", "straightforward", "civilization", "bonny", "radiant", "marvels", "shimmering", "plenty", "toast", "egalitarian", "happiness", "accomplish", "eagerly", "skillful", "elation", "savor", "admiring", "sacred", "magnanimous", "soothingly", "jubilant", "bountiful", "bask", "advocacy", "sweet", "marvelously", "respite", "prompt", "lark", "stimulative", "paramount", "educational", "endorsement", "boldly", "compatible", "worthiness", "salvation", "joyous", "interesting", "resound", "esteem", "jollify", "unfettered", "boast", "doubtless", "surely", "smartest", "amiability", "inquisitive", "backbone", "delightfulness", "upright", "beneficial", "prospects", "indispensability", "responsibility", "exceptionally", "strikingly", "worthy", "prosper", "revel", "free", "entrust", "distinction", "fancy", "exhaustively", "cohere", "conviction", "valid", "dauntless", "eventful", "pardon", "keenness", "kindness", "rectifying", "smiling", "consent", "capably", "gratifying", "noteworthy", "explicitly", "shrewdly", "dotingly", "commonsensical", "civil", "sincerity", "constructive", "versatility", "repentance", "encourage", "motivate", "lucky", "wealthy", "tidy", "suggestions", "capable", "spare", "gumption", "cute", "enthuse", "entrance", "relaxed", "relief", "pundits", "bravery", "openness", "secure", "hard-working", "assuredly", "engrossing", "astoundingly", "wholesome", "nurturing", "praise", "germane", "effectiveness", "court", "bright", "persuasive", "ascertainable", "acclaimed", "affectionate", "unconventional", "tolerance", "supurbly", "true", "uplifting", "objective", "perfection", "undisputed", "preferences", "excel", "fairness", "acumen", "glowing", "haven", "titillate", "lucid", "informative", "revitalize", "reestablish", "astonishingly", "stirringly", "terrifyingly", "achieve", "accept", "crusade", "abundant", "peace", "admire", "prosperous", "fast-paced", "expert", "normal", "fearless", "convince", "smitten", "celebrate", "poetic", "fortunate", "stellarly", "altruistically", "nourishment", "well-educated", "promoter", "well-wishers", "prettily", "survive", "majestic", "exceptional", "frank", "amaze", "confute", "witty", "clarity", "terrific", "curiously", "astonish", "invigorate", "fabulous", "saint", "uncommonly", "dignified", "solicitude", "adore", "pillar", "please", "risk-free", "humble", "fiery", "purify", "leniently", "sprightly", "acceptance", "gladness", "stimulating", "willfully", "cost-effective", "genius", "entertaining", "cheer", "pleasurably", "established", "believable", "brilliant", "comrades", "reinforcement", "mellow", "chum", "cherub", "nobly", "skill", "glow", "rewarding", "precision", "pleasurable",  "mend", "hanker", "mysteriously","special", "altruistic", "inspiring", "well-managed", "intrigue", "rejoicing", "joke", "incisive", "coax", "noble", "magic", "radiance", "moralize", "sagacity", "pledges", "delight", "groove", "adoring", "attractively", "orderly", "justifiably", "learning", "clever", "eclectic", "ambitiously", "well", "endearing", "opportune", "precious", "justifiable", "tribute", "excitement", "ingenious", "unabashedly", "impartially", "supportive", "studious", "heroic", "refreshing", "aspire", "staunch", "self-respect", "mesmerize", "superlative", "zeal", "supremely", "sumptuously", "palatial", "congenial", "relevance", "magnificently", "astonishment", "considerate", "ideally", "untouched", "experienced", "upbeat", "encouragement", "accommodative", "enjoyment", "exaltation", "mercifully", "arousal", "effortless", "hopes", "endorser", "admirer", "innocently", "zenith", "righteous", "mesmerizingly", "feat", "daydreamer", "restful", "glory", "tranquil", "absolve", "eternity", "smart", "resourcefulness", "welfare", "felicitous", "effective", "cooperate", "evocative", "enticingly", "spellbindingly", "surmount", "just", "generously", "definite", "affordable", "renewal", "beneficent", "unequivocally", "effusiveness", "humility", "intelligent", "trendy", "exemplary", "vow", "jest", "sane", "best-known", "successful", "splendidly", "soften", "attainable", "glitter", "winners", "concrete", "generous", "impressively", "award", "salutary", "righteously", "exaltedly", "conscientious", "tremendous", "thrilling", "revere", "gladden", "unbiased", "scrupulous", "refine", "instructive", "equitable", "sufficient", "facilitate", "miracles", "penitent", "enthral", "forgiving", "morality", "suffice", "pro-Beijing", "evidently", "restoration", "sensations", "sentiment", "discreet", "compliant", "wellbeing", "imperial", "good", "aptly", "impassioned", "elevate", "brightness", "youthful", "popularity", "amicability", "energize", "sparkling", "crave", "adventurism", "encouraging", "back", "accomplishment", "quicken", "naturally", "prodigiously", "enrapt", "inspire", "headway", "kindly", "saintliness", "taste", "trim", "stellar", "light-hearted", "agree", "shiny", "wonderously", "inexpensive", "articulate", "recommendations", "inventive", "capitalize", "best-selling", "satisfying", "straight", "forgiven", "fairly", "undoubted", "cleanliness", "shine", "apotheosis", "proper", "commensurate", "attain", "liberal", "edify", "smartly", "pleasant", "durable", "titillatingly", "steady", "sensitivity", "erudite", "palliate", "indulgent", "cheery", "well-being", "wide-open", "meek", "jauntily", "upliftment", "insistently", "astonished", "inspiration", "greet", "innovative", "heartening", "fast-growing", "mentor", "affluent", "peacekeepers", "accede", "enrichment", "sagely", "relax", "greatest", "winnable", "kiss", "gold", "altruist", "relent", "ensure", "exaltingly", "proficiently", "jovial", "vulnerable", "potent", "correctly", "extoll", "conciliatory", "tenacity", "redemption", "manifest", "rehabilitate", "idol", "sweetly", "sensation", "propitious", "glee", "coddle", "exhilarate", "eulogize", "palatable", "liberalism", "educated", "sweetheart", "sentiments", "celebrated", "clear-cut", "relieve", "exuberantly", "utmost", "unrestricted", "inalienable", "momentous", "balanced", "lofty", "thoughtfully", "authoritative", "entrancing", "obedient", "charm", "favored", "fit", "tolerate", "punctual", "exceedingly", "entreat", "pragmatic", "dote", "glossy", "principle", "dazzled", "sage", "euphorically", "indebted", "compact", "chic", "amicably", "inestimably", "lucrative", "outstanding", "prize", "intact", "monumental", "ecstasy", "tradition", "steadfast", "benefactor", "magnificence", "light", "understood", "famous", "amicable", "warmth", "inestimable", "poignant", "safe", "moderation", "allure", "white", "nourishing", "stimulate", "elatedly", "profusion", "nurture", "adept", "commonsensibly"};
	//public static String[] negwords= {"clich", "average", "misses", "sink", "lamest", "abandoned ", "abused ", "accused ", "addicted ", "afraid ", "aggravated ", "aggressive ", "alone ", "angry ", "anguish ", "annoyed ", "stereotypes", "squirming", "unnoticeable", "unoriginal", "anxious ", "apprehensive ", "insipid", "missing", "spoof", "spoofing", "forgetable", "regretable", "vacuous", "sophomoric", "argumentative ", "artificial ", "ashamed ", "assaulted ", "risk ", "atrocious ", "attacked ", "avoided ", "awful ", "awkward ", "bad ", "badgered ", "baffled ", "banned ", "barren ", "belittled ", "berated ", "betrayed ", "bitched ", "bitter ", "bizzare ", "blacklisted ", "blackmailed ", "blamed ", "bleak ", "blown ", "blur ", "bored ", "boring ", "bossed-around ", "bothered ", "bothersome ", "bounded ", "boxed-in ", "broken ", "bruised ", "brushed-off ", "bugged ", "bullied ", "bummed ", "burdened ", "burdensome ", "burned ", "burned-out ", "caged ", "careless ", "chaotic ", "chased ", "cheated ", "chicken ", "claustrophobic ", "clingy ", "closed ", "clueless ", "clumsy ", "coaxed ",  "coerced ", "cold ", "cold-hearted ", "combative ", "commanded ",  "compulsive ", "conceited ", "concerned ", "condescended ", "confined ", "conflicted ", "confronted ", "confused ", "conned ", "consumed ", "contemplative ", "contempt ", "contentious ", "controlled ", "convicted ", "cornered ", "corralled ", "cowardly ", "crabby ", "cramped ", "cranky ", "crap ", "crappy ", "crazy ", "creeped ", "creepy ", "critical ", "criticized ", "cross ", "crowded ", "cruddy ", "unrehearsed", "crummy ", "crushed ", "cut-down ", "cut-off ", "damaged ", "damned ", "dangerous ", "dazed ", "deceived ", "defamed ", "defeated ", "defective ", "defenseless ", "defensive ", "defiant ", "deficient ", "deflated ", "degraded ", "dehumanized ", "dejected ",  "deluded ", "demanding ", "demeaned ", "demented ", "demoralized ", "demotivated ",  "depleted ", "depraved ", "depressed ", "deprived ", "melodramatics", "punishment ", "desolate ", "despair ", "despairing ", "desperate ", "despicable ", "despised ", "destroyed ", "destructive ", "detached ", "detest ", "detestable ", "detested ", "devalued ", "devastated ", "deviant ", "devoid ", "diagnosed ", "dictated ", "difficult ", "directionless ", "dirty ", "disabled ", "disagreeable ", "disappointed ", "disappointing ", "disapproved ", "disbelieved ", "discardable ", "discarded ", "disconnected ", "discontent ", "discouraged ", "discriminated ", "disdain ", "disdainful ", "disempowered ", "disenchanted ", "disgraced ", "disgruntled ", "disgust ", "disgusted ", "disheartened ", "dishonest ", "dishonorable ", "disillusioned ", "dislike ", "disliked ", "dismal ", "dismayed ", "disorganized ", "disoriented ", "disowned ", "displeased ", "disposable ", "disregarded ", "disrespected ", "dissatisfied ", "distant ", "distracted ", "distraught ", "distressed ", "disturbed ", "dizzy ", "dominated ", "doomed ", "double-crossed ", "doubted ", "doubtful ", "down ", "downhearted ", "downtrodden ", "drained ",  "dread ", "dreadful ", "dreary ", "dropped ", "drunk ", "dry ", "dumb ", "dumped ", "duped", "edgy ", "egocentric ", "egotistic ", "egotistical ", "elusive ", "emancipated ", "emasculated ", "embarrassed ", "emotional ", "emotionless ", "bankrupt ", "empty ", "encumbered ", "endangered ", "enraged ", "enslaved ", "entangled ", "evaded ", "evasive ", "evicted ", "excessive ", "excluded ", "exhausted ", "exploited ", "exposed ", "failful", "fake ", "fearful ", "fed ", "flawed ", "forced ", "forgetful ", "forgettable ", "forgotten ", "fragile ", "freaked ", "frightened ", "frigid ", "frustrated ", "gloomy ", "glum ", "gothic ", "grey ", "grief ", "grim ", "gross ", "grossed-out ", "grotesque ", "grouchy ", "grounded ", "grumpy ", "guilt-tripped ", "guilty ", "harassed ", "hard ", "hard-hearted ", "harmed ", "hassled ", "hate ", "hateful ", "hatred ", "haunted ", "heartbroken ", "heartless ", "heavy-hearted ", "helpless ", "hesitant ", "hideous ", "hindered ", "hopeless ", "horrible ", "horrified ", "horror ", "hostile ", "hot-tempered ", "humiliated ", "hung ", "hurried ", "idiotic ", "ignorant ", "ignored ", "ill ", "ill-tempered ", "imbalanced ", "imposed-upon ", "impotent ", "imprisoned ", "impulsive ", "dumps ", "inactive ", "inadequate ", "incapable ", "incommunicative ", "incompetent ", "incompatible ", "incomplete ", "incorrect ", "indecisive ", "indifferent ", "indoctrinated ", "inebriated ", "ineffective ", "inefficient ", "inferior ", "infuriated ", "inhibited ", "inhumane ", "injured ", "injusticed ", "insane ", "insecure ", "insignificant ", "insincere ", "insufficient ", "insulted ",  "interrogated ", "interrupted ", "intimidated ", "intoxicated ", "invalidated ",  "irrational ", "irritable ", "irritated ", "jealous ", "jerked ", "joyless ", "labeled ", "laughable ", "lazy ", "limited ", "lonely ", "lonesome ", "lost ", "lousy ", "loveless ", "mad ", "manipulated ", "masochistic ", "messed ", "messy ", "miffed ", "miserable ", "misled ", "mistaken ", "mistreated ", "mistrusted ", "misunderstood ", "mixed-up ", "mocked ", "molested ", "nagged ", "needy ", "negative ", "nervous ", "neurotic ", "nonconforming ", "numb ", "nuts ", "nutty", "objectified ", "obligated ", "obsessed ", "obsessive ", "obstructed ", "odd ", "offended ", "opposed ", "oppressed ", "over-controlled ", "over-protected ", "overwhelmed", "panic ", "paranoid ", "passive ", "pathetic ", "pessimistic ", "petrified ", "phony ", "pissed ", "plain ", "pooped ", "poor ", "powerless ", "pre-judged ", "preached", "preoccupied ", "predjudiced ", "pressured ", "prosecuted ", "provoked ", "psychopathic ", "psychotic ", "punished ", "pushed ", "puzzled ", "quarrelsome ", "queer ", "questioned ", "rage ", "raped ", "rattled ", "regret ", "rejected ", "resented ", "resentful ",  "retarded ", "revengeful ", "ridiculed ", "ridiculous ", "robbed ", "rotten ", "sad ", "sadistic ", "sarcastic ", "scared ", "scarred ", "screwed ", "self-centered ", "self-conscious ", "self-destructive ", "self-hatred ", "selfish ",  "shy ", "singled-out ", "slow ", "smothered ", "snapped", "spiteful ", "stereotyped ", "strange ", "stressed ", "stretched ", "stuck ", "stupid ", "submissive ", "suffering ", "suffocated ", "suicidal ", "superficial ", "suppressed ","idiotically", "doggedly", "antithetical", "disappoint", "cancerous", "coping", "proscription", "demonic", "suicide", "absurdity", "overzealously", "evade", "rupture", "mere", "laconic", "hardship", "impudent", "balk", "unfunded", "askance", "guiltily", "disinterest", "vexing", "impose", "narrower", "lecherous", "unprecedented", "diabolically", "remorsefully", "weariness", "warily", "deadlock", "upheaval", "least", "snarl", "distressingly", "edgy", "virulence", "unwieldy", "snare", "compulsive", "unilateralism", "perfunctory", "calamity", "demonize", "fragile", "vex", "exhaustion", "traumatic", "loophole", "ill", "exile", "disbelieve", "elimination", "polarisation", "spilling", "unconvincingly", "perfidious", "berserk", "hatefully", "problems", "obstinately", "inappropriately", "jolt", "fallaciousness", "heresy", "disrespecting", "confrontational", "fallacy", "reviled", "tepid", "bait", "erroneously", "conspiratorial", "roadblocks", "less-developed", "vagueness", "obsess", "peeve", "defiantly", "stammer", "encroachment", "dirt", "opinionated", "traitorously", "overwhelm", "degenerate", "mistake", "dire", "inhumanity", "enrage", "suspiciously", "villify", "inequalities", "ruthless", "obscenity", "damnably", "digress", "ill-favored", "vain", "symptom", "sinisterly", "apathetically", "self-destructive", "accost", "collapse", "damnable", "rollercoaster", "fundamentalism", "prohibit", "uproarious", "fudge", "critics", "niggle", "profanity", "dismaying", "disapprobation", "incoherent", "inappropriate", "envious", "slaughtered", "impinge", "fear", "indistinct", "disputable", "involuntarily", "feckless", "fiend", "vociferously", "complacent", "fears", "revengeful", "hideous", "indeterminably", "debate", "scandal", "melodramatically", "jealously", "frail", "gaudy", "imaginary", "laughably", "sloppily", "disown", "fissures", "unsettlingly", "shabby", "indeterminable", "fretful", "sputter", "severity", "brainwash", "paradoxically", "jealousness", "lecture", "unorthodox", "laughable", "debase", "outburst", "bitchy", "deviate", "debilitate", "vengeful", "tyranny", "compulsion", "affectation", "disaffected", "impudently", "horrendously", "stooge", "downfall", "expire", "usurper", "overtaxed", "grudging", "incomprehension", "inflated", "irresolvable", "leaky", "dishonestly", "travesties", "selfishly", "doldrums", "spite", "stressful", "concession", "pretence", "corrosive", "heartless", "starkly", "devastated", "disgusting", "belated", "gallingly", "apprehensively", "headache", "despoiler", "touchy", "devastate", "glib", "villian", "peripheral", "peril", "treachery", "trickery", "mourn", "calamitously", "accursed", "improperly", "insulting", "racists", "pricey", "frightening", "icy", "hothead", "unprecedent", "maddening", "adulteration", "weird", "adamantly", "annoy", "inexplainable", "obnoxiously", "distressed", "viciousness", "exploit", "eccentric", "aggravate", "unrelenting", "stagger", "uncivil", "arrogant", "immoderately", "questionable", "down", "dejection", "desecrate", "dilly-dally", "perfidity", "virulent", "moody", "bragger", "bothersome", "obsessions", "impetuously", "impossibly", "bum", "disrespectable", "bereavement", "extremely", "uncouth", "jeers", "bug", "lapse", "misuse", "puppet", "inevitably", "abject", "erosion", "blandish", "battle", "flaws", "deceptive", "surrender", "impossible", "deteriorate", "idiocy", "midget", "abscond", "thankless", "dismissive", "insultingly", "inevitable", "eradicate", "inconsequentially", "imprudence", "sober", "contrive", "shrouded", "casualty", "susceptible", "unable", "junk", "disobey", "forceful", "remorseful", "ill-advised", "forbid", "unhappy", "bewilder", "forgetfully", "imperfectly", "detriment", "discontinuity", "allegations", "destroy", "impure", "castigate", "inexcusably", "inordinately", "chit", "savagery", "disvalue", "interrupt", "helplessly", "wariness", "repugnance", "prisoner", "pessimistically", "emasculate", "desertion", "procrastinate", "inexcusable", "capsize", "disobedient", "addiction", "deadbeat", "tauntingly", "biting", "accusingly", "domination", "panic", "short-lived", "divisively", "wretched", "malevolently", "defamation", "distrusting", "betray", "beggarly", "harboring", "shamefulness", "lascivious", "scorching", "damned", "outcry", "extravagant", "turbulent", "pervert", "slight", "corrosion", "inconsequently", "overblown", "isolate", "anxiousness", "failures", "lawbreaker", "premeditated", "explode", "crippling", "lackluster", "flash", "pretentiously", "presumptuously", "negative", "allergic", "peculiar", "incapably", "exterminate", "mean", "squash", "compulsory", "timid", "condolence", "exasperatingly", "vague", "manic", "horribly", "mania", "falter", "cash-strapped", "incapable", "oddest", "fastidious", "mocking", "heavy-handed", "irreformable", "bitch", "accuse", "offending", "nosey", "barbarically", "wrong", "revenge", "horrible", "fluster", "martyrdom", "hawkish", "lesser-known", "breach", "dissident", "maladjusted", "ignominy", "junky", "dwindling", "dope", "perversely", "omit", "gullible", "extravagance", "depression", "dictatorial", "greed", "defect", "trick", "oddities", "clash", "seedy", "unqualified", "harsh", "hardliner", "mockeries", "fearsome", "deception", "finagle", "ignorant", "vexingly", "neglect", "doom", "byzantine", "bully", "miserly", "inaccurate", "blameworthy", "hegemonistic", "dodgey", "bristle", "shiver", "contamination", "mirage", "expose", "sketchy", "depressing", "succumb", "choppy", "inglorious", "over-valuation", "jeopardize", "forgetful", "savagely", "destroyer", "immorally", "bulky", "cave", "troublemaker", "despotism", "vindictively", "sharp", "lowly", "controversial", "imperialist", "shark", "nefarious", "kill", "immobilized", "barely", "damage", "set-up", "divergent", "defeat", "infirm", "corrupt", "trial", "overworked", "inextricably", "disgustfully", "discontentedly", "illogically", "gossip", "beware", "corrode", "misunderstand", "felonious", "censure", "impulsively", "barren", "harpy", "proscriptions", "delirium", "pale", "inextricable", "exhaust", "clumsy", "trouble", "grim", "boiling", "fetid", "enflame", "incompetence", "spoonfed", "mistrust", "revert", "resentful", "dreary", "misgiving", "ramshackle", "uncomfortable", "partisan", "distract", "overstatements", "infested", "overbearing", "odd", "lifeless", "punch", "undocumented", "plebeian", "dawdle", "laughingstock", "disgruntle", "wayward", "toughness", "appal", "miseries", "cumbersome", "unrest", "aspersion", "letch", "madness", "childish", "blasphemy", "sneakily", "excoriate", "repudiate", "condolences", "negation", "nauseatingly", "formidable", "precarious", "outdated", "breakdown", "forfeit", "dissatisfied", "gloomy", "swipe", "horrendous", "detest", "abhors", "blaspheme", "throw", "carp", "flaky", "risk", "conspire", "defamatory", "clamor", "pain", "insolent", "tardy", "tediously", "enemy", "unnaturally", "incessant", "attack", "harms", "divorced", "adversarial", "impugn", "flake", "preposterous", "disadvantaged", "difficulties", "alienation", "apologists", "endless", "forbidding", "stagnate", "dread", "uneasily", "indifferent", "substandard", "wary", "irrationality", "unacceptablely", "itch", "inopportune", "so-called", "misbehavior", "warp", "thorny", "overrun", "shame", "lovelorn", "accuses", "slashing", "upbraid", "flakey", "abhorrent", "grouse", "flighty", "frustratingly", "capitulate", "shocking", "spook", "hotbeds", "sourly", "lethal", "angry", "notorious", "frenzy", "avoid", "ejaculate", "treacherous", "gravely", "scowl", "impractical", "confess", "shaky", "abuse", "incomplete", "uncompromising", "resignation", "refusal", "venomous", "urgent", "asunder", "shake", "mystery", "fictitious", "haggard", "avenge", "busybody", "beg", "anti-white", "tiresome", "worst", "scariest", "unjustifiably", "ravage", "decrepit", "inhibit", "quit", "relentless", "god-awful", "get-rich", "distressing", "worse", "ignominious", "eccentricity", "static", "inelegant", "sickness", "despicably", "unjustifiable", "misread", "baffle", "pitiable", "dishonorable", "adulterated", "worry", "horrifying", "discouragement", "abasement", "dismally", "ghetto", "disgraced", "goading", "perplex", "vindictiveness", "despicable", "dissension", "spurious", "kick", "scourge", "frenetically", "kook", "bewail", "travesty", "imprecise", "spookily", "wane", "instigator", "inflexible", "detract", "insanely", "totalitarian", "dismayed", "lewdly", "egotism", "contrived", "infringe", "stagnant", "incongruous", "dissent", "acrimony", "impropriety", "dupe", "calumny", "extraneous", "shallow", "retreat", "antagonistic", "deprive", "extreme", "lacking", "impending", "awfully", "misinform", "unfinished", "regretful", "inclement", "rile", "anti-", "ugh", "rotten", "despair", "demean", "shatter", "slow-moving", "bar", "dunce", "indigent", "ashamed", "mischievous", "dislocated", "scorn", "undependability", "bad", "assault", "spoil", "lawless", "hoodwink", "flirty", "ferocity", "doubt", "hellion", "dilemma", "penalty", "denunciation", "disrepute", "brood", "collide", "discord", "disquieting", "uninsured", "bruise", "staggeringly", "resigned", "inadvisably", "ignoble", "jealous", "unwisely", "crafty", "dump", "asininely", "plague", "harshly", "absurdness", "battering", "buckle", "repressive", "radicalization", "babble", "inadvisable", "dumb", "oppress", "downhearted", "swore", "neglected", "daunting", "unscrupulous", "cruelty", "dispute", "shady", "queer", "miserableness", "nightmare", "dull", "relentlessness", "ill-tempered", "battered", "superstition", "ineptitude", "wail", "pleas", "indignantly", "undermine", "senseless", "disprove", "dreadfully", "sanctimonious", "prickles", "nauseate", "spurn", "teasingly", "dissatisfying", "seething", "hamstring", "disrespectfully", "hideousness", "discountenance", "mournful", "inaccuracy", "wickedness", "vulgar", "pessimistic", "admonishment", "loathsomely", "maltreatment", "evil", "recession", "mishap", "heartrending", "bombardment", "sobering", "involuntary", "insatiable", "swoon", "alas", "useless", "disgusted", "mismanage", "broke", "degrading", "rift", "insufficiency", "ruffle", "retire", "monstrosity", "excuses", "slander", "despairing", "arcane", "displease", "repulsiveness", "coldly", "distraughtly", "spookier", "concessions", "sarcastically", "wildly", "rife", "flagrantly", "mistakes", "cringe", "abhor", "mistaken", "disconcert", "fatalistic", "aspersions", "prohibitive", "annoyance", "garish", "blasphemous", "traitor", "spiritless", "indiscretion", "shamelessness", "listless", "last-ditch", "trauma", "problem", "far-fetched", "scold", "refute", "strictly", "sugar-coated", "exorbitantance", "repugnantly", "indistinctive", "carelessness", "violate", "spot", "intrusive", "disagree", "vocally", "inadverently", "obnoxious", "snatch", "refuse", "foulness", "dissonant", "incognizant", "feeblely", "swamped", "battleground", "incoherently", "temper", "hazard", "desolation", "scum", "prevaricate", "anger", "faint", "uneasiness", "brute", "grating", "superstitious", "brutalising", "greedy", "thirst", "invidiousness", "difficulty", "insufficiently", "inflict", "repression", "ignorance", "derisively", "transgress", "dominance", "second-tier", "worthlessness", "lackadaisical", "excuse", "unclear", "bewildered", "wretchedly", "slanderously", "unclean", "protracted", "blind", "onerous", "archaic", "damaging", "frazzle", "imperiously", "discriminate", "standstill", "facetiously", "deceiver", "scared", "erode", "deepening", "insignificant", "dissonance", "criticisms", "grouch", "meaningless", "asperse", "vengefulness", "menacingly", "insult", "agitator", "suspect", "irrelevance", "overdo", "interruption", "engulf", "rocky", "misleadingly", "precariously", "splitting", "pressing", "empty", "congested", "tricky", "need", "avaricious", "thrash", "disturbed", "worries", "worrier", "opportunistic", "scarce", "fidget", "payback", "worried", "unconfirmed", "absentee", "outrageous", "blistering", "pariah", "comedy", "fastidiously", "scoff", "writhe", "dizzing", "overcome", "jumpy", "graceless", "friction", "criticize", "confounded", "hapless", "dearth", "subtract", "wearisome", "oversight", "shipwreck", "incredulously", "inaccessible", "besiege", "indiscreetly", "bellicose", "pointless", "mordant", "ruffian", "upsetting", "tenuous", "madder", "incorrect", "inimically", "intrusion", "madden", "cautious", "pillory", "hubris", "mangle", "darkness", "calumniously", "crowded", "strut", "straggler", "daze", "blur", "alarmed", "contravene", "loathsome", "skeptical", "diffidence", "futile", "inimical", "woebegone", "pertinaciously", "goddam", "incompetently", "nervous", "autocrat", "furious", "indecorum", "petrify", "underestimate", "critic", "cowardly", "nix", "partiality", "lesser", "trivial", "drastically", "unsettling", "stiflingly", "ape", "lessen", "impair", "passe", "delusion", "mislead", "inadequate", "impermissible", "disbeliever", "captive", "unwise", "disturbingly", "obscene", "stupidity", "topple", "incivility", "haunting", "defrauding", "delinquency", "deformed", "illusions", "polution", "inability", "limp", "bicker", "unrelentingly", "sneeringly", "wiles", "glaringly", "brittle", "bickering", "wrath", "gibber", "unipolar", "insensible", "bother", "motionless", "disarm", "scoffingly", "fulminate", "irreverence", "epidemic", "unspeakable", "taxing", "misgivings", "intimidate", "brutalizing", "scheme", "outrage", "ignominiously", "glibly", "unnervingly", "try", "mudslinger", "unnatural", "bastard", "flawed", "infamous", "persecution", "stigmatize", "bravado", "rumours", "multi-polarization", "criticism", "inequality", "capriciously", "disrespectfulness", "abate", "imposers", "sugar-coat", "dummy", "hopelessly", "inconsequential", "hazardous", "haphazard", "fastuous", "zealot", "ineffective", "blindingly", "dazed", "loathly", "blow", "instable", "agitated", "parody", "brazenness", "burdensome", "abash", "inflammatory", "syndrome", "desiccated", "abase", "spitefulness", "pugnacity", "uncompetitive", "egotistically", "derisiveness", "dispensable", "dash", "conspiracy", "toxic", "satirize", "inhuman", "fatuously", "restrictive", "despot", "doubtful", "litigious", "abysmally", "deviousness", "disoriented", "disaccord", "contend", "subservient", "notoriously", "unpredictable", "cocky", "impersonal", "oversized", "deride", "argument", "lonely", "commonplace", "darn", "dark", "divisive", "too", "spitefully", "hindrance", "delusional", "scarcely", "wrangle", "frenzied", "quarrel", "intransigent", "needlessly", "torturously", "dissemble", "ail", "unsophisticated", "negate", "chill", "discomfit", "horde", "fumble", "tense", "complain", "hell", "unjustified", "lost", "loss", "calumnious", "assail", "disturbing", "inconsistent", "perturb", "dissuasive", "scornfully", "lose", "neurotically", "disconcertingly", "fabrication", "polluters", "stern", "heathen", "desolate", "nag", "blatantly", "coward", "sunder", "misdirection", "disapproving", "wretchedness", "lorn", "scoundrel", "hardheaded", "oppose", "bestial", "devilishly", "mournfully", "detraction", "patronize", "mischief", "ill-treated", "disgruntled", "dusty", "collude", "lies", "lier", "prosecute", "petrified", "unconstitutional", "condescend", "defunct", "cripple", "futility", "ferociously", "dangle", "tragedy", "draconian", "critical", "hinder", "irresolute", "smother", "draconic", "crushing", "inexorably", "lambaste", "pitiless", "avariciously", "insubordinate", "tiringly", "left-leaning", "unsavory", "ruin", "inefficiently", "irregular", "tramp", "geezer", "shambles", "inexorable", "monotonous", "damn", "heavyhearted", "torture", "divisiveness", "insidious", "enviously", "loot", "shortsighted", "dissention", "nervousness", "nettle", "scar", "darken", "cheater", "ostracize", "outbursts", "incense", "weary", "accusations", "hamstrung", "restriction", "disingenuous", "forget", "frictions", "smelling", "traumatically", "incitement", "aggrieve", "ingratitude", "bloodthirsty", "disadvantage", "credulous", "superficially", "forged", "offensive", "frightfully", "long", "blasted", "blurt", "division", "insubstantially", "lone", "unnerve", "debacle", "unobserved", "pinch", "unsuccessful", "lurking", "liar", "chore", "arguments", "superfluous", "over-acted", "coarse", "dinky", "begging", "disrespectablity", "inconveniently", "tease", "treacherously", "hardships", "dauntingly", "haughty", "vomit", "direness", "melancholy", "blunder", "mortifying", "disquiet", "impatient", "oblivious", "irretrievable", "stringent", "disservice", "inessential", "languorous", "radical", "smear", "cannibal", "suppression", "fist", "illiquid", "anguish", "threats", "disconsolately", "detestably", "diametrically", "malevolent", "infuriating", "farcically", "suspicious", "amputate", "complicated", "misbecoming", "chide", "preposterously", "hell-bent", "disorder", "strange", "animosity", "detestable", "hopeless", "vainly", "truant", "rude", "overdue", "battlefield", "immovable", "pretend", "sour", "block", "contagious", "stingingly", "altercation", "injurious", "danger", "erase", "heck", "perilous", "bleakness", "tired", "helpless", "skittishly", "inadequacy", "maddeningly", "utter", "blunt", "sleazy", "devilry", "explosive", "woefully", "spank", "confession", "cliched", "denunciations", "inelegance", "felon", "expediencies", "comical", "freakish", "rationalize", "inaptitude", "ailment", "pertinacious", "sidetracked", "blather", "stifling", "hardhearted", "recourses", "enormity", "insane", "fiction", "contrary", "downfallen", "fault", "prattle", "awkwardness", "fatuity", "sinister", "stunted", "mourner", "brash", "deplore", "shortchange", "erratically", "calumnies", "unfaithfully", "bewilderment", "blah", "immorality", "repulsively", "incoherence", "tentative", "blab",  "offenses", "damnation", "sore", "disquietude", "genocide", "unconvincing", "dehumanize", "barbarity", "appalling", "irregularity", "overbalanced", "badly", "ultimatum", "offensively", "implode", "omission", "boisterous", "grotesque", "befoul", "displaced", "veto", "bankrupt", "choke", "berate", "traduce", "sugarcoated", "coupists", "punishable", "unnecessary", "scandalized", "demeaning", "indignity", "lurk", "disaffect", "stupify", "steep", "lure", "incompatible", "accusation", "propagandize", "blindness", "viciously", "harrow", "immoral", "selfish", "scary", "rankle", "impedance", "scars", "fugitive", "maledict", "showdown", "unbearablely", "deploring", "delusions", "immodest", "calumniation", "expedient", "suspicions", "sick", "scare", "revolting", "recklessly", "sympathy", "demoralize", "precipitous", "mistrustful", "villainous", "illegal", "stuffy", "unsuccessfully", "capricious", "skepticism", "assassin", "frantic", "destructive", "indiscriminating", "chasten", "supremacy", "anxieties", "disruptive", "dizzy", "harangue", "asinine", "foolish", "indeterminate", "denigrate", "dissocial", "avarice", "miscreants", "detrimental", "terribleness", "mindless", "mawkishness", "hassle", "obsessively", "manipulative", "implication", "stigma", "intermittent", "exaggerate", "doubts", "weakness", "bent", "deceivers", "unproductive", "sully", "envy", "transgression", "foul", "spooky", "miss", "steal", "dubious", "agonizing", "unlawfulness", "overdone", "forsaken", "ploy", "prejudge", "overkill", "mendacious", "vexation", "plot", "scant", "undetermined", "scheming", "hustler", "impiety", "uneconomical", "little-known", "infraction", "hypocritical", "belittling", "vent", "miscalculation", "rash", "problematic", "filthy", "falsehood", "ironic", "oppositions", "ominously", "frenetic", "ineptly", "discredit", "outrageousness", "mire", "livid", "untrue", "overacted", "grieving", "gaffe", "disinterested", "impolitic", "ferocious", "lull", "suspicion", "shyly", "heartbreakingly", "beast", "idiocies", "obsessive", "spade", "belligerent", "infamy", "paucity", "ruinous", "sardonically", "misinformed", "lousy", "reject", "devilment", "blatant", "hesitant", "depressingly", "emptiness", "disabled", "controversy", "squabbling", "enemies", "leery", "poisonous", "kaput", "unavailable", "traumatize", "unprepared", "insinuation", "killer", "inapt", "hopelessness", "crackdown", "disgraceful", "encroach", "nastily", "tempest", "battle-lines", "inveigle", "ineffectually", "enormous", "heavily", "destruction", "boycott", "losing", "fatuous", "disruption", "rival", "disinclined", "insinuating", "starve", "deviously", "goddamn", "wasteful", "fateful", "crisis", "hostilities", "decry", "denunciate", "caustically", "manipulation", "mind", "jeopardy", "brutalities", "brat", "impertinent", "falsely", "arrogantly", "inconvenient", "waning", "rant", "barbarous", "anxiety", "imprecate", "disconsolate", "oversimplified", "bitter", "fool", "rank", "inane", "scathingly", "startlingly", "extremist", "egotistical", "unsuspecting", "unrealistic", "grievous", "heretic", "scandals", "frighten", "extremism", "cancer", "mediocrity", "gratuitous", "self-humiliation", "consternation", "declining", "tragic", "franticly", "sty", "dominate", "discouraging", "disgustedly", "yawn", "inundated", "distress", "idiotic", "fiat", "ultra-hardline", "misfortune", "irreconcilable", "inflame", "pernicious", "deprave", "rascal", "abrasive", "unjustly", "paralize", "enviousness", "unwilling", "grudges", "oddly", "unjust", "damning", "lanky", "needless", "fickle", "farcical-yet-provocative", "ungovernable", "ineffectualness", "savages", "lugubrious", "agonizingly", "obsession", "strike", "forlorn", "discomfort", "gripe", "repress",  "troublesome", "scornful", "tantrum", "savaged", "annihilation", "nefariously", "war-like", "illusion", "chastisement", "foolishness", "clog", "reprimand", "dispirit", "pugnacious", "shun", "perplexed", "decadent", "obstruct", "boggle", "blackmail", "bloody", "injudicious", "wrongful", "rough", "desperate", "unfulfilled", "mockingly", "mortify", "threatening", "rail", "grind", "reprovingly", "plea", "beastly", "interference", "debilitating", "defile", "scandalize", "blundering", "ill-natured", "unexpectedly", "perversity", "beguile", "mediocre", "tire", "scarred",  "shrug", "outrages", "sulk", "blast", "misconceptions", "malignant", "impotent", "fearfully", "unethical", "disastrously", "vagrant", "sob", "perverse", "limited", "sever", "grill", "outraged", "backbiting", "lazy", "fun", "haggle", "self-interest", "lackey", "unneeded", "caricature", "vileness", "rage", "plight", "groundless", "careless", "infuriated", "insignificance", "bullies", "chatterbox", "trample", "atrocity", "miff", "unexpected", "superiority", "sporadic", "resistant", "overwhelming", "partisans", "grievance", "barbarian", "remorselessly", "strife", "retard", "bemoaning", "fuss", "growl", "mar", "skimpy", "calamitous", "violator", "destitute", "unwarranted", "mad", "shyness", "manipulators", "decrease", "inconsiderately", "irreverently", "refutation", "fury", "shadowy", "fractious", "villianous", "threaten", "intolerable", "admonishingly", "sly", "shockingly", "selfinterested", "demise", "harridan", "extortion", "counterproductive", "repulsed", "sneer", "pest", "tiny", "fraught", "self-serving", "odder", "abomination", "inflationary", "disrespectful", "instigators", "mope", "sharply", "betrayer", "hysterically", "regress", "melodramatic", "reprehensibly", "reactionary", "fatty", "annihilate", "indecency", "moot", "paradoxical", "bungle", "insolvent", "strict", "squander", "moon", "impurity", "freak", "sermonize", "dismissively", "reprehensible", "shrill", "nervously", "enervate", "moribund", "deadly", "nuisance", "aggravation", "muddle", "rack", "passive", "callous", "averse", "hothouse", "smutty", "perversion", "unfaithful", "shunned", "misfit", "staggering", "murky", "deform", "revulsive", "skulk", "oddity", "restricted", "gross", "gnawing", "helplessness", "cannibalize", "nebulous", "bland", "lunatic", "calamities", "pathetic", "gloatingly", "dismay", "aggravating", "undecided", "sin", "slowly", "illusory", "ordeal", "shrivel", "drought", "immoderate", "dismal", "cackle", "aggressor", "defiant", "obscurity", "leech", "blame", "shy", "ambivalence", "dejected", "illiterate", "unnoticed", "foe", "hectic", "awkward", "unkind", "phobic", "naive", "phobia", "sneak", "inefficient", "immaterial", "withheld", "feeble", "betrayal", "objectionable", "grief", "fictional", "worriedly", "watchdog", "misconception", "shroud", "somber", "devil", "apprehensions", "nagging", "admonish", "profane", "fume", "violation", "inexplicable", "concerns", "corruption", "discrepant", "hard-hit", "insociable", "stubbornly", "widespread", "stereotypical", "misreading", "sounding", "disapprove", "undone", "domineering", "reticent", "worthlessly", "shortsightedness", "deluge", "cursory", "calumniate", "pitiful", "brusque", "sardonic", "blinding", "ill-used", "quandary", "disillusioned", "undesirable", "pillage", "tangled", "horrific", "slime", "sillily", "decay", "despotic", "taint", "disgustful", "snub", "anti-proliferation", "irrelevant", "cynical", "deceitfully", "unusually", "killjoy", "massacres", "impeach", "stinking", "abjure", "disheartening", "molest", "aggressiveness", "insanity", "relapse", "incongruously", "contemptuous", "dying", "audacity", "distraction", "garbage", "harbors", "shriek", "prickle", "glitch", "doubtfully", "fuzzy", "uncertain", "indecisively", "bombard", "entanglement", "ax", "uproarously", "droop", "revulsion", "disappointing", "suffocate", "havoc", "ineffectual", "disrupt", "fainthearted", "unreliable", "parasite", "delude", "mudslinging", "pretentious", "unpopular", "appalled", "acerbate", "dislike", "obstinate", "indisposed", "distracting", "tentatively", "swindle", "despondently", "congestion", "imminence", "discordance", "sorry", "hypocrite", "insincerely", "fib", "unaccustomed", "prohibitively", "bemoan", "hypocrisy", "confound", "excruciatingly", "disgrace", "ill-treatment", "complaints", "compel", "condescending", "lukewarm", "disillusion", "restlessness", "scolding", "abandon", "sufferers", "sap", "objections", "incessantly", "prison", "rigorous", "sag", "inconsistencies", "sad", "lame", "subversively", "pertinacity", "disbelief", "election-rigger", "disavowal", "butchery", "diabolical", "unspeakablely", "puzzlement", "onslaught", "direly", "embattled", "sloth", "intrude", "chatter", "heinous", "loath", "imprecisely", "disconcerting", "hysterical", "exorbitant", "bondage", "shrew", "dictator", "abyss", "challenging", "weirdly", "primitive", "presumptuous", "paltry", "dishonest", "dissembler", "tyrant", "scandalous", "impaired", "distrustful", "shred", "enraged", "mock", "poison", "contempt", "grumble", "chaos", "violently", "untruthful", "black", "whips", "deviation", "deign", "confessions", "bereave", "knife", "mischievously", "hostile", "afraid", "flabbergasted", "indiscreet", "decrepitude", "renounce", "abuses", "figurehead", "grapple", "indoctrination", "sufferer", "indiscernible", "decrement", "revile", "persecute", "conceited", "catastrophe", "torrent", "redundancy", "infringement", "tortured", "villains", "toll", "sham", "irrationally", "contortions", "worryingly", "disagreeably", "poisonously", "stolen", "incompliant", "moan", "irresponsibly", "turmoil", "boastful", "dastard", "slaughter", "flaunt", "sass", "insignificantly", "stifle", "low", "sadden", "barbaric", "disagreeable", "imprisonment", "divide", "irresponsible", "disreputable", "hardball", "whine", "hard-line", "miser", "infidel", "deceptively", "shortcoming", "backbite", "embarrass", "fleer", "exclude", "tumultuous", "gainsayer", "dumbfounded", "deplorably", "heedless", "doomsday", "dehumanization", "smugly", "awfulness", "inordinate", "straggle", "intimidation", "lame-duck", "isolated", "deplorable", "morbidly", "inconstant", "degrade", "fat", "rumor", "thoughtlessness", "excessive", "ugliness", "faze", "heretical", "complaining", "toil", "sucker", "sloppy", "brutal", "intimidating", "polemize", "anxiously", "harmful", "conspicuously", "debauch", "bedlamite", "rejection", "gainsay", "fathomless", "plagiarize", "incautious", "oversimplify", "stooges", "admonition", "bungler", "acridness", "impenitent", "illicit", "stormy", "spotty", "stun", "sympathetic", "butcher", "rogue", "impolitely", "catastrophic", "dispirited", "sheer", "coercive", "invective", "negligence", "insolence", "faithless", "sickly", "inconsiderate", "leakage", "disingenuously", "licentiousness", "unacceptable", "restless", "mistakenly", "painful", "slaves", "fatal", "entangle", "constrain", "tamper", "repudiation", "derisive", "jerk", "goof", "insensitively", "disdain", "heartbreaking", "servitude", "underlings", "conspiracies", "precipitate", "lack", "inhospitable", "wrongly", "suppress", "slanderer", "ultimatums", "bewitch", "ill-usage", "wheedle", "blindside", "dogged", "meddlesome", "gibe", "capriciousness", "fawningly", "hardly", "repetitive", "inconsolably", "gloss", "burden", "downcast", "inconclusive", "famished", "flimflam", "infringements", "lecher", "imprudent", "pauper", "misrepresentation", "limitation", "lie", "drunk", "rue", "debatable", "inconsolable", "dubitable", "hegemonism", "life-threatening", "fragmented", "chaff", "chafe", "ache", "ineligible", "catastrophes", "displace", "revengefully", "adversity", "fading", "plotters", "silly", "untested", "inefficacious", "blabber", "whimper", "distraught", "unworkable", "loopholes", "frazzled", "decayed", "self-criticism", "apocalypse", "quitter", "sympathetically", "misery", "divorce", "unskilled", "endanger", "constraint", "overlook", "troublingly", "virus", "mislike", "lethargic", "hurtful", "fanatical", "fleeting", "ambush", "defiance", "brazen", "fabricate", "rusty", "intimidatingly", "airs", "shirker", "outrageously", "gamble", "weep", "brashness", "forgetfulness", "pessimism", "apologist", "upsettingly", "imprison", "cramped", "weed", "inadverent", "taboo", "arduous", "unwillingly", "alarming", "uneven", "imbroglio", "frightful", "unnerved", "miscreant", "grisly", "impolite", "licentiously", "struck", "mystify", "absence", "confounding", "degenerately", "displeasing", "gloom", "revolt", "depravedly", "coercion", "horrify", "betrayals", "audaciously", "expunge", "conspicuous", "gruesome", "pollute", "acridly", "horrors", "posturing", "rampant", "differ", "inexperience", "urgency", "sicken", "powerless", "disadvantageous", "strangle", "derision", "tarnish", "weaknesses", "crazily", "demoralizing", "deceive", "villianously", "noisy", "imperious", "revoke", "arbitrary", "rancor", "poorly", "vehement", "empathy", "smoulder", "rot", "flounder", "loneliness", "grandiose", "gruff", "idle", "vindictive", "runaway", "dragon", "abjectly", "insidiously", "terror", "knock", "dubiously", "tattered", "combative", "weak", "heartbreak", "unfortunately", "unfamiliar", "harden", "pitilessly", "aggrieved", "vicious", "unsteady", "murder", "unhealthy", "disgracefully", "austere", "vengefully", "reservations", "nightmarishly", "nonexistent", "lax", "unfit", "incommensurate", "insurmountably", "fractiously", "ranting", "jabber", "lunaticism", "diminish", "stalemate", "admonisher", "muscle-flexing", "oblique", "acrimonious", "pathetically", "lag", "misrepresent", "insurmountable", "inexact", "violent", "grouchy", "maniacal", "raging", "regrettably", "aloof", "unprofitable", "slump", "uproariously", "regrettable", "warlike", "avalanche", "fall", "taunt", "err", "dishearten", "salacious", "troublesomely", "rumbling", "bullyingly", "pittance", "shameful", "resistance", "insincere", "gracelessly", "blister", "martyrdom-seeking", "irritably", "glaring", "unmoved", "scarcity", "cartoonish", "fake", "sadly", "ill-conceived", "desperately", "prate", "irritable", "intolerance", "rhetoric", "puzzling", "bedlam", "dishonor", "infamously", "liars", "deceit", "misapprehend", "embarrassing", "jeer", "disorient", "fusty", "exaggeration", "torturous", "disloyal", "apathy", "fatefully", "deploringly", "stranger", "reprehensive", "faulty", "debaucher", "obstruction", "guilty", "rampage", "ghastly", "enjoin", "unsupported", "temerity", "dungeon", "rid", "untimely", "fail", "unsteadiness", "sorrowfully", "contemptuously", "fussy", "wallow", "pestilent", "insecure", "aghast", "farcical", "bleakly", "stew", "poverty", "goad", "unnerving", "jealousy", "annoyed", "misinterpret", "consume", "bafflement", "cynicism", "earsplitting", "obsolete", "venom", "menial", "strenuous", "egocentric", "unraveled", "rantingly", "baffling", "utterly", "meanness", "incredulous", "wrought", "stupified", "puppets", "anarchistic", "aberration", "panicky", "hypocrites", "wrest", "dwindle", "mawkishly", "accidental", "subdued", "lethargy", "exclaim", "indignant", "inferior", "horror", "split", "inhibition", "neurotic", "awful", "arrogance", "dangerousness", "beset", "madly", "grave", "unlamentably", "anarchist", "smut", "obstacle", "idiot", "confuse", "anarchism", "plunderer", "mawkish", "illegitimate", "errant", "gauche", "forswear", "tragically", "smuttier", "smug", "rebuke", "discordant", "inefficiency", "unlamentable", "friggin", "stricken", "nationalism", "dirty", "fidgety", "quibble", "embroil", "malign", "argumentative", "banalize", "quarrels", "unhappily", "discombobulate", "narrow", "startle", "dissenter", "stab", "anti-Semites", "impede", "uncivilized", "wrestle", "pandemonium", "grate", "spoon-feed", "incite", "discouragingly", "demoralizingly", "beseech", "flagrant", "wretch", "acerbic", "disaffirm", "isolation", "unruly", "drones", "sinking", "quarrellous", "depressed", "indelicate", "fanatically", "reprehension", "embarrassment", "haunt", "spoon-fed", "deterrent", "disproportionate", "disease", "disinclination", "erroneous", "sacrifice", "impoverish", "unscrupulously", "overpower", "challenge", "nastiness", "perverted", "inexperienced", "banishment", "erratic", "bashful", "inferiority", "superficial", "tiring", "gruesomely", "lambast", "backwardness", "unleash", "misjudge", "rat", "distaste", "ironies", "iniquity", "dullard", "maliciously", "imposing", "dissolution", "agitation", "invalid", "exasperate", "hateful", "incorrectly", "flat-out", "effigy", "ego", "sensationalize", "shadow", "severe", "rebuff", "anti-Israeli", "fierce", "malice", "horrid", "invalidity", "repulsive", "accountable", "motley", "excessively", "deny", "thumb", "hollow", "cartoon", "catastrophically", "oversimplification", "inaccuracies", "protests", "amiss", "iniquitous", "cutthroat", "rigor", "redundant", "horrifyingly", "sorrow", "whatever", "inadequately", "flabbergast", "unworthy", "blunders", "obtuse", "eternal", "extremists", "anti-US", "wanton", "brashly", "unfriendly", "painfully", "starvation", "overbearingly", "mortification", "disappointment", "abhorrently", "degradingly", "clique", "undignified", "improbably", "instability", "defame", "strain", "loathing", "injustice", "unfeeling", "trying", "presume", "impoverished", "rumple", "numb", "cuplrit", "pointlessly", "antiquated", "improbable", "importunate", "demolisher", "decline", "facetious", "disconsolation", "stink", "abolish", "inconsequent", "sting", "sadness", "displeasure", "disobedience", "resent", "petty", "threat", "disrespect", "uninformed", "muddy", "abandoned", "venomously", "strident", "unyielding", "cataclysm", "enslave", "error", "jaded", "insupportably", "contort", "zealously", "empathize", "denial", "mindlessly", "feebleminded", "knave", "siege", "naively", "invidiously", "unfortunate", "disaster", "insupportable", "troubling", "perilously", "fanatic", "acrimoniously", "gawky", "distortion", "agonize",  "braggart", "loveless", "dastardly", "lawbreaking", "ineffectively", "obscenely", "disdainful", "recalcitrant", "joker", "concern", "startling", "mockery", "savage", "malcontented", "dilapidated", "trivialize", "opponent", "drama", "timidity", "marginally", "entrap", "convoluted", "forsake", "abusive", "outmoded", "preoccupy", "unthinkably", "unlikely", "irritate", "devastation", "inertia", "spiteful", "abrupt", "burdensomely", "embarrassingly", "biases", "baseless", "deject", "unsound", "kooky", "belittle", "unthinkable", "jeering", "culpable", "dreadful", "unavoidably", "hallucinate", "terror-genic", "gawk", "ill-mannered", "biased", "anomaly", "rigid", "destitution", "brutalize", "gratuitously", "death", "drab", "wound", "devastating", "unavoidable", "floundering", "angriness", "fibber", "apprehensive", "provoke", "swagger", "pettifog", "audaciousness", "repulsing", "blockhead", "victimize", "infuriatingly", "hatred", "despondent", "extort", "doddering", "passiveness", "defy", "blemish", "severely", "jeeringly", "infected", "devilish", "overplay", "malevolence", "unhappiness", "evils", "vengeance", "so-cal", "ominous", "humiliate", "repel", "incomprehensible", "false", "untenable", "wreck", "belie", "difficult", "condescendingly", "drain", "hungry", "condemnable", "improbability", "enfeeble", "lawlessness", "dishearteningly", "infiltrator", "unpleasantries", "insensitive", "graft", "worrying", "spinster", "cheerless", "impetuous", "smolder", "stench", "hole", "outbreak", "smuttiest", "insular", "sorely", "shortage", "renunciation", "deceitfulness", "grieve", "full-blown", "maladjustment", "diminishing", "inattentive", "gasp", "languorously", "storm", "unspecified", "stiff", "alienate", "accusing", "scathing", "debility", "temptation", "resentment", "distort", "villainously", "delinquent", "timidly", "discontented", "discourteous", "failing", "obscure", "irritant", "negligent", "anti-American", "superficiality", "argue", "lackeys", "infest", "untrustworthy", "diatribes", "defective", "irreparable", "abhorred", "unwillingness", "brutality", "galling", "terrorize", "self-coup", "sneaky", "quash", "ridicule", "remorseless", "ignore", "unforeseen", "huckster", "afflictive", "unseemly", "sullen", "reproach", "humiliation", "non-confidence", "monstrosities", "deaf", "dead", "languish", "impudence", "unsatisfactory", "apathetic", "lechery", "asinininity", "fallout", "gape", "recoil", "abominably", "exclusion", "conceit", "maxi-devaluation", "apprehension", "costly", "chaotic", "infiltrators", "extravagantly", "deficiency", "abominable", "humiliating", "obliterate", "jittery", "mistrustfully", "inescapably", "penalize", "dissolute", "puzzled", "flagging", "craven", "offend", "demolish", "contrariness", "irreverent", "hobble", "inescapable", "hurt", "quarrelsome", "volatility", "indulge", "imposition", "bitingly", "self-defeating", "object", "incorrigibly", "stupor", "complaint", "fight", "unorthodoxy", "dud", "condescension", "adulterate", "commiserate", "despairingly", "pique", "monstrous", "predicament", "incorrigible", "malcontent", "game", "stole", "disapproval", "artificial", "boring", "murderous", "mortified", "glare", "misunderstanding", "unkindly", "caustic", "grudge", "gall", "overshadow", "debauchery", "insecurity", "vociferous", "despised", "debasement", "aversion", "implicate", "lamentably", "apocalyptic", "screw", "diatribe", "woeful", "curses", "antipathy", "confused", "indefinite", "worsen", "lamentable", "outlaw", "disintegration", "cursed", "brimstone", "grimace", "vile", "misjudgment", "clamorous", "exorbitantly", "stodgy", "inept", "overstate", "depraved", "conspirator", "terribly", "repugn", "interfere", "terrorism", "polluter", "longing", "gibberish", "embroilment", "deceiving", "contemptible", "concede", "cruelties", "regretfully", "incompatibility", "unfairly", "terrible", "uneventful", "twist", "obsessiveness", "affliction", "loser", "outsider", "worthless", "torment", "discontent", "subside", "bitterness", "unsettled", "hoax", "suffer", "indefinitely", "spookiest", "discourage", "inanely", "ambivalent", "sorrowful", "officious", "emphatic", "subvert", "strained", "aggressive", "bizarre", "unsure", "fraternize", "retract", "simmer", "undependable", "repulse", "haughtily", "scandalously", "offence", "chastise", "alarm", "craziness", "pompous", "grossly", "disastrous", "frown", "prejudicial", "drunken", "indecently", "hunger", "crime", "reluctance", "cataclysmically", "wicked", "irreplacible", "contaminate", "stupid", "nebulously", "instigate", "handicapped", "irksome", "taunting", "disintegrate", "overawe", "gaga", "needy", "limit", "subjugation", "slack", "radically", "grievously", "unequal", "sabotage", "disavow", "anti-social", "perish", "bore", "disappointed", "contention", "unimaginably", "disturb", "headaches", "screech", "gaff", "lewdness", "mercilessly", "uneasy", "indignation", "punish", "illegally", "arduously", "unlucky", "struggle", "pervasive", "bereft", "unimaginable", "anti-occupation", "imperfect", "defiler", "downside", "irreversible", "diseased", "unease", "dragoon", "annoying", "impatiently", "bewilderingly", "curse", "lying", "hostage", "unbelievably", "slur", "excruciating", "agonies", "onerously", "ambiguity", "atrocities", "crumple", "slug", "offensiveness", "imperil", "merely", "dragons", "unbelievable", "depress", "twisted", "tedious", "orphan", "treason", "simplistically", "furor", "prideful", "foolishly", "reckless", "unstable", "batty", "scarily", "rifts", "rumors", "boredom", "stunt", "radicals", "ungrateful", "sidetrack", "break", "disparaging", "provocative", "smoldering", "tenuously", "falsify", "tyrannical", "nemesis", "insulted", "stressfully", "unlawfully", "opposition", "deter", "malicious", "implausibly", "dissidents", "bowdlerize", "militancy", "feint", "impious", "unexplained", "fanatics", "stubborn", "misguidance", "paralyzed", "aggression", "stump", "bias", "treasonous", "unwanted", "vice", "ineloquent", "implausible", "woe", "cross", "lurid", "din", "dim", "inhospitality", "fallacious", "skeletons", "irony", "acrid", "dig", "bomb", "seethe", "risky", "quack", "escapade", "astray", "unbearable", "inconvenience", "concerned", "solemn", "belabor", "invidious", "seriously", "liable", "inaccurately", "eviscerate", "pity", "overwhelmingly", "beleaguer", "sneering", "egregiously", "vanity", "inconsistency", "fever", "ulterior", "intolerablely", "bloodshed", "absent-minded", "unravel", "overturn", "incomparably", "predatory", "insubstantial", "infidels", "unreasonably", "inconsistence", "slanders", "aimless", "slanderous", "lonesome", "scream", "incomparable", "swear", "skeptically", "one-side", "zealous", "illogic", "unreasonable", "fiendish", "misbehave", "abnormal", "slow", "disgust", "shoddy", "expensive", "irredeemably", "stealing", "vanish", "adversary", "incendiary", "uprising", "self-interested", "disgustingly", "exploitation", "abysmal", "deluded", "weaken", "failure", "subjection", "irredeemable", "appall", "complication", "lewd", "importune", "floored", "boil", "wickedly", "effrontery", "uncompromisingly", "crook", "injury", "inactive", "misunderstandings", "serious", "deadweight", "anxious", "malodorous", "insincerity", "impulsive", "tyrannically", "stubbornness", "dishonorablely", "ridiculous", "pains", "uproarous", "expulse", "irritated", "injure", "entrapment", "defamations", "hazy", "smouldering", "emphatically", "lament", "inculcate", "unattractive", "although", "disallow", "run-down", "provocation", "scarier", "eliminate", "banal", "dishonesty", "frivolous", "yelp", "recessionary", "disunity", "peevish", "delirious", "flirt", "busy", "lurch", "void", "ruthlessness", "reprove", "anomalous", "shameless", "debaser", "imbalance", "absurd", "unfavorable", "squirm", "mulish", "desolately", "feign", "reluctant", "allegation", "uncontrolled", "fatigue", "inhumane", "fatalistically", "malaise", "drowning", "inequities", "fraudulent", "oppressive", "madman", "burn", "perplexity", "divided", "devious", "less", "banish", "rattle", "drastic", "chilly", "beggar", "chagrin", "distastefully", "subordinate", "cravenly", "disagreement", "pine", "demon", "meddle", "ruthlessly", "undue", "impunity", "underdog", "agony", "hotheaded", "ambiguous", "farce", "smash", "domineer", "nightmarish", "hater", "worrisome", "imminently", "messy", "fustigate", "shirk", "timidness", "ludicrous", "discrimination", "unsteadily", "indecisive", "slightly", "little", "fanciful", "despite", "oppressively", "secretive", "bombastic", "raving", "wee", "foreboding", "paranoid", "paranoia", "obtrusive", "heckle", "addict", "disorderly", "despise", "stampede", "downheartedly", "implacable", "disquietingly", "inaction", "sinfully", "lividly", "myth", "downer", "tawdry", "senile", "bunk", "hypocritically", "hardliners", "appallingly", "subjected", "dejectedly", "peeved", "flashy", "discourteously", "hate", "tormented", "hostility", "insurrection", "undo", "longingly", "menace", "hoard", "defensive", "condemn", "impossiblity", "disarray", "farfetched", "irately", "imprecision", "hallucination", "fruitlessly", "embroiled", "diabolic", "crush", "frozen", "downbeat", "remorselessness", "furiously", "vehemently", "pout", "extermination", "frustrated", "unresolved", "acerbically", "oppressiveness", "nettlesome", "mundane", "abominate", "smokescreen", "naughty", "harm", "war", "sympathize", "ill-sorted", "despondency", "hard", "quarrellously", "bemused", "thumbs", "oppression", "belligerently", "perplexing", "monotony", "unlicensed", "bonkers", "waste", "bleed", "alienated", "despondence", "egregious", "anarchy", "invasive", "covetous", "mordantly", "humbling", "baffled", "overact", "bloated", "inexpiable", "maliciousness", "mendacity", "abdicate", "upset", "procrastination", "flout", "exacting", "destabilisation", "pry", "guilt", "rhetorical", "stinging", "barbarously", "objection", "esoteric", "insensitivity", "fallacies", "dispiriting", "undefined", "confront", "gaggle", "guile", "indoctrinate", "decreasing", "stridently", "rubbish", "stupidly", "second-class", "repugnant", "regret", "mistified", "low-rated", "enormities", "devastatingly", "vilify", "indecision", "abrade", "massacre", "dissonantly", "senselessly", "irrepressible", "warning", "cajole", "brutish", "indolent", "deplete", "intractable", "dogmatic", "volatile", "misbegotten", "dissidence", "menacing", "peculiarly", "wedge", "intransigence", "unsustainable", "slap", "absurdly", "inequitably", "dangerous", "jobless", "besmirch", "cautionary", "affront", "deceitful", "scapegoat", "agitate", "throttle", "cloud", "unsettle", "suffering", "inequitable", "angrily", "bleak", "fatally", "dumbfound", "discriminatory", "insolently", "unfounded", "strangest", "disordered", "uproot", "tension", "dissuade", "reproachful", "recant", "exhort", "hegemony", "autocratic", "misguide", "halfheartedly", "harried", "rhapsodize", "poor", "cut", "disparagingly", "fiasco", "distrust", "foolhardy", "restrict", "overemphasize", "seriousness", "exposed", "withhold", "subservience", "dungeons", "exasperation", "tortuous", "evildoer", "imminent", "thoughtlessly", "underpaid", "close", "dissatisfy", "malady", "equivocal", "indecent", "monster", "fallaciously", "filth", "against", "wily", "wilt", "jar", "nasty", "jam", "stark", "unimportant", "devoid", "undid", "glower", "incompetent", "wild", "morbid", "exasperating", "disparage", "stereotypically", "slothful", "grudgingly", "misunderstood", "disclaim", "misleading", "relentlessly", "ludicrously", "weakening", "obliterated", "egomania", "avoidance", "revoltingly", "complicit", "pedestrian", "abandonment", "leer", "gabble", "plaything", "discompose", "famine", "jaundiced", "cry", "disloyalty", "warfare", "insufficient", "one-sided", "merciless", "invalidate", "indefensible", "pedantic", "dismalness", "browbeat", "ugly", "thoughtless", "dissatisfaction", "infernal", "punitive", "distasteful", "obese", "frigid", "adamant", "hideously", "expropriate", "estranged", "bumpy", "oppressors", "brutally", "charisma", "peevishly", "insouciance", "miserably", "protest", "fright", "harassment", "desultory", "misbecome", "overbalance", "juvenile", "squabble", "indifference", "nonsense", "miserable", "disregardful", "unwelcome", "lech", "cheapen", "ineloquently", "overreach", "cliche", "invader", "vestiges", "disable", "illness", "disfavor", "hysterics", "impatience", "insinuate", "criminal", "deficient", "worsening", "sarcasm", "broken-hearted", "cow", "hasty", "plunder", "strangely", "smack", "disputed", "urgently", "reluctantly", "manipulate", "bogus", "bid-rigging", "complicate", "dispiritedly", "extinguish", "crooked", "authoritarian", "break-point", "haste", "disorganized", "intoxicate", "shamelessly", "leak", "discomfititure", "foully", "outcast", "flaw", "degeneration", "traitorous", "ingrate", "sinful", "riled", "nauseating", "overstatement", "misguided", "horrifically", "flak", "rivalry", "subversive", "frustration", "cruel", "qualms", "worn", "ill-fated", "disdainfully", "insufferably", "stale", "stagnation", "fracture", "remorse", "commotion", "fruitless", "uncollectible", "evasive", "inarticulate", "phony", "insufferable", "confusion", "overzealous", "dizzingly", "ineffectiveness", "denounce", "chronic", "hard-liner", "degradation", "illogical", "frustrating", "halfhearted", "crude", "stake", "innuendo", "misstatement", "mishandle", "exacerbate", "backward", "imbecile", "maverick", "skittish", "pugnaciously", "contradiction", "hedge", "scoldingly", "wince", "drunkard", "adrift", "warped", "expel", "cataclysmic", "confusing", "enmity", "deterioration", "fearful", "disregard", "flimsy", "shamefully", "marginal", "declaim", "inundate", "pitifully", "complex", "antagonize", "stain", "contradict", "usurp", "submissive", "emaciated", "sarcastic", "adverse", "staid", "audacious", "atrophy", "unreliability", "scummy", "deteriorating", "futilely", "cheat", "stereotype", "force", "frustrate", "cheap", "ragged", "virulently", "crazy", "meager", "fanaticism", "unsafe", "viper", "hamper", "miscalculate", "wastefulness", "steeply", "languor", "cranky", "bitterly", "regressive", "irritation", "maneuver", "hatefulness", "indiscriminate", "craze", "scorchingly", "monstrously", "bearish", "abhorrence", "cold", "dissatisfactory", "soreness", "stumble", "molestation", "deprived", "disturbed-let", "trivially", "inexpertly", "forlornly", "hysteric", "hysteria", "puny", "condemnation", "propaganda", "pretense", "tainted", "contentious", "subjugate", "puzzle", "irritating", "unpleasant", "emotional", "uproar", "sedentary",  "decadence", "despoil", "pan", "fascist", "selfishness", "belittled", "racist", "irate", "retaliate", "fascism", "desperation", "racism", "atrocious", "paupers", "frantically", "collusion", "subversion", "allege", "thwart", "inefficacy", "annoyingly", "maniac", "desert", "belligerence", "macabre", "inconceivably", "satirical", "irrational", "conflict", "evasion", "perturbed", "negligible", "fraud", "sympathies", "prejudice", "licentious", "fell", "idiots", "hedonistic", "brazenly", "fret", "inconceivable", "sluggish", "hardened", "irk", "injustices", "ire", "confrontation", "distraughtness", "intolerant", "derogatory", "heartbreaker", "overthrow", "deprecate", "liability", "recklessness", "ridiculously", "crumble", "immature", "supposed", "anemic", "twists", "inexpert", "bewildering", "downgrade", "dreadfulness", "alarmingly", "forebodingly", "antagonist", "picky", "impasse", "afflict", "glut", "freakishly", "cuss", "antagonism", "suicidal", "obviously", "expropriation", "glum", "disappointingly", "grievances", "unfair", "shrilly", "cataclysmal", "taunts", "harass", "shock", "pratfall", "indiscriminately", "rebellious", "curt", "botch", "vie", "disconcerted", "traumatized", "infuriate", "contradictory", "eschew", "improper", "dismayingly", "retaliatory", "coerce", "bane", "simplistic", "loathe", "murderously", "assassinate", "sickening", "mess", "sticky", "languid", "shortcomings", "feverish", "carnage", "forbidden", "stress", "crass", "wounds", "regression", "unauthentic", "sickeningly", "desiccate", "unlawful", "frighteningly", "impediment", "daunt", "execrate"};
	//public static String[] neutwords= {"contemplate", "fortress", "quiet", "outspoken", "orthodoxy", "replete", "immune", "indication", "expressions", "open-ended", "covert",  "transparent", "cognizant", "views", "outlook", "continuous", "actuality", "further", "nuance", "allusions", "disposition", "readiness", "considerably", "fixer", "air", "regardless", "affected", "nature", "intent", "considerable", "particular", "immensurable", "familiar", "innumerably", "quick", "believe", "emphasise", "mentality", "intend", "nap", "enough", "regardlessly", "position", "intentions", "theoretize", "full", "decide", "innumerable", "absolute", "however", "deep", "full-scale", "motive", "aha", "olympic", "touches", "viewpoints", "evaluate", "hmm", "intensively", "assessment", "emotion", "felt", "central", "reflecting", "immensity", "hypnotize", "primarily", "alert", "immense", "clandestine", "giants", "remark", "proclaim", "amplify", "exactly", "expression", "nascent", "simply", "opinions", "dramatic", "renewable", "pressure", "eyebrows", "furthermore", "maybe", "idea", "posture", "influence", "alliances", "allusion", "statements", "so", "infer", "prophesy", "anyhow", "needful", "unaudited", "high-powered", "effectively", "stances", "imply", "legalistic", "predictable", "hefty", "likewise", "consideration", "perceptions", "limitless", "screamingly", "strength", "concerted", "reputed", "insights", "notion", "thus", "predominant", "judgement", "allegorize", "direct", "reveal", "scholarly", "consciousness", "deduce", "actually", "tint", "signals", "prime", "consequently", "embodiment", "rather", "immediate", "likelihood",  "splayed-finger", "dominant", "deeply", "reactions", "sleepy", "irregardless", "should", "would", "show", "opinion", "metaphorize", "soliloquize", "transparency", "reaction", "feeling", "stands", "move", "relations", "astronomical", "proportionate", "judgements", "corrective", "oh", "surprising", "overtures", "ignite", "think", "primary", "conjecture", "increasingly", "diplomacy", "utterances", "memories", "large-scale", "though", "possibility", "certified", "vocal", "alliance", "inference", "forthright", "tall", "stance", "prove", "claim", "tale", "floor", "exact", "reiterates", "quite", "dependent", "revelatory", "anyways", "all-time", "still", "reiterated", "attitude", "imperatively", "comment", "glean", "major", "mm", "batons", "giant", "galvanize", "feel", "very", "rarely", "legacies", "most", "growing", "evaluation", "duty", "specific", "predictablely", "adolescents", "largely", "actual", "look", "heavy-duty", "nonviolent", "obligation", "astronomic", "downright", "intents", "halt", "outright", "absorbed", "react", "immensely", "entire", "facts", "astronomically", "whiff", "nuances", "player", "assess","responsible", "inklings", "extensively", "seem", "particularly", "gestures", "therefore", "distinctly", "mantra", "ought", "fact", "basically", "thought", "besides", "intensive", "systematic", "cogitate", "intense", "possibly", "know", "specifically", "proportionately", "commentator", "stir", "mum", "looking", "such", "engross",  "prognosticate", "chant", "mostly", "assessments", "revealing", "extensive", "possible", "pressures", "absolutely", "realization", "power", "sovereignty", "indirect", "pacify", "firmly", "scrutiny", "tantamount", "much", "stupefy", "implicit", "judgment", "accentuate", "surprisingly", "completely", "thusly", "cognizance", "yeah", "self-examination", "imagination", "likely", "foretell", "huge", "hm", "frankly", "presumably", "reiterate", "legacy", "apparently", "plenary", "confide", "lastly", "knowingly", "high", "ponder", "philosophize", "key", "inarguably", "practically", "invisible", "appearance", "attitudes", "really", "minor", "knowing", "funded", "finally", "blood", "elaborate", "fully", "inarguable", "nevertheless", "feelings", "could", "needs", "beliefs", "transport", "discern", "constitutions", "indicative", "expound", "inkling", "screaming", "extemporize", "exclusively", "expectation", "point", "might", "gigantic", "moreover", "persistence", "suppose", "imagine", "overt", "entirely", "difference", "belief", "conscience", "altogether", "fundamentally", "comprehend", "emotions", "massive", "factual", "concerning", "increasing", "frequent", "immediately", "stuffed", "informational", "big", "large", "speculate", "swing", "reflective", "rapid", "inherent", "certainly", "far-reaching", "rare", "speculation", "certain", "recognizable", "dramatically", "obvious", "perspective", "fundamental", "apparent", "thinking", "needfully", "fast", "prevalent", "innumerous", "pray", "engage", "perhaps", "awareness", "scrutinize", "assumption", "touch", "firm", "judgments", "indeed",  "infectious", "greatly", "baby", "halfway", "consider", "broad-based", "must", "activist", "entrenchment", "aware", "imperative", "feels", "knew", "seemingly", "forsee", "else", "intention", "view", "ceaseless", "apprehend", "stronger-than-expected", "appear", "analytical", "pivotal", "tendency", "anyway", "matter", "affect", "supposing"};



	public static ArrayList<String> stopWords=new ArrayList<String>();
	public static ArrayList<String> posWords=new ArrayList<String>();
	public static ArrayList<String> negWords=new ArrayList<String>();
	public static ArrayList<String> neutWords=new ArrayList<String>();

	public static double wordCnt=0, wordFromPos=0,wordFromNeg=0,docCount=0;
	public static double cntstar1wordList=0,cntstar2wordList=0,cntstar3wordList=0,cntstar4wordList=0;

	public CountGenerator(String INPUTPATH){


		try {

			// Read a list of Opinion/Sentiment words from the files.
			FileInputStream featstream1 = new FileInputStream(INPUTPATH+"stopwords.txt");

			DataInputStream featin1 = new DataInputStream(featstream1);
			BufferedReader featbr1 = new BufferedReader(new InputStreamReader(featin1));


			FileInputStream featstream2 = new FileInputStream(INPUTPATH+"poswords.txt");
			DataInputStream featin2 = new DataInputStream(featstream2);
			BufferedReader featbr2 = new BufferedReader(new InputStreamReader(featin2));


			FileInputStream featstream3 = new FileInputStream(INPUTPATH+"negwords.txt");
			DataInputStream featin3 = new DataInputStream(featstream3);
			BufferedReader featbr3 = new BufferedReader(new InputStreamReader(featin3));


			FileInputStream featstream4 = new FileInputStream(INPUTPATH+"neutwords.txt");
			DataInputStream featin4 = new DataInputStream(featstream4);
			BufferedReader featbr4 = new BufferedReader(new InputStreamReader(featin4));



			stopWords=readFeaturesFromFile(	 featbr1,  stopWords )  ;

			posWords=readFeaturesFromFile(	 featbr2,  posWords )  ;

			negWords=readFeaturesFromFile( featbr3,  negWords )  ;

			neutWords=readFeaturesFromFile(	 featbr4,  neutWords )  ;


			featin1.close();
			featin2.close();
			featin3.close();
			featin4.close();

		} catch (Exception e) {
			e.printStackTrace();
		}


	}


	/*
	 * Function to read Opinion words form files and initialize the data structures.
	 * 
	 */
	private static ArrayList <String> readFeaturesFromFile(	BufferedReader br, ArrayList <String> readLines )  {

		String strLine="";

		try {

			while ((strLine = br.readLine()) != null)   {
				if(!readLines.contains(strLine.toLowerCase().trim())){
					readLines.add(strLine.toLowerCase().trim());
				}

			}



		} catch (Exception e) {

			e.printStackTrace();
		}



		//System.out.println(readLines.size());
		return readLines;

	}


	/*
	 * Function to calculate all the counts. It calls all the functions and initailizes all the data structutures with their proper counts.
	 * 
	 */
	public static void getCount(String match, int cntt, int star,String reviewer, String id, boolean trainFlag) {


		POSFileReader poss= new POSFileReader();


		String[] bow = match.split(" ");

		Document d = new Document();
		//d.countWords=bow.length;
		System.out.println("Extracting features for Document -- "+id+".");
		d.id = id;
		d.star = star;
		d.reviewer = reviewer;



		if(!trainFlag){
			String[] lines = match.split("\\.");
			for(String line:lines){
				String parsedline= parsReader.parseTheLine(line);
				if(!parsedline.equalsIgnoreCase("")){
					poss.parseLineforNN(parsedline, d);
					poss.parseLineforNNpair(parsedline, d);
					poss.parseLineforNN(parsedline, d);
					poss.parseLineforJJ(parsedline, d);
					poss.parseLineforRB(parsedline, d);
					poss.parseLineforVB(parsedline, d);
					poss.parseLineforDT(parsedline, d);
					poss.parseLineforNNpair(parsedline, d);
				}
			}
		}


		int cntWordId = 0;
		String lastword = "";
		String lastTolastword = "";
		String fourthlastword = "";
		//	String fifthlastword = "";
		for(String bowWord:bow){
			bowWord=bowWord.replaceAll("'", "");
			bowWord=bowWord.replaceAll("", "");
			bowWord=bowWord.replaceAll("%", "");
			//",",box,","empty"
			bowWord= bowWord.toLowerCase().trim();
			//System.out.println(fourthlastword+ " "+lastTolastword+ " "+lastword+ " "+bowWord);
			//bowWord=callStemmer(bowWord);

			if(bowWord.equals("not")||bowWord.equals("no")||bowWord.equals("none")||bowWord.equals("nothing")||bowWord.equals("isn't")||bowWord.equals("wasn't"))
			{
				d.notWords++;
				addToDocFreqTracker("notWords",cntt);
			}

			if(bowWord.equals(",")||bowWord.equals(".")||bowWord.equals(";")||bowWord.equals(":")||bowWord.equals("*")||bowWord.equals("\"")||bowWord.equals("?")||bowWord.equals("!")||bowWord.equals("-")||bowWord.equals("--")){
				d.commaWords++;
				addToDocFreqTracker("commaWords",cntt);
			}


			if(bowWord.equals("very")||bowWord.equals("most")||bowWord.equals("more")||bowWord.equals("less")||bowWord.equals("best")||bowWord.equals("highest")||bowWord.equals("strongest")||bowWord.equals("extremely")){
				d.extremeWords++;
				addToDocFreqTracker("extremeWords",cntt);
			}

			/*if(bowWord.equals("."))
			{
				lastword = ".";
				lastTolastword = "";
				fourthlastword = "";
			//	fifthlastword = "";
			}
			 */
			if(bowWord.equals("")||bowWord.equals("\"")||bowWord.equals(",")||bowWord.equals(".")||bowWord.equals(";")||bowWord.equals(":")||bowWord.length()<=1||stopWords.contains(bowWord))
			{
				continue;
			}

			d.countWords++;
			cntWordId++;

			if(lastword.equals("not")||lastword.equals("no")||lastword.equals("none")||lastword.equals("nothing")||lastword.equals("isn't")||lastword.equals("wasn't")||lastTolastword.equals("not")||lastTolastword.equals("no")||lastTolastword.equals("none")||lastTolastword.equals("nothing")||lastTolastword.equals("isn't")||lastTolastword.equals("wasn't")||fourthlastword.equals("not")||fourthlastword.equals("no")||fourthlastword.equals("none")||fourthlastword.equals("nothing")||fourthlastword.equals("isn't")||fourthlastword.equals("wasn't"))//||fifthlastword.equals("not")||fifthlastword.equals("no")||fifthlastword.equals("none")||fifthlastword.equals("nothing")||fifthlastword.equals("isn't")||fifthlastword.equals("wasn't"))
			{
				if(posWords.contains(bowWord.trim().toLowerCase())){


					d.negWords++;
					//addTermNeg(bowWord,d);

				}
				else if(negWords.contains(bowWord.trim().toLowerCase())){
					d.posWords++;
					//addTermPos(bowWord,d);
				}

				else if(neutWords.contains(bowWord.trim().toLowerCase())){
					d.neutWords++;
					addTermNeut(bowWord,d);
				}

			}
			else{
				if(posWords.contains(bowWord.trim().toLowerCase())){
					d.posWords++;
					addTermPos(bowWord,d);
				}
				else if(negWords.contains(bowWord.trim().toLowerCase())){
					d.negWords++;
					addTermNeg(bowWord,d);
				}
				else if(neutWords.contains(bowWord.trim().toLowerCase())){
					d.neutWords++;
					addTermNeut(bowWord,d);
				}
			}

			if(cntWordId>=2){
				addToBigram(bowWord,lastword,d);
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


			if(star==1){
				cntstar1wordList++;
				addToWordList(bowWord,star1wordList);
				addToDocFreqTrackerStar(bowWord,star);

			}
			else if(star==2){
				cntstar2wordList++;
				addToWordList(bowWord,star2wordList);
				addToDocFreqTrackerStar(bowWord,star);


			}
			else if(star==3){
				cntstar3wordList++;
				addToWordList(bowWord,star3wordList);
				addToDocFreqTrackerStar(bowWord,star);


			}
			else if(star==4){
				cntstar4wordList++;
				addToWordList(bowWord,star4wordList);
				addToDocFreqTrackerStar(bowWord,star);


			}


			//if(cntWordId>3){
			//	fifthlastword=fourthlastword;
			//}

			if(cntWordId>2){
				fourthlastword=lastTolastword;
			}

			if(cntWordId>1){
				lastTolastword=lastword;
			}
			lastword=bowWord;


		}

		docList.add(d);
	}




	/*
	 * Function to insert the word count for the purpose of document ferquency to proper data structure for each star rating.

	 */
	private static void addToDocFreqTrackerStar(String bowWord, int cntt) {

		if(stardocFrequency.containsKey(bowWord)){

			ArrayList<Integer> list = stardocFrequency.get(bowWord);
			if(list.contains(cntt)){

			}
			else{
				list.add(cntt);
			}

			stardocFrequency.remove(bowWord);
			stardocFrequency.put(bowWord, list);


		}
		else{
			ArrayList<Integer> list = new 	ArrayList<Integer> ();
			list.add(cntt);
			stardocFrequency.put(bowWord, list);

		}
	}




	/*
	 * Function to insert the bigram word count to proper data structure.
	 */
	private static void addToBigram(String bowWord2, String lastword, Document d) {

		String bowWord= lastword+"-"+bowWord2;
		d.bicountWords++;
		if(d.bigramtermFrequency.containsKey(bowWord)){

			Integer count = d.bigramtermFrequency.get(bowWord);
			count++;
			d.bigramtermFrequency.remove(bowWord);
			d.bigramtermFrequency.put(bowWord, count);


		}
		else{
			d.bigramtermFrequency.put(bowWord, 1);
		}


		if(bigramwordList.containsKey(bowWord)){

			Integer count = bigramwordList.get(bowWord);
			count++;
			bigramwordList.remove(bowWord);
			bigramwordList.put(bowWord, count);


		}
		else{
			bigramwordList.put(bowWord, 1);
		}

	}



	/*
	 * Function to insert the negative word count to proper data structure.
	 */
	private static void addTermNeg(String bowWord, Document d) {
		if(d.negtermFrequency.containsKey(bowWord)){

			Integer count = d.negtermFrequency.get(bowWord);
			count++;
			d.negtermFrequency.remove(bowWord);
			d.negtermFrequency.put(bowWord, count);


		}
		else{
			d.negtermFrequency.put(bowWord, 1);
		}

		if(cntnegwordList.containsKey(bowWord)){

			Integer count = cntnegwordList.get(bowWord);
			count++;
			cntnegwordList.remove(bowWord);
			cntnegwordList.put(bowWord, count);


		}
		else{
			cntnegwordList.put(bowWord, 1);
		}


	}




	/*
	 * Function to insert the neutral word count to proper data structure.
	 */
	private static void addTermNeut(String bowWord, Document d) {
		// TODO Auto-generated method stub
		if(d.neuttermFrequency.containsKey(bowWord)){

			Integer count = d.neuttermFrequency.get(bowWord);
			count++;
			d.neuttermFrequency.remove(bowWord);
			d.neuttermFrequency.put(bowWord, count);


		}
		else{
			d.neuttermFrequency.put(bowWord, 1);
		}

		if(cntneutwordList.containsKey(bowWord)){

			Integer count = cntneutwordList.get(bowWord);
			count++;
			cntneutwordList.remove(bowWord);
			cntneutwordList.put(bowWord, count);


		}
		else{
			cntneutwordList.put(bowWord, 1);
		}
	}




	/*
	 * Function to insert the postive word count to proper data structure.
	 */

	private static void addTermPos(String bowWord, Document d) {
		if(d.postermFrequency.containsKey(bowWord)){

			Integer count = d.postermFrequency.get(bowWord);
			count++;
			d.postermFrequency.remove(bowWord);
			d.postermFrequency.put(bowWord, count);


		}
		else{
			d.postermFrequency.put(bowWord, 1);
		}


		if(cntposwordList.containsKey(bowWord)){

			Integer count = cntposwordList.get(bowWord);
			count++;
			cntposwordList.remove(bowWord);
			cntposwordList.put(bowWord, count);


		}
		else{
			cntposwordList.put(bowWord, 1);
		}



	}




	/*
	 * Function to insert the word count for the purpose of document ferquency to proper data structure.
	 */

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



	/*
	 * Function to insert the word count per document to proper data structure.
	 */

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



	/*
	 * Function to insert the word count to proper data structure.
	 */
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
