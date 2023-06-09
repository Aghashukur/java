package fact.it.examcustomercheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;

@SpringBootApplication
public class ExamCustomerCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamCustomerCheckApplication.class, args);
    }

}
import java.time.LocalDate;

class WasteDisposalFacility {
    private static final double RATE_PER_KG = 0.1; // Cost per kilogram

    private String registrationNumber;
    private LocalDate registrationDate;
    private double enterWeight;
    private double exitWeight;

    public WasteDisposalFacility(String registrationNumber, LocalDate registrationDate) {
        this.registrationNumber = registrationNumber;
        this.registrationDate = registrationDate;
    }

    public void setEnterWeight(double enterWeight) {
        this.enterWeight = enterWeight;
    }

    public void setExitWeight(double exitWeight) {
        this.exitWeight = exitWeight;
    }

    public double calculateCosts() {
        double weightDifference = exitWeight - enterWeight;
        int daysSinceRegistration = registrationDate.until(LocalDate.now()).getDays();
        double cost = weightDifference * RATE_PER_KG * (1 + (daysSinceRegistration / 365.0));
        return Math.max(0, cost); // Ensure the cost is never negative
    }
}

class WasteDisposalFacilityDemo {
    public static void main(String[] args) {
        WasteDisposalFacility customer = new WasteDisposalFacility("ABC123", LocalDate.of(2022, 1, 1));
        customer.setEnterWeight(1000);
        customer.setExitWeight(750);

        double costs = customer.calculateCosts();
        System.out.println("The costs for the visit are: $" + costs);
    }
}
