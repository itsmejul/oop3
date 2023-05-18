package verschiebungschiffre;

/**
 * 
 * @author Simon Hoffmann, Julian Mosig von Aehrenfeld
 * @version 69.0
 */
public class Main {
	public static void main(String args[]) {

		// Könnte eine Lösungs fürs Problem mit dem BufferedReader sein!
		// String fileName = ...;
		// String text = Files.readString(Path.of(fileName));

		String dateipfad = System.getProperty("user.dir") + "\\" + "Gedicht.txt";
		// System.getProperty("user.dir") --> direkt im aufgerufenen Verzeichnis
		FileHandler text = new FileHandler();
		text.readText(dateipfad);
		String content = text.toString();
		System.out.println(content); // debug
		Chiffre c = new Chiffre(7);
		String g = c.language(content);
		System.out.println(g); // debug
		System.out.println(c.transformation(g)); // debug
	}
}