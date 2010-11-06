#!/bin/bash   
# 1 args
#  test.txt  




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

java -cp bin/.:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m code/FileReader "$casee" "$1" data/ 6






./run_weka_on_test.sh starRatingSameUsers.model starRatingSameUsersTest.arff out_starRatingSameUsersTest.arff multi "$1" classified-starRatingSameUsersTest.txt
./run_weka_on_test.sh starRatingDiffUsers.model starRatingDiffUsersTest.arff out_starRatingDiffUsersTest.arff multi "$1" classified-starRatingDiffUsersTest.txt
./run_weka_on_test.sh binaryRatingSameUsers.model binaryRatingSameUsersTest.arff out_binaryRatingSameUsersTest.arff binary "$1" classified-binaryRatingSameUsersTest.txt
./run_weka_on_test.sh binaryRatingDiffUsers.model binaryRatingDiffUsersTest.arff out_binaryRatingDiffUsersTest.arff binary "$1" classified-binaryRatingDiffUsersTest.txt
./run_weka_on_test.sh author.model authorTest.arff out_authorTest.arff reviewer "$1" classified-authorTest.txt

