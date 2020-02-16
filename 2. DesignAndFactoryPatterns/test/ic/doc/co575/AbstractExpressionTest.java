package ic.doc.co575;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class AbstractExpressionTest {

  @Test
  public void compareTo_equal() {

    Expression a = new Addition(new NaturalNumber(3), new NaturalNumber(4));
    Expression b = new Product(new NaturalNumber(1), new NaturalNumber(5));
    Expression c = new Product(a, b);
    Expression d = new Product(b, a);

    final String errorMsg =
        "Problem comparing two expressions that are equal:"
            + c
            + " and "
            + d
            + " which evaluate to "
            + c.evaluate()
            + " and "
            + d.evaluate();
    assertThat(errorMsg, d.compareTo(c), equalTo(0));
  }

  @Test
  public void compareTo_less() {

    Expression a = new Addition(new NaturalNumber(3), new NaturalNumber(4));
    Expression b = new Product(new NaturalNumber(1), new NaturalNumber(5));
    Expression c = new Product(a, b);

    Expression d = new Subtraction(a, b);

    final String errorMsg =
        "Problem comparing two expressions. The first should be less than the second: "
            + d
            + " and "
            + c
            + " which evaluate to "
            + d.evaluate()
            + " and "
            + c.evaluate();
    // compareTo returns negative if the object is less than the argument. i.e., d is less than c.
    if (d.compareTo(c) >= 0) {
      fail(errorMsg);
    }
  }
}
