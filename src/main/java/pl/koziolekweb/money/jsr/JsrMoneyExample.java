package pl.koziolekweb.money.jsr;

/**
 * User: koziolek
 */
public class JsrMoneyExample {

	public static void main(String[] args) {
		Basket basket = new Basket()
				.insert(Item.build("Koń", "PLN", 100.))
				.insert(Item.build("Kuc", "EUR", 30.))
				.insert(Item.build("Leming", "EUR", 100.))
				.insert(Item.build("Świnka morska", "PLN", 1.99));
		Receipt receipt = new Receipt(basket);
		receipt.printIn("PLN");
	}
}


