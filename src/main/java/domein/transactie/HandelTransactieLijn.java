package domein.transactie;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class HandelTransactieLijn extends TransactieLijn {
    private float bedrag;
    private HandelsLijnType handelsLijnType;
    
    public HandelTransactieLijn (float bedrag, HandelsLijnType handelsLijnType) {
        setBedrag (bedrag);
        setHandelsLijnType (handelsLijnType);
    }
    
    public void setBedrag (float bedrag) {
        if (bedrag < 0) {
            throw new IllegalArgumentException ("Bedrag kan niet onder de 0 zijn.");
        }
        this.bedrag = bedrag;
    }
    
    public void setHandelsLijnType (HandelsLijnType handelsLijnType) {
        if (handelsLijnType == null) {
            throw new IllegalArgumentException ("HandelsTypeLijn kan niet null zijn");
        }
        this.handelsLijnType = handelsLijnType;
    }
}
