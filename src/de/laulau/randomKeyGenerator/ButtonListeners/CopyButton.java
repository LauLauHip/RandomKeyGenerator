package de.laulau.randomKeyGenerator.ButtonListeners;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.laulau.randomKeyGenerator.UI.UI;

public class CopyButton implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(UI.outputKey), null);
		System.out.println("Copied the key to clipboard.");
	}
	
}
