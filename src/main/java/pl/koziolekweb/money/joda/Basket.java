package pl.koziolekweb.money.joda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * User: koziolek
 */
public class Basket {

	public final List<Item> items;

	public Basket() {
		items = Collections.unmodifiableList(new ArrayList<Item>());
	}

	private Basket(Item item, Basket old) {
		ArrayList<Item> items = new ArrayList<>(old.items);
		items.add(item);
		this.items = Collections.unmodifiableList(items);
	}

	public Basket insert(Item item) {
		return new Basket(item, this);
	}

}
