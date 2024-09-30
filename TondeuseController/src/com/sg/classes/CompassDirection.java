package com.sg.classes;

/**
 * this enum represents the compass directions
 * 
 * 
 * @author Marwen Argoubi
 */
public enum CompassDirection {
	NORTH('N'),
	EAST('E'),
	WEST('W'),
	SOUTH('S');

	private final char val;
	CompassDirection(char c) {
		this.val = c;
	}
	/**
	 * Method uses a char (N,W,S,E) and return an enum with the direction
	 * @param charValue char value representing the orientation
	 * @return compassDirection based on char input
	 */
	public static CompassDirection fromChar(char charValue) {
        for (CompassDirection cD : CompassDirection.values()) {
            if (cD.val == charValue) {
                return cD;
            }
        }
        return null;
}
}
