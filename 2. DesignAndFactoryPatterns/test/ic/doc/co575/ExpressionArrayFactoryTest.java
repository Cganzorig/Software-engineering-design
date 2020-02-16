package ic.doc.co575;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ExpressionArrayFactoryTest {

  @Test
  public void randomArray() {
    final int size = 4;
    final int maxDepth = 3;

    Expression[] exps = ExpressionArrayFactory.randomExpressionArray(size, maxDepth);

    assertThat("Incorrect array size", exps.length, is(size));
    int i = 1;
    while (i < size) {
      if (exps[i].evaluate() < exps[i - 1].evaluate()) {
        String errorMsg =
            String.format(
                "Array not ordered. "
                    + "position %d contains %s which evaluates to %d while "
                    + "position %d contains %s which evaluates to %d",
                i - 1, exps[i - 1], exps[i - 1].evaluate(), i, exps[i], exps[i].evaluate());
        fail(errorMsg);
      }
      i++;
    }
  }
}
