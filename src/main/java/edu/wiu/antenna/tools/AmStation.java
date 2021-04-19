package edu.wiu.antenna.tools;

/*
 Things to keep in mind.
 Frequency is in khz (kilohertz)
 Power is in kW (kilowatts)
 type is: 0 - unlimited, 1 - daytime, 2 - nighttime
 latitude - N/S (true for north, false for south), longitude - E/W (true for east, false for west)
 gps coords are denoted as (direction) (degrees)*(minutes)'(seconds)"
 */

public class AmStation {
    private String cs;
    private short frequency;
    private byte mode;
    private String city;
    private String state;
    private String country;
    private float power;
    private boolean latDir;
    private int latDeg;
    private int latMin;
    private double latSec;
    private boolean lngDir;
    private int lngDeg;
    private int lngMin;
    private double lngSec;

    public AmStation(String callsign, short freq, byte type, String loc, String locState, String locCountry,
                     float sPower, boolean latD, int latDeg, int latMin, double latSec, boolean longD, int longDeg,
                     int longMin, double longSec){

        init(callsign, freq, type, loc, locState, locCountry, sPower, latD, latDeg, latMin, latSec, longD, longDeg,
                longMin, longSec);

    }

    //Getters
    public String getCallsign(){ return cs; }
    public short getFrequency(){ return frequency; }
    public byte getMode(){ return mode; }
    public String getCity(){ return city; }
    public String getState(){ return state; }
    public String getCountry(){ return country; }
    public float getPower(){ return power; }
    public boolean getLatDir(){ return latDir; }
    public int getLatDeg(){ return latDeg; }
    public int getLatMin(){ return latMin; }
    public double getLatSec(){ return latSec; }
    public boolean getLngDir(){ return lngDir; }
    public int getLngDeg(){ return lngDeg; }
    public int getLngMin(){ return lngMin; }
    public double getLngSec(){ return lngSec; }

    //Setters
    public void setCs(String newCs){
        cs = newCs;
    }

    private void init(String callsign, short freq, byte type, String loc, String locState, String locCountry,
                      float sPower, boolean latD, int latDeg, int latMin, double latSec, boolean longD, int longDeg,
                      int longMin, double longSec){

        cs = callsign;
        frequency = freq;
        mode = type;
        city = loc;
        state = locState;
        country = locCountry;
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
