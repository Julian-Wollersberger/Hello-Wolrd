package at.htlwels.bhit.wollersberger.zugfahrplan.traintimetable;

import at.htlwels.bhit.wollersberger.zugfahrplan.util.Zufallsnamen;

/**
 * Created by Julian Wollersberger on 16.12.2016.
 */
public class Station {

    private String name;

    /** Constructor with the name */
    public Station(String name) {
        this.name = name;
    }

    /** Constructor with random testing values.
     * The name is a just a place name. */
    public Station()
    {
        Zufallsnamen zfn = new Zufallsnamen();
        name = zfn.Ort();
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
