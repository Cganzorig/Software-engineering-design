package ic.doc.strategy;

public class TriangleNumbersTermsGenerator implements TermGenerator {

    @Override
    public int positiveTerm(int i) {
        return (i + 1) * (i + 2) / 2;
    }
}