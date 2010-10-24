# Makefile for Classifier System by Ashish Tomar



CLASSFILES=bin/code/Document.class \
	bin/code/CountGenerator.class \
        bin/code/POSFileReader.class \
        bin/code/ParseFileReader.class \
	bin/code/FileReader.class 
	

build: $(CLASSFILES)
	ant compile

bin/%.class: src/%.java
	ant compile

clean:
	ant clean; rm -f outputA*.txt extra*.txt




