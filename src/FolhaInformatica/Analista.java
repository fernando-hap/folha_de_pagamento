package FolhaInformatica;

import FolhaGenerica.Horista;

public class Analista extends Horista {

	public Analista(String nome, int codigo, double valorHora, int numeroHoras) {
		super(nome, codigo, valorHora, numeroHoras);
	}
	
	protected String cargo() {
		return "Analista";
	}

}
