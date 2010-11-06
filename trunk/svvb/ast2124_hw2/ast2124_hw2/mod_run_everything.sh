#!/bin/bash   
# 2 args
#train.txt test.txt  

#train

java -cp bin/.:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m code/FileReader Train "$1" data/ 6


./run_weka.sh starRatingSameUsersTrain.arff starRatingSameUsers.model outt_starRatingSameUsers.txt
./run_weka.sh starRatingDiffUsersTrain.arff starRatingDiffUsers.model outt_starRatingDiffUsers.txt
./run_weka.sh binaryRatingSameUsersTrain.arff binaryRatingSameUsers.model outt_binaryRatingSameUsers.txt
./run_weka.sh binaryRatingDiffUsersTrain.arff binaryRatingDiffUsers.model outt_binaryRatingDiffUsers.txt
./run_weka.sh authorTrain.arff author.model outt_author.txt


#test




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

java -cp bin/.:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m code/FileReader "$casee" "$2" data/ 6








./run_weka_on_test.sh starRatingSameUsers.model starRatingSameUsersTest.arff out_starRatingSameUsersTest.arff multi "$2" classified-starRatingSameUsersTest.txt
./run_weka_on_test.sh starRatingDiffUsers.model starRatingDiffUsersTest.arff out_starRatingDiffUsersTest.arff multi "$2" classified-starRatingDiffUsersTest.txt
./run_weka_on_test.sh binaryRatingSameUsers.model binaryRatingSameUsersTest.arff out_binaryRatingSameUsersTest.arff binary "$2" classified-binaryRatingSameUsersTest.txt
./run_weka_on_test.sh binaryRatingDiffUsers.model binaryRatingDiffUsersTest.arff out_binaryRatingDiffUsersTest.arff binary "$2" classified-binaryRatingDiffUsersTest.txt
./run_weka_on_test.sh author.model authorTest.arff out_authorTest.arff reviewer "$2" classified-authorTest.txt



