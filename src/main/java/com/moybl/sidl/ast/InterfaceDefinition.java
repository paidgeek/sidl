package com.moybl.sidl.ast;

import com.moybl.sidl.Position;

import java.util.ArrayList;
import java.util.List;

public class InterfaceDefinition extends Definition {

  private Identifier name;
  private List<Field> fields;
  private Identifier parent;
  private List<InterfaceDefinition> parentPath;
  private InterfaceDefinition parentDefinition;
  private List<Definition> children;

  public InterfaceDefinition(Position position, Identifier name, Identifier parent, List<Field> fields) {
    super(position);
    this.name = name;
    this.parent = parent;
    this.fields = fields;
    children = new ArrayList<Definition>();
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public Identifier getName() {
    return name;
  }

  public Identifier getParent() {
    return parent;
  }

  public boolean hasChildren() {
    return children.size() != 0;
  }

  public List<Definition> getChildren() {
    return children;
  }

  public void setChildren(List<Definition> children) {
    this.children = children;
  }

  public InterfaceDefinition getParentDefinition() {
    return parentDefinition;
  }

  public void setParentDefinition(InterfaceDefinition parentDefinition) {
    this.parentDefinition = parentDefinition;

    parentPath = new ArrayList<InterfaceDefinition>();

    do {
      parentPath.add(parentDefinition);

      if (parentDefinition.getParentDefinition() != null) {
        parentDefinition = parentDefinition.getParentDefinition();
      } else {
        parentDefinition = null;
      }
    } while (parentDefinition != null);
  }

  public List<InterfaceDefinition> getParentPath() {
    return parentPath;
  }

  public String getDefinedName() {
    return name.getCanonicalName();
  }

  public List<Field> getFields() {
    return fields;
  }

}
