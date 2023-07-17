package clases;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;

public abstract class Lista {

	public ArrayList<Lista> lista = new ArrayList<Lista>();

	protected String conversores;
	protected String imagen,divisa;
	protected double tasa,celsius,fahrenheit,kelvin;
	ImageIcon imagenDivisa = new ImageIcon(imagen,divisa);
	
	public Lista() {
		
	}
	
	public Lista(double celsius, double fahrenheit, double kelvin) {
		super();
		this.celsius = celsius;
		this.fahrenheit = fahrenheit;
		this.kelvin = kelvin;
	}

	public Lista(double tasa) {
		this.tasa = tasa;
	}
	
	public Lista(String divisa, double tasa) {
		this.divisa = divisa;
		this.tasa = tasa;
		
	}
		
	public Lista(String conversores) {
		this.conversores = conversores;
	}

	@SuppressWarnings("rawtypes")
	public abstract void mostrarLista(JComboBox cb);

	public String getConversores() {
		return conversores;
	}


	public void setConversores(String conversores) {
		this.conversores = conversores;
	}


	public String getDivisa() {
		return divisa;
	}


	public void setDivisa(String divisa) {
		this.divisa = divisa;
	}


	public double getTasa() {
		return tasa;
	}


	public void setTasa(double tasa) {
		this.tasa = tasa;
	}

	public abstract void mostrarLista(JTable table);
}
