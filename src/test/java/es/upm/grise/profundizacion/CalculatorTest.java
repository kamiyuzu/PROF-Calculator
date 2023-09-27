package es.upm.grise.profundizacion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void test() {
		Calculator c = new Calculator();
		c.numbers = new Vector <Double>();
		c.add(2.0);
		c.add(4.0);
		c.add(3.0);
		System.out.println(c.max());
		System.out.println(c.min());
		System.out.println(c.average());
		System.out.println(c.stddev());
		c.remove(3.0);
		System.out.println(c.max());
		System.out.println(c.min());
		System.out.println(c.average());
		System.out.println(c.stddev());
	}

}
