package com.networkprobe;

import java.io.IOException;

import br.com.alterdata.util.Utilities;

public class NetworkProbeLink {

	public static String findServerAddress() throws IOException, InterruptedException {
		NetworkProbeJarHomeDialog homeDialog = new NetworkProbeJarHomeDialog();
		homeDialog.setVisible(true);

		String javaHome = homeDialog.getJavaHomePanel().getWrapperedComponent().getText();
		String networkProbeJar = homeDialog.getNpJarPanel().getWrapperedComponent().getText();
		
		Process process = Runtime.getRuntime().exec(String.format("\"%s\\bin\\java.exe\" -jar \"%s\" -subjectTypeName CLIENT --enableLogging OFF", 
				javaHome, networkProbeJar));
		
		process.waitFor();
		
		return Utilities.getString(process.getInputStream());
	}
	
}
