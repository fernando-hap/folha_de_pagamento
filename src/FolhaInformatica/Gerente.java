package FolhaInformatica;

import FolhaGenerica.Mensalista;

public class Gerente extends Mensalista {

	public Gerente(String nome, int codigo) {
		super(nome, codigo);
	}

	protected String cargo() {
		return "Gerente";
	}

	@Override
	public double comissao() {
		return 5000;
	}

}
