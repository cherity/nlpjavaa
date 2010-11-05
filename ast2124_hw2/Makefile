# Makefile for Classifier System by Ashish Tomar



CLASSFILES=bin/code/Document.class \
	bin/code/CountGenerator.class \
        bin/code/POSFileReader.class \
        bin/code/ParseFileReader.class \
        bin/code/FinalOutput.class \
	bin/code/FileReader.class 
	

build: $(CLASSFILES)
	ant compile

bin/%.class: src/%.java
	ant compile

clean:
	ant clean; rm -f outt_*.txt extra*.txt




