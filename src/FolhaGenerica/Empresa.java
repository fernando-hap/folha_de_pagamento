package FolhaGenerica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Empresa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private List<Funcionario> listaFuncionarios;
	
	public Empresa(String nome) {
		this.nome = nome;
		this.listaFuncionarios = new ArrayList<>();
	}
	
	public void gerarFolha() {
		for(int i = 0; i < listaFuncionarios.size(); i++) {
			listaFuncionarios.get(i).gerarContraCheque();
		}
	}
	
	public void exibirFuncionario(int codigo) {
		
	}
	
	public boolean inserirFuncionario(Funcionario f) throws FuncionarioExistente {
		for(int i = 0; i < listaFuncionarios.size(); i++) {
			if(listaFuncionarios.get(i).getCodigo() == f.getCodigo()) {
				FuncionarioExistente e = new FuncionarioExistente("Funcionário código " + f.getCodigo() + " já existe.");
				throw(e);
			}
		}
		listaFuncionarios.add(f);
		return true;
	}
}
