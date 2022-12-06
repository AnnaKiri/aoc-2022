package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part1 {
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day4\\data.txt";
		final String [] assignments = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		int counter = 0;
		for (String str : assignments) {
			String[] assignmentsForPair = str.split(",");
			String[] elf1 = assignmentsForPair[0].split("-");
			String[] elf2 = assignmentsForPair[1].split("-");
			
			int d1 = Integer.parseInt(elf1[0]);
			int d2 = Integer.parseInt(elf1[1]);
			int d3 = Integer.parseInt(elf2[0]);
			int d4 = Integer.parseInt(elf2[1]);
			
			boolean case1 = d1 >= d3 && d2 <= d4;
			boolean case2 = d1 <= d3 && d2 >= d4;
			
			if (case1 || case2) {
				counter++;
			}
		}
		System.out.println(counter);
	}
}
