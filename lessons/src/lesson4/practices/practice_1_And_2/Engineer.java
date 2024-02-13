package lesson4.practices.practice_1_And_2;

public class Engineer extends Employee2 {
    Engineer(String name, int age, double salary) {
        super(name, age, salary);
    }

    public void engineerMethod(){
        System.out.println("Method specific to Engineer class");
    }
}
