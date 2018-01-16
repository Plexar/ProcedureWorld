package eu.burbach.procedureworld.server.core;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

import eu.burbach.procedureworld.server.common.BuilderService;

public class Strategy extends BuilderService {
    private Rules rules;
    private Values values;
    private Set<Node> working= new HashSet<>();
	
	public Strategy(GraphDatabaseService db, Builder builder) {
		super(db,builder);
		this.start();
	}

	public void neighbours(Rules rules, Values values) {
		this.rules= rules;
		this.values= values;
	}

	@Override
	protected void dosomething() {
		Node current= in.poll();
		while (current!=null) {
			
			current= in.poll();
		}
	}
}
