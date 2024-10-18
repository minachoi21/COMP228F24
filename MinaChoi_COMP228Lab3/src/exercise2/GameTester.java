package exercise2;

public abstract class GameTester {
    protected String name;
    protected boolean isFullTime;

    public GameTester(String name, boolean isFullTime) {
        this.name = name;
        this.isFullTime = isFullTime;
    }

    public abstract double determineSalary();

    public String getName() {
        return name;
    }

    public boolean isFullTime() {
        return isFullTime;
    }
}
