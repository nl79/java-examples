

class Node {
  Node left;
  Node right;

  String val;

  public Node() { }

  public double value() throws Exception {
    return Double.parseDouble(this.val);
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
  public static Expression Parse(Pipe p) throws Exception {
    /* <factor> ::= <digit> | (<expression>) */
     char token;
     String number = "";

     while(true) {
       token = p.peek();
       // Check if <digit>
       if ( Character.isDigit(token) ) {
           number += token;
           p.next();
       } else {
         break;
       }
     }

     // Check if <digit>
     if ( Digit.isInteger(number) ) {
       //p.next();
         return new Digit(number);
     }

     // Check if '(' followed by an <expression> followed by a ')'
     else if ( token == '(' ) {
       p.next();
       Expression exp = Expression.Parse(p);

       if ( p.peek() != ')' ) {
           throw new Exception("Missing closing parenthesis.");
       }

       p.next();
       return exp;
     }
     else {
        // Invalid token.
        throw new Exception("Unexpected token '" + token + "'");
     }
  }
}

class Term extends Expression {
  public static Expression Parse(Pipe p) throws Exception {

      Expression term = Factor.Parse(p);
      
      /*
       * Check if the term is followed by '*' or '/'
       * if so, create an Operator node and supply the left and right children.
       */
      while ( p.peek() == '*' || p.peek() == '/' ) {

          term = new Operator(p.nextToken(),term,Factor.Parse(p));
      }
      return term;
  }
}

public class Expression extends Node {
  public static Expression Parse(Pipe p) throws Exception {

    /* <expression> ::= <term> + <expression> | <term> - <expression> | <term> */

    //Get the term.
    Expression term = Term.Parse(p);


    /*
     * Check if the term is followed by '+' or '-'
     * if so, create an Operator node and supply the left and right children.
     */
    while ( p.peek() == '+' || p.peek() == '-' ) {
        term = new Operator(p.nextToken(), term, Term.Parse(p));
    }

    // Return the <term>
    return term;
  }
  public Expression() {
  }
}

class Operator extends Expression{

  // Valid Operators.
  String operators = "+-*/";

  public Operator(String op, Expression left, Expression right) throws Exception  {

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
     switch (this.val.charAt(0)) {
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

  public static boolean isInteger(String s) {
    try {
        Integer.parseInt(s);
    } catch(NumberFormatException e) {
        return false;
    } catch(NullPointerException e) {
        return false;
    }
    // only got here if we didn't return false
    return true;
  }

  public Digit(String d){
    this.val = d;
  }

  @Override
  public double value() {
    try {
      return Double.parseDouble(this.val);
    } catch(Exception e) {
      return 0;
    }
  }
}
