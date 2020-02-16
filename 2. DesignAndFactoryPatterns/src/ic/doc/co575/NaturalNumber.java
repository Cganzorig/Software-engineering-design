package ic.doc.co575;

public class NaturalNumber implements Expression {

  private final int value;

  public NaturalNumber(int val) {
    if (val <= 0) {
      throw new IllegalArgumentException(val + " is not a natural number (i.e., positive integer)");
    }
    value = val;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @Override
  public int evaluate() {
    return this.value;
  }

  @Override
  public int depth() {
    return 0;
  }

  @Override
  public int compareTo(Expression other) {
    if (this.evaluate() < other.evaluate()) {
      return -1;
    } else if (this.evaluate() > other.evaluate()) {
      return 1;
    } else {
      return 0;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof NaturalNumber) {
      return ((NaturalNumber) o).value == this.value;
    } else {
      return false;
    }

  }

}
