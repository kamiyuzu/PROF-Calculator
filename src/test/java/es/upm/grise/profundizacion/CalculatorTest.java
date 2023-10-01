package es.upm.grise.profundizacion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	private Calculator calculator;
	private Vector<Double> state;

	@BeforeEach
	public void init() {
		state = new Vector<Double>();
		calculator = new Calculator(state);
	}

	@Test()
	void initCalculator() {
		Vector<Double> expected_state = new Vector<Double>();
		assertEquals(expected_state, calculator.numbers, "Checking the numbers from a freshly init Calculator class");
	}

	@Test()
	void addWithNumbers() {
		Double numberToAddAndRemove = 1.0;
		state.add(numberToAddAndRemove);
		assertEquals(state, calculator.numbers, "Expected " + state + " but got: " + calculator.numbers);
	}

	@Test()
	void removeWithNumbers() {
		Double numberToAddAndRemove = 1.0;
		state.add(numberToAddAndRemove);
		calculator.remove(numberToAddAndRemove);
		Vector<Double> expected_state = new Vector<Double>();
		assertEquals(expected_state, calculator.numbers, "Expected " + state + " but got: " + calculator.numbers);
	}

	@Test()
	void removeWithNoNumbers() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			calculator.remove(1.0);
		}, "Expected throw when no numbers in the calculator");
	}

	@Test()
	void maxWithNoNumbers() {
		Double expectedMax = Double.MIN_VALUE;
		assertEquals(expectedMax, calculator.max(), "Expected max:" + expectedMax + " but got: " + calculator.max());
	}

	@Test()
	void maxWithNumbers() {
		Double expectedMax = 2.0;
		state.add(expectedMax);
		assertEquals(expectedMax, calculator.max(), "Expected max:" + expectedMax + "but got: " + calculator.max());
	}

	@Test()
	void minWithNoNumbers() {
		Double expectedMin = Double.MAX_VALUE;
		assertEquals(expectedMin, calculator.min(), "Expected min:" + expectedMin + "but got: " + calculator.min());
	}

	@Test()
	void minWithNumbers() {
		Double expectedMin = 2.0;
		state.add(expectedMin);
		assertEquals(expectedMin, calculator.min(), "Expected min:" + expectedMin + "but got: " + calculator.min());
	}

	@Test()
	void averageWithNoNumbers() {
		Double expectedAverage = Double.NaN;
		assertEquals(expectedAverage, calculator.average(), "Expected average:" + expectedAverage + "but got: " + calculator.average());
	}

	@Test()
	void averageWithNumbers() {
		Double expectedAverage = 5.0;
		state.add(2.0);
		state.add(8.0);
		assertEquals(expectedAverage, calculator.average(), "Expected average:" + expectedAverage + "but got: " + calculator.average());
	}

	@Test()
	void stddevWithNoNumbers() {
		Double expectedStddev = -0.0;
		assertEquals(expectedStddev, calculator.stddev(), "Expected stddev:" + expectedStddev + "but got: " + calculator.stddev());
	}

	@Test()
	void stddevWithNumbers() {
		Double expectedStddev = 0.0;
		state.add(2.0);
		state.add(2.0);
		assertEquals(expectedStddev, calculator.stddev(), "Expected stddev:" + expectedStddev + "but got: " + calculator.stddev());
	}
}
