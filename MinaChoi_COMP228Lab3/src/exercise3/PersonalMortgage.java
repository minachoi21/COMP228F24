package exercise3;

class PersonalMortgage extends Mortgage {
    public PersonalMortgage(String mortgageNumber, String customerName, double amount, double primeRate, int term) {
        super(mortgageNumber, customerName, amount, primeRate + 2, term);
    }

    @Override
    public String getMortgageInfo() {
        return "Personal Mortgage - Number: " + mortgageNumber + ", Customer: " + customerName +
                ", Amount: $" + amount + ", Interest Rate: " + interestRate + "%, Term: " + term + " years, Total Owed: $" + calculateTotalOwed();
    }
}