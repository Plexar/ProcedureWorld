package eu.burbach.procedureworld.server.core;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

import eu.burbach.procedureworld.server.common.BuilderService;

public class Cleaner extends BuilderService {

	public Cleaner(GraphDatabaseService db, Builder builder) {
		super(db,builder);
		this.start();		
	}

	@Override
	protected void dosomething() {
		
	}
}
