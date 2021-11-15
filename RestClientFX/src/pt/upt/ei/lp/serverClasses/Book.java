package pt.upt.ei.lp.serverClasses;

public class Book {
	private int id;
	private String author;
	private String title;
	private boolean available;

	public Book() {
		id = 0;
		title = "";
		author = "";
		available = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String toString() {
		String st = title + "  (id=" + id + "  autor=" + author + "  avail=" + available + ")";
		return st;
	}

	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!(o instanceof Book))
			return false;
		Book ob = (Book) o;
		if (id != ob.getId())
			return false;
		if (!title.equals(ob.getTitle()))
			return false;
		if (!author.equals(ob.getAuthor()))
			return false;
		if (available != ob.available)
			return false;
		return true;
	}

	public int hashCode() {
		int hc = id;
		hc = 31 * hc + (available ? 1 : 0);
		hc = 31 * hc + title.hashCode();
		hc = 31 * hc + author.hashCode();
		return hc;
	}
}
