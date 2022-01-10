package zemib.inoue.javasourceanalyzer;

public class Param extends NamedNode {

	private String type;

	Param(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
