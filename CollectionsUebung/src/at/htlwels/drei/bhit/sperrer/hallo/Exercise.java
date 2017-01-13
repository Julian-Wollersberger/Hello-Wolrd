package at.htlwels.drei.bhit.sperrer.hallo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by sperr on 25.11.2016.
 */
public class Exercise {

    public Book[] books = new Book[6];

    public Exercise()
    {
        for(int i=0;i<6;i++)
        {
            books[i]=new Book("author"+i,"title"+i,i*666);
        }
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Book[] part(int nr,Book[] books)
    {
        if(nr==6)
        {
            int i=0;
            ArrayList<Book> al = new ArrayList<Book>();
            Iterator<Book> itera= al.iterator();

            while(i<6)
                al.add(books[i++]);

            TreeSet<Book> ts= new TreeSet<Book>(al);
            Iterator<Book> itert= ts.iterator();

            while(itert.hasNext())
            {
                System.out.println(itert.next());
            }
        }
        return books;
    }


}
