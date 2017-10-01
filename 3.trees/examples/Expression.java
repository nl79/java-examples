

class Node {
  Node left;
  Node right;

  char val;

  public Node() { }

  public double value() throws Exception {
    return this.val;
  }

  public void draw(int show, int curr, char c) {

    if(show == curr) {
      System.out.print(c + "( " + this.val + " )");
    }

    if(this.left != null) {
      this.left.draw(show, curr+1, 'L');
    }

    if(this.right != null) {
      this.right.draw(show, curr+1, 'R');
    }
  }

  public void draw() throws Exception {

    System.out.println("( " + this.val + " )");

    if(this.left != null) {
      this.left.draw();
    }

    if(this.right != null) {
      this.right.draw();
    }

  }
}

class Factor extends Expression {
  public static Expression Tree(Pipe p) throws Exception {
     char c = p.peek();
     if ( Character.isDigit(c) ) {
         return new Digit(p.next());
     }
     else if ( c == '(' ) {
       p.next();
       Expression exp = Expression.Tree(p);

       if ( p.peek() != ')' ) {
           throw new Exception("Missing closing parenthesis.");
       }

       p.next();
       return exp;
     }
     else {
       switch(c) {
         case '+':
         case '-':
         case '*':
         case '/':
            throw new Exception("Unexpected operator encountered");
         case '\n':
            throw new Exception("Unexpected end of line");
         default:
            throw new Exception("Unexpected token '" + c + "'");
       }
     }
  }
}

class Term extends Expression {
  public static Expression Tree(Pipe p) throws Exception {

      Expression term;
      term = Factor.Tree(p);

      while ( p.peek() == '*' || p.peek() == '/' ) {

          term = new Operator(p.next(),term,Factor.Tree(p));
      }
      return term;
  }
}

public class Expression extends Node {
  public static Expression Tree(Pipe p) throws Exception {

    Expression exp = Term.Tree(p);

    while ( p.peek() == '+' || p.peek() == '-' ) {
        exp = new Operator(p.next(), exp, Term.Tree(p));
    }
    return exp;
  }
  public Expression() {
  }
}

class Operator extends Expression{

  // Valid Operators.
  String operators = "+-*/";

  public Operator(char op, Expression left, Expression right) throws Exception  {

    if(this.operators.indexOf(op) == -1) {
      throw new Exception("Invalid Operator Supplied");
    }

    if(left == null || right == null) {
      throw new Exception("Expression nodes cannot be null");

    }

    this.val = op;
    this.left = left;
    this.right = right;
  }

  @Override
  public double value() throws Exception {
     double x = left.value();
     double y = right.value();
     switch (this.val) {
       case '+':
        return x + y;
       case '-':
        return x - y;
       case '*':
        return x * y;
       case '/':
        return x / y;
       default:
        throw new Exception("Invalid Arithmetic Operator.");
     }
  }
}

class Digit extends Expression {
  public Digit(char d){
    this.val = d;
  }

  @Override
  public double value() {
    try {
      return Double.parseDouble(Character.toString(this.val));
    } catch(Exception e) {
      return 0;
    }

  }
}
