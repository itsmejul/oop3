package verschiebungschiffre;


/**
 * 
 * @author Simon Hoffmann
 * @version 69.0
 */
public class Main {
	public static void main(String args[]) {
		String dateipfad = System.getProperty("user.dir")+"\\" + "Gedicht.txt";
		//System.getProperty("user.dir") --> direkt im aufgerufenen Verzeichnis
		FileHandler text = new FileHandler();
		text.readText(dateipfad);
		String content = text.toString();
		Chiffre c = new Chiffre();
		content = c.language(content);
		System.out.println(content); //debug
	}
}
