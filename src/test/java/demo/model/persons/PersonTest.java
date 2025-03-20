package demo.model.persons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demo.exceptions.BuildException;

public class PersonTest {
    private Person person;

    @BeforeEach
    void createInstance() {
        try {
            person = new Person("89264975C", "Perico Palotes", "pericoPalotes@gmail.com", "Calle del Sol, 1", 617536475) {
                @Override
                public String getContact() {
                    return "Información del contacto";
                }
            };
        } catch (BuildException e) {
            fail("No se pudo crear la persona en createInstance");
        }
    }

    // Tests para Getters
    @Test
    void testGetDirection_Valid() {
        assertEquals("Calle 123, 456", person.getDirection());
    }

    @Test
    void testGetEmail_Valid() {
        assertEquals("john.doe@example.com", person.getEmail());
    }

    @Test
    void testGetName_Valid() {
        assertEquals("John Doe", person.getName());
    }

    @Test
    void testGetNif_Valid() {
        assertEquals("12345678Z", person.getNif());
    }

    @Test
    void testGetPhoneNumber_Valid() {
        assertEquals(666777889, person.getPhoneNumber());
    }

    // Tests para Setters
    @Test
    void testSetDirection_Valid() {
        assertEquals(0, person.setDirection("Avenida Principal 123"));
    }

    @Test
    void testSetDirection_Short() {
        assertEquals(-2, person.setDirection("Short"));
    }

    @Test
    void testSetDirection_Long() {
        assertEquals(-10, person.setDirection("Esta es una dirección extremadamente larga que supera los 60 caracteres permitidos"));
    }

    @Test
    void testSetDirection_Null() {
        assertEquals(-1, person.setDirection(null));
    }

    @Test
    void testSetDirection_NumberLetter() {
        assertEquals(0, person.setDirection("Calle 123A"));
    }

    @Test
    void testSetDirection_SpecialChar() {
        assertEquals(0, person.setDirection("Calle @#$%"));
    }

    @Test
    void testSetEmail_Valid() {
        assertEquals(0, person.setEmail("valid.email@example.com"));
    }

    @Test
    void testSetEmail_Short() {
        assertEquals(-22, person.setEmail("a@b.c"));
    }

    @Test
    void testSetEmail_Long() {
        assertEquals(0, person.setEmail("longemailaddressmorethan64characters@example.com"));
    }

    @Test
    void testSetEmail_Null() {
        assertEquals(-1, person.setEmail(null));
    }

    @Test
    void testSetEmail_NumberLetter() {
        assertEquals(0, person.setEmail("user123@example.com"));
    }

    @Test
    void testSetEmail_SpecialChar() {
        assertEquals(-22, person.setEmail("email!@example.com"));
    }

    @Test
    void testSetName_Valid() {
        assertEquals(0, person.setName("Maria"));
    }

    @Test
    void testSetName_Short() {
        assertEquals(-2, person.setName("Jo"));
    }

    @Test
    void testSetName_Long() {
        assertEquals(-10, person.setName("UnNombreExcesivamenteLargoParaElSistema"));
    }

    @Test
    void testSetName_Null() {
        assertEquals(-1, person.setName(null));
    }

    @Test
    void testSetName_NumberLetter() {
        assertEquals(0, person.setName("John123"));
    }

    @Test
    void testSetName_SpecialChar() {
        assertEquals(0, person.setName("John@Doe"));
    }

    @Test
    void testSetNif_Valid() {
        assertEquals(0, person.setNif("58840253C"));
    }

    @Test
    void testSetNif_Short() {
        assertEquals(-22, person.setNif("1234567A"));
    }

    @Test
    void testSetNif_Long() {
        assertEquals(-22, person.setNif("1234567890A"));
    }

    @Test
    void testSetNif_Null() {
        assertEquals(-1, person.setNif(null));
    }

    @Test
    void testSetNif_NumberOnly() {
        assertEquals(-22, person.setNif("12345678"));
    }

    @Test
    void testSetNif_SpecialChar() {
        assertEquals(-22, person.setNif("12345678@"));
    }

    @Test
    void testSetPhoneNumber_Valid() {
        assertEquals(0, person.setPhoneNumber(666555444));
    }

    @Test
    void testSetPhoneNumber_Short() {
        assertEquals(-6, person.setPhoneNumber(1234));
    }

    @Test
    void testSetPhoneNumber_Long() {
        assertEquals(0, person.setPhoneNumber(1234567890));
    }

    @Test
    void testSetPhoneNumber_Null() {
        assertEquals(-1, person.setPhoneNumber(0));
    }

    @Test
    void testSetPhoneNumber_NumberLetter() {
        assertEquals(-3, person.setPhoneNumber(Integer.parseInt("123A".replaceAll("\\D", ""))));
    }

    @Test
    void testSetPhoneNumber_SpecialChar() {
        assertEquals(-3, person.setPhoneNumber(Integer.parseInt("123-456".replaceAll("\\D", ""))));
    }
}
