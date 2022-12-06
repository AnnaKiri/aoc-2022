package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class Part1 {
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day6\\data.txt";
		final String datastream = Files.readString(Path.of(path));
		
		for (int i = 3; i < datastream.length(); i++) {
			Set<Character> set = new HashSet<>();
			set.add(datastream.charAt(i));
			set.add(datastream.charAt(i - 1));
			set.add(datastream.charAt(i - 2));
			set.add(datastream.charAt(i - 3));
			
			if (set.size() == 4) {
				System.out.println(i + 1);
				break;
			}
			
		}
	}
}
