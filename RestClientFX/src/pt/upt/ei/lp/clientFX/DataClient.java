package pt.upt.ei.lp.clientFX;

import pt.upt.ei.lp.serverClasses.Model;

public interface DataClient {
	public void getAllReaders(Model model);
	public void consultReader(Model model, int number);
	public void saveReader(Model model);
	public void deleteReader(Model model);
	public void getAllBooks(Model model);
	public void saveBook(Model model);
	
}
