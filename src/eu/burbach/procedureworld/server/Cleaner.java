package eu.burbach.procedureworld.server;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class Cleaner extends Thread {

    private GraphDatabaseService db;
    private Queue<Node> in= new ConcurrentLinkedDeque<>();
    private boolean shutdown= false;
    private Builder builder;
	
	public Cleaner(GraphDatabaseService db, Builder builder) {
		this.db= db;
		this.builder= builder;
		this.start();		
	}

	public void shutdown() {
		this.shutdown= true;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		for(;;) {
			try {
				this.sleep(1000);
				if (shutdown)
					return;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void focus(Node node) {
		in.add(node);
	}
}
