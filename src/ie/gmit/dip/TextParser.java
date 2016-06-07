package ie.gmit.dip;

import java.util.*;
import java.io.*;

/**
 * 
 * @author Stephen Fahy
 * 
 *         The TextParser class reads in and parse's the text in the text file
 *         chosen be the user of the program. It divides each word in the text
 *         file into an array and removes any words which are in the TreeSet in
 *         the StopWords class. The words from from the text file are put into a
 *         index Map as the key with a definition to be created in the value.
 *         The definition is added to the value my comparing the index Map with
 *         the Map(keys and values) created in the Dictionary Class from the
 *         dictionary.csv.
 * 
 *
 */

public class TextParser {

	// instance variables declared.
	private int lineCounter;
	private int pageCounter;
	private boolean run = true;
	private StopWords sw = new StopWords();// StopWords object called sw gets
											// the StopWords class.
	private Collection<String> stop = sw.getStopWords();// a collection of
														// Strings called stop
														// is assigned the value
														// of the getStopWords
														// method in StopWords.
	private Map<String, WordDetail> index = new TreeMap<String, WordDetail>();
	// A map object is created called index which takes a key(A String which
	// contains the word) and a value (definition created in the WordDetail
	// class). The map is a TreeMap which prints the key in alphabetical order
	// followed by the definition.
	private BufferedReader br;// BufferedReader object.
	private String lineOfText = null;
	private String[] wordsInTheTextFile;// An array of Strings.
	private String word;
	private WordDetail we = new WordDetail(null); // WordDetail object calls the
													// WordObject class.
	private String key;
	private String pageNumber;
	private FileWriter book;// FileWriter object
	private BufferedWriter bufW;// BufferedWriter object called.
	private Scanner s;// Scanner object called.
	private Map<String, WordDetail> dictionary;// A map for the dictionary
												// class.
	private Dictionary d;// Dictionary class called
	private Iterator<String> indexIterator;
	private String choose;
	private IndexingAndDictionaryMenu menu;

	/**
	 * The TextParser constructor
	 * 
	 * @throws IOException
	 */

	public TextParser() throws IOException {

	}

	/**
	 * The parseTextfile method parses the text file entered by the user of the
	 * program.
	 * 
	 * @param textfile
	 * @throws IOException
	 */

	public void parseTextFile(String textfile) throws IOException {

		d = new Dictionary();// A Dictionary object is created which calls a
								// dictionary class.
		d.dictionaryWords();// The dictionaryWords method is called in the
							// Dictionary class which parses the text in the
							// dictionary.csv file ands puts the words into the
							// key of a map and puts the definitions into the
							// values of the map.
		dictionary = d.getDictionary();
		// dictionary is assigned the value of the getDictionary method in the
		// Dictionary class.
		// This returns the Map from Dictionary which contains the words and
		// definition from dictionary.csv.
		// System.out.println(dictionary);

		lineCounter = 0;
		pageCounter = 1;

		br = new BufferedReader(new InputStreamReader(new FileInputStream(textfile)));
		// Buffered reader reads in text file.

		while (((lineOfText = br.readLine()) != null)) {
			lineCounter++;
			// reads the text in line by line
			if (lineCounter % 40 == 0)
				pageCounter++;
			// every time 40 lines have been read in by br then a page is
			// created.

			wordsInTheTextFile = lineOfText.toLowerCase().replaceAll("[^a-z]", " ").split(" ");
			// A String array of words is created which reads in the line of
			// text, changes all letters in text to lower case letters, removes
			// anything which isn't lower case letters between a and z and
			// splits the
			// line every time there is a space in it.
			// The words of the text are put into an array and a for loop
			// iterates over this array.
			for (int i = 0; i < wordsInTheTextFile.length; i++) {
				word = wordsInTheTextFile[i];

				// If there is a word in the text which is also in the StopWords
				// Class do not include this word
				if (stop.contains(word)) {
					// System.out.println("STOP WORD: " + words[i]);
					// System.out.println("THE WORD " + word + " IS REMOVED FROM
					// PAGE NUMBER " + pageCounter + ".");
					continue;
				}

				// key is assigned the value of word.
				key = word;

				// An index Map is compared to the dictionary map

				// if the index map and dictionary map do not contain the
				// key(word in text file)
				// word or definition print out "THERE IS NO DEFINITION FOR THIS
				// WORD" and add the word to the index Map along with the page
				// number where the word is found in the text.
				if (!index.containsKey(key) && !dictionary.containsKey(key)) {
					WordDetail wd = new WordDetail(key);
					wd.addDefinition("THERE IS NO DEFINITION FOR THIS WORD.");
					String s = String.valueOf(pageCounter);
					we.addPage(s);
					index.put(key, wd);
				}

				// if the index Map does not contain the key(word in the text
				// file) and the dictionary Map does contain the key add the key
				// to the index Map along with the definition.
				if (!index.containsKey(key) && dictionary.containsKey(key)) {
					we = dictionary.get(key);
					pageNumber = String.valueOf(pageCounter);
					we.addPage(pageNumber);
					index.put(key, we);
				}
			}

		}
		iterator();// The iterator method is called
	}

	/**
	 * The iterator method iterates through Map index so the entire map prints
	 * out to the console and also to a file.
	 * 
	 * @throws IOException
	 */

	public void iterator() throws IOException {

		indexIterator = index.keySet().iterator();
		// iterate through the TreeMap index.

		book = new FileWriter("textfiles/words_in_book_definitions.txt");
		bufW = new BufferedWriter(book);
		bufW.write("---------------------------------------------------");
		bufW.write(" THE WORDS AND DEFINITIONS IN THE TEXT ");
		bufW.write("---------------------------------------------------");
		bufW.newLine();
		bufW.newLine();
		while (indexIterator.hasNext()) {
			String key = indexIterator.next();
			System.out.println("WORD: " + key);
			System.out.println("PAGE NUMBER: " + pageNumber);
			System.out.println("DEFINITION: ");
			System.out.println(index.get(key));
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

			bufW.newLine();
			bufW.write("WORD: " + key);
			bufW.newLine();
			bufW.write("PAGE NUMBER: " + pageNumber);
			bufW.newLine();
			bufW.write("DEFINITION: ");
			bufW.newLine();
			bufW.write("" + index.get(key));
			bufW.newLine();
			bufW.newLine();
			bufW.write(
					"===============================================================================================================================================================================================================================================================================================================================");

		}
		bufW.close();
		System.out
				.println("******************************************************************************************");
		System.out
				.println("*******THE INDEX OF THE TEXT CONTAINING THE WORDS AND DEFINITION HAS BEEN CREATED.********");
		System.out
				.println("**YOU CAN VIEW IT IN THE CONSOLE OR IN THE FILE textfiles/words_in_book_definitions.txt.**");
		System.out
				.println("******************************************************************************************");
		System.out.println("");

		ScanInWord();// call the scanInWord method.

	}

	/**
	 * The ScanInWord method asks the user would they like to search the text
	 * for word and definition and bring the user to the searchForWordInText
	 * method if they select yes and back to the menu in the
	 * IndexingAndDictionaryMenu Class if they select no.
	 * 
	 * @throws IOException
	 */

	public void ScanInWord() throws IOException {

		s = new Scanner(System.in);

		System.out.println("WOULD YOU LIKE TO SEARCH THE TEXT FOR A WORD AND DEFINITION? (YES/NO)");
		System.out.println("SELECT NO IF YOU WOULD LIKE TO RETURN TO THE MAIN MENU.");
		while (run) {
			choose = s.next().toUpperCase();
			if (choose.startsWith("Y")) {
				run = true;
				searchForWordInText();

			} else if (choose.startsWith("N")) {
				run = false;
				System.out.println("RETURN TO MENU: ");
				menu = new IndexingAndDictionaryMenu();
				// IndexingAndDictionaryMenu object is created and the class is
				// called to bring user back to MainMenu
				menu.getClass();

			}

		}

	}

	/**
	 * The searchForWordInText method prints out a prompt to search the text for
	 * a word entered by the user and get's its definition. It then searches
	 * through the index Map and if a key matches the word entered by the user
	 * then the key and value(WORD AND DEFINITION) are printed out to screen.
	 * The user is then brought to the ScanInWord method which asks the user to
	 * the want to search for another word in the text.
	 * 
	 * @throws IOException
	 */

	public void searchForWordInText() throws IOException {

		System.out.println("Enter the word to search the text.");

		String searchForWord = s.next();
		System.out.println(searchForWord);//user types in word.
		if (index.containsKey(searchForWord)) {
			//the index Map is checked to see if the word is in it.
			System.out.println("WORD: " + searchForWord);//word displayed
			System.out.println("DEFINITION: ");
			System.out.println(index.get(searchForWord));//definition displayed
			System.out.println();
			ScanInWord();

		} else {
			System.out.println("THE WORD IS NOT IN THE TEXT!"); 
			//If the word is not in the text display the following message.
			System.out.println();
			ScanInWord();

		}

	}

}
