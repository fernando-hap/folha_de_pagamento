package FolhaInformatica;

import FolhaGenerica.Horista;

public class Programador extends Horista {

	public Programador(String nome, int codigo, double valorHora, int numeroHoras) {
		super(nome, codigo, valorHora, numeroHoras);
	}
	
	protected String cargo() {
		return "Programador";
	}

}
