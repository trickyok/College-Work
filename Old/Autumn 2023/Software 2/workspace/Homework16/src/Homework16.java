import java.util.Comparator;
import components.queue.Queue;
import components.queue.Queue3;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Homework16 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework16() {
    }

    
    /**
     * Partitions {@code q} into two parts: entries no larger than
     * {@code partitioner} are put in {@code front}, and the rest are put in
     * {@code back}.
     * 
     * @param <T>
     *            type of {@code Queue} entries
     * @param q
     *            the {@code Queue} to be partitioned
     * @param partitioner
     *            the partitioning value
     * @param front
     *            upon return, the entries no larger than {@code partitioner}
     * @param back
     *            upon return, the entries larger than {@code partitioner}
     * @param order
     *            ordering by which to separate entries
     * @clears q
     * @replaces front, back
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures <pre>
     * perms(#q, front * back)  and
     * for all x: T where (<x> is substring of front)
     *  ([relation computed by order.compare method](x, partitioner))  and
     * for all x: T where (<x> is substring of back)
     *  (not [relation computed by order.compare method](x, partitioner))
     * </pre>
     */
    private static <T> void partition(Queue<T> q, T partitioner,
            Queue<T> front, Queue<T> back, Comparator<T> order) {
    	
    	Queue<T> nullQ = new Queue3<T>();
    	
    	while (!q.equals(nullQ)) {
    		
    		T next = q.dequeue();
    		
    		// if next greater than or equal to partitioner
    		if (order.compare(next, partitioner) > 0) {
    			back.enqueue(next);
    		} else {
    			front.enqueue(next);
    		}
    	}
    }
    
    
    /**
     * Sorts {@code this} according to the ordering provided by the
     * {@code compare} method from {@code order}.
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
    public static <T> void sort(Queue<T> qthis, Comparator<T> order) {
        if (qthis.length() > 2) {
        	Queue<T> temp = new Queue3<T>();
        	
            /*
             * Dequeue the partitioning entry from this
             */
        	while (qthis.length() > temp.length()) {
        		
        		temp.enqueue(qthis.dequeue());
        		
        	}
        	
        	T partitioner = qthis.dequeue();
        	temp.enqueue(partitioner);
        	
        	while (qthis.length() > 0) {
        		
        		temp.enqueue(qthis.dequeue());
        		
        	}
     
            /*
             * Partition this into two queues as discussed above
             * (you will need to declare and initialize two new queues)
             */
     
        	Queue<T> lower = new Queue3<T>();
        	Queue<T> higher = new Queue3<T>();
        	
        	// partition queue
        	while (temp.length() > 0) {
        		
        		T dequeue = temp.dequeue();
        		
        		if (order.compare(dequeue, partitioner) > 0) {
        			higher.enqueue(dequeue);
        		} else {
        			lower.enqueue(dequeue);
        		}
       		
        	}
        	
            /*
             * Recursively sort the two queues
             */
        	// THIS SHIT DONT WORK!!!!!!!!!// THIS SHIT DONT WORK!!!!!!!!!// THIS SHIT DONT WORK!!!!!!!!!
        	sort(lower, order);
        	sort(higher, order);
        	
            /*
             * Reconstruct this by combining the two sorted queues and the
             * partitioning entry in the proper order
             */
        	qthis.append(lower);
        	qthis.append(higher);
        	
     
        }
    }
    
    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
    	
    	SimpleReader in = new SimpleReader1L();
    	SimpleWriter out = new SimpleWriter1L();
        Comparator<Integer> order = Comparator.naturalOrder();
    	Integer partitioner = 50;
        
    	Queue<Integer> q = new Queue3<Integer>();;
    	for (int i = 0; i < 10; i++) {
    		q.enqueue((int) (Math.random()*100));
    	}
    	
    	out.println("Given queue");
    	out.println(q);
    	out.println();
    	
    	sort(q, order);
    	out.println("Sorted queue");
    	out.println(q);
    	out.println();
    	
        Queue<Integer> front = new Queue3<Integer>();
        Queue<Integer> back = new Queue3<Integer>();
    	
    	partition(q, partitioner, front, back, order);

    	out.println("Less than " + partitioner);
    	out.println(front);
    	out.println("Greater than " + partitioner);
    	out.println(back);
    	
    	
    	
    }
    


}
