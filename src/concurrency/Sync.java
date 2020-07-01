package concurrency;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Sync extends Thread {
    List<Integer> nums;

    Sync(String name, List<Integer> nums) {
        super(name);
        this.nums = nums;
    }

    @Override
    synchronized public void run() {
            Random rand = new Random();

            for (int i = 0; i < 100; i++) {
                int randInt = rand.nextInt(100);
                this.nums.add(randInt);
            }

    }

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Sync syncThread = new Sync("sync thread 1", nums);
        executor.execute(syncThread);
        Sync syncThread2 = new Sync("sync thread 2", nums);
        executor.execute(syncThread2);
        Sync syncThread3 = new Sync("sync thread 3", nums);
        executor.execute(syncThread3);
        Sync syncThread4 = new Sync("sync thread 4", nums);
        executor.execute(syncThread4);
        Sync syncThread5 = new Sync("sync thread 5", nums);
        executor.execute(syncThread5);

        try {
            executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(syncThread.nums);
        executor.shutdown();
        //this prints out an empty list. write some code that will allow the data generated in the syncThread to show up  here.  There is a brute force way and a more sophisticated way.  Either or will work, but strive for sophistication :)

    }

}