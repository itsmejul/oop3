package verschiebungschiffre;

import de.oop2023.util.UserInterface;

/**
 * Entschluesselt einen verschluesselten Text
 * 
 * @author Simon Hoffmann, Julian Mosig von Aehrenfeld
 *
 */
public class Dechiffre extends Crypto {

	/**
	 * Konstruktor
	 * 
	 * @param key            der Schluessel. Bei unbekanntem Schluessel wird -1
	 *                       uebergeben
	 * @param fileHandler    liefert Lese- und Schreibefunktion fuer Dateien
	 * @param filePath       Dateipfad von auszulesender Datei
	 * @param resultFileName Dateiname fuer die Ausgabe des dechiffrierten Textes
	 */
	public Dechiffre(int key, FileHandler fileHandler, String filePath, String resultFileName) {
		super(fileHandler, filePath, resultFileName);
		this.key = key;
	}

	/**
	 * Entschluesselt den Text gemaess der Verschiebung anhand des Schluessels. Bei
	 * unbekanntem Schluessel wird in Hilfsmethode uebergegangen
	 * 
	 * @param text der zu entschluesselnde Text
	 * @return der entschluesselte Text
	 */
	public String transformation(String text) {
		if (key == -1) {
			return decodeWithoutKey(text);
		} else {
			String decrypted = "";
			int x = 0;
			for (int i = 0; i < text.length(); i++) {
				x = letterToNumber(text.charAt(i));
				if (x >= 0) {
					// nur Kodierung von Buchstaben keine anderen Symbole
					// nicht kodierte Symbole haben negative Id's
					x = (x - key + 26) % 26;
				}
				decrypted = decrypted + numberToLetter(x);
			}
			return decrypted;
		}

	}

	/**
	 * Fuehrt Haeufigkeitsanalyse durch und gibt den entschluesselten Text an
	 * Benutzer aus,
	 * bei Fehlversuch wird der zweithaeufigste Buchstabe probiert etc
	 * 
	 * @param text der zu entschluesselnde Text
	 * @return dechiffrierter Text
	 */
	private String decodeWithoutKey(String text) {
		String decrypted = "";
		Statistic stat = new Statistic(text);
		stat.textToFrequency();
		int maxLetter = letterToNumber(stat.freqOrder[stat.maxFrequencyIndex()]);

		int i = 0;
		int keyAttempt = (maxLetter - letterToNumber(stat.freqOrder[i])) % 26;
		key = keyAttempt;
		System.out.println(transformation(text));
		while (true) {
			String tryAgain = UserInterface.in.requestChoiceName("anderen schluessel probieren?", "y", "n");
			if (tryAgain == "y") {
				i++;
				keyAttempt = (maxLetter - letterToNumber(stat.freqOrder[i])) % 26;

				key = keyAttempt;
				System.out.println(transformation(text));
			} else {
				break;
			}
		}
		int x = 0;
		for (int j = 0; j < text.length(); j++) {
			x = letterToNumber(text.charAt(j));
			if (x >= 0) {
				// nur Kodierung von Buchstaben keine anderen Symbole
				// nicht kodierte Symbole haben negative Id's
				x = (x - key + 26) % 26;
			}
			decrypted = decrypted + numberToLetter(x);
		}

		return decrypted;
	}

	/**
	 * Ausgabe der Dechiffriertabelle fuer den Schluessel
	 */
	public void chart() {
		String letters = "| a| b| c| d| e| f| g| h| i| j| k| l| m| n| o| p| q| r| s| t| u| v| w| x| y| z";
		String numbers = "| 0| 1| 2| 3| 4| 5| 6| 7| 8| 9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25";
		System.out.println(letters);
		System.out.println(numbers);
		System.out.println("|  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  ");
		String part1 = letters.substring(letters.length() - (key * 3), letters.length());
		String part2 = letters.substring(0, letters.length() - key * 3);
		System.out.println(part1 + part2);
		part1 = numbers.substring(numbers.length() - (key * 3), numbers.length());
		part2 = numbers.substring(0, numbers.length() - key * 3);
		System.out.println(part1 + part2);
	}
}
