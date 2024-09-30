package com.sg.handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * this class is used to read and extract files data
 * 
 * 
 * @author Marwen Argoubi
 */
public class FileHandler {
	
	private String fileName;
	
	public FileHandler(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * method to extract data from the file
	 * @return string with the data
	 */
	public String extractFileData() {
		File file = new File(fileName);
		String data ="";
		try {
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				 data = reader.nextLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	/**
	 * method to exctract the coordinates and the commands from a given string
	 * @param input string with commands and coordinates
	 * @return hashMap<String,String> every key is the coordinates and the values are the commands
	 */
	public HashMap<String,String> coordinationExtractor(String input) {
		List<String> allCoordinates = new ArrayList<>();
		List<String> coordinateList = new ArrayList<>();
		List<String> allCommands = new ArrayList<>();
		HashMap<String,String> actions = new HashMap<String, String>();
		if(input != null) {
			String[] commands =  input.replaceAll(" ", "").split("(?<=\\D)(?=\\d)");
			for(String command:commands) {
				Pattern pattern = Pattern.compile("[NEWS]");
		        Matcher matcher = pattern.matcher(command);
		        if(matcher.find()) {
		        	String[] coordinates = command.split("(?<=[NEWS])");
		        	allCoordinates.add(coordinates[0]);
		        	allCommands.add(coordinates[1]);
		        	actions.put(coordinates[0], coordinates[1]);
		        	
			}
			}
			for(String coordinate:allCoordinates) {
			if(coordinate.length()>=3) {
        		String newKey =  coordinate.substring(coordinate.length()-3);
        		 String command = actions.get(coordinate);
        		 actions.remove(coordinate, command);
        		 actions.put(newKey, command);
        	}
			
		}
		
	}
		return actions;
	}
}
