package FolhaGenerica;

public abstract class Funcionario {
	private String nome;
	private int codigo;
	
	public Funcionario(String nome, int codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}
	
	
	
	public String getNome() {
		return nome;
	}



	public int getCodigo() {
		return codigo;
	}



	void gerarContraCheque() {
		exibir();
	}
	
	protected abstract double salario();
	
	protected abstract String cargo();
	
	public void exibir() {
		System.out.println("C�DIGO: " + codigo + " - NOME: " + nome + " - CARGO: " + cargo() + " - SAL�RIO: " + salario());
	}
	
	
	
	
}
