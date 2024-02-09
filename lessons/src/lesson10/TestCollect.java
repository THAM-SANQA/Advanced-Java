package lesson10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author TJ
 */
public class TestCollect {

    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();

        List<Employee> nList = eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .filter(e -> e.getState().equals("CO"))
                .sorted(Comparator.comparing(Employee::getSurName))
                .collect(Collectors.toList());

        System.out.println("\n== CO Bonus Details ==");

        nList.stream()
                .forEach(Employee::printSummary);

    }

}
