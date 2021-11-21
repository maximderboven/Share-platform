package util;

/**
 * @author Maxim Derboven
 * @version 1.0 21/11/2021 15:33
 */
public class GeoLocatie {
    double longitude;
    double lattitude;

    public GeoLocatie(double longitude, double lattitude) {
        setLongitude(longitude);
        setLattitude(lattitude);
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        if (longitude < 0)
            throw new IllegalArgumentException ("longitude cannot be negative.");
        this.longitude = longitude;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        if (lattitude < 0)
            throw new IllegalArgumentException ("lattitude cannot be negative.");
        this.lattitude = lattitude;
    }
}


