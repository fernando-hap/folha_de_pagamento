import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import FolhaGenerica.Funcionario;
import FolhaInformatica.Analista;
import FolhaInformatica.Diretor;
import FolhaInformatica.EmpresaInformatica;
import FolhaInformatica.Gerente;
import FolhaInformatica.Programador;

public class Escrita {
	//global
	private static EmpresaInformatica empresaInformatica;
	//deve ser volatile para garantir que seja usada a mesma inst�ncia da lista para todas as threads
	private static volatile List<Funcionario> listaFuncionarios = new ArrayList<>();
		
	private static void lerDadosEmpresa() {
		try {
			List<String> arquivoEmpresa = new ArrayList<>();
			arquivoEmpresa = Files.lines(Paths.get("empresa.txt")).collect(Collectors.toList());
			arquivoEmpresa.parallelStream().forEach(s -> criarObjetos(s));
		} catch (IOException e) {
			System.out.println("Ocorreu uma exce��o na fun��o lerDadosEmpresa(): "+e.getMessage());
			System.out.println("Localiza��o: "+e.getLocalizedMessage());
			System.out.println("Causa: "+e.getCause());
			System.out.println("Exce��o: "+e);
		}

	}
	
	//deve ser syncronized pois a fun��o � chamada para cada linha do arquivo em paralelo
	private synchronized static void criarObjetos(String line) {
		try {
			String[] arrayDados = new String[5];
			arrayDados = line.split(";");
			
			//Popula a empresa inform�tica
			if(arrayDados.length == 1) {
				//Cria a inst�ncia do objeto empresa inform�tica em mem�ria
				empresaInformatica = new EmpresaInformatica(arrayDados[0]);
				return;				
			}
			
			//Popula os funcion�rios
			if (!arrayDados[0].isEmpty() && !arrayDados[1].isEmpty() && !arrayDados[2].isEmpty()
					&& !arrayDados[3].isEmpty()) {
				switch (arrayDados[1].toLowerCase()) {
				case "diretor":
					listaFuncionarios.add(new Diretor(arrayDados[2], Integer.parseInt(arrayDados[0]),
							Double.parseDouble(arrayDados[3])));
					break;
				case "gerente":
					listaFuncionarios.add(new Gerente(arrayDados[2], Integer.parseInt(arrayDados[0]),
							Double.parseDouble(arrayDados[3])));
					break;
				case "analista":
					listaFuncionarios.add(new Analista(arrayDados[2], Integer.parseInt(arrayDados[0]),
							Double.parseDouble(arrayDados[3]), Integer.parseInt(arrayDados[4])));
					break;
				case "programador":
					listaFuncionarios.add(new Programador(arrayDados[2], Integer.parseInt(arrayDados[0]),
							Double.parseDouble(arrayDados[3]), Integer.parseInt(arrayDados[4])));
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Ocorreu uma exce��o na fun��o criarObjetos(): " + e.getMessage());
			System.out.println("Localiza��o: " + e.getLocalizedMessage());
			System.out.println("Causa: " + e.getCause());
			System.out.println("Exce��o: " + e);
		}
	}
	
	private static void salvarObjetos() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("empresa.obj");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(empresaInformatica);
			objectOutputStream.close();
		} catch (IOException e) {
			System.out.println("Ocorreu uma exce��o na fun��o salvarObjetos(): "+e.getMessage());
			System.out.println("Localiza��o: "+e.getLocalizedMessage());
			System.out.println("Causa: "+e.getCause());
			System.out.println("Exce��o: "+e);
		}
	}

	public static void main(String[] args) {
			//ler o arquivo empresa.txt e salva os dados em mem�ria
			lerDadosEmpresa();
			//insere a lista de funcion�rios na empresa inform�tica
			empresaInformatica.setListaFuncionarios(listaFuncionarios);
			//Imprimi a lista de funcion�rios salvo em mem�ria
			empresaInformatica.getListaFuncionarios().parallelStream().forEach(s -> System.out.println("Codigo: "+s.getCodigo()+" Nome: "+s.getNome()));
			//serializa a empresa inform�ticae salva no arquivo empresa.obj
			salvarObjetos();

	}

}
