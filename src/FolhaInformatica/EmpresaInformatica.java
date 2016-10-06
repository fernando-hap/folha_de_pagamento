package FolhaInformatica;

import FolhaGenerica.Empresa;
import FolhaGenerica.FuncionarioExistente;

public class EmpresaInformatica extends Empresa {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8883679173820401288L;

	public EmpresaInformatica(String nome) {
		super(nome);
	}
	
	public boolean inserirProgramador(Programador p) {
		try {
			super.inserirFuncionario(p);	
			return true;
		} catch (FuncionarioExistente e) {
			System.out.println("Erro ao inserir programador: "+e.getMessage());
			return false;
		}
	}
	
	public boolean inserirAnalista(Analista a) {
		try {
			super.inserirFuncionario(a);	
			return true;			
		} catch (FuncionarioExistente e) {
			System.out.println("Erro ao inserir Analista: "+e.getMessage());
			return false;
		}
	}
	
	public boolean inserirGerente(Gerente g) {
		try {
			super.inserirFuncionario(g);	
			return true;			
		} catch (FuncionarioExistente e) {
			System.out.println("Erro ao inserir Gerente: "+e.getMessage());
			return false;
		}
	}
	
	public boolean inserirDiretor(Diretor d) {
		try {
			super.inserirFuncionario(d);	
			return true;			
		} catch (FuncionarioExistente e) {
			System.out.println("Erro ao inserir Diretor: "+e.getMessage());
			return false;
		}
	}

}
