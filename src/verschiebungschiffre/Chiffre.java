package verschiebungschiffre;
/**
 * Verschluesselt einen Text
 * @author Simon Hoffmann
 *
 */
public class Chiffre {
	
	private int key = 0;
	
	/**
	 * Konstruktor
	 * @param key
	 */
	public Chiffre(int key) {
		this.key = key;
	}
	/**
	 * Ausgabe von Chiffriertabelle
	 */
	public void chart() {
		System.out.println("a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z");
		System.out.println("0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25");
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
	/**
	 * Grossbuchstaben werden klein, Sonderbuchstaben, Ziffern als Wort
	 * @param text
	 * @return Sonderbuchstaben freier Text
	 */
	public String language(String text) {
		//bufferedReader liest Umlaute nicht ein ... !!!!!!
		text = text.toLowerCase();
		text = text.replaceAll("\u00e4", "ae"); //ä
		text = text.replaceAll("\u00f6", "oe"); //ö
		text = text.replaceAll("\u00fc", "ue"); //ü
		text = text.replaceAll("\u00df", "ss"); //ß
		return text;
	}
	/**
	 * a=0,b=1,c=2, etc. nicht kodierte Zeichen kleiner Null
	 * @param letter
	 * @return Position vom Buchstaben im Alphabet
	 */
	public int letterToNumber(char letter) {
		switch(letter) {
		case 'a': return 0;
		case 'b': return 1;
		case 'c': return 2;
		case 'd': return 3;
		case 'e': return 4;
		case 'f': return 5;
		case 'g': return 6;
		case 'h': return 7;
		case 'i': return 8;
		case 'j': return 9;
		case 'k': return 10;
		case 'l': return 11;
		case 'm': return 12;
		case 'n': return 13;
		case 'o': return 14;
		case 'p': return 15;
		case 'q': return 16;
		case 'r': return 17;
		case 's': return 18;
		case 't': return 19;
		case 'u': return 20;
		case 'v': return 21;
		case 'w': return 22;
		case 'x': return 23;
		case 'y': return 24;
		case 'z': return 25;
		case ',': return -2;
		case '.': return -3;
		case '!': return -4;
		case '?': return -5;
		case '0': return -10;
		case '1': return -11;
		case '2': return -12;
		case '3': return -13;
		case '4': return -14;
		case '5': return -15;
		case '6': return -16;
		case '7': return -17;
		case '8': return -18;
		case '9': return -19;
		default: return -1;		
		}
	}
	/**
	 * 0=a, 1=b, 2=c, etc. nicht kodierte Zeichen kleiner Null
	 * @param number
	 * @return Buchstabe von der angebenen Position
	 */
	public char numberToLetter(int number) {
		switch(number) {
		case 0: return 'a';
		case 1: return 'b';
		case 2: return 'c';
		case 3: return 'd';
		case 4: return 'e';
		case 5: return 'f';
		case 6: return 'g';
		case 7: return 'h';
		case 8: return 'i';
		case 9: return 'j';
		case 10: return 'k';
		case 11: return 'l';
		case 12: return 'm';
		case 13: return 'n';
		case 14: return 'o';
		case 15: return 'p';
		case 16: return 'q';
		case 17: return 'r';
		case 18: return 's';
		case 19: return 't';
		case 20: return 'u';
		case 21: return 'v';
		case 22: return 'w';
		case 23: return 'x';
		case 24: return 'y';
		case 25: return 'z';
		case -2: return ',';
		case -3: return '.';
		case -4: return '!';
		case -5: return '?';
		case -10: return '0';
		case -11: return '1';
		case -12: return '2';
		case -13: return '3';
		case -14: return '4';
		case -15: return '5';
		case -16: return '6';
		case -17: return '7';
		case -18: return '8';
		case -19: return '9';
		default: return ' ';		
		}
	}
}
