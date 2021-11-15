package pt.upt.ei.lp.serverClasses;

import java.util.ArrayList;
import java.util.List;

public class Reader {
	private int id;
	private String phone;
	private String name;

	private List<Book> books = new ArrayList<Book>();

	public Reader() {
		id = 0;
		name = "";
		phone = "";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public String getNameMinus() {
		return name.toLowerCase();
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}
	
	public String toString() {
		String st = name + "  (id=" + id + "  phone=" + phone + ")";
		return st;
	}

	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!( o instanceof Reader)) 
			return false;
		Reader or = (Reader) o;
		if (id != or.getId())
			return false;
		if (! name.equals( or.getName()))
			return false;
		if (! phone.equals( or.getPhone()))
			return false;
		return true;
	}

	public int hashCode() {
		int hc = id;
		hc = 31*hc + name.hashCode();
		hc = 31*hc + phone.hashCode();
		return hc;
	}

}
