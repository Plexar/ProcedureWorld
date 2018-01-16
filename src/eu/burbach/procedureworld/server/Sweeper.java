package eu.burbach.procedureworld.server;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.neo4j.graphdb.GraphDatabaseService;

import eu.burbach.procedureworld.server.common.Service;
import eu.burbach.procedureworld.server.core.World;

public class Sweeper extends Service {
	private Queue<String> in = new ConcurrentLinkedDeque<String>();
	private Queue<String> out = new ConcurrentLinkedDeque<String>();
	private World world= new World(out);

	public Sweeper() {
		super(null);
	}

	public void put(String s) {
		in.add(s);
	}
	
	public String poll() {
		return out.poll();
	}
	
	public synchronized void ende() {
		world.shutdown();
		this.shutdown();
	}
	
	private void parse(String s) {
		world.userCommand(s);
	}
	
	protected void dosomething() {
		if (!in.isEmpty()) {
			String s = in.poll();
			parse(s);
		}
	}
}
