package exercise1;

public class Health extends Insurance {
    public Health() {
        this.insuranceType = "Health";
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