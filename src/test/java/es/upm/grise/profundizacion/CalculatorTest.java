package es.upm.grise.profundizacion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	private Calculator calculator;
	private Vector<Double> state;
	private Vector<Double> expected_state;

	@BeforeEach
	public void init() {
		state = new Vector<Double>();
		calculator = new Calculator(state);
		state.add(2.0);
		state.add(2.0);
		expected_state = new Vector<Double>();
	}

	@Test()
	@DisplayName("Test init the calculator state")
	void initCalculator() {
		Double numberToAddAndRemove = 2.0;
		expected_state.add(numberToAddAndRemove);
		expected_state.add(numberToAddAndRemove);
		assertEquals(expected_state, calculator.numbers, "Checking the numbers from a freshly init Calculator class");
	}

	@Test()
	@DisplayName("Test add 2.0 in the calculator state")
	void addWithNumbers() {
		Double numberToAddAndRemove = 2.0;
		expected_state.add(numberToAddAndRemove);
		expected_state.add(numberToAddAndRemove);
		expected_state.add(numberToAddAndRemove);
		calculator.add(numberToAddAndRemove);
		assertEquals(expected_state, calculator.numbers, "Expected " + expected_state + " but got: " + calculator.numbers);
	}

	@Test()
	@DisplayName("Test remove 2.0 in the calculator state")
	void removeWithNumbers() {
		Double numberRemove = 2.0;
		expected_state.add(numberRemove);
		calculator.remove(numberRemove);
		assertEquals(expected_state, calculator.numbers, "Expected " + expected_state + " but got: " + calculator.numbers);
	}

	@Test()
	@DisplayName("Test remove without numbers in the calculator state")
	void removeWithNoNumbers() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			calculator.remove(-1.0);
		}, "Expected throw when no numbers in the calculator");
	}

	@Test()
	@DisplayName("Test max without state in the calculator")
	void maxWithNoNumbers() {
		Double expectedMax = Double.MIN_VALUE;
		setNewCalculator();
		assertEquals(expectedMax, calculator.max(), "Expected max:" + expectedMax + " but got: " + calculator.max());
	}

	@Test()
	@DisplayName("Test max with 2.0 and 2.0 in the calculator state")
	void maxWithNumbers() {
		Double expectedMax = 2.0;
		assertEquals(expectedMax, calculator.max(), "Expected max:" + expectedMax + "but got: " + calculator.max());
	}

	@Test()
	@DisplayName("Test min without state in the calculator")
	void minWithNoNumbers() {
		Double expectedMin = Double.MAX_VALUE;
		setNewCalculator();
		assertEquals(expectedMin, calculator.min(), "Expected min:" + expectedMin + "but got: " + calculator.min());
	}

	@Test()
	@DisplayName("Test min with 2.0 and 2.0 in the calculator state")
	void minWithNumbers() {
		Double expectedMin = 2.0;
		assertEquals(expectedMin, calculator.min(), "Expected min:" + expectedMin + "but got: " + calculator.min());
	}

	@Test()
	@DisplayName("Test average without state in the calculator")
	void averageWithNoNumbers() {
		Double expectedAverage = Double.NaN;
		setNewCalculator();
		assertEquals(expectedAverage, calculator.average(), "Expected average:" + expectedAverage + "but got: " + calculator.average());
	}

	@Test()
	@DisplayName("Test average with 2.0 and 2.0 in the calculator state")
	void averageWithNumbers() {
		Double expectedAverage = 2.0;
		assertEquals(expectedAverage, calculator.average(), "Expected average:" + expectedAverage + "but got: " + calculator.average());
	}

	@Test()
	@DisplayName("Test stddev without state in the calculator")
	void stddevWithNoNumbers() {
		Double expectedStddev = -0.0;
		setNewCalculator();
		assertEquals(expectedStddev, calculator.stddev(), "Expected average:" + expectedStddev + "but got: " + calculator.stddev());
	}

	@Test()
	@DisplayName("Test stddev with 2.0 and 2.0 in the calculator state")
	void stddevWithNumbers() {
		Double expectedStddev = 0.0;
		assertEquals(expectedStddev, calculator.stddev(), "Expected average:" + expectedStddev + "but got: " + calculator.stddev());
	}

	private void setNewCalculator(){
		calculator = new Calculator();
	}
}
