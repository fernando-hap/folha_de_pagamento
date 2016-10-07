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
	
	public String getNome() {
		return nome;
	}
	
	public void gerarFolha() {
		for(int i = 0; i < listaFuncionarios.size(); i++) {
			listaFuncionarios.get(i).gerarContraCheque();
		}
	}
	
	public void gerarFolhaEmArquivo(String arquivo) {
		List<String> folhaDePagamento = new ArrayList<String>();
		folhaDePagamento.add("EMPRESA: " + nome);
		for(int i=0; i< listaFuncionarios.size(); i++) {
			Funcionario funcionario = listaFuncionarios.get(i);
			String contraCheque = "C�DIGO: " + funcionario.getCodigo() + " - NOME: " + funcionario.getNome() + " - CARGO: " + funcionario.cargo() + " - SAL�RIO: " + funcionario.salario();
			folhaDePagamento.add(contraCheque);
		}
		ImprimeEmArquivo.gerarFolhaPagamentoEmArquivo(arquivo, folhaDePagamento);
	}
	
	public void exibirFuncionario(int codigo) {
		for(int i = 0; i < listaFuncionarios.size(); i++) {
			if(listaFuncionarios.get(i).getCodigo() == codigo) {
				listaFuncionarios.get(i).exibir();
			}
		}
	}
	
	public boolean inserirFuncionario(Funcionario f) throws FuncionarioExistente {
		for(int i = 0; i < listaFuncionarios.size(); i++) {
			if(listaFuncionarios.get(i).getCodigo() == f.getCodigo()) {
				FuncionarioExistente e = new FuncionarioExistente("Funcion�rio c�digo " + f.getCodigo() + " j� existe.");
				throw(e);
			}
		}
		listaFuncionarios.add(f);
		return true;
	}
}
