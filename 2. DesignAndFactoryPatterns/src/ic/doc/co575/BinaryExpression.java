package ic.doc.co575;

public abstract class BinaryExpression implements Expression {
    Expression leftOperand;
    Expression rightOperand;

    public BinaryExpression(Expression left, Expression right) {
        this.leftOperand = left;
        this.rightOperand = right;
    }

    @Override
    public abstract String toString();

    @Override
    public abstract int evaluate();

    @Override
    public int depth() {
        return 1 + leftOperand.depth();
    }

    @Override
    public int compareTo(Expression other) {
        if (this.evaluate() < other.evaluate()) {
            return -1;
        } else if (this.evaluate() > other.evaluate()) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean equals(Object o) {
        if (o instanceof BinaryExpression) {
            return ((BinaryExpression) o).evaluate() == this.evaluate();
        } else {
            return false;
        }
    }

    public Expression getLeft() {
        return leftOperand;
    }

    public Expression getRight() {
        return rightOperand;
    }
}
