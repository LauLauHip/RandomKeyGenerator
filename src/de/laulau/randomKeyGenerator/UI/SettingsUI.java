package de.laulau.randomKeyGenerator.UI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

import de.laulau.randomKeyGenerator.createWindow;
import de.laulau.randomKeyGenerator.ChangeListeners.SettingsSliders;

public class SettingsUI implements ActionListener {
	
	public static JSlider mainR = new JSlider(0, 255, 154);
	public static JSlider mainG = new JSlider(0, 255, 171);
	public static JSlider mainB = new JSlider(0, 255, 158);
	JButton saveButton = new JButton("Save");
	static JPanel savePanel = new JPanel();
	public static JPanel panel1 = new JPanel();
	
	public static File saveFile = new File(System.getProperty("user.home") + "\\keyGenerator", "colorSave.rkg");
	
	public SettingsUI() {

		JLabel hR = new JLabel("Red");
		JLabel hG = new JLabel("Green");
		JLabel hB = new JLabel("Blue");
		
		saveButton.addActionListener(this);
		
		mainR.addChangeListener(new SettingsSliders());
		mainR.setPaintTicks(true);
		mainR.setMajorTickSpacing(25);
		mainR.setMinorTickSpacing(5);
		mainR.setPaintLabels(true);
		mainR.setOrientation(SwingConstants.VERTICAL);
		
		mainG.addChangeListener(new SettingsSliders());
		mainG.setPaintTicks(true);
		mainG.setMajorTickSpacing(25);
		mainG.setMinorTickSpacing(5);
		mainG.setPaintLabels(true);
		mainG.setOrientation(SwingConstants.VERTICAL);
		
		mainB.addChangeListener(new SettingsSliders());
		mainB.setPaintTicks(true);
		mainB.setMajorTickSpacing(25);
		mainB.setMinorTickSpacing(5);
		mainB.setPaintLabels(true);
		mainB.setOrientation(SwingConstants.VERTICAL);
		
		if(saveFile.exists()) {
			mainR.setValue(load()[0]);
			mainG.setValue(load()[1]);
			mainB.setValue(load()[2]);
		}
		
		panel1.setLayout(new GridLayout(0, 3));
		panel1.add(hR);
		panel1.add(hG);
		panel1.add(hB);
		panel1.add(mainR);
		panel1.add(mainG);
		panel1.add(mainB);
		
		savePanel.setLayout(new GridLayout(0, 1));
		savePanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		savePanel.add(saveButton);
		
		createWindow sWindow = new createWindow(223, 472, "Settings", JFrame.EXIT_ON_CLOSE);
		sWindow.add(panel1);
		sWindow.setResizable(false);
		sWindow.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("key.png")).getImage());
		
		createWindow saveWindow = new createWindow(0, 0, "Save");
		saveWindow.add(savePanel);
		saveWindow.pack();
		saveWindow.setResizable(false);
		saveWindow.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("lock.png")).getImage());
		
	}
	
	public static void save() {
		try {
			
			FileWriter writer = new FileWriter(saveFile);
			writer.write(mainR.getValue() + "\n");
			writer.write(mainG.getValue() + "\n");
			writer.write(mainB.getValue() + "");
			writer.close();
			saveFile.mkdirs();
			if(saveFile.createNewFile()) {
				System.out.println("File created: " + saveFile.getAbsolutePath());
			}
			
		} catch (Exception e) {
			System.out.println("Error trying to save the file:");
			e.printStackTrace();
		}
	}
	
	public static int[] load() {
		try {
			
			Scanner scanner = new Scanner(saveFile);
			int[] rgb = new int[3];
			for(int i = 0; i < rgb.length ; i++) {
				rgb[i] = scanner.nextInt();
			}
			
			scanner.close();
			return rgb;
			
		} catch (Exception e) {
			System.out.println("Error trying to load the file");
			return null;
		}
	}
	
	public static void setBackground(Color color) {
		savePanel.setBackground(color);
		panel1.setBackground(color);
		mainR.setBackground(color);
		mainG.setBackground(color);
		mainB.setBackground(color);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		save();
	}
	
}
