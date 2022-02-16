/*
 * Written by: Evan C. 
 * Created: Spring 2021
 * Last updated: February 15, 2022 
*/

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

    /**
     * AmStation constructor
     * @param callsign a string of the station's callsign.
     * @param freq the station's frequency (in mhz).
     * @param type 0-daytime, 1-nightime, 2-universal
     * @param loc station's city.
     * @param locState station's state.
     * @param locCountry station's country.
     * @param sPower station's power in kW
     * @param latD Latitude direction (n/s)
     * @param latDeg Latitude degree
     * @param latMin Latitude minute
     * @param latSec Latitude second
     * @param longD Longitude direction (e/w)
     * @param longDeg Longitude degree 
     * @param longMin Longitude minute
     * @param longSec Longitude second
     */
    public AmStation(String callsign, short freq, byte type, String loc, String locState, String locCountry,
                     float sPower, boolean latD, int latDeg, int latMin, double latSec, boolean longD, int longDeg,
                     int longMin, double longSec){

        init(callsign, freq, type, loc, locState, locCountry, sPower, latD, latDeg, latMin, latSec, longD, longDeg,
                longMin, longSec);

    }

    //Getters
    /**
     * Callsign getter
     * @return callsign as a string
     */
    public String getCallsign(){ return cs; }
    /**
     * Frequency getter
     * @return Frequency as a short
     */
    public short getFrequency(){ return frequency; }
    /**
     * Mode getter
     * @return mode as a byte
     */
    public byte getMode(){ return mode; }
    /**
     * City getter
     * @return City as a string
     */
    public String getCity(){ return city; }
    /**
     * State getter
     * @return state as a string
     */
    public String getState(){ return state; }
    /**
     * Country getter
     * @return country as a string
     */
    public String getCountry(){ return country; }
    /**
     * Power getter
     * @return power as a float
     */
    public float getPower(){ return power; }
    /**
     * Latitude Direction getter
     * @return Latitude Direction as a boolean(north-false, south-true)
     */
    public boolean getLatDir(){ return latDir; }
    /**
     * Latitude degree getter
     * @return latitude degree as an int
     */
    public int getLatDeg(){ return latDeg; }
    /**
     * Latitude minute getter
     * @return latitude minute as an int
     */
    public int getLatMin(){ return latMin; }
    /**
     * Latitude second getter
     * @return latitude second as a double
     */
    public double getLatSec(){ return latSec; }
    /**
     * Longitude direction getter
     * @return longitude direction as a boolean(east-false, west-true)
     */
    public boolean getLngDir(){ return lngDir; }
    /**
     * Longitude degree getter
     * @return longitude degree as an int
     */
    public int getLngDeg(){ return lngDeg; }
    /**
     * Longitude minute getter
     * @return longitude minute as an int
     */
    public int getLngMin(){ return lngMin; }
    /**
     * Longitude second getter
     * @return longitude second as a double
     */
    public double getLngSec(){ return lngSec; }

    // Setters

    /**
     * Sets the callsign of the station.
     * @param newCs the new callsign of the Station as a string.
     */
    public void setCs(String newCs){
        cs = newCs;
    }

    // Initializes all the values in the AmStation object.
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
