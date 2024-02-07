package lesson4;

/**
 * @author thamsanqa 2024
 **/
public class TestOverriding {

    public static void main(String[] args) {
        Employee emp = new Employee(1, "Jac", "gtb78", 2000);
        Manager manager = new Manager(2, "loli", "hyg8", 7000, "dev");
        System.out.println(emp.getAllDetails());
        System.out.println(manager.getAllDetails());
    }
}