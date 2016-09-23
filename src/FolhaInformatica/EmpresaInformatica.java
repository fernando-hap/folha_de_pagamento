package FolhaInformatica;

import FolhaGenerica.Empresa;

public class EmpresaInformatica extends Empresa {

	public EmpresaInformatica(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}
	
	public boolean inserirProgramador(Programador p) {
		try {
			super.inserirFuncionario(p);	
			return true;
			
			
		} catch (Throwable ex) {
			System.out.println("Erro na ao inserir programador: "+ex.toString());
			return false;
		}
	}
	
	public boolean inserirAnalista() {
		try {
			return true;
			
			
		} catch (Throwable ex) {
			System.out.println("Erro na ao inserir Analista: "+ex.toString());
			return false;
		}
	}
	
	public boolean inserirGerente() {
		return true;
	}
	
	public boolean inserirDiretor() {
		return true;
	}

}
