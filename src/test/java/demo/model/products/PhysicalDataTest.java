package demo.model.products;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import demo.exceptions.BuildException;

public class PhysicalDataTest {
    private PhysicalData physicalData;

    @BeforeEach
    void createInstance() {
        try {
            this.physicalData = PhysicalData.getInstancePhysicalData(10, 20, 30, 10, "yes");
        } catch (BuildException e) {
            fail("Falló la configuración del test en @BeforeEach: " + e.getMessage());
        }
    }

    @Test
    void testGetInstancePhysicalData_Valid() {
        try {
            PhysicalData data = PhysicalData.getInstancePhysicalData(10, 20, 30, 10, "yes");
            assertNotNull(data);
            assertEquals(10.0, data.getAncho());
            assertEquals(20.0, data.getLargo());
            assertEquals(30.0, data.getAlto());
            assertEquals(10.0, data.getPeso());
            assertEquals("yes", data.getFragil());
        } catch (BuildException e) {
            fail("No debería lanzar excepción con valores válidos");
        }
    }

    @Test
    void testGetInstancePhysicalData_InvalidByAncho() {
        try {
            PhysicalData.getInstancePhysicalData(0, 20, 30, 10, "yes");
            fail("Se esperaba una BuildException pero no se lanzó");
        } catch (BuildException e) {
            assertEquals("This wide is not possible, ", e.getMessage());
        }
    }

    @Test
    void testGetInstancePhysicalData_InvalidByLargo() {
        try {
            PhysicalData.getInstancePhysicalData(10, -5, 30, 10, "yes");
            fail("Se esperaba una BuildException pero no se lanzó");
        } catch (BuildException e) {
            assertEquals("This large is not possible, ", e.getMessage());
        }
    }

    @Test
    void testGetInstancePhysicalData_InvalidByAlto() {
        try {
            PhysicalData.getInstancePhysicalData(10, 20, 50, 10, "yes");
            fail("Se esperaba una BuildException pero no se lanzó");
        } catch (BuildException e) {
            assertEquals("This high is not possible, ", e.getMessage());
        }
    }

    @Test
    void testGetInstancePhysicalData_InvalidByPeso() {
        try {
            PhysicalData.getInstancePhysicalData(10, 20, 30, -1, "yes");
            fail("Se esperaba una BuildException pero no se lanzó");
        } catch (BuildException e) {
            assertEquals("This weight is not possible, ", e.getMessage());
        }
    }

    @Test
    void testGetInstancePhysicalData_InvalidByFragil() {
        try {
            PhysicalData.getInstancePhysicalData(10, 20, 30, 10, "maybe");
            fail("Se esperaba una BuildException pero no se lanzó");
        } catch (BuildException e) {
            assertEquals("This fragil is not possible, ", e.getMessage());
        }
    }

    @Test
    void testSetAlto_Valid() {
        int result = physicalData.setAlto(25.0);
        assertEquals(0, result, "El alto debería ser válido");
        assertEquals(25.0, physicalData.getAlto());
    }

    @Test
    void testSetAlto_TooHigh() {
        int result = physicalData.setAlto(2500000000.0);
        assertEquals(-5, result, "El código de error debería indicar que el alto es demasiado grande");
        assertNotEquals(2500000000.0, physicalData.getAlto(), "El valor no debería haberse asignado");
    }

    @Test
    void testSetAlto_Zero() {
        int result = physicalData.setAlto(0);
        assertEquals(-3, result, "El código de error debería indicar que el valor no puede ser cero");
    }

    @Test
    void testSetFragil_Valid() {
        int result = physicalData.setFragil("no");
        assertEquals(0, result, "El valor 'no' debería ser aceptado");
        assertEquals("no", physicalData.getFragil());
    }

    @Test
    void testSetFragil_Invalid() {
        int result = physicalData.setFragil("maybe");
        assertEquals(-8, result, "El código de error debería indicar que solo se acepta 'yes' o 'no'");
    }

    @Test
    void testGetDimensions() {
        assertEquals(10 * 30, physicalData.getDimensions(), 0.0001);
    }

    @Test
    void testGetVolumen() {
        assertEquals(10 * 30 * 20, physicalData.getVolumen(), 0.0001);
    }

    @Test
    void testToString() {
        String expected = "PhysicalData [ancho=10.0, largo=20.0, alto=30.0, peso=10.0, fragil=yes]";
        assertEquals(expected, physicalData.toString());
    }
}
