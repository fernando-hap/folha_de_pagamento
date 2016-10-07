import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import FolhaInformatica.EmpresaInformatica;

public class Leitura {
	private static EmpresaInformatica empresaInformatica;
	
	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		String arquivoDeEntrada = path + "/empresa.obj";
		restaurarObjetos(arquivoDeEntrada);
		empresaInformatica.gerarFolha();
	}

	private static void restaurarObjetos(String arquivo) {
		try {
			FileInputStream fileInputStream = new FileInputStream(arquivo);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			empresaInformatica = (EmpresaInformatica) objectInputStream.readObject();
			objectInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
