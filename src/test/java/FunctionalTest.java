import demo.exceptions.BuildException;
import demo.model.persons.Client;
import demo.model.products.Book;

public class FunctionalTest {
    public static void main(String[] args) {
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

            Client a = Client.getInstantClient(
                    "83360554K",
                    "David",
                    "David@gmail.com",
                    "Carrer del Español",
                    654379103,
                    "9403759105739184",
                    "08850",
                    "Gava");

            System.out.println(b.toString());
            System.out.println(a.toString());

            System.out.println(a.getContact());
            System.out.println(b.getDetails());


        } catch (BuildException ex) {
            System.out.println("Error al crear un objeto Client: " + ex.getMessage());
        }
    }
}
