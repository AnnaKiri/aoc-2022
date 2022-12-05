package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part1 {
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day3\\data.txt";
		final String [] items = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		int result = 0;
		for (String str : items) {
			char[] firstArray = str.substring(0, (str.length() / 2)).toCharArray();
			char[] secondArray = str.substring(str.length() / 2).toCharArray();
			
			boolean find = false;
			for (int i = 0; i < firstArray.length && !find; i++) {
				for (int j = 0; j < secondArray.length && !find; j++) {
					if (firstArray[i] == secondArray[j]) {
						find = true;
						if (firstArray[i] > 96) {
							result += firstArray[i] - 96;
						} else {
							result += firstArray[i] - 38;
						}
						
					}
				}
			}
		}
		
		System.out.println(result);
	
	}
}
