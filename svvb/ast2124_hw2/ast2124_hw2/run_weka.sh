#!/bin/bash


java -cp /home/cs4705/bin/weka-3-6-3/weka.jar -Xmx2560m weka.classifiers.functions.SMO  -C 1.0 -L 0.0010 -P 1.0E-12 -N 0 -V -1 -W 1 -K "weka.classifiers.functions.supportVector.PolyKernel -C 250007 -E 1.0"   -t "$1" -d "$2" >> "$3" 


