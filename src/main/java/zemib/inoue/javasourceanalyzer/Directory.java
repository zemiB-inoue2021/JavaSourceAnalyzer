package zemib.inoue.javasourceanalyzer;

import java.util.List;

public class Directory extends Node {
	public String name;
	public List<Node> children;

	public void addChild(Node n) {
		children.add(n);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
