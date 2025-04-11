package io.zipcoder;

import java.util.concurrent.locks.ReentrantLock;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.
//        UnsafeCopier unsafeCopy = new UnsafeCopier(introduction);
        SafeCopier safeCopy = new SafeCopier(introduction, lock);

        Thread monkey1 = new Thread(new UnsafeCopier(introduction));
        Thread monkey2 = new Thread(new UnsafeCopier(introduction));
        Thread monkey3 = new Thread(new UnsafeCopier(introduction));
        Thread monkey4 = new Thread(new UnsafeCopier(introduction));
        Thread monkey5 = new Thread(new UnsafeCopier(introduction));

        Thread chimp1 = new Thread(safeCopy);
        Thread chimp2 = new Thread(safeCopy);
        Thread chimp3 = new Thread(safeCopy);
        Thread chimp4 = new Thread(safeCopy);
        Thread chimp5 = new Thread(safeCopy);

        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.

        System.out.println("Unsafe copy:");
        monkey1.run();
        monkey2.run();
        monkey3.run();
        monkey4.run();
        monkey5.run();
        //returning expected outcome

        System.out.println("Safe copy:");
        chimp1.run();
        chimp2.run();
        chimp3.run();
        chimp4.run();
        chimp5.run();
        System.out.println(safeCopy.copied);

        //needs to only print one time
        //make an instance var for SafeCopier and use that as the argument for the threads?
        //then sout(safeCopy.copied)?
        //or does the implementation of both classes in main have to match?
    }
}