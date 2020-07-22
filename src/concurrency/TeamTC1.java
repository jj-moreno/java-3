package concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TeamTC1 implements Runnable {

    List<String> team = new ArrayList<>();
    public static final String ANSI_RESET = "\u001B[0m";
    //public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private static List<String> colorsForTerminal = new ArrayList<>(Arrays.asList(
            ANSI_RESET, ANSI_RED, ANSI_GREEN, ANSI_YELLOW, ANSI_BLUE, ANSI_PURPLE, ANSI_CYAN, ANSI_WHITE));
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Emilios");
            team.add("Emilios");
            Thread.sleep(1000);
            System.out.println("Abigail");
            team.add("Abigail");
            Thread.sleep(1000);
            System.out.println("Adam");
            team.add("Adam");
            Thread.sleep(1000);
            System.out.println("Christian");
            team.add("Christian");
            Thread.sleep(1000);
            System.out.println("Devon");
            team.add("Devon");
            Thread.sleep(1000);
            System.out.println("Gabe");
            team.add("Gabe");
            Thread.sleep(1000);
            System.out.println("Jose");
            team.add("Jose");
            Thread.sleep(1000);
            System.out.println("Julian");
            team.add("Julian");
            Thread.sleep(1000);
            System.out.println("Marcelo");
            team.add("Marcelo");
            Thread.sleep(1000);
            System.out.println("Michael");
            team.add("Michael");
            Thread.sleep(1000);
            System.out.println("Monica");
            team.add("Monica");
            Thread.sleep(1000);
            System.out.println("Phoenix");
            team.add("Phoenix");
            int random;
            for (String teamMember : team) {
                String colorReset = colorsForTerminal.get(0);
                random = (int) (Math.random() * 7 + 1); // prints value from 1 to 7
                System.out.println(colorsForTerminal.get(random) + teamMember + colorReset); // will print names in different colors in linux/unix shell and IntelliJ terminal
            }

        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

    }

    //This thread should be created by implementing the Runnable interface, NOT by extending the Thread class.
    // In the run method of this thread, print out the name of each student in your TA group, (starting with your TA).
    // There should be a pause of 1 second before each name is printed to the console.The name should then be pushed to the team List
    // After all the names have been pushed to this List, print out the entire list of all the students in your TA group.
    // Don't forget your TA as well!  All of these steps should be done whenever the thread is started.  (i.e. it can be done directly in the run()method of the thread itself).
    // Kick off the thread in the Main class of the concurrency package.
}