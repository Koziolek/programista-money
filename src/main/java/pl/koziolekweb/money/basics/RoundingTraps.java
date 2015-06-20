package pl.koziolekweb.money.basics;

/**
 * User: koziolek
 */
public class RoundingTraps {

	public static void main(String[] args) {
		double[] numbers = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9 };
		for (double nb : numbers) {
			System.out.format("1 + nb - nb == nb - nb + 1 dla %s  to %s\n",
					nb, 1 + nb - nb == nb - nb + 1);
		}
	}
}