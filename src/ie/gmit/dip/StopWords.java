package ie.gmit.dip;

import java.util.*;//imports Scanner Object
import java.io.*;//imports File and FileNotFoundException

/**
 * 
 * @author Stephen Fahy
 *
 *         The StopWords Class reads in and parse's the text in the file
 *         "text files/stopwords.txt". This file contains a list of all of the
 *         words that do not need to be included in the index.
 */
public class StopWords {

	private Scanner s;
	private Collection<String> stopWords = new TreeSet<String>();
	private String nextWord;

	/**
	 * The StopWords constructor calls the getStopWords method and throws a
	 * FileNotFoundException if the file is not found
	 */

	public StopWords() throws FileNotFoundException {
		getStopWords();
		 //System.out.println("STOPWORDS: " + getStopWords());
	}

	/**
	 * The getStopWords method
	 * 
	 * @return stopWords
	 * @throws FileNotFoundException
	 * 
	 *             A TreeSet called stopWords object is created. The scanner
	 *             object reads in the text line by line and adds each word to
	 *             the TreeSet.
	 */

	public Collection<String> getStopWords() throws FileNotFoundException {
		
		//The scanner reads in a text file using a scanner.
		s = new Scanner(new File("textfiles/stopwords.txt"));

		// while loop loops over the text file and reads text into TreeSet.
		while (s.hasNextLine()) {
			nextWord = s.nextLine();
			stopWords.add(nextWord);
		}
		return stopWords;//

	}

	
}
