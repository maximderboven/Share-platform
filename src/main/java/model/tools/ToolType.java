package model.tools;

/**
 * Anouar Bannamar
 * 27-10-21
 */
public enum ToolType {
	
	ELECTRIC (40),
	KITCHEN (40),
	SOUND_INSTALLATION (400),
	LIGHT_INSTALLATION (150);
	
	ToolType (int sharepointGuarantyValue) {
		this.sharepointGuarantyValue = sharepointGuarantyValue;
	}
	
	private final int sharepointGuarantyValue;
	
	public int getSharepointGuarantyValue () {
		return sharepointGuarantyValue;
	}
}
