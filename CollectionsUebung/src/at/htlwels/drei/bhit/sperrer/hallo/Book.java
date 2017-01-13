package at.htlwels.drei.bhit.sperrer.hallo;

/**
 * Created by Sperrer Daniel on 25.11.2016.
 */
public class Book implements Comparable{

    private String author;
    private String title;
    private Integer issue;

    public Book(String author,String title,Integer issue)
    {
        this.author=author;
        this.title=title;
        this.issue=issue;
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

    public Integer getIssue() {
        return issue;
    }

    public void setIssue(Integer issue) {
        this.issue = issue;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || getClass() != o.getClass()) return -1;

        Book book = (Book) o;
        int i =author.compareTo(book.author);
        if(i != 0) return i;

        i = title.compareTo(book.title);
        if(i != 0) return i;

        i = issue.compareTo(book.issue);
        if(i != 0) return i;

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!getAuthor().equals(book.getAuthor())) return false;
        if (!getTitle().equals(book.getTitle())) return false;
        return getIssue().equals(book.getIssue());

    }

    @Override
    public int hashCode() {
        int result = getAuthor().hashCode();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getIssue().hashCode();
        return result;
    }
}
