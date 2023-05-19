package verschiebungschiffre;
/**
 * Haeufigkeitsanalyse der Buchstaben fuer die Dechiffre
 * @author Simon Hoffmann
 *
 */
public class Statistic {
	
	private String text;
	private char[] freqOrder = {'e','n','i','s','r','a','t','d','h','u','l','c','g','m','o','b','w','f','k','z','p','v','j','y','x','q'};
	private int[] letterCount = new int[freqOrder.length]; //jedem Buchstaben Häufigkeit zuordnen
	/**
	 * Konstruktor
	 * @param text
	 */
	public Statistic(String text) {
		this.text = text;
		for(int i = 0; i<26;i++) {
			letterCount[i] = 0;
		}
	}
	/**
	 * ueberprueft die Haeufigkeitsverteilung 
	 * @return wahr wenn Haeufigkeitsverteilung der deutschen Buchstabenhaeufigkeit uebereinstimmt
	 */
	public boolean frequencyOrder() {
		int x = 0;
		for(int i = 0; i<letterCount.length - 1; i++) {
			if(letterCount[i] < letterCount[i+1]) {
				x = x +1;
			}
		}
		if(x == 0) {
			return true;
		}else {
			return false;
		}
	}
	public void textToFrequency() {
		text = text.replaceAll("[^\\p{IsAlphabetic}]+",""); //alle Sonderzeichen ersetzen
		text = text.replaceAll(" ", ""); //alle Leerzeichen entfernen
		for(int i = 0;i<text.length(); i++) {
			for(int j = 0;j<freqOrder.length; j++) {
				if(text.charAt(i) == freqOrder[j]) {
					letterCount[j] = letterCount[j] + 1;
				}
			}
		}
	}
}
