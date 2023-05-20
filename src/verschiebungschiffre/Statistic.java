package verschiebungschiffre;

/**
 * Haeufigkeitsanalyse der Buchstaben fuer die Dechiffre
 * 
 * @author Simon Hoffmann, Julian Mosig von Aehrenfeld
 *
 */
public class Statistic {

	private String text;
	public char[] freqOrder = { 'e', 'n', 'i', 's', 'r', 'a', 't', 'd', 'h', 'u', 'l', 'c', 'g', 'm', 'o', 'b', 'w',
			'f', 'k', 'z', 'p', 'v', 'j', 'y', 'x', 'q' };
	private int[] letterCount = new int[freqOrder.length]; // jedem Buchstaben Häufigkeit zuordnen

	/**
	 * Konstruktor
	 * 
	 * @param text Text der eine Buchstabenzaehlung erhalten soll
	 */
	public Statistic(String text) {
		this.text = text;
		for (int i = 0; i < 26; i++) {
			letterCount[i] = 0;
		}
	}

	/**
	 * ueberprueft die Haeufigkeitsverteilung
	 * 
	 * @return maxFreq Integerwert repraesentativ fuer den haeufigsten Buchstaben (orientiert an freqOrder-Array)
	 */
	public int maxFrequencyIndex() {
		int maxFreq = 0;

		for (int i = 0; i < letterCount.length; i++) {
			maxFreq = letterCount[i] > letterCount[maxFreq] ? i : maxFreq;
		}
		return maxFreq;
	}

	/**
	 * zaehlt die Haeufigkeit aller Buchstaben
	 */
	public void textToFrequency() {
		text = text.replaceAll("[^\\p{IsAlphabetic}]+", ""); // alle Sonderzeichen ersetzen
		text = text.replaceAll(" ", ""); // alle Leerzeichen entfernen
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < freqOrder.length; j++) {
				if (text.charAt(i) == freqOrder[j]) {
					letterCount[j] = letterCount[j] + 1;
				}
			}
		}
	}
}
