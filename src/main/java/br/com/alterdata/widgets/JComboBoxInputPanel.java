package br.com.alterdata.widgets;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class JComboBoxInputPanel<C> extends JAbstractInputPanel<JComboBox<C>> {

	private static final long serialVersionUID = 523753837720253366L;

	private DefaultComboBoxModel<C> comboboxModel;
	
	@Override
	public JComboBox<C> input() {
		comboboxModel = new DefaultComboBoxModel<>();
		return new JComboBox<C>(comboboxModel);
	}
	
	public DefaultComboBoxModel<C> getModel() {
		return comboboxModel;
	}

}
