package lesson4.practices.practice_1_And_2;

public class Director extends Manager {
    Director(String name, int age, double salary,String deptName) {
        super(name, age, salary,deptName);
    }
    @Override
    public String printInfo() {
        return super.printInfo();
    }
}
