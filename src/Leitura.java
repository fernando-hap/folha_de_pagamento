import java.io.FileInputStream;
import java.io.ObjectInputStream;

import FolhaInformatica.EmpresaInformatica;

public class Leitura {
	//global
	private static EmpresaInformatica empresaInformatica;
	
	private static void restaurarObjetos() {
		try {
			FileInputStream fileInputStream = new FileInputStream("empresa.obj");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			empresaInformatica = (EmpresaInformatica) objectInputStream.readObject();
			objectInputStream.close();
		} catch (Exception e) {
			System.out.println("Ocorreu uma exce��o na fun��o restaurarObjetos(): "+e.getMessage());
			System.out.println("Localiza��o: "+e.getLocalizedMessage());
			System.out.println("Causa: "+e.getCause());
			System.out.println("Exce��o: "+e);
		}
	}

	public static void main(String[] args) {
		//deserializa a empresa inform�tica em mem�ria lendo o arquivo empresa.obj
		restaurarObjetos();
		//Gera a folha de pagamento
		empresaInformatica.gerarFolhaPagamento();
		empresaInformatica.gerarFolhaPagamentoEmArquivo();

	}

}
