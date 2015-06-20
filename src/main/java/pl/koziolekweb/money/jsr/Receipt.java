package pl.koziolekweb.money.jsr;

import org.apache.commons.lang3.tuple.Pair;
import org.javamoney.moneta.Money;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import javax.money.MonetaryCurrencies;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;

/**
 * User: koziolek
 */
public class Receipt {

	private final Basket basket;

	public void printIn(final String currencySymbol) {
		MonetaryAmount sum = basket.items
				.stream()
				.map(i -> Pair.of(i, convertPrice(currencySymbol, i)))
				.map(p -> {
					print(p);
					return p.getRight();
				})
				.reduce(Money.of(0., currencySymbol), MonetaryAmount::add);
		System.out.printf("Wartość koszyka to %s", sum.toString());
	}

	public Receipt(Basket basket) {
		this.basket = basket;
	}

	private void print(Pair<Item, MonetaryAmount> p) {
		System.out.printf("%-20s cena oryginlana to %-20s po przeliczeniu na %-20s to %s\n",
				p.getLeft().name,
				p.getLeft().price,
				p.getRight().getCurrency(),
				p.getRight()
		);
	}

	private MonetaryAmount convertPrice(String currencySymbol, Item i) {
		if (i.price.getCurrency().getCurrencyCode().equals(currencySymbol)) {
			return i.price;
		}
		ExchangeRateProvider ecbRateProvider =
				MonetaryConversions.getExchangeRateProvider("IMF");
		CurrencyUnit target = MonetaryCurrencies.getCurrency(currencySymbol);
		CurrencyConversion targetConvertion = ecbRateProvider.getCurrencyConversion(target);
		return i.price.with(targetConvertion);
	}
}
