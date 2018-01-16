package eu.burbach.procedureworld.server.core;

import java.io.File;
import java.util.Queue;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class World {

	private Queue<String> out;
	private GraphDatabaseService db;
	private Builder builder;
	private Cleaner cleaner;
	private Logger logger;
	private Strategy strategy;
	private Values values;
	private Rules rules;
	
	private static enum RelTypes implements RelationshipType
	{
	    LINKED
	}
	
	public World(Queue<String> out) {
		this.out= out;
		db = new GraphDatabaseFactory().newEmbeddedDatabase( new File(".") );
		registerShutdownHook( db );	
		builder= new Builder(db);
		cleaner= new Cleaner(db,builder);
		logger= new Logger(db,builder,out);
		strategy= new Strategy(db,builder);
		values= new Values(db,builder);
		rules= new Rules(db,builder);
		strategy.neighbours(rules, values);
		values.neighbours(strategy, rules);
		rules.neighbours(strategy, values);
	}
	
	private static void registerShutdownHook( final GraphDatabaseService graphDb )
	{
	    // Registers a shutdown hook for the Neo4j instance so that it
	    // shuts down nicely when the VM exits (even if you "Ctrl-C" the
	    // running application).
	    Runtime.getRuntime().addShutdownHook( new Thread()
	    {
	        @Override
	        public void run()
	        {
	            graphDb.shutdown();
	        }
	    } );
	}
	
	public void shutdown() {
		builder.shutdown();
		cleaner.shutdown();
		logger.shutdown();
		strategy.shutdown();
		rules.shutdown();
		values.shutdown();
	}
	
	public void userCommand(String in) {
		if (in==null)
			return;
	}
	
	private void cmd_clear() {
	}
	
	private void cmd_scan(Node node) {
		
	}

	private void cmd_readFile(String path) {
		
	}
	
	private void cmd_writeFile(String name, String path) {
		
	}
}
