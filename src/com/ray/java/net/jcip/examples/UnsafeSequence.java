package com.ray.java.net.jcip.examples;

import net.jcip.annotations.*;

/**
 * UnsafeSequence
 *
 * @author Brian Goetz and Tim Peierls
 */

@NotThreadSafe
public class UnsafeSequence {
    private int value;

    /**
     * Returns a unique value.
     */
    public int getNext() {
        return value++;
    }

    public static void main(String[] args) {
        UnsafeSequence unsafeSequence = new UnsafeSequence();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.print(unsafeSequence.getNext()));
        }
    }
}
