package de.exxcellent.challenge;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.management.MBeanAttributeInfo;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        String dayWithSmallestTempSpread="Failed";
        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        // Your preparation code …
        
        
/* n    Hier ist der erste Versuch, aufgeteilt in zwei Methoden
        Controller controll = new Controller();

        try {
            controll.extractDayMinMax();
            controll.extractInfoFootball();
            dayWithSmallestTempSpread = controll.getDaySmallestSpreadWeather(); //Alternativ highest
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
            teamWithSmallestGoalSpread = controll.getDaySmallestSpreadFootball();
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
*/      
        String filepathWeather = "programming-challenge-challenge-weatherdata\\src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv";
        String filepathFootbal = "programming-challenge-challenge-weatherdata\\src\\main\\resources\\de\\exxcellent\\challenge\\football.csv";
        methoden start=new methoden();
        try {
            
            start.sortieren(filepathWeather, 0, 1, 2);
            dayWithSmallestTempSpread = start.smallestDiff("Day"); //Alternativ highest
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
            start.sortieren(filepathFootbal, 0, 5, 6);
            teamWithSmallestGoalSpread = start.smallestDiff("Team");
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);

        } catch (Exception e) {
            // TODO: handle exception
        }
        

        
        
    }
}
