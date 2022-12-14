package Day11;

import java.util.Queue;
import java.util.function.LongUnaryOperator;

public class Monkey {
	
	private Queue<Item> items;
	private long itemCounter;
	private int divisibleWorryLevel;
	private int trueNextMonkey;
	private int falseNextMonkey;
	private LongUnaryOperator worry;
	private boolean typeOfWorry;
	private long divisor;

	public Queue<Item> getItems() {
		return items;
	}

	public void setItems(Queue<Item> items) {
		this.items = items;
	}

	public long getItemCounter() {
		return itemCounter;
	}

	public Monkey(Queue<Item> items, int divisibleWorryLevel, int trueNextMonkey, int falseNextMonkey, LongUnaryOperator worry, boolean typeOfWorry, long divisor) {
		this.items = items;
		this.itemCounter = 0;
		this.divisibleWorryLevel = divisibleWorryLevel;
		this.trueNextMonkey = trueNextMonkey;
		this.falseNextMonkey = falseNextMonkey;
		this.worry = worry;
		this.typeOfWorry = typeOfWorry;
		this.divisor = divisor;
	}

	public int throwItem(Item item) {
		itemCounter++;
		long newWorryLevel = worry.applyAsLong(item.getWorryLevel());
		
		if (typeOfWorry) {
			newWorryLevel = newWorryLevel / 3;
		} else {
			newWorryLevel = newWorryLevel % divisor;
		}
		
		item.setWorryLevel(newWorryLevel);
		
		if (item.getWorryLevel() % divisibleWorryLevel == 0) {
			return trueNextMonkey;
		} else {
			return falseNextMonkey;
		}
	}

}
