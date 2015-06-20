package pl.koziolekweb.money.basics;

import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class MoneyTest {

	@Test
	public void shouldToString() {
		Money one = new Money(1_0000L);
		assertThat(one.toString()).isEqualTo("1.0000");
		Money ten = new Money(10_0000L);
		assertThat(ten.toString()).isEqualTo("10.0000");
		Money zeroOne = new Money(100L);
		assertThat(zeroOne.toString()).isEqualTo("0.0100");
		Money zeroTen = new Money(1000L);
		assertThat(zeroTen.toString()).isEqualTo("0.1000");
	}

	@Test
	public void shouldDivide() {
		Money one = new Money(1_0000L);
		Pair<Money, Money> divide = one.divide(100L);
		assertThat(divide.left).isEqualTo(new Money(100L));
		assertThat(divide.right).isEqualTo(new Money(0L));

		Money two = new Money(2_0000L);
		Pair<Money, Money> divide2 = two.divide(3L);
		assertThat(divide2.left).isEqualTo(new Money(6666L));
		assertThat(divide2.right).isEqualTo(new Money(2L));
	}
}