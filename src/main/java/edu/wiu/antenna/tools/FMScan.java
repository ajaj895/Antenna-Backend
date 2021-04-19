package edu.wiu.antenna.tools;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

import java.io.IOException;

public class FMScan {



    public static void findFm(){
        // TODO: The website is too slow for jsoup. May have to try wget script and text file parsing.
        parseFmList();
    }

    private static Scanner getFmSc() throws FileNotFoundException {
        String fileName = "FM-stations.txt";
        File fmFile = new File(fileName);
        Scanner fmSc = new Scanner(fmFile); // This causes filenotfound exception
        return fmSc;
    }

    private static void parseFmList(){
        Scanner sc = null;
        try {
            sc = getFmSc();
            sc.useDelimiter("\\|");
            short loc = 0;
            while(sc.hasNext()){
                String[] StationArr = new String[16];
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
                        break;
                }

                if(current.length() == 1){ // Each radio station is separated by one space.
                    loc = 0;
                } else {
                    loc++;
                }

                //System.out.println(sc.next());
                /*
                FmStation newStation = new FmStation(StationArr[0], StationArr[1],
                        StationArr[2], StationArr[3], StationArr[4], StationArr[5],
                        StationArr[6], StationArr[7], StationArr[8], StationArr[9],
                        StationArr[10], StationArr[11], StationArr[12], StationArr[13],
                        StationArr[14], StationArr[15]);

                 */
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("FM-stations.txt not found!");
        }
    }
}
