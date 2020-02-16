package ic.doc.co575;

import java.util.Arrays;

public class ExpressionArrayFactory {
    public static Expression[] randomExpressionArray(int maxSize, int maxDepth) {
        ExpressionFactory factory = new ExpressionFactory();
        Expression[] result = new Expression[maxSize];
        for (int i = 0; i < maxSize; i++) {
            result[i] = factory.randomExpression(maxDepth);
        }
        Arrays.sort(result);
        return result;
    }
}
