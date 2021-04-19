package edu.wiu.antenna.tools;

public class FmStation {

    private String cs;
    private Float frequency;
    private String city;
    private String state;
    private String country;
    private boolean directional;
    private short cl; // FM classes (A, B1, B, C3, C2, C1, C0, C) = 0, 1, 2, 3, 4, 5, 6, 7 respectivly.
    //Note: The fcc has class station ranges here: https://www.fcc.gov/media/radio/fm-station-classes
    private float power;
    private boolean ltDir;
    private int ltDeg;
    private int ltMin;
    private double ltSec;
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
        ltDir = latD;
        ltDeg = latDeg;
        ltMin = latMin;
        ltSec = latSec;
        lngDir = longD;
        lngDeg = longDeg;
        lngMin = longMin;
        lngSec = longSec;

    }
}
