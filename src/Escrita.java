import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Vector;

import FolhaGenerica.Funcionario;
import FolhaGenerica.FuncionarioExistente;
import FolhaInformatica.Analista;
import FolhaInformatica.Diretor;
import FolhaInformatica.EmpresaInformatica;
import FolhaInformatica.Gerente;
import FolhaInformatica.Programador;

public class Escrita {
	private static EmpresaInformatica empresaInformatica;
	
	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		String arquivoDeEntrada = path + "/empresa.txt";
		String arquivoDeSaida = path + "/empresa.obj";
		lerArquivo(arquivoDeEntrada);
		salvarObjetos(arquivoDeSaida);
	}
	
	private static void lerArquivo(String arquivo) {
		Vector<String> linhas = new Vector<String>();
		try {
			Scanner scanner = new Scanner(new File(arquivo));
			while(scanner.hasNextLine()) {
				String nextLine = scanner.nextLine();
				linhas.add(nextLine);
			}
			scanner.close();
			empresaInformatica = new EmpresaInformatica(linhas.get(0));
			for(int i = 1; i < linhas.size(); i++) {
				String linha = linhas.get(i);
				String codigo = linha.substring(0,linha.indexOf(';'));
				String cargo = linha.substring(codigo.length()+1, linha.indexOf(';', codigo.length()+1));
				String nome = linha.substring(codigo.length()+1+cargo.length()+1,linha.indexOf(';', codigo.length()+1+cargo.length()+1));
				String salario = linha.substring(codigo.length()+1+cargo.length()+1+nome.length()+1,linha.indexOf(';', codigo.length()+1+cargo.length()+1+nome.length()+1));
				String numeroHoras = linha.substring(linha.lastIndexOf(';')+1);
				Funcionario funcionario = null;
				switch (cargo) {
				case "Programador": 
					funcionario = new Programador(nome,Integer.parseInt(codigo), Double.parseDouble(salario), Integer.parseInt(numeroHoras));
					break;
				case "Analista":
					funcionario = new Analista(nome,Integer.parseInt(codigo), Double.parseDouble(salario), Integer.parseInt(numeroHoras));
					break;
				case "Gerente":
					funcionario = new Gerente(nome,Integer.parseInt(codigo), Double.parseDouble(salario));
					break;
				case "Diretor":
					funcionario = new Diretor(nome,Integer.parseInt(codigo), Double.parseDouble(salario));
					break;
				}
				empresaInformatica.inserirFuncionario(funcionario);
			}
			System.out.println("Arquivo de entrada lido.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FuncionarioExistente e) {
			e.printStackTrace();
		}
	}
	
	private static void salvarObjetos(String arquivo) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(arquivo);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(empresaInformatica);
			objectOutputStream.close();
			System.out.println("Arquivo de saída salvo.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
