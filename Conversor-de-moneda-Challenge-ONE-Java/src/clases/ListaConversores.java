package clases;


import javax.swing.JComboBox;
import javax.swing.JTable;

public class ListaConversores extends Lista  {
	
	public ListaConversores(String conversores) {
		super(conversores);
		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void mostrarLista(JComboBox cb) {
		lista.add(new ListaConversores("Selecciona"));
		lista.add(new ListaConversores("Conversor de divisas"));
		lista.add(new ListaConversores("Conversor de Temperatura"));
		for (Lista listaConversores : lista) {

			cb.addItem(listaConversores.conversores);
		}


	}
	@Override
	public void mostrarLista(JTable table) {
		// TODO Auto-generated method stub
		
	}
	
	
		

}
