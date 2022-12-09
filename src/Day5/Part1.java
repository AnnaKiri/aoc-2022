package Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Part1 {
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day5\\data.txt";
		final String [] procedure = Files.readString(Path.of(path)).lines().toArray(String[]::new);
				
		Stack<Character> stack1 = new Stack<>();
		stack1.push('Z');
		stack1.push('J');
		stack1.push('N');
		stack1.push('W');
		stack1.push('P');
		stack1.push('S');
		Stack<Character> stack2 = new Stack<>();
		stack2.push('G');
		stack2.push('S');
		stack2.push('T');
		Stack<Character> stack3 = new Stack<>();
		stack3.push('V');
		stack3.push('Q');
		stack3.push('R');
		stack3.push('L');
		stack3.push('H');
		Stack<Character> stack4 = new Stack<>();
		stack4.push('V');
		stack4.push('S');
		stack4.push('T');
		stack4.push('D');
		Stack<Character> stack5 = new Stack<>();
		stack5.push('Q');
		stack5.push('Z');
		stack5.push('T');
		stack5.push('D');
		stack5.push('B');
		stack5.push('M');
		stack5.push('J');
		Stack<Character> stack6 = new Stack<>();
		stack6.push('M');
		stack6.push('W');
		stack6.push('T');
		stack6.push('J');
		stack6.push('D');
		stack6.push('C');
		stack6.push('Z');
		stack6.push('L');
		Stack<Character> stack7 = new Stack<>();
		stack7.push('L');
		stack7.push('P');
		stack7.push('M');
		stack7.push('W');
		stack7.push('G');
		stack7.push('T');
		stack7.push('J');
		Stack<Character> stack8 = new Stack<>();
		stack8.push('N');
		stack8.push('G');
		stack8.push('M');
		stack8.push('T');
		stack8.push('B');
		stack8.push('F');
		stack8.push('Q');
		stack8.push('H');
		Stack<Character> stack9 = new Stack<>();
		stack9.push('R');
		stack9.push('D');
		stack9.push('G');
		stack9.push('C');
		stack9.push('P');
		stack9.push('B');
		stack9.push('Q');
		stack9.push('W');
		
		List<Stack<Character>> list = new ArrayList<>();
		list.add(stack1);
		list.add(stack2);
		list.add(stack3);
		list.add(stack4);
		list.add(stack5);
		list.add(stack6);
		list.add(stack7);
		list.add(stack8);
		list.add(stack9);
		
		for (String str : procedure) {
			final String regex = "^move (\\d+) from (\\d) to (\\d)$";
			int crates = Integer.parseInt(str.replaceAll(regex, "$1"));
			int stackFrom = Integer.parseInt(str.replaceAll(regex, "$2"));
			int stackTo = Integer.parseInt(str.replaceAll(regex, "$3"));
			for (int i = 0; i < crates; i++) {
				if (!list.get(stackFrom-1).empty()) {
					list.get(stackTo-1).push(list.get(stackFrom-1).pop());
				}
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).peek());
		}
	}
}
