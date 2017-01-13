package at.htlwels.bhit.wollersberger.zugfahrplan.traintimetable;

import at.htlwels.bhit.wollersberger.zugfahrplan.util.Zufallsnamen;

/**
 * Created by Julian Wollersberger on 16.12.2016.
 */
public class Stop {

    private Time time;
    private int platform;
    private Station station;

    /** Constructor with all fields (time, platform and station) */
    public Stop(Time time, int platform, Station station) {
        this.time = time;
        this.platform = platform;
        this.station = station;
    }

    /** Constructor with random testing values */
    public Stop()
    {
        Zufallsnamen zfn = new Zufallsnamen();
        this.time = new Time();
        this.platform = zfn.Zahl(1, 5);
        this.station = new Station();
    }

    @Override
    public String toString() {
        return time +" "+ station +" ("+ platform +")";
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
