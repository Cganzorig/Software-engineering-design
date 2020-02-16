package ic.doc.co575;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SubtractionTest {

  @Test
  public void evaluate_TwoNumbers() {
    Subtraction a = new Subtraction(new NaturalNumber(4), new NaturalNumber(3));
    int expectedOutput = 1;
    int output = a.evaluate();
    final String errorMsg = "Problem subtracting " + a;
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }

  @Test
  public void evaluate_NestedSubtractions() {
    Subtraction a = new Subtraction(new NaturalNumber(10), new NaturalNumber(6));
    Subtraction b = new Subtraction(new NaturalNumber(6), new NaturalNumber(5));
    Subtraction c = new Subtraction(a, b);

    int expectedOutput = 3;
    int output = c.evaluate();
    final String errorMsg = "Problem subtracting " + c;
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }

  @Test
  public void evaluate_NestedUnbalancedSubtractions() {
    Subtraction a = new Subtraction(new NaturalNumber(5), new NaturalNumber(3));
    Subtraction b = new Subtraction(new NaturalNumber(10), a);
    Subtraction c = new Subtraction(new NaturalNumber(20), b);
    Subtraction d = new Subtraction(c, new NaturalNumber(1));

    int expectedOutput = 11;
    int output = d.evaluate();
    final String errorMsg = "Problem subtracting " + d;
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }

  @Test
  public void getLeft() {
    Subtraction a = new Subtraction(new NaturalNumber(5), new NaturalNumber(3));
    Subtraction b = new Subtraction(new NaturalNumber(10), a);
    Subtraction c = new Subtraction(new NaturalNumber(20), b);
    Subtraction d = new Subtraction(c, new NaturalNumber(1));

    int expectedOutput = 12;
    int output = d.getLeft().evaluate();
    final String errorMsg = "Problem evaluating getLeft of " + d;
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }

  @Test
  public void getRight() {
    Subtraction a = new Subtraction(new NaturalNumber(5), new NaturalNumber(3));
    Subtraction b = new Subtraction(new NaturalNumber(10), a);
    Subtraction c = new Subtraction(new NaturalNumber(20), b);
    Subtraction d = new Subtraction(c, new NaturalNumber(1));

    int expectedOutput = 1;
    int output = d.getRight().evaluate();
    final String errorMsg = "Problem evaluating getLeft of " + d;
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }

  @Test
  public void evaluate_Zero() {
    try {
      new Subtraction(new NaturalNumber(6), new NaturalNumber(6));
      fail("Creating 6-6 should generate a NonPositiveNumbers exception");
    } catch (NonPositiveNumber e) {
      // expected
    }
  }

}
