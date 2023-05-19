package verschiebungschiffre;
/**
 * Verschluesselt einen Text
 * @author Simon Hoffmann
 *
 */
public class Chiffre extends Crypto{
	/**
	 * Konstruktor
	 * @param key
	 */
	public Chiffre(int key) {
		this.key = key;
	}
	/**
	 * Verschiebt alle Buchstaben um den Schluessel
	 * @param text
	 * @return codierter text
	 */
	public String transformation(String text) {
		String encrypted = "";
		int x = 0;
		for(int i = 0; i < text.length(); i++) {
			x = letterToNumber(text.charAt(i));
			if (x >= 0) {
				//nur Kodierung von Buchstaben keine anderen Symbole
				x = (x + key) % 26;
			}
			encrypted = encrypted + numberToLetter(x);
		}
		return encrypted;
	}
}
