package verschiebungschiffre;

import de.oop2023.util.UserInterface;

/**
 * Entschluesselt einen verschluesselten Text
 * 
 * @author Simon Hoffmann
 *
 */
public class Dechiffre extends Crypto {

	/**
	 * Konstruktor fuer unbekannten Schluessel
	 */
	/*
	 * public Dechiffre() {
	 * this.key = -1;
	 * }
	 */

	/**
	 * Konstruktor fuer bekannten Schluessel
	 * 
	 * @param key
	 */
	public Dechiffre(int key, FileHandler fileHandler, String filePath, String resultFileName) {
		super(fileHandler, filePath, resultFileName);
		this.key = key;
	}

	/**
	 * 
	 * @param text
	 * @return
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
					x = (x - key + 26) % 26;
				}
				decrypted = decrypted + numberToLetter(x);
			}
			return decrypted;
		}

	}

	/**
	 * gibt nach der Kryptoanalyse einen Text wieder
	 * 
	 * @param text
	 * @return dechiffrierter Text
	 */
	private String decodeWithoutKey(String text) {
		String decrypted = "";
		Statistic stat = new Statistic(text);
		stat.textToFrequency();
		int maxLetter = letterToNumber(stat.freqOrder[stat.maxFrequencyIndex()]);

		int i = 0;
		int keyAttempt = (maxLetter - letterToNumber(stat.freqOrder[i])) % 26;
		// int keyAttempt = maxFreqIndex - letterToNumber(stat.freqOrder[i]) + 1;
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

		return decrypted;
	}
}
