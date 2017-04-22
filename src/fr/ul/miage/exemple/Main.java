/**
 * 
 */
package fr.ul.miage.exemple;

import java.io.File;
import java.io.FileReader;

import fr.ul.miage.exemple.generated.ParserCup;
import fr.ul.miage.exemple.generated.Yylex;


/**
 * @author azim
 *
 */

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File directory = new File("samples");
		File[] listFiles = directory.listFiles();
		try {
			//for(int i=1;i<=7;i++){
				ParserCup parser = new ParserCup(new Yylex(new FileReader(listFiles[12])));
				parser.parse();
			//}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
