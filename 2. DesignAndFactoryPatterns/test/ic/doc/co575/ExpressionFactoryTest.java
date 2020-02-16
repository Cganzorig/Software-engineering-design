package ic.doc.co575;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

public class ExpressionFactoryTest {

  @Test
  public void randomExpression_Depth0() {
    for (int i = 0; i < 10; i++) {
      Expression e = null;
      final String errorMsg = "Problem creating random expression of depth 0:";
      try {
        e = ExpressionFactory.randomExpression(0);
      } catch (Exception e1) {
        fail(errorMsg + e1);
      }
      assertThat(errorMsg, e, isWholeNumber());
      assertThat(String.format("Depth incorrectly reported for %s.", e), e.depth(), is(0));
    }
  }

  @Test
  public void randomExpression_MaxDepth() {
    final int depth = 5;
    for (int i = 0; i < 400; i++) {
      Expression e = null;
      try {
        e = ExpressionFactory.randomExpression(depth);
      } catch (Exception e1) {
        fail("Something went wrong when building an expression." + e1);
      }
      if (e.depth() > depth) {
        fail("Expression of depth " + e.depth() + " deeper than it should be: " + depth + "." + e);
      }
    }
  }

  @Test
  public void randomExpression_EqualDepth2() {
    int i = 0;
    boolean found = false;
    Expression e = null;
    int expectedDepth = 3;
    int attempts = 500;
    while (i < attempts && !found) {
      e = ExpressionFactory.randomExpression(expectedDepth);
      int depth = e.depth();
      found = (depth == expectedDepth);
      i++;
    }
    assertThat(
        "Couldn't build an expression of depth "
            + expectedDepth
            + " in "
            + attempts
            + " attempts. Unlucky?",
        e.depth(),
        is(expectedDepth));
  }

  @Test
  public void checkEquals() {
    Expression e = ExpressionFactory.randomExpression(3);
    Expression f = new Subtraction(new Addition(e, new NaturalNumber(1)), new NaturalNumber(1));

    assertThat(
        String.format("Expressions %s and %s should be equal according to equals()", e, f),
        e.equals(f));
  }

  private Matcher<Expression> isWholeNumber() {
    return new BaseMatcher<Expression>() {
      @Override
      public boolean matches(final Object e) {
        final Expression exp = (Expression) e;
        return (exp instanceof NaturalNumber);
      }

      @Override
      public void describeTo(final Description description) {
        description.appendText("A whole number");
      }
    };
  }
}
