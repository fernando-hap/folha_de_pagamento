package FolhaGenerica;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class ImprimeEmArquivo {
	public static void gerarFolhaPagamentoEmArquivo (String arquivo, List<String> folhaDePagamento) {
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(arquivo);
			PrintWriter printWriter = new PrintWriter(fileOutputStream);
			for(int i=0; i< folhaDePagamento.size(); i++) {
				printWriter.println(folhaDePagamento.get(i));
			}
			printWriter.close();
			System.out.println("Arquivo de folha de pagamento salvo.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
