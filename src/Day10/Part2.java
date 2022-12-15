package Day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part2 {

	static int x = 2;
	static int counter = 0;
	
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day10\\data.txt";
		final String [] instructions = Files.readString(Path.of(path)).lines().toArray(String[]::new);
				
		for (String str : instructions) {
			if (str.equals("noop")) {
				doPaint();
			} else {
				final String regex = "^(\\w{4}) (-?\\d+)?$";
				int value = Integer.parseInt(str.replaceAll(regex, "$2"));
				
				doPaint();
				doPaint();
				x = x + value;
			}
		}
	}
	
	public static void doPaint() {
		counter++;
		int pointerHor = counter % 40;
		if (counter == 41 || counter == 81 || counter == 121 || counter == 161 || counter == 201) {
			System.out.println();
		}
		if (pointerHor == x || pointerHor == x - 1 || pointerHor == x + 1) {
			System.out.print("#");
		} else {
			System.out.print(".");
		}
		
		try {
			Thread.sleep(8);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}