package at.htlwels.wollersbergerjulian;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.TreeSet;

/**
 * Created by Julian Wollersberger on 16.12.2016.
 *
 * Displays and exports the urls in many different ways. First, it
 * gets written in a file and then displayed.
 * 1. Simply write the content of UrlSet to a file.
 */
public class FileExporter {

    /*File file;

    public FileExporter(String path) {
        openFile(path);
    }*/
    public FileExporter() {
    }

    public void write(String path, String outputPattern, TreeSet<Url> urlSet)
    {
        FileOutputStream stream = openStream(path);
        try {
            for (Url url:urlSet) {
                stream.write((url.toString()+"\r\n").getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        urlSet.forEach(System.out::println);
    }

    /**Write the Urls in the standard format "u.s.d.t" in the File path. */
    public void simplyWrite(String path, TreeSet<Url> urlSet)
    {
        write(path, "u.s.d.t", urlSet);
    }
    /**Write the Urls in reverse order "t.d.s.u" in the File path. */
    public void reverseWrite(String path, TreeSet<Url> urlSet)
    {
        write(path, "t.d.s.u", urlSet);
    }

    /**This method is for listing the Urls in a format where not all domain parts are
     * used. write() would list some entrys double, especially in "t.d". This doesn't.
     * All the entries will be sorted alphabeticly and not in the standard "t.d.s.u" order. */
    public void writeAndDeleteDoubles(String path, String outputPattern, TreeSet<Url> urlSet)
    {
        /* Convert each Url to a String and sort them in a TreeSet.
        * This will delete doubles and list them alphabeticly, not the usual order. */
        TreeSet<String> tree = new TreeSet<>();
        for (Url url:urlSet) {
            tree.add(url.toString(outputPattern));
        }

        /* Write to file */
        FileOutputStream stream = openStream(path);
        try {
            for (String str:tree) {
                stream.write((str +"\r\n").getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Print to screen */
        tree.forEach(System.out::println);

    }

    //TODO Open a Window to choose a File
    /**Opens the file behind Path in the field file. */
    public FileOutputStream openStream(String path)
    {
        try {
            return new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
