package edu.wiu.antenna;

import edu.wiu.antenna.tools.*;

import java.util.LinkedList;
import java.util.Scanner;

public class RadioSoup {

    public static void main(String[] args){
        //AMSoup.findAm(); // This works!
        //FMScan.findFm();
        Scanner sc = new Scanner(System.in);

        while(true) { // Program loop
            System.out.print("What would you like to do?\n| 1-Radio Scan 2-AM Scan 3-FM Scan 4-DB Update" +
                    " 5-Exit | \nEnter just the number: ");
            String choice = sc.next();

            switch(choice){
                case "1":
                    System.out.println("Starting AM and FM scans...");
                    AMScan.findAm();
                    System.out.println("\nAM done.");
                    FMScan.findFm();
                    System.out.println("FM done. Scan complete.");
                    break;
                case "2":
                    System.out.println("Starting AM scan...");
                    AMScan.findAm();
                    System.out.println("\nAM done. Scan complete.");
                    break;
                case "3":
                    System.out.println("Starting FM scan...");
                    FMScan.findFm();
                    System.out.println("FM done. Scan complete.");
                    break;
                case "4":
                    System.out.print("Enter your username: ");
                    String user = sc.next();
                    System.out.print("Enter your password: ");
                    String pass = sc.next();
                    System.out.println("Getting AM stations ready...");
                    LinkedList<AmStation> amList = AMScan.findAm();
                    System.out.println("AM stations ready.");
                    System.out.println("Getting FM stations ready...");
                    LinkedList<FmStation> fmList = FMScan.findFm();
                    System.out.println("FM stations ready.");
                    System.out.println("Starting database update...");
                    for(int i = 0; i < amList.size(); i++) {
                        String temp = amList.get(i).getCallsign();
                        amList.get(i).setCs(temp+i);
                        DBHandler.amInsert(amList.get(i), user, pass);
                    }
                    System.out.println("AM Database update complete.");
                    System.out.println("FM Database update started...");
                    for(int i = 0; i < fmList.size(); i++) {
                        String temp = fmList.get(i).getCallsign();
                        fmList.get(i).setCs(temp+i);
                        DBHandler.fmInsert(fmList.get(i), user, pass);
                    }
                    DBHandler.dbTest();
                    System.out.println("Database update complete.");
                    break;
                case "5":
                    System.out.println("So long partner.");
                    System.exit(0);
                default:
                    System.err.println("Unknown value, please enter a number from the list above.");
                    break;
            }
        }
    }

}
