package eu.burbach.procedureworld.server.common;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public abstract class Service extends Thread {

	protected int sleepinterval= 100;
    protected GraphDatabaseService db;
    protected Queue<Node> in= new ConcurrentLinkedDeque<>();
    private boolean shutdown= false;
	
	public Service(GraphDatabaseService db) {
		this.db= db;
	}

	public Service(GraphDatabaseService db, int sleepinterval) {
		this.db= db;
		this.sleepinterval= sleepinterval;
	}	
		
	public void shutdown() {
		this.shutdown= true;
	}
	
	@Override
	public void run() {
		for(;;) {
			try {
				synchronized(this) {
					wait(sleepinterval);
				}
				if (shutdown)
					return;
				dosomething();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected abstract void dosomething();

	public void focus(Node node) {
		in.add(node);
		synchronized(this) {
			notify();
		}
	}
}
