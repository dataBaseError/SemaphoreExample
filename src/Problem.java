import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Problem {

	// Problem max difficulty
	private static int UPPER_BOUND = 50;
	
	private ArrayList<Integer> list;
	
	private Random random;
	
	public Problem() {
		
		random = new Random(System.currentTimeMillis());
		
		int size = random.nextInt(UPPER_BOUND-1) + 1;
		list = new ArrayList<Integer>(size);
		
		for(int i = 0; i < size; i++) {
			list.add(random.nextInt());
		}
	}
	
	public void solve() {
		list = (ArrayList<Integer>) bubbleSort(list);
	}
	
	// 
	/**
	 * Adapted from source code from Rosetta Code: http://rosettacode.org/wiki/Sorting_algorithms/Bubble_sort#Java
	 * The original code base used Comparable type arrays. This snippet has been updated to make use of List.
	 * @param comparable
	 * @return
	 */
	private static <E extends Comparable<? super E>> List<E > bubbleSort(List<E > comparable) {
	    boolean changed = false;
	    do {
	        changed = false;
	        for (int a = 0; a < comparable.size() - 1; a++) {
	            if (comparable.get(a).compareTo(comparable.get(a + 1)) > 0) {
	                E tmp = comparable.get(a);
	                comparable.set(a, comparable.get(a + 1));
	                comparable.set(a + 1, tmp);
	                changed = true;
	            }
	        }
	    } while (changed);
	    
		return comparable;
	}
}
