package pt.upt.ei.lp.serverClasses;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {

	private StringProperty rIdProperty;
	private StringProperty rNameProperty;
	private StringProperty rPhoneProperty;
	ObservableList<pt.upt.ei.lp.serverClasses.Reader> allReadersList;
	ObservableList<pt.upt.ei.lp.serverClasses.Book> rBooksList;

	private StringProperty bIdProperty;
	private StringProperty bTitleProperty;
	private StringProperty bAuthorProperty;
	private BooleanProperty bAvailableProperty;
	ObservableList<pt.upt.ei.lp.serverClasses.Book> allBooksList;

	private Book rBookListSelected;
	
	public Model() {
		rIdProperty = new SimpleStringProperty();
		rIdProperty.set("0");
		rNameProperty = new SimpleStringProperty();
		rPhoneProperty = new SimpleStringProperty();
		allReadersList = FXCollections.observableArrayList();
		rBooksList = FXCollections.observableArrayList();

		bIdProperty = new SimpleStringProperty();
		bIdProperty.set("0");
		bTitleProperty = new SimpleStringProperty();
		bAuthorProperty = new SimpleStringProperty();
		bAvailableProperty = new SimpleBooleanProperty();
		bAvailableProperty.set( false);
		allBooksList = FXCollections.observableArrayList();

	}

	public StringProperty getRIdProperty() {
		return rIdProperty;
	}
	
	public String getRId() {
		return rIdProperty.get();
	}
	
	public void setRId( String newValue) {
		rIdProperty.setValue(newValue);
	}

	public StringProperty getRNameProperty() {
		return rNameProperty;
	}
	
	public String getRName() {
		return rNameProperty.get();
	}
	
	public void setRName( String newValue) {
		rNameProperty.setValue(newValue);
	}

	public StringProperty getRPhoneProperty() {
		return rPhoneProperty;
	}
	
	public String getRPhone() {
		return rPhoneProperty.get();
	}
	
	public void setRPhone( String newValue) {
		rPhoneProperty.setValue(newValue);
	}

	public ObservableList<Reader> getAllReadersList() {
		return allReadersList;
	}

	public Book getRBookListSelected() {
		return rBookListSelected;
	}
	
	public void setRBookListSelected(Book rBookListSelected) {
		this.rBookListSelected = rBookListSelected;
	}

	public ObservableList<pt.upt.ei.lp.serverClasses.Book> getRBooksList() {
		return rBooksList;
	}

	public StringProperty getBIdProperty() {
		return bIdProperty;
	}
	
	public String getBId() {
		return bIdProperty.get();
	}

	public StringProperty getBTitleProperty() {
		return bTitleProperty;
	}
	
	public String getBTitle() {
		return bTitleProperty.get();
	}

	public StringProperty getBAuthorProperty() {
		return bAuthorProperty;
	}
	
	public String getBAuthor() {
		return bAuthorProperty.get();
	}

	public BooleanProperty getBAvailableProperty() {
		return bAvailableProperty;
	}
	
	public boolean getBAvailable() {
		return bAvailableProperty.get();
	}

	public ObservableList<pt.upt.ei.lp.serverClasses.Book> getAllBooksList() {
		return allBooksList;
	}

	public void setAllBooksList(ObservableList<pt.upt.ei.lp.serverClasses.Book> allBooksList) {
		this.allBooksList = allBooksList;
	}
	
	
}

