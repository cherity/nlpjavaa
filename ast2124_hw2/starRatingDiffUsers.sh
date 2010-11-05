#!/bin/bash   
# 2 args
# model  test.txt 




VAR="classified"
text=".txt"
casee="Test"
starsame="starRatingSameUsers"
stardiff="starRatingDiffUsers"


binsame="binaryRatingSameUsers"
bindiff="binaryRatingDiffUsers"

auth="author"


concat1="${VAR}_$starsame$text"
concat2="${VAR}_$stardiff$text"
concat3="${VAR}_$binsame$text"
concat4="${VAR}_$bindiff$text"
concat5="${VAR}_$auth$text"


#echo "$concat"

#test
java -cp bin/.:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m code/FileReader "$casee" "$2" data/ 4



./run_weka_on_test.sh "$1" starRatingDiffUsers"$2"-Test.arff out_starRatingDiffUsers"$2"-Test.arff multi "$2" classified-starRatingDiffUsersTest-"$2"

