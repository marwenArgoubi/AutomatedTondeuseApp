package com.sg.classes;
/**
 * this interface represents the diffrent commands method
 * to control the machines
 * 
 * 
 * @author Marwen Argoubi
 */
public interface Direction {
	/**
	 * method to orient the machine left by 90°
	 */
	void tournerGauche();
	/**
	 * method to orient the machine right by 90°
	 */
	void tournerDroite();
	/**
	 * method to  Move the machine forward in the direction of the chosen orientation
	 */
	void avancer();
	/**
	 * Run the machine in diffrent directions based on the instruction input (D,G,A)
	 * @param str instruction to chose the orientation of the machine D for right G for left and A for forward
	 */
	void deplacer(String str);
	
	
	/**
	 * method tha return the coordinates and the orientation of the machine
	 * @return a string with final position
	 */
	String finalPosition();

}
