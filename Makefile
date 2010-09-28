# Makefile for QA System by Ashish Tomar



CLASSFILES=bin/Questions.class \
	bin/POSFileReader.class \
	bin/Answer.class \
	bin/FileParser.class 
	

build: $(CLASSFILES)
	ant compile

bin/%.class: src/%.java
	ant compile

clean:
	ant clean; rm -f outputA*.txt extra*.txt




