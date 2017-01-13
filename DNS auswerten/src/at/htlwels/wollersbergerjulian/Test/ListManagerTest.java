package at.htlwels.wollersbergerjulian.Test;

import at.htlwels.wollersbergerjulian.Url;
import java.util.TreeSet;

/**
 * Created by Julian Wollersberger on 16.12.2016.
 */
public class ListManagerTest {

    public ListManagerTest() {

        TreeSet<Url> urlSet = new TreeSet<>();
        for (int i = 0; i < 20; i++) {
            urlSet.add(new Url());
        }
        urlSet.forEach(System.out::println);
    }
}
