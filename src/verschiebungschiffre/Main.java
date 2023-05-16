package verschiebungschiffre;


/**
 * 
 * @author Simon Hoffmann
 * @version 69.0
 */
public class Main {
	public static void main(String args[]) {
		
		//Könnte eine Lösungs fürs Problem mit dem BufferedReader sein!
		//String fileName = ...; 
		//String text = Files.readString(Path.of(fileName));
		
		
		String dateipfad = System.getProperty("user.dir")+"\\" + "Gedicht.txt";
		//System.getProperty("user.dir") --> direkt im aufgerufenen Verzeichnis
		FileHandler text = new FileHandler();
		text.readText(dateipfad);
		String content = text.toString();
		Chiffre c = new Chiffre();
		String g = c.language(content);
		System.out.println(g); //debug
	}
}