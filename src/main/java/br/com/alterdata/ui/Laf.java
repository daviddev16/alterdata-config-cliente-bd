package br.com.alterdata.ui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.util.SystemInfo;

public final class Laf {
	
	public static final String TITLE = "Alterdata - Configurador de Conexões";

	public static void setup() {
		FlatLaf lookAndFeel = new FlatDarculaLaf();
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		if (SystemInfo.isMacOS) {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty("apple.awt.application.name", TITLE);
		}
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);

		UIManager.put("TitlePane.menuBarEmbedded", true);
		
		System.setProperty("flatlaf.animation", "true");
		System.setProperty("flatlaf.uiScale", "1.0");

		UIManager.put("JButton.menuBarEmbedded", true);
		FlatLaf.setUseNativeWindowDecorations(true);
	}
	
}
