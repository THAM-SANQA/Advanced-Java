package lesson10;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author TJ
 */
public class TestOtherTerminalOps {

    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();

        System.out.println("\n== Executive Count ==");
        long execCount =
                eList.stream()
                        .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                        .count();

        System.out.println("Exec count: " + execCount);

        System.out.println("\n== Highest Paid Exec ==");
        Optional highestExec =
                eList.stream()
                        .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                        .max(Employee::sortBySalary);

        if (highestExec.isPresent()) {
            Employee temp = (Employee) highestExec.get();
            System.out.printf(
                    "Name: " + temp.getGivenName() + " " + temp.getSurName() + "   Salary: $%,6.2f %n ",
                    temp.getSalary());
        }

        System.out.println("\n== Lowest Paid Exec ==");
        Optional lowestExec =
                eList.stream()
                        .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                        .min(Comparator.comparingDouble(e -> e.getSalary()));

        if (lowestExec.isPresent()) {
            Employee temp = (Employee) lowestExec.get();
            System.out.printf("Name: " + temp.getGivenName()
                    + " " + temp.getSurName() + "   Salary: $%,6.2f %n ", temp.getSalary());
        }
    }
}
