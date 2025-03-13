package demo.model.operations;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil.Checker;

import demo.exceptions.BuildException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class checkerTest {

    // Tests CheckDNI function
    @Test
    void testCheckDNI_Valid() {
        String dni = "12345678Z";
        int resultado = checker.checkDNI(dni);
        assertEquals(0, resultado, "DNI válido debería devolver 0");
    }

    @Test
    void testCheckDNI_TooShort() {
        String dni = "1234567Z";
        int resultado = checker.checkDNI(dni);
        assertEquals(-23, resultado, "DNI demasiado corto debería devolver -23");
    }

    @Test
    void testCheckDNI_TooLong() {
        String dni = "123456789Z";
        int resultado = checker.checkDNI(dni);
        assertEquals(-23, resultado, "DNI demasiado largo debería devolver -23");
    }

    @Test
    void testCheckDNI_InvalidFormat_NonNumeric() {
        String dni = "A2345678Z";
        int resultado = checker.checkDNI(dni);
        assertEquals(-23, resultado, "DNI con caracteres no numéricos debería devolver -23");
    }

    @Test
    void testCheckDNI_InvalidFormat_SpecialCharacter() {
        String dni = "1234567@Z";
        int resultado = checker.checkDNI(dni);
        assertEquals(-23, resultado, "DNI con carácter especial debería devolver -23");
    }

    @Test
    void testCheckDNI_InvalidLetter() {
        String dni = "12345678X"; // Letra incorrecta para ese número
        int resultado = checker.checkDNI(dni);
        assertEquals(-23, resultado, "DNI con letra incorrecta debería devolver -23");
    }

    @Test
    void testCheckDNI_Empty() {
        String dni = "";
        int resultado = checker.checkDNI(dni);
        assertEquals(-23, resultado, "DNI vacío debería devolver -23");
    }

    @Test
    void testCheckDNI_Null() {
        assertThrows(NullPointerException.class, () -> checker.checkDNI(null), "DNI null debería lanzar una excepción");
    }

    @Test
    void testCheckDate2() {

    }

    @Test
    void testCheckDateAndTime() {

    }

    @Test
    void testCheckDifficulty() {

    }

    @Test
    void testCheckStatus() {

    }

    @Test
    void testComparePrices() {

    }

    @Test
    void testIsDateTimeGreaterThanToday() {

    }

    // Tests isNull function
    @Test
    void testIsNull() {
        String a = null;
        assertEquals(-1, checker.isNull(a), "Comparar null con isNull debería devolver -1");
    }

    @Test
    void testIsNull_space() {
        String a = " ";
        assertEquals(-1, checker.isNull(a), "Comparar espacio con isNull debería devolver -1");
    }

    @Test
    void testIsNull_varchar() {
        String a = "A";
        assertEquals(0, checker.isNull(a), "Comparar varchar con isNull debería devolver 0");
    }

    @Test
    void testMaxLenght() {

    }

    @Test
    void testMaxValue() {

    }

    @Test
    void testMaxValue2() {

    }

    @Test
    void testMaxValueCount() {

    }

    // Tests MinLength function
    @Test
    void testMinLength() {
        String a = "";
        int n = 3;
        assertEquals(-2, checker.minLength(n, a), "Comparar " + a.length() + " con " + n + " debería devolver -2");
    }

    @Test
    void testMinLength_Long() {
        String a = "wefwfwf";
        int n = 3;
        assertEquals(0, checker.minLength(n, a), "Comparar " + a.length() + " con " + n + " debería devolver -2");
    }

@Test
void testMinLength_Null() {
    String a = null;
    int n = 3;

    try {
        int result = checker.minLength(n, a);
        fail("Se esperaba una excepción BuildException, pero el método devolvió: " + result);
    } catch (Exception e) {
        assertEquals(0, e.getMessage(), "El mensaje de la excepción no es el esperado.");
    }
}



    @Test
    void testMinValue() {

    }

    @Test
    void testMinValue2() {

    }

    @Test
    void testMinValueCount() {

    }

    @Test
    void testNonNegative() {

    }

    @Test
    void testNonNegative2() {

    }

    @Test
    void testNonZero() {

    }

    @Test
    void testNonZero2() {

    }

    @Test
    void testValidarCorreo() {

    }

    @Test
    void testValidateISBN13() {

    }

    @Test
    void testWhichPaymentMethod() {

    }

    @Test
    void testYesOrNo() {

    }
}
