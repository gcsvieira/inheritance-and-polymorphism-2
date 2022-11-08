package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.LegalPerson;
import model.entities.NaturalPerson;
import model.entities.Person;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of tax payers: ");
        Integer taxPayer = Integer.parseInt(scan.nextLine());
        List<Person> person = new ArrayList<>();

        for (int i = 1; i <= taxPayer; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Natural or legal (n/l)? ");
            Character personType = scan.next().charAt(0);
            scan.nextLine();
            System.out.print("Name: ");
            String name = scan.nextLine();
            System.out.print("Annual income: ");
            Double annualIncome = Double.parseDouble(scan.nextLine());
            if (personType == 'n') {
                System.out.print("Amount of health spendings this year: ");
                Double healthSpendings = Double.parseDouble(scan.nextLine());
                person.add(new NaturalPerson(name, annualIncome, healthSpendings));
            } else if (personType == 'l') {
                System.out.print("Amount of employees hired: ");
                Integer employeeNumber = Integer.parseInt(scan.nextLine());
                person.add(new LegalPerson(name, annualIncome, employeeNumber));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID: ");
        for (Person per : person) {
            System.out.println(per.getName() + " $ " + String.format("%.2f", per.taxCalculator()));
        }

        System.out.println();
        Double sumTaxes = 0.0;
        for (Person per : person) {
            sumTaxes += per.taxCalculator();
        }
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sumTaxes));

        scan.close();
    }
}
