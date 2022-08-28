package br.com.alterdata.ui;

import java.io.IOException;
import java.net.InetAddress;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.networkprobe.NetworkProbeLink;

import br.com.alterdata.ClienteBDDefaults;
import br.com.alterdata.ClienteBDPropertyType;
import br.com.alterdata.widgets.JComboBoxInputPanel;
import br.com.alterdata.widgets.JTextFieldInputPanel;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ClienteBDWindow extends JFrame {

	private static final long serialVersionUID = -7526762001192293317L;

	private JPanel contentPane;
	private JTextFieldInputPanel databasePanel;
	private JTextFieldInputPanel serverPanel;
	private JComboBoxInputPanel<String> providerPanel;
	private JPanel checkOptionsPanel;
	private JPanel configurationPnale;
	private JCheckBox otherServerCheckBox;
	private JCheckBox otherDatabaseCheckBox;
	private JCheckBox otherProviderCheckBox;
	private JButton btnProcurarServidor;

	public static void open() throws IOException {
		new ClienteBDWindow();
	}

	public ClienteBDWindow() throws IOException {

		setResizable(false);
		setTitle(Laf.TITLE);
		setIconImage(ImageIO.read( ClienteBDWindow.class.getResourceAsStream("/icon_64px.png") ));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 454);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		configurationPnale = new JPanel();
		configurationPnale.setBounds(10, 76, 381, 290);
		contentPane.add(configurationPnale);
		configurationPnale.setLayout(null);

		providerPanel = new JComboBoxInputPanel<String>();
		for (String providerDefaults : ClienteBDPropertyType.DATABASE_PROVIDER.getDefaults()) {
			providerPanel.getModel().addElement(providerDefaults);	
		}

		providerPanel.setBounds(0, 0, 381, 62);
		configurationPnale.add(providerPanel);
		providerPanel.setName("provider");
		providerPanel.setTitleText("Provedor do Banco de Dados");

		serverPanel = new JTextFieldInputPanel();
		serverPanel.setBounds(0, 73, 381, 62);
		configurationPnale.add(serverPanel);
		serverPanel.setName("server");
		serverPanel.getWrapperedComponent().setText(InetAddress.getLoopbackAddress().getHostAddress());
		serverPanel.setTitleText("Nome do Servidor");

		databasePanel = new JTextFieldInputPanel();
		databasePanel.setBounds(0, 146, 381, 62);
		configurationPnale.add(databasePanel);
		databasePanel.setName("database");
		databasePanel.setTitleText("Nome do Banco de Dados");

		checkOptionsPanel = new JPanel();
		checkOptionsPanel.setBounds(0, 215, 381, 75);
		configurationPnale.add(checkOptionsPanel);
		checkOptionsPanel.setLayout(null);

		otherServerCheckBox = new JCheckBox("Permitir login em outros servidores");
		otherServerCheckBox.setBounds(0, 0, 373, 23);
		checkOptionsPanel.add(otherServerCheckBox);

		otherDatabaseCheckBox = new JCheckBox("Permitir login em outros bancos de dados");
		otherDatabaseCheckBox.setBounds(0, 26, 373, 23);
		checkOptionsPanel.add(otherDatabaseCheckBox);

		otherProviderCheckBox = new JCheckBox("Permitir login em outros serviços");
		otherProviderCheckBox.setBounds(0, 52, 373, 23);
		checkOptionsPanel.add(otherProviderCheckBox);
		
		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(-1);
			}
		});
		cancelBtn.setBounds(302, 377, 89, 26);
		contentPane.add(cancelBtn);
		
		JButton okBtn = new JButton("OK");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ClienteBDDefaults.registerAllChanges(ClienteBDWindow.this);
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					JOptionPane.showMessageDialog(null, "A configuração foi salva.");
					System.exit(-1);
				}
			}
		});
		okBtn.setBounds(209, 377, 89, 26);
		contentPane.add(okBtn);
		
		JLabel lblNewLabel = new JLabel("<html>\r\nConexão com o Banco de Dados<br>\r\n<font size=2>Configurar para acessar o banco de dados no servidor principal</font>\r\n</html>");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/icon_32px.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 401, 54);
		contentPane.add(lblNewLabel);
		
		btnProcurarServidor = new JButton("Auto-configurar servidor...");
		btnProcurarServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String serverAddress =  NetworkProbeLink.findServerAddress();
					
					synchronized (NetworkProbeLink.class) {
						System.out.println(serverAddress);
						getServerPanel().getWrapperedComponent().setText(serverAddress);
					}
					
					
				} catch (IOException | InterruptedException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Houve um erro ao tentar iniciar o network-probe.", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});
		btnProcurarServidor.setBounds(10, 379, 189, 26);
		contentPane.add(btnProcurarServidor);

		
		ClienteBDDefaults.loadAllDefaults(this);
		synchronized (ClienteBDDefaults.class) {
			setVisible(true);
		}

	}

	public JTextFieldInputPanel getDatabasePanel() {
		return databasePanel;
	}

	public JTextFieldInputPanel getServerPanel() {
		return serverPanel;
	}

	public JComboBoxInputPanel<String> getProviderPanel() {
		return providerPanel;
	}

	public JCheckBox getOtherServerCheckBox() {
		return otherServerCheckBox;
	}

	public JCheckBox getOtherDatabaseCheckBox() {
		return otherDatabaseCheckBox;
	}

	public JCheckBox getOtherProviderCheckBox() {
		return otherProviderCheckBox;
	}
}
