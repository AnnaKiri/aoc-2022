package Day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;
import java.util.function.LongUnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day11\\data.txt";
		final String [] notes = Files.readString(Path.of(path)).split("\r\n\r\n");
		
		List<Monkey> monkeyList = new ArrayList<>();
		for (String str : notes) {
			Matcher itemsMat = Pattern.compile("Starting items: ([(0-9, ]+)").matcher(str);
			Matcher operationMat = Pattern.compile("Operation: new = old (\\+|\\*) (\\d+|\\w+)").matcher(str);
			Matcher divisionMat = Pattern.compile("Test: divisible by (\\d+)").matcher(str);
			Matcher trueMonkeyMat = Pattern.compile("If true: throw to monkey (\\d)").matcher(str);
			Matcher falseMonkeyMat = Pattern.compile("If false: throw to monkey (\\d)").matcher(str);
		
		
			Queue<Item> itemsMonkey = new LinkedList<>();
			
			String items = null;
			if (itemsMat.find()) {
				items = itemsMat.group(1);
			}
			String[] itemsArray = items.split(", ");
			for (String string : itemsArray) {
				itemsMonkey.add(new Item(Integer.parseInt(string)));
			}
			
			LongUnaryOperator operation = null;
			char symbol;
			if (operationMat.find()) {
				symbol = operationMat.group(1).charAt(0);

				if (operationMat.group(2).equals("old")) {
					if (symbol == '+') {
						operation = a -> a + a;
					} else {
						operation = a -> a * a;
					}
				} else {
					int temp = Integer.parseInt(operationMat.group(2));
					
					if (symbol == '+') {
						operation = a -> a + temp;
					} else {
						operation = a -> a * temp;
					}
				}
			}
			
			int divider = 0;
			if (divisionMat.find()) {
				divider = Integer.parseInt(divisionMat.group(1));
			}
			
			int trueMonkeyID = 0;
			if (trueMonkeyMat.find()) {
				trueMonkeyID = Integer.parseInt(trueMonkeyMat.group(1));
			}
			
			int falseMonkeyID = 0;
			if (falseMonkeyMat.find()) {
				falseMonkeyID = Integer.parseInt(falseMonkeyMat.group(1));
			}
			
			Monkey monkey = new Monkey(itemsMonkey, divider, trueMonkeyID, falseMonkeyID, operation, false, 9699690);
			monkeyList.add(monkey);
		}
		
		for (int i = 0; i < 10000; i++) {
			for (Monkey monkey : monkeyList) {
				if (!monkey.getItems().isEmpty()) {
					Queue<Item> items = monkey.getItems();
					for (Item item : items) {
						int index = monkey.throwItem(item);
						monkeyList.get(index).getItems().add(item);
					}
					items.clear();
				}
			}
		}
		
		TreeSet<Long> itemCounters = new TreeSet<>();
		for (Monkey monkey : monkeyList) {
			itemCounters.add(monkey.getItemCounter());
		}
		
		System.out.println(itemCounters.pollLast() * itemCounters.pollLast());
	}
}
