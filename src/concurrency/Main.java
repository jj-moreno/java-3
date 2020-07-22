package concurrency;

public class Main {
   
    public static void main(String[] args) {
         //run all of your threads from this main class.
        Reasoning r1 = new Reasoning();
        r1.start();
        TeamTC1 tc1 = new TeamTC1();
        Thread teamV8 = new Thread(tc1, "TeamV8");
        teamV8.start();
    }
}