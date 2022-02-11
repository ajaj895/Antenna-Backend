package edu.wiu.antenna.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class AMScan {

    static LinkedList<AmStation> amStations = new LinkedList<>();

    /**
     * Returns a LinkedList<AmStation> object that contains all the AM radio stations in North America.
     * Pulls data from the AM-stations.txt
     * @return LinkedList<AmStation> of all AM radio stations in North America.
     */
    public static LinkedList<AmStation> findAm(){
        parseAmList();
        return amStations;
    }

    
    // Returns a Scanner object of the AM-stations.txt
    // Throws a FileNotFound exception if the AM-stations.txt is not found.
    private static Scanner getAmSc() throws FileNotFoundException {
        String fileName = "AM-stations.txt";
        File amFile = new File(fileName);
        Scanner amSc = new Scanner(amFile); // This causes filenotfound exception
        return amSc;
    }

    // Parses the AM-stations.txt file and scrapes the data for AM radio stations.
    // Every 15 reads creates an AmStation object.
    private static void parseAmList(){
        Scanner sc = null;
        try {
            sc = getAmSc();
            sc.useDelimiter("\\|");
            short loc = 0;
            String[] StationArr = new String[15];
            AmStation curr;
            while (sc.hasNext()) {

                String current = sc.next();
                switch (loc) {
                    case 0:
                        //Callsign
                        System.out.print(current + " ");
                        StationArr[0] = current;
                        break;
                    case 1:
                        //Frequency
                        System.out.print(current + " ");
                        StationArr[1] = current;
                        break;
                    case 5:
                        //Type (day/night/unlimited)
                        System.out.print(current + " ");
                        StationArr[2] = current;
                        break;
                    case 9:
                        //city
                        System.out.print(current + " ");
                        StationArr[3] = current;
                        break;
                    case 10:
                        //state
                        System.out.print(current + " ");
                        StationArr[4] = current;
                        break;
                    case 11:
                        //country
                        System.out.print(current + " ");
                        StationArr[5] = current;
                        break;
                    case 13:
                        //power
                        System.out.print(current + " ");
                        StationArr[6] = current;
                        break;
                    case 18:
                        //Latitude direction
                        System.out.print(current + " ");
                        StationArr[7] = current;
                        break;
                    case 19:
                        //Latitude degrees
                        System.out.print(current + " ");
                        StationArr[8] = current;
                        break;
                    case 20:
                        //Latitude minutes
                        System.out.print(current + " ");
                        StationArr[9] = current;
                        break;
                    case 21:
                        //Latitude seconds
                        System.out.print(current + " ");
                        StationArr[10] = current;
                        break;
                    case 22:
                        //Longitude direction
                        System.out.print(current + " ");
                        StationArr[11] = current;
                        break;
                    case 23:
                        //Longitude degrees
                        System.out.print(current + " ");
                        StationArr[12] = current;
                        break;
                    case 24:
                        //Longitude minutes
                        System.out.print(current + " ");
                        StationArr[13] = current;
                        break;
                    case 25:
                        //Longitude seconds
                        System.out.println(current);
                        StationArr[14] = current;
                        curr = newStation(StationArr);
                        amStations.add(curr);
                        break;

                }

                if (current.length() == 1) { // Each radio station is separated by one space.
                    loc = 0;
                } else {
                    loc++;
                }
                //System.out.println(sc.next());
            }

        } catch (FileNotFoundException e) { //Only if the AM-station.txt isn't found.
            e.printStackTrace();
            System.err.println("AM-stations.txt not found!");
        }

    }

    /**
     * Returns a LinkedList<AmStation> of all the AM radio stations found in AM-station.txt
     * @return LinkedList<AmStation> a list of all the AM stations in North America.
     */
    public static LinkedList getAmList(){
        return amStations;
    }

    /**
     * Creates and returns an AmStation object.
     * @param am the array of size 15 of the AM-Station data in the following format: callsign, Freq, mode, city, state, country, power, latitude direction (n/s), latitude degree, latitude minute, latitude second, longitude direction (e/w), latitude degree, latitude minute, latitude second.
     * @return AmStation a new AM radio station object.
     */
    public static AmStation newStation(String[] am){
        return makeStation(am);
    }

    // Creates the AmStation object.
    // This will verify the data too
    private static AmStation makeStation(String[] am){
        //Initialization
        String cs;
        short frequency;
        byte mode;
        String city;
        String state;
        String country;
        float power;
        boolean latDir;
        int latDeg;
        int latMin;
        double latSec;
        boolean lngDir;
        int lngDeg;
        int lngMin;
        double lngSec;

        //Testing phase
        cs = am[0];
        try{
            frequency = Short.parseShort(am[1].substring(0,4)); // The first 4 digits
        } catch(NumberFormatException e) {
            //This means its only three digits (or bad)
            frequency = Short.parseShort(am[1].substring(0,3)); // The first 3 digits
        }
        //type is: 0 - unlimited, 1 - daytime, 2 - nighttime
        if(am[2].equalsIgnoreCase("unlimited")){
            mode = 0;
        } else if(am[2].equalsIgnoreCase("daytime")){
            mode = 1;
        } else {
            mode = 2;
        }
        city = am[3];
        state = am[4];
        country = am[5];
        power = Float.parseFloat(am[6].substring(0,5));
        //latitude - N/S (true for north, false for south), longitude - E/W (true for east, false for west)
        //gps coords are denoted as (direction) (degrees)*(minutes)'(seconds)"
        if(am[7].equalsIgnoreCase("N")){
            latDir = true;
        } else {
            latDir = false;
        }
        //Latitude Degree
        try {
            latDeg = Integer.parseInt(am[8]);
        } catch(NumberFormatException e){
            //This means that its a 2 digit lat
            try {
                latDeg = Integer.parseInt(am[8].substring(0, 2));
            } catch(NumberFormatException f){
                //Means that it is a 1 digit
                latDeg = Integer.parseInt(am[8].substring(0, 1));
            }
        }
        //Latitude Minutes
        try {
            latMin = Integer.parseInt(am[9]);
        } catch(NumberFormatException e){
            //This means that its a 2 digit lat
            try {
                latMin = Integer.parseInt(am[9].substring(0, 2));
            } catch(NumberFormatException f){
                //Means that it is a 1 digit
                latMin = Integer.parseInt(am[9].substring(0, 1));
            }
        }
        //Latitude Seconds
        latSec = Double.parseDouble(am[10]);

        if(am[11].equalsIgnoreCase("E")){
            lngDir = true;
        } else {
            lngDir = false;
        }
        //Longitude Degrees
        try {
            lngDeg = Integer.parseInt(am[12]);
        } catch(NumberFormatException e){
            //Means it's two digits
            try {
                lngDeg = Integer.parseInt(am[12].substring(0, 2));
            } catch(NumberFormatException f){
                //Means that it is a 1 digit
                lngDeg = Integer.parseInt(am[12].substring(0, 1));
            }
        }
        //Longitude Minutes
        try {
            lngMin = Integer.parseInt(am[13]);
        } catch(NumberFormatException e){
            //Means that is is 2 digits
            try {
                lngMin = Integer.parseInt(am[13].substring(0, 2));
            } catch(NumberFormatException f){
                //Means that it is a 1 digit
                lngMin = Integer.parseInt(am[13].substring(0, 1));
            }
        }
        //Longitude Seconds
        try {
            lngSec = Double.parseDouble(am[14]);
        } catch(NumberFormatException e){
            //Could be empty
            lngSec = 0;
        }
        return new AmStation(cs, frequency, mode, city, state, country, power, latDir, latDeg, latMin, latSec, lngDir,
                lngDeg, lngMin, lngSec);
    }

}
