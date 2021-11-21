package domein.gereedschap;

/**
 * Arne Cools
 * 21/11/2021
 */
public enum GereedschapsType {
    ELEKTRISCH ("Elektrisch gereedschap", 40),
    KEUKEN ("Keuken", 60),
    GELUIDSINSTALLATIE ("Geluidsinstallatie", 400),
    LICHTINSTALLATIE ("Lichtinstallatie", 150);
    
    private String naam;
    private long waarborg;
    
    GereedschapsType (String naam, long waarborg) {
        this.naam = naam;
        this.waarborg = waarborg;
    }
    
    public String getNaam () {
        return naam;
    }

    public long getWaarborg() {
        return waarborg;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setWaarborg(long waarborg) {
        this.waarborg = waarborg;
    }
}
