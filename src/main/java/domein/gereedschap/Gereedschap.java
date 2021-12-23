package domein.gereedschap;

import domein.gebruiker.Gebruiker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Arne Cools
 * 21/11/2021
 */
public class Gereedschap {
	
	private String naam;
	private String beschrijving;
	private Gebruiker aanbieder;
	private long daghuurprijs;
	private int aankoopprijs;
	private int waarde;
	private String gereedschapsType;
	private final Set<Gereedschap> gereedschapSet;
	private GereedschapsPrijsBerekener prijsBerekener;
	
	public Gereedschap (String naam, String beschrijving, Gebruiker aanbieder, long daghuurprijs, int aankoopprijs, int waarde, String gereedschapsType, GereedschapsPrijsBerekener gereedschapsPrijsBerekener) {
		this.prijsBerekener = gereedschapsPrijsBerekener;
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
	
	public String getGereedschapsType () {
		return gereedschapsType;
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
	
	private void setGereedschapsType (String gereedschapsType) {
		if (gereedschapsType == null)
			throw new NullPointerException ("Gereedschapstype cannot be null.");
		this.gereedschapsType = gereedschapsType;
	}
	
	public String getBeschrijving () {
		return beschrijving;
	}
	
	public int getAankoopprijs () {
		return aankoopprijs + (int) gereedschapSet.stream ().mapToDouble (Gereedschap::getAankoopprijs).sum ();
	}
	
	public int getWaarde () {
		return waarde + (int) gereedschapSet.stream ().mapToDouble (Gereedschap::getWaarde).sum ();
	}
	
	public int getWaarbord () {
		return GereedschapsTypen.getInstance ().getWaarborg (gereedschapsType);
	}
	
	Set<Gereedschap> getGereedschapSet () {
		return gereedschapSet;
	}
	
	public List<Gereedschap> getAllGereedschap () {
		return new ArrayList<> (gereedschapSet);
	}
	
	public long getHuurPrijs (int dagen) {
		return prijsBerekener.berekenPrijs (this, dagen);
	}
}
