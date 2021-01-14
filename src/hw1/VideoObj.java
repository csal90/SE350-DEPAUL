package hw1;
// TODO: complete the methods
/**
 * Immutable Data Class for video objects. Comprises a triple: title, year,
 * director.
 *
 * @objecttype Immutable Data Class
 * @objectinvariant Title is non-null, no leading or final spaces, not empty
 *                  string.
 * @objectinvariant Year is greater than 1800, less than 5000.
 * @objectinvariant Director is non-null, no leading or final spaces, not empty
 *                  string.
 */
final class VideoObj implements Comparable<VideoObj> {
	/** @invariant non-null, no leading or final spaces, not empty string */
	private final String _title;
	/** @invariant greater than 1800, less than 5000 */
	private final int _year;
	/** @invariant non-null, no leading or final spaces, not empty string */
	private final String _director;

	/**
	 * Initialize all object attributes. Title and director are "trimmed" to remove
	 * leading and final space.
	 * 
	 * @throws IllegalArgumentException if any object invariant is violated.
	 */
	VideoObj(String title, int year, String director) {
		// TODO
		if ((title == null || title.length() == 0)) {
			throw new IllegalArgumentException();
		}

		if ((director == null || director.length() == 0)) {
			throw new IllegalArgumentException();
		}
		
		if ((title == " ") || (director == " ")) {
			throw new IllegalArgumentException();
		}
		
		title = title.trim();
		director = director.trim();

		if (year <= 1800 || year >= 5000) {
			throw new IllegalArgumentException();
		}
		
		this._title = title;
		this._year = year;
		this._director = director;
	}

	/**
	 * Return the value of the attribute.
	 */
	public String director() {
		// TODO
		return _director;
	}

	/**
	 * Return the value of the attribute.
	 */
	public String title() {
		// TODO
		return _title;
	}

	/**
	 * Return the value of the attribute.
	 */
	public int year() {
		// TODO
		return _year;
	}

	/**
	 * Compare the attributes of this object with those of thatObject.
	 * 
	 * @param thatObject the Object to be compared.
	 * @return deep equality test between this and thatObject.
	 */
	public boolean equals(Object thatObject) {
		// TODO
		if (thatObject == null || !(thatObject instanceof VideoObj)) {
			return false;
		}
		
		VideoObj v = (VideoObj) thatObject;

		if ((this._director == null) ? (v._director != null) : !this._director.equals(v._director)) {
			return false;
		} else if ((this._title == null) ? (v._title != null) : !this._title.equals(v._title)) {
			return false;
		} else if (this._year != v._year) {
			return false;
		}

		return true;
	}

	/**
	 * Return a hash code value for this object using the algorithm from Bloch:
	 * fields are added in the following order: title, year, director.
	 */
	private volatile int hashCode;

	public int hashCode() {
		// TODO
		if (hashCode == 0) {
			int result = 17;
			result = 37 * result + ((_title == null) ? 0 : _title.hashCode());
			result = 37 * result + _year;
			result = 37 * result + ((_director == null) ? 0 : _director.hashCode());
			hashCode = result;
		}
		return hashCode;
	}

	/**
	 * Compares the attributes of this object with those of thatObject, in the
	 * following order: title, year, director.
	 * 
	 * @param that the VideoObj to be compared.
	 * @return a negative integer, zero, or a positive integer as this object is
	 *         less than, equal to, or greater than that object.
	 *         
	 */
	public int compareTo(VideoObj that) {
		// TODO
		int titleCompare = _title.compareTo(that.title());
		if (titleCompare != 0) {
			return titleCompare;
		}
		
		int yearCompare = Integer.compare (_year, that.year());
		if (yearCompare != 0) {
			return yearCompare;
		}
		
		int directorCompare = _director.compareTo(that.director());
		if (directorCompare != 0) {
			return directorCompare;
		}
		
		return 0;
	}

	/**
	 * Return a string representation of the object in the following format:
	 * <code>"title (year) : director"</code>.
	 */
	public String toString() {
		// TODO
		String format = String.format("%s (%d) : %s", title(), year(), director());
		return format;
	}

}
