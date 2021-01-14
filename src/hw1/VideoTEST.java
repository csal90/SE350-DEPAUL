package hw1;
//TODO: complete the tests
import junit.framework.Assert;
import junit.framework.TestCase;

public class VideoTEST extends TestCase {
	public VideoTEST(String name) {
		super(name);
	}

	public void testConstructorAndAttributes() {
		String title1 = "XX";
		String director1 = "XY";
		String title2 = " XX ";
		String director2 = " XY ";
		int year = 2002;

		VideoObj v1 = new VideoObj(title1, year, director1);
		assertSame(title1, v1.title());
		assertEquals(year, v1.year());
		assertSame(director1, v1.director());

		VideoObj v2 = new VideoObj(title2, year, director2);
		assertEquals(title1, v2.title());
		assertEquals(director1, v2.director());
	}

	public void testConstructorExceptionYear() {
		try {
			new VideoObj("X", 1800, "Y");
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			new VideoObj("X", 5000, "Y");
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			new VideoObj("X", 1801, "Y");
			new VideoObj("X", 4999, "Y");
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	public void testConstructorExceptionTitle() {
		// TODO
		try {
			new VideoObj(null, 2002, "Y");
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			new VideoObj("", 2002, "Y");
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			new VideoObj(" ", 2002, "Y");
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	public void testConstructorExceptionDirector() {
		// TODO
		try {
			new VideoObj("X", 1788, "Y");
			fail();
		} catch (IllegalArgumentException e) { }
		try {
			new VideoObj("X", 6000, "Y");
			fail();
		} catch (IllegalArgumentException e) { }
		try {
			new VideoObj("X", 1804, "Y");
			new VideoObj("X", 4999, "Y");
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	public void testHashCode() {
		// TODO
		assertEquals(-875826552, new VideoObj("None", 2009, "Zebra").hashCode());
		assertEquals(-1391078111, new VideoObj("Blah", 1954, "Cante").hashCode());
	}

	public void testEquals() {
		// TODO
		String title = "A";
		int year = 2009;
		String director = "Zebra";
		VideoObj a = new VideoObj(title, year, director);
		assertTrue(a.equals(a));
		assertTrue(a.equals(new VideoObj(title, year, director)));
		assertTrue(a.equals(new VideoObj(new String(title), year, director)));
		assertTrue(a.equals(new VideoObj(title, year, new String(director))));
		assertFalse(a.equals(new VideoObj(title + "1", year, director)));
		assertFalse(a.equals(new VideoObj(title, year + 1, director)));
		assertFalse(a.equals(new VideoObj(title, year, director + "1")));
		assertFalse(a.equals(new Object()));
		assertFalse(a.equals(null));
	}

	public void testCompareTo() {
		String title = "A", title2 = "B";
		int year = 2009, year2 = 2010;
		String director = "Zebra", director2 = "Zzz";
		VideoObj a = new VideoObj(title, year, director);
		VideoObj b = new VideoObj(title2, year, director);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(a.compareTo(b) == -b.compareTo(a));
		assertTrue(a.compareTo(a) == 0);

		b = new VideoObj(title, year2, director);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(a.compareTo(b) == -b.compareTo(a));

		b = new VideoObj(title, year, director2);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(a.compareTo(b) == -b.compareTo(a));

		b = new VideoObj(title2, year2, director2);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(a.compareTo(b) == -b.compareTo(a));

		// try {
		// a.compareTo(null);
		// fail();
		// } catch ( NullPointerException e ) {}
		// catch ( ClassCastException e ) {}
	}

	public void testToString() {
		String s = new VideoObj("A", 2000, "B").toString();
		assertEquals(s, "A (2000) : B");
		s = new VideoObj(" A ", 2000, " B ").toString();
		assertEquals(s, "A (2000) : B");
	}
}
