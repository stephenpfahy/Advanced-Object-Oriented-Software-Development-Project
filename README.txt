********************************************************************************************
                            GALWAY-MAYO INSTITUTE OF TECHNOLOGY 
                                         STEPHEN FAHY
                        HIGHER DIPLOMA IN SCIENCE (SOFTWARE DEVELOPMENT)
                                       G00172772@gmit.ie
                             ADVANCED OBJECT ORIENTED PROGRAMMING
********************************************************************************************
                              A JAVA INDEXING AND DICTIONARY API 
********************************************************************************************

The following files are in the {g00172772}.zip:

(1) src	: A directory that contains the packaged source code for the application.
(2) textfiles: A folder containing sample .txt files to be used by the programme.
(3) README.txt : This text file outlines the main features of the application, 
    and also contains a set of instructions for running this programme. 
(4) design.png : A UML diagram of the API design. 
    The UML diagram show's the relationships between the key classes in the design. 
(5) docs : A directory containing the JavaDocs for this application.
(6) index.jar : A Java Application Archive containing the classes in this application.

********************************************************************************************
                     MAIN FEATURES OF THE JAVA INDEXNG AND DICTIONARY API
********************************************************************************************

In the src folder a package has been created called ie.gmit.dip.
In the package there are eight .java files and this package contains eight .java files containing 
the seven classes and one interface needed to run the programme. These are as follows:

Runner.java
IndexingAndDictionaryMenu.java
FileDownloader.java
Textparser.java
Dictionary.java
StopWords.java
WordDetail.java
Wordable.java.

In the textfiles folder it contains the following textfiles and one csv file. These are as follows:

DeBelloGallico-Caesar.txt
dictionary.csv
DivineComedy-Dante.txt
HappyPrince-Wilde.txt
IgnoreWords.txt
PictureOfDorianGray-Wilde.txt
PoblachtNaHEireann.txt
stopwords.txt
ThePrince-Machiavelli.txt
WarAndPeace-Tolstoy.txt

------------------------------------------------------------------------------------------------------------------------
The main function of the programme is that it should be able to read in and parse any .txt file. The programme should be
able to read in every word in the textfile and create an index for the textfile which provides the definitions of the words
in the textfile and also prints the page numbers. This index should print to a screen in the console and also to the file 
words_in_book_definitions.txt in the textfile folder. The user should also be able to type a word into the console and 
the programme should search the textfile for this word and print the definition out in the console.
------------------------------------------------------------------------------------------------------------------------
Runner.java

The Runner Class's primary function is to start up the program. This class contains the main method and it welcome's
the user to the index and dictionary maker by printing out the text "WELCOME TO THE FILE INDEXER AND DICTIONARY MAKER".
This class brings the user to the main menu by calling the IndexingAndDictionaryMenu Class in the main method. 

------------------------------------------------------------------------------------------------------------------------
IndexingAndDictionaryMenu.java

The IndexingAndDictionaryMenu Class's main function is to display a menu which give's the
user ten different options. The first seven options provides sample text files from the 
textfiles folder and these are sent to the TextParser class and the text is parsed and
divided into words which are then given definitions and an index is then created. 
Option 8 gives the user the option to enter in their own text file which is then sent to the TextParser Class. 
Option 9 bring the user to the FileDownloader Class which downloads a text file when a URL is entered 
and then this text file is sent to the TextParser Class. 
Option 10 gives the user the option to leave the application and then the programme is terminated.

This programme is made up of three methods: IndexingAndDictionaryMenu() constructor, the getUserOption() method 
and the buildMenu() method.

The IndexingAndDictionaryMenu constructor calls the IndexingAndDictionary Class with the super method and creates it. 
It calls the BuildMenu method which builds the menu using a StringBuffer and prints it out as text. It then calls the 
getUserOption method which creates options to select in the menu.

--------------------------------------------------------------------------------------------------------------------------
FileDownloader.java

The FileDownloader Class reads in a text file from an online resource by typing in a URL using a scanner object. 
The file is written to a new text file called "textfiles/text_from_internet.txt" using a file writer object
which is then sent to the TextParser Class.

The class contains the FileDownloader() constructor and the FileDownload() method.

The FileDownload() method scans in the URL entered by the user. If the URL is valid the user is brought to a menu 
with 3 options. If the URL is not valid then a message will display telling the user this and then will bring the 
user back to the main menu in theIndexingAndDictionaryMenu Class. 
If the user selects 1 then the message will display in the console. 
If the user selects 2 then the text will be written to a text file and sent to the TextParser Class. 
If the user selects option 3 then they will be brought back to the main menu in the IndexingAndDictionaryMenu Class.

---------------------------------------------------------------------------------------------------------------------------
Textparser.java

The TextParser class reads in and parse's the text in the textfile.txt chosen be the user of the program.
A file containing words not to be included in the index is parsed in the StopWords class and this class is called
in the TextParser Class. This removes stopwords from the textfile. 
The TextParser Class reads in the textfile line by line, puts all letters to lowercase letters, removes any characters
which are not letters between a-z and splits each word in the line by the space. 
Also for every 40 lines read in a page number is also created. The Text Parser then divides each word in the text 
file into an array which is then put to in as the key (as a collection of Strings) in a Map object.

The values of this Map object contains the definitions which have been created in the Dictionary Class and the WordDetail Class.
The TextParser creates an index by comparing the Map objects created in the Textparser Class and the Dictionary Class.
The Map in the TextParser Class has key's(made from all the words in the textfile) and no values.
The Map in the Dictionary Class has Key's(words from the dictionary.csv file) and 
values (the definitions of the words in the dictionary.csv file).
If the two Maps have matching words then the definitions are taken from the Dictionary Class Map and 
added and appended to the values of the TextParser Class Map using methods in the WordDetail class which extract 
the definitions from the Dictionary Class map. The index for the textfiles has now been created

The Index for the textfile is then printed out to screen displaying the word, page number and definition. 
It has also been printed out to a textfile called "words_in_book_definitions" in the textfiles folder.

The user is then given the option to enter in a word and then the programme will search for that word and
then display the word and definition. When the user is finished carrying out these tasks then they are brought 
back to the main menu in the IndexingAndDictionaryMenu Class.

--------------------------------------------------------------------------------------------------------------------
StopWords.java

The StopWords Class reads in and parse's the text in the file "text files/stopwords.txt". This file contains a list
 of all of the words that do not need to be included in the index. The text is read in line by line and then
 put into a treeSet.
 The class contains the StopWords() constructor which calls the getStopWords() method which returns the stopWords.
 
---------------------------------------------------------------------------------------------------------------------
Dictionary.java

The Dictionary Class reads in and parses the text in the file "textfiles/dictionary.csv". 
It first reads in the file line by line and puts all the words to lowercase.
It parses the file by splitting the words and definitions by removing inverted commas, commas and spaces.
The words and definitions are put into a TreeMap which display the words and definitions in alphabetical order. 
By putting them into into a Map the text is split into key's (word) and values(definition of the word).

The Dictionary() constructor calls the dictionaryWords method which returns a collection of Strings 
which are divided into a map as Keys (word) and values (definition) and put into a map. The word and definition is also
extracted in this method by the WordDetail class to help build the index.
In this method the stripTheInvertedCommas method is called which strips the inverted commas from the word.

The getDictionary method returns the Map object made out of the word(key) and the definitions (values).

---------------------------------------------------------------------------------------------------------------------
WordDetail.java

The WordDetail Class implements the interface Wordable. The WordDetail extracts the definitions from the Dictionary Class.
and adds them to an arrayList. It also extracts the words from the Dictionary Class  and TextParser Class.
WordDetail adds the definitions to the to the values of the Map in TextParser. The definitions are added to an arrayList 
useing the addDefinitions method and then they are a appended using the appendDictionary method. 
The words from the textfile are extracted from the TextParser Class and appened to an ArrayList also.

The toString method calls a stringBuilder objects which prints the the word and definition arrayList.
The word is printed first, followed by comma and then the definition. Getter and setter methods get the definition 
and getter and setter methods help construct the index and print it out as an arrayList. The addPageNumbers method gets 
the page numbers. All these methods in WordDetail help create the values for the index Map in the TextParser Class. 
----------------------------------------------------------------------------------------------------------------------
Wordalble.java

Wordable interface defines the method signatures for the methods in the WordDetail Class. It hides what is actually 
happening in these methods in the WordDetail Class.







************************************************************************************************************************
                       INSTRUCTIONS ON HOW TO USE THE JAVA INDEXING AND DICTIONARY API
**********************************************************************************************************************

1. Insert all the files from src folder and the textfiles folder into Eclipse IDE.

2. Open the Runner.java file and run as a java application.

3. The welcome screen should appear.
---------------------------------------------------------------
------WELCOME TO THE FILE INDEXER AND DICTIONARY MAKER---------
---------------------------------------------------------------
     
4. The user will then be brought to a menu screen.

-------------------------------
	 FILE DOWNLOADER MENU 
-------------------------------
Note: 
The first few options sare sample textfiles. 
You can enter your own textfile in option 8. 
You can enter a URL in option 9 to download an online text resource. 
You can exit the program by selecting option 10. 

1. Poblacht Na hEireann. 
2. Commentarii de Bello Gallico by Julius Caesar.
3. The Divine Comedy by Dante Alighieri. 
4. The Happy Prince by Oscar Wilde. 
5. The Picture of Dorian Gray by Oscar Wilde. 
6. The Prince by Niccolò Machiavelli.
7. War and Peace by Leo Tolstoy.
8. Type in a file name.
9. Type in a URL.
10. Exit

Enter Option [1-10]>


5. Once you select an option and choose a textfile then the index will be created display the word, page number and definition.
   The index will be displayed in the console or printed to a file. If succesfull then the following prompt will display.
   
   ******************************************************************************************
*******THE INDEX OF THE TEXT CONTAINING THE WORDS AND DEFINITION HAS BEEN CREATED.********
**YOU CAN VIEW IT IN THE CONSOLE OR IN THE FILE textfiles/words_in_book_definitions.txt.**
******************************************************************************************

6. The user is then asked would they like to search the textfile for a word and display the definition.

WOULD YOU LIKE TO SEARCH THE TEXT FOR A WORD AND DEFINITION? (YES/NO)
SELECT NO IF YOU WOULD LIKE TO RETURN TO THE MAIN MENU.

If yes is selected then the user is asked to enter a word and if the select no to bring them back to main menu.

Enter the word to search the text.

The word is then displayed along with the definition/definitions.

The above question is then repeated until the user no longer wants to search for words in the textfile.

No is the selected to bring the user back to the main menu.

7. The user can either choose option 1 - 9 in the main menu to create another index for another text or
   select option 10 to quit the Java Indexing and Dictionary API.













