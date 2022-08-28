package br.com.alterdata.widgets;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;

public abstract class JAbstractInputPanel<E extends JComponent> extends JPanel {

	public static final Dimension DEFAULT_SIZE = new Dimension(460, 80);
	
	public static final String TITLE_ALIGNMENT_KEY = "titleAlignment";

	private static final long serialVersionUID = 1L;
	private JLabel titleLabel;
	private E wrapperComponent;

	{
		if (UIManager.get(TITLE_ALIGNMENT_KEY) == null)
			UIManager.put(TITLE_ALIGNMENT_KEY, JLabel.LEADING);
	}
	
	public JAbstractInputPanel() {
		setPreferredSize(DEFAULT_SIZE);
		setMinimumSize(DEFAULT_SIZE);
		
		setBorder(new EmptyBorder(5, 0, 5, 0));
		setLayout(new BorderLayout(0, 5));
		
		titleLabel = new JLabel();
		wrapperComponent = input();
		
		add(titleLabel, BorderLayout.NORTH);
		add(wrapperComponent, BorderLayout.CENTER);

		titleLabel.setHorizontalAlignment(UIManager.getInt(TITLE_ALIGNMENT_KEY));
	}
	
	public void setTitleText(String title) {
		titleLabel.setText(title == null ? "Default Title" : title);
	}

	public void setTitleIcon(ImageIcon icon) {
		titleLabel.setIcon(icon);
	}
	
	public abstract E input();

	public E getWrapperedComponent() {
		return (E) wrapperComponent;
	}

}
