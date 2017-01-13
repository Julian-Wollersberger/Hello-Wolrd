package at.htlwels.wollersbergerjulian.Test;

import at.htlwels.wollersbergerjulian.Url;

import java.text.ParseException;

/**Tests the Url Class. */
public class UrlTest {

	public UrlTest()
	{
		valid();
		System.out.println("\n\n\t Does OutputPattern work?");
		outputPattern();
	}

	private void outputPattern()
	{
		//Url.setOutputPattern("u.s.d.t");
		print("s1.www.beides.at");
		print("www.beides.at");
		print("beides.at");

		//Url.setOutputPattern("t.d.s.u");
		print("s1.www.beides.at");
		print("www.beides.at");
		print("beides.at");


	}

	/** Converts the string into a Url and then
	 * outputs Url.toString() while handling the parseException. */
	private void print(String str)
	{
		try {
			System.out.println("Yop "+ new Url(str));
		} catch (ParseException e) {
			System.out.println("Nop "+ str);
		}
	}

	/**Tests if different strings give valid Urls. */
	private void valid()
	{
		System.out.println(new Url()); //Valid
		print("asd.f.93748.beides.net"); //Valid
		print(""); //invalid
		print(".net"); //invalid
		print("b.a"); //valid
		print(".d.c"); //invalid
	}

}
