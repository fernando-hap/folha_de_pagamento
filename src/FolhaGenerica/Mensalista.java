package FolhaGenerica;

public abstract class Mensalista extends Funcionario {
	private double salarioMensal;
	
	public Mensalista(String nome, int codigo, double salarioMensal) {
		super(nome, codigo);
		this.salarioMensal = salarioMensal;
	}

	protected double salario() {
		return salarioMensal + comissao();
	}
	
	protected abstract double comissao();
}
