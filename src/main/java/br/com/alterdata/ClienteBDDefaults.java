package br.com.alterdata;

import static br.com.alterdata.util.Conventions.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import br.com.alterdata.ui.ClienteBDWindow;

/*
 * Essa classe é responsavel por carregar todas as informaçoes no sistema.
 */
public final class ClienteBDDefaults {

	private static Map<ClienteBDPropertyType, String> clienteBDProperties = new HashMap<>();

	public static void setupDefaults() throws IOException, InterruptedException {
		for (ClienteBDPropertyType propertyType : ClienteBDPropertyType.values()) {
			String propertyCurrentValue = AlterdataAPI.queryClienteBDProperty(propertyType);
			getProperties().putIfAbsent(propertyType, propertyCurrentValue);
		}
	}

	public static void loadAllDefaults(ClienteBDWindow clienteBDWindow) {

		clienteBDWindow.getOtherDatabaseCheckBox().setSelected(toBooleanValue(
				getProperties().get(ClienteBDPropertyType.CHANGE_DATABASE_CONNECTION)));		

		clienteBDWindow.getOtherProviderCheckBox().setSelected(toBooleanValue(
				getProperties().get(ClienteBDPropertyType.CHANGE_DATABASE_PROVIDER)));	

		clienteBDWindow.getOtherServerCheckBox().setSelected(toBooleanValue(
				getProperties().get(ClienteBDPropertyType.CHANGE_SERVER_ADDRESS)));	

		clienteBDWindow.getDatabasePanel().getWrapperedComponent().setText(
				getProperties().get(ClienteBDPropertyType.DATABASE_NAME));	

		clienteBDWindow.getServerPanel().getWrapperedComponent().setText(
				getProperties().get(ClienteBDPropertyType.SERVER_ADDRESS));	

		clienteBDWindow.getProviderPanel().getWrapperedComponent().setSelectedItem(
				getProperties().get(ClienteBDPropertyType.DATABASE_PROVIDER));

	}

	public static void registerAllChanges(ClienteBDWindow clienteBDWindow) throws IOException {

		AlterdataAPI.updateClienteBDProperty(ClienteBDPropertyType.CHANGE_DATABASE_CONNECTION, 
				toStringValue(clienteBDWindow.getOtherDatabaseCheckBox().isSelected()));

		AlterdataAPI.updateClienteBDProperty(ClienteBDPropertyType.CHANGE_DATABASE_PROVIDER, 
				toStringValue(clienteBDWindow.getOtherProviderCheckBox().isSelected()));

		AlterdataAPI.updateClienteBDProperty(ClienteBDPropertyType.CHANGE_SERVER_ADDRESS, 
				toStringValue(clienteBDWindow.getOtherServerCheckBox().isSelected()));

		AlterdataAPI.updateClienteBDProperty(ClienteBDPropertyType.DATABASE_NAME, 
				clienteBDWindow.getDatabasePanel().getWrapperedComponent().getText());
		
		AlterdataAPI.updateClienteBDProperty(ClienteBDPropertyType.SERVER_ADDRESS, 
				clienteBDWindow.getServerPanel().getWrapperedComponent().getText());
		
		AlterdataAPI.updateClienteBDProperty(ClienteBDPropertyType.DATABASE_PROVIDER, 
				(String)clienteBDWindow.getProviderPanel().getWrapperedComponent().getSelectedItem());

	}

	public static Map<ClienteBDPropertyType, String> getProperties() {
		return clienteBDProperties;
	}

}
