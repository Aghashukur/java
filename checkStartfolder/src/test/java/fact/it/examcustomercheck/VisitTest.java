package fact.it.examcustomercheck;

import fact.it.examcustomercheck.model.Customer;
import fact.it.examcustomercheck.model.Visit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VisitTest {

    private Visit visit;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        visit = new Visit();
        customer = new Customer("John");
        customer.setYearOfRegistration(2020);
        visit.setCustomer(customer);
    }



    @Test
    public void testSetEnterWeight() {
        visit.setEnterWeight(10);
        assertEquals(10, visit.getEnterWeight());
    }


    @Test
    public void testSetExitWeight() {
        visit.setExitWeight(8);
        assertEquals(8, visit.getExitWeight());
    }

    @Test
    public void testGetCustomer() {
        assertEquals(customer, visit.getCustomer());
    }

    @Test
    public void testSetCustomer() {
        Customer newCustomer = new Customer("Jane");
        visit.setCustomer(newCustomer);
        assertEquals(newCustomer, visit.getCustomer());
    }

    @Test
    public void testGetDepositedWeight() {
        visit.setEnterWeight(10);
        visit.setExitWeight(8);
        assertEquals(2, visit.getDepositedWeight());
    }

    //alternative test for deposited weight
    @Test
    public void testGetDepositedWeight2() {
        visit.setEnterWeight(18);
        visit.setExitWeight(8);
        assertEquals(10, visit.getDepositedWeight());
    }

    @Test
    public void testGetCost_LessThanOrEqualTo7KgAndMembershipAgeGreaterThan5() {
        customer.setYearOfRegistration(2016);
        visit.setEnterWeight(5);
        visit.setExitWeight(3);
        assertEquals(0, visit.getCost());
    }
    //alternative test for cost
    @Test
    public void testGetCost_LessThanOrEqualTo7KgAndMembershipAgeGreaterThan5_2() {
        customer.setYearOfRegistration(2016);
        visit.setEnterWeight(12);
        visit.setExitWeight(5);
        assertEquals(0, visit.getCost());
    }
    @Test
    public void testGetCost_LessThanOrEqualTo7KgAndMembershipAgeGreaterThan5_3() {
        customer.setYearOfRegistration(2018);
        visit.setEnterWeight(12);
        visit.setExitWeight(5);
        assertEquals(14, visit.getCost());
    }
    @Test
    public void testGetCost_LessThanOrEqualTo50Kg() {
        visit.setEnterWeight(30);
        visit.setExitWeight(28);
        assertEquals(4, visit.getCost());
    }

    //alternative test for cost
    public void testGetCost_LessThanOrEqualTo50Kg_2() {
        customer.setYearOfRegistration(2010);
        visit.setEnterWeight(30);
        visit.setExitWeight(20);
        assertEquals(20, visit.getCost());
    }

    @Test
    public void testGetCost_GreaterThan50Kg() {
        customer.setYearOfRegistration(2010);
        visit.setEnterWeight(180);
        visit.setExitWeight(80);
        assertEquals(300, visit.getCost());
    }
    @Test
    public void testGetCost_EqualTo50Kg() {
        visit.setEnterWeight(180);
        visit.setExitWeight(130);
        assertEquals(100, visit.getCost());
    }

    @Test
    public void testGetMembershipAge() {
        assertEquals(3, visit.getMembershipAge());
    }

    @Test
    public void testToString() {
        visit.setEnterWeight(10);
        visit.setExitWeight(8);
        assertEquals("John registered in 2020 has deposited 2kg. of waste: Cost = 4 euro.", visit.toString());
    }

    //alternative test for toString
    public void testToString2() {
        visit.setEnterWeight(15);
        visit.setExitWeight(8);
        assertEquals("John registered in 2020 has deposited 2kg. of waste: Cost = 14 euro.", visit.toString());
    }

}
