package util;

/**
 * @author Maxim Derboven
 * @version 1.0 21/11/2021 15:33
 */
public class GeoLocatie {
    private double longitude;
    private double lattitude;
    
    public GeoLocatie (double longitude, double lattitude) {
        setLongitude (longitude);
        setLattitude (lattitude);
    }
    
    public double getLongitude () {
        return longitude;
    }

    public void setLongitude(double longitude) {
        if (longitude < -180 || longitude > 180)
            throw new IllegalArgumentException ("longitude cannot go beyond (-180, 180).");
        this.longitude = longitude;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        if (lattitude < -90 || lattitude > 90)
            throw new IllegalArgumentException ("lattitude cannot go beyond (-90, 90).");
        this.lattitude = lattitude;
    }
}


