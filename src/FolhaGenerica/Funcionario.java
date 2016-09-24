package FolhaGenerica;

import java.io.Serializable;

public abstract class Funcionario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		System.out.println("CÓDIGO: " + codigo + " - NOME: " + nome + " - CARGO: " + cargo() + " - SALÁRIO: " + salario());
	}
	
	
	
	
}
