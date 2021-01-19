package hw2;

import org.junit.Assert;

import junit.framework.TestCase;

public class MyLinkedTEST extends TestCase {
	public static void testDelete() {
		MyLinked b = new MyLinked();
		b.add(1);
		Assert.assertEquals(1, b.size());
		b.delete(0);
		Assert.assertEquals(0, b.size());
		for (double i = 1; i < 13; i++) {
			b.add(i);
		}
		Assert.assertEquals(12, b.size());
		b.delete(0);
		Assert.assertEquals(11, b.size());
		b.delete(10);
		Assert.assertEquals(10, b.size());
		b.delete(4);
		Assert.assertEquals(9, b.size());
	}

	public static void testReverse() {
		MyLinked b = new MyLinked();
		b.reverse();
		assertTrue(b.isEmpty());

		b.add(1);
		assertTrue(b.size() == 1);

		b.reverse();
		assertTrue(b.size() == 1);

		b.add(2);
		assertTrue(b.size() == 2);

		b.reverse();
		assertTrue(b.size() == 2);

		b.reverse();
		assertTrue(b.size() == 2);

		for (double i = 3; i < 7; i++) {
			b.add(i);
			b.add(i);
		}

		assertTrue(b.size() == 10);
		b.reverse();

		assertTrue(b.size() == 10);
	}

	public void testRemove() {
		MyLinked b = new MyLinked();
		b.remove(4);
		assertTrue(b.isEmpty());

		b.add(1);
		b.remove(4);

		assertTrue(b.size() == 1);
		b.remove(1);

		assertTrue(b.size() == 0);
		for (double i = 1; i < 5; i++) {
			b.add(i);
			b.add(i);
		}

		for (double i = 1; i < 5; i++) {
			b.add(i);
			b.add(i);
			b.add(i);
			b.add(i);
			b.add(i);
		}

		assertTrue(b.size() == 28);
		b.remove(9);

		assertTrue(b.size() == 28);// size wont change
		b.remove(3);

		assertTrue(b.size() == 21);
		b.remove(1);

		assertTrue(b.size() == 14);
		b.remove(4);

		assertTrue(b.size() == 7);
		b.remove(2);

		assertTrue(b.isEmpty());
	}
}
