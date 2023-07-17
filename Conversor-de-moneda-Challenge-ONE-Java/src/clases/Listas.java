package clases;
import java.util.ArrayList;

import javax.swing.JComboBox;

public interface Listas {

    public ArrayList<Listas> lista = new ArrayList<Listas>();

    default void mostrarLista(JComboBox<String> cb) {}
	
	default void limpiarLista(ArrayList<Listas> clear) {
		lista.clear();
	}
}
