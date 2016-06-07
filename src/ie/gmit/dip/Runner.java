package ie.gmit.dip;

import java.io.*;


/**
 * @author Stephen Fahy
 * 
 * The Runner Class's primary function is to start up the program. It welcome's
 * the user to the index and dictionary maker and brings the user to the menu by
 * calling the IndexingAndDictionaryMenu Class.
 **/

public class Runner {

	private static IndexingAndDictionaryMenu menu;// instance variables are
													// called here.

	/**
	 * Main argument carries out all the methods in the program.
	 * 
	 * @param args
	 * @throws IOException
	 *             It welcomes the user to the programme and calls the
	 *             IndexingAndDictionaryMenu Class. The
	 *             IndexingAndDictionaryMenu Class contains all the other
	 *             methods in the programme to be carried out.
	 **/

	public static void main(String[] args) throws IOException {

		System.out.println("---------------------------------------------------------------");
		System.out.println("------WELCOME TO THE FILE INDEXER AND DICTIONARY MAKER---------");
		System.out.println("---------------------------------------------------------------");
		System.out.println("     ");

		// An IndexingAndDictionaryMenu Object is created called menu.
		menu = new IndexingAndDictionaryMenu();
		menu.getClass();
		// menu calls the getClass() method which brings the user to the
		// IndexingAndDictionaryMenuClass
	}
}
