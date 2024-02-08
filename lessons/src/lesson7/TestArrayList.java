package lesson7;

import java.util.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> partList = new ArrayList<>(3);
        partList.add(new Integer(1111));
        partList.add(new Integer(2222));
        partList.add(new Integer(3333));
        partList.add(new Integer(4444));
        System.out.println("First part: " + partList.get(2));
        partList.add(0,new Integer(5555));

    }
}
