package pt.upt.ei.lp.clientFX;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pt.upt.ei.lp.serverClasses.Book;
import pt.upt.ei.lp.serverClasses.Model;
import pt.upt.ei.lp.serverClasses.Reader;

public class MainWindow extends Application {
	Model model;
	Controller controller;
//	RestClient restClient;
	DataClient restClient;

	@Override
	public void start(Stage primaryStage) {
		model = new Model();
		restClient = new RestClient();
//		restClient = new LocalClient();
		controller = new Controller(model, restClient);
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Scene scene = new Scene(grid, 1200, 750);
		primaryStage.setScene(scene);
		
		Text scenetitle = new Text("Library");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 1, 1, 1);

		ListView<Reader> readersList = new ListView<>();
		readersList.setItems(model.getAllReadersList());
		grid.add(readersList, 0, 2, 3, 5);
		readersList.getSelectionModel().selectedItemProperty()
			.addListener((ObservableValue<? extends Reader> oValue, Reader oldValue, Reader newValue) -> {
				controller.readersListSelected(newValue);
			});
		readersList.getSelectionModel().selectedItemProperty()
			.addListener((oValue, oldValue, newValue) -> {
				controller.readersListSelected(newValue);
		});

		GridPane gridReader = new GridPane();
		gridReader.setAlignment(Pos.CENTER);
		gridReader.setHgap(10);
		gridReader.setVgap(10);
		gridReader.setPadding(new Insets(25, 25, 25, 25));
		grid.add(gridReader, 0, 7, 2, 5);

		Label rId = new Label("Reader id:");
		gridReader.add(rId, 0, 0);
		TextField rIdTf = new TextField();
		rIdTf.setDisable(true);
		gridReader.add(rIdTf, 1, 0);
		rIdTf.textProperty().bindBidirectional(model.getRIdProperty());

		Label rName = new Label("Reader name:");
		gridReader.add(rName, 0, 1);
		TextField rNameTf = new TextField();
		rNameTf.setPrefWidth(200);
		gridReader.add(rNameTf, 1, 1);
		rNameTf.textProperty().bindBidirectional(model.getRNameProperty());

		Label rPhone = new Label("Reader phone:");
		gridReader.add(rPhone, 0, 2);
		TextField rPhoneTf = new TextField();
		rNameTf.setPrefWidth(150);
		gridReader.add(rPhoneTf, 1, 2);
		rPhoneTf.textProperty().bindBidirectional(model.getRPhoneProperty());

		ListView<Book> rBooksList = new ListView<>();
		rBooksList.setItems(model.getRBooksList());
		gridReader.add(rBooksList, 0, 3, 4, 3);
		rBooksList.getSelectionModel().selectedItemProperty()
		.addListener((oValue, oldValue, newValue) -> {
			controller.rBooksListSelected(newValue);
		});
		HBox bReader = new HBox(10);
		bReader.setAlignment(Pos.BOTTOM_RIGHT);
		gridReader.add(bReader, 0, 6);
		Button bNewReader = new Button("  NEW  ");
		bReader.getChildren().add(bNewReader);
		bNewReader.setOnAction(e -> {
			controller.bNewReaderClick(e);
		});
		Button bSaveReader = new Button("  SAVE  ");
		bReader.getChildren().add(bSaveReader);
		bSaveReader.setOnAction(e -> {
			controller.bSaveReaderClick(e);
		});
		Button bDelReader = new Button(" DELETE ");
		bReader.getChildren().add(bDelReader);
		bDelReader.setOnAction(e -> {
			controller.bDelReaderClick(e);
		});


		ListView<Book> booksList = new ListView<>();
		booksList.setItems(model.getAllBooksList());
		grid.add(booksList, 4, 2, 3, 5);
		booksList.getSelectionModel().selectedItemProperty()
			.addListener((oValue, oldValue, newValue) -> {
				controller.booksListSelected(newValue);
			});

		GridPane gridBook = new GridPane();
		gridBook.setAlignment(Pos.CENTER);
		gridBook.setHgap(10);
		gridBook.setVgap(10);
		gridBook.setPadding(new Insets(25, 25, 25, 25));
		grid.add(gridBook, 4, 7, 2, 5);

		Label bId = new Label("Book id:");
		gridBook.add(bId, 0, 0);
		TextField bIdTf = new TextField();
		gridBook.add(bIdTf, 1, 0);
		bIdTf.setDisable(true);
		bIdTf.textProperty().bindBidirectional(model.getBIdProperty());

		Label bTitle = new Label("Book title:");
		gridBook.add(bTitle, 0, 1);
		TextField bTitleTf = new TextField();
		bTitleTf.setPrefWidth(250);
		gridBook.add(bTitleTf, 1, 1);
		bTitleTf.textProperty().bindBidirectional(model.getBTitleProperty());

		Label bAuthor = new Label("Book author:");
		gridBook.add(bAuthor, 0, 2);
		TextField bAuthorTf = new TextField();
		bAuthorTf.setPrefWidth(250);
		gridBook.add(bAuthorTf, 1, 2);
		bAuthorTf.textProperty().bindBidirectional(model.getBAuthorProperty());

		Label bAvail = new Label("Available:");
		gridBook.add(bAvail, 0, 3);
		CheckBox bAvailCB = new CheckBox();
		gridBook.add(bAvailCB, 1, 3);
		bAvailCB.selectedProperty().bindBidirectional(model.getBAvailableProperty());

		VBox bBooks = new VBox(10);
		bBooks.setAlignment(Pos.TOP_LEFT);
		gridBook.add(bBooks, 0, 4);
		Button bAddBook = new Button("  <<  ");
		bBooks.getChildren().add(bAddBook);
		bAddBook.setOnAction(e -> {
			controller.bAddRBookClick(e);
		});
		Button bDelBook = new Button("  >>  ");
		bBooks.getChildren().add(bDelBook);
		bDelBook.setOnAction(e -> {
			controller.bDelRBookClick(e);
		});
		HBox bBook = new HBox(10);
		bBook.setAlignment(Pos.BOTTOM_RIGHT);
		gridBook.add(bBook, 1, 4);
		Button bNewBook = new Button("  NEW  ");
		bBook.getChildren().add(bNewBook);
		bNewBook.setOnAction(e -> {
			controller.bNewBookClick(e);
		});
		Button bSaveBook = new Button("  SAVE  ");
		bBook.getChildren().add(bSaveBook);
		bSaveBook.setOnAction(e -> {
			controller.bSaveBookClick(e);
		});

		controller.readData();
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
