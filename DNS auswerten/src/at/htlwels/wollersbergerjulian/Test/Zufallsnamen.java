package at.htlwels.wollersbergerjulian.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Random;

/**
 * @author Julian Wollersberger
 * @date 11. November 2016
 * @version 3.0
 * 
 * Enth�lt Methoden, die zuf�llige Namen, Adressen,... f�r z.B. 
 * Testausgaben erzeugen. Diese werden aus jewiligen Listen 
 * ausgew�hlt.
 * Aus dem C-Programm Sch�lerverwaltung kopiert und angepasst
 */
public class Zufallsnamen {
	
	private static Random rand = new Random();
	
	/* Liste aller m�glichen Namen/Werte */
	private static final String nachnamen[] = {"Wollersberger", "P�hringer", "Sieberer", "Krammer", "Klammer", "Arthofer", "Bierbarb�rbel", "Gruber", "Aslanidis", "Der Gro�e"};
	private static final String vornamen[] = {"Julian", "Lukas", "Daniel", "Manuel", "Barbara", "Beides", "Marin", "Mario", "Jakob", "Nicola", "Alex"};
	private static final String strassen[] = {"Johanna-Dorn-Weg", "Lindenweg", "Linzer Stra�e", "Schnellstra�e", "Schmelzingweg"};
	private static final String orte[] = {"Wernstein", "Sch�rding", "Wels", "Thalheim", "Drentadatraun", "London", "Buxdihudicity", "Ort", "Pettenbach", "Irgendwo"};
	
	/** Konstruktor, der den RNG initialisiert */
	public Zufallsnamen()
	{
		rand =  new Random();
	}
	
	/** Gibt Zufallszahl zwischen 2 Werten (inklusiv) zur�ck.
	 *  @param min Kleinster Wert
	 *  @param max Gr��ter Wert
	 *  @return Zufallszahl zwischen 2 Werten (inklusiv) */
	public int Zahl(int min, int max)
	{
		return rand.nextInt(max - min + 1) + min;
	}
	
	/** Gibt eine Hausnummer von 1 bis 99 zur�ck.
	 * @return Hausnummer als int */
	public int Hausnr()
	{
		return rand.nextInt(99) + 1;
	}
	
	/** Gibt Vierstellige Postleitzahl von 1000 bis 9999 zur�ck
	 * @return Vierstellige Postleitzahl als int*/
	public int Plz()
	{
		return rand.nextInt(9000) + 1000;
	}
	
	/** Gibt einen zuf�llig ausgew�hlten Nachnamen aus der Liste aus. 
	 * @return Nachname als String */
	public String Nachn()
	{
		return nachnamen[rand.nextInt(nachnamen.length)];
	}
	/** Gibt einen zuf�llig ausgew�hlten Vornamen aus der Liste aus.
	 * @return Vorname als String */
	public String Vorn()
	{
		return vornamen[rand.nextInt(vornamen.length)];
	}
	/** Gibt einen zuf�llig ausgew�hlten Stra�ennamen aus der Liste aus. 
	 * @return Stra�e als String */
	public String Strasse()
	{
		return strassen[rand.nextInt(strassen.length)];
	}
	/** Gibt einen zuf�llig ausgew�hlten Ortsnamen aus der Liste aus. 
	 * @return Ort als String */
	public String Ort()
	{
		return orte[rand.nextInt(orte.length)];
	}
	
	/** Gibt ein zul�lliges Datum vom 1.1.1970 bis zum 
	 * 30.12.2016, vobei jeder Monat von inklusiv 1. bis 30. geht. 
	 * @return LocalDate */
	public LocalDate Datum()
	{				
		return LocalDate.of(this.Zahl(1970, 2016), Zahl(1, 12), Zahl(1, 30));
	}
}
