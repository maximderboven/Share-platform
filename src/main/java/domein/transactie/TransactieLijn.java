package domein.transactie;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public abstract class TransactieLijn {
	
	private long sharepoints;
	
	public long getSharepoints () {
		return sharepoints;
	}
	
	public void setSharepoints (long sharepoints) {
		this.sharepoints = sharepoints;
	}
	
}
