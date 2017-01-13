package at.htlwels.wollersbergerjulian;

import java.util.TreeSet;

/**
 * Created by Julian Wollersberger on 16.12.2016.
 *
 * This is the heart of the Program.
 * It imports, sorts and analyzes the Urls from the file.
 */
public class ListManager {

    TreeSet<Url> urlSet;

    public ListManager()
    {
        urlSet = new TreeSet<>();
        /* Read the input File */
        //new FileImporter("noscript_dns.log", urlSet);
        new FileImporter("noscript_dns - Kopie.log", urlSet);
        //new FileExporter().simplyWrite("SimplyWrite.txt", urlSet);

        //new FileExporter().simplyWrite("WriteReverse.txt", urlSet);
        //new FileExporter().writeAndDeleteDoubles("WriteDom.txt", "d", urlSet);
        new FileExporter().writeAndDeleteDoubles("WriteTopDom.txt", "t.d", urlSet);
    }
}
