package at.htlwels.bhit.wollersberger.zugfahrplan.traintimetable;

import at.htlwels.bhit.wollersberger.zugfahrplan.util.Zufallsnamen;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Julian Wollersberger on 16.12.2016.
 */
public class Train {

    private String name;
    private TreeMap<Time, Stop> stops = new TreeMap<>();

    public Train(String name) {
        this.name = name;
    }

    /** Creates a train with a random number of Stops [1;10] all with
     * random testing values.
     */
    public Train()
    {
        Zufallsnamen zfn = new Zufallsnamen();
        name = zfn.Vorn();
        /* Counts downwards from a random number to 1*/
        for (int i = new Zufallsnamen().Zahl(1,10); i > 0; i--) {
            addStop(new Stop());
        }
    }

    /**Insert Stop (with Station, Platform and Time)
     * @return true if the Stop didn't exist in the List before, else false when one
     * got overwritten */
    public boolean addStop(Stop stop)
    {
        /* Put Returns:
         * the previous value associated with key, or null if there was no
         * mapping for key. (A null return can also indicate that the map
         * previously associated null with key.) */
        if(null==stops.put(stop.getTime(), stop))
            return true;
        else
            return false;
    }


    /** Gets the first Stop of the Train
     * @return the first Stop of the Train */
    public Stop getFirstStop()
    {
        return stops.firstEntry().getValue();
    }
    /** Getter for the last Stop */
    public Stop getLastStop()
    {
        return stops.lastEntry().getValue();
    }
    //TODO Getter for all Stops in timed order
    //TODO Getter for Set of Stops after a given Station

    /** Makes a String in the format:
     * Trainname (firstStationName - lastStationName)\n
     * \t   [Stop 1] \n
     * \t   [Stop 2] \n */
    @Override
    public String toString()
    {
        String s = name +" ("+ getFirstStop().getStation() +" - "+ getLastStop().getStation() +")\n";
        for(Map.Entry e : stops.entrySet())
        {
            s += '\t'+ e.getValue().toString() +'\n';
        }

        return s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeMap<Time, Stop> getStops() {
        return stops;
    }

    public void setStops(TreeMap<Time, Stop> stops) {
        this.stops = stops;
    }
}
