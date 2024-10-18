package exercise3;

abstract class Mortgage implements MortgageConstants {
    protected String mortgageNumber;
    protected String customerName;
    protected double amount;
    protected double interestRate;
    protected int term;

    public Mortgage(String mortgageNumber, String customerName, double amount, double interestRate, int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        setAmount(amount);
        this.interestRate = interestRate;
        setTerm(term);
    }

    public void setAmount(double amount) {
        if (amount > MAX_MORTGAGE_AMOUNT) {
            throw new IllegalArgumentException("Mortgage amount cannot exceed $" + MAX_MORTGAGE_AMOUNT);
        }
        this.amount = amount;
    }

    public void setTerm(int term) {
        if (term != SHORT_TERM && term != MEDIUM_TERM && term != LONG_TERM) {
            this.term = SHORT_TERM;
        } else {
            this.term = term;
        }
    }

    public double calculateTotalOwed() {
        return amount + (amount * (interestRate / 100));
    }

    public abstract String getMortgageInfo();
}
