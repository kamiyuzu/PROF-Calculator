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
	}

	@Test()
	void initCalculator() {
		assertEquals(new Vector<Double>(), calculator.numbers, "Checking the numbers from a freshly init Calculator class");
	}

	@Test()
	void addWithNumbers() {
		Double numberToAddAndRemove = 1.0;
		Vector<Double> expectedNumbers = new Vector<Double>();
		expectedNumbers.add(numberToAddAndRemove);
		calculator.add(numberToAddAndRemove);
		assertEquals(expectedNumbers, calculator.numbers, "Expected " + expectedNumbers + " but got: " + calculator.numbers);
	}

	@Test()
	void removeWithNumbers() {
		Vector<Double> state = new Vector<Double>();
		Double numberToAddAndRemove = 1.0;
		state.add(numberToAddAndRemove);
		calculator = new Calculator(state);
		calculator.remove(numberToAddAndRemove);
		assertEquals(new Vector<Double>(), calculator.numbers, "Expected " + state + " but got: " + calculator.numbers);
	}

	@Test()
	void removeWithNoNumbers() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			calculator.remove(1.0);
		}, "Expected throw when no numbers in the calculator");
	}

	@Test()
	void maxWithNoNumbers() {
		double expectedMax = Double.MIN_VALUE;
		assertEquals(expectedMax, calculator.max(), "Expected max:" + expectedMax + " but got: " + calculator.max());
	}

	@Test()
	void maxWithNumbers() {
		double expectedMax = 2.0;
		Vector<Double> state = new Vector<Double>();
		state.add(expectedMax);
		calculator = new Calculator(state);		
		assertEquals(expectedMax, calculator.max(), "Expected max:" + expectedMax + "but got: " + calculator.max());
	}

	@Test()
	void minWithNoNumbers() {
		double expectedMin = Double.MAX_VALUE;
		assertEquals(expectedMin, calculator.min(), "Expected min:" + expectedMin + "but got: " + calculator.min());
	}

	@Test()
	void minWithNumbers() {
		double expectedMin = 2.0;
		Vector<Double> state = new Vector<Double>();
		state.add(expectedMin);
		calculator = new Calculator(state);
		assertEquals(expectedMin, calculator.min(), "Expected min:" + expectedMin + "but got: " + calculator.min());
	}

	@Test()
	void averageWithNoNumbers() {
		Double expectedAverage = Double.NaN;
		assertEquals(expectedAverage, calculator.average(), "Expected average:" + expectedAverage + "but got: " + calculator.average());
	}

	@Test()
	void averageWithNumbers() {
		double expectedAverage = 5.0;
		Vector<Double> state = new Vector<Double>();
		state.add(2.0);
		state.add(8.0);
		calculator = new Calculator(state);
		assertEquals(expectedAverage, calculator.average(), "Expected average:" + expectedAverage + "but got: " + calculator.average());
	}

	@Test()
	void stddevWithNoNumbers() {
		Double expectedStddev = -0.0;
		assertEquals(expectedStddev, calculator.stddev(), "Expected stddev:" + expectedStddev + "but got: " + calculator.stddev());
	}

	@Test()
	void stddevWithNumbers() {
		double expectedStddev = 0.0;
		Vector<Double> state = new Vector<Double>();
		state.add(2.0);
		state.add(2.0);
		calculator = new Calculator(state);
		assertEquals(expectedStddev, calculator.stddev(), "Expected stddev:" + expectedStddev + "but got: " + calculator.stddev());
	}
}
