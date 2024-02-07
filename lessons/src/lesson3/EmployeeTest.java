package lesson3;

/**
 * @author thamsanqa 2024
 **/
public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp1 = new Employee(121, "Ron Weasly", "ab123", 5000);
        String name = emp1.getName();
        String ssn = emp1.getSsn();
        double salary = emp1.getSalary();
        int id = emp1.getEmpId();
        System.out.println("Details of Employee 1");
        System.out.println("Name: " + name +" "+ "ssn: " + ssn +" "+ "salary: R" + salary +" "+ "id: " + id);
        emp1.changeName("John Show");
        name = emp1.getName();
        System.out.println("Details of Employee 1 updated.");
        System.out.println("Name: " + name +" "+ "ssn: " + ssn +" "+ "salary: R" + salary +" "+ "id: " + id);
    }
}

