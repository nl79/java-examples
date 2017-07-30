class Counter {

  private String name = null;
  private int value;

  Counter(String str) {
    this.name = str;
  }

  public void increment () {
    value++;
  }

  public int getCurrentValue() {
    return this.value;
  }

  public String toString() {
    return name + ": " + this.value;
  }
}