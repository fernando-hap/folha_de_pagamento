package FolhaGenerica;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import FolhaInformatica.ImprimeEmArquivo;

public abstract class Empresa extends ImprimeEmArquivo implements Serializable {
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}

	public void gerarFolhaPagamento() {
		for(int i = 0; i < listaFuncionarios.size(); i++) {
			listaFuncionarios.get(i).gerarContraCheque();
		}
	}
	
	public void gerarFolhaPagamentoEmArquivo () {
		List<String> folhaPagamento = new ArrayList<>();
		for(int i = 0; i < listaFuncionarios.size(); i++) {
			folhaPagamento.add("CÓDIGO: " + listaFuncionarios.get(i).getCodigo() + " - NOME: " + listaFuncionarios.get(i).getNome()
					+ " - CARGO: " + listaFuncionarios.get(i).cargo() + " - SALÁRIO: " + listaFuncionarios.get(i).salario());
		}
		String dataHoraAtual = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
		salvarArquivo("folhaPagamento_"+dataHoraAtual+".txt", folhaPagamento);
	}
	
	public void exibirFuncionario(int codigo) {
		Optional<Funcionario> funcionario = listaFuncionarios.stream().filter(s -> s.getCodigo() == codigo).findFirst();
		if (funcionario.isPresent()) {
			System.out.println("CÓDIGO: " + funcionario.get().getCodigo() + " - NOME: " + funcionario.get().getNome()
					+ " - CARGO: " + funcionario.get().cargo() + " - SALÁRIO: " + funcionario.get().salario());
		}
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
