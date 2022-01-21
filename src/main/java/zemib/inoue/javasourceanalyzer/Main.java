package zemib.inoue.javasourceanalyzer;

import java.io.Console;
import java.io.FileWriter;
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
		// 解析対象ディレクトリが指定されていなければエラー
		if(args.length != 1){
			System.exit(1);
			return;
		}

		Path sourcedir = Paths.get(args[0]);
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
						zemibvoidvisitor.getClasses().forEach(packagedata::addClass);
						zemibvoidvisitor.getInterfaces().forEach(packagedata::addInterface);
						zemibvoidvisitor.getEnums().forEach(packagedata::addEnum);
					} catch (IOException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				});
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
				return;
			}

			// 解析結果のJSONを標準出力に出力
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(parsedata);
			System.out.println(json);

		} catch (IOException e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}
}
