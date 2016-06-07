package ie.gmit.dip;

import java.util.*;
import java.io.*;

/**
 * 
 * @author Stephen Fahy
 * 
 *         The Dictionary Class reads in and parses the text in the file
 *         "textfiles/dictionary.csv". It first reads in and parses the file by
 *         splitting the words and definitions and putting them into into a Map
 *         object, splitting the text into key's (word) and values(definition of
 *         the word).
 *
 */

public class Dictionary {

	// instance variables declared below.
	private Map<String, WordDetail> m = new TreeMap<String, WordDetail>();
	private BufferedReader bufR;
	// private Map<String, String> m = new HashMap<String, String>();
	private Collection<String> words = new TreeSet<String>();
	private String line = null;
	private String lineToLowerCase;
	private String previousWord = null;
	private String cvsFileSplitByComma = ",";
	private String cvsFileSplitBySpace = " ";
	private String definition;
	private WordDetail wd;
	private String word;
	private int firstIndex;

	/**
	 * Dictionary constructor calls the dictionaryWords method and
	 * 
	 * @throws IOException
	 */
	public Dictionary() throws IOException {
		dictionaryWords();
	}

	/**
	 * The dictionaryWords method takes in a collection of Strings and puts the
	 * into a TreeSet called words. It splits the text into words and
	 * definitions and puts them into the Map m.
	 * 
	 * @return words
	 * @throws IOException
	 */

	public Collection<String> dictionaryWords() throws IOException {
		bufR = new BufferedReader(new InputStreamReader(new FileInputStream("textfiles/dictionary.csv")));
		// Buffered Reader reads in the dictionary.csv file.

		while ((line = bufR.readLine()) != null) {
			// line is assigned the value of text file being read in by the
			// buffered reader as long a line is not assigned the value of null.
			// This reads in the text in the file line by line.
			lineToLowerCase = line.toLowerCase();
			// The instance variable String lineToLowerCase is assigned the
			// value of all the text in the file being changed to lower case
			// letters.

			if (lineToLowerCase.startsWith(cvsFileSplitBySpace)) {
				// if line starts with a space
				wd = m.get(previousWord);
				// get word in dictionary Map
				if (wd == null) {// if word is null print out following message
					throw new NullPointerException("Word detail was null " + previousWord);
				}
				wd.appendDefinition(lineToLowerCase);
				// append the definition to WordDetail in the map using the
				// appendDefinition method in the WordDetail class.

			} else if (lineToLowerCase.startsWith("\",")) {
				// if line starts with inverted commas and a comma split
				definition = lineToLowerCase.substring(lineToLowerCase.indexOf(cvsFileSplitByComma) + 1);
				wd = m.get(previousWord);
				if (wd == null) {
					throw new NullPointerException("Word detail was null " + previousWord);
				}
				wd.addDefinition(definition);
				// add the definition to the map using addDefinition method in
				// the WordDetail class
			} else if (lineToLowerCase.startsWith("\""))
			// if line starts with inverted comma's
			{
				firstIndex = lineToLowerCase.indexOf(cvsFileSplitByComma);
				// at the first comma split the line.
				// String word is assigned the value of the text of the text in
				// between the first two commas in a line
				// The inverted commas are also stripped of this word using the
				// stripTheInvertedCommas.
				word = stripTheInvertedCommas(lineToLowerCase.substring(0, firstIndex));
				previousWord = word;
				wd = m.get(word);//
				if (wd == null) {
					wd = new WordDetail(word);// new WordDetail
					m.put(word, wd);
					// put word and definition into the Map m.
				}
				wd.addDefinition(lineToLowerCase.substring(firstIndex + 1));
				// add the definition using the addDefinition in the WordDetail
				// class
			} else {
				throw new IOException("unknown format" + lineToLowerCase);
			}

		}
		// System.out.println(m);

		return words;// return the result in TreeSet words.

	}

	/**
	 * The stripTheInvertedCommas method strips the inverted commas from the
	 * word.
	 * 
	 * @param word
	 * @return word
	 */

	private String stripTheInvertedCommas(String word) {
		if (word.startsWith("\"") && word.endsWith("\"")) {
			// the word is the text between the first two inverted commas in the
			// line
			// The inverted commas are stripped of the word and the word is
			// returned.
			return word.substring(1, word.length() - 1);
		} else {
			return word;

		}
	}
	
	

	/**
	 * The getDictionary method returns the Map m or the words and definitions
	 * from the dictionary.csv.
	 * 
	 * @return m
	 */

	public Map<String, WordDetail> getDictionary() {
		return m;

	}
}
