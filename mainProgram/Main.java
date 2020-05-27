package mainProgram;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		FileProcessor clean = new FileProcessor("O:\\Steam Game time Tracker\\my_games.txt");
		
		FileSpider total = new FileSpider("O:\\Steam Game time Tracker\\cleanfile.txt");
		
	}

}
