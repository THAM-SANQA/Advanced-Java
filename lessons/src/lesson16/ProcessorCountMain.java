package lesson16;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessorCountMain {

    public static void main(String[] args) {
        int count = Runtime.getRuntime().availableProcessors();
        System.out.println("Processor Count:" + count);

        int[] data = new int[1024 * 1024 * 256]; //1G

        for (int i = 0; i < data.length; i++) {
            data[i] = ThreadLocalRandom.current().nextInt();
        }

/*
        int max = Integer.MIN_VALUE;
        int i = 1;
        for (int value : data) {
            if (value > max) {
                max = value;
                System.out.println("Increasing values, value: " + i +" = "+ max);
                i++;
            }
        }
        System.out.println("Max value found: " + max);
*/

        ForkJoinPool pool = new ForkJoinPool();
        FindMaxTask task = new FindMaxTask(data, 0, data.length-1, data.length/16);
        Integer result = pool.invoke(task);
        System.out.println("Max value found:" + result);

    }
}