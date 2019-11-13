package net.jcip.examples.s1;

import jsoup.main;
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
    
    /**
     * @param args
     */
    public static void main(String[] args) {
    	final UnsafeSequence u = new UnsafeSequence();
		Thread t1 =  new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					System.out.println("t1="+u.getNext()); 
				}
			}
		});
		Thread t2 =  new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
				System.out.println("t2="+u.getNext());
				} 
			}
		});
		t1.start();
		t2.start();
		
	}
}
