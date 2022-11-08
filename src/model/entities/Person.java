package model.entities;

public abstract class Person {
    protected String name;
    protected Double annualIncome;

    public Person(String name, Double annualIncome) {
        this.name = name;
        this.annualIncome = annualIncome;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAnnualIncome() {
        return this.annualIncome;
    }

    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public abstract Double taxCalculator();

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", annualIncome='" + getAnnualIncome() + "'" +
                "}";
    }

}
