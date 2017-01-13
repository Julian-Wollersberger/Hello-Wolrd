package at.htlwels.bhit.wollersberger.zugfahrplan.traintimetable;

import at.htlwels.bhit.wollersberger.zugfahrplan.util.Zufallsnamen;

import java.util.Comparator;

/**
 * Created by Julian Wollersberger on 16.12.2016.
 */
public class Time implements Comparable{

    private int minute;
    private int hour;

    /** Constructor with all fields (hour and minute) */
    public Time(int hour, int minute) {
        this.minute = minute;
        this.hour = hour;
    }

    /** Constructor with random testing values. */
    public Time()
    {
        Zufallsnamen zfn = new Zufallsnamen();
        hour = zfn.Zahl(0, 23);
        minute = zfn.Zahl(0,59);
    }

    @Override
    public String toString() {
        return getHour() +":"+ getMinute();
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public int compareTo(Object o) {
        if ((o == null) || (o.getClass() != getClass()))
            return -1;

        Time obj = (Time)o;
        int i = getHour() - obj.getHour();

        if (i != 0)
            return i;
        else
            i = getHour() - obj.getHour();

        return i;

    }
}
