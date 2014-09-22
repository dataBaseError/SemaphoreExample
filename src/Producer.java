import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;


public class Producer implements Runnable{
	
	// Set the semaphore initial ticket to 0 and to not fair
	public static Semaphore semaphore = new Semaphore(0, false);
	
	public static Queue<Problem> problems = new LinkedList<Problem>();
	
	// Give the consumers a fighting chance
	private static int PRODUCER_SLEEP_TIME = 500;
	
	public Producer() {
		Thread t = new Thread(this);
		t.start();
	}
	
	private Problem createProblem() {
		return new Problem();
	}
	
	@Override
	public void run() {	
		
		while(true) {
			
			problems.add(createProblem());
			SemaphoreTester.problemsPosted.getAndIncrement();
			
			semaphore.release();
			
			try {
				Thread.sleep(PRODUCER_SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}

}
