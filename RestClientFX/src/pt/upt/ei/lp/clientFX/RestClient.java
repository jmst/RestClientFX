package pt.upt.ei.lp.clientFX;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pt.upt.ei.lp.serverClasses.Book;
import pt.upt.ei.lp.serverClasses.Model;
import pt.upt.ei.lp.serverClasses.Reader;

// class RestClient is responsible for accessing the Server
public class RestClient implements DataClient {
	private static final int HTTPCLIENT_TIMEOUT = 30000;
	private static final String Server_ADDRESS = "http://localhost:8080/RestServer/";
	private static final int STATUSCODE_OK = 200; 

	public RestClient() {
	}

	public void getAllReaders(Model model) {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(Server_ADDRESS + "readers"))
			.build();
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			if (response.statusCode() == 200) {
				String body = response.body();
				if (body != null) {
					Reader[] sl = new Gson().fromJson(body, Reader[].class);
					model.getAllReadersList().clear();
					model.getAllReadersList().addAll(sl);
//					System.out.println("List: "+model.getAllReadersList().toString());
				}
			}
		} catch (IOException | InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public void consultReader(Model model, int number) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(Server_ADDRESS + "reader/" + number))
			.build();
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			if (response.statusCode() == 200) {
				String body = response.body();
				if (body != null) {
					Reader r = new Gson().fromJson(body, Reader.class);
					model.setRId(""+r.getId());
					model.setRName(r.getName());
					model.setRPhone(r.getPhone());
					model.getRBooksList().clear();
					model.getRBooksList().addAll(r.getBooks());
				}
			}
		} catch (IOException | InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public void saveReader(Model model) {
		HttpClient client = HttpClient.newHttpClient();
		Reader r = new Reader();
		r.setId(Integer.parseInt(model.getRId()));
		r.setName(model.getRName());
		r.setPhone(model.getRPhone());
		r.getBooks().addAll(model.getRBooksList());
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		String json = gson.toJson(r);
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(Server_ADDRESS + "reader/" + model.getRId()))
			.POST(BodyPublishers.ofString( json))
			.build();
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			if (response.statusCode() == 200) {
				String body = response.body();
				if (body != null) {
				}
			}
		} catch (IOException | InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public void deleteReader(Model model) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(Server_ADDRESS + "reader/" + model.getRId()))
			.DELETE()
			.build();
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			if (response.statusCode() == 200) {
				String body = response.body();
				if (body != null) {
				}
			}
		} catch (IOException | InterruptedException ex) {
			ex.printStackTrace();
		}
	}


	public void getAllBooks(Model model) {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(Server_ADDRESS + "books"))
			.build();
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			if (response.statusCode() == 200) {
				String body = response.body();
				if (body != null) {
					Book[] sl = new Gson().fromJson(body, Book[].class);
					model.getAllBooksList().clear();
					model.getAllBooksList().addAll(sl);
//					System.out.println("List: "+model.getAllBooksList().toString());
				}
			}
		} catch (IOException | InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public void saveBook(Model model) {
		HttpClient client = HttpClient.newHttpClient();
		Book b = new Book();
		b.setId(Integer.parseInt(model.getBId()));
		b.setTitle(model.getBTitle());
		b.setAuthor(model.getBAuthor());
		b.setAvailable(model.getBAvailable());
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		String json = gson.toJson(b);
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(Server_ADDRESS + "book/" + model.getBId()))
			.POST(BodyPublishers.ofString( json))
			.build();
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			if (response.statusCode() == STATUSCODE_OK) {
				String body = response.body();
				if (body != null) {
				}
			}
		} catch (IOException | InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
