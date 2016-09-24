import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Escrita {

	public static void main(String[] args) {
		String path;
		path = System.getProperty("user.dir");
		try {
			Scanner scanner = new Scanner(new File(path + "empresa.txt"));
			while(scanner.nextLine()) {
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
