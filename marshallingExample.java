package  com.ozymandias.LibraryJaxb;


import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class marshallingExample
{
	static Books books = new Books();
	static 
	{
		books.setBooks(new ArrayList<Book>());
	
		books.getBooks().add(new Book(1,"Gone Girl","Gillian Flynn"));
		books.getBooks().add(new Book(2,"Winds of Winter","George RR Martin"));
		books.getBooks().add(new Book(3,"Legend","Marie Lu"));
	}
	
	public static void main(String[] args) throws JAXBException 
	{
		marshalingExample();
		System.out.println("");
		unMarshalingExample();
	}

	private static void unMarshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Books books = (Books) jaxbUnmarshaller.unmarshal( new File("D:\\Accolite_training\\library.xml") );
		
		for(Book book : books.getBooks())
		{
			System.out.println(book.getISBN());
			System.out.println(book.getBookName()+" by "+book.getAuthorName());
		}
	}

	private static void marshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
//		jaxbMarshaller.marshal(books, System.out);
		jaxbMarshaller.marshal(books, new File("D:\\Accolite_training\\library.xml"));
		System.out.println();
	}
}
