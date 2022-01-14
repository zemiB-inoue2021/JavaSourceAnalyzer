package zemib.inoue.javasourceanalyzer;

import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.WhileStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class ZemiBVoidVisitor extends VoidVisitorAdapter<String> {

	private String packagename;
	private MethodedNode currentnode;
	private Method currentmethod;
	private List<ClassorInterface> classes = new ArrayList<ClassorInterface>();
	private List<ClassorInterface> interfaces = new ArrayList<ClassorInterface>();
	private List<Enum> enums = new ArrayList<Enum>();

	@Override
	public void visit(PackageDeclaration n, String arg) {
		this.packagename = n.getNameAsString();
		super.visit(n, arg);
	}

	@Override
	public void visit(ClassOrInterfaceDeclaration n, String arg) {
		ClassorInterface classorinterface = new ClassorInterface();
		classorinterface.setName(n.getNameAsString());
		if (n.isInterface()) {
			interfaces.add(classorinterface);
		} else {
			classes.add(classorinterface);
		}
		currentnode = classorinterface;
		super.visit(n, arg);
	}

	@Override
	public void visit(MethodDeclaration n, String arg) {
		Method method = new Method();
		method.setName(n.getNameAsString());
		method.setReturnType(n.getTypeAsString());
		n.getParameters()
				.forEach(param -> method.addParam(new Param(param.getNameAsString(), param.getTypeAsString())));
		// TODO メトリクス計算
		int startline = n.getBegin().get().line;
		int endline = n.getEnd().get().line;
		method.setLoc(endline - startline + 1);
		method.setCyclo(0);
		currentnode.addMethod(method);
		currentmethod = method;
		super.visit(n, arg);
	}

	@Override
	public void visit(EnumDeclaration n, String arg) {
		Enum e = new Enum();
		e.setName(n.getNameAsString());
		n.getEntries().forEach(entry -> e.addValue(entry.getNameAsString()));
		enums.add(e);
		currentnode = e;
		super.visit(n, arg);
	}

	@Override
	public void visit(IfStmt n, String arg) {
		currentmethod.incCyclo();
		super.visit(n, arg);
	}

	@Override
	public void visit(WhileStmt n, String arg) {
		currentmethod.incCyclo();
		super.visit(n, arg);
	}

	@Override
	public void visit(ForStmt n, String arg) {
		currentmethod.incCyclo();
		super.visit(n, arg);
	}

	@Override
	public void visit(ConstructorDeclaration n, String arg) {
		super.visit(n, arg);
	}

	public List<ClassorInterface> getClasses() {
		return classes;
	}

	public List<ClassorInterface> getInterfaces() {
		return interfaces;
	}

	public List<Enum> getEnums() {
		return enums;
	}

	public String getPackage() {
		return packagename;
	}
}
