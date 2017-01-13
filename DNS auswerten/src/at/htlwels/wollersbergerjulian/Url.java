package at.htlwels.wollersbergerjulian;

import at.htlwels.wollersbergerjulian.Test.Zufallsnamen;

import java.text.ParseException;
import java.util.TreeMap;

/** The Class where a URL gets stored.
 * It consists of three domain levels: Top-level, domain and sub-domain.
 * The sub-domain can contain an empty String but not null.
 * Using the parameter for toString outputPattern the order in which the domain parts
 * will made to a String can be determand*/
public class Url implements Comparable {

	/**
	 * Top-Level Domain
	 */
	private String tld;
	/**
	 * Domain
	 */
	private String dom;
	/**
	 * Sublevel Domain
	 */
	private String sub;
	/**
	 * UnderLevel (SubSublevel) Domain and Subsubsublevel, ...
	 */
	private String uld;

	/**
	 * String gets parsed. When there are not enough
	 * points in the String, not all fields will get a value.
	 *
	 * @param s the string to parse
	 */
	public Url(String s) throws ParseException {
		String rest;
		int index;
		/* Removes empty spaces and line breaks at beginning and end. */
		s = s.trim().toLowerCase();


		/*if(s.startsWith("."))
			throw new ParseException("String begins with dot", 0);
		/*else if(s.contains("***"))
			throw new ParseException("Might be a headline", 0);*/

		index = s.lastIndexOf('.');
		if (index < 0)
			throw new ParseException("Text doesn't contain a Dot and is no Url", 0);
		tld = s.substring(index + 1);
		rest = s.substring(0, index);

		index = rest.lastIndexOf('.');
		dom = rest.substring(index + 1);
		/* Subdomain can be an empty String */
		if (index >= 0) {
			rest = rest.substring(0, index);

			index = rest.lastIndexOf('.');
			sub = rest.substring(index + 1);
			if (index >= 0)
				uld = rest.substring(0, index);
			else
				uld = "";
		} else {
			sub = "";
			uld = "";
		}

	}

	/**
	 * Create some test Urls
	 */
	public Url() {
		Zufallsnamen zfn = new Zufallsnamen();
		tld = zfn.Ort();
		dom = zfn.Vorn();
		sub = zfn.Vorn() + "." + zfn.Vorn();
	}

	@Override
	/** Sorts first after top-level-domain, then after domain
	 *  and if it exists after sub-domain. */
	public int compareTo(Object o) {
		if (o == null || o.getClass() != this.getClass())
			return -1;
		else {
			Url url = (Url) o;
			int comp = 0;

			if ((comp = tld.compareTo(url.tld)) != 0)
				return comp;
			else if ((comp = dom.compareTo(url.dom)) != 0)
				return comp;
			/* Throw lacy evaluation in && it should't throw a NullPointerException */
			else if (sub != null && url.sub != null && (comp = sub.compareTo(url.sub)) != 0)
				return comp;
			else if (uld != null && url.uld != null && (comp = uld.compareTo(url.uld)) != 0)
				return comp;
			else
				return 0;
		}
	}

	/**
	 * Returns the Url as a String. The form depends on the outputPattern.
	 * For example, the standard "u.s.d.t" makes "s1.www.beides.com".
	 * "t.d.s.u" makes "com.beides.www.s1".
	 */
	public String toString(String outputPattern) {
		/* If all domain-parts are in the Url, then normal.
		 * Else just use those which are in the Url. E.g. "d.s" should only
		 * use the domain and subdomain and not display some lines twice.
		if(outputPattern.contains("t") && outputPattern.contains("d") &&
				outputPattern.contains("s") && outputPattern.contains("u") )
		{*/
		String str = "";
		String temp;

		TreeMap<Character, String> map = new TreeMap<>();
		map.put('t', tld);
		map.put('d', dom);
		map.put('s', sub);
		map.put('u', uld);

		/* For every character you look if it is one of the placeholders
		* for tld, dom or sub. If so, write it into the String.
		* A Map is good for this because the letter in the OutputPatter
		* is the Key in the Map and the Value is the domain part.*/
		for (int i = 0; i < outputPattern.length(); i++) {
			temp = map.get(outputPattern.charAt(i));
			if (temp != null) {
				/* For the sub-domain: If it is empty the next dot will be skiped. */
				if (temp.equals(""))
					i++;
				else
					str += temp;
			}
			/* If it was a dot or something else it gets just added. */
			else
				str += outputPattern.charAt(i);
		}

		/* Delete a trailing dot. */
		if (str.endsWith("."))
			str = str.substring(0, str.length() - 1);

		return str;
	}

	@Override
	/**A simple toString that makes the Pattern "u.s.d.t*/
	public String toString() {
		/* If there is no subdomain it shouldn't add a dot in front. */
		if (sub != null && uld != null)
			return uld + "." + sub + "." + dom + "." + tld;
		else if (sub != null)
			return sub + "." + dom + "." + tld;
		else
			return dom + "." + tld;
	}
}
