package zemib.inoue.javasourceanalyzer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;

public class Main {
	public static void main(String[] args) {
		Path source = Paths.get("src/main/java/zemib/inoue/javasourceanalyzer/Main.java");
		ParseData parsedata = new ParseData();
		Package packagedata = new Package();
		try {
			JavaParser parser = new JavaParser();
			ParseResult<CompilationUnit> result = parser.parse(source);
			ZemiBVoidVisitor zemibvoidvisitor = new ZemiBVoidVisitor();
			result.getResult().ifPresent(r -> r.accept(zemibvoidvisitor, null));
			ObjectMapper mapper = new ObjectMapper();
			zemibvoidvisitor.getClasses().forEach(c -> packagedata.addClass(c));
			parsedata.addPackage(packagedata);
			String json = mapper.writeValueAsString(parsedata);
			System.out.println(json);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
	}
}
