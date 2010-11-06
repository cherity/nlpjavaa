#!/bin/bash   
# 2 args
#train.txt test.txt 

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






# 5 times
#java -cp /home/cs4705/bin/weka-3-6-3/weka.jar -Xmx2048m  weka.classifiers.functions.SMO -p 95  -l "$1"  -T "$2" >> "$3" 
#java -cp /home/cs4705/bin/weka-3-6-3/weka.jar -Xmx2048m weka.filters.supervised.attribute.AddClassification -remove-old-class -classification -serialized $model -i $test -o $op.arff -c last


#5 times final output

#java -cp bin/.:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m code/FinalOutput "$1" "$2" "$3"


# 5 times - 4 args


./run_weka_on_test.sh starRatingSameUsers.model starRatingSameUsers"$2"-Test.arff out_starRatingSameUsers"$2"-Test.arff multi "$2" classified-starRatingSameUsersTest-"$2"
./run_weka_on_test.sh starRatingDiffUsers.model starRatingDiffUsers"$2"-Test.arff out_starRatingDiffUsers"$2"-Test.arff multi "$2" classified-starRatingDiffUsersTest-"$2"
./run_weka_on_test.sh binaryRatingSameUsers.model binaryRatingSameUsers"$2"-Test.arff out_binaryRatingSameUsers"$2"-Test.arff binary "$2" classified-binaryRatingSameUsersTest-"$2"
./run_weka_on_test.sh binaryRatingDiffUsers.model binaryRatingDiffUsers"$2"-Test.arff out_binaryRatingDiffUsers"$2"-Test.arff binary "$2" classified-binaryRatingDiffUsersTest-"$2"
./run_weka_on_test.sh author.model author"$2"-Test.arff out_author"$2"-Test.arff reviewer "$2" classified-authorTest-"$2"

