package verschiebungschiffre;

public class Chiffre {
	public Chiffre() {
		
	}
	public String language(String text) {
		text = text.toLowerCase();
		text = text.replace("ä", "ae");
		text = text.replace("ö", "oe");
		text = text.replace("ü", "ue");
		text = text.replace("ß", "ss");
		return text;
	}
}
