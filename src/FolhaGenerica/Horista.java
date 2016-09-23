package FolhaGenerica;

public abstract class Horista extends Funcionario {
	private double valorHora;
	private int numeroHoras;
	
	public Horista(String nome, int codigo, double valorHora, int numeroHoras) {
		super(nome, codigo);
		this.valorHora = valorHora;
		this.numeroHoras = numeroHoras;
	}
	
	protected double salario() {
		return valorHora * numeroHoras;
	}
	
}
