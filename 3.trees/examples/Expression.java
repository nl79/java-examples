class Pipe {
  String s;
  int pos = 0;

  boolean ignoreEmpty = true;

  public Pipe(String s) {
    this.s = s;
  }

  public boolean hasNext() {
    return (this.pos + 1) < this.s.length();
  }

  // Get the next token.
  public char next() throws Exception {
    return (char)this.next(1);

  }

  // Get the next token at position i.
  public char next(int i) throws Exception {

    if(this.hasNext()) {
      this.pos = this.pos + 1;
      return this.s.charAt(pos);
    } else {
      throw new Exception("End of input reached");
    }
  }

  // Look ahead 1 token.
  public char peak() {
    return this.peak(1);
  }

  // Look ahead n tokens.
  public char peak(int n) {
    int pos = this.pos + n;
    if(pos < this.s.length()) {
      return this.s.charAt(pos);
    } else {
      return '\0';
    }
  }

  public void ignoreEmpty(boolean b) {
    this.ignoreEmpty = b;
  }
}

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
