import demo.exceptions.BuildException;
import demo.model.core.services.BookDTO;
import demo.model.core.services.BookMapper;
import demo.model.core.services.ClientDTO;
import demo.model.core.services.ClientMapper;
import demo.model.persons.Client;
import demo.model.products.Book;

public class DTOFunctionalsTest {
    public static void main(String[] args) {
        try {
            Client c = Client.getInstantClient(
                    "83360554K",
                    "David",
                    "David@gmail.com",
                    "Carrer del Español",
                    654379103,
                    "9403759105739184",
                    "08850",
                    "Gava");
            System.out.println(c.toString());

            ClientDTO cdto = ClientMapper.dtoFromClient(c);
            System.out.println("ID Cliente: " + cdto.getNif());

            Client ccopy = ClientMapper.clientFromDTO(cdto);
            System.out.println(ccopy.toString());
        } catch (BuildException ex) {
            System.out.println("Error al crear un objeto Client: " + ex.getMessage());
        }

        try {
            Book b = Book.getInstanceBook(
                    10.00,
                    "No the Book",
                    "Este libro es no es libro libreto",
                    "El librero",
                    "Español",
                    30,
                    "978-8-42-724842-7",
                    "2020-12-01 20:20:40",
                    "2020-12-01",
                    20,
                    20,
                    20.30,
                    20.30,
                    2.30,
                    "yes");
            System.out.println(b.toString());

            BookDTO cdto = BookMapper.dtoFromBook(b);
            System.out.println("ID Cliente: " + cdto.getISBN());

            Book ccopy = BookMapper.bookFromDTO(cdto);
            System.out.println(ccopy.toString());


        } catch (BuildException ex) {
            System.out.println("Error al crear un objeto Book: " + ex.getMessage());
        }

    }
}
