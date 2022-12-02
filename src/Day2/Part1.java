package Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part1 {
	public static void main(String[] args) throws IOException {

		String path = ".\\src\\Day2\\data.txt";
		
		final String [] strategy = Files.readString(Path.of(path)).split("\r\n");
		
		int totalScore = 0;

		for (String val : strategy) {
			String[] round = val.split(" ");
			switch (round[0]) {
			case "A":
				if (round[1].equals("X")) {		//draw
					totalScore += (1 + 3);
				} else if (round[1].equals("Y")) {		// win
					totalScore += (2 + 6);
				} else {						// lost
					totalScore += 3;
				}
				break;
			case "B":
				if (round[1].equals("Y")) {		//draw
					totalScore += (2 + 3);
				} else if (round[1].equals("Z")) {		// win
					totalScore += (3 + 6);
				} else {						// lost
					totalScore += 1;
				}
				break;
			case "C":
				if (round[1].equals("Z")) {		//draw
					totalScore += (3 + 3);
				} else if (round[1].equals("X")) {		// win
					totalScore += (1 + 6);
				} else {						// lost
					totalScore += 2;
				}
				break;
			default:
				System.out.println("Error1!");
				return;
			}
		}
		
		System.out.println(totalScore);
		
	}
}
