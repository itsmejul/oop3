package verschiebungschiffre;

/**
 * Verschluesselt einen Text
 * 
 * @author Simon Hoffmann, Julian Mosig von Aehrenfeld
 *
 */
public class Chiffre extends Crypto {
	/**
	 * Konstruktor
	 * 
	 * @param key der Schluessel fuer die Chiffrierung des Textes
	 * @param fileHandler liefert Lese- und Schreibefunktion fuer Dateien
	 * @param filePath Dateipfad von auszulesender Datei
	 * @param resultFileName Dateiname fuer die Ausgabe des chiffrierten Textes
	 */
	public Chiffre(int key, FileHandler fileHandler, String filePath, String resultFileName) {
		super(fileHandler, filePath, resultFileName);
		this.key = key;
	}

	/**
	 * Verschiebt alle Buchstaben um den Schluessel
	 * 
	 * @param text der Text, der chiffriert werden soll
	 * @return codierter text
	 */
	public String transformation(String text) {
		String encrypted = "";
		int x = 0;
		for (int i = 0; i < text.length(); i++) {
			x = letterToNumber(text.charAt(i));
			if (x >= 0) {
				// nur Kodierung von Buchstaben keine anderen Symbole
				// nicht kodierte Symbole haben negative Id's
				x = (x + key) % 26;
			}
			encrypted = encrypted + numberToLetter(x);
		}
		return encrypted;
	}
	/**
	 * Ausgabe der Chiffirertabelle fuer den Schluessel
	 */
	public void chart() {
		String letters ="| a| b| c| d| e| f| g| h| i| j| k| l| m| n| o| p| q| r| s| t| u| v| w| x| y| z";
		String numbers ="| 0| 1| 2| 3| 4| 5| 6| 7| 8| 9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25";
		System.out.println(letters);
		System.out.println(numbers);
		System.out.println("|  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  ");
		String part1 = letters.substring(0, key*3);
		String part2 = letters.substring(key*3, letters.length());
		System.out.println(part2 + part1);
		part1 = numbers.substring(0, key*3);
		part2 = numbers.substring(key*3, numbers.length());
		System.out.println(part2 + part1);
		System.out.println("");
	}
}
