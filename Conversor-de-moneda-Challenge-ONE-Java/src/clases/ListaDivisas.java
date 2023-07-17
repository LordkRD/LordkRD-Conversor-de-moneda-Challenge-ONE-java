package clases;

import javax.swing.JComboBox;
import javax.swing.JTable;

public class ListaDivisas extends Lista {
	
	  public ListaDivisas(String divisa, double tasa) { 
		  super( divisa, tasa); 
		  }
	 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void mostrarLista(JComboBox cb) {

		lista.add(new ListaDivisas("DOP-Peso Dominicano", 1));
		lista.add(new ListaDivisas("EUR-Euro", 59.7092));
		lista.add(new ListaDivisas("USD-Dollar Estadounidense",  54.74));
		
		for (Lista listaDivisas : lista) {
			
			cb.addItem( listaDivisas.getDivisa());
			
		}

	}

	@SuppressWarnings("unused")
	@Override
	public void mostrarLista(JTable table) {
		lista.add(new ListaDivisas("DOP-Peso Dominicano", 1));
		lista.add(new ListaDivisas("EUR-Euro", 59.7092));
		lista.add(new ListaDivisas("USD-Dollar Estadounidense",  54.74));
		
		for (Lista listaDivisas : lista) {
			
			table.add(table, table, 0);
			
		}
	}
	
}
