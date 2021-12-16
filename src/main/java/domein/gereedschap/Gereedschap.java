package domein.gereedschap;

import domein.gebruiker.Gebruiker;
import persistence.CataloogObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Arne Cools
 * 21/11/2021
 */
public class Gereedschap implements CataloogObject {
    private String naam;
    public final int id;
    private static int idTeller;
    private String beschrijving;
    private Gebruiker aanbieder;
    private long daghuurprijs;
    private int aankoopprijs;
    private int waarde;
    private GereedschapsType gereedschapsType;
    private final Set<Gereedschap> gereedschapSet;
    
    public Gereedschap (int id, String naam, String beschrijving, Gebruiker aanbieder, long daghuurprijs, int aankoopprijs, int waarde, GereedschapsType gereedschapsType) {
        this.id = id;
        setNaam (naam);
        setBeschrijving (beschrijving);
        setDaghuurprijs (daghuurprijs);
        setAanbieder (aanbieder);
        setAankoopprijs (aankoopprijs);
        setWaarde (waarde);
        setGereedschapsType (gereedschapsType);
        gereedschapSet = new HashSet<> ();
    }
    
    public Gebruiker getAanbieder () {
        return aanbieder;
    }
    
    private void setAanbieder (Gebruiker aanbieder) {
        this.aanbieder = aanbieder;
    }
    
    private void setNaam (String naam) {
        this.naam = naam;
    }
    
    private void setGereedschapsType (GereedschapsType gereedschapsType) {
        this.gereedschapsType = gereedschapsType;
    }
    
    private void setDaghuurprijs (long daghuurprijs) {
        this.daghuurprijs = daghuurprijs;
    }
    
    private void setBeschrijving (String beschrijving) {
        this.beschrijving = beschrijving;
    }
    
    private void setAankoopprijs (int aankoopprijs) {
        this.aankoopprijs = aankoopprijs;
    }
    
    private void setWaarde (int waarde) {
        this.waarde = waarde;
    }
    
    public boolean addGereedschap (Gereedschap gereedschap) {
        return gereedschapSet.add (gereedschap);
    }
    
    public boolean removeGereedschap (Gereedschap gereedschap) {
        return gereedschapSet.remove (gereedschap);
    }
    
    public long getDaghuurprijs () {
        return daghuurprijs;
    }
    
    public GereedschapsType getGereedschapsType () {
        return gereedschapsType;
    }
    
    public String getBeschrijving () {
        return beschrijving;
    }
    
    public int getAankoopprijs () {
        return aankoopprijs;
    }
    
    public int getWaarde () {
        return waarde;
    }
    
    public Set<Gereedschap> getGereedschapSet () {
        return gereedschapSet;
    }
    
    public List<Gereedschap> getAllGereedschap () {
        return new ArrayList<> (gereedschapSet);
    }

    @Override
    public int getId() {
        return id;
    }
}
