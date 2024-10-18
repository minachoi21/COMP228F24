package exercise1;

public class Life extends Insurance {
    public Life() {
        this.insuranceType = "Life";
    }

    @Override
    public void setInsuranceCost(double cost) {
        this.monthlyCost = cost;
    }

    @Override
    public void displayInfo() {
        System.out.println("Type: "+ getInsuranceType()+ ", Monthly Cost: $" + getMonthlyCost());
    }
}