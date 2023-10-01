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
	void initCalculator() {
		Double numberToAddAndRemove = 2.0;
		Vector<Double> expected_state = new Vector<Double>();
		expected_state.add(numberToAddAndRemove);
		expected_state.add(numberToAddAndRemove);
		assertEquals(expected_state, calculator.numbers, "Checking the numbers from a freshly init Calculator class");
	}

	@Test()
	void add() {
		Double numberToAddAndRemove = 2.0;
		Vector<Double> expected_state = new Vector<Double>();
		expected_state.add(numberToAddAndRemove);
		expected_state.add(numberToAddAndRemove);
		expected_state.add(numberToAddAndRemove);
		calculator.add(numberToAddAndRemove);
		assertEquals(expected_state, calculator.numbers);
	}

	@Test()
	void remove() {
		Double numberRemove = 2.0;
		Vector<Double> expected_state = new Vector<Double>();
		expected_state.add(numberRemove);
		calculator.remove(numberRemove);
		assertEquals(expected_state, calculator.numbers, "Expected:" + expected_state + " got:" + calculator.numbers);
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			calculator.remove(-1.0);
		}, "Checking the removal for a non existing number from the calculator");
	}

	@Test()
	void max() {
		Double expectedMax = 2.0;
		assertEquals(expectedMax, calculator.max(), "Expected:" + expectedMax + " got:" + calculator.max());
		expectedMax = Double.MIN_VALUE;
		setNewCalculator();
		assertEquals(expectedMax, calculator.max(), "Expected:" + expectedMax + " got:" + calculator.max());
	}

	@Test()
	void min() {
		Double expectedMin = 2.0;
		assertEquals(expectedMin, calculator.min(), "Expected:" + expectedMin + " got:" + calculator.min());
		expectedMin = Double.MAX_VALUE;
		setNewCalculator();
		assertEquals(expectedMin, calculator.min(), "Expected:" + expectedMin + " got:" + calculator.min());
	}

	@Test()
	void average() {
		Double expectedAverage = 2.0;
		assertEquals(expectedAverage, calculator.average(),
				"Expected:" + expectedAverage + " got:" + calculator.average());
		expectedAverage = Double.NaN;
		setNewCalculator();
		assertEquals(expectedAverage, calculator.average(),
				"Expected:" + expectedAverage + " got:" + calculator.average());
	}

	@Test()
	void stddev() {
		Double expectedStddev = 0.0;
		assertEquals(expectedStddev, calculator.stddev(),
				"Expected:" + expectedStddev + " got:" + calculator.stddev());
		expectedStddev = -0.0;
		setNewCalculator();
		assertEquals(expectedStddev, calculator.stddev(),
				"Expected:" + expectedStddev + " got:" + calculator.stddev());
	}

	private void setNewCalculator() {
		calculator = new Calculator();
	}
}
