package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeSet;

public class Part2 {
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day1\\data.txt";
		
		final String [] digits = Files.readString(Path.of(path)).split("\r\n\r\n");
				
		TreeSet<Integer> calories = new TreeSet<>();
		
		for (String elf : digits) {
			String[] str = elf.split("\r\n");
			int sum = 0;
			for (String s : str) {
				sum += Integer.parseInt(s);
				calories.add(sum);
			}
		}
		
		System.out.println(calories.descendingSet().stream().limit(3).reduce((a,e) -> a + e).get());
	}
}
