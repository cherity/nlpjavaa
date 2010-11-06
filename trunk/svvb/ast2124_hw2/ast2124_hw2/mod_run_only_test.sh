#!/bin/bash   
# 2 args
#  test.txt op 

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


./run_weka_on_test.sh starRatingSameUsers.model starRatingSameUsersTest.arff out_starRatingSameUsersTest.arff multi "$1" "$2"
./run_weka_on_test.sh starRatingDiffUsers.model starRatingDiffUsersTest.arff out_starRatingDiffUsersTest.arff multi "$1" "$2"
./run_weka_on_test.sh binaryRatingSameUsers.model binaryRatingSameUsersTest.arff out_binaryRatingSameUsersTest.arff binary "$1" "$2"
./run_weka_on_test.sh binaryRatingDiffUsers.model binaryRatingDiffUsersTest.arff out_binaryRatingDiffUsersTest.arff binary "$1" "$2"
./run_weka_on_test.sh author.model authorTest.arff out_authorTest.arff reviewer "$1" "$2"

