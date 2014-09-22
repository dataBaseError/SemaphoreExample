import java.util.ArrayList;


public class ConsumerManager implements Runnable {
	
	private static final int NEW_CONSUMER_TIME = 500;
	
	public static final int MAX_COMSUMERS = 20;
	
	private static final int INITIAL_CONSUMER = 2;

	ArrayList<Consumer> consumers;
	
	public ConsumerManager()
	{
		consumers = new ArrayList<Consumer>();
		Thread manger = new Thread(this);
		manger.start();
	}

	@Override
	public void run() {
			
		for(int i = 0; i < INITIAL_CONSUMER; i++) {
			consumers.add(new Consumer());
		}
		
		while (consumers.size() < MAX_COMSUMERS) {
			
			// Sleep for the defined time
			try {
				Thread.sleep(NEW_CONSUMER_TIME);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
					
			// Add a new producer
			consumers.add(new Consumer());
		}
		
	}

}
