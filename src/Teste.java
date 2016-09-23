import java.util.ArrayList;
import java.util.List;

import FolhaGenerica.Funcionario;
import FolhaInformatica.Analista;
import FolhaInformatica.EmpresaInformatica;
import FolhaInformatica.Programador;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpresaInformatica empresaInformatica = new EmpresaInformatica("WeDeliver");
		Programador fernando = new Programador("Fernando", 1, 15, 160);
		if(empresaInformatica.inserirProgramador(fernando)) System.out.println("Programador inserido");
		Analista gustavo = new Analista("Gustavo", 2, 25, 160);
		
		
	}

}
