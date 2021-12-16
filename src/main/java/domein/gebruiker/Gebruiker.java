package domein.gebruiker;

import domein.transactie.Reservatie;
import persistence.CataloogObject;
import util.GeoLocatie;

import java.util.List;


/**
 * Anouar Bannamar
 * 21-11-21
 */
public class Gebruiker implements CataloogObject {
    
    public final int id;
    
    private String login;
    private GeoLocatie locatie;
    private long sharepoints;
    
    private List<Reservatie> reservaties;
    
    public Gebruiker (int id, String login, GeoLocatie locatie, long sharepoints) {
        this.id = id;
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
    
    public void setReservaties (List<Reservatie> reservaties) {
        this.reservaties = reservaties;
    }
    
    public GeoLocatie getLocatie () {
        return locatie;
    }
    
    public long getSharepoints () {
        return sharepoints;
    }
    
    public List<Reservatie> getReservaties () {
        return reservaties;
    }
    
    public boolean addReservatie (Reservatie reservatie) {
        return reservaties.add (reservatie);
    }
    
    public boolean removeReservatie (Reservatie reservatie) {
        return reservaties.remove (reservatie);
    }
    
    @Override
    public int getId () {
        return id;
    }
}
