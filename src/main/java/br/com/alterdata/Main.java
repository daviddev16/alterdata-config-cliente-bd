package br.com.alterdata;

import java.awt.EventQueue;
import java.io.IOException;

import br.com.alterdata.ui.ClienteBDWindow;
import br.com.alterdata.ui.Laf;

public class Main {


	public static void main(String[] args) {

		try {
			Laf.setup();
			ClienteBDDefaults.setupDefaults();
		} catch (IOException | InterruptedException e1) {
			e1.printStackTrace();
		}
		EventQueue.invokeLater(() -> {
			try {
				ClienteBDWindow.open();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
	}
}
