package ic.doc.co575;

import java.util.Random;

public class ExpressionFactory {
    public static Expression randomExpression(int maxDepth) {
        Random random = new Random();
        if (maxDepth == 0) {
            return new NaturalNumber(random.nextInt(9) + 1);
            //the reason for which the return has this value is to prevent having an
            // invalid
            // integer as a parameter for NaturalNumber creation.
        } else {
            int expSelector = random.nextInt(4);
            try {
                if (expSelector == 0) {
                    return new Addition(randomExpression(maxDepth - 1),
                            randomExpression(maxDepth - 1));
                } else if (expSelector == 1) {
                    return new Product(randomExpression(maxDepth - 1),
                            randomExpression(maxDepth - 1));
                } else if (expSelector == 2) {
                    return new Subtraction(randomExpression(maxDepth - 1),
                            randomExpression(maxDepth - 1));
                } else {
                    return new Division(randomExpression(maxDepth - 1),
                            randomExpression(maxDepth - 1));
                }
            } catch (InvalidNaturalNumber e) {
                System.out.println(e.toString());
                if (expSelector < 2) {
                    return new Addition(randomExpression(maxDepth - 1),
                            randomExpression(maxDepth - 1));
                } else {
                    return new Product(randomExpression(maxDepth - 1),
                            randomExpression(maxDepth - 1));
                }
                // we decided here to fix the mistake by adding either a
                // new multiplication or a new addition. We could also have returned a
                //NaturalNumber,
                // which would have been easier but less fun :)
            }
        }
    }
}
