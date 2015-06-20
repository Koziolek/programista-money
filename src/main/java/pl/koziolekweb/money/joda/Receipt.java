package pl.koziolekweb.money.joda;

import org.apache.commons.lang3.tuple.Pair;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.RoundingMode;

/**
 * User: koziolek
 */
public class Receipt {

	private final Basket basket;

	public void printIn(final String currencySymbol) {
		Money sum = basket.items
				.stream()
				.map(i -> Pair.of(i, convertPrice(currencySymbol, i)))
				.map(p -> {
					print(p);
					return p.getRight();
				})
				.reduce(Money.of(CurrencyUnit.of(currencySymbol), 0.), Money::plus);
		System.out.printf("Wartość koszyka to %s", sum.toString());
	}

	public Receipt(Basket basket) {
		this.basket = basket;
	}

	private void print(Pair<Item, Money> p) {
		System.out.printf("%-20s cena oryginlana to %-20s po przeliczeniu na %-20s to %s\n",
				p.getLeft().name,
				p.getLeft().price,
				p.getRight().getCurrencyUnit(),
				p.getRight()
		);
	}

	private Money convertPrice(String currencySymbol, Item i) {
		CurrencyUnit targetSymbol = CurrencyUnit.of(currencySymbol);
		if (i.price.getCurrencyUnit().equals(targetSymbol)) {
			return i.price;
		}
		return i.price.convertedTo(targetSymbol,
				CurrencyConverter.conversionRate(i.price.getCurrencyUnit()
						, currencySymbol)
				, RoundingMode.HALF_EVEN);
	}
}

interface State<T> {
	T detonate();
}

interface VoidState extends State<Void> {

	void detonate2();

	default Void detonate() {
		detonate2();
		return null;
	}
}