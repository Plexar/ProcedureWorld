package eu.burbach.procedureworld.server;

import java.util.Queue;

public class World {

	private Queue<String> out;
	
	public World(Queue<String> out) {
		this.out= out;
	}
	
	public void clear() {
		
	}

	public void userCommand(String in) {
		if (in==null)
			return;
		if (!in.toLowerCase().endsWith(".txt")) {
			out.add("'"+in+"' ignoriert (verstehe ich noch nicht)");
			return;
		}
		
	}
	
	private void readFile(String path) {
		
	}
	
	private void writeFile(String name, String path) {
		
	}
}
