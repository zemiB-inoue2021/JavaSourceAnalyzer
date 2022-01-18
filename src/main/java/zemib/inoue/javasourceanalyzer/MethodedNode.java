package zemib.inoue.javasourceanalyzer;

import java.util.ArrayList;
import java.util.List;

public class MethodedNode extends NamedNode {
	protected List<Method> methods = new ArrayList<Method>();
	protected List<Constructor> constructors = new ArrayList<Constructor>();

	public List<Method> getMethods() {
		return methods;
	}

	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}

	public void addMethod(Method method) {
		this.methods.add(method);
	}

	public List<Constructor> getConstructors() {
		return constructors;
	}

	public void setConstructors(List<Constructor> constructors) {
		this.constructors = constructors;
	}

	public void addConstructor(Constructor constructor) {
		this.constructors.add(constructor);
	}
}
