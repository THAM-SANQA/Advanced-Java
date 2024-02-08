package lesson7;

import java.util.Set;
import java.util.TreeSet;

public class TestSet {
    public static void main(String[] args){
        Set<String> set = new TreeSet<>();
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("three"); // not added, only unique
        for (String item:set){
            System.out.println("Item: " + item);
        }
    }
}
