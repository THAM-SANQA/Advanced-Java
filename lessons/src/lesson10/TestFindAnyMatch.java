package lesson10;

import java.util.List;
import java.util.Optional;

/**
 * @author TJ
 */
public class TestFindAnyMatch {

    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();
        System.out.println("\n== First CO Bonus ==");

        if (eList.stream().anyMatch(e -> e.getState().equals("CO"))) {
            Optional<Employee> result = eList.parallelStream()
                    .peek(e -> System.out.println("Stream"))
                    .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                    .filter(e -> e.getState().equals("CO"))
                    .findAny();

            if (result.isPresent()) {
                result.get().printSummary();
            }
        }

    }

}
