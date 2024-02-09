package lesson10;

import java.util.List;

/**
 * @author oracle
 */
public class TestSort {
    public static void main(String[] args) {
        List<Employee> eList = Employee.createShortList();

        System.out.println("\n== CO Bonus Details ==");

        eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .filter(e -> e.getState().equals("CO"))
                .peek(e -> System.out.print("Name: " + e.getGivenName() + ", Surname: " + e.getSurName() + " "))
                .mapToDouble(e -> e.getSalary() * Bonus.byRole(e.getRole()))
                .peek(d -> System.out.printf("Bonus paid: $%,6.2f %n", d))
                .sorted()
                .forEach(d -> System.out.printf("Sort Bonus paid: $%,6.2f %n", d));
    }
}
