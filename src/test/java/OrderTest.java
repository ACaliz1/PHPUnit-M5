
import demo.exceptions.BuildException;
import demo.model.order.Order;


public class OrderTest {

    public static void main(String[] args) {
        try{
        Order o = Order.getInsanceOrder( "94017591749", "Calle de Mejor", "David Espinosa", 
        "Amazon", "849184759", "aaaaaaaaa", null,
        null, "Info");

        System.out.println(o.toString());
        } catch (BuildException e) {
            System.out.println("Error al crear un objeto Order: " + e.getMessage());
        }

        try {
            Order o = Order.getInsanceOrder( "94017591749", "Calle de Mejor", "David Espinosa", 
            "Amazon", "849184759", "aaaaaaaaa", "2020-11-01 20:20:40",
            "2020-11-01 20:20:40", "Ninfoninfo",  20,20.30,20.30,2.30,
            "yes", "i:978-8-40-829707-9,q:3,p:20.2,d:0.25;i:978-8-46-797142-2,q:2,p:22.95,d:0.0;", 
            "COMPLETED", "CreditCard", "2020-11-01 20:20:40", "2020-12-01 20:20:40");

            System.out.println(o.toString());
        } catch (Exception e) {
            System.out.println("Error al crear un objeto Order: " + e.getMessage());
        }
        

     
    }
}



