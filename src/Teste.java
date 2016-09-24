import java.util.ArrayList;
import java.util.List;

import FolhaGenerica.Funcionario;
import FolhaInformatica.Analista;
import FolhaInformatica.Diretor;
import FolhaInformatica.EmpresaInformatica;
import FolhaInformatica.Gerente;
import FolhaInformatica.Programador;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpresaInformatica empresaInformatica = new EmpresaInformatica("WeDeliver");
		Programador fernando = new Programador("Fernando", 1, 15, 160);
		if(empresaInformatica.inserirProgramador(fernando)) System.out.println("Programador " + fernando.getNome() + " inserido");
		Analista gustavo = new Analista("Gustavo", 2, 25, 160);
		if(empresaInformatica.inserirAnalista(gustavo)) System.out.println("Analista " + gustavo.getNome() + " inserido");
		Gerente henrique = new Gerente("Henrique", 3, 6000);
		if(empresaInformatica.inserirGerente(henrique)) System.out.println("Gerente " + henrique.getNome() + " inserido");
		Diretor carlos = new Diretor("Carlos", 4, 10000);
		if(empresaInformatica.inserirDiretor(carlos)) System.out.println("Diretor " + carlos.getNome() + " inserido");
		empresaInformatica.gerarFolha();
		
	}

}
