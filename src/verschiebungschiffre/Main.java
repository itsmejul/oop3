package verschiebungschiffre;

/**
 * Main-Klasse
 * @author Simon Hoffmann, Julian Mosig von Aehrenfeld
 * @version 69.0
 */
public class Main {
	/**
	 * main-Methode
	 * @param args
	 */
	public static void main(String args[]) {

		String dateipfad = System.getProperty("user.dir") + "\\" + "Gedicht.txt";
		FileHandler text = new FileHandler();
		text.readText(dateipfad);
		String content = text.toString();
		System.out.println(content); // debug
		Chiffre c = new Chiffre(7);
		String g = c.language(content);
		System.out.println(g); // debug
		String f = c.transformation(g);
		System.out.println(f); // debug
		Dechiffre d = new Dechiffre(7);
		System.out.println(d.transformation(f));
	}
}