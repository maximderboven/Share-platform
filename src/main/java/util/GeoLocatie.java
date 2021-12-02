package util;

/**
 * @author Maxim Derboven
 * @version 1.0 21/11/2021 15:33
 */
public class GeoLocatie {
    private double longitude;
    private double latitude;
    
    public GeoLocatie (double longitude, double lattitude) {
        setLongitude (longitude);
        setLatitude (lattitude);
    }
    
    public double getLongitude () {
        return longitude;
    }
    
    public void setLongitude (double longitude) {
        if (longitude < -90 || longitude > 90)
            throw new IllegalArgumentException ("longitude cannot go beyond (-180, 180).");
        this.longitude = longitude;
    }
    
    public double getLatitude () {
        return latitude;
    }
    
    public void setLatitude (double latitude) {
        if (latitude < -180 || latitude > 180)
            throw new IllegalArgumentException ("lattitude cannot go beyond (-90, 90).");
        this.latitude = latitude;
    }
}


