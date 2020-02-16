package ic.doc.templatemethod;

import java.util.Iterator;

public class TriangleNumbersSequence extends NumbersSequence {

    @Override
    protected int positiveTerm(int i) {

        return (i + 1) * (i + 2) / 2;
    }

}
