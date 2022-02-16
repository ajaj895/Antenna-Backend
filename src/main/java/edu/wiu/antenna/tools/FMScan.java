/*
 * Written by: Evan C. 
 * Created: Spring 2021
 * Last updated: February 15, 2022 
*/

package edu.wiu.antenna.tools;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;

import java.io.IOException;

public class FMScan {

    static LinkedList<FmStation> fmStations = new LinkedList<>();

    /**
     * findFm parses the FM-stations.txt in the project directory for all FM radio stations in North America and returns them as a linked list.
     * @return LinkedList<FmStation> containing the entire list of FM Radio Stations in North America.
     */
    public static LinkedList<FmStation> findFm(){
        // TODO: The website is too slow for jsoup. May have to try wget script and text file parsing.
        parseFmList();
        return fmStations;
    }

    // For reading the file
    private static Scanner getFmSc() throws FileNotFoundException {
        String fileName = "FM-stations.txt";
        File fmFile = new File(fileName);
        Scanner fmSc = new Scanner(fmFile); // This causes filenotfound exception
        return fmSc;
    }

    // For parsing the data in the FM-stations.txt file.
    private static void parseFmList(){
        Scanner sc = null;
        try {
            sc = getFmSc();
            sc.useDelimiter("\\|");
            short loc = 0;
            String[] StationArr = new String[16];
            FmStation curr;
            while(sc.hasNext()){
                String current = sc.next();
                switch (loc){
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

                    case 4:
                        //Directional (DA) or non-directional antenna (ND)
                        System.out.print(current + " ");
                        StationArr[2] = current;
                        break;
                    case 6:
                        //Power Class (A, B1, B, C3, C2, C1, C0, C) = 0, 1, 2, 3, 4, 5, 6, 7 respectivly.
                        System.out.print(current + " ");
                        StationArr[3] = current;
                        break;
                    case 9:
                        //city
                        System.out.print(current + " ");
                        StationArr[4] = current;
                        break;
                    case 10:
                        //state
                        System.out.print(current + " ");
                        StationArr[5] = current;
                        break;
                    case 11:
                        //country
                        System.out.print(current + " ");
                        StationArr[6] = current;
                        break;
                    case 13:
                        //power
                        System.out.print(current + " ");
                        StationArr[7] = current;
                        break;
                    case 18:
                        //Latitude direction
                        System.out.print(current + " ");
                        StationArr[8] = current;
                        break;
                    case 19:
                        //Latitude degrees
                        System.out.print(current + " ");
                        StationArr[9] = current;
                        break;
                    case 20:
                        //Latitude minutes
                        System.out.print(current + " ");
                        StationArr[10] = current;
                        break;
                    case 21:
                        //Latitude seconds
                        System.out.print(current + " ");
                        StationArr[11] = current;
                        break;
                    case 22:
                        //Longitude direction
                        System.out.print(current + " ");
                        StationArr[12] = current;
                        break;
                    case 23:
                        //Longitude degrees
                        System.out.print(current + " ");
                        StationArr[13] = current;
                        break;
                    case 24:
                        //Longitude minutes
                        System.out.print(current + " ");
                        StationArr[14] = current;
                        break;
                    case 25:
                        //Longitude seconds
                        System.out.println(current);
                        StationArr[15] = current;
                        curr = newStation(StationArr);
                        fmStations.add(curr);
                        break;
                }

                if(current.length() == 1){ // Each radio station is separated by one space.
                    loc = 0;
                } else {
                    loc++;
                }

            }

        } catch (FileNotFoundException e) { // Only thrown if getFmSc() does not find FM-stations.txt
            e.printStackTrace();
            System.err.println("FM-stations.txt not found!");
        }
    }

    /**
     * newStation creates a FmStation object and returns it.
     * @param fm A String[] of size 16 representing all the data needed to make the Fm Station
     * (callsign, frequency, city, state, country, directional, class, power, latitude direction, lat degrees, lat minutes, lat seconds, longitude direction, long degrees, long minutes, long seconds).
     * @return FmStation object representing the new FM radio station.
     */
    public static FmStation newStation(String[] fm){
        return makeStation(fm);
    }

    // newStation() constructor.
    private static FmStation makeStation(String[] fm){
        //Initialization
        String cs;
        Float frequency;
        String city;
        String state;
        String country;
        boolean directional;
        short cl; // FM classes (A, B1, B, C3, C2, C1, C0, C, D, LP1) = 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 respectivly.
        //Note: The fcc has class station ranges here: https://www.fcc.gov/media/radio/fm-station-classes
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
        cs = fm[0];
        try {
            frequency = Float.parseFloat(fm[1].substring(0, 4));
        } catch(NumberFormatException e) {
            //This means it's a smaller frequency (three digits)
            frequency = Float.parseFloat(fm[1].substring(0, 3));
        }

        city = fm[2];
        state = fm[3];
        country = fm[4];

        if(fm[5].equalsIgnoreCase("DA")){ // Directional
            directional = true;
        } else { // Nondirectional
            directional = false;
        }

        //Class switch
        switch(fm[6]) {
            case "A":
                cl = 0;
                break;
            case "B1":
                cl = 1;
                break;
            case "B":
                cl = 2;
                break;
            case "C3":
                cl = 3;
                break;
            case "C2":
                cl = 4;
                break;
            case "C1":
                cl = 5;
                break;
            case "C0":
                cl = 6;
                break;
            case "C":
                cl = 7;
                break;
            case "D":
                cl = 8;
                break;
            default: //LOW POWER Radio stations
                cl = 9;
                break;
        }

        //Not effecient but it works.
        try {
            power = Float.parseFloat(fm[7].substring(0, 4));
        } catch(NumberFormatException e) {
            try {
                power = Float.parseFloat(fm[7].substring(0, 3));
            } catch(NumberFormatException r) {
                try {
                    power = Float.parseFloat(fm[7].substring(0, 2));
                } catch(NumberFormatException t) {
                    power = (float) 0.76; //random variable
                }
            }
        }

        if(fm[8].equalsIgnoreCase("N")){ // North = true, south = false
            latDir = true;
        } else {
            latDir = false;
        }

        //Latitude Degree
        try {
            latDeg = Integer.parseInt(fm[9]);
        } catch(NumberFormatException e){
            //This means that its a two digit lat
            try {
                latDeg = Integer.parseInt(fm[9].substring(0, 2));
            } catch(NumberFormatException f){
                //Means that it is a one digit
                try {
                    latDeg = Integer.parseInt(fm[9].substring(0, 1));
                } catch(NumberFormatException g){
                    //Default value
                    latDeg = 0;
                }
            }
        }

        //Latitude Minutes
        try {
            latMin = Integer.parseInt(fm[10]);
        } catch(NumberFormatException e){
            //This means that its a two digit lat
            try {
                latMin = Integer.parseInt(fm[10].substring(0, 2));
            } catch(NumberFormatException f){
                //Means that it is a one digit
                try {
                    latMin = Integer.parseInt(fm[10].substring(0, 1));
                } catch(NumberFormatException g){
                    latMin = 0;
                }
            }
        }
        //Latitude Seconds
        try {
            latSec = Double.parseDouble(fm[11]);
        } catch(NumberFormatException e){
            //This means that its a two digit lat
            try {
                latSec = Double.parseDouble(fm[11].substring(0, 2));
            } catch(NumberFormatException f){
                //Means that it is a one digit
                try {
                    latSec = Double.parseDouble(fm[11].substring(0, 1));
                } catch(NumberFormatException g){
                    latSec = 0;
                }
            }
        }

        if(fm[12].equalsIgnoreCase("E")){ //Longitude = true for east, or false for west.
            lngDir = true;
        } else {
            lngDir = false;
        }
        //Longitude Degrees
        try {
            lngDeg = Integer.parseInt(fm[13]);
        } catch(NumberFormatException e){
            //Means it's two digits
            try {
                lngDeg = Integer.parseInt(fm[13].substring(0, 2));
            } catch(NumberFormatException f){
                //Means that it is a one digit
                try {
                    lngDeg = Integer.parseInt(fm[13].substring(0, 1));
                } catch (NumberFormatException g){
                    lngDeg = 0;
                }
            }
        }
        //Longitude Minutes
        try {
            lngMin = Integer.parseInt(fm[14]);
        } catch(NumberFormatException e){
            //Means that is is two digits
            try {
                lngMin = Integer.parseInt(fm[14].substring(0, 2));
            } catch(NumberFormatException f){
                //Means that it is a one digit
                try {
                    lngMin = Integer.parseInt(fm[14].substring(0, 1));
                } catch (NumberFormatException g){
                    lngMin = 0;
                }
            }
        }
        //Longitude Seconds
        try {
            lngSec = Double.parseDouble(fm[15]);
        } catch(NumberFormatException e){
            //Could be empty
            lngSec = 0;
        }

        return new FmStation(cs, frequency, city, state, country, directional, cl, power, latDir, latDeg, latMin,
                latSec, lngDir, lngDeg, lngMin, lngSec);


    }
}
