import java.util.ArrayList;


public class ProducerManager implements Runnable {
	
	private static final int NEW_PRODUCER_TIME = 1000;
	
	private static final int MAX_PRODUCERS = 5;
	
	private static final int INITIAL_PRODUCERS = 1;

	ArrayList<Producer> producers;
	
	public ProducerManager()
	{
		producers = new ArrayList<Producer>();
		Thread manger = new Thread(this);
		manger.start();
	}
	
	@Override
	public void run() {
		
		for(int i = 0; i < INITIAL_PRODUCERS; i++) {
			producers.add(new Producer());
		}
		
		while (producers.size() < MAX_PRODUCERS) {
			
			// Sleep for the defined time
			try {
				Thread.sleep(NEW_PRODUCER_TIME);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			//System.out.println("Creating the " + producers.size() +" Producer");
			
			// Add a new producer
			producers.add(new Producer());
		}
		
	}
}
