package hw2;

import junit.framework.Assert;
import junit.framework.TestCase;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.HashSet;

public class AssertExp1TEST extends TestCase {
	AssertExp1 tester = new AssertExp1();

	public void testminValue() {
		assertEquals(-7.0, AssertExp1.minValue(new double[] { -7 }));
		assertEquals(-7.0, AssertExp1.minValue(new double[] { 1, -4, -7, 7, 8, 11 }));
		assertEquals(-13.0, AssertExp1.minValue(new double[] { -13, -4, -7, 7, 8, 11 }));
		assertEquals(-9.0, AssertExp1.minValue(new double[] { 1, -4, -7, 7, 8, 11, -9 }));
	}

	public void testminPosition() {
		assertEquals(0, AssertExp1.minPosition(new double[] { -7 }));
		assertEquals(2, AssertExp1.minPosition(new double[] { 1, -4, -7, 7, 8, 11 }));
		assertEquals(0, AssertExp1.minPosition(new double[] { -13, -4, -7, 7, 8, 11 }));
		assertEquals(6, AssertExp1.minPosition(new double[] { 1, -4, -7, 7, 8, 11, -9 }));
	}

	public void testnumUnique() {
		assertEquals(0, AssertExp1.numUnique(new double[] {}));
		assertEquals(1, AssertExp1.numUnique(new double[] { 11 }));
		assertEquals(1, AssertExp1.numUnique(new double[] { 11, 11, 11, 11 }));
		assertEquals(8, AssertExp1
				.numUnique(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 }));
		assertEquals(8, AssertExp1.numUnique(new double[] { 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88 }));
	}

	public void testremoveDuplicates() {
		assertArrayEquals(new double[] {}, AssertExp1.removeDuplicates(new double[] {}));
		assertArrayEquals(new double[] { 11 }, AssertExp1.removeDuplicates(new double[] { 11, 11, 11, 11 }));
		assertArrayEquals(new double[] { 11, 22, 33, 44, 55, 66, 77, 88 }, AssertExp1
				.removeDuplicates(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 }));

	}
}
