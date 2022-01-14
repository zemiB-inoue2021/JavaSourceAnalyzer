package zemib.inoue.javasourceanalyzer;

import java.util.ArrayList;
import java.util.List;

public class Enum extends MethodedNode{
	private String name;
	private List<String> values = new ArrayList<String>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}

	public void addValue(String value) {
		this.values.add(value);
	}

}
