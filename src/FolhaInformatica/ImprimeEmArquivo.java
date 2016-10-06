package FolhaInformatica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ImprimeEmArquivo {
	protected void salvarArquivo(String nome, List<String> conteudo) {
		try {
			Files.write(Paths.get(nome), conteudo);
		} catch (IOException e) {
			System.out.println("Ocorreu uma exceção na função salvarArquivo(): "+e.getMessage());
			System.out.println("Localização: "+e.getLocalizedMessage());
			System.out.println("Causa: "+e.getCause());
			System.out.println("Exceção: "+e);
		}		
	}
	

}
