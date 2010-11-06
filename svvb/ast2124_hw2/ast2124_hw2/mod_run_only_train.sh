#!/bin/bash   
# 1 args
#  train.txt  

#train

java -cp bin/.:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m code/FileReader Train "$1" data/ 6


#java -cp bin/.:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m code/FileReader "$1" "$2" "$3" 2


#java -cp bin/.:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m code/FileReader "$1" "$2" "$3" 3



#java -cp bin/.:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m code/FileReader "$1" "$2" "$3" 4


#java -cp bin/.:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m code/FileReader "$1" "$2" "$3" 5
# 5 times
#java -cp /home/cs4705/bin/weka-3-6-3/weka.jar -Xmx2560m weka.classifiers.functions.SMO  -C 1.0 -L 0.0010 -P 1.0E-12 -N 0 -V -1 -W 1 -K "weka.classifiers.functions.supportVector.PolyKernel -C 250007 -E 1.0"   -t "$1" -d "$2" >> "$3"

./run_weka.sh starRatingSameUsersTrain.arff starRatingSameUsers.model outt_starRatingSameUsers.txt
./run_weka.sh starRatingDiffUsersTrain.arff starRatingDiffUsers.model outt_starRatingDiffUsers.txt
./run_weka.sh binaryRatingSameUsersTrain.arff binaryRatingSameUsers.model outt_binaryRatingSameUsers.txt
./run_weka.sh binaryRatingDiffUsersTrain.arff binaryRatingDiffUsers.model outt_binaryRatingDiffUsers.txt
./run_weka.sh authorTrain.arff author.model outt_author.txt


#test
#java -cp bin/.:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m code/FileReader "$1" "$2" "$3"

# 5 times
#java -cp /home/cs4705/bin/weka-3-6-3/weka.jar -Xmx2048m weka.filters.supervised.attribute.AddClassification -remove-old-class -classification -serialized $model -i $test -o $op.arff -c last



#5 times final output


#java -cp bin/.:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m code/FinalOutput "$1" "$2" "$3"

 
#java -cp /home/cs4705/bin/weka-3-6-3/weka.jar -Xmx2048m weka.filters.supervised.attribute.AddClassification -remove-old-class -classification -serialized $model -i $test -o $op.arff -c last


#5 times final output

#java -cp bin/.:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m code/FinalOutput "$1" "$2" "$3"


# 5 times - 4 args
