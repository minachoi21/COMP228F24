package exercise3;

class BusinessMortgage extends Mortgage {
    public BusinessMortgage(String mortgageNumber, String customerName, double amount, double primeRate, int term) {
        super(mortgageNumber, customerName, amount, primeRate + 1, term);
    }

    @Override
    public String getMortgageInfo() {
        return "Business Mortgage - Number: " + mortgageNumber + ", Customer: " + customerName +
                ", Amount: $" + amount + ", Interest Rate: " + interestRate + "%, Term: " + term + " years, Total Owed: $" + calculateTotalOwed();
    }
}