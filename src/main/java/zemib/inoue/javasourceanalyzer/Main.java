package zemib.inoue.javasourceanalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;

public class Main {
	public static void main(String[] args) {
		Path sourcedir = Paths.get("../enshud/src/main/java/enshud/");
		ParseData parsedata = new ParseData();

		try {

			try (Stream<Path> stream = Files.walk(sourcedir)) {
				stream.filter(Files::isRegularFile).forEach(p -> {
					JavaParser parser = new JavaParser();
					ParseResult<CompilationUnit> result;
					try {
						result = parser.parse(p);
						ZemiBVoidVisitor zemibvoidvisitor = new ZemiBVoidVisitor();
						result.getResult().ifPresent(r -> r.accept(zemibvoidvisitor, null));
						Package packagedata = parsedata.getPackage(zemibvoidvisitor.getPackage());
						zemibvoidvisitor.getClasses().forEach(c -> packagedata.addClass(c));
						zemibvoidvisitor.getInterfaces().forEach(c -> packagedata.addInterface(c));
						zemibvoidvisitor.getEnums().forEach(c -> packagedata.addEnum(c));
					} catch (IOException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				});
			} catch (IOException e) {
				System.out.println(e);
			}

			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(parsedata);
			System.out.println(json);

		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
	}
}
