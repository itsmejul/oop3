package verschiebungschiffre;

import de.oop2023.util.UserInterface;

/**
 * Main-Klasse
 * 
 * @author Simon Hoffmann, Julian Mosig von Aehrenfeld
 * @version 69.0
 */
public class Main {
	/**
	 * main-Methode
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		FileHandler fileHandler = new FileHandler();
		while (true) {
			String mode = UserInterface.in.requestChoiceName("\nChiffrieren oder Dechiffrieren?", "c", "d");
			if (mode == "c") {
				String fileName = UserInterface.in.requestString("Welche Datei soll gelesen werden?");
				String filePath = System.getProperty("user.dir") + "\\" + fileName;
				String resultFileName = UserInterface.in
						.requestString("In welche Datei soll das Ergebnis geschrieben werden?");

				int key = UserInterface.in.requestInt("Was ist der Schluessel?", 0, 25);
				Chiffre c = new Chiffre(key, fileHandler, filePath, resultFileName);
				c.fullTransformation();
			} else {
				String fileName = UserInterface.in.requestString("Welche Datei soll gelesen werden?");
				String filePath = System.getProperty("user.dir") + "\\" + fileName;
				String resultFileName = UserInterface.in
						.requestString("In welche Datei soll das Ergebnis geschrieben werden?");
				int key;
				if (UserInterface.in.requestChoiceName("Hast du einen Schluessel?", "y", "n") == "y") {
					key = UserInterface.in.requestInt("Was ist der Schluessel?", 0, 25);
				} else {
					key = -1;
				}
				Dechiffre dechiffre = new Dechiffre(key, fileHandler, filePath, resultFileName);
				dechiffre.fullTransformation();
			}
		}

		// text.readText(dateipfad);
		// String content = text.toString();
		// System.out.println(content); // debug
		// Chiffre c = new Chiffre(7);
		// String g = c.language(content);
		// System.out.println(g); // debug
		// String f = c.transformation(g);
		// System.out.println(f); // debug

		// Dechiffre d = new Dechiffre();
		// System.out.println(d.decodeWithoutKey(f));
	}
}