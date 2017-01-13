package at.htlwels.bhit.wollersberger.buecher;

/**
 * Created by Julian on 25.11.2016.
 *
 * A book gets compared by its Title, then by its Author. The Issue is ignored.
 */
public class Book implements Comparable{

    private String author;
    private String title;
    private int issue;

    public Book(String author, String title, int issue) {
        this.author = author;
        this.title = title;
        this.issue = issue;
    }

    @Override
    public String toString() {
        return getAuthor() +": "+ getTitle() +"\t Auflage: "+ getIssue();
    }

    /** A book gets compared by its Title, then by its Author. The Issue is ignored. */
    @Override
    public int compareTo(Object o) {
        if(o==null || o.getClass()!=getClass())
            return -1;

        Book book = (Book)o;
        int i = getTitle().compareTo(book.getTitle());
        if(i!=0)
            return i;
        else
            i = getAuthor().compareTo(book.getAuthor());

        return i;
    }

    /** Generates Hash based on Author and Title. */
    @Override
    public int hashCode()
    {
        return getAuthor().hashCode() + getTitle().hashCode();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

}
