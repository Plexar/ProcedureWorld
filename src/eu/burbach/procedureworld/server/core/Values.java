package eu.burbach.procedureworld.server.core;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

import eu.burbach.procedureworld.server.common.BuilderService;

public class Values extends BuilderService {
    private Strategy strategy;
    private Rules rules;
    private Set<Node> yes= new HashSet<>();
    private Set<Node> no= new HashSet<>();
	
	public Values(GraphDatabaseService db, Builder builder) {
		super(db,builder);
		this.start();		
	}

	public void neighbours(Strategy strategy, Rules rules) {
		this.strategy= strategy;
		this.rules= rules;
	}

	@Override
	protected void dosomething() {
		Node current= in.poll();
		while (current!=null) {
			//wenn current in yes oder LINKED mit yes: value++
			//wenn current in no oder LINKED mit no: value--
			current= in.poll();
		}
	}
}
