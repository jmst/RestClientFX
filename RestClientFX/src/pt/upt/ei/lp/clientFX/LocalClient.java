package pt.upt.ei.lp.clientFX;

import java.util.Collection;
import java.util.HashMap;

import pt.upt.ei.lp.serverClasses.Book;
import pt.upt.ei.lp.serverClasses.Model;
import pt.upt.ei.lp.serverClasses.Reader;

// class RestClient is responsible for accessing the Server
public class LocalClient implements DataClient {
	HashMap<Integer, Reader> readerMap;
	HashMap<Integer, Book> bookMap;
	int lastId;

	public LocalClient() {
		readerMap = new HashMap<Integer, Reader>();
		bookMap = new HashMap<Integer, Book>();
		lastId = 0;
		for (Integer k : readerMap.keySet()) {
			if (k > lastId)
				lastId = k;
		}
		for (Integer k : bookMap.keySet()) {
			if (k > lastId)
				lastId = k;
		}
		defineValoresIniciais();
	}

	public void getAllReaders(Model model) {
		Collection<Reader> sl = readerMap.values();
		model.getAllReadersList().clear();
		model.getAllReadersList().addAll(sl);
	}

	public void consultReader(Model model, int number) {
		if (!readerMap.containsKey(number))
			return;
		Reader r = readerMap.get(number);
		model.setRId("" + r.getId());
		model.setRName(r.getName());
		model.setRPhone(r.getPhone());
		model.getRBooksList().clear();
		model.getRBooksList().addAll(r.getBooks());
	}

	public void saveReader(Model model) {
		Reader r = new Reader();
		r.setId(Integer.parseInt(model.getRId()));
		r.setName(model.getRName());
		r.setPhone(model.getRPhone());
		r.getBooks().addAll(model.getRBooksList());
		if (r.getId() <= 0) {
			lastId++;
			r.setId(lastId);
		}
		readerMap.put(r.getId(), r);
	}

	public void deleteReader(Model model) {
		int rid = Integer.parseInt(model.getRId());
		if (rid <= 0)
			return;
		if (!readerMap.containsKey(rid))
			return;
		readerMap.remove(rid);
	}

	public void getAllBooks(Model model) {
		Collection<Book> sl = bookMap.values();
		model.getAllBooksList().clear();
		model.getAllBooksList().addAll(sl);
	}

	public void saveBook(Model model) {
		Book b = new Book();
		b.setId(Integer.parseInt(model.getBId()));
		b.setTitle(model.getBTitle());
		b.setAuthor(model.getBAuthor());
		b.setAvailable(model.getBAvailable());
		if (b.getId() <= 0) {
			lastId++;
			b.setId(lastId);
		}
		bookMap.put(b.getId(), b);
	}

	//
	// cria alguns objetos iniciais
	//
	private void defineValoresIniciais() {
		Reader r = new Reader();
		r.setId(0);
		r.setName("Zezé");
		r.setPhone("123456789");
		if (r.getId() <= 0) {
			lastId++;
			r.setId(lastId);
		}
		readerMap.put(r.getId(), r);
		
		r = new Reader();
		r.setId(0);
		r.setName("Mimi");
		r.setPhone("111111111");
		if (r.getId() <= 0) {
			lastId++;
			r.setId(lastId);
		}
		readerMap.put(r.getId(), r);
		
		r = new Reader();
		r.setId(0);
		r.setName("Lulu");
		r.setPhone("222222222");
		if (r.getId() <= 0) {
			lastId++;
			r.setId(lastId);
		}
		readerMap.put(r.getId(), r);

		Book b = new Book();
		b.setId(0);
		b.setTitle("Lusíadas");
		b.setAuthor("Luís");
		b.setAvailable(true);
		if (b.getId() <= 0) {
			lastId++;
			b.setId(lastId);
		}
		bookMap.put(b.getId(), b);

		b = new Book();
		b.setId(0);
		b.setTitle("Maias");
		b.setAuthor("José Maria");
		b.setAvailable(true);
		if (b.getId() <= 0) {
			lastId++;
			b.setId(lastId);
		}
		bookMap.put(b.getId(), b);

		b = new Book();
		b.setId(0);
		b.setTitle("História");
		b.setAuthor("Alexandre");
		b.setAvailable(true);
		if (b.getId() <= 0) {
			lastId++;
			b.setId(lastId);
		}
		bookMap.put(b.getId(), b);
	}
}
