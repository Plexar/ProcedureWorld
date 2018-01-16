package eu.burbach.procedureworld.server.common;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

import eu.burbach.procedureworld.server.core.Builder;

public abstract class BuilderService extends Service {

    protected Builder builder;
	
	public BuilderService(GraphDatabaseService db, Builder builder) {
		super(db);
		this.builder= builder;
	}
	
	public BuilderService(GraphDatabaseService db, int sleepinterval, Builder builder) {
		super(db, sleepinterval);
		this.builder= builder;
	}
}
