package verschiebungschiffre;

import java.io.*;

import java.nio.charset.Charset;

/**
 * Klasse fuer das Auslesen/Schreiben von Dateien
 * @author Simon Hoffmann
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
	 * liest text aus Datei aus
	 * @param Dateiname
	 */
	public void readText(String filename) {
		try (
				FileReader fr = new FileReader(filename, Charset.forName("UTF-8"));
				BufferedReader br = new BufferedReader(fr);) {
			String zeile = "";

			do {
				zeile = br.readLine();
				text.append(zeile);
				text.append(" ");
			} while (zeile != null);
			br.close();
		} catch (FileNotFoundException fe) {
			fe.printStackTrace(System.err);
		} catch (IOException ie) {
			ie.printStackTrace(System.err);
		}
	}

	/**
	 * schreibt Text in eine Datei
	 * @param filename
	 * @param content
	 */
	public void writeFile(String filename, String content) {
		File datei = new File(filename);
		try (
				FileWriter fr = new FileWriter(datei);
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
