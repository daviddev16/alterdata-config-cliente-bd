package br.com.alterdata.widgets;

import javax.swing.JTextField;

public class JTextFieldInputPanel extends JAbstractInputPanel<JTextField> {

	private static final long serialVersionUID = 6685676329256231815L;

	@Override
	public JTextField input() {
		return new JTextField();
	}

}
