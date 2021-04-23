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

    public FmStation(String callsign, Float freq, String loc, String locState, String locCountry, boolean dir,
                     short clas, float sPower, boolean latD, int latDeg, int latMin, double latSec, boolean longD,
                     int longDeg, int longMin, double longSec){

        init(callsign, freq, loc, locState, locCountry, dir, clas, sPower, latD, latDeg, latMin, latSec, longD, longDeg,
                longMin, longSec);

    }

    //Getters
    public String getCallsign() { return cs; }
    public Float getFrequency() { return frequency; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getCountry() { return country; }
    public boolean getDirectional() { return directional; }
    public short getCl() { return cl; }
    public float getPower() { return power; }
    public boolean getLatDir() { return latDir; }
    public int getLatDeg() { return latDeg; }
    public int getLatMin() { return latMin; }
    public double getLatSec() { return latSec; }
    public boolean getLngDir() { return lngDir; }
    public int getLngDeg() { return lngDeg; }
    public int getLngMin() { return lngMin; }
    public double getLngSec() { return lngSec; }

    //Setters
    public void setCs(String newCs){
        cs = newCs;
    }

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
