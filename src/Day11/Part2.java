package Day11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

public class Part2 {
	public static void main(String[] args) throws IOException {
		
		Queue<Item> items0Monkey = new LinkedList<>();
		items0Monkey.add(new Item(54));
		items0Monkey.add(new Item(98));
		items0Monkey.add(new Item(50));
		items0Monkey.add(new Item(94));
		items0Monkey.add(new Item(69));
		items0Monkey.add(new Item(62));
		items0Monkey.add(new Item(53));
		items0Monkey.add(new Item(85));
		
		Monkey monkey0 = new Monkey(items0Monkey, 3, 2, 1, a -> a * 13, false, 9699690);
		
		Queue<Item> items1Monkey = new LinkedList<>();
		items1Monkey.add(new Item(71));
		items1Monkey.add(new Item(55));
		items1Monkey.add(new Item(82));
		
		Monkey monkey1 = new Monkey(items1Monkey, 13, 7, 2, a -> a + 2, false, 9699690);
				
		Queue<Item> items2Monkey = new LinkedList<>();
		items2Monkey.add(new Item(77));
		items2Monkey.add(new Item(73));
		items2Monkey.add(new Item(86));
		items2Monkey.add(new Item(72));
		items2Monkey.add(new Item(87));
		
		Monkey monkey2 = new Monkey(items2Monkey, 19, 4, 7, a -> a + 8, false, 9699690);
		
		Queue<Item> items3Monkey = new LinkedList<>();
		items3Monkey.add(new Item(97));
		items3Monkey.add(new Item(91));
		
		Monkey monkey3 = new Monkey(items3Monkey, 17, 6, 5, a -> a + 1, false, 9699690);
		
		Queue<Item> items4Monkey = new LinkedList<>();
		items4Monkey.add(new Item(78));
		items4Monkey.add(new Item(97));
		items4Monkey.add(new Item(51));
		items4Monkey.add(new Item(85));
		items4Monkey.add(new Item(66));
		items4Monkey.add(new Item(63));
		items4Monkey.add(new Item(62));
		
		Monkey monkey4 = new Monkey(items4Monkey, 5, 6, 3, a -> a * 17, false, 9699690);
		
		Queue<Item> items5Monkey = new LinkedList<>();
		items5Monkey.add(new Item(88));
		
		Monkey monkey5 = new Monkey(items5Monkey, 7, 1, 0, a -> a + 3, false, 9699690);
		
		Queue<Item> items6Monkey = new LinkedList<>();
		items6Monkey.add(new Item(87));
		items6Monkey.add(new Item(57));
		items6Monkey.add(new Item(63));
		items6Monkey.add(new Item(86));
		items6Monkey.add(new Item(87));
		items6Monkey.add(new Item(53));
		
		Monkey monkey6 = new Monkey(items6Monkey, 11, 5, 0, a -> a * a, false, 9699690);
		
		Queue<Item> items7Monkey = new LinkedList<>();
		items7Monkey.add(new Item(73));
		items7Monkey.add(new Item(59));
		items7Monkey.add(new Item(82));
		items7Monkey.add(new Item(65));
		
		Monkey monkey7 = new Monkey(items7Monkey, 2, 4, 3, a -> a + 6, false, 9699690);
		
		List<Monkey> monkeyList = new ArrayList<>();
		monkeyList.add(monkey0);
		monkeyList.add(monkey1);
		monkeyList.add(monkey2);
		monkeyList.add(monkey3);
		monkeyList.add(monkey4);
		monkeyList.add(monkey5);
		monkeyList.add(monkey6);
		monkeyList.add(monkey7);
		
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
