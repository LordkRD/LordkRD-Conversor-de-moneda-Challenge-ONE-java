package ventanas;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import clases.Listas;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 */

@SuppressWarnings("serial")
public class ConvertidorTemperatura extends JPanel implements Listas {

	private JTextField textFieldTemp;
	private JTextField textFieldResultado;
	protected double gradoCelsius, gradoFahrenheit, gradoKelvin, grado;
	String temperatura;

	ArrayList<ConvertidorTemperatura> listaCt = new ArrayList<ConvertidorTemperatura>();

	public ConvertidorTemperatura(String temperatura) {
		super();
		this.temperatura = temperatura;
	}
	@Override
	public void mostrarLista(JComboBox<String> cb) {

		listaCt.add(new ConvertidorTemperatura("Grado Celsius"));
		listaCt.add(new ConvertidorTemperatura("Grado Fahrenheit"));
		listaCt.add(new ConvertidorTemperatura("Grado kelvin"));

		for (ConvertidorTemperatura listaDeTemperatura : listaCt) {

			cb.addItem(listaDeTemperatura.getTemperatura());

		}
	}

	/**
	 * Create the panel.
	 */
	public ConvertidorTemperatura() {
		setLayout(null);

		textFieldTemp = new JTextField();
		textFieldTemp.setBounds(147, 103, 163, 31);
		add(textFieldTemp);
		textFieldTemp.setColumns(10);
		JPanel panelTemperatura = new JPanel();
		setForeground(new Color(0, 0, 0));
		setBorder(new BevelBorder(BevelBorder.RAISED, Color.GREEN, null, null, null));
		setBackground(new Color(0, 0, 255));

		setBounds(10, 99, 675, 269);
		setVisible(false);

		add(panelTemperatura);

		textFieldResultado = new JTextField();
		textFieldResultado.setColumns(10);
		textFieldResultado.setBounds(360, 103, 163, 31);
		add(textFieldResultado);

		JLabel lblNewLabel = new JLabel("=");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(317, 103, 33, 31);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Temperatura");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(179, 83, 95, 14);
		add(lblNewLabel_1);

		JComboBox<String> comboBoxTempIn = new JComboBox<String>();
		comboBoxTempIn.setBounds(145, 159, 162, 22);
		mostrarLista(comboBoxTempIn);
		add(comboBoxTempIn);
		listaCt.clear();
		JComboBox<String> comboBoxTempOut = new JComboBox<String>();
		mostrarLista(comboBoxTempOut);
		comboBoxTempOut.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBoxTempOut.getSelectedItem() == listaCt.get(1).getTemperatura()
						&& comboBoxTempIn.getSelectedItem() == listaCt.get(1).getTemperatura()) {
					comboBoxTempIn.setSelectedIndex(2);
				} else if (comboBoxTempOut.getSelectedItem() == listaCt.get(0).getTemperatura()
						&& comboBoxTempIn.getSelectedItem() == listaCt.get(0).getTemperatura()) {
					comboBoxTempIn.setSelectedIndex(2);
				} else if (comboBoxTempOut.getSelectedItem() == listaCt.get(2).getTemperatura()
						&& comboBoxTempIn.getSelectedItem() == listaCt.get(2).getTemperatura()) {
					comboBoxTempIn.setSelectedIndex(1);
				}
			}
		});
		comboBoxTempOut.setBounds(361, 159, 162, 22);

		add(comboBoxTempOut);
		comboBoxTempOut.setSelectedIndex(1);
		comboBoxTempIn.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBoxTempIn.getSelectedItem() == listaCt.get(0).getTemperatura()) {
					comboBoxTempOut.setSelectedIndex(1);
				} else if (comboBoxTempIn.getSelectedItem() == listaCt.get(1).getTemperatura()) {
					comboBoxTempOut.setSelectedIndex(0);
				} else if (comboBoxTempIn.getSelectedItem() == listaCt.get(2).getTemperatura()) {
					comboBoxTempOut.setSelectedIndex(1);
				}
			}
		});

		JLabel lblNewLabel_1_1 = new JLabel("Grado");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(202, 141, 47, 14);
		add(lblNewLabel_1_1);

		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textFieldTemp.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Porfavor coloque los grados");
					textFieldTemp.setText("0.00");
				} else {
					// De gradoCelsius a gradoFahrenheit
					if (comboBoxTempIn.getSelectedItem() == listaCt.get(0).getTemperatura()
							&& comboBoxTempOut.getSelectedItem() == listaCt.get(1).getTemperatura()) {
						setGradoFahrenheit((getGrado() * 9 / 5) + 32);
						textFieldResultado.setText(String.valueOf(getGradoFahrenheit()) + "°F");
					}

					else if (comboBoxTempIn.getSelectedItem() == listaCt.get(0).getTemperatura()
							&& comboBoxTempOut.getSelectedItem() == listaCt.get(2).getTemperatura()) {
						setGradoKelvin(getGrado() + 273.15);
						textFieldResultado.setText(String.valueOf(getGradoKelvin()) + "°K");
					}

					else if (comboBoxTempIn.getSelectedItem() == listaCt.get(1).getTemperatura()
							&& comboBoxTempOut.getSelectedItem() == listaCt.get(0).getTemperatura()) {
						setGradoCelsius((getGrado() - 32) * 5 / 9);
						textFieldResultado.setText(String.valueOf(getGradoCelsius()) + "°C");
					}

					else if (comboBoxTempIn.getSelectedItem() == listaCt.get(1).getTemperatura()
							&& comboBoxTempOut.getSelectedItem() == listaCt.get(2).getTemperatura()) {
						setGradoKelvin((getGrado() - 32) * 5 / 9 + 273.15);
						textFieldResultado.setText(String.valueOf(getGradoKelvin()) + "°K");
					}

					else if (comboBoxTempIn.getSelectedItem() == listaCt.get(2).getTemperatura()
							&& comboBoxTempOut.getSelectedItem() == listaCt.get(0).getTemperatura()) {
						setGradoCelsius(getGrado() - 273.15);
						textFieldResultado.setText(String.valueOf(getGradoCelsius()) + "°C");

					} else if (comboBoxTempIn.getSelectedItem() == listaCt.get(2).getTemperatura()
							&& comboBoxTempOut.getSelectedItem() == listaCt.get(1).getTemperatura()) {
						setGradoFahrenheit((getGrado() - 273.15) * 9 / 5 + 32);
						textFieldResultado.setText(String.valueOf(getGradoFahrenheit()) + "°F");
					}
				}
			}
		});
		btnConvertir.setBounds(291, 207, 77, 23);
		add(btnConvertir);

		JLabel lblNewLabel_1_1_1 = new JLabel("Grado");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(419, 141, 47, 14);
		add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Convertidor de temperatura");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(202, 11, 283, 22);
		add(lblNewLabel_1_2);

	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public double getGradoCelsius() {
		return gradoCelsius;
	}

	public void setGradoCelsius(double gradoCelsius) {
		this.gradoCelsius = (Math.round(gradoCelsius * 100d) / 100d);
	}

	public double getGradoFahrenheit() {
		return gradoFahrenheit;
	}

	public void setGradoFahrenheit(double gradoFahrenheit) {
		this.gradoFahrenheit = (Math.round(gradoFahrenheit * 100d) / 100d);
	}

	public double getGradoKelvin() {
		return gradoKelvin;
	}

	public void setGradoKelvin(double gradoKelvin) {
		this.gradoKelvin = (Math.round(gradoKelvin * 100d) / 100d);
	}

	public double getGrado() {
		return grado = Double.valueOf(textFieldTemp.getText());
	}

	public void setGrado(double grado) {
		this.grado = grado;
	}
}
