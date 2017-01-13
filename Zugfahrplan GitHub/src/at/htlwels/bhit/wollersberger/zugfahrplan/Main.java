package at.htlwels.bhit.wollersberger.zugfahrplan;

import at.htlwels.bhit.wollersberger.zugfahrplan.test.TrainTest;
import at.htlwels.bhit.wollersberger.zugfahrplan.traintimetable.Station;
import at.htlwels.bhit.wollersberger.zugfahrplan.traintimetable.Stop;
import at.htlwels.bhit.wollersberger.zugfahrplan.traintimetable.Time;
import at.htlwels.bhit.wollersberger.zugfahrplan.traintimetable.Train;

/**
 * Created by Julian Wollersberger on 16.12.2016.
 *
 * With this program one can create a fancy Timetable for Trains, Stops, and Stations.
 */
public class Main {

    public static void main (String[] args)
    {
        //new TrainTest();

        Train train1 = new Train("Gesprächspartner");
        train1.addStop(new Stop(new Time(13,45), 1, new Station("Aufstehen")));
        train1.addStop(new Stop(new Time(14,10), 4, new Station("Mittagessen")));
        train1.addStop(new Stop(new Time(18,00), 3, new Station("Fertig programmieren")));
        System.out.println(train1);

        System.out.println(new Train());
        System.out.println(new Train());
        System.out.println(new Train());
        System.out.println(new Train());
        System.out.println(new Train());
    }
}
