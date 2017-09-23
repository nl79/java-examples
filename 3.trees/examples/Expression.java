class Node {
  public Node() {

  }

  // Return Subtree.
  public void getTree() {

  }

  private void parse(String exp) {
    // Read the next token.
    int pos = exp.indexOf(" ");
    String sub = exp.substring(0, pos);
  }

}

class Digit extends Node {

  double val;

  public Digit(double val) {
    this.val = val;
  }
}

class Term extends Node {
  public Term() {

  }
}

class Operator extends Node {
  String op;

  public Operator(String op) {
    this.op = op;
  }
}

public class Expression extends Node {
  String exp;

  public Expression(String exp) {
    this.exp = exp;

    this.parse(this.exp);
  }

}
