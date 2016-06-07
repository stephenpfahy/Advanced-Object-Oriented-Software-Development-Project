package ie.gmit.dip;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Stephen Fahy
 * 
 *         The WordDetail Class implements the interface Wordable. The
 *         WordDetail adds the definitions to the to the values in the Map.
 *         Example: Map m <key, value> = new TreeMap <key, value> ();
 *
 */

public class WordDetail implements Wordable {

	private String word;
	private List<String> definition;
	private List<String> index;
	private String latestDefinition;
	private StringBuilder sb; // StringBuilder object

	/**
	 * WordDetail constructor takes in a String in it's parameters and this
	 * contains the key from the Map object.
	 *
	 * @param word
	 */

	public WordDetail(String word) {
		this.word = word;
		definition = new ArrayList<>();// definitions are put into an array
										// list.
		this.index = new ArrayList<>();// the index is put into an array list.
	}

	/**
	 * addDefinition method takes in the line from the dictionary and adds it as a definition.
	 */

	public void addDefinition(String line) {
		definition.add(line);
	}

	/**
	 *adds the definition to an arrayList.
	 */

	// append the definition from Dictionary Class.
	public void appendDefinition(String lineToLowerCase) {
		latestDefinition = definition.remove(definition.size() - 1);
		latestDefinition += lineToLowerCase;
		definition.add(latestDefinition);
	}

	/**
	 * The toString method calls a StringBuilder object which prints out the
	 * text from the Map (key, value)
	 */
	@Override
	public String toString() {
		sb = new StringBuilder();// StringBuilder object
		if (definition.size() > 0) {// if the definition size is greater then
									// one.
			for (int i = 0; i < definition.size(); i++) {
				sb.append(word);// display the word in the line
				sb.append(",");// display the "," in the line
				sb.append(definition.get(i));// display the definition
				if (i < definition.size() - 1) {
					sb.append('\n');
				}
			}
		} else {
			sb.append(word);
		}
		// return the strings.
		return sb.toString();

	}

	/**
	 * getIndex() method gets the Index .
	 */

	public List<String> getIndex() {
		return index;
	}

	/**
	 * setIndex method.
	 */

	public void setIndex(List<String> index) {
		this.index = index;
	}

	/**
	 * addPage method gets the page numbers.
	 */
	public void addPage(String pageNumber) {
		index.add(pageNumber);
	}

	/**
	 * getDefinition method gets the definition
	 */
	public List<String> getDefinition() {
		return definition;
	}

	/**
	 * setDefinition method sets the definition.
	 */
	public void setDefinition(List<String> definition) {
		this.definition = definition;
	}

}
