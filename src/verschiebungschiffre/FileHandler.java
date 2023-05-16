package verschiebungschiffre;

import java.io.*;
/**
 * 
 * @author Simon Hoffmann
 *
 */
public class FileHandler {
	
	private StringBuilder text;
	
	public FileHandler() {
		text = new StringBuilder();
	}
	public void leseTextAusDatei(String Dateiname){
		try(
		FileReader fr = new FileReader(Dateiname);
	    BufferedReader br = new BufferedReader(fr);
				){
	    String zeile = "";

	    do
	    {
	      zeile = br.readLine();
	      text.append(zeile);
	      text.append(" "); //Leerzeichen nach Zeilenende
	    }
	    while (zeile != null);
	    br.close();
		} catch (FileNotFoundException fe) {
			fe.printStackTrace(System.err);
		} catch (IOException ie) {
			ie.printStackTrace(System.err);
		}
	}
	public String toString() {
		return text.toString();
	}
}
