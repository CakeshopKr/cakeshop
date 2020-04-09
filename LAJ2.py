#LAJ2 VOCABULARY PRACTICE APP
#Author: Liu Tianyi
#Email: dannylty98@gmail.com

from random import randint

print("Welcome to this vocab app,")
print("You are to answer in romaji.")
print("The app will keep retesting words you don't get right.")
print("Type 'skip' to get answer and skip.") 
print("The word will still appear next time.")
print("Answer verbs in masu form")
print("For na/i adjectives, include na/i")
print("Some pure katakana verbs require '-'")
print("Chu, shu, ju do not have 'yu' in it unlike e.g. ryu")
print("Scope is L10-L20.")

d = {}

#L11
d['take/cost (time or money)'] = 'kakarimasu'
d['one (counter)'] = 'hitotsu'
d['two (counter)'] = 'futatsu'
d['three (counter)'] = 'mittsu'
d['four (counter)'] = 'yottsu'
d['five (counter)'] = 'itsutsu'
d['six (counter)'] = 'muttsu'
d['seven (counter)'] = 'nanatsu'
d['eight (counter)'] = 'yattsu'
d['nine (counter)'] = 'kokonotsu'
d['ten (counter)'] = 'too'
d['how many (counter)'] = 'ikutsu'
d['apple'] = 'ringo'
d['orange'] = 'mikan'
d['sandwich'] = 'sandoicchi'
d['ice cream'] = 'aisukuri-mu'
d['postage stamp'] = 'kitte'
d['postcard'] = 'hagaki'
d['envelope'] = 'fuutou'
d['parents'] = 'ryoushin'
d['brothers and sisters'] = 'kyoudai'
d['(my) elder brother'] = 'ani'
d['(my) elder sister'] = 'ane'
d["(someone else's) elder brother"] = 'oniisan'
d["(someone else's) elder sister"] = 'oneesan'
d["(my) younger brother"] = 'otouto'
d["(my) younger sister"] = 'imouto'
d["(someone else's) younger brother"] = 'otoutosan'
d["(someone else's) younger sister"] = 'imoutosan'
d['foreign country'] = 'gaikoku'
d['foreign student'] = 'ryuugakusei'
d['four years (time)'] = 'yonen'
d['four months (time)'] = 'yonkagetsu'
d['four weeks (time)'] = 'yonshuukan'
d['in total..'] = 'zenbude'
d['everyone (no san)'] = 'minna'
d['..only'] = 'dake'
d['certainly, (sir/madam)'] = 'kashikomarimashita'
d['seamail'] = 'funabin'
d['airmail (non katakana)'] = 'koukuubin'
d['australia'] = 'o-sutoraria'

#L12
d['easy/simple'] = 'kantanna'
d['near'] = 'chikai'
d['far'] = 'tooi'
d['fast/early'] = 'hayai'
d['slow/late'] = 'osoi'
d['many/much (e.g. many people)'] = 'ooi'
d['few/little (e.g. few people)'] = 'sukunai'
d['warm'] = 'atatakai'
d['cool'] = 'suzushii'
d['sweet'] = 'amai'
d['spicy'] = 'karai'
d['heavy'] = 'omoi'
d['light'] = 'karui'
d['season'] = 'kisetsu'
d['spring'] = 'haru'
d['summer'] = 'natsu'
d['autumn'] = 'aki'
d['winter'] = 'fuyu'
d['weather'] = 'tenki'
d['rain/rainy'] = 'ame'
d['snow/snowy'] = 'yuki'
d['cloudy'] = 'kumori'
d['hotel'] = 'hoteru'
d['airport'] = 'kuukou'
d['sea/ocean'] = 'umi'
d['world'] = 'sekai'
d['party'] = 'pa-ti-'
d['festival (with o)'] = 'omatsuri'
d['beef and veggie hot pot yummy'] = 'sukiyaki'
d['pork'] = 'butaniku'
d['chicken meat'] = 'toriniku'
d['beef'] = 'gyuuniku'
d['lemon'] = 'remon'
d['flower arrangement'] = 'ikebana'
d['maple/red leaves of autumn'] = 'momiji'
d['which one(of two things)'] = 'dochira'
d['both'] = 'dochiramo'
d['the most'] = 'ichiban'
d['by far'] = 'zutto'
d['for the first time'] = 'hajimete'
d["i'm home"] = 'tadaima'
d["welcome home (full thing)"] = "okaerinasai"
d["Gion Festival"] = "gionmatsuri"
d["Hong Kong"] = "honkon"
d["Singapore"] = "shingapo-ru"

#L13
d["enjoy/play"] = "asobimasu"
d["swim"] = "oyogimasu"
d["go to meet/welcome"] = "mukaemasu"
d["to get tired"] = "tsukaremasu"
d["marry/get married"] = "kekkonshimasu"
d["do shopping"] = "kaimonoshimasu"
d["have a meal/dine"] = "shokujishimasu"
d["take a walk (in a park)"] = "sanposhimasu"
d["hard/tough/severe/awful"] = "taihenna"
d["want/desire (for something)"] = "hoshii"
d["wide/spacious"] = "hiroi"
d["narrow/small"] = "semai"
d["swimming pool"] = "pu-ru"
d["river"] = "kawa"
d["fine arts"] = "bijutsu"
d["fishing"] = "tsuri"
d["skiing"] = "suki-"
d["weekend"] = "shuumatsu"
d["about(e.g. about 8pm)"] = "goro"
d["separately"] = "betsubetsuni"

#L14
d["turn on"] = "tsukemasu"
d["turn off"] = "keshimasu"
d["open"] = "akemasu"
d["close/shut"] = "shimemasu"
d["to hurry"] = "isogimasu"
d["to wait"] = "machimasu"
d["to hold"] = "mochimasu"
d["to take/pass"] = "torimasu"
d["help(with a task)"] = "tetsudaimasu"
d["to call (e.g. taxi)"] = "yobimasu"
d["speak/talk"] = "hanashimasu"
d["use"] = "tsukaimasu"
d["stop/park"] = "tomemasu"
d["to show"] = "misemasu"
d["tell (an address)"] = "oshiemasu"
d["stand up"] = "tachimasu"
d["sit down"] = "suwarimasu"
d["enter a cafe"] = "kissatennihairimasu"
d["exit a cafe"] = "kissatenwodemasu"
d["rain (ame ga ~)"] = "furimasu"
d["to copy"] = "kopi-shimasu"
d["electricity/light"] = "denki"
d["air conditioner"] = "eakon"
d["passport"] = "pasupo-to"
d["name"] = "namae"
d["address"] = "juusho"
d["map"] = "chizu"
d["salt"] = "shio"
d["sugar"] = "satou"
d["question/problem"] = "mondai"
d["answer"] = "kotae"
d["straight"] = "massugu"
d["slowly/leisurely"] = "yukkuri"
d["immediately"] = "sugu"
d["again"] = "mata"
d["later"] = "atode"
d["a little more"] = "mousukoshi"

#L15
d["to put"] = "okimasu"
d["make/produce"] = "tsukurimasu"
d["sell"] = "urimasu"
d["to know"] = "shirimasu"
d["to live (at)"] = "sumimasu"
d["to do research"] = "kenkyuushimasu"
d["materials/data"] = "shiryou"
d["catalogue"] = "katarogu"
d["timetable"] = "jikokuhyou"
d["clothes"] = "fuku"
d["products"] = "seihin"
d["software"] = "sofuto"
d["electronic dictionary"] = "denshijisho"
d["economy"] = "keizai"
d["municipal office/city hall"] = "shiyakusho"
d["senior high school"] = "koukou"
d["dentist"] = "haisha"
d["single/unmarried"] = "dokushin"
d["remember/recollect"] = "omoidashimasu"

#L16
d["ride/get on"] = "norimasu"
d["get off (a train)"] = "orimasu"
d["change (train)"] = "norikaemasu"
d["take (a shower)"] = "abimasu"
d["put in/insert"] = "iremasu"
d["take out/hand in/send"] = "dashimasu"
d["withdraw (money)"] = "oroshimasu"
d["enter"] = "hairimasu"
d["graduate from (university)"] = "demasu"
d["push/press"] = "oshimasu"
d["drink"] = "nomimasu"
d["to start/begin"] = "hajimemasu"
d["tour/visit a place to study it"] = "kengakushimasu"
d["to phone"] = "denwashimasu"
d["young"] = "wakai"
d["long"] = "nagai"
d["short"] = "mijikai"
d["bright/light"] = "akarui"
d["dark"] = "kurai"
d["body/health"] = "karada"
d["head/brain"] = "atama"
d["hair"] = "kami"
d["face"] = "kao"
d["eye"] = "me"
d["ear"] = "mimi"
d["nose"] = "hana"
d["mouth"] = "kuchi"
d["tooth"] = "ha"
d["stomach"] = "onaka"
d["leg/foot"] = "ashi"
d["height"] = "se"
d["service"] = "sa-bisu"
d["jogging"] = "jogingu"
d["shower"] = "shawa-"
d["green/greenery"] = "midori"
d["temple"] = "otera"
d["shinto shrine"] = "jinja"
d["in what way/how"] = "douyatte"
d["which (three or more things)"] = "dono"
d["which one (of three or more things)"] = "dore"
d["first of all"] = "mazu"
d["amount of money/balance"] = "kingaku"
d["to confirm"] = "kakuninshimasu"
d["button"] = "botan"
d["'are you making a withdrawal?'"] = "ohikidashidesuka"

#L17
d["memorise"] = "oboemasu"
d["forget"] = "wasuremasu"
d["to lose"] = "nakushimasu"
d["to pay"] = "haraimasu"
d["give back/return"] = "kaeshimasu"
d["go out"] = "dekakemasu"
d["take off (clothes)"] = "nugimasu"
d["to worry"] = "shinpaishimasu"
d["work overtime"] = "zangyoushimasu"
d["go on a business trip"] = "shucchoushimasu"
d["important/precious"] = "taisetsuna"
d["all right (it's alright)"] = "daijoubuna"
d["dangerous"] = "abunai"
d["no smoking"] = "kinen"
d["health insurance card"] = "kenkouhokenshou"
d["temperature/fever"] = "netsu"
d["illness/disease"] = "byouki"
d["medicine"] = "kusuri"
d["bath (with o)"] = "ofuro"
d["jacket/outerwear"] = "uwagi"
d["underwear"] = "shitagi"
d["throat"] = "nodo"
d["'take care of yourself' (said to ill people)"] = "odaijini"
d["cold/flu"] = "kaze"

#L18
d["be able to/can"] = "dekimasu"
d["wash"] = "araimasu"
d["play (e.g. piano)"] = "hikimasu"
d["to sing"] = "utaimasu"
d["collect/gather"] = "atsumemasu"
d["throw away"] = "sutemasu"
d["exchange/change"] = "kaemasu"
d["to drive"] = "untenshimasu"
d["reserve/book"] = "yoyakushimasu"
d["piano"] = "piano"
d["meter"] = "me-toru"
d["cash"] = "genkin"
d["hobby"] = "shumi"
d["diary"] = "nikki"
d["prayer"] = "oinori"
d["section head"] = "kachou"
d["department head"] = "buchou"
d["company president"] = "shachou"
d["animal"] = "doubutsu"
d["horse"] = "uma"
d["the Internet"] = "inta-netto"
d["especially"] = "tokuni"
d["not easily(used with negatives)"] = "nakanaka"
d["by all means/really"] = "zehi"

#L19
d["climb/go up"] = "noborimasu"
d["stay (at a hotel)"] = "tomarimasu"
d["clean (a room)"] = "soujishimasu"
d["wash (clothes)"] = "sentakushimasu"
d["to become"] = "narimasu"
d["sleepy"] = "nemui"
d["strong"] = "tsuyoi"
d["weak"] = "yowai"
d["practice (noun)"] = "renshuu"
d["golf"] = "gorufu"
d["sumo wrestling"] = "sumou"
d["condition"] = "choushi"
d["once (do something once)"] = "ichido"
d["gradually"] = "dandan"
d["soon"] = "mousugu"
d["thank you (used when expressing gratitute for help received)"] = "okagesamade"
d["but"] = "demo"
d["cheers!! (drinks)"] = "kanpai"
d["diet"] = "daietto"
d["excessive/impossible"] = "murina"
d["good for one's health"] = "karadaniii"

#L20
d["need/require"] = "irimasu"
d["check/investigate"] = "shirabemasu"
d["repair"] = "shuurishimasu"
d["word/language"] = "kotoba"
d["visa"] = "biza"
d["the beginning (noun)"] = "hajime"
d["the end of ~/the end"] = "owari"
d["if you'd like"] = "yokattara"
d["various"] = "iroiro"


def borderfy(text):
    if len(text) % 2:
        print("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~")
        print("|" + "-"*int((31-len(text))/2-1) + text + "-"*int((31-len(text))/2-1) + "|")
        print("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~")
    else:
        print("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-")
        print("|" + "-"*int((30-len(text))/2-1) + text + "-"*int((30-len(text))/2-1) + "|")
        print("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-")


inplay = []
wronganswers = []
for i in d.items():
    inplay.append(i)

while len(inplay) > 0:
    left = len(inplay)
    print("{} words left.".format(left) + '\n')
    nextword = inplay[randint(0, left-1)]
    borderfy(nextword[0])
    print("Answer: ")
    correct = True;
    inp = input()
    while inp != nextword[1]:
        correct = False
        if inp == "skip":
            print("Answer is: " + nextword[1])
            break
        else:
            print("Wrong")
            print("\nAnswer: ")
            inp = input()
    if correct: 
        print("Correct")
        inplay.remove(nextword)
    elif nextword not in wronganswers: 
        wronganswers.append(nextword)

print("Your wrong answers:")
for i in wronganswers:
    print(i[0] + " - " + i[1])
print("\npress any key to quit")
input() 