package lesson4.practices.practice_1_And_2;

public class Manager extends Employee2 {
    private String deptName;

    Manager(String name, int age, double salary,String deptName) {
        super(name, age, salary);
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String printInfo() {
        return super.printInfo() + " Dept: " + deptName;
    }
}
