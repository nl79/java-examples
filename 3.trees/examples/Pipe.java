class Pipe {
  String s;
  int nextPos = 0;
  char current;

  final int TAB = 9;
  final int SPACE = 32;

  boolean ignoreEmpty = true;

  public Pipe(String s) {
    this.s = s;
  }

  public boolean hasNext() {
    return (this.nextPos) < this.s.length();
  }

  // Get the next token.
  public char next() throws Exception {
    return (char)this.next(1);

  }

  // Get the next token at position i.
  public char next(int i) throws Exception {
    char next;

    if(this.ignoreEmpty) {
      for(int k = this.nextPos; k < this.s.length(); ++k) {
        next = this.nextChar();
        if(this.isBlank(next)) {
          continue;
        }
        return next;
      }
    }

    return this.nextChar();
  }

  private char nextChar() throws Exception {
    if(this.hasNext()) {
      this.current = this.s.charAt(this.nextPos);
      this.nextPos = this.nextPos + 1;
      return current;
    } else {
      throw new Exception("End of input reached");
    }
  }

  // Look ahead 1 token.
  public char peek() {
    return this.peek(1);
  }

  // Look ahead n tokens.
  public char peek(int n) {
    char temp = this.current;
    char c;
    int tempPos = this.nextPos;

    int pos = this.nextPos + n;

    try {
      c = this.next();
      this.current = temp;
      this.nextPos = tempPos;

      return c;
    } catch(Exception e) {
      return '\0';
    }
  }

  private boolean isBlank(char c) {
    int code = (int)c;
    return (code == this.TAB || code == this.SPACE);
  }

  public void ignoreEmpty(boolean b) {
    this.ignoreEmpty = b;
  }
}
