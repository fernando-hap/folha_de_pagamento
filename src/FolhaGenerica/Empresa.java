package FolhaGenerica;

public abstract class Empresa {
	private String nome;
	
	public Empresa(String nome) {
		this.nome = nome;
	}
	
	public void gerarFolha() {
		
	}
	
	public void exibirFuncionario(int codigo) {
		
	}
	
	public boolean inserirFuncionario(Funcionario f) {
		return true;
	}
}
