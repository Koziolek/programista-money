package pl.koziolekweb.money.bd;

import com.google.common.base.Preconditions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * User: koziolek
 */
public class Money {

	private final BigDecimal value;

	private static final DecimalFormat DF = new DecimalFormat("#.0000");

	public Money(String value) {
		this(new BigDecimal(value, new MathContext(4, RoundingMode.HALF_UP)));
	}

	private Money(BigDecimal value) {
		Preconditions.checkArgument(value.compareTo(BigDecimal.ZERO) >= 0, "Value can not be less than 0.");
		this.value = value;
	}

	public Money add(Money money) {
		Preconditions.checkArgument(money != null, "Money can not be null");
		return new Money(value.add(money.value));
	}

	public Money subtract(Money money) {
		Preconditions.checkArgument(money != null, "Money can not be null");
		return new Money(this.value.subtract(money.value));
	}

	public Money multiply(BigDecimal multiplier) {
		Preconditions.checkArgument(multiplier != null, "Multiplier can not be null");
		Preconditions.checkArgument(multiplier.compareTo(BigDecimal.ZERO) >= 0);
		return new Money(this.value.multiply(multiplier));
	}

	public Money divide(BigDecimal denominator) {
		Preconditions.checkArgument(denominator != null, "Denominator can not be null");
		Preconditions.checkArgument(denominator.compareTo(BigDecimal.ZERO) >= 0, "Denominator must be greater than 0.");
		return new Money(this.value.divide(denominator));
	}

	@Override
	public String toString() {
		return DF.format(value);
	}

}
