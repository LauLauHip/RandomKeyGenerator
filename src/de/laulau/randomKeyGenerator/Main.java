package de.laulau.randomKeyGenerator;

import java.awt.Color;
import java.util.Random;

import de.laulau.randomKeyGenerator.UI.SettingsUI;
import de.laulau.randomKeyGenerator.UI.UI;

public class Main {

	public static void main(String[] args) {
		if(args.length == 0) {
			
			System.out.println("Started without arguments.");
			new UI();
			try {
				UI.setBackground(new Color(SettingsUI.load()[0], SettingsUI.load()[1], SettingsUI.load()[2]));
			} catch (Exception e) {
				System.out.println("File not found.");
			}
			
		} else if(args.length == 1) {
			if(args[0].equals("-settings")) {
				
				System.out.println("Argument 1: settings.");
				new SettingsUI();
				if(SettingsUI.saveFile.exists()) {
					try {
						SettingsUI.setBackground(new Color(SettingsUI.load()[0], SettingsUI.load()[1], SettingsUI.load()[2]));
					} catch (Exception e) {
						System.out.println("File not found.");
					}
				} else {
					SettingsUI.setBackground(UI.bgColor);
				}
				
			} else if(args[0].equals("-rts")) {
				System.out.println("Argument 2: real-time settings.");
				new UI();
				new SettingsUI();
				try {
					UI.setBackground(new Color(SettingsUI.load()[0], SettingsUI.load()[1], SettingsUI.load()[2]));
					SettingsUI.setBackground(new Color(SettingsUI.load()[0], SettingsUI.load()[1], SettingsUI.load()[2]));
				} catch (Exception e) {
					System.out.println("File not found.");
				}
			} else if(args[0].equals("-help")) {
				System.out.println("Arguments:");
				System.out.println("-settings\n-rts\n-help");
			}
		}
		
		System.out.println("Have fun with LauLauHip's generator!");
		
	}
	
	public static String generateKey(boolean Print, boolean Upper, boolean Lower, boolean Symbol, String Prefix, int Length) {

		String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowercase = uppercase.toLowerCase();
		String symbols = "!?=$&,:;.1234567890";
		boolean upper = Upper;
		boolean lower = Lower;
		boolean symbol = Symbol;
		String finalchars = "";
		
		int length = Length;
		char[] textArray = new char[length];
		Random random = new Random();
		
		String finalKey = Prefix;
		
		if(upper)
			finalchars += uppercase;
		if(lower)
			finalchars += lowercase;
		if(symbol)
			finalchars += symbols;
		
		for(int i = 0; i < length; i++) {
			textArray[i] = finalchars.charAt(random.nextInt(finalchars.length()));
			finalKey += textArray[i];
		}
		
		if(Print)
			System.out.println(finalKey);
		
		return finalKey;
		
	}

}
