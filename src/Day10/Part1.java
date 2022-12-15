package Day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part1 {
	
	static int x = 1;
	static int counter = 0;
	static int sum = 0;
	
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day10\\data.txt";
		final String [] instructions = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		for (String str : instructions) {
			if (str.equals("noop")) {
				doCalculation();
			} else {
				final String regex = "^(\\w{4}) (-?\\d+)?$";
				int value = Integer.parseInt(str.replaceAll(regex, "$2"));
				
				doCalculation();
				doCalculation();
				x = x + value;
			}
		}
		
		System.out.println(sum);
	}
	
	public static void doCalculation() {
		counter++;
		if (counter == 20 || counter == 60 || counter == 100 || counter == 140 || counter == 180 || counter == 220) {
			sum += x * counter;
		}
	}
}
