package de.laulau.randomKeyGenerator;

import java.awt.Image;

import javax.swing.JFrame;

public class createWindow extends JFrame {
	
	private static final long serialVersionUID = -7546354974154464471L;
	
	
	public createWindow(int width, int height, String title) {
		this.setSize(width, height);
		this.setTitle(title);
		this.setVisible(true);
	}
	
	public createWindow(int width, int height, String title, int onClose) {
		this.setSize(width, height);
		this.setTitle(title);
		this.setDefaultCloseOperation(onClose);
		this.setVisible(true);
	}
	
	public createWindow(int width, int height, String title, int onClose, Image icon) {
		this.setSize(width, height);
		this.setTitle(title);
		this.setIconImage(icon);
		this.setDefaultCloseOperation(onClose);
		this.setVisible(true);
	}
	
	public createWindow(int width, int height, String title, Image icon) {
		this.setSize(width, height);
		this.setTitle(title);
		this.setIconImage(icon);
		this.setVisible(true);
	}
	
}
