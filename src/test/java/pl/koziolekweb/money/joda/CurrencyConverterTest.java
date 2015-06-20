package pl.koziolekweb.money.joda;

import org.fest.assertions.Delta;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.fest.assertions.Assertions.assertThat;

public class CurrencyConverterTest {

	@Test
	public void shouldConversionRateReturnValid() {
		assertThat(
				CurrencyConverter.conversionRate("PLN", "EUR")
		).isEqualTo(new BigDecimal(0.24));
		assertThat(
				CurrencyConverter.conversionRate("PLN", "PLN")
		).isEqualTo(BigDecimal.ONE);

	}
}