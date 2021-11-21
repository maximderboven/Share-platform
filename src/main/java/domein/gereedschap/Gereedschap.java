package domein.gereedschap;

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

    public Gereedschap(long daghuurprijs, String beschrijving, int aankoopprijs, int waarde, GereedschapsType gereedschapsType) {
        this.daghuurprijs = daghuurprijs;
        this.beschrijving = beschrijving;
        this.aankoopprijs = aankoopprijs;
        this.waarde = waarde;
        this.gereedschapsType = gereedschapsType;
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

    public void setAankoopprijs(int aankoopprijs) {
        this.aankoopprijs = aankoopprijs;
    }

    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }
}
