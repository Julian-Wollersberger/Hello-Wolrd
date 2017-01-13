package at.htlwels.bhit.wollersberger.buecher;

import java.util.*;

/** Beispiel 13.8 Aus dem Buch bis zut Nummer 6.*/
public class Exercise {

    public static void main(String[] args) {

        System.out.println("Alles wird nach der Straße geordnet, dann nach Autor. ");
        Book[] buecher = new Book[6];
        Zufallsnamen zfn = new Zufallsnamen();

        for(int i=0; i<6; i++)
        {
            buecher[i] = new Book(zfn.Nachn(), zfn.Strasse(), zfn.Zahl(1, 1000));
        }

        //part6(buecher);
        //part7(buecher);
        part8(buecher);
    }

    private static void part8(Book[] array)
    {
        /* Its Magic. The Content of array gets added strait away. */
        HashSet<Book> pikachu = new HashSet<>(Arrays.asList(array));

        pikachu.forEach(System.out::println);
        /* This was the magical short form for this: */
        /*for (Book book : pikachu)
            System.out.println(book);*/

        /* Adding an existing shouldn't be possible */
        System.out.println("\n Existierendes Element hinzufügbar?\n"+ pikachu.add(array[3]));


        /* And now again with a TreeSet */
        TreeSet<Book> wuffels = new TreeSet<>();
        /* My code works and I have no idea why. */
        pikachu.forEach(wuffels::add);
        System.out.println("\n Schon wieder sortiert!");
        wuffels.forEach(System.out::println);


        /* Backwards sorted */
        System.out.println("\n Sorted Backwards!");
        ArrayList<Book> beides = new ArrayList<>(wuffels);
        ListIterator<Book> iter = beides.listIterator(beides.size());

        while (iter.hasPrevious())
            System.out.println(iter.previous());
    }

    private static void part7(Book[] array)
    {
        /* New Hashmap with an Int as Key and Book as Value. */
        HashMap<Integer, Book> hmap = new HashMap<>();

        /* feed HashMap */
        for (int i = 0; i < array.length; i++) {
            hmap.put(i,array[i]);
        }

        /* Print all */
        for(Map.Entry entry : hmap.entrySet())
            System.out.println(entry.getValue().toString());

        /* Now as a TreeMap */
        TreeMap<Integer, Book> halali = new TreeMap<>(hmap);

        /* Print all */
        System.out.println("\n Doch nicht sortiert! ");
        for(Map.Entry entry : halali.entrySet())
            System.out.println(entry.getValue().toString());

    }

    public static void part6(Book[] array)
    {
        /* Ich bin ein Pirat! */
        ArrayList<Book> arrr = new ArrayList<>();

        /* This is magic what IntelliJ suggested! */
        arrr.addAll(Arrays.asList(array));

        for (Book book : arrr)
        {
            System.out.println(book.toString());
        }

        /* Sortiert*/
        System.out.println("\n  Sortiert!");
        TreeSet<Book> sortiert = new TreeSet<>(arrr);
        for (Book book : sortiert)
        {
            System.out.println(book.toString());
        }


        /* Sortiert */
        System.out.println("\n  Rückwärts!");
        Iterator<Book> iter = sortiert.descendingIterator();
        while (iter.hasNext())
        {
            System.out.println(iter.next());
        }

    }
}
