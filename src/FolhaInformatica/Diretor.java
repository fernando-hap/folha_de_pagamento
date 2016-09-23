package FolhaInformatica;

import FolhaGenerica.Mensalista;

public class Diretor extends Mensalista {

	public Diretor(String nome, int codigo) {
		super(nome, codigo);
	}

	protected String cargo() {
		return "Diretor";
	}

	@Override
	public double comissao() {
		return 20000;
	}

}
