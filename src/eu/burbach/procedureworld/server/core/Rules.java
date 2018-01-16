package eu.burbach.procedureworld.server.core;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

import eu.burbach.procedureworld.server.common.BuilderService;

public class Rules extends BuilderService {
    private Strategy strategy;
    private Values values;
	
	public Rules(GraphDatabaseService db, Builder builder) {
		super(db,builder);
		this.start();		
	}
	
	public void neighbours(Strategy strategy, Values values) {
		this.strategy= strategy;
		this.values= values;
	}

	@Override
	protected void dosomething() {
	}
}
