package FolhaInformatica;

import FolhaGenerica.Mensalista;

public class Diretor extends Mensalista {

	public Diretor(String nome, int codigo, double salarioMensal) {
		super(nome, codigo, salarioMensal);
	}

	protected String cargo() {
		return "Diretor";
	}

	@Override
	public double comissao() {
		return 20000;
	}

}
