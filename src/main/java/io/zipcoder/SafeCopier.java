package io.zipcoder;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {
    private ReentrantLock lock;

    public SafeCopier(String toCopy, ReentrantLock lock) {
        super(toCopy);
        this.lock = lock;
    }

    public void run() {
        lock.lock();
        while(this.stringIterator.hasNext()) {
            this.copied += this.stringIterator.next() + " ";
        }
        lock.unlock();
        System.out.println(this.copied);
    }
}
