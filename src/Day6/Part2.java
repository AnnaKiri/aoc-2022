package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class Part2 {
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day6\\data.txt";
		final String datastream = Files.readString(Path.of(path));
		
		for (int i = 13; i < datastream.length(); i++) {
			Set<Character> set = new HashSet<>();
			for (int j = 0; j < 14; j++) {
				set.add(datastream.charAt(i - j));
			}
			
			if (set.size() == 14) {
				System.out.println(i + 1);
				break;
			}
			
		}
	}
}