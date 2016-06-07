package ie.gmit.dip;

import java.io.*;//import io for the IOException
import java.util.*;//import util for the scanner.

/**
 * @author Stephen Fahy
 * 
 *         The IndexingAndDictionaryMenu Class creates a menu which give's the
 *         user ten different options. Options 1 to 7 provide sample text files
 *         to which are sent to the TextParser class and the text is parsed and
 *         divided into words which are then given definitions and an index is
 *         then created. Option 8 gives the user the option to enter in their
 *         own text file which is then sent to the TextParser Class. Option 9
 *         bring the user to the FileDownloader Class which downloads a text
 *         file when a URL is entered and then this text file is sent to the
 *         TextParser Class. Option 10 gives the user the option to leave the
 *         application. The programme is then terminated.
 **/
public class IndexingAndDictionaryMenu {

	// The instance variables are called below
	private String menuText = null; // creating a String called menuText which
									// has the value of null.
	private Scanner s = new Scanner(System.in);// creating a scanner object from
												// java.io library which scans
												// in text entered by the user.
	private boolean keepRunning = true;
	private int option;
	private String fileLocation;
	private StringBuffer sb;// StringBuffer object called sb is created.
	private TextParser tp;// TextParser object called tp which calls the
							// TextParser Class.
	private IndexingAndDictionaryMenu menu;// IndexingAndDictionaryMenu object
											// called menu which calls this
											// class.
	private FileDownloader fd;

	/**
	 * IndexingAndDictionaryMenu constructor.
	 * 
	 * @throws IOException
	 * 
	 *             IndexingAndDictionaryMenu constructor calls the
	 *             IndexingAndDictionary Class with the super method and creates
	 *             it. It calls the BuildMenu method which builds the menu using
	 *             a StringBuffer and prints it out as text. It calls the
	 *             getUserOption method which creates options to select in the
	 *             menu.
	 */
	public IndexingAndDictionaryMenu() throws IOException {
		super();// calls the IndexingAndDictionaryMenu Class
		this.buildMenu();// calls buildMenu method.
		System.out.println(menuText);// prints out the StringBuffer text in
										// BuildMenu method.
		this.getUserOption();// calls getUserOption method.
	}

	/**
	 * getUserOption Method
	 * 
	 * @throws IOException
	 * 
	 *             Creates a while loop called boolean keepRunning which is
	 *             assigned the value of true and keeps running until the user
	 *             selects option 10 in the menu which is false. This option
	 *             exits the program. The int object instance variable is
	 *             assigned the value of any integer that the user enters into
	 *             the program using the scanner object. If user enters 1-7 this
	 *             provides sample text files which are sent to the TextParser
	 *             class. If user enters 8 this gives the user the option to
	 *             enter in their own text file which is then sent to the
	 *             TextParser Class. If user enters 9 this bring the user to the
	 *             FileDownloader Class. If user enters 10 then the programme is
	 *             then terminated. If user enters any other number the the user
	 *             is prompted to enter an integer between 1 and 10.
	 */
	private void getUserOption() throws IOException {
		while (keepRunning) {// while loop is assigned the value of true.
			option = s.nextInt();// option is assigned the value of whatever
									// integer the user types into console.

			if (option == 1) {
				tp = new TextParser();// TextParser object created.
				tp.parseTextFile("textfiles/PoblachtNaHEireann.txt");
				// if option 1 is selected send the text file to the
				// parseTextFile method in TextParser Class.
			} else if (option == 2) {
				tp = new TextParser();
				tp.parseTextFile("textfiles/DeBelloGallico-Caesar.txt");
				// if option 2 is selected send the text file to the
				// parseTextFile method in TextParser Class.
			} else if (option == 3) {
				tp = new TextParser();
				tp.parseTextFile("textfiles/DivineComedy-Dante.txt");
				// if option 3 is selected send the text file to the
				// parseTextFile method in TextParser Class.
			} else if (option == 4) {
				tp = new TextParser();
				tp.parseTextFile("textfiles/HappyPrince-Wilde.txt");
				// if option 4 is selected send the text file to the
				// parseTextFile method in TextParser Class.
			} else if (option == 5) {
				tp = new TextParser();
				tp.parseTextFile("textfiles/PictureOfDorianGray-Wilde.txt");
				// if option 5 is selected send the text file to the
				// parseTextFile method in TextParser Class.
			} else if (option == 6) {
				tp = new TextParser();
				tp.parseTextFile("textfiles/ThePrince-Machiavelli.txt");
				// if option 6 is selected send the text file to the
				// parseTextFile method in TextParser Class.
			} else if (option == 7) {
				tp = new TextParser();
				tp.parseTextFile("textfiles/WarAndPeace-Tolstoy.txt");
				// if option 7 is selected send the text file to the
				// parseTextFile method in TextParser Class.
			} else if (option == 8) {
				System.out.println("Please type in a the name of the text file.");
				try {
					tp = new TextParser();
					fileLocation = s.next();
					tp.parseTextFile(fileLocation);
				} catch (Exception e) {
					System.out.println("You have not entered a valid file name.");
					menu = new IndexingAndDictionaryMenu();
					menu.getUserOption();
				}
			} else if (option == 9) {
				fd = new FileDownloader();// FileDownloader object is created.
				fd.FileDownload();
				// if option 9 is selected the user is brought to the
				// FileDownload method method in FileDownloader Class.
			} else if (option == 10) {
				System.out.println("YOU ARE NOW EXITING THE INDEX AND DICTIONARY MAKER");
				keepRunning = false;
				System.exit(option);
				// if 10 is selected the while loop is false and stops running.
				// The programme is then stopped
			} else {
				System.out.println("Enter a value [1-10]>");
				// user is prompted to enter a number between 1 and 10.
			}
		}
	}

	/**
	 * The BuildMenu method creates a StringBuffer object called sb which
	 * creates the menu text. The instance variable menuText is assigned the
	 * value of any text which has written in sb. The BuildMenu method is called
	 * in the IndexingAndDictionaryMenu Constructor.
	 */
	private void buildMenu() {
		sb = new StringBuffer();
		// String Buffer object called sb is created and a menu text is appended.
		// below.
		sb.append("-------------------------------\n");
		sb.append("\t FILE DOWNLOADER MENU \n");
		sb.append("-------------------------------\n");
		sb.append("Note: \n");
		sb.append("The first few options sare sample textfiles. \n");
		sb.append("You can enter your own textfile in option 8. \n");
		sb.append("You can enter a URL in option 9 to download an online text resource. \n");
		sb.append("You can exit the program by selecting option 10. \n\n");
		sb.append("1. Poblacht Na hEireann. \n");
		sb.append("2. Commentarii de Bello Gallico by Julius Caesar.\n");
		sb.append("3. The Divine Comedy by Dante Alighieri. \n");
		sb.append("4. The Happy Prince by Oscar Wilde. \n");
		sb.append("5. The Picture of Dorian Gray by Oscar Wilde. \n");
		sb.append("6. The Prince by Niccolò Machiavelli.\n");
		sb.append("7. War and Peace by Leo Tolstoy.\n");
		sb.append("8. Type in a file name.\n");
		sb.append("9. Type in a URL.\n");
		sb.append("10. Exit\n\n");
		sb.append("Enter Option [1-10]>");
		menuText = sb.toString();
		// Instance variable String menuText is assigned the value of contents
		// of the StringBuffer which has been converted to a String.

	}

}
