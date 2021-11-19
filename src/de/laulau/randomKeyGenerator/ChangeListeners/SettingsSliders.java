package de.laulau.randomKeyGenerator.ChangeListeners;

import java.awt.Color;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.laulau.randomKeyGenerator.UI.SettingsUI;
import de.laulau.randomKeyGenerator.UI.UI;

public class SettingsSliders implements ChangeListener {
	
	Color finalCol = new Color(0, 0, 0);
	int r = 0;
	int g = 0;
	int b = 0;
	
	@Override
	public void stateChanged(ChangeEvent e) {
		r = SettingsUI.mainR.getValue();
		g = SettingsUI.mainG.getValue();
		b = SettingsUI.mainB.getValue();
		finalCol = new Color(r, g, b);
		SettingsUI.setBackground(finalCol);
		UI.setBackground(finalCol);
	}

}
