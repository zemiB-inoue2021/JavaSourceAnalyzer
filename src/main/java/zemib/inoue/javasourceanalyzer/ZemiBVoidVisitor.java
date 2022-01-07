package zemib.inoue.javasourceanalyzer;

import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class ZemiBVoidVisitor extends VoidVisitorAdapter<String> {
	
	@Override
	public void visit(VariableDeclarator n, String arg) {
		super.visit(n, arg);
	}

	@Override
	public void visit(PackageDeclaration n, String arg) {
		super.visit(n, arg);
	}

	@Override
	public void visit(ClassOrInterfaceDeclaration n, String arg) {
		super.visit(n, arg);
	}

	@Override
	public void visit(MethodDeclaration n, String arg) {
		super.visit(n, arg);
	}
	
	@Override
	public void visit(ConstructorDeclaration n, String arg) {
		super.visit(n, arg);
	}
	
	@Override
	public void visit(FieldDeclaration n, String arg) {
		super.visit(n, arg);
	}
}
