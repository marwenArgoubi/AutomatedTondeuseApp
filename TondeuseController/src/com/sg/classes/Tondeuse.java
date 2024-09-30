package com.sg.classes;
/**
 * Class Tondeuse implements methods
 * to control the machine's directions
 * 
 * @author Marwen Argoubi
 */
public class Tondeuse implements Direction {
	
	private int x,y;
	private CompassDirection orientation;
	
	public Tondeuse(int x, int y, CompassDirection orientation) {
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}
/**
 * Change the machine's orientation to the left by 90°
 */
	@Override
	public void tournerGauche() {
		switch(orientation) {
		case NORTH: orientation = CompassDirection.WEST;break;
		case WEST: orientation = CompassDirection.SOUTH;break;
		case SOUTH: orientation = CompassDirection.EAST;break;
		case EAST: orientation = CompassDirection.NORTH;break;
		
		}
		
	}
	/**
	 * Change the machine's orientation to the right by 90°
	 */
	@Override
	public void tournerDroite() {
		switch(orientation) {
		case NORTH: orientation = CompassDirection.EAST;break;
		case WEST: orientation = CompassDirection.NORTH;break;
		case SOUTH: orientation = CompassDirection.WEST;break;
		case EAST: orientation = CompassDirection.SOUTH;break;
		
		}
		
	}
	/**
	 * Move the machine forward in the direction of the chosen orientation
	 */
	@Override
	public void avancer() {
		
		switch(orientation) {
		case NORTH: y++;break;
		case WEST: x--;break;
		case SOUTH: y--;break;
		case EAST: x++;break;
		
		}
		
	}
/**
 * Run the machine in diffrent directions based on the instruction input (D,G,A)
 * @param instructions instruction to chose the orientation of the machine D for right G for left and A for forward
 */
	@Override
	public void deplacer(String instructions) {
		for (char command : instructions.toCharArray()) {
            switch (command) {
                case 'D': tournerDroite(); break;
                case 'G': tournerGauche(); break;
                case 'A': avancer(); break;
            }
        }
		
	}
	/**
	 * method tha return the coordinates and the orientation of the machine
	 * @return string with finalPosition of the machine
	 */
	@Override
	public String finalPosition() {
		return x+","+y+","+orientation;
	}
}
