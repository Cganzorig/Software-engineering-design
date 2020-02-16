package ic.doc.co575;

public class Subtraction extends BinaryExpression {
    public Subtraction(Expression left, Expression right) {
        super(left, right);
        if(left.evaluate() <= right.evaluate()) {
            throw new NonPositiveNumber();
        }
    }

    @Override
    public int evaluate() {
        return leftOperand.evaluate() - rightOperand.evaluate();
    }

    @Override
    public String toString(){
        return leftOperand.toString() + " - " + rightOperand.toString();
    }

}
