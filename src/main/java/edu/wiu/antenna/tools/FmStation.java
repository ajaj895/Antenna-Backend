/*
 * Written by: Evan C. 
 * Created: Spring 2021
 * Last updated: February 15, 2022 
*/

package edu.wiu.antenna.tools;

public class FmStation {

    private String cs;
    private Float frequency;
    private String city;
    private String state;
    private String country;
    private boolean directional; // false - nondirectional, true - directional
    private short cl; // FM classes (A, B1, B, C3, C2, C1, C0, C) = 0, 1, 2, 3, 4, 5, 6, 7 respectivly.
    //Note: The fcc has class station ranges here: https://www.fcc.gov/media/radio/fm-station-classes
    private float power;
    private boolean latDir;
    private int latDeg;
    private int latMin;
    private double latSec;
    private boolean lngDir;
    private int lngDeg;
    private int lngMin;
    private double lngSec;

    /**
     * FmStation is the constructor for the FmStation object.
     * @param callsign String representing the callsign of the station.
     * @param freq A float representing the frequency of the station.
     * @param loc String representing the city that the station is located in.
     * @param locState String representing the state that the station is located in.
     * @param locCountry String representing the country that the station is located in.
     * @param dir Boolean representing if the station is unidirectional or omnidirectional.
     * @param clas A short representing the class of the station (A, B1, B, C3, C2, C1, C0, C) = 0, 1, 2, 3, 4, 5, 6, 7 respectivly.
     * @param sPower A float representing the power of the station in Khz, will be 0.76 if the station doesn't have a power rating.
     * @param latD Latitude direction, false for south, true for north.
     * @param latDeg Integer representing latitude degree.
     * @param latMin Integer representing latitude minute.
     * @param latSec Double representing latitude second.
     * @param longD Longitude direction false for west, true for east.
     * @param longDeg Integer representing longitude degree.
     * @param longMin Integer representing longitude minute.
     * @param longSec Double representing longitude second.
     */
    public FmStation(String callsign, Float freq, String loc, String locState, String locCountry, boolean dir,
                     short clas, float sPower, boolean latD, int latDeg, int latMin, double latSec, boolean longD,
                     int longDeg, int longMin, double longSec){

        init(callsign, freq, loc, locState, locCountry, dir, clas, sPower, latD, latDeg, latMin, latSec, longD, longDeg,
                longMin, longSec);

    }

    //Getters

    /**
     * getCallsign() returns the callsign.
     * @return Callsign as a string.
     */
    public String getCallsign() { return cs; }
    /**
     * getFrequency returns the frequency.
     * @return frequency as a float.
     */
    public Float getFrequency() { return frequency; }
    /**
     * getCity() returns the station's city.
     * @return City as a string.
     */
    public String getCity() { return city; }
    /**
     * getState() returns the station's state.
     * @return State as a string.
     */
    public String getState() { return state; }
    /**
     * getCountry() returns the station's country.
     * @return Country as a string.
     */
    public String getCountry() { return country; }
    /**
     * getDirectional() returns the type of station.
     * @return Direction type as a boolean. (false for omnidirectional, true for unidirectional)
     */
    public boolean getDirectional() { return directional; }
    /**
     * getCl() returns the class of the station.
     * @return Class as a short. (A, B1, B, C3, C2, C1, C0, C) = 0, 1, 2, 3, 4, 5, 6, 7 respectivly.
     */
    public short getCl() { return cl; }
    /**
     * getPower() returns the power of the station in Khz.
     * @return Power as a float.
     */
    public float getPower() { return power; }
    /**
     * getLatDir() returns the latitude direction of the station. 
     * @return Latitude direction as a boolean (true for north, false for south).
     */
    public boolean getLatDir() { return latDir; }
    /**
     * getLatDeg() returns the latitude degrees.
     * @return Latitude degrees as an int.
     */
    public int getLatDeg() { return latDeg; }
    /**
     * getLatMin() returns the latitude minutes.
     * @return Latitude minutes as an int.
     */
    public int getLatMin() { return latMin; }
    /**
     * getLatSec() returns the latitude seconds.
     * @return Latitude seconds as a double.
     */
    public double getLatSec() { return latSec; }
    /**
     * getLngDir() returns the longitude direction of the station.
     * @return Longitude direction as a boolean (true for east, false for west).
     */
    public boolean getLngDir() { return lngDir; }
    /**
     * getLngDeg() returns the longitude degrees.
     * @return Longitude degree as an int.
     */
    public int getLngDeg() { return lngDeg; }
    /**
     * getLngMin() returns the longitude minutes.
     * @return Longitude minutes as an int.
     */
    public int getLngMin() { return lngMin; }
    /**
     * getLngSec() returns the longitude seconds.
     * @return Longitude seconds as a double.
     */
    public double getLngSec() { return lngSec; }

    //Setters

    /**
     * setCs() sets the callsign of the station.
     * @param newCs A string of the new callsign of the station.
     */
    public void setCs(String newCs){
        cs = newCs;
    }

    // Intializes all the values in the FmStation object.
    private void init(String callsign, Float freq, String loc, String locState, String locCountry, boolean dir,
                      short clas, float sPower, boolean latD, int latDeg, int latMin, double latSec, boolean longD,
                      int longDeg, int longMin, double longSec){

        cs = callsign;
        frequency = freq;
        city = loc;
        state = locState;
        country = locCountry;
        directional = dir;
        cl = clas;
        power = sPower;
        latDir = latD;
        this.latDeg = latDeg;
        this.latMin = latMin;
        this.latSec = latSec;
        lngDir = longD;
        lngDeg = longDeg;
        lngMin = longMin;
        lngSec = longSec;

    }
}
