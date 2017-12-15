package eu.burbach.procedureworld.server;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Sweeper extends Thread {
	private Queue<String> in = new ConcurrentLinkedDeque<String>();
	private Queue<String> out = new ConcurrentLinkedDeque<String>();
	boolean stop= false;

	private World world= new World(out);
	
	public void put(String s) {
		in.add(s);
	}
	
	public String poll() {
		return out.poll();
	}
	
	public synchronized void ende() {
		stop= true;
		world.shutdown();
	}
	
	private synchronized boolean isEnde() {
		return stop;
	}
	
	private void parse(String s) {
		world.userCommand(s);
	}
	
	public void run() {
		for(;;) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (!in.isEmpty()) {
				String s= in.poll();
				parse(s);
				out.add(s);
			}
			if (isEnde())
				break;
		}
	}
}
