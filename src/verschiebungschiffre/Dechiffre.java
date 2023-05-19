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
	public Dechiffre() {
		this.key = -1;
	}

	/**
	 * Konstruktor fuer bekannten Schluessel
	 * 
	 * @param key
	 */
	public Dechiffre(int key) {
		this.key = key;
	}
	/**
	 * 
	 * @param text
	 * @return
	 */
	public String transformation(String text) {
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
	/**
	 * gibt nach der Kryptoanalyse einen Text wieder
	 * @param text
	 * @return dechiffrierter Text
	 */
	public String decodeWithoutKey(String text) {
		String decrypted = "";
		Statistic stat = new Statistic(text);
		stat.textToFrequency();
		int keyAttempt = stat.maxFrequencyIndex() - letterToNumber('e') + 1;
		key = keyAttempt;
		System.out.println(keyAttempt);
		System.out.println(transformation(text));
		while (true) {
			String tryAgain = UserInterface.in.requestChoiceName("anderen schluessel probieren?", "y", "n");
			if (tryAgain == "y") {
				keyAttempt++;
				key = keyAttempt;
				System.out.println(transformation(text));
			} else {
				break;
			}
		}
		return decrypted;
	}
}
