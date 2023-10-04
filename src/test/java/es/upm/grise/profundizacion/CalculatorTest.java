package es.upm.grise.profundizacion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	private Calculator calculator;
	private Vector<Double> state;

	@BeforeEach
	public void init() {
		state = new Vector<Double>();
		calculator = new Calculator(state);
		state.add(2.0);
		state.add(2.0);
	}

	@Test()
	@DisplayName("Test init the calculator state")
	void initCalculator() {
		Integer expected_size = 0;
		calculator = new Calculator();
		Integer size = calculator.numbers.size();
		assertEquals(expected_size, size, "Checking the numbers from a freshly init Calculator class");
	}

	@Test()
	@DisplayName("Test add 2.0 in the calculator state")
	void addWithNumbers() {
		Integer expected_size = 3;
		calculator.add(2.0);
		Integer size = calculator.numbers.size();
		assertEquals(expected_size, size, "Expected " + expected_size + " but got: " + size);
	}

	@Test()
	@DisplayName("Test remove 2.0 in the calculator state")
	void removeWithNumbers() {
		Integer expected_size = 1;
		calculator.remove(2.0);
		assertEquals(expected_size, calculator.numbers.size(),
				"Expected " + expected_size + " but got: " + calculator.numbers.size());
	}

	@Test()
	@DisplayName("Test remove a number not in the calculator state")
	void removeNonExistingNumberFromState() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			calculator.remove(-1.0);
		}, "Expected throw when no numbers in the calculator");
	}

	@Test()
	@DisplayName("Test remove without numbers in the calculator state")
	void removeWithNoNumbers() {
		calculator = new Calculator();
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			calculator.remove(-1.0);
		}, "Expected throw when no numbers in the calculator");
	}

	@Test
	@DisplayName("Test max without state in the calculator")
	void maxWithNoNumbers() {
		Double expectedMax = Double.MIN_VALUE;
		calculator = new Calculator();
		Double max = calculator.max();
		assertEquals(expectedMax, max, "Expected max:" + expectedMax + " but got: " + max);
	}

	@Test()
	@DisplayName("Test max with 2.0 and 2.0 in the calculator state")
	void maxWithNumbers() {
		Double expectedMax = 2.0;
		Double max = calculator.max();
		assertEquals(expectedMax, max, "Expected max:" + expectedMax + "but got: " + max);
	}

	@Test()
	@DisplayName("Test min without state in the calculator")
	void minWithNoNumbers() {
		Double expectedMin = Double.MAX_VALUE;
		calculator = new Calculator();
		Double min = calculator.min();
		assertEquals(expectedMin, min, "Expected min:" + expectedMin + "but got: " + min);
	}

	@Test()
	@DisplayName("Test min with 2.0 and 2.0 in the calculator state")
	void minWithNumbers() {
		Double expectedMin = 2.0;
		Double min = calculator.min();
		assertEquals(expectedMin, min, "Expected min:" + expectedMin + "but got: " + min);
	}

	@Test()
	@DisplayName("Test average without state in the calculator")
	void averageWithNoNumbers() {
		Double expectedAverage = Double.NaN;
		calculator = new Calculator();
		Double average = calculator.average();
		assertEquals(expectedAverage, average,
				"Expected average:" + expectedAverage + "but got: " + average);
	}

	@Test()
	@DisplayName("Test average with 2.0 and 2.0 in the calculator state")
	void averageWithNumbers() {
		Double expectedAverage = 2.0;
		Double average = calculator.average();
		assertEquals(expectedAverage, average,
				"Expected average:" + expectedAverage + "but got: " + average);
	}

	@Test()
	@DisplayName("Test stddev without state in the calculator")
	void stddevWithNoNumbers() {
		Double expectedStddev = -0.0;
		calculator = new Calculator();
		Double stddev = calculator.stddev();
		assertEquals(expectedStddev, stddev,
				"Expected average:" + expectedStddev + "but got: " + stddev);
	}

	@Test()
	@DisplayName("Test stddev with 2.0 and 2.0 in the calculator state")
	void stddevWithNumbers() {
		Double expectedStddev = 0.0;
		Double stddev = calculator.stddev();
		assertEquals(expectedStddev, stddev,
				"Expected average:" + expectedStddev + "but got: " + stddev);
	}
}
