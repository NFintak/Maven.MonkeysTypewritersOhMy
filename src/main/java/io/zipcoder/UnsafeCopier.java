package io.zipcoder;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        while(this.stringIterator.hasNext()) {
            this.copied += this.stringIterator.next() + " ";
            System.out.println(this.copied);
        }
    }
}
