package com.moybl.sidl.ast;

import com.moybl.sidl.Position;

import java.util.List;

public class Schema extends Node {

	private List<Definition> definitions;

	public Schema(Position position, List<Definition> definitions) {
		super(position);
		this.definitions = definitions;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public List<Definition> getDefinitions() {
		return definitions;
	}

}