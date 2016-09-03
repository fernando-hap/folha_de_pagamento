package FolhaGenerica;

public abstract class Funcionario {
	private String nome;
	private int codigo;
	
	public Funcionario(String nome, int codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}
	
	void gerarContraCheque() {
		
	}
	
	protected abstract double salario();
	
	protected abstract String cargo();
	
	public void exibir() {
		
	}
	
	
}
