package de.laulau.randomKeyGenerator.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.laulau.randomKeyGenerator.Main;
import de.laulau.randomKeyGenerator.ButtonListeners.CopyButton;

public class UI implements ActionListener {
	
	public static String outputKey;
	
	//ImageIcon key = new ImageIcon("src/images/key.png");
	ImageIcon key = new ImageIcon(getClass().getClassLoader().getResource("key.png"));
	//ImageIcon lock = new ImageIcon("src/images/lock.png");
	ImageIcon lock = new ImageIcon(getClass().getClassLoader().getResource("lock.png"));
	JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	JButton generateButton = new JButton("Generate");
	JButton copyButton = new JButton("Copy");
	JLabel keyLabel = new JLabel(outputKey);
	static JCheckBox upperBox = new JCheckBox("Uppercase letters", true);
	static JCheckBox lowerBox = new JCheckBox("Lowercase letters", true);
	static JCheckBox symbolsBox = new JCheckBox("Symbols", true);
	JTextField prefix = new JTextField("key_");
	JTextField length = new JTextField("13");
	public static Color bgColor = new Color(154, 171, 158);
	int keylength;
	JFrame outputFrame = new JFrame();
	static JPanel outputPanel = new JPanel();
	
	public UI() {
		keyLabel.setHorizontalAlignment(JLabel.CENTER);
		
		generateButton.addActionListener(this);
		copyButton.addActionListener(new CopyButton());
		copyButton.setVisible(false);
		upperBox.setBackground(bgColor);
		lowerBox.setBackground(bgColor);
		symbolsBox.setBackground(bgColor);
		
		panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 200, 100));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(prefix);
		panel.add(length);
		panel.add(upperBox);
		panel.add(lowerBox);
		panel.add(symbolsBox);
		panel.add(generateButton);
		panel.setBackground(bgColor);
		
		outputPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		outputPanel.setLayout(new GridLayout(0, 1));
		outputPanel.setBackground(new Color(201, 134, 129));
		outputPanel.add(copyButton);
		outputPanel.add(keyLabel);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Key generator");
		frame.setIconImage(key.getImage());
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		
		outputFrame.add(outputPanel, BorderLayout.CENTER);
		outputFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		outputFrame.setTitle("Output Key");
		outputFrame.setIconImage(lock.getImage());
		outputFrame.setSize(341, 290);
		outputFrame.setVisible(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == generateButton) {
			if(!upperBox.isSelected() && !lowerBox.isSelected() && !symbolsBox.isSelected()) {
				System.out.println("Nothing is selected.");
				return;
			}
			
			try {
				keylength = Integer.parseInt(length.getText());
			} catch (Exception e) {
				System.out.println("The length was not an integer.");
			}
			
			outputKey = Main.generateKey(true, upperBox.isSelected(), lowerBox.isSelected(), symbolsBox.isSelected(), prefix.getText(), keylength);
			keyLabel.setText(outputKey);
			copyButton.setVisible(true);
			frame.setTitle("Key Generator - " + outputKey);
			outputFrame.setVisible(true);
		}
	}
	
	public static void setBackground(Color color) {
		panel.setBackground(color);
		outputPanel.setBackground(color);
		lowerBox.setBackground(color);
		upperBox.setBackground(color);
		symbolsBox.setBackground(color);
	}
	
}
