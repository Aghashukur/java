package fact.it.examcustomercheck;

import fact.it.examcustomercheck.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerTest {

    @Test
    public void testGetName() {
        Customer customer = new Customer("John");
        assertEquals("John", customer.getName());
    }

    @Test
    public void testSetName() {
        Customer customer = new Customer("John");
        customer.setName("Jane");
        assertEquals("Jane", customer.getName());
    }

    @Test
    public void testIsCitizen() {
        Customer customer = new Customer("John");
        customer.setCitizen(true);
        assertTrue(customer.isCitizen());
    }

    @Test
    public void testSetCitizen() {
        Customer customer = new Customer("John");
        customer.setCitizen(false);
        assertFalse(customer.isCitizen());
    }

    @Test
    public void testGetYearOfRegistration() {
        Customer customer = new Customer("John");
        customer.setYearOfRegistration(2021);
        assertEquals(2021, customer.getYearOfRegistration());
    }

    @Test
    public void testSetYearOfRegistration() {
        Customer customer = new Customer("John");
        customer.setYearOfRegistration(2021);
        assertEquals(2021, customer.getYearOfRegistration());
    }

    @Test
    public void testToStringCitizen() {
        Customer customer = new Customer("John");
        customer.setCitizen(true);
        customer.setYearOfRegistration(2021);
        assertEquals("John (citizen) registered in 2021", customer.toString());
    }

    @Test
    public void testToStringNonCitizen() {
        Customer customer = new Customer("John");
        customer.setCitizen(false);
        customer.setYearOfRegistration(2021);
        assertEquals("John registered in 2021", customer.toString());
    }

}
