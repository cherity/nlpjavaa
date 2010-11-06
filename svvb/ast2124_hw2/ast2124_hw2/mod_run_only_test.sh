#!/bin/bash   
# 1args
#  test.txt 

#train



#java -cp bin/.:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m code/FileReader "$1" "$2" "$3" 3



#java -cp bin/.:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m code/FileReader "$1" "$2" "$3" 4


#java -cp bin/.:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m code/FileReader "$1" "$2" "$3" 5
# 5 times
#java -cp /home/cs4705/bin/weka-3-6-3/weka.jar -Xmx2560m weka.classifiers.functions.SMO  -C 1.0 -L 0.0010 -P 1.0E-12 -N 0 -V -1 -W 1 -K "weka.classifiers.functions.supportVector.PolyKernel -C 250007 -E 1.0"   -t "$1" -d "$2" >> "$3"



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

java -cp bin/.:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m code/FileReader "$casee" "$1" data/ 6



# 5 times
#java -cp /home/cs4705/bin/weka-3-6-3/weka.jar -Xmx2048m  weka.classifiers.functions.SMO -p 95  -l "$1"  -T "$2" >> "$3" 
#java -cp /home/cs4705/bin/weka-3-6-3/weka.jar -Xmx2048m weka.filters.supervised.attribute.AddClassification -remove-old-class -classification -serialized $model -i $test -o $op.arff -c last


#5 times final output

#java -cp bin/.:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m code/FinalOutput "$1" "$2" "$3"


# 5 times - 4 args


./run_weka_on_test.sh starRatingSameUsers.model starRatingSameUsers"$1"-Test.arff out_starRatingSameUsers"$1"-Test.arff multi "$1" classified-starRatingSameUsersTest-"$1"
./run_weka_on_test.sh starRatingDiffUsers.model starRatingDiffUsers"$1"-Test.arff out_starRatingDiffUsers"$1"-Test.arff multi "$1" classified-starRatingDiffUsersTest-"$1"
./run_weka_on_test.sh binaryRatingSameUsers.model binaryRatingSameUsers"$1"-Test.arff out_binaryRatingSameUsers"$1"-Test.arff binary "$1" classified-binaryRatingSameUsersTest-"$1"
./run_weka_on_test.sh binaryRatingDiffUsers.model binaryRatingDiffUsers"$1"-Test.arff out_binaryRatingDiffUsers"$1"-Test.arff binary "$1" classified-binaryRatingDiffUsersTest-"$1"
./run_weka_on_test.sh author.model author"$1"-Test.arff out_author"$1"-Test.arff reviewer "$1" classified-authorTest-"$1"

