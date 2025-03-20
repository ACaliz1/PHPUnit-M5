package demo.model.operations;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

// hacer en ingles
public class checkerTest {
@Test
    void testCheckDNI_Valid() {
        String dni = "12345678Z";
        assertEquals(0, checker.checkDNI(dni), "DNI válido debería devolver 0");
    }

    @Test
    void testCheckDNI_TooShort() {
        String dni = "1234567Z";
        assertEquals(-23, checker.checkDNI(dni), "DNI demasiado corto debería devolver -23");
    }

    @Test
    void testCheckDNI_TooLong() {
        String dni = "123456789Z";
        assertEquals(-23, checker.checkDNI(dni), "DNI demasiado largo debería devolver -23");
    }

    @Test
    void testCheckDNI_InvalidFormat_NonNumeric() {
        String dni = "A2345678Z";
        assertEquals(-23, checker.checkDNI(dni), "DNI con caracteres no numéricos debería devolver -23");
    }

    @Test
    void testCheckDNI_InvalidLetter() {
        String dni = "12345678X";
        assertEquals(-23, checker.checkDNI(dni), "DNI con letra incorrecta debería devolver -23");
    }
    @Test
    void testCheckDNI_Empty() {
        assertEquals(-23, checker.checkDNI(""), "DNI vacío debería devolver -23");
    }

    @Test
    void testCheckDNI_Null() {
        assertThrows(NullPointerException.class, () -> checker.checkDNI(null), "DNI null debería lanzar una excepción");
    }

    @Test
    void testCheckDNI_InvalidFormat_SpecialCharacter() {
        String dni = "1234567@Z";
        int resultado = checker.checkDNI(dni);
        assertEquals(-23, resultado, "DNI con caracter especial deberi�a devolver -23");
    }



//TEST PARA NULL

    @Test
    void testIsNull_Null() {
        assertEquals(-1, checker.isNull(null), "Comparar null debería devolver -1");
    }

    @Test
    void testIsNull_Space() {
        assertEquals(-1, checker.isNull(" "), "Comparar espacio debería devolver -1");
    }

    @Test
    void testIsNull_Text() {
        assertEquals(0, checker.isNull("A"), "Comparar texto debería devolver 0");
    }

    @Test
    void testIsNull_SpecialChar() {
        assertEquals(0, checker.isNull("@"), "Comparar caracteres especiales debería devolver 0");
    }


//TEST PARA MINLENGHT

    @Test
    void testMinLength_Valid() {
        assertEquals(0, checker.minLength(3, "hello"), "Texto con suficiente longitud debería ser válido");
    }

    @Test
    void testMinLength_Short() {
        assertEquals(-2, checker.minLength(10, "hi"), "Texto demasiado corto debería devolver -2");
    }

    @Test
    void testMinLength_Exact() {
        assertEquals(0, checker.minLength(5, "hello"), "Texto con longitud exacta debería ser válido");
    }

    @Test
    void testMinLength_Number() {
        assertEquals(-2, checker.minLength(5, "1"), "Texto con longitud exacta debería ser válido");
    }

    @Test
    void testMinLength_Empty() {
        assertEquals(-2, checker.minLength(5, ""), "Texto vacío debería devolver -2");
    }








//-------------------------------------------------
    @Test
    void testMinLength_Null() {
        String a = null;
        int n = 3;

        try {
            int result = checker.minLength(n, a);
            fail("Se esperaba una excepcion BuildException, pero el metodo devolvio: " + result);
        } catch (Exception e) {
            assertEquals(-2, e.getMessage(), "El mensaje de la excepcion no es el esperado.");
            fail("Se esperaba una excepcion BuildException, pero el metodo devolvio:" + e.getMessage());
        }
    }
    //------------------------------




    






    @Test
    void testMinLength_SpecialChar() {
        assertEquals(-2, checker.minLength(5, "@"), "Texto con caracteres especiales debería devolver -2");
    }

//TEST PARA MAXLENGHT

    @Test
    void testMaxLenght_TooLong() {
        assertEquals(-10, checker.maxLenght(3, "hello"), "Texto más largo que el máximo debería devolver -10");
    }
//TEST PARA MAXVALUE

    @Test
    void testMaxValue_Valid() {
        assertEquals(0, checker.maxValue(5, 10), "Valor dentro del límite debería ser válido");
    }

    @Test
    void testMaxValue_Exceeded() {
        assertEquals(-5, checker.maxValue(15, 10), "Valor fuera del límite debería devolver -5");
    }
//TEST PARA MINVALUE

    @Test
    void testMinValue_Valid() {
        assertEquals(0, checker.minValue(10, 5), "Valor mayor al mínimo debería ser válido");
    }

    @Test
    void testMinValue_BelowMin() {
        assertEquals(-7, checker.minValue(2, 5), "Valor menor al mínimo debería devolver -7");
    }

//TEST PARA NONNEGAVITE
    @Test
    void testNonNegative_Valid() {
        assertEquals(0, checker.nonNegative(5), "Número positivo debería ser válido");
    }

    @Test
    void testNonNegative_Negative() {
        assertEquals(-4, checker.nonNegative(-1), "Número negativo debería devolver -4");
    }

//TEST PARA NOZERO

    @Test
    void testNonZero_Valid() {
        assertEquals(0, checker.nonZero(5), "Número distinto de cero debería ser válido");
    }

    @Test
    void testNonZero_Zero() {
        assertEquals(-3, checker.nonZero(0), "Cero debería devolver -3");
    }

//TEST PARA VALIDATEISBN

    @Test
    void testValidateISBN13_Valid() {
        assertEquals(0, checker.validateISBN13("978-8-40-829696-6"), "ISBN válido debería ser aceptado");
    }

    @Test
    void testValidateISBN13_InvalidChecksum() {
        assertEquals(-24, checker.validateISBN13("978-1-23-456789-1"), "ISBN con checksum incorrecto debería devolver -24");
    }

    @Test
    void testValidateISBN13_InvalidFormat() {
        assertEquals(-24, checker.validateISBN13("978-123-456789"), "ISBN con formato incorrecto debería devolver -24");
    }

//TEST PARA PAYMENTMETHOD
    @Test
    void testWhichPaymentMethod_Valid() {
        assertEquals(0, checker.whichPaymentMethod("Paypal"), "Método de pago 'Paypal' debería ser válido");
    }

    @Test
    void testWhichPaymentMethod_Invalid() {
        assertEquals(-17, checker.whichPaymentMethod("Bitcoin"), "Método de pago no válido debería devolver -17");
    }

    @Test
    void testYesOrNo_ValidWithYes() {
        assertEquals(0, checker.yesOrNo("yes"), "Respuesta 'yes' debería ser válida");
    }
    @Test
    void testYesOrNo_ValidWithNo() {
        assertEquals(0, checker.yesOrNo("no"), "Respuesta 'no' debería ser válida");
    }

    @Test
    void testYesOrNo_Invalid() {
        assertEquals(-6, checker.yesOrNo("maybe"), "Respuesta no válida debería devolver -6");
    }

}
