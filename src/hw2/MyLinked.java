package hw2;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyLinked {
	static class Node {
		public Node() {
		}

		public double item;
		public Node next;
	}

	int N;
	Node first;

	public MyLinked() {
		first = null;
		N = 0;
		assert checkInvariants();
	}

	private boolean checkInvariants() {
		assert ((N != 0) || (first == null));
		Node x = first;
		for (int i = 0; i < N; i++) {
			if (x == null) {
				return false;
			}
			x = x.next;
		}
		assert (x == null);
		return true;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void add(double item) {
		Node newfirst = new Node();
		newfirst.item = item;
		newfirst.next = first;
		first = newfirst;
		N++;
	}

	// delete the kth element
	public void delete(int k) {
		if (k < 0 || k >= N)
			throw new IllegalArgumentException();

		if (first == null) { // check if it is null
			return;
		}

		Node curr = first;
		Node prev = null, next = null;
		int index = 0;
		while (curr != null && index < k) {
			index++;
			prev = curr;
			curr = curr.next;
		}

		if (prev == null & curr != null) {
			first = first.next;
			N = N - 1;
		} else {
			prev.next = curr.next;
			N = N - 1;

		}

		assert checkInvariants();
	}

	// reverse the list "in place"... without creating any new nodes
	public void reverse() {
		if (first == null)
			return;
		Node f = first;
		Node prev = null;
		Node cur = f;
		Node nxt = null;
		while (cur != null) {
			nxt = cur.next;
			cur.next = prev;
			prev = cur;
			cur = nxt;
		}
		f = prev;
		first = f;
		assert checkInvariants();
	}

	// remove
	public void remove(double item) {
		if (N == 0) {
			return;
		}

		Node prev = first;
		Node cur = first.next;

		while (cur != null) {
			if (cur.item == item) {
				prev.next = cur.next;
				N--;
			} else {
				prev = cur;
			}
			cur = cur.next;
		}
		if (first.item == item) {
			N--;
			first = first.next;
		}
		assert checkInvariants();
	}

	// TODO: CONVERT THE FOLLOWING TO JUNIT TESTS

//	private static void testDelete() {
//		MyLinked b = new MyLinked();
//		b.add(1);
//		print("singleton", b);
//		b.delete(0);
//		print("deleted", b);
//		for (double i = 1; i < 13; i++) {
//			b.add(i);
//		}
//		print("bigger list", b);
//		b.delete(0);
//		print("deleted at beginning", b);
//		b.delete(10);
//		print("deleted at end", b);
//		b.delete(4);
//		print("deleted in middle", b);
//	}
//
//	private static void testReverse() {
//		MyLinked b = new MyLinked();
//		b.reverse();
//		print("reverse empty", b);
//		b.add(1);
//		print("singleton", b);
//		b.reverse();
//		print("reverse singleton", b);
//		b.add(2);
//		print("two", b);
//		b.reverse();
//		print("reverse two", b);
//		b.reverse();
//		print("reverse again", b);
//		for (double i = 3; i < 7; i++) {
//			b.add(i);
//			b.add(i);
//		}
//		print("bigger list", b);
//		b.reverse();
//		print("reversed", b);
//	}
//
//	private static void testRemove() {
//		MyLinked b = new MyLinked();
//		b.remove(4);
//		print("removed 4 from empty", b);
//		b.add(1);
//		b.remove(4);
//		print("removed 4 from singelton", b);
//		b.remove(1);
//		print("removed 1 from singelton", b);
//		for (double i = 1; i < 5; i++) {
//			b.add(i);
//			b.add(i);
//		}
//		for (double i = 1; i < 5; i++) {
//			b.add(i);
//			b.add(i);
//			b.add(i);
//			b.add(i);
//			b.add(i);
//		}
//		print("longer list", b);
//		b.remove(9);
//		print("removed all 9s", b); // does nothing
//		b.remove(3);
//		print("removed all 3s", b);
//		b.remove(1);
//		print("removed all 1s", b);
//		b.remove(4);
//		print("removed all 4s", b);
//		b.remove(2);
//		print("removed all 2s", b); // should be empty
//	}

}
