/*
 * Written by: Evan C. 
 * Created: Spring 2021
 * Last updated: February 15, 2022 
*/

package edu.wiu.antenna.tools;

import java.util.Scanner;
import java.sql.*;

public class DBHandler {

    // NOTE: You have to enter your DB's address after the // in the line below and rebuild the project.
    // Make sure to include the database name after the address i.e. localhost:3306/radio
    private static String url = "jdbc:mariadb://put server address here";
       

    static Connection conn;
    static Statement stmt;
    static Scanner sc = new Scanner(System.in); // For credentials
    private static String[] cred;

    /**
     * amInsert inserts a new AmStation object into the radio database. Will not create new objects if the current station exists on the DB.
     * @param curr An AmStation object that is currently selected to go into the db.
     */
    public static void amInsert(AmStation curr){
        cred = auth();
        System.out.println("Connecting to the database...");
        connectToDb(cred[0], cred[1]);

        /*
            latitude - N/S (true (1) for north, false (0) for south), longitude - E/W (true (1) for east, false (0) for west)
            gps coords are denoted as (direction) (degrees)*(minutes)'(seconds)"
         */
        
        //Direction transformation
        byte latDir;
        byte lngDir;

        //Latitude fix
        if(curr.getLatDir()){
            latDir = 1;
        } else {
            latDir = 0;
        }
        
        //Longitude fix
        if(curr.getLngDir()){
            lngDir = 1;
        } else {
            lngDir = 0;
        }

        String query = "INSERT INTO am_radio VALUES(" + "\"" +
                curr.getCallsign()+ "\"" + ", " + curr.getFrequency() +
                ", " + curr.getMode() + ", " + "\"" + curr.getCity() + "\"" + ", " +
                "\"" + curr.getState() + "\"" + ", " + "\"" + curr.getCountry() + "\"" + ", " +
                curr.getPower() + ", " + latDir + ", " +
                curr.getLatDeg() + ", " + curr.getLatMin() + ", " +
                curr.getLatSec() + ", " + lngDir + ", " +
                curr.getLngDeg() + ", " + curr.getLngMin() + ", " +
                curr.getLngSec() + ");";
        try {

            stmt.executeUpdate(query); //insert the information into the db.
            System.out.println(curr.getCallsign() + " added to the database.");

        } catch (SQLException throwables) {
            System.err.println("Error in the sql query...");
            System.err.println(throwables);
        }


    }

    /**
     * amInsert inserts a new AmStation object into the radio database. Will not create new objects if the current station exists on the DB.
     * @param curr An AmStation object that is currently selected to go into the db.
     * @param user String of the username of the DB.
     * @param pass String of the password of the DB.
     */
    public static void amInsert(AmStation curr, String user, String pass){
        
        connectToDb(user, pass); // Authentication

        /*
            latitude - N/S (true (1) for north, false (0) for south), longitude - E/W (true (1) for east, false (0) for west)
            gps coords are denoted as (direction) (degrees)*(minutes)'(seconds)"
         */

        //Direction transformation
        byte latDir;
        byte lngDir;

        //Latitude fix
        if(curr.getLatDir()){
            latDir = 1;
        } else {
            latDir = 0;
        }

        //Longitude fix
        if(curr.getLngDir()){
            lngDir = 1;
        } else {
            lngDir = 0;
        }

        String query = "INSERT INTO am_radio VALUES(" + "\"" +
                curr.getCallsign()+ "\"" + ", " + curr.getFrequency() +
                ", " + curr.getMode() + ", " + "\"" + curr.getCity() + "\"" + ", " +
                "\"" + curr.getState() + "\"" + ", " + "\"" + curr.getCountry() + "\"" + ", " +
                curr.getPower() + ", " + latDir + ", " +
                curr.getLatDeg() + ", " + curr.getLatMin() + ", " +
                curr.getLatSec() + ", " + lngDir + ", " +
                curr.getLngDeg() + ", " + curr.getLngMin() + ", " +
                curr.getLngSec() + ");";
        try {

            stmt.executeUpdate(query); //insert the information into the db.

        } catch (SQLException throwables) {
            System.err.println("Error in the sql query...");
            System.err.println(throwables);
        } finally {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                //Do nothing
            }
            try {
                conn.close();
            } catch (SQLException throwables) {
                //do nothing
            }
        }


    }

    /**
     * fmInsert inserts a new FmStation object into the radio database. Will not create new objects if the current station exists on the DB.
     * @param curr An FmStation object that is currently selected to go into the db.
     * @param user String of the username of the DB.
     * @param pass String of the password of the DB. 
     */
    public static void fmInsert(FmStation curr, String user, String pass){
        
        connectToDb(user, pass); // Authentication

        /*
            latitude - N/S (true (1) for north, false (0) for south), longitude - E/W (true (1) for east, false (0) for west)
            gps coords are denoted as (direction) (degrees)*(minutes)'(seconds)"
         */

        //Direction transformation
        byte latDir;
        byte lngDir;

        //Latitude fix
        if(curr.getLatDir()){
            latDir = 1;
        } else {
            latDir = 0;
        }

        //Longitude fix
        if(curr.getLngDir()){
            lngDir = 1;
        } else {
            lngDir = 0;
        }

        String query = "INSERT INTO fm_radio VALUES(" + "\"" +
                curr.getCallsign()+ "\"" + ", " + curr.getFrequency() +
                ", " + "\"" + curr.getCity() + "\"" + ", " +
                "\"" + curr.getState() + "\"" + ", " + "\"" + curr.getCountry() + "\"" + ", " +
                curr.getDirectional() + ", " + curr.getCl() + ", " + curr.getPower() + ", " + latDir + ", " +
                curr.getLatDeg() + ", " + curr.getLatMin() + ", " +
                curr.getLatSec() + ", " + lngDir + ", " +
                curr.getLngDeg() + ", " + curr.getLngMin() + ", " +
                curr.getLngSec() + ");";

        try {

            stmt.executeUpdate(query); //insert the information into the db.

        } catch (SQLException throwables) {
            System.err.println("Error in the sql query...");
            System.err.println(throwables);
        } finally {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                //Do nothing
            }
            try {
                conn.close();
            } catch (SQLException throwables) {
                //do nothing
            }
        }


    }

    /**
     * dbTest is a debuging tool to test to see if you are connected to the database.
     * dbTest will print out ALL of the entries in the am_radio table.
     */
    public static void dbTest(){

        cred = auth();
        System.out.println("Connecting to the database...");
        connectToDb(cred[0], cred[1]);

        String query = "SELECT * FROM am_radio;"; 
        try {
            ResultSet amStations = stmt.executeQuery(query);
            int col = amStations.getMetaData().getColumnCount();
            while(amStations.next()){
                for(int i = 1; i<=col; i++){
                    System.out.print(amStations.getString(i)+" ");
                }
                System.out.println();
            }
        } catch (SQLException throwables) {
            System.err.println("Error in the sql query...");
            System.err.println(throwables);
        }

    }

    // 0 - username, 1 - password
    private static String[] auth(){
        String[] authy = new String[2];
        sc = new Scanner(System.in);
        System.out.print("Enter your username: ");
        authy[0] = sc.next();
        System.out.print("Enter your password: ");
        authy[1] = sc.next();
        System.out.println();//For decoration
        return authy;
    }

    // for connecting to the db.
    private static void connectToDb(String user, String pass){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        } catch(SQLException e){
            System.err.println("Unable to connect to the MariaDB.");
            System.err.println(e);
        } catch (ClassNotFoundException e){
            System.err.println("Class not found.");
            System.err.println(e);
        }

    }
}
