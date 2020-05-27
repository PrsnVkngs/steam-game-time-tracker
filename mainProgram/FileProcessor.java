package mainProgram;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author oskar
 * This class is called to take the input file the user provides as an HTML file, 
 * meaning the user would log in to their steam account and navigate to their games page,
 * then click save as... > "Complete HTML"
 * next, change the file extension into a .txt and feed into this program. 
 */



public class FileProcessor {

	String filePath;
	
	public FileProcessor(String filePath) {
		
		this.filePath = filePath;
		
	}
	
	public boolean cleanFile() {
		try {
			Scanner gameFile = new Scanner(new File(filePath));
			
			//Move file pointer to the first line of game data.
			while(gameFile.hasNextLine()) {
				String nLine = gameFile.nextLine();
				if(nLine.contains("gameListRowItem")) {
					break;
				}
			}
			
			FileWriter fw = new FileWriter("cleanfile.txt", false);
			//Move file pointer to the end of the game data and write to a temporary file.
			while(gameFile.hasNextLine()) {
				String nLine = gameFile.nextLine();
				if(nLine.contains("<br>")) {
					break;
				}
				if(nLine.contains("gameListRowItemName ellipsis") || nLine.contains("ellipsis hours_played")) {
					nLine = nLine.trim();
					fw.write(nLine + "\n");
				}
				
				
			}
			fw.close();
			
			return true;
		}
		catch (FileNotFoundException e ) {
			System.out.println("Please provide a valid file location.");
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
