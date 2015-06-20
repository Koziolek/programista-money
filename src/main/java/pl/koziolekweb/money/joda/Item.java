package pl.koziolekweb.money.joda;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

/**
 * User: koziolek
 */
public class Item {

	public final String name;
	public final Money price;

	public Item(String name, Money price) {
		this.name = name;
		this.price = price;
	}

	public static Item build(String name, String currencyCode, double value) {
		return new Item(name, Money.of(CurrencyUnit.of(currencyCode), value));
	}
}
