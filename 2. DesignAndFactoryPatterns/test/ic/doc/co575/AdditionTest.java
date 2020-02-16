package ic.doc.co575;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class AdditionTest {

  @Test
  public void evaluate_TwoNumbers() {
    Addition a = new Addition(new NaturalNumber(3), new NaturalNumber(4));
    NaturalNumber n = new NaturalNumber(5);
    int expectedOutput = 7;
    int output = a.evaluate();
    final String errorMsg = String.format("Problem adding two whole numbers: %s", a);
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }

  @Test
  public void evaluate_NestedAdditions() {
    Addition a = new Addition(new NaturalNumber(3), new NaturalNumber(4));
    Addition b = new Addition(new NaturalNumber(1), new NaturalNumber(5));
    Addition c = new Addition(a, b);

    int expectedOutput = 13;
    int output = c.evaluate();
    final String errorMsg = String.format("Problem adding nested additions: %s", c);
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }

  @Test
  public void evaluate_NestedUnbalancedAdditions() {
    Addition a = new Addition(new NaturalNumber(1), new NaturalNumber(1));
    Addition b = new Addition(new NaturalNumber(1), a);
    Addition c = new Addition(new NaturalNumber(1), b);
    Addition d = new Addition(new NaturalNumber(1), c);

    int expectedOutput = 5;
    int output = d.evaluate();
    final String errorMsg = String.format("Problem adding an unbalanced nested addition %s ", d);
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }

  @Test
  public void getLeft() {
    Addition a = new Addition(new NaturalNumber(1), new NaturalNumber(1));
    Addition b = new Addition(new NaturalNumber(1), a);
    Addition c = new Addition(new NaturalNumber(1), b);
    Addition d = new Addition(new NaturalNumber(1), c);

    int expectedOutput = 1;
    int output = d.getLeft().evaluate();
    final String errorMsg =
        String.format("Problem adding getLeft of the following addition: %s", d);
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }

  @Test
  public void getRight() {
    Addition a = new Addition(new NaturalNumber(1), new NaturalNumber(1));
    Addition b = new Addition(new NaturalNumber(1), a);
    Addition c = new Addition(new NaturalNumber(1), b);
    Addition d = new Addition(new NaturalNumber(1), c);

    int expectedOutput = 4;
    int output = d.getRight().evaluate();
    final String errorMsg = String.format("Problem evaluating getRight of addition: %s", d);
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }
}
