package pt.upt.ei.lp.clientFX;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.upt.ei.lp.serverClasses.Reader;

public class Model {

	private IntegerProperty rIdP;
	private StringProperty rNameP;
	private StringProperty rPhoneP;
	ObservableList<pt.upt.ei.lp.serverClasses.Reader> allReadersList;
	ObservableList<pt.upt.ei.lp.serverClasses.Book> rBooksList;

	
	public Model() {
		rIdP = new SimpleIntegerProperty();
		rNameP = new SimpleStringProperty();
		rPhoneP = new SimpleStringProperty();
		allReadersList = FXCollections.observableArrayList();
		rBooksList = FXCollections.observableArrayList();

	}

	public IntegerProperty getRIdP() {
		return rIdP;
	}

	public StringProperty getRNameP() {
		return rNameP;
	}

	public StringProperty getRPhoneP() {
		return rPhoneP;
	}

	public ObservableList<Reader> getAllReadersList() {
		return allReadersList;
	}

	public ObservableList<pt.upt.ei.lp.serverClasses.Book> getRBooksList() {
		return rBooksList;
	}
}

