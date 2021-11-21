package domein.gereedschap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Arne Cools
 * 21/11/2021
 */
public class Gereedschap {
    private GereedschapsType gereedschapsType;
    //    private Gebruiker aanbieder;
    private long daghuurprijs;
    private String beschrijving;
    private int aankoopprijs;
    private int waarde;
    private final Set<Gereedschap> gereedschapSet;

    public Gereedschap(long daghuurprijs, String beschrijving, int aankoopprijs, int waarde, GereedschapsType gereedschapsType) {
        this.daghuurprijs = daghuurprijs;
        this.beschrijving = beschrijving;
        this.aankoopprijs = aankoopprijs;
        this.waarde = waarde;
        this.gereedschapsType = gereedschapsType;
        gereedschapSet = new HashSet<> ();
    }

    public void setGereedschapsType(GereedschapsType gereedschapsType) {
        this.gereedschapsType = gereedschapsType;
    }

    public void setDaghuurprijs(long daghuurprijs) {
        this.daghuurprijs = daghuurprijs;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }
    
    public void setAankoopprijs (int aankoopprijs) {
        this.aankoopprijs = aankoopprijs;
    }
    
    public void setWaarde (int waarde) {
        this.waarde = waarde;
    }
    
    public boolean addGereedschap (Gereedschap gereedschap) {
        return gereedschapSet.add (gereedschap);
    }
    
    public boolean removeGereedschap (Gereedschap gereedschap) {
        return gereedschapSet.remove (gereedschap);
    }
    
    public List<Gereedschap> getAllGereedschap () {
        return new ArrayList<> (gereedschapSet);
    }
}
