package FolhaInformatica;

import FolhaGenerica.Mensalista;

public class Gerente extends Mensalista {

	public Gerente(String nome, int codigo, double salarioMensal) {
		super(nome, codigo, salarioMensal);
	}

	protected String cargo() {
		return "Gerente";
	}

	@Override
	public double comissao() {
		return 5000;
	}

}
