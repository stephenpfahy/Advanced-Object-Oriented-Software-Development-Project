package ie.gmit.dip;

import java.io.*;//imports BufferedInputStream, BufferedReader, BufferedWriter, FileWriter, IOException, InputStream, InputStreamReader.
import java.net.*;//imports MalformedURLException, URL, URLConnection.
import java.util.*;//imports Scanner.

/**
 * 
 * @author Stephen Fahy
 * 
 *         FileDownloader Class reads in a text file from an online resource by
 *         typing in a URL using a scanner. The file is written to a new text
 *         file which is then sent to the TextParser Class.
 *
 */
public class FileDownloader {

	// INSTANCE VARIABLES ARE DECLARED
	private Scanner s = new Scanner(System.in);// Scanner object.
	private BufferedWriter bw;// Buffered Writer object
	private boolean running = true;
	private String uniformResourceLocater;
	private int option;
	private URLConnection uc;
	private InputStream raw;
	private InputStream buffer;
	private BufferedReader br;// Buffered reader object
	private IndexingAndDictionaryMenu menu;// IndexingAndDictionaryMenu object
											// for IndexingAndDictionaryMenu
											// Class
	private FileWriter fw;// FileWriter object
	private String c;
	private TextParser tp;// TextParser object for TextParser Class.
	private URL u;// URL object
	//private String choose;
	//private boolean run;

	/**
	 * FileDownloader Constructor.
	 */
	public FileDownloader() {
	}

	/**
	 * FileDownload method.
	 * 
	 * @throws IOException
	 * 
	 *             This method scans in the URL entered by the user. If the URL
	 *             is valid the user is brought to a menu with 3 options. If the
	 *             URL is not valid then a message will display telling the user
	 *             this and then will bring the user back to the
	 *             IndexingAndDictionaryMenu Class. If the user selects 1 then
	 *             the message will display in the console. If the user selects
	 *             2 then the text will be written to a text file and sent to
	 *             the TextParser Class. If the user selects option 3 then they
	 *             will be brought back to the main menu in the
	 *             IndexingAndDictionaryMenu Class.
	 */

	public void FileDownload() throws IOException {

		
		System.out.println("-- VIEW IN A SOURCEVIEWER --");
		System.out.println("PLEASE ENTER IN THE URL: ");
		uniformResourceLocater = s.nextLine();// String uniformResourceLocator
												// is assigned the value of text
												// entered by user into console.

		if (uniformResourceLocater.length() > 0) {// if the length is greater
													// than 0 try open the URL
													// for reading/
			try {
				// Open the URLConnection for reading
				u = new URL(uniformResourceLocater);// URL object

				System.out.println("WOULD YOU LIKE TO VIEW THE TEXT IN THE CONSOLE OR WRITE TO A FILE?");
				System.out.println("IF YOU CHOOSE 1 THE TEXT FROM THE WEB RESOURCE WILL SHOW IN THE CONSOLE.");
				System.out.println(
						"IF YOU CHOOSE 2 THE TEXT WILL WRITE TO A FILE ON DISK CALLED 'text_from_internet.txt'.");
				System.out.println("IF YOU CHOOSE 3 YOU WILL BE BROUGHT BACK TO THE MAIN MENU.");
				while (running) {// while loop is true
					option = s.nextInt();
					// option is assigned the value of an integer entered by the
					// user in the console.

					if (option == 1) {
						uc = u.openConnection();//opens connection
						raw = uc.getInputStream();//inputs the bytes
						buffer = new BufferedInputStream(raw);
						br = new BufferedReader(new InputStreamReader(buffer));

						while ((br.readLine()) != null) {//reads the text line by line
							System.out.println(br.readLine());//prints the text out to console
						}

						System.out.println("EVERYTHING CAME ACROSS THE CONNECTION.");
						System.out.println("RETURN TO MENU: ");
						menu = new IndexingAndDictionaryMenu();
						menu.getClass();// the user is brought back to the IndexingAndDictionaryClass

					} else if (option == 2) {
						uc = u.openConnection();
						raw = uc.getInputStream();
						buffer = new BufferedInputStream(raw);
						br = new BufferedReader(new InputStreamReader(buffer));
						
						//the text from the URL resource is written to file (textfiles/text_from internet).
						fw = new FileWriter("textfiles/text_from_internet.txt");
						bw = new BufferedWriter(fw);

						// String c;
						while ((c = br.readLine()) != null) {//reads the text line by line
							System.out.println(br.readLine());//prints the text out

							bw.append(c);
							bw.write(c);//Each line of text is appended and written to the text file
							bw.newLine();

						}
						
						System.out.println("----------------------------------------------------------------------------------------------------------------");
						System.out.println("EVERYTHING CAME ACROSS THE CONNECTION.");
						System.out.println("THE WEB RESOURCEIS NOW WRITTEN TO A FILE ON DISK CALLED 'textfiles/text_from_internet.txt'.");
						System.out.println("-----------------------------------------------------------------------------------------------------------------");
						tp = new TextParser();//TextParser object created.
						tp.parseTextFile("textfiles/text_from_internet.txt");
						//The file "textfiles/text_from_internet.txt is sent to the parseTextFile method in the TextParser Class"			
							
						} else if (option == 3) {//if user types 3 the while loop stops running as it is boolean false.
						System.out.println("RETURN TO MAIN MENU.");
						running = false;
						menu = new IndexingAndDictionaryMenu();
						menu.getClass();//The user is brought to the IndexingAndDictionaryMenu Class.
					} else {
						System.out.println("Enter a value [1-3]>");
						//if the user enters a value other the 1, 2 and 3 they are prompted to enter a value between 1 and 3.
					}
				}

			} catch (MalformedURLException e) {
				// if not valid URL print out message below
				System.err.println(uniformResourceLocater + " IS NOT A PARSEABLE URL.");
				menu = new IndexingAndDictionaryMenu();
				menu.getClass();
			} catch (IOException e) {
				System.err.println(e);
				menu = new IndexingAndDictionaryMenu();
				menu.getClass();//The user is brought back to the main menu.
			}
		} // end if

	}
	
	

}
