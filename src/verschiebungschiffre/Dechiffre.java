package verschiebungschiffre;

import de.oop2023.util.UserInterface;

/**
 * Entschluesselt einen verschluesselten Text
 * 
 * @author Simon Hoffmann
 *
 */
public class Dechiffre {

	private int key = 0;

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

	/**
	 * a=0,b=1,c=2, etc. nicht kodierte Zeichen kleiner Null
	 * 
	 * @param letter
	 * @return Position vom Buchstaben im Alphabet
	 */
	public int letterToNumber(char letter) {
		switch (letter) {
			case 'a':
				return 0;
			case 'b':
				return 1;
			case 'c':
				return 2;
			case 'd':
				return 3;
			case 'e':
				return 4;
			case 'f':
				return 5;
			case 'g':
				return 6;
			case 'h':
				return 7;
			case 'i':
				return 8;
			case 'j':
				return 9;
			case 'k':
				return 10;
			case 'l':
				return 11;
			case 'm':
				return 12;
			case 'n':
				return 13;
			case 'o':
				return 14;
			case 'p':
				return 15;
			case 'q':
				return 16;
			case 'r':
				return 17;
			case 's':
				return 18;
			case 't':
				return 19;
			case 'u':
				return 20;
			case 'v':
				return 21;
			case 'w':
				return 22;
			case 'x':
				return 23;
			case 'y':
				return 24;
			case 'z':
				return 25;
			case ',':
				return -2;
			case '.':
				return -3;
			case '!':
				return -4;
			case '?':
				return -5;
			case '0':
				return -10;
			case '1':
				return -11;
			case '2':
				return -12;
			case '3':
				return -13;
			case '4':
				return -14;
			case '5':
				return -15;
			case '6':
				return -16;
			case '7':
				return -17;
			case '8':
				return -18;
			case '9':
				return -19;
			default:
				return -1;
		}
	}

	/**
	 * 0=a, 1=b, 2=c, etc. nicht kodierte Zeichen kleiner Null
	 * 
	 * @param number
	 * @return Buchstabe von der angebenen Position
	 */
	public char numberToLetter(int number) {
		switch (number) {
			case 0:
				return 'a';
			case 1:
				return 'b';
			case 2:
				return 'c';
			case 3:
				return 'd';
			case 4:
				return 'e';
			case 5:
				return 'f';
			case 6:
				return 'g';
			case 7:
				return 'h';
			case 8:
				return 'i';
			case 9:
				return 'j';
			case 10:
				return 'k';
			case 11:
				return 'l';
			case 12:
				return 'm';
			case 13:
				return 'n';
			case 14:
				return 'o';
			case 15:
				return 'p';
			case 16:
				return 'q';
			case 17:
				return 'r';
			case 18:
				return 's';
			case 19:
				return 't';
			case 20:
				return 'u';
			case 21:
				return 'v';
			case 22:
				return 'w';
			case 23:
				return 'x';
			case 24:
				return 'y';
			case 25:
				return 'z';
			case -2:
				return ',';
			case -3:
				return '.';
			case -4:
				return '!';
			case -5:
				return '?';
			case -10:
				return '0';
			case -11:
				return '1';
			case -12:
				return '2';
			case -13:
				return '3';
			case -14:
				return '4';
			case -15:
				return '5';
			case -16:
				return '6';
			case -17:
				return '7';
			case -18:
				return '8';
			case -19:
				return '9';
			default:
				return ' ';
		}
	}

}
