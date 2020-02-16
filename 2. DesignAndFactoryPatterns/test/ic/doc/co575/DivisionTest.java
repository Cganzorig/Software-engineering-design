package ic.doc.co575;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class DivisionTest {

  @Test
  public void evaluate_WholeDivision() {
    Division a = new Division(new NaturalNumber(6), new NaturalNumber(2));
    int expectedOutput = 3;
    int output = a.evaluate();
    final String errorMsg = String.format("Problem dividing 6 by 2: %s", a);
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }

  @Test
  public void evaluate_NonWholeDivision() {

    Division a = null;
    try {
      a = new Division(new NaturalNumber(6), new NaturalNumber(5));
    } catch (NonWholeNumber e) {
      return; // Exception raised is correct.
    }
    fail("Creating a division 6/5 should generate a NonWholeNumber exception");
  }

  @Test
  public void evaluate_NestedDivision() {
    Division l = new Division(new NaturalNumber(18), new NaturalNumber(3));
    Division r = new Division(new NaturalNumber(20), new NaturalNumber(10));
    Division a = new Division(l, r);

    int expectedOutput = 3;
    int output = a.evaluate();
    final String errorMsg = String.format("Problem dividing: %s", a);
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }

  @Test
  public void evaluate_NestedExpressions() {
    Expression l = new Division(new NaturalNumber(12), new NaturalNumber(2));
    Expression r = new Addition(new NaturalNumber(1), new NaturalNumber(1));
    Division a = new Division(l, r);

    int expectedOutput = 3;
    int output = a.evaluate();
    final String errorMsg = String.format("Problem dividing: %s", a);
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }
}
