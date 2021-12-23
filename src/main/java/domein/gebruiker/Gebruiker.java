package domein.gebruiker;

import util.GeoLocatie;


/**
 * Anouar Bannamar
 * 21-11-21
 */
public class Gebruiker {
    
    private String login;
    private GeoLocatie locatie;
    private long sharepoints;
    
    public Gebruiker (String login, GeoLocatie locatie, long sharepoints) {
        setLogin (login);
        setLocatie (locatie);
        setSharepoints (sharepoints);
    }
    
    public void setLogin (String login) {
        if (login == null) {
            throw new IllegalArgumentException ("Login kan niet leeg zijn");
        }
        this.login = login;
    }
    
    public String getLogin () {
        return login;
    }
    
    public void setLocatie (GeoLocatie locatie) {
        if (locatie == null) {
            throw new IllegalArgumentException ("Locatie kan niet leeg zijn.");
        }
        this.locatie = locatie;
    }
    
    public void setSharepoints (long sharepoints) {
        this.sharepoints = sharepoints;
    }
    
    public GeoLocatie getLocatie () {
        return locatie;
    }
    
    public long getSharepoints () {
        return sharepoints;
    }
    
}
