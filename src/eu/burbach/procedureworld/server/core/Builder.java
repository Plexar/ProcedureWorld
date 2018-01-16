package eu.burbach.procedureworld.server.core;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

import eu.burbach.procedureworld.server.common.Service;

public class Builder extends Service {

	public Builder(GraphDatabaseService db) {
		super(db);
		this.start();
	}

	@Override
	protected void dosomething() {
		
	}	
}
