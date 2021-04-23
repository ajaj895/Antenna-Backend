package edu.wiu.antenna.tools;

import java.util.Scanner;
import java.sql.*;

public class DBHandler {

    String url = "jdbc:mariadb://put server address here";
    static Connection conn;
    static Statement stmt;
    static Scanner sc = new Scanner(System.in); // For credentials
    private static String[] cred;

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

            stmt.executeUpdate(query);//insert the information into the db.
            System.out.println(curr.getCallsign() + " added to the database.");
            //ResultSet amStations = stmt.executeQuery(query);
            //System.out.println(amStations.getMetaData().getColumnCount());
            /*
            int col = amStations.getMetaData().getColumnCount();
            while(amStations.next()){
                for(int i = 1; i<=col; i++){
                    System.out.print(amStations.getString(i)+" ");
                }
                System.out.println();
            }
            */

        } catch (SQLException throwables) {
            System.err.println("Error in the sql query...");
            System.err.println(throwables);
        }


    }
    public static void amInsert(AmStation curr, String user, String pass){
        //cred = auth();
        //System.out.println("Connecting to the database...");
        connectToDb(user, pass);

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

            stmt.executeUpdate(query);//insert the information into the db.
            //System.out.println(curr.getCallsign() + " added to the database.");
            //ResultSet amStations = stmt.executeQuery(query);
            //System.out.println(amStations.getMetaData().getColumnCount());
            /*
            int col = amStations.getMetaData().getColumnCount();
            while(amStations.next()){
                for(int i = 1; i<=col; i++){
                    System.out.print(amStations.getString(i)+" ");
                }
                System.out.println();
            }
            */

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

    public static void fmInsert(FmStation curr, String user, String pass){
        //cred = auth();
        //System.out.println("Connecting to the database...");
        connectToDb(user, pass);

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

            stmt.executeUpdate(query);//insert the information into the db.
            //System.out.println(curr.getCallsign() + " added to the database.");
            //ResultSet amStations = stmt.executeQuery(query);
            //System.out.println(amStations.getMetaData().getColumnCount());
            /*
            int col = amStations.getMetaData().getColumnCount();
            while(amStations.next()){
                for(int i = 1; i<=col; i++){
                    System.out.print(amStations.getString(i)+" ");
                }
                System.out.println();
            }
            */

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

    public static void dbTest(){

        cred = auth();
        System.out.println("Connecting to the database...");
        connectToDb(cred[0], cred[1]);

        String query = "SELECT * FROM am_radio;";
        try {
            ResultSet amStations = stmt.executeQuery(query);
            //System.out.println(amStations.getMetaData().getColumnCount());
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

    private static void connectToDb(String user, String pass){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/radio", user, pass);
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
