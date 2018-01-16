package eu.burbach.procedureworld.server.core;

import java.util.Queue;

import org.neo4j.graphdb.GraphDatabaseService;

import eu.burbach.procedureworld.server.common.BuilderService;

public class Logger extends BuilderService {

	private Queue<String> out;
	
	public Logger(GraphDatabaseService db, Builder builder, Queue<String> out) {
		super(db,builder);
		this.out= out;
		this.start();
	}

	@Override
	protected void dosomething() {
		//für alle mit Ausgabe LINKED: wenn in strategy working set:
		// dann append out und lösche LINKED
	}
}
