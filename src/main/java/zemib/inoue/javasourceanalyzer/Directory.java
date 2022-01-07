package zemib.inoue.javasourceanalyzer;

import java.util.HashMap;

public class Directory extends Node {
	private HashMap<String, Node> nodemap;

	public void putNodeMap(String s, Node n) {
		nodemap.put(s, n);
	}
	

}
