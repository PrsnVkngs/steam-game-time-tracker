package mainProgram;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileSpider {
	
	public FileSpider(String filePath) {
		
		displayStats(filePath);
		
	}
	
	private void displayStats(String filePath) {
		
		double hours = 0, total = 0;
		String game, nLine;
		
		try {
			Scanner filtered = new Scanner(new File(filePath));
			
			while(filtered.hasNextLine()) {
				nLine = filtered.nextLine();
								
				if(nLine.contains("hours_played")) {
					nLine = nLine.substring(34);
					nLine = nLine.substring(0, nLine.length()-18);
					System.out.println(nLine);
					hours = Double.parseDouble(nLine.trim().replaceAll(",", ""));
					total+=hours;
				}
				
			}
			
			//System.out.println(total);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (StringIndexOutOfBoundsException e) {
			System.out.printf("%.2f",total);
		}
		catch (NumberFormatException e) {
			System.out.printf("%.2f",total);
		}
		
	}
	
	
	
}
