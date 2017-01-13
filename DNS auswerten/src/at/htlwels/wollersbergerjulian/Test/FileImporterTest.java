package at.htlwels.wollersbergerjulian.Test;

import java.util.StringTokenizer;
import at.htlwels.wollersbergerjulian.FileImporter;

public class FileImporterTest {

	public FileImporterTest()
	{
		FileImporter test = new FileImporter();
		test.openFile("Test.txt");
		StringTokenizer stringTok = test.makeTokenizer();
		
		while(stringTok.hasMoreTokens())
		{
			String str = stringTok.nextToken();
			System.out.println(str);
		}
		
		
	}
}
