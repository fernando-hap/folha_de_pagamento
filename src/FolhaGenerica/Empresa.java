package FolhaGenerica;

import java.util.ArrayList;
import java.util.List;

public abstract class Empresa {
	private String nome;
	private List<Funcionario> listaFuncionarios;
	
	public Empresa(String nome) {
		this.nome = nome;
		this.listaFuncionarios = new ArrayList<>();
	}
	
	public void gerarFolha() {
		
	}
	
	public void exibirFuncionario(int codigo) {
		
	}
	
	public boolean inserirFuncionario(Funcionario f) {
		for(int i = 0; i < listaFuncionarios.size(); i++) {
			if(listaFuncionarios.get(i).getCodigo() == f.getCodigo())
				return false;
		}
		listaFuncionarios.add(f);
		return true;
	}
}
