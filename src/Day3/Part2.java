package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part2 {
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day3\\data.txt";
		final String [] items = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		int result = 0;
		for (int i = 0; i < items.length - 2; i +=3) {
			char[] firstElf = items[i].toCharArray();
			char[] secondElf = items[i + 1].toCharArray();
			char[] thirdElf = items[i + 2].toCharArray();
			
			boolean find = false;
			for (int l = 0; l < firstElf.length && !find; l++) {
				for (int j = 0; j < secondElf.length && !find; j++) {
					for (int k = 0; k < thirdElf.length && !find; k++) {
						
						if (firstElf[l] == secondElf[j] && firstElf[l] == thirdElf[k] && secondElf[j] == thirdElf[k]) {
							find = true;
							if (firstElf[l] > 96) {
								result += firstElf[l] - 96;
							} else {
								result += firstElf[l] - 38;
							}
						}
					}
				}
			}
		}
	
		System.out.println(result);
	
	}
}
