package lesson10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author TJ
 */
public class TestCollectCount {

    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();

        Map<String, Long> gMap = eList.stream()
                .collect(Collectors.groupingBy(e -> e.getDept(), Collectors.counting()));

        System.out.println("\n== Employees by Dept ==");
        gMap.forEach((k, v) -> System.out.println("Department: " + k + ", Employees/Department: " + v));

    }

}
