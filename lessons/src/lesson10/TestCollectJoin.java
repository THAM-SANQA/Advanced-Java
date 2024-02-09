package lesson10;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author oracle
 */
public class TestCollectJoin {
    
    public static void main(String[] args) {
        
        List<Employee> eList = Employee.createShortList();
       
        // Collect CO Executives
        String deptList = eList.stream()
            .map(Employee::getDept)
            .distinct()
            .collect(Collectors.joining(", "));        

        System.out.println("\n== Dept List ==");
        System.out.println("Dept names: " + deptList);
                
    }
    
}
