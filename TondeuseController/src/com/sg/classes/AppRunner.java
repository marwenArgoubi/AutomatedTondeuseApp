package com.sg.classes;
/**
 * AppRunner Class to run the machines
 * uses the Interface Direction which is implemented by diffrent machines
 * 
 * 
 * @author Marwen Argoubi
 */
public class AppRunner {
	
	private Direction direction;

	public AppRunner(Direction direction) {
		this.direction = direction;
	}
	/**
	 * Launch the machine
	 * @param intructions contains the instruction to control the machine
	 */
	public void run(String intructions) {
		direction.deplacer(intructions);
		System.out.println(direction.finalPosition());
	}
}
