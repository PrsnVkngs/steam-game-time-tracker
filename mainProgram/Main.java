package mainProgram;

public class Main {

	public static void main(String[] args) {

		FileProcessor clean = new FileProcessor("O:\\Steam Game time Tracker\\my_games.txt");
		
		if(clean.cleanFile()) {
			System.out.println("success!");
		}
		else {
			System.out.println("failure :(");
		}
		
	}

}
