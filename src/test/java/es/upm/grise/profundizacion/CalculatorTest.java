package es.upm.grise.profundizacion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	private Calculator calculator;

	@BeforeEach
	public void init() {
		calculator = new Calculator();
		// () -> String.format("The map doesn't contain the key: %s", KEY)
	}

	@Test()
	void initCalculator() {
		assertEquals(new Vector<Double>(), calculator.numbers, () -> String.format("Checking the numbers from a freshly init Calculator class"));
	}

	@Test()
	void addAndRemoveWithNumbers() {
		Double numberToAddAndRemove = 1.0;
		Vector<Double> expectedNumbers = new Vector<Double>();
		expectedNumbers.add(numberToAddAndRemove);
		calculator.add(numberToAddAndRemove);
		assertEquals(expectedNumbers, calculator.numbers);
		expectedNumbers.remove(numberToAddAndRemove);
		calculator.remove(numberToAddAndRemove);
		assertEquals(expectedNumbers, calculator.numbers);
	}

	@Test()
	void removeWithNoNumbers() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			calculator.remove(1.0);
		});
	}

	@Test()
	void maxWithNoNumbers() {
		double expectedMax = Double.MIN_VALUE;
		assertEquals(expectedMax, calculator.max(), "Expected but got: ");
	}

	@Test()
	void maxWithNumbers() {
		double expectedMax = 2.0;
		calculator.add(2.0);
		assertEquals(expectedMax, calculator.max(), "Expected " + expectedMax + "but got: " + calculator.max());
	}

	@Test()
	void minWithNoNumbers() {
		double expectedMin = Double.MAX_VALUE;
		assertEquals(expectedMin, calculator.min(), "Expected " + expectedMin + "but got: " + calculator.min());
	}

	@Test()
	void minWithNumbers() {
		double expectedMin = 2.0;
		calculator.add(2.0);
		assertEquals(expectedMin, calculator.min(), "Expected " + expectedMin + "but got: " + calculator.min());
	}

	@Test()
	void averageWithNoNumbers() {
		Double expectedAverage = Double.NaN;
		assertEquals(expectedAverage, calculator.average(), "Expected " + expectedAverage + "but got: " + calculator.average());
	}

	@Test()
	void averageWithNumbers() {
		double expectedAverage = 5.0;
		calculator.add(2.0);
		calculator.add(8.0);
		assertEquals(expectedAverage, calculator.average(), "Expected " + expectedAverage + "but got: " + calculator.average());
	}

	@Test()
	void stddevWithNoNumbers() {
		Double expectedStddev = -0.0;
		assertEquals(expectedStddev, calculator.stddev(), "Expected " + expectedStddev + "but got: " + calculator.stddev());
	}

	@Test()
	void stddevWithNumbers() {
		double expectedStddev = 0.0;
		calculator.add(2.0);
		calculator.add(2.0);
		assertEquals(expectedStddev, calculator.stddev(), "Expected " + expectedStddev + "but got: " + calculator.stddev());
	}
}
