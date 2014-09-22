import java.util.concurrent.Semaphore;


public class Consumer implements Runnable {
	
	public static Semaphore queue_sem = new Semaphore(1, false);

	public Consumer() {
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			try {
				Producer.semaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			try {
				queue_sem.acquire();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// Get the new problem
			Problem newProblem = Producer.problems.poll();
			
			queue_sem.release();
		
			if(newProblem != null) {
				
				newProblem.solve();
				SemaphoreTester.problemsSolved.getAndIncrement();
			}
			
		}
	}

}
