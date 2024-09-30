package com.sg.classes;

import java.util.Set;

import com.sg.handlers.FileHandler;
/**
 * Main class is the entry point of the program
 * this class will execute the application
 * 
 * 
 * @author Marwen Argoubi
 */
public class main {
	
/**
 * @param args command line argument -unused
 */
	public static void main(String[] args) {

        FileHandler fh = new FileHandler("file.txt");
        Set<String> keys = fh.coordinationExtractor(fh.extractFileData()).keySet();
        for(String key:keys) {
        	Tondeuse tondeuse = new Tondeuse(Integer.parseInt(String.valueOf(key.charAt(0))), Integer.parseInt(String.valueOf(key.charAt(1))), CompassDirection.fromChar(key.charAt(2)));
        	AppRunner robotRunnder = new AppRunner(tondeuse);
            robotRunnder.run(fh.coordinationExtractor(fh.extractFileData()).get(key));
        }
        
        
	}

}
