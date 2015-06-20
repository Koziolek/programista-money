package pl.koziolekweb.money.basics;

import com.google.common.base.Preconditions;

import java.text.DecimalFormat;

/**
 * User: koziolek
 */
public class Money {

	private final Long value;

	public static final DecimalFormat LESS_FORMAT = new DecimalFormat("0000");

	public Money(Long value) {
		Preconditions.checkArgument(value >= 0);
		this.value = value;
	}

	public Money add(Money money) {
		Preconditions.checkArgument(money != null, "Money can not be null");
		return new Money(this.value + money.value);
	}


	public Money multiply(Long multiplier) {
		Preconditions.checkArgument(multiplier != null, "Multiplier can not be null");
		Preconditions.checkArgument(multiplier >= 0);
		return new Money(this.value * multiplier);
	}

	public Money subtract(Money money) {
		Preconditions.checkArgument(money != null, "Money can not be null");
		return new Money(this.value - money.value);
	}

	public Pair<Money, Money> divide(Long denominator) {
		Preconditions.checkArgument(denominator != null, "Denominator can not be null");
		Preconditions.checkArgument(denominator > 0, "Denominator must be greater than 0.");
		Long quotient = value / denominator;
		Long remainder = value % denominator;
		return Pair.of(new Money(quotient), new Money(remainder));
	}

	@Override
	public String toString() {
		Long grand = value / 10000;
		Long less = value % 10000;
		return grand + "." + LESS_FORMAT.format(less);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Money)) return false;

		Money money = (Money) o;

		if (!value.equals(money.value)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}
}


class Pair<A, B> {

	public final A left;
	public final B right;

	public static <L, R> Pair<L, R> of(L left, R right) {
		return new Pair<>(left, right);
	}

	private Pair(A left, B right) {
		this.left = left;
		this.right = right;
	}
}