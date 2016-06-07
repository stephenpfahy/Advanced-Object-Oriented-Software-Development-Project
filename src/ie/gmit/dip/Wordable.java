package ie.gmit.dip;

import java.util.List;

/**
 * Wordable interface defines the method signatures for the methods in the WordDetail Class.
 * 
 * @author Stephen Fahy
 *
 */

public interface Wordable {

	void addDefinition(String line);

	void appendDefinition(String lineToLowerCase);

	String toString();

	List<String> getIndex();

	void setIndex(List<String> index);

	void addPage(String pageNumber);

	List<String> getDefinition();

	void setDefinition(List<String> definition);

}