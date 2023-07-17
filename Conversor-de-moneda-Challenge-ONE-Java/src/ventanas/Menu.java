package ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import clases.Lista;
import clases.ListaConversores;
import clases.ListaDivisas;

/**
 * menu
 */
@SuppressWarnings("serial")
public class Menu extends JFrame {

	/**
	 * 
	 */

	public JPanel contentPane;
	protected JComboBox<String> comboBoxDe = new JComboBox<String>();
	protected JComboBox<String> comboBoxA = new JComboBox<String>();

	protected JTextField textFieldMonto;
	double total, monto;
	protected double tasa;
	ConvertidorTemperatura panelCt = new ConvertidorTemperatura();
	public Lista listC = new ListaConversores(null);
	public Lista listD1 = new ListaDivisas(null, 0);
	public Lista listD2 = new ListaDivisas(null, 0);
	public String resultado;
	protected JTextField textField;

	public double getTasa() {
		return tasa;
	}

	public double getMonto() {
		return monto = Double.valueOf(textFieldMonto.getText());
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Menu() throws Exception {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 418);
		setSize(711, 418);
		setResizable(false);
		setTitle("Conversores");
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(panelCt);

		JPanel panelCambioDivisa = new JPanel();
		panelCambioDivisa.setForeground(new Color(0, 0, 0));
		panelCambioDivisa.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GREEN, null, null, null));
		panelCambioDivisa.setBackground(new Color(0, 0, 255));
		panelCambioDivisa.setBounds(10, 99, 675, 269);
		panelCambioDivisa.setVisible(false);
		contentPane.add(panelCambioDivisa);
		panelCambioDivisa.setLayout(null);

		JLabel lbltitulo = new JLabel("Selecciona una opcion de convercion");
		lbltitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbltitulo.setBounds(10, 11, 256, 22);
		contentPane.add(lbltitulo);

		JLabel lblCambioDeDividas = new JLabel("CAMBIO DE DIVISAS");
		lblCambioDeDividas.setForeground(Color.WHITE);
		lblCambioDeDividas.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCambioDeDividas.setBounds(262, 11, 163, 14);
		panelCambioDivisa.add(lblCambioDeDividas);

		JLabel lblMonto = new JLabel("Monto");
		lblMonto.setForeground(new Color(255, 255, 255));
		lblMonto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMonto.setBounds(10, 61, 139, 14);
		panelCambioDivisa.add(lblMonto);

		JLabel lblDe = new JLabel("De");
		lblDe.setForeground(new Color(255, 255, 255));
		lblDe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDe.setBounds(225, 61, 211, 14);
		panelCambioDivisa.add(lblDe);

		JLabel lblA = new JLabel("A");
		lblA.setForeground(new Color(255, 255, 255));
		lblA.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblA.setBounds(454, 61, 211, 14);
		panelCambioDivisa.add(lblA);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotal.setBounds(225, 226, 72, 32);
		panelCambioDivisa.add(lblTotal);

		JLabel lblResultado = new JLabel("0.00");
		lblResultado.setBackground(Color.RED);
		lblResultado.setForeground(Color.GREEN);

		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResultado.setBounds(290, 236, 284, 14);
		panelCambioDivisa.add(lblResultado);

		JLabel lblIconoCd = new JLabel("");
		lblIconoCd.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblIconoCd.setBorder(
						new BevelBorder(BevelBorder.RAISED, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN));
			}
		});
		lblIconoCd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblIconoCd.setBorder(null);
			}
		});
		lblIconoCd.setToolTipText("Conversor de divisas");
		lblIconoCd.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoCd.setIcon(new ImageIcon("src/imagenes/cambio-de-divisas.png"));
		lblIconoCd.setForeground(Color.BLACK);
		lblIconoCd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIconoCd.setBounds(10, 100, 90, 77);
		contentPane.add(lblIconoCd);

		JLabel lblIconoCt = new JLabel("");
		lblIconoCt.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblIconoCt.setBorder(
						new BevelBorder(BevelBorder.RAISED, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN));
			}
		});
		lblIconoCt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblIconoCt.setBorder(null);
			}
		});
		lblIconoCt.setIcon(new ImageIcon("src/imagenes/termimetro.jpg"));
		lblIconoCt.setToolTipText("Conversor de Temperatura");
		lblIconoCt.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoCt.setForeground(Color.BLACK);
		lblIconoCt.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIconoCt.setBounds(110, 100, 90, 77);
		contentPane.add(lblIconoCt);

		JComboBox<String> comboBoxConversores = new JComboBox<String>();
		listC.mostrarLista(comboBoxConversores);
		comboBoxConversores.setBounds(10, 38, 256, 22);
		comboBoxConversores.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (comboBoxConversores.getSelectedItem() == listC.lista.get(0).getConversores()) {
					panelCambioDivisa.setVisible(false);
					lblIconoCd.setBounds(10, 100, 90, 77);
					lblIconoCt.setBounds(110, 100, 90, 77);
					lblIconoCd.setVisible(true);
					panelCt.setVisible(false);

				} else if (comboBoxConversores.getSelectedItem() == listC.lista.get(1).getConversores()) {
					panelCambioDivisa.setVisible(true);
					lblIconoCd.setBounds(426, 11, 90, 77);
					lblIconoCt.setBounds(110, 100, 90, 77);
					panelCt.setVisible(false);

				} else if (comboBoxConversores.getSelectedItem() == listC.lista.get(2).getConversores()) {
					panelCambioDivisa.setVisible(false);
					lblIconoCd.setBounds(10, 100, 90, 77);
					lblIconoCt.setBounds(426, 11, 90, 77);
					// lblIconoCd.setVisible(false);
					panelCt.setVisible(true);

				}
			}
		});
		contentPane.add(comboBoxConversores);

		lblIconoCd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBoxConversores.setSelectedIndex(1);
				lblIconoCd.setBounds(426, 11, 90, 77);
				panelCambioDivisa.setVisible(true);
			}
		});

		lblIconoCt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBoxConversores.setSelectedIndex(2);
				lblIconoCd.setBounds(10, 100, 90, 77);
				lblIconoCt.setBounds(426, 11, 90, 77);
				panelCt.setVisible(true);
			}
		});

		textFieldMonto = new JTextField();
		textFieldMonto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldMonto.setText("");
			}
		});
		textFieldMonto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				int key = evt.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;
				boolean punto = key == 46;
				if (!(numeros || punto)) {
					evt.consume();
				}
				if (textFieldMonto.getText().trim().length() == 10) {
					evt.consume();
				}
			}
		});
		textFieldMonto.setFont(new Font("Tahoma", Font.BOLD, 12));
		textFieldMonto.setBounds(10, 86, 205, 32);
		textFieldMonto.setText(String.valueOf(monto));
		panelCambioDivisa.add(textFieldMonto);
		textFieldMonto.setColumns(10);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(581, 128, 84, 21);
		panelCambioDivisa.add(textField);
		
		comboBoxDe.setBounds(225, 86, 219, 32);
		listD1.mostrarLista(comboBoxDe);
		panelCambioDivisa.add(comboBoxDe);
		
		comboBoxA.setBounds(454, 85, 211, 32);

		listD2.mostrarLista(comboBoxA);
		textField.setText(String.valueOf(listD2.lista.get(comboBoxA.getSelectedIndex()).getTasa()));
		comboBoxA.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				textField.setText(String.valueOf(listD2.lista.get(comboBoxA.getSelectedIndex()).getTasa()));
			}
		});
		panelCambioDivisa.add(comboBoxA);

		JButton btnCalcularDivisa = new JButton("Calcular");
		btnCalcularDivisa.setBounds(262, 169, 139, 32);
		panelCambioDivisa.add(btnCalcularDivisa);

		JLabel lblTasa = new JLabel("Tasa:");
		lblTasa.setForeground(Color.WHITE);
		lblTasa.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTasa.setBounds(528, 123, 52, 32);
		panelCambioDivisa.add(lblTasa);

		comboBoxA.setSelectedIndex(1);

		JLabel lblConversores = new JLabel("Conversores");
		lblConversores.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConversores.setBounds(301, 79, 90, 22);
		contentPane.add(lblConversores);	
		
		btnCalcularDivisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				

				if (textFieldMonto.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Porfavor coloque el monto");
					textFieldMonto.setText("0.00");
				} else {

					if (comboBoxDe.getSelectedItem() == listD1.lista.get(comboBoxDe.getSelectedIndex()).getDivisa()// cambio de DOP a DOP
							&& comboBoxA.getSelectedItem() == listD2.lista.get(comboBoxA.getSelectedIndex())
									.getDivisa()) {

						monto = Double.valueOf(textFieldMonto.getText());

						total = (listD1.lista.get(comboBoxDe.getSelectedIndex()).getTasa() * monto)
								/ listD2.lista.get(comboBoxA.getSelectedIndex()).getTasa();
						total = (double) (Math.round(total * 100d) / 100d);
						resultado = String.valueOf(total + " " + comboBoxA.getSelectedItem().toString());
						lblResultado.setText(resultado);

					} else if (comboBoxDe.getSelectedItem() == listD1.lista.get(comboBoxDe.getSelectedIndex())
							.getDivisa()// cambio de DOP a euro
							&& comboBoxA.getSelectedItem() == listD2.lista.get(comboBoxA.getSelectedIndex())
									.getDivisa()) {

						monto = Double.valueOf(textFieldMonto.getText());

						total = (listD1.lista.get(comboBoxDe.getSelectedIndex()).getTasa() * monto)
								/ listD2.lista.get(comboBoxA.getSelectedIndex()).getTasa();
						total = (double) (Math.round(total * 100d) / 100d);
						resultado = String
								.valueOf(total + " " + listD2.lista.get(comboBoxA.getSelectedIndex()).getDivisa());
						lblResultado.setText(resultado);

					} else if (comboBoxDe.getSelectedItem() == listD1.lista.get(comboBoxDe.getSelectedIndex())
							.getDivisa()// cambio de DOP a USD
							&& comboBoxA.getSelectedItem() == listD2.lista.get(comboBoxA.getSelectedIndex())
									.getDivisa()) {

						monto = Double.valueOf(textFieldMonto.getText());

						total = (listD1.lista.get(comboBoxDe.getSelectedIndex()).getTasa() * monto)
								/ listD2.lista.get(comboBoxA.getSelectedIndex()).getTasa();
						total = (double) (Math.round(total * 100d) / 100d);
						resultado = String
								.valueOf(total + " " + listD2.lista.get(comboBoxA.getSelectedIndex()).getDivisa());
						lblResultado.setText(resultado);

					} else if (comboBoxDe.getSelectedItem() == listD1.lista.get(2).getDivisa()// cambio de euro a DOP
							&& comboBoxA.getSelectedItem() == listD2.lista.get(comboBoxA.getSelectedIndex())
									.getDivisa()) {

						monto = Double.valueOf(textFieldMonto.getText());

						total = (listD1.lista.get(2).getTasa() * monto)
								/ listD2.lista.get(comboBoxA.getSelectedIndex()).getTasa();
						total = (double) (Math.round(total * 100d) / 100d);
						resultado = String
								.valueOf(total + " " + listD2.lista.get(comboBoxA.getSelectedIndex()).getDivisa());
						lblResultado.setText(resultado);

					} else if (comboBoxDe.getSelectedItem() == listD1.lista.get(2).getDivisa()// cambio de euro a euro
							&& comboBoxA.getSelectedItem() == listD2.lista.get(comboBoxA.getSelectedIndex())
									.getDivisa()) {

						monto = Double.valueOf(textFieldMonto.getText());

						total = (listD1.lista.get(2).getTasa() * monto)
								/ listD2.lista.get(comboBoxA.getSelectedIndex()).getTasa();
						total = (double) (Math.round(total * 100d) / 100d);
						resultado = String
								.valueOf(total + " " + listD2.lista.get(comboBoxA.getSelectedIndex()).getDivisa());
						lblResultado.setText(resultado);

					} else if (comboBoxDe.getSelectedItem() == listD1.lista.get(2).getDivisa()// cambio de euro a USD
							&& comboBoxA.getSelectedItem() == listD2.lista.get(comboBoxA.getSelectedIndex())
									.getDivisa()) {

						monto = Double.valueOf(textFieldMonto.getText());

						total = (listD1.lista.get(2).getTasa() * monto)
								/ listD2.lista.get(comboBoxA.getSelectedIndex()).getTasa();
						total = (double) (Math.round(total * 100d) / 100d);
						resultado = String
								.valueOf(total + " " + listD2.lista.get(comboBoxA.getSelectedIndex()).getDivisa());
						lblResultado.setText(resultado);

					} else if (comboBoxDe.getSelectedItem() == listD1.lista.get(3).getDivisa()// cambio de USD a DOP
							&& comboBoxA.getSelectedItem() == listD2.lista.get(comboBoxA.getSelectedIndex())
									.getDivisa()) {

						monto = Double.valueOf(textFieldMonto.getText());

						total = (listD1.lista.get(3).getTasa() * monto)
								/ listD2.lista.get(comboBoxA.getSelectedIndex()).getTasa();
						total = (double) (Math.round(total * 100d) / 100d);
						resultado = String
								.valueOf(total + " " + listD2.lista.get(comboBoxA.getSelectedIndex()).getDivisa());
						lblResultado.setText(resultado);

					} else if (comboBoxDe.getSelectedItem() == listD1.lista.get(3).getDivisa()// cambio de USD a euro
							&& comboBoxA.getSelectedItem() == listD2.lista.get(comboBoxA.getSelectedIndex())
									.getDivisa()) {

						monto = Double.valueOf(textFieldMonto.getText());

						total = (listD1.lista.get(3).getTasa() * monto)
								/ listD2.lista.get(comboBoxA.getSelectedIndex()).getTasa();
						total = (double) (Math.round(total * 100d) / 100d);
						resultado = String
								.valueOf(total + " " + listD2.lista.get(comboBoxA.getSelectedIndex()).getDivisa());
						lblResultado.setText(resultado);

					} else if (comboBoxDe.getSelectedItem() == listD1.lista.get(comboBoxA.getSelectedIndex())
							.getDivisa()// cambio de USD a USD
							&& comboBoxA.getSelectedItem() == listD2.lista.get(comboBoxA.getSelectedIndex())
									.getDivisa()) {

						monto = Double.valueOf(textFieldMonto.getText());

						total = (listD1.lista.get(3).getTasa() * monto)
								/ listD2.lista.get(comboBoxA.getSelectedIndex()).getTasa();
						total = (double) (Math.round(total * 100d) / 100d);
						resultado = String
								.valueOf(total + " " + listD2.lista.get(comboBoxA.getSelectedIndex()).getDivisa());
						lblResultado.setText(resultado);

					}
				}

			}
		});

	}
}
