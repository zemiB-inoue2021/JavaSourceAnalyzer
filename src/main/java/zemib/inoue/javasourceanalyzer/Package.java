package zemib.inoue.javasourceanalyzer;

import java.util.ArrayList;
import java.util.List;

public class Package extends NamedNode {

	private List<ClassorInterface> classes = new ArrayList<ClassorInterface>();
	private List<ClassorInterface> interfaces = new ArrayList<ClassorInterface>();
	private List<Enum> enums = new ArrayList<Enum>();

	Package(){
		
	}
	
	Package(String name){
		this.name = name;
	}
	
	public List<ClassorInterface> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassorInterface> classes) {
		this.classes = classes;
	}

	public void addClass(ClassorInterface c) {
		this.classes.add(c);
	}

	public List<ClassorInterface> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(List<ClassorInterface> interfaces) {
		this.interfaces = interfaces;
	}

	public void addInterface(ClassorInterface i) {
		this.interfaces.add(i);
	}

	public List<Enum> getEnums() {
		return enums;
	}

	public void setEnums(List<Enum> enums) {
		this.enums = enums;
	}

	public void addEnum(Enum e) {
		this.enums.add(e);
	}

}
