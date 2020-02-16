package ic.doc.co575;

interface Expression extends Comparable<Expression>{

  int evaluate();

  int depth();
}
