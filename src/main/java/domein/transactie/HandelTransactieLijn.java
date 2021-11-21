package domein.transactie;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class HandelTransactieLijn extends TransactieLijn {
    private float bedrag;
    private HandelsTypeLijn handelsTypeLijn;

    public HandelTransactieLijn(float bedrag, HandelsTypeLijn handelsTypeLijn) {
        setBedrag(bedrag);
        setHandelsTypeLijn(handelsTypeLijn);
    }

    public void setBedrag(float bedrag) {
        if (bedrag < 0){
            throw new IllegalArgumentException("Bedrag kan niet onder de 0 zijn.");
        }
        this.bedrag = bedrag;
    }

    public void setHandelsTypeLijn(HandelsTypeLijn handelsTypeLijn) {
        if(handelsTypeLijn == null){
            throw new IllegalArgumentException("HandelsTypeLijn kan niet null zijn");
        }
        this.handelsTypeLijn = handelsTypeLijn;
    }
}
