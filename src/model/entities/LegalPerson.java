package model.entities;

public class LegalPerson extends Person {
    protected static final Double TAX_PERCENTAGE_1 = 0.16;
    protected static final Double TAX_PERCENTAGE_2 = 0.14;

    private Integer employeeAmount;

    public LegalPerson(String name, Double annualIncome, Integer employeeAmount) {
        super(name, annualIncome);
        this.employeeAmount = employeeAmount;
    }

    public Integer getEmployeeAmount() {
        return this.employeeAmount;
    }

    public void setEmployeeAmount(Integer employeeAmount) {
        this.employeeAmount = employeeAmount;
    }

    @Override
    public Double taxCalculator() {
        Double sum;

        if (employeeAmount <= 10) {
            sum = annualIncome * TAX_PERCENTAGE_1;
        } else {
            sum = annualIncome * TAX_PERCENTAGE_2;
        }

        return sum;
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", annualIncome='" + getAnnualIncome() + "'" +
                " employeeAmount='" + getEmployeeAmount() + "'" +
                "}";
    }

}
