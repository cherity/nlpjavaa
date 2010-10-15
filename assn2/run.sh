#!/bin/bash
java -cp bin/:/home/cs4705/stanford-parser-2010-08-20/stanford-parser-2010-08-20.jar -Xmx2048m FileReader "$1" "$2"
