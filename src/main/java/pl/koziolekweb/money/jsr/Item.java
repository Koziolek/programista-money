package pl.koziolekweb.money.jsr;


import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;

/**
 * User: koziolek
 */
public class Item {

	public final String name;
	public final MonetaryAmount price;

	public Item(String name, MonetaryAmount price) {
		this.name = name;
		this.price = price;
	}

	public static Item build(String name, String currencyCode, double value) {
		return new Item(name, Money.of(value, currencyCode));
	}
}
