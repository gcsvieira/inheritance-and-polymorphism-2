package model.entities;

public class NaturalPerson extends Person {
    protected static final Double TAX_PERCENTAGE_1 = 0.15;
    protected static final Double TAX_PERCENTAGE_2 = 0.25;
    protected static final Double HEALTH_TAX_PERCENTAGE = 0.5;

    private Double healthSpendings;

    public NaturalPerson(String name, Double annualIncome, Double healthSpendings) {
        super(name, annualIncome);
        this.healthSpendings = healthSpendings;
    }

    public Double getHealthSpendings() {
        return this.healthSpendings;
    }

    public void setHealthSpendings(Double healthSpendings) {
        this.healthSpendings = healthSpendings;
    }

    @Override
    public Double taxCalculator() {
        Double sum;

        if (annualIncome < 20000) {
            sum = annualIncome * TAX_PERCENTAGE_1;
        } else {
            sum = annualIncome * TAX_PERCENTAGE_2;
        }

        if (healthSpendings != null || healthSpendings != 0.0)
            sum -= (healthSpendings * HEALTH_TAX_PERCENTAGE);

        return sum;
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", annualIncome='" + getAnnualIncome() + "'" +
                " healthSpendings='" + getHealthSpendings() + "'" +
                "}";
    }

}
