package com.networkprobe;


import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import br.com.alterdata.widgets.JTextFieldInputPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NetworkProbeJarHomeDialog extends JDialog {

	private static final long serialVersionUID = 2924259560256809795L;
	private final JPanel contentPanel = new JPanel();
	private JTextFieldInputPanel javaHomePanel;
	private JTextFieldInputPanel npJarPanel;
	private JButton okBtn;

	public NetworkProbeJarHomeDialog() {
		setModal(true);
		setResizable(false);
		setTitle("Network Probe Jar Home");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 626, 248);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel titleLbl = new JLabel("<html>Não foi possível achar uma conexão com o Network Probe<br><center>Por favor, preencha os seguintes campos:</html>");
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setBounds(0, 6, 610, 42);
		contentPanel.add(titleLbl);

		npJarPanel = new JTextFieldInputPanel();
		npJarPanel.getWrapperedComponent().setText("C:\\Users\\David\\Desktop\\network-probe-versions\\network-probe-1.3\\network-probe.jar");
		npJarPanel.setTitleText("Network Probe Jar File");
		npJarPanel.setBounds(10, 53, 590, 56);
		contentPanel.add(npJarPanel);

		javaHomePanel = new JTextFieldInputPanel();
		javaHomePanel.getWrapperedComponent().setText("C:\\Users\\David\\Desktop\\network-probe-versions\\network-probe-1.3\\jre");
		javaHomePanel.setTitleText("Java Home");
		javaHomePanel.setBounds(10, 107, 590, 56);
		contentPanel.add(javaHomePanel);
		
		okBtn = new JButton("Ok");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		okBtn.setBounds(511, 174, 89, 23);
		contentPanel.add(okBtn);
	}

	public JTextFieldInputPanel getJavaHomePanel() {
		return javaHomePanel;
	}

	public JTextFieldInputPanel getNpJarPanel() {
		return npJarPanel;
	}

}
