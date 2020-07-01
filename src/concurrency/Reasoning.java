package concurrency;

class Reasoning extends Thread {
    //set up this class so it can become a valid thread. 
    void distinguish() {
        //print to the console the difference between a thread and a process
        System.out.println("A thread is an ordered stream of instructions (smallest unit of execution) that can be run in a program. " + "\n" +
                "And each program runs in a process which handles the execution of a thread and can multitask by executing multiple threads at the same time (concurrently).");
        //print out you think will happen if you invoke the run() method of a thread as opposed to the start() method of a thread.
        System.out.println("Not sure but expecting the unexpected. I think we will just execute run() method like a regular method but a thread is not populated." + "\n" +
                "The start() method does populate a thread and thanks to it we can take advantage of controlling the stream of execution in the program while run() method just runs procedurally");
    }

    @Override
    public void run() {
    distinguish();
    }
}

