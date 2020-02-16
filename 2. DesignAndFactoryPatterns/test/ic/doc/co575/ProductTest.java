package ic.doc.co575;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class ProductTest {

  @Test
  public void evaluate_TwoNumbers() {
    Product a = new Product(new NaturalNumber(3), new NaturalNumber(4));
    int expectedOutput = 12;
    int output = a.evaluate();
    final String errorMsg = String.format("Problem multiplying two natural numbers: %s.", a);
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }

  @Test
  public void evaluate_NestedProducts() {
    Product a = new Product(new NaturalNumber(3), new NaturalNumber(4));
    Product b = new Product(new NaturalNumber(1), new NaturalNumber(5));
    Product c = new Product(a, b);

    int expectedOutput = 60;
    int output = c.evaluate();
    final String errorMsg =
        String.format("Problem multiplying nested products of natural numbers: %s.", c);
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }

  @Test
  public void evaluate_NestedUnbalancedProducts() {
    Product a = new Product(new NaturalNumber(1), new NaturalNumber(1));
    Product b = new Product(new NaturalNumber(1), a);
    Product c = new Product(new NaturalNumber(1), b);
    Product d = new Product(new NaturalNumber(1), c);

    int expectedOutput = 1;
    int output = d.evaluate();
    final String errorMsg = "Problem adding unbalanced nesting of products" + d + ".";
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }

  @Test
  public void getLeft() {
    Product a = new Product(new NaturalNumber(2), new NaturalNumber(2));
    Product b = new Product(new NaturalNumber(2), a);
    Product c = new Product(new NaturalNumber(2), b);
    Product d = new Product(new NaturalNumber(2), c);

    int expectedOutput = 2;
    int output = d.getLeft().evaluate();
    final String errorMsg = "Problem evaluating getLeft of " + d;
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }

  @Test
  public void getRight() {
    Product a = new Product(new NaturalNumber(2), new NaturalNumber(2));
    Product b = new Product(new NaturalNumber(2), a);
    Product c = new Product(new NaturalNumber(2), b);
    Product d = new Product(new NaturalNumber(2), c);

    int expectedOutput = 16;
    int output = d.getRight().evaluate();
    final String errorMsg = "Problem evaluating getRight of " + d;
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }
}
