package pt.upt.ei.lp.clientFX;

import javafx.event.ActionEvent;
import pt.upt.ei.lp.serverClasses.Book;
import pt.upt.ei.lp.serverClasses.Model;
import pt.upt.ei.lp.serverClasses.Reader;

public class Controller {
	Model model;
	// RestClient restClient;
	DataClient restClient;

	// public Controller(Model model, RestClient restClient) {
	public Controller(Model model, DataClient restClient) {
		this.model = model;
		this.restClient = restClient;
	}

	public void getAllReaders() {
		restClient.getAllReaders(model);
	}

	public void getAllBooks() {
		restClient.getAllBooks(model);
	}

	public void readersListSelected(Reader newValue) {
		if (newValue == null)
			return;
		model.setRId("" + newValue.getId());
		model.setRName(newValue.getName());
		model.setRPhone("" + newValue.getPhone());
		restClient.consultReader(model, newValue.getId());
	};

	public void rBooksListSelected(Book newValue) {
		if (newValue == null)
			return;
		model.setRBookListSelected(newValue);
	};

	public void booksListSelected(Book newValue) {
		if (newValue == null)
			return;
		model.getBIdProperty().set("" + newValue.getId());
		model.getBTitleProperty().set(newValue.getTitle());
		model.getBAuthorProperty().set("" + newValue.getAuthor());
		model.getBAvailableProperty().set(newValue.isAvailable());
	};

	public void bNewReaderClick(ActionEvent e) {
		model.getRIdProperty().set("0");
		model.getRNameProperty().set("");
		model.getRPhoneProperty().set("");
		model.getRBooksList().clear();
	}

	public void bSaveReaderClick(ActionEvent e) {
		restClient.saveReader(model);
		restClient.getAllReaders(model);
	}

	public void bDelReaderClick(ActionEvent e) {
		restClient.deleteReader(model);
		restClient.getAllReaders(model);
	}

	public void bAddRBookClick(ActionEvent e) {
		Book book = new Book();
		book.setId(Integer.parseInt(model.getBId()));
		book.setTitle(model.getBTitle());
		book.setAuthor(model.getBAuthor());
		book.setAvailable(model.getBAvailable());
		System.out.println("antes: " + model.getRBooksList().size());
		model.getRBooksList().add(book);
		System.out.println("depois: " + model.getRBooksList().size());
	}

	public void bDelRBookClick(ActionEvent e) {
		Book book = new Book();
		book.setId(Integer.parseInt(model.getBId()));
		book.setTitle(model.getBTitle());
		book.setAuthor(model.getBAuthor());
		if (model.getRBooksList().contains(model.getRBookListSelected())) {
			model.getRBooksList().remove(model.getRBookListSelected());
			model.setRBookListSelected(null);
			System.out.println("Book removed");
		} else {
			System.out.println("Book not found");
		}
		;
	}

	public void bNewBookClick(ActionEvent e) {
		model.getBIdProperty().set("0");
		model.getBTitleProperty().set("");
		model.getBAuthorProperty().set("");
		model.getBAvailableProperty().set(false);
	}

	public void bSaveBookClick(ActionEvent e) {
		restClient.saveBook(model);
		restClient.getAllBooks(model);
	}

	public void readData() {
		getAllReaders();
		getAllBooks();
	}
}
