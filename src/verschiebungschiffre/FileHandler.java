package verschiebungschiffre;

import java.io.*;

import java.nio.charset.Charset;

/**
 * Klasse fuer das Auslesen/Schreiben von Dateien
 * 
 * @author Simon Hoffmann, Julian Mosig von Aehrenfeld
 *
 */
public class FileHandler {

	private StringBuilder text;

	/**
	 * Konstruktor fuer Dateibehandler
	 */
	public FileHandler() {
		text = new StringBuilder();
	}

	/**
	 * Liest einen Text(String) aus der Datei aus.
	 * 
	 * @param filename Name der auszulesenden Datei
	 */
	public void readText(String filename) {
		text = new StringBuilder();
		try (
				FileReader fr = new FileReader(filename, Charset.forName("UTF-8"));
				BufferedReader br = new BufferedReader(fr);) {
			String zeile = "";

			do {
				zeile = br.readLine();
				if (zeile != null) {
					text.append(zeile);
					text.append(" ");
				} else {
					break;
				}

			} while (true);
			br.close();
		} catch (FileNotFoundException fe) {
			fe.printStackTrace(System.err);
		} catch (IOException ie) {
			ie.printStackTrace(System.err);
		}
	}

	/**
	 * Schreibt einen Text(String) in eine Datei
	 * 
	 * @param filename Name der Datei, in die der Inhalt geschrieben werden soll
	 * @param content Inhalt fuer die Datei
	 */
	public void writeFile(String filename, String content) {
		File datei = new File(filename);
		try (
				FileWriter fr = new FileWriter(datei, Charset.forName("UTF-8"));
				BufferedWriter br = new BufferedWriter(fr);
				PrintWriter pr = new PrintWriter(br);) {
			pr.println(content);

			pr.close();
		} catch (FileNotFoundException fe) {
			System.out.println(fe);
		} catch (IOException ie) {
			System.out.println(ie);
		}
	}

	/**
	 * toString Methode fuer Dateibehandler
	 */
	public String toString() {
		return text.toString();
	}
}
