package at.htlwels.wollersbergerjulian;

import java.io.*;
import java.nio.CharBuffer;
import java.text.ParseException;
import java.util.StringTokenizer;
import java.util.TreeSet;

/** The DNS Logfiles are read here. */
public class FileImporter {

	private File file;
	
	 /**All the Urls from the file get placed into the Set.
	  * @param path the path and name of the file to open
	  * @param urlSet the Set to save the Urls into */
	public FileImporter(String path, TreeSet<Url> urlSet)
	{
		//TODO If the Path isn't valid the program will crash.
		openFile(path);
		readFile(urlSet);
	}

	/* openFile() and readFile() have to be called seperately. */
	public FileImporter() {
	}

	/** This Method reads the file and places the urls into the TreeSet.
	 * @param urlSet the Set where the urls will get stored */
	public void readFile(TreeSet<Url> urlSet)
	{
		StringTokenizer stringTok = makeTokenizer();
		
		while(stringTok.hasMoreTokens())
		{
			try {
				urlSet.add(new Url(stringTok.nextToken()));
			} catch (ParseException e) {
				/* When the Url is invalid the line gets just ignored. */
			}
		}
		
	}
	
	//TODO The File limit is an Integer
	/**This Method makes a Tokenizer that that splits 
	 * the content of the file in lines.
	 * @return a Tokenizer for the File content that is ready to use (or null if it's not)
	 */
	public StringTokenizer makeTokenizer()
	{
		StringTokenizer stringTok = null;
		
		try {
			FileInputStream in = new FileInputStream(file);
			String str;

			/* Should be easier: StringSeqHelper.read() */

			/* A Stream Tokenizer can't return a String :'( */
			/*StreamTokenizer tokenizer = new StreamTokenizer(new InputStreamReader(in));
			tokenizer.quoteChar('\n');
			str = tokenizer.();
			System.out.println(str);*/
			
			/* The Stream writes into the Buffer */
			CharBuffer buffer = CharBuffer.allocate((int)file.length());
			//TODO Specify Charset, Line Delimeters
			InputStreamReader reader = new InputStreamReader(in);
			reader.read(buffer);
			reader.close();
			
			/* And the Tokenizer gets the String that is in the Buffer. */ 
			buffer.position(0);
			stringTok = new StringTokenizer(buffer.toString()/*, "\r\n"*/);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stringTok;
	}
	
	//TODO Open a Window to choose a File
	/**Opens the file behind Path. */
	public void openFile(String path)
	{
		file = new File(path);
	}
}
