#!/bin/bash   
# 1 args
#  train.txt  

#train

java -cp bin/.:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m code/FileReader Train "$1" data/ 6



./run_weka.sh starRatingSameUsersTrain.arff starRatingSameUsers.model outt_starRatingSameUsers.txt
./run_weka.sh starRatingDiffUsersTrain.arff starRatingDiffUsers.model outt_starRatingDiffUsers.txt
./run_weka.sh binaryRatingSameUsersTrain.arff binaryRatingSameUsers.model outt_binaryRatingSameUsers.txt
./run_weka.sh binaryRatingDiffUsersTrain.arff binaryRatingDiffUsers.model outt_binaryRatingDiffUsers.txt
./run_weka.sh authorTrain.arff author.model outt_author.txt


