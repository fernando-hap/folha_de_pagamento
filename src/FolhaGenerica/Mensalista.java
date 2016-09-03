package FolhaGenerica;

public abstract class Mensalista extends Funcionario {
	private double salarioMensal;
	
	public Mensalista(String nome, int codigo) {
		super(nome, codigo);
	}

	protected double salario() {
		return salarioMensal;
	}
	
	protected abstract double comissao();
}
