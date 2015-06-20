package pl.koziolekweb.money.bd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: koziolek
 */
public class ShopBasket {

	private final List<Item> items;

	public ShopBasket() {
		items = Collections.emptyList();
	}

	private ShopBasket(Item item, ShopBasket old) {
		this.items = new ArrayList<>(old.items);
		this.items.add(item);
	}

	public ShopBasket insert(Item item) {
		return new ShopBasket(item, this);
	}

}
