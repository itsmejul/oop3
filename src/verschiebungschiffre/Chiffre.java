package verschiebungschiffre;
/**
 * 
 * @author Simon Hoffmann
 *
 */
public class Chiffre {
	public Chiffre() {

	}
	/**
	 * 
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

	// test
}
