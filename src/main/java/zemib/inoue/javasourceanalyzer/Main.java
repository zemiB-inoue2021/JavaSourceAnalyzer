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

		try {
			JavaParser parser = new JavaParser();
			ParseResult<CompilationUnit> result = parser.parse(source);
			ZemiBVoidVisitor zemibvoidvisitor = new ZemiBVoidVisitor();
			result.getResult().ifPresent(r -> r.accept(zemibvoidvisitor, null));
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(zemibvoidvisitor.getClasses());
			System.out.println(json);
			for(int i=0; i<1; i++) {
				
			}
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
	}
}
