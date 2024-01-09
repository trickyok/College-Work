import java.util.Comparator;
import java.util.Iterator;

import components.queue.Queue;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class ProgramSkeleton {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private ProgramSkeleton() {
    }

    
    /**
     * Inserts the given {@code T} in the {@code Queue<T>} sorted according to
     * the given {@code Comparator<T>} and maintains the {@code Queue<T>}
     * sorted.
     * 
     * @param <T>
     *            type of {@code Queue} entries
     * @param q
     *            the {@code Queue} to insert into
     * @param x
     *            the {@code T} to insert
     * @param order
     *            the {@code Comparator} defining the order for {@code T}
     * @updates q
     * @requires <pre>
     * IS_TOTAL_PREORDER([relation computed by order.compare method])  and
     * IS_SORTED(q, [relation computed by order.compare method])
     * </pre>
     * @ensures <pre>
     * perms(q, #q * <x>)  and
     * IS_SORTED(q, [relation computed by order.compare method])
     * </pre>
     */
    private static <T> void insertInOrder(Queue<T> q, T x, Comparator<T> order) {
    	
    	boolean in = false;
    	int idx = 0;
    	
    	while (idx < q.length() && !in) {
    		if (order.compare(q.front(), x) > 0) {
    			q.enqueue(x);
    			in = true;
    		}
    		
    		idx++;
    		T temp = q.dequeue();
    		q.enqueue(temp);
    	}
    }
    
    
    /**
     * Sorts {@code this} according to the ordering provided by the
     * {@code compare} method from {@code order}.
     * 
     * Algorithm taken from the following link:
     * https://www.javatpoint.com/insertion-sort-in-java
     * 
     * @param order
     *            ordering by which to sort
     * @updates this
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures <pre>
     * perms(this, #this)  and
     * IS_SORTED(this, [relation computed by order.compare method])
     * </pre>
     */
    public void sort(Comparator<T> order) {
        int n = order.length;
        for (int j = 1; j < n; j++) {  
            int key = order[j];  
            int i = j-1;  
            while ((i > -1) && (order [i] > key)) {  
                order [i+1] = order [i];  
                i--;  
            }  
            order[i+1] = key;  
        }  
    }
    
    
    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        /*
         * Put your main program code here
         */
    }

}
