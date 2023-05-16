package verschiebungschiffre;

import java.io.*;
/**
 * 
 * @author Simon Hoffmann
 *
 */
public class FileHandler {
	
	private StringBuilder text;
	/**
	 * 
	 */
	public FileHandler() {
		text = new StringBuilder();
	}
	/**
	 * 
	 * @param Dateiname
	 */
	public void readText(String filename){
		try(
		FileReader fr = new FileReader(filename);
	    BufferedReader br = new BufferedReader(fr);
				){
	    String zeile = "";

	    do
	    {
	      zeile = br.readLine();
	      text.append(zeile);
	      text.append(" ");
	    }
	    while (zeile != null);
	    br.close();
		} catch (FileNotFoundException fe) {
			fe.printStackTrace(System.err);
		} catch (IOException ie) {
			ie.printStackTrace(System.err);
		}
	}
	/**
	 * 
	 * @param filename
	 * @param content
	 */
	public void writeFile(String filename, String content) {
		File datei = new File(filename);
		try (
			FileWriter fr = new FileWriter(datei);
			BufferedWriter br = new BufferedWriter(fr);
			PrintWriter pr = new PrintWriter(br);
				){
			pr.println(content);
			
			pr.close();
		}catch (FileNotFoundException fe) {
			System.out.println(fe);
		}catch (IOException ie) {
			System.out.println(ie);
		}
	}
	/**
	 * 
	 */
	public String toString() {
		return text.toString();
	}
}
