package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part1 {
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day1\\data.txt";
		
		final String [] digits = Files.readString(Path.of(path)).split("\r\n\r\n");
				
		int max = Integer.MIN_VALUE;
		
		for (String elf : digits) {
			String[] str = elf.split("\r\n");
			int sum = 0;
			for (String s : str) {
				sum += Integer.parseInt(s);
			}
			
			if (sum > max) {
				max = sum;
			}
		}
		
		System.out.println(max);
	}
}
