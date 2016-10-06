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
			System.out.println("Ocorreu uma exce��o na fun��o salvarArquivo(): "+e.getMessage());
			System.out.println("Localiza��o: "+e.getLocalizedMessage());
			System.out.println("Causa: "+e.getCause());
			System.out.println("Exce��o: "+e);
		}		
	}
	

}
