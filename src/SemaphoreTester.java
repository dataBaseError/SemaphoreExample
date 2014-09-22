import java.util.concurrent.atomic.AtomicInteger;


public class SemaphoreTester {
	
	public static AtomicInteger problemsSolved = new AtomicInteger(0);
	
	public static AtomicInteger problemsPosted = new AtomicInteger(0);
	
	private static int REFRESH_TIMER = 1000;

	public static void main(String[] args) {
		/**
		 * TODO create producer manager which creates producers at n random time
		 * producers creating sorting jobs (of random size) and place them into a job queue
		 * (producer) posts to the semaphore each new job
		 * Consumer manager creates consumers at p random time
		 * consumers will consume jobs from the queue using semaphores will wait on the semaphore for new jobs.
		 */
		
		ProducerManager pm = new ProducerManager();
		ConsumerManager cm = new ConsumerManager();
		
		while(true) {
			
			System.out.print("\033c");
			System.out.println("Total number of problems posted = " + problemsPosted.get());
			System.out.println("Current number of Problems Solved = " + problemsSolved.get());
			System.out.println("Number of Problem Creators: " + pm.producers.size());
			System.out.println("Number of Problem Solvers: " + cm.consumers.size());
			
			try {
				Thread.sleep(REFRESH_TIMER);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
