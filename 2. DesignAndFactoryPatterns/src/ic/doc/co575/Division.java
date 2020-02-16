package ic.doc.co575;

public class Division extends BinaryExpression {
    public Division(Expression left, Expression right) {
        super(left, right);
        if((left.evaluate() % right.evaluate() != 0)) {
            throw new NonWholeNumber();
        }
    }

    @Override
    public int evaluate() {
        return leftOperand.evaluate() / rightOperand.evaluate();
    }

    @Override
    public String toString(){
        return leftOperand.toString() + " / " + rightOperand.toString();
    }
}
