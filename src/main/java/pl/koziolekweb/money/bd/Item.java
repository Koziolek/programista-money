package pl.koziolekweb.money.bd;

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
}
