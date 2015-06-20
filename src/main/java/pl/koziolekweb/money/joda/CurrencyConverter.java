package pl.koziolekweb.money.joda;

import org.apache.commons.lang3.tuple.Pair;
import org.joda.money.CurrencyUnit;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * User: koziolek
 */
public class CurrencyConverter {

	private static Map<Pair<String, String>, BigDecimal> exchange = new HashMap<>();

	static {
		exchange.put(Pair.of("PLN", "EUR"), new BigDecimal(0.24));
		exchange.put(Pair.of("EUR", "PLN"), new BigDecimal(4.13));
	}

	public static BigDecimal conversionRate(CurrencyUnit from, String to) {
		if (from.getCurrencyCode().equalsIgnoreCase(to)) return BigDecimal.ONE;
		return exchange.get(Pair.of(from, to));
	}

	public static BigDecimal conversionRate(String from, String to) {
		if (from.equalsIgnoreCase(to)) return BigDecimal.ONE;
		return exchange.get(Pair.of(from, to));
	}
}
