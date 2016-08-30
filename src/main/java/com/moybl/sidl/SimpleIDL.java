package com.moybl.sidl;

import com.moybl.sidl.ast.Schema;
import com.moybl.sidl.semantics.NameChecker;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class SimpleIDL {

	public static Schema parse(InputStream inputStream) {
		Lexer lexer = new Lexer(inputStream);
		Parser parser = new Parser(lexer);
		Schema schema = parser.parse();
		schema.accept(new NameChecker());

		return schema;
	}

	public static Schema parse(String source) {
		return parse(new ByteArrayInputStream(source.getBytes()));
	}

}